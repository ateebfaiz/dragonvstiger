package com.bumptech.glide.manager;

import android.app.Activity;
import androidx.annotation.RequiresApi;

@RequiresApi(26)
final class FirstFrameWaiter implements FrameWaiter {
    FirstFrameWaiter() {
    }

    public void registerSelf(Activity activity) {
    }
}
