package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
class FeMergeView extends FilterPrimitiveView {

    /* renamed from: c  reason: collision with root package name */
    private ReadableArray f9599c;

    public FeMergeView(ReactContext reactContext) {
        super(reactContext);
    }

    public Bitmap p(HashMap hashMap, Bitmap bitmap) {
        Bitmap bitmap2;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int size = this.f9599c.size();
        for (int i10 = 0; i10 < size; i10++) {
            String string = this.f9599c.getString(i10);
            if (string.isEmpty()) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = (Bitmap) hashMap.get(string);
            }
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, new Paint());
            }
        }
        return createBitmap;
    }

    public void x(ReadableArray readableArray) {
        this.f9599c = readableArray;
        invalidate();
    }
}
