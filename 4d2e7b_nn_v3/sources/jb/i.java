package jb;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class i extends StateListDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f12465a;

    public i(Drawable drawable, int i10) {
        this.f12465a = i10;
        addState(new int[]{16842913}, drawable);
        addState(new int[0], drawable);
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z10 = false;
        for (int i10 : iArr) {
            if (i10 == 16842913) {
                z10 = true;
            }
        }
        if (z10) {
            super.setColorFilter(this.f12465a, PorterDuff.Mode.SRC_ATOP);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
