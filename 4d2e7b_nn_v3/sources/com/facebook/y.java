package com.facebook;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q5.p0;

public final class y {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile y f20975d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f20976e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Profile f20977a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalBroadcastManager f20978b;

    /* renamed from: c  reason: collision with root package name */
    private final x f20979c;

    public static final class a {
        private a() {
        }

        public final y a() {
            if (y.f20975d == null) {
                synchronized (this) {
                    try {
                        if (y.f20975d == null) {
                            LocalBroadcastManager instance = LocalBroadcastManager.getInstance(o.f());
                            m.e(instance, "LocalBroadcastManager.ge…tance(applicationContext)");
                            y.f20975d = new y(instance, new x());
                        }
                        Unit unit = Unit.f12577a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            y a10 = y.f20975d;
            if (a10 != null) {
                return a10;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public y(LocalBroadcastManager localBroadcastManager, x xVar) {
        m.f(localBroadcastManager, "localBroadcastManager");
        m.f(xVar, "profileCache");
        this.f20978b = localBroadcastManager;
        this.f20979c = xVar;
    }

    private final void e(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile2);
        this.f20978b.sendBroadcast(intent);
    }

    private final void g(Profile profile, boolean z10) {
        Profile profile2 = this.f20977a;
        this.f20977a = profile;
        if (z10) {
            if (profile != null) {
                this.f20979c.c(profile);
            } else {
                this.f20979c.a();
            }
        }
        if (!p0.c(profile2, profile)) {
            e(profile2, profile);
        }
    }

    public final Profile c() {
        return this.f20977a;
    }

    public final boolean d() {
        Profile b10 = this.f20979c.b();
        if (b10 == null) {
            return false;
        }
        g(b10, false);
        return true;
    }

    public final void f(Profile profile) {
        g(profile, true);
    }
}
