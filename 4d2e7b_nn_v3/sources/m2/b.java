package m2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;
import m2.d;

public final class b {

    /* renamed from: m  reason: collision with root package name */
    private static final Map f22489m = i0.g(t.a("embedding.weight", "embed.weight"), t.a("dense1.weight", "fc1.weight"), t.a("dense2.weight", "fc2.weight"), t.a("dense3.weight", "fc3.weight"), t.a("dense1.bias", "fc1.bias"), t.a("dense2.bias", "fc2.bias"), t.a("dense3.bias", "fc3.bias"));

    /* renamed from: n  reason: collision with root package name */
    public static final a f22490n = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a f22491a;

    /* renamed from: b  reason: collision with root package name */
    private final a f22492b;

    /* renamed from: c  reason: collision with root package name */
    private final a f22493c;

    /* renamed from: d  reason: collision with root package name */
    private final a f22494d;

    /* renamed from: e  reason: collision with root package name */
    private final a f22495e;

    /* renamed from: f  reason: collision with root package name */
    private final a f22496f;

    /* renamed from: g  reason: collision with root package name */
    private final a f22497g;

    /* renamed from: h  reason: collision with root package name */
    private final a f22498h;

    /* renamed from: i  reason: collision with root package name */
    private final a f22499i;

    /* renamed from: j  reason: collision with root package name */
    private final a f22500j;

    /* renamed from: k  reason: collision with root package name */
    private final a f22501k;

    /* renamed from: l  reason: collision with root package name */
    private final Map f22502l;

    public static final class a {
        private a() {
        }

        private final Map b(File file) {
            Map c10 = g.c(file);
            if (c10 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Map a10 = b.a();
            for (Map.Entry entry : c10.entrySet()) {
                String str = (String) entry.getKey();
                if (a10.containsKey(entry.getKey()) && (str = (String) a10.get(entry.getKey())) == null) {
                    return null;
                }
                hashMap.put(str, entry.getValue());
            }
            return hashMap;
        }

        public final b a(File file) {
            m.f(file, "file");
            Map b10 = b(file);
            if (b10 != null) {
                try {
                    return new b(b10, (DefaultConstructorMarker) null);
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private b(Map map) {
        Object obj = map.get("embed.weight");
        if (obj != null) {
            this.f22491a = (a) obj;
            Object obj2 = map.get("convs.0.weight");
            if (obj2 != null) {
                this.f22492b = f.l((a) obj2);
                Object obj3 = map.get("convs.1.weight");
                if (obj3 != null) {
                    this.f22493c = f.l((a) obj3);
                    Object obj4 = map.get("convs.2.weight");
                    if (obj4 != null) {
                        this.f22494d = f.l((a) obj4);
                        Object obj5 = map.get("convs.0.bias");
                        if (obj5 != null) {
                            this.f22495e = (a) obj5;
                            Object obj6 = map.get("convs.1.bias");
                            if (obj6 != null) {
                                this.f22496f = (a) obj6;
                                Object obj7 = map.get("convs.2.bias");
                                if (obj7 != null) {
                                    this.f22497g = (a) obj7;
                                    Object obj8 = map.get("fc1.weight");
                                    if (obj8 != null) {
                                        this.f22498h = f.k((a) obj8);
                                        Object obj9 = map.get("fc2.weight");
                                        if (obj9 != null) {
                                            this.f22499i = f.k((a) obj9);
                                            Object obj10 = map.get("fc1.bias");
                                            if (obj10 != null) {
                                                this.f22500j = (a) obj10;
                                                Object obj11 = map.get("fc2.bias");
                                                if (obj11 != null) {
                                                    this.f22501k = (a) obj11;
                                                    this.f22502l = new HashMap();
                                                    for (String str : r0.h(d.a.MTML_INTEGRITY_DETECT.a(), d.a.MTML_APP_EVENT_PREDICTION.a())) {
                                                        String str2 = str + ".weight";
                                                        String str3 = str + ".bias";
                                                        a aVar = (a) map.get(str2);
                                                        a aVar2 = (a) map.get(str3);
                                                        if (aVar != null) {
                                                            this.f22502l.put(str2, f.k(aVar));
                                                        }
                                                        if (aVar2 != null) {
                                                            this.f22502l.put(str3, aVar2);
                                                        }
                                                    }
                                                    return;
                                                }
                                                throw new IllegalStateException("Required value was null.".toString());
                                            }
                                            throw new IllegalStateException("Required value was null.".toString());
                                        }
                                        throw new IllegalStateException("Required value was null.".toString());
                                    }
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final /* synthetic */ Map a() {
        Class<b> cls = b.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f22489m;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public final a b(a aVar, String[] strArr, String str) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            m.f(aVar, "dense");
            m.f(strArr, "texts");
            m.f(str, "task");
            a c10 = f.c(f.e(strArr, 128, this.f22491a), this.f22492b);
            f.a(c10, this.f22495e);
            f.i(c10);
            a c11 = f.c(c10, this.f22493c);
            f.a(c11, this.f22496f);
            f.i(c11);
            a g10 = f.g(c11, 2);
            a c12 = f.c(g10, this.f22494d);
            f.a(c12, this.f22497g);
            f.i(c12);
            a g11 = f.g(c10, c10.b(1));
            a g12 = f.g(g10, g10.b(1));
            a g13 = f.g(c12, c12.b(1));
            f.f(g11, 1);
            f.f(g12, 1);
            f.f(g13, 1);
            a d10 = f.d(f.b(new a[]{g11, g12, g13, aVar}), this.f22498h, this.f22500j);
            f.i(d10);
            a d11 = f.d(d10, this.f22499i, this.f22501k);
            f.i(d11);
            Map map = this.f22502l;
            a aVar2 = (a) map.get(str + ".weight");
            Map map2 = this.f22502l;
            a aVar3 = (a) map2.get(str + ".bias");
            if (aVar2 != null) {
                if (aVar3 != null) {
                    a d12 = f.d(d11, aVar2, aVar3);
                    f.j(d12);
                    return d12;
                }
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public /* synthetic */ b(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }
}
