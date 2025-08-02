package q4;

import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f23215a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final c f23216b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f23217c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f23218d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f23219e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f23220f;

    /* renamed from: g  reason: collision with root package name */
    public static final c f23221g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f23222h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f23223i;

    /* renamed from: j  reason: collision with root package name */
    public static final c f23224j;

    /* renamed from: k  reason: collision with root package name */
    public static final c f23225k;

    /* renamed from: l  reason: collision with root package name */
    public static final c f23226l;

    /* renamed from: m  reason: collision with root package name */
    public static final c f23227m = new c("DNG", "dng");

    /* renamed from: n  reason: collision with root package name */
    public static final List f23228n;

    static {
        c cVar = new c("JPEG", "jpeg");
        f23216b = cVar;
        c cVar2 = new c("PNG", "png");
        f23217c = cVar2;
        c cVar3 = new c("GIF", "gif");
        f23218d = cVar3;
        c cVar4 = new c("BMP", "bmp");
        f23219e = cVar4;
        c cVar5 = new c("ICO", "ico");
        f23220f = cVar5;
        c cVar6 = new c("WEBP_SIMPLE", "webp");
        f23221g = cVar6;
        c cVar7 = new c("WEBP_LOSSLESS", "webp");
        f23222h = cVar7;
        c cVar8 = new c("WEBP_EXTENDED", "webp");
        f23223i = cVar8;
        c cVar9 = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
        f23224j = cVar9;
        c cVar10 = new c("WEBP_ANIMATED", "webp");
        f23225k = cVar10;
        c cVar11 = new c("HEIF", "heif");
        f23226l = cVar11;
        f23228n = r.o(cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9, cVar10, cVar11);
    }

    private b() {
    }

    public static final boolean a(c cVar) {
        m.f(cVar, "imageFormat");
        if (cVar == f23221g || cVar == f23222h || cVar == f23223i || cVar == f23224j) {
            return true;
        }
        return false;
    }

    public static final boolean b(c cVar) {
        m.f(cVar, "imageFormat");
        if (a(cVar) || cVar == f23225k) {
            return true;
        }
        return false;
    }
}
