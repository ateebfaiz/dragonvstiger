package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.introspect.h0;
import com.fasterxml.jackson.databind.introspect.t;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.util.f;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class h extends u {

    /* renamed from: d  reason: collision with root package name */
    private final o f5349d;

    /* renamed from: e  reason: collision with root package name */
    private final t.a f5350e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5351f;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final h0 f5352a;

        /* renamed from: b  reason: collision with root package name */
        public final Field f5353b;

        /* renamed from: c  reason: collision with root package name */
        public o f5354c = o.e();

        public a(h0 h0Var, Field field) {
            this.f5352a = h0Var;
            this.f5353b = field;
        }

        public g a() {
            return new g(this.f5352a, this.f5353b, this.f5354c.b());
        }
    }

    h(b bVar, o oVar, t.a aVar, boolean z10) {
        super(bVar);
        this.f5349d = oVar;
        this.f5350e = bVar == null ? null : aVar;
        this.f5351f = z10;
    }

    private void i(Class cls, Class cls2, Map map) {
        a aVar;
        for (Class declaredFields : f.u(cls, cls2, true)) {
            for (Field field : declaredFields.getDeclaredFields()) {
                if (k(field) && (aVar = (a) map.get(field.getName())) != null) {
                    aVar.f5354c = d(aVar.f5354c, field.getDeclaredAnnotations());
                }
            }
        }
    }

    private Map j(h0 h0Var, j jVar, Map map) {
        t.a aVar;
        Class a10;
        j u10 = jVar.u();
        if (u10 == null) {
            return map;
        }
        Class s10 = jVar.s();
        Map j10 = j(new h0.a(this.f5349d, u10.k()), u10, map);
        for (Field field : s10.getDeclaredFields()) {
            if (k(field)) {
                if (j10 == null) {
                    j10 = new LinkedHashMap();
                }
                a aVar2 = new a(h0Var, field);
                if (this.f5351f) {
                    aVar2.f5354c = d(aVar2.f5354c, field.getDeclaredAnnotations());
                }
                j10.put(field.getName(), aVar2);
            }
        }
        if (!(j10 == null || (aVar = this.f5350e) == null || (a10 = aVar.a(s10)) == null)) {
            i(a10, s10, j10);
        }
        return j10;
    }

    private boolean k(Field field) {
        if (!field.isSynthetic() && !Modifier.isStatic(field.getModifiers())) {
            return true;
        }
        return false;
    }

    public static List m(b bVar, h0 h0Var, t.a aVar, o oVar, j jVar, boolean z10) {
        return new h(bVar, oVar, aVar, z10).l(h0Var, jVar);
    }

    /* access modifiers changed from: package-private */
    public List l(h0 h0Var, j jVar) {
        Map j10 = j(h0Var, jVar, (Map) null);
        if (j10 == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(j10.size());
        for (a a10 : j10.values()) {
            arrayList.add(a10.a());
        }
        return arrayList;
    }
}
