package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q5.p0;

public final class AuthenticationTokenManager {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static AuthenticationTokenManager f19496d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f19497e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private AuthenticationToken f19498a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalBroadcastManager f19499b;

    /* renamed from: c  reason: collision with root package name */
    private final f f19500c;

    public static final class CurrentAuthenticationTokenChangedBroadcastReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            m.f(context, "context");
            m.f(intent, "intent");
        }
    }

    public static final class a {
        private a() {
        }

        public final AuthenticationTokenManager a() {
            AuthenticationTokenManager a10;
            AuthenticationTokenManager a11 = AuthenticationTokenManager.f19496d;
            if (a11 != null) {
                return a11;
            }
            synchronized (this) {
                a10 = AuthenticationTokenManager.f19496d;
                if (a10 == null) {
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(o.f());
                    m.e(instance, "LocalBroadcastManager.ge…tance(applicationContext)");
                    AuthenticationTokenManager authenticationTokenManager = new AuthenticationTokenManager(instance, new f());
                    AuthenticationTokenManager.f19496d = authenticationTokenManager;
                    a10 = authenticationTokenManager;
                }
            }
            return a10;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AuthenticationTokenManager(LocalBroadcastManager localBroadcastManager, f fVar) {
        m.f(localBroadcastManager, "localBroadcastManager");
        m.f(fVar, "authenticationTokenCache");
        this.f19499b = localBroadcastManager;
        this.f19500c = fVar;
    }

    private final void d(AuthenticationToken authenticationToken, AuthenticationToken authenticationToken2) {
        Intent intent = new Intent(o.f(), CurrentAuthenticationTokenChangedBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_AUTHENTICATION_TOKEN", authenticationToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_AUTHENTICATION_TOKEN", authenticationToken2);
        this.f19499b.sendBroadcast(intent);
    }

    private final void f(AuthenticationToken authenticationToken, boolean z10) {
        AuthenticationToken c10 = c();
        this.f19498a = authenticationToken;
        if (z10) {
            if (authenticationToken != null) {
                this.f19500c.b(authenticationToken);
            } else {
                this.f19500c.a();
                p0.h(o.f());
            }
        }
        if (!p0.c(c10, authenticationToken)) {
            d(c10, authenticationToken);
        }
    }

    public final AuthenticationToken c() {
        return this.f19498a;
    }

    public final void e(AuthenticationToken authenticationToken) {
        f(authenticationToken, true);
    }
}
