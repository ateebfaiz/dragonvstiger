package com.sensorsdata.analytics.android.sdk.core.eventbus;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SAEventBus {
    private static SAEventBus sSAEventBus;
    private final Map<String, CopyOnWriteArrayList<Subscription>> mSubscriberMap = new ConcurrentHashMap();

    private boolean checkType(Subscription subscription, Object obj) {
        try {
            subscription.getClass().getDeclaredMethod("notify", new Class[]{obj.getClass()});
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static SAEventBus getInstance() {
        if (sSAEventBus == null) {
            synchronized (SAEventBus.class) {
                try {
                    if (sSAEventBus == null) {
                        sSAEventBus = new SAEventBus();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sSAEventBus;
    }

    public void clear() {
        this.mSubscriberMap.clear();
    }

    public void post(String str, Object obj) {
        if (this.mSubscriberMap.containsKey(str)) {
            Iterator it = this.mSubscriberMap.get(str).iterator();
            while (it.hasNext()) {
                Subscription subscription = (Subscription) it.next();
                if (checkType(subscription, obj)) {
                    subscription.notify(obj);
                }
            }
        }
    }

    public void register(String str, Subscription subscription) {
        if (subscription != null) {
            subscription.eventTag = str;
            if (this.mSubscriberMap.containsKey(str)) {
                this.mSubscriberMap.get(str).add(subscription);
                return;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(subscription);
            this.mSubscriberMap.put(str, copyOnWriteArrayList);
        }
    }

    public void unRegister(Subscription subscription) {
        if (subscription != null && this.mSubscriberMap.containsKey(subscription.eventTag)) {
            this.mSubscriberMap.get(subscription.eventTag).remove(subscription);
        }
    }
}
