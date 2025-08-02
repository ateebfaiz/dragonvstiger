package kotlin.jvm.internal;

import zb.c;
import zb.d;
import zb.e;
import zb.g;
import zb.j;

public class a0 {
    public e a(i iVar) {
        return iVar;
    }

    public c b(Class cls) {
        return new e(cls);
    }

    public d c(Class cls, String str) {
        return new r(cls, str);
    }

    public g d(o oVar) {
        return oVar;
    }

    public j e(s sVar) {
        return sVar;
    }

    public String f(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            return obj.substring(21);
        }
        return obj;
    }

    public String g(n nVar) {
        return f(nVar);
    }
}
