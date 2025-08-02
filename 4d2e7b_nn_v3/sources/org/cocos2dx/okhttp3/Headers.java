package org.cocos2dx.okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.http.HttpDate;

public final class Headers {
    private final String[] namesAndValues;

    Headers(Builder builder) {
        List<String> list = builder.namesAndValues;
        this.namesAndValues = (String[]) list.toArray(new String[list.size()]);
    }

    static void checkName(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i10);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    static void checkValue(String str, String str2) {
        if (str != null) {
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                char charAt = str.charAt(i10);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i10++;
                } else {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    public static Headers of(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int i10 = 0;
            while (i10 < strArr2.length) {
                String str = strArr2[i10];
                if (str != null) {
                    strArr2[i10] = str.trim();
                    i10++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            for (int i11 = 0; i11 < strArr2.length; i11 += 2) {
                String str2 = strArr2[i11];
                String str3 = strArr2[i11 + 1];
                checkName(str2);
                checkValue(str3, str2);
            }
            return new Headers(strArr2);
        } else {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
    }

    public long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = (long) (strArr.length * 2);
        int length2 = strArr.length;
        for (int i10 = 0; i10 < length2; i10++) {
            length += (long) this.namesAndValues[i10].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Headers) || !Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues)) {
            return false;
        }
        return true;
    }

    public String get(String str) {
        return get(this.namesAndValues, str);
    }

    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public String name(int i10) {
        return this.namesAndValues[i10 * 2];
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(name(i10));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String lowerCase = name(i10).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i10));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append(name(i10));
            sb2.append(": ");
            sb2.append(value(i10));
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public String value(int i10) {
        return this.namesAndValues[(i10 * 2) + 1];
    }

    public List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(name(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i10));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public static final class Builder {
        final List<String> namesAndValues = new ArrayList(20);

        public Builder add(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        public Builder addAll(Headers headers) {
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                addLenient(headers.name(i10), headers.value(i10));
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder addLenient(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return addLenient(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return addLenient("", str.substring(1));
            }
            return addLenient("", str);
        }

        public Builder addUnsafeNonAscii(String str, String str2) {
            Headers.checkName(str);
            return addLenient(str, str2);
        }

        public Headers build() {
            return new Headers(this);
        }

        public String get(String str) {
            for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                    return this.namesAndValues.get(size + 1);
                }
            }
            return null;
        }

        public Builder removeAll(String str) {
            int i10 = 0;
            while (i10 < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(i10))) {
                    this.namesAndValues.remove(i10);
                    this.namesAndValues.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public Builder set(String str, Date date) {
            if (date != null) {
                set(str, HttpDate.format(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        public Builder set(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }

        public Builder add(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            return addLenient(str, str2);
        }

        /* access modifiers changed from: package-private */
        public Builder addLenient(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }

        public Builder add(String str, Date date) {
            if (date != null) {
                add(str, HttpDate.format(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }
    }

    private static String get(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static Headers of(Map<String, String> map) {
        if (map != null) {
            String[] strArr = new String[(map.size() * 2)];
            int i10 = 0;
            for (Map.Entry next : map.entrySet()) {
                if (next.getKey() == null || next.getValue() == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                String trim = ((String) next.getKey()).trim();
                String trim2 = ((String) next.getValue()).trim();
                checkName(trim);
                checkValue(trim2, trim);
                strArr[i10] = trim;
                strArr[i10 + 1] = trim2;
                i10 += 2;
            }
            return new Headers(strArr);
        }
        throw new NullPointerException("headers == null");
    }
}
