package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zaf extends zag {
    private final WeakReference<ImageManager.OnImageLoadedListener> zac;

    public zaf(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(onImageLoadedListener);
        this.zac = new WeakReference<>(onImageLoadedListener);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zaf)) {
            return false;
        }
        zaf zaf = (zaf) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = this.zac.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = zaf.zac.get();
        if (onImageLoadedListener2 == null || onImageLoadedListener == null || !Objects.equal(onImageLoadedListener2, onImageLoadedListener) || !Objects.equal(zaf.zaa, this.zaa)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zaa);
    }

    /* access modifiers changed from: protected */
    public final void zaa(@Nullable Drawable drawable, boolean z10, boolean z11, boolean z12) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        if (!z11 && (onImageLoadedListener = this.zac.get()) != null) {
            onImageLoadedListener.onImageLoaded(this.zaa.f6777a, drawable, z12);
        }
    }
}
