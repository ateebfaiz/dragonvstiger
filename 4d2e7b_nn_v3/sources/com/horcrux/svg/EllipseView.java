package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class EllipseView extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private SVGLength f9572a;

    /* renamed from: b  reason: collision with root package name */
    private SVGLength f9573b;

    /* renamed from: c  reason: collision with root package name */
    private SVGLength f9574c;

    /* renamed from: d  reason: collision with root package name */
    private SVGLength f9575d;

    public EllipseView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double relativeOnWidth = relativeOnWidth(this.f9572a);
        double relativeOnHeight = relativeOnHeight(this.f9573b);
        double relativeOnWidth2 = relativeOnWidth(this.f9574c);
        double relativeOnHeight2 = relativeOnHeight(this.f9575d);
        double d10 = relativeOnWidth - relativeOnWidth2;
        double d11 = relativeOnHeight - relativeOnHeight2;
        double d12 = d10;
        double d13 = relativeOnWidth2 + relativeOnWidth;
        double d14 = relativeOnHeight2 + relativeOnHeight;
        double d15 = relativeOnHeight;
        path.addOval(new RectF((float) d10, (float) d11, (float) d13, (float) d14), Path.Direction.CW);
        ArrayList<m> arrayList = new ArrayList<>();
        this.elements = arrayList;
        arrayList.add(new m(c.kCGPathElementMoveToPoint, new o[]{new o(relativeOnWidth, d11)}));
        ArrayList<m> arrayList2 = this.elements;
        c cVar = c.kCGPathElementAddLineToPoint;
        o oVar = new o(relativeOnWidth, d11);
        double d16 = d11;
        double d17 = d15;
        Path path2 = path;
        arrayList2.add(new m(cVar, new o[]{oVar, new o(d13, d17)}));
        this.elements.add(new m(cVar, new o[]{new o(d13, d17), new o(relativeOnWidth, d14)}));
        double d18 = d12;
        this.elements.add(new m(cVar, new o[]{new o(relativeOnWidth, d14), new o(d18, d17)}));
        this.elements.add(new m(cVar, new o[]{new o(d18, d17), new o(relativeOnWidth, d16)}));
        return path2;
    }

    public void p(Dynamic dynamic) {
        this.f9572a = SVGLength.b(dynamic);
        invalidate();
    }

    public void q(Dynamic dynamic) {
        this.f9573b = SVGLength.b(dynamic);
        invalidate();
    }

    public void r(Dynamic dynamic) {
        this.f9574c = SVGLength.b(dynamic);
        invalidate();
    }

    public void s(Dynamic dynamic) {
        this.f9575d = SVGLength.b(dynamic);
        invalidate();
    }
}
