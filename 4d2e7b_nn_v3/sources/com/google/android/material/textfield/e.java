package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;

class e extends f {
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static final boolean f8585t = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final TextWatcher f8586e = new a();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final View.OnFocusChangeListener f8587f = new C0101e();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout.AccessibilityDelegate f8588g = new f(this.f8618a);

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.OnEditTextAttachedListener f8589h = new g();

    /* renamed from: i  reason: collision with root package name */
    private final TextInputLayout.OnEndIconChangedListener f8590i = new h();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f8591j = new i();

    /* renamed from: k  reason: collision with root package name */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f8592k = new j();
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f8593l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f8594m = false;

    /* renamed from: n  reason: collision with root package name */
    private long f8595n = LocationRequestCompat.PASSIVE_INTERVAL;

    /* renamed from: o  reason: collision with root package name */
    private StateListDrawable f8596o;

    /* renamed from: p  reason: collision with root package name */
    private MaterialShapeDrawable f8597p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public AccessibilityManager f8598q;

    /* renamed from: r  reason: collision with root package name */
    private ValueAnimator f8599r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public ValueAnimator f8600s;

    class a extends TextWatcherAdapter {

        /* renamed from: com.google.android.material.textfield.e$a$a  reason: collision with other inner class name */
        class C0100a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f8602a;

            C0100a(AutoCompleteTextView autoCompleteTextView) {
                this.f8602a = autoCompleteTextView;
            }

            public void run() {
                boolean isPopupShowing = this.f8602a.isPopupShowing();
                e.this.J(isPopupShowing);
                boolean unused = e.this.f8593l = isPopupShowing;
            }
        }

        a() {
        }

        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView e10 = e.C(e.this.f8618a.getEditText());
            if (e.this.f8598q.isTouchExplorationEnabled() && e.H(e10) && !e.this.f8620c.hasFocus()) {
                e10.dismissDropDown();
            }
            e10.post(new C0100a(e10));
        }
    }

    class b implements AutoCompleteTextView.OnDismissListener {
        b() {
        }

        public void onDismiss() {
            e.this.N();
            e.this.J(false);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            e eVar = e.this;
            eVar.f8620c.setChecked(eVar.f8594m);
            e.this.f8600s.start();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.f8620c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.textfield.e$e  reason: collision with other inner class name */
    class C0101e implements View.OnFocusChangeListener {
        C0101e() {
        }

        public void onFocusChange(View view, boolean z10) {
            e.this.f8618a.setEndIconActivated(z10);
            if (!z10) {
                e.this.J(false);
                boolean unused = e.this.f8593l = false;
            }
        }
    }

    class f extends TextInputLayout.AccessibilityDelegate {
        f(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!e.H(e.this.f8618a.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText((CharSequence) null);
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView e10 = e.C(e.this.f8618a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && e.this.f8598q.isEnabled() && !e.H(e.this.f8618a.getEditText())) {
                e.this.M(e10);
                e.this.N();
            }
        }
    }

    class g implements TextInputLayout.OnEditTextAttachedListener {
        g() {
        }

        public void onEditTextAttached(TextInputLayout textInputLayout) {
            AutoCompleteTextView e10 = e.C(textInputLayout.getEditText());
            e.this.K(e10);
            e.this.y(e10);
            e.this.L(e10);
            e10.setThreshold(0);
            e10.removeTextChangedListener(e.this.f8586e);
            e10.addTextChangedListener(e.this.f8586e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!e.H(e10) && e.this.f8598q.isTouchExplorationEnabled()) {
                ViewCompat.setImportantForAccessibility(e.this.f8620c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(e.this.f8588g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    class h implements TextInputLayout.OnEndIconChangedListener {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f8611a;

            a(AutoCompleteTextView autoCompleteTextView) {
                this.f8611a = autoCompleteTextView;
            }

            public void run() {
                this.f8611a.removeTextChangedListener(e.this.f8586e);
            }
        }

        h() {
        }

        public void onEndIconChanged(TextInputLayout textInputLayout, int i10) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i10 == 3) {
                autoCompleteTextView.post(new a(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == e.this.f8587f) {
                    autoCompleteTextView.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                }
                autoCompleteTextView.setOnTouchListener((View.OnTouchListener) null);
                if (e.f8585t) {
                    autoCompleteTextView.setOnDismissListener((AutoCompleteTextView.OnDismissListener) null);
                }
            }
            if (i10 == 3) {
                textInputLayout.removeOnAttachStateChangeListener(e.this.f8591j);
                e.this.I();
            }
        }
    }

    class i implements View.OnAttachStateChangeListener {
        i() {
        }

        public void onViewAttachedToWindow(View view) {
            e.this.B();
        }

        public void onViewDetachedFromWindow(View view) {
            e.this.I();
        }
    }

    class j implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {
        j() {
        }

        public void onTouchExplorationStateChanged(boolean z10) {
            AutoCompleteTextView autoCompleteTextView;
            int i10;
            TextInputLayout textInputLayout = e.this.f8618a;
            if (textInputLayout != null && (autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText()) != null && !e.H(autoCompleteTextView)) {
                CheckableImageButton checkableImageButton = e.this.f8620c;
                if (z10) {
                    i10 = 2;
                } else {
                    i10 = 1;
                }
                ViewCompat.setImportantForAccessibility(checkableImageButton, i10);
            }
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        public void onClick(View view) {
            e.this.M((AutoCompleteTextView) e.this.f8618a.getEditText());
        }
    }

    class l implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f8616a;

        l(AutoCompleteTextView autoCompleteTextView) {
            this.f8616a = autoCompleteTextView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (e.this.G()) {
                    boolean unused = e.this.f8593l = false;
                }
                e.this.M(this.f8616a);
                e.this.N();
            }
            return false;
        }
    }

    e(TextInputLayout textInputLayout, int i10) {
        super(textInputLayout, i10);
    }

    private void A(AutoCompleteTextView autoCompleteTextView, int i10, int[][] iArr, MaterialShapeDrawable materialShapeDrawable) {
        LayerDrawable layerDrawable;
        int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorSurface);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        int layer = MaterialColors.layer(i10, color, 0.1f);
        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, new int[]{layer, 0}));
        if (f8585t) {
            materialShapeDrawable2.setTint(color);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{layer, color});
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
            materialShapeDrawable3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable});
        }
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
    }

    /* access modifiers changed from: private */
    public void B() {
        TextInputLayout textInputLayout;
        if (this.f8598q != null && (textInputLayout = this.f8618a) != null && ViewCompat.isAttachedToWindow(textInputLayout)) {
            AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.f8598q, this.f8592k);
        }
    }

    /* access modifiers changed from: private */
    public static AutoCompleteTextView C(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator D(int i10, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration((long) i10);
        ofFloat.addUpdateListener(new d());
        return ofFloat;
    }

    private MaterialShapeDrawable E(float f10, float f11, float f12, int i10) {
        ShapeAppearanceModel build = ShapeAppearanceModel.builder().setTopLeftCornerSize(f10).setTopRightCornerSize(f10).setBottomLeftCornerSize(f11).setBottomRightCornerSize(f11).build();
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.f8619b, f12);
        createWithElevationOverlay.setShapeAppearanceModel(build);
        createWithElevationOverlay.setPadding(0, i10, 0, i10);
        return createWithElevationOverlay;
    }

    private void F() {
        this.f8600s = D(67, 0.0f, 1.0f);
        ValueAnimator D = D(50, 1.0f, 0.0f);
        this.f8599r = D;
        D.addListener(new c());
    }

    /* access modifiers changed from: private */
    public boolean G() {
        long currentTimeMillis = System.currentTimeMillis() - this.f8595n;
        if (currentTimeMillis < 0 || currentTimeMillis > 300) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean H(EditText editText) {
        if (editText.getKeyListener() != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void I() {
        AccessibilityManager accessibilityManager = this.f8598q;
        if (accessibilityManager != null) {
            AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(accessibilityManager, this.f8592k);
        }
    }

    /* access modifiers changed from: private */
    public void J(boolean z10) {
        if (this.f8594m != z10) {
            this.f8594m = z10;
            this.f8600s.cancel();
            this.f8599r.start();
        }
    }

    /* access modifiers changed from: private */
    public void K(AutoCompleteTextView autoCompleteTextView) {
        if (f8585t) {
            int boxBackgroundMode = this.f8618a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f8597p);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f8596o);
            }
        }
    }

    /* access modifiers changed from: private */
    public void L(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new l(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f8587f);
        if (f8585t) {
            autoCompleteTextView.setOnDismissListener(new b());
        }
    }

    /* access modifiers changed from: private */
    public void M(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView != null) {
            if (G()) {
                this.f8593l = false;
            }
            if (!this.f8593l) {
                if (f8585t) {
                    J(!this.f8594m);
                } else {
                    this.f8594m = !this.f8594m;
                    this.f8620c.toggle();
                }
                if (this.f8594m) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            this.f8593l = false;
        }
    }

    /* access modifiers changed from: private */
    public void N() {
        this.f8593l = true;
        this.f8595n = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void y(AutoCompleteTextView autoCompleteTextView) {
        if (!H(autoCompleteTextView)) {
            int boxBackgroundMode = this.f8618a.getBoxBackgroundMode();
            MaterialShapeDrawable boxBackground = this.f8618a.getBoxBackground();
            int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorControlHighlight);
            int[][] iArr = {new int[]{16842919}, new int[0]};
            if (boxBackgroundMode == 2) {
                A(autoCompleteTextView, color, iArr, boxBackground);
            } else if (boxBackgroundMode == 1) {
                z(autoCompleteTextView, color, iArr, boxBackground);
            }
        }
    }

    private void z(AutoCompleteTextView autoCompleteTextView, int i10, int[][] iArr, MaterialShapeDrawable materialShapeDrawable) {
        int boxBackgroundColor = this.f8618a.getBoxBackgroundColor();
        int[] iArr2 = {MaterialColors.layer(i10, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f8585t) {
            ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), materialShapeDrawable, materialShapeDrawable));
            return;
        }
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable, materialShapeDrawable2});
        int paddingStart = ViewCompat.getPaddingStart(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    /* access modifiers changed from: package-private */
    public void O(AutoCompleteTextView autoCompleteTextView) {
        if (!H(autoCompleteTextView) && this.f8618a.getBoxBackgroundMode() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
            y(autoCompleteTextView);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        float dimensionPixelOffset = (float) this.f8619b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.f8619b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f8619b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable E = E(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable E2 = E(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f8597p = E;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f8596o = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, E);
        this.f8596o.addState(new int[0], E2);
        int i10 = this.f8621d;
        if (i10 == 0) {
            if (f8585t) {
                i10 = R.drawable.mtrl_dropdown_arrow;
            } else {
                i10 = R.drawable.mtrl_ic_arrow_drop_down;
            }
        }
        this.f8618a.setEndIconDrawable(i10);
        TextInputLayout textInputLayout = this.f8618a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.f8618a.setEndIconOnClickListener(new k());
        this.f8618a.addOnEditTextAttachedListener(this.f8589h);
        this.f8618a.addOnEndIconChangedListener(this.f8590i);
        F();
        this.f8598q = (AccessibilityManager) this.f8619b.getSystemService("accessibility");
        this.f8618a.addOnAttachStateChangeListener(this.f8591j);
        B();
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i10) {
        return i10 != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return true;
    }
}
