package com.hcaptcha.sdk;

import androidx.annotation.NonNull;
import com.fasterxml.jackson.annotation.f0;
import java.io.Serializable;

public enum HCaptchaTheme implements Serializable {
    DARK("dark"),
    LIGHT("light"),
    CONTRAST("contrast");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f9507a;

    private HCaptchaTheme(String str) {
        this.f9507a = str;
    }

    @NonNull
    @f0
    public String toString() {
        return this.f9507a;
    }
}
