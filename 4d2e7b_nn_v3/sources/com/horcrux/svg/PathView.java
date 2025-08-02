package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"ViewConstructor"})
class PathView extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private Path f9658a = new Path();

    public PathView(ReactContext reactContext) {
        super(reactContext);
        n.f9910a = this.mScale;
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        return this.f9658a;
    }

    public void p(String str) {
        this.f9658a = n.o(str);
        ArrayList<m> arrayList = n.f9915f;
        this.elements = arrayList;
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            for (o oVar : it.next().f9909b) {
                double d10 = oVar.f9923a;
                float f10 = this.mScale;
                oVar.f9923a = d10 * ((double) f10);
                oVar.f9924b *= (double) f10;
            }
        }
        invalidate();
    }
}
