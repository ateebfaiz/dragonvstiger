package androidx.credentials.provider;

import android.os.Bundle;
import kotlin.jvm.internal.m;

public class BeginCreateCustomCredentialRequest extends BeginCreateCredentialRequest {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BeginCreateCustomCredentialRequest(String str, Bundle bundle, CallingAppInfo callingAppInfo) {
        super(str, bundle, callingAppInfo);
        m.f(str, "type");
        m.f(bundle, "candidateQueryData");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("type should not be empty".toString());
        }
    }
}
