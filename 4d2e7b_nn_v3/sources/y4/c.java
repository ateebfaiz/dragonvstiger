package y4;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import y2.j;

public class c {

    /* renamed from: m  reason: collision with root package name */
    private static final c f24895m = b().a();

    /* renamed from: a  reason: collision with root package name */
    public final int f24896a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24897b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f24898c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f24899d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f24900e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f24901f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f24902g;

    /* renamed from: h  reason: collision with root package name */
    public final Bitmap.Config f24903h;

    /* renamed from: i  reason: collision with root package name */
    public final Bitmap.Config f24904i;

    /* renamed from: j  reason: collision with root package name */
    public final c5.c f24905j;

    /* renamed from: k  reason: collision with root package name */
    public final ColorSpace f24906k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f24907l;

    public c(d dVar) {
        this.f24896a = dVar.l();
        this.f24897b = dVar.k();
        this.f24898c = dVar.h();
        this.f24899d = dVar.n();
        this.f24900e = dVar.m();
        this.f24901f = dVar.g();
        this.f24902g = dVar.j();
        this.f24903h = dVar.c();
        this.f24904i = dVar.b();
        this.f24905j = dVar.f();
        dVar.d();
        this.f24906k = dVar.e();
        this.f24907l = dVar.i();
    }

    public static c a() {
        return f24895m;
    }

    public static d b() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public j.a c() {
        return j.c(this).a("minDecodeIntervalMs", this.f24896a).a("maxDimensionPx", this.f24897b).c("decodePreviewFrame", this.f24898c).c("useLastFrameForPreview", this.f24899d).c("useEncodedImageForPreview", this.f24900e).c("decodeAllFrames", this.f24901f).c("forceStaticImage", this.f24902g).b("bitmapConfigName", this.f24903h.name()).b("animatedBitmapConfigName", this.f24904i.name()).b("customImageDecoder", this.f24905j).b("bitmapTransformation", (Object) null).b("colorSpace", this.f24906k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f24896a != cVar.f24896a || this.f24897b != cVar.f24897b || this.f24898c != cVar.f24898c || this.f24899d != cVar.f24899d || this.f24900e != cVar.f24900e || this.f24901f != cVar.f24901f || this.f24902g != cVar.f24902g) {
            return false;
        }
        boolean z10 = this.f24907l;
        if (!z10 && this.f24903h != cVar.f24903h) {
            return false;
        }
        if ((z10 || this.f24904i == cVar.f24904i) && this.f24905j == cVar.f24905j && this.f24906k == cVar.f24906k) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12 = (((((((((((this.f24896a * 31) + this.f24897b) * 31) + (this.f24898c ? 1 : 0)) * 31) + (this.f24899d ? 1 : 0)) * 31) + (this.f24900e ? 1 : 0)) * 31) + (this.f24901f ? 1 : 0)) * 31) + (this.f24902g ? 1 : 0);
        if (!this.f24907l) {
            i12 = (i12 * 31) + this.f24903h.ordinal();
        }
        int i13 = 0;
        if (!this.f24907l) {
            int i14 = i12 * 31;
            Bitmap.Config config = this.f24904i;
            if (config != null) {
                i11 = config.ordinal();
            } else {
                i11 = 0;
            }
            i12 = i14 + i11;
        }
        int i15 = i12 * 31;
        c5.c cVar = this.f24905j;
        if (cVar != null) {
            i10 = cVar.hashCode();
        } else {
            i10 = 0;
        }
        int i16 = (i15 + i10) * 961;
        ColorSpace colorSpace = this.f24906k;
        if (colorSpace != null) {
            i13 = colorSpace.hashCode();
        }
        return i16 + i13;
    }

    public String toString() {
        return "ImageDecodeOptions{" + c().toString() + "}";
    }
}
