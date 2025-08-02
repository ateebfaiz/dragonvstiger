package com.facebook.react.fabric;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class LongStreamingStats {
    private int len = 0;
    private long max = 0;
    private final Queue<Long> maxHeap = new PriorityQueue(11, new g());
    private final Queue<Long> minHeap = new PriorityQueue(11, Comparator.comparingLong(new f()));
    private double streamingAverage = 0.0d;

    LongStreamingStats() {
    }

    public void add(long j10) {
        if (j10 != 0) {
            if (this.minHeap.size() == this.maxHeap.size()) {
                this.maxHeap.offer(Long.valueOf(j10));
                this.minHeap.offer(this.maxHeap.poll());
            } else {
                this.minHeap.offer(Long.valueOf(j10));
                this.maxHeap.offer(this.minHeap.poll());
            }
        }
        int i10 = this.len;
        int i11 = i10 + 1;
        this.len = i11;
        if (i11 == 1) {
            this.streamingAverage = (double) j10;
        } else {
            this.streamingAverage = (this.streamingAverage / ((double) (i11 / i10))) + ((double) (j10 / ((long) i11)));
        }
        long j11 = this.max;
        if (j10 <= j11) {
            j10 = j11;
        }
        this.max = j10;
    }

    public double getAverage() {
        return this.streamingAverage;
    }

    public long getMax() {
        return this.max;
    }

    public double getMedian() {
        long j10;
        if (this.minHeap.size() == 0 && this.maxHeap.size() == 0) {
            return 0.0d;
        }
        if (this.minHeap.size() > this.maxHeap.size()) {
            j10 = this.minHeap.peek().longValue();
        } else {
            j10 = (this.minHeap.peek().longValue() + this.maxHeap.peek().longValue()) / 2;
        }
        return (double) j10;
    }
}
