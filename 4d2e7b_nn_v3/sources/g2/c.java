package g2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import com.facebook.l;
import com.facebook.o;
import g2.a;
import g2.d;
import h2.f;
import io.jsonwebtoken.JwtParser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import q5.b0;
import q5.p0;
import q5.r;
import q5.s;

public final class c {

    /* renamed from: f  reason: collision with root package name */
    private static final String f21647f = c.class.getCanonicalName();

    /* renamed from: g  reason: collision with root package name */
    private static c f21648g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f21649h = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Handler f21650a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f21651b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f21652c;

    /* renamed from: d  reason: collision with root package name */
    private HashSet f21653d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap f21654e;

    public static final class a {
        private a() {
        }

        public final synchronized c a() {
            c a10;
            try {
                if (c.a() == null) {
                    c.d(new c((DefaultConstructorMarker) null));
                }
                a10 = c.a();
                if (a10 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
                }
            } catch (Throwable th) {
                throw th;
            }
            return a10;
        }

        public final Bundle b(h2.a aVar, View view, View view2) {
            List<h2.b> c10;
            List list;
            m.f(view, "rootView");
            m.f(view2, "hostView");
            Bundle bundle = new Bundle();
            if (!(aVar == null || (c10 = aVar.c()) == null)) {
                for (h2.b bVar : c10) {
                    if (bVar.d() == null || bVar.d().length() <= 0) {
                        if (bVar.b().size() > 0) {
                            if (m.b(bVar.c(), "relative")) {
                                C0281c.a aVar2 = C0281c.f21657f;
                                List b10 = bVar.b();
                                String simpleName = view2.getClass().getSimpleName();
                                m.e(simpleName, "hostView.javaClass.simpleName");
                                list = aVar2.a(aVar, view2, b10, 0, -1, simpleName);
                            } else {
                                C0281c.a aVar3 = C0281c.f21657f;
                                List b11 = bVar.b();
                                String simpleName2 = view.getClass().getSimpleName();
                                m.e(simpleName2, "rootView.javaClass.simpleName");
                                list = aVar3.a(aVar, view, b11, 0, -1, simpleName2);
                            }
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                b bVar2 = (b) it.next();
                                if (bVar2.a() != null) {
                                    String k10 = f.k(bVar2.a());
                                    if (k10.length() > 0) {
                                        bundle.putString(bVar.a(), k10);
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        bundle.putString(bVar.a(), bVar.d());
                    }
                }
            }
            return bundle;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f21655a;

        /* renamed from: b  reason: collision with root package name */
        private final String f21656b;

        public b(View view, String str) {
            m.f(view, "view");
            m.f(str, "viewMapKey");
            this.f21655a = new WeakReference(view);
            this.f21656b = str;
        }

        public final View a() {
            WeakReference weakReference = this.f21655a;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public final String b() {
            return this.f21656b;
        }
    }

    /* renamed from: g2.c$c  reason: collision with other inner class name */
    public static final class C0281c implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {

        /* renamed from: f  reason: collision with root package name */
        public static final a f21657f = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f21658a;

        /* renamed from: b  reason: collision with root package name */
        private List f21659b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f21660c;

        /* renamed from: d  reason: collision with root package name */
        private final HashSet f21661d;

        /* renamed from: e  reason: collision with root package name */
        private final String f21662e;

        /* renamed from: g2.c$c$a */
        public static final class a {
            private a() {
            }

            private final List b(ViewGroup viewGroup) {
                ArrayList arrayList = new ArrayList();
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    m.e(childAt, "child");
                    if (childAt.getVisibility() == 0) {
                        arrayList.add(childAt);
                    }
                }
                return arrayList;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0068, code lost:
                if ((!kotlin.jvm.internal.m.b(r10.getClass().getSimpleName(), (java.lang.String) r12.get(r12.size() - 1))) != false) goto L_0x006a;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private final boolean c(android.view.View r10, h2.c r11, int r12) {
                /*
                    r9 = this;
                    int r0 = r11.e()
                    r1 = -1
                    r2 = 0
                    if (r0 == r1) goto L_0x000f
                    int r0 = r11.e()
                    if (r12 == r0) goto L_0x000f
                    return r2
                L_0x000f:
                    java.lang.Class r12 = r10.getClass()
                    java.lang.String r12 = r12.getCanonicalName()
                    java.lang.String r0 = r11.a()
                    boolean r12 = kotlin.jvm.internal.m.b(r12, r0)
                    r0 = 1
                    r12 = r12 ^ r0
                    if (r12 == 0) goto L_0x006b
                    java.lang.String r12 = r11.a()
                    kotlin.text.h r1 = new kotlin.text.h
                    java.lang.String r3 = ".*android\\..*"
                    r1.<init>((java.lang.String) r3)
                    boolean r12 = r1.c(r12)
                    if (r12 == 0) goto L_0x006a
                    java.lang.String r3 = r11.a()
                    java.lang.String r12 = "."
                    java.lang.String[] r4 = new java.lang.String[]{r12}
                    r7 = 6
                    r8 = 0
                    r5 = 0
                    r6 = 0
                    java.util.List r12 = kotlin.text.j.v0(r3, r4, r5, r6, r7, r8)
                    r1 = r12
                    java.util.Collection r1 = (java.util.Collection) r1
                    boolean r1 = r1.isEmpty()
                    r1 = r1 ^ r0
                    if (r1 == 0) goto L_0x006a
                    int r1 = r12.size()
                    int r1 = r1 - r0
                    java.lang.Object r12 = r12.get(r1)
                    java.lang.String r12 = (java.lang.String) r12
                    java.lang.Class r1 = r10.getClass()
                    java.lang.String r1 = r1.getSimpleName()
                    boolean r12 = kotlin.jvm.internal.m.b(r1, r12)
                    r12 = r12 ^ r0
                    if (r12 == 0) goto L_0x006b
                L_0x006a:
                    return r2
                L_0x006b:
                    int r12 = r11.f()
                    h2.c$b r1 = h2.c.b.f21874b
                    int r1 = r1.a()
                    r12 = r12 & r1
                    if (r12 <= 0) goto L_0x0083
                    int r12 = r11.d()
                    int r1 = r10.getId()
                    if (r12 == r1) goto L_0x0083
                    return r2
                L_0x0083:
                    int r12 = r11.f()
                    h2.c$b r1 = h2.c.b.f21875c
                    int r1 = r1.a()
                    r12 = r12 & r1
                    java.lang.String r1 = ""
                    if (r12 <= 0) goto L_0x00b1
                    java.lang.String r12 = r11.h()
                    java.lang.String r3 = h2.f.k(r10)
                    java.lang.String r4 = q5.p0.C0(r3)
                    java.lang.String r4 = q5.p0.j(r4, r1)
                    boolean r3 = kotlin.jvm.internal.m.b(r12, r3)
                    r3 = r3 ^ r0
                    if (r3 == 0) goto L_0x00b1
                    boolean r12 = kotlin.jvm.internal.m.b(r12, r4)
                    r12 = r12 ^ r0
                    if (r12 == 0) goto L_0x00b1
                    return r2
                L_0x00b1:
                    int r12 = r11.f()
                    h2.c$b r3 = h2.c.b.f21877e
                    int r3 = r3.a()
                    r12 = r12 & r3
                    if (r12 <= 0) goto L_0x00e9
                    java.lang.String r12 = r11.b()
                    java.lang.CharSequence r3 = r10.getContentDescription()
                    if (r3 != 0) goto L_0x00ca
                    r3 = r1
                    goto L_0x00d2
                L_0x00ca:
                    java.lang.CharSequence r3 = r10.getContentDescription()
                    java.lang.String r3 = r3.toString()
                L_0x00d2:
                    java.lang.String r4 = q5.p0.C0(r3)
                    java.lang.String r4 = q5.p0.j(r4, r1)
                    boolean r3 = kotlin.jvm.internal.m.b(r12, r3)
                    r3 = r3 ^ r0
                    if (r3 == 0) goto L_0x00e9
                    boolean r12 = kotlin.jvm.internal.m.b(r12, r4)
                    r12 = r12 ^ r0
                    if (r12 == 0) goto L_0x00e9
                    return r2
                L_0x00e9:
                    int r12 = r11.f()
                    h2.c$b r3 = h2.c.b.f21878f
                    int r3 = r3.a()
                    r12 = r12 & r3
                    if (r12 <= 0) goto L_0x0115
                    java.lang.String r12 = r11.c()
                    java.lang.String r3 = h2.f.i(r10)
                    java.lang.String r4 = q5.p0.C0(r3)
                    java.lang.String r4 = q5.p0.j(r4, r1)
                    boolean r3 = kotlin.jvm.internal.m.b(r12, r3)
                    r3 = r3 ^ r0
                    if (r3 == 0) goto L_0x0115
                    boolean r12 = kotlin.jvm.internal.m.b(r12, r4)
                    r12 = r12 ^ r0
                    if (r12 == 0) goto L_0x0115
                    return r2
                L_0x0115:
                    int r12 = r11.f()
                    h2.c$b r3 = h2.c.b.f21876d
                    int r3 = r3.a()
                    r12 = r12 & r3
                    if (r12 <= 0) goto L_0x014d
                    java.lang.String r11 = r11.g()
                    java.lang.Object r12 = r10.getTag()
                    if (r12 != 0) goto L_0x012e
                    r10 = r1
                    goto L_0x0136
                L_0x012e:
                    java.lang.Object r10 = r10.getTag()
                    java.lang.String r10 = r10.toString()
                L_0x0136:
                    java.lang.String r12 = q5.p0.C0(r10)
                    java.lang.String r12 = q5.p0.j(r12, r1)
                    boolean r10 = kotlin.jvm.internal.m.b(r11, r10)
                    r10 = r10 ^ r0
                    if (r10 == 0) goto L_0x014d
                    boolean r10 = kotlin.jvm.internal.m.b(r11, r12)
                    r10 = r10 ^ r0
                    if (r10 == 0) goto L_0x014d
                    return r2
                L_0x014d:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: g2.c.C0281c.a.c(android.view.View, h2.c, int):boolean");
            }

            public final List a(h2.a aVar, View view, List list, int i10, int i11, String str) {
                m.f(list, "path");
                m.f(str, "mapKey");
                String str2 = str + JwtParser.SEPARATOR_CHAR + i11;
                ArrayList arrayList = new ArrayList();
                if (view == null) {
                    return arrayList;
                }
                if (i10 >= list.size()) {
                    arrayList.add(new b(view, str2));
                } else {
                    h2.c cVar = (h2.c) list.get(i10);
                    if (m.b(cVar.a(), "..")) {
                        ViewParent parent = view.getParent();
                        if (parent instanceof ViewGroup) {
                            List b10 = b((ViewGroup) parent);
                            int size = b10.size();
                            for (int i12 = 0; i12 < size; i12++) {
                                arrayList.addAll(a(aVar, (View) b10.get(i12), list, i10 + 1, i12, str2));
                            }
                        }
                        return arrayList;
                    } else if (m.b(cVar.a(), com.alibaba.pdns.f.G)) {
                        arrayList.add(new b(view, str2));
                        return arrayList;
                    } else if (!c(view, cVar, i11)) {
                        return arrayList;
                    } else {
                        if (i10 == list.size() - 1) {
                            arrayList.add(new b(view, str2));
                        }
                    }
                }
                if (view instanceof ViewGroup) {
                    List b11 = b((ViewGroup) view);
                    int size2 = b11.size();
                    for (int i13 = 0; i13 < size2; i13++) {
                        arrayList.addAll(a(aVar, (View) b11.get(i13), list, i10 + 1, i13, str2));
                    }
                }
                return arrayList;
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public C0281c(View view, Handler handler, HashSet hashSet, String str) {
            m.f(handler, "handler");
            m.f(hashSet, "listenerSet");
            m.f(str, "activityName");
            this.f21658a = new WeakReference(view);
            this.f21660c = handler;
            this.f21661d = hashSet;
            this.f21662e = str;
            handler.postDelayed(this, 200);
        }

        private final void a(b bVar, View view, h2.a aVar) {
            if (aVar != null) {
                try {
                    View a10 = bVar.a();
                    if (a10 != null) {
                        View a11 = f.a(a10);
                        if (a11 == null || !f.f21888d.p(a10, a11)) {
                            String name = a10.getClass().getName();
                            m.e(name, "view.javaClass.name");
                            if (!j.F(name, "com.facebook.react", false, 2, (Object) null)) {
                                if (!(a10 instanceof AdapterView)) {
                                    b(bVar, view, aVar);
                                } else if (a10 instanceof ListView) {
                                    c(bVar, view, aVar);
                                }
                            }
                        } else {
                            d(bVar, view, aVar);
                        }
                    }
                } catch (Exception e10) {
                    p0.e0(c.b(), e10);
                }
            }
        }

        private final void b(b bVar, View view, h2.a aVar) {
            boolean z10;
            View a10 = bVar.a();
            if (a10 != null) {
                String b10 = bVar.b();
                View.OnClickListener g10 = f.g(a10);
                if (g10 instanceof a.C0279a) {
                    if (g10 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                    } else if (((a.C0279a) g10).a()) {
                        z10 = true;
                        if (!this.f21661d.contains(b10) && !z10) {
                            a10.setOnClickListener(a.a(aVar, view, a10));
                            this.f21661d.add(b10);
                            return;
                        }
                    }
                }
                z10 = false;
                if (!this.f21661d.contains(b10)) {
                }
            }
        }

        private final void c(b bVar, View view, h2.a aVar) {
            boolean z10;
            AdapterView adapterView = (AdapterView) bVar.a();
            if (adapterView != null) {
                String b10 = bVar.b();
                AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
                if (onItemClickListener instanceof a.b) {
                    if (onItemClickListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                    } else if (((a.b) onItemClickListener).a()) {
                        z10 = true;
                        if (!this.f21661d.contains(b10) && !z10) {
                            adapterView.setOnItemClickListener(a.b(aVar, view, adapterView));
                            this.f21661d.add(b10);
                            return;
                        }
                    }
                }
                z10 = false;
                if (!this.f21661d.contains(b10)) {
                }
            }
        }

        private final void d(b bVar, View view, h2.a aVar) {
            boolean z10;
            View a10 = bVar.a();
            if (a10 != null) {
                String b10 = bVar.b();
                View.OnTouchListener h10 = f.h(a10);
                if (h10 instanceof d.a) {
                    if (h10 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                    } else if (((d.a) h10).a()) {
                        z10 = true;
                        if (!this.f21661d.contains(b10) && !z10) {
                            a10.setOnTouchListener(d.a(aVar, view, a10));
                            this.f21661d.add(b10);
                            return;
                        }
                    }
                }
                z10 = false;
                if (!this.f21661d.contains(b10)) {
                }
            }
        }

        private final void e(h2.a aVar, View view) {
            if (aVar != null && view != null) {
                String a10 = aVar.a();
                if (a10 == null || a10.length() == 0 || !(!m.b(aVar.a(), this.f21662e))) {
                    List d10 = aVar.d();
                    if (d10.size() <= 25) {
                        for (b a11 : f21657f.a(aVar, view, d10, 0, -1, this.f21662e)) {
                            a(a11, view, aVar);
                        }
                    }
                }
            }
        }

        private final void f() {
            List list = this.f21659b;
            if (list != null && this.f21658a.get() != null) {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    e((h2.a) list.get(i10), (View) this.f21658a.get());
                }
            }
        }

        public void onGlobalLayout() {
            f();
        }

        public void onScrollChanged() {
            f();
        }

        public void run() {
            View view;
            if (!v5.a.d(this)) {
                try {
                    r j10 = s.j(o.g());
                    if (j10 == null) {
                        return;
                    }
                    if (j10.b()) {
                        List b10 = h2.a.f21843j.b(j10.e());
                        this.f21659b = b10;
                        if (b10 != null && (view = (View) this.f21658a.get()) != null) {
                            m.e(view, "rootView.get() ?: return");
                            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                            m.e(viewTreeObserver, "observer");
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.addOnGlobalLayoutListener(this);
                                viewTreeObserver.addOnScrollChangedListener(this);
                            }
                            f();
                        }
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f21663a;

        d(c cVar) {
            this.f21663a = cVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    c.c(this.f21663a);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private c() {
        this.f21650a = new Handler(Looper.getMainLooper());
        Set newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        m.e(newSetFromMap, "Collections.newSetFromMap(WeakHashMap())");
        this.f21651b = newSetFromMap;
        this.f21652c = new LinkedHashSet();
        this.f21653d = new HashSet();
        this.f21654e = new HashMap();
    }

    public static final /* synthetic */ c a() {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21648g;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String b() {
        Class<c> cls = c.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21647f;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void c(c cVar) {
        Class<c> cls = c.class;
        if (!v5.a.d(cls)) {
            try {
                cVar.g();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void d(c cVar) {
        Class<c> cls = c.class;
        if (!v5.a.d(cls)) {
            try {
                f21648g = cVar;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void g() {
        if (!v5.a.d(this)) {
            try {
                for (Activity activity : this.f21651b) {
                    if (activity != null) {
                        View e10 = l2.b.e(activity);
                        String simpleName = activity.getClass().getSimpleName();
                        m.e(simpleName, "activity.javaClass.simpleName");
                        this.f21652c.add(new C0281c(e10, this.f21650a, this.f21653d, simpleName));
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void i() {
        if (!v5.a.d(this)) {
            try {
                Thread currentThread = Thread.currentThread();
                Looper mainLooper = Looper.getMainLooper();
                m.e(mainLooper, "Looper.getMainLooper()");
                if (currentThread == mainLooper.getThread()) {
                    g();
                } else {
                    this.f21650a.post(new d(this));
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void e(Activity activity) {
        if (!v5.a.d(this)) {
            try {
                m.f(activity, "activity");
                if (!b0.b()) {
                    Thread currentThread = Thread.currentThread();
                    Looper mainLooper = Looper.getMainLooper();
                    m.e(mainLooper, "Looper.getMainLooper()");
                    if (currentThread == mainLooper.getThread()) {
                        this.f21651b.add(activity);
                        this.f21653d.clear();
                        HashSet hashSet = (HashSet) this.f21654e.get(Integer.valueOf(activity.hashCode()));
                        if (hashSet != null) {
                            m.e(hashSet, "it");
                            this.f21653d = hashSet;
                        }
                        i();
                        return;
                    }
                    throw new l("Can't add activity to CodelessMatcher on non-UI thread");
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void f(Activity activity) {
        if (!v5.a.d(this)) {
            try {
                m.f(activity, "activity");
                this.f21654e.remove(Integer.valueOf(activity.hashCode()));
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void h(Activity activity) {
        if (!v5.a.d(this)) {
            try {
                m.f(activity, "activity");
                if (!b0.b()) {
                    Thread currentThread = Thread.currentThread();
                    Looper mainLooper = Looper.getMainLooper();
                    m.e(mainLooper, "Looper.getMainLooper()");
                    if (currentThread == mainLooper.getThread()) {
                        this.f21651b.remove(activity);
                        this.f21652c.clear();
                        HashMap hashMap = this.f21654e;
                        Integer valueOf = Integer.valueOf(activity.hashCode());
                        Object clone = this.f21653d.clone();
                        if (clone != null) {
                            hashMap.put(valueOf, (HashSet) clone);
                            this.f21653d.clear();
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashSet<kotlin.String> /* = java.util.HashSet<kotlin.String> */");
                    }
                    throw new l("Can't remove activity from CodelessMatcher on non-UI thread");
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
