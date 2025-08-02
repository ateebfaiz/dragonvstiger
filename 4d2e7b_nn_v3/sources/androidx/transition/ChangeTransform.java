package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final Property<e, float[]> NON_TRANSLATIONS_PROPERTY = new a(float[].class, "nonTranslations");
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION = true;
    private static final Property<e, PointF> TRANSLATIONS_PROPERTY = new b(PointF.class, "translations");
    private static final String[] sTransitionProperties = {PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
    private boolean mReparent = true;
    private Matrix mTempMatrix = new Matrix();
    boolean mUseOverlay = true;

    static class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public float[] get(e eVar) {
            return null;
        }

        /* renamed from: b */
        public void set(e eVar, float[] fArr) {
            eVar.d(fArr);
        }
    }

    static class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(e eVar) {
            return null;
        }

        /* renamed from: b */
        public void set(e eVar, PointF pointF) {
            eVar.c(pointF);
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f16588a;

        /* renamed from: b  reason: collision with root package name */
        private Matrix f16589b = new Matrix();

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f16590c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Matrix f16591d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f16592e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ f f16593f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ e f16594g;

        c(boolean z10, Matrix matrix, View view, f fVar, e eVar) {
            this.f16590c = z10;
            this.f16591d = matrix;
            this.f16592e = view;
            this.f16593f = fVar;
            this.f16594g = eVar;
        }

        private void a(Matrix matrix) {
            this.f16589b.set(matrix);
            this.f16592e.setTag(R.id.transition_transform, this.f16589b);
            this.f16593f.a(this.f16592e);
        }

        public void onAnimationCancel(Animator animator) {
            this.f16588a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f16588a) {
                if (!this.f16590c || !ChangeTransform.this.mUseOverlay) {
                    this.f16592e.setTag(R.id.transition_transform, (Object) null);
                    this.f16592e.setTag(R.id.parent_matrix, (Object) null);
                } else {
                    a(this.f16591d);
                }
            }
            b0.f(this.f16592e, (Matrix) null);
            this.f16593f.a(this.f16592e);
        }

        public void onAnimationPause(Animator animator) {
            a(this.f16594g.a());
        }

        public void onAnimationResume(Animator animator) {
            ChangeTransform.setIdentityTransforms(this.f16592e);
        }
    }

    private static class d extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private View f16596a;

        /* renamed from: b  reason: collision with root package name */
        private f f16597b;

        d(View view, f fVar) {
            this.f16596a = view;
            this.f16597b = fVar;
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            h.b(this.f16596a);
            this.f16596a.setTag(R.id.transition_transform, (Object) null);
            this.f16596a.setTag(R.id.parent_matrix, (Object) null);
        }

        public void onTransitionPause(Transition transition) {
            this.f16597b.setVisibility(4);
        }

        public void onTransitionResume(Transition transition) {
            this.f16597b.setVisibility(0);
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        private final Matrix f16598a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final View f16599b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f16600c;

        /* renamed from: d  reason: collision with root package name */
        private float f16601d;

        /* renamed from: e  reason: collision with root package name */
        private float f16602e;

        e(View view, float[] fArr) {
            this.f16599b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f16600c = fArr2;
            this.f16601d = fArr2[2];
            this.f16602e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f16600c;
            fArr[2] = this.f16601d;
            fArr[5] = this.f16602e;
            this.f16598a.setValues(fArr);
            b0.f(this.f16599b, this.f16598a);
        }

        /* access modifiers changed from: package-private */
        public Matrix a() {
            return this.f16598a;
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f16601d = pointF.x;
            this.f16602e = pointF.y;
            b();
        }

        /* access modifiers changed from: package-private */
        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f16600c, 0, fArr.length);
            b();
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        final float f16603a;

        /* renamed from: b  reason: collision with root package name */
        final float f16604b;

        /* renamed from: c  reason: collision with root package name */
        final float f16605c;

        /* renamed from: d  reason: collision with root package name */
        final float f16606d;

        /* renamed from: e  reason: collision with root package name */
        final float f16607e;

        /* renamed from: f  reason: collision with root package name */
        final float f16608f;

        /* renamed from: g  reason: collision with root package name */
        final float f16609g;

        /* renamed from: h  reason: collision with root package name */
        final float f16610h;

        f(View view) {
            this.f16603a = view.getTranslationX();
            this.f16604b = view.getTranslationY();
            this.f16605c = ViewCompat.getTranslationZ(view);
            this.f16606d = view.getScaleX();
            this.f16607e = view.getScaleY();
            this.f16608f = view.getRotationX();
            this.f16609g = view.getRotationY();
            this.f16610h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.setTransforms(view, this.f16603a, this.f16604b, this.f16605c, this.f16606d, this.f16607e, this.f16608f, this.f16609g, this.f16610h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (fVar.f16603a == this.f16603a && fVar.f16604b == this.f16604b && fVar.f16605c == this.f16605c && fVar.f16606d == this.f16606d && fVar.f16607e == this.f16607e && fVar.f16608f == this.f16608f && fVar.f16609g == this.f16609g && fVar.f16610h == this.f16610h) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            float f10 = this.f16603a;
            int i17 = 0;
            if (f10 != 0.0f) {
                i10 = Float.floatToIntBits(f10);
            } else {
                i10 = 0;
            }
            int i18 = i10 * 31;
            float f11 = this.f16604b;
            if (f11 != 0.0f) {
                i11 = Float.floatToIntBits(f11);
            } else {
                i11 = 0;
            }
            int i19 = (i18 + i11) * 31;
            float f12 = this.f16605c;
            if (f12 != 0.0f) {
                i12 = Float.floatToIntBits(f12);
            } else {
                i12 = 0;
            }
            int i20 = (i19 + i12) * 31;
            float f13 = this.f16606d;
            if (f13 != 0.0f) {
                i13 = Float.floatToIntBits(f13);
            } else {
                i13 = 0;
            }
            int i21 = (i20 + i13) * 31;
            float f14 = this.f16607e;
            if (f14 != 0.0f) {
                i14 = Float.floatToIntBits(f14);
            } else {
                i14 = 0;
            }
            int i22 = (i21 + i14) * 31;
            float f15 = this.f16608f;
            if (f15 != 0.0f) {
                i15 = Float.floatToIntBits(f15);
            } else {
                i15 = 0;
            }
            int i23 = (i22 + i15) * 31;
            float f16 = this.f16609g;
            if (f16 != 0.0f) {
                i16 = Float.floatToIntBits(f16);
            } else {
                i16 = 0;
            }
            int i24 = (i23 + i16) * 31;
            float f17 = this.f16610h;
            if (f17 != 0.0f) {
                i17 = Float.floatToIntBits(f17);
            }
            return i24 + i17;
        }
    }

    public ChangeTransform() {
    }

    private void captureValues(TransitionValues transitionValues) {
        Matrix matrix;
        View view = transitionValues.view;
        if (view.getVisibility() != 8) {
            transitionValues.values.put(PROPNAME_PARENT, view.getParent());
            transitionValues.values.put(PROPNAME_TRANSFORMS, new f(view));
            Matrix matrix2 = view.getMatrix();
            if (matrix2 == null || matrix2.isIdentity()) {
                matrix = null;
            } else {
                matrix = new Matrix(matrix2);
            }
            transitionValues.values.put(PROPNAME_MATRIX, matrix);
            if (this.mReparent) {
                Matrix matrix3 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                b0.j(viewGroup, matrix3);
                matrix3.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix3);
                transitionValues.values.put(PROPNAME_INTERMEDIATE_MATRIX, view.getTag(R.id.transition_transform));
                transitionValues.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, view.getTag(R.id.parent_matrix));
            }
        }
    }

    private void createGhostView(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.view;
        Matrix matrix = new Matrix((Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX));
        b0.k(viewGroup, matrix);
        f a10 = h.a(view, viewGroup, matrix);
        if (a10 != null) {
            a10.a((ViewGroup) transitionValues.values.get(PROPNAME_PARENT), transitionValues.view);
            Transition transition = this;
            while (true) {
                Transition transition2 = transition.mParent;
                if (transition2 == null) {
                    break;
                }
                transition = transition2;
            }
            transition.addListener(new d(view, a10));
            if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
                View view2 = transitionValues.view;
                if (view2 != transitionValues2.view) {
                    b0.h(view2, 0.0f);
                }
                b0.h(view, 1.0f);
            }
        }
    }

    private ObjectAnimator createTransformAnimator(TransitionValues transitionValues, TransitionValues transitionValues2, boolean z10) {
        Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        Matrix matrix2 = (Matrix) transitionValues2.values.get(PROPNAME_MATRIX);
        if (matrix == null) {
            matrix = k.f16688a;
        }
        if (matrix2 == null) {
            matrix2 = k.f16688a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        View view = transitionValues2.view;
        setIdentityTransforms(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        e eVar = new e(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(eVar, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new e(new float[9]), new float[][]{fArr, fArr2}), m.a(TRANSLATIONS_PROPERTY, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5]))});
        c cVar = new c(z10, matrix3, view, (f) transitionValues2.values.get(PROPNAME_TRANSFORMS), eVar);
        ofPropertyValuesHolder.addListener(cVar);
        a.a(ofPropertyValuesHolder, cVar);
        return ofPropertyValuesHolder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r4 == r5) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r5 == r4.view) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean parentsMatch(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.isValidTarget(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001d
            boolean r0 = r3.isValidTarget(r5)
            if (r0 != 0) goto L_0x000f
            goto L_0x001d
        L_0x000f:
            androidx.transition.TransitionValues r4 = r3.getMatchedTransitionValues(r4, r1)
            if (r4 == 0) goto L_0x0020
            android.view.View r4 = r4.view
            if (r5 != r4) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            r2 = r1
            goto L_0x0020
        L_0x001d:
            if (r4 != r5) goto L_0x001a
            goto L_0x001b
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.parentsMatch(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    static void setIdentityTransforms(View view) {
        setTransforms(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setMatricesForParent(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX);
        transitionValues2.view.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.mTempMatrix;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        if (matrix3 == null) {
            matrix3 = new Matrix();
            transitionValues.values.put(PROPNAME_MATRIX, matrix3);
        }
        matrix3.postConcat((Matrix) transitionValues.values.get(PROPNAME_PARENT_MATRIX));
        matrix3.postConcat(matrix2);
    }

    static void setTransforms(View view, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        view.setTranslationX(f10);
        view.setTranslationY(f11);
        ViewCompat.setTranslationZ(view, f12);
        view.setScaleX(f13);
        view.setScaleY(f14);
        view.setRotationX(f15);
        view.setRotationY(f16);
        view.setRotation(f17);
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
        if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            ((ViewGroup) transitionValues.view.getParent()).startViewTransition(transitionValues.view);
        }
    }

    public Animator createAnimator(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean z10;
        if (transitionValues == null || transitionValues2 == null || !transitionValues.values.containsKey(PROPNAME_PARENT) || !transitionValues2.values.containsKey(PROPNAME_PARENT)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        if (!this.mReparent || parentsMatch(viewGroup2, viewGroup3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_MATRIX);
        if (matrix != null) {
            transitionValues.values.put(PROPNAME_MATRIX, matrix);
        }
        Matrix matrix2 = (Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX);
        if (matrix2 != null) {
            transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix2);
        }
        if (z10) {
            setMatricesForParent(transitionValues, transitionValues2);
        }
        ObjectAnimator createTransformAnimator = createTransformAnimator(transitionValues, transitionValues2, z10);
        if (z10 && createTransformAnimator != null && this.mUseOverlay) {
            createGhostView(viewGroup, transitionValues, transitionValues2);
        } else if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            viewGroup2.endViewTransition(transitionValues.view);
        }
        return createTransformAnimator;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setReparent(boolean z10) {
        this.mReparent = z10;
    }

    public void setReparentWithOverlay(boolean z10) {
        this.mUseOverlay = z10;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f16698g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
