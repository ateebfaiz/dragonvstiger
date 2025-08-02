package x4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private final d0 f24798a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedHashMap f24799b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private int f24800c = 0;

    public m(d0 d0Var) {
        this.f24798a = d0Var;
    }

    private int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return this.f24798a.a(obj);
    }

    public synchronized boolean a(Object obj) {
        return this.f24799b.containsKey(obj);
    }

    public synchronized Object b(Object obj) {
        return this.f24799b.get(obj);
    }

    public synchronized int c() {
        return this.f24799b.size();
    }

    public synchronized Object d() {
        Object obj;
        if (this.f24799b.isEmpty()) {
            obj = null;
        } else {
            obj = this.f24799b.keySet().iterator().next();
        }
        return obj;
    }

    public synchronized ArrayList e(y2.m mVar) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList(this.f24799b.entrySet().size());
            for (Map.Entry entry : this.f24799b.entrySet()) {
                if (mVar != null) {
                    if (mVar.apply(entry.getKey())) {
                    }
                }
                arrayList.add(entry);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized int f() {
        return this.f24800c;
    }

    public synchronized Object h(Object obj, Object obj2) {
        Object remove;
        remove = this.f24799b.remove(obj);
        this.f24800c -= g(remove);
        this.f24799b.put(obj, obj2);
        this.f24800c += g(obj2);
        return remove;
    }

    public synchronized Object i(Object obj) {
        Object remove;
        remove = this.f24799b.remove(obj);
        this.f24800c -= g(remove);
        return remove;
    }

    public synchronized ArrayList j(y2.m mVar) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.f24799b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (mVar != null) {
                    if (mVar.apply(entry.getKey())) {
                    }
                }
                arrayList.add(entry.getValue());
                this.f24800c -= g(entry.getValue());
                it.remove();
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized void k() {
        if (this.f24799b.isEmpty()) {
            this.f24800c = 0;
        }
    }
}
