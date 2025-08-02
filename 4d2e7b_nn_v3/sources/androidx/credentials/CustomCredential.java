package androidx.credentials;

import android.os.Bundle;
import kotlin.jvm.internal.m;

public class CustomCredential extends Credential {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomCredential(String str, Bundle bundle) {
        super(str, bundle);
        m.f(str, "type");
        m.f(bundle, "data");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("type should not be empty".toString());
        }
    }
}
