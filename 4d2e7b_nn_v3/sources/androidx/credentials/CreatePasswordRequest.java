package androidx.credentials;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.HintConstants;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class CreatePasswordRequest extends CreateCredentialRequest {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String BUNDLE_KEY_ID = "androidx.credentials.BUNDLE_KEY_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String BUNDLE_KEY_PASSWORD = "androidx.credentials.BUNDLE_KEY_PASSWORD";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: id  reason: collision with root package name */
    private final String f15307id;
    private final String password;

    public static final class Companion {
        private Companion() {
        }

        @RequiresApi(23)
        public final CreatePasswordRequest createFrom$credentials_release(Bundle bundle, String str, Bundle bundle2) {
            m.f(bundle, "data");
            m.f(bundle2, "candidateQueryData");
            try {
                String string = bundle.getString("androidx.credentials.BUNDLE_KEY_ID");
                m.c(string);
                String string2 = bundle.getString("androidx.credentials.BUNDLE_KEY_PASSWORD");
                m.c(string2);
                CreateCredentialRequest.DisplayInfo parseFromCredentialDataBundle = CreateCredentialRequest.DisplayInfo.Companion.parseFromCredentialDataBundle(bundle);
                if (parseFromCredentialDataBundle == null) {
                    parseFromCredentialDataBundle = new CreateCredentialRequest.DisplayInfo(string, (CharSequence) null);
                }
                boolean z10 = bundle.getBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", false);
                return new CreatePasswordRequest(string, string2, bundle.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), parseFromCredentialDataBundle, str, z10, bundle, bundle2, (DefaultConstructorMarker) null);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final Bundle toCandidateDataBundle$credentials_release() {
            return new Bundle();
        }

        public final Bundle toCredentialDataBundle$credentials_release(String str, String str2) {
            m.f(str, "id");
            m.f(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_ID", str);
            bundle.putString("androidx.credentials.BUNDLE_KEY_PASSWORD", str2);
            return bundle;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2) {
        this(str, str2, (String) null, false, false, 28, (DefaultConstructorMarker) null);
        m.f(str, "id");
        m.f(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
    }

    @RequiresApi(23)
    public static final CreatePasswordRequest createFrom$credentials_release(Bundle bundle, String str, Bundle bundle2) {
        return Companion.createFrom$credentials_release(bundle, str, bundle2);
    }

    public static final Bundle toCandidateDataBundle$credentials_release() {
        return Companion.toCandidateDataBundle$credentials_release();
    }

    public static final Bundle toCredentialDataBundle$credentials_release(String str, String str2) {
        return Companion.toCredentialDataBundle$credentials_release(str, str2);
    }

    public final String getId() {
        return this.f15307id;
    }

    public final String getPassword() {
        return this.password;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2, String str3) {
        this(str, str2, str3, false, false, 24, (DefaultConstructorMarker) null);
        m.f(str, "id");
        m.f(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2, String str3, boolean z10) {
        this(str, str2, str3, z10, false, 16, (DefaultConstructorMarker) null);
        m.f(str, "id");
        m.f(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
    }

    public /* synthetic */ CreatePasswordRequest(String str, String str2, boolean z10, CreateCredentialRequest.DisplayInfo displayInfo, String str3, boolean z11, Bundle bundle, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z10, displayInfo, str3, z11, bundle, bundle2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ CreatePasswordRequest(java.lang.String r12, java.lang.String r13, boolean r14, androidx.credentials.CreateCredentialRequest.DisplayInfo r15, java.lang.String r16, boolean r17, android.os.Bundle r18, android.os.Bundle r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r7 = r1
            goto L_0x000b
        L_0x0009:
            r7 = r16
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            androidx.credentials.CreatePasswordRequest$Companion r1 = Companion
            r3 = r12
            r4 = r13
            android.os.Bundle r1 = r1.toCredentialDataBundle$credentials_release(r12, r13)
            r9 = r1
            goto L_0x001d
        L_0x0019:
            r3 = r12
            r4 = r13
            r9 = r18
        L_0x001d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0029
            androidx.credentials.CreatePasswordRequest$Companion r0 = Companion
            android.os.Bundle r0 = r0.toCandidateDataBundle$credentials_release()
            r10 = r0
            goto L_0x002b
        L_0x0029:
            r10 = r19
        L_0x002b:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.CreatePasswordRequest.<init>(java.lang.String, java.lang.String, boolean, androidx.credentials.CreateCredentialRequest$DisplayInfo, java.lang.String, boolean, android.os.Bundle, android.os.Bundle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private CreatePasswordRequest(String str, String str2, boolean z10, CreateCredentialRequest.DisplayInfo displayInfo, String str3, boolean z11, Bundle bundle, Bundle bundle2) {
        super(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, bundle, bundle2, false, z10, displayInfo, str3, z11);
        this.f15307id = str;
        this.password = str2;
        if (str2.length() <= 0) {
            throw new IllegalArgumentException("password should not be empty".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreatePasswordRequest(String str, String str2, String str3, boolean z10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2, String str3, boolean z10, boolean z11) {
        this(str, str2, z11, new CreateCredentialRequest.DisplayInfo(str, (CharSequence) null), str3, z10, (Bundle) null, (Bundle) null, 192, (DefaultConstructorMarker) null);
        m.f(str, "id");
        m.f(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePasswordRequest(String str, String str2, String str3, String str4, boolean z10, boolean z11) {
        this(str, str2, z11, new CreateCredentialRequest.DisplayInfo(str, (CharSequence) null, str4), str3, z10, (Bundle) null, (Bundle) null, 192, (DefaultConstructorMarker) null);
        m.f(str, "id");
        m.f(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
        String str5 = str4;
    }
}
