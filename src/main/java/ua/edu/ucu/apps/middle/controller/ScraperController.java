package ua.edu.ucu.apps.middle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.edu.ucu.apps.middle.dto.ResponseDTO;
import ua.edu.ucu.apps.middle.service.ScrapingService;
import ua.edu.ucu.apps.middle.service.ScrapingServiceImpl;

@Controller
@RequestMapping("/scraping.api")
public class ScraperController {
    private final ScrapingService scrapingService;

    @Autowired
    public ScraperController(ScrapingServiceImpl scrapingService) {
        this.scrapingService = scrapingService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/scrape")
    @ResponseBody
    public ResponseDTO scrape(@RequestParam String domain) {
        return scrapingService.scrape(domain);
    }
}
