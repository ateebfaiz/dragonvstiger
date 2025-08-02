package com.adjust.sdk;

public enum BackoffStrategy {
    LONG_WAIT(1, 120000, 86400000, 0.5d, 1.0d),
    SHORT_WAIT(1, 200, 3600000, 0.5d, 1.0d),
    TEST_WAIT(1, 200, 1000, 0.5d, 1.0d),
    NO_WAIT(100, 1, 1000, 1.0d, 1.0d);
    
    public double maxRange;
    public long maxWait;
    public long milliSecondMultiplier;
    public double minRange;
    public int minRetries;

    private BackoffStrategy(int i10, long j10, long j11, double d10, double d11) {
        this.minRetries = i10;
        this.milliSecondMultiplier = j10;
        this.maxWait = j11;
        this.minRange = d10;
        this.maxRange = d11;
    }
}
