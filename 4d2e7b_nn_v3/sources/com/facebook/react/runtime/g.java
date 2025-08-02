package com.facebook.react.runtime;

import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.s0;
import java.util.List;

public interface g {
    JSRuntimeFactory a();

    ReactNativeConfig b();

    List c();

    void d(Exception exc);

    JSBundleLoader e();

    s0.a f();

    String g();

    BindingsInstaller getBindingsInstaller();
}
