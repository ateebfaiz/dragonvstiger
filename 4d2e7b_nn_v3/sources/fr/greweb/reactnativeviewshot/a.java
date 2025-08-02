package fr.greweb.reactnativeviewshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.PixelCopy;
import android.view.PixelCopy$OnPixelCopyFinishedListener;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.interop.UIBlock;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.uimanager.c0;
import com.facebook.react.uimanager.i1;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;

public class a implements i1, UIBlock {
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final String f12177o = "a";
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static byte[] f12178p = new byte[65536];

    /* renamed from: q  reason: collision with root package name */
    private static final Object f12179q = new Object();

    /* renamed from: r  reason: collision with root package name */
    private static final Set f12180r = Collections.newSetFromMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f12181a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12182b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f12183c;

    /* renamed from: d  reason: collision with root package name */
    private final double f12184d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f12185e;

    /* renamed from: f  reason: collision with root package name */
    private final Integer f12186f;

    /* renamed from: g  reason: collision with root package name */
    private final File f12187g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f12188h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Promise f12189i;

    /* renamed from: j  reason: collision with root package name */
    private final Boolean f12190j;

    /* renamed from: k  reason: collision with root package name */
    private final ReactApplicationContext f12191k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f12192l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Activity f12193m;

    /* renamed from: n  reason: collision with root package name */
    private final Executor f12194n;

    /* renamed from: fr.greweb.reactnativeviewshot.a$a  reason: collision with other inner class name */
    class C0137a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UIBlockViewResolver f12195a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0 f12196b;

        C0137a(UIBlockViewResolver uIBlockViewResolver, c0 c0Var) {
            this.f12195a = uIBlockViewResolver;
            this.f12196b = c0Var;
        }

        public void run() {
            View view;
            try {
                if (a.this.f12181a == -1) {
                    view = a.this.f12193m.getWindow().getDecorView().findViewById(16908290);
                } else {
                    UIBlockViewResolver uIBlockViewResolver = this.f12195a;
                    if (uIBlockViewResolver != null) {
                        view = uIBlockViewResolver.resolveView(a.this.f12181a);
                    } else {
                        view = this.f12196b.resolveView(a.this.f12181a);
                    }
                }
                if (view == null) {
                    String l10 = a.f12177o;
                    Log.e(l10, "No view found with reactTag: " + a.this.f12181a, new AssertionError());
                    Promise d10 = a.this.f12189i;
                    d10.reject("E_UNABLE_TO_SNAPSHOT", "No view found with reactTag: " + a.this.f12181a);
                    return;
                }
                d dVar = new d(a.f12178p);
                dVar.k(a.y(view));
                a.f12178p = dVar.j();
                if ("tmpfile".equals(a.this.f12188h) && -1 == a.this.f12183c) {
                    a.this.C(view);
                } else if (!"tmpfile".equals(a.this.f12188h) || -1 == a.this.f12183c) {
                    if (!"base64".equals(a.this.f12188h)) {
                        if (!"zip-base64".equals(a.this.f12188h)) {
                            if ("data-uri".equals(a.this.f12188h)) {
                                a.this.B(view);
                                return;
                            }
                            return;
                        }
                    }
                    a.this.A(view);
                } else {
                    a.this.D(view);
                }
            } catch (Throwable th) {
                Log.e(a.f12177o, "Failed to capture view snapshot", th);
                a.this.f12189i.reject("E_UNABLE_TO_SNAPSHOT", "Failed to capture view snapshot");
            }
        }
    }

    class b implements PixelCopy$OnPixelCopyFinishedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Canvas f12198a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f12199b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f12200c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Bitmap f12201d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Paint f12202e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f12203f;

        b(Canvas canvas, View view, View view2, Bitmap bitmap, Paint paint, CountDownLatch countDownLatch) {
            this.f12198a = canvas;
            this.f12199b = view;
            this.f12200c = view2;
            this.f12201d = bitmap;
            this.f12202e = paint;
            this.f12203f = countDownLatch;
        }

        public void onPixelCopyFinished(int i10) {
            int save = this.f12198a.save();
            Matrix unused = a.this.q(this.f12198a, this.f12199b, this.f12200c);
            this.f12198a.drawBitmap(this.f12201d, 0.0f, 0.0f, this.f12202e);
            this.f12198a.restoreToCount(save);
            a.z(this.f12201d);
            this.f12203f.countDown();
        }
    }

    public @interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final Bitmap.CompressFormat[] f12205a = {Bitmap.CompressFormat.JPEG, Bitmap.CompressFormat.PNG, Bitmap.CompressFormat.WEBP};
    }

    public static class d extends ByteArrayOutputStream {
        public d(byte[] bArr) {
            super(0);
            this.buf = bArr;
        }

        protected static int h(int i10) {
            if (i10 < 0) {
                throw new OutOfMemoryError();
            } else if (i10 > 2147483639) {
                return Integer.MAX_VALUE;
            } else {
                return 2147483639;
            }
        }

        public ByteBuffer a(int i10) {
            if (this.buf.length < i10) {
                b(i10);
            }
            return ByteBuffer.wrap(this.buf);
        }

        /* access modifiers changed from: protected */
        public void b(int i10) {
            int length = this.buf.length << 1;
            if (length - i10 < 0) {
                length = i10;
            }
            if (length - 2147483639 > 0) {
                length = h(i10);
            }
            this.buf = Arrays.copyOf(this.buf, length);
        }

        public byte[] j() {
            return this.buf;
        }

        public void k(int i10) {
            this.count = i10;
        }
    }

    public a(int i10, String str, int i11, double d10, Integer num, Integer num2, File file, String str2, Boolean bool, ReactApplicationContext reactApplicationContext, Activity activity, boolean z10, Promise promise, Executor executor) {
        this.f12181a = i10;
        this.f12182b = str;
        this.f12183c = i11;
        this.f12184d = d10;
        this.f12185e = num;
        this.f12186f = num2;
        this.f12187g = file;
        this.f12188h = str2;
        this.f12190j = bool;
        this.f12191k = reactApplicationContext;
        this.f12193m = activity;
        this.f12192l = z10;
        this.f12189i = promise;
        this.f12194n = executor;
    }

    /* access modifiers changed from: private */
    public void A(View view) {
        boolean z10;
        String str;
        if (-1 == this.f12183c) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean equals = "zip-base64".equals(this.f12188h);
        d dVar = new d(f12178p);
        Point r10 = r(view, dVar);
        f12178p = dVar.j();
        int size = dVar.size();
        String format = String.format(Locale.US, "%d:%d|", new Object[]{Integer.valueOf(r10.x), Integer.valueOf(r10.y)});
        if (!z10) {
            format = "";
        }
        if (equals) {
            Deflater deflater = new Deflater();
            deflater.setInput(f12178p, 0, size);
            deflater.finish();
            d dVar2 = new d(new byte[32]);
            byte[] bArr = new byte[1024];
            while (!deflater.finished()) {
                dVar2.write(bArr, 0, deflater.deflate(bArr));
            }
            str = format + Base64.encodeToString(dVar2.j(), 0, dVar2.size(), 2);
        } else {
            str = format + Base64.encodeToString(f12178p, 0, size, 2);
        }
        this.f12189i.resolve(str);
    }

    /* access modifiers changed from: private */
    public void B(View view) {
        String str;
        d dVar = new d(f12178p);
        r(view, dVar);
        f12178p = dVar.j();
        String encodeToString = Base64.encodeToString(f12178p, 0, dVar.size(), 2);
        if ("jpg".equals(this.f12182b)) {
            str = "jpeg";
        } else {
            str = this.f12182b;
        }
        Promise promise = this.f12189i;
        promise.resolve("data:image/" + str + ";base64," + encodeToString);
    }

    /* access modifiers changed from: private */
    public void C(View view) {
        String uri = Uri.fromFile(this.f12187g).toString();
        FileOutputStream fileOutputStream = new FileOutputStream(this.f12187g);
        d dVar = new d(f12178p);
        Point r10 = r(view, dVar);
        f12178p = dVar.j();
        int size = dVar.size();
        fileOutputStream.write(String.format(Locale.US, "%d:%d|", new Object[]{Integer.valueOf(r10.x), Integer.valueOf(r10.y)}).getBytes(Charset.forName("US-ASCII")));
        fileOutputStream.write(f12178p, 0, size);
        fileOutputStream.close();
        this.f12189i.resolve(uri);
    }

    /* access modifiers changed from: private */
    public void D(View view) {
        r(view, new FileOutputStream(this.f12187g));
        this.f12189i.resolve(Uri.fromFile(this.f12187g).toString());
    }

    /* access modifiers changed from: private */
    public Matrix q(Canvas canvas, View view, View view2) {
        int i10;
        Matrix matrix = new Matrix();
        LinkedList linkedList = new LinkedList();
        View view3 = view2;
        do {
            linkedList.add(view3);
            view3 = (View) view3.getParent();
        } while (view3 != view);
        Collections.reverse(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            View view4 = (View) it.next();
            canvas.save();
            int left = view4.getLeft();
            int i11 = 0;
            if (view4 != view2) {
                i10 = view4.getPaddingLeft();
            } else {
                i10 = 0;
            }
            float translationX = ((float) (left + i10)) + view4.getTranslationX();
            int top = view4.getTop();
            if (view4 != view2) {
                i11 = view4.getPaddingTop();
            }
            float translationY = ((float) (top + i11)) + view4.getTranslationY();
            canvas.translate(translationX, translationY);
            canvas.rotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            canvas.scale(view4.getScaleX(), view4.getScaleY());
            matrix.postTranslate(translationX, translationY);
            matrix.postRotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            matrix.postScale(view4.getScaleX(), view4.getScaleY());
        }
        return matrix;
    }

    private Point r(View view, OutputStream outputStream) {
        try {
            return s(view, outputStream);
        } finally {
            outputStream.close();
        }
    }

    private Point s(View view, OutputStream outputStream) {
        int i10;
        Bitmap bitmap;
        OutputStream outputStream2;
        Bitmap bitmap2;
        Point point;
        Canvas canvas;
        boolean z10;
        Paint paint;
        Paint paint2;
        SurfaceView surfaceView;
        View view2 = view;
        OutputStream outputStream3 = outputStream;
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Impossible to snapshot the view: view is invalid");
        }
        boolean z11 = false;
        if (this.f12190j.booleanValue()) {
            ScrollView scrollView = (ScrollView) view2;
            int i11 = 0;
            for (int i12 = 0; i12 < scrollView.getChildCount(); i12++) {
                i11 += scrollView.getChildAt(i12).getHeight();
            }
            i10 = i11;
        } else {
            i10 = height;
        }
        Point point2 = new Point(width, i10);
        Bitmap w10 = w(width, i10);
        Paint paint3 = new Paint();
        boolean z12 = true;
        paint3.setAntiAlias(true);
        paint3.setFilterBitmap(true);
        paint3.setDither(true);
        Canvas canvas2 = new Canvas(w10);
        view2.draw(canvas2);
        for (View view3 : v(view)) {
            if (view3 instanceof TextureView) {
                if (view3.getVisibility() == 0) {
                    TextureView textureView = (TextureView) view3;
                    textureView.setOpaque(z11);
                    Bitmap bitmap3 = textureView.getBitmap(x(view3.getWidth(), view3.getHeight()));
                    int save = canvas2.save();
                    q(canvas2, view2, view3);
                    canvas2.drawBitmap(bitmap3, 0.0f, 0.0f, paint3);
                    canvas2.restoreToCount(save);
                    z(bitmap3);
                }
            } else if ((view3 instanceof SurfaceView) && this.f12192l) {
                SurfaceView surfaceView2 = (SurfaceView) view3;
                CountDownLatch countDownLatch = new CountDownLatch(z12 ? 1 : 0);
                if (Build.VERSION.SDK_INT >= 24) {
                    Bitmap x10 = x(view3.getWidth(), view3.getHeight());
                    try {
                        b bVar = r1;
                        CountDownLatch countDownLatch2 = countDownLatch;
                        Canvas canvas3 = canvas2;
                        surfaceView = surfaceView2;
                        point = point2;
                        canvas = canvas2;
                        View view4 = view3;
                        Bitmap bitmap4 = x10;
                        z10 = true;
                        paint2 = paint3;
                        bitmap2 = w10;
                        try {
                            b bVar2 = new b(canvas3, view, view4, x10, paint3, countDownLatch2);
                            PixelCopy.request(surfaceView, bitmap4, bVar, new Handler(Looper.getMainLooper()));
                            countDownLatch2.await(5, TimeUnit.SECONDS);
                        } catch (Exception e10) {
                            e = e10;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        surfaceView = surfaceView2;
                        paint2 = paint3;
                        bitmap2 = w10;
                        point = point2;
                        z10 = true;
                        canvas = canvas2;
                        Log.e(f12177o, "Cannot PixelCopy for " + surfaceView, e);
                        paint = paint2;
                        view2 = view;
                        paint3 = paint;
                        z12 = z10;
                        canvas2 = canvas;
                        point2 = point;
                        w10 = bitmap2;
                        z11 = false;
                        OutputStream outputStream4 = outputStream;
                    }
                } else {
                    SurfaceView surfaceView3 = surfaceView2;
                    paint2 = paint3;
                    bitmap2 = w10;
                    point = point2;
                    z10 = true;
                    canvas = canvas2;
                    if (surfaceView3.getDrawingCache() != null) {
                        paint = paint2;
                        canvas.drawBitmap(surfaceView3.getDrawingCache(), 0.0f, 0.0f, paint);
                        view2 = view;
                        paint3 = paint;
                        z12 = z10;
                        canvas2 = canvas;
                        point2 = point;
                        w10 = bitmap2;
                        z11 = false;
                        OutputStream outputStream42 = outputStream;
                    }
                }
                paint = paint2;
                view2 = view;
                paint3 = paint;
                z12 = z10;
                canvas2 = canvas;
                point2 = point;
                w10 = bitmap2;
                z11 = false;
                OutputStream outputStream422 = outputStream;
            }
            z10 = z12;
            paint = paint3;
            bitmap2 = w10;
            point = point2;
            canvas = canvas2;
            view2 = view;
            paint3 = paint;
            z12 = z10;
            canvas2 = canvas;
            point2 = point;
            w10 = bitmap2;
            z11 = false;
            OutputStream outputStream4222 = outputStream;
        }
        boolean z13 = z12;
        Bitmap bitmap5 = w10;
        Point point3 = point2;
        Integer num = this.f12185e;
        if (num == null || this.f12186f == null || (num.intValue() == width && this.f12186f.intValue() == i10)) {
            bitmap = bitmap5;
        } else {
            Bitmap bitmap6 = bitmap5;
            bitmap = Bitmap.createScaledBitmap(bitmap6, this.f12185e.intValue(), this.f12186f.intValue(), z13);
            z(bitmap6);
        }
        int i13 = this.f12183c;
        if (-1 == i13) {
            outputStream2 = outputStream;
            if (outputStream2 instanceof d) {
                int i14 = width * i10 * 4;
                d dVar = (d) t(outputStream);
                bitmap.copyPixelsToBuffer(dVar.a(i14));
                dVar.k(i14);
                z(bitmap);
                return point3;
            }
        } else {
            outputStream2 = outputStream;
        }
        bitmap.compress(c.f12205a[i13], (int) (this.f12184d * 100.0d), outputStream2);
        z(bitmap);
        return point3;
    }

    private static Object t(Object obj) {
        return obj;
    }

    private void u(c0 c0Var, UIBlockViewResolver uIBlockViewResolver) {
        this.f12194n.execute(new C0137a(uIBlockViewResolver, c0Var));
    }

    private List v(View view) {
        if (!(view instanceof ViewGroup)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            arrayList2.addAll(v(viewGroup.getChildAt(i10)));
        }
        return arrayList2;
    }

    private static Bitmap w(int i10, int i11) {
        synchronized (f12179q) {
            try {
                for (Bitmap bitmap : f12180r) {
                    if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
                        f12180r.remove(bitmap);
                        bitmap.eraseColor(0);
                        return bitmap;
                    }
                }
                return Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private static Bitmap x(int i10, int i11) {
        synchronized (f12179q) {
            try {
                for (Bitmap bitmap : f12180r) {
                    if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
                        f12180r.remove(bitmap);
                        bitmap.eraseColor(0);
                        return bitmap;
                    }
                }
                return Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static int y(View view) {
        return Math.min(view.getWidth() * view.getHeight() * 4, 32);
    }

    /* access modifiers changed from: private */
    public static void z(Bitmap bitmap) {
        synchronized (f12179q) {
            f12180r.add(bitmap);
        }
    }

    public void a(c0 c0Var) {
        u(c0Var, (UIBlockViewResolver) null);
    }

    public void execute(UIBlockViewResolver uIBlockViewResolver) {
        u((c0) null, uIBlockViewResolver);
    }
}
