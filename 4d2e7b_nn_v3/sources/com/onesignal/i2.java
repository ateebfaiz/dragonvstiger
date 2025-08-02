package com.onesignal;

import android.content.Context;
import android.net.Uri;
import java.security.SecureRandom;
import org.json.JSONObject;

public class i2 {

    /* renamed from: a  reason: collision with root package name */
    private d2 f10680a;

    /* renamed from: b  reason: collision with root package name */
    private Context f10681b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f10682c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10683d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10684e;

    /* renamed from: f  reason: collision with root package name */
    private Long f10685f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f10686g;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f10687h;

    /* renamed from: i  reason: collision with root package name */
    private Uri f10688i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f10689j;

    /* renamed from: k  reason: collision with root package name */
    private Integer f10690k;

    /* renamed from: l  reason: collision with root package name */
    private Uri f10691l;

    i2(Context context) {
        this.f10681b = context;
    }

    /* access modifiers changed from: package-private */
    public Integer a() {
        return Integer.valueOf(this.f10680a.d());
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return o3.f0(this.f10682c);
    }

    /* access modifiers changed from: package-private */
    public CharSequence c() {
        CharSequence charSequence = this.f10686g;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f10680a.e();
    }

    public Context d() {
        return this.f10681b;
    }

    public JSONObject e() {
        return this.f10682c;
    }

    public d2 f() {
        return this.f10680a;
    }

    public Uri g() {
        return this.f10691l;
    }

    public Integer h() {
        return this.f10689j;
    }

    public Uri i() {
        return this.f10688i;
    }

    public Long j() {
        return this.f10685f;
    }

    /* access modifiers changed from: package-private */
    public CharSequence k() {
        CharSequence charSequence = this.f10687h;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f10680a.k();
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        if (this.f10680a.f() != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f10684e;
    }

    public boolean n() {
        return this.f10683d;
    }

    public void o(Context context) {
        this.f10681b = context;
    }

    /* access modifiers changed from: package-private */
    public void p(boolean z10) {
        this.f10684e = z10;
    }

    public void q(JSONObject jSONObject) {
        this.f10682c = jSONObject;
    }

    public void r(d2 d2Var) {
        if (d2Var != null && !d2Var.m()) {
            d2 d2Var2 = this.f10680a;
            if (d2Var2 == null || !d2Var2.m()) {
                d2Var.r(new SecureRandom().nextInt());
            } else {
                d2Var.r(this.f10680a.d());
            }
        }
        this.f10680a = d2Var;
    }

    public void s(Integer num) {
        this.f10690k = num;
    }

    public void t(Uri uri) {
        this.f10691l = uri;
    }

    public String toString() {
        return "OSNotificationGenerationJob{jsonPayload=" + this.f10682c + ", isRestoring=" + this.f10683d + ", isNotificationToDisplay=" + this.f10684e + ", shownTimeStamp=" + this.f10685f + ", overriddenBodyFromExtender=" + this.f10686g + ", overriddenTitleFromExtender=" + this.f10687h + ", overriddenSound=" + this.f10688i + ", overriddenFlags=" + this.f10689j + ", orgFlags=" + this.f10690k + ", orgSound=" + this.f10691l + ", notification=" + this.f10680a + '}';
    }

    public void u(CharSequence charSequence) {
        this.f10686g = charSequence;
    }

    public void v(Integer num) {
        this.f10689j = num;
    }

    public void w(Uri uri) {
        this.f10688i = uri;
    }

    public void x(CharSequence charSequence) {
        this.f10687h = charSequence;
    }

    public void y(boolean z10) {
        this.f10683d = z10;
    }

    public void z(Long l10) {
        this.f10685f = l10;
    }

    i2(Context context, JSONObject jSONObject) {
        this(context, new d2(jSONObject), jSONObject);
    }

    i2(Context context, d2 d2Var, JSONObject jSONObject) {
        this.f10681b = context;
        this.f10682c = jSONObject;
        r(d2Var);
    }
}
