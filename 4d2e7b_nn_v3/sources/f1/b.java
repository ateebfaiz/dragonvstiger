package f1;

import f1.j;
import f1.k;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    static final j.f f21310a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final k.a f21311b = new C0272b();

    class a implements j.f {
        a() {
        }

        /* renamed from: b */
        public byte[] a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return b.a(jVar);
        }
    }

    /* renamed from: f1.b$b  reason: collision with other inner class name */
    class C0272b implements k.a {
        C0272b() {
        }

        /* renamed from: b */
        public void a(k kVar, byte[] bArr) {
            b.b(bArr, kVar);
        }
    }

    public static byte[] a(j jVar) {
        return jVar.B();
    }

    public static void b(byte[] bArr, k kVar) {
        if (bArr == null) {
            kVar.n();
        } else if (bArr.length == 0) {
            kVar.i("\"\"");
        } else {
            kVar.k(bArr);
        }
    }
}
