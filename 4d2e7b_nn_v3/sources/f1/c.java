package f1;

import f1.j;
import f1.k;
import java.util.Arrays;
import okhttp3.HttpUrl;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean[] f21312a = new boolean[0];

    /* renamed from: b  reason: collision with root package name */
    public static final j.f f21313b = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final j.f f21314c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final k.a f21315d = new C0273c();

    /* renamed from: e  reason: collision with root package name */
    public static final j.f f21316e = new d();

    /* renamed from: f  reason: collision with root package name */
    public static final k.a f21317f = new e();

    class a implements j.f {
        a() {
        }

        /* renamed from: b */
        public Boolean a(j jVar) {
            return Boolean.valueOf(c.a(jVar));
        }
    }

    class b implements j.f {
        b() {
        }

        /* renamed from: b */
        public Boolean a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return Boolean.valueOf(c.a(jVar));
        }
    }

    /* renamed from: f1.c$c  reason: collision with other inner class name */
    class C0273c implements k.a {
        C0273c() {
        }

        /* renamed from: b */
        public void a(k kVar, Boolean bool) {
            c.d(bool, kVar);
        }
    }

    class d implements j.f {
        d() {
        }

        /* renamed from: b */
        public boolean[] a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            if (jVar.l() == 91) {
                jVar.h();
                return c.b(jVar);
            }
            throw jVar.n("Expecting '[' for boolean array start");
        }
    }

    class e implements k.a {
        e() {
        }

        /* renamed from: b */
        public void a(k kVar, boolean[] zArr) {
            c.c(zArr, kVar);
        }
    }

    public static boolean a(j jVar) {
        if (jVar.L()) {
            return true;
        }
        if (jVar.J()) {
            return false;
        }
        throw jVar.p("Found invalid boolean value", 0);
    }

    public static boolean[] b(j jVar) {
        if (jVar.l() == 93) {
            return f21312a;
        }
        boolean[] zArr = new boolean[4];
        zArr[0] = a(jVar);
        int i10 = 1;
        while (jVar.h() == 44) {
            jVar.h();
            if (i10 == zArr.length) {
                zArr = Arrays.copyOf(zArr, zArr.length << 1);
            }
            zArr[i10] = a(jVar);
            i10++;
        }
        jVar.d();
        return Arrays.copyOf(zArr, i10);
    }

    public static void c(boolean[] zArr, k kVar) {
        String str;
        String str2;
        if (zArr == null) {
            kVar.n();
        } else if (zArr.length == 0) {
            kVar.i(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            kVar.l((byte) 91);
            if (zArr[0]) {
                str = "true";
            } else {
                str = "false";
            }
            kVar.i(str);
            for (int i10 = 1; i10 < zArr.length; i10++) {
                if (zArr[i10]) {
                    str2 = ",true";
                } else {
                    str2 = ",false";
                }
                kVar.i(str2);
            }
            kVar.l((byte) 93);
        }
    }

    public static void d(Boolean bool, k kVar) {
        if (bool == null) {
            kVar.n();
        } else if (bool.booleanValue()) {
            kVar.i("true");
        } else {
            kVar.i("false");
        }
    }
}
