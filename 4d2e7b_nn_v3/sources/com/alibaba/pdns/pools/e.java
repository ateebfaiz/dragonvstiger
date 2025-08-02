package com.alibaba.pdns.pools;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.pdns.pools.AbstractTask;
import com.alibaba.pdns.pools.Callback;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

public class e<ResultType> extends AbstractTask<ResultType> {

    /* renamed from: k  reason: collision with root package name */
    static final c f18180k = new c((a) null);

    /* renamed from: l  reason: collision with root package name */
    static final b f18181l = new b(true);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final String f18182m = e.class.getSimpleName();

    /* renamed from: n  reason: collision with root package name */
    private static final int f18183n = 1000000000;

    /* renamed from: o  reason: collision with root package name */
    private static final int f18184o = 1000000001;

    /* renamed from: p  reason: collision with root package name */
    private static final int f18185p = 1000000002;

    /* renamed from: q  reason: collision with root package name */
    private static final int f18186q = 1000000003;

    /* renamed from: r  reason: collision with root package name */
    private static final int f18187r = 1000000004;

    /* renamed from: s  reason: collision with root package name */
    private static final int f18188s = 1000000005;

    /* renamed from: t  reason: collision with root package name */
    private static final int f18189t = 1000000006;

    /* renamed from: u  reason: collision with root package name */
    private static final int f18190u = 1000000007;

    /* renamed from: f  reason: collision with root package name */
    private final WeakReference<Activity> f18191f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final AbstractTask<ResultType> f18192g;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f18193h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f18194i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f18195j = false;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                if (!e.this.f18194i) {
                    if (!e.this.a()) {
                        e.this.k();
                        if (!e.this.a()) {
                            e.this.f18192g.b(e.this.f18192g.d());
                            e eVar = e.this;
                            eVar.b(eVar.f18192g.g());
                            if (!e.this.a()) {
                                if (e.this.n()) {
                                    e eVar2 = e.this;
                                    eVar2.a(eVar2.f18192g.g());
                                }
                                if (!e.this.n()) {
                                    return;
                                }
                                e.this.j();
                                return;
                            } else if (e.this.n()) {
                                e.this.j();
                                return;
                            } else {
                                return;
                            }
                        } else if (e.this.n()) {
                            e.this.j();
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (e.this.n()) {
                    e.this.j();
                }
            } catch (Callback.CancelledException e10) {
                if (e.this.n()) {
                    e.this.a(e10);
                }
                if (!e.this.n()) {
                }
            } catch (Throwable th) {
                if (e.this.n()) {
                    e.this.j();
                }
                throw th;
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final e f18197a;

        /* renamed from: b  reason: collision with root package name */
        final Object[] f18198b;

        public b(e eVar, Object... objArr) {
            this.f18197a = eVar;
            this.f18198b = objArr;
        }
    }

    static final class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f18199a = true;

        /* synthetic */ c(a aVar) {
            this();
        }

        public void handleMessage(Message message) {
            Object[] objArr;
            Object obj = message.obj;
            if (obj == null) {
                com.alibaba.pdns.u.a.e(e.f18182m, "msg must not be null");
                return;
            }
            e eVar = null;
            if (obj instanceof e) {
                eVar = (e) obj;
                objArr = null;
            } else if (obj instanceof b) {
                b bVar = (b) obj;
                eVar = bVar.f18197a;
                objArr = bVar.f18198b;
            } else {
                objArr = null;
            }
            if (eVar == null) {
                com.alibaba.pdns.u.a.e(e.f18182m, "msg.obj not instanceof TaskProxy");
                return;
            }
            try {
                switch (message.what) {
                    case e.f18184o /*1000000001*/:
                        eVar.f18192g.l();
                        break;
                    case e.f18185p /*1000000002*/:
                        eVar.f18192g.k();
                        break;
                    case e.f18186q /*1000000003*/:
                        eVar.f18192g.a(eVar.g());
                        break;
                    case e.f18187r /*1000000004*/:
                        if (!f18199a) {
                            if (objArr == null) {
                                throw new AssertionError();
                            }
                        }
                        eVar.f18192g.a((Throwable) objArr[0], false);
                        break;
                    case e.f18188s /*1000000005*/:
                        eVar.f18192g.a(message.arg1, objArr);
                        break;
                    case e.f18189t /*1000000006*/:
                        if (!eVar.f18194i) {
                            boolean unused = eVar.f18194i = true;
                            if (!f18199a) {
                                if (objArr == null) {
                                    throw new AssertionError();
                                }
                            }
                            eVar.f18192g.a((Callback.CancelledException) objArr[0]);
                            break;
                        } else {
                            return;
                        }
                    case e.f18190u /*1000000007*/:
                        if (!eVar.f18195j) {
                            boolean unused2 = eVar.f18195j = true;
                            eVar.f18192g.j();
                            break;
                        } else {
                            return;
                        }
                }
            } catch (Throwable th) {
                eVar.a(AbstractTask.State.ERROR);
                if (message.what != e.f18187r) {
                    eVar.f18192g.a(th, true);
                }
            }
            super.handleMessage(message);
        }

        private c() {
            super(Looper.getMainLooper());
        }
    }

    e(AbstractTask abstractTask) {
        super(abstractTask);
        this.f18192g = abstractTask;
        abstractTask.a(this);
        a((e) null);
        Executor e10 = abstractTask.e();
        this.f18193h = e10 == null ? f18181l : e10;
        this.f18191f = null;
    }

    /* access modifiers changed from: private */
    public boolean n() {
        WeakReference<Activity> weakReference = this.f18191f;
        if (weakReference == null || (weakReference.get() != null && !this.f18191f.get().isFinishing() && !this.f18191f.get().isDestroyed())) {
            return true;
        }
        return false;
    }

    public Priority f() {
        return this.f18192g.f();
    }

    /* access modifiers changed from: protected */
    public void j() {
        f18180k.obtainMessage(f18190u, this).sendToTarget();
    }

    /* access modifiers changed from: protected */
    public void k() {
        a(AbstractTask.State.STARTED);
        f18180k.obtainMessage(f18185p, this).sendToTarget();
    }

    /* access modifiers changed from: protected */
    public void l() {
        a(AbstractTask.State.WAITING);
        f18180k.obtainMessage(f18184o, this).sendToTarget();
    }

    /* access modifiers changed from: protected */
    public void a(Object obj) {
        a(AbstractTask.State.SUCCESS);
        f18180k.obtainMessage(f18186q, this).sendToTarget();
    }

    /* access modifiers changed from: protected */
    public final ResultType d() throws Throwable {
        l();
        this.f18193h.execute(new c(this.f18192g.f(), new a()));
        return null;
    }

    public Executor e() {
        return this.f18193h;
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th, boolean z10) {
        a(AbstractTask.State.CANCELLED);
        f18180k.obtainMessage(f18187r, new b(this, th)).sendToTarget();
    }

    /* access modifiers changed from: protected */
    public void a(int i10, Object... objArr) {
        f18180k.obtainMessage(f18188s, i10, i10, new b(this, objArr)).sendToTarget();
    }

    /* access modifiers changed from: protected */
    public void a(Callback.CancelledException cancelledException) {
        a(AbstractTask.State.CANCELLED);
        f18180k.obtainMessage(f18189t, new b(this, cancelledException)).sendToTarget();
    }

    e(Activity activity, AbstractTask abstractTask) {
        super(abstractTask);
        this.f18192g = abstractTask;
        abstractTask.a(this);
        a((e) null);
        Executor e10 = abstractTask.e();
        this.f18193h = e10 == null ? f18181l : e10;
        this.f18191f = new WeakReference<>(activity);
    }

    /* access modifiers changed from: package-private */
    public void a(AbstractTask.State state) {
        super.a(state);
        this.f18192g.a(state);
    }
}
