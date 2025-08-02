package com.horcrux.svg;

import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.horcrux.svg.SVGLength;

public class FilterRegion {
    SVGLength mH;
    SVGLength mW;
    SVGLength mX;
    SVGLength mY;

    private double getRelativeOrDefault(VirtualView virtualView, SVGLength sVGLength, float f10, double d10) {
        if (sVGLength == null || sVGLength.f9684b == SVGLength.UnitType.UNKNOWN) {
            return d10;
        }
        return virtualView.relativeOn(sVGLength, f10);
    }

    public Rect getCropRect(VirtualView virtualView, i iVar, RectF rectF) {
        double d10;
        double d11;
        double d12;
        double d13;
        VirtualView virtualView2 = virtualView;
        RectF rectF2 = rectF;
        if (rectF2 == null) {
            return new Rect(0, 0, 0, 0);
        }
        if (iVar == i.OBJECT_BOUNDING_BOX) {
            d13 = ((double) rectF2.left) + virtualView2.relativeOnFraction(this.mX, rectF.width());
            d12 = ((double) rectF2.top) + virtualView2.relativeOnFraction(this.mY, rectF.height());
            d11 = virtualView2.relativeOnFraction(this.mW, rectF.width());
            d10 = virtualView2.relativeOnFraction(this.mH, rectF.height());
        } else {
            float canvasWidth = virtualView.getSvgView().getCanvasWidth();
            float canvasHeight = virtualView.getSvgView().getCanvasHeight();
            VirtualView virtualView3 = virtualView;
            double relativeOrDefault = getRelativeOrDefault(virtualView3, this.mX, canvasWidth, (double) rectF2.left);
            double relativeOrDefault2 = getRelativeOrDefault(virtualView3, this.mY, canvasHeight, (double) rectF2.top);
            double relativeOrDefault3 = getRelativeOrDefault(virtualView3, this.mW, canvasWidth, (double) rectF.width());
            d10 = getRelativeOrDefault(virtualView3, this.mH, canvasHeight, (double) rectF.height());
            d13 = relativeOrDefault;
            d12 = relativeOrDefault2;
            d11 = relativeOrDefault3;
        }
        return new Rect((int) d13, (int) d12, (int) (d13 + d11), (int) (d12 + d10));
    }

    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.b(dynamic);
    }

    public void setWidth(Dynamic dynamic) {
        this.mW = SVGLength.b(dynamic);
    }

    public void setX(Dynamic dynamic) {
        this.mX = SVGLength.b(dynamic);
    }

    public void setY(Dynamic dynamic) {
        this.mY = SVGLength.b(dynamic);
    }
}
