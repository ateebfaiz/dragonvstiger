package com.facebook.react.bridge;

import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

public interface UIManager extends PerformanceCounter {
    @UiThread
    @Deprecated
    <T extends View> int addRootView(T t10, WritableMap writableMap);

    void addUIManagerEventListener(UIManagerListener uIManagerListener);

    void dispatchCommand(int i10, int i11, @Nullable ReadableArray readableArray);

    void dispatchCommand(int i10, String str, @Nullable ReadableArray readableArray);

    <T> T getEventDispatcher();

    void initialize();

    void invalidate();

    void receiveEvent(int i10, int i11, String str, @Nullable WritableMap writableMap);

    @Deprecated
    void receiveEvent(int i10, String str, @Nullable WritableMap writableMap);

    void removeUIManagerEventListener(UIManagerListener uIManagerListener);

    @Deprecated
    @Nullable
    String resolveCustomDirectEventName(@Nullable String str);

    View resolveView(int i10);

    void sendAccessibilityEvent(int i10, int i11);

    @AnyThread
    <T extends View> int startSurface(T t10, String str, WritableMap writableMap, int i10, int i11);

    @AnyThread
    void stopSurface(int i10);

    @UiThread
    void synchronouslyUpdateViewOnUIThread(int i10, ReadableMap readableMap);

    @UiThread
    void updateRootLayoutSpecs(int i10, int i11, int i12, int i13, int i14);
}
