package com.bugsnag.android;

import c1.u;
import com.bugsnag.android.k2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;

public final class y2 implements k2.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f19153c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Map f19154a;

    /* renamed from: b  reason: collision with root package name */
    private final g3 f19155b;

    public static final class a {
        private a() {
        }

        private final void a(Map map, String str, Map map2) {
            Object obj = map.get(str);
            Object obj2 = map2.get(str);
            if (obj2 != null) {
                if (!(obj instanceof Map) || !(obj2 instanceof Map)) {
                    map.put(str, obj2);
                    return;
                }
                map.put(str, c(r.o((Map) obj, (Map) obj2)));
            } else if (obj != null) {
                map.put(str, obj);
            }
        }

        public final y2 b(y2... y2VarArr) {
            ArrayList arrayList = new ArrayList(y2VarArr.length);
            int length = y2VarArr.length;
            int i10 = 0;
            int i11 = 0;
            while (i11 < length) {
                y2 y2Var = y2VarArr[i11];
                i11++;
                arrayList.add(y2Var.n());
            }
            ArrayList arrayList2 = new ArrayList();
            int length2 = y2VarArr.length;
            while (i10 < length2) {
                y2 y2Var2 = y2VarArr[i10];
                i10++;
                r.z(arrayList2, y2Var2.g().c());
            }
            y2 y2Var3 = new y2(c0.d(c(arrayList)));
            y2Var3.m(r.A0(arrayList2));
            return y2Var3;
        }

        public final Map c(List list) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                r.z(arrayList, ((Map) it.next()).keySet());
            }
            Set<String> A0 = r.A0(arrayList);
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Map map = (Map) it2.next();
                for (String a10 : A0) {
                    a(concurrentHashMap, a10, map);
                }
            }
            return concurrentHashMap;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public y2() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    private final void l(Map map, String str, Object obj) {
        Object obj2 = map.get(str);
        if (obj2 != null && (obj instanceof Map)) {
            obj = f19153c.c(r.o((Map) obj2, (Map) obj));
        }
        map.put(str, obj);
    }

    public void a(String str, String str2, Object obj) {
        if (obj == null) {
            d(str, str2);
            return;
        }
        Map map = (Map) this.f19154a.get(str);
        if (map == null) {
            map = new ConcurrentHashMap();
        }
        this.f19154a.put(str, map);
        l(map, str2, obj);
    }

    public void b(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            a(str, (String) entry.getKey(), entry.getValue());
        }
    }

    public void c(String str) {
        this.f19154a.remove(str);
    }

    public void d(String str, String str2) {
        Map map = (Map) this.f19154a.get(str);
        if (map != null) {
            map.remove(str2);
        }
        if (map == null || map.isEmpty()) {
            this.f19154a.remove(str);
        }
    }

    public final y2 e() {
        y2 f10 = f(n());
        f10.m(r.A0(j()));
        return f10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y2) && m.b(this.f19154a, ((y2) obj).f19154a);
    }

    public final y2 f(Map map) {
        return new y2(map);
    }

    public final g3 g() {
        return this.f19155b;
    }

    public Object h(String str, String str2) {
        Map i10 = i(str);
        if (i10 == null) {
            return null;
        }
        return i10.get(str2);
    }

    public int hashCode() {
        return this.f19154a.hashCode();
    }

    public Map i(String str) {
        return (Map) this.f19154a.get(str);
    }

    public final Set j() {
        return this.f19155b.c();
    }

    public final Map k() {
        return this.f19154a;
    }

    public final void m(Set set) {
        this.f19155b.h(set);
    }

    public final Map n() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(this.f19154a);
        for (Map.Entry entry : this.f19154a.entrySet()) {
            concurrentHashMap.put(entry.getKey(), new ConcurrentHashMap((Map) entry.getValue()));
        }
        return concurrentHashMap;
    }

    public final u o(int i10) {
        int i11 = 0;
        int i12 = 0;
        for (Map.Entry value : this.f19154a.entrySet()) {
            u e10 = c1.r.f17269a.e(i10, c0.d(value.getValue()));
            i11 += e10.d();
            i12 += e10.c();
        }
        return new u(i11, i12);
    }

    public void toStream(k2 k2Var) {
        this.f19155b.f(this.f19154a, k2Var, true);
    }

    public String toString() {
        return "Metadata(store=" + this.f19154a + ')';
    }

    public y2(Map map) {
        this.f19154a = map;
        this.f19155b = new g3();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y2(Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new ConcurrentHashMap() : map);
    }
}
