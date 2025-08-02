package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> HEIGHT;
    static final Property<View, Float> PADDING_END;
    static final Property<View, Float> PADDING_START;
    static final Property<View, Float> WIDTH;
    /* access modifiers changed from: private */
    public int animState;
    private boolean animateShowBeforeLayout;
    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final a changeVisibilityTracker;
    private final int collapsedSize;
    /* access modifiers changed from: private */
    @NonNull
    public final f extendStrategy;
    /* access modifiers changed from: private */
    public int extendedPaddingEnd;
    /* access modifiers changed from: private */
    public int extendedPaddingStart;
    /* access modifiers changed from: private */
    public final f hideStrategy;
    /* access modifiers changed from: private */
    public boolean isExtended;
    /* access modifiers changed from: private */
    public boolean isTransforming;
    @NonNull
    protected ColorStateList originalTextCsl;
    /* access modifiers changed from: private */
    public final f showStrategy;
    /* access modifiers changed from: private */
    @NonNull
    public final f shrinkStrategy;

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;
        @Nullable
        private OnChangedCallback internalAutoHideCallback;
        @Nullable
        private OnChangedCallback internalAutoShrinkCallback;
        private Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        private static boolean isBottomSheet(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean shouldUpdateVisibility(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            if ((this.autoHideEnabled || this.autoShrinkEnabled) && layoutParams.getAnchorId() == view.getId()) {
                return true;
            }
            return false;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        /* access modifiers changed from: protected */
        public void extendOrShow(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            OnChangedCallback onChangedCallback;
            f fVar;
            boolean z10 = this.autoShrinkEnabled;
            if (z10) {
                onChangedCallback = this.internalAutoShrinkCallback;
            } else {
                onChangedCallback = this.internalAutoHideCallback;
            }
            if (z10) {
                fVar = extendedFloatingActionButton.extendStrategy;
            } else {
                fVar = extendedFloatingActionButton.showStrategy;
            }
            extendedFloatingActionButton.performMotion(fVar, onChangedCallback);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public void setAutoHideEnabled(boolean z10) {
            this.autoHideEnabled = z10;
        }

        public void setAutoShrinkEnabled(boolean z10) {
            this.autoShrinkEnabled = z10;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void setInternalAutoHideCallback(@Nullable OnChangedCallback onChangedCallback) {
            this.internalAutoHideCallback = onChangedCallback;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void setInternalAutoShrinkCallback(@Nullable OnChangedCallback onChangedCallback) {
            this.internalAutoShrinkCallback = onChangedCallback;
        }

        /* access modifiers changed from: protected */
        public void shrinkOrHide(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            OnChangedCallback onChangedCallback;
            f fVar;
            boolean z10 = this.autoShrinkEnabled;
            if (z10) {
                onChangedCallback = this.internalAutoShrinkCallback;
            } else {
                onChangedCallback = this.internalAutoHideCallback;
            }
            if (z10) {
                fVar = extendedFloatingActionButton.shrinkStrategy;
            } else {
                fVar = extendedFloatingActionButton.hideStrategy;
            }
            extendedFloatingActionButton.performMotion(fVar, onChangedCallback);
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (!isBottomSheet(view)) {
                return false;
            } else {
                updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton);
                return false;
            }
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = dependencies.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i10);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    public static abstract class OnChangedCallback {
        public void onExtended(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onHidden(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShown(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShrunken(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    class a implements k {
        a() {
        }

        public int a() {
            return ExtendedFloatingActionButton.this.extendedPaddingEnd;
        }

        public ViewGroup.LayoutParams b() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        public int c() {
            return ExtendedFloatingActionButton.this.extendedPaddingStart;
        }

        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.extendedPaddingStart + ExtendedFloatingActionButton.this.extendedPaddingEnd;
        }
    }

    class b implements k {
        b() {
        }

        public int a() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        public ViewGroup.LayoutParams b() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        public int c() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f8216a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f8217b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OnChangedCallback f8218c;

        c(f fVar, OnChangedCallback onChangedCallback) {
            this.f8217b = fVar;
            this.f8218c = onChangedCallback;
        }

        public void onAnimationCancel(Animator animator) {
            this.f8216a = true;
            this.f8217b.b();
        }

        public void onAnimationEnd(Animator animator) {
            this.f8217b.a();
            if (!this.f8216a) {
                this.f8217b.l(this.f8218c);
            }
        }

        public void onAnimationStart(Animator animator) {
            this.f8217b.onAnimationStart(animator);
            this.f8216a = false;
        }
    }

    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().width);
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            view.getLayoutParams().width = f10.intValue();
            view.requestLayout();
        }
    }

    class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().height);
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            view.getLayoutParams().height = f10.intValue();
            view.requestLayout();
        }
    }

    class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) ViewCompat.getPaddingStart(view));
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            ViewCompat.setPaddingRelative(view, f10.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }
    }

    class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) ViewCompat.getPaddingEnd(view));
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
        }
    }

    class h extends b {

        /* renamed from: g  reason: collision with root package name */
        private final k f8220g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f8221h;

        h(a aVar, k kVar, boolean z10) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f8220g = kVar;
            this.f8221h = z10;
        }

        public void a() {
            super.a();
            boolean unused = ExtendedFloatingActionButton.this.isTransforming = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.f8220g.b().width;
                layoutParams.height = this.f8220g.b().height;
            }
        }

        public int c() {
            if (this.f8221h) {
                return R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
            }
            return R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        public void d() {
            boolean unused = ExtendedFloatingActionButton.this.isExtended = this.f8221h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.f8220g.b().width;
                layoutParams.height = this.f8220g.b().height;
                ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f8220g.c(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f8220g.a(), ExtendedFloatingActionButton.this.getPaddingBottom());
                ExtendedFloatingActionButton.this.requestLayout();
            }
        }

        public boolean f() {
            if (this.f8221h == ExtendedFloatingActionButton.this.isExtended || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText())) {
                return true;
            }
            return false;
        }

        public AnimatorSet j() {
            float f10;
            MotionSpec o10 = o();
            if (o10.hasPropertyValues(Snapshot.WIDTH)) {
                PropertyValuesHolder[] propertyValues = o10.getPropertyValues(Snapshot.WIDTH);
                propertyValues[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getWidth(), (float) this.f8220g.getWidth()});
                o10.setPropertyValues(Snapshot.WIDTH, propertyValues);
            }
            if (o10.hasPropertyValues(Snapshot.HEIGHT)) {
                PropertyValuesHolder[] propertyValues2 = o10.getPropertyValues(Snapshot.HEIGHT);
                propertyValues2[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getHeight(), (float) this.f8220g.getHeight()});
                o10.setPropertyValues(Snapshot.HEIGHT, propertyValues2);
            }
            if (o10.hasPropertyValues("paddingStart")) {
                PropertyValuesHolder[] propertyValues3 = o10.getPropertyValues("paddingStart");
                propertyValues3[0].setFloatValues(new float[]{(float) ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), (float) this.f8220g.c()});
                o10.setPropertyValues("paddingStart", propertyValues3);
            }
            if (o10.hasPropertyValues("paddingEnd")) {
                PropertyValuesHolder[] propertyValues4 = o10.getPropertyValues("paddingEnd");
                propertyValues4[0].setFloatValues(new float[]{(float) ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), (float) this.f8220g.a()});
                o10.setPropertyValues("paddingEnd", propertyValues4);
            }
            if (o10.hasPropertyValues("labelOpacity")) {
                PropertyValuesHolder[] propertyValues5 = o10.getPropertyValues("labelOpacity");
                boolean z10 = this.f8221h;
                float f11 = 1.0f;
                if (z10) {
                    f10 = 0.0f;
                } else {
                    f10 = 1.0f;
                }
                if (!z10) {
                    f11 = 0.0f;
                }
                propertyValues5[0].setFloatValues(new float[]{f10, f11});
                o10.setPropertyValues("labelOpacity", propertyValues5);
            }
            return super.n(o10);
        }

        public void l(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                if (this.f8221h) {
                    onChangedCallback.onExtended(ExtendedFloatingActionButton.this);
                } else {
                    onChangedCallback.onShrunken(ExtendedFloatingActionButton.this);
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            boolean unused = ExtendedFloatingActionButton.this.isExtended = this.f8221h;
            boolean unused2 = ExtendedFloatingActionButton.this.isTransforming = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    class i extends b {

        /* renamed from: g  reason: collision with root package name */
        private boolean f8223g;

        public i(a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        public void a() {
            super.a();
            int unused = ExtendedFloatingActionButton.this.animState = 0;
            if (!this.f8223g) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }

        public void b() {
            super.b();
            this.f8223g = true;
        }

        public int c() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        public boolean f() {
            return ExtendedFloatingActionButton.this.isOrWillBeHidden();
        }

        public void l(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onHidden(ExtendedFloatingActionButton.this);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f8223g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            int unused = ExtendedFloatingActionButton.this.animState = 1;
        }
    }

    class j extends b {
        public j(a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        public void a() {
            super.a();
            int unused = ExtendedFloatingActionButton.this.animState = 0;
        }

        public int c() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        public boolean f() {
            return ExtendedFloatingActionButton.this.isOrWillBeShown();
        }

        public void l(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onShown(ExtendedFloatingActionButton.this);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            int unused = ExtendedFloatingActionButton.this.animState = 2;
        }
    }

    interface k {
        int a();

        ViewGroup.LayoutParams b();

        int c();

        int getHeight();

        int getWidth();
    }

    static {
        Class<Float> cls = Float.class;
        WIDTH = new d(cls, Snapshot.WIDTH);
        HEIGHT = new e(cls, Snapshot.HEIGHT);
        PADDING_START = new f(cls, "paddingStart");
        PADDING_END = new g(cls, "paddingEnd");
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public boolean isOrWillBeHidden() {
        if (getVisibility() == 0) {
            if (this.animState == 1) {
                return true;
            }
            return false;
        } else if (this.animState != 2) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean isOrWillBeShown() {
        if (getVisibility() != 0) {
            if (this.animState == 2) {
                return true;
            }
            return false;
        } else if (this.animState != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void performMotion(@NonNull f fVar, @Nullable OnChangedCallback onChangedCallback) {
        if (!fVar.f()) {
            if (!shouldAnimateVisibilityChange()) {
                fVar.d();
                fVar.l(onChangedCallback);
                return;
            }
            measure(0, 0);
            AnimatorSet j10 = fVar.j();
            j10.addListener(new c(fVar, onChangedCallback));
            for (Animator.AnimatorListener addListener : fVar.k()) {
                j10.addListener(addListener);
            }
            j10.start();
        }
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    private boolean shouldAnimateVisibilityChange() {
        if ((ViewCompat.isLaidOut(this) || (!isOrWillBeShown() && this.animateShowBeforeLayout)) && !isInEditMode()) {
            return true;
        }
        return false;
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.extendStrategy.h(animatorListener);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.hideStrategy.h(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.showStrategy.h(animatorListener);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.h(animatorListener);
    }

    public void extend() {
        performMotion(this.extendStrategy, (OnChangedCallback) null);
    }

    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getCollapsedSize() {
        int i10 = this.collapsedSize;
        if (i10 < 0) {
            return (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize();
        }
        return i10;
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.e();
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.hideStrategy.e();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.showStrategy.e();
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.e();
    }

    public void hide() {
        performMotion(this.hideStrategy, (OnChangedCallback) null);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.isExtended = false;
            this.shrinkStrategy.d();
        }
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.extendStrategy.g(animatorListener);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.hideStrategy.g(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.showStrategy.g(animatorListener);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.g(animatorListener);
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
        this.animateShowBeforeLayout = z10;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec motionSpec) {
        this.extendStrategy.i(motionSpec);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i10) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i10));
    }

    public void setExtended(boolean z10) {
        f fVar;
        if (this.isExtended != z10) {
            if (z10) {
                fVar = this.extendStrategy;
            } else {
                fVar = this.shrinkStrategy;
            }
            if (!fVar.f()) {
                fVar.d();
            }
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.hideStrategy.i(motionSpec);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i10) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i10));
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        if (this.isExtended && !this.isTransforming) {
            this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
            this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        }
    }

    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
        if (this.isExtended && !this.isTransforming) {
            this.extendedPaddingStart = i10;
            this.extendedPaddingEnd = i12;
        }
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.showStrategy.i(motionSpec);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i10) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i10));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec motionSpec) {
        this.shrinkStrategy.i(motionSpec);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i10) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i10));
    }

    public void setTextColor(int i10) {
        super.setTextColor(i10);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(this.showStrategy, (OnChangedCallback) null);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, (OnChangedCallback) null);
    }

    /* access modifiers changed from: protected */
    public void silentlyUpdateTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    public void extend(@NonNull OnChangedCallback onChangedCallback) {
        performMotion(this.extendStrategy, onChangedCallback);
    }

    public void hide(@NonNull OnChangedCallback onChangedCallback) {
        performMotion(this.hideStrategy, onChangedCallback);
    }

    public void show(@NonNull OnChangedCallback onChangedCallback) {
        performMotion(this.showStrategy, onChangedCallback);
    }

    public void shrink(@NonNull OnChangedCallback onChangedCallback) {
        performMotion(this.shrinkStrategy, onChangedCallback);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = DEF_STYLE_RES
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.animState = r10
            com.google.android.material.floatingactionbutton.a r1 = new com.google.android.material.floatingactionbutton.a
            r1.<init>()
            r0.changeVisibilityTracker = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j
            r11.<init>(r1)
            r0.showStrategy = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i
            r12.<init>(r1)
            r0.hideStrategy = r12
            r13 = 1
            r0.isExtended = r13
            r0.isTransforming = r10
            r0.animateShowBeforeLayout = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.behavior = r1
            int[] r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_showMotionSpec
            com.google.android.material.animation.MotionSpec r2 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r2)
            int r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_hideMotionSpec
            com.google.android.material.animation.MotionSpec r3 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r3)
            int r4 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_extendMotionSpec
            com.google.android.material.animation.MotionSpec r4 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r4)
            int r5 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            com.google.android.material.animation.MotionSpec r5 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r5)
            int r6 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_collapsedSize
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.collapsedSize = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingStart(r16)
            r0.extendedPaddingStart = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingEnd(r16)
            r0.extendedPaddingEnd = r6
            com.google.android.material.floatingactionbutton.a r6 = new com.google.android.material.floatingactionbutton.a
            r6.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h r15 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a
            r10.<init>()
            r15.<init>(r6, r10, r13)
            r0.extendStrategy = r15
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b
            r13.<init>()
            r7 = 0
            r10.<init>(r6, r13, r7)
            r0.shrinkStrategy = r10
            r11.i(r2)
            r12.i(r3)
            r15.i(r4)
            r10.i(r5)
            r1.recycle()
            com.google.android.material.shape.CornerSize r1 = com.google.android.material.shape.ShapeAppearanceModel.PILL
            r2 = r18
            com.google.android.material.shape.ShapeAppearanceModel$Builder r1 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r14, (android.util.AttributeSet) r2, (int) r8, (int) r9, (com.google.android.material.shape.CornerSize) r1)
            com.google.android.material.shape.ShapeAppearanceModel r1 = r1.build()
            r0.setShapeAppearanceModel(r1)
            r16.saveOriginalTextCsl()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        saveOriginalTextCsl();
    }
}
