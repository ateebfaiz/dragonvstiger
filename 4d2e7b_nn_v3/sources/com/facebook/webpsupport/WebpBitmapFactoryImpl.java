package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.TypedValue;
import com.facebook.imagepipeline.nativecode.e;
import h3.a;
import h3.b;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import y2.d;

@d
public class WebpBitmapFactoryImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    private static a f4846a;

    private static byte[] c(InputStream inputStream, BitmapFactory.Options options) {
        byte[] bArr;
        inputStream.mark(20);
        if (options == null || (bArr = options.inTempStorage) == null || bArr.length < 20) {
            bArr = new byte[20];
        }
        try {
            inputStream.read(bArr, 0, 20);
            inputStream.reset();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    @d
    private static Bitmap createBitmap(int i10, int i11, BitmapFactory.Options options) {
        Bitmap bitmap;
        if (options == null || (bitmap = options.inBitmap) == null || !bitmap.isMutable()) {
            return f4846a.a(i10, i11, Bitmap.Config.ARGB_8888);
        }
        return options.inBitmap;
    }

    private static void d(String str) {
    }

    private static InputStream e(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            return new BufferedInputStream(inputStream, 20);
        }
        return inputStream;
    }

    @d
    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options options) {
        byte[] bArr;
        if (options == null || (bArr = options.inTempStorage) == null) {
            return new byte[8192];
        }
        return bArr;
    }

    @d
    private static float getScaleFromOptions(BitmapFactory.Options options) {
        float f10 = 1.0f;
        if (options == null) {
            return 1.0f;
        }
        int i10 = options.inSampleSize;
        if (i10 > 1) {
            f10 = 1.0f / ((float) i10);
        }
        if (!options.inScaled) {
            return f10;
        }
        int i11 = options.inDensity;
        int i12 = options.inTargetDensity;
        int i13 = options.inScreenDensity;
        if (i11 == 0 || i12 == 0 || i11 == i13) {
            return f10;
        }
        return ((float) i12) / ((float) i11);
    }

    @d
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i10, int i11, BitmapFactory.Options options) {
        e.a();
        Bitmap originalDecodeByteArray = originalDecodeByteArray(bArr, i10, i11, options);
        if (originalDecodeByteArray == null) {
            d("webp_direct_decode_array_failed_on_no_webp");
        }
        return originalDecodeByteArray;
    }

    @d
    public static Bitmap hookDecodeFile(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        Bitmap bitmap = null;
        try {
            fileInputStream = new FileInputStream(str);
            bitmap = hookDecodeStream(fileInputStream, (Rect) null, options);
            fileInputStream.close();
        } catch (Exception unused) {
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        return bitmap;
        throw th;
    }

    @d
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        e.a();
        long nativeSeek = nativeSeek(fileDescriptor, 0, false);
        if (nativeSeek != -1) {
            InputStream e10 = e(new FileInputStream(fileDescriptor));
            try {
                c(e10, options);
                nativeSeek(fileDescriptor, nativeSeek, true);
                Bitmap originalDecodeFileDescriptor = originalDecodeFileDescriptor(fileDescriptor, rect, options);
                if (originalDecodeFileDescriptor == null) {
                    d("webp_direct_decode_fd_failed_on_no_webp");
                }
                try {
                    e10.close();
                    return originalDecodeFileDescriptor;
                } catch (Throwable unused) {
                    return originalDecodeFileDescriptor;
                }
            } catch (Throwable unused2) {
            }
        } else {
            Bitmap hookDecodeStream = hookDecodeStream(new FileInputStream(fileDescriptor), rect, options);
            setPaddingDefaultValues(rect);
            return hookDecodeStream;
        }
        throw th;
    }

    @d
    public static Bitmap hookDecodeResource(Resources resources, int i10, BitmapFactory.Options options) {
        InputStream openRawResource;
        TypedValue typedValue = new TypedValue();
        Bitmap bitmap = null;
        try {
            openRawResource = resources.openRawResource(i10, typedValue);
            bitmap = hookDecodeResourceStream(resources, typedValue, openRawResource, (Rect) null, options);
            if (openRawResource != null) {
                openRawResource.close();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        if (bitmap != null || options == null || options.inBitmap == null) {
            return bitmap;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
        throw th;
    }

    @d
    public static Bitmap hookDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i10 = typedValue.density;
            if (i10 == 0) {
                options.inDensity = 160;
            } else if (i10 != 65535) {
                options.inDensity = i10;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, options);
    }

    @d
    public static Bitmap hookDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        e.a();
        Bitmap originalDecodeStream = originalDecodeStream(e(inputStream), rect, options);
        if (originalDecodeStream == null) {
            d("webp_direct_decode_stream_failed_on_no_webp");
        }
        return originalDecodeStream;
    }

    @d
    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i10, int i11, BitmapFactory.Options options, float f10, byte[] bArr2);

    @d
    private static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f10, byte[] bArr);

    @d
    private static native long nativeSeek(FileDescriptor fileDescriptor, long j10, boolean z10);

    @d
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i10, int i11, BitmapFactory.Options options) {
        return BitmapFactory.decodeByteArray(bArr, i10, i11, options);
    }

    @d
    private static Bitmap originalDecodeFile(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    @d
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    @d
    private static Bitmap originalDecodeResource(Resources resources, int i10, BitmapFactory.Options options) {
        return BitmapFactory.decodeResource(resources, i10, options);
    }

    @d
    private static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    @d
    private static Bitmap originalDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    @d
    private static void setBitmapSize(BitmapFactory.Options options, int i10, int i11) {
        if (options != null) {
            options.outWidth = i10;
            options.outHeight = i11;
        }
    }

    @d
    private static boolean setOutDimensions(BitmapFactory.Options options, int i10, int i11) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        options.outWidth = i10;
        options.outHeight = i11;
        return true;
    }

    @d
    private static void setPaddingDefaultValues(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    @d
    @SuppressLint({"NewApi"})
    private static boolean shouldPremultiply(BitmapFactory.Options options) {
        if (options != null) {
            return options.inPremultiplied;
        }
        return true;
    }

    public Bitmap a(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        return hookDecodeFileDescriptor(fileDescriptor, rect, options);
    }

    public void b(a aVar) {
        f4846a = aVar;
    }

    @d
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i10, int i11) {
        return BitmapFactory.decodeByteArray(bArr, i10, i11);
    }

    @d
    private static Bitmap originalDecodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    @d
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    @d
    private static Bitmap originalDecodeResource(Resources resources, int i10) {
        return BitmapFactory.decodeResource(resources, i10);
    }

    @d
    private static Bitmap originalDecodeStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    @d
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i10, int i11) {
        return hookDecodeByteArray(bArr, i10, i11, (BitmapFactory.Options) null);
    }

    @d
    public static Bitmap hookDecodeFile(String str) {
        return hookDecodeFile(str, (BitmapFactory.Options) null);
    }

    @d
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        return hookDecodeStream(inputStream, (Rect) null, (BitmapFactory.Options) null);
    }

    @d
    public static Bitmap hookDecodeResource(Resources resources, int i10) {
        return hookDecodeResource(resources, i10, (BitmapFactory.Options) null);
    }

    @d
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, (Rect) null, (BitmapFactory.Options) null);
    }
}
