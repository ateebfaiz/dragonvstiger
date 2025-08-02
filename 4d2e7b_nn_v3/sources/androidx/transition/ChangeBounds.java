package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property<k, PointF> BOTTOM_RIGHT_PROPERTY;
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY;
    private static final Property<View, PointF> POSITION_PROPERTY;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    private static final Property<k, PointF> TOP_LEFT_PROPERTY;
    private static n sRectEvaluator = new n();
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private boolean mReparent = false;
    private boolean mResizeClip = false;
    private int[] mTempLocation = new int[2];

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f16559a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f16560b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f16561c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f16562d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f16559a = viewGroup;
            this.f16560b = bitmapDrawable;
            this.f16561c = view;
            this.f16562d = f10;
        }

        public void onAnimationEnd(Animator animator) {
            b0.b(this.f16559a).remove(this.f16560b);
            b0.h(this.f16561c, this.f16562d);
        }
    }

    static class b extends Property {

        /* renamed from: a  reason: collision with root package name */
        private Rect f16564a = new Rect();

        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f16564a);
            Rect rect = this.f16564a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f16564a);
            this.f16564a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f16564a);
        }
    }

    static class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    static class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    static class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            b0.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    static class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            b0.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    static class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            b0.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f16565a;
        private k mViewBounds;

        h(k kVar) {
            this.f16565a = kVar;
            this.mViewBounds = kVar;
        }
    }

    class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f16567a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f16568b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f16569c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f16570d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f16571e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f16572f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f16573g;

        i(View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f16568b = view;
            this.f16569c = rect;
            this.f16570d = i10;
            this.f16571e = i11;
            this.f16572f = i12;
            this.f16573g = i13;
        }

        public void onAnimationCancel(Animator animator) {
            this.f16567a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f16567a) {
                ViewCompat.setClipBounds(this.f16568b, this.f16569c);
                b0.g(this.f16568b, this.f16570d, this.f16571e, this.f16572f, this.f16573g);
            }
        }
    }

    class j extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        boolean f16575a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f16576b;

        j(ViewGroup viewGroup) {
            this.f16576b = viewGroup;
        }

        public void onTransitionCancel(Transition transition) {
            y.d(this.f16576b, false);
            this.f16575a = true;
        }

        public void onTransitionEnd(Transition transition) {
            if (!this.f16575a) {
                y.d(this.f16576b, false);
            }
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
            y.d(this.f16576b, false);
        }

        public void onTransitionResume(Transition transition) {
            y.d(this.f16576b, true);
        }
    }

    private static class k {

        /* renamed from: a  reason: collision with root package name */
        private int f16578a;

        /* renamed from: b  reason: collision with root package name */
        private int f16579b;

        /* renamed from: c  reason: collision with root package name */
        private int f16580c;

        /* renamed from: d  reason: collision with root package name */
        private int f16581d;

        /* renamed from: e  reason: collision with root package name */
        private View f16582e;

        /* renamed from: f  reason: collision with root package name */
        private int f16583f;

        /* renamed from: g  reason: collision with root package name */
        private int f16584g;

        k(View view) {
            this.f16582e = view;
        }

        private void b() {
            b0.g(this.f16582e, this.f16578a, this.f16579b, this.f16580c, this.f16581d);
            this.f16583f = 0;
            this.f16584g = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f16580c = Math.round(pointF.x);
            this.f16581d = Math.round(pointF.y);
            int i10 = this.f16584g + 1;
            this.f16584g = i10;
            if (this.f16583f == i10) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f16578a = Math.round(pointF.x);
            this.f16579b = Math.round(pointF.y);
            int i10 = this.f16583f + 1;
            this.f16583f = i10;
            if (i10 == this.f16584g) {
                b();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        DRAWABLE_ORIGIN_PROPERTY = new b(cls, "boundsOrigin");
        TOP_LEFT_PROPERTY = new c(cls, "topLeft");
        BOTTOM_RIGHT_PROPERTY = new d(cls, "bottomRight");
        BOTTOM_RIGHT_ONLY_PROPERTY = new e(cls, "bottomRight");
        TOP_LEFT_ONLY_PROPERTY = new f(cls, "topLeft");
        POSITION_PROPERTY = new g(cls, "position");
    }

    public ChangeBounds() {
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (ViewCompat.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
            if (this.mReparent) {
                transitionValues.view.getLocationInWindow(this.mTempLocation);
                transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
                transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
            }
            if (this.mResizeClip) {
                transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(view));
            }
        }
    }

    private boolean parentMatches(View view, View view2) {
        if (!this.mReparent) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.view) {
            return true;
        }
        return false;
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i10;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i11;
        Rect rect;
        ObjectAnimator objectAnimator2;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues3.values;
        Map<String, Object> map2 = transitionValues4.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues4.view;
        if (parentMatches(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) transitionValues3.values.get(PROPNAME_BOUNDS);
            Rect rect3 = (Rect) transitionValues4.values.get(PROPNAME_BOUNDS);
            int i12 = rect2.left;
            int i13 = rect3.left;
            int i14 = rect2.top;
            int i15 = rect3.top;
            int i16 = rect2.right;
            int i17 = rect3.right;
            int i18 = rect2.bottom;
            int i19 = rect3.bottom;
            int i20 = i16 - i12;
            int i21 = i18 - i14;
            int i22 = i17 - i13;
            int i23 = i19 - i15;
            View view3 = view2;
            Rect rect4 = (Rect) transitionValues3.values.get(PROPNAME_CLIP);
            Rect rect5 = (Rect) transitionValues4.values.get(PROPNAME_CLIP);
            if ((i20 == 0 || i21 == 0) && (i22 == 0 || i23 == 0)) {
                i10 = 0;
            } else {
                if (i12 == i13 && i14 == i15) {
                    i10 = 0;
                } else {
                    i10 = 1;
                }
                if (!(i16 == i17 && i18 == i19)) {
                    i10++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i10++;
            }
            if (i10 <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            if (!this.mResizeClip) {
                view = view3;
                b0.g(view, i12, i14, i16, i18);
                if (i10 == 2) {
                    if (i20 == i22 && i21 == i23) {
                        animator = l.a(view, POSITION_PROPERTY, getPathMotion().getPath((float) i12, (float) i14, (float) i13, (float) i15));
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a10 = l.a(kVar, TOP_LEFT_PROPERTY, getPathMotion().getPath((float) i12, (float) i14, (float) i13, (float) i15));
                        ObjectAnimator a11 = l.a(kVar, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath((float) i16, (float) i18, (float) i17, (float) i19));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a10, a11});
                        animatorSet.addListener(new h(kVar));
                        animator = animatorSet;
                    }
                } else if (i12 == i13 && i14 == i15) {
                    animator = l.a(view, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath((float) i16, (float) i18, (float) i17, (float) i19));
                } else {
                    animator = l.a(view, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath((float) i12, (float) i14, (float) i13, (float) i15));
                }
            } else {
                view = view3;
                b0.g(view, i12, i14, Math.max(i20, i22) + i12, Math.max(i21, i23) + i14);
                if (i12 == i13 && i14 == i15) {
                    objectAnimator = null;
                } else {
                    objectAnimator = l.a(view, POSITION_PROPERTY, getPathMotion().getPath((float) i12, (float) i14, (float) i13, (float) i15));
                }
                if (rect4 == null) {
                    i11 = 0;
                    rect4 = new Rect(0, 0, i20, i21);
                } else {
                    i11 = 0;
                }
                if (rect6 == null) {
                    rect = new Rect(i11, i11, i22, i23);
                } else {
                    rect = rect6;
                }
                if (!rect4.equals(rect)) {
                    ViewCompat.setClipBounds(view, rect4);
                    n nVar = sRectEvaluator;
                    Object[] objArr = new Object[2];
                    objArr[i11] = rect4;
                    objArr[1] = rect;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", nVar, objArr);
                    ofObject.addListener(new i(view, rect6, i13, i15, i17, i19));
                    objectAnimator2 = ofObject;
                } else {
                    objectAnimator2 = null;
                }
                animator = q.c(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                y.d(viewGroup4, true);
                addListener(new j(viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) transitionValues3.values.get(PROPNAME_WINDOW_X)).intValue();
        int intValue2 = ((Integer) transitionValues3.values.get(PROPNAME_WINDOW_Y)).intValue();
        int intValue3 = ((Integer) transitionValues4.values.get(PROPNAME_WINDOW_X)).intValue();
        int intValue4 = ((Integer) transitionValues4.values.get(PROPNAME_WINDOW_Y)).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.mTempLocation);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c10 = b0.c(view2);
        b0.h(view2, 0.0f);
        b0.b(viewGroup).add(bitmapDrawable);
        PathMotion pathMotion = getPathMotion();
        int[] iArr = this.mTempLocation;
        int i24 = iArr[0];
        int i25 = iArr[1];
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{m.a(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath((float) (intValue - i24), (float) (intValue2 - i25), (float) (intValue3 - i24), (float) (intValue4 - i25)))});
        ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c10));
        return ofPropertyValuesHolder;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z10) {
        this.mResizeClip = z10;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f16695d);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
