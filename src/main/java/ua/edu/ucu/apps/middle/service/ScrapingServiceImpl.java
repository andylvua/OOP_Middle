package ua.edu.ucu.apps.middle.service;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import ua.edu.ucu.apps.middle.dto.Response;
import ua.edu.ucu.apps.middle.dto.ResponseDTO;
import ua.edu.ucu.apps.middle.dto.ResponseError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.edu.ucu.apps.middle.utils.GoogleQuery.getQueryUrl;

@Service
public class ScrapingServiceImpl implements ScrapingService {
    @SneakyThrows
    public Document officialPageDocument(String domain) {
        return Jsoup.connect(domain).get();
    }

    @SneakyThrows
    public Document wikiPageDocument(String domain) {
        String googleQuery = getQueryUrl("site:en.wikipedia.org " + domain);
        Document googlePage = Jsoup.connect(googleQuery).userAgent(USERAGENT).get();

        String wikiUrl = googlePage.select("div." + FIRSTRESULT).select("a").attr("href");
        System.out.println(wikiUrl);
        return Jsoup.connect(wikiUrl).get();
    }

    @SneakyThrows
    public String getTwitterUrl(String domain) {
        String GoogleQuery = getQueryUrl("site:twitter.com " + domain);

        Document googlePage = Jsoup.connect(GoogleQuery).userAgent(USERAGENT).get();

        return googlePage.select("div." + FIRSTRESULT).select("a").attr("href");
    }

    @SneakyThrows
    public String getFacebookUrl(String domain) {
        String GoogleQuery = getQueryUrl("site:facebook.com " + domain);

        Document googlePage = Jsoup.connect(GoogleQuery).userAgent(USERAGENT).get();

        return googlePage.select("div." + FIRSTRESULT).select("a").attr("href");
    }

    public String getCompanyName(Document wikiPage) {
        return wikiPage.select("h1").text();
    }

    @SneakyThrows
    public String getLogoUrl(String companyName) {
        String GoogleQuery = getQueryUrl(companyName + " logo png");

        Document googlePage = Jsoup.connect(GoogleQuery).userAgent(USERAGENT).get();

        return googlePage.select("div." + FIRSTRESULT).select("a").attr("href");
    }

    public String getIconUrl(Document document, String domain) {
        String icon = document.select("link[rel=icon]").attr("href");

        if (StringUtils.isBlank(icon)) {
            icon = document.select("link[rel=apple-touch-icon]").attr("href");
        }

        if (StringUtils.isBlank(icon)) {
            icon = "No icon found";
            return icon;
        }

        if (!icon.startsWith("http")) {
            domain = StringUtils.chop(domain);
            icon = domain + icon;
        }
        return icon;
    }

    public String getNumberOfEmployees(Document wikiPage) {
        Element infobox = wikiPage.select("table.infobox").first();

        if (infobox == null) {
            return "Not found";
        }

        Element employees = infobox.select("th:contains(employees)").first();

        if (employees == null) {
            return "Not found";
        }

        Element employeesValue = employees.nextElementSibling();

        if (employeesValue == null) {
            return "Not found";
        }

        String employeesValueText = employeesValue.text();

        if (StringUtils.isBlank(employeesValueText)) {
            return "Not found";
        } else {
            Pattern pattern = Pattern.compile("\\d+,?\\d*");
            Matcher matcher = pattern.matcher(employeesValueText);

            if (matcher.find()) {
                return matcher.group(0);
            } else {
                return "Not found";
            }
        }
    }

    public String getCompanyAddress(Document wikiPage) {
        Element infobox = wikiPage.select("table.infobox").first();

        if (infobox == null) {
            return "Not found";
        }

        Element address = infobox.select("th:contains(Headquarters)").first();

        if (address == null) {
            return "Not found";
        }

        Element addressValue = address.nextElementSibling();

        if (addressValue == null) {
            return "Not found";
        }

        String addressValueText = addressValue.text();

        if (StringUtils.isBlank(addressValueText)) {
            return "Not found";
        } else {
            return addressValueText;
        }
    }

    @Override
    public ResponseDTO scrape(String domain) {
        try {
            domain = new Domain(domain).domainUrl();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return new ResponseError(e.getMessage());
        }

        try {
            Document document = officialPageDocument(domain);
            Document wikiPage = wikiPageDocument(domain);
            String companyName = getCompanyName(wikiPage);

            Response response = Response.builder()
                    .companyName(companyName)
                    .twitterUrl(getTwitterUrl(domain))
                    .facebookUrl(getFacebookUrl(domain))
                    .companyLogo(getLogoUrl(companyName))
                    .companyIcon(getIconUrl(document, domain))
                    .numberOfEmployees(getNumberOfEmployees(wikiPage))
                    .companyAddress(getCompanyAddress(wikiPage))
                    .build();

            System.out.println(response);

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseError("Error while scraping");
        }
    }
}
