package com.bugsnag.android;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.m0;
import java.util.Collections;
import java.util.List;

public class t implements m0 {
    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new BugsnagReactNative(reactApplicationContext));
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
