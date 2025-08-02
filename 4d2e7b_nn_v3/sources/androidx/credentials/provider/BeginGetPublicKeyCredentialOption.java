package androidx.credentials.provider;

import android.os.Bundle;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.provider.utils.RequestValidationUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class BeginGetPublicKeyCredentialOption extends BeginGetCredentialOption {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final byte[] clientDataHash;
    private final String requestJson;

    public static final class Companion {
        private Companion() {
        }

        public final BeginGetPublicKeyCredentialOption createFrom$credentials_release(Bundle bundle, String str) {
            m.f(bundle, "data");
            m.f(str, "id");
            try {
                String string = bundle.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                byte[] byteArray = bundle.getByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH");
                m.c(string);
                return new BeginGetPublicKeyCredentialOption(bundle, str, string, byteArray);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final BeginGetPublicKeyCredentialOption createFromEntrySlice$credentials_release(Bundle bundle, String str) {
            m.f(bundle, "data");
            m.f(str, "id");
            return new BeginGetPublicKeyCredentialOption(bundle, str, "{\"dummy_key\":\"dummy_value\"}", (byte[]) null, 8, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BeginGetPublicKeyCredentialOption(Bundle bundle, String str, String str2) {
        this(bundle, str, str2, (byte[]) null, 8, (DefaultConstructorMarker) null);
        m.f(bundle, "candidateQueryData");
        m.f(str, "id");
        m.f(str2, "requestJson");
    }

    public static final BeginGetPublicKeyCredentialOption createFrom$credentials_release(Bundle bundle, String str) {
        return Companion.createFrom$credentials_release(bundle, str);
    }

    public static final BeginGetPublicKeyCredentialOption createFromEntrySlice$credentials_release(Bundle bundle, String str) {
        return Companion.createFromEntrySlice$credentials_release(bundle, str);
    }

    public final byte[] getClientDataHash() {
        return this.clientDataHash;
    }

    public final String getRequestJson() {
        return this.requestJson;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeginGetPublicKeyCredentialOption(Bundle bundle, String str, String str2, byte[] bArr, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle, str, str2, (i10 & 8) != 0 ? null : bArr);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BeginGetPublicKeyCredentialOption(Bundle bundle, String str, String str2, byte[] bArr) {
        super(str, PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, bundle);
        m.f(bundle, "candidateQueryData");
        m.f(str, "id");
        m.f(str2, "requestJson");
        this.requestJson = str2;
        this.clientDataHash = bArr;
        if (!RequestValidationUtil.Companion.isValidJSON(str2)) {
            throw new IllegalArgumentException("requestJson must not be empty, and must be a valid JSON".toString());
        }
    }
}
