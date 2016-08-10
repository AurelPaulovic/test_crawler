package com.aurelpaulovic.crawler.page;

import java.net.URL;

public class PageUrl {
    private final URL url;
    private final String title;
    
    public PageUrl(URL url, String title) {
        this.url = url;
        this.title = title;
    }

    public URL getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
