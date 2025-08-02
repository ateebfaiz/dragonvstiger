package com.horcrux.svg;

import android.graphics.Paint;
import android.graphics.Path;
import java.util.ArrayList;

class l {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f9902a;

    /* renamed from: b  reason: collision with root package name */
    private final int[][] f9903b = new int[256][];

    /* renamed from: c  reason: collision with root package name */
    private final Paint f9904c;

    l(Paint paint) {
        ArrayList arrayList = new ArrayList();
        this.f9902a = arrayList;
        this.f9904c = paint;
        arrayList.add(new Path());
    }

    private int a(char c10) {
        int[] iArr = this.f9903b[c10 >> 8];
        if (iArr == null) {
            return 0;
        }
        return iArr[c10 & 255];
    }

    /* access modifiers changed from: package-private */
    public Path b(char c10, String str) {
        Path path;
        int a10 = a(c10);
        if (a10 != 0) {
            path = (Path) this.f9902a.get(a10);
        } else {
            Path path2 = new Path();
            this.f9904c.getTextPath(str, 0, 1, 0.0f, 0.0f, path2);
            int[][] iArr = this.f9903b;
            int i10 = c10 >> 8;
            int[] iArr2 = iArr[i10];
            if (iArr2 == null) {
                iArr2 = new int[256];
                iArr[i10] = iArr2;
            }
            iArr2[c10 & 255] = this.f9902a.size();
            this.f9902a.add(path2);
            path = path2;
        }
        Path path3 = new Path();
        path3.addPath(path);
        return path3;
    }
}
