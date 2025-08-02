package ea;

import java.sql.Timestamp;
import java.util.Date;
import y9.d;
import y9.r;
import y9.s;

class c extends r {

    /* renamed from: b  reason: collision with root package name */
    static final s f12058b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final r f12059a;

    class a implements s {
        a() {
        }

        public r a(d dVar, fa.a aVar) {
            if (aVar.d() == Timestamp.class) {
                return new c(dVar.l(Date.class), (a) null);
            }
            return null;
        }
    }

    /* synthetic */ c(r rVar, a aVar) {
        this(rVar);
    }

    /* renamed from: e */
    public Timestamp b(ga.a aVar) {
        Date date = (Date) this.f12059a.b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /* renamed from: f */
    public void d(ga.c cVar, Timestamp timestamp) {
        this.f12059a.d(cVar, timestamp);
    }

    private c(r rVar) {
        this.f12059a = rVar;
    }
}
