package hc;

import zd.a;

public class l0 extends r {

    /* renamed from: a  reason: collision with root package name */
    private final char[] f388a;

    l0(char[] cArr) {
        this.f388a = cArr;
    }

    /* access modifiers changed from: protected */
    public boolean g(r rVar) {
        if (!(rVar instanceof l0)) {
            return false;
        }
        return a.b(this.f388a, ((l0) rVar).f388a);
    }

    public int hashCode() {
        return a.n(this.f388a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.c(30);
        pVar.i(this.f388a.length * 2);
        int i10 = 0;
        while (true) {
            char[] cArr = this.f388a;
            if (i10 != cArr.length) {
                char c10 = cArr[i10];
                pVar.c((byte) (c10 >> 8));
                pVar.c((byte) c10);
                i10++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f388a.length * 2) + 1 + (this.f388a.length * 2);
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public String o() {
        return new String(this.f388a);
    }

    public String toString() {
        return o();
    }
}
