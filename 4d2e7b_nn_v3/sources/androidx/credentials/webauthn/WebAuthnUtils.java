package androidx.credentials.webauthn;

import android.os.Build;
import android.util.Base64;
import androidx.annotation.RestrictTo;
import androidx.credentials.provider.CallingAppInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class WebAuthnUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public final String appInfoToOrigin(CallingAppInfo callingAppInfo) {
            m.f(callingAppInfo, "info");
            if (Build.VERSION.SDK_INT >= 28) {
                return WebAuthnUtilsApi28.Companion.appInfoToOrigin(callingAppInfo);
            }
            return "";
        }

        public final byte[] b64Decode(String str) {
            m.f(str, "str");
            byte[] decode = Base64.decode(str, 11);
            m.e(decode, "decode(str, Base64.NO_PA…_WRAP or Base64.URL_SAFE)");
            return decode;
        }

        public final String b64Encode(byte[] bArr) {
            m.f(bArr, "data");
            String encodeToString = Base64.encodeToString(bArr, 11);
            m.e(encodeToString, "encodeToString(data, Bas…_WRAP or Base64.URL_SAFE)");
            return encodeToString;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
