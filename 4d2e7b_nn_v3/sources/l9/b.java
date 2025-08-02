package l9;

import com.linecorp.linesdk.LineIdToken;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class b {

    /* renamed from: f  reason: collision with root package name */
    private static final long f12740f = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: a  reason: collision with root package name */
    private final LineIdToken f12741a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12742b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12743c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12744d;

    /* renamed from: e  reason: collision with root package name */
    private final String f12745e;

    /* renamed from: l9.b$b  reason: collision with other inner class name */
    public static final class C0150b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public LineIdToken f12746a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f12747b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f12748c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f12749d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f12750e;

        public b f() {
            return new b(this);
        }

        public C0150b g(String str) {
            this.f12749d = str;
            return this;
        }

        public C0150b h(String str) {
            this.f12747b = str;
            return this;
        }

        public C0150b i(String str) {
            this.f12750e = str;
            return this;
        }

        public C0150b j(String str) {
            this.f12748c = str;
            return this;
        }

        public C0150b k(LineIdToken lineIdToken) {
            this.f12746a = lineIdToken;
            return this;
        }
    }

    private static void a(String str, Object obj, Object obj2) {
        throw new RuntimeException(str + " expected: " + obj + ", but received: " + obj2);
    }

    private void c() {
        String a10 = this.f12741a.a();
        if (!this.f12744d.equals(a10)) {
            a("OpenId audience does not match.", this.f12744d, a10);
        }
    }

    private void d() {
        String d10 = this.f12741a.d();
        if (!this.f12742b.equals(d10)) {
            a("OpenId issuer does not match.", this.f12742b, d10);
        }
    }

    private void e() {
        String e10 = this.f12741a.e();
        String str = this.f12745e;
        if (str != null || e10 != null) {
            if (str == null || !str.equals(e10)) {
                a("OpenId nonce does not match.", this.f12745e, e10);
            }
        }
    }

    private void f() {
        String g10 = this.f12741a.g();
        String str = this.f12743c;
        if (str != null && !str.equals(g10)) {
            a("OpenId subject does not match.", this.f12743c, g10);
        }
    }

    private void g() {
        Date date = new Date();
        long time = this.f12741a.c().getTime();
        long time2 = date.getTime();
        long j10 = f12740f;
        if (time > time2 + j10) {
            throw new RuntimeException("OpenId issuedAt is after current time: " + this.f12741a.c());
        } else if (this.f12741a.b().getTime() < date.getTime() - j10) {
            throw new RuntimeException("OpenId expiresAt is before current time: " + this.f12741a.b());
        }
    }

    public void b() {
        d();
        f();
        c();
        e();
        g();
    }

    private b(C0150b bVar) {
        this.f12741a = bVar.f12746a;
        this.f12742b = bVar.f12747b;
        this.f12743c = bVar.f12748c;
        this.f12744d = bVar.f12749d;
        this.f12745e = bVar.f12750e;
    }
}
