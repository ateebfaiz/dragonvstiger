package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final View f14419a;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f14420a;

        a(boolean z10) {
            this.f14420a = z10;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f14420a) {
                b.super.dismiss();
            }
        }
    }

    b(Context context, View view) {
        super(context);
        this.f14419a = view;
    }

    private void b(boolean z10) {
        float f10;
        long j10;
        float f11 = 1.0f;
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = 1.0f;
        }
        if (!z10) {
            f11 = 0.0f;
        }
        if (z10) {
            j10 = 250;
        } else {
            j10 = 150;
        }
        this.f14419a.setScaleX(f10);
        this.f14419a.setScaleY(f10);
        this.f14419a.animate().scaleX(f11).scaleY(f11).setDuration(j10).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new a(z10)).start();
    }

    public void dismiss() {
        b(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return true;
    }

    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        b(true);
        super.show();
    }
}
