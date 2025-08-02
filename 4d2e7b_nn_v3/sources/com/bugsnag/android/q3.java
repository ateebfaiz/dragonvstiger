package com.bugsnag.android;

import com.bugsnag.android.k2;
import com.google.firebase.analytics.FirebaseAnalytics;

final class q3 implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f18944a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18945b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18946c;

    /* renamed from: d  reason: collision with root package name */
    private final Severity f18947d;

    /* renamed from: e  reason: collision with root package name */
    private Severity f18948e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18949f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f18950g;

    q3(String str, Severity severity, boolean z10, boolean z11, String str2, String str3) {
        this.f18944a = str;
        this.f18949f = z10;
        this.f18950g = z11;
        this.f18947d = severity;
        this.f18948e = severity;
        this.f18946c = str2;
        this.f18945b = str3;
    }

    static q3 h(String str) {
        return i(str, (Severity) null, (String) null);
    }

    static q3 i(String str, Severity severity, String str2) {
        if (str.equals("strictMode") && j2.a(str2)) {
            throw new IllegalArgumentException("No reason supplied for strictmode");
        } else if (str.equals("strictMode") || str.equals("log") || j2.a(str2)) {
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1876197364:
                    if (str.equals("strictMode")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1773746641:
                    if (str.equals("userCallbackSetSeverity")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -1591166708:
                    if (str.equals("unhandledException")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case -1107031998:
                    if (str.equals("userSpecifiedSeverity")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case -902467928:
                    if (str.equals("signal")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case -845696980:
                    if (str.equals("handledError")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case -573976797:
                    if (str.equals("anrError")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 107332:
                    if (str.equals("log")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 87505361:
                    if (str.equals("unhandledPromiseRejection")) {
                        c10 = 8;
                        break;
                    }
                    break;
                case 561970291:
                    if (str.equals("handledException")) {
                        c10 = 9;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    return new q3(str, Severity.WARNING, true, true, str2, "violationType");
                case 1:
                case 3:
                    return new q3(str, severity, false, false, (String) null, (String) null);
                case 2:
                case 4:
                case 6:
                case 8:
                    return new q3(str, Severity.ERROR, true, true, (String) null, (String) null);
                case 5:
                case 9:
                    return new q3(str, Severity.WARNING, false, false, (String) null, (String) null);
                case 7:
                    return new q3(str, severity, false, false, str2, FirebaseAnalytics.Param.LEVEL);
                default:
                    throw new IllegalArgumentException("Invalid argument for severityReason: '" + str + '\'');
            }
        } else {
            throw new IllegalArgumentException("attributeValue should not be supplied");
        }
    }

    /* access modifiers changed from: package-private */
    public String a() {
        if (this.f18947d == this.f18948e) {
            return this.f18944a;
        }
        return "userCallbackSetSeverity";
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.f18945b;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f18946c;
    }

    /* access modifiers changed from: package-private */
    public Severity d() {
        return this.f18948e;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.f18944a;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f18949f;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        if (this.f18949f != this.f18950g) {
            return true;
        }
        return false;
    }

    public void toStream(k2 k2Var) {
        k2Var.j().v("type").K(a()).v("unhandledOverridden").L(g());
        if (!(this.f18945b == null || this.f18946c == null)) {
            k2Var.v("attributes").j().v(this.f18945b).K(this.f18946c).n();
        }
        k2Var.n();
    }
}
