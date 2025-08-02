package r3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import f3.c;
import java.io.Closeable;
import m4.b;
import m4.e;
import m4.h;
import m4.i;
import w3.t;
import y2.l;
import y2.o;

public class a extends m4.a implements Closeable, t {

    /* renamed from: h  reason: collision with root package name */
    private static C0327a f23656h;

    /* renamed from: b  reason: collision with root package name */
    private final c f23657b;

    /* renamed from: c  reason: collision with root package name */
    private final i f23658c;

    /* renamed from: d  reason: collision with root package name */
    private final h f23659d;

    /* renamed from: e  reason: collision with root package name */
    private final o f23660e;

    /* renamed from: f  reason: collision with root package name */
    private h f23661f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f23662g;

    /* renamed from: r3.a$a  reason: collision with other inner class name */
    static class C0327a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final h f23663a;

        /* renamed from: b  reason: collision with root package name */
        private h f23664b;

        public C0327a(Looper looper, h hVar, h hVar2) {
            super(looper);
            this.f23663a = hVar;
            this.f23664b = hVar2;
        }

        public void handleMessage(Message message) {
            i iVar = (i) l.g(message.obj);
            h hVar = this.f23664b;
            int i10 = message.what;
            if (i10 == 1) {
                e a10 = e.f22550b.a(message.arg1);
                if (a10 != null) {
                    this.f23663a.b(iVar, a10);
                    if (hVar != null) {
                        hVar.b(iVar, a10);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Invalid ImageLoadStatus value: " + message.arg1);
            } else if (i10 == 2) {
                m4.l a11 = m4.l.f22605b.a(message.arg1);
                if (a11 != null) {
                    this.f23663a.a(iVar, a11);
                    if (hVar != null) {
                        hVar.a(iVar, a11);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Invalid VisibilityState value: " + message.arg1);
            }
        }
    }

    public a(c cVar, i iVar, h hVar, o oVar) {
        this(cVar, iVar, hVar, oVar, true);
    }

    private boolean B() {
        boolean booleanValue = ((Boolean) this.f23660e.get()).booleanValue();
        if (booleanValue && f23656h == null) {
            p();
        }
        return booleanValue;
    }

    private void C(i iVar, e eVar) {
        iVar.n(eVar);
        if (B()) {
            Message obtainMessage = ((C0327a) l.g(f23656h)).obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = eVar.c();
            obtainMessage.obj = iVar;
            f23656h.sendMessage(obtainMessage);
            return;
        }
        this.f23659d.b(iVar, eVar);
        h hVar = this.f23661f;
        if (hVar != null) {
            hVar.b(iVar, eVar);
        }
    }

    private void E(i iVar, m4.l lVar) {
        if (B()) {
            Message obtainMessage = ((C0327a) l.g(f23656h)).obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = lVar.c();
            obtainMessage.obj = iVar;
            f23656h.sendMessage(obtainMessage);
            return;
        }
        this.f23659d.a(iVar, lVar);
        h hVar = this.f23661f;
        if (hVar != null) {
            hVar.a(iVar, lVar);
        }
    }

    private synchronized void p() {
        if (f23656h == null) {
            HandlerThread handlerThread = new HandlerThread("ImagePerfControllerListener2Thread");
            handlerThread.start();
            f23656h = new C0327a((Looper) l.g(handlerThread.getLooper()), this.f23659d, this.f23661f);
        }
    }

    private void y(i iVar, long j10) {
        iVar.x(false);
        iVar.r(j10);
        E(iVar, m4.l.INVISIBLE);
    }

    public void A() {
        this.f23658c.b();
    }

    public void b(boolean z10) {
        if (z10) {
            z(this.f23658c, this.f23657b.now());
        } else {
            y(this.f23658c, this.f23657b.now());
        }
    }

    public void close() {
        A();
    }

    public void j(String str, Throwable th, b.a aVar) {
        long now = this.f23657b.now();
        i iVar = this.f23658c;
        iVar.l(aVar);
        iVar.f(now);
        iVar.h(str);
        iVar.k(th);
        C(iVar, e.ERROR);
        y(iVar, now);
    }

    public void k(String str, b.a aVar) {
        long now = this.f23657b.now();
        i iVar = this.f23658c;
        iVar.l(aVar);
        iVar.h(str);
        e a10 = iVar.a();
        if (!(a10 == e.SUCCESS || a10 == e.ERROR || a10 == e.DRAW)) {
            iVar.e(now);
            C(iVar, e.CANCELED);
        }
        C(iVar, e.RELEASED);
        if (this.f23662g) {
            y(iVar, now);
        }
    }

    public void n(String str, Object obj, b.a aVar) {
        long now = this.f23657b.now();
        i iVar = this.f23658c;
        iVar.c();
        iVar.j(now);
        iVar.h(str);
        iVar.d(obj);
        iVar.l(aVar);
        C(iVar, e.REQUESTED);
        if (this.f23662g) {
            z(iVar, now);
        }
    }

    public void onDraw() {
    }

    /* renamed from: v */
    public void h(String str, e5.l lVar, b.a aVar) {
        long now = this.f23657b.now();
        i iVar = this.f23658c;
        iVar.l(aVar);
        iVar.g(now);
        iVar.p(now);
        iVar.h(str);
        iVar.m(lVar);
        C(iVar, e.SUCCESS);
    }

    /* renamed from: w */
    public void a(String str, e5.l lVar) {
        long now = this.f23657b.now();
        i iVar = this.f23658c;
        iVar.i(now);
        iVar.h(str);
        iVar.m(lVar);
        C(iVar, e.INTERMEDIATE_AVAILABLE);
    }

    public void z(i iVar, long j10) {
        iVar.x(true);
        iVar.w(j10);
        E(iVar, m4.l.VISIBLE);
    }

    public a(c cVar, i iVar, h hVar, o oVar, boolean z10) {
        this.f23661f = null;
        this.f23657b = cVar;
        this.f23658c = iVar;
        this.f23659d = hVar;
        this.f23660e = oVar;
        this.f23662g = z10;
    }
}
