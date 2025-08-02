package com.onesignal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.adjust.sdk.Constants;
import com.onesignal.DraggableRelativeLayout;
import com.onesignal.c5;
import com.onesignal.o3;

class d0 {

    /* renamed from: v  reason: collision with root package name */
    private static final int f10498v = Color.parseColor("#00000000");

    /* renamed from: w  reason: collision with root package name */
    private static final int f10499w = Color.parseColor("#BB000000");

    /* renamed from: x  reason: collision with root package name */
    private static final int f10500x = m3.b(4);

    /* renamed from: a  reason: collision with root package name */
    private PopupWindow f10501a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Activity f10502b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f10503c = new Handler();

    /* renamed from: d  reason: collision with root package name */
    private int f10504d;

    /* renamed from: e  reason: collision with root package name */
    private int f10505e;

    /* renamed from: f  reason: collision with root package name */
    private int f10506f = m3.b(24);

    /* renamed from: g  reason: collision with root package name */
    private int f10507g = m3.b(24);

    /* renamed from: h  reason: collision with root package name */
    private int f10508h = m3.b(24);

    /* renamed from: i  reason: collision with root package name */
    private int f10509i = m3.b(24);

    /* renamed from: j  reason: collision with root package name */
    private double f10510j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f10511k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f10512l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f10513m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f10514n = false;

    /* renamed from: o  reason: collision with root package name */
    private n1 f10515o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public c5.m f10516p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public WebView f10517q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public RelativeLayout f10518r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public DraggableRelativeLayout f10519s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public j f10520t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public Runnable f10521u;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10522a;

        a(int i10) {
            this.f10522a = i10;
        }

        public void run() {
            if (d0.this.f10517q == null) {
                o3.d1(o3.v.WARN, "WebView height update skipped, new height will be used once it is displayed.");
                return;
            }
            ViewGroup.LayoutParams layoutParams = d0.this.f10517q.getLayoutParams();
            if (layoutParams == null) {
                o3.d1(o3.v.WARN, "WebView height update skipped because of null layoutParams, new height will be used once it is displayed.");
                return;
            }
            layoutParams.height = this.f10522a;
            d0.this.f10517q.setLayoutParams(layoutParams);
            if (d0.this.f10519s != null) {
                DraggableRelativeLayout b10 = d0.this.f10519s;
                d0 d0Var = d0.this;
                b10.i(d0Var.F(this.f10522a, d0Var.f10516p, d0.this.f10514n));
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f10524a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f10525b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DraggableRelativeLayout.c f10526c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c5.m f10527d;

        b(RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, DraggableRelativeLayout.c cVar, c5.m mVar) {
            this.f10524a = layoutParams;
            this.f10525b = layoutParams2;
            this.f10526c = cVar;
            this.f10527d = mVar;
        }

        public void run() {
            if (d0.this.f10517q != null) {
                d0.this.f10517q.setLayoutParams(this.f10524a);
                Context applicationContext = d0.this.f10502b.getApplicationContext();
                d0.this.S(applicationContext, this.f10525b, this.f10526c);
                d0.this.T(applicationContext);
                d0 d0Var = d0.this;
                d0Var.H(d0Var.f10518r);
                if (d0.this.f10520t != null) {
                    d0 d0Var2 = d0.this;
                    d0Var2.z(this.f10527d, d0Var2.f10519s, d0.this.f10518r);
                }
                d0.this.Y();
            }
        }
    }

    class c implements DraggableRelativeLayout.b {
        c() {
        }

        public void a() {
            boolean unused = d0.this.f10513m = true;
        }

        public void b() {
            boolean unused = d0.this.f10513m = false;
        }

        public void onDismiss() {
            if (d0.this.f10520t != null) {
                d0.this.f10520t.c();
            }
            d0.this.L((c5.l) null);
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            if (d0.this.f10520t != null) {
                d0.this.f10520t.c();
            }
            if (d0.this.f10502b != null) {
                d0.this.K((c5.l) null);
                Runnable unused = d0.this.f10521u = null;
                return;
            }
            boolean unused2 = d0.this.f10512l = true;
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f10531a;

        e(Activity activity) {
            this.f10531a = activity;
        }

        public void run() {
            d0.this.I(this.f10531a);
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c5.l f10533a;

        f(c5.l lVar) {
            this.f10533a = lVar;
        }

        public void run() {
            if (!d0.this.f10511k || d0.this.f10518r == null) {
                d0.this.C();
                c5.l lVar = this.f10533a;
                if (lVar != null) {
                    lVar.onComplete();
                    return;
                }
                return;
            }
            d0 d0Var = d0.this;
            d0Var.v(d0Var.f10518r, this.f10533a);
        }
    }

    class g implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CardView f10535a;

        g(CardView cardView) {
            this.f10535a = cardView;
        }

        public void onAnimationEnd(Animation animation) {
            if (Build.VERSION.SDK_INT == 23) {
                this.f10535a.setCardElevation((float) m3.b(5));
            }
            if (d0.this.f10520t != null) {
                d0.this.f10520t.b();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c5.l f10537a;

        h(c5.l lVar) {
            this.f10537a = lVar;
        }

        public void onAnimationEnd(Animator animator) {
            d0.this.C();
            c5.l lVar = this.f10537a;
            if (lVar != null) {
                lVar.onComplete();
            }
        }
    }

    static /* synthetic */ class i {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10539a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.onesignal.c5$m[] r0 = com.onesignal.c5.m.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10539a = r0
                com.onesignal.c5$m r1 = com.onesignal.c5.m.TOP_BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10539a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.c5$m r1 = com.onesignal.c5.m.BOTTOM_BANNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10539a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.c5$m r1 = com.onesignal.c5.m.CENTER_MODAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10539a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.onesignal.c5$m r1 = com.onesignal.c5.m.FULL_SCREEN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.d0.i.<clinit>():void");
        }
    }

    interface j {
        void a();

        void b();

        void c();
    }

    d0(WebView webView, n1 n1Var, boolean z10) {
        double d10;
        this.f10517q = webView;
        this.f10516p = n1Var.c();
        this.f10505e = n1Var.d();
        this.f10504d = -1;
        if (n1Var.b() == null) {
            d10 = 0.0d;
        } else {
            d10 = n1Var.b().doubleValue();
        }
        this.f10510j = d10;
        this.f10511k = !this.f10516p.b();
        this.f10514n = z10;
        this.f10515o = n1Var;
        Q(n1Var);
    }

    private void A(View view, int i10, Animation.AnimationListener animationListener) {
        q3.a(view, (float) ((-i10) - this.f10508h), 0.0f, 1000, new s3(0.1d, 8.0d), animationListener).start();
    }

    /* access modifiers changed from: private */
    public void C() {
        P();
        j jVar = this.f10520t;
        if (jVar != null) {
            jVar.a();
        }
    }

    private Animation.AnimationListener D(CardView cardView) {
        return new g(cardView);
    }

    private CardView E(Context context) {
        int i10;
        CardView cardView = new CardView(context);
        if (this.f10516p == c5.m.FULL_SCREEN) {
            i10 = -1;
        } else {
            i10 = -2;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i10);
        layoutParams.addRule(13);
        cardView.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT == 23) {
            cardView.setCardElevation(0.0f);
        } else {
            cardView.setCardElevation((float) m3.b(5));
        }
        cardView.setRadius((float) m3.b(8));
        cardView.setClipChildren(false);
        cardView.setClipToPadding(false);
        cardView.setPreventCornerOverlap(false);
        cardView.setCardBackgroundColor(0);
        return cardView;
    }

    /* access modifiers changed from: private */
    public DraggableRelativeLayout.c F(int i10, c5.m mVar, boolean z10) {
        DraggableRelativeLayout.c cVar = new DraggableRelativeLayout.c();
        cVar.f10266d = this.f10507g;
        cVar.f10264b = this.f10508h;
        cVar.f10270h = z10;
        cVar.f10268f = i10;
        cVar.f10267e = N();
        int i11 = i.f10539a[mVar.ordinal()];
        int i12 = 1;
        if (i11 == 1) {
            cVar.f10265c = this.f10508h - f10500x;
        } else if (i11 != 2) {
            if (i11 != 3) {
                if (i11 == 4) {
                    i10 = N() - (this.f10509i + this.f10508h);
                    cVar.f10268f = i10;
                }
            }
            int N = (N() / 2) - (i10 / 2);
            cVar.f10265c = f10500x + N;
            cVar.f10264b = N;
            cVar.f10263a = N;
        } else {
            cVar.f10263a = N() - i10;
            cVar.f10265c = this.f10509i + f10500x;
        }
        if (mVar == c5.m.TOP_BANNER) {
            i12 = 0;
        }
        cVar.f10269g = i12;
        return cVar;
    }

    private RelativeLayout.LayoutParams G() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f10504d, -1);
        int i10 = i.f10539a[this.f10516p.ordinal()];
        if (i10 == 1) {
            layoutParams.addRule(10);
            layoutParams.addRule(14);
        } else if (i10 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(14);
        } else if (i10 == 3 || i10 == 4) {
            layoutParams.addRule(13);
        }
        return layoutParams;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r5 != 4) goto L_0x0048;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H(android.widget.RelativeLayout r5) {
        /*
            r4 = this;
            android.widget.PopupWindow r0 = new android.widget.PopupWindow
            boolean r1 = r4.f10511k
            r2 = -1
            if (r1 == 0) goto L_0x0009
            r3 = r2
            goto L_0x000b
        L_0x0009:
            int r3 = r4.f10504d
        L_0x000b:
            if (r1 == 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r2 = -2
        L_0x000f:
            r1 = 1
            r0.<init>(r5, r3, r2, r1)
            r4.f10501a = r0
            android.graphics.drawable.ColorDrawable r5 = new android.graphics.drawable.ColorDrawable
            r2 = 0
            r5.<init>(r2)
            r0.setBackgroundDrawable(r5)
            android.widget.PopupWindow r5 = r4.f10501a
            r5.setTouchable(r1)
            android.widget.PopupWindow r5 = r4.f10501a
            r5.setClippingEnabled(r2)
            boolean r5 = r4.f10511k
            if (r5 != 0) goto L_0x0048
            int[] r5 = com.onesignal.d0.i.f10539a
            com.onesignal.c5$m r0 = r4.f10516p
            int r0 = r0.ordinal()
            r5 = r5[r0]
            if (r5 == r1) goto L_0x0045
            r0 = 2
            if (r5 == r0) goto L_0x0042
            r0 = 3
            if (r5 == r0) goto L_0x0049
            r0 = 4
            if (r5 == r0) goto L_0x0049
            goto L_0x0048
        L_0x0042:
            r1 = 81
            goto L_0x0049
        L_0x0045:
            r1 = 49
            goto L_0x0049
        L_0x0048:
            r1 = r2
        L_0x0049:
            com.onesignal.n1 r5 = r4.f10515o
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x0054
            r5 = 1000(0x3e8, float:1.401E-42)
            goto L_0x0056
        L_0x0054:
            r5 = 1003(0x3eb, float:1.406E-42)
        L_0x0056:
            android.widget.PopupWindow r0 = r4.f10501a
            androidx.core.widget.PopupWindowCompat.setWindowLayoutType(r0, r5)
            android.widget.PopupWindow r5 = r4.f10501a
            android.app.Activity r0 = r4.f10502b
            android.view.Window r0 = r0.getWindow()
            android.view.View r0 = r0.getDecorView()
            android.view.View r0 = r0.getRootView()
            r5.showAtLocation(r0, r1, r2, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.d0.H(android.widget.RelativeLayout):void");
    }

    /* access modifiers changed from: private */
    public void I(Activity activity) {
        if (!m3.i(activity) || this.f10518r != null) {
            new Handler().postDelayed(new e(activity), 200);
        } else {
            W(activity);
        }
    }

    private void J() {
        this.f10518r = null;
        this.f10519s = null;
        this.f10517q = null;
    }

    /* access modifiers changed from: private */
    public void L(c5.l lVar) {
        OSUtils.R(new f(lVar), 600);
    }

    private int N() {
        return m3.e(this.f10502b);
    }

    private void Q(n1 n1Var) {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        if (n1Var.e()) {
            i10 = m3.b(24);
        } else {
            i10 = 0;
        }
        this.f10508h = i10;
        if (n1Var.e()) {
            i11 = m3.b(24);
        } else {
            i11 = 0;
        }
        this.f10509i = i11;
        if (n1Var.f()) {
            i12 = m3.b(24);
        } else {
            i12 = 0;
        }
        this.f10506f = i12;
        if (n1Var.f()) {
            i13 = m3.b(24);
        }
        this.f10507g = i13;
    }

    /* access modifiers changed from: private */
    public void S(Context context, RelativeLayout.LayoutParams layoutParams, DraggableRelativeLayout.c cVar) {
        DraggableRelativeLayout draggableRelativeLayout = new DraggableRelativeLayout(context);
        this.f10519s = draggableRelativeLayout;
        if (layoutParams != null) {
            draggableRelativeLayout.setLayoutParams(layoutParams);
        }
        this.f10519s.i(cVar);
        this.f10519s.h(new c());
        if (this.f10517q.getParent() != null) {
            ((ViewGroup) this.f10517q.getParent()).removeAllViews();
        }
        CardView E = E(context);
        E.setTag("IN_APP_MESSAGE_CARD_VIEW_TAG");
        E.addView(this.f10517q);
        this.f10519s.setPadding(this.f10506f, this.f10508h, this.f10507g, this.f10509i);
        this.f10519s.setClipChildren(false);
        this.f10519s.setClipToPadding(false);
        this.f10519s.addView(E);
    }

    /* access modifiers changed from: private */
    public void T(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f10518r = relativeLayout;
        relativeLayout.setBackgroundDrawable(new ColorDrawable(0));
        this.f10518r.setClipChildren(false);
        this.f10518r.setClipToPadding(false);
        this.f10518r.addView(this.f10519s);
    }

    private void V(c5.m mVar, RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, DraggableRelativeLayout.c cVar) {
        OSUtils.S(new b(layoutParams, layoutParams2, cVar, mVar));
    }

    /* access modifiers changed from: private */
    public void Y() {
        if (this.f10510j > 0.0d && this.f10521u == null) {
            d dVar = new d();
            this.f10521u = dVar;
            this.f10503c.postDelayed(dVar, ((long) this.f10510j) * 1000);
        }
    }

    /* access modifiers changed from: private */
    public void v(View view, c5.l lVar) {
        View view2 = view;
        w(view2, Constants.MINIMAL_ERROR_STATUS_CODE, f10499w, f10498v, new h(lVar)).start();
    }

    private ValueAnimator w(View view, int i10, int i11, int i12, Animator.AnimatorListener animatorListener) {
        return q3.b(view, i10, i11, i12, animatorListener);
    }

    private void x(View view, int i10, Animation.AnimationListener animationListener) {
        q3.a(view, (float) (i10 + this.f10509i), 0.0f, 1000, new s3(0.1d, 8.0d), animationListener).start();
    }

    private void y(View view, View view2, Animation.AnimationListener animationListener, Animator.AnimatorListener animatorListener) {
        Animation c10 = q3.c(view, 1000, new s3(0.1d, 8.0d), animationListener);
        ValueAnimator w10 = w(view2, Constants.MINIMAL_ERROR_STATUS_CODE, f10498v, f10499w, animatorListener);
        c10.start();
        w10.start();
    }

    /* access modifiers changed from: private */
    public void z(c5.m mVar, View view, View view2) {
        CardView cardView = (CardView) view.findViewWithTag("IN_APP_MESSAGE_CARD_VIEW_TAG");
        Animation.AnimationListener D = D(cardView);
        int i10 = i.f10539a[mVar.ordinal()];
        if (i10 == 1) {
            A(cardView, this.f10517q.getHeight(), D);
        } else if (i10 == 2) {
            x(cardView, this.f10517q.getHeight(), D);
        } else if (i10 == 3 || i10 == 4) {
            y(view, view2, D, (Animator.AnimatorListener) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void B() {
        if (this.f10512l) {
            this.f10512l = false;
            L((c5.l) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void K(c5.l lVar) {
        DraggableRelativeLayout draggableRelativeLayout = this.f10519s;
        if (draggableRelativeLayout == null) {
            o3.b(o3.v.ERROR, "No host presenter to trigger dismiss animation, counting as dismissed already", new Throwable());
            J();
            if (lVar != null) {
                lVar.onComplete();
                return;
            }
            return;
        }
        draggableRelativeLayout.g();
        L(lVar);
    }

    /* access modifiers changed from: package-private */
    public c5.m M() {
        return this.f10516p;
    }

    /* access modifiers changed from: package-private */
    public boolean O() {
        return this.f10513m;
    }

    /* access modifiers changed from: package-private */
    public void P() {
        o3.d1(o3.v.DEBUG, "InAppMessageView removing views");
        Runnable runnable = this.f10521u;
        if (runnable != null) {
            this.f10503c.removeCallbacks(runnable);
            this.f10521u = null;
        }
        DraggableRelativeLayout draggableRelativeLayout = this.f10519s;
        if (draggableRelativeLayout != null) {
            draggableRelativeLayout.removeAllViews();
        }
        PopupWindow popupWindow = this.f10501a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        J();
    }

    /* access modifiers changed from: package-private */
    public void R(j jVar) {
        this.f10520t = jVar;
    }

    /* access modifiers changed from: package-private */
    public void U(WebView webView) {
        this.f10517q = webView;
        webView.setBackgroundColor(0);
    }

    /* access modifiers changed from: package-private */
    public void W(Activity activity) {
        RelativeLayout.LayoutParams layoutParams;
        this.f10502b = activity;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f10505e);
        layoutParams2.addRule(13);
        if (this.f10511k) {
            layoutParams = G();
        } else {
            layoutParams = null;
        }
        c5.m mVar = this.f10516p;
        V(mVar, layoutParams2, layoutParams, F(this.f10505e, mVar, this.f10514n));
    }

    /* access modifiers changed from: package-private */
    public void X(Activity activity) {
        I(activity);
    }

    /* access modifiers changed from: package-private */
    public void Z(int i10) {
        this.f10505e = i10;
        OSUtils.S(new a(i10));
    }

    public String toString() {
        return "InAppMessageView{currentActivity=" + this.f10502b + ", pageWidth=" + this.f10504d + ", pageHeight=" + this.f10505e + ", displayDuration=" + this.f10510j + ", hasBackground=" + this.f10511k + ", shouldDismissWhenActive=" + this.f10512l + ", isDragging=" + this.f10513m + ", disableDragDismiss=" + this.f10514n + ", displayLocation=" + this.f10516p + ", webView=" + this.f10517q + '}';
    }
}
