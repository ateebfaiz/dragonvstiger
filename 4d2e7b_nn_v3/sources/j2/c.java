package j2;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: s  reason: collision with root package name */
    private static final AtomicBoolean f22153s = new AtomicBoolean(false);

    /* renamed from: t  reason: collision with root package name */
    private static c f22154t;

    /* renamed from: u  reason: collision with root package name */
    private static final AtomicBoolean f22155u = new AtomicBoolean(false);

    /* renamed from: v  reason: collision with root package name */
    private static final Map f22156v = new ConcurrentHashMap();

    /* renamed from: w  reason: collision with root package name */
    private static final Map f22157w = new ConcurrentHashMap();

    /* renamed from: x  reason: collision with root package name */
    public static final b f22158x = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Set f22159a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f22160b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f22161c;

    /* renamed from: d  reason: collision with root package name */
    private final Class f22162d;

    /* renamed from: e  reason: collision with root package name */
    private final Class f22163e;

    /* renamed from: f  reason: collision with root package name */
    private final Class f22164f;

    /* renamed from: g  reason: collision with root package name */
    private final Class f22165g;

    /* renamed from: h  reason: collision with root package name */
    private final Class f22166h;

    /* renamed from: i  reason: collision with root package name */
    private final Class f22167i;

    /* renamed from: j  reason: collision with root package name */
    private final Class f22168j;

    /* renamed from: k  reason: collision with root package name */
    private final Method f22169k;

    /* renamed from: l  reason: collision with root package name */
    private final Method f22170l;

    /* renamed from: m  reason: collision with root package name */
    private final Method f22171m;

    /* renamed from: n  reason: collision with root package name */
    private final Method f22172n;

    /* renamed from: o  reason: collision with root package name */
    private final Method f22173o;

    /* renamed from: p  reason: collision with root package name */
    private final Method f22174p;

    /* renamed from: q  reason: collision with root package name */
    private final Method f22175q;

    /* renamed from: r  reason: collision with root package name */
    private final g f22176r;

    public static final class a implements InvocationHandler {
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (v5.a.d(this)) {
                return null;
            }
            try {
                m.f(obj, "proxy");
                m.f(method, "m");
                if (m.b(method.getName(), "onBillingSetupFinished")) {
                    c.f22158x.f().set(true);
                } else {
                    String name = method.getName();
                    m.e(name, "m.name");
                    if (j.p(name, "onBillingServiceDisconnected", false, 2, (Object) null)) {
                        c.f22158x.f().set(false);
                    }
                }
                return null;
            } catch (Throwable th) {
                v5.a.b(th, this);
                return null;
            }
        }
    }

    public static final class b {
        private b() {
        }

        private final Object a(Context context, Class cls) {
            Object c10;
            Object c11;
            Class a10 = h.a("com.android.billingclient.api.BillingClient$Builder");
            Class a11 = h.a("com.android.billingclient.api.PurchasesUpdatedListener");
            if (a10 == null || a11 == null) {
                return null;
            }
            Method b10 = h.b(cls, "newBuilder", Context.class);
            Method b11 = h.b(a10, "enablePendingPurchases", new Class[0]);
            Method b12 = h.b(a10, "setListener", a11);
            Method b13 = h.b(a10, "build", new Class[0]);
            if (b10 == null || b11 == null || b12 == null || b13 == null || (c10 = h.c(cls, b10, (Object) null, context)) == null) {
                return null;
            }
            Object newProxyInstance = Proxy.newProxyInstance(a11.getClassLoader(), new Class[]{a11}, new d());
            m.e(newProxyInstance, "Proxy.newProxyInstance(\n…UpdatedListenerWrapper())");
            Object c12 = h.c(a10, b12, c10, newProxyInstance);
            if (c12 == null || (c11 = h.c(a10, b11, c12, new Object[0])) == null) {
                return null;
            }
            return h.c(a10, b13, c11, new Object[0]);
        }

        private final void b(Context context) {
            g b10 = g.f22197i.b();
            if (b10 != null) {
                Class a10 = h.a("com.android.billingclient.api.BillingClient");
                Class a11 = h.a("com.android.billingclient.api.Purchase");
                Class a12 = h.a("com.android.billingclient.api.Purchase$PurchasesResult");
                Class a13 = h.a("com.android.billingclient.api.SkuDetails");
                Class a14 = h.a("com.android.billingclient.api.PurchaseHistoryRecord");
                Class a15 = h.a("com.android.billingclient.api.SkuDetailsResponseListener");
                Class a16 = h.a("com.android.billingclient.api.PurchaseHistoryResponseListener");
                if (a10 == null || a12 == null || a11 == null || a13 == null || a15 == null || a14 == null || a16 == null) {
                    return;
                }
                Class<String> cls = String.class;
                Method b11 = h.b(a10, "queryPurchases", cls);
                Method b12 = h.b(a12, "getPurchasesList", new Class[0]);
                Method b13 = h.b(a11, "getOriginalJson", new Class[0]);
                Method b14 = h.b(a13, "getOriginalJson", new Class[0]);
                Method b15 = h.b(a14, "getOriginalJson", new Class[0]);
                Method b16 = h.b(a10, "querySkuDetailsAsync", b10.e(), a15);
                Method b17 = h.b(a10, "queryPurchaseHistoryAsync", cls, a16);
                if (b11 == null || b12 == null || b13 == null || b14 == null || b15 == null || b16 == null || b17 == null) {
                    return;
                }
                Object a17 = a(context, a10);
                if (a17 != null) {
                    c.m(new c(context, a17, a10, a12, a11, a13, a14, a15, a16, b11, b12, b13, b14, b15, b16, b17, b10, (DefaultConstructorMarker) null));
                    c f10 = c.f();
                    if (f10 != null) {
                        c.n(f10);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper");
                }
                return;
            }
        }

        public final synchronized c c(Context context) {
            m.f(context, "context");
            if (c.e().get()) {
                return c.f();
            }
            b(context);
            c.e().set(true);
            return c.f();
        }

        public final Map d() {
            return c.g();
        }

        public final Map e() {
            return c.j();
        }

        public final AtomicBoolean f() {
            return c.k();
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: j2.c$c  reason: collision with other inner class name */
    public final class C0294c implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f22177a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f22178b;

        public C0294c(c cVar, Runnable runnable) {
            m.f(runnable, "runnable");
            this.f22178b = cVar;
            this.f22177a = runnable;
        }

        private final void a(List list) {
            if (!v5.a.d(this)) {
                try {
                    for (Object c10 : list) {
                        try {
                            Object c11 = h.c(c.h(this.f22178b), c.b(this.f22178b), c10, new Object[0]);
                            if (!(c11 instanceof String)) {
                                c11 = null;
                            }
                            String str = (String) c11;
                            if (str != null) {
                                JSONObject jSONObject = new JSONObject(str);
                                jSONObject.put("packageName", c.a(this.f22178b).getPackageName());
                                if (jSONObject.has("productId")) {
                                    String string = jSONObject.getString("productId");
                                    c.d(this.f22178b).add(string);
                                    Map d10 = c.f22158x.d();
                                    m.e(string, "skuID");
                                    d10.put(string, jSONObject);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    this.f22177a.run();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            List list;
            if (v5.a.d(this)) {
                return null;
            }
            try {
                m.f(obj, "proxy");
                m.f(method, FirebaseAnalytics.Param.METHOD);
                if (m.b(method.getName(), "onPurchaseHistoryResponse")) {
                    if (objArr != null) {
                        list = objArr[1];
                    } else {
                        list = null;
                    }
                    if (list != null && (list instanceof List)) {
                        a(list);
                    }
                }
                return null;
            } catch (Throwable th) {
                v5.a.b(th, this);
                return null;
            }
        }
    }

    public static final class d implements InvocationHandler {
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (v5.a.d(this)) {
                return null;
            }
            try {
                m.f(obj, "proxy");
                m.f(method, "m");
                return null;
            } catch (Throwable th) {
                v5.a.b(th, this);
                return null;
            }
        }
    }

    public final class e implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f22179a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f22180b;

        public e(c cVar, Runnable runnable) {
            m.f(runnable, "runnable");
            this.f22180b = cVar;
            this.f22179a = runnable;
        }

        public final void a(List list) {
            if (!v5.a.d(this)) {
                try {
                    m.f(list, "skuDetailsObjectList");
                    for (Object c10 : list) {
                        try {
                            Object c11 = h.c(c.i(this.f22180b), c.c(this.f22180b), c10, new Object[0]);
                            if (!(c11 instanceof String)) {
                                c11 = null;
                            }
                            String str = (String) c11;
                            if (str != null) {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("productId")) {
                                    String string = jSONObject.getString("productId");
                                    Map e10 = c.f22158x.e();
                                    m.e(string, "skuID");
                                    e10.put(string, jSONObject);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    this.f22179a.run();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            List list;
            if (v5.a.d(this)) {
                return null;
            }
            try {
                m.f(obj, "proxy");
                m.f(method, "m");
                if (m.b(method.getName(), "onSkuDetailsResponse")) {
                    if (objArr != null) {
                        list = objArr[1];
                    } else {
                        list = null;
                    }
                    if (list != null && (list instanceof List)) {
                        a(list);
                    }
                }
                return null;
            } catch (Throwable th) {
                v5.a.b(th, this);
                return null;
            }
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22181a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f22182b;

        f(c cVar, Runnable runnable) {
            this.f22181a = cVar;
            this.f22182b = runnable;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    c.l(this.f22181a, "inapp", new ArrayList(c.d(this.f22181a)), this.f22182b);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public /* synthetic */ c(Context context, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, g gVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, gVar);
    }

    public static final /* synthetic */ Context a(c cVar) {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return cVar.f22160b;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Method b(c cVar) {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return cVar.f22173o;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Method c(c cVar) {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return cVar.f22172n;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Set d(c cVar) {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return cVar.f22159a;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean e() {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f22153s;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ c f() {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f22154t;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Map g() {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f22156v;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Class h(c cVar) {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return cVar.f22166h;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Class i(c cVar) {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return cVar.f22165g;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Map j() {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f22157w;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean k() {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f22155u;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void l(c cVar, String str, List list, Runnable runnable) {
        Class<c> cls = c.class;
        if (!v5.a.d(cls)) {
            try {
                cVar.r(str, list, runnable);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void m(c cVar) {
        Class<c> cls = c.class;
        if (!v5.a.d(cls)) {
            try {
                f22154t = cVar;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void n(c cVar) {
        Class<c> cls = c.class;
        if (!v5.a.d(cls)) {
            try {
                cVar.s();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void q(String str, Runnable runnable) {
        if (!v5.a.d(this)) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(this.f22168j.getClassLoader(), new Class[]{this.f22168j}, new C0294c(this, runnable));
                m.e(newProxyInstance, "Proxy.newProxyInstance(\n…istenerWrapper(runnable))");
                h.c(this.f22162d, this.f22175q, this.f22161c, str, newProxyInstance);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void r(String str, List list, Runnable runnable) {
        if (!v5.a.d(this)) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(this.f22167i.getClassLoader(), new Class[]{this.f22167i}, new e(this, runnable));
                m.e(newProxyInstance, "Proxy.newProxyInstance(\n…istenerWrapper(runnable))");
                Object d10 = this.f22176r.d(str, list);
                h.c(this.f22162d, this.f22174p, this.f22161c, d10, newProxyInstance);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void s() {
        Method b10;
        if (!v5.a.d(this)) {
            try {
                Class a10 = h.a("com.android.billingclient.api.BillingClientStateListener");
                if (a10 != null && (b10 = h.b(this.f22162d, "startConnection", a10)) != null) {
                    Object newProxyInstance = Proxy.newProxyInstance(a10.getClassLoader(), new Class[]{a10}, new a());
                    m.e(newProxyInstance, "Proxy.newProxyInstance(\n…ntStateListenerWrapper())");
                    h.c(this.f22162d, b10, this.f22161c, newProxyInstance);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void o(String str, Runnable runnable) {
        if (!v5.a.d(this)) {
            try {
                m.f(str, "skuType");
                m.f(runnable, "querySkuRunnable");
                Object c10 = h.c(this.f22163e, this.f22170l, h.c(this.f22162d, this.f22169k, this.f22161c, "inapp"), new Object[0]);
                if (!(c10 instanceof List)) {
                    c10 = null;
                }
                List<Object> list = (List) c10;
                if (list != null) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (Object c11 : list) {
                            Object c12 = h.c(this.f22164f, this.f22171m, c11, new Object[0]);
                            if (!(c12 instanceof String)) {
                                c12 = null;
                            }
                            String str2 = (String) c12;
                            if (str2 != null) {
                                JSONObject jSONObject = new JSONObject(str2);
                                if (jSONObject.has("productId")) {
                                    String string = jSONObject.getString("productId");
                                    arrayList.add(string);
                                    Map map = f22156v;
                                    m.e(string, "skuID");
                                    map.put(string, jSONObject);
                                }
                            }
                        }
                        r(str, arrayList, runnable);
                    } catch (JSONException unused) {
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void p(String str, Runnable runnable) {
        if (!v5.a.d(this)) {
            try {
                m.f(str, "skuType");
                m.f(runnable, "queryPurchaseHistoryRunnable");
                q(str, new f(this, runnable));
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private c(Context context, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, g gVar) {
        this.f22160b = context;
        this.f22161c = obj;
        this.f22162d = cls;
        this.f22163e = cls2;
        this.f22164f = cls3;
        this.f22165g = cls4;
        this.f22166h = cls5;
        this.f22167i = cls6;
        this.f22168j = cls7;
        this.f22169k = method;
        this.f22170l = method2;
        this.f22171m = method3;
        this.f22172n = method4;
        this.f22173o = method5;
        this.f22174p = method6;
        this.f22175q = method7;
        this.f22176r = gVar;
        this.f22159a = new CopyOnWriteArraySet();
    }
}
