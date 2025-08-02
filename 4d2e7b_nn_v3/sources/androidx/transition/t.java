package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.transition.Transition;

abstract class t {

    private static class a extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        private final View f16716a;

        /* renamed from: b  reason: collision with root package name */
        private final View f16717b;

        /* renamed from: c  reason: collision with root package name */
        private final int f16718c;

        /* renamed from: d  reason: collision with root package name */
        private final int f16719d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f16720e;

        /* renamed from: f  reason: collision with root package name */
        private float f16721f;

        /* renamed from: g  reason: collision with root package name */
        private float f16722g;

        /* renamed from: h  reason: collision with root package name */
        private final float f16723h;

        /* renamed from: i  reason: collision with root package name */
        private final float f16724i;

        a(View view, View view2, int i10, int i11, float f10, float f11) {
            this.f16717b = view;
            this.f16716a = view2;
            this.f16718c = i10 - Math.round(view.getTranslationX());
            this.f16719d = i11 - Math.round(view.getTranslationY());
            this.f16723h = f10;
            this.f16724i = f11;
            int[] iArr = (int[]) view2.getTag(R.id.transition_position);
            this.f16720e = iArr;
            if (iArr != null) {
                view2.setTag(R.id.transition_position, (Object) null);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f16720e == null) {
                this.f16720e = new int[2];
            }
            this.f16720e[0] = Math.round(((float) this.f16718c) + this.f16717b.getTranslationX());
            this.f16720e[1] = Math.round(((float) this.f16719d) + this.f16717b.getTranslationY());
            this.f16716a.setTag(R.id.transition_position, this.f16720e);
        }

        public void onAnimationPause(Animator animator) {
            this.f16721f = this.f16717b.getTranslationX();
            this.f16722g = this.f16717b.getTranslationY();
            this.f16717b.setTranslationX(this.f16723h);
            this.f16717b.setTranslationY(this.f16724i);
        }

        public void onAnimationResume(Animator animator) {
            this.f16717b.setTranslationX(this.f16721f);
            this.f16717b.setTranslationY(this.f16722g);
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.f16717b.setTranslationX(this.f16723h);
            this.f16717b.setTranslationY(this.f16724i);
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    static Animator a(View view, TransitionValues transitionValues, int i10, int i11, float f10, float f11, float f12, float f13, TimeInterpolator timeInterpolator, Transition transition) {
        float f14;
        float f15;
        View view2 = view;
        TransitionValues transitionValues2 = transitionValues;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues2.view.getTag(R.id.transition_position);
        if (iArr != null) {
            f14 = ((float) (iArr[0] - i10)) + translationX;
            f15 = ((float) (iArr[1] - i11)) + translationY;
        } else {
            f14 = f10;
            f15 = f11;
        }
        int round = Math.round(f14 - translationX) + i10;
        int round2 = i11 + Math.round(f15 - translationY);
        view.setTranslationX(f14);
        view.setTranslationY(f15);
        if (f14 == f12 && f15 == f13) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f14, f12}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f15, f13})});
        a aVar = new a(view, transitionValues2.view, round, round2, translationX, translationY);
        transition.addListener(aVar);
        ofPropertyValuesHolder.addListener(aVar);
        a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
