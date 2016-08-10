package com.aurelpaulovic.crawler.worker;

import java.net.URL;

import com.aurelpaulovic.crawler.page.Page;
import com.aurelpaulovic.crawler.processor.PageProcessor;

public class DownloadWorker implements Runnable {
    private final URL url;
    private final PageProcessor pageProcessor;
    private final int timeout;
    
    public DownloadWorker(URL url, PageProcessor pageProcessor, int timeout) {
        this.url = url;
        this.pageProcessor = pageProcessor;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        // TODO download Page
        
        Page page = new Page(url);
        pageProcessor.processPage(page);
    }
}
