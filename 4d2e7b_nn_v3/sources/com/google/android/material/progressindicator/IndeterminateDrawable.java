package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends c {
    private e animatorDelegate;
    private d drawingDelegate;

    IndeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull d dVar, @NonNull e eVar) {
        super(context, baseProgressIndicatorSpec);
        setDrawingDelegate(dVar);
        setAnimatorDelegate(eVar);
    }

    @NonNull
    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new IndeterminateDrawable<>(context, circularProgressIndicatorSpec, new a(circularProgressIndicatorSpec), new b(circularProgressIndicatorSpec));
    }

    @NonNull
    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        e eVar;
        f fVar = new f(linearProgressIndicatorSpec);
        if (linearProgressIndicatorSpec.indeterminateAnimationType == 0) {
            eVar = new g(linearProgressIndicatorSpec);
        } else {
            eVar = new h(context, linearProgressIndicatorSpec);
        }
        return new IndeterminateDrawable<>(context, linearProgressIndicatorSpec, fVar, eVar);
    }

    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.drawingDelegate.g(canvas, getGrowFraction());
            this.drawingDelegate.c(canvas, this.paint);
            int i10 = 0;
            while (true) {
                e eVar = this.animatorDelegate;
                int[] iArr = eVar.f8401c;
                if (i10 < iArr.length) {
                    d dVar = this.drawingDelegate;
                    Paint paint = this.paint;
                    float[] fArr = eVar.f8400b;
                    int i11 = i10 * 2;
                    dVar.b(canvas, paint, fArr[i11], fArr[i11 + 1], iArr[i10]);
                    i10++;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public e getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public d getDrawingDelegate() {
        return this.drawingDelegate;
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.d();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.e();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    /* access modifiers changed from: package-private */
    public void setAnimatorDelegate(@NonNull e eVar) {
        this.animatorDelegate = eVar;
        eVar.e(this);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: package-private */
    public void setDrawingDelegate(@NonNull d dVar) {
        this.drawingDelegate = dVar;
        dVar.f(this);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    /* access modifiers changed from: package-private */
    public boolean setVisibleInternal(boolean z10, boolean z11, boolean z12) {
        boolean visibleInternal = super.setVisibleInternal(z10, z11, z12);
        if (!isRunning()) {
            this.animatorDelegate.a();
        }
        this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (z10 && z12) {
            this.animatorDelegate.g();
        }
        return visibleInternal;
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11, boolean z12) {
        return super.setVisible(z10, z11, z12);
    }
}
