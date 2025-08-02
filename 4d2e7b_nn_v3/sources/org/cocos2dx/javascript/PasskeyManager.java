package org.cocos2dx.javascript;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import androidx.credentials.CredentialManager;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialNoCreateOptionException;
import com.facebook.react.bridge.Callback;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import java.security.SecureRandom;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.x0;

public final class PasskeyManager {
    public static final PasskeyManager INSTANCE;
    private static final int RESULT_CANCEL = 2;
    private static final int RESULT_FAILED = 0;
    private static final int RESULT_NOT_SUPPORT = 3;
    private static final int RESULT_SUCCESS = 1;
    private static CredentialManager credentialManager;

    static {
        PasskeyManager passkeyManager = new PasskeyManager();
        INSTANCE = passkeyManager;
        credentialManager = CredentialManager.Companion.create(passkeyManager.getContext());
    }

    private PasskeyManager() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createPasskey(java.lang.String r13, kotlin.coroutines.d r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof org.cocos2dx.javascript.PasskeyManager$createPasskey$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            org.cocos2dx.javascript.PasskeyManager$createPasskey$1 r0 = (org.cocos2dx.javascript.PasskeyManager$createPasskey$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            org.cocos2dx.javascript.PasskeyManager$createPasskey$1 r0 = new org.cocos2dx.javascript.PasskeyManager$createPasskey$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r13 = r0.L$0
            org.cocos2dx.javascript.PasskeyManager r13 = (org.cocos2dx.javascript.PasskeyManager) r13
            kotlin.p.b(r14)     // Catch:{ CreateCredentialException -> 0x002d }
            goto L_0x005a
        L_0x002d:
            r14 = move-exception
            goto L_0x006d
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0037:
            kotlin.p.b(r14)
            androidx.credentials.CreatePublicKeyCredentialRequest r14 = new androidx.credentials.CreatePublicKeyCredentialRequest
            r10 = 30
            r11 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r4 = r14
            r5 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            androidx.credentials.CredentialManager r13 = credentialManager     // Catch:{ CreateCredentialException -> 0x006b }
            android.content.Context r2 = r12.getContext()     // Catch:{ CreateCredentialException -> 0x006b }
            r0.L$0 = r12     // Catch:{ CreateCredentialException -> 0x006b }
            r0.label = r3     // Catch:{ CreateCredentialException -> 0x006b }
            java.lang.Object r14 = r13.createCredential(r2, r14, r0)     // Catch:{ CreateCredentialException -> 0x006b }
            if (r14 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r13 = r12
        L_0x005a:
            java.lang.String r0 = "null cannot be cast to non-null type androidx.credentials.CreatePublicKeyCredentialResponse"
            kotlin.jvm.internal.m.d(r14, r0)     // Catch:{ CreateCredentialException -> 0x002d }
            androidx.credentials.CreatePublicKeyCredentialResponse r14 = (androidx.credentials.CreatePublicKeyCredentialResponse) r14     // Catch:{ CreateCredentialException -> 0x002d }
            kotlin.Pair r13 = new kotlin.Pair
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.a.b(r3)
            r13.<init>(r0, r14)
            return r13
        L_0x006b:
            r14 = move-exception
            r13 = r12
        L_0x006d:
            kotlin.Pair r0 = new kotlin.Pair
            int r13 = r13.handlePasskeyFailure(r14)
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.a.b(r13)
            r14 = 0
            r0.<init>(r13, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.PasskeyManager.createPasskey(java.lang.String, kotlin.coroutines.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final String fetchAuthJsonFromServer(String str, String str2) {
        return j.z(j.z(PasskeyManagerKt.readFromAsset(getContext(), "AuthFromServer"), "<rpId>", str, false, 4, (Object) null), "<challenge>", str2, false, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final String fetchRegistrationJsonFromServer(String str, String str2, String str3, String str4) {
        return j.z(j.z(j.z(j.z(j.z(PasskeyManagerKt.readFromAsset(getContext(), "RegFromServer"), "<userId>", str4, false, 4, (Object) null), "<userName>", str, false, 4, (Object) null), "<userDisplayName>", str, false, 4, (Object) null), "<rpId>", str2, false, 4, (Object) null), "<challenge>", str3, false, 4, (Object) null);
    }

    private final Context getContext() {
        AppActivity appActivity = PlatformUtils.mActivity;
        m.e(appActivity, "mActivity");
        return appActivity;
    }

    private final String getEncodedChallenge() {
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 11);
        m.e(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    private final String getEncodedUserId() {
        byte[] bArr = new byte[64];
        new SecureRandom().nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 11);
        m.e(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSavedCredentials(java.lang.String r22, kotlin.coroutines.d r23) {
        /*
            r21 = this;
            r0 = r23
            r1 = 2
            r2 = 1
            r3 = 0
            boolean r4 = r0 instanceof org.cocos2dx.javascript.PasskeyManager$getSavedCredentials$1
            if (r4 == 0) goto L_0x001a
            r4 = r0
            org.cocos2dx.javascript.PasskeyManager$getSavedCredentials$1 r4 = (org.cocos2dx.javascript.PasskeyManager$getSavedCredentials$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001a
            int r5 = r5 - r6
            r4.label = r5
            r5 = r21
            goto L_0x0021
        L_0x001a:
            org.cocos2dx.javascript.PasskeyManager$getSavedCredentials$1 r4 = new org.cocos2dx.javascript.PasskeyManager$getSavedCredentials$1
            r5 = r21
            r4.<init>(r5, r0)
        L_0x0021:
            java.lang.Object r0 = r4.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.b.c()
            int r7 = r4.label
            java.lang.String r8 = "Auth"
            if (r7 == 0) goto L_0x003e
            if (r7 != r2) goto L_0x0036
            kotlin.p.b(r0)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0087
        L_0x0033:
            r0 = move-exception
            goto L_0x00bd
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003e:
            kotlin.p.b(r0)
            androidx.credentials.GetPublicKeyCredentialOption r0 = new androidx.credentials.GetPublicKeyCredentialOption
            r13 = 4
            r14 = 0
            r11 = 0
            r12 = 0
            r9 = r0
            r10 = r22
            r9.<init>((java.lang.String) r10, (byte[]) r11, (java.util.Set) r12, (int) r13, (kotlin.jvm.internal.DefaultConstructorMarker) r14)
            androidx.credentials.GetPasswordOption r7 = new androidx.credentials.GetPasswordOption
            r19 = 7
            r20 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r15 = r7
            r15.<init>((java.util.Set) r16, (boolean) r17, (java.util.Set) r18, (int) r19, (kotlin.jvm.internal.DefaultConstructorMarker) r20)
            androidx.credentials.CredentialManager r9 = credentialManager     // Catch:{ Exception -> 0x0033 }
            android.content.Context r10 = r21.getContext()     // Catch:{ Exception -> 0x0033 }
            androidx.credentials.GetCredentialRequest r15 = new androidx.credentials.GetCredentialRequest     // Catch:{ Exception -> 0x0033 }
            androidx.credentials.CredentialOption[] r11 = new androidx.credentials.CredentialOption[r1]     // Catch:{ Exception -> 0x0033 }
            r11[r3] = r0     // Catch:{ Exception -> 0x0033 }
            r11[r2] = r7     // Catch:{ Exception -> 0x0033 }
            java.util.List r12 = kotlin.collections.r.o(r11)     // Catch:{ Exception -> 0x0033 }
            r17 = 30
            r18 = 0
            r13 = 0
            r14 = 0
            r0 = 0
            r16 = 0
            r11 = r15
            r7 = r15
            r15 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x0033 }
            r4.label = r2     // Catch:{ Exception -> 0x0033 }
            java.lang.Object r0 = r9.getCredential((android.content.Context) r10, (androidx.credentials.GetCredentialRequest) r7, (kotlin.coroutines.d) r4)     // Catch:{ Exception -> 0x0033 }
            if (r0 != r6) goto L_0x0087
            return r6
        L_0x0087:
            androidx.credentials.GetCredentialResponse r0 = (androidx.credentials.GetCredentialResponse) r0     // Catch:{ Exception -> 0x0033 }
            androidx.credentials.Credential r1 = r0.getCredential()
            boolean r1 = r1 instanceof androidx.credentials.PublicKeyCredential
            if (r1 == 0) goto L_0x00b1
            androidx.credentials.Credential r0 = r0.getCredential()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.credentials.PublicKeyCredential"
            kotlin.jvm.internal.m.d(r0, r1)
            androidx.credentials.PublicKeyCredential r0 = (androidx.credentials.PublicKeyCredential) r0
            java.lang.String r1 = r0.getAuthenticationResponseJson()
            android.util.Log.d(r8, r1)
            kotlin.Pair r1 = new kotlin.Pair
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.a.b(r2)
            java.lang.String r0 = r0.getAuthenticationResponseJson()
            r1.<init>(r2, r0)
            return r1
        L_0x00b1:
            kotlin.Pair r0 = new kotlin.Pair
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.a.b(r3)
            java.lang.String r2 = ""
            r0.<init>(r1, r2)
            return r0
        L_0x00bd:
            java.lang.String r4 = r0.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "getCredential failed with exception: "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            android.util.Log.e(r8, r4)
            java.lang.String r4 = r0.getMessage()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r6 = "cancel"
            boolean r2 = kotlin.text.j.I(r4, r6, r2)
            if (r2 == 0) goto L_0x00e6
            goto L_0x00ed
        L_0x00e6:
            boolean r1 = r0 instanceof androidx.credentials.exceptions.NoCredentialException
            if (r1 == 0) goto L_0x00ec
            r1 = 3
            goto L_0x00ed
        L_0x00ec:
            r1 = r3
        L_0x00ed:
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.a.b(r1)
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.PasskeyManager.getSavedCredentials(java.lang.String, kotlin.coroutines.d):java.lang.Object");
    }

    private final int handlePasskeyFailure(CreateCredentialException createCredentialException) {
        if (createCredentialException instanceof CreateCredentialCancellationException) {
            return 2;
        }
        if (createCredentialException instanceof CreateCredentialNoCreateOptionException) {
            Log.w("Auth", "CreateCredentialNoCreateOptionException");
            return 3;
        }
        String message = createCredentialException.getMessage();
        Log.w("Auth", "ERROR" + message);
        return 0;
    }

    public final void register(String str, String str2, String str3, String str4) {
        m.f(str, "rpId");
        m.f(str2, "userName");
        m.f(str3, ClientData.KEY_CHALLENGE);
        m.f(str4, "userId");
        register(str, str2, str3, str4, (Callback) null);
    }

    public final void signIn(String str, String str2) {
        m.f(str, "rpId");
        m.f(str2, ClientData.KEY_CHALLENGE);
        signIn(str, str2, (Callback) null);
    }

    public final void register(String str, String str2, String str3, String str4, Callback callback) {
        m.f(str, "rpId");
        m.f(str2, "userName");
        m.f(str3, ClientData.KEY_CHALLENGE);
        m.f(str4, "userId");
        f1 unused = f.b(x0.f1205a, (CoroutineContext) null, (d0) null, new PasskeyManager$register$1(str2, str, str3, str4, callback, (d) null), 3, (Object) null);
    }

    public final void signIn(String str, String str2, Callback callback) {
        m.f(str, "rpId");
        m.f(str2, ClientData.KEY_CHALLENGE);
        f1 unused = f.b(x0.f1205a, (CoroutineContext) null, (d0) null, new PasskeyManager$signIn$1(str, str2, callback, (d) null), 3, (Object) null);
    }
}
