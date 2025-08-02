package com.bugsnag.android;

public final class n2 {

    /* renamed from: a  reason: collision with root package name */
    private final int f18881a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18882b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18883c;

    public n2(int i10, boolean z10, boolean z11) {
        this.f18881a = i10;
        this.f18882b = z10;
        this.f18883c = z11;
    }

    public final int a() {
        return this.f18881a;
    }

    public final boolean b() {
        return this.f18882b;
    }

    public final boolean c() {
        return this.f18883c;
    }

    public String toString() {
        return "LastRunInfo(consecutiveLaunchCrashes=" + this.f18881a + ", crashed=" + this.f18882b + ", crashedDuringLaunch=" + this.f18883c + ')';
    }
}
