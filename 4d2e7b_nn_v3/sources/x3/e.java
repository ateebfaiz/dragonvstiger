package x3;

import java.util.Arrays;
import y2.l;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private a f24744a = a.BITMAP_ONLY;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24745b = false;

    /* renamed from: c  reason: collision with root package name */
    private float[] f24746c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f24747d = 0;

    /* renamed from: e  reason: collision with root package name */
    private float f24748e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private int f24749f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f24750g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24751h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24752i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24753j = false;

    public enum a {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public static e a(float f10) {
        return new e().q(f10);
    }

    private float[] e() {
        if (this.f24746c == null) {
            this.f24746c = new float[8];
        }
        return this.f24746c;
    }

    public int b() {
        return this.f24749f;
    }

    public float c() {
        return this.f24748e;
    }

    public float[] d() {
        return this.f24746c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f24745b == eVar.f24745b && this.f24747d == eVar.f24747d && Float.compare(eVar.f24748e, this.f24748e) == 0 && this.f24749f == eVar.f24749f && Float.compare(eVar.f24750g, this.f24750g) == 0 && this.f24744a == eVar.f24744a && this.f24751h == eVar.f24751h && this.f24752i == eVar.f24752i) {
            return Arrays.equals(this.f24746c, eVar.f24746c);
        }
        return false;
    }

    public int f() {
        return this.f24747d;
    }

    public float g() {
        return this.f24750g;
    }

    public boolean h() {
        return this.f24752i;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        a aVar = this.f24744a;
        int i13 = 0;
        if (aVar != null) {
            i10 = aVar.hashCode();
        } else {
            i10 = 0;
        }
        int i14 = ((i10 * 31) + (this.f24745b ? 1 : 0)) * 31;
        float[] fArr = this.f24746c;
        if (fArr != null) {
            i11 = Arrays.hashCode(fArr);
        } else {
            i11 = 0;
        }
        int i15 = (((i14 + i11) * 31) + this.f24747d) * 31;
        float f10 = this.f24748e;
        if (f10 != 0.0f) {
            i12 = Float.floatToIntBits(f10);
        } else {
            i12 = 0;
        }
        int i16 = (((i15 + i12) * 31) + this.f24749f) * 31;
        float f11 = this.f24750g;
        if (f11 != 0.0f) {
            i13 = Float.floatToIntBits(f11);
        }
        return ((((i16 + i13) * 31) + (this.f24751h ? 1 : 0)) * 31) + (this.f24752i ? 1 : 0);
    }

    public boolean i() {
        return this.f24753j;
    }

    public boolean j() {
        return this.f24745b;
    }

    public a k() {
        return this.f24744a;
    }

    public boolean l() {
        return this.f24751h;
    }

    public e m(int i10, float f10) {
        boolean z10;
        if (f10 >= 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.c(z10, "the border width cannot be < 0");
        this.f24748e = f10;
        this.f24749f = i10;
        return this;
    }

    public e n(int i10) {
        this.f24749f = i10;
        return this;
    }

    public e o(float f10) {
        boolean z10;
        if (f10 >= 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.c(z10, "the border width cannot be < 0");
        this.f24748e = f10;
        return this;
    }

    public e p(float f10, float f11, float f12, float f13) {
        float[] e10 = e();
        e10[1] = f10;
        e10[0] = f10;
        e10[3] = f11;
        e10[2] = f11;
        e10[5] = f12;
        e10[4] = f12;
        e10[7] = f13;
        e10[6] = f13;
        return this;
    }

    public e q(float f10) {
        Arrays.fill(e(), f10);
        return this;
    }

    public e r(int i10) {
        this.f24747d = i10;
        this.f24744a = a.OVERLAY_COLOR;
        return this;
    }

    public e s(float f10) {
        boolean z10;
        if (f10 >= 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.c(z10, "the padding cannot be < 0");
        this.f24750g = f10;
        return this;
    }

    public e t(boolean z10) {
        this.f24752i = z10;
        return this;
    }

    public e u(boolean z10) {
        this.f24745b = z10;
        return this;
    }

    public e v(a aVar) {
        this.f24744a = aVar;
        return this;
    }
}
