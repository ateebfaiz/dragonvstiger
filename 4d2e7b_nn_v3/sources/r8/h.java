package r8;

import com.alibaba.pdns.f;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.o;
import l8.l;
import q8.c;

public class h extends f {

    /* renamed from: d  reason: collision with root package name */
    protected final String f12950d;

    /* renamed from: e  reason: collision with root package name */
    protected final String f12951e;

    protected h(j jVar, o oVar, c cVar) {
        super(jVar, oVar, cVar);
        String name = jVar.s().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            this.f12950d = "";
            this.f12951e = f.G;
            return;
        }
        this.f12951e = name.substring(0, lastIndexOf + 1);
        this.f12950d = name.substring(0, lastIndexOf);
    }

    public static h f(j jVar, l lVar, c cVar) {
        return new h(jVar, lVar.B(), cVar);
    }

    public String a(Object obj) {
        String name = obj.getClass().getName();
        if (name.startsWith(this.f12951e)) {
            return name.substring(this.f12951e.length() - 1);
        }
        return name;
    }
}
