package qd;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import qd.i;
import zd.c;

public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Map f1868a = new TreeMap();

    b() {
    }

    private void e(o oVar, long j10, byte[] bArr, byte[] bArr2) {
        u g10 = oVar.g();
        int d10 = g10.d();
        long j11 = x.j(j10, d10);
        int i10 = x.i(j10, d10);
        i iVar = (i) ((i.b) new i.b().h(j11)).p(i10).l();
        int i11 = (1 << d10) - 1;
        if (i10 < i11) {
            if (a(0) == null || i10 == 0) {
                b(0, new a(g10, bArr, bArr2, iVar));
            }
            d(0, bArr, bArr2, iVar);
        }
        for (int i12 = 1; i12 < oVar.d(); i12++) {
            int i13 = x.i(j11, d10);
            j11 = x.j(j11, d10);
            i iVar2 = (i) ((i.b) ((i.b) new i.b().g(i12)).h(j11)).p(i13).l();
            if (i13 < i11 && x.m(j10, d10, i12)) {
                if (a(i12) == null) {
                    b(i12, new a(oVar.g(), bArr, bArr2, iVar2));
                }
                d(i12, bArr, bArr2, iVar2);
            }
        }
    }

    public a a(int i10) {
        return (a) this.f1868a.get(c.b(i10));
    }

    public void b(int i10, a aVar) {
        this.f1868a.put(c.b(i10), aVar);
    }

    /* access modifiers changed from: package-private */
    public void c(u uVar) {
        for (Integer num : this.f1868a.keySet()) {
            a aVar = (a) this.f1868a.get(num);
            aVar.f(uVar);
            aVar.h();
        }
    }

    public a d(int i10, byte[] bArr, byte[] bArr2, i iVar) {
        return (a) this.f1868a.put(c.b(i10), ((a) this.f1868a.get(c.b(i10))).c(bArr, bArr2, iVar));
    }

    b(o oVar, long j10, byte[] bArr, byte[] bArr2) {
        for (long j11 = 0; j11 < j10; j11++) {
            e(oVar, j11, bArr, bArr2);
        }
    }
}
