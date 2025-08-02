package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.drawee.view.a;
import y2.j;
import z3.b;

public class DraweeView<DH extends b> extends ImageView {

    /* renamed from: g  reason: collision with root package name */
    private static boolean f19651g;

    /* renamed from: a  reason: collision with root package name */
    private final a.C0247a f19652a = new a.C0247a();

    /* renamed from: b  reason: collision with root package name */
    private float f19653b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private a4.a f19654c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19655d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19656e = false;

    /* renamed from: f  reason: collision with root package name */
    private Object f19657f = null;

    public DraweeView(Context context) {
        super(context);
        c(context);
    }

    private void c(Context context) {
        try {
            if (l5.b.d()) {
                l5.b.a("DraweeView#init");
            }
            if (!this.f19655d) {
                boolean z10 = true;
                this.f19655d = true;
                this.f19654c = a4.a.d((b) null, context);
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                    if (!f19651g || context.getApplicationInfo().targetSdkVersion < 24) {
                        z10 = false;
                    }
                    this.f19656e = z10;
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                } else if (l5.b.d()) {
                    l5.b.b();
                }
            } else if (l5.b.d()) {
                l5.b.b();
            }
        } catch (Throwable th) {
            if (l5.b.d()) {
                l5.b.b();
            }
            throw th;
        }
    }

    private void d() {
        Drawable drawable;
        boolean z10;
        if (this.f19656e && (drawable = getDrawable()) != null) {
            if (getVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            drawable.setVisible(z10, false);
        }
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z10) {
        f19651g = z10;
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f19654c.j();
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f19654c.k();
    }

    /* access modifiers changed from: protected */
    public void e() {
        a();
    }

    /* access modifiers changed from: protected */
    public void f() {
        b();
    }

    public float getAspectRatio() {
        return this.f19653b;
    }

    public z3.a getController() {
        return this.f19654c.f();
    }

    public Object getExtraData() {
        return this.f19657f;
    }

    public DH getHierarchy() {
        return this.f19654c.g();
    }

    public Drawable getTopLevelDrawable() {
        return this.f19654c.h();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        e();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
        f();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        d();
        e();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        a.C0247a aVar = this.f19652a;
        aVar.f19660a = i10;
        aVar.f19661b = i11;
        a.b(aVar, this.f19653b, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        a.C0247a aVar2 = this.f19652a;
        super.onMeasure(aVar2.f19660a, aVar2.f19661b);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        d();
        f();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f19654c.l(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        d();
    }

    public void setAspectRatio(float f10) {
        if (f10 != this.f19653b) {
            this.f19653b = f10;
            requestLayout();
        }
    }

    public void setController(z3.a aVar) {
        this.f19654c.o(aVar);
        super.setImageDrawable(this.f19654c.h());
    }

    public void setExtraData(Object obj) {
        this.f19657f = obj;
    }

    public void setHierarchy(DH dh) {
        this.f19654c.p(dh);
        super.setImageDrawable(this.f19654c.h());
    }

    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        c(getContext());
        this.f19654c.n();
        super.setImageBitmap(bitmap);
    }

    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        c(getContext());
        this.f19654c.n();
        super.setImageDrawable(drawable);
    }

    @Deprecated
    public void setImageResource(int i10) {
        c(getContext());
        this.f19654c.n();
        super.setImageResource(i10);
    }

    @Deprecated
    public void setImageURI(Uri uri) {
        c(getContext());
        this.f19654c.n();
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z10) {
        this.f19656e = z10;
    }

    public String toString() {
        String str;
        j.a c10 = j.c(this);
        a4.a aVar = this.f19654c;
        if (aVar != null) {
            str = aVar.toString();
        } else {
            str = "<no holder set>";
        }
        return c10.b("holder", str).toString();
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c(context);
    }
}
