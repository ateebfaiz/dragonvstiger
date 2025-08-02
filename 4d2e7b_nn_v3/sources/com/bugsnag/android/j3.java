package com.bugsnag.android;

import c1.j;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class j3 {

    /* renamed from: g  reason: collision with root package name */
    public static final a f18805g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final j f18806a;

    /* renamed from: b  reason: collision with root package name */
    private final s2 f18807b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f18808c;

    /* renamed from: d  reason: collision with root package name */
    private final i3 f18809d;

    /* renamed from: e  reason: collision with root package name */
    private final i3 f18810e;

    /* renamed from: f  reason: collision with root package name */
    private final i3 f18811f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j3(Set set, j jVar, s2 s2Var) {
        this.f18806a = jVar;
        this.f18807b = s2Var;
        i3 c10 = c("com.bugsnag.android.NdkPlugin", jVar.l().c());
        this.f18809d = c10;
        i3 c11 = c("com.bugsnag.android.AnrPlugin", jVar.l().b());
        this.f18810e = c11;
        i3 c12 = c("com.bugsnag.android.BugsnagReactNativePlugin", jVar.l().e());
        this.f18811f = c12;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        if (c10 != null) {
            linkedHashSet.add(c10);
        }
        if (c11 != null) {
            linkedHashSet.add(c11);
        }
        if (c12 != null) {
            linkedHashSet.add(c12);
        }
        this.f18808c = r.A0(linkedHashSet);
    }

    private final i3 c(String str, boolean z10) {
        try {
            Object newInstance = Class.forName(str).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            if (newInstance != null) {
                return (i3) newInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.bugsnag.android.Plugin");
        } catch (ClassNotFoundException unused) {
            if (!z10) {
                return null;
            }
            s2 s2Var = this.f18807b;
            s2Var.d("Plugin '" + str + "' is not on the classpath - functionality will not be enabled.");
            return null;
        } catch (Throwable th) {
            s2 s2Var2 = this.f18807b;
            s2Var2.e("Failed to load plugin '" + str + '\'', th);
            return null;
        }
    }

    private final void d(i3 i3Var, z zVar) {
        String name = i3Var.getClass().getName();
        n1 l10 = this.f18806a.l();
        if (m.b(name, "com.bugsnag.android.NdkPlugin")) {
            if (l10.c()) {
                i3Var.load(zVar);
            }
        } else if (!m.b(name, "com.bugsnag.android.AnrPlugin")) {
            i3Var.load(zVar);
        } else if (l10.b()) {
            i3Var.load(zVar);
        }
    }

    public final i3 a(Class cls) {
        Object obj;
        Iterator it = this.f18808c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (m.b(((i3) obj).getClass(), cls)) {
                break;
            }
        }
        return (i3) obj;
    }

    public final i3 b() {
        return this.f18809d;
    }

    public final void e(z zVar) {
        for (i3 i3Var : this.f18808c) {
            try {
                d(i3Var, zVar);
            } catch (Throwable th) {
                s2 s2Var = this.f18807b;
                s2Var.e("Failed to load plugin " + i3Var + ", continuing with initialisation.", th);
            }
        }
    }

    public final void f(z zVar, boolean z10) {
        if (z10) {
            i3 i3Var = this.f18810e;
            if (i3Var != null) {
                i3Var.load(zVar);
                return;
            }
            return;
        }
        i3 i3Var2 = this.f18810e;
        if (i3Var2 != null) {
            i3Var2.unload();
        }
    }

    public final void g(z zVar, boolean z10) {
        f(zVar, z10);
        if (z10) {
            i3 i3Var = this.f18809d;
            if (i3Var != null) {
                i3Var.load(zVar);
                return;
            }
            return;
        }
        i3 i3Var2 = this.f18809d;
        if (i3Var2 != null) {
            i3Var2.unload();
        }
    }
}
