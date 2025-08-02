package com.facebook.react.fabric;

import d6.a;

@a
public interface ReactNativeConfig {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final ReactNativeConfig DEFAULT_CONFIG = new EmptyReactNativeConfig();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @a
    boolean getBool(String str);

    @a
    double getDouble(String str);

    @a
    long getInt64(String str);

    @a
    String getString(String str);
}
