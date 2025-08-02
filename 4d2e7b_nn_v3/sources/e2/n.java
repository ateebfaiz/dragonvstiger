package e2;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class n implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21206b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f21207a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        public static final a f21208b = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f21209a;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(HashMap hashMap) {
            m.f(hashMap, "proxyEvents");
            this.f21209a = hashMap;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new n(this.f21209a);
        }
    }

    public n() {
        this.f21207a = new HashMap();
    }

    private final Object writeReplace() throws ObjectStreamException {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return new b(this.f21207a);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public final void a(a aVar, List list) {
        if (!v5.a.d(this)) {
            try {
                m.f(aVar, "accessTokenAppIdPair");
                m.f(list, "appEvents");
                if (!this.f21207a.containsKey(aVar)) {
                    this.f21207a.put(aVar, r.y0(list));
                    return;
                }
                List list2 = (List) this.f21207a.get(aVar);
                if (list2 != null) {
                    list2.addAll(list);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final List b(a aVar) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            m.f(aVar, "accessTokenAppIdPair");
            return (List) this.f21207a.get(aVar);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public final Set c() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            Set keySet = this.f21207a.keySet();
            m.e(keySet, "events.keys");
            return keySet;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public n(HashMap hashMap) {
        m.f(hashMap, "appEventMap");
        HashMap hashMap2 = new HashMap();
        this.f21207a = hashMap2;
        hashMap2.putAll(hashMap);
    }
}
