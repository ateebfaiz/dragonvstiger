package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
abstract class FilterPrimitiveView extends DefinitionView {

    /* renamed from: a  reason: collision with root package name */
    private String f9603a;

    /* renamed from: b  reason: collision with root package name */
    public final FilterRegion f9604b = new FilterRegion();

    public FilterPrimitiveView(ReactContext reactContext) {
        super(reactContext);
    }

    protected static Bitmap r(HashMap hashMap, Bitmap bitmap, String str) {
        Bitmap bitmap2;
        if (str != null) {
            bitmap2 = (Bitmap) hashMap.get(str);
        } else {
            bitmap2 = null;
        }
        if (bitmap2 != null) {
            return bitmap2;
        }
        return bitmap;
    }

    public abstract Bitmap p(HashMap hashMap, Bitmap bitmap);

    public String q() {
        return this.f9603a;
    }

    public void s(Dynamic dynamic) {
        this.f9604b.setHeight(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
    }

    public void t(String str) {
        this.f9603a = str;
        invalidate();
    }

    public void u(Dynamic dynamic) {
        this.f9604b.setWidth(dynamic);
        invalidate();
    }

    public void v(Dynamic dynamic) {
        this.f9604b.setX(dynamic);
        invalidate();
    }

    public void w(Dynamic dynamic) {
        this.f9604b.setY(dynamic);
        invalidate();
    }
}
