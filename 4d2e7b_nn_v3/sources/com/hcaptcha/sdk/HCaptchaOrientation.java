package com.hcaptcha.sdk;

import androidx.annotation.NonNull;
import com.fasterxml.jackson.annotation.f0;
import java.io.Serializable;

public enum HCaptchaOrientation implements Serializable {
    PORTRAIT("portrait"),
    LANDSCAPE("landscape");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f9497a;

    private HCaptchaOrientation(String str) {
        this.f9497a = str;
    }

    @NonNull
    @f0
    public String toString() {
        return this.f9497a;
    }
}
