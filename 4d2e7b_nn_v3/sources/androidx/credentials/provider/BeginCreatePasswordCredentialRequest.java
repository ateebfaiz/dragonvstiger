package androidx.credentials.provider;

import android.os.Bundle;
import androidx.credentials.PasswordCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class BeginCreatePasswordCredentialRequest extends BeginCreateCredentialRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public final BeginCreatePasswordCredentialRequest createFrom$credentials_release(Bundle bundle, CallingAppInfo callingAppInfo) {
            m.f(bundle, "data");
            try {
                return new BeginCreatePasswordCredentialRequest(callingAppInfo, bundle);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BeginCreatePasswordCredentialRequest(CallingAppInfo callingAppInfo, Bundle bundle) {
        super(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, bundle, callingAppInfo);
        m.f(bundle, "candidateQueryData");
    }

    public static final BeginCreatePasswordCredentialRequest createFrom$credentials_release(Bundle bundle, CallingAppInfo callingAppInfo) {
        return Companion.createFrom$credentials_release(bundle, callingAppInfo);
    }
}
