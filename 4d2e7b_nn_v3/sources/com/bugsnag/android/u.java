package com.bugsnag.android;

import c1.q;
import com.bugsnag.android.v3;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function1;

public final class u implements q {

    /* renamed from: a  reason: collision with root package name */
    private final z f19019a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1 f19020b;

    public u(z zVar, Function1 function1) {
        this.f19019a = zVar;
        this.f19020b = function1;
    }

    public void onStateChange(v3 v3Var) {
        x2 x2Var;
        boolean z10;
        boolean z11;
        x2 x2Var2;
        if (v3Var instanceof v3.n) {
            x2Var = new x2("ContextUpdate", ((v3.n) v3Var).f19071a);
        } else {
            if (v3Var instanceof v3.c) {
                z10 = true;
            } else {
                z10 = v3Var instanceof v3.f;
            }
            if (z10) {
                z11 = true;
            } else {
                z11 = v3Var instanceof v3.g;
            }
            if (z11) {
                x2Var = new x2("MetadataUpdate", this.f19019a.u());
            } else {
                if (v3Var instanceof v3.s) {
                    v3.s sVar = (v3.s) v3Var;
                    x2Var2 = new x2("UserUpdate", i0.i(new Pair("id", sVar.f19079a.b()), new Pair("email", sVar.f19079a.a()), new Pair("name", sVar.f19079a.c())));
                } else if (v3Var instanceof v3.b) {
                    v3.b bVar = (v3.b) v3Var;
                    x2Var2 = new x2("AddFeatureFlag", i0.i(new Pair("name", bVar.f19044a), new Pair("variant", bVar.f19045b)));
                } else if (v3Var instanceof v3.d) {
                    x2Var = new x2("ClearFeatureFlag", i0.d(new Pair("name", ((v3.d) v3Var).f19049a)));
                } else {
                    x2Var = null;
                    if (v3Var instanceof v3.e) {
                        x2Var = new x2("ClearFeatureFlag", (Object) null);
                    }
                }
                x2Var = x2Var2;
            }
        }
        if (x2Var != null) {
            this.f19020b.invoke(x2Var);
        }
    }
}
