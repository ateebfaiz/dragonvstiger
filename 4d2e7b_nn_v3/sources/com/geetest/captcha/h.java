package com.geetest.captcha;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.geetest.captcha.GTCaptcha4Client;
import kotlin.jvm.internal.m;

public final class h extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View f5807a;

    /* renamed from: b  reason: collision with root package name */
    public GTCaptcha4Client.OnDialogShowListener f5808b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context, g0.f5806a.b(context, "gt4_captcha_dialog_style"));
        m.f(context, "context");
    }

    public final void a() {
        WindowManager.LayoutParams layoutParams;
        Integer num;
        Window window = getWindow();
        if (window != null) {
            window.addFlags(1280);
        }
        Window window2 = getWindow();
        Integer num2 = null;
        if (window2 != null) {
            layoutParams = window2.getAttributes();
        } else {
            layoutParams = null;
        }
        Context context = getContext();
        m.e(context, "context");
        m.f(context, "context");
        Resources resources = context.getResources();
        m.e(resources, "context.resources");
        int i10 = resources.getDisplayMetrics().widthPixels;
        Context context2 = getContext();
        m.e(context2, "context");
        m.f(context2, "context");
        Resources resources2 = context2.getResources();
        m.e(resources2, "context.resources");
        int i11 = resources2.getDisplayMetrics().heightPixels;
        if (layoutParams != null) {
            layoutParams.width = i10;
        }
        if (layoutParams != null) {
            layoutParams.height = i11;
        }
        h0 h0Var = h0.f5812d;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ScreenWidth: ");
        sb2.append(i10);
        sb2.append(", ScreenHeight: ");
        sb2.append(i11);
        sb2.append(", ");
        sb2.append("DialogWidth: ");
        if (layoutParams != null) {
            num = Integer.valueOf(layoutParams.width);
        } else {
            num = null;
        }
        sb2.append(num);
        sb2.append(", DialogHeight: ");
        if (layoutParams != null) {
            num2 = Integer.valueOf(layoutParams.height);
        }
        sb2.append(num2);
        h0Var.c(sb2.toString());
        if (layoutParams != null) {
            layoutParams.gravity = 17;
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setAttributes(layoutParams);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m.e(LayoutInflater.from(getContext()), "inflater");
        View view = this.f5807a;
        if (view != null) {
            setContentView(view);
        }
    }

    public void onWindowFocusChanged(boolean z10) {
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener = this.f5808b;
        if (onDialogShowListener != null) {
            onDialogShowListener.onDialogFocusChanged(this, z10);
        }
    }

    public void show() {
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener = this.f5808b;
        if (onDialogShowListener != null) {
            onDialogShowListener.actionBeforeDialogShow(this);
        }
        super.show();
        GTCaptcha4Client.OnDialogShowListener onDialogShowListener2 = this.f5808b;
        if (onDialogShowListener2 != null) {
            onDialogShowListener2.actionAfterDialogShow(this);
        }
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context, String str) {
        super(context, g0.f5806a.b(context, str));
        m.f(context, "context");
        m.f(str, "dialogStyle");
    }
}
