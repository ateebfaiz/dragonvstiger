package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.facebook.react.bridge.ReactContext;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
class FeGaussianBlurView extends FilterPrimitiveView {

    /* renamed from: c  reason: collision with root package name */
    String f9595c;

    /* renamed from: d  reason: collision with root package name */
    float f9596d;

    /* renamed from: e  reason: collision with root package name */
    float f9597e;

    /* renamed from: f  reason: collision with root package name */
    e f9598f;

    public FeGaussianBlurView(ReactContext reactContext) {
        super(reactContext);
    }

    private Bitmap x(Context context, Bitmap bitmap) {
        float max = Math.max(this.f9596d, this.f9597e) * 2.0f;
        if (max <= 0.0f) {
            return bitmap;
        }
        float min = Math.min(max, 25.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        RenderScript create = RenderScript.create(context);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
        create2.setRadius(min);
        create2.setInput(createFromBitmap);
        create2.forEach(createFromBitmap2);
        createFromBitmap2.copyTo(createBitmap);
        createFromBitmap.destroy();
        createFromBitmap2.destroy();
        create.destroy();
        return Bitmap.createScaledBitmap(createBitmap, bitmap.getWidth(), bitmap.getHeight(), false);
    }

    public void A(float f10) {
        this.f9596d = f10;
        invalidate();
    }

    public void B(float f10) {
        this.f9597e = f10;
        invalidate();
    }

    public Bitmap p(HashMap hashMap, Bitmap bitmap) {
        return x(getContext(), FilterPrimitiveView.r(hashMap, bitmap, this.f9595c));
    }

    public void y(String str) {
        this.f9598f = e.b(str);
        invalidate();
    }

    public void z(String str) {
        this.f9595c = str;
        invalidate();
    }
}
