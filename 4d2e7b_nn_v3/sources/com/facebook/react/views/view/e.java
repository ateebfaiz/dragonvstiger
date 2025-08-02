package com.facebook.react.views.view;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.core.view.ViewCompat;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private k7.a f4370a;

    /* renamed from: b  reason: collision with root package name */
    private View f4371b;

    /* renamed from: c  reason: collision with root package name */
    private int f4372c = 0;

    /* renamed from: d  reason: collision with root package name */
    private a f4373d = a.VISIBLE;

    private enum a {
        VISIBLE,
        HIDDEN,
        SCROLL
    }

    public e(View view) {
        this.f4371b = view;
    }

    private k7.a c() {
        if (this.f4370a == null) {
            this.f4370a = new k7.a(this.f4371b.getContext());
            Drawable background = this.f4371b.getBackground();
            ViewCompat.setBackground(this.f4371b, (Drawable) null);
            if (background == null) {
                ViewCompat.setBackground(this.f4371b, this.f4370a);
            } else {
                ViewCompat.setBackground(this.f4371b, new LayerDrawable(new Drawable[]{this.f4370a, background}));
            }
        }
        return this.f4370a;
    }

    public void a() {
        ViewCompat.setBackground(this.f4371b, (Drawable) null);
        this.f4371b = null;
        this.f4370a = null;
    }

    public int b() {
        return this.f4372c;
    }

    public void d(Canvas canvas) {
        if (this.f4373d != a.VISIBLE) {
            Rect rect = new Rect();
            this.f4371b.getDrawingRect(rect);
            k7.a aVar = this.f4370a;
            if (aVar == null) {
                canvas.clipRect(rect);
                return;
            }
            Path m10 = aVar.m();
            if (m10 != null) {
                m10.offset((float) rect.left, (float) rect.top);
                canvas.clipPath(m10);
                return;
            }
            RectF n10 = aVar.n();
            n10.offset((float) rect.left, (float) rect.top);
            canvas.clipRect(n10);
        }
    }

    public void e(int i10) {
        if (i10 != 0 || this.f4370a != null) {
            c().x(i10);
        }
    }

    public void f(int i10, float f10, float f11) {
        c().s(i10, f10, f11);
    }

    public void g(float f10) {
        c().z(f10);
    }

    public void h(float f10, int i10) {
        c().A(f10, i10);
    }

    public void i(String str) {
        c().v(str);
    }

    public void j(int i10, float f10) {
        c().w(i10, f10);
    }

    public void k(String str) {
        a aVar = this.f4373d;
        if ("hidden".equals(str)) {
            this.f4373d = a.HIDDEN;
        } else if ("scroll".equals(str)) {
            this.f4373d = a.SCROLL;
        } else {
            this.f4373d = a.VISIBLE;
        }
        if (aVar != this.f4373d) {
            this.f4371b.invalidate();
        }
    }
}
