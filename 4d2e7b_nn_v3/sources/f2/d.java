package f2;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.h;
import kotlin.text.j;

public final class d implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* renamed from: e  reason: collision with root package name */
    private static final Map f21508e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static final a f21509f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Set f21510a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f21511b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference f21512c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f21513d;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final String c(String str, String str2) {
            if (m.b("r2", str)) {
                return new h("[^\\d.]").d(str2, "");
            }
            return str2;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
            if (r7.equals("r5") != false) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
            if (r7.equals("r4") != false) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
            r8 = new kotlin.text.h("[^a-z]+").d(r8, "");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(java.util.Map r6, java.lang.String r7, java.lang.String r8) {
            /*
                r5 = this;
                int r0 = r7.hashCode()
                r1 = 0
                r2 = 2
                r3 = 0
                switch(r0) {
                    case 3585: goto L_0x005b;
                    case 3586: goto L_0x0045;
                    case 3587: goto L_0x003c;
                    case 3588: goto L_0x000c;
                    default: goto L_0x000a;
                }
            L_0x000a:
                goto L_0x0080
            L_0x000c:
                java.lang.String r0 = "r6"
                boolean r0 = r7.equals(r0)
                if (r0 == 0) goto L_0x0080
                java.lang.String r0 = "-"
                boolean r1 = kotlin.text.j.K(r8, r0, r3, r2, r1)
                if (r1 == 0) goto L_0x0080
                kotlin.text.h r1 = new kotlin.text.h
                r1.<init>((java.lang.String) r0)
                java.util.List r8 = r1.e(r8, r3)
                java.util.Collection r8 = (java.util.Collection) r8
                java.lang.String[] r0 = new java.lang.String[r3]
                java.lang.Object[] r8 = r8.toArray(r0)
                if (r8 == 0) goto L_0x0034
                java.lang.String[] r8 = (java.lang.String[]) r8
                r8 = r8[r3]
                goto L_0x0080
            L_0x0034:
                java.lang.NullPointerException r6 = new java.lang.NullPointerException
                java.lang.String r7 = "null cannot be cast to non-null type kotlin.Array<T>"
                r6.<init>(r7)
                throw r6
            L_0x003c:
                java.lang.String r0 = "r5"
                boolean r0 = r7.equals(r0)
                if (r0 == 0) goto L_0x0080
                goto L_0x004d
            L_0x0045:
                java.lang.String r0 = "r4"
                boolean r0 = r7.equals(r0)
                if (r0 == 0) goto L_0x0080
            L_0x004d:
                kotlin.text.h r0 = new kotlin.text.h
                java.lang.String r1 = "[^a-z]+"
                r0.<init>((java.lang.String) r1)
                java.lang.String r1 = ""
                java.lang.String r8 = r0.d(r8, r1)
                goto L_0x0080
            L_0x005b:
                java.lang.String r0 = "r3"
                boolean r0 = r7.equals(r0)
                if (r0 == 0) goto L_0x0080
                java.lang.String r0 = "m"
                boolean r4 = kotlin.text.j.F(r8, r0, r3, r2, r1)
                if (r4 != 0) goto L_0x007f
                java.lang.String r4 = "b"
                boolean r4 = kotlin.text.j.F(r8, r4, r3, r2, r1)
                if (r4 != 0) goto L_0x007f
                java.lang.String r4 = "ge"
                boolean r8 = kotlin.text.j.F(r8, r4, r3, r2, r1)
                if (r8 == 0) goto L_0x007c
                goto L_0x007f
            L_0x007c:
                java.lang.String r8 = "f"
                goto L_0x0080
            L_0x007f:
                r8 = r0
            L_0x0080:
                r6.put(r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f2.d.a.d(java.util.Map, java.lang.String, java.lang.String):void");
        }

        public final void e(Activity activity) {
            m.f(activity, "activity");
            int hashCode = activity.hashCode();
            Map a10 = d.a();
            Integer valueOf = Integer.valueOf(hashCode);
            Object obj = a10.get(valueOf);
            if (obj == null) {
                obj = new d(activity, (DefaultConstructorMarker) null);
                a10.put(valueOf, obj);
            }
            d.c((d) obj);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f21514a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f21515b;

        b(d dVar, View view) {
            this.f21514a = dVar;
            this.f21515b = view;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    View view = this.f21515b;
                    if (view instanceof EditText) {
                        d.b(this.f21514a, view);
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private d(Activity activity) {
        this.f21510a = new LinkedHashSet();
        this.f21511b = new Handler(Looper.getMainLooper());
        this.f21512c = new WeakReference(activity);
        this.f21513d = new AtomicBoolean(false);
    }

    public static final /* synthetic */ Map a() {
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f21508e;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void b(d dVar, View view) {
        Class<d> cls = d.class;
        if (!v5.a.d(cls)) {
            try {
                dVar.e(view);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void c(d dVar) {
        Class<d> cls = d.class;
        if (!v5.a.d(cls)) {
            try {
                dVar.g();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void d(View view) {
        if (!v5.a.d(this)) {
            try {
                f(new b(this, view));
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void e(View view) {
        if (!v5.a.d(this)) {
            if (view != null) {
                try {
                    String obj = ((EditText) view).getText().toString();
                    if (obj != null) {
                        String obj2 = j.P0(obj).toString();
                        if (obj2 != null) {
                            String lowerCase = obj2.toLowerCase();
                            m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                            if (lowerCase.length() != 0) {
                                if (this.f21510a.contains(lowerCase)) {
                                    return;
                                }
                                if (lowerCase.length() <= 100) {
                                    this.f21510a.add(lowerCase);
                                    HashMap hashMap = new HashMap();
                                    List b10 = b.b(view);
                                    List list = null;
                                    for (c cVar : c.f21504e.c()) {
                                        a aVar = f21509f;
                                        String a10 = aVar.c(cVar.c(), lowerCase);
                                        if (cVar.d().length() <= 0 || b.f(a10, cVar.d())) {
                                            if (b.e(b10, cVar.b())) {
                                                aVar.d(hashMap, cVar.c(), a10);
                                            } else {
                                                if (list == null) {
                                                    list = b.a(view);
                                                }
                                                if (b.e(list, cVar.b())) {
                                                    aVar.d(hashMap, cVar.c(), a10);
                                                }
                                            }
                                        }
                                    }
                                    e2.m.f21204b.d(hashMap);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
            }
        }
    }

    private final void f(Runnable runnable) {
        if (!v5.a.d(this)) {
            try {
                Thread currentThread = Thread.currentThread();
                Looper mainLooper = Looper.getMainLooper();
                m.e(mainLooper, "Looper.getMainLooper()");
                if (currentThread == mainLooper.getThread()) {
                    runnable.run();
                } else {
                    this.f21511b.post(runnable);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void g() {
        View e10;
        if (!v5.a.d(this)) {
            try {
                if (!this.f21513d.getAndSet(true) && (e10 = l2.b.e((Activity) this.f21512c.get())) != null) {
                    ViewTreeObserver viewTreeObserver = e10.getViewTreeObserver();
                    m.e(viewTreeObserver, "observer");
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalFocusChangeListener(this);
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        if (!v5.a.d(this)) {
            if (view != null) {
                try {
                    d(view);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                    return;
                }
            }
            if (view2 != null) {
                d(view2);
            }
        }
    }

    public /* synthetic */ d(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }
}
