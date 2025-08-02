package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import b3.d;
import h5.f0;
import h5.g0;
import h5.i;
import y2.l;

public class c extends a implements i {
    public c(d dVar, f0 f0Var, g0 g0Var, boolean z10) {
        super(dVar, f0Var, g0Var, z10);
        s();
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public Bitmap g(int i10) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i10) / 2.0d), Bitmap.Config.RGB_565);
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public void k(Bitmap bitmap) {
        l.g(bitmap);
        bitmap.recycle();
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public int o(Bitmap bitmap) {
        l.g(bitmap);
        return bitmap.getAllocationByteCount();
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public Bitmap q(b bVar) {
        Bitmap bitmap = (Bitmap) super.q(bVar);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public boolean u(Bitmap bitmap) {
        l.g(bitmap);
        if (bitmap.isRecycled() || !bitmap.isMutable()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int n(int i10) {
        return i10;
    }

    /* access modifiers changed from: protected */
    public int p(int i10) {
        return i10;
    }
}
