package i4;

import android.os.SystemClock;
import k4.b;
import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f22102a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f22103b;

    /* renamed from: c  reason: collision with root package name */
    private long f22104c = 8;

    /* renamed from: d  reason: collision with root package name */
    private long f22105d;

    /* renamed from: e  reason: collision with root package name */
    private long f22106e;

    /* renamed from: f  reason: collision with root package name */
    private long f22107f;

    /* renamed from: g  reason: collision with root package name */
    private long f22108g;

    /* renamed from: h  reason: collision with root package name */
    private long f22109h;

    /* renamed from: i  reason: collision with root package name */
    private long f22110i;

    /* renamed from: j  reason: collision with root package name */
    private int f22111j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f22112k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f22113l;

    public c(b bVar) {
        m.f(bVar, "frameScheduler");
        this.f22102a = bVar;
    }

    private final long d() {
        return SystemClock.uptimeMillis();
    }

    public final int a() {
        long j10;
        long d10 = d();
        if (this.f22103b) {
            j10 = (d10 - this.f22107f) + this.f22105d;
        } else {
            j10 = Math.max(this.f22109h, 0);
        }
        int b10 = this.f22102a.b(j10, this.f22109h);
        this.f22109h = j10;
        return b10;
    }

    public final boolean b() {
        return this.f22103b;
    }

    public final long c() {
        if (!this.f22103b) {
            return -1;
        }
        long a10 = this.f22102a.a(d() - this.f22107f);
        if (a10 != -1) {
            long j10 = a10 + this.f22104c;
            this.f22108g = this.f22107f + j10;
            return j10;
        }
        this.f22103b = false;
        return -1;
    }

    public final void e() {
        this.f22113l++;
    }

    public final void f(int i10) {
        this.f22111j = i10;
    }

    public final void g(boolean z10) {
        this.f22103b = z10;
    }

    public final boolean h() {
        if (this.f22111j == -1 || d() < this.f22108g) {
            return false;
        }
        return true;
    }

    public final void i() {
        if (!this.f22103b) {
            long d10 = d();
            long j10 = d10 - this.f22106e;
            this.f22107f = j10;
            this.f22108g = j10;
            this.f22109h = d10 - this.f22110i;
            this.f22111j = this.f22112k;
            this.f22103b = true;
        }
    }

    public final void j() {
        if (this.f22103b) {
            long d10 = d();
            this.f22106e = d10 - this.f22107f;
            this.f22110i = d10 - this.f22109h;
            this.f22107f = 0;
            this.f22108g = 0;
            this.f22109h = -1;
            this.f22111j = -1;
            this.f22103b = false;
        }
    }
}
