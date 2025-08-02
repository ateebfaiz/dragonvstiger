package com.facebook.react.views.drawer;

import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.m;
import com.facebook.react.uimanager.i0;

class ReactDrawerLayout extends DrawerLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f3984a = GravityCompat.START;

    /* renamed from: b  reason: collision with root package name */
    private int f3985b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3986c = false;

    class a extends AccessibilityDelegateCompat {
        a() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            i0.e eVar = (i0.e) view.getTag(m.f20850g);
            if (eVar != null) {
                accessibilityEvent.setClassName(i0.e.e(eVar));
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            i0.e d10 = i0.e.d(view);
            if (d10 != null) {
                accessibilityNodeInfoCompat.setClassName(i0.e.e(d10));
            }
        }
    }

    public ReactDrawerLayout(ReactContext reactContext) {
        super(reactContext);
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    /* access modifiers changed from: package-private */
    public void a() {
        closeDrawer(this.f3984a);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        openDrawer(this.f3984a);
    }

    /* access modifiers changed from: package-private */
    public void c(int i10) {
        this.f3984a = i10;
        d();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.gravity = this.f3984a;
            layoutParams.width = this.f3985b;
            childAt.setLayoutParams(layoutParams);
            childAt.setClickable(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i10) {
        this.f3985b = i10;
        d();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (!super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            com.facebook.react.uimanager.events.m.b(this, motionEvent);
            this.f3986c = true;
            return true;
        } catch (IllegalArgumentException e10) {
            z2.a.H("ReactNative", "Error intercepting touch event.", e10);
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && this.f3986c) {
            com.facebook.react.uimanager.events.m.a(this, motionEvent);
            this.f3986c = false;
        }
        return super.onTouchEvent(motionEvent);
    }
}
