package ab;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout;
import com.facebook.react.views.text.ReactTextView;
import com.facebook.react.views.textinput.ReactEditText;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class o extends d {
    public static final b Q = new b((DefaultConstructorMarker) null);
    private static final a R = new a();
    private boolean N;
    private boolean O;
    private d P = R;

    public static final class a implements d {
        a() {
        }

        public boolean a() {
            return d.a.f(this);
        }

        public Boolean b(d dVar) {
            return d.a.g(this, dVar);
        }

        public boolean c(MotionEvent motionEvent) {
            return d.a.c(this, motionEvent);
        }

        public boolean d() {
            return d.a.h(this);
        }

        public boolean e(View view) {
            return d.a.b(this, view);
        }

        public void f(MotionEvent motionEvent) {
            d.a.d(this, motionEvent);
        }

        public Boolean g(View view, MotionEvent motionEvent) {
            return d.a.e(this, view, motionEvent);
        }

        public void h(MotionEvent motionEvent) {
            d.a.a(this, motionEvent);
        }
    }

    public static final class b {
        private b() {
        }

        /* access modifiers changed from: private */
        public final boolean b(View view, MotionEvent motionEvent) {
            if (!(view instanceof ViewGroup) || !((ViewGroup) view).onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        private final o f2412a;

        /* renamed from: b  reason: collision with root package name */
        private final ReactEditText f2413b;

        /* renamed from: c  reason: collision with root package name */
        private float f2414c;

        /* renamed from: d  reason: collision with root package name */
        private float f2415d;

        /* renamed from: e  reason: collision with root package name */
        private int f2416e;

        public c(o oVar, ReactEditText reactEditText) {
            m.f(oVar, "handler");
            m.f(reactEditText, "editText");
            this.f2412a = oVar;
            this.f2413b = reactEditText;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(reactEditText.getContext());
            this.f2416e = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
        }

        public boolean a() {
            return true;
        }

        public Boolean b(d dVar) {
            boolean z10;
            m.f(dVar, "handler");
            if (dVar.R() <= 0 || (dVar instanceof o)) {
                z10 = false;
            } else {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }

        public boolean c(MotionEvent motionEvent) {
            return d.a.c(this, motionEvent);
        }

        public boolean d() {
            return true;
        }

        public boolean e(View view) {
            return d.a.b(this, view);
        }

        public void f(MotionEvent motionEvent) {
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            this.f2412a.i();
            this.f2413b.onTouchEvent(motionEvent);
            this.f2414c = motionEvent.getX();
            this.f2415d = motionEvent.getY();
        }

        public Boolean g(View view, MotionEvent motionEvent) {
            return d.a.e(this, view, motionEvent);
        }

        public void h(MotionEvent motionEvent) {
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            if (((motionEvent.getX() - this.f2414c) * (motionEvent.getX() - this.f2414c)) + ((motionEvent.getY() - this.f2415d) * (motionEvent.getY() - this.f2415d)) < ((float) this.f2416e)) {
                this.f2413b.L();
            }
        }
    }

    public interface d {

        public static final class a {
            public static void a(d dVar, MotionEvent motionEvent) {
                m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            }

            public static boolean b(d dVar, View view) {
                m.f(view, "view");
                return view.isPressed();
            }

            public static boolean c(d dVar, MotionEvent motionEvent) {
                m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
                return true;
            }

            public static void d(d dVar, MotionEvent motionEvent) {
                m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            }

            public static Boolean e(d dVar, View view, MotionEvent motionEvent) {
                m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
                if (view != null) {
                    return Boolean.valueOf(view.onTouchEvent(motionEvent));
                }
                return null;
            }

            public static boolean f(d dVar) {
                return false;
            }

            public static Boolean g(d dVar, d dVar2) {
                m.f(dVar2, "handler");
                return null;
            }

            public static boolean h(d dVar) {
                return false;
            }
        }

        boolean a();

        Boolean b(d dVar);

        boolean c(MotionEvent motionEvent);

        boolean d();

        boolean e(View view);

        void f(MotionEvent motionEvent);

        Boolean g(View view, MotionEvent motionEvent);

        void h(MotionEvent motionEvent);
    }

    private static final class e implements d {
        public boolean a() {
            return d.a.f(this);
        }

        public Boolean b(d dVar) {
            return d.a.g(this, dVar);
        }

        public boolean c(MotionEvent motionEvent) {
            return d.a.c(this, motionEvent);
        }

        public boolean d() {
            return d.a.h(this);
        }

        public boolean e(View view) {
            return d.a.b(this, view);
        }

        public void f(MotionEvent motionEvent) {
            d.a.d(this, motionEvent);
        }

        public Boolean g(View view, MotionEvent motionEvent) {
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            if (view != null) {
                return Boolean.valueOf(view.dispatchTouchEvent(motionEvent));
            }
            return null;
        }

        public void h(MotionEvent motionEvent) {
            d.a.a(this, motionEvent);
        }
    }

    private static final class f implements d {
        public boolean a() {
            return true;
        }

        public Boolean b(d dVar) {
            return d.a.g(this, dVar);
        }

        public boolean c(MotionEvent motionEvent) {
            return d.a.c(this, motionEvent);
        }

        public boolean d() {
            return d.a.h(this);
        }

        public boolean e(View view) {
            return d.a.b(this, view);
        }

        public void f(MotionEvent motionEvent) {
            d.a.d(this, motionEvent);
        }

        public Boolean g(View view, MotionEvent motionEvent) {
            return d.a.e(this, view, motionEvent);
        }

        public void h(MotionEvent motionEvent) {
            d.a.a(this, motionEvent);
        }
    }

    private static final class g implements d {

        /* renamed from: a  reason: collision with root package name */
        private final o f2417a;

        /* renamed from: b  reason: collision with root package name */
        private final ReactSwipeRefreshLayout f2418b;

        public g(o oVar, ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
            m.f(oVar, "handler");
            m.f(reactSwipeRefreshLayout, "swipeRefreshLayout");
            this.f2417a = oVar;
            this.f2418b = reactSwipeRefreshLayout;
        }

        public boolean a() {
            return d.a.f(this);
        }

        public Boolean b(d dVar) {
            return d.a.g(this, dVar);
        }

        public boolean c(MotionEvent motionEvent) {
            return d.a.c(this, motionEvent);
        }

        public boolean d() {
            return true;
        }

        public boolean e(View view) {
            return d.a.b(this, view);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(android.view.MotionEvent r4) {
            /*
                r3 = this;
                java.lang.String r0 = "event"
                kotlin.jvm.internal.m.f(r4, r0)
                com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout r4 = r3.f2418b
                r0 = 0
                android.view.View r4 = r4.getChildAt(r0)
                boolean r0 = r4 instanceof android.widget.ScrollView
                r1 = 0
                if (r0 == 0) goto L_0x0014
                android.widget.ScrollView r4 = (android.widget.ScrollView) r4
                goto L_0x0015
            L_0x0014:
                r4 = r1
            L_0x0015:
                if (r4 != 0) goto L_0x0018
                return
            L_0x0018:
                ab.o r0 = r3.f2417a
                ab.g r0 = r0.N()
                if (r0 == 0) goto L_0x0043
                java.util.ArrayList r0 = r0.o(r4)
                if (r0 == 0) goto L_0x0043
                java.util.Iterator r0 = r0.iterator()
            L_0x002a:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x003b
                java.lang.Object r1 = r0.next()
                ab.d r1 = (ab.d) r1
                boolean r2 = r1 instanceof ab.o
                if (r2 == 0) goto L_0x002a
                goto L_0x0043
            L_0x003b:
                java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
                java.lang.String r0 = "Collection contains no element matching the predicate."
                r4.<init>(r0)
                throw r4
            L_0x0043:
                if (r1 == 0) goto L_0x0057
                int r0 = r1.Q()
                r1 = 4
                if (r0 != r1) goto L_0x0057
                int r4 = r4.getScrollY()
                if (r4 <= 0) goto L_0x0057
                ab.o r4 = r3.f2417a
                r4.B()
            L_0x0057:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ab.o.g.f(android.view.MotionEvent):void");
        }

        public Boolean g(View view, MotionEvent motionEvent) {
            return d.a.e(this, view, motionEvent);
        }

        public void h(MotionEvent motionEvent) {
            d.a.a(this, motionEvent);
        }
    }

    private static final class h implements d {
        public boolean a() {
            return d.a.f(this);
        }

        public Boolean b(d dVar) {
            m.f(dVar, "handler");
            return Boolean.FALSE;
        }

        public boolean c(MotionEvent motionEvent) {
            return d.a.c(this, motionEvent);
        }

        public boolean d() {
            return d.a.h(this);
        }

        public boolean e(View view) {
            m.f(view, "view");
            return view instanceof ReactTextView;
        }

        public void f(MotionEvent motionEvent) {
            d.a.d(this, motionEvent);
        }

        public Boolean g(View view, MotionEvent motionEvent) {
            return d.a.e(this, view, motionEvent);
        }

        public void h(MotionEvent motionEvent) {
            d.a.a(this, motionEvent);
        }
    }

    public o() {
        E0(true);
    }

    public boolean I0(d dVar) {
        m.f(dVar, "handler");
        return !this.O;
    }

    public boolean J0(d dVar) {
        m.f(dVar, "handler");
        Boolean b10 = this.P.b(dVar);
        if (b10 != null) {
            return b10.booleanValue();
        }
        if (super.J0(dVar)) {
            return true;
        }
        if ((dVar instanceof o) && dVar.Q() == 4 && ((o) dVar).O) {
            return false;
        }
        boolean z10 = !this.O;
        int Q2 = dVar.Q();
        if ((Q() != 4 || Q2 != 4 || !z10) && Q() == 4 && z10 && (!this.P.a() || dVar.R() > 0)) {
            return true;
        }
        return false;
    }

    public final boolean S0() {
        return this.O;
    }

    public final o T0(boolean z10) {
        this.O = z10;
        return this;
    }

    public final o U0(boolean z10) {
        this.N = z10;
        return this;
    }

    /* access modifiers changed from: protected */
    public void g0() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setAction(3);
        d dVar = this.P;
        View U = U();
        m.c(obtain);
        dVar.g(U, obtain);
        obtain.recycle();
    }

    /* access modifiers changed from: protected */
    public void h0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
        View U = U();
        m.c(U);
        Context context = U.getContext();
        m.e(context, "getContext(...)");
        boolean c10 = com.swmansion.gesturehandler.react.a.c(context);
        if ((U instanceof RNGestureHandlerButtonViewManager.ButtonViewGroup) && c10) {
            return;
        }
        if (motionEvent.getActionMasked() == 1) {
            if (Q() != 0 || this.P.c(motionEvent)) {
                this.P.g(U, motionEvent);
                if ((Q() == 0 || Q() == 2) && this.P.e(U)) {
                    i();
                }
                if (Q() == 0) {
                    o();
                } else {
                    z();
                }
            } else {
                o();
            }
            this.P.h(motionEvent);
        } else if (Q() == 0 || Q() == 2) {
            if (this.N) {
                boolean unused = Q.b(U, motionEvent);
                this.P.g(U, motionEvent);
                i();
            } else if (Q.b(U, motionEvent)) {
                this.P.g(U, motionEvent);
                i();
            } else if (this.P.d()) {
                this.P.f(motionEvent);
            } else if (Q() != 2 && this.P.c(motionEvent)) {
                n();
            }
        } else if (Q() == 4) {
            this.P.g(U, motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void j0() {
        View U = U();
        if (U instanceof d) {
            this.P = (d) U;
        } else if (U instanceof ReactEditText) {
            this.P = new c(this, (ReactEditText) U);
        } else if (U instanceof ReactSwipeRefreshLayout) {
            this.P = new g(this, (ReactSwipeRefreshLayout) U);
        } else if (U instanceof ReactScrollView) {
            this.P = new f();
        } else if (U instanceof ReactHorizontalScrollView) {
            this.P = new f();
        } else if (U instanceof ReactTextView) {
            this.P = new h();
        } else if (U instanceof ReactViewGroup) {
            this.P = new e();
        }
    }

    /* access modifiers changed from: protected */
    public void k0() {
        this.P = R;
    }

    public void o0() {
        super.o0();
        this.N = false;
        this.O = false;
    }
}
