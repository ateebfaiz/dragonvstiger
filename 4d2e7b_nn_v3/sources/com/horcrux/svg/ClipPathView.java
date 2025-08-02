package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.react.bridge.ReactContext;
import z2.a;

@SuppressLint({"ViewConstructor"})
class ClipPathView extends GroupView {
    public ClipPathView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f10) {
        a.G("ReactNative", "RNSVG: ClipPath can't be drawn, it should be defined as a child component for `Defs` ");
    }

    public int hitTest(float[] fArr) {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean isResponsible() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void mergeProperties(RenderableView renderableView) {
    }

    /* access modifiers changed from: package-private */
    public void resetProperties() {
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        getSvgView().defineClipPath(this, this.mName);
    }
}
