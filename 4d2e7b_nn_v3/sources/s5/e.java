package s5;

import com.facebook.o;
import q5.n;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f23906a = new e();

    static final class a implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f23907a = new a();

        a() {
        }

        public final void a(boolean z10) {
            if (z10) {
                u5.a.f24346d.a();
                if (n.g(n.b.CrashShield)) {
                    a.a();
                    v5.a.a();
                }
                if (n.g(n.b.ThreadCheck)) {
                    x5.a.a();
                }
            }
        }
    }

    static final class b implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f23908a = new b();

        b() {
        }

        public final void a(boolean z10) {
            if (z10) {
                w5.b.a();
            }
        }
    }

    static final class c implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f23909a = new c();

        c() {
        }

        public final void a(boolean z10) {
            if (z10) {
                t5.b.a();
            }
        }
    }

    private e() {
    }

    public static final void a() {
        if (o.k()) {
            n.a(n.b.CrashReport, a.f23907a);
            n.a(n.b.ErrorReport, b.f23908a);
            n.a(n.b.AnrReport, c.f23909a);
        }
    }
}
