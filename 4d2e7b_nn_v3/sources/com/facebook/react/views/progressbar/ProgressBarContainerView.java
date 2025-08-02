package com.facebook.react.views.progressbar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;

class ProgressBarContainerView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Integer f4059a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4060b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4061c = true;

    /* renamed from: d  reason: collision with root package name */
    private double f4062d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f4063e;

    public ProgressBarContainerView(Context context) {
        super(context);
    }

    private void c(ProgressBar progressBar) {
        Drawable drawable;
        if (progressBar.isIndeterminate()) {
            drawable = progressBar.getIndeterminateDrawable();
        } else {
            drawable = progressBar.getProgressDrawable();
        }
        if (drawable != null) {
            Integer num = this.f4059a;
            if (num != null) {
                drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            } else {
                drawable.clearColorFilter();
            }
        }
    }

    public void a() {
        ProgressBar progressBar = this.f4063e;
        if (progressBar != null) {
            progressBar.setIndeterminate(this.f4060b);
            c(this.f4063e);
            this.f4063e.setProgress((int) (this.f4062d * 1000.0d));
            if (this.f4061c) {
                this.f4063e.setVisibility(0);
            } else {
                this.f4063e.setVisibility(4);
            }
        } else {
            throw new JSApplicationIllegalArgumentException("setStyle() not called");
        }
    }

    public void b(boolean z10) {
        this.f4061c = z10;
    }

    public void d(Integer num) {
        this.f4059a = num;
    }

    public void e(boolean z10) {
        this.f4060b = z10;
    }

    public void f(double d10) {
        this.f4062d = d10;
    }

    public void g(String str) {
        ProgressBar createProgressBar = ReactProgressBarViewManager.createProgressBar(getContext(), ReactProgressBarViewManager.getStyleFromString(str));
        this.f4063e = createProgressBar;
        createProgressBar.setMax(1000);
        removeAllViews();
        addView(this.f4063e, new ViewGroup.LayoutParams(-1, -1));
    }
}
