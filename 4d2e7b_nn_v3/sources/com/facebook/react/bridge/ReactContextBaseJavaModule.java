package com.facebook.react.bridge;

import android.app.Activity;
import androidx.annotation.Nullable;

public abstract class ReactContextBaseJavaModule extends BaseJavaModule {
    public ReactContextBaseJavaModule() {
        super((ReactApplicationContext) null);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Activity getCurrentActivity() {
        return getReactApplicationContext().getCurrentActivity();
    }

    public ReactContextBaseJavaModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
