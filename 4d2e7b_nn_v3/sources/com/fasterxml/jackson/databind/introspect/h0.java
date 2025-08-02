package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.n;
import com.fasterxml.jackson.databind.type.o;
import java.lang.reflect.Type;

public interface h0 {

    public static class a implements h0 {

        /* renamed from: a  reason: collision with root package name */
        private final o f5355a;

        /* renamed from: b  reason: collision with root package name */
        private final n f5356b;

        public a(o oVar, n nVar) {
            this.f5355a = oVar;
            this.f5356b = nVar;
        }

        public j a(Type type) {
            return this.f5355a.H(type, this.f5356b);
        }
    }

    j a(Type type);
}
