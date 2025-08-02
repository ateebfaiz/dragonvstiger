package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};
    private int mMode = 3;

    @SuppressLint({"UniqueConstants"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    class a extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f16653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f16654b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f16655c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f16653a = viewGroup;
            this.f16654b = view;
            this.f16655c = view2;
        }

        public void onTransitionEnd(Transition transition) {
            this.f16655c.setTag(R.id.save_overlay_view, (Object) null);
            y.b(this.f16653a).b(this.f16654b);
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
            y.b(this.f16653a).b(this.f16654b);
        }

        public void onTransitionResume(Transition transition) {
            if (this.f16654b.getParent() == null) {
                y.b(this.f16653a).a(this.f16654b);
            } else {
                Visibility.this.cancel();
            }
        }
    }

    private static class b extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        private final View f16657a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16658b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f16659c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f16660d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f16661e;

        /* renamed from: f  reason: collision with root package name */
        boolean f16662f = false;

        b(View view, int i10, boolean z10) {
            this.f16657a = view;
            this.f16658b = i10;
            this.f16659c = (ViewGroup) view.getParent();
            this.f16660d = z10;
            b(true);
        }

        private void a() {
            if (!this.f16662f) {
                b0.i(this.f16657a, this.f16658b);
                ViewGroup viewGroup = this.f16659c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            b(false);
        }

        private void b(boolean z10) {
            ViewGroup viewGroup;
            if (this.f16660d && this.f16661e != z10 && (viewGroup = this.f16659c) != null) {
                this.f16661e = z10;
                y.d(viewGroup, z10);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f16662f = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f16662f) {
                b0.i(this.f16657a, this.f16658b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f16662f) {
                b0.i(this.f16657a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            a();
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
            b(false);
        }

        public void onTransitionResume(Transition transition) {
            b(true);
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f16663a;

        /* renamed from: b  reason: collision with root package name */
        boolean f16664b;

        /* renamed from: c  reason: collision with root package name */
        int f16665c;

        /* renamed from: d  reason: collision with root package name */
        int f16666d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f16667e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f16668f;

        c() {
        }
    }

    public Visibility() {
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    private c getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        c cVar = new c();
        cVar.f16663a = false;
        cVar.f16664b = false;
        if (transitionValues == null || !transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            cVar.f16665c = -1;
            cVar.f16667e = null;
        } else {
            cVar.f16665c = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            cVar.f16667e = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            cVar.f16666d = -1;
            cVar.f16668f = null;
        } else {
            cVar.f16666d = ((Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
            cVar.f16668f = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i10 = cVar.f16665c;
            int i11 = cVar.f16666d;
            if (i10 == i11 && cVar.f16667e == cVar.f16668f) {
                return cVar;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    cVar.f16664b = false;
                    cVar.f16663a = true;
                } else if (i11 == 0) {
                    cVar.f16664b = true;
                    cVar.f16663a = true;
                }
            } else if (cVar.f16668f == null) {
                cVar.f16664b = false;
                cVar.f16663a = true;
            } else if (cVar.f16667e == null) {
                cVar.f16664b = true;
                cVar.f16663a = true;
            }
        } else if (transitionValues == null && cVar.f16666d == 0) {
            cVar.f16664b = true;
            cVar.f16663a = true;
        } else if (transitionValues2 == null && cVar.f16665c == 0) {
            cVar.f16664b = false;
            cVar.f16663a = true;
        }
        return cVar;
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        c visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.f16663a) {
            return null;
        }
        if (visibilityChangeInfo.f16667e == null && visibilityChangeInfo.f16668f == null) {
            return null;
        }
        if (visibilityChangeInfo.f16664b) {
            return onAppear(viewGroup, transitionValues, visibilityChangeInfo.f16665c, transitionValues2, visibilityChangeInfo.f16666d);
        }
        return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.f16665c, transitionValues2, visibilityChangeInfo.f16666d);
    }

    public int getMode() {
        return this.mMode;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY) != transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        c visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.f16663a) {
            return false;
        }
        if (visibilityChangeInfo.f16665c == 0 || visibilityChangeInfo.f16666d == 0) {
            return true;
        }
        return false;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        int intValue = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
        View view = (View) transitionValues.values.get(PROPNAME_PARENT);
        if (intValue != 0 || view == null) {
            return false;
        }
        return true;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public void setMode(int i10) {
        if ((i10 & -4) == 0) {
            this.mMode = i10;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i10, TransitionValues transitionValues2, int i11) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.view.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f16663a) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        if (r10.mCanRemoveViews != false) goto L_0x0085;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onDisappear(android.view.ViewGroup r11, androidx.transition.TransitionValues r12, int r13, androidx.transition.TransitionValues r14, int r15) {
        /*
            r10 = this;
            int r13 = r10.mMode
            r0 = 2
            r13 = r13 & r0
            r1 = 0
            if (r13 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r12 != 0) goto L_0x000b
            return r1
        L_0x000b:
            android.view.View r13 = r12.view
            if (r14 == 0) goto L_0x0012
            android.view.View r2 = r14.view
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            int r3 = androidx.transition.R.id.save_overlay_view
            java.lang.Object r3 = r13.getTag(r3)
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0023
            r2 = r1
            r6 = r5
            goto L_0x0088
        L_0x0023:
            if (r2 == 0) goto L_0x003a
            android.view.ViewParent r3 = r2.getParent()
            if (r3 != 0) goto L_0x002c
            goto L_0x003a
        L_0x002c:
            r3 = 4
            if (r15 != r3) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            if (r13 != r2) goto L_0x0036
        L_0x0032:
            r3 = r2
            r6 = r4
            r2 = r1
            goto L_0x003e
        L_0x0036:
            r2 = r1
            r3 = r2
            r6 = r5
            goto L_0x003e
        L_0x003a:
            if (r2 == 0) goto L_0x0036
            r3 = r1
            r6 = r4
        L_0x003e:
            if (r6 == 0) goto L_0x0069
            android.view.ViewParent r6 = r13.getParent()
            if (r6 != 0) goto L_0x0047
            goto L_0x0085
        L_0x0047:
            android.view.ViewParent r6 = r13.getParent()
            boolean r6 = r6 instanceof android.view.View
            if (r6 == 0) goto L_0x0069
            android.view.ViewParent r6 = r13.getParent()
            android.view.View r6 = (android.view.View) r6
            androidx.transition.TransitionValues r7 = r10.getTransitionValues(r6, r5)
            androidx.transition.TransitionValues r8 = r10.getMatchedTransitionValues(r6, r5)
            androidx.transition.Visibility$c r7 = r10.getVisibilityChangeInfo(r7, r8)
            boolean r7 = r7.f16663a
            if (r7 != 0) goto L_0x006e
            android.view.View r2 = androidx.transition.q.a(r11, r13, r6)
        L_0x0069:
            r6 = r4
            r9 = r3
            r3 = r2
            r2 = r9
            goto L_0x0088
        L_0x006e:
            int r7 = r6.getId()
            android.view.ViewParent r6 = r6.getParent()
            if (r6 != 0) goto L_0x0069
            r6 = -1
            if (r7 == r6) goto L_0x0069
            android.view.View r6 = r11.findViewById(r7)
            if (r6 == 0) goto L_0x0069
            boolean r6 = r10.mCanRemoveViews
            if (r6 == 0) goto L_0x0069
        L_0x0085:
            r2 = r3
            r6 = r4
            r3 = r13
        L_0x0088:
            if (r3 == 0) goto L_0x00da
            if (r6 != 0) goto L_0x00bc
            java.util.Map<java.lang.String, java.lang.Object> r15 = r12.values
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r15 = r15.get(r1)
            int[] r15 = (int[]) r15
            r1 = r15[r4]
            r15 = r15[r5]
            int[] r0 = new int[r0]
            r11.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r3.getLeft()
            int r1 = r1 - r2
            r3.offsetLeftAndRight(r1)
            r0 = r0[r5]
            int r15 = r15 - r0
            int r0 = r3.getTop()
            int r15 = r15 - r0
            r3.offsetTopAndBottom(r15)
            androidx.transition.v r15 = androidx.transition.y.b(r11)
            r15.a(r3)
        L_0x00bc:
            android.animation.Animator r12 = r10.onDisappear(r11, r3, r12, r14)
            if (r6 != 0) goto L_0x00d9
            if (r12 != 0) goto L_0x00cc
            androidx.transition.v r11 = androidx.transition.y.b(r11)
            r11.b(r3)
            goto L_0x00d9
        L_0x00cc:
            int r14 = androidx.transition.R.id.save_overlay_view
            r13.setTag(r14, r3)
            androidx.transition.Visibility$a r14 = new androidx.transition.Visibility$a
            r14.<init>(r11, r3, r13)
            r10.addListener(r14)
        L_0x00d9:
            return r12
        L_0x00da:
            if (r2 == 0) goto L_0x00fc
            int r13 = r2.getVisibility()
            androidx.transition.b0.i(r2, r4)
            android.animation.Animator r11 = r10.onDisappear(r11, r2, r12, r14)
            if (r11 == 0) goto L_0x00f8
            androidx.transition.Visibility$b r12 = new androidx.transition.Visibility$b
            r12.<init>(r2, r15, r5)
            r11.addListener(r12)
            androidx.transition.a.a(r11, r12)
            r10.addListener(r12)
            goto L_0x00fb
        L_0x00f8:
            androidx.transition.b0.i(r2, r13)
        L_0x00fb:
            return r11
        L_0x00fc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f16696e);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }
}
