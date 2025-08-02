package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a extends CustomTabsServiceConnection {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static CustomTabsClient f20475a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static CustomTabsSession f20476b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f20477c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static final C0257a f20478d = new C0257a((DefaultConstructorMarker) null);

    /* renamed from: com.facebook.login.a$a  reason: collision with other inner class name */
    public static final class C0257a {
        private C0257a() {
        }

        /* access modifiers changed from: private */
        public final void d() {
            CustomTabsClient a10;
            a.f20477c.lock();
            if (a.f20476b == null && (a10 = a.f20475a) != null) {
                a.f20476b = a10.newSession((CustomTabsCallback) null);
            }
            a.f20477c.unlock();
        }

        public final CustomTabsSession b() {
            a.f20477c.lock();
            CustomTabsSession c10 = a.f20476b;
            a.f20476b = null;
            a.f20477c.unlock();
            return c10;
        }

        public final void c(Uri uri) {
            m.f(uri, ImagesContract.URL);
            d();
            a.f20477c.lock();
            CustomTabsSession c10 = a.f20476b;
            if (c10 != null) {
                c10.mayLaunchUrl(uri, (Bundle) null, (List<Bundle>) null);
            }
            a.f20477c.unlock();
        }

        public /* synthetic */ C0257a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void e(Uri uri) {
        f20478d.c(uri);
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        m.f(componentName, "name");
        m.f(customTabsClient, "newClient");
        customTabsClient.warmup(0);
        f20475a = customTabsClient;
        f20478d.d();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        m.f(componentName, "componentName");
    }
}
