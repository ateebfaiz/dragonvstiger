package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;

class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9226a;

    /* renamed from: b  reason: collision with root package name */
    private String f9227b;

    /* renamed from: c  reason: collision with root package name */
    private String f9228c;

    /* renamed from: d  reason: collision with root package name */
    private int f9229d;

    /* renamed from: e  reason: collision with root package name */
    private int f9230e = 0;

    d0(Context context) {
        this.f9226a = context;
    }

    static String c(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.f9226a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w(Constants.TAG, "Failed to find package " + e10);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f10 = f(this.f9226a.getPackageName());
        if (f10 != null) {
            this.f9227b = Integer.toString(f10.versionCode);
            this.f9228c = f10.versionName;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized String a() {
        try {
            if (this.f9227b == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9227b;
    }

    /* access modifiers changed from: package-private */
    public synchronized String b() {
        try {
            if (this.f9228c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9228c;
    }

    /* access modifiers changed from: package-private */
    public synchronized int d() {
        PackageInfo f10;
        try {
            if (this.f9229d == 0 && (f10 = f("com.google.android.gms")) != null) {
                this.f9229d = f10.versionCode;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9229d;
    }

    /* access modifiers changed from: package-private */
    public synchronized int e() {
        int i10 = this.f9230e;
        if (i10 != 0) {
            return i10;
        }
        PackageManager packageManager = this.f9226a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e(Constants.TAG, "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f9230e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w(Constants.TAG, "Failed to resolve IID implementation package, falling back");
            if (PlatformVersion.isAtLeastO()) {
                this.f9230e = 2;
            } else {
                this.f9230e = 1;
            }
            return this.f9230e;
        }
        this.f9230e = 2;
        return 2;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        if (e() != 0) {
            return true;
        }
        return false;
    }
}
