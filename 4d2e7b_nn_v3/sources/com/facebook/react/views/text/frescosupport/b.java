package com.facebook.react.views.text.frescosupport;

import a4.a;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.TextView;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.g0;
import com.facebook.react.views.image.d;
import k5.c;
import w3.p;
import w7.i;

class b extends i {
    private TextView C;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f4208b;

    /* renamed from: c  reason: collision with root package name */
    private final t3.b f4209c;

    /* renamed from: d  reason: collision with root package name */
    private final a f4210d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f4211e;

    /* renamed from: f  reason: collision with root package name */
    private int f4212f;

    /* renamed from: g  reason: collision with root package name */
    private int f4213g;

    /* renamed from: h  reason: collision with root package name */
    private Uri f4214h;

    /* renamed from: i  reason: collision with root package name */
    private int f4215i;

    /* renamed from: j  reason: collision with root package name */
    private ReadableMap f4216j;

    /* renamed from: w  reason: collision with root package name */
    private String f4217w;

    public b(Resources resources, int i10, int i11, int i12, Uri uri, ReadableMap readableMap, t3.b bVar, Object obj, String str) {
        this.f4210d = new a(x3.b.u(resources).a());
        this.f4209c = bVar;
        this.f4211e = obj;
        this.f4213g = i12;
        this.f4214h = uri == null ? Uri.EMPTY : uri;
        this.f4216j = readableMap;
        this.f4215i = (int) g0.d((float) i11);
        this.f4212f = (int) g0.d((float) i10);
        this.f4217w = str;
    }

    private p.b i(String str) {
        return d.c(str);
    }

    public Drawable a() {
        return this.f4208b;
    }

    public int b() {
        return this.f4212f;
    }

    public void c() {
        this.f4210d.j();
    }

    public void d() {
        this.f4210d.k();
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        if (this.f4208b == null) {
            z6.a z10 = z6.a.z(c.w(this.f4214h), this.f4216j);
            ((x3.a) this.f4210d.g()).v(i(this.f4217w));
            this.f4210d.o(this.f4209c.z().a(this.f4210d.f()).B(this.f4211e).D(z10).build());
            this.f4209c.z();
            Drawable h10 = this.f4210d.h();
            this.f4208b = h10;
            h10.setBounds(0, 0, this.f4215i, this.f4212f);
            int i15 = this.f4213g;
            if (i15 != 0) {
                this.f4208b.setColorFilter(i15, PorterDuff.Mode.SRC_IN);
            }
            this.f4208b.setCallback(this.C);
        }
        canvas.save();
        canvas.translate(f10, (float) (((i13 + ((int) paint.descent())) - (((int) (paint.descent() - paint.ascent())) / 2)) - ((this.f4208b.getBounds().bottom - this.f4208b.getBounds().top) / 2)));
        this.f4208b.draw(canvas);
        canvas.restore();
    }

    public void e() {
        this.f4210d.j();
    }

    public void f() {
        this.f4210d.k();
    }

    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            int i12 = -this.f4212f;
            fontMetricsInt.ascent = i12;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i12;
            fontMetricsInt.bottom = 0;
        }
        return this.f4215i;
    }

    public void h(TextView textView) {
        this.C = textView;
    }
}
