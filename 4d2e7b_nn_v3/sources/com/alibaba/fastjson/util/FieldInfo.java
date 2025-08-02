package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class FieldInfo implements Comparable<FieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    private int ordinal;
    public final int serialzeFeatures;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field2, int i10, int i11) {
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field2;
        this.ordinal = i10;
        this.serialzeFeatures = i11;
        this.isEnum = cls2.isEnum() && !JSONAware.class.isAssignableFrom(cls2);
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        if (field2 != null) {
            int modifiers = field2.getModifiers();
            this.fieldAccess = true;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        this.getOnly = false;
        long j10 = -3750763034362895579L;
        for (int i12 = 0; i12 < str.length(); i12++) {
            j10 = (j10 ^ ((long) str.charAt(i12))) * 1099511628211L;
        }
        this.nameHashCode = j10;
        this.format = null;
        this.alternateNames = new String[0];
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        ParameterizedType parameterizedType;
        TypeVariable[] typeVariableArr;
        if (!(cls == null || type == null)) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType2 = getFieldType(cls, type, genericComponentType);
                if (genericComponentType != fieldType2) {
                    return Array.newInstance(TypeUtils.getClass(fieldType2), 0).getClass();
                }
                return type2;
            } else if (!TypeUtils.isGenericParamType(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                    Class<?> cls2 = TypeUtils.getClass(parameterizedType2);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    for (int i10 = 0; i10 < cls2.getTypeParameters().length; i10++) {
                        if (cls2.getTypeParameters()[i10].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i10];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    Type[] typeArr = null;
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeVariableArr = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeVariableArr = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeVariableArr = null;
                        parameterizedType = null;
                    }
                    boolean z10 = false;
                    for (int i11 = 0; i11 < actualTypeArguments.length && parameterizedType != null; i11++) {
                        Type type3 = actualTypeArguments[i11];
                        if (type3 instanceof TypeVariable) {
                            TypeVariable typeVariable2 = (TypeVariable) type3;
                            for (int i12 = 0; i12 < typeVariableArr.length; i12++) {
                                if (typeVariableArr[i12].getName().equals(typeVariable2.getName())) {
                                    if (typeArr == null) {
                                        typeArr = parameterizedType.getActualTypeArguments();
                                    }
                                    actualTypeArguments[i11] = typeArr[i12];
                                    z10 = true;
                                }
                            }
                        }
                    }
                    if (z10) {
                        return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                    }
                }
            }
        }
        return type2;
    }

    public boolean equals(FieldInfo fieldInfo) {
        if (fieldInfo == this || compareTo(fieldInfo) == 0) {
            return true;
        }
        return false;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        if (this.fieldAccess) {
            return this.field.get(obj);
        }
        return this.method.invoke(obj, (Object[]) null);
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        if (jSONField != null) {
            return jSONField;
        }
        return this.methodAnnotation;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method2 = this.method;
        if (method2 != null) {
            method2.invoke(obj, new Object[]{obj2});
            return;
        }
        this.field.set(obj, obj2);
    }

    public String toString() {
        return this.name;
    }

    public int compareTo(FieldInfo fieldInfo) {
        int i10 = this.ordinal;
        int i11 = fieldInfo.ordinal;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        return this.name.compareTo(fieldInfo.name);
    }

    public FieldInfo(String str, Method method2, Field field2, Class<?> cls, Type type, int i10, int i11, JSONField jSONField, JSONField jSONField2, boolean z10) {
        String str2;
        Class<?> cls2;
        Type type2;
        Type genericReturnType;
        this.name = str;
        this.method = method2;
        this.field = field2;
        this.ordinal = i10;
        this.methodAnnotation = jSONField;
        this.fieldAnnotation = jSONField2;
        this.serialzeFeatures = i11;
        JSONField annotation = getAnnotation();
        boolean z11 = false;
        Type type3 = null;
        if (annotation != null) {
            str2 = annotation.format();
            str2 = str2.trim().length() == 0 ? null : str2;
            this.alternateNames = annotation.alternateNames();
        } else {
            this.alternateNames = new String[0];
            str2 = null;
        }
        this.format = str2;
        if (field2 != null) {
            int modifiers = field2.getModifiers();
            this.fieldAccess = method2 == null || ((modifiers & 1) != 0 && method2.getReturnType() == field2.getType());
            this.fieldTransient = (modifiers & 128) != 0;
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        long j10 = -3750763034362895579L;
        for (int i12 = 0; i12 < str.length(); i12++) {
            j10 = (j10 ^ ((long) str.charAt(i12))) * 1099511628211L;
        }
        this.nameHashCode = j10;
        Class<String> cls3 = String.class;
        if (method2 != null) {
            Class<?>[] parameterTypes = method2.getParameterTypes();
            Class<Class> cls4 = Class.class;
            if (parameterTypes.length == 1) {
                cls2 = parameterTypes[0];
                type2 = (cls2 == cls4 || cls2 == cls3 || cls2.isPrimitive() || !z10) ? cls2 : method2.getGenericParameterTypes()[0];
                this.getOnly = false;
            } else {
                cls2 = method2.getReturnType();
                if (cls2 != cls4 && z10) {
                    genericReturnType = method2.getGenericReturnType();
                } else {
                    genericReturnType = cls2;
                }
                this.getOnly = true;
            }
            this.declaringClass = method2.getDeclaringClass();
        } else {
            Class<?> type4 = field2.getType();
            type2 = (type4.isPrimitive() || type4 == cls3 || type4.isEnum() || !z10) ? type4 : field2.getGenericType();
            this.declaringClass = field2.getDeclaringClass();
            this.getOnly = Modifier.isFinal(field2.getModifiers());
            cls2 = type4;
        }
        Class<JSONAware> cls5 = JSONAware.class;
        if (cls != null && cls2 == (r13 = Object.class) && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type[] actualTypeArguments = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
            Class<?> cls6 = cls;
            while (cls6 != null && cls6 != r13 && cls6 != this.declaringClass) {
                Type genericSuperclass = cls6.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    TypeUtils.getArgument(actualTypeArguments2, cls6.getTypeParameters(), actualTypeArguments);
                    actualTypeArguments = actualTypeArguments2;
                }
                cls6 = cls6.getSuperclass();
            }
            if (actualTypeArguments != null) {
                TypeVariable[] typeParameters = this.declaringClass.getTypeParameters();
                int i13 = 0;
                while (true) {
                    if (i13 >= typeParameters.length) {
                        break;
                    } else if (typeVariable.equals(typeParameters[i13])) {
                        type3 = actualTypeArguments[i13];
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            if (type3 != null) {
                this.fieldClass = TypeUtils.getClass(type3);
                this.fieldType = type3;
                if (cls2.isEnum() && !cls5.isAssignableFrom(cls2)) {
                    z11 = true;
                }
                this.isEnum = z11;
                return;
            }
        }
        if (!(type2 instanceof Class)) {
            Type fieldType2 = getFieldType(cls, type == null ? cls : type, type2);
            if (fieldType2 != type2) {
                if (fieldType2 instanceof ParameterizedType) {
                    cls2 = TypeUtils.getClass(fieldType2);
                } else if (fieldType2 instanceof Class) {
                    cls2 = TypeUtils.getClass(fieldType2);
                }
            }
            type2 = fieldType2;
        }
        this.fieldType = type2;
        this.fieldClass = cls2;
        if (!cls2.isArray() && cls2.isEnum() && !cls5.isAssignableFrom(cls2)) {
            z11 = true;
        }
        this.isEnum = z11;
    }
}
