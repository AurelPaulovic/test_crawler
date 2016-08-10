package com.aurelpaulovic.crawler;

import java.net.URI;

import com.aurelpaulovic.crawler.processor.PageProcessor;
import com.aurelpaulovic.crawler.processor.UrlProcessor;
import com.aurelpaulovic.crawler.queue.JobQueue;
import com.aurelpaulovic.crawler.store.PageStore;
import com.aurelpaulovic.crawler.store.UrlStore;
import com.aurelpaulovic.crawler.worker.DownloadWorkerPool;

public class Crawler {
    private static final int WORKER_NUM = 10;
    private static final int TIMEOUT = 60;
    private static final int CURTESY_DELAY = 15;
    
    public static void main(String[] args) {
        JobQueue jobQueue = new JobQueue(URI.create("localhost"));
        PageStore pageStore = new PageStore();
        UrlStore urlStore = new UrlStore();
        UrlProcessor urlProcessor = new UrlProcessor(urlStore, jobQueue);
        PageProcessor pageProcessor = new PageProcessor(pageStore, urlProcessor);
        DownloadWorkerPool downloadWorkerPool = new DownloadWorkerPool(jobQueue, pageProcessor, WORKER_NUM, TIMEOUT, CURTESY_DELAY);
        
        downloadWorkerPool.run();
    }
}
