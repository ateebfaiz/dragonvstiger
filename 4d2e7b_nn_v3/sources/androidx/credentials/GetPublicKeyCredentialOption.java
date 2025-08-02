package androidx.credentials;

import android.content.ComponentName;
import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.internal.RequestValidationHelper;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class GetPublicKeyCredentialOption extends CredentialOption {
    public static final String BUNDLE_KEY_CLIENT_DATA_HASH = "androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH";
    public static final String BUNDLE_KEY_REQUEST_JSON = "androidx.credentials.BUNDLE_KEY_REQUEST_JSON";
    public static final String BUNDLE_VALUE_SUBTYPE_GET_PUBLIC_KEY_CREDENTIAL_OPTION = "androidx.credentials.BUNDLE_VALUE_SUBTYPE_GET_PUBLIC_KEY_CREDENTIAL_OPTION";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final byte[] clientDataHash;
    private final String requestJson;

    public static final class Companion {
        private Companion() {
        }

        public final GetPublicKeyCredentialOption createFrom$credentials_release(Bundle bundle, Set<ComponentName> set, Bundle bundle2) {
            m.f(bundle, "data");
            m.f(set, "allowedProviders");
            m.f(bundle2, "candidateQueryData");
            try {
                String string = bundle.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                byte[] byteArray = bundle.getByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH");
                m.c(string);
                return new GetPublicKeyCredentialOption(string, byteArray, set, bundle, bundle2, (DefaultConstructorMarker) null);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final Bundle toRequestDataBundle$credentials_release(String str, byte[] bArr) {
            m.f(str, "requestJson");
            Bundle bundle = new Bundle();
            bundle.putString(PublicKeyCredential.BUNDLE_KEY_SUBTYPE, GetPublicKeyCredentialOption.BUNDLE_VALUE_SUBTYPE_GET_PUBLIC_KEY_CREDENTIAL_OPTION);
            bundle.putString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON", str);
            bundle.putByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH", bArr);
            return bundle;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetPublicKeyCredentialOption(String str) {
        this(str, (byte[]) null, (Set) null, 6, (DefaultConstructorMarker) null);
        m.f(str, "requestJson");
    }

    public static final GetPublicKeyCredentialOption createFrom$credentials_release(Bundle bundle, Set<ComponentName> set, Bundle bundle2) {
        return Companion.createFrom$credentials_release(bundle, set, bundle2);
    }

    public static final Bundle toRequestDataBundle$credentials_release(String str, byte[] bArr) {
        return Companion.toRequestDataBundle$credentials_release(str, bArr);
    }

    public final byte[] getClientDataHash() {
        return this.clientDataHash;
    }

    public final String getRequestJson() {
        return this.requestJson;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetPublicKeyCredentialOption(String str, byte[] bArr) {
        this(str, bArr, (Set) null, 4, (DefaultConstructorMarker) null);
        m.f(str, "requestJson");
    }

    public /* synthetic */ GetPublicKeyCredentialOption(String str, byte[] bArr, Set set, Bundle bundle, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bArr, (Set<ComponentName>) set, bundle, bundle2);
    }

    private GetPublicKeyCredentialOption(String str, byte[] bArr, Set<ComponentName> set, Bundle bundle, Bundle bundle2) {
        super(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, bundle, bundle2, false, true, set);
        this.requestJson = str;
        this.clientDataHash = bArr;
        if (!RequestValidationHelper.Companion.isValidJSON(str)) {
            throw new IllegalArgumentException("requestJson must not be empty, and must be a valid JSON".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPublicKeyCredentialOption(String str, byte[] bArr, Set set, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : bArr, (i10 & 4) != 0 ? r0.d() : set);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GetPublicKeyCredentialOption(java.lang.String r8, byte[] r9, java.util.Set<android.content.ComponentName> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "requestJson"
            kotlin.jvm.internal.m.f(r8, r0)
            java.lang.String r0 = "allowedProviders"
            kotlin.jvm.internal.m.f(r10, r0)
            androidx.credentials.GetPublicKeyCredentialOption$Companion r0 = Companion
            android.os.Bundle r5 = r0.toRequestDataBundle$credentials_release(r8, r9)
            android.os.Bundle r6 = r0.toRequestDataBundle$credentials_release(r8, r9)
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r1.<init>((java.lang.String) r2, (byte[]) r3, (java.util.Set<android.content.ComponentName>) r4, (android.os.Bundle) r5, (android.os.Bundle) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.GetPublicKeyCredentialOption.<init>(java.lang.String, byte[], java.util.Set):void");
    }
}
