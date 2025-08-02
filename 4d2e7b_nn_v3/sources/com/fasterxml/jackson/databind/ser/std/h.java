package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import java.text.DateFormat;
import java.util.Calendar;

public class h extends l {

    /* renamed from: f  reason: collision with root package name */
    public static final h f5553f = new h();

    public h() {
        this((Boolean) null, (DateFormat) null);
    }

    /* access modifiers changed from: protected */
    public long A(Calendar calendar) {
        if (calendar == null) {
            return 0;
        }
        return calendar.getTimeInMillis();
    }

    /* renamed from: B */
    public void f(Calendar calendar, f fVar, b0 b0Var) {
        if (x(b0Var)) {
            fVar.Y(A(calendar));
        } else {
            y(calendar.getTime(), fVar, b0Var);
        }
    }

    /* renamed from: C */
    public h z(Boolean bool, DateFormat dateFormat) {
        return new h(bool, dateFormat);
    }

    public h(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }
}
