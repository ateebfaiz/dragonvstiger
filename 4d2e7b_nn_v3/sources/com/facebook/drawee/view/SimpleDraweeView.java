package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import g3.f;
import o3.a;
import t3.b;
import y2.l;
import y2.o;

public class SimpleDraweeView extends GenericDraweeView {

    /* renamed from: i  reason: collision with root package name */
    private static o f19658i;

    /* renamed from: h  reason: collision with root package name */
    private b f19659h;

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context, attributeSet);
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        int resourceId;
        try {
            if (l5.b.d()) {
                l5.b.a("SimpleDraweeView#init");
            }
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                l.h(f19658i, "SimpleDraweeView was not initialized!");
                this.f19659h = (b) f19658i.get();
            }
            if (attributeSet != null) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.E);
                if (obtainStyledAttributes.hasValue(a.G)) {
                    k(Uri.parse(obtainStyledAttributes.getString(a.G)), (Object) null);
                } else if (obtainStyledAttributes.hasValue(a.F) && (resourceId = obtainStyledAttributes.getResourceId(a.F, -1)) != -1) {
                    if (isInEditMode()) {
                        setImageResource(resourceId);
                    } else {
                        setActualImageResource(resourceId);
                    }
                }
                obtainStyledAttributes.recycle();
            }
            if (l5.b.d()) {
                l5.b.b();
            }
        } catch (Throwable th) {
            if (l5.b.d()) {
                l5.b.b();
            }
            throw th;
        }
    }

    public static void i(o oVar) {
        f19658i = oVar;
    }

    public b getControllerBuilder() {
        return this.f19659h;
    }

    public void j(int i10, Object obj) {
        k(f.g(i10), obj);
    }

    public void k(Uri uri, Object obj) {
        setController(this.f19659h.B(obj).b(uri).a(getController()).build());
    }

    public void l(String str, Object obj) {
        Uri uri;
        if (str != null) {
            uri = Uri.parse(str);
        } else {
            uri = null;
        }
        k(uri, obj);
    }

    public void setActualImageResource(@DrawableRes int i10) {
        j(i10, (Object) null);
    }

    public void setImageRequest(k5.b bVar) {
        setController(this.f19659h.D(bVar).a(getController()).build());
    }

    public void setImageResource(int i10) {
        super.setImageResource(i10);
    }

    public void setImageURI(Uri uri) {
        k(uri, (Object) null);
    }

    public void setImageURI(String str) {
        l(str, (Object) null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h(context, attributeSet);
    }
}
