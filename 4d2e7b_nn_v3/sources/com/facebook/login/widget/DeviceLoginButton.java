package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.c;
import com.facebook.login.e;
import com.facebook.login.i;
import com.facebook.login.widget.LoginButton;

public class DeviceLoginButton extends LoginButton {
    private Uri Z0;

    private class b extends LoginButton.e {
        private b() {
            super();
        }

        /* access modifiers changed from: protected */
        public i a() {
            if (v5.a.d(this)) {
                return null;
            }
            try {
                c H = c.H();
                H.w(DeviceLoginButton.this.getDefaultAudience());
                H.z(e.DEVICE_AUTH);
                H.I(DeviceLoginButton.this.getDeviceRedirectUri());
                return H;
            } catch (Throwable th) {
                v5.a.b(th, this);
                return null;
            }
        }
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public Uri getDeviceRedirectUri() {
        return this.Z0;
    }

    /* access modifiers changed from: protected */
    public LoginButton.e getNewLoginClickListener() {
        return new b();
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.Z0 = uri;
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
