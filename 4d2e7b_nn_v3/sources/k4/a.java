package k4;

import b4.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final C0298a f22279c = new C0298a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final d f22280a;

    /* renamed from: b  reason: collision with root package name */
    private long f22281b = -1;

    /* renamed from: k4.a$a  reason: collision with other inner class name */
    public static final class C0298a {
        private C0298a() {
        }

        public /* synthetic */ C0298a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(d dVar) {
        m.f(dVar, "animationInformation");
        this.f22280a = dVar;
    }

    public long a(long j10) {
        long d10 = d();
        long j11 = 0;
        if (d10 == 0) {
            return -1;
        }
        if (!e() && j10 / d10 >= ((long) this.f22280a.getLoopCount())) {
            return -1;
        }
        long j12 = j10 % d10;
        int frameCount = this.f22280a.getFrameCount();
        for (int i10 = 0; i10 < frameCount && j11 <= j12; i10++) {
            j11 += (long) this.f22280a.i(i10);
        }
        return j10 + (j11 - j12);
    }

    public int b(long j10, long j11) {
        long d10 = d();
        if (d10 == 0) {
            return c(0);
        }
        if (e() || j10 / d10 < ((long) this.f22280a.getLoopCount())) {
            return c(j10 % d10);
        }
        return -1;
    }

    public final int c(long j10) {
        int i10 = 0;
        long j11 = 0;
        while (true) {
            j11 += (long) this.f22280a.i(i10);
            int i11 = i10 + 1;
            if (j10 < j11) {
                return i10;
            }
            i10 = i11;
        }
    }

    public long d() {
        long j10 = this.f22281b;
        if (j10 != -1) {
            return j10;
        }
        this.f22281b = 0;
        int frameCount = this.f22280a.getFrameCount();
        for (int i10 = 0; i10 < frameCount; i10++) {
            this.f22281b += (long) this.f22280a.i(i10);
        }
        return this.f22281b;
    }

    public boolean e() {
        if (this.f22280a.getLoopCount() == 0) {
            return true;
        }
        return false;
    }
}
