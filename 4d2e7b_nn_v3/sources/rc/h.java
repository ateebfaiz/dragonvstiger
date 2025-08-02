package rc;

import hc.e;
import hc.j;
import hc.l;
import hc.m;
import hc.r;
import hc.z0;
import java.math.BigInteger;

public class h extends l implements j {

    /* renamed from: a  reason: collision with root package name */
    private m f2022a;

    /* renamed from: b  reason: collision with root package name */
    private r f2023b;

    public h(BigInteger bigInteger) {
        this.f2022a = j.f2047v;
        this.f2023b = new j(bigInteger);
    }

    public r c() {
        e eVar = new e();
        eVar.a(this.f2022a);
        eVar.a(this.f2023b);
        return new z0(eVar);
    }

    public h(int i10, int i11) {
        this(i10, i11, 0, 0);
    }

    public h(int i10, int i11, int i12, int i13) {
        this.f2022a = j.f2050x;
        e eVar = new e();
        eVar.a(new j((long) i10));
        if (i12 == 0) {
            if (i13 == 0) {
                eVar.a(j.f2054z);
                eVar.a(new j((long) i11));
            } else {
                throw new IllegalArgumentException("inconsistent k values");
            }
        } else if (i12 <= i11 || i13 <= i12) {
            throw new IllegalArgumentException("inconsistent k values");
        } else {
            eVar.a(j.A);
            e eVar2 = new e();
            eVar2.a(new j((long) i11));
            eVar2.a(new j((long) i12));
            eVar2.a(new j((long) i13));
            eVar.a(new z0(eVar2));
        }
        this.f2023b = new z0(eVar);
    }
}
