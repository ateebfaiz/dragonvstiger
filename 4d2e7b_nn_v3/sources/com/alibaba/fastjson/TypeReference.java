package com.alibaba.fastjson;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeReference<T> {
    static ConcurrentMap<Type, Type> classTypeCache = new ConcurrentHashMap(16, 0.75f, 1);
    protected final Type type;

    protected TypeReference() {
        Type type2 = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            this.type = type2;
            return;
        }
        Type type3 = classTypeCache.get(type2);
        if (type3 == null) {
            classTypeCache.putIfAbsent(type2, type2);
            type3 = classTypeCache.get(type2);
        }
        this.type = type3;
    }

    private Type handlerParameterizedType(ParameterizedType parameterizedType, Type[] typeArr, int i10) {
        Class<?> cls = getClass();
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
            if ((actualTypeArguments[i11] instanceof TypeVariable) && i10 < typeArr.length) {
                actualTypeArguments[i11] = typeArr[i10];
                i10++;
            }
            Type type2 = actualTypeArguments[i11];
            if (type2 instanceof GenericArrayType) {
                actualTypeArguments[i11] = TypeUtils.checkPrimitiveArray((GenericArrayType) type2);
            }
            Type type3 = actualTypeArguments[i11];
            if (type3 instanceof ParameterizedType) {
                return handlerParameterizedType((ParameterizedType) type3, typeArr, i10);
            }
        }
        return new ParameterizedTypeImpl(actualTypeArguments, cls, rawType);
    }

    public Type getType() {
        return this.type;
    }

    protected TypeReference(Type... typeArr) {
        Class<?> cls = getClass();
        ParameterizedType parameterizedType = (ParameterizedType) ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int i10 = 0;
        for (int i11 = 0; i11 < actualTypeArguments.length; i11++) {
            if ((actualTypeArguments[i11] instanceof TypeVariable) && i10 < typeArr.length) {
                actualTypeArguments[i11] = typeArr[i10];
                i10++;
            }
            Type type2 = actualTypeArguments[i11];
            if (type2 instanceof GenericArrayType) {
                actualTypeArguments[i11] = TypeUtils.checkPrimitiveArray((GenericArrayType) type2);
            }
            Type type3 = actualTypeArguments[i11];
            if (type3 instanceof ParameterizedType) {
                actualTypeArguments[i11] = handlerParameterizedType((ParameterizedType) type3, typeArr, i10);
            }
        }
        ParameterizedTypeImpl parameterizedTypeImpl = new ParameterizedTypeImpl(actualTypeArguments, cls, rawType);
        Type type4 = classTypeCache.get(parameterizedTypeImpl);
        if (type4 == null) {
            classTypeCache.putIfAbsent(parameterizedTypeImpl, parameterizedTypeImpl);
            type4 = classTypeCache.get(parameterizedTypeImpl);
        }
        this.type = type4;
    }
}
