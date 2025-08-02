package com.bumptech.glide.manager;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(26)
final class FirstFrameAndAfterTrimMemoryWaiter implements FrameWaiter, ComponentCallbacks2 {
    FirstFrameAndAfterTrimMemoryWaiter() {
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
    }

    public void onLowMemory() {
        onTrimMemory(20);
    }

    public void onTrimMemory(int i10) {
    }

    public void registerSelf(Activity activity) {
    }
}
