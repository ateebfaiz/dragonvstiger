package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.uimanager.k2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class e2 {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f3583a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map f3584b = new HashMap();

    private static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private final Map f3585a;

        public void a(Map map) {
            for (k2.m mVar : this.f3585a.values()) {
                map.put(mVar.a(), mVar.b());
            }
        }

        public void c(t0 t0Var, String str, Object obj) {
            k2.m mVar = (k2.m) this.f3585a.get(str);
            if (mVar != null) {
                mVar.d(t0Var, obj);
            }
        }

        private a(Class cls) {
            this.f3585a = k2.h(cls);
        }
    }

    private static class b implements e {

        /* renamed from: a  reason: collision with root package name */
        private final Map f3586a;

        public void a(Map map) {
            for (k2.m mVar : this.f3586a.values()) {
                map.put(mVar.a(), mVar.b());
            }
        }

        public void b(ViewManager viewManager, View view, String str, Object obj) {
            k2.m mVar = (k2.m) this.f3586a.get(str);
            if (mVar != null) {
                mVar.e(viewManager, view, obj);
            }
        }

        private b(Class cls) {
            this.f3586a = k2.i(cls);
        }
    }

    public interface c {
        void a(Map map);
    }

    public interface d extends c {
        void c(t0 t0Var, String str, Object obj);
    }

    public interface e extends c {
        void b(ViewManager viewManager, View view, String str, Object obj);
    }

    public static void a() {
        k2.b();
        f3583a.clear();
        f3584b.clear();
    }

    private static Object b(Class cls) {
        String name = cls.getName();
        try {
            return Class.forName(name + "$$PropsSetter").newInstance();
        } catch (ClassNotFoundException unused) {
            z2.a.G("ViewManagerPropertyUpdater", "Could not find generated setter for " + cls);
            return null;
        } catch (IllegalAccessException | InstantiationException e10) {
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e10);
        }
    }

    private static e c(Class cls) {
        Map map = f3583a;
        e eVar = (e) map.get(cls);
        if (eVar == null) {
            eVar = (e) b(cls);
            if (eVar == null) {
                eVar = new b(cls);
            }
            map.put(cls, eVar);
        }
        return eVar;
    }

    private static d d(Class cls) {
        Map map = f3584b;
        d dVar = (d) map.get(cls);
        if (dVar == null) {
            dVar = (d) b(cls);
            if (dVar == null) {
                dVar = new a(cls);
            }
            map.put(cls, dVar);
        }
        return dVar;
    }

    public static Map e(Class cls, Class cls2) {
        HashMap hashMap = new HashMap();
        c(cls).a(hashMap);
        d(cls2).a(hashMap);
        return hashMap;
    }

    public static void f(t0 t0Var, v0 v0Var) {
        d d10 = d(t0Var.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = v0Var.f3960a.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry next = entryIterator.next();
            d10.c(t0Var, (String) next.getKey(), next.getValue());
        }
    }

    public static void g(ViewManager viewManager, View view, v0 v0Var) {
        e c10 = c(viewManager.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = v0Var.f3960a.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry next = entryIterator.next();
            c10.b(viewManager, view, (String) next.getKey(), next.getValue());
        }
    }

    public static void h(c2 c2Var, View view, v0 v0Var) {
        Iterator<Map.Entry<String, Object>> entryIterator = v0Var.f3960a.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry next = entryIterator.next();
            c2Var.b(view, (String) next.getKey(), next.getValue());
        }
    }
}
