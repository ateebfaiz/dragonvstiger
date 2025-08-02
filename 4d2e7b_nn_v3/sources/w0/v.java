package w0;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import com.airbnb.lottie.j;
import com.alibaba.pdns.model.DomainUhfReportModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import s0.b;
import s0.k;
import s0.n;
import t0.h;
import u0.e;
import x0.c;
import y0.l;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24476a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24477b = c.a.a(DomainUhfReportModel.ENCRYPTDATA, "a");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f24478c = c.a.a("ty", "nm");

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24479a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                u0.e$b[] r0 = u0.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24479a = r0
                u0.e$b r1 = u0.e.b.LUMA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24479a     // Catch:{ NoSuchFieldError -> 0x001d }
                u0.e$b r1 = u0.e.b.LUMA_INVERTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: w0.v.a.<clinit>():void");
        }
    }

    public static e a(j jVar) {
        Rect b10 = jVar.b();
        List emptyList = Collections.emptyList();
        e.a aVar = e.a.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        n nVar = r4;
        n nVar2 = new n();
        return new e(emptyList, jVar, "__container", -1, aVar, -1, (String) null, emptyList2, nVar, 0, 0, 0, 0.0f, 0.0f, (float) b10.width(), (float) b10.height(), (s0.j) null, (k) null, Collections.emptyList(), e.b.NONE, (b) null, false, (t0.a) null, (j) null, h.NORMAL);
    }

    public static e b(c cVar, j jVar) {
        ArrayList arrayList;
        boolean z10;
        float f10;
        c cVar2 = cVar;
        j jVar2 = jVar;
        e.b bVar = e.b.NONE;
        h hVar = h.NORMAL;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cVar.h();
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        e.b bVar2 = bVar;
        h hVar2 = hVar;
        e.a aVar = null;
        String str = null;
        s0.j jVar3 = null;
        k kVar = null;
        b bVar3 = null;
        t0.a aVar2 = null;
        j jVar4 = null;
        long j10 = 0;
        boolean z11 = false;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z12 = false;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        long j11 = -1;
        float f16 = 1.0f;
        String str2 = "UNSET";
        String str3 = null;
        n nVar = null;
        while (cVar.m()) {
            switch (cVar2.C(f24476a)) {
                case 0:
                    str2 = cVar.y();
                    break;
                case 1:
                    j10 = (long) cVar.v();
                    break;
                case 2:
                    str = cVar.y();
                    break;
                case 3:
                    int v10 = cVar.v();
                    aVar = e.a.UNKNOWN;
                    if (v10 >= aVar.ordinal()) {
                        break;
                    } else {
                        aVar = e.a.values()[v10];
                        break;
                    }
                case 4:
                    j11 = (long) cVar.v();
                    break;
                case 5:
                    i10 = (int) (((float) cVar.v()) * l.e());
                    break;
                case 6:
                    i11 = (int) (((float) cVar.v()) * l.e());
                    break;
                case 7:
                    i12 = Color.parseColor(cVar.y());
                    break;
                case 8:
                    nVar = c.g(cVar, jVar);
                    break;
                case 9:
                    int v11 = cVar.v();
                    if (v11 < e.b.values().length) {
                        bVar2 = e.b.values()[v11];
                        int i13 = a.f24479a[bVar2.ordinal()];
                        if (i13 == 1) {
                            jVar2.a("Unsupported matte type: Luma");
                        } else if (i13 == 2) {
                            jVar2.a("Unsupported matte type: Luma Inverted");
                        }
                        jVar2.r(1);
                        break;
                    } else {
                        jVar2.a("Unsupported matte type: " + v11);
                        break;
                    }
                case 10:
                    cVar.b();
                    while (cVar.m()) {
                        arrayList2.add(x.a(cVar, jVar));
                    }
                    jVar2.r(arrayList2.size());
                    cVar.j();
                    break;
                case 11:
                    cVar.b();
                    while (cVar.m()) {
                        t0.c a10 = h.a(cVar, jVar);
                        if (a10 != null) {
                            arrayList3.add(a10);
                        }
                    }
                    cVar.j();
                    break;
                case 12:
                    cVar.h();
                    while (cVar.m()) {
                        int C = cVar2.C(f24477b);
                        if (C == 0) {
                            jVar3 = d.d(cVar, jVar);
                        } else if (C != 1) {
                            cVar.E();
                            cVar.G();
                        } else {
                            cVar.b();
                            if (cVar.m()) {
                                kVar = b.a(cVar, jVar);
                            }
                            while (cVar.m()) {
                                cVar.G();
                            }
                            cVar.j();
                        }
                    }
                    cVar.k();
                    break;
                case 13:
                    cVar.b();
                    ArrayList arrayList4 = new ArrayList();
                    while (cVar.m()) {
                        cVar.h();
                        while (cVar.m()) {
                            int C2 = cVar2.C(f24478c);
                            if (C2 == 0) {
                                int v12 = cVar.v();
                                if (v12 == 29) {
                                    aVar2 = e.b(cVar, jVar);
                                } else if (v12 == 25) {
                                    jVar4 = new k().b(cVar2, jVar2);
                                }
                            } else if (C2 != 1) {
                                cVar.E();
                                cVar.G();
                            } else {
                                arrayList4.add(cVar.y());
                            }
                        }
                        cVar.k();
                    }
                    cVar.j();
                    jVar2.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 14:
                    f16 = (float) cVar.p();
                    break;
                case 15:
                    f12 = (float) cVar.p();
                    break;
                case 16:
                    f13 = (float) (cVar.p() * ((double) l.e()));
                    break;
                case 17:
                    f14 = (float) (cVar.p() * ((double) l.e()));
                    break;
                case 18:
                    f11 = (float) cVar.p();
                    break;
                case 19:
                    f15 = (float) cVar.p();
                    break;
                case 20:
                    bVar3 = d.f(cVar2, jVar2, false);
                    break;
                case 21:
                    str3 = cVar.y();
                    break;
                case 22:
                    z12 = cVar.n();
                    break;
                case 23:
                    if (cVar.v() != 1) {
                        z11 = false;
                        break;
                    } else {
                        z11 = true;
                        break;
                    }
                case 24:
                    int v13 = cVar.v();
                    if (v13 < h.values().length) {
                        hVar2 = h.values()[v13];
                        break;
                    } else {
                        jVar2.a("Unsupported Blend Mode: " + v13);
                        hVar2 = h.NORMAL;
                        break;
                    }
                default:
                    cVar.E();
                    cVar.G();
                    break;
            }
        }
        cVar.k();
        ArrayList arrayList5 = new ArrayList();
        if (f11 > 0.0f) {
            z0.a aVar3 = r0;
            arrayList = arrayList2;
            z10 = z11;
            z0.a aVar4 = new z0.a(jVar, valueOf, valueOf, (Interpolator) null, 0.0f, Float.valueOf(f11));
            arrayList5.add(aVar3);
            f10 = 0.0f;
        } else {
            arrayList = arrayList2;
            z10 = z11;
            f10 = 0.0f;
        }
        if (f15 <= f10) {
            f15 = jVar.f();
        }
        j jVar5 = jVar;
        arrayList5.add(new z0.a(jVar5, valueOf2, valueOf2, (Interpolator) null, f11, Float.valueOf(f15)));
        arrayList5.add(new z0.a(jVar5, valueOf, valueOf, (Interpolator) null, f15, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str3)) {
            jVar2.a("Convert your Illustrator layers to shape layers.");
        }
        if (z10) {
            if (nVar == null) {
                nVar = new n();
            }
            nVar.m(z10);
        }
        return new e(arrayList3, jVar, str2, j10, aVar, j11, str, arrayList, nVar, i10, i11, i12, f16, f12, f13, f14, jVar3, kVar, arrayList5, bVar2, bVar3, z12, aVar2, jVar4, hVar2);
    }
}
