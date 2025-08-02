package com.onesignal;

public abstract class k implements Runnable {
    public void run() {
        Thread.currentThread().setPriority(10);
    }
}
