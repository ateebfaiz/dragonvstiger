package com.google.android.material.timepicker;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

class TimePickerView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Chip f8701a;

    /* renamed from: b  reason: collision with root package name */
    private final Chip f8702b;

    /* renamed from: c  reason: collision with root package name */
    private final ClockHandView f8703c;

    /* renamed from: d  reason: collision with root package name */
    private final ClockFaceView f8704d;

    /* renamed from: e  reason: collision with root package name */
    private final MaterialButtonToggleGroup f8705e;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f8706f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public f f8707g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public g f8708h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public e f8709i;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (TimePickerView.this.f8708h != null) {
                TimePickerView.this.f8708h.c(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        }
    }

    class b implements MaterialButtonToggleGroup.OnButtonCheckedListener {
        b() {
        }

        public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
            int i11;
            if (i10 == R.id.material_clock_period_pm_button) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (TimePickerView.this.f8707g != null && z10) {
                TimePickerView.this.f8707g.b(i11);
            }
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            e c10 = TimePickerView.this.f8709i;
            if (c10 == null) {
                return false;
            }
            c10.onDoubleTap();
            return true;
        }
    }

    class d implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GestureDetector f8713a;

        d(GestureDetector gestureDetector) {
            this.f8713a = gestureDetector;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f8713a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface e {
        void onDoubleTap();
    }

    interface f {
        void b(int i10);
    }

    interface g {
        void c(int i10);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void n() {
        this.f8701a.setTag(R.id.selection_type, 12);
        this.f8702b.setTag(R.id.selection_type, 10);
        this.f8701a.setOnClickListener(this.f8706f);
        this.f8702b.setOnClickListener(this.f8706f);
        this.f8701a.setAccessibilityClassName("android.view.View");
        this.f8702b.setAccessibilityClassName("android.view.View");
    }

    private void p() {
        d dVar = new d(new GestureDetector(getContext(), new c()));
        this.f8701a.setOnTouchListener(dVar);
        this.f8702b.setOnTouchListener(dVar);
    }

    private void r(Chip chip, boolean z10) {
        int i10;
        chip.setChecked(z10);
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        ViewCompat.setAccessibilityLiveRegion(chip, i10);
    }

    private void t() {
        int i10;
        if (this.f8705e.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone((ConstraintLayout) this);
            if (ViewCompat.getLayoutDirection(this) == 0) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            constraintSet.clear(R.id.material_clock_display, i10);
            constraintSet.applyTo(this);
        }
    }

    public void d(ClockHandView.OnRotateListener onRotateListener) {
        this.f8703c.b(onRotateListener);
    }

    public void e(int i10) {
        boolean z10;
        Chip chip = this.f8701a;
        boolean z11 = false;
        if (i10 == 12) {
            z10 = true;
        } else {
            z10 = false;
        }
        r(chip, z10);
        Chip chip2 = this.f8702b;
        if (i10 == 10) {
            z11 = true;
        }
        r(chip2, z11);
    }

    public void f(boolean z10) {
        this.f8703c.j(z10);
    }

    public void g(float f10, boolean z10) {
        this.f8703c.m(f10, z10);
    }

    public void h(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f8701a, accessibilityDelegateCompat);
    }

    public void i(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f8702b, accessibilityDelegateCompat);
    }

    public void j(ClockHandView.OnActionUpListener onActionUpListener) {
        this.f8703c.o(onActionUpListener);
    }

    /* access modifiers changed from: package-private */
    public void k(e eVar) {
        this.f8709i = eVar;
    }

    /* access modifiers changed from: package-private */
    public void l(f fVar) {
        this.f8707g = fVar;
    }

    /* access modifiers changed from: package-private */
    public void m(g gVar) {
        this.f8708h = gVar;
    }

    public void o(String[] strArr, int i10) {
        this.f8704d.m(strArr, i10);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            t();
        }
    }

    public void q() {
        this.f8705e.setVisibility(0);
    }

    public void s(int i10, int i11, int i12) {
        int i13;
        if (i10 == 1) {
            i13 = R.id.material_clock_period_pm_button;
        } else {
            i13 = R.id.material_clock_period_am_button;
        }
        this.f8705e.check(i13);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", new Object[]{Integer.valueOf(i12)});
        String format2 = String.format(locale, "%02d", new Object[]{Integer.valueOf(i11)});
        if (!TextUtils.equals(this.f8701a.getText(), format)) {
            this.f8701a.setText(format);
        }
        if (!TextUtils.equals(this.f8702b.getText(), format2)) {
            this.f8702b.setText(format2);
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8706f = new a();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.f8704d = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.f8705e = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new b());
        this.f8701a = (Chip) findViewById(R.id.material_minute_tv);
        this.f8702b = (Chip) findViewById(R.id.material_hour_tv);
        this.f8703c = (ClockHandView) findViewById(R.id.material_clock_hand);
        p();
        n();
    }
}
