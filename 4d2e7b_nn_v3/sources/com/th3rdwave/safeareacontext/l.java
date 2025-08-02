package com.th3rdwave.safeareacontext;

import kotlin.jvm.internal.m;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final a f11732a;

    /* renamed from: b  reason: collision with root package name */
    private final m f11733b;

    /* renamed from: c  reason: collision with root package name */
    private final k f11734c;

    public l(a aVar, m mVar, k kVar) {
        m.f(aVar, "insets");
        m.f(mVar, "mode");
        m.f(kVar, "edges");
        this.f11732a = aVar;
        this.f11733b = mVar;
        this.f11734c = kVar;
    }

    public final k a() {
        return this.f11734c;
    }

    public final a b() {
        return this.f11732a;
    }

    public final m c() {
        return this.f11733b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return m.b(this.f11732a, lVar.f11732a) && this.f11733b == lVar.f11733b && m.b(this.f11734c, lVar.f11734c);
    }

    public int hashCode() {
        return (((this.f11732a.hashCode() * 31) + this.f11733b.hashCode()) * 31) + this.f11734c.hashCode();
    }

    public String toString() {
        a aVar = this.f11732a;
        m mVar = this.f11733b;
        k kVar = this.f11734c;
        return "SafeAreaViewLocalData(insets=" + aVar + ", mode=" + mVar + ", edges=" + kVar + ")";
    }
}
