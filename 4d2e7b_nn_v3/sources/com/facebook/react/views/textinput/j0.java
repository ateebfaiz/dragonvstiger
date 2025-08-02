package com.facebook.react.views.textinput;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import androidx.room.FtsOptions;
import com.facebook.react.uimanager.d0;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.r1;
import com.facebook.react.views.text.c;
import com.facebook.react.views.text.i;
import com.facebook.react.views.text.m;
import com.facebook.yoga.n;
import com.facebook.yoga.o;
import com.facebook.yoga.p;
import com.facebook.yoga.q;
import p5.a;

public class j0 extends c implements n {

    /* renamed from: b0  reason: collision with root package name */
    private int f4337b0;

    /* renamed from: c0  reason: collision with root package name */
    private EditText f4338c0;

    /* renamed from: d0  reason: collision with root package name */
    private q f4339d0;

    /* renamed from: e0  reason: collision with root package name */
    private String f4340e0;

    /* renamed from: f0  reason: collision with root package name */
    private String f4341f0;

    public j0(m mVar) {
        super(mVar);
        this.f4337b0 = -1;
        this.f4340e0 = null;
        this.f4341f0 = null;
        this.J = 1;
        B1();
    }

    private void B1() {
        X0(this);
    }

    public String A1() {
        return this.f4340e0;
    }

    public void E(Object obj) {
        a.a(obj instanceof q);
        this.f4339d0 = (q) obj;
        h();
    }

    public long U(q qVar, float f10, o oVar, float f11, o oVar2) {
        EditText editText = (EditText) a.c(this.f4338c0);
        q qVar2 = this.f4339d0;
        if (qVar2 != null) {
            qVar2.a(editText);
        } else {
            editText.setTextSize(0, (float) this.A.c());
            int i10 = this.H;
            if (i10 != -1) {
                editText.setLines(i10);
            }
            int breakStrategy = editText.getBreakStrategy();
            int i11 = this.J;
            if (breakStrategy != i11) {
                editText.setBreakStrategy(i11);
            }
        }
        editText.setHint(z1());
        editText.measure(com.facebook.react.views.view.c.a(f10, oVar), com.facebook.react.views.view.c.a(f11, oVar2));
        return p.b(editText.getMeasuredWidth(), editText.getMeasuredHeight());
    }

    public void Z0(int i10, float f10) {
        super.Z0(i10, f10);
        x0();
    }

    @h7.a(name = "mostRecentEventCount")
    public void setMostRecentEventCount(int i10) {
        this.f4337b0 = i10;
    }

    @h7.a(name = "placeholder")
    public void setPlaceholder(@Nullable String str) {
        this.f4341f0 = str;
        x0();
    }

    @h7.a(name = "text")
    public void setText(@Nullable String str) {
        this.f4340e0 = str;
        x0();
    }

    public void setTextBreakStrategy(String str) {
        if (str == null || FtsOptions.TOKENIZER_SIMPLE.equals(str)) {
            this.J = 0;
        } else if ("highQuality".equals(str)) {
            this.J = 1;
        } else if ("balanced".equals(str)) {
            this.J = 2;
        } else {
            z2.a.G("ReactNative", "Invalid textBreakStrategy: " + str);
            this.J = 0;
        }
    }

    public boolean u0() {
        return true;
    }

    public boolean v0() {
        return true;
    }

    /* access modifiers changed from: protected */
    public EditText y1() {
        return new EditText(new ContextThemeWrapper((Context) F(), com.facebook.react.q.f20911f));
    }

    public void z(e1 e1Var) {
        super.z(e1Var);
        EditText y12 = y1();
        J0(4, (float) ViewCompat.getPaddingStart(y12));
        J0(1, (float) y12.getPaddingTop());
        J0(5, (float) ViewCompat.getPaddingEnd(y12));
        J0(3, (float) y12.getPaddingBottom());
        this.f4338c0 = y12;
        y12.setPadding(0, 0, 0, 0);
        this.f4338c0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    public void z0(r1 r1Var) {
        super.z0(r1Var);
        if (this.f4337b0 != -1) {
            r1Var.O(q(), new i(x1(this, A1(), false, (d0) null), this.f4337b0, this.Z, k0(0), k0(1), k0(2), k0(3), this.I, this.J, this.L));
        }
    }

    public String z1() {
        return this.f4341f0;
    }

    public j0() {
        this((m) null);
    }
}
