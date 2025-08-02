package c3;

import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import y2.l;

public abstract class a implements Cloneable, Closeable {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static Class f17280e = a.class;

    /* renamed from: f  reason: collision with root package name */
    private static int f17281f;

    /* renamed from: g  reason: collision with root package name */
    private static final h f17282g = new C0223a();

    /* renamed from: h  reason: collision with root package name */
    private static final c f17283h = new b();

    /* renamed from: a  reason: collision with root package name */
    protected boolean f17284a = false;

    /* renamed from: b  reason: collision with root package name */
    protected final i f17285b;

    /* renamed from: c  reason: collision with root package name */
    protected final c f17286c;

    /* renamed from: d  reason: collision with root package name */
    protected final Throwable f17287d;

    /* renamed from: c3.a$a  reason: collision with other inner class name */
    class C0223a implements h {
        C0223a() {
        }

        /* renamed from: a */
        public void release(Closeable closeable) {
            try {
                y2.b.a(closeable, true);
            } catch (IOException unused) {
            }
        }
    }

    class b implements c {
        b() {
        }

        public boolean a() {
            return false;
        }

        public void b(i iVar, Throwable th) {
            String str;
            Object f10 = iVar.f();
            Class a10 = a.f17280e;
            Integer valueOf = Integer.valueOf(System.identityHashCode(this));
            Integer valueOf2 = Integer.valueOf(System.identityHashCode(iVar));
            if (f10 == null) {
                str = null;
            } else {
                str = f10.getClass().getName();
            }
            z2.a.E(a10, "Finalized without closing: %x %x (type = %s)", valueOf, valueOf2, str);
        }
    }

    public interface c {
        boolean a();

        void b(i iVar, Throwable th);
    }

    protected a(i iVar, c cVar, Throwable th) {
        this.f17285b = (i) l.g(iVar);
        iVar.b();
        this.f17286c = cVar;
        this.f17287d = th;
    }

    public static a A(Closeable closeable, c cVar) {
        Throwable th = null;
        if (closeable == null) {
            return null;
        }
        h hVar = f17282g;
        if (cVar.a()) {
            th = new Throwable();
        }
        return E(closeable, hVar, cVar, th);
    }

    public static a B(Object obj, h hVar) {
        return C(obj, hVar, f17283h);
    }

    public static a C(Object obj, h hVar, c cVar) {
        Throwable th = null;
        if (obj == null) {
            return null;
        }
        if (cVar.a()) {
            th = new Throwable();
        }
        return E(obj, hVar, cVar, th);
    }

    public static a E(Object obj, h hVar, c cVar, Throwable th) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Bitmap) || (obj instanceof d)) {
            int i10 = f17281f;
            if (i10 == 1) {
                return new c(obj, hVar, cVar, th);
            }
            if (i10 == 2) {
                return new g(obj, hVar, cVar, th);
            }
            if (i10 == 3) {
                return new e(obj);
            }
        }
        return new b(obj, hVar, cVar, th);
    }

    public static a j(a aVar) {
        if (aVar != null) {
            return aVar.h();
        }
        return null;
    }

    public static List k(Collection collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(j((a) it.next()));
        }
        return arrayList;
    }

    public static void m(a aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    public static void n(Iterable iterable) {
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                m((a) it.next());
            }
        }
    }

    public static boolean y(a aVar) {
        if (aVar == null || !aVar.w()) {
            return false;
        }
        return true;
    }

    public static a z(Closeable closeable) {
        return B(closeable, f17282g);
    }

    public abstract a b();

    public void close() {
        synchronized (this) {
            try {
                if (!this.f17284a) {
                    this.f17284a = true;
                    this.f17285b.d();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public synchronized a h() {
        if (!w()) {
            return null;
        }
        return b();
    }

    public synchronized Object p() {
        l.i(!this.f17284a);
        return l.g(this.f17285b.f());
    }

    public int v() {
        if (w()) {
            return System.identityHashCode(this.f17285b.f());
        }
        return 0;
    }

    public synchronized boolean w() {
        return !this.f17284a;
    }

    protected a(Object obj, h hVar, c cVar, Throwable th, boolean z10) {
        this.f17285b = new i(obj, hVar, z10);
        this.f17286c = cVar;
        this.f17287d = th;
    }
}
