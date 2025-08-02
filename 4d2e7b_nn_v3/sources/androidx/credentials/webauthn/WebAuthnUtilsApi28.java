package androidx.credentials.webauthn;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.webauthn.WebAuthnUtils;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RequiresApi(28)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class WebAuthnUtilsApi28 {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public final String appInfoToOrigin(CallingAppInfo callingAppInfo) {
            m.f(callingAppInfo, "info");
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(callingAppInfo.getSigningInfo().getApkContentsSigners()[0].toByteArray());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("android:apk-key-hash:");
            WebAuthnUtils.Companion companion = WebAuthnUtils.Companion;
            m.e(digest, "certHash");
            sb2.append(companion.b64Encode(digest));
            return sb2.toString();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
