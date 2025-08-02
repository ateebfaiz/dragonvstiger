package e4;

import android.graphics.Bitmap;
import android.util.SparseArray;
import c4.b;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import w4.d;

public final class c implements b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f21231a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c4.c f21232b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap.Config f21233c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f21234d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Class f21235e = c.class;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray f21236f = new SparseArray();

    private final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final b4.a f21237a;

        /* renamed from: b  reason: collision with root package name */
        private final b f21238b;

        /* renamed from: c  reason: collision with root package name */
        private final int f21239c;

        /* renamed from: d  reason: collision with root package name */
        private final int f21240d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f21241e;

        public a(c cVar, b4.a aVar, b bVar, int i10, int i11) {
            m.f(aVar, "animationBackend");
            m.f(bVar, "bitmapFrameCache");
            this.f21241e = cVar;
            this.f21237a = aVar;
            this.f21238b = bVar;
            this.f21239c = i10;
            this.f21240d = i11;
        }

        private final boolean a(int i10, int i11) {
            c3.a aVar;
            int i12 = 2;
            if (i11 == 1) {
                aVar = this.f21238b.c(i10, this.f21237a.c(), this.f21237a.a());
            } else if (i11 != 2) {
                c3.a.m((c3.a) null);
                return false;
            } else {
                try {
                    aVar = this.f21241e.f21231a.b(this.f21237a.c(), this.f21237a.a(), this.f21241e.f21233c);
                    i12 = -1;
                } catch (RuntimeException e10) {
                    z2.a.D(this.f21241e.f21235e, "Failed to create frame bitmap", e10);
                    c3.a.m((c3.a) null);
                    return false;
                } catch (Throwable th) {
                    c3.a.m((c3.a) null);
                    throw th;
                }
            }
            boolean b10 = b(i10, aVar, i11);
            c3.a.m(aVar);
            if (b10 || i12 == -1) {
                return b10;
            }
            return a(i10, i12);
        }

        private final boolean b(int i10, c3.a aVar, int i11) {
            if (c3.a.y(aVar) && aVar != null) {
                c4.c c10 = this.f21241e.f21232b;
                Object p10 = aVar.p();
                m.e(p10, "bitmapReference.get()");
                if (c10.d(i10, (Bitmap) p10)) {
                    z2.a.w(this.f21241e.f21235e, "Frame %d ready.", Integer.valueOf(i10));
                    synchronized (this.f21241e.f21236f) {
                        this.f21238b.g(i10, aVar, i11);
                        Unit unit = Unit.f12577a;
                    }
                    return true;
                }
            }
            return false;
        }

        public void run() {
            try {
                if (this.f21238b.b(this.f21239c)) {
                    z2.a.w(this.f21241e.f21235e, "Frame %d is cached already.", Integer.valueOf(this.f21239c));
                    SparseArray d10 = this.f21241e.f21236f;
                    c cVar = this.f21241e;
                    synchronized (d10) {
                        cVar.f21236f.remove(this.f21240d);
                        Unit unit = Unit.f12577a;
                    }
                    return;
                }
                if (a(this.f21239c, 1)) {
                    z2.a.w(this.f21241e.f21235e, "Prepared frame %d.", Integer.valueOf(this.f21239c));
                } else {
                    z2.a.h(this.f21241e.f21235e, "Could not prepare frame %d.", Integer.valueOf(this.f21239c));
                }
                SparseArray d11 = this.f21241e.f21236f;
                c cVar2 = this.f21241e;
                synchronized (d11) {
                    cVar2.f21236f.remove(this.f21240d);
                    Unit unit2 = Unit.f12577a;
                }
            } catch (Throwable th) {
                SparseArray d12 = this.f21241e.f21236f;
                c cVar3 = this.f21241e;
                synchronized (d12) {
                    cVar3.f21236f.remove(this.f21240d);
                    Unit unit3 = Unit.f12577a;
                    throw th;
                }
            }
        }
    }

    public c(d dVar, c4.c cVar, Bitmap.Config config, ExecutorService executorService) {
        m.f(dVar, "platformBitmapFactory");
        m.f(cVar, "bitmapFrameRenderer");
        m.f(config, "bitmapConfig");
        m.f(executorService, "executorService");
        this.f21231a = dVar;
        this.f21232b = cVar;
        this.f21233c = config;
        this.f21234d = executorService;
    }

    private final int g(b4.a aVar, int i10) {
        return (aVar.hashCode() * 31) + i10;
    }

    public boolean a(b bVar, b4.a aVar, int i10) {
        m.f(bVar, "bitmapFrameCache");
        m.f(aVar, "animationBackend");
        int g10 = g(aVar, i10);
        synchronized (this.f21236f) {
            if (this.f21236f.get(g10) != null) {
                z2.a.w(this.f21235e, "Already scheduled decode job for frame %d", Integer.valueOf(i10));
                return true;
            } else if (bVar.b(i10)) {
                z2.a.w(this.f21235e, "Frame %d is cached already.", Integer.valueOf(i10));
                return true;
            } else {
                a aVar2 = new a(this, aVar, bVar, i10, g10);
                this.f21236f.put(g10, aVar2);
                this.f21234d.execute(aVar2);
                Unit unit = Unit.f12577a;
                return true;
            }
        }
    }
}
