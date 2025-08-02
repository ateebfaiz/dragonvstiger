package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public abstract class FieldDeserializer {
    public final Class<?> clazz;
    protected long[] enumNameHashCodes;
    protected Enum[] enums;
    public final FieldInfo fieldInfo;

    public FieldDeserializer(Class<?> cls, FieldInfo fieldInfo2, int i10) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo2;
        if (fieldInfo2 != null) {
            Class<?> cls2 = fieldInfo2.fieldClass;
            if (cls2.isEnum()) {
                Enum[] enumArr = (Enum[]) cls2.getEnumConstants();
                int length = enumArr.length;
                long[] jArr = new long[length];
                this.enumNameHashCodes = new long[enumArr.length];
                for (int i11 = 0; i11 < enumArr.length; i11++) {
                    String name = enumArr[i11].name();
                    long j10 = -3750763034362895579L;
                    for (int i12 = 0; i12 < name.length(); i12++) {
                        j10 = (j10 ^ ((long) name.charAt(i12))) * 1099511628211L;
                    }
                    jArr[i11] = j10;
                    this.enumNameHashCodes[i11] = j10;
                }
                Arrays.sort(this.enumNameHashCodes);
                this.enums = new Enum[enumArr.length];
                for (int i13 = 0; i13 < this.enumNameHashCodes.length; i13++) {
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length) {
                            break;
                        } else if (this.enumNameHashCodes[i13] == jArr[i14]) {
                            this.enums[i13] = enumArr[i14];
                            break;
                        } else {
                            i14++;
                        }
                    }
                }
            }
        }
    }

    public Enum getEnumByHashCode(long j10) {
        int binarySearch;
        if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j10)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public void setValue(Object obj, int i10) throws IllegalAccessException {
        this.fieldInfo.field.setInt(obj, i10);
    }

    public void setValue(Object obj, long j10) throws IllegalAccessException {
        this.fieldInfo.field.setLong(obj, j10);
    }

    public void setValue(Object obj, float f10) throws IllegalAccessException {
        this.fieldInfo.field.setFloat(obj, f10);
    }

    public void setValue(Object obj, double d10) throws IllegalAccessException {
        this.fieldInfo.field.setDouble(obj, d10);
    }

    public void setValue(Object obj, Object obj2) {
        if (obj2 != null || !this.fieldInfo.fieldClass.isPrimitive()) {
            FieldInfo fieldInfo2 = this.fieldInfo;
            Field field = fieldInfo2.field;
            Method method = fieldInfo2.method;
            try {
                Class<Map> cls = Map.class;
                if (fieldInfo2.fieldAccess) {
                    if (!fieldInfo2.getOnly) {
                        field.set(obj, obj2);
                    } else if (cls.isAssignableFrom(fieldInfo2.fieldClass)) {
                        Map map = (Map) field.get(obj);
                        if (map != null) {
                            map.putAll((Map) obj2);
                        }
                    } else {
                        Collection collection = (Collection) field.get(obj);
                        if (collection != null) {
                            collection.addAll((Collection) obj2);
                        }
                    }
                } else if (!fieldInfo2.getOnly) {
                    method.invoke(obj, new Object[]{obj2});
                } else if (cls.isAssignableFrom(fieldInfo2.fieldClass)) {
                    Map map2 = (Map) method.invoke(obj, (Object[]) null);
                    if (map2 != null) {
                        map2.putAll((Map) obj2);
                    }
                } else {
                    Collection collection2 = (Collection) method.invoke(obj, (Object[]) null);
                    if (collection2 != null) {
                        collection2.addAll((Collection) obj2);
                    }
                }
            } catch (Exception e10) {
                throw new JSONException("set property error, " + this.fieldInfo.name, e10);
            }
        }
    }
}
