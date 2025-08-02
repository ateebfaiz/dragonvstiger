package com.th3rdwave.safeareacontext;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final float f11707a;

    /* renamed from: b  reason: collision with root package name */
    private final float f11708b;

    /* renamed from: c  reason: collision with root package name */
    private final float f11709c;

    /* renamed from: d  reason: collision with root package name */
    private final float f11710d;

    public a(float f10, float f11, float f12, float f13) {
        this.f11707a = f10;
        this.f11708b = f11;
        this.f11709c = f12;
        this.f11710d = f13;
    }

    public final float a() {
        return this.f11709c;
    }

    public final float b() {
        return this.f11710d;
    }

    public final float c() {
        return this.f11708b;
    }

    public final float d() {
        return this.f11707a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(this.f11707a, aVar.f11707a) == 0 && Float.compare(this.f11708b, aVar.f11708b) == 0 && Float.compare(this.f11709c, aVar.f11709c) == 0 && Float.compare(this.f11710d, aVar.f11710d) == 0;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f11707a) * 31) + Float.floatToIntBits(this.f11708b)) * 31) + Float.floatToIntBits(this.f11709c)) * 31) + Float.floatToIntBits(this.f11710d);
    }

    public String toString() {
        float f10 = this.f11707a;
        float f11 = this.f11708b;
        float f12 = this.f11709c;
        float f13 = this.f11710d;
        return "EdgeInsets(top=" + f10 + ", right=" + f11 + ", bottom=" + f12 + ", left=" + f13 + ")";
    }
}
