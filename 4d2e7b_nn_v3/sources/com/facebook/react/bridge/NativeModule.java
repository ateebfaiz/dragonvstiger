package com.facebook.react.bridge;

import d6.a;

@a
public interface NativeModule {
    boolean canOverrideExistingModule();

    String getName();

    void initialize();

    void invalidate();

    @Deprecated(forRemoval = true, since = "Use invalidate method instead")
    void onCatalystInstanceDestroy();
}
