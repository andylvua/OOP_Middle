package ua.edu.ucu.apps.middle.service;

import ua.edu.ucu.apps.middle.dto.ResponseDTO;

public interface ScrapingService {
    String FIRSTRESULT = "yuRUbf";
    String USERAGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36";

    ResponseDTO scrape(String url);
}
