package com.google.android.material.datepicker;

import android.os.Build;
import android.widget.BaseAdapter;
import java.util.Calendar;

class e extends BaseAdapter {

    /* renamed from: d  reason: collision with root package name */
    private static final int f8199d;

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f8200a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8201b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8202c;

    static {
        int i10;
        if (Build.VERSION.SDK_INT >= 26) {
            i10 = 4;
        } else {
            i10 = 1;
        }
        f8199d = i10;
    }

    public e() {
        Calendar q10 = k.q();
        this.f8200a = q10;
        this.f8201b = q10.getMaximum(7);
        this.f8202c = q10.getFirstDayOfWeek();
    }

    private int b(int i10) {
        int i11 = i10 + this.f8202c;
        int i12 = this.f8201b;
        if (i11 > i12) {
            return i11 - i12;
        }
        return i11;
    }

    /* renamed from: a */
    public Integer getItem(int i10) {
        if (i10 >= this.f8201b) {
            return null;
        }
        return Integer.valueOf(b(i10));
    }

    public int getCount() {
        return this.f8201b;
    }

    public long getItemId(int i10) {
        return 0;
    }

    /* JADX WARNING: type inference failed for: r6v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = r6
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r6 != 0) goto L_0x0017
            android.content.Context r6 = r7.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r1 = com.google.android.material.R.layout.mtrl_calendar_day_of_week
            android.view.View r6 = r6.inflate(r1, r7, r0)
            r1 = r6
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x0017:
            java.util.Calendar r6 = r4.f8200a
            int r5 = r4.b(r5)
            r2 = 7
            r6.set(r2, r5)
            android.content.res.Resources r5 = r1.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            java.util.Locale r5 = r5.locale
            java.util.Calendar r6 = r4.f8200a
            int r3 = f8199d
            java.lang.String r5 = r6.getDisplayName(r2, r3, r5)
            r1.setText(r5)
            android.content.Context r5 = r7.getContext()
            int r6 = com.google.android.material.R.string.mtrl_picker_day_of_week_column_header
            java.lang.String r5 = r5.getString(r6)
            java.util.Calendar r6 = r4.f8200a
            r7 = 2
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r6 = r6.getDisplayName(r2, r7, r3)
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r0] = r6
            java.lang.String r5 = java.lang.String.format(r5, r7)
            r1.setContentDescription(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.e.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
