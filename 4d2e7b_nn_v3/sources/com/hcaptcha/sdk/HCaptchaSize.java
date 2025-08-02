package com.hcaptcha.sdk;

import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import com.fasterxml.jackson.annotation.f0;
import java.io.Serializable;

public enum HCaptchaSize implements Serializable {
    INVISIBLE("invisible"),
    NORMAL(Constants.NORMAL),
    COMPACT("compact");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f9502a;

    private HCaptchaSize(String str) {
        this.f9502a = str;
    }

    @NonNull
    @f0
    public String toString() {
        return this.f9502a;
    }
}
