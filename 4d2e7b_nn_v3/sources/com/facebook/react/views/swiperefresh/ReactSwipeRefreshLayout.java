package com.facebook.react.views.swiperefresh;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.m;
import com.facebook.react.uimanager.g0;

public class ReactSwipeRefreshLayout extends SwipeRefreshLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4179a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4180b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f4181c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f4182d;

    /* renamed from: e  reason: collision with root package name */
    private float f4183e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4184f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4185g = false;

    public ReactSwipeRefreshLayout(ReactContext reactContext) {
        super(reactContext);
        this.f4182d = ViewConfiguration.get(reactContext).getScaledTouchSlop();
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4183e = motionEvent.getX();
            this.f4184f = false;
        } else if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.f4183e);
            if (this.f4184f || abs > ((float) this.f4182d)) {
                this.f4184f = true;
                return false;
            }
        }
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!a(motionEvent) || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        m.b(this, motionEvent);
        this.f4185g = true;
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!this.f4179a) {
            this.f4179a = true;
            setProgressViewOffset(this.f4181c);
            setRefreshing(this.f4180b);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && this.f4185g) {
            m.a(this, motionEvent);
            this.f4185g = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z10);
        }
    }

    public void setProgressViewOffset(float f10) {
        this.f4181c = f10;
        if (this.f4179a) {
            int progressCircleDiameter = getProgressCircleDiameter();
            setProgressViewOffset(false, Math.round(g0.d(f10)) - progressCircleDiameter, Math.round(g0.d(f10 + 64.0f) - ((float) progressCircleDiameter)));
        }
    }

    public void setRefreshing(boolean z10) {
        this.f4180b = z10;
        if (this.f4179a) {
            super.setRefreshing(z10);
        }
    }
}
