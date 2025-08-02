package com.hcaptcha.sdk;

import android.os.Parcel;
import android.os.Parcelable;

abstract class HCaptchaStateListener implements Parcelable {
    public abstract void a(i iVar);

    public abstract void b();

    public abstract void c(String str);

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
    }
}
