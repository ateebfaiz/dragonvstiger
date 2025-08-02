package y0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.provider.Settings;
import com.airbnb.lottie.e;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;
import n0.u;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal f24865a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal f24866b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal f24867c = new c();

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal f24868d = new d();

    /* renamed from: e  reason: collision with root package name */
    private static final float f24869e = ((float) (Math.sqrt(2.0d) / 2.0d));

    class a extends ThreadLocal {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    class b extends ThreadLocal {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Path initialValue() {
            return new Path();
        }
    }

    class c extends ThreadLocal {
        c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Path initialValue() {
            return new Path();
        }
    }

    class d extends ThreadLocal {
        d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public float[] initialValue() {
            return new float[4];
        }
    }

    public static void a(Path path, float f10, float f11, float f12) {
        if (e.h()) {
            e.b("applyTrimPathIfNeeded");
        }
        PathMeasure pathMeasure = (PathMeasure) f24865a.get();
        Path path2 = (Path) f24866b.get();
        Path path3 = (Path) f24867c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f10 == 1.0f && f11 == 0.0f) {
            if (e.h()) {
                e.c("applyTrimPathIfNeeded");
            }
        } else if (length >= 1.0f && ((double) Math.abs((f11 - f10) - 1.0f)) >= 0.01d) {
            float f13 = f10 * length;
            float f14 = f11 * length;
            float f15 = f12 * length;
            float min = Math.min(f13, f14) + f15;
            float max = Math.max(f13, f14) + f15;
            if (min >= length && max >= length) {
                min = (float) k.f(min, length);
                max = (float) k.f(max, length);
            }
            if (min < 0.0f) {
                min = (float) k.f(min, length);
            }
            if (max < 0.0f) {
                max = (float) k.f(max, length);
            }
            int i10 = (min > max ? 1 : (min == max ? 0 : -1));
            if (i10 == 0) {
                path.reset();
                if (e.h()) {
                    e.c("applyTrimPathIfNeeded");
                    return;
                }
                return;
            }
            if (i10 >= 0) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            if (e.h()) {
                e.c("applyTrimPathIfNeeded");
            }
        } else if (e.h()) {
            e.c("applyTrimPathIfNeeded");
        }
    }

    public static void b(Path path, u uVar) {
        if (uVar != null && !uVar.k()) {
            a(path, ((o0.d) uVar.i()).q() / 100.0f, ((o0.d) uVar.d()).q() / 100.0f, ((o0.d) uVar.f()).q() / 360.0f);
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f10 = pointF.x;
            float f11 = pointF2.x;
            float f12 = pointF2.y;
            path.cubicTo(pointF3.x + f10, pointF.y + pointF3.y, f11 + pointF4.x, f12 + pointF4.y, f11, f12);
        }
        return path;
    }

    public static float e() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float f(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float g(Matrix matrix) {
        float[] fArr = (float[]) f24868d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f10 = f24869e;
        fArr[2] = f10;
        fArr[3] = f10;
        matrix.mapPoints(fArr);
        return (float) Math.hypot((double) (fArr[2] - fArr[0]), (double) (fArr[3] - fArr[1]));
    }

    public static boolean h(Matrix matrix) {
        float[] fArr = (float[]) f24868d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] == fArr[2] || fArr[1] == fArr[3]) {
            return true;
        }
        return false;
    }

    public static int i(float f10, float f11, float f12, float f13) {
        int i10;
        if (f10 != 0.0f) {
            i10 = (int) (((float) 527) * f10);
        } else {
            i10 = 17;
        }
        if (f11 != 0.0f) {
            i10 = (int) (((float) (i10 * 31)) * f11);
        }
        if (f12 != 0.0f) {
            i10 = (int) (((float) (i10 * 31)) * f12);
        }
        if (f13 != 0.0f) {
            return (int) (((float) (i10 * 31)) * f13);
        }
        return i10;
    }

    public static boolean j(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (i10 < i13) {
            return false;
        }
        if (i10 > i13) {
            return true;
        }
        if (i11 < i14) {
            return false;
        }
        if (i11 > i14) {
            return true;
        }
        if (i12 >= i15) {
            return true;
        }
        return false;
    }

    public static boolean k(Throwable th) {
        if ((th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException)) {
            return true;
        }
        return false;
    }

    public static int l(int i10, int i11) {
        return (int) ((((((float) i10) / 255.0f) * ((float) i11)) / 255.0f) * 255.0f);
    }

    public static Bitmap m(Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void n(Canvas canvas, RectF rectF, Paint paint) {
        o(canvas, rectF, paint, 31);
    }

    public static void o(Canvas canvas, RectF rectF, Paint paint, int i10) {
        if (e.h()) {
            e.b("Utils#saveLayer");
        }
        canvas.saveLayer(rectF, paint);
        if (e.h()) {
            e.c("Utils#saveLayer");
        }
    }
}
