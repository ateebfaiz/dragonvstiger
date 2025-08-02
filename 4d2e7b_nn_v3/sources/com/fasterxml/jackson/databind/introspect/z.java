package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.h0;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.n;
import com.fasterxml.jackson.databind.type.o;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Objects;

abstract class z {
    static n a(Method method, j jVar, h0 h0Var) {
        j k10;
        TypeVariable b10;
        TypeVariable[] typeParameters = method.getTypeParameters();
        if (typeParameters.length == 0 || jVar.k().n()) {
            return null;
        }
        Type genericReturnType = method.getGenericReturnType();
        if (!(genericReturnType instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
        if (!Objects.equals(jVar.s(), parameterizedType.getRawType())) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        ArrayList arrayList2 = new ArrayList(typeParameters.length);
        for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
            TypeVariable d10 = d(actualTypeArguments[i10]);
            if (d10 != null) {
                String name = d10.getName();
                if (name == null || (k10 = jVar.k().k(i10)) == null || (b10 = b(typeParameters, name)) == null) {
                    return null;
                }
                if (!g(h0Var, k10, b10.getBounds())) {
                    continue;
                } else {
                    int indexOf = arrayList.indexOf(name);
                    if (indexOf != -1) {
                        j jVar2 = (j) arrayList2.get(indexOf);
                        if (k10.equals(jVar2)) {
                            continue;
                        } else {
                            boolean L = jVar2.L(k10.s());
                            boolean L2 = k10.L(jVar2.s());
                            if (!L && !L2) {
                                return null;
                            }
                            if ((L ^ L2) && L2) {
                                arrayList2.set(indexOf, k10);
                            }
                        }
                    } else {
                        arrayList.add(name);
                        arrayList2.add(k10);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return n.e(arrayList, arrayList2);
    }

    private static TypeVariable b(TypeVariable[] typeVariableArr, String str) {
        if (!(typeVariableArr == null || str == null)) {
            for (TypeVariable typeVariable : typeVariableArr) {
                if (str.equals(typeVariable.getName())) {
                    return typeVariable;
                }
            }
        }
        return null;
    }

    private static ParameterizedType c(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return c(upperBounds[0]);
            }
        }
        return null;
    }

    private static TypeVariable d(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return d(upperBounds[0]);
            }
        }
        return null;
    }

    public static h0 e(Method method, j jVar, o oVar, h0 h0Var) {
        n a10 = a(method, jVar, h0Var);
        if (a10 == null) {
            return h0Var;
        }
        return new h0.a(oVar, a10);
    }

    private static boolean f(h0 h0Var, j jVar, Type type) {
        if (!jVar.L(h0Var.a(type).s())) {
            return false;
        }
        ParameterizedType c10 = c(type);
        if (c10 == null || !Objects.equals(jVar.s(), c10.getRawType())) {
            return true;
        }
        Type[] actualTypeArguments = c10.getActualTypeArguments();
        n k10 = jVar.k();
        if (k10.o() != actualTypeArguments.length) {
            return false;
        }
        for (int i10 = 0; i10 < k10.o(); i10++) {
            if (!f(h0Var, k10.k(i10), actualTypeArguments[i10])) {
                return false;
            }
        }
        return true;
    }

    private static boolean g(h0 h0Var, j jVar, Type[] typeArr) {
        for (Type f10 : typeArr) {
            if (!f(h0Var, jVar, f10)) {
                return false;
            }
        }
        return true;
    }
}
