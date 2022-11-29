package ua.edu.ucu.apps.middle.utils;

public class GoogleQuery {
    private static final String SEARCH_URL = "https://www.google.com/search?q=";
    public static String getQueryUrl(String query) {
        return SEARCH_URL + query;
    }
}
