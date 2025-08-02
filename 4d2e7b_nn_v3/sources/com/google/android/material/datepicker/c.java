package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

abstract class c extends TextWatcherAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout f8189a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final DateFormat f8190b;

    /* renamed from: c  reason: collision with root package name */
    private final CalendarConstraints f8191c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f8192d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f8193e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f8194f;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8195a;

        a(String str) {
            this.f8195a = str;
        }

        public void run() {
            TextInputLayout a10 = c.this.f8189a;
            DateFormat b10 = c.this.f8190b;
            Context context = a10.getContext();
            String string = context.getString(R.string.mtrl_picker_invalid_format);
            String format = String.format(context.getString(R.string.mtrl_picker_invalid_format_use), new Object[]{this.f8195a});
            String format2 = String.format(context.getString(R.string.mtrl_picker_invalid_format_example), new Object[]{b10.format(new Date(k.o().getTimeInMillis()))});
            a10.setError(string + "\n" + format + "\n" + format2);
            c.this.e();
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f8197a;

        b(long j10) {
            this.f8197a = j10;
        }

        public void run() {
            c.this.f8189a.setError(String.format(c.this.f8192d, new Object[]{d.c(this.f8197a)}));
            c.this.e();
        }
    }

    c(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f8190b = dateFormat;
        this.f8189a = textInputLayout;
        this.f8191c = calendarConstraints;
        this.f8192d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f8193e = new a(str);
    }

    private Runnable d(long j10) {
        return new b(j10);
    }

    /* access modifiers changed from: package-private */
    public abstract void e();

    /* access modifiers changed from: package-private */
    public abstract void f(Long l10);

    public void g(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000);
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f8189a.removeCallbacks(this.f8193e);
        this.f8189a.removeCallbacks(this.f8194f);
        this.f8189a.setError((CharSequence) null);
        f((Long) null);
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                Date parse = this.f8190b.parse(charSequence.toString());
                this.f8189a.setError((CharSequence) null);
                long time = parse.getTime();
                if (!this.f8191c.getDateValidator().isValid(time) || !this.f8191c.isWithinBounds(time)) {
                    Runnable d10 = d(time);
                    this.f8194f = d10;
                    g(this.f8189a, d10);
                    return;
                }
                f(Long.valueOf(parse.getTime()));
            } catch (ParseException unused) {
                g(this.f8189a, this.f8193e);
            }
        }
    }
}
