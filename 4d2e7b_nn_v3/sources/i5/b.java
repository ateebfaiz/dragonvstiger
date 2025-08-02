package i5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import c3.h;
import com.facebook.imagepipeline.platform.PreverificationHelper;
import e5.j;
import h5.i;
import h5.r;
import java.io.IOException;
import java.io.InputStream;
import y2.l;

public abstract class b implements d {

    /* renamed from: f  reason: collision with root package name */
    private static final Class f22120f = b.class;

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f22121g = {-1, -39};

    /* renamed from: a  reason: collision with root package name */
    private final i f22122a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f22123b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22124c;

    /* renamed from: d  reason: collision with root package name */
    private final PreverificationHelper f22125d;

    /* renamed from: e  reason: collision with root package name */
    final Pools.Pool f22126e;

    private static final class a implements h {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f22127a = new a();

        private a() {
        }

        /* renamed from: b */
        public void release(Bitmap bitmap) {
        }
    }

    public b(i iVar, Pools.Pool pool, f fVar) {
        PreverificationHelper preverificationHelper;
        if (Build.VERSION.SDK_INT >= 26) {
            preverificationHelper = new PreverificationHelper();
        } else {
            preverificationHelper = null;
        }
        this.f22125d = preverificationHelper;
        this.f22122a = iVar;
        if (iVar instanceof r) {
            this.f22123b = fVar.a();
            this.f22124c = fVar.b();
        }
        this.f22126e = pool;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:56|57|(2:59|60)) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0099, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009a, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        z2.a.h(f22120f, "Could not decode region %s, decoding full bitmap instead.", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b8, code lost:
        if (r2 != null) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r2.recycle();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00ad */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x011f */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0094 A[SYNTHETIC, Splitter:B:42:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009f A[SYNTHETIC, Splitter:B:48:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c0 A[Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6, all -> 0x00a3, IOException -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c7 A[Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6, all -> 0x00a3, IOException -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private c3.a c(java.io.InputStream r10, android.graphics.BitmapFactory.Options r11, android.graphics.Rect r12, android.graphics.ColorSpace r13) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            y2.l.g(r10)
            int r2 = r11.outWidth
            int r3 = r11.outHeight
            if (r12 == 0) goto L_0x0019
            int r2 = r12.width()
            int r3 = r11.inSampleSize
            int r2 = r2 / r3
            int r3 = r12.height()
            int r4 = r11.inSampleSize
            int r3 = r3 / r4
        L_0x0019:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            if (r4 < r5) goto L_0x002d
            com.facebook.imagepipeline.platform.PreverificationHelper r6 = r9.f22125d
            if (r6 == 0) goto L_0x002d
            android.graphics.Bitmap$Config r7 = r11.inPreferredConfig
            boolean r6 = r6.shouldUseHardwareBitmapConfig(r7)
            if (r6 == 0) goto L_0x002d
            r6 = r1
            goto L_0x002e
        L_0x002d:
            r6 = r0
        L_0x002e:
            r7 = 0
            if (r12 != 0) goto L_0x0036
            if (r6 == 0) goto L_0x0036
            r11.inMutable = r0
            goto L_0x0059
        L_0x0036:
            if (r12 == 0) goto L_0x003e
            if (r6 == 0) goto L_0x003e
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            r11.inPreferredConfig = r6
        L_0x003e:
            boolean r6 = r9.f22123b
            if (r6 != 0) goto L_0x0059
            int r6 = r9.d(r2, r3, r11)
            h5.i r8 = r9.f22122a
            java.lang.Object r6 = r8.get(r6)
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            if (r6 == 0) goto L_0x0051
            goto L_0x005a
        L_0x0051:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            java.lang.String r11 = "BitmapPool.get returned null"
            r10.<init>(r11)
            throw r10
        L_0x0059:
            r6 = r7
        L_0x005a:
            r11.inBitmap = r6
            if (r4 < r5) goto L_0x006b
            if (r13 != 0) goto L_0x0068
            android.graphics.ColorSpace$Named r13 = android.graphics.ColorSpace.Named.SRGB
            android.graphics.ColorSpace r13 = android.graphics.ColorSpace.get(r13)
        L_0x0068:
            r11.inPreferredColorSpace = r13
        L_0x006b:
            androidx.core.util.Pools$Pool r13 = r9.f22126e
            java.lang.Object r13 = r13.acquire()
            java.nio.ByteBuffer r13 = (java.nio.ByteBuffer) r13
            if (r13 != 0) goto L_0x007d
            int r13 = b3.b.c()
            java.nio.ByteBuffer r13 = java.nio.ByteBuffer.allocate(r13)
        L_0x007d:
            byte[] r4 = r13.array()     // Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6 }
            r11.inTempStorage = r4     // Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6 }
            if (r12 == 0) goto L_0x00c4
            if (r6 == 0) goto L_0x00c4
            android.graphics.Bitmap$Config r4 = r11.inPreferredConfig     // Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6 }
            if (r4 == 0) goto L_0x00c4
            r6.reconfigure(r2, r3, r4)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            android.graphics.BitmapRegionDecoder r2 = android.graphics.BitmapRegionDecoder.newInstance(r10, r1)     // Catch:{ IOException -> 0x00ac, all -> 0x00aa }
            if (r2 == 0) goto L_0x009c
            android.graphics.Bitmap r12 = r2.decodeRegion(r12, r11)     // Catch:{ IOException -> 0x00ad }
            goto L_0x009d
        L_0x0099:
            r11 = move-exception
            r7 = r2
            goto L_0x00be
        L_0x009c:
            r12 = r7
        L_0x009d:
            if (r2 == 0) goto L_0x00c5
            r2.recycle()     // Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6 }
            goto L_0x00c5
        L_0x00a3:
            r10 = move-exception
            goto L_0x0120
        L_0x00a6:
            r10 = move-exception
            goto L_0x00f8
        L_0x00a8:
            r11 = move-exception
            goto L_0x0100
        L_0x00aa:
            r11 = move-exception
            goto L_0x00be
        L_0x00ac:
            r2 = r7
        L_0x00ad:
            java.lang.Class r3 = f22120f     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "Could not decode region %s, decoding full bitmap instead."
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0099 }
            r1[r0] = r12     // Catch:{ all -> 0x0099 }
            z2.a.h(r3, r4, r1)     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x00c4
            r2.recycle()     // Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6 }
            goto L_0x00c4
        L_0x00be:
            if (r7 == 0) goto L_0x00c3
            r7.recycle()     // Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6 }
        L_0x00c3:
            throw r11     // Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6 }
        L_0x00c4:
            r12 = r7
        L_0x00c5:
            if (r12 != 0) goto L_0x00cb
            android.graphics.Bitmap r12 = android.graphics.BitmapFactory.decodeStream(r10, r7, r11)     // Catch:{ IllegalArgumentException -> 0x00a8, RuntimeException -> 0x00a6 }
        L_0x00cb:
            androidx.core.util.Pools$Pool r10 = r9.f22126e
            r10.release(r13)
            if (r6 == 0) goto L_0x00e4
            if (r6 == r12) goto L_0x00e4
            h5.i r10 = r9.f22122a
            r10.release(r6)
            if (r12 == 0) goto L_0x00de
            r12.recycle()
        L_0x00de:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>()
            throw r10
        L_0x00e4:
            boolean r10 = r9.f22124c
            if (r10 == 0) goto L_0x00f1
            i5.b$a r10 = i5.b.a.f22127a
            c3.a r10 = c3.a.B(r12, r10)
            return r10
        L_0x00f1:
            h5.i r10 = r9.f22122a
            c3.a r10 = c3.a.B(r12, r10)
            return r10
        L_0x00f8:
            if (r6 == 0) goto L_0x00ff
            h5.i r11 = r9.f22122a     // Catch:{ all -> 0x00a3 }
            r11.release(r6)     // Catch:{ all -> 0x00a3 }
        L_0x00ff:
            throw r10     // Catch:{ all -> 0x00a3 }
        L_0x0100:
            if (r6 == 0) goto L_0x0107
            h5.i r12 = r9.f22122a     // Catch:{ all -> 0x00a3 }
            r12.release(r6)     // Catch:{ all -> 0x00a3 }
        L_0x0107:
            r10.reset()     // Catch:{ IOException -> 0x011f }
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r10)     // Catch:{ IOException -> 0x011f }
            if (r10 == 0) goto L_0x011e
            w4.f r12 = w4.f.a()     // Catch:{ IOException -> 0x011f }
            c3.a r10 = c3.a.B(r10, r12)     // Catch:{ IOException -> 0x011f }
            androidx.core.util.Pools$Pool r11 = r9.f22126e
            r11.release(r13)
            return r10
        L_0x011e:
            throw r11     // Catch:{ IOException -> 0x011f }
        L_0x011f:
            throw r11     // Catch:{ all -> 0x00a3 }
        L_0x0120:
            androidx.core.util.Pools$Pool r11 = r9.f22126e
            r11.release(r13)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.b.c(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect, android.graphics.ColorSpace):c3.a");
    }

    private static BitmapFactory.Options e(j jVar, Bitmap.Config config, boolean z10) {
        boolean z11;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = jVar.z();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        if (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.HARDWARE) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            options.inPreferredConfig = config;
        }
        options.inMutable = true;
        if (!z10) {
            BitmapFactory.decodeStream(jVar.w(), (Rect) null, options);
            if (options.outWidth == -1 || options.outHeight == -1) {
                throw new IllegalArgumentException();
            }
        }
        if (z11) {
            options.inPreferredConfig = config;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    public c3.a a(j jVar, Bitmap.Config config, Rect rect, int i10, ColorSpace colorSpace) {
        boolean z10;
        boolean G = jVar.G(i10);
        BitmapFactory.Options e10 = e(jVar, config, this.f22123b);
        e3.b w10 = jVar.w();
        l.g(w10);
        if (jVar.A() > i10) {
            w10 = new e3.a(w10, i10);
        }
        if (!G) {
            w10 = new e3.b(w10, f22121g);
        }
        if (e10.inPreferredConfig != Bitmap.Config.ARGB_8888) {
            z10 = true;
        } else {
            z10 = false;
        }
        try {
            c3.a c10 = c(w10, e10, rect, colorSpace);
            try {
                w10.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            return c10;
        } catch (RuntimeException e12) {
            if (z10) {
                c3.a a10 = a(jVar, Bitmap.Config.ARGB_8888, rect, i10, colorSpace);
                try {
                    w10.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
                return a10;
            }
            throw e12;
        } catch (Throwable th) {
            try {
                w10.close();
            } catch (IOException e14) {
                e14.printStackTrace();
            }
            throw th;
        }
    }

    public c3.a b(j jVar, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        boolean z10;
        BitmapFactory.Options e10 = e(jVar, config, this.f22123b);
        if (e10.inPreferredConfig != Bitmap.Config.ARGB_8888) {
            z10 = true;
        } else {
            z10 = false;
        }
        try {
            return c((InputStream) l.g(jVar.w()), e10, rect, colorSpace);
        } catch (RuntimeException e11) {
            if (z10) {
                return b(jVar, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e11;
        }
    }

    public abstract int d(int i10, int i11, BitmapFactory.Options options);
}
