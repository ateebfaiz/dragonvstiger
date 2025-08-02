package t8;

import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.util.q;
import java.util.HashMap;
import java.util.Map;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final a[] f13104a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13105b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13106c;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final o f13107a;

        /* renamed from: b  reason: collision with root package name */
        public final a f13108b;

        /* renamed from: c  reason: collision with root package name */
        protected final Class f13109c;

        /* renamed from: d  reason: collision with root package name */
        protected final j f13110d;

        /* renamed from: e  reason: collision with root package name */
        protected final boolean f13111e;

        public a(a aVar, q qVar, o oVar) {
            this.f13108b = aVar;
            this.f13107a = oVar;
            this.f13111e = qVar.c();
            this.f13109c = qVar.a();
            this.f13110d = qVar.b();
        }

        public boolean a(Class cls) {
            if (this.f13109c != cls || !this.f13111e) {
                return false;
            }
            return true;
        }

        public boolean b(j jVar) {
            if (this.f13111e || !jVar.equals(this.f13110d)) {
                return false;
            }
            return true;
        }

        public boolean c(Class cls) {
            if (this.f13109c != cls || this.f13111e) {
                return false;
            }
            return true;
        }
    }

    public l(Map map) {
        int a10 = a(map.size());
        this.f13105b = a10;
        this.f13106c = a10 - 1;
        a[] aVarArr = new a[a10];
        for (Map.Entry entry : map.entrySet()) {
            q qVar = (q) entry.getKey();
            int hashCode = qVar.hashCode() & this.f13106c;
            aVarArr[hashCode] = new a(aVarArr[hashCode], qVar, (o) entry.getValue());
        }
        this.f13104a = aVarArr;
    }

    private static final int a(int i10) {
        int i11;
        if (i10 <= 64) {
            i11 = i10 + i10;
        } else {
            i11 = i10 + (i10 >> 2);
        }
        int i12 = 8;
        while (i12 < i11) {
            i12 += i12;
        }
        return i12;
    }

    public static l b(HashMap hashMap) {
        return new l(hashMap);
    }

    public o c(Class cls) {
        a aVar = this.f13104a[q.e(cls) & this.f13106c];
        if (aVar == null) {
            return null;
        }
        if (aVar.a(cls)) {
            return aVar.f13107a;
        }
        do {
            aVar = aVar.f13108b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.a(cls));
        return aVar.f13107a;
    }

    public o d(j jVar) {
        a aVar = this.f13104a[q.f(jVar) & this.f13106c];
        if (aVar == null) {
            return null;
        }
        if (aVar.b(jVar)) {
            return aVar.f13107a;
        }
        do {
            aVar = aVar.f13108b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.b(jVar));
        return aVar.f13107a;
    }

    public o e(Class cls) {
        a aVar = this.f13104a[q.g(cls) & this.f13106c];
        if (aVar == null) {
            return null;
        }
        if (aVar.c(cls)) {
            return aVar.f13107a;
        }
        do {
            aVar = aVar.f13108b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.c(cls));
        return aVar.f13107a;
    }
}
