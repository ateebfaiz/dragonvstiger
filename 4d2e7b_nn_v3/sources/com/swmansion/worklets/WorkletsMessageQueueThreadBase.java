package com.swmansion.worklets;

import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.MessageQueueThreadImpl;
import com.facebook.react.bridge.queue.MessageQueueThreadPerfStats;
import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import d6.a;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@a
public abstract class WorkletsMessageQueueThreadBase implements MessageQueueThread {

    /* renamed from: a  reason: collision with root package name */
    protected final MessageQueueThreadImpl f11696a = MessageQueueThreadImpl.create(MessageQueueThreadSpec.mainThreadSpec(), new c());

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Exception exc) {
        throw new RuntimeException(exc);
    }

    public void assertIsOnThread() {
        this.f11696a.assertIsOnThread();
    }

    public Future callOnQueue(Callable callable) {
        return this.f11696a.callOnQueue(callable);
    }

    public MessageQueueThreadPerfStats getPerfStats() {
        return this.f11696a.getPerfStats();
    }

    public boolean isOnThread() {
        return this.f11696a.isOnThread();
    }

    public void quitSynchronous() {
        try {
            Field declaredField = this.f11696a.getClass().getDeclaredField("mIsFinished");
            declaredField.setAccessible(true);
            declaredField.set(this.f11696a, Boolean.TRUE);
            declaredField.setAccessible(false);
        } catch (IllegalAccessException | NoSuchFieldException e10) {
            e10.printStackTrace();
        }
    }

    public void resetPerfStats() {
        this.f11696a.resetPerfStats();
    }

    public void assertIsOnThread(String str) {
        this.f11696a.assertIsOnThread(str);
    }
}
