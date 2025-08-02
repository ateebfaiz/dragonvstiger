package w0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.j;
import com.airbnb.lottie.n0;
import com.alibaba.pdns.model.DomainUhfReportModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r0.d;
import r0.h;
import u0.e;
import x0.c;
import y0.f;
import y0.l;

public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    private static final c.a f24480a = c.a.a("w", "h", "ip", "op", "fr", DomainUhfReportModel.ENCRYPTYPE, "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b  reason: collision with root package name */
    static c.a f24481b = c.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f24482c = c.a.a("list");

    /* renamed from: d  reason: collision with root package name */
    private static final c.a f24483d = c.a.a("cm", "tm", "dr");

    public static j a(c cVar) {
        HashMap hashMap;
        ArrayList arrayList;
        c cVar2 = cVar;
        float e10 = l.e();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        j jVar = new j();
        cVar.h();
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        while (cVar.m()) {
            switch (cVar2.C(f24480a)) {
                case 0:
                    HashMap hashMap5 = hashMap4;
                    ArrayList arrayList4 = arrayList3;
                    i11 = cVar.v();
                    continue;
                case 1:
                    HashMap hashMap6 = hashMap4;
                    ArrayList arrayList5 = arrayList3;
                    i10 = cVar.v();
                    continue;
                case 2:
                    HashMap hashMap7 = hashMap4;
                    ArrayList arrayList6 = arrayList3;
                    f10 = (float) cVar.p();
                    continue;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f11 = ((float) cVar.p()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f12 = (float) cVar.p();
                    break;
                case 5:
                    String[] split = cVar.y().split("\\.");
                    if (l.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        break;
                    } else {
                        jVar.a("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                case 6:
                    e(cVar2, jVar, arrayList2, longSparseArray);
                    continue;
                case 7:
                    b(cVar2, jVar, hashMap2, hashMap3);
                    continue;
                case 8:
                    d(cVar2, hashMap4);
                    continue;
                case 9:
                    c(cVar2, jVar, sparseArrayCompat);
                    continue;
                case 10:
                    f(cVar2, arrayList3);
                    continue;
                default:
                    cVar.E();
                    cVar.G();
                    continue;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            cVar2 = cVar;
        }
        j jVar2 = jVar;
        jVar.s(new Rect(0, 0, (int) (((float) i11) * e10), (int) (((float) i10) * e10)), f10, f11, f12, arrayList2, longSparseArray, hashMap2, hashMap3, l.e(), sparseArrayCompat, hashMap4, arrayList3, i11, i10);
        return jVar2;
    }

    private static void b(c cVar, j jVar, Map map, Map map2) {
        cVar.b();
        while (cVar.m()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            cVar.h();
            int i10 = 0;
            int i11 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (cVar.m()) {
                int C = cVar.C(f24481b);
                if (C == 0) {
                    str = cVar.y();
                } else if (C == 1) {
                    cVar.b();
                    while (cVar.m()) {
                        e b10 = v.b(cVar, jVar);
                        longSparseArray.put(b10.e(), b10);
                        arrayList.add(b10);
                    }
                    cVar.j();
                } else if (C == 2) {
                    i10 = cVar.v();
                } else if (C == 3) {
                    i11 = cVar.v();
                } else if (C == 4) {
                    str2 = cVar.y();
                } else if (C != 5) {
                    cVar.E();
                    cVar.G();
                } else {
                    str3 = cVar.y();
                }
            }
            cVar.k();
            if (str2 != null) {
                n0 n0Var = new n0(i10, i11, str, str2, str3);
                map2.put(n0Var.e(), n0Var);
            } else {
                map.put(str, arrayList);
            }
        }
        cVar.j();
    }

    private static void c(c cVar, j jVar, SparseArrayCompat sparseArrayCompat) {
        cVar.b();
        while (cVar.m()) {
            d a10 = m.a(cVar, jVar);
            sparseArrayCompat.put(a10.hashCode(), a10);
        }
        cVar.j();
    }

    private static void d(c cVar, Map map) {
        cVar.h();
        while (cVar.m()) {
            if (cVar.C(f24482c) != 0) {
                cVar.E();
                cVar.G();
            } else {
                cVar.b();
                while (cVar.m()) {
                    r0.c a10 = n.a(cVar);
                    map.put(a10.b(), a10);
                }
                cVar.j();
            }
        }
        cVar.k();
    }

    private static void e(c cVar, j jVar, List list, LongSparseArray longSparseArray) {
        cVar.b();
        int i10 = 0;
        while (cVar.m()) {
            e b10 = v.b(cVar, jVar);
            if (b10.g() == e.a.IMAGE) {
                i10++;
            }
            list.add(b10);
            longSparseArray.put(b10.e(), b10);
            if (i10 > 4) {
                f.c("You have " + i10 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.j();
    }

    private static void f(c cVar, List list) {
        cVar.b();
        while (cVar.m()) {
            cVar.h();
            float f10 = 0.0f;
            String str = null;
            float f11 = 0.0f;
            while (cVar.m()) {
                int C = cVar.C(f24483d);
                if (C == 0) {
                    str = cVar.y();
                } else if (C == 1) {
                    f10 = (float) cVar.p();
                } else if (C != 2) {
                    cVar.E();
                    cVar.G();
                } else {
                    f11 = (float) cVar.p();
                }
            }
            cVar.k();
            list.add(new h(str, f10, f11));
        }
        cVar.j();
    }
}
