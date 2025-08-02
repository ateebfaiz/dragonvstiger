package o5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import android.util.Pair;
import androidx.core.util.Pools;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23013a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f23014b = i.b(C0317a.f23016a);

    /* renamed from: c  reason: collision with root package name */
    private static boolean f23015c;

    /* renamed from: o5.a$a  reason: collision with other inner class name */
    static final class C0317a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final C0317a f23016a = new C0317a();

        C0317a() {
            super(0);
        }

        /* renamed from: a */
        public final Pools.SynchronizedPool invoke() {
            return new Pools.SynchronizedPool(12);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23017a;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|(2:13|14)|15|17) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0036 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0041 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGBA_F16     // Catch:{ NoSuchFieldError -> 0x0036 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0036 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0036 }
            L_0x0036:
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGBA_1010102     // Catch:{ NoSuchFieldError -> 0x0041 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0041 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.HARDWARE     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                f23017a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o5.a.b.<clinit>():void");
        }
    }

    private a() {
    }

    private final ByteBuffer a() {
        if (f23015c) {
            return b3.b.f17158a.acquire();
        }
        return (ByteBuffer) d().acquire();
    }

    public static final Pair b(InputStream inputStream) {
        if (inputStream != null) {
            a aVar = f23013a;
            ByteBuffer h10 = aVar.h();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                options.inTempStorage = h10.array();
                Pair pair = null;
                BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                if (options.outWidth != -1) {
                    if (options.outHeight != -1) {
                        pair = new Pair(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    }
                }
                aVar.i(h10);
                return pair;
            } catch (Throwable th) {
                f23013a.i(h10);
                throw th;
            }
        } else {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public static final d c(InputStream inputStream) {
        if (inputStream != null) {
            a aVar = f23013a;
            ByteBuffer h10 = aVar.h();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                options.inTempStorage = h10.array();
                ColorSpace colorSpace = null;
                BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                if (Build.VERSION.SDK_INT >= 26) {
                    colorSpace = options.outColorSpace;
                }
                d dVar = new d(options.outWidth, options.outHeight, colorSpace);
                aVar.i(h10);
                return dVar;
            } catch (Throwable th) {
                f23013a.i(h10);
                throw th;
            }
        } else {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    private final Pools.SynchronizedPool d() {
        return (Pools.SynchronizedPool) f23014b.getValue();
    }

    public static final int e(Bitmap.Config config) {
        int i10;
        if (config == null) {
            i10 = -1;
        } else {
            i10 = b.f23017a[config.ordinal()];
        }
        switch (i10) {
            case 1:
            case 6:
            case 7:
                return 4;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
                return 8;
            default:
                throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
        }
    }

    public static final int f(int i10, int i11, Bitmap.Config config) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(("width must be > 0, width is: " + i10).toString());
        } else if (i11 > 0) {
            int e10 = e(config);
            int i12 = i10 * i11 * e10;
            if (i12 > 0) {
                return i12;
            }
            throw new IllegalStateException(("size must be > 0: size: " + i12 + ", width: " + i10 + ", height: " + i11 + ", pixelSize: " + e10).toString());
        } else {
            throw new IllegalArgumentException(("height must be > 0, height is: " + i11).toString());
        }
    }

    public static final int g(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getByteCount();
        }
    }

    private final ByteBuffer h() {
        ByteBuffer a10 = a();
        if (a10 != null) {
            return a10;
        }
        ByteBuffer allocate = ByteBuffer.allocate(b3.b.c());
        m.e(allocate, "allocate(DecodeBufferHel…mendedDecodeBufferSize())");
        return allocate;
    }

    private final void i(ByteBuffer byteBuffer) {
        if (!f23015c) {
            d().release(byteBuffer);
        }
    }
}
