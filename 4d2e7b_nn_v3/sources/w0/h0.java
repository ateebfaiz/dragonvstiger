package w0;

import android.graphics.PointF;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.alibaba.pdns.net.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import r0.a;
import t0.o;
import x0.c;
import y0.k;

public class h0 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final h0 f24436a = new h0();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24437b = c.a.a(d.f18103f, DomainUhfReportModel.ENCRYPTYPE, "i", "o");

    private h0() {
    }

    /* renamed from: b */
    public o a(c cVar, float f10) {
        if (cVar.A() == c.b.BEGIN_ARRAY) {
            cVar.b();
        }
        cVar.h();
        List list = null;
        List list2 = null;
        List list3 = null;
        boolean z10 = false;
        while (cVar.m()) {
            int C = cVar.C(f24437b);
            if (C == 0) {
                z10 = cVar.n();
            } else if (C == 1) {
                list = s.f(cVar, f10);
            } else if (C == 2) {
                list2 = s.f(cVar, f10);
            } else if (C != 3) {
                cVar.E();
                cVar.G();
            } else {
                list3 = s.f(cVar, f10);
            }
        }
        cVar.k();
        if (cVar.A() == c.b.END_ARRAY) {
            cVar.j();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new o(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = (PointF) list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 1; i10 < size; i10++) {
                PointF pointF2 = (PointF) list.get(i10);
                int i11 = i10 - 1;
                arrayList.add(new a(k.a((PointF) list.get(i11), (PointF) list3.get(i11)), k.a(pointF2, (PointF) list2.get(i10)), pointF2));
            }
            if (z10) {
                PointF pointF3 = (PointF) list.get(0);
                int i12 = size - 1;
                arrayList.add(new a(k.a((PointF) list.get(i12), (PointF) list3.get(i12)), k.a(pointF3, (PointF) list2.get(0)), pointF3));
            }
            return new o(pointF, z10, arrayList);
        }
    }
}
