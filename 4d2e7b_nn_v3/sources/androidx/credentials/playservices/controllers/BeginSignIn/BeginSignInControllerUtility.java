package androidx.credentials.playservices.controllers.BeginSignIn;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class BeginSignInControllerUtility {
    private static final long AUTH_MIN_VERSION_JSON_PARSING = 231815000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "BeginSignInUtility";

    public static final class Companion {
        private Companion() {
        }

        private final BeginSignInRequest.GoogleIdTokenRequestOptions convertToGoogleIdTokenOption(GetGoogleIdOption getGoogleIdOption) {
            BeginSignInRequest.GoogleIdTokenRequestOptions.Builder supported = BeginSignInRequest.GoogleIdTokenRequestOptions.builder().setFilterByAuthorizedAccounts(getGoogleIdOption.getFilterByAuthorizedAccounts()).setNonce(getGoogleIdOption.getNonce()).setRequestVerifiedPhoneNumber(getGoogleIdOption.getRequestVerifiedPhoneNumber()).setServerClientId(getGoogleIdOption.getServerClientId()).setSupported(true);
            m.e(supported, "builder()\n              …      .setSupported(true)");
            if (getGoogleIdOption.getLinkedServiceId() != null) {
                String linkedServiceId = getGoogleIdOption.getLinkedServiceId();
                m.c(linkedServiceId);
                supported.associateLinkedAccounts(linkedServiceId, getGoogleIdOption.getIdTokenDepositionScopes());
            }
            BeginSignInRequest.GoogleIdTokenRequestOptions build = supported.build();
            m.e(build, "idTokenOption.build()");
            return build;
        }

        private final long determineDeviceGMSVersionCode(Context context) {
            PackageManager packageManager = context.getPackageManager();
            m.e(packageManager, "context.packageManager");
            return (long) packageManager.getPackageInfo("com.google.android.gms", 0).versionCode;
        }

        private final boolean needsBackwardsCompatibleRequest(long j10) {
            return j10 < BeginSignInControllerUtility.AUTH_MIN_VERSION_JSON_PARSING;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
            if (r4.getAutoSelectEnabled() == false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0041, code lost:
            if (r4.isAutoSelectAllowed() == false) goto L_0x0044;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.android.gms.auth.api.identity.BeginSignInRequest constructBeginSignInRequest$credentials_play_services_auth_release(androidx.credentials.GetCredentialRequest r10, android.content.Context r11) {
            /*
                r9 = this;
                java.lang.String r0 = "request"
                kotlin.jvm.internal.m.f(r10, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.f(r11, r0)
                com.google.android.gms.auth.api.identity.BeginSignInRequest$Builder r0 = new com.google.android.gms.auth.api.identity.BeginSignInRequest$Builder
                r0.<init>()
                java.util.List r10 = r10.getCredentialOptions()
                java.util.Iterator r10 = r10.iterator()
                r1 = 0
                r2 = r1
                r3 = r2
            L_0x001a:
                boolean r4 = r10.hasNext()
                if (r4 == 0) goto L_0x0087
                java.lang.Object r4 = r10.next()
                androidx.credentials.CredentialOption r4 = (androidx.credentials.CredentialOption) r4
                boolean r5 = r4 instanceof androidx.credentials.GetPasswordOption
                r6 = 1
                if (r5 == 0) goto L_0x0048
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions$Builder r5 = new com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions$Builder
                r5.<init>()
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions$Builder r5 = r5.setSupported(r6)
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasswordRequestOptions r5 = r5.build()
                r0.setPasswordRequestOptions(r5)
                if (r2 != 0) goto L_0x0046
                boolean r2 = r4.isAutoSelectAllowed()
                if (r2 == 0) goto L_0x0044
                goto L_0x0046
            L_0x0044:
                r2 = r1
                goto L_0x001a
            L_0x0046:
                r2 = r6
                goto L_0x001a
            L_0x0048:
                boolean r5 = r4 instanceof androidx.credentials.GetPublicKeyCredentialOption
                if (r5 == 0) goto L_0x0071
                if (r3 != 0) goto L_0x0071
                long r7 = r9.determineDeviceGMSVersionCode(r11)
                boolean r3 = r9.needsBackwardsCompatibleRequest(r7)
                if (r3 == 0) goto L_0x0064
                androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility$Companion r3 = androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility.Companion
                androidx.credentials.GetPublicKeyCredentialOption r4 = (androidx.credentials.GetPublicKeyCredentialOption) r4
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeysRequestOptions r3 = r3.convertToPlayAuthPasskeyRequest(r4)
                r0.setPasskeysSignInRequestOptions(r3)
                goto L_0x006f
            L_0x0064:
                androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility$Companion r3 = androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility.Companion
                androidx.credentials.GetPublicKeyCredentialOption r4 = (androidx.credentials.GetPublicKeyCredentialOption) r4
                com.google.android.gms.auth.api.identity.BeginSignInRequest$PasskeyJsonRequestOptions r3 = r3.convertToPlayAuthPasskeyJsonRequest(r4)
                r0.setPasskeyJsonSignInRequestOptions(r3)
            L_0x006f:
                r3 = r6
                goto L_0x001a
            L_0x0071:
                boolean r5 = r4 instanceof com.google.android.libraries.identity.googleid.GetGoogleIdOption
                if (r5 == 0) goto L_0x001a
                com.google.android.libraries.identity.googleid.GetGoogleIdOption r4 = (com.google.android.libraries.identity.googleid.GetGoogleIdOption) r4
                com.google.android.gms.auth.api.identity.BeginSignInRequest$GoogleIdTokenRequestOptions r5 = r9.convertToGoogleIdTokenOption(r4)
                r0.setGoogleIdTokenRequestOptions(r5)
                if (r2 != 0) goto L_0x0046
                boolean r2 = r4.getAutoSelectEnabled()
                if (r2 == 0) goto L_0x0044
                goto L_0x0046
            L_0x0087:
                com.google.android.gms.auth.api.identity.BeginSignInRequest$Builder r10 = r0.setAutoSelectEnabled(r2)
                com.google.android.gms.auth.api.identity.BeginSignInRequest r10 = r10.build()
                java.lang.String r11 = "requestBuilder\n         …\n                .build()"
                kotlin.jvm.internal.m.e(r10, r11)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.playservices.controllers.BeginSignIn.BeginSignInControllerUtility.Companion.constructBeginSignInRequest$credentials_play_services_auth_release(androidx.credentials.GetCredentialRequest, android.content.Context):com.google.android.gms.auth.api.identity.BeginSignInRequest");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
