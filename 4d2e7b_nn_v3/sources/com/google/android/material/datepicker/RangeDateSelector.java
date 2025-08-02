package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
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
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();
    private final String invalidRangeEndError = " ";
    private String invalidRangeStartError;
    /* access modifiers changed from: private */
    @Nullable
    public Long proposedTextEnd = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long proposedTextStart = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long selectedEndItem = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long selectedStartItem = null;

    class a extends c {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f8162g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f8163h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ OnSelectionChangedListener f8164i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f8162g = textInputLayout2;
            this.f8163h = textInputLayout3;
            this.f8164i = onSelectionChangedListener;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            Long unused = RangeDateSelector.this.proposedTextStart = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f8162g, this.f8163h, this.f8164i);
        }

        /* access modifiers changed from: package-private */
        public void f(Long l10) {
            Long unused = RangeDateSelector.this.proposedTextStart = l10;
            RangeDateSelector.this.updateIfValidTextProposal(this.f8162g, this.f8163h, this.f8164i);
        }
    }

    class b extends c {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f8166g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f8167h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ OnSelectionChangedListener f8168i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f8166g = textInputLayout2;
            this.f8167h = textInputLayout3;
            this.f8168i = onSelectionChangedListener;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            Long unused = RangeDateSelector.this.proposedTextEnd = null;
            RangeDateSelector.this.updateIfValidTextProposal(this.f8166g, this.f8167h, this.f8168i);
        }

        /* access modifiers changed from: package-private */
        public void f(Long l10) {
            Long unused = RangeDateSelector.this.proposedTextEnd = l10;
            RangeDateSelector.this.updateIfValidTextProposal(this.f8166g, this.f8167h, this.f8168i);
        }
    }

    class c implements Parcelable.Creator {
        c() {
        }

        /* renamed from: a */
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            Class<Long> cls = Long.class;
            Long unused = rangeDateSelector.selectedStartItem = (Long) parcel.readValue(cls.getClassLoader());
            Long unused2 = rangeDateSelector.selectedEndItem = (Long) parcel.readValue(cls.getClassLoader());
            return rangeDateSelector;
        }

        /* renamed from: b */
        public RangeDateSelector[] newArray(int i10) {
            return new RangeDateSelector[i10];
        }
    }

    private void clearInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError((CharSequence) null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError((CharSequence) null);
        }
    }

    private boolean isValidRange(long j10, long j11) {
        return j10 <= j11;
    }

    private void setInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    /* access modifiers changed from: private */
    public void updateIfValidTextProposal(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        Long l10 = this.proposedTextStart;
        if (l10 == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else if (isValidRange(l10.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            onSelectionChangedListener.onSelectionChanged(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(@NonNull Context context) {
        int i10;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis)) {
            i10 = R.attr.materialCalendarTheme;
        } else {
            i10 = R.attr.materialCalendarFullscreenTheme;
        }
        return MaterialAttributes.resolveOrThrow(context, i10, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.selectedStartItem;
        if (l10 != null) {
            arrayList.add(l10);
        }
        Long l11 = this.selectedEndItem;
        if (l11 != null) {
            arrayList.add(l11);
        }
        return arrayList;
    }

    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        if (this.selectedStartItem == null || this.selectedEndItem == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l10 = this.selectedStartItem;
        if (l10 == null && this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l11 = this.selectedEndItem;
        if (l11 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[]{d.c(l10.longValue())});
        } else if (l10 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[]{d.c(l11.longValue())});
        } else {
            Pair a10 = d.a(l10, l11);
            return resources.getString(R.string.mtrl_picker_range_header_selected, new Object[]{a10.first, a10.second});
        }
    }

    public boolean isSelectionComplete() {
        Long l10 = this.selectedStartItem;
        if (l10 == null || this.selectedEndItem == null || !isValidRange(l10.longValue(), this.selectedEndItem.longValue())) {
            return false;
        }
        return true;
    }

    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat k10 = k.k();
        Long l10 = this.selectedStartItem;
        if (l10 != null) {
            editText.setText(k10.format(l10));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l11 = this.selectedEndItem;
        if (l11 != null) {
            editText2.setText(k10.format(l11));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String l12 = k.l(inflate.getResources(), k10);
        textInputLayout.setPlaceholderText(l12);
        textInputLayout2.setPlaceholderText(l12);
        SimpleDateFormat simpleDateFormat = k10;
        CalendarConstraints calendarConstraints2 = calendarConstraints;
        TextInputLayout textInputLayout3 = textInputLayout;
        a aVar = r0;
        TextInputLayout textInputLayout4 = textInputLayout2;
        String str = l12;
        OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener2 = onSelectionChangedListener;
        a aVar2 = new a(l12, simpleDateFormat, textInputLayout, calendarConstraints2, textInputLayout3, textInputLayout4, onSelectionChangedListener2);
        editText.addTextChangedListener(aVar);
        editText2.addTextChangedListener(new b(str, simpleDateFormat, textInputLayout2, calendarConstraints2, textInputLayout3, textInputLayout4, onSelectionChangedListener2));
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    public void select(long j10) {
        Long l10 = this.selectedStartItem;
        if (l10 == null) {
            this.selectedStartItem = Long.valueOf(j10);
        } else if (this.selectedEndItem != null || !isValidRange(l10.longValue(), j10)) {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j10);
        } else {
            this.selectedEndItem = Long.valueOf(j10);
        }
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    public void setSelection(@NonNull Pair<Long, Long> pair) {
        F f10 = pair.first;
        if (!(f10 == null || pair.second == null)) {
            Preconditions.checkArgument(isValidRange(((Long) f10).longValue(), ((Long) pair.second).longValue()));
        }
        F f11 = pair.first;
        Long l10 = null;
        this.selectedStartItem = f11 == null ? null : Long.valueOf(k.a(((Long) f11).longValue()));
        S s10 = pair.second;
        if (s10 != null) {
            l10 = Long.valueOf(k.a(((Long) s10).longValue()));
        }
        this.selectedEndItem = l10;
    }
}
