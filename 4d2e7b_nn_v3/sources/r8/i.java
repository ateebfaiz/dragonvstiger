package r8;

import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.introspect.c;
import com.fasterxml.jackson.databind.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import l8.l;
import q8.d;

public class i extends d implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected LinkedHashSet f12952a;

    public Collection a(l lVar, c cVar) {
        b h10 = lVar.h();
        HashMap hashMap = new HashMap();
        if (this.f12952a != null) {
            Class d10 = cVar.d();
            Iterator it = this.f12952a.iterator();
            while (it.hasNext()) {
                q8.b bVar = (q8.b) it.next();
                if (d10.isAssignableFrom(bVar.b())) {
                    c(com.fasterxml.jackson.databind.introspect.d.m(lVar, bVar.b()), bVar, lVar, h10, hashMap);
                }
            }
        }
        c(cVar, new q8.b(cVar.d(), (String) null), lVar, h10, hashMap);
        return new ArrayList(hashMap.values());
    }

    public Collection b(l lVar, com.fasterxml.jackson.databind.introspect.i iVar, j jVar) {
        Class cls;
        List<q8.b> S;
        b h10 = lVar.h();
        if (jVar != null) {
            cls = jVar.s();
        } else if (iVar != null) {
            cls = iVar.d();
        } else {
            throw new IllegalArgumentException("Both property and base type are nulls");
        }
        HashMap hashMap = new HashMap();
        LinkedHashSet linkedHashSet = this.f12952a;
        if (linkedHashSet != null) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                q8.b bVar = (q8.b) it.next();
                if (cls.isAssignableFrom(bVar.b())) {
                    c(com.fasterxml.jackson.databind.introspect.d.m(lVar, bVar.b()), bVar, lVar, h10, hashMap);
                }
            }
        }
        if (!(iVar == null || (S = h10.S(iVar)) == null)) {
            for (q8.b bVar2 : S) {
                c(com.fasterxml.jackson.databind.introspect.d.m(lVar, bVar2.b()), bVar2, lVar, h10, hashMap);
            }
        }
        c(com.fasterxml.jackson.databind.introspect.d.m(lVar, cls), new q8.b(cls, (String) null), lVar, h10, hashMap);
        return new ArrayList(hashMap.values());
    }

    /* access modifiers changed from: protected */
    public void c(c cVar, q8.b bVar, l lVar, b bVar2, HashMap hashMap) {
        String T;
        if (!bVar.c() && (T = bVar2.T(cVar)) != null) {
            bVar = new q8.b(bVar.b(), T);
        }
        q8.b bVar3 = new q8.b(bVar.b());
        if (!hashMap.containsKey(bVar3)) {
            hashMap.put(bVar3, bVar);
            List<q8.b> S = bVar2.S(cVar);
            if (S != null && !S.isEmpty()) {
                for (q8.b bVar4 : S) {
                    c(com.fasterxml.jackson.databind.introspect.d.m(lVar, bVar4.b()), bVar4, lVar, bVar2, hashMap);
                }
            }
        } else if (bVar.c() && !((q8.b) hashMap.get(bVar3)).c()) {
            hashMap.put(bVar3, bVar);
        }
    }
}
