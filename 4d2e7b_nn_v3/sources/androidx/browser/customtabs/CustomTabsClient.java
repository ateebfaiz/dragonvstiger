package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.alibaba.pdns.s.e.c;
import java.util.ArrayList;
import java.util.List;
import z.a;

public class CustomTabsClient {
    private final z.b mService;
    private final ComponentName mServiceComponentName;

    static class a extends CustomTabsServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f14428a;

        a(Context context) {
            this.f14428a = context;
        }

        public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            customTabsClient.warmup(0);
            this.f14428a.unbindService(this);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    class b extends a.C0358a {

        /* renamed from: a  reason: collision with root package name */
        private Handler f14429a = new Handler(Looper.getMainLooper());

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CustomTabsCallback f14430b;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f14432a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Bundle f14433b;

            a(int i10, Bundle bundle) {
                this.f14432a = i10;
                this.f14433b = bundle;
            }

            public void run() {
                b.this.f14430b.onNavigationEvent(this.f14432a, this.f14433b);
            }
        }

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$b$b  reason: collision with other inner class name */
        class C0182b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f14435a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Bundle f14436b;

            C0182b(String str, Bundle bundle) {
                this.f14435a = str;
                this.f14436b = bundle;
            }

            public void run() {
                b.this.f14430b.extraCallback(this.f14435a, this.f14436b);
            }
        }

        class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Bundle f14438a;

            c(Bundle bundle) {
                this.f14438a = bundle;
            }

            public void run() {
                b.this.f14430b.onMessageChannelReady(this.f14438a);
            }
        }

        class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f14440a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Bundle f14441b;

            d(String str, Bundle bundle) {
                this.f14440a = str;
                this.f14441b = bundle;
            }

            public void run() {
                b.this.f14430b.onPostMessage(this.f14440a, this.f14441b);
            }
        }

        class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f14443a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Uri f14444b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f14445c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Bundle f14446d;

            e(int i10, Uri uri, boolean z10, Bundle bundle) {
                this.f14443a = i10;
                this.f14444b = uri;
                this.f14445c = z10;
                this.f14446d = bundle;
            }

            public void run() {
                b.this.f14430b.onRelationshipValidationResult(this.f14443a, this.f14444b, this.f14445c, this.f14446d);
            }
        }

        b(CustomTabsCallback customTabsCallback) {
            this.f14430b = customTabsCallback;
        }

        public void C(int i10, Bundle bundle) {
            if (this.f14430b != null) {
                this.f14429a.post(new a(i10, bundle));
            }
        }

        public void D(String str, Bundle bundle) {
            if (this.f14430b != null) {
                this.f14429a.post(new d(str, bundle));
            }
        }

        public void E(Bundle bundle) {
            if (this.f14430b != null) {
                this.f14429a.post(new c(bundle));
            }
        }

        public void H(int i10, Uri uri, boolean z10, Bundle bundle) {
            if (this.f14430b != null) {
                this.f14429a.post(new e(i10, uri, z10, bundle));
            }
        }

        public void z(String str, Bundle bundle) {
            if (this.f14430b != null) {
                this.f14429a.post(new C0182b(str, bundle));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CustomTabsClient(z.b bVar, ComponentName componentName) {
        this.mService = bVar;
        this.mServiceComponentName = componentName;
    }

    public static boolean bindCustomTabsService(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    public static boolean connectAndInitialize(Context context, String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return bindCustomTabsService(applicationContext, str, new a(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static String getPackageName(Context context, @Nullable List<String> list) {
        return getPackageName(context, list, false);
    }

    public Bundle extraCommand(String str, Bundle bundle) {
        try {
            return this.mService.l(str, bundle);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public CustomTabsSession newSession(CustomTabsCallback customTabsCallback) {
        b bVar = new b(customTabsCallback);
        try {
            if (!this.mService.G(bVar)) {
                return null;
            }
            return new CustomTabsSession(this.mService, bVar, this.mServiceComponentName);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public boolean warmup(long j10) {
        try {
            return this.mService.r(j10);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public static String getPackageName(Context context, @Nullable List<String> list, boolean z10) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = list == null ? new ArrayList() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(c.f18246k));
        if (!z10 && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        for (String next : arrayList) {
            intent2.setPackage(next);
            if (packageManager.resolveService(intent2, 0) != null) {
                return next;
            }
        }
        return null;
    }
}
