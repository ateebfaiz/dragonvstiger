package com.facebook.react.uimanager;

import android.os.Bundle;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicInteger;

public interface r0 {
    void b(int i10);

    void d();

    Bundle getAppProperties();

    int getHeightMeasureSpec();

    String getJSModuleName();

    ViewGroup getRootViewGroup();

    int getRootViewTag();

    AtomicInteger getState();

    String getSurfaceID();

    int getUIManagerType();

    int getWidthMeasureSpec();

    void setRootViewTag(int i10);

    void setShouldLogContentAppeared(boolean z10);
}
