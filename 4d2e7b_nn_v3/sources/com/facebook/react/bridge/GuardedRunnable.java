package com.facebook.react.bridge;

public abstract class GuardedRunnable implements Runnable {
    private final JSExceptionHandler mExceptionHandler;

    public GuardedRunnable(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    public final void run() {
        try {
            runGuarded();
        } catch (RuntimeException e10) {
            this.mExceptionHandler.handleException(e10);
        }
    }

    public abstract void runGuarded();

    public GuardedRunnable(JSExceptionHandler jSExceptionHandler) {
        this.mExceptionHandler = jSExceptionHandler;
    }
}
