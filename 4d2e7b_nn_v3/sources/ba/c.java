package ba;

import aa.e;
import aa.j;
import ga.b;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import y9.d;
import y9.m;
import y9.r;
import y9.s;

public final class c extends r {

    /* renamed from: b  reason: collision with root package name */
    public static final s f2517b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List f2518a;

    class a implements s {
        a() {
        }

        public r a(d dVar, fa.a aVar) {
            if (aVar.d() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f2518a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (e.d()) {
            arrayList.add(j.c(2, 2));
        }
    }

    private Date e(ga.a aVar) {
        String M = aVar.M();
        synchronized (this.f2518a) {
            try {
                for (DateFormat parse : this.f2518a) {
                    try {
                        Date parse2 = parse.parse(M);
                        return parse2;
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return ca.a.c(M, new ParsePosition(0));
                } catch (ParseException e10) {
                    throw new m("Failed parsing '" + M + "' as Date; at path " + aVar.w(), e10);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: f */
    public Date b(ga.a aVar) {
        if (aVar.O() != b.NULL) {
            return e(aVar);
        }
        aVar.K();
        return null;
    }

    /* renamed from: g */
    public void d(ga.c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.B();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f2518a.get(0);
        synchronized (this.f2518a) {
            format = dateFormat.format(date);
        }
        cVar.R(format);
    }
}
