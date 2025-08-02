package com.google.firebase.analytics;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class a extends ThreadPoolExecutor {
    a(FirebaseAnalytics firebaseAnalytics, int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(0, 1, 30, timeUnit, blockingQueue);
    }
}
