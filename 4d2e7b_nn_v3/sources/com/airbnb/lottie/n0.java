package com.airbnb.lottie;

import android.graphics.Bitmap;

public class n0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f17724a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17725b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17726c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17727d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17728e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f17729f;

    public n0(int i10, int i11, String str, String str2, String str3) {
        this.f17724a = i10;
        this.f17725b = i11;
        this.f17726c = str;
        this.f17727d = str2;
        this.f17728e = str3;
    }

    public n0 a(float f10) {
        n0 n0Var = new n0((int) (((float) this.f17724a) * f10), (int) (((float) this.f17725b) * f10), this.f17726c, this.f17727d, this.f17728e);
        Bitmap bitmap = this.f17729f;
        if (bitmap != null) {
            n0Var.g(Bitmap.createScaledBitmap(bitmap, n0Var.f17724a, n0Var.f17725b, true));
        }
        return n0Var;
    }

    public Bitmap b() {
        return this.f17729f;
    }

    public String c() {
        return this.f17727d;
    }

    public int d() {
        return this.f17725b;
    }

    public String e() {
        return this.f17726c;
    }

    public int f() {
        return this.f17724a;
    }

    public void g(Bitmap bitmap) {
        this.f17729f = bitmap;
    }
}
