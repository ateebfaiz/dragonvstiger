package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;

class f extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    static final int f8203f = k.q().getMaximum(4);

    /* renamed from: a  reason: collision with root package name */
    final Month f8204a;

    /* renamed from: b  reason: collision with root package name */
    final DateSelector f8205b;

    /* renamed from: c  reason: collision with root package name */
    private Collection f8206c;

    /* renamed from: d  reason: collision with root package name */
    b f8207d;

    /* renamed from: e  reason: collision with root package name */
    final CalendarConstraints f8208e;

    f(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints) {
        this.f8204a = month;
        this.f8205b = dateSelector;
        this.f8208e = calendarConstraints;
        this.f8206c = dateSelector.getSelectedDays();
    }

    private void e(Context context) {
        if (this.f8207d == null) {
            this.f8207d = new b(context);
        }
    }

    private boolean h(long j10) {
        for (Long longValue : this.f8205b.getSelectedDays()) {
            if (k.a(j10) == k.a(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    private void k(TextView textView, long j10) {
        a aVar;
        if (textView != null) {
            if (this.f8208e.getDateValidator().isValid(j10)) {
                textView.setEnabled(true);
                if (h(j10)) {
                    aVar = this.f8207d.f8182b;
                } else if (k.o().getTimeInMillis() == j10) {
                    aVar = this.f8207d.f8183c;
                } else {
                    aVar = this.f8207d.f8181a;
                }
            } else {
                textView.setEnabled(false);
                aVar = this.f8207d.f8187g;
            }
            aVar.d(textView);
        }
    }

    private void l(MaterialCalendarGridView materialCalendarGridView, long j10) {
        if (Month.c(j10).equals(this.f8204a)) {
            k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.f8204a.g(j10)) - materialCalendarGridView.getFirstVisiblePosition()), j10);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i10) {
        return b() + (i10 - 1);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f8204a.e();
    }

    /* renamed from: c */
    public Long getItem(int i10) {
        if (i10 < this.f8204a.e() || i10 > i()) {
            return null;
        }
        return Long.valueOf(this.f8204a.f(j(i10)));
    }

    /* JADX WARNING: type inference failed for: r7v10, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0084  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 1
            android.content.Context r1 = r8.getContext()
            r5.e(r1)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            if (r7 != 0) goto L_0x001f
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r1 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r1, r8, r2)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x001f:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L_0x0075
            com.google.android.material.datepicker.Month r8 = r5.f8204a
            int r3 = r8.f8153e
            if (r7 < r3) goto L_0x002e
            goto L_0x0075
        L_0x002e:
            int r7 = r7 + r0
            r1.setTag(r8)
            android.content.res.Resources r8 = r1.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r2] = r3
            java.lang.String r3 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r3, r4)
            r1.setText(r8)
            com.google.android.material.datepicker.Month r8 = r5.f8204a
            long r7 = r8.f(r7)
            com.google.android.material.datepicker.Month r3 = r5.f8204a
            int r3 = r3.f8151c
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.d()
            int r4 = r4.f8151c
            if (r3 != r4) goto L_0x0067
            java.lang.String r7 = com.google.android.material.datepicker.d.g(r7)
            r1.setContentDescription(r7)
            goto L_0x006e
        L_0x0067:
            java.lang.String r7 = com.google.android.material.datepicker.d.l(r7)
            r1.setContentDescription(r7)
        L_0x006e:
            r1.setVisibility(r2)
            r1.setEnabled(r0)
            goto L_0x007d
        L_0x0075:
            r7 = 8
            r1.setVisibility(r7)
            r1.setEnabled(r2)
        L_0x007d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L_0x0084
            return r1
        L_0x0084:
            long r6 = r6.longValue()
            r5.k(r1, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.f.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* access modifiers changed from: package-private */
    public boolean f(int i10) {
        if (i10 % this.f8204a.f8152d == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean g(int i10) {
        if ((i10 + 1) % this.f8204a.f8152d == 0) {
            return true;
        }
        return false;
    }

    public int getCount() {
        return this.f8204a.f8153e + b();
    }

    public long getItemId(int i10) {
        return (long) (i10 / this.f8204a.f8152d);
    }

    public boolean hasStableIds() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return (this.f8204a.e() + this.f8204a.f8153e) - 1;
    }

    /* access modifiers changed from: package-private */
    public int j(int i10) {
        return (i10 - this.f8204a.e()) + 1;
    }

    public void m(MaterialCalendarGridView materialCalendarGridView) {
        for (Long longValue : this.f8206c) {
            l(materialCalendarGridView, longValue.longValue());
        }
        DateSelector dateSelector = this.f8205b;
        if (dateSelector != null) {
            for (Long longValue2 : dateSelector.getSelectedDays()) {
                l(materialCalendarGridView, longValue2.longValue());
            }
            this.f8206c = this.f8205b.getSelectedDays();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean n(int i10) {
        if (i10 < b() || i10 > i()) {
            return false;
        }
        return true;
    }
}
