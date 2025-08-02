package androidx.credentials;

import kotlin.jvm.internal.m;

public final class GetCredentialResponse {
    private final Credential credential;

    public GetCredentialResponse(Credential credential2) {
        m.f(credential2, "credential");
        this.credential = credential2;
    }

    public final Credential getCredential() {
        return this.credential;
    }
}
