package com.alibaba.fastjson;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class JSONArray extends JSON implements List<Object>, Cloneable, RandomAccess, Serializable {
    protected transient Type componentType;
    private final List<Object> list;
    protected transient Object relatedArray;

    public JSONArray() {
        this.list = new ArrayList(10);
    }

    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    public boolean addAll(Collection<? extends Object> collection) {
        return this.list.addAll(collection);
    }

    public void clear() {
        this.list.clear();
    }

    public Object clone() {
        return new JSONArray((List<Object>) new ArrayList(this.list));
    }

    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    public Object get(int i10) {
        return this.list.get(i10);
    }

    public BigDecimal getBigDecimal(int i10) {
        return TypeUtils.castToBigDecimal(get(i10));
    }

    public BigInteger getBigInteger(int i10) {
        return TypeUtils.castToBigInteger(get(i10));
    }

    public Boolean getBoolean(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return null;
        }
        return TypeUtils.castToBoolean(obj);
    }

    public boolean getBooleanValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return false;
        }
        return TypeUtils.castToBoolean(obj).booleanValue();
    }

    public Byte getByte(int i10) {
        return TypeUtils.castToByte(get(i10));
    }

    public byte getByteValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.castToByte(obj).byteValue();
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public Date getDate(int i10) {
        return TypeUtils.castToDate(get(i10));
    }

    public Double getDouble(int i10) {
        return TypeUtils.castToDouble(get(i10));
    }

    public double getDoubleValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0.0d;
        }
        return TypeUtils.castToDouble(obj).doubleValue();
    }

    public Float getFloat(int i10) {
        return TypeUtils.castToFloat(get(i10));
    }

    public float getFloatValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0.0f;
        }
        return TypeUtils.castToFloat(obj).floatValue();
    }

    public int getIntValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.castToInt(obj).intValue();
    }

    public Integer getInteger(int i10) {
        return TypeUtils.castToInt(get(i10));
    }

    public JSONArray getJSONArray(int i10) {
        Object obj = this.list.get(i10);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        return (JSONArray) JSON.toJSON(obj);
    }

    public JSONObject getJSONObject(int i10) {
        Object obj = this.list.get(i10);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        return (JSONObject) JSON.toJSON(obj);
    }

    public Long getLong(int i10) {
        return TypeUtils.castToLong(get(i10));
    }

    public long getLongValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.castToLong(obj).longValue();
    }

    public <T> T getObject(int i10, Class<T> cls) {
        return TypeUtils.castToJavaBean(this.list.get(i10), cls);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public Short getShort(int i10) {
        return TypeUtils.castToShort(get(i10));
    }

    public short getShortValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.castToShort(obj).shortValue();
    }

    public String getString(int i10) {
        return TypeUtils.castToString(get(i10));
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    public Object set(int i10, Object obj) {
        return this.list.set(i10, obj);
    }

    public void setComponentType(Type type) {
        this.componentType = type;
    }

    public void setRelatedArray(Object obj) {
        this.relatedArray = obj;
    }

    public int size() {
        return this.list.size();
    }

    public List<Object> subList(int i10, int i11) {
        return this.list.subList(i10, i11);
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public void add(int i10, Object obj) {
        this.list.add(i10, obj);
    }

    public boolean addAll(int i10, Collection<? extends Object> collection) {
        return this.list.addAll(i10, collection);
    }

    public ListIterator<Object> listIterator(int i10) {
        return this.list.listIterator(i10);
    }

    public Object remove(int i10) {
        return this.list.remove(i10);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.list.toArray(tArr);
    }

    public JSONArray(List<Object> list2) {
        this.list = list2;
    }

    public JSONArray(int i10) {
        this.list = new ArrayList(i10);
    }
}
