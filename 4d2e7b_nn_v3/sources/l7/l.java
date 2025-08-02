package l7;

import android.graphics.Paint;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class l extends Animation {

    /* renamed from: a  reason: collision with root package name */
    private final View f12645a;

    /* renamed from: b  reason: collision with root package name */
    private final float f12646b;

    /* renamed from: c  reason: collision with root package name */
    private final float f12647c;

    static class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private final View f12648a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12649b = false;

        public a(View view) {
            this.f12648a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f12649b) {
                this.f12648a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            if (this.f12648a.hasOverlappingRendering() && this.f12648a.getLayerType() == 0) {
                this.f12649b = true;
                this.f12648a.setLayerType(2, (Paint) null);
            }
        }
    }

    public l(View view, float f10, float f11) {
        this.f12645a = view;
        this.f12646b = f10;
        this.f12647c = f11 - f10;
        setAnimationListener(new a(view));
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f10, Transformation transformation) {
        this.f12645a.setAlpha(this.f12646b + (this.f12647c * f10));
    }

    public boolean willChangeBounds() {
        return false;
    }
}
