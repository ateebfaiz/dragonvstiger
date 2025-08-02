package com.onesignal;

import android.content.Context;
import android.webkit.WebView;

public class OSWebView extends WebView {
    public OSWebView(Context context) {
        super(context);
    }

    public void computeScroll() {
    }

    public boolean overScrollBy(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        return false;
    }

    public void scrollTo(int i10, int i11) {
    }
}
