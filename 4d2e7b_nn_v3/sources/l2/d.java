package l2;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import e2.g;
import e2.m;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import q5.q;
import q5.q0;
import q5.r;
import q5.s;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22418a = d.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    private static final m f22419b = new m(o.f());

    /* renamed from: c  reason: collision with root package name */
    public static final d f22420c = new d();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private BigDecimal f22421a;

        /* renamed from: b  reason: collision with root package name */
        private Currency f22422b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f22423c;

        public a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
            kotlin.jvm.internal.m.f(bigDecimal, "purchaseAmount");
            kotlin.jvm.internal.m.f(currency, FirebaseAnalytics.Param.CURRENCY);
            kotlin.jvm.internal.m.f(bundle, "param");
            this.f22421a = bigDecimal;
            this.f22422b = currency;
            this.f22423c = bundle;
        }

        public final Currency a() {
            return this.f22422b;
        }

        public final Bundle b() {
            return this.f22423c;
        }

        public final BigDecimal c() {
            return this.f22421a;
        }
    }

    private d() {
    }

    private final a a(String str, String str2) {
        return b(str, str2, new HashMap());
    }

    private final a b(String str, String str2, Map map) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_iap_product_id", jSONObject.getString("productId"));
            bundle.putCharSequence("fb_iap_purchase_time", jSONObject.getString("purchaseTime"));
            bundle.putCharSequence("fb_iap_purchase_token", jSONObject.getString("purchaseToken"));
            bundle.putCharSequence("fb_iap_package_name", jSONObject.optString("packageName"));
            bundle.putCharSequence("fb_iap_product_title", jSONObject2.optString("title"));
            bundle.putCharSequence("fb_iap_product_description", jSONObject2.optString("description"));
            String optString = jSONObject2.optString("type");
            bundle.putCharSequence("fb_iap_product_type", optString);
            if (kotlin.jvm.internal.m.b(optString, "subs")) {
                bundle.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence("fb_iap_subs_period", jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence("fb_free_trial_period", jSONObject2.optString("freeTrialPeriod"));
                String optString2 = jSONObject2.optString("introductoryPriceCycles");
                kotlin.jvm.internal.m.e(optString2, "introductoryPriceCycles");
                if (optString2.length() != 0) {
                    bundle.putCharSequence("fb_intro_price_amount_micros", jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence("fb_intro_price_cycles", optString2);
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                bundle.putCharSequence((String) entry.getKey(), (String) entry.getValue());
            }
            BigDecimal bigDecimal = new BigDecimal(((double) jSONObject2.getLong("price_amount_micros")) / 1000000.0d);
            Currency instance = Currency.getInstance(jSONObject2.getString("price_currency_code"));
            kotlin.jvm.internal.m.e(instance, "Currency.getInstance(sku…g(\"price_currency_code\"))");
            return new a(bigDecimal, instance, bundle);
        } catch (JSONException e10) {
            Log.e(f22418a, "Error parsing in-app subscription data.", e10);
            return null;
        }
    }

    public static final boolean c() {
        r j10 = s.j(o.g());
        if (j10 == null || !o.k() || !j10.f()) {
            return false;
        }
        return true;
    }

    public static final void d() {
        Context f10 = o.f();
        String g10 = o.g();
        boolean k10 = o.k();
        q0.m(f10, "context");
        if (!k10) {
            return;
        }
        if (f10 instanceof Application) {
            g.f21166c.a((Application) f10, g10);
        } else {
            Log.w(f22418a, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
        }
    }

    public static final void e(String str, long j10) {
        Context f10 = o.f();
        String g10 = o.g();
        q0.m(f10, "context");
        r o10 = s.o(g10, false);
        if (o10 != null && o10.a() && j10 > 0) {
            m mVar = new m(f10);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_aa_time_spent_view_name", str);
            mVar.c("fb_aa_time_spent_on_view", (double) j10, bundle);
        }
    }

    public static final void f(String str, String str2, boolean z10) {
        a a10;
        String str3;
        kotlin.jvm.internal.m.f(str, FirebaseAnalytics.Event.PURCHASE);
        kotlin.jvm.internal.m.f(str2, "skuDetails");
        if (!c() || (a10 = f22420c.a(str, str2)) == null) {
            return;
        }
        if (!z10 || !q.f("app_events_if_auto_log_subs", o.g(), false)) {
            f22419b.j(a10.c(), a10.a(), a10.b());
            return;
        }
        if (j2.d.f22188f.m(str2)) {
            str3 = "StartTrial";
        } else {
            str3 = "Subscribe";
        }
        f22419b.i(str3, a10.c(), a10.a(), a10.b());
    }
}
