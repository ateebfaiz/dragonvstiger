package com.facebook.react.modules.appregistry;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;

public interface AppRegistry extends JavaScriptModule {
    void runApplication(String str, WritableMap writableMap);

    void startHeadlessTask(int i10, String str, WritableMap writableMap);

    void unmountApplicationComponentAtRootTag(int i10);
}
