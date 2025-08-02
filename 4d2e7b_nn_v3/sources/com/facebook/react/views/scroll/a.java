package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.k1;
import com.facebook.react.views.scroll.d;
import com.facebook.react.views.view.ReactViewGroup;
import java.lang.ref.WeakReference;

class a implements UIManagerListener {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f4125a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4126b;

    /* renamed from: c  reason: collision with root package name */
    private b f4127c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference f4128d = null;

    /* renamed from: e  reason: collision with root package name */
    private Rect f4129e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4130f = false;

    /* renamed from: com.facebook.react.views.scroll.a$a  reason: collision with other inner class name */
    class C0057a implements Runnable {
        C0057a() {
        }

        public void run() {
            a.this.b();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f4132a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f4133b;

        b(int i10, Integer num) {
            this.f4132a = i10;
            this.f4133b = num;
        }

        static b a(ReadableMap readableMap) {
            Integer num;
            int i10 = readableMap.getInt("minIndexForVisible");
            if (readableMap.hasKey("autoscrollToTopThreshold")) {
                num = Integer.valueOf(readableMap.getInt("autoscrollToTopThreshold"));
            } else {
                num = null;
            }
            return new b(i10, num);
        }
    }

    public a(ViewGroup viewGroup, boolean z10) {
        this.f4125a = viewGroup;
        this.f4126b = z10;
    }

    /* access modifiers changed from: private */
    public void b() {
        ReactViewGroup c10;
        int i10;
        float y10;
        int height;
        if (this.f4127c != null && (c10 = c()) != null) {
            if (this.f4126b) {
                i10 = this.f4125a.getScrollX();
            } else {
                i10 = this.f4125a.getScrollY();
            }
            for (int i11 = this.f4127c.f4132a; i11 < c10.getChildCount(); i11++) {
                View childAt = c10.getChildAt(i11);
                if (this.f4126b) {
                    y10 = childAt.getX();
                    height = childAt.getWidth();
                } else {
                    y10 = childAt.getY();
                    height = childAt.getHeight();
                }
                if (y10 + ((float) height) > ((float) i10) || i11 == c10.getChildCount() - 1) {
                    this.f4128d = new WeakReference(childAt);
                    Rect rect = new Rect();
                    childAt.getHitRect(rect);
                    this.f4129e = rect;
                    return;
                }
            }
        }
    }

    private ReactViewGroup c() {
        return (ReactViewGroup) this.f4125a.getChildAt(0);
    }

    private UIManager d() {
        return (UIManager) p5.a.c(k1.g((ReactContext) this.f4125a.getContext(), i7.a.a(this.f4125a.getId())));
    }

    private void i() {
        WeakReference weakReference;
        View view;
        if (this.f4127c != null && (weakReference = this.f4128d) != null && this.f4129e != null && (view = (View) weakReference.get()) != null) {
            Rect rect = new Rect();
            view.getHitRect(rect);
            if (this.f4126b) {
                int i10 = rect.left - this.f4129e.left;
                if (i10 != 0) {
                    int scrollX = this.f4125a.getScrollX();
                    ViewGroup viewGroup = this.f4125a;
                    ((d.C0059d) viewGroup).b(i10 + scrollX, viewGroup.getScrollY());
                    this.f4129e = rect;
                    Integer num = this.f4127c.f4133b;
                    if (num != null && scrollX <= num.intValue()) {
                        ViewGroup viewGroup2 = this.f4125a;
                        ((d.C0059d) viewGroup2).c(0, viewGroup2.getScrollY());
                        return;
                    }
                    return;
                }
                return;
            }
            int i11 = rect.top - this.f4129e.top;
            if (i11 != 0) {
                int scrollY = this.f4125a.getScrollY();
                ViewGroup viewGroup3 = this.f4125a;
                ((d.C0059d) viewGroup3).b(viewGroup3.getScrollX(), i11 + scrollY);
                this.f4129e = rect;
                Integer num2 = this.f4127c.f4133b;
                if (num2 != null && scrollY <= num2.intValue()) {
                    ViewGroup viewGroup4 = this.f4125a;
                    ((d.C0059d) viewGroup4).c(viewGroup4.getScrollX(), 0);
                }
            }
        }
    }

    public void didDispatchMountItems(UIManager uIManager) {
    }

    public void didMountItems(UIManager uIManager) {
        i();
    }

    public void didScheduleMountItems(UIManager uIManager) {
    }

    public void e(b bVar) {
        this.f4127c = bVar;
    }

    public void f() {
        if (!this.f4130f) {
            this.f4130f = true;
            d().addUIManagerEventListener(this);
        }
    }

    public void g() {
        if (this.f4130f) {
            this.f4130f = false;
            d().removeUIManagerEventListener(this);
        }
    }

    public void h() {
        if (i7.a.a(this.f4125a.getId()) != 2) {
            i();
        }
    }

    public void willDispatchViewUpdates(UIManager uIManager) {
        UiThreadUtil.runOnUiThread(new C0057a());
    }

    public void willMountItems(UIManager uIManager) {
        b();
    }
}
