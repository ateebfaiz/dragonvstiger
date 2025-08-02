package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;

class g implements TimePickerView.g, e {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f8731a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final TimeModel f8732b;

    /* renamed from: c  reason: collision with root package name */
    private final TextWatcher f8733c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f8734d = new b();

    /* renamed from: e  reason: collision with root package name */
    private final ChipTextInputComboView f8735e;

    /* renamed from: f  reason: collision with root package name */
    private final ChipTextInputComboView f8736f;

    /* renamed from: g  reason: collision with root package name */
    private final f f8737g;

    /* renamed from: h  reason: collision with root package name */
    private final EditText f8738h;

    /* renamed from: i  reason: collision with root package name */
    private final EditText f8739i;

    /* renamed from: j  reason: collision with root package name */
    private MaterialButtonToggleGroup f8740j;

    class a extends TextWatcherAdapter {
        a() {
        }

        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    g.this.f8732b.i(0);
                    return;
                }
                g.this.f8732b.i(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    class b extends TextWatcherAdapter {
        b() {
        }

        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    g.this.f8732b.g(0);
                    return;
                }
                g.this.f8732b.g(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            g.this.c(((Integer) view.getTag(R.id.selection_type)).intValue());
        }
    }

    class d extends b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TimeModel f8744b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, int i10, TimeModel timeModel) {
            super(context, i10);
            this.f8744b = timeModel;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R.string.material_hour_suffix, new Object[]{String.valueOf(this.f8744b.c())}));
        }
    }

    class e extends b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TimeModel f8746b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, int i10, TimeModel timeModel) {
            super(context, i10);
            this.f8746b = timeModel;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R.string.material_minute_suffix, new Object[]{String.valueOf(this.f8746b.f8698e)}));
        }
    }

    class f implements MaterialButtonToggleGroup.OnButtonCheckedListener {
        f() {
        }

        public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
            int i11;
            if (i10 == R.id.material_clock_period_pm_button) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            g.this.f8732b.j(i11);
        }
    }

    public g(LinearLayout linearLayout, TimeModel timeModel) {
        this.f8731a = linearLayout;
        this.f8732b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.f8735e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.f8736f = chipTextInputComboView2;
        ((TextView) chipTextInputComboView.findViewById(R.id.material_label)).setText(resources.getString(R.string.material_timepicker_minute));
        ((TextView) chipTextInputComboView2.findViewById(R.id.material_label)).setText(resources.getString(R.string.material_timepicker_hour));
        chipTextInputComboView.setTag(R.id.selection_type, 12);
        chipTextInputComboView2.setTag(R.id.selection_type, 10);
        if (timeModel.f8696c == 0) {
            j();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(timeModel.d());
        chipTextInputComboView.c(timeModel.e());
        this.f8738h = chipTextInputComboView2.e().getEditText();
        this.f8739i = chipTextInputComboView.e().getEditText();
        this.f8737g = new f(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new d(linearLayout.getContext(), R.string.material_hour_selection, timeModel));
        chipTextInputComboView.f(new e(linearLayout.getContext(), R.string.material_minute_selection, timeModel));
        f();
    }

    private void d() {
        this.f8738h.addTextChangedListener(this.f8734d);
        this.f8739i.addTextChangedListener(this.f8733c);
    }

    private void g() {
        this.f8738h.removeTextChangedListener(this.f8734d);
        this.f8739i.removeTextChangedListener(this.f8733c);
    }

    private void i(TimeModel timeModel) {
        g();
        Locale locale = this.f8731a.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", new Object[]{Integer.valueOf(timeModel.f8698e)});
        String format2 = String.format(locale, "%02d", new Object[]{Integer.valueOf(timeModel.c())});
        this.f8735e.g(format);
        this.f8736f.g(format2);
        d();
        k();
    }

    private void j() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f8731a.findViewById(R.id.material_clock_period_toggle);
        this.f8740j = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new f());
        this.f8740j.setVisibility(0);
        k();
    }

    private void k() {
        int i10;
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f8740j;
        if (materialButtonToggleGroup != null) {
            if (this.f8732b.f8700g == 0) {
                i10 = R.id.material_clock_period_am_button;
            } else {
                i10 = R.id.material_clock_period_pm_button;
            }
            materialButtonToggleGroup.check(i10);
        }
    }

    public void a() {
        View focusedChild = this.f8731a.getFocusedChild();
        if (focusedChild == null) {
            this.f8731a.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.f8731a.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.f8731a.setVisibility(8);
    }

    public void c(int i10) {
        boolean z10;
        this.f8732b.f8699f = i10;
        ChipTextInputComboView chipTextInputComboView = this.f8735e;
        boolean z11 = false;
        if (i10 == 12) {
            z10 = true;
        } else {
            z10 = false;
        }
        chipTextInputComboView.setChecked(z10);
        ChipTextInputComboView chipTextInputComboView2 = this.f8736f;
        if (i10 == 10) {
            z11 = true;
        }
        chipTextInputComboView2.setChecked(z11);
        k();
    }

    public void e() {
        this.f8735e.setChecked(false);
        this.f8736f.setChecked(false);
    }

    public void f() {
        d();
        i(this.f8732b);
        this.f8737g.a();
    }

    public void h() {
        boolean z10;
        ChipTextInputComboView chipTextInputComboView = this.f8735e;
        boolean z11 = false;
        if (this.f8732b.f8699f == 12) {
            z10 = true;
        } else {
            z10 = false;
        }
        chipTextInputComboView.setChecked(z10);
        ChipTextInputComboView chipTextInputComboView2 = this.f8736f;
        if (this.f8732b.f8699f == 10) {
            z11 = true;
        }
        chipTextInputComboView2.setChecked(z11);
    }

    public void invalidate() {
        i(this.f8732b);
    }

    public void show() {
        this.f8731a.setVisibility(0);
    }
}
