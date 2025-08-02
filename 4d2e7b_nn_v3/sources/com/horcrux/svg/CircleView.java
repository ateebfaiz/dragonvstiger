package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class CircleView extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private SVGLength f9569a;

    /* renamed from: b  reason: collision with root package name */
    private SVGLength f9570b;

    /* renamed from: c  reason: collision with root package name */
    private SVGLength f9571c;

    public CircleView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double relativeOnWidth = relativeOnWidth(this.f9569a);
        double relativeOnHeight = relativeOnHeight(this.f9570b);
        double relativeOnOther = relativeOnOther(this.f9571c);
        path.addCircle((float) relativeOnWidth, (float) relativeOnHeight, (float) relativeOnOther, Path.Direction.CW);
        ArrayList<m> arrayList = new ArrayList<>();
        this.elements = arrayList;
        double d10 = relativeOnHeight - relativeOnOther;
        arrayList.add(new m(c.kCGPathElementMoveToPoint, new o[]{new o(relativeOnWidth, d10)}));
        ArrayList<m> arrayList2 = this.elements;
        c cVar = c.kCGPathElementAddLineToPoint;
        o oVar = new o(relativeOnWidth, d10);
        double d11 = d10;
        double d12 = relativeOnWidth + relativeOnOther;
        Path path2 = path;
        arrayList2.add(new m(cVar, new o[]{oVar, new o(d12, relativeOnHeight)}));
        ArrayList<m> arrayList3 = this.elements;
        o oVar2 = new o(d12, relativeOnHeight);
        double d13 = relativeOnHeight + relativeOnOther;
        arrayList3.add(new m(cVar, new o[]{oVar2, new o(relativeOnWidth, d13)}));
        double d14 = relativeOnWidth - relativeOnOther;
        this.elements.add(new m(cVar, new o[]{new o(relativeOnWidth, d13), new o(d14, relativeOnHeight)}));
        this.elements.add(new m(cVar, new o[]{new o(d14, relativeOnHeight), new o(relativeOnWidth, d11)}));
        return path2;
    }

    public void p(Dynamic dynamic) {
        this.f9569a = SVGLength.b(dynamic);
        invalidate();
    }

    public void q(Dynamic dynamic) {
        this.f9570b = SVGLength.b(dynamic);
        invalidate();
    }

    public void r(Dynamic dynamic) {
        this.f9571c = SVGLength.b(dynamic);
        invalidate();
    }
}
