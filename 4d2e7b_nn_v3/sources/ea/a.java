package ea;

import ga.b;
import ga.c;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import y9.d;
import y9.m;
import y9.r;
import y9.s;

final class a extends r {

    /* renamed from: b  reason: collision with root package name */
    static final s f12054b = new C0136a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f12055a;

    /* renamed from: ea.a$a  reason: collision with other inner class name */
    class C0136a implements s {
        C0136a() {
        }

        public r a(d dVar, fa.a aVar) {
            if (aVar.d() == Date.class) {
                return new a((C0136a) null);
            }
            return null;
        }
    }

    /* synthetic */ a(C0136a aVar) {
        this();
    }

    /* renamed from: e */
    public Date b(ga.a aVar) {
        java.util.Date parse;
        if (aVar.O() == b.NULL) {
            aVar.K();
            return null;
        }
        String M = aVar.M();
        try {
            synchronized (this) {
                parse = this.f12055a.parse(M);
            }
            return new Date(parse.getTime());
        } catch (ParseException e10) {
            throw new m("Failed parsing '" + M + "' as SQL Date; at path " + aVar.w(), e10);
        }
    }

    /* renamed from: f */
    public void d(c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.B();
            return;
        }
        synchronized (this) {
            format = this.f12055a.format(date);
        }
        cVar.R(format);
    }

    private a() {
        this.f12055a = new SimpleDateFormat("MMM d, yyyy");
    }
}
