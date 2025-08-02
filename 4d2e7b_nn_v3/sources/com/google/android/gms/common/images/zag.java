package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;

public abstract class zag {
    final d zaa;
    protected int zab = 0;

    public zag(Uri uri, int i10) {
        this.zaa = new d(uri);
        this.zab = i10;
    }

    /* access modifiers changed from: protected */
    public abstract void zaa(@Nullable Drawable drawable, boolean z10, boolean z11, boolean z12);

    /* access modifiers changed from: package-private */
    public final void zab(Context context, zak zak, boolean z10) {
        Drawable drawable;
        int i10 = this.zab;
        if (i10 != 0) {
            drawable = context.getResources().getDrawable(i10);
        } else {
            drawable = null;
        }
        zaa(drawable, z10, false, false);
    }

    /* access modifiers changed from: package-private */
    public final void zac(Context context, Bitmap bitmap, boolean z10) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
