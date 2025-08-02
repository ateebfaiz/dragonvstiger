package com.yalantis.ucrop.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import gb.a;
import hb.b;
import hb.c;
import java.io.File;
import java.io.IOException;
import jb.e;
import jb.f;

public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f11766a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f11767b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f11768c;

    /* renamed from: d  reason: collision with root package name */
    private float f11769d;

    /* renamed from: e  reason: collision with root package name */
    private float f11770e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11771f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11772g;

    /* renamed from: h  reason: collision with root package name */
    private final Bitmap.CompressFormat f11773h;

    /* renamed from: i  reason: collision with root package name */
    private final int f11774i;

    /* renamed from: j  reason: collision with root package name */
    private final String f11775j;

    /* renamed from: k  reason: collision with root package name */
    private final String f11776k;

    /* renamed from: l  reason: collision with root package name */
    private final b f11777l;

    /* renamed from: m  reason: collision with root package name */
    private final a f11778m;

    /* renamed from: n  reason: collision with root package name */
    private int f11779n;

    /* renamed from: o  reason: collision with root package name */
    private int f11780o;

    /* renamed from: p  reason: collision with root package name */
    private int f11781p;

    /* renamed from: q  reason: collision with root package name */
    private int f11782q;

    static {
        System.loadLibrary("ucrop");
    }

    public BitmapCropTask(Bitmap bitmap, c cVar, hb.a aVar, a aVar2) {
        this.f11766a = bitmap;
        this.f11767b = cVar.a();
        this.f11768c = cVar.c();
        this.f11769d = cVar.d();
        this.f11770e = cVar.b();
        this.f11771f = aVar.f();
        this.f11772g = aVar.g();
        this.f11773h = aVar.a();
        this.f11774i = aVar.b();
        this.f11775j = aVar.d();
        this.f11776k = aVar.e();
        this.f11777l = aVar.c();
        this.f11778m = aVar2;
    }

    private boolean a(float f10) {
        ExifInterface exifInterface = new ExifInterface(this.f11775j);
        this.f11781p = Math.round((this.f11767b.left - this.f11768c.left) / this.f11769d);
        this.f11782q = Math.round((this.f11767b.top - this.f11768c.top) / this.f11769d);
        this.f11779n = Math.round(this.f11767b.width() / this.f11769d);
        int round = Math.round(this.f11767b.height() / this.f11769d);
        this.f11780o = round;
        boolean e10 = e(this.f11779n, round);
        Log.i("BitmapCropTask", "Should crop: " + e10);
        if (e10) {
            boolean cropCImg = cropCImg(this.f11775j, this.f11776k, this.f11781p, this.f11782q, this.f11779n, this.f11780o, this.f11770e, f10, this.f11773h.ordinal(), this.f11774i, this.f11777l.a(), this.f11777l.b());
            if (cropCImg && this.f11773h.equals(Bitmap.CompressFormat.JPEG)) {
                f.b(exifInterface, this.f11779n, this.f11780o, this.f11776k);
            }
            return cropCImg;
        }
        e.a(this.f11775j, this.f11776k);
        return false;
    }

    public static native boolean cropCImg(String str, String str2, int i10, int i11, int i12, int i13, float f10, float f11, int i14, int i15, int i16, int i17) throws IOException, OutOfMemoryError;

    private float d() {
        int i10;
        int i11;
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z10 = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.f11775j, options);
        if (!(this.f11777l.a() == 90 || this.f11777l.a() == 270)) {
            z10 = false;
        }
        if (z10) {
            i10 = options.outHeight;
        } else {
            i10 = options.outWidth;
        }
        float width = ((float) i10) / ((float) this.f11766a.getWidth());
        if (z10) {
            i11 = options.outWidth;
        } else {
            i11 = options.outHeight;
        }
        this.f11769d /= Math.min(width, ((float) i11) / ((float) this.f11766a.getHeight()));
        if (this.f11771f > 0 && this.f11772g > 0) {
            float width2 = this.f11767b.width() / this.f11769d;
            float height = this.f11767b.height() / this.f11769d;
            int i12 = this.f11771f;
            if (width2 > ((float) i12) || height > ((float) this.f11772g)) {
                float min = Math.min(((float) i12) / width2, ((float) this.f11772g) / height);
                this.f11769d /= min;
                return min;
            }
        }
        return 1.0f;
    }

    private boolean e(int i10, int i11) {
        int round = Math.round(((float) Math.max(i10, i11)) / 1000.0f) + 1;
        if (this.f11771f > 0 && this.f11772g > 0) {
            return true;
        }
        float f10 = (float) round;
        if (Math.abs(this.f11767b.left - this.f11768c.left) > f10 || Math.abs(this.f11767b.top - this.f11768c.top) > f10 || Math.abs(this.f11767b.bottom - this.f11768c.bottom) > f10 || Math.abs(this.f11767b.right - this.f11768c.right) > f10 || this.f11770e != 0.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.f11766a;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.f11768c.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            a(d());
            this.f11766a = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void onPostExecute(Throwable th) {
        a aVar = this.f11778m;
        if (aVar == null) {
            return;
        }
        if (th == null) {
            this.f11778m.a(Uri.fromFile(new File(this.f11776k)), this.f11781p, this.f11782q, this.f11779n, this.f11780o);
            return;
        }
        aVar.b(th);
    }
}
