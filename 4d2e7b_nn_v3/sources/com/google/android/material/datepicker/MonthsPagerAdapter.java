package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

class MonthsPagerAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final CalendarConstraints f8156a;

    /* renamed from: b  reason: collision with root package name */
    private final DateSelector f8157b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final MaterialCalendar.l f8158c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8159d;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        ViewHolder(@NonNull LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.monthTitle = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z10) {
                textView.setVisibility(8);
            }
        }
    }

    class a implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f8160a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f8160a = materialCalendarGridView;
        }

        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            if (this.f8160a.getAdapter().n(i10)) {
                MonthsPagerAdapter.this.f8158c.a(this.f8160a.getAdapter().getItem(i10).longValue());
            }
        }
    }

    MonthsPagerAdapter(Context context, DateSelector dateSelector, CalendarConstraints calendarConstraints, MaterialCalendar.l lVar) {
        int i10;
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (openAt.compareTo(end) <= 0) {
            int dayHeight = f.f8203f * MaterialCalendar.getDayHeight(context);
            if (MaterialDatePicker.isFullscreen(context)) {
                i10 = MaterialCalendar.getDayHeight(context);
            } else {
                i10 = 0;
            }
            this.f8159d = dayHeight + i10;
            this.f8156a = calendarConstraints;
            this.f8157b = dateSelector;
            this.f8158c = lVar;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    /* access modifiers changed from: package-private */
    public Month b(int i10) {
        return this.f8156a.getStart().j(i10);
    }

    /* access modifiers changed from: package-private */
    public CharSequence c(int i10) {
        return b(i10).h();
    }

    /* access modifiers changed from: package-private */
    public int d(Month month) {
        return this.f8156a.getStart().k(month);
    }

    /* renamed from: e */
    public void onBindViewHolder(ViewHolder viewHolder, int i10) {
        Month j10 = this.f8156a.getStart().j(i10);
        viewHolder.monthTitle.setText(j10.h());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.monthGrid.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !j10.equals(materialCalendarGridView.getAdapter().f8204a)) {
            f fVar = new f(j10, this.f8157b, this.f8156a);
            materialCalendarGridView.setNumColumns(j10.f8152d);
            materialCalendarGridView.setAdapter((ListAdapter) fVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().m(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    /* renamed from: f */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f8159d));
        return new ViewHolder(linearLayout, true);
    }

    public int getItemCount() {
        return this.f8156a.getMonthSpan();
    }

    public long getItemId(int i10) {
        return this.f8156a.getStart().j(i10).i();
    }
}
