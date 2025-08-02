package com.bugsnag.android;

import com.bugsnag.android.k2;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class e3 implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private String f18717a;

    /* renamed from: b  reason: collision with root package name */
    private String f18718b;

    /* renamed from: c  reason: collision with root package name */
    private String f18719c;

    /* renamed from: d  reason: collision with root package name */
    private List f18720d;

    public e3(String str, String str2, String str3) {
        this.f18717a = str;
        this.f18718b = str2;
        this.f18719c = str3;
        this.f18720d = r.l();
    }

    public final List a() {
        return this.f18720d;
    }

    public final String b() {
        return this.f18717a;
    }

    public final String c() {
        return this.f18719c;
    }

    public final String d() {
        return this.f18718b;
    }

    public final void e(List list) {
        this.f18720d = list;
    }

    public final void f(String str) {
        this.f18717a = str;
    }

    public final void g(String str) {
        this.f18719c = str;
    }

    public final void h(String str) {
        this.f18718b = str;
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        k2Var.v("name").K(this.f18717a);
        k2Var.v("version").K(this.f18718b);
        k2Var.v(ImagesContract.URL).K(this.f18719c);
        if (!this.f18720d.isEmpty()) {
            k2Var.v("dependencies");
            k2Var.h();
            for (e3 P : this.f18720d) {
                k2Var.P(P);
            }
            k2Var.m();
        }
        k2Var.n();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e3(String str, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "Android Bugsnag Notifier" : str, (i10 & 2) != 0 ? "6.12.1" : str2, (i10 & 4) != 0 ? "https://bugsnag.com" : str3);
    }
}
