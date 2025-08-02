package com.bugsnag.android;

import c1.p;
import com.bugsnag.android.k2;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class s3 implements k2.a {
    private ErrorType C;

    /* renamed from: a  reason: collision with root package name */
    private String f18992a;

    /* renamed from: b  reason: collision with root package name */
    private String f18993b;

    /* renamed from: c  reason: collision with root package name */
    private Number f18994c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f18995d;

    /* renamed from: e  reason: collision with root package name */
    private Map f18996e;

    /* renamed from: f  reason: collision with root package name */
    private Number f18997f;

    /* renamed from: g  reason: collision with root package name */
    private Long f18998g;

    /* renamed from: h  reason: collision with root package name */
    private Long f18999h;

    /* renamed from: i  reason: collision with root package name */
    private Long f19000i;

    /* renamed from: j  reason: collision with root package name */
    private String f19001j;

    /* renamed from: w  reason: collision with root package name */
    private Boolean f19002w;

    public s3(String str, String str2, Number number, Boolean bool) {
        this(str, str2, number, bool, (Map) null, (Number) null, 48, (DefaultConstructorMarker) null);
    }

    public final String a() {
        return this.f18993b;
    }

    public final Long b() {
        return this.f18998g;
    }

    public final Boolean c() {
        return this.f18995d;
    }

    public final Number d() {
        return this.f18994c;
    }

    public final Long e() {
        return this.f19000i;
    }

    public final String f() {
        return this.f18992a;
    }

    public final Long g() {
        return this.f18999h;
    }

    public final ErrorType h() {
        return this.C;
    }

    public final void i(ErrorType errorType) {
        this.C = errorType;
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        k2Var.v(FirebaseAnalytics.Param.METHOD).K(this.f18992a);
        k2Var.v("file").K(this.f18993b);
        k2Var.v("lineNumber").J(this.f18994c);
        Boolean bool = this.f18995d;
        if (bool != null) {
            k2Var.v("inProject").L(bool.booleanValue());
        }
        k2Var.v("columnNumber").J(this.f18997f);
        if (this.f18998g != null) {
            k2Var.v("frameAddress").K(p.f17266a.h(b()));
        }
        if (this.f18999h != null) {
            k2Var.v("symbolAddress").K(p.f17266a.h(g()));
        }
        if (this.f19000i != null) {
            k2Var.v("loadAddress").K(p.f17266a.h(e()));
        }
        String str = this.f19001j;
        if (str != null) {
            k2Var.v("codeIdentifier").K(str);
        }
        Boolean bool2 = this.f19002w;
        if (bool2 != null) {
            k2Var.v("isPC").L(bool2.booleanValue());
        }
        ErrorType errorType = this.C;
        if (errorType != null) {
            k2Var.v("type").K(errorType.getDesc$bugsnag_android_core_release());
        }
        Map map = this.f18996e;
        if (map != null) {
            k2Var.v(Constant.PARAM_OAUTH_CODE);
            for (Map.Entry entry : map.entrySet()) {
                k2Var.j();
                k2Var.v((String) entry.getKey());
                k2Var.K((String) entry.getValue());
                k2Var.n();
            }
        }
        k2Var.n();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s3(String str, String str2, Number number, Boolean bool, Map map, Number number2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, number, bool, (i10 & 16) != 0 ? null : map, (i10 & 32) != 0 ? null : number2);
    }

    public s3(String str, String str2, Number number, Boolean bool, Map map, Number number2) {
        this.f18992a = str;
        this.f18993b = str2;
        this.f18994c = number;
        this.f18995d = bool;
        this.f18996e = map;
        this.f18997f = number2;
    }

    public s3(NativeStackframe nativeStackframe) {
        this(nativeStackframe.getMethod(), nativeStackframe.getFile(), nativeStackframe.getLineNumber(), (Boolean) null, (Map) null, (Number) null, 32, (DefaultConstructorMarker) null);
        this.f18998g = nativeStackframe.getFrameAddress();
        this.f18999h = nativeStackframe.getSymbolAddress();
        this.f19000i = nativeStackframe.getLoadAddress();
        this.f19001j = nativeStackframe.getCodeIdentifier();
        this.f19002w = nativeStackframe.isPC();
        this.C = nativeStackframe.getType();
    }

    public s3(Map map) {
        Object obj = map.get(FirebaseAnalytics.Param.METHOD);
        ErrorType errorType = null;
        this.f18992a = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("file");
        this.f18993b = obj2 instanceof String ? (String) obj2 : null;
        p pVar = p.f17266a;
        this.f18994c = pVar.e(map.get("lineNumber"));
        Object obj3 = map.get("inProject");
        this.f18995d = obj3 instanceof Boolean ? (Boolean) obj3 : null;
        Object obj4 = map.get("columnNumber");
        this.f18997f = obj4 instanceof Number ? (Number) obj4 : null;
        this.f18998g = pVar.e(map.get("frameAddress"));
        this.f18999h = pVar.e(map.get("symbolAddress"));
        this.f19000i = pVar.e(map.get("loadAddress"));
        Object obj5 = map.get("codeIdentifier");
        this.f19001j = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = map.get("isPC");
        this.f19002w = obj6 instanceof Boolean ? (Boolean) obj6 : null;
        Object obj7 = map.get(Constant.PARAM_OAUTH_CODE);
        this.f18996e = obj7 instanceof Map ? (Map) obj7 : null;
        Object obj8 = map.get("type");
        String str = obj8 instanceof String ? (String) obj8 : null;
        this.C = str != null ? ErrorType.Companion.a(str) : errorType;
    }
}
