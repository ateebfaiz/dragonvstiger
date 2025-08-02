package com.google.firebase.messaging;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import androidx.credentials.a;
import androidx.webkit.ProxyConfig;
import com.alibaba.pdns.j;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f9205a;

    /* renamed from: b  reason: collision with root package name */
    private final d0 f9206b;

    /* renamed from: c  reason: collision with root package name */
    private final Rpc f9207c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider f9208d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider f9209e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseInstallationsApi f9210f;

    a0(FirebaseApp firebaseApp, d0 d0Var, Provider provider, Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, d0Var, new Rpc(firebaseApp.getApplicationContext()), provider, provider2, firebaseInstallationsApi);
    }

    private static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task d(Task task) {
        return task.continueWith(new a(), new z(this));
    }

    private String e() {
        try {
            return b(MessageDigest.getInstance(j.f17956c).digest(this.f9205a.getName().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String g(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                Log.w(Constants.TAG, "Unexpected response: " + bundle, new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    static boolean h(String str) {
        if ("SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String i(Task task) {
        return g((Bundle) task.getResult(IOException.class));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00c0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j(java.lang.String r3, java.lang.String r4, android.os.Bundle r5) {
        /*
            r2 = this;
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "scope"
            r5.putString(r1, r4)
            java.lang.String r4 = "sender"
            r5.putString(r4, r3)
            java.lang.String r4 = "subtype"
            r5.putString(r4, r3)
            com.google.firebase.FirebaseApp r3 = r2.f9205a
            com.google.firebase.FirebaseOptions r3 = r3.getOptions()
            java.lang.String r3 = r3.getApplicationId()
            java.lang.String r4 = "gmp_app_id"
            r5.putString(r4, r3)
            com.google.firebase.messaging.d0 r3 = r2.f9206b
            int r3 = r3.d()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "gmsv"
            r5.putString(r4, r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "osv"
            r5.putString(r4, r3)
            com.google.firebase.messaging.d0 r3 = r2.f9206b
            java.lang.String r3 = r3.a()
            java.lang.String r4 = "app_ver"
            r5.putString(r4, r3)
            com.google.firebase.messaging.d0 r3 = r2.f9206b
            java.lang.String r3 = r3.b()
            java.lang.String r4 = "app_ver_name"
            r5.putString(r4, r3)
            java.lang.String r3 = "firebase-app-name-hash"
            java.lang.String r4 = r2.e()
            r5.putString(r3, r4)
            com.google.firebase.installations.FirebaseInstallationsApi r3 = r2.f9210f     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            r4 = 0
            com.google.android.gms.tasks.Task r3 = r3.getToken(r4)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            java.lang.Object r3 = com.google.android.gms.tasks.Tasks.await(r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            com.google.firebase.installations.InstallationTokenResult r3 = (com.google.firebase.installations.InstallationTokenResult) r3     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            java.lang.String r3 = r3.getToken()     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            if (r4 != 0) goto L_0x007a
            java.lang.String r4 = "Goog-Firebase-Installations-Auth"
            r5.putString(r4, r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            goto L_0x0085
        L_0x0076:
            r3 = move-exception
            goto L_0x0080
        L_0x0078:
            r3 = move-exception
            goto L_0x0080
        L_0x007a:
            java.lang.String r3 = "FIS auth token is empty"
            android.util.Log.w(r0, r3)     // Catch:{ ExecutionException -> 0x0078, InterruptedException -> 0x0076 }
            goto L_0x0085
        L_0x0080:
            java.lang.String r4 = "Failed to get FIS auth token"
            android.util.Log.e(r0, r4, r3)
        L_0x0085:
            com.google.firebase.installations.FirebaseInstallationsApi r3 = r2.f9210f
            com.google.android.gms.tasks.Task r3 = r3.getId()
            java.lang.Object r3 = com.google.android.gms.tasks.Tasks.await(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "appid"
            r5.putString(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fcm-"
            r3.append(r4)
            java.lang.String r4 = "23.1.2"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "cliv"
            r5.putString(r4, r3)
            com.google.firebase.inject.Provider r3 = r2.f9209e
            java.lang.Object r3 = r3.get()
            com.google.firebase.heartbeatinfo.HeartBeatInfo r3 = (com.google.firebase.heartbeatinfo.HeartBeatInfo) r3
            com.google.firebase.inject.Provider r4 = r2.f9208d
            java.lang.Object r4 = r4.get()
            com.google.firebase.platforminfo.UserAgentPublisher r4 = (com.google.firebase.platforminfo.UserAgentPublisher) r4
            if (r3 == 0) goto L_0x00e2
            if (r4 == 0) goto L_0x00e2
            java.lang.String r0 = "fire-iid"
            com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat r3 = r3.getHeartBeatCode(r0)
            com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat r0 = com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat.NONE
            if (r3 == r0) goto L_0x00e2
            int r3 = r3.getCode()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r0 = "Firebase-Client-Log-Type"
            r5.putString(r0, r3)
            java.lang.String r3 = "Firebase-Client"
            java.lang.String r4 = r4.getUserAgent()
            r5.putString(r3, r4)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.a0.j(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    private Task k(String str, String str2, Bundle bundle) {
        try {
            j(str, str2, bundle);
            return this.f9207c.send(bundle);
        } catch (InterruptedException | ExecutionException e10) {
            return Tasks.forException(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public Task c() {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return d(k(d0.c(this.f9205a), ProxyConfig.MATCH_ALL_SCHEMES, bundle));
    }

    /* access modifiers changed from: package-private */
    public Task f() {
        return d(k(d0.c(this.f9205a), ProxyConfig.MATCH_ALL_SCHEMES, new Bundle()));
    }

    /* access modifiers changed from: package-private */
    public Task l(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return d(k(str, "/topics/" + str2, bundle));
    }

    /* access modifiers changed from: package-private */
    public Task m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return d(k(str, "/topics/" + str2, bundle));
    }

    a0(FirebaseApp firebaseApp, d0 d0Var, Rpc rpc, Provider provider, Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f9205a = firebaseApp;
        this.f9206b = d0Var;
        this.f9207c = rpc;
        this.f9208d = provider;
        this.f9209e = provider2;
        this.f9210f = firebaseInstallationsApi;
    }
}
