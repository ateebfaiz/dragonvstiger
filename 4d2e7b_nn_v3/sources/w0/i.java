package w0;

import android.graphics.PointF;
import com.alibaba.pdns.model.DomainUhfReportModel;
import r0.b;
import x0.c;

public class i implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final i f24438a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f24439b = c.a.a("t", "f", DomainUhfReportModel.SCENE, "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    private i() {
    }

    /* renamed from: b */
    public b a(c cVar, float f10) {
        b.a aVar = b.a.CENTER;
        cVar.h();
        b.a aVar2 = aVar;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = true;
        while (cVar.m()) {
            switch (cVar.C(f24439b)) {
                case 0:
                    str = cVar.y();
                    break;
                case 1:
                    str2 = cVar.y();
                    break;
                case 2:
                    f11 = (float) cVar.p();
                    break;
                case 3:
                    int v10 = cVar.v();
                    aVar2 = b.a.CENTER;
                    if (v10 <= aVar2.ordinal() && v10 >= 0) {
                        aVar2 = b.a.values()[v10];
                        break;
                    }
                case 4:
                    i10 = cVar.v();
                    break;
                case 5:
                    f12 = (float) cVar.p();
                    break;
                case 6:
                    f13 = (float) cVar.p();
                    break;
                case 7:
                    i11 = s.d(cVar);
                    break;
                case 8:
                    i12 = s.d(cVar);
                    break;
                case 9:
                    f14 = (float) cVar.p();
                    break;
                case 10:
                    z10 = cVar.n();
                    break;
                case 11:
                    cVar.b();
                    PointF pointF3 = new PointF(((float) cVar.p()) * f10, ((float) cVar.p()) * f10);
                    cVar.j();
                    pointF = pointF3;
                    break;
                case 12:
                    cVar.b();
                    PointF pointF4 = new PointF(((float) cVar.p()) * f10, ((float) cVar.p()) * f10);
                    cVar.j();
                    pointF2 = pointF4;
                    break;
                default:
                    cVar.E();
                    cVar.G();
                    break;
            }
        }
        c cVar2 = cVar;
        cVar.k();
        return new b(str, str2, f11, aVar2, i10, f12, f13, i11, i12, f14, z10, pointF, pointF2);
    }
}
