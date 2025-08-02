package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    @Nullable
    private Animatable animatable;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    private void maybeUpdateAnimatable(@Nullable Z z10) {
        if (z10 instanceof Animatable) {
            Animatable animatable2 = (Animatable) z10;
            this.animatable = animatable2;
            animatable2.start();
            return;
        }
        this.animatable = null;
    }

    private void setResourceInternal(@Nullable Z z10) {
        setResource(z10);
        maybeUpdateAnimatable(z10);
    }

    @Nullable
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.stop();
        }
        setResourceInternal((Object) null);
        setDrawable(drawable);
    }

    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        setResourceInternal((Object) null);
        setDrawable(drawable);
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        setResourceInternal((Object) null);
        setDrawable(drawable);
    }

    public void onResourceReady(@NonNull Z z10, @Nullable Transition<? super Z> transition) {
        if (transition == null || !transition.transition(z10, this)) {
            setResourceInternal(z10);
        } else {
            maybeUpdateAnimatable(z10);
        }
    }

    public void onStart() {
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.start();
        }
    }

    public void onStop() {
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.stop();
        }
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void setResource(@Nullable Z z10);

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }
}
