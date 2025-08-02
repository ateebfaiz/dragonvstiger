package com.google.firebase.concurrent;

import java.util.concurrent.Executor;

public class FirebaseExecutors {

    private enum a implements Executor {
        INSTANCE;

        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private FirebaseExecutors() {
    }

    public static Executor directExecutor() {
        return a.INSTANCE;
    }

    public static Executor newSequentialExecutor(Executor executor) {
        return new z(executor);
    }
}
