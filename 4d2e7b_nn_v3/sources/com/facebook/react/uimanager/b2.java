package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class b2 {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f3558a;

    /* renamed from: b  reason: collision with root package name */
    private int f3559b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int[] f3560c;

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            Integer viewZIndex = ViewGroupManager.getViewZIndex(view);
            Integer num = 0;
            if (viewZIndex == null) {
                viewZIndex = num;
            }
            Integer viewZIndex2 = ViewGroupManager.getViewZIndex(view2);
            if (viewZIndex2 != null) {
                num = viewZIndex2;
            }
            return viewZIndex.intValue() - num.intValue();
        }
    }

    public b2(ViewGroup viewGroup) {
        this.f3558a = viewGroup;
    }

    public int a(int i10, int i11) {
        int[] iArr = this.f3560c;
        if (iArr != null && (i11 >= iArr.length || iArr[i11] >= i10)) {
            z2.a.I("ReactNative", "getChildDrawingOrder index out of bounds! Please check any custom view manipulations you may have done. childCount = %d, index = %d", Integer.valueOf(i10), Integer.valueOf(i11));
            e();
        }
        if (this.f3560c == null) {
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < i10; i12++) {
                arrayList.add(this.f3558a.getChildAt(i12));
            }
            Collections.sort(arrayList, new a());
            this.f3560c = new int[i10];
            for (int i13 = 0; i13 < i10; i13++) {
                this.f3560c[i13] = this.f3558a.indexOfChild((View) arrayList.get(i13));
            }
        }
        return this.f3560c[i11];
    }

    public void b(View view) {
        if (ViewGroupManager.getViewZIndex(view) != null) {
            this.f3559b++;
        }
        this.f3560c = null;
    }

    public void c(View view) {
        if (ViewGroupManager.getViewZIndex(view) != null) {
            this.f3559b--;
        }
        this.f3560c = null;
    }

    public boolean d() {
        if (this.f3559b > 0) {
            return true;
        }
        return false;
    }

    public void e() {
        this.f3559b = 0;
        for (int i10 = 0; i10 < this.f3558a.getChildCount(); i10++) {
            if (ViewGroupManager.getViewZIndex(this.f3558a.getChildAt(i10)) != null) {
                this.f3559b++;
            }
        }
        this.f3560c = null;
    }
}
