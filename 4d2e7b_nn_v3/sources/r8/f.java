package r8;

import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.o;
import java.util.EnumMap;
import java.util.EnumSet;
import l8.l;
import q8.c;

public class f extends k {

    /* renamed from: c  reason: collision with root package name */
    protected final c f12948c;

    public f(j jVar, o oVar, c cVar) {
        super(jVar, oVar);
        this.f12948c = cVar;
    }

    public static f e(j jVar, l lVar, c cVar) {
        return new f(jVar, lVar.B(), cVar);
    }

    public String a(Object obj) {
        return d(obj, obj.getClass(), this.f12961a);
    }

    public String c(Object obj, Class cls) {
        return d(obj, cls, this.f12961a);
    }

    /* access modifiers changed from: protected */
    public String d(Object obj, Class cls, o oVar) {
        if (com.fasterxml.jackson.databind.util.f.G(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name = cls.getName();
        if (name.startsWith("java.util.")) {
            if (obj instanceof EnumSet) {
                return oVar.y(EnumSet.class, com.fasterxml.jackson.databind.util.f.s((EnumSet) obj)).e();
            } else if (!(obj instanceof EnumMap)) {
                return name;
            } else {
                return oVar.B(EnumMap.class, com.fasterxml.jackson.databind.util.f.r((EnumMap) obj), Object.class).e();
            }
        } else if (name.indexOf(36) < 0 || com.fasterxml.jackson.databind.util.f.A(cls) == null || com.fasterxml.jackson.databind.util.f.A(this.f12962b.s()) != null) {
            return name;
        } else {
            return this.f12962b.s().getName();
        }
    }
}
