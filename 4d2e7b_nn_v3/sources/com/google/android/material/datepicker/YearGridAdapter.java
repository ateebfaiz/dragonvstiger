package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Locale;

class YearGridAdapter extends RecyclerView.Adapter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCalendar f8172a;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(TextView textView2) {
            super(textView2);
            this.textView = textView2;
        }
    }

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8173a;

        a(int i10) {
            this.f8173a = i10;
        }

        public void onClick(View view) {
            YearGridAdapter.this.f8172a.setCurrentMonth(YearGridAdapter.this.f8172a.getCalendarConstraints().clamp(Month.b(this.f8173a, YearGridAdapter.this.f8172a.getCurrentMonth().f8150b)));
            YearGridAdapter.this.f8172a.setSelector(MaterialCalendar.k.DAY);
        }
    }

    YearGridAdapter(MaterialCalendar materialCalendar) {
        this.f8172a = materialCalendar;
    }

    private View.OnClickListener b(int i10) {
        return new a(i10);
    }

    /* access modifiers changed from: package-private */
    public int c(int i10) {
        return i10 - this.f8172a.getCalendarConstraints().getStart().f8151c;
    }

    /* access modifiers changed from: package-private */
    public int d(int i10) {
        return this.f8172a.getCalendarConstraints().getStart().f8151c + i10;
    }

    /* renamed from: e */
    public void onBindViewHolder(ViewHolder viewHolder, int i10) {
        a aVar;
        int d10 = d(i10);
        String string = viewHolder.textView.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        viewHolder.textView.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(d10)}));
        viewHolder.textView.setContentDescription(String.format(string, new Object[]{Integer.valueOf(d10)}));
        b calendarStyle = this.f8172a.getCalendarStyle();
        Calendar o10 = k.o();
        if (o10.get(1) == d10) {
            aVar = calendarStyle.f8186f;
        } else {
            aVar = calendarStyle.f8184d;
        }
        for (Long longValue : this.f8172a.getDateSelector().getSelectedDays()) {
            o10.setTimeInMillis(longValue.longValue());
            if (o10.get(1) == d10) {
                aVar = calendarStyle.f8185e;
            }
        }
        aVar.d(viewHolder.textView);
        viewHolder.textView.setOnClickListener(b(d10));
    }

    /* renamed from: f */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }

    public int getItemCount() {
        return this.f8172a.getCalendarConstraints().getYearSpan();
    }
}
