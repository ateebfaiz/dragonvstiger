package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import l5.b;
import x3.c;

public class GenericDraweeView extends DraweeView<x3.a> {

    public interface a {
    }

    public GenericDraweeView(Context context, x3.a aVar) {
        super(context);
        setHierarchy(aVar);
    }

    public static void setInflateHierarchyListener(a aVar) {
    }

    /* access modifiers changed from: protected */
    public void g(Context context, AttributeSet attributeSet) {
        if (b.d()) {
            b.a("GenericDraweeView#inflateHierarchy");
        }
        x3.b d10 = c.d(context, attributeSet);
        setAspectRatio(d10.f());
        setHierarchy(d10.a());
        if (b.d()) {
            b.b();
        }
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        g(context, attributeSet);
    }
}
