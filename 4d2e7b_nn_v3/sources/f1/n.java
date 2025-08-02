package f1;

import f1.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private static final j.f f21483a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final j.f f21484b = new b();

    class a implements j.f {
        a() {
        }

        /* renamed from: b */
        public Map a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return n.b(jVar);
        }
    }

    class b implements j.f {
        b() {
        }

        /* renamed from: b */
        public LinkedHashMap a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return n.b(jVar);
        }
    }

    public static ArrayList a(j jVar) {
        byte h10;
        if (jVar.l() != 91) {
            throw jVar.n("Expecting '[' for list start");
        } else if (jVar.h() == 93) {
            return new ArrayList(0);
        } else {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(c(jVar));
            while (true) {
                h10 = jVar.h();
                if (h10 != 44) {
                    break;
                }
                jVar.h();
                arrayList.add(c(jVar));
            }
            if (h10 == 93) {
                return arrayList;
            }
            throw jVar.n("Expecting ']' for list end");
        }
    }

    public static LinkedHashMap b(j jVar) {
        byte h10;
        if (jVar.l() != 123) {
            throw jVar.n("Expecting '{' for map start");
        } else if (jVar.h() == 125) {
            return new LinkedHashMap(0);
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(jVar.D(), c(jVar));
            while (true) {
                h10 = jVar.h();
                if (h10 != 44) {
                    break;
                }
                jVar.h();
                linkedHashMap.put(jVar.D(), c(jVar));
            }
            if (h10 == 125) {
                return linkedHashMap;
            }
            throw jVar.n("Expecting '}' for map end");
        }
    }

    public static Object c(j jVar) {
        byte l10 = jVar.l();
        if (l10 == 34) {
            return jVar.G();
        }
        if (l10 == 91) {
            return a(jVar);
        }
        if (l10 != 102) {
            if (l10 != 110) {
                if (l10 != 116) {
                    if (l10 != 123) {
                        return m.l(jVar);
                    }
                    return b(jVar);
                } else if (jVar.L()) {
                    return Boolean.TRUE;
                } else {
                    throw jVar.p("Expecting 'true' for true constant", 0);
                }
            } else if (jVar.K()) {
                return null;
            } else {
                throw jVar.p("Expecting 'null' for null constant", 0);
            }
        } else if (jVar.J()) {
            return Boolean.FALSE;
        } else {
            throw jVar.p("Expecting 'false' for false constant", 0);
        }
    }
}
