package ea;

import ga.c;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import y9.d;
import y9.m;
import y9.r;
import y9.s;

final class b extends r {

    /* renamed from: b  reason: collision with root package name */
    static final s f12056b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f12057a;

    class a implements s {
        a() {
        }

        public r a(d dVar, fa.a aVar) {
            if (aVar.d() == Time.class) {
                return new b((a) null);
            }
            return null;
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    /* renamed from: e */
    public Time b(ga.a aVar) {
        Time time;
        if (aVar.O() == ga.b.NULL) {
            aVar.K();
            return null;
        }
        String M = aVar.M();
        try {
            synchronized (this) {
                time = new Time(this.f12057a.parse(M).getTime());
            }
            return time;
        } catch (ParseException e10) {
            throw new m("Failed parsing '" + M + "' as SQL Time; at path " + aVar.w(), e10);
        }
    }

    /* renamed from: f */
    public void d(c cVar, Time time) {
        String format;
        if (time == null) {
            cVar.B();
            return;
        }
        synchronized (this) {
            format = this.f12057a.format(time);
        }
        cVar.R(format);
    }

    private b() {
        this.f12057a = new SimpleDateFormat("hh:mm:ss a");
    }
}
