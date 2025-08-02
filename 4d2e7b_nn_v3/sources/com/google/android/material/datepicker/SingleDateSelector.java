package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();
    /* access modifiers changed from: private */
    @Nullable
    public Long selectedItem;

    class a extends c {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ OnSelectionChangedListener f8170g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f8170g = onSelectionChangedListener;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f8170g.onIncompleteSelectionChanged();
        }

        /* access modifiers changed from: package-private */
        public void f(Long l10) {
            if (l10 == null) {
                SingleDateSelector.this.clearSelection();
            } else {
                SingleDateSelector.this.select(l10.longValue());
            }
            this.f8170g.onSelectionChanged(SingleDateSelector.this.getSelection());
        }
    }

    class b implements Parcelable.Creator {
        b() {
        }

        /* renamed from: a */
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            Long unused = singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        /* renamed from: b */
        public SingleDateSelector[] newArray(int i10) {
            return new SingleDateSelector[i10];
        }
    }

    /* access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(Context context) {
        return MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.selectedItem;
        if (l10 != null) {
            arrayList.add(l10);
        }
        return arrayList;
    }

    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l10 = this.selectedItem;
        if (l10 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        String j10 = d.j(l10.longValue());
        return resources.getString(R.string.mtrl_picker_date_header_selected, new Object[]{j10});
    }

    public boolean isSelectionComplete() {
        if (this.selectedItem != null) {
            return true;
        }
        return false;
    }

    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Long> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        SimpleDateFormat k10 = k.k();
        String l10 = k.l(inflate.getResources(), k10);
        textInputLayout.setPlaceholderText(l10);
        Long l11 = this.selectedItem;
        if (l11 != null) {
            editText.setText(k10.format(l11));
        }
        editText.addTextChangedListener(new a(l10, k10, textInputLayout, calendarConstraints, onSelectionChangedListener));
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    public void select(long j10) {
        this.selectedItem = Long.valueOf(j10);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeValue(this.selectedItem);
    }

    @Nullable
    public Long getSelection() {
        return this.selectedItem;
    }

    public void setSelection(@Nullable Long l10) {
        this.selectedItem = l10 == null ? null : Long.valueOf(k.a(l10.longValue()));
    }
}
