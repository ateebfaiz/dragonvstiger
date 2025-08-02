package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class LineView extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private SVGLength f9631a;

    /* renamed from: b  reason: collision with root package name */
    private SVGLength f9632b;

    /* renamed from: c  reason: collision with root package name */
    private SVGLength f9633c;

    /* renamed from: d  reason: collision with root package name */
    private SVGLength f9634d;

    public LineView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double relativeOnWidth = relativeOnWidth(this.f9631a);
        double relativeOnHeight = relativeOnHeight(this.f9632b);
        double relativeOnWidth2 = relativeOnWidth(this.f9633c);
        double relativeOnHeight2 = relativeOnHeight(this.f9634d);
        path.moveTo((float) relativeOnWidth, (float) relativeOnHeight);
        path.lineTo((float) relativeOnWidth2, (float) relativeOnHeight2);
        ArrayList<m> arrayList = new ArrayList<>();
        this.elements = arrayList;
        arrayList.add(new m(c.kCGPathElementMoveToPoint, new o[]{new o(relativeOnWidth, relativeOnHeight)}));
        this.elements.add(new m(c.kCGPathElementAddLineToPoint, new o[]{new o(relativeOnWidth2, relativeOnHeight2)}));
        return path;
    }

    public void p(Dynamic dynamic) {
        this.f9631a = SVGLength.b(dynamic);
        invalidate();
    }

    public void q(Dynamic dynamic) {
        this.f9633c = SVGLength.b(dynamic);
        invalidate();
    }

    public void r(Dynamic dynamic) {
        this.f9632b = SVGLength.b(dynamic);
        invalidate();
    }

    public void s(Dynamic dynamic) {
        this.f9634d = SVGLength.b(dynamic);
        invalidate();
    }
}
