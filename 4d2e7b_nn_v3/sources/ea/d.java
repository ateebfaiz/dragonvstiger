package ea;

import ba.d;
import java.sql.Date;
import java.sql.Timestamp;
import y9.s;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f12060a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.b f12061b;

    /* renamed from: c  reason: collision with root package name */
    public static final d.b f12062c;

    /* renamed from: d  reason: collision with root package name */
    public static final s f12063d;

    /* renamed from: e  reason: collision with root package name */
    public static final s f12064e;

    /* renamed from: f  reason: collision with root package name */
    public static final s f12065f;

    class a extends d.b {
        a(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public Date d(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    class b extends d.b {
        b(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public Timestamp d(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f12060a = z10;
        if (z10) {
            f12061b = new a(Date.class);
            f12062c = new b(Timestamp.class);
            f12063d = a.f12054b;
            f12064e = b.f12056b;
            f12065f = c.f12058b;
            return;
        }
        f12061b = null;
        f12062c = null;
        f12063d = null;
        f12064e = null;
        f12065f = null;
    }
}
