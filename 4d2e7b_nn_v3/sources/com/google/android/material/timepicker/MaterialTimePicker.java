package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import java.util.LinkedHashSet;
import java.util.Set;

public final class MaterialTimePicker extends DialogFragment implements TimePickerView.e {
    public static final int INPUT_MODE_CLOCK = 0;
    static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final String NEGATIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT";
    static final String NEGATIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES";
    static final String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    static final String POSITIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT";
    static final String POSITIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT_RES";
    static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";
    @Nullable
    private e activePresenter;
    private Button cancelButton;
    private final Set<DialogInterface.OnCancelListener> cancelListeners = new LinkedHashSet();
    @DrawableRes
    private int clockIcon;
    private final Set<DialogInterface.OnDismissListener> dismissListeners = new LinkedHashSet();
    /* access modifiers changed from: private */
    public int inputMode = 0;
    @DrawableRes
    private int keyboardIcon;
    /* access modifiers changed from: private */
    public MaterialButton modeButton;
    /* access modifiers changed from: private */
    public final Set<View.OnClickListener> negativeButtonListeners = new LinkedHashSet();
    private CharSequence negativeButtonText;
    @StringRes
    private int negativeButtonTextResId = 0;
    private int overrideThemeResId = 0;
    /* access modifiers changed from: private */
    public final Set<View.OnClickListener> positiveButtonListeners = new LinkedHashSet();
    private CharSequence positiveButtonText;
    @StringRes
    private int positiveButtonTextResId = 0;
    private ViewStub textInputStub;
    private TimeModel time;
    @Nullable
    private d timePickerClockPresenter;
    @Nullable
    private g timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    @StringRes
    private int titleResId = 0;
    private CharSequence titleText;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int inputMode;
        /* access modifiers changed from: private */
        public CharSequence negativeButtonText;
        /* access modifiers changed from: private */
        @StringRes
        public int negativeButtonTextResId = 0;
        /* access modifiers changed from: private */
        public int overrideThemeResId = 0;
        /* access modifiers changed from: private */
        public CharSequence positiveButtonText;
        /* access modifiers changed from: private */
        @StringRes
        public int positiveButtonTextResId = 0;
        /* access modifiers changed from: private */
        public TimeModel time = new TimeModel();
        /* access modifiers changed from: private */
        public CharSequence titleText;
        /* access modifiers changed from: private */
        @StringRes
        public int titleTextResId = 0;

        @NonNull
        public MaterialTimePicker build() {
            return MaterialTimePicker.newInstance(this);
        }

        @NonNull
        public Builder setHour(@IntRange(from = 0, to = 23) int i10) {
            this.time.h(i10);
            return this;
        }

        @NonNull
        public Builder setInputMode(int i10) {
            this.inputMode = i10;
            return this;
        }

        @NonNull
        public Builder setMinute(@IntRange(from = 0, to = 59) int i10) {
            this.time.i(i10);
            return this;
        }

        @NonNull
        public Builder setNegativeButtonText(@StringRes int i10) {
            this.negativeButtonTextResId = i10;
            return this;
        }

        @NonNull
        public Builder setPositiveButtonText(@StringRes int i10) {
            this.positiveButtonTextResId = i10;
            return this;
        }

        @NonNull
        public Builder setTheme(@StyleRes int i10) {
            this.overrideThemeResId = i10;
            return this;
        }

        @NonNull
        public Builder setTimeFormat(int i10) {
            TimeModel timeModel = this.time;
            int i11 = timeModel.f8697d;
            int i12 = timeModel.f8698e;
            TimeModel timeModel2 = new TimeModel(i10);
            this.time = timeModel2;
            timeModel2.i(i12);
            this.time.h(i11);
            return this;
        }

        @NonNull
        public Builder setTitleText(@StringRes int i10) {
            this.titleTextResId = i10;
            return this;
        }

        @NonNull
        public Builder setNegativeButtonText(@Nullable CharSequence charSequence) {
            this.negativeButtonText = charSequence;
            return this;
        }

        @NonNull
        public Builder setPositiveButtonText(@Nullable CharSequence charSequence) {
            this.positiveButtonText = charSequence;
            return this;
        }

        @NonNull
        public Builder setTitleText(@Nullable CharSequence charSequence) {
            this.titleText = charSequence;
            return this;
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            for (View.OnClickListener onClick : MaterialTimePicker.this.positiveButtonListeners) {
                onClick.onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            for (View.OnClickListener onClick : MaterialTimePicker.this.negativeButtonListeners) {
                onClick.onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            int i10;
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            if (materialTimePicker.inputMode == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            int unused = materialTimePicker.inputMode = i10;
            MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
            materialTimePicker2.updateInputMode(materialTimePicker2.modeButton);
        }
    }

    private Pair<Integer, Integer> dataForMode(int i10) {
        if (i10 == 0) {
            return new Pair<>(Integer.valueOf(this.keyboardIcon), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
        }
        if (i10 == 1) {
            return new Pair<>(Integer.valueOf(this.clockIcon), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: " + i10);
    }

    private int getThemeResId() {
        int i10 = this.overrideThemeResId;
        if (i10 != 0) {
            return i10;
        }
        TypedValue resolve = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private e initializeOrRetrieveActivePresenterForMode(int i10, @NonNull TimePickerView timePickerView2, @NonNull ViewStub viewStub) {
        if (i10 == 0) {
            d dVar = this.timePickerClockPresenter;
            if (dVar == null) {
                dVar = new d(timePickerView2, this.time);
            }
            this.timePickerClockPresenter = dVar;
            return dVar;
        }
        if (this.timePickerTextInputPresenter == null) {
            this.timePickerTextInputPresenter = new g((LinearLayout) viewStub.inflate(), this.time);
        }
        this.timePickerTextInputPresenter.e();
        return this.timePickerTextInputPresenter;
    }

    /* access modifiers changed from: private */
    @NonNull
    public static MaterialTimePicker newInstance(@NonNull Builder builder) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TIME_MODEL_EXTRA, builder.time);
        bundle.putInt(INPUT_MODE_EXTRA, builder.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, builder.titleTextResId);
        if (builder.titleText != null) {
            bundle.putCharSequence(TITLE_TEXT_EXTRA, builder.titleText);
        }
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, builder.positiveButtonTextResId);
        if (builder.positiveButtonText != null) {
            bundle.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, builder.positiveButtonText);
        }
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, builder.negativeButtonTextResId);
        if (builder.negativeButtonText != null) {
            bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, builder.negativeButtonText);
        }
        bundle.putInt(OVERRIDE_THEME_RES_ID, builder.overrideThemeResId);
        materialTimePicker.setArguments(bundle);
        return materialTimePicker;
    }

    private void restoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            TimeModel timeModel = (TimeModel) bundle.getParcelable(TIME_MODEL_EXTRA);
            this.time = timeModel;
            if (timeModel == null) {
                this.time = new TimeModel();
            }
            this.inputMode = bundle.getInt(INPUT_MODE_EXTRA, 0);
            this.titleResId = bundle.getInt(TITLE_RES_EXTRA, 0);
            this.titleText = bundle.getCharSequence(TITLE_TEXT_EXTRA);
            this.positiveButtonTextResId = bundle.getInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, 0);
            this.positiveButtonText = bundle.getCharSequence(POSITIVE_BUTTON_TEXT_EXTRA);
            this.negativeButtonTextResId = bundle.getInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, 0);
            this.negativeButtonText = bundle.getCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA);
            this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID, 0);
        }
    }

    private void updateCancelButtonVisibility() {
        int i10;
        Button button = this.cancelButton;
        if (button != null) {
            if (isCancelable()) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            button.setVisibility(i10);
        }
    }

    /* access modifiers changed from: private */
    public void updateInputMode(MaterialButton materialButton) {
        if (materialButton != null && this.timePickerView != null && this.textInputStub != null) {
            e eVar = this.activePresenter;
            if (eVar != null) {
                eVar.a();
            }
            e initializeOrRetrieveActivePresenterForMode = initializeOrRetrieveActivePresenterForMode(this.inputMode, this.timePickerView, this.textInputStub);
            this.activePresenter = initializeOrRetrieveActivePresenterForMode;
            initializeOrRetrieveActivePresenterForMode.show();
            this.activePresenter.invalidate();
            Pair<Integer, Integer> dataForMode = dataForMode(this.inputMode);
            materialButton.setIconResource(((Integer) dataForMode.first).intValue());
            materialButton.setContentDescription(getResources().getString(((Integer) dataForMode.second).intValue()));
            materialButton.sendAccessibilityEvent(4);
        }
    }

    public boolean addOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.add(onCancelListener);
    }

    public boolean addOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.add(onClickListener);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    @IntRange(from = 0, to = 23)
    public int getHour() {
        return this.time.f8697d % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @IntRange(from = 0, to = 59)
    public int getMinute() {
        return this.time.f8698e;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public d getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancel : this.cancelListeners) {
            onCancel.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        restoreState(bundle);
    }

    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), getThemeResId());
        Context context = dialog.getContext();
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, (AttributeSet) null, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.MaterialTimePicker, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        this.clockIcon = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        obtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        materialShapeDrawable.setElevation(ViewCompat.getElevation(window.getDecorView()));
        return dialog;
    }

    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView2 = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.timePickerView = timePickerView2;
        timePickerView2.k(this);
        this.textInputStub = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        int i10 = this.titleResId;
        if (i10 != 0) {
            textView.setText(i10);
        } else if (!TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        updateInputMode(this.modeButton);
        Button button = (Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button);
        button.setOnClickListener(new a());
        int i11 = this.positiveButtonTextResId;
        if (i11 != 0) {
            button.setText(i11);
        } else if (!TextUtils.isEmpty(this.positiveButtonText)) {
            button.setText(this.positiveButtonText);
        }
        Button button2 = (Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button);
        this.cancelButton = button2;
        button2.setOnClickListener(new b());
        int i12 = this.negativeButtonTextResId;
        if (i12 != 0) {
            this.cancelButton.setText(i12);
        } else if (!TextUtils.isEmpty(this.negativeButtonText)) {
            this.cancelButton.setText(this.negativeButtonText);
        }
        updateCancelButtonVisibility();
        this.modeButton.setOnClickListener(new c());
        return viewGroup2;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        TimePickerView timePickerView2 = this.timePickerView;
        if (timePickerView2 != null) {
            timePickerView2.k((TimePickerView.e) null);
            this.timePickerView = null;
        }
    }

    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismiss : this.dismissListeners) {
            onDismiss.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDoubleTap() {
        this.inputMode = 1;
        updateInputMode(this.modeButton);
        this.timePickerTextInputPresenter.h();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(TIME_MODEL_EXTRA, this.time);
        bundle.putInt(INPUT_MODE_EXTRA, this.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, this.titleResId);
        bundle.putCharSequence(TITLE_TEXT_EXTRA, this.titleText);
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, this.positiveButtonTextResId);
        bundle.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, this.positiveButtonText);
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, this.negativeButtonTextResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, this.negativeButtonText);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    public boolean removeOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.remove(onClickListener);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setActivePresenter(@Nullable e eVar) {
        this.activePresenter = eVar;
    }

    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        updateCancelButtonVisibility();
    }

    public void setHour(@IntRange(from = 0, to = 23) int i10) {
        this.time.g(i10);
        e eVar = this.activePresenter;
        if (eVar != null) {
            eVar.invalidate();
        }
    }

    public void setMinute(@IntRange(from = 0, to = 59) int i10) {
        this.time.i(i10);
        e eVar = this.activePresenter;
        if (eVar != null) {
            eVar.invalidate();
        }
    }
}
