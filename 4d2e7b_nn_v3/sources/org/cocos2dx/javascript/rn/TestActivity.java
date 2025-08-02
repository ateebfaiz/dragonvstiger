package org.cocos2dx.javascript.rn;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import e9.b;
import e9.h;
import org.cocos2dx.javascript.PlatformUtils;

public class TestActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        h B = h.e0(this).B(b.FLAG_SHOW_BAR).B(b.FLAG_HIDE_NAVIGATION_BAR);
        boolean z10 = true;
        if (PlatformUtils.getStatusBarState() != 1) {
            z10 = false;
        }
        B.Z(z10).C();
        new Handler().post(new h(this));
    }
}
