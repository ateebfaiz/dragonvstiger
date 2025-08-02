package l8;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class i {
    public static i b() {
        return a.b();
    }

    public abstract Object a(Object obj);

    public abstract i c(Object obj, Object obj2);

    public static class a extends i implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        protected static final a f12709c = new a(Collections.emptyMap());

        /* renamed from: d  reason: collision with root package name */
        protected static final Object f12710d = new Object();

        /* renamed from: a  reason: collision with root package name */
        protected final Map f12711a;

        /* renamed from: b  reason: collision with root package name */
        protected transient Map f12712b;

        protected a(Map map) {
            this.f12711a = map;
            this.f12712b = null;
        }

        public static i b() {
            return f12709c;
        }

        public Object a(Object obj) {
            Object obj2;
            Map map = this.f12712b;
            if (map == null || (obj2 = map.get(obj)) == null) {
                return this.f12711a.get(obj);
            }
            if (obj2 == f12710d) {
                return null;
            }
            return obj2;
        }

        public i c(Object obj, Object obj2) {
            if (obj2 == null) {
                if (this.f12711a.containsKey(obj)) {
                    obj2 = f12710d;
                } else {
                    Map map = this.f12712b;
                    if (map != null && map.containsKey(obj)) {
                        this.f12712b.remove(obj);
                    }
                    return this;
                }
            }
            Map map2 = this.f12712b;
            if (map2 == null) {
                return d(obj, obj2);
            }
            map2.put(obj, obj2);
            return this;
        }

        /* access modifiers changed from: protected */
        public i d(Object obj, Object obj2) {
            HashMap hashMap = new HashMap();
            if (obj2 == null) {
                obj2 = f12710d;
            }
            hashMap.put(obj, obj2);
            return new a(this.f12711a, hashMap);
        }

        protected a(Map map, Map map2) {
            this.f12711a = map;
            this.f12712b = map2;
        }
    }
}
