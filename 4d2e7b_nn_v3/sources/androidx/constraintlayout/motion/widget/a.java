package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

abstract class a extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    a() {
    }

    /* access modifiers changed from: package-private */
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public abstract boolean intersects(int i10, int i11, RectF rectF, RectF rectF2, float f10, float f11);

    /* access modifiers changed from: package-private */
    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f10, float f11, String[] strArr, float[] fArr);
}
