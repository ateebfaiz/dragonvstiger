package com.onesignal;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

class DraggableRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    private static final int f10255e = m3.b(28);

    /* renamed from: f  reason: collision with root package name */
    private static final int f10256f = m3.b(64);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f10257a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ViewDragHelper f10258b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f10259c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public c f10260d;

    class a extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        private int f10261a;

        a() {
        }

        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            return DraggableRelativeLayout.this.f10260d.f10266d;
        }

        public int clampViewPositionVertical(View view, int i10, int i11) {
            if (DraggableRelativeLayout.this.f10260d.f10270h) {
                return DraggableRelativeLayout.this.f10260d.f10264b;
            }
            this.f10261a = i10;
            if (DraggableRelativeLayout.this.f10260d.f10269g == 1) {
                if (i10 >= DraggableRelativeLayout.this.f10260d.f10265c && DraggableRelativeLayout.this.f10257a != null) {
                    DraggableRelativeLayout.this.f10257a.a();
                }
                if (i10 < DraggableRelativeLayout.this.f10260d.f10264b) {
                    return DraggableRelativeLayout.this.f10260d.f10264b;
                }
            } else {
                if (i10 <= DraggableRelativeLayout.this.f10260d.f10265c && DraggableRelativeLayout.this.f10257a != null) {
                    DraggableRelativeLayout.this.f10257a.a();
                }
                if (i10 > DraggableRelativeLayout.this.f10260d.f10264b) {
                    return DraggableRelativeLayout.this.f10260d.f10264b;
                }
            }
            return i10;
        }

        public void onViewReleased(View view, float f10, float f11) {
            int i10 = DraggableRelativeLayout.this.f10260d.f10264b;
            if (!DraggableRelativeLayout.this.f10259c) {
                if (DraggableRelativeLayout.this.f10260d.f10269g == 1) {
                    if (this.f10261a > DraggableRelativeLayout.this.f10260d.f10273k || f11 > ((float) DraggableRelativeLayout.this.f10260d.f10271i)) {
                        i10 = DraggableRelativeLayout.this.f10260d.f10272j;
                        boolean unused = DraggableRelativeLayout.this.f10259c = true;
                        if (DraggableRelativeLayout.this.f10257a != null) {
                            DraggableRelativeLayout.this.f10257a.onDismiss();
                        }
                    }
                } else if (this.f10261a < DraggableRelativeLayout.this.f10260d.f10273k || f11 < ((float) DraggableRelativeLayout.this.f10260d.f10271i)) {
                    i10 = DraggableRelativeLayout.this.f10260d.f10272j;
                    boolean unused2 = DraggableRelativeLayout.this.f10259c = true;
                    if (DraggableRelativeLayout.this.f10257a != null) {
                        DraggableRelativeLayout.this.f10257a.onDismiss();
                    }
                }
            }
            if (DraggableRelativeLayout.this.f10258b.settleCapturedViewAt(DraggableRelativeLayout.this.f10260d.f10266d, i10)) {
                ViewCompat.postInvalidateOnAnimation(DraggableRelativeLayout.this);
            }
        }

        public boolean tryCaptureView(View view, int i10) {
            return true;
        }
    }

    interface b {
        void a();

        void b();

        void onDismiss();
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        int f10263a;

        /* renamed from: b  reason: collision with root package name */
        int f10264b;

        /* renamed from: c  reason: collision with root package name */
        int f10265c;

        /* renamed from: d  reason: collision with root package name */
        int f10266d;

        /* renamed from: e  reason: collision with root package name */
        int f10267e;

        /* renamed from: f  reason: collision with root package name */
        int f10268f;

        /* renamed from: g  reason: collision with root package name */
        int f10269g;

        /* renamed from: h  reason: collision with root package name */
        boolean f10270h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f10271i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public int f10272j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public int f10273k;

        c() {
        }
    }

    public DraggableRelativeLayout(Context context) {
        super(context);
        setClipChildren(false);
        f();
    }

    private void f() {
        this.f10258b = ViewDragHelper.create(this, 1.0f, new a());
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f10258b.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void g() {
        this.f10259c = true;
        this.f10258b.smoothSlideViewTo(this, getLeft(), this.f10260d.f10272j);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    public void h(b bVar) {
        this.f10257a = bVar;
    }

    /* access modifiers changed from: package-private */
    public void i(c cVar) {
        this.f10260d = cVar;
        int unused = cVar.f10272j = cVar.f10268f + cVar.f10263a + ((Resources.getSystem().getDisplayMetrics().heightPixels - cVar.f10268f) - cVar.f10263a) + f10256f;
        int unused2 = cVar.f10271i = m3.b(3000);
        if (cVar.f10269g == 0) {
            int unused3 = cVar.f10272j = (-cVar.f10268f) - f10255e;
            int unused4 = cVar.f10271i = -cVar.f10271i;
            int unused5 = cVar.f10273k = cVar.f10272j / 3;
            return;
        }
        int unused6 = cVar.f10273k = (cVar.f10268f / 3) + (cVar.f10264b * 2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.f10259c) {
            return true;
        }
        int action = motionEvent.getAction();
        if ((action == 0 || action == 5) && (bVar = this.f10257a) != null) {
            bVar.b();
        }
        this.f10258b.processTouchEvent(motionEvent);
        return false;
    }
}
