package com.aurelpaulovic.crawler.queue;

import java.net.URL;
import java.util.Comparator;

public class Job {
    private final URL url;
    private final int priority;
    private final long creationTime;    
    
    public Job(URL url, int priority) {
        this.url = url;
        this.priority = priority;
        this.creationTime = System.nanoTime();
    }

    public URL getUrl() {
        return url;
    }

    public int getPriority() {
        return priority;
    }
    
    public long getCreationTime() {
        return creationTime;
    }

    public static class PriorityComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            if (o1.priority < o2.priority) {
                return -1;
            } else if (o1.priority > o2.priority) {
                return 1;
            } else {
                if (o1.creationTime < o2.creationTime) {
                    return -1;
                } else if (o1.creationTime == o2.creationTime) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
