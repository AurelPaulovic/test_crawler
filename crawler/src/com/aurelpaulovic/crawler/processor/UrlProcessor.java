package com.aurelpaulovic.crawler.processor;

import java.util.Set;

import com.aurelpaulovic.crawler.page.PageUrl;
import com.aurelpaulovic.crawler.queue.Job;
import com.aurelpaulovic.crawler.queue.JobQueue;
import com.aurelpaulovic.crawler.store.UrlStore;

public class UrlProcessor {
    private UrlStore store;
    private JobQueue jobQueue;
    
    public UrlProcessor(UrlStore store, JobQueue jobQueue) {
        this.store = store;
    }

    public void push(Set<PageUrl> urls) {
       for (PageUrl url : urls) {
           // normalize, transform, etc.
           if (isUnique(url)) {
               store.add(url);
               
               Job job = createJobFromUrl(url);
               jobQueue.submitJob(job);
           }
       }        
    }

    private boolean isUnique(PageUrl url) {
        // check store
        return store.contains(url);
    }
    
    private Job createJobFromUrl(PageUrl url) {
        return new Job(url.getUrl(), 10);
    }
}
