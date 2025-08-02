package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Collection;

public interface w0 {
    ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str);

    Collection getViewManagerNames(ReactApplicationContext reactApplicationContext);
}
