package com.facebook.react.views.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import t3.d;

public abstract class g extends w3.g implements d {

    /* renamed from: e  reason: collision with root package name */
    public static final a f4022e = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b extends Drawable {
        public void draw(Canvas canvas) {
            m.f(canvas, "canvas");
        }

        public int getOpacity() {
            return -1;
        }

        public void setAlpha(int i10) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public g() {
        super(new b());
    }

    public void a(String str, Object obj) {
        m.f(str, "id");
    }

    public void k(String str) {
        m.f(str, "id");
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        w(i10, 10000);
        return super.onLevelChange(i10);
    }

    public void p(String str, Throwable th) {
        m.f(str, "id");
        m.f(th, "throwable");
    }

    public abstract void w(int i10, int i11);
}
