package com.onesignal;

import android.content.pm.PackageInfo;
import kotlin.jvm.internal.m;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11108a;

    /* renamed from: b  reason: collision with root package name */
    private final PackageInfo f11109b;

    public y(boolean z10, PackageInfo packageInfo) {
        this.f11108a = z10;
        this.f11109b = packageInfo;
    }

    public final PackageInfo a() {
        return this.f11109b;
    }

    public final boolean b() {
        return this.f11108a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f11108a == yVar.f11108a && m.b(this.f11109b, yVar.f11109b);
    }

    public int hashCode() {
        boolean z10 = this.f11108a;
        if (z10) {
            z10 = true;
        }
        int i10 = (z10 ? 1 : 0) * true;
        PackageInfo packageInfo = this.f11109b;
        return i10 + (packageInfo == null ? 0 : packageInfo.hashCode());
    }

    public String toString() {
        return "GetPackageInfoResult(successful=" + this.f11108a + ", packageInfo=" + this.f11109b + ')';
    }
}
