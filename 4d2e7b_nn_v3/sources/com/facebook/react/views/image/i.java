package com.facebook.react.views.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import w3.p;

public final class i extends p.a {

    /* renamed from: l  reason: collision with root package name */
    public static final a f4023l = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final p.b f4024m = new i();

    public static final class a {
        private a() {
        }

        public final p.b a() {
            return i.f4024m;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
        m.f(matrix, "outTransform");
        m.f(rect, "parentRect");
        float e10 = l.e(Math.min(f12, f13), 1.0f);
        matrix.setScale(e10, e10);
        matrix.postTranslate((float) Math.round((float) rect.left), (float) Math.round((float) rect.top));
    }

    public String toString() {
        return "start_inside";
    }
}
