package e5;

import android.graphics.Bitmap;
import c3.a;
import c3.h;

class i extends b {
    protected i(a aVar, o oVar, int i10, int i11) {
        super(aVar, oVar, i10, i11);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (!isClosed()) {
            z2.a.I("DefaultCloseableStaticBitmap", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    protected i(Bitmap bitmap, h hVar, o oVar, int i10, int i11) {
        super(bitmap, hVar, oVar, i10, i11);
    }
}
