package hc;

import java.io.InputStream;

class j0 extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final v f385a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f386b = true;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f387c;

    j0(v vVar) {
        this.f385a = vVar;
    }

    public int read(byte[] bArr, int i10, int i11) {
        o oVar;
        int i12 = 0;
        if (this.f387c == null) {
            if (!this.f386b || (oVar = (o) this.f385a.b()) == null) {
                return -1;
            }
            this.f386b = false;
            this.f387c = oVar.a();
        }
        while (true) {
            int read = this.f387c.read(bArr, i10 + i12, i11 - i12);
            if (read >= 0) {
                i12 += read;
                if (i12 == i11) {
                    return i12;
                }
            } else {
                o oVar2 = (o) this.f385a.b();
                if (oVar2 == null) {
                    this.f387c = null;
                    if (i12 < 1) {
                        return -1;
                    }
                    return i12;
                }
                this.f387c = oVar2.a();
            }
        }
    }

    public int read() {
        o oVar;
        if (this.f387c == null) {
            if (!this.f386b || (oVar = (o) this.f385a.b()) == null) {
                return -1;
            }
            this.f386b = false;
            this.f387c = oVar.a();
        }
        while (true) {
            int read = this.f387c.read();
            if (read >= 0) {
                return read;
            }
            o oVar2 = (o) this.f385a.b();
            if (oVar2 == null) {
                this.f387c = null;
                return -1;
            }
            this.f387c = oVar2.a();
        }
    }
}
