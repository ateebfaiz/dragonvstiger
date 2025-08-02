package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.n;
import com.facebook.login.o;
import com.facebook.login.t;
import com.facebook.z;
import q5.d0;
import q5.p0;
import q5.v;
import q5.w;
import q5.x;

public class ProfilePictureView extends FrameLayout {

    /* renamed from: w  reason: collision with root package name */
    public static final String f20638w = "ProfilePictureView";

    /* renamed from: a  reason: collision with root package name */
    private String f20639a;

    /* renamed from: b  reason: collision with root package name */
    private int f20640b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f20641c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20642d = true;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f20643e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f20644f;

    /* renamed from: g  reason: collision with root package name */
    private int f20645g = -1;

    /* renamed from: h  reason: collision with root package name */
    private w f20646h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f20647i = null;

    /* renamed from: j  reason: collision with root package name */
    private z f20648j;

    class a extends z {
        a() {
        }

        /* access modifiers changed from: protected */
        public void c(Profile profile, Profile profile2) {
            String str;
            ProfilePictureView profilePictureView = ProfilePictureView.this;
            if (profile2 != null) {
                str = profile2.d();
            } else {
                str = null;
            }
            profilePictureView.setProfileId(str);
            ProfilePictureView.this.h(true);
        }
    }

    class b implements w.b {
        b() {
        }

        public void a(x xVar) {
            ProfilePictureView.this.g(xVar);
        }
    }

    public interface c {
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
        f(attributeSet);
    }

    private int c(boolean z10) {
        int i10;
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            int i11 = this.f20645g;
            if (i11 == -4) {
                i10 = n.f20550a;
            } else if (i11 == -3) {
                i10 = n.f20551b;
            } else if (i11 == -2) {
                i10 = n.f20552c;
            } else if (i11 != -1 || !z10) {
                return 0;
            } else {
                i10 = n.f20551b;
            }
            return getResources().getDimensionPixelSize(i10);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    private void d(Context context) {
        if (!v5.a.d(this)) {
            try {
                removeAllViews();
                this.f20644f = new ImageView(context);
                this.f20644f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f20644f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                addView(this.f20644f);
                this.f20648j = new a();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void f(AttributeSet attributeSet) {
        if (!v5.a.d(this)) {
            try {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, t.f20585d0);
                setPresetSize(obtainStyledAttributes.getInt(t.f20589f0, -1));
                this.f20642d = obtainStyledAttributes.getBoolean(t.f20587e0, true);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void g(x xVar) {
        if (!v5.a.d(this)) {
            try {
                if (xVar.c() == this.f20646h) {
                    this.f20646h = null;
                    Bitmap a10 = xVar.a();
                    Exception b10 = xVar.b();
                    if (b10 != null) {
                        d0.f(com.facebook.w.REQUESTS, 6, f20638w, b10.toString());
                    } else if (a10 != null) {
                        setImageBitmap(a10);
                        if (xVar.d()) {
                            i(false);
                        }
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void h(boolean z10) {
        if (!v5.a.d(this)) {
            try {
                boolean k10 = k();
                String str = this.f20639a;
                if (!(str == null || str.length() == 0)) {
                    if (this.f20641c != 0 || this.f20640b != 0) {
                        if (k10 || z10) {
                            i(true);
                            return;
                        }
                        return;
                    }
                }
                j();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void i(boolean z10) {
        String str;
        Uri f10;
        if (!v5.a.d(this)) {
            try {
                if (AccessToken.o()) {
                    str = AccessToken.d().m();
                } else {
                    str = "";
                }
                Uri d10 = w.d(this.f20639a, this.f20641c, this.f20640b, str);
                Profile c10 = Profile.c();
                if (!(!AccessToken.r() || c10 == null || (f10 = c10.f(this.f20641c, this.f20640b)) == null)) {
                    d10 = f10;
                }
                w a10 = new w.a(getContext(), d10).b(z10).d(this).c(new b()).a();
                w wVar = this.f20646h;
                if (wVar != null) {
                    v.c(wVar);
                }
                this.f20646h = a10;
                v.e(a10);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void j() {
        int i10;
        if (!v5.a.d(this)) {
            try {
                w wVar = this.f20646h;
                if (wVar != null) {
                    v.c(wVar);
                }
                if (this.f20647i == null) {
                    if (e()) {
                        i10 = o.f20554b;
                    } else {
                        i10 = o.f20553a;
                    }
                    setImageBitmap(BitmapFactory.decodeResource(getResources(), i10));
                    return;
                }
                k();
                setImageBitmap(Bitmap.createScaledBitmap(this.f20647i, this.f20641c, this.f20640b, false));
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private boolean k() {
        if (v5.a.d(this)) {
            return false;
        }
        try {
            int height = getHeight();
            int width = getWidth();
            boolean z10 = true;
            if (width >= 1) {
                if (height >= 1) {
                    int c10 = c(false);
                    if (c10 != 0) {
                        height = c10;
                        width = height;
                    }
                    if (width <= height) {
                        if (e()) {
                            height = width;
                        } else {
                            height = 0;
                        }
                    } else if (e()) {
                        width = height;
                    } else {
                        width = 0;
                    }
                    if (width == this.f20641c) {
                        if (height == this.f20640b) {
                            z10 = false;
                        }
                    }
                    this.f20641c = width;
                    this.f20640b = height;
                    return z10;
                }
            }
            return false;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    private void setImageBitmap(Bitmap bitmap) {
        if (!v5.a.d(this)) {
            try {
                ImageView imageView = this.f20644f;
                if (imageView != null && bitmap != null) {
                    this.f20643e = bitmap;
                    imageView.setImageBitmap(bitmap);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final boolean e() {
        return this.f20642d;
    }

    public final c getOnErrorListener() {
        return null;
    }

    public final int getPresetSize() {
        return this.f20645g;
    }

    public final String getProfileId() {
        return this.f20639a;
    }

    public final boolean getShouldUpdateOnProfileChange() {
        return this.f20648j.b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20646h = null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        h(false);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        boolean z10;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i10);
        boolean z11 = true;
        if (View.MeasureSpec.getMode(i11) == 1073741824 || layoutParams.height != -2) {
            z10 = false;
        } else {
            size = c(true);
            i11 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z10 = true;
        }
        if (View.MeasureSpec.getMode(i10) == 1073741824 || layoutParams.width != -2) {
            z11 = z10;
        } else {
            size2 = c(true);
            i10 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        }
        if (z11) {
            setMeasuredDimension(size2, size);
            measureChildren(i10, i11);
            return;
        }
        super.onMeasure(i10, i11);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("ProfilePictureView_superState"));
        this.f20639a = bundle.getString("ProfilePictureView_profileId");
        this.f20645g = bundle.getInt("ProfilePictureView_presetSize");
        this.f20642d = bundle.getBoolean("ProfilePictureView_isCropped");
        this.f20641c = bundle.getInt("ProfilePictureView_width");
        this.f20640b = bundle.getInt("ProfilePictureView_height");
        h(true);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        boolean z10;
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ProfilePictureView_superState", onSaveInstanceState);
        bundle.putString("ProfilePictureView_profileId", this.f20639a);
        bundle.putInt("ProfilePictureView_presetSize", this.f20645g);
        bundle.putBoolean("ProfilePictureView_isCropped", this.f20642d);
        bundle.putInt("ProfilePictureView_width", this.f20641c);
        bundle.putInt("ProfilePictureView_height", this.f20640b);
        if (this.f20646h != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        bundle.putBoolean("ProfilePictureView_refresh", z10);
        return bundle;
    }

    public final void setCropped(boolean z10) {
        this.f20642d = z10;
        h(false);
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.f20647i = bitmap;
    }

    public final void setOnErrorListener(c cVar) {
    }

    public final void setPresetSize(int i10) {
        if (i10 == -4 || i10 == -3 || i10 == -2 || i10 == -1) {
            this.f20645g = i10;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Must use a predefined preset size");
    }

    public final void setProfileId(@Nullable String str) {
        boolean z10;
        if (p0.Y(this.f20639a) || !this.f20639a.equalsIgnoreCase(str)) {
            j();
            z10 = true;
        } else {
            z10 = false;
        }
        this.f20639a = str;
        h(z10);
    }

    public final void setShouldUpdateOnProfileChange(boolean z10) {
        if (z10) {
            this.f20648j.d();
        } else {
            this.f20648j.e();
        }
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        d(context);
        f(attributeSet);
    }
}
