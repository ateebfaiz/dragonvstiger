package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.j;
import java.util.ArrayList;
import java.util.Iterator;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    protected final c f5615a;

    /* renamed from: b  reason: collision with root package name */
    protected final Class f5616b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f5617c;

    public c(Class cls) {
        this((c) null, cls);
    }

    public void a(k kVar) {
        if (this.f5617c == null) {
            this.f5617c = new ArrayList();
        }
        this.f5617c.add(kVar);
    }

    public c b(Class cls) {
        return new c(this, cls);
    }

    public c c(Class cls) {
        if (this.f5616b == cls) {
            return this;
        }
        for (c cVar = this.f5615a; cVar != null; cVar = cVar.f5615a) {
            if (cVar.f5616b == cls) {
                return cVar;
            }
        }
        return null;
    }

    public void d(j jVar) {
        ArrayList arrayList = this.f5617c;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((k) it.next()).Z(jVar);
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ClassStack (self-refs: ");
        ArrayList arrayList = this.f5617c;
        if (arrayList == null) {
            str = "0";
        } else {
            str = String.valueOf(arrayList.size());
        }
        sb2.append(str);
        sb2.append(')');
        for (c cVar = this; cVar != null; cVar = cVar.f5615a) {
            sb2.append(' ');
            sb2.append(cVar.f5616b.getName());
        }
        sb2.append(']');
        return sb2.toString();
    }

    private c(c cVar, Class cls) {
        this.f5615a = cVar;
        this.f5616b = cls;
    }
}
