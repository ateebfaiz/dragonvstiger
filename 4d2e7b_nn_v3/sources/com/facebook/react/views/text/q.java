package com.facebook.react.views.text;

import com.facebook.react.uimanager.g0;
import z2.a;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4261a = true;

    /* renamed from: b  reason: collision with root package name */
    private float f4262b = Float.NaN;

    /* renamed from: c  reason: collision with root package name */
    private float f4263c = Float.NaN;

    /* renamed from: d  reason: collision with root package name */
    private float f4264d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    private float f4265e = Float.NaN;

    /* renamed from: f  reason: collision with root package name */
    private float f4266f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    private s f4267g = s.UNSET;

    public q a(q qVar) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        q qVar2 = new q();
        qVar2.f4261a = this.f4261a;
        if (!Float.isNaN(qVar.f4262b)) {
            f10 = qVar.f4262b;
        } else {
            f10 = this.f4262b;
        }
        qVar2.f4262b = f10;
        if (!Float.isNaN(qVar.f4263c)) {
            f11 = qVar.f4263c;
        } else {
            f11 = this.f4263c;
        }
        qVar2.f4263c = f11;
        if (!Float.isNaN(qVar.f4264d)) {
            f12 = qVar.f4264d;
        } else {
            f12 = this.f4264d;
        }
        qVar2.f4264d = f12;
        if (!Float.isNaN(qVar.f4265e)) {
            f13 = qVar.f4265e;
        } else {
            f13 = this.f4265e;
        }
        qVar2.f4265e = f13;
        if (!Float.isNaN(qVar.f4266f)) {
            f14 = qVar.f4266f;
        } else {
            f14 = this.f4266f;
        }
        qVar2.f4266f = f14;
        s sVar = qVar.f4267g;
        if (sVar == s.UNSET) {
            sVar = this.f4267g;
        }
        qVar2.f4267g = sVar;
        return qVar2;
    }

    public boolean b() {
        return this.f4261a;
    }

    public int c() {
        float f10;
        double ceil;
        if (!Float.isNaN(this.f4262b)) {
            f10 = this.f4262b;
        } else {
            f10 = 14.0f;
        }
        if (this.f4261a) {
            ceil = Math.ceil((double) g0.g(f10, f()));
        } else {
            ceil = Math.ceil((double) g0.d(f10));
        }
        return (int) ceil;
    }

    public float d() {
        float f10;
        if (Float.isNaN(this.f4264d)) {
            return Float.NaN;
        }
        if (this.f4261a) {
            f10 = g0.g(this.f4264d, f());
        } else {
            f10 = g0.d(this.f4264d);
        }
        return f10 / ((float) c());
    }

    public float e() {
        float f10;
        if (Float.isNaN(this.f4263c)) {
            return Float.NaN;
        }
        if (this.f4261a) {
            f10 = g0.g(this.f4263c, f());
        } else {
            f10 = g0.d(this.f4263c);
        }
        if (Float.isNaN(this.f4266f)) {
            return f10;
        }
        float f11 = this.f4266f;
        if (f11 > f10) {
            return f11;
        }
        return f10;
    }

    public float f() {
        if (!Float.isNaN(this.f4265e)) {
            return this.f4265e;
        }
        return 0.0f;
    }

    public float g() {
        return this.f4262b;
    }

    public float h() {
        return this.f4266f;
    }

    public float i() {
        return this.f4264d;
    }

    public float j() {
        return this.f4263c;
    }

    public float k() {
        return this.f4265e;
    }

    public s l() {
        return this.f4267g;
    }

    public void m(boolean z10) {
        this.f4261a = z10;
    }

    public void n(float f10) {
        this.f4262b = f10;
    }

    public void o(float f10) {
        this.f4266f = f10;
    }

    public void p(float f10) {
        this.f4264d = f10;
    }

    public void q(float f10) {
        this.f4263c = f10;
    }

    public void r(float f10) {
        if (f10 == 0.0f || f10 >= 1.0f) {
            this.f4265e = f10;
            return;
        }
        a.G("ReactNative", "maxFontSizeMultiplier must be NaN, 0, or >= 1");
        this.f4265e = Float.NaN;
    }

    public void s(s sVar) {
        this.f4267g = sVar;
    }

    public String toString() {
        return "TextAttributes {\n  getAllowFontScaling(): " + b() + "\n  getFontSize(): " + g() + "\n  getEffectiveFontSize(): " + c() + "\n  getHeightOfTallestInlineViewOrImage(): " + h() + "\n  getLetterSpacing(): " + i() + "\n  getEffectiveLetterSpacing(): " + d() + "\n  getLineHeight(): " + j() + "\n  getEffectiveLineHeight(): " + e() + "\n  getTextTransform(): " + l() + "\n  getMaxFontSizeMultiplier(): " + k() + "\n  getEffectiveMaxFontSizeMultiplier(): " + f() + "\n}";
    }
}
