package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.d0;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.m2;
import com.facebook.react.uimanager.v;
import h7.b;
import kotlin.jvm.internal.m;

public final class n extends v {
    private l A;
    private final float[] B;
    private final float[] C;
    private boolean D;

    public n() {
        int[] iArr = m2.f3814c;
        this.B = new float[iArr.length];
        this.C = new float[iArr.length];
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.B[i10] = Float.NaN;
            this.C[i10] = Float.NaN;
        }
    }

    private final float w1(j jVar, float f10, float f11) {
        if (jVar == j.OFF) {
            return f11;
        }
        if (jVar == j.MAXIMUM) {
            return Math.max(f10, f11);
        }
        return f10 + f11;
    }

    private final void x1(m mVar) {
        if (mVar == m.PADDING) {
            super.Z0(1, this.B[1]);
            super.Z0(2, this.B[1]);
            super.Z0(3, this.B[3]);
            super.Z0(0, this.B[0]);
        } else {
            super.U0(1, this.C[1]);
            super.U0(2, this.C[1]);
            super.U0(3, this.C[3]);
            super.U0(0, this.C[0]);
        }
        x0();
    }

    private final void y1() {
        float[] fArr;
        l lVar = this.A;
        if (lVar != null) {
            m c10 = lVar.c();
            m mVar = m.PADDING;
            if (c10 == mVar) {
                fArr = this.B;
            } else {
                fArr = this.C;
            }
            float f10 = fArr[8];
            if (Float.isNaN(f10)) {
                f10 = 0.0f;
            }
            float f11 = f10;
            float f12 = f11;
            float f13 = f12;
            float f14 = fArr[7];
            if (!Float.isNaN(f14)) {
                f10 = f14;
                f12 = f10;
            }
            float f15 = fArr[6];
            if (!Float.isNaN(f15)) {
                f11 = f15;
                f13 = f11;
            }
            float f16 = fArr[1];
            if (!Float.isNaN(f16)) {
                f10 = f16;
            }
            float f17 = fArr[2];
            if (!Float.isNaN(f17)) {
                f11 = f17;
            }
            float f18 = fArr[3];
            if (!Float.isNaN(f18)) {
                f12 = f18;
            }
            float f19 = fArr[0];
            if (!Float.isNaN(f19)) {
                f13 = f19;
            }
            float d10 = g0.d(f10);
            float d11 = g0.d(f11);
            float d12 = g0.d(f12);
            float d13 = g0.d(f13);
            k a10 = lVar.a();
            a b10 = lVar.b();
            if (lVar.c() == mVar) {
                super.Z0(1, w1(a10.d(), b10.d(), d10));
                super.Z0(2, w1(a10.c(), b10.c(), d11));
                super.Z0(3, w1(a10.a(), b10.a(), d12));
                super.Z0(0, w1(a10.b(), b10.b(), d13));
                return;
            }
            super.U0(1, w1(a10.d(), b10.d(), d10));
            super.U0(2, w1(a10.c(), b10.c(), d11));
            super.U0(3, w1(a10.a(), b10.a(), d12));
            super.U0(0, w1(a10.b(), b10.b(), d13));
        }
    }

    public void E(Object obj) {
        m.f(obj, "data");
        if (obj instanceof l) {
            l lVar = this.A;
            if (!(lVar == null || lVar.c() == ((l) obj).c())) {
                x1(lVar.c());
            }
            this.A = (l) obj;
            this.D = false;
            y1();
        }
    }

    public void V(d0 d0Var) {
        m.f(d0Var, "nativeViewHierarchyOptimizer");
        if (this.D) {
            this.D = false;
            y1();
        }
    }

    @b(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i10, Dynamic dynamic) {
        float f10;
        m.f(dynamic, "margin");
        int i11 = m2.f3814c[i10];
        float[] fArr = this.C;
        if (dynamic.getType() == ReadableType.Number) {
            f10 = (float) dynamic.asDouble();
        } else {
            f10 = Float.NaN;
        }
        fArr[i11] = f10;
        super.setMargins(i10, dynamic);
        this.D = true;
    }

    @b(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i10, Dynamic dynamic) {
        float f10;
        m.f(dynamic, "padding");
        int i11 = m2.f3814c[i10];
        float[] fArr = this.B;
        if (dynamic.getType() == ReadableType.Number) {
            f10 = (float) dynamic.asDouble();
        } else {
            f10 = Float.NaN;
        }
        fArr[i11] = f10;
        super.setPaddings(i10, dynamic);
        this.D = true;
    }
}
