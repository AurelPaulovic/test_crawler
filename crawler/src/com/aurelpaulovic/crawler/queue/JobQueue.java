package com.aurelpaulovic.crawler.queue;

import java.net.URI;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobQueue {
    private final Queue<Job> queue = new PriorityQueue<Job>();
    
    public JobQueue(URI queue) {
        // find and connect to remote queue
    }
    
    public void submitJob(Job job) {
        queue.add(job);
    }
    
    public Job getJob() {
        return queue.poll();
    }
}
