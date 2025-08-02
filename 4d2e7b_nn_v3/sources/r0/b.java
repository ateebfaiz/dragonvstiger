package r0;

import android.graphics.PointF;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f23595a;

    /* renamed from: b  reason: collision with root package name */
    public String f23596b;

    /* renamed from: c  reason: collision with root package name */
    public float f23597c;

    /* renamed from: d  reason: collision with root package name */
    public a f23598d;

    /* renamed from: e  reason: collision with root package name */
    public int f23599e;

    /* renamed from: f  reason: collision with root package name */
    public float f23600f;

    /* renamed from: g  reason: collision with root package name */
    public float f23601g;

    /* renamed from: h  reason: collision with root package name */
    public int f23602h;

    /* renamed from: i  reason: collision with root package name */
    public int f23603i;

    /* renamed from: j  reason: collision with root package name */
    public float f23604j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f23605k;

    /* renamed from: l  reason: collision with root package name */
    public PointF f23606l;

    /* renamed from: m  reason: collision with root package name */
    public PointF f23607m;

    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, float f10, a aVar, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10, PointF pointF, PointF pointF2) {
        a(str, str2, f10, aVar, i10, f11, f12, i11, i12, f13, z10, pointF, pointF2);
    }

    public void a(String str, String str2, float f10, a aVar, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10, PointF pointF, PointF pointF2) {
        this.f23595a = str;
        this.f23596b = str2;
        this.f23597c = f10;
        this.f23598d = aVar;
        this.f23599e = i10;
        this.f23600f = f11;
        this.f23601g = f12;
        this.f23602h = i11;
        this.f23603i = i12;
        this.f23604j = f13;
        this.f23605k = z10;
        this.f23606l = pointF;
        this.f23607m = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) (((float) (((this.f23595a.hashCode() * 31) + this.f23596b.hashCode()) * 31)) + this.f23597c)) * 31) + this.f23598d.ordinal()) * 31) + this.f23599e;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.f23600f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f23602h;
    }

    public b() {
    }
}
