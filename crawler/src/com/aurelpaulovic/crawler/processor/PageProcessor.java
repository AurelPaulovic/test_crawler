package com.aurelpaulovic.crawler.processor;

import java.util.Set;

import com.aurelpaulovic.crawler.page.Page;
import com.aurelpaulovic.crawler.page.PageUrl;
import com.aurelpaulovic.crawler.page.ProcessedPage;
import com.aurelpaulovic.crawler.store.PageStore;

public class PageProcessor {
    private PageStore store;
    private UrlExtractor urlExtractor;
    private UrlProcessor urlProcessor;
    
    public PageProcessor(PageStore store, UrlProcessor urlProcessor) {
        this.store = store;
        this.urlExtractor = new UrlExtractor();
        this.urlProcessor = urlProcessor;
    }
    
    public void processPage(Page page) {
        ProcessedPage processedPage = new ProcessedPage();
        Set<PageUrl> urls = urlExtractor.extractLinks(processedPage);
        
        urlProcessor.push(urls);
        store.storePage(processedPage);
    }
}
