package com.hcaptcha.sdk;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

abstract class b {
    public static Parcelable a(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (Parcelable) bundle.getParcelable(str, cls);
        }
        return bundle.getParcelable(str);
    }

    public static Serializable b(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 33) {
            return bundle.getSerializable(str, cls);
        }
        return bundle.getSerializable(str);
    }
}
