package e4;

import b4.d;
import c4.c;
import e4.a;
import g4.h;
import g4.i;
import g4.j;
import g4.k;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.ranges.l;

public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final d f21244a;

    /* renamed from: b  reason: collision with root package name */
    private final c f21245b;

    /* renamed from: c  reason: collision with root package name */
    private final j f21246c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f21247d;

    /* renamed from: e  reason: collision with root package name */
    private final String f21248e;

    /* renamed from: f  reason: collision with root package name */
    private final int f21249f;

    /* renamed from: g  reason: collision with root package name */
    private final int f21250g;

    /* renamed from: h  reason: collision with root package name */
    private i f21251h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final int f21252i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f21253j;

    /* renamed from: k  reason: collision with root package name */
    private final a f21254k;

    public static final class a implements h {

        /* renamed from: a  reason: collision with root package name */
        private final int f21255a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f21256b;

        a(e eVar) {
            this.f21256b = eVar;
            this.f21255a = eVar.f21252i;
        }

        public int a() {
            return this.f21255a;
        }

        public int b() {
            return this.f21256b.f21253j;
        }

        public void c(int i10) {
            if (i10 != this.f21256b.f21253j) {
                e eVar = this.f21256b;
                eVar.f21253j = l.h(i10, 1, eVar.f21252i);
                i f10 = this.f21256b.k();
                if (f10 != null) {
                    f10.c(this.f21256b.f21253j);
                }
            }
        }
    }

    static final class b extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f21257a = new b();

        b() {
            super(0);
        }

        public final void invoke() {
        }
    }

    public e(String str, d dVar, c cVar, j jVar, boolean z10) {
        m.f(dVar, "animationInformation");
        m.f(cVar, "bitmapFrameRenderer");
        m.f(jVar, "frameLoaderFactory");
        this.f21244a = dVar;
        this.f21245b = cVar;
        this.f21246c = jVar;
        this.f21247d = z10;
        this.f21248e = str == null ? String.valueOf(hashCode()) : str;
        this.f21249f = dVar.k();
        this.f21250g = dVar.f();
        int j10 = j(dVar);
        this.f21252i = j10;
        this.f21253j = j10;
        this.f21254k = new a(this);
    }

    private final f i(int i10, int i11) {
        if (!this.f21247d) {
            return new f(this.f21249f, this.f21250g);
        }
        int i12 = this.f21249f;
        int i13 = this.f21250g;
        if (i10 < i12 || i11 < i13) {
            double d10 = ((double) i12) / ((double) i13);
            if (i11 > i10) {
                i13 = l.f(i11, i13);
                i12 = (int) (((double) i13) * d10);
            } else {
                i12 = l.f(i10, i12);
                i13 = (int) (((double) i12) / d10);
            }
        }
        return new f(i12, i13);
    }

    private final int j(d dVar) {
        return (int) l.d(TimeUnit.SECONDS.toMillis(1) / ((long) (dVar.g() / dVar.getFrameCount())), 1);
    }

    /* access modifiers changed from: private */
    public final i k() {
        if (this.f21251h == null) {
            this.f21251h = this.f21246c.b(this.f21248e, this.f21245b, this.f21244a);
        }
        return this.f21251h;
    }

    public void a(int i10, int i11, Function0 function0) {
        if (i10 > 0 && i11 > 0 && this.f21249f > 0 && this.f21250g > 0) {
            f i12 = i(i10, i11);
            i k10 = k();
            if (k10 != null) {
                int b10 = i12.b();
                int b11 = i12.b();
                if (function0 == null) {
                    function0 = b.f21257a;
                }
                k10.a(b10, b11, function0);
            }
        }
    }

    public c3.a b(int i10, int i11, int i12) {
        k kVar;
        f i13 = i(i11, i12);
        i k10 = k();
        if (k10 != null) {
            kVar = k10.b(i10, i13.b(), i13.a());
        } else {
            kVar = null;
        }
        if (kVar != null) {
            g4.d.f21695a.f(this.f21254k, kVar);
        }
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    public void c() {
        i k10 = k();
        if (k10 != null) {
            j.f21724c.b(this.f21248e, k10);
        }
        this.f21251h = null;
    }

    public void d(b bVar, c4.b bVar2, b4.a aVar, int i10, Function0 function0) {
        a.C0267a.e(this, bVar, bVar2, aVar, i10, function0);
    }

    public void onStop() {
        i k10 = k();
        if (k10 != null) {
            k10.onStop();
        }
        c();
    }
}
