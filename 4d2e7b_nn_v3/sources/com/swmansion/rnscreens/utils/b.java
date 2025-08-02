package com.swmansion.rnscreens.utils;

import g0.a;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f11686a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11687b;

    public b(int i10, boolean z10) {
        this.f11686a = i10;
        this.f11687b = z10;
    }

    public final int a() {
        return this.f11686a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11686a == bVar.f11686a && this.f11687b == bVar.f11687b;
    }

    public int hashCode() {
        return (this.f11686a * 31) + a.a(this.f11687b);
    }

    public String toString() {
        int i10 = this.f11686a;
        boolean z10 = this.f11687b;
        return "CacheKey(fontSize=" + i10 + ", isTitleEmpty=" + z10 + ")";
    }
}
