package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class TextView extends GroupView {
    private ArrayList C;
    private ArrayList N0;
    private ArrayList O0;
    private ArrayList P0;
    double Q0 = Double.NaN;

    /* renamed from: f  reason: collision with root package name */
    SVGLength f9733f = null;

    /* renamed from: g  reason: collision with root package name */
    SVGLength f9734g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f9735h = null;

    /* renamed from: i  reason: collision with root package name */
    h0 f9736i = h0.spacing;

    /* renamed from: j  reason: collision with root package name */
    private b0 f9737j;

    /* renamed from: w  reason: collision with root package name */
    private ArrayList f9738w;

    public TextView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public b0 A() {
        b0 b0Var;
        if (this.f9737j == null) {
            ViewParent parent = getParent();
            while (parent != null) {
                if (!(parent instanceof TextView) || (b0Var = ((TextView) parent).f9737j) == null) {
                    parent = parent.getParent();
                } else {
                    this.f9737j = b0Var;
                    return b0Var;
                }
            }
        }
        if (this.f9737j == null) {
            this.f9737j = b0.baseline;
        }
        return this.f9737j;
    }

    /* access modifiers changed from: package-private */
    public String B() {
        String str;
        if (this.f9735h == null) {
            ViewParent parent = getParent();
            while (parent != null) {
                if (!(parent instanceof TextView) || (str = ((TextView) parent).f9735h) == null) {
                    parent = parent.getParent();
                } else {
                    this.f9735h = str;
                    return str;
                }
            }
        }
        return this.f9735h;
    }

    /* access modifiers changed from: package-private */
    public Path C(Canvas canvas, Paint paint) {
        Path path = this.mPath;
        if (path != null) {
            return path;
        }
        v();
        this.mPath = super.getPath(canvas, paint);
        u();
        return this.mPath;
    }

    /* access modifiers changed from: package-private */
    public double D(Paint paint) {
        if (!Double.isNaN(this.Q0)) {
            return this.Q0;
        }
        double d10 = 0.0d;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof TextView) {
                d10 += ((TextView) childAt).D(paint);
            }
        }
        this.Q0 = d10;
        return d10;
    }

    /* access modifiers changed from: package-private */
    public TextView E() {
        ArrayList arrayList = t().f9873a;
        ViewParent parent = getParent();
        int size = arrayList.size() - 1;
        TextView textView = this;
        ViewParent viewParent = parent;
        while (size >= 0 && (viewParent instanceof TextView) && ((j) arrayList.get(size)).f9862j != f0.start && textView.f9738w == null) {
            textView = (TextView) viewParent;
            size--;
            viewParent = textView.getParent();
        }
        return textView;
    }

    /* access modifiers changed from: package-private */
    public TextView F() {
        TextView textView = this;
        ViewParent viewParent = getParent();
        while (viewParent instanceof TextView) {
            textView = (TextView) viewParent;
            viewParent = textView.getParent();
        }
        return textView;
    }

    public void G(Dynamic dynamic) {
        this.f9735h = SVGLength.c(dynamic);
        invalidate();
    }

    public void H(Dynamic dynamic) {
        this.O0 = SVGLength.a(dynamic);
        invalidate();
    }

    public void I(Dynamic dynamic) {
        this.P0 = SVGLength.a(dynamic);
        invalidate();
    }

    public void J(Dynamic dynamic) {
        this.f9733f = SVGLength.b(dynamic);
        invalidate();
    }

    public void K(String str) {
        this.f9736i = h0.valueOf(str);
        invalidate();
    }

    public void L(String str) {
        this.f9737j = b0.b(str);
        invalidate();
    }

    public void M(Dynamic dynamic) {
        this.f9738w = SVGLength.a(dynamic);
        invalidate();
    }

    public void N(Dynamic dynamic) {
        this.C = SVGLength.a(dynamic);
        invalidate();
    }

    public void O(Dynamic dynamic) {
        this.N0 = SVGLength.a(dynamic);
        invalidate();
    }

    public void P(Dynamic dynamic) {
        this.f9734g = SVGLength.b(dynamic);
        invalidate();
    }

    public void Q(Dynamic dynamic) {
        String c10 = SVGLength.c(dynamic);
        if (c10 != null) {
            String trim = c10.trim();
            int lastIndexOf = trim.lastIndexOf(32);
            try {
                this.f9737j = b0.b(trim.substring(lastIndexOf));
            } catch (IllegalArgumentException unused) {
                this.f9737j = b0.baseline;
            }
            try {
                this.f9735h = trim.substring(0, lastIndexOf);
            } catch (IndexOutOfBoundsException unused2) {
                this.f9735h = null;
            }
        } else {
            this.f9737j = b0.baseline;
            this.f9735h = null;
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.Q0 = Double.NaN;
        super.clearCache();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f10) {
        z(canvas);
        clip(canvas, paint);
        C(canvas, paint);
        v();
        p(canvas, paint, f10);
        u();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = this.mPath;
        if (path != null) {
            return path;
        }
        z(canvas);
        return C(canvas, paint);
    }

    public void invalidate() {
        if (this.mPath != null) {
            super.invalidate();
            F().clearChildCache();
        }
    }

    /* access modifiers changed from: package-private */
    public Path s(Canvas canvas, Paint paint, Region.Op op) {
        return getPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public void v() {
        boolean z10;
        if ((this instanceof TextPathView) || (this instanceof TSpanView)) {
            z10 = false;
        } else {
            z10 = true;
        }
        t().p(z10, this, this.f9615a, this.f9738w, this.C, this.O0, this.P0, this.N0);
    }
}
