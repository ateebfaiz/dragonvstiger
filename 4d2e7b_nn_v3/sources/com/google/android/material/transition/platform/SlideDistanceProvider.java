package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    @Px
    private int slideDistance = -1;
    private int slideEdge;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8918a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8919b;

        a(View view, float f10) {
            this.f8918a = view;
            this.f8919b = f10;
        }

        public void onAnimationEnd(Animator animator) {
            this.f8918a.setTranslationX(this.f8919b);
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8920a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8921b;

        b(View view, float f10) {
            this.f8920a = view;
            this.f8921b = f10;
        }

        public void onAnimationEnd(Animator animator) {
            this.f8920a.setTranslationY(this.f8921b);
        }
    }

    public SlideDistanceProvider(int i10) {
        this.slideEdge = i10;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i10, @Px int i11) {
        float f10;
        float f11;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i10 == 3) {
            return createTranslationXAnimator(view2, ((float) i11) + translationX, translationX, translationX);
        }
        if (i10 == 5) {
            return createTranslationXAnimator(view2, translationX - ((float) i11), translationX, translationX);
        }
        if (i10 == 48) {
            return createTranslationYAnimator(view2, translationY - ((float) i11), translationY, translationY);
        }
        if (i10 == 80) {
            return createTranslationYAnimator(view2, ((float) i11) + translationY, translationY, translationY);
        }
        if (i10 == 8388611) {
            if (isRtl(view)) {
                f10 = ((float) i11) + translationX;
            } else {
                f10 = translationX - ((float) i11);
            }
            return createTranslationXAnimator(view2, f10, translationX, translationX);
        } else if (i10 == 8388613) {
            if (isRtl(view)) {
                f11 = translationX - ((float) i11);
            } else {
                f11 = ((float) i11) + translationX;
            }
            return createTranslationXAnimator(view2, f11, translationX, translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i10);
        }
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i10, @Px int i11) {
        float f10;
        float f11;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i10 == 3) {
            return createTranslationXAnimator(view2, translationX, translationX - ((float) i11), translationX);
        }
        if (i10 == 5) {
            return createTranslationXAnimator(view2, translationX, ((float) i11) + translationX, translationX);
        }
        if (i10 == 48) {
            return createTranslationYAnimator(view2, translationY, ((float) i11) + translationY, translationY);
        }
        if (i10 == 80) {
            return createTranslationYAnimator(view2, translationY, translationY - ((float) i11), translationY);
        }
        if (i10 == 8388611) {
            if (isRtl(view)) {
                f10 = translationX - ((float) i11);
            } else {
                f10 = ((float) i11) + translationX;
            }
            return createTranslationXAnimator(view2, translationX, f10, translationX);
        } else if (i10 == 8388613) {
            if (isRtl(view)) {
                f11 = ((float) i11) + translationX;
            } else {
                f11 = translationX - ((float) i11);
            }
            return createTranslationXAnimator(view2, translationX, f11, translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i10);
        }
    }

    private static Animator createTranslationXAnimator(View view, float f10, float f11, float f12) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f10, f11})});
        ofPropertyValuesHolder.addListener(new a(view, f12));
        return ofPropertyValuesHolder;
    }

    private static Animator createTranslationYAnimator(View view, float f10, float f11, float f12) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f10, f11})});
        ofPropertyValuesHolder.addListener(new b(view, f12));
        return ofPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i10 = this.slideDistance;
        if (i10 != -1) {
            return i10;
        }
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        if (ViewCompat.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i10) {
        if (i10 >= 0) {
            this.slideDistance = i10;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i10) {
        this.slideEdge = i10;
    }
}
