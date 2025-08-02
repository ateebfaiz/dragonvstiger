package m7;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final float f12800a;

    /* renamed from: b  reason: collision with root package name */
    private final float f12801b;

    /* renamed from: c  reason: collision with root package name */
    private final float f12802c;

    /* renamed from: d  reason: collision with root package name */
    private final float f12803d;

    public c(float f10, float f11, float f12, float f13) {
        this.f12800a = f10;
        this.f12801b = f11;
        this.f12802c = f12;
        this.f12803d = f13;
    }

    public final float a() {
        return this.f12802c;
    }

    public final float b() {
        return this.f12803d;
    }

    public final float c() {
        return this.f12800a;
    }

    public final float d() {
        return this.f12801b;
    }

    public final boolean e() {
        if (this.f12800a > 0.0f || this.f12801b > 0.0f || this.f12802c > 0.0f || this.f12803d > 0.0f) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Float.compare(this.f12800a, cVar.f12800a) == 0 && Float.compare(this.f12801b, cVar.f12801b) == 0 && Float.compare(this.f12802c, cVar.f12802c) == 0 && Float.compare(this.f12803d, cVar.f12803d) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f12800a) * 31) + Float.floatToIntBits(this.f12801b)) * 31) + Float.floatToIntBits(this.f12802c)) * 31) + Float.floatToIntBits(this.f12803d);
    }

    public String toString() {
        float f10 = this.f12800a;
        float f11 = this.f12801b;
        float f12 = this.f12802c;
        float f13 = this.f12803d;
        return "ComputedBorderRadius(topLeft=" + f10 + ", topRight=" + f11 + ", bottomLeft=" + f12 + ", bottomRight=" + f13 + ")";
    }

    public c() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
