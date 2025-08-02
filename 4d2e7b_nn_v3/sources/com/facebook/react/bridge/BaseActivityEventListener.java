package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;

public class BaseActivityEventListener implements ActivityEventListener {
    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onActivityResult(Activity activity, int i10, int i11, @Nullable Intent intent) {
    }
}
