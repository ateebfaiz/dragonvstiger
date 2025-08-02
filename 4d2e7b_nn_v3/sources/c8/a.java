package c8;

import androidx.tracing.Trace;
import com.facebook.systrace.TraceListener;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2651a = new a();

    /* renamed from: c8.a$a  reason: collision with other inner class name */
    public enum C0044a {
        THREAD('t'),
        PROCESS('p'),
        GLOBAL('g');
        

        /* renamed from: a  reason: collision with root package name */
        private final char f2657a;

        static {
            C0044a[] a10;
            f2656f = pb.a.a(a10);
        }

        private C0044a(char c10) {
            this.f2657a = c10;
        }
    }

    private a() {
    }

    public static final void a(long j10, String str, int i10) {
        m.f(str, "sectionName");
        Trace.beginAsyncSection(str, i10);
    }

    public static final void b(long j10, String str, int i10, long j11) {
        m.f(str, "sectionName");
        a(j10, str, i10);
    }

    public static final void c(long j10, String str) {
        m.f(str, "sectionName");
        Trace.beginSection(str);
    }

    public static final void d(long j10, String str, int i10) {
        m.f(str, "sectionName");
        e(j10, str, i10);
    }

    public static final void e(long j10, String str, int i10) {
        m.f(str, "sectionName");
        Trace.endAsyncSection(str, i10);
    }

    public static final void f(long j10, String str, int i10, long j11) {
        m.f(str, "sectionName");
        e(j10, str, i10);
    }

    public static final void g(long j10) {
        Trace.endSection();
    }

    public static final boolean h(long j10) {
        return false;
    }

    public static final void i(TraceListener traceListener) {
    }

    public static final void j(long j10, String str, int i10) {
        m.f(str, "sectionName");
        a(j10, str, i10);
    }

    public static final void k(long j10, String str, int i10) {
        m.f(str, "counterName");
        Trace.setCounter(str, i10);
    }

    public static final void l(long j10, String str, C0044a aVar) {
    }

    public static final void m(TraceListener traceListener) {
    }
}
