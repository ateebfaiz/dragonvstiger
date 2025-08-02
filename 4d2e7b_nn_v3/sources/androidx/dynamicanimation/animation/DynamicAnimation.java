package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.a;
import java.util.ArrayList;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements a.b {
    public static final ViewProperty ALPHA = new c("alpha");
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    public static final ViewProperty ROTATION = new l("rotation");
    public static final ViewProperty ROTATION_X = new m("rotationX");
    public static final ViewProperty ROTATION_Y = new n("rotationY");
    public static final ViewProperty SCALE_X = new j("scaleX");
    public static final ViewProperty SCALE_Y = new k("scaleY");
    public static final ViewProperty SCROLL_X = new d("scrollX");
    public static final ViewProperty SCROLL_Y = new e("scrollY");
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final ViewProperty TRANSLATION_X = new g("translationX");
    public static final ViewProperty TRANSLATION_Y = new h("translationY");
    public static final ViewProperty TRANSLATION_Z = new i("translationZ");
    private static final float UNSET = Float.MAX_VALUE;
    public static final ViewProperty X = new o("x");
    public static final ViewProperty Y = new a("y");
    public static final ViewProperty Z = new b("z");
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        /* synthetic */ ViewProperty(String str, g gVar) {
            this(str);
        }

        private ViewProperty(String str) {
            super(str);
        }
    }

    static class a extends ViewProperty {
        a(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getY();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setY(f10);
        }
    }

    static class b extends ViewProperty {
        b(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return ViewCompat.getZ(view);
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            ViewCompat.setZ(view, f10);
        }
    }

    static class c extends ViewProperty {
        c(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getAlpha();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    static class d extends ViewProperty {
        d(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return (float) view.getScrollX();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    static class e extends ViewProperty {
        e(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return (float) view.getScrollY();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    class f extends FloatPropertyCompat {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FloatValueHolder f15374a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, FloatValueHolder floatValueHolder) {
            super(str);
            this.f15374a = floatValueHolder;
        }

        public float getValue(Object obj) {
            return this.f15374a.getValue();
        }

        public void setValue(Object obj, float f10) {
            this.f15374a.setValue(f10);
        }
    }

    static class g extends ViewProperty {
        g(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getTranslationX();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    static class h extends ViewProperty {
        h(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getTranslationY();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    static class i extends ViewProperty {
        i(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            ViewCompat.setTranslationZ(view, f10);
        }
    }

    static class j extends ViewProperty {
        j(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getScaleX();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    static class k extends ViewProperty {
        k(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getScaleY();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    static class l extends ViewProperty {
        l(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getRotation();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setRotation(f10);
        }
    }

    static class m extends ViewProperty {
        m(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getRotationX();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    static class n extends ViewProperty {
        n(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getRotationY();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    static class o extends ViewProperty {
        o(String str) {
            super(str, (g) null);
        }

        /* renamed from: a */
        public float getValue(View view) {
            return view.getX();
        }

        /* renamed from: b */
        public void setValue(View view, float f10) {
            view.setX(f10);
        }
    }

    static class p {

        /* renamed from: a  reason: collision with root package name */
        float f15376a;

        /* renamed from: b  reason: collision with root package name */
        float f15377b;

        p() {
        }
    }

    DynamicAnimation(FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new f("FloatValueHolder", floatValueHolder);
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean z10) {
        this.mRunning = false;
        a.d().g(this);
        this.mLastFrameTime = 0;
        this.mStartValueIsSet = false;
        for (int i10 = 0; i10 < this.mEndListeners.size(); i10++) {
            if (this.mEndListeners.get(i10) != null) {
                this.mEndListeners.get(i10).onAnimationEnd(this, z10, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t10) {
        int indexOf = arrayList.indexOf(t10);
        if (indexOf >= 0) {
            arrayList.set(indexOf, (Object) null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.mStartValueIsSet) {
                this.mValue = getPropertyValue();
            }
            float f10 = this.mValue;
            if (f10 > this.mMaxValue || f10 < this.mMinValue) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            a.d().a(this, 0);
        }
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!isRunning()) {
            if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
                this.mUpdateListeners.add(onAnimationUpdateListener);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.mRunning) {
            endAnimationInternal(true);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean doAnimationFrame(long j10) {
        long j11 = this.mLastFrameTime;
        if (j11 == 0) {
            this.mLastFrameTime = j10;
            setPropertyValue(this.mValue);
            return false;
        }
        this.mLastFrameTime = j10;
        boolean updateValueAndVelocity = updateValueAndVelocity(j10 - j11);
        float min = Math.min(this.mValue, this.mMaxValue);
        this.mValue = min;
        float max = Math.max(min, this.mMinValue);
        this.mValue = max;
        setPropertyValue(max);
        if (updateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return updateValueAndVelocity;
    }

    /* access modifiers changed from: package-private */
    public abstract float getAcceleration(float f10, float f11);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    /* access modifiers changed from: package-private */
    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isAtEquilibrium(float f10, float f11);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f10) {
        this.mMaxValue = f10;
        return this;
    }

    public T setMinValue(float f10) {
        this.mMinValue = f10;
        return this;
    }

    public T setMinimumVisibleChange(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        if (f10 > 0.0f) {
            this.mMinVisibleChange = f10;
            setValueThreshold(f10 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    /* access modifiers changed from: package-private */
    public void setPropertyValue(float f10) {
        this.mProperty.setValue(this.mTarget, f10);
        for (int i10 = 0; i10 < this.mUpdateListeners.size(); i10++) {
            if (this.mUpdateListeners.get(i10) != null) {
                this.mUpdateListeners.get(i10).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float f10) {
        this.mValue = f10;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f10) {
        this.mVelocity = f10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public abstract void setValueThreshold(float f10);

    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.mRunning) {
            startAnimationInternal();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean updateValueAndVelocity(long j10);

    <K> DynamicAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = k10;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat == ROTATION || floatPropertyCompat == ROTATION_X || floatPropertyCompat == ROTATION_Y) {
            this.mMinVisibleChange = 0.1f;
        } else if (floatPropertyCompat == ALPHA) {
            this.mMinVisibleChange = 0.00390625f;
        } else if (floatPropertyCompat == SCALE_X || floatPropertyCompat == SCALE_Y) {
            this.mMinVisibleChange = 0.00390625f;
        } else {
            this.mMinVisibleChange = 1.0f;
        }
    }
}
