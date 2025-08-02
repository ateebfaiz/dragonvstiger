package ba;

import aa.e;
import aa.j;
import ga.c;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import y9.m;
import y9.r;
import y9.s;

public final class d extends r {

    /* renamed from: a  reason: collision with root package name */
    private final b f2519a;

    /* renamed from: b  reason: collision with root package name */
    private final List f2520b;

    public static abstract class b {

        /* renamed from: b  reason: collision with root package name */
        public static final b f2521b = new a(Date.class);

        /* renamed from: a  reason: collision with root package name */
        private final Class f2522a;

        class a extends b {
            a(Class cls) {
                super(cls);
            }

            /* access modifiers changed from: protected */
            public Date d(Date date) {
                return date;
            }
        }

        protected b(Class cls) {
            this.f2522a = cls;
        }

        private s c(d dVar) {
            return m.b(this.f2522a, dVar);
        }

        public final s a(int i10, int i11) {
            return c(new d(this, i10, i11));
        }

        public final s b(String str) {
            return c(new d(this, str));
        }

        /* access modifiers changed from: protected */
        public abstract Date d(Date date);
    }

    private Date e(ga.a aVar) {
        String M = aVar.M();
        synchronized (this.f2520b) {
            try {
                for (DateFormat parse : this.f2520b) {
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
        if (aVar.O() == ga.b.NULL) {
            aVar.K();
            return null;
        }
        return this.f2519a.d(e(aVar));
    }

    /* renamed from: g */
    public void d(c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.B();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f2520b.get(0);
        synchronized (this.f2520b) {
            format = dateFormat.format(date);
        }
        cVar.R(format);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f2520b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private d(b bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f2520b = arrayList;
        Objects.requireNonNull(bVar);
        this.f2519a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    private d(b bVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f2520b = arrayList;
        Objects.requireNonNull(bVar);
        this.f2519a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (e.d()) {
            arrayList.add(j.c(i10, i11));
        }
    }
}
