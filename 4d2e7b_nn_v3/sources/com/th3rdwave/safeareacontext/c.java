package com.th3rdwave.safeareacontext;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final float f11714a;

    /* renamed from: b  reason: collision with root package name */
    private final float f11715b;

    /* renamed from: c  reason: collision with root package name */
    private final float f11716c;

    /* renamed from: d  reason: collision with root package name */
    private final float f11717d;

    public c(float f10, float f11, float f12, float f13) {
        this.f11714a = f10;
        this.f11715b = f11;
        this.f11716c = f12;
        this.f11717d = f13;
    }

    public final float a() {
        return this.f11717d;
    }

    public final float b() {
        return this.f11716c;
    }

    public final float c() {
        return this.f11714a;
    }

    public final float d() {
        return this.f11715b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Float.compare(this.f11714a, cVar.f11714a) == 0 && Float.compare(this.f11715b, cVar.f11715b) == 0 && Float.compare(this.f11716c, cVar.f11716c) == 0 && Float.compare(this.f11717d, cVar.f11717d) == 0;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f11714a) * 31) + Float.floatToIntBits(this.f11715b)) * 31) + Float.floatToIntBits(this.f11716c)) * 31) + Float.floatToIntBits(this.f11717d);
    }

    public String toString() {
        float f10 = this.f11714a;
        float f11 = this.f11715b;
        float f12 = this.f11716c;
        float f13 = this.f11717d;
        return "Rect(x=" + f10 + ", y=" + f11 + ", width=" + f12 + ", height=" + f13 + ")";
    }
}
