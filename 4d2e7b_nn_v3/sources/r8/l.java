package r8;

import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.q;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import q8.b;

public class l extends k {

    /* renamed from: c  reason: collision with root package name */
    protected final l8.l f12963c;

    /* renamed from: d  reason: collision with root package name */
    protected final ConcurrentHashMap f12964d;

    /* renamed from: e  reason: collision with root package name */
    protected final Map f12965e;

    /* renamed from: f  reason: collision with root package name */
    protected final boolean f12966f;

    protected l(l8.l lVar, j jVar, ConcurrentHashMap concurrentHashMap, HashMap hashMap) {
        super(jVar, lVar.B());
        this.f12963c = lVar;
        this.f12964d = concurrentHashMap;
        this.f12965e = hashMap;
        this.f12966f = lVar.F(q.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    protected static String d(Class cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return name;
        }
        return name.substring(lastIndexOf + 1);
    }

    public static l e(l8.l lVar, j jVar, Collection collection, boolean z10, boolean z11) {
        HashMap hashMap;
        ConcurrentHashMap concurrentHashMap;
        String str;
        if (z10 != z11) {
            if (z10) {
                concurrentHashMap = new ConcurrentHashMap();
                hashMap = null;
            } else {
                hashMap = new HashMap();
                concurrentHashMap = new ConcurrentHashMap(4);
            }
            boolean F = lVar.F(q.ACCEPT_CASE_INSENSITIVE_VALUES);
            if (collection != null) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    Class b10 = bVar.b();
                    if (bVar.c()) {
                        str = bVar.a();
                    } else {
                        str = d(b10);
                    }
                    if (z10) {
                        concurrentHashMap.put(b10.getName(), str);
                    }
                    if (z11) {
                        if (F) {
                            str = str.toLowerCase();
                        }
                        j jVar2 = (j) hashMap.get(str);
                        if (jVar2 == null || !b10.isAssignableFrom(jVar2.s())) {
                            hashMap.put(str, lVar.e(b10));
                        }
                    }
                }
            }
            return new l(lVar, jVar, concurrentHashMap, hashMap);
        }
        throw new IllegalArgumentException();
    }

    public String a(Object obj) {
        return f(obj.getClass());
    }

    public String c(Object obj, Class cls) {
        if (obj == null) {
            return f(cls);
        }
        return a(obj);
    }

    /* access modifiers changed from: protected */
    public String f(Class cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        String str = (String) this.f12964d.get(name);
        if (str == null) {
            Class s10 = this.f12961a.E(cls).s();
            if (this.f12963c.E()) {
                str = this.f12963c.h().T(this.f12963c.D(s10).k());
            }
            if (str == null) {
                str = d(s10);
            }
            this.f12964d.put(name, str);
        }
        return str;
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", new Object[]{getClass().getName(), this.f12965e});
    }
}
