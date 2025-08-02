package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class JSONObject extends JSON implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
    private final Map<String, Object> map;

    public JSONObject() {
        this(16, false);
    }

    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        return new JSONObject((Map<String, Object>) new LinkedHashMap(this.map));
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public BigDecimal getBigDecimal(String str) {
        return TypeUtils.castToBigDecimal(get(str));
    }

    public BigInteger getBigInteger(String str) {
        return TypeUtils.castToBigInteger(get(str));
    }

    public Boolean getBoolean(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return TypeUtils.castToBoolean(obj);
    }

    public boolean getBooleanValue(String str) {
        Boolean castToBoolean = TypeUtils.castToBoolean(get(str));
        if (castToBoolean == null) {
            return false;
        }
        return castToBoolean.booleanValue();
    }

    public Byte getByte(String str) {
        return TypeUtils.castToByte(get(str));
    }

    public byte getByteValue(String str) {
        Byte castToByte = TypeUtils.castToByte(get(str));
        if (castToByte == null) {
            return 0;
        }
        return castToByte.byteValue();
    }

    public byte[] getBytes(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return TypeUtils.castToBytes(obj);
    }

    public Date getDate(String str) {
        return TypeUtils.castToDate(get(str));
    }

    public Double getDouble(String str) {
        return TypeUtils.castToDouble(get(str));
    }

    public double getDoubleValue(String str) {
        Double castToDouble = TypeUtils.castToDouble(get(str));
        if (castToDouble == null) {
            return 0.0d;
        }
        return castToDouble.doubleValue();
    }

    public Float getFloat(String str) {
        return TypeUtils.castToFloat(get(str));
    }

    public float getFloatValue(String str) {
        Float castToFloat = TypeUtils.castToFloat(get(str));
        if (castToFloat == null) {
            return 0.0f;
        }
        return castToFloat.floatValue();
    }

    public Map<String, Object> getInnerMap() {
        return this.map;
    }

    public int getIntValue(String str) {
        Integer castToInt = TypeUtils.castToInt(get(str));
        if (castToInt == null) {
            return 0;
        }
        return castToInt.intValue();
    }

    public Integer getInteger(String str) {
        return TypeUtils.castToInt(get(str));
    }

    public JSONArray getJSONArray(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if (obj instanceof String) {
            return (JSONArray) JSON.parse((String) obj);
        }
        return (JSONArray) JSON.toJSON(obj);
    }

    public JSONObject getJSONObject(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if (obj instanceof String) {
            return JSON.parseObject((String) obj);
        }
        return (JSONObject) JSON.toJSON(obj);
    }

    public Long getLong(String str) {
        return TypeUtils.castToLong(get(str));
    }

    public long getLongValue(String str) {
        Long castToLong = TypeUtils.castToLong(get(str));
        if (castToLong == null) {
            return 0;
        }
        return castToLong.longValue();
    }

    public <T> T getObject(String str, Class<T> cls) {
        return TypeUtils.castToJavaBean(this.map.get(str), cls);
    }

    public Short getShort(String str) {
        return TypeUtils.castToShort(get(str));
    }

    public short getShortValue(String str) {
        Short castToShort = TypeUtils.castToShort(get(str));
        if (castToShort == null) {
            return 0;
        }
        return castToShort.shortValue();
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String str;
        Class[] parameterTypes = method.getParameterTypes();
        Class cls = JSONField.class;
        String str2 = null;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() == Void.TYPE) {
                JSONField jSONField = (JSONField) method.getAnnotation(cls);
                if (jSONField == null || jSONField.name().length() == 0) {
                    str = null;
                } else {
                    str = jSONField.name();
                }
                if (str == null) {
                    String name = method.getName();
                    if (name.startsWith("set")) {
                        String substring = name.substring(3);
                        if (substring.length() != 0) {
                            str = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                        } else {
                            throw new JSONException("illegal setter");
                        }
                    } else {
                        throw new JSONException("illegal setter");
                    }
                }
                this.map.put(str, objArr[0]);
                return null;
            }
            throw new JSONException("illegal setter");
        } else if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        } else if (method.getReturnType() != Void.TYPE) {
            JSONField jSONField2 = (JSONField) method.getAnnotation(cls);
            if (!(jSONField2 == null || jSONField2.name().length() == 0)) {
                str2 = jSONField2.name();
            }
            if (str2 == null) {
                String name2 = method.getName();
                if (name2.startsWith("get")) {
                    String substring2 = name2.substring(3);
                    if (substring2.length() != 0) {
                        str2 = Character.toLowerCase(substring2.charAt(0)) + substring2.substring(1);
                    } else {
                        throw new JSONException("illegal getter");
                    }
                } else if (name2.startsWith("is")) {
                    String substring3 = name2.substring(2);
                    if (substring3.length() != 0) {
                        str2 = Character.toLowerCase(substring3.charAt(0)) + substring3.substring(1);
                    } else {
                        throw new JSONException("illegal getter");
                    }
                } else if (name2.startsWith("hashCode")) {
                    return Integer.valueOf(hashCode());
                } else {
                    if (name2.startsWith("toString")) {
                        return toString();
                    }
                    throw new JSONException("illegal getter");
                }
            }
            return TypeUtils.cast(this.map.get(str2), method.getGenericReturnType(), ParserConfig.global);
        } else {
            throw new JSONException("illegal getter");
        }
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public void putAll(Map<? extends String, ? extends Object> map2) {
        this.map.putAll(map2);
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    public int size() {
        return this.map.size();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public JSONObject(Map<String, Object> map2) {
        this.map = map2;
    }

    public Object put(String str, Object obj) {
        return this.map.put(str, obj);
    }

    public <T> T getObject(String str, Class<T> cls, Feature... featureArr) {
        Object obj = this.map.get(str);
        int i10 = JSON.DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i10 |= feature.mask;
        }
        return TypeUtils.cast(obj, cls, ParserConfig.global, i10);
    }

    public JSONObject(boolean z10) {
        this(16, z10);
    }

    public JSONObject(int i10) {
        this(i10, false);
    }

    public JSONObject(int i10, boolean z10) {
        if (z10) {
            this.map = new LinkedHashMap(i10);
        } else {
            this.map = new HashMap(i10);
        }
    }
}
