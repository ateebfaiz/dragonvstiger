package com.linecorp.linesdk.auth.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import com.google.firebase.messaging.Constants;
import com.linecorp.linesdk.LineApiError;
import com.linecorp.linesdk.auth.LineAuthenticationConfig;
import com.linecorp.linesdk.auth.LineAuthenticationParams;
import com.zing.zalo.zalosdk.common.Constant;
import i9.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k9.h;
import n9.d;
import org.json.JSONException;
import org.json.JSONObject;

class a {

    /* renamed from: b  reason: collision with root package name */
    private static final b f10054b = new b(6, 9, 0);

    /* renamed from: a  reason: collision with root package name */
    private final LineAuthenticationStatus f10055a;

    /* renamed from: com.linecorp.linesdk.auth.internal.a$a  reason: collision with other inner class name */
    static class C0114a {

        /* renamed from: a  reason: collision with root package name */
        private final Intent f10056a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f10057b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final boolean f10058c;

        C0114a(Intent intent, Bundle bundle, boolean z10) {
            this.f10056a = intent;
            this.f10057b = bundle;
            this.f10058c = z10;
        }

        public Intent b() {
            return this.f10056a;
        }

        public Bundle c() {
            return this.f10057b;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Intent f10059a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f10060b;

        /* renamed from: c  reason: collision with root package name */
        private final String f10061c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f10062d;

        b(Intent intent, Bundle bundle, String str, boolean z10) {
            this.f10059a = intent;
            this.f10060b = bundle;
            this.f10061c = str;
            this.f10062d = z10;
        }

        /* access modifiers changed from: package-private */
        public Intent a() {
            return this.f10059a;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.f10061c;
        }

        /* access modifiers changed from: package-private */
        public Bundle c() {
            return this.f10060b;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.f10062d;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f10063a;

        /* renamed from: b  reason: collision with root package name */
        private final Boolean f10064b;

        /* renamed from: c  reason: collision with root package name */
        private final String f10065c;

        /* renamed from: d  reason: collision with root package name */
        private final String f10066d;

        /* renamed from: e  reason: collision with root package name */
        private final String f10067e;

        private c(String str, Boolean bool, String str2, String str3, String str4) {
            this.f10063a = str;
            this.f10064b = bool;
            this.f10065c = str2;
            this.f10066d = str3;
            this.f10067e = str4;
        }

        private void a() {
            if (TextUtils.isEmpty(this.f10063a)) {
                throw new UnsupportedOperationException("requestToken is null. Please check result by isSuccess before.");
            }
        }

        static c b(String str, String str2) {
            return new c((String) null, (Boolean) null, str, str2, (String) null);
        }

        static c c(String str) {
            return new c((String) null, (Boolean) null, (String) null, (String) null, str);
        }

        static c d(String str, Boolean bool) {
            return new c(str, bool, (String) null, (String) null, (String) null);
        }

        /* access modifiers changed from: package-private */
        public Boolean e() {
            a();
            return this.f10064b;
        }

        /* access modifiers changed from: package-private */
        public LineApiError f() {
            if (!h()) {
                return new LineApiError(this.f10067e);
            }
            try {
                return new LineApiError(new JSONObject().putOpt(Constants.IPC_BUNDLE_KEY_SEND_ERROR, this.f10065c).putOpt("error_description", this.f10066d).toString());
            } catch (JSONException e10) {
                return new LineApiError((Exception) e10);
            }
        }

        /* access modifiers changed from: package-private */
        public String g() {
            a();
            return this.f10063a;
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            if (!TextUtils.isEmpty(this.f10067e) || i()) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return !TextUtils.isEmpty(this.f10063a);
        }
    }

    a(LineAuthenticationStatus lineAuthenticationStatus) {
        this.f10055a = lineAuthenticationStatus;
    }

    private static List a(Uri uri, Collection collection, Bundle bundle) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setPackage(((ResolveInfo) it.next()).activityInfo.packageName);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            arrayList.add(intent);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Uri b(LineAuthenticationConfig lineAuthenticationConfig, h hVar, LineAuthenticationParams lineAuthenticationParams, String str, String str2, String str3) {
        Map d10 = d.d("response_type", Constant.PARAM_OAUTH_CODE, "client_id", lineAuthenticationConfig.b(), "state", str, "otpId", hVar.a(), "redirect_uri", str3, "sdk_ver", "5.3.1", "scope", k.d(lineAuthenticationParams.c()));
        if (!TextUtils.isEmpty(str2)) {
            d10.put("nonce", str2);
        }
        if (lineAuthenticationParams.a() != null) {
            d10.put("bot_prompt", lineAuthenticationParams.a().name().toLowerCase());
        }
        Map d11 = d.d("returnUri", d.c("/oauth2/v2.1/authorize/consent", d10).toString(), "loginChannelId", lineAuthenticationConfig.b());
        if (lineAuthenticationParams.d() != null) {
            d11.put("ui_locales", lineAuthenticationParams.d().toString());
        }
        return d.b(lineAuthenticationConfig.d(), d11);
    }

    /* access modifiers changed from: package-private */
    public String c(Context context) {
        return "intent://result#Intent;package=" + context.getPackageName() + ";scheme=lineauth;end";
    }

    /* access modifiers changed from: package-private */
    public C0114a d(Context context, Uri uri, boolean z10) {
        Intent intent;
        Bundle bundle;
        if (g()) {
            CustomTabsIntent build = new CustomTabsIntent.Builder().setToolbarColor(ContextCompat.getColor(context, 17170443)).build();
            intent = build.intent.setData(uri);
            bundle = build.startAnimationBundle;
        } else {
            intent = new Intent("android.intent.action.VIEW").setData(uri);
            bundle = null;
        }
        b a10 = b.a(context);
        if (a10 == null) {
            return new C0114a(intent, bundle, false);
        }
        if (z10 || !a10.b(f10054b)) {
            List a11 = a(uri, context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(com.alibaba.pdns.s.e.c.f18246k)), 0), intent.getExtras());
            int size = a11.size();
            if (size == 0) {
                throw new ActivityNotFoundException("Activity for LINE log-in is not found. uri=" + uri);
            } else if (size == 1) {
                return new C0114a((Intent) a11.get(0), bundle, false);
            } else {
                Intent createChooser = Intent.createChooser((Intent) a11.remove(0), (CharSequence) null);
                createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) a11.toArray(new Parcelable[a11.size()]));
                return new C0114a(createChooser, bundle, false);
            }
        } else {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(uri);
            intent2.setPackage("jp.naver.line.android");
            return new C0114a(intent2, bundle, true);
        }
    }

    /* access modifiers changed from: package-private */
    public c e(Intent intent) {
        Boolean bool;
        Uri data = intent.getData();
        if (data == null) {
            return c.c("Illegal redirection from external application.");
        }
        String d10 = this.f10055a.d();
        String queryParameter = data.getQueryParameter("state");
        if (d10 == null || !d10.equals(queryParameter)) {
            return c.c("Illegal parameter value of 'state'.");
        }
        String queryParameter2 = data.getQueryParameter(Constant.PARAM_OAUTH_CODE);
        String queryParameter3 = data.getQueryParameter("friendship_status_changed");
        if (!TextUtils.isEmpty(queryParameter3)) {
            bool = Boolean.valueOf(Boolean.parseBoolean(queryParameter3));
        } else {
            bool = null;
        }
        if (!TextUtils.isEmpty(queryParameter2)) {
            return c.d(queryParameter2, bool);
        }
        return c.b(data.getQueryParameter(Constants.IPC_BUNDLE_KEY_SEND_ERROR), data.getQueryParameter("error_description"));
    }

    /* access modifiers changed from: package-private */
    public b f(Context context, LineAuthenticationConfig lineAuthenticationConfig, h hVar, LineAuthenticationParams lineAuthenticationParams) {
        String str;
        String a10 = g9.a.a(8);
        this.f10055a.i(a10);
        if (!lineAuthenticationParams.c().contains(k.f12372g)) {
            str = null;
        } else if (!TextUtils.isEmpty(lineAuthenticationParams.b())) {
            str = lineAuthenticationParams.b();
        } else {
            str = g9.a.a(8);
        }
        String str2 = str;
        this.f10055a.k(str2);
        String c10 = c(context);
        C0114a d10 = d(context, b(lineAuthenticationConfig, hVar, lineAuthenticationParams, a10, str2, c10), lineAuthenticationConfig.f());
        return new b(d10.b(), d10.c(), c10, d10.f10058c);
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return true;
    }
}
