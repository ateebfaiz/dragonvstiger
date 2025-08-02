package h5;

import android.graphics.Bitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public class j extends u {

    /* renamed from: c  reason: collision with root package name */
    public static final a f21961c = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: c */
    public Bitmap get(int i10) {
        Bitmap bitmap = (Bitmap) super.get(i10);
        if (bitmap == null || !e(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    /* renamed from: d */
    public int a(Bitmap bitmap) {
        m.f(bitmap, "bitmap");
        return o5.a.g(bitmap);
    }

    /* access modifiers changed from: protected */
    public final boolean e(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            z2.a.M("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        } else if (bitmap.isMutable()) {
            return true;
        } else {
            z2.a.M("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", bitmap);
            return false;
        }
    }

    /* renamed from: f */
    public void put(Bitmap bitmap) {
        m.f(bitmap, "bitmap");
        if (e(bitmap)) {
            super.put(bitmap);
        }
    }
}
