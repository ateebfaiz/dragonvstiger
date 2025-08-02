package c3;

import java.util.IdentityHashMap;
import java.util.Map;
import y2.l;

public class i {

    /* renamed from: d  reason: collision with root package name */
    private static final Map f17291d = new IdentityHashMap();

    /* renamed from: a  reason: collision with root package name */
    private Object f17292a;

    /* renamed from: b  reason: collision with root package name */
    private int f17293b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final h f17294c;

    public static class a extends RuntimeException {
        public a() {
            super("Null shared reference");
        }
    }

    public i(Object obj, h hVar, boolean z10) {
        this.f17292a = l.g(obj);
        this.f17294c = hVar;
        if (z10) {
            a(obj);
        }
    }

    private static void a(Object obj) {
        Map map = f17291d;
        synchronized (map) {
            try {
                Integer num = (Integer) map.get(obj);
                if (num == null) {
                    map.put(obj, 1);
                } else {
                    map.put(obj, Integer.valueOf(num.intValue() + 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized int c() {
        boolean z10;
        int i10;
        e();
        if (this.f17293b > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        i10 = this.f17293b - 1;
        this.f17293b = i10;
        return i10;
    }

    private void e() {
        if (!h(this)) {
            throw new a();
        }
    }

    public static boolean h(i iVar) {
        if (iVar == null || !iVar.g()) {
            return false;
        }
        return true;
    }

    private static void i(Object obj) {
        Map map = f17291d;
        synchronized (map) {
            try {
                Integer num = (Integer) map.get(obj);
                if (num == null) {
                    z2.a.M("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
                } else if (num.intValue() == 1) {
                    map.remove(obj);
                } else {
                    map.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void b() {
        e();
        this.f17293b++;
    }

    public void d() {
        Object obj;
        if (c() == 0) {
            synchronized (this) {
                obj = this.f17292a;
                this.f17292a = null;
            }
            if (obj != null) {
                h hVar = this.f17294c;
                if (hVar != null) {
                    hVar.release(obj);
                }
                i(obj);
            }
        }
    }

    public synchronized Object f() {
        return this.f17292a;
    }

    public synchronized boolean g() {
        boolean z10;
        if (this.f17293b > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }
}
