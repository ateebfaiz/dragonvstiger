package androidx.credentials.provider;

import androidx.credentials.CreateCredentialRequest;
import kotlin.jvm.internal.m;

public final class ProviderCreateCredentialRequest {
    private final CallingAppInfo callingAppInfo;
    private final CreateCredentialRequest callingRequest;

    public ProviderCreateCredentialRequest(CreateCredentialRequest createCredentialRequest, CallingAppInfo callingAppInfo2) {
        m.f(createCredentialRequest, "callingRequest");
        m.f(callingAppInfo2, "callingAppInfo");
        this.callingRequest = createCredentialRequest;
        this.callingAppInfo = callingAppInfo2;
    }

    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }

    public final CreateCredentialRequest getCallingRequest() {
        return this.callingRequest;
    }
}
