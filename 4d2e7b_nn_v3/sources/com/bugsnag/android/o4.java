package com.bugsnag.android;

import android.util.JsonReader;
import com.bugsnag.android.g1;
import com.bugsnag.android.k4;
import com.bugsnag.android.v3;
import d1.d;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

public final class o4 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18898a;

    /* renamed from: b  reason: collision with root package name */
    private final d f18899b;

    /* renamed from: c  reason: collision with root package name */
    private final d f18900c;

    /* renamed from: d  reason: collision with root package name */
    private final d f18901d;

    /* renamed from: e  reason: collision with root package name */
    private final s2 f18902e;

    /* renamed from: f  reason: collision with root package name */
    private final y3 f18903f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference f18904g;

    /* synthetic */ class a extends j implements Function1 {
        a(Object obj) {
            super(1, obj, k4.a.class, "fromReader", "fromReader(Landroid/util/JsonReader;)Lcom/bugsnag/android/User;", 0);
        }

        /* renamed from: c */
        public final k4 invoke(JsonReader jsonReader) {
            return ((k4.a) this.receiver).a(jsonReader);
        }
    }

    public o4(boolean z10, d dVar, d dVar2, File file, d dVar3, s2 s2Var) {
        this.f18898a = z10;
        this.f18899b = dVar;
        this.f18900c = dVar2;
        this.f18901d = dVar3;
        this.f18902e = s2Var;
        this.f18904g = new AtomicReference((Object) null);
        this.f18903f = new y3(file);
    }

    /* access modifiers changed from: private */
    public static final void c(o4 o4Var, v3 v3Var) {
        if (v3Var instanceof v3.s) {
            o4Var.e(((v3.s) v3Var).f19079a);
        }
    }

    private final k4 d() {
        String str = null;
        if (((r3) this.f18901d.get()).c()) {
            r3 r3Var = (r3) this.f18901d.get();
            g1.c cVar = (g1.c) this.f18900c.get();
            if (cVar != null) {
                str = cVar.a();
            }
            k4 d10 = r3Var.d(str);
            e(d10);
            return d10;
        } else if (!this.f18903f.a().canRead() || this.f18903f.a().length() <= 0 || !this.f18898a) {
            return null;
        } else {
            try {
                return (k4) this.f18903f.b(new a(k4.f18815d));
            } catch (Exception e10) {
                this.f18902e.c("Failed to load user info", e10);
                return null;
            }
        }
    }

    private final boolean f(k4 k4Var) {
        if (k4Var.b() == null && k4Var.c() == null && k4Var.a() == null) {
            return false;
        }
        return true;
    }

    public final m4 b(k4 k4Var) {
        m4 m4Var;
        String str;
        if (!f(k4Var)) {
            if (this.f18898a) {
                k4Var = d();
            } else {
                k4Var = null;
            }
        }
        if (k4Var == null || !f(k4Var)) {
            g1.c cVar = (g1.c) this.f18900c.get();
            if (cVar == null) {
                str = null;
            } else {
                str = cVar.a();
            }
            m4Var = new m4(new k4(str, (String) null, (String) null));
        } else {
            m4Var = new m4(k4Var);
        }
        m4Var.addObserver(new n4(this));
        return m4Var;
    }

    public final void e(k4 k4Var) {
        if (this.f18898a && !m.b(k4Var, this.f18904g.getAndSet(k4Var))) {
            try {
                this.f18903f.c(k4Var);
            } catch (Exception e10) {
                this.f18902e.c("Failed to persist user info", e10);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o4(boolean z10, d dVar, d dVar2, File file, d dVar3, s2 s2Var, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, dVar, dVar2, (i10 & 8) != 0 ? new File((File) dVar.get(), "user-info") : file, dVar3, s2Var);
    }
}
