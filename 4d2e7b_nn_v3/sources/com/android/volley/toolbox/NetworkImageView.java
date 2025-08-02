package com.android.volley.toolbox;

import a1.p;
import a1.u;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

public class NetworkImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private String f18343a;

    /* renamed from: b  reason: collision with root package name */
    private int f18344b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f18345c;

    class a implements p.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f18346a;

        a(boolean z10) {
            this.f18346a = z10;
        }

        public void a(u uVar) {
            if (NetworkImageView.this.f18345c != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f18345c);
            }
        }
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        int i10 = this.f18344b;
        if (i10 != 0) {
            setImageResource(i10);
        } else {
            setImageBitmap((Bitmap) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z10) {
        boolean z11;
        boolean z12;
        int width = getWidth();
        int height = getHeight();
        getScaleType();
        boolean z13 = true;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width == -2) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (getLayoutParams().height == -2) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z12 = false;
            z11 = false;
        }
        if (!z12 || !z11) {
            z13 = false;
        }
        if (width != 0 || height != 0 || z13) {
            if (TextUtils.isEmpty(this.f18343a)) {
                c();
            } else {
                new a(z10);
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        b(true);
    }

    public void setDefaultImageResId(int i10) {
        this.f18344b = i10;
    }

    public void setErrorImageResId(int i10) {
        this.f18345c = i10;
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
