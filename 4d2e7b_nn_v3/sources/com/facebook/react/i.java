package com.facebook.react;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.bridge.MemoryPressureListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class i implements ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList f20808a = new CopyOnWriteArrayList();

    public i(Context context) {
        context.getApplicationContext().registerComponentCallbacks(this);
    }

    private void c(int i10) {
        Iterator it = this.f20808a.iterator();
        while (it.hasNext()) {
            ((MemoryPressureListener) it.next()).handleMemoryPressure(i10);
        }
    }

    public void a(MemoryPressureListener memoryPressureListener) {
        if (!this.f20808a.contains(memoryPressureListener)) {
            this.f20808a.add(memoryPressureListener);
        }
    }

    public void b(Context context) {
        context.getApplicationContext().unregisterComponentCallbacks(this);
    }

    public void d(MemoryPressureListener memoryPressureListener) {
        this.f20808a.remove(memoryPressureListener);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i10) {
        c(i10);
    }
}
