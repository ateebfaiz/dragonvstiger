package k5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import w4.d;
import z4.p;

public abstract class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final Bitmap.Config f22282a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    private static Method f22283b;

    private static void c(Bitmap bitmap, Bitmap bitmap2) {
        if (!p.a() || bitmap.getConfig() != bitmap2.getConfig()) {
            new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            return;
        }
        try {
            if (f22283b == null) {
                int i10 = Bitmaps.f19989a;
                Class<Bitmap> cls = Bitmap.class;
                f22283b = Bitmaps.class.getDeclaredMethod("copyBitmap", new Class[]{cls, cls});
            }
            f22283b.invoke((Object) null, new Object[]{bitmap, bitmap2});
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException("Wrong Native code setup, reflection failed.", e13);
        }
    }

    public c3.a a(Bitmap bitmap, d dVar) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = f22282a;
        }
        c3.a d10 = dVar.d(width, height, config);
        try {
            e((Bitmap) d10.p(), bitmap);
            return d10.b();
        } finally {
            c3.a.m(d10);
        }
    }

    public r2.d b() {
        return null;
    }

    public void d(Bitmap bitmap) {
    }

    public void e(Bitmap bitmap, Bitmap bitmap2) {
        c(bitmap, bitmap2);
        d(bitmap);
    }

    public String getName() {
        return "Unknown postprocessor";
    }
}
