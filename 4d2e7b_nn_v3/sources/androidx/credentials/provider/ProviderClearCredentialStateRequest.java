package androidx.credentials.provider;

import kotlin.jvm.internal.m;

public final class ProviderClearCredentialStateRequest {
    private final CallingAppInfo callingAppInfo;

    public ProviderClearCredentialStateRequest(CallingAppInfo callingAppInfo2) {
        m.f(callingAppInfo2, "callingAppInfo");
        this.callingAppInfo = callingAppInfo2;
    }

    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }
}
