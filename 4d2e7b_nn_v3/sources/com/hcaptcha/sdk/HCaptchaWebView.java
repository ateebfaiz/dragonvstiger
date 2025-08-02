package com.hcaptcha.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HCaptchaWebView extends WebView {
    public HCaptchaWebView(Context context) {
        super(context);
    }

    public boolean a() {
        if (getParent() == null) {
            return true;
        }
        return false;
    }

    public boolean onCheckIsTextEditor() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return super.onCheckIsTextEditor();
        }
        return false;
    }

    public boolean performClick() {
        return false;
    }

    public HCaptchaWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HCaptchaWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
