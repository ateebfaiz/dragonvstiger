package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;

public abstract class a {

    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    public static class C0247a {

        /* renamed from: a  reason: collision with root package name */
        public int f19660a;

        /* renamed from: b  reason: collision with root package name */
        public int f19661b;
    }

    private static boolean a(int i10) {
        return i10 == 0 || i10 == -2;
    }

    public static void b(C0247a aVar, float f10, ViewGroup.LayoutParams layoutParams, int i10, int i11) {
        if (f10 > 0.0f && layoutParams != null) {
            if (a(layoutParams.height)) {
                aVar.f19661b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (View.MeasureSpec.getSize(aVar.f19660a) - i10)) / f10) + ((float) i11)), aVar.f19661b), 1073741824);
            } else if (a(layoutParams.width)) {
                aVar.f19660a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (View.MeasureSpec.getSize(aVar.f19661b) - i11)) * f10) + ((float) i10)), aVar.f19660a), 1073741824);
            }
        }
    }
}
