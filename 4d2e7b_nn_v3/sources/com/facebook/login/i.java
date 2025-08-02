package com.facebook.login;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.browser.customtabs.CustomTabsClient;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookActivity;
import com.facebook.Profile;
import com.facebook.j;
import com.facebook.l;
import com.facebook.login.LoginClient;
import com.facebook.o;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import q5.d;
import q5.q0;
import q5.u;

public class i {

    /* renamed from: j  reason: collision with root package name */
    private static final Set f20514j = f();

    /* renamed from: k  reason: collision with root package name */
    private static final String f20515k = i.class.toString();

    /* renamed from: l  reason: collision with root package name */
    private static volatile i f20516l;

    /* renamed from: a  reason: collision with root package name */
    private e f20517a = e.NATIVE_WITH_FALLBACK;

    /* renamed from: b  reason: collision with root package name */
    private b f20518b = b.FRIENDS;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f20519c;

    /* renamed from: d  reason: collision with root package name */
    private String f20520d = "rerequest";

    /* renamed from: e  reason: collision with root package name */
    private String f20521e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20522f;

    /* renamed from: g  reason: collision with root package name */
    private k f20523g = k.FACEBOOK;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20524h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20525i = false;

    class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f20526a;

        a(j jVar) {
            this.f20526a = jVar;
        }

        public boolean a(int i10, Intent intent) {
            return i.this.s(i10, intent, this.f20526a);
        }
    }

    static class b extends HashSet {
        b() {
            add("ads_management");
            add("create_event");
            add("rsvp_event");
        }
    }

    class c implements d.a {
        c() {
        }

        public boolean a(int i10, Intent intent) {
            return i.this.r(i10, intent);
        }
    }

    private static class d implements u {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f20529a;

        d(Activity activity) {
            q0.m(activity, "activity");
            this.f20529a = activity;
        }

        public Activity a() {
            return this.f20529a;
        }

        public void startActivityForResult(Intent intent, int i10) {
            this.f20529a.startActivityForResult(intent, i10);
        }
    }

    private static class e implements u {

        /* renamed from: a  reason: collision with root package name */
        private ActivityResultRegistryOwner f20530a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public com.facebook.g f20531b;

        class a extends ActivityResultContract {
            a() {
            }

            /* renamed from: a */
            public Pair parseResult(int i10, Intent intent) {
                return Pair.create(Integer.valueOf(i10), intent);
            }

            public Intent createIntent(Context context, Intent intent) {
                return intent;
            }
        }

        class b {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public ActivityResultLauncher f20533a = null;

            b() {
            }
        }

        class c implements ActivityResultCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f20535a;

            c(b bVar) {
                this.f20535a = bVar;
            }

            /* renamed from: a */
            public void onActivityResult(Pair pair) {
                e.this.f20531b.a(d.c.Login.a(), ((Integer) pair.first).intValue(), (Intent) pair.second);
                if (this.f20535a.f20533a != null) {
                    this.f20535a.f20533a.unregister();
                    ActivityResultLauncher unused = this.f20535a.f20533a = null;
                }
            }
        }

        e(ActivityResultRegistryOwner activityResultRegistryOwner, com.facebook.g gVar) {
            this.f20530a = activityResultRegistryOwner;
            this.f20531b = gVar;
        }

        public Activity a() {
            ActivityResultRegistryOwner activityResultRegistryOwner = this.f20530a;
            if (activityResultRegistryOwner instanceof Activity) {
                return (Activity) activityResultRegistryOwner;
            }
            return null;
        }

        public void startActivityForResult(Intent intent, int i10) {
            b bVar = new b();
            ActivityResultLauncher unused = bVar.f20533a = this.f20530a.getActivityResultRegistry().register("facebook-login", new a(), new c(bVar));
            bVar.f20533a.launch(intent);
        }
    }

    private static class f implements u {

        /* renamed from: a  reason: collision with root package name */
        private final u f20537a;

        f(u uVar) {
            q0.m(uVar, "fragment");
            this.f20537a = uVar;
        }

        public Activity a() {
            return this.f20537a.a();
        }

        public void startActivityForResult(Intent intent, int i10) {
            this.f20537a.d(intent, i10);
        }
    }

    private static class g {

        /* renamed from: a  reason: collision with root package name */
        private static h f20538a;

        /* access modifiers changed from: private */
        public static synchronized h b(Context context) {
            synchronized (g.class) {
                if (context == null) {
                    try {
                        context = o.f();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (context == null) {
                    return null;
                }
                if (f20538a == null) {
                    f20538a = new h(context, o.g());
                }
                h hVar = f20538a;
                return hVar;
            }
        }
    }

    i() {
        q0.o();
        this.f20519c = o.f().getSharedPreferences("com.facebook.loginManager", 0);
        if (o.f20687p && q5.f.a() != null) {
            CustomTabsClient.bindCustomTabsService(o.f(), "com.android.chrome", new a());
            CustomTabsClient.connectAndInitialize(o.f(), o.f().getPackageName());
        }
    }

    private void E(u uVar, LoginClient.Request request) {
        q(uVar.a(), request);
        q5.d.d(d.c.Login.a(), new c());
        if (!F(uVar, request)) {
            l lVar = new l("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            h(uVar.a(), LoginClient.Result.b.ERROR, (Map) null, lVar, false, request);
            throw lVar;
        }
    }

    private boolean F(u uVar, LoginClient.Request request) {
        Intent d10 = d(request);
        if (!u(d10)) {
            return false;
        }
        try {
            uVar.startActivityForResult(d10, LoginClient.p());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private void G(Collection collection) {
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (g(str)) {
                    throw new l(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[]{str}));
                }
            }
        }
    }

    static j a(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
        Set k10 = request.k();
        HashSet hashSet = new HashSet(accessToken.k());
        if (request.p()) {
            hashSet.retainAll(k10);
        }
        HashSet hashSet2 = new HashSet(k10);
        hashSet2.removeAll(hashSet);
        return new j(accessToken, authenticationToken, hashSet, hashSet2);
    }

    private void c(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, l lVar, boolean z10, j jVar) {
        j jVar2;
        if (accessToken != null) {
            AccessToken.s(accessToken);
            Profile.b();
        }
        if (authenticationToken != null) {
            AuthenticationToken.b(authenticationToken);
        }
        if (jVar != null) {
            if (accessToken != null) {
                jVar2 = a(request, accessToken, authenticationToken);
            } else {
                jVar2 = null;
            }
            if (z10 || (jVar2 != null && jVar2.b().size() == 0)) {
                jVar.onCancel();
            } else if (lVar != null) {
                jVar.a(lVar);
            } else if (accessToken != null) {
                x(true);
                jVar.onSuccess(jVar2);
            }
        }
    }

    public static i e() {
        if (f20516l == null) {
            synchronized (i.class) {
                try {
                    if (f20516l == null) {
                        f20516l = new i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f20516l;
    }

    private static Set f() {
        return Collections.unmodifiableSet(new b());
    }

    static boolean g(String str) {
        if (str == null || (!str.startsWith("publish") && !str.startsWith("manage") && !f20514j.contains(str))) {
            return false;
        }
        return true;
    }

    private void h(Context context, LoginClient.Result.b bVar, Map map, Exception exc, boolean z10, LoginClient.Request request) {
        String str;
        h a10 = g.b(context);
        if (a10 != null) {
            String str2 = "fb_mobile_login_complete";
            if (request == null) {
                a10.i(str2, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
                return;
            }
            HashMap hashMap = new HashMap();
            if (z10) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("try_login_activity", str);
            String b10 = request.b();
            if (request.n()) {
                str2 = "foa_mobile_login_complete";
            }
            a10.f(b10, hashMap, bVar, map, exc, str2);
        }
    }

    private void q(Context context, LoginClient.Request request) {
        String str;
        h a10 = g.b(context);
        if (a10 != null && request != null) {
            if (request.n()) {
                str = "foa_mobile_login_start";
            } else {
                str = "fb_mobile_login_start";
            }
            a10.h(request, str);
        }
    }

    private boolean u(Intent intent) {
        if (o.f().getPackageManager().resolveActivity(intent, 0) != null) {
            return true;
        }
        return false;
    }

    private void x(boolean z10) {
        SharedPreferences.Editor edit = this.f20519c.edit();
        edit.putBoolean("express_login_allowed", z10);
        edit.apply();
    }

    public i A(k kVar) {
        this.f20523g = kVar;
        return this;
    }

    public i B(String str) {
        this.f20521e = str;
        return this;
    }

    public i C(boolean z10) {
        this.f20522f = z10;
        return this;
    }

    public i D(boolean z10) {
        this.f20525i = z10;
        return this;
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request b(f fVar) {
        HashSet hashSet;
        e eVar = this.f20517a;
        if (fVar.b() != null) {
            hashSet = new HashSet(fVar.b());
        } else {
            hashSet = new HashSet();
        }
        LoginClient.Request request = new LoginClient.Request(eVar, Collections.unmodifiableSet(hashSet), this.f20518b, this.f20520d, o.g(), UUID.randomUUID().toString(), this.f20523g, fVar.a());
        request.u(AccessToken.o());
        request.s(this.f20521e);
        request.v(this.f20522f);
        request.r(this.f20524h);
        request.w(this.f20525i);
        return request;
    }

    /* access modifiers changed from: protected */
    public Intent d(LoginClient.Request request) {
        Intent intent = new Intent();
        intent.setClass(o.f(), FacebookActivity.class);
        intent.setAction(request.g().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        return intent;
    }

    public void i(Activity activity, f fVar) {
        if (activity instanceof ActivityResultRegistryOwner) {
            Log.w(f20515k, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        E(new d(activity), b(fVar));
    }

    public void j(Activity activity, Collection collection, String str) {
        LoginClient.Request b10 = b(new f(collection));
        b10.q(str);
        E(new d(activity), b10);
    }

    public void k(Fragment fragment, Collection collection, String str) {
        n(new u(fragment), collection, str);
    }

    public void l(ActivityResultRegistryOwner activityResultRegistryOwner, com.facebook.g gVar, Collection collection, String str) {
        LoginClient.Request b10 = b(new f(collection));
        b10.q(str);
        E(new e(activityResultRegistryOwner, gVar), b10);
    }

    public void m(androidx.fragment.app.Fragment fragment, Collection collection, String str) {
        n(new u(fragment), collection, str);
    }

    public void n(u uVar, Collection collection, String str) {
        LoginClient.Request b10 = b(new f(collection));
        b10.q(str);
        E(new f(uVar), b10);
    }

    public void o(Activity activity, Collection collection) {
        G(collection);
        i(activity, new f(collection));
    }

    public void p() {
        AccessToken.s((AccessToken) null);
        AuthenticationToken.b((AuthenticationToken) null);
        Profile.g((Profile) null);
        x(false);
    }

    /* access modifiers changed from: package-private */
    public boolean r(int i10, Intent intent) {
        return s(i10, intent, (j) null);
    }

    /* access modifiers changed from: package-private */
    public boolean s(int i10, Intent intent, j jVar) {
        boolean z10;
        Map map;
        LoginClient.Result.b bVar;
        LoginClient.Request request;
        AuthenticationToken authenticationToken;
        AccessToken accessToken;
        AuthenticationToken authenticationToken2;
        boolean z11;
        LoginClient.Request request2;
        Map map2;
        int i11 = i10;
        Intent intent2 = intent;
        LoginClient.Result.b bVar2 = LoginClient.Result.b.ERROR;
        l lVar = null;
        boolean z12 = false;
        if (intent2 != null) {
            intent2.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent2.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                LoginClient.Request request3 = result.f20452f;
                LoginClient.Result.b bVar3 = result.f20447a;
                if (i11 != -1) {
                    if (i11 == 0) {
                        z12 = true;
                    }
                    accessToken = null;
                    authenticationToken2 = null;
                } else if (bVar3 == LoginClient.Result.b.SUCCESS) {
                    accessToken = result.f20448b;
                    authenticationToken2 = result.f20449c;
                } else {
                    authenticationToken2 = null;
                    lVar = new com.facebook.i(result.f20450d);
                    accessToken = null;
                }
                map2 = result.f20453g;
                boolean z13 = z12;
                request2 = request3;
                bVar2 = bVar3;
                z11 = z13;
            } else {
                accessToken = null;
                map2 = null;
                authenticationToken2 = null;
                z11 = false;
                request2 = null;
            }
            map = map2;
            z10 = z11;
            authenticationToken = authenticationToken2;
            bVar = bVar2;
            request = request2;
        } else if (i11 == 0) {
            bVar = LoginClient.Result.b.CANCEL;
            z10 = true;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
        } else {
            bVar = bVar2;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
            z10 = false;
        }
        if (lVar == null && accessToken == null && !z10) {
            lVar = new l("Unexpected call to LoginManager.onActivityResult");
        }
        l lVar2 = lVar;
        LoginClient.Request request4 = request;
        h((Context) null, bVar, map, lVar2, true, request4);
        c(accessToken, authenticationToken, request4, lVar2, z10, jVar);
        return true;
    }

    public void t(com.facebook.g gVar, j jVar) {
        if (gVar instanceof q5.d) {
            ((q5.d) gVar).c(d.c.Login.a(), new a(jVar));
            return;
        }
        throw new l("Unexpected CallbackManager, please use the provided Factory.");
    }

    public i v(String str) {
        this.f20520d = str;
        return this;
    }

    public i w(b bVar) {
        this.f20518b = bVar;
        return this;
    }

    public i y(boolean z10) {
        this.f20524h = z10;
        return this;
    }

    public i z(e eVar) {
        this.f20517a = eVar;
        return this;
    }
}
