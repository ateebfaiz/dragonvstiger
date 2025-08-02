package com.facebook.react.uimanager;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import com.alibaba.pdns.model.DomainUhfReportModel;
import kotlin.jvm.internal.m;
import p5.a;

public final class a1 {

    /* renamed from: a  reason: collision with root package name */
    public static final a1 f3546a = new a1();

    private a1() {
    }

    public static final z0 a(View view) {
        m.f(view, "reactView");
        while (!(view instanceof z0)) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                return null;
            }
            a.a(parent instanceof View);
            view = (View) parent;
        }
        return (z0) view;
    }

    public static final Point b(View view) {
        m.f(view, DomainUhfReportModel.ENCRYPTYPE);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        iArr[0] = iArr[0] - rect.left;
        iArr[1] = iArr[1] - rect.top;
        return new Point(iArr[0], iArr[1]);
    }
}
