package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    private static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
    private static final g sCalculateBottom = new f();
    private static final g sCalculateEnd = new e();
    private static final g sCalculateLeft = new a();
    private static final g sCalculateRight = new d();
    private static final g sCalculateStart = new b();
    private static final g sCalculateTop = new c();
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private g mSlideCalculator = sCalculateBottom;
    private int mSlideEdge = 80;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    static class a extends h {
        a() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    static class b extends h {
        b() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            if (ViewCompat.getLayoutDirection(viewGroup) == 1) {
                return view.getTranslationX() + ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    static class c extends i {
        c() {
            super((a) null);
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    }

    static class d extends h {
        d() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    static class e extends h {
        e() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            if (ViewCompat.getLayoutDirection(viewGroup) == 1) {
                return view.getTranslationX() - ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    static class f extends i {
        f() {
            super((a) null);
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    }

    private interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class h implements g {
        private h() {
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    private static abstract class i implements g {
        private i() {
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    public Slide() {
        setSlideEdge(80);
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_POSITION, iArr);
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get(PROPNAME_SCREEN_POSITION);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return t.a(view, transitionValues2, iArr[0], iArr[1], this.mSlideCalculator.b(viewGroup, view), this.mSlideCalculator.a(viewGroup, view), translationX, translationY, sDecelerate, this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        return t.a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.mSlideCalculator.b(viewGroup, view), this.mSlideCalculator.a(viewGroup, view), sAccelerate, this);
    }

    public void setSlideEdge(int i10) {
        if (i10 == 3) {
            this.mSlideCalculator = sCalculateLeft;
        } else if (i10 == 5) {
            this.mSlideCalculator = sCalculateRight;
        } else if (i10 == 48) {
            this.mSlideCalculator = sCalculateTop;
        } else if (i10 == 80) {
            this.mSlideCalculator = sCalculateBottom;
        } else if (i10 == 8388611) {
            this.mSlideCalculator = sCalculateStart;
        } else if (i10 == 8388613) {
            this.mSlideCalculator = sCalculateEnd;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.mSlideEdge = i10;
        SidePropagation sidePropagation = new SidePropagation();
        sidePropagation.setSide(i10);
        setPropagation(sidePropagation);
    }

    public Slide(int i10) {
        setSlideEdge(i10);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f16699h);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        setSlideEdge(namedInt);
    }
}
