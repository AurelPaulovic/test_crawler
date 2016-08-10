package com.aurelpaulovic.crawler.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.aurelpaulovic.crawler.processor.PageProcessor;
import com.aurelpaulovic.crawler.queue.Job;
import com.aurelpaulovic.crawler.queue.JobQueue;

public class DownloadWorkerPool implements Runnable {
    private JobQueue jobQueue;
    private PageProcessor pageProcessor;
    private int workerTimeout;
    private int curtesyDelay; 
    
    private ExecutorService executor;
    
    public DownloadWorkerPool(JobQueue jobQueue, PageProcessor pageProcessor, int workerNum, int timeout, int curtesyDelay) {
        this.jobQueue = jobQueue;
        this.pageProcessor = pageProcessor;
        this.workerTimeout = timeout;
        this.curtesyDelay = curtesyDelay;
        
        this.executor = Executors.newFixedThreadPool(workerNum);
    }
    
    @Override
    public void run() {
      for (;;) {
          Job job = jobQueue.getJob();
          executor.execute(new DownloadWorker(job.getUrl(), pageProcessor, workerTimeout));
      }
    }
}
