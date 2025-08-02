package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ParameterizedTypeImpl implements ParameterizedType {
    private final Type[] actualTypeArguments;
    private final Type ownerType;
    private final Type rawType;

    public ParameterizedTypeImpl(Type[] typeArr, Type type, Type type2) {
        this.actualTypeArguments = typeArr;
        this.ownerType = type;
        this.rawType = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParameterizedTypeImpl parameterizedTypeImpl = (ParameterizedTypeImpl) obj;
        if (!Arrays.equals(this.actualTypeArguments, parameterizedTypeImpl.actualTypeArguments)) {
            return false;
        }
        Type type = this.ownerType;
        if (type == null ? parameterizedTypeImpl.ownerType != null : !type.equals(parameterizedTypeImpl.ownerType)) {
            return false;
        }
        Type type2 = this.rawType;
        Type type3 = parameterizedTypeImpl.rawType;
        if (type2 != null) {
            return type2.equals(type3);
        }
        if (type3 == null) {
            return true;
        }
        return false;
    }

    public Type[] getActualTypeArguments() {
        return this.actualTypeArguments;
    }

    public Type getOwnerType() {
        return this.ownerType;
    }

    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        int i10;
        int i11;
        Type[] typeArr = this.actualTypeArguments;
        int i12 = 0;
        if (typeArr != null) {
            i10 = Arrays.hashCode(typeArr);
        } else {
            i10 = 0;
        }
        int i13 = i10 * 31;
        Type type = this.ownerType;
        if (type != null) {
            i11 = type.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i13 + i11) * 31;
        Type type2 = this.rawType;
        if (type2 != null) {
            i12 = type2.hashCode();
        }
        return i14 + i12;
    }
}
