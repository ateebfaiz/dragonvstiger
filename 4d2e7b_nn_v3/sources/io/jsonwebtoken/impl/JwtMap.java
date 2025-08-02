package io.jsonwebtoken.impl;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.DateFormats;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class JwtMap implements Map<String, Object> {
    private final Map<String, Object> map;

    public JwtMap() {
        this.map = new LinkedHashMap();
    }

    private static Date parseIso8601Date(String str, String str2) throws IllegalArgumentException {
        try {
            return DateFormats.parseIso8601Date(str);
        } catch (ParseException e10) {
            throw new IllegalArgumentException("'" + str2 + "' value does not appear to be ISO-8601-formatted: " + str, e10);
        }
    }

    protected static Date toDate(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            return parseIso8601Date((String) obj, str);
        }
        throw new IllegalStateException("Cannot create Date from '" + str + "' value '" + obj + "'.");
    }

    protected static Date toSpecDate(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            obj = Long.valueOf(((Number) obj).longValue() * 1000);
        } else if (obj instanceof String) {
            try {
                obj = Long.valueOf(Long.parseLong((String) obj) * 1000);
            } catch (NumberFormatException unused) {
            }
        }
        return toDate(obj, str);
    }

    public void clear() {
        this.map.clear();
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

    /* access modifiers changed from: protected */
    public String getString(String str) {
        Object obj = get(str);
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public void putAll(Map<? extends String, ?> map2) {
        if (map2 != null) {
            for (String str : map2.keySet()) {
                put(str, (Object) map2.get(str));
            }
        }
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void setDate(String str, Date date) {
        if (date == null) {
            this.map.remove(str);
        } else {
            this.map.put(str, Long.valueOf(date.getTime() / 1000));
        }
    }

    /* access modifiers changed from: protected */
    public Object setDateAsSeconds(String str, Date date) {
        if (date == null) {
            return this.map.remove(str);
        }
        return this.map.put(str, Long.valueOf(date.getTime() / 1000));
    }

    /* access modifiers changed from: protected */
    public void setValue(String str, Object obj) {
        if (obj == null) {
            this.map.remove(str);
        } else {
            this.map.put(str, obj);
        }
    }

    public int size() {
        return this.map.size();
    }

    public String toString() {
        return this.map.toString();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public Object put(String str, Object obj) {
        if (obj == null) {
            return this.map.remove(str);
        }
        return this.map.put(str, obj);
    }

    public JwtMap(Map<String, Object> map2) {
        this();
        Assert.notNull(map2, "Map argument cannot be null.");
        putAll(map2);
    }
}
