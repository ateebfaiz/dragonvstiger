package com.facebook.react.views.modal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.pdns.f;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f4047a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Point f4048b = new Point();

    /* renamed from: c  reason: collision with root package name */
    private static final Point f4049c = new Point();

    /* renamed from: d  reason: collision with root package name */
    private static final Point f4050d = new Point();

    private a() {
    }

    public static final Point a(Context context) {
        m.f(context, "context");
        Object systemService = context.getSystemService("window");
        m.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = f4048b;
        Point point2 = f4049c;
        defaultDisplay.getCurrentSizeRange(point, point2);
        Point point3 = f4050d;
        defaultDisplay.getSize(point3);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843277});
        m.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int i10 = 0;
        boolean z10 = obtainStyledAttributes.getBoolean(0, false);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", f.f17924q);
        if (z10 && identifier > 0) {
            i10 = (int) resources.getDimension(identifier);
        }
        if (point3.x < point3.y) {
            return new Point(point.x, point2.y + i10);
        }
        return new Point(point2.x, point.y + i10);
    }
}
