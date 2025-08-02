package com.microsoft.codepush.react;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.g0;
import com.facebook.react.m0;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import k6.e;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements m0 {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f10206i = false;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f10207j = false;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f10208k = false;

    /* renamed from: l  reason: collision with root package name */
    private static String f10209l = null;

    /* renamed from: m  reason: collision with root package name */
    private static String f10210m = "https://codepush.appcenter.ms/";

    /* renamed from: n  reason: collision with root package name */
    private static String f10211n;

    /* renamed from: o  reason: collision with root package name */
    private static a f10212o;

    /* renamed from: a  reason: collision with root package name */
    private boolean f10213a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f10214b;

    /* renamed from: c  reason: collision with root package name */
    private h f10215c;

    /* renamed from: d  reason: collision with root package name */
    private f f10216d;

    /* renamed from: e  reason: collision with root package name */
    private o f10217e;

    /* renamed from: f  reason: collision with root package name */
    private String f10218f;

    /* renamed from: g  reason: collision with root package name */
    private Context f10219g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f10220h;

    public a(String str, Context context, boolean z10) {
        this.f10219g = context.getApplicationContext();
        this.f10215c = new h(context.getFilesDir().getAbsolutePath());
        this.f10216d = new f(this.f10219g);
        this.f10218f = str;
        this.f10220h = z10;
        this.f10217e = new o(this.f10219g);
        if (f10209l == null) {
            try {
                f10209l = this.f10219g.getPackageManager().getPackageInfo(this.f10219g.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e10) {
                throw new g("Unable to get package info for " + this.f10219g.getPackageName(), e10);
            }
        }
        f10212o = this;
        String h10 = h("PublicKey");
        if (h10 != null) {
            f10211n = h10;
        }
        String h11 = h("ServerUrl");
        if (h11 != null) {
            f10210m = h11;
        }
        a((g0) null);
        q();
    }

    private String h(String str) {
        String packageName = this.f10219g.getPackageName();
        Resources resources = this.f10219g.getResources();
        int identifier = resources.getIdentifier("CodePush" + str, "string", packageName);
        if (identifier == 0) {
            return null;
        }
        String string = this.f10219g.getString(identifier);
        if (!string.isEmpty()) {
            return string;
        }
        k.h("Specified " + str + " is empty");
        return null;
    }

    public static String j() {
        return k("index.android.bundle");
    }

    public static String k(String str) {
        a aVar = f10212o;
        if (aVar != null) {
            return aVar.l(str);
        }
        throw new e("A CodePush instance has not been created yet. Have you added it to your app's list of ReactPackages?");
    }

    static g0 n() {
        return null;
    }

    private boolean p(JSONObject jSONObject) {
        return !f10209l.equals(jSONObject.optString("appVersion", (String) null));
    }

    private boolean t(g0 g0Var) {
        e D;
        if (!(g0Var == null || (D = g0Var.D()) == null)) {
            x6.a w10 = D.w();
            Method[] methods = w10.getClass().getMethods();
            int length = methods.length;
            int i10 = 0;
            while (i10 < length) {
                Method method = methods[i10];
                if (method.getName().equals("isReloadOnJSChangeEnabled")) {
                    try {
                        return ((Boolean) method.invoke(w10, (Object[]) null)).booleanValue();
                    } catch (Exception unused) {
                        return false;
                    }
                } else {
                    i10++;
                }
            }
        }
        return false;
    }

    private boolean u(JSONObject jSONObject) {
        Long l10;
        try {
            String optString = jSONObject.optString("binaryModifiedTime", (String) null);
            if (optString != null) {
                l10 = Long.valueOf(Long.parseLong(optString));
            } else {
                l10 = null;
            }
            String optString2 = jSONObject.optString("appVersion", (String) null);
            long f10 = f();
            if (l10 == null || l10.longValue() != f10 || (!w() && !f10209l.equals(optString2))) {
                return false;
            }
            return true;
        } catch (NumberFormatException e10) {
            throw new g("Error in reading binary modified date from package metadata", e10);
        }
    }

    public static boolean w() {
        return f10208k;
    }

    private void y() {
        this.f10217e.h(this.f10215c.e());
        this.f10215c.r();
        this.f10217e.g();
    }

    public void a(g0 g0Var) {
        if (this.f10220h && this.f10217e.e((String) null) && !t(g0Var)) {
            File file = new File(this.f10219g.getFilesDir(), "ReactNativeDevBundle.js");
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public void b() {
        this.f10215c.a();
        this.f10217e.g();
        this.f10217e.f();
    }

    public boolean c() {
        return this.f10213a;
    }

    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        CodePushNativeModule codePushNativeModule = new CodePushNativeModule(reactApplicationContext, this, this.f10215c, this.f10216d, this.f10217e);
        CodePushDialog codePushDialog = new CodePushDialog(reactApplicationContext);
        ArrayList arrayList = new ArrayList();
        arrayList.add(codePushNativeModule);
        arrayList.add(codePushDialog);
        return arrayList;
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return new ArrayList();
    }

    public String d() {
        return f10209l;
    }

    public String e() {
        return this.f10214b;
    }

    /* access modifiers changed from: package-private */
    public long f() {
        try {
            return Long.parseLong(this.f10219g.getResources().getString(this.f10219g.getResources().getIdentifier("CODE_PUSH_APK_BUILD_TIME", "string", this.f10219g.getPackageName())).replaceAll("\"", ""));
        } catch (Exception e10) {
            throw new g("Error in getting binary resources modified time", e10);
        }
    }

    public Context g() {
        return this.f10219g;
    }

    public String i() {
        return this.f10218f;
    }

    public String l(String str) {
        String str2;
        this.f10214b = str;
        String str3 = "assets://" + str;
        try {
            str2 = this.f10215c.f(this.f10214b);
        } catch (d e10) {
            k.h(e10.getMessage());
            b();
            str2 = null;
        }
        if (str2 == null) {
            k.j(str3);
            f10206i = true;
            return str3;
        }
        JSONObject e11 = this.f10215c.e();
        if (u(e11)) {
            k.j(str2);
            f10206i = false;
            return str2;
        }
        this.f10213a = false;
        if (!this.f10220h || p(e11)) {
            b();
        }
        k.j(str3);
        f10206i = true;
        return str3;
    }

    public String m() {
        return f10211n;
    }

    public String o() {
        return f10210m;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.f10213a = false;
        JSONObject c10 = this.f10217e.c();
        if (c10 != null) {
            try {
                JSONObject e10 = this.f10215c.e();
                if (e10 == null || (!u(e10) && p(e10))) {
                    k.h("Skipping initializeUpdateAfterRestart(), binary version is newer");
                    return;
                }
                try {
                    if (c10.getBoolean("isLoading")) {
                        k.h("Update did not finish loading the last time, rolling back to a previous version.");
                        f10207j = true;
                        y();
                        return;
                    }
                    this.f10213a = true;
                    this.f10217e.i(c10.getString("hash"), true);
                } catch (JSONException e11) {
                    throw new g("Unable to read pending update metadata stored in SharedPreferences", e11);
                }
            } catch (d e12) {
                k.i(e12);
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        f10212o = null;
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return this.f10220h;
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        return f10206i;
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return f10207j;
    }

    public void z(boolean z10) {
        f10207j = z10;
    }
}
