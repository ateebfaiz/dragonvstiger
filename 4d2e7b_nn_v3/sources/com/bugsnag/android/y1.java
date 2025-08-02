package com.bugsnag.android;

import android.os.SystemClock;
import c1.i;
import c1.j;
import c1.s;
import com.bugsnag.android.d2;
import com.bugsnag.android.k2;
import com.bugsnag.android.q1;
import java.io.File;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.sequences.h;

public final class y1 extends d2 {

    /* renamed from: o  reason: collision with root package name */
    public static final a f19139o = new a((DefaultConstructorMarker) null);

    /* renamed from: p  reason: collision with root package name */
    private static final Comparator f19140p = new u1();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final j f19141g;

    /* renamed from: h  reason: collision with root package name */
    private final e3 f19142h;

    /* renamed from: i  reason: collision with root package name */
    private final c1.a f19143i;

    /* renamed from: j  reason: collision with root package name */
    private final y f19144j;

    /* renamed from: k  reason: collision with root package name */
    private final s2 f19145k;

    /* renamed from: l  reason: collision with root package name */
    private Function0 f19146l = e.f19152a;

    /* renamed from: m  reason: collision with root package name */
    private Function1 f19147m = d.f19151a;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19148n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19149a;

        static {
            int[] iArr = new int[v0.values().length];
            iArr[v0.DELIVERED.ordinal()] = 1;
            iArr[v0.UNDELIVERED.ordinal()] = 2;
            iArr[v0.FAILURE.ordinal()] = 3;
            f19149a = iArr;
        }
    }

    static final class c extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y1 f19150a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(y1 y1Var) {
            super(1);
            this.f19150a = y1Var;
        }

        /* renamed from: a */
        public final Boolean invoke(File file) {
            return Boolean.valueOf(q1.f18935f.i(file, this.f19150a.f19141g).e());
        }
    }

    static final class d extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final d f19151a = new d();

        d() {
            super(1);
        }

        public final void a(s1 s1Var) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((s1) obj);
            return Unit.f12577a;
        }
    }

    static final class e extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final e f19152a = new e();

        e() {
            super(0);
        }

        public final void invoke() {
        }
    }

    public y1(j jVar, s2 s2Var, e3 e3Var, c1.a aVar, d2.a aVar2, y yVar) {
        super(new File((File) jVar.z().getValue(), "bugsnag/errors"), jVar.t(), s2Var, aVar2);
        this.f19141g = jVar;
        this.f19145k = s2Var;
        this.f19142h = e3Var;
        this.f19143i = aVar;
        this.f19144j = yVar;
    }

    /* access modifiers changed from: private */
    public static final void A(y1 y1Var) {
        y1Var.y();
        y1Var.H();
    }

    private final void B(Collection collection) {
        if (!collection.isEmpty()) {
            int size = collection.size();
            s2 g10 = g();
            g10.f("Sending " + size + " saved error(s) to Bugsnag");
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                x((File) it.next());
            }
        }
    }

    private final Date C(File file) {
        return new Date(q1.f18935f.f(file));
    }

    private final void E(Exception exc, File file) {
        s2 g10 = g();
        String message = exc.getMessage();
        if (message == null) {
            message = "Failed to send event";
        }
        g10.e(message, exc);
        b(r0.c(file));
    }

    private final boolean F(File file) {
        if (file.length() > 1048576) {
            return true;
        }
        return false;
    }

    private final boolean G(File file) {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -60);
        if (q1.f18935f.f(file) < instance.getTimeInMillis()) {
            return true;
        }
        return false;
    }

    private final void H() {
        if (i() && !this.f19148n) {
            this.f19146l.invoke();
            this.f19148n = true;
        }
    }

    private final void I(File file) {
        if (F(file)) {
            s2 g10 = g();
            g10.g("Discarding over-sized event (" + file.length() + ") after failed delivery");
            t(file);
            b(r0.c(file));
        } else if (G(file)) {
            s2 g11 = g();
            g11.g("Discarding historical event (from " + C(file) + ") after failed delivery");
            t(file);
            b(r0.c(file));
        } else {
            a(r0.c(file));
            g().g("Could not send previously saved error(s) to Bugsnag, will try again later");
        }
    }

    /* access modifiers changed from: private */
    public static final String K(y1 y1Var, String str) {
        y1Var.x(new File(str));
        return str;
    }

    /* access modifiers changed from: private */
    public static final int p(File file, File file2) {
        if (file == null && file2 == null) {
            return 0;
        }
        if (file == null) {
            return 1;
        }
        if (file2 == null) {
            return -1;
        }
        return file.compareTo(file2);
    }

    private final s1 r(File file, String str) {
        m.c(str);
        v2 v2Var = new v2(file, str, g());
        try {
            if (!this.f19144j.j(v2Var, g())) {
                return null;
            }
        } catch (Exception e10) {
            g().c("could not parse event payload", e10);
            v2Var.a();
        }
        o1 b10 = v2Var.b();
        if (b10 != null) {
            return new s1(b10.e(), b10, (File) null, this.f19142h, this.f19141g);
        }
        return new s1(str, (o1) null, file, this.f19142h, this.f19141g);
    }

    private final void s(File file, s1 s1Var) {
        int i10 = b.f19149a[this.f19141g.i().a(s1Var, this.f19141g.o(s1Var)).ordinal()];
        if (i10 == 1) {
            b(r0.c(file));
            s2 g10 = g();
            g10.f("Deleting sent error file " + file + ".name");
        } else if (i10 == 2) {
            I(file);
        } else if (i10 == 3) {
            E(new RuntimeException("Failed to deliver event payload"), file);
        }
    }

    private final void t(File file) {
        File file2 = file;
        this.f19147m.invoke(new s1(q1.f18935f.i(file, this.f19141g).c(), (o1) null, file2, this.f19142h, this.f19141g));
    }

    /* access modifiers changed from: private */
    public static final void w(y1 y1Var) {
        List e10 = y1Var.e();
        if (e10.isEmpty()) {
            y1Var.g().d("No regular events to flush to Bugsnag.");
        }
        y1Var.B(e10);
        y1Var.H();
    }

    private final void x(File file) {
        try {
            s1 r10 = r(file, q1.f18935f.i(file, this.f19141g).a());
            if (r10 == null) {
                b(r0.c(file));
            } else {
                s(file, r10);
            }
        } catch (Exception e10) {
            E(e10, file);
        }
    }

    private final void y() {
        List e10 = e();
        Collection collection = e10;
        File u10 = u(collection);
        if (u10 != null) {
            e10.remove(u10);
        }
        a(collection);
        if (u10 != null) {
            g().f("Attempting to send the most recent launch crash report");
            B(r.e(u10));
            g().f("Continuing with Bugsnag initialisation");
            return;
        }
        g().d("No startupcrash events to flush to Bugsnag.");
    }

    public final String D(Object obj, String str) {
        q1 h10;
        String b10;
        if (obj == null || (h10 = q1.a.h(q1.f18935f, obj, (String) null, str, 0, this.f19141g, (Boolean) null, 42, (Object) null)) == null || (b10 = h10.b()) == null) {
            return "";
        }
        return b10;
    }

    public final Future J(k2.a aVar) {
        String k10 = k(aVar);
        if (k10 == null) {
            return null;
        }
        try {
            return this.f19143i.e(s.ERROR_REQUEST, new w1(this, k10));
        } catch (RejectedExecutionException unused) {
            g().g("Failed to flush all on-disk errors, retaining unsent errors for later.");
            return null;
        }
    }

    public String f(Object obj) {
        q1 h10;
        String b10;
        if (obj == null || (h10 = q1.a.h(q1.f18935f, obj, (String) null, (String) null, 0, this.f19141g, (Boolean) null, 42, (Object) null)) == null || (b10 = h10.b()) == null) {
            return "";
        }
        return b10;
    }

    /* access modifiers changed from: protected */
    public s2 g() {
        return this.f19145k;
    }

    public final File u(Collection collection) {
        return (File) h.s(h.j(r.Q(collection), new c(this)), f19140p);
    }

    public final void v() {
        try {
            this.f19143i.d(s.ERROR_REQUEST, new x1(this));
        } catch (RejectedExecutionException unused) {
            g().g("Failed to flush all on-disk errors, retaining unsent errors for later.");
        }
    }

    public final void z() {
        if (this.f19141g.D()) {
            try {
                Future d10 = this.f19143i.d(s.ERROR_REQUEST, new v1(this));
                try {
                    long j10 = 2000;
                    long elapsedRealtime = 2000 - (SystemClock.elapsedRealtime() - i.f17220a.c());
                    if (elapsedRealtime > 0) {
                        j10 = elapsedRealtime;
                    }
                    d10.get(j10, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e10) {
                    g().b("Failed to send launch crash reports within timeout, continuing.", e10);
                } catch (ExecutionException e11) {
                    g().b("Failed to send launch crash reports within timeout, continuing.", e11);
                } catch (TimeoutException e12) {
                    g().b("Failed to send launch crash reports within timeout, continuing.", e12);
                }
            } catch (RejectedExecutionException e13) {
                g().b("Failed to flush launch crash reports, continuing.", e13);
            }
        }
    }
}
