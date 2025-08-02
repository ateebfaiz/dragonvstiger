package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import fb.e;
import fb.h;
import gb.c;
import gb.d;

public class UCropView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public GestureCropImageView f11839a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final OverlayView f11840b;

    class a implements c {
        a() {
        }

        public void a(float f10) {
            UCropView.this.f11840b.setTargetAspectRatio(f10);
        }
    }

    class b implements d {
        b() {
        }

        public void a(RectF rectF) {
            UCropView.this.f11839a.setCropRect(rectF);
        }
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        this.f11839a.setCropBoundsChangeListener(new a());
        this.f11840b.setOverlayViewChangeListener(new b());
    }

    @NonNull
    public GestureCropImageView getCropImageView() {
        return this.f11839a;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.f11840b;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(e.f12136d, this, true);
        this.f11839a = (GestureCropImageView) findViewById(fb.d.f12108b);
        OverlayView overlayView = (OverlayView) findViewById(fb.d.f12131y);
        this.f11840b = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.U);
        overlayView.g(obtainStyledAttributes);
        this.f11839a.w(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        c();
    }
}
