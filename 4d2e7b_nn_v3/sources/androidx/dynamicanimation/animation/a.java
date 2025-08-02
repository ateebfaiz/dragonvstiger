package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

class a {

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal f15382g = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap f15383a = new SimpleArrayMap();

    /* renamed from: b  reason: collision with root package name */
    final ArrayList f15384b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final C0196a f15385c = new C0196a();

    /* renamed from: d  reason: collision with root package name */
    private c f15386d;

    /* renamed from: e  reason: collision with root package name */
    long f15387e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15388f = false;

    /* renamed from: androidx.dynamicanimation.animation.a$a  reason: collision with other inner class name */
    class C0196a {
        C0196a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            a.this.f15387e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f15387e);
            if (a.this.f15384b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    interface b {
        boolean doAnimationFrame(long j10);
    }

    static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final C0196a f15390a;

        c(C0196a aVar) {
            this.f15390a = aVar;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();
    }

    private static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f15391b = Choreographer.getInstance();

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f15392c = new C0197a();

        /* renamed from: androidx.dynamicanimation.animation.a$d$a  reason: collision with other inner class name */
        class C0197a implements Choreographer.FrameCallback {
            C0197a() {
            }

            public void doFrame(long j10) {
                d.this.f15390a.a();
            }
        }

        d(C0196a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f15391b.postFrameCallback(this.f15392c);
        }
    }

    a() {
    }

    private void b() {
        if (this.f15388f) {
            for (int size = this.f15384b.size() - 1; size >= 0; size--) {
                if (this.f15384b.get(size) == null) {
                    this.f15384b.remove(size);
                }
            }
            this.f15388f = false;
        }
    }

    public static a d() {
        ThreadLocal threadLocal = f15382g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return (a) threadLocal.get();
    }

    private boolean f(b bVar, long j10) {
        Long l10 = (Long) this.f15383a.get(bVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j10) {
            return false;
        }
        this.f15383a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j10) {
        if (this.f15384b.size() == 0) {
            e().a();
        }
        if (!this.f15384b.contains(bVar)) {
            this.f15384b.add(bVar);
        }
        if (j10 > 0) {
            this.f15383a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    /* access modifiers changed from: package-private */
    public void c(long j10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f15384b.size(); i10++) {
            b bVar = (b) this.f15384b.get(i10);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.doAnimationFrame(j10);
            }
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public c e() {
        if (this.f15386d == null) {
            this.f15386d = new d(this.f15385c);
        }
        return this.f15386d;
    }

    public void g(b bVar) {
        this.f15383a.remove(bVar);
        int indexOf = this.f15384b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f15384b.set(indexOf, (Object) null);
            this.f15388f = true;
        }
    }
}
