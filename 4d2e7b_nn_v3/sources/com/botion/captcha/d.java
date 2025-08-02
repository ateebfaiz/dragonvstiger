package com.botion.captcha;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.botion.captcha.BOCaptchaClient;
import kotlin.jvm.internal.m;

public final class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View f18526a;

    /* renamed from: b  reason: collision with root package name */
    public BOCaptchaClient.OnDialogShowListener f18527b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context, ae.b(context, "boc_captcha_dialog_style"));
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
        aa aaVar = aa.f18457a;
        Context context = getContext();
        m.e(context, "context");
        int a10 = aa.a(context);
        Context context2 = getContext();
        m.e(context2, "context");
        int b10 = aa.b(context2);
        if (layoutParams != null) {
            layoutParams.width = a10;
        }
        if (layoutParams != null) {
            layoutParams.height = b10;
        }
        af afVar = af.f18475a;
        StringBuilder sb2 = new StringBuilder("ScreenWidth: ");
        sb2.append(a10);
        sb2.append(", ScreenHeight: ");
        sb2.append(b10);
        sb2.append(", DialogWidth: ");
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
        af.b(sb2.toString());
        if (layoutParams != null) {
            layoutParams.gravity = 17;
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setAttributes(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m.e(LayoutInflater.from(getContext()), "inflater");
        View view = this.f18526a;
        if (view != null) {
            setContentView(view);
        }
    }

    public final void onWindowFocusChanged(boolean z10) {
        BOCaptchaClient.OnDialogShowListener onDialogShowListener = this.f18527b;
        if (onDialogShowListener != null) {
            onDialogShowListener.onDialogFocusChanged(this, z10);
        }
    }

    public final void show() {
        BOCaptchaClient.OnDialogShowListener onDialogShowListener = this.f18527b;
        if (onDialogShowListener != null) {
            onDialogShowListener.actionBeforeDialogShow(this);
        }
        super.show();
        BOCaptchaClient.OnDialogShowListener onDialogShowListener2 = this.f18527b;
        if (onDialogShowListener2 != null) {
            onDialogShowListener2.actionAfterDialogShow(this);
        }
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, String str) {
        super(context, ae.b(context, str));
        m.f(context, "context");
        m.f(str, "dialogStyle");
    }
}
