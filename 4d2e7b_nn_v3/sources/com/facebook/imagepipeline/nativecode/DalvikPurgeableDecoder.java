package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import c3.a;
import com.facebook.soloader.f;
import e5.j;
import h5.g;
import h5.h;
import java.util.Locale;
import y2.d;
import y2.l;
import y2.q;

@d
public abstract class DalvikPurgeableDecoder implements i5.d {

    /* renamed from: b  reason: collision with root package name */
    protected static final byte[] f19990b = {-1, -39};

    /* renamed from: a  reason: collision with root package name */
    private final g f19991a = h.a();

    @f
    private static class OreoUtils {
        private OreoUtils() {
        }

        static void a(BitmapFactory.Options options, ColorSpace colorSpace) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
    }

    static {
        a.a();
    }

    protected DalvikPurgeableDecoder() {
    }

    public static boolean e(a aVar, int i10) {
        b3.h hVar = (b3.h) aVar.p();
        if (i10 >= 2 && hVar.c(i10 - 2) == -1 && hVar.c(i10 - 1) == -39) {
            return true;
        }
        return false;
    }

    public static BitmapFactory.Options f(int i10, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i10;
        options.inMutable = true;
        return options;
    }

    @d
    private static native void nativePinBitmap(Bitmap bitmap);

    public a a(j jVar, Bitmap.Config config, Rect rect, int i10, ColorSpace colorSpace) {
        BitmapFactory.Options f10 = f(jVar.z(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.a(f10, colorSpace);
        }
        a k10 = jVar.k();
        l.g(k10);
        try {
            return g(d(k10, i10, f10));
        } finally {
            a.m(k10);
        }
    }

    public a b(j jVar, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        BitmapFactory.Options f10 = f(jVar.z(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.a(f10, colorSpace);
        }
        a k10 = jVar.k();
        l.g(k10);
        try {
            return g(c(k10, f10));
        } finally {
            a.m(k10);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap c(a aVar, BitmapFactory.Options options);

    /* access modifiers changed from: protected */
    public abstract Bitmap d(a aVar, int i10, BitmapFactory.Options options);

    public a g(Bitmap bitmap) {
        l.g(bitmap);
        try {
            nativePinBitmap(bitmap);
            if (this.f19991a.g(bitmap)) {
                return a.B(bitmap, this.f19991a.e());
            }
            int g10 = o5.a.g(bitmap);
            bitmap.recycle();
            throw new y4.h(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", new Object[]{Integer.valueOf(g10), Integer.valueOf(this.f19991a.b()), Long.valueOf(this.f19991a.f()), Integer.valueOf(this.f19991a.c()), Integer.valueOf(this.f19991a.d())}));
        } catch (Exception e10) {
            bitmap.recycle();
            throw q.a(e10);
        }
    }
}
