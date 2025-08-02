package androidx.credentials.provider;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.provider.utils.RequestValidationUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class BeginCreatePublicKeyCredentialRequest extends BeginCreateCredentialRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final byte[] clientDataHash;
    private final String requestJson;

    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public final BeginCreatePublicKeyCredentialRequest createForTest(Bundle bundle, CallingAppInfo callingAppInfo) {
            m.f(bundle, "data");
            return createFrom$credentials_release(bundle, callingAppInfo);
        }

        public final BeginCreatePublicKeyCredentialRequest createFrom$credentials_release(Bundle bundle, CallingAppInfo callingAppInfo) {
            m.f(bundle, "data");
            try {
                String string = bundle.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                byte[] byteArray = bundle.getByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH");
                m.c(string);
                return new BeginCreatePublicKeyCredentialRequest(string, callingAppInfo, bundle, byteArray);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BeginCreatePublicKeyCredentialRequest(String str, CallingAppInfo callingAppInfo, Bundle bundle) {
        this(str, callingAppInfo, bundle, (byte[]) null, 8, (DefaultConstructorMarker) null);
        m.f(str, "requestJson");
        m.f(bundle, "candidateQueryData");
    }

    @VisibleForTesting
    public static final BeginCreatePublicKeyCredentialRequest createForTest(Bundle bundle, CallingAppInfo callingAppInfo) {
        return Companion.createForTest(bundle, callingAppInfo);
    }

    private final void initiateBundle(Bundle bundle, String str) {
        bundle.putString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON", str);
    }

    public final byte[] getClientDataHash() {
        return this.clientDataHash;
    }

    public final String getRequestJson() {
        return this.requestJson;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeginCreatePublicKeyCredentialRequest(String str, CallingAppInfo callingAppInfo, Bundle bundle, byte[] bArr, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, callingAppInfo, bundle, (i10 & 8) != 0 ? null : bArr);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BeginCreatePublicKeyCredentialRequest(String str, CallingAppInfo callingAppInfo, Bundle bundle, byte[] bArr) {
        super(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, bundle, callingAppInfo);
        m.f(str, "requestJson");
        m.f(bundle, "candidateQueryData");
        this.requestJson = str;
        this.clientDataHash = bArr;
        if (RequestValidationUtil.Companion.isValidJSON(str)) {
            initiateBundle(bundle, str);
            return;
        }
        throw new IllegalArgumentException("requestJson must not be empty, and must be a valid JSON".toString());
    }
}
