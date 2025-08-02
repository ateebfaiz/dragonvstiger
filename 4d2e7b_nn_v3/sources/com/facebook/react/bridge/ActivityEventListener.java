package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;

public interface ActivityEventListener {
    void onActivityResult(Activity activity, int i10, int i11, @Nullable Intent intent);

    void onNewIntent(Intent intent);
}
