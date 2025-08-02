package androidx.credentials;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.internal.RequestValidationHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class CreatePublicKeyCredentialRequest extends CreateCredentialRequest {
    public static final String BUNDLE_KEY_CLIENT_DATA_HASH = "androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH";
    public static final String BUNDLE_KEY_REQUEST_JSON = "androidx.credentials.BUNDLE_KEY_REQUEST_JSON";
    public static final String BUNDLE_VALUE_SUBTYPE_CREATE_PUBLIC_KEY_CREDENTIAL_REQUEST = "androidx.credentials.BUNDLE_VALUE_SUBTYPE_CREATE_PUBLIC_KEY_CREDENTIAL_REQUEST";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final byte[] clientDataHash;
    private final String requestJson;

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ CreateCredentialRequest.DisplayInfo getRequestDisplayInfo$credentials_release$default(Companion companion, String str, String str2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            return companion.getRequestDisplayInfo$credentials_release(str, str2);
        }

        public static /* synthetic */ Bundle toCredentialDataBundle$credentials_release$default(Companion companion, String str, byte[] bArr, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                bArr = null;
            }
            return companion.toCredentialDataBundle$credentials_release(str, bArr);
        }

        @RequiresApi(23)
        public final CreatePublicKeyCredentialRequest createFrom$credentials_release(Bundle bundle, String str, Bundle bundle2) {
            m.f(bundle, "data");
            m.f(bundle2, "candidateQueryData");
            try {
                String string = bundle.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                m.c(string);
                byte[] byteArray = bundle.getByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH");
                boolean z10 = bundle.getBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", false);
                CreateCredentialRequest.DisplayInfo parseFromCredentialDataBundle = CreateCredentialRequest.DisplayInfo.Companion.parseFromCredentialDataBundle(bundle);
                if (parseFromCredentialDataBundle == null) {
                    parseFromCredentialDataBundle = getRequestDisplayInfo$credentials_release$default(this, string, (String) null, 2, (Object) null);
                }
                return new CreatePublicKeyCredentialRequest(string, byteArray, bundle.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), z10, parseFromCredentialDataBundle, str, bundle, bundle2, (DefaultConstructorMarker) null);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final CreateCredentialRequest.DisplayInfo getRequestDisplayInfo$credentials_release(String str, String str2) {
            String str3;
            m.f(str, "requestJson");
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("user");
                String string = jSONObject.getString("name");
                if (jSONObject.isNull("displayName")) {
                    str3 = null;
                } else {
                    str3 = jSONObject.getString("displayName");
                }
                m.e(string, "userName");
                return new CreateCredentialRequest.DisplayInfo((CharSequence) string, (CharSequence) str3, (Icon) null, str2);
            } catch (Exception unused) {
                throw new IllegalArgumentException("user.name must be defined in requestJson");
            }
        }

        public final Bundle toCandidateDataBundle$credentials_release(String str, byte[] bArr) {
            m.f(str, "requestJson");
            Bundle bundle = new Bundle();
            bundle.putString(PublicKeyCredential.BUNDLE_KEY_SUBTYPE, CreatePublicKeyCredentialRequest.BUNDLE_VALUE_SUBTYPE_CREATE_PUBLIC_KEY_CREDENTIAL_REQUEST);
            bundle.putString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON", str);
            bundle.putByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH", bArr);
            return bundle;
        }

        public final Bundle toCredentialDataBundle$credentials_release(String str, byte[] bArr) {
            m.f(str, "requestJson");
            Bundle bundle = new Bundle();
            bundle.putString(PublicKeyCredential.BUNDLE_KEY_SUBTYPE, CreatePublicKeyCredentialRequest.BUNDLE_VALUE_SUBTYPE_CREATE_PUBLIC_KEY_CREDENTIAL_REQUEST);
            bundle.putString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON", str);
            bundle.putByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH", bArr);
            return bundle;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePublicKeyCredentialRequest(String str) {
        this(str, (byte[]) null, false, (String) null, false, 30, (DefaultConstructorMarker) null);
        m.f(str, "requestJson");
    }

    @RequiresApi(23)
    public static final CreatePublicKeyCredentialRequest createFrom$credentials_release(Bundle bundle, String str, Bundle bundle2) {
        return Companion.createFrom$credentials_release(bundle, str, bundle2);
    }

    public static final CreateCredentialRequest.DisplayInfo getRequestDisplayInfo$credentials_release(String str, String str2) {
        return Companion.getRequestDisplayInfo$credentials_release(str, str2);
    }

    public static final Bundle toCandidateDataBundle$credentials_release(String str, byte[] bArr) {
        return Companion.toCandidateDataBundle$credentials_release(str, bArr);
    }

    public static final Bundle toCredentialDataBundle$credentials_release(String str, byte[] bArr) {
        return Companion.toCredentialDataBundle$credentials_release(str, bArr);
    }

    public final byte[] getClientDataHash() {
        return this.clientDataHash;
    }

    public final String getRequestJson() {
        return this.requestJson;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePublicKeyCredentialRequest(String str, byte[] bArr) {
        this(str, bArr, false, (String) null, false, 28, (DefaultConstructorMarker) null);
        m.f(str, "requestJson");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePublicKeyCredentialRequest(String str, byte[] bArr, boolean z10) {
        this(str, bArr, z10, (String) null, false, 24, (DefaultConstructorMarker) null);
        m.f(str, "requestJson");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePublicKeyCredentialRequest(String str, byte[] bArr, boolean z10, String str2) {
        this(str, bArr, z10, str2, false, 16, (DefaultConstructorMarker) null);
        m.f(str, "requestJson");
    }

    public /* synthetic */ CreatePublicKeyCredentialRequest(String str, byte[] bArr, boolean z10, boolean z11, CreateCredentialRequest.DisplayInfo displayInfo, String str2, Bundle bundle, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bArr, z10, z11, displayInfo, str2, bundle, bundle2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ CreatePublicKeyCredentialRequest(java.lang.String r10, byte[] r11, boolean r12, boolean r13, androidx.credentials.CreateCredentialRequest.DisplayInfo r14, java.lang.String r15, android.os.Bundle r16, android.os.Bundle r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r1 = r10
            r2 = r11
            r0 = r18
            r3 = r0 & 32
            if (r3 == 0) goto L_0x000b
            r3 = 0
            r6 = r3
            goto L_0x000c
        L_0x000b:
            r6 = r15
        L_0x000c:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x0018
            androidx.credentials.CreatePublicKeyCredentialRequest$Companion r3 = Companion
            android.os.Bundle r3 = r3.toCredentialDataBundle$credentials_release(r10, r11)
            r7 = r3
            goto L_0x001a
        L_0x0018:
            r7 = r16
        L_0x001a:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0026
            androidx.credentials.CreatePublicKeyCredentialRequest$Companion r0 = Companion
            android.os.Bundle r0 = r0.toCandidateDataBundle$credentials_release(r10, r11)
            r8 = r0
            goto L_0x0028
        L_0x0026:
            r8 = r17
        L_0x0028:
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.CreatePublicKeyCredentialRequest.<init>(java.lang.String, byte[], boolean, boolean, androidx.credentials.CreateCredentialRequest$DisplayInfo, java.lang.String, android.os.Bundle, android.os.Bundle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private CreatePublicKeyCredentialRequest(String str, byte[] bArr, boolean z10, boolean z11, CreateCredentialRequest.DisplayInfo displayInfo, String str2, Bundle bundle, Bundle bundle2) {
        super(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, bundle, bundle2, false, z10, displayInfo, str2, z11);
        this.requestJson = str;
        this.clientDataHash = bArr;
        if (!RequestValidationHelper.Companion.isValidJSON(str)) {
            throw new IllegalArgumentException("requestJson must not be empty, and must be a valid JSON".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreatePublicKeyCredentialRequest(String str, byte[] bArr, boolean z10, String str2, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : bArr, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? false : z11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePublicKeyCredentialRequest(String str, byte[] bArr, boolean z10, String str2, boolean z11) {
        this(str, bArr, z11, z10, Companion.getRequestDisplayInfo$credentials_release$default(Companion, str, (String) null, 2, (Object) null), str2, (Bundle) null, (Bundle) null, 192, (DefaultConstructorMarker) null);
        m.f(str, "requestJson");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePublicKeyCredentialRequest(String str, byte[] bArr, boolean z10, String str2, String str3, boolean z11) {
        this(str, bArr, z11, z10, Companion.getRequestDisplayInfo$credentials_release(str, str3), str2, (Bundle) null, (Bundle) null, 192, (DefaultConstructorMarker) null);
        m.f(str, "requestJson");
    }
}
