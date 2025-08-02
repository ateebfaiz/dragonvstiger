package x4;

import b3.h;
import b3.i;
import b3.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.f;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import l5.b;
import r2.d;
import s2.n;

public final class j {

    /* renamed from: h  reason: collision with root package name */
    public static final a f24788h = new a((DefaultConstructorMarker) null);

    /* renamed from: i  reason: collision with root package name */
    private static final Class f24789i = j.class;

    /* renamed from: a  reason: collision with root package name */
    private final n f24790a;

    /* renamed from: b  reason: collision with root package name */
    private final i f24791b;

    /* renamed from: c  reason: collision with root package name */
    private final l f24792c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f24793d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f24794e;

    /* renamed from: f  reason: collision with root package name */
    private final t f24795f;

    /* renamed from: g  reason: collision with root package name */
    private final c0 f24796g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(n nVar, i iVar, l lVar, Executor executor, Executor executor2, t tVar) {
        m.f(nVar, "fileCache");
        m.f(iVar, "pooledByteBufferFactory");
        m.f(lVar, "pooledByteStreams");
        m.f(executor, "readExecutor");
        m.f(executor2, "writeExecutor");
        m.f(tVar, "imageCacheStatsTracker");
        this.f24790a = nVar;
        this.f24791b = iVar;
        this.f24792c = lVar;
        this.f24793d = executor;
        this.f24794e = executor2;
        this.f24795f = tVar;
        c0 d10 = c0.d();
        m.e(d10, "getInstance()");
        this.f24796g = d10;
    }

    private final boolean g(d dVar) {
        e5.j c10 = this.f24796g.c(dVar);
        if (c10 != null) {
            c10.close();
            z2.a.w(f24789i, "Found image for %s in staging area", dVar.c());
            this.f24795f.c(dVar);
            return true;
        }
        z2.a.w(f24789i, "Did not find image for %s in staging area", dVar.c());
        this.f24795f.k(dVar);
        try {
            return this.f24790a.e(dVar);
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static final Void i(Object obj, j jVar) {
        m.f(jVar, "this$0");
        Object e10 = f5.a.e(obj, (String) null);
        try {
            jVar.f24796g.a();
            jVar.f24790a.a();
            f5.a.f(e10);
            return null;
        } catch (Throwable th) {
            f5.a.f(e10);
            throw th;
        }
    }

    private final f l(d dVar, e5.j jVar) {
        z2.a.w(f24789i, "Found image for %s in staging area", dVar.c());
        this.f24795f.c(dVar);
        f h10 = f.h(jVar);
        m.e(h10, "forResult(pinnedImage)");
        return h10;
    }

    private final f n(d dVar, AtomicBoolean atomicBoolean) {
        try {
            f b10 = f.b(new e(f5.a.d("BufferedDiskCache_getAsync"), atomicBoolean, this, dVar), this.f24793d);
            m.e(b10, "{\n      val token = Fres…      readExecutor)\n    }");
            return b10;
        } catch (Exception e10) {
            z2.a.F(f24789i, e10, "Failed to schedule disk-cache read for %s", dVar.c());
            f g10 = f.g(e10);
            m.e(g10, "{\n      // Log failure\n …forError(exception)\n    }");
            return g10;
        }
    }

    /* access modifiers changed from: private */
    public static final e5.j o(Object obj, AtomicBoolean atomicBoolean, j jVar, d dVar) {
        c3.a z10;
        m.f(atomicBoolean, "$isCancelled");
        m.f(jVar, "this$0");
        m.f(dVar, "$key");
        Object e10 = f5.a.e(obj, (String) null);
        try {
            if (!atomicBoolean.get()) {
                e5.j c10 = jVar.f24796g.c(dVar);
                if (c10 != null) {
                    z2.a.w(f24789i, "Found image for %s in staging area", dVar.c());
                    jVar.f24795f.c(dVar);
                } else {
                    z2.a.w(f24789i, "Did not find image for %s in staging area", dVar.c());
                    jVar.f24795f.k(dVar);
                    try {
                        h r10 = jVar.r(dVar);
                        if (r10 == null) {
                            f5.a.f(e10);
                            return null;
                        }
                        z10 = c3.a.z(r10);
                        m.e(z10, "of(buffer)");
                        e5.j jVar2 = new e5.j(z10);
                        c3.a.m(z10);
                        c10 = jVar2;
                    } catch (Exception unused) {
                        f5.a.f(e10);
                        return null;
                    } catch (Throwable th) {
                        c3.a.m(z10);
                        throw th;
                    }
                }
                if (!Thread.interrupted()) {
                    f5.a.f(e10);
                    return c10;
                }
                z2.a.v(f24789i, "Host thread was interrupted, decreasing reference count");
                c10.close();
                throw new InterruptedException();
            }
            throw new CancellationException();
        } catch (Throwable th2) {
            f5.a.f(e10);
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public static final void q(Object obj, j jVar, d dVar, e5.j jVar2) {
        m.f(jVar, "this$0");
        m.f(dVar, "$key");
        Object e10 = f5.a.e(obj, (String) null);
        try {
            jVar.u(dVar, jVar2);
            c0 c0Var = jVar.f24796g;
            m.c(jVar2);
            c0Var.h(dVar, jVar2);
            e5.j.h(jVar2);
            f5.a.f(e10);
        } catch (Throwable th) {
            c0 c0Var2 = jVar.f24796g;
            m.c(jVar2);
            c0Var2.h(dVar, jVar2);
            e5.j.h(jVar2);
            f5.a.f(e10);
            throw th;
        }
    }

    private final h r(d dVar) {
        InputStream a10;
        try {
            Class cls = f24789i;
            z2.a.w(cls, "Disk cache read for %s", dVar.c());
            q2.a f10 = this.f24790a.f(dVar);
            if (f10 == null) {
                z2.a.w(cls, "Disk cache miss for %s", dVar.c());
                this.f24795f.i(dVar);
                return null;
            }
            z2.a.w(cls, "Found entry in disk cache for %s", dVar.c());
            this.f24795f.e(dVar);
            a10 = f10.a();
            h d10 = this.f24791b.d(a10, (int) f10.size());
            a10.close();
            z2.a.w(cls, "Successful read from disk cache for %s", dVar.c());
            return d10;
        } catch (IOException e10) {
            z2.a.F(f24789i, e10, "Exception reading from cache for %s", dVar.c());
            this.f24795f.g(dVar);
            throw e10;
        } catch (Throwable th) {
            a10.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final Void t(Object obj, j jVar, d dVar) {
        m.f(jVar, "this$0");
        m.f(dVar, "$key");
        Object e10 = f5.a.e(obj, (String) null);
        try {
            jVar.f24796g.g(dVar);
            jVar.f24790a.c(dVar);
            f5.a.f(e10);
            return null;
        } catch (Throwable th) {
            f5.a.f(e10);
            throw th;
        }
    }

    private final void u(d dVar, e5.j jVar) {
        Class cls = f24789i;
        z2.a.w(cls, "About to write to disk-cache for key %s", dVar.c());
        try {
            this.f24790a.d(dVar, new i(jVar, this));
            this.f24795f.m(dVar);
            z2.a.w(cls, "Successful disk-cache write for key %s", dVar.c());
        } catch (IOException e10) {
            z2.a.F(f24789i, e10, "Failed to write to disk-cache for key %s", dVar.c());
        }
    }

    /* access modifiers changed from: private */
    public static final void v(e5.j jVar, j jVar2, OutputStream outputStream) {
        m.f(jVar2, "this$0");
        m.f(outputStream, "os");
        m.c(jVar);
        InputStream w10 = jVar.w();
        if (w10 != null) {
            jVar2.f24792c.a(w10, outputStream);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void f(d dVar) {
        m.f(dVar, "key");
        this.f24790a.g(dVar);
    }

    public final f h() {
        this.f24796g.a();
        try {
            f b10 = f.b(new f(f5.a.d("BufferedDiskCache_clearAll"), this), this.f24794e);
            m.e(b10, "{\n      Task.call(\n     …     writeExecutor)\n    }");
            return b10;
        } catch (Exception e10) {
            z2.a.F(f24789i, e10, "Failed to schedule disk-cache clear", new Object[0]);
            f g10 = f.g(e10);
            m.e(g10, "{\n      // Log failure\n …forError(exception)\n    }");
            return g10;
        }
    }

    public final boolean j(d dVar) {
        m.f(dVar, "key");
        if (this.f24796g.b(dVar) || this.f24790a.b(dVar)) {
            return true;
        }
        return false;
    }

    public final boolean k(d dVar) {
        m.f(dVar, "key");
        if (j(dVar)) {
            return true;
        }
        return g(dVar);
    }

    public final f m(d dVar, AtomicBoolean atomicBoolean) {
        f fVar;
        f l10;
        m.f(dVar, "key");
        m.f(atomicBoolean, "isCancelled");
        if (!b.d()) {
            e5.j c10 = this.f24796g.c(dVar);
            if (c10 == null || (l10 = l(dVar, c10)) == null) {
                return n(dVar, atomicBoolean);
            }
            return l10;
        }
        b.a("BufferedDiskCache#get");
        try {
            e5.j c11 = this.f24796g.c(dVar);
            if (c11 != null) {
                fVar = l(dVar, c11);
                if (fVar == null) {
                }
                b.b();
                return fVar;
            }
            fVar = n(dVar, atomicBoolean);
            b.b();
            return fVar;
        } catch (Throwable th) {
            b.b();
            throw th;
        }
    }

    public final void p(d dVar, e5.j jVar) {
        e5.j b10;
        m.f(dVar, "key");
        m.f(jVar, "encodedImage");
        if (b.d()) {
            b.a("BufferedDiskCache#put");
            try {
                if (e5.j.J(jVar)) {
                    this.f24796g.f(dVar, jVar);
                    b10 = e5.j.b(jVar);
                    this.f24794e.execute(new g(f5.a.d("BufferedDiskCache_putAsync"), this, dVar, b10));
                    Unit unit = Unit.f12577a;
                    b.b();
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            } catch (Exception e10) {
                z2.a.F(f24789i, e10, "Failed to schedule disk-cache write for %s", dVar.c());
                this.f24796g.h(dVar, jVar);
                e5.j.h(b10);
            } catch (Throwable th) {
                b.b();
                throw th;
            }
        } else if (e5.j.J(jVar)) {
            this.f24796g.f(dVar, jVar);
            e5.j b11 = e5.j.b(jVar);
            try {
                this.f24794e.execute(new g(f5.a.d("BufferedDiskCache_putAsync"), this, dVar, b11));
            } catch (Exception e11) {
                z2.a.F(f24789i, e11, "Failed to schedule disk-cache write for %s", dVar.c());
                this.f24796g.h(dVar, jVar);
                e5.j.h(b11);
            }
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final f s(d dVar) {
        m.f(dVar, "key");
        this.f24796g.g(dVar);
        try {
            f b10 = f.b(new h(f5.a.d("BufferedDiskCache_remove"), this, dVar), this.f24794e);
            m.e(b10, "{\n      val token = Fres…     writeExecutor)\n    }");
            return b10;
        } catch (Exception e10) {
            z2.a.F(f24789i, e10, "Failed to schedule disk-cache remove for %s", dVar.c());
            f g10 = f.g(e10);
            m.e(g10, "{\n      // Log failure\n …forError(exception)\n    }");
            return g10;
        }
    }
}
