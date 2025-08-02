package e9;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

class g implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    private h f12005a;

    /* renamed from: b  reason: collision with root package name */
    private Window f12006b;

    /* renamed from: c  reason: collision with root package name */
    private View f12007c;

    /* renamed from: d  reason: collision with root package name */
    private View f12008d;

    /* renamed from: e  reason: collision with root package name */
    private View f12009e;

    /* renamed from: f  reason: collision with root package name */
    private int f12010f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f12011g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f12012h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f12013i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f12014j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f12015w;

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    g(e9.h r4) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.f12010f = r0
            r3.f12011g = r0
            r3.f12012h = r0
            r3.f12013i = r0
            r3.f12005a = r4
            android.view.Window r1 = r4.z()
            r3.f12006b = r1
            android.view.View r1 = r1.getDecorView()
            r3.f12007c = r1
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            boolean r2 = r4.H()
            if (r2 == 0) goto L_0x0043
            androidx.fragment.app.Fragment r0 = r4.y()
            if (r0 == 0) goto L_0x0036
            android.view.View r4 = r0.getView()
            r3.f12009e = r4
            goto L_0x0057
        L_0x0036:
            android.app.Fragment r4 = r4.r()
            if (r4 == 0) goto L_0x0057
            android.view.View r4 = r4.getView()
            r3.f12009e = r4
            goto L_0x0057
        L_0x0043:
            android.view.View r4 = r1.getChildAt(r0)
            r3.f12009e = r4
            if (r4 == 0) goto L_0x0057
            boolean r2 = r4 instanceof androidx.drawerlayout.widget.DrawerLayout
            if (r2 == 0) goto L_0x0057
            androidx.drawerlayout.widget.DrawerLayout r4 = (androidx.drawerlayout.widget.DrawerLayout) r4
            android.view.View r4 = r4.getChildAt(r0)
            r3.f12009e = r4
        L_0x0057:
            android.view.View r4 = r3.f12009e
            if (r4 == 0) goto L_0x0079
            int r4 = r4.getPaddingLeft()
            r3.f12010f = r4
            android.view.View r4 = r3.f12009e
            int r4 = r4.getPaddingTop()
            r3.f12011g = r4
            android.view.View r4 = r3.f12009e
            int r4 = r4.getPaddingRight()
            r3.f12012h = r4
            android.view.View r4 = r3.f12009e
            int r4 = r4.getPaddingBottom()
            r3.f12013i = r4
        L_0x0079:
            android.view.View r4 = r3.f12009e
            if (r4 == 0) goto L_0x007e
            r1 = r4
        L_0x007e:
            r3.f12008d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.g.<init>(e9.h):void");
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f12015w) {
            this.f12007c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f12015w = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.f12015w) {
            return;
        }
        if (this.f12009e != null) {
            this.f12008d.setPadding(this.f12010f, this.f12011g, this.f12012h, this.f12013i);
        } else {
            this.f12008d.setPadding(this.f12005a.t(), this.f12005a.v(), this.f12005a.u(), this.f12005a.s());
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i10) {
        this.f12006b.setSoftInputMode(i10);
        if (!this.f12015w) {
            this.f12007c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f12015w = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ba, code lost:
        if ((r3 - r1) > r1) goto L_0x0093;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGlobalLayout() {
        /*
            r7 = this;
            e9.h r0 = r7.f12005a
            if (r0 == 0) goto L_0x00d9
            e9.c r0 = r0.q()
            if (r0 == 0) goto L_0x00d9
            e9.h r0 = r7.f12005a
            e9.c r0 = r0.q()
            boolean r0 = r0.f11985d1
            if (r0 == 0) goto L_0x00d9
            e9.h r0 = r7.f12005a
            e9.a r0 = r0.p()
            boolean r1 = r0.l()
            if (r1 == 0) goto L_0x0025
            int r1 = r0.d()
            goto L_0x0029
        L_0x0025:
            int r1 = r0.f()
        L_0x0029:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.view.View r3 = r7.f12007c
            r3.getWindowVisibleDisplayFrame(r2)
            android.view.View r3 = r7.f12008d
            int r3 = r3.getHeight()
            int r2 = r2.bottom
            int r3 = r3 - r2
            int r2 = r7.f12014j
            if (r3 == r2) goto L_0x00d9
            r7.f12014j = r3
            android.view.Window r2 = r7.f12006b
            android.view.View r2 = r2.getDecorView()
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r2 = r2.findViewById(r4)
            boolean r2 = e9.h.d(r2)
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x00b9
            android.view.View r2 = r7.f12009e
            if (r2 == 0) goto L_0x0095
            e9.h r2 = r7.f12005a
            e9.c r2 = r2.q()
            boolean r2 = r2.f11983c1
            if (r2 == 0) goto L_0x0071
            e9.h r2 = r7.f12005a
            int r2 = r2.n()
            int r6 = r0.i()
            int r2 = r2 + r6
            int r3 = r3 + r2
        L_0x0071:
            e9.h r2 = r7.f12005a
            e9.c r2 = r2.q()
            boolean r2 = r2.W0
            if (r2 == 0) goto L_0x0080
            int r0 = r0.i()
            int r3 = r3 + r0
        L_0x0080:
            if (r3 <= r1) goto L_0x0087
            int r0 = r7.f12013i
            int r4 = r3 + r0
            goto L_0x0088
        L_0x0087:
            r5 = r4
        L_0x0088:
            android.view.View r0 = r7.f12008d
            int r1 = r7.f12010f
            int r2 = r7.f12011g
            int r3 = r7.f12012h
            r0.setPadding(r1, r2, r3, r4)
        L_0x0093:
            r4 = r5
            goto L_0x00bd
        L_0x0095:
            e9.h r0 = r7.f12005a
            int r0 = r0.s()
            int r3 = r3 - r1
            if (r3 <= r1) goto L_0x00a1
            int r0 = r3 + r1
            r4 = r5
        L_0x00a1:
            android.view.View r1 = r7.f12008d
            e9.h r2 = r7.f12005a
            int r2 = r2.t()
            e9.h r3 = r7.f12005a
            int r3 = r3.v()
            e9.h r5 = r7.f12005a
            int r5 = r5.u()
            r1.setPadding(r2, r3, r5, r0)
            goto L_0x00bd
        L_0x00b9:
            int r3 = r3 - r1
            if (r3 <= r1) goto L_0x00bd
            goto L_0x0093
        L_0x00bd:
            e9.h r0 = r7.f12005a
            e9.c r0 = r0.q()
            r0.getClass()
            if (r4 != 0) goto L_0x00d9
            e9.h r0 = r7.f12005a
            e9.c r0 = r0.q()
            e9.b r0 = r0.f11996j
            e9.b r1 = e9.b.FLAG_SHOW_BAR
            if (r0 == r1) goto L_0x00d9
            e9.h r0 = r7.f12005a
            r0.P()
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.g.onGlobalLayout():void");
    }
}
