package io.jsonwebtoken.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public final class Collections {

    private static class EnumerationIterator<E> implements Iterator<E> {
        private Enumeration<E> enumeration;

        public EnumerationIterator(Enumeration<E> enumeration2) {
            this.enumeration = enumeration2;
        }

        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }

        public E next() {
            return this.enumeration.nextElement();
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    private Collections() {
    }

    public static List arrayToList(Object obj) {
        return Arrays.asList(Objects.toObjectArray(obj));
    }

    public static boolean contains(Iterator it, Object obj) {
        if (it == null) {
            return false;
        }
        while (it.hasNext()) {
            if (Objects.nullSafeEquals(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsAny(Collection collection, Collection collection2) {
        if (!isEmpty(collection) && !isEmpty(collection2)) {
            for (Object contains : collection2) {
                if (collection.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsInstance(Collection collection, Object obj) {
        if (collection == null) {
            return false;
        }
        for (Object obj2 : collection) {
            if (obj2 == obj) {
                return true;
            }
        }
        return false;
    }

    public static Class<?> findCommonElementType(Collection collection) {
        if (isEmpty(collection)) {
            return null;
        }
        Class<?> cls = null;
        for (Object next : collection) {
            if (next != null) {
                if (cls == null) {
                    cls = next.getClass();
                } else if (cls != next.getClass()) {
                    return null;
                }
            }
        }
        return cls;
    }

    public static Object findFirstMatch(Collection collection, Collection collection2) {
        if (!isEmpty(collection) && !isEmpty(collection2)) {
            for (Object next : collection2) {
                if (collection.contains(next)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static <T> T findValueOfType(Collection<?> collection, Class<T> cls) {
        if (isEmpty((Collection) collection)) {
            return null;
        }
        T t10 = null;
        for (T next : collection) {
            if (cls == null || cls.isInstance(next)) {
                if (t10 != null) {
                    return null;
                }
                t10 = next;
            }
        }
        return t10;
    }

    public static boolean hasUniqueObject(Collection collection) {
        if (isEmpty(collection)) {
            return false;
        }
        Object obj = null;
        boolean z10 = false;
        for (Object next : collection) {
            if (!z10) {
                obj = next;
                z10 = true;
            } else if (obj != next) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static void mergeArrayIntoCollection(Object obj, Collection collection) {
        if (collection != null) {
            for (Object add : Objects.toObjectArray(obj)) {
                collection.add(add);
            }
            return;
        }
        throw new IllegalArgumentException("Collection must not be null");
    }

    public static void mergePropertiesIntoMap(Properties properties, Map map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null");
        } else if (properties != null) {
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                Object property = properties.getProperty(str);
                if (property == null) {
                    property = properties.get(str);
                }
                map.put(str, property);
            }
        }
    }

    public static int size(Collection collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] aArr) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList.toArray(aArr);
    }

    public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
        return new EnumerationIterator(enumeration);
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static int size(Map map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static boolean contains(Enumeration enumeration, Object obj) {
        if (enumeration == null) {
            return false;
        }
        while (enumeration.hasMoreElements()) {
            if (Objects.nullSafeEquals(enumeration.nextElement(), obj)) {
                return true;
            }
        }
        return false;
    }

    public static Object findValueOfType(Collection<?> collection, Class<?>[] clsArr) {
        if (!isEmpty((Collection) collection) && !Objects.isEmpty((Object[]) clsArr)) {
            for (Class<?> findValueOfType : clsArr) {
                Object findValueOfType2 = findValueOfType(collection, findValueOfType);
                if (findValueOfType2 != null) {
                    return findValueOfType2;
                }
            }
        }
        return null;
    }
}
