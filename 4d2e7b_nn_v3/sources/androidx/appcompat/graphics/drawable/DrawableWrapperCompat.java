package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableWrapperCompat extends Drawable implements Drawable.Callback {
    private Drawable mDrawable;

    public DrawableWrapperCompat(Drawable drawable) {
        setDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    @Nullable
    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        return this.mDrawable.setLevel(i10);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    public void setAlpha(int i10) {
        this.mDrawable.setAlpha(i10);
    }

    public void setAutoMirrored(boolean z10) {
        DrawableCompat.setAutoMirrored(this.mDrawable, z10);
    }

    public void setChangingConfigurations(int i10) {
        this.mDrawable.setChangingConfigurations(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public void setDither(boolean z10) {
        this.mDrawable.setDither(z10);
    }

    public void setDrawable(@Nullable Drawable drawable) {
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void setFilterBitmap(boolean z10) {
        this.mDrawable.setFilterBitmap(z10);
    }

    public void setHotspot(float f10, float f11) {
        DrawableCompat.setHotspot(this.mDrawable, f10, f11);
    }

    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        DrawableCompat.setHotspotBounds(this.mDrawable, i10, i11, i12, i13);
    }

    public boolean setState(int[] iArr) {
        return this.mDrawable.setState(iArr);
    }

    public void setTint(int i10) {
        DrawableCompat.setTint(this.mDrawable, i10);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.mDrawable, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.setTintMode(this.mDrawable, mode);
    }

    public boolean setVisible(boolean z10, boolean z11) {
        if (super.setVisible(z10, z11) || this.mDrawable.setVisible(z10, z11)) {
            return true;
        }
        return false;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
