package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

class a {

    /* renamed from: e  reason: collision with root package name */
    private static a f8516e;

    /* renamed from: a  reason: collision with root package name */
    private final Object f8517a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f8518b = new Handler(Looper.getMainLooper(), new C0097a());

    /* renamed from: c  reason: collision with root package name */
    private c f8519c;

    /* renamed from: d  reason: collision with root package name */
    private c f8520d;

    /* renamed from: com.google.android.material.snackbar.a$a  reason: collision with other inner class name */
    class C0097a implements Handler.Callback {
        C0097a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a.this.d((c) message.obj);
            return true;
        }
    }

    interface b {
        void a(int i10);

        void show();
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference f8522a;

        /* renamed from: b  reason: collision with root package name */
        int f8523b;

        /* renamed from: c  reason: collision with root package name */
        boolean f8524c;

        c(int i10, b bVar) {
            this.f8522a = new WeakReference(bVar);
            this.f8523b = i10;
        }

        /* access modifiers changed from: package-private */
        public boolean a(b bVar) {
            if (bVar == null || this.f8522a.get() != bVar) {
                return false;
            }
            return true;
        }
    }

    private a() {
    }

    private boolean a(c cVar, int i10) {
        b bVar = (b) cVar.f8522a.get();
        if (bVar == null) {
            return false;
        }
        this.f8518b.removeCallbacksAndMessages(cVar);
        bVar.a(i10);
        return true;
    }

    static a c() {
        if (f8516e == null) {
            f8516e = new a();
        }
        return f8516e;
    }

    private boolean g(b bVar) {
        c cVar = this.f8519c;
        if (cVar == null || !cVar.a(bVar)) {
            return false;
        }
        return true;
    }

    private boolean h(b bVar) {
        c cVar = this.f8520d;
        if (cVar == null || !cVar.a(bVar)) {
            return false;
        }
        return true;
    }

    private void m(c cVar) {
        int i10 = cVar.f8523b;
        if (i10 != -2) {
            if (i10 <= 0) {
                if (i10 == -1) {
                    i10 = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
                } else {
                    i10 = 2750;
                }
            }
            this.f8518b.removeCallbacksAndMessages(cVar);
            Handler handler = this.f8518b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), (long) i10);
        }
    }

    private void o() {
        c cVar = this.f8520d;
        if (cVar != null) {
            this.f8519c = cVar;
            this.f8520d = null;
            b bVar = (b) cVar.f8522a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f8519c = null;
            }
        }
    }

    public void b(b bVar, int i10) {
        synchronized (this.f8517a) {
            try {
                if (g(bVar)) {
                    a(this.f8519c, i10);
                } else if (h(bVar)) {
                    a(this.f8520d, i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(c cVar) {
        synchronized (this.f8517a) {
            try {
                if (this.f8519c != cVar) {
                    if (this.f8520d == cVar) {
                    }
                }
                a(cVar, 2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e(b bVar) {
        boolean g10;
        synchronized (this.f8517a) {
            g10 = g(bVar);
        }
        return g10;
    }

    public boolean f(b bVar) {
        boolean z10;
        synchronized (this.f8517a) {
            try {
                if (!g(bVar)) {
                    if (!h(bVar)) {
                        z10 = false;
                    }
                }
                z10 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public void i(b bVar) {
        synchronized (this.f8517a) {
            try {
                if (g(bVar)) {
                    this.f8519c = null;
                    if (this.f8520d != null) {
                        o();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.f8517a) {
            try {
                if (g(bVar)) {
                    m(this.f8519c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.f8517a) {
            try {
                if (g(bVar)) {
                    c cVar = this.f8519c;
                    if (!cVar.f8524c) {
                        cVar.f8524c = true;
                        this.f8518b.removeCallbacksAndMessages(cVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void l(b bVar) {
        synchronized (this.f8517a) {
            try {
                if (g(bVar)) {
                    c cVar = this.f8519c;
                    if (cVar.f8524c) {
                        cVar.f8524c = false;
                        m(cVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n(int i10, b bVar) {
        synchronized (this.f8517a) {
            try {
                if (g(bVar)) {
                    c cVar = this.f8519c;
                    cVar.f8523b = i10;
                    this.f8518b.removeCallbacksAndMessages(cVar);
                    m(this.f8519c);
                    return;
                }
                if (h(bVar)) {
                    this.f8520d.f8523b = i10;
                } else {
                    this.f8520d = new c(i10, bVar);
                }
                c cVar2 = this.f8519c;
                if (cVar2 == null || !a(cVar2, 4)) {
                    this.f8519c = null;
                    o();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
