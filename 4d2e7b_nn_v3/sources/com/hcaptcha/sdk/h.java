package com.hcaptcha.sdk;

import java.io.Serializable;

public enum h implements Serializable {
    NETWORK_ERROR(7, "No internet connection"),
    INVALID_DATA(8, "Invalid data is not accepted by endpoints"),
    CHALLENGE_ERROR(9, "Challenge encountered error on setup"),
    INTERNAL_ERROR(10, "hCaptcha client encountered an internal error"),
    SESSION_TIMEOUT(15, "Session Timeout"),
    TOKEN_TIMEOUT(16, "Token Timeout"),
    CHALLENGE_CLOSED(30, "Challenge Closed"),
    RATE_LIMITED(31, "Rate Limited"),
    INVALID_CUSTOM_THEME(32, "Invalid custom theme"),
    INSECURE_HTTP_REQUEST_ERROR(33, "Insecure resource requested"),
    ERROR(29, "Unknown error");
    

    /* renamed from: a  reason: collision with root package name */
    private final int f9538a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9539b;

    private h(int i10, String str) {
        this.f9538a = i10;
        this.f9539b = str;
    }

    public static h b(int i10) {
        for (h hVar : values()) {
            if (hVar.f9538a == i10) {
                return hVar;
            }
        }
        throw new RuntimeException("Unsupported error id: " + i10);
    }

    public int c() {
        return this.f9538a;
    }

    public String d() {
        return this.f9539b;
    }

    public String toString() {
        return this.f9539b;
    }
}
