package l8;

import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.introspect.t;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.x;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import q8.c;
import q8.f;

public final class a implements Serializable {

    /* renamed from: w  reason: collision with root package name */
    private static final TimeZone f12660w = TimeZone.getTimeZone("UTC");

    /* renamed from: a  reason: collision with root package name */
    protected final o f12661a;

    /* renamed from: b  reason: collision with root package name */
    protected final t f12662b;

    /* renamed from: c  reason: collision with root package name */
    protected final b f12663c;

    /* renamed from: d  reason: collision with root package name */
    protected final a.C0071a f12664d;

    /* renamed from: e  reason: collision with root package name */
    protected final f f12665e;

    /* renamed from: f  reason: collision with root package name */
    protected final c f12666f;

    /* renamed from: g  reason: collision with root package name */
    protected final DateFormat f12667g;

    /* renamed from: h  reason: collision with root package name */
    protected final Locale f12668h;

    /* renamed from: i  reason: collision with root package name */
    protected final TimeZone f12669i;

    /* renamed from: j  reason: collision with root package name */
    protected final com.fasterxml.jackson.core.a f12670j;

    public a(t tVar, b bVar, x xVar, o oVar, f fVar, DateFormat dateFormat, k kVar, Locale locale, TimeZone timeZone, com.fasterxml.jackson.core.a aVar, c cVar, a.C0071a aVar2) {
        this.f12662b = tVar;
        this.f12663c = bVar;
        this.f12661a = oVar;
        this.f12665e = fVar;
        this.f12667g = dateFormat;
        this.f12668h = locale;
        this.f12669i = timeZone;
        this.f12670j = aVar;
        this.f12666f = cVar;
        this.f12664d = aVar2;
    }

    public a.C0071a a() {
        return this.f12664d;
    }

    public b b() {
        return this.f12663c;
    }

    public com.fasterxml.jackson.core.a c() {
        return this.f12670j;
    }

    public t d() {
        return this.f12662b;
    }

    public DateFormat e() {
        return this.f12667g;
    }

    public k f() {
        return null;
    }

    public Locale h() {
        return this.f12668h;
    }

    public c i() {
        return this.f12666f;
    }

    public x j() {
        return null;
    }

    public TimeZone k() {
        TimeZone timeZone = this.f12669i;
        if (timeZone == null) {
            return f12660w;
        }
        return timeZone;
    }

    public o l() {
        return this.f12661a;
    }

    public f m() {
        return this.f12665e;
    }

    public a n(t tVar) {
        if (this.f12662b == tVar) {
            return this;
        }
        return new a(tVar, this.f12663c, (x) null, this.f12661a, this.f12665e, this.f12667g, (k) null, this.f12668h, this.f12669i, this.f12670j, this.f12666f, this.f12664d);
    }
}
