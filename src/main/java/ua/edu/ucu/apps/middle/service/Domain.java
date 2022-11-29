package ua.edu.ucu.apps.middle.service;

import org.apache.commons.lang3.StringUtils;

public record Domain(String domainUrl) {
    public Domain {
        if (StringUtils.isBlank(domainUrl)) {
            throw new IllegalArgumentException("Missing domain url");
        }
        if (!domainUrl.startsWith("https://")) {
            domainUrl = "https://" + domainUrl;
        }
        if (!domainUrl.endsWith("/")) {
            domainUrl = domainUrl + "/";
        }
    }
}
