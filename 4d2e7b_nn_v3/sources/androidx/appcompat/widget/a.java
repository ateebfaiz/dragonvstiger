package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f14311a;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    private static class C0180a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public a(ActionBarContainer actionBarContainer) {
        this.f14311a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f14311a;
        if (actionBarContainer.mIsSplit) {
            Drawable drawable = actionBarContainer.mSplitBackground;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.mBackground;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f14311a;
        Drawable drawable3 = actionBarContainer2.mStackedBackground;
        if (drawable3 != null && actionBarContainer2.mIsStacked) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f14311a;
        if (!actionBarContainer.mIsSplit) {
            Drawable drawable = actionBarContainer.mBackground;
            if (drawable != null) {
                C0180a.a(drawable, outline);
            }
        } else if (actionBarContainer.mSplitBackground != null) {
            C0180a.a(actionBarContainer.mBackground, outline);
        }
    }

    public void setAlpha(int i10) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
