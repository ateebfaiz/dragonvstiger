package com.sensorsdata.analytics.android.sdk.util;

import android.annotation.SuppressLint;
import android.util.LruCache;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ReflectUtil {
    @SuppressLint({"NewApi"})
    private static final LruCache<String, Class<?>> mObjectLruCache = new LruCache<>(64);
    private static final Set<String> mObjectSet = new HashSet();

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        Method method = getMethod(obj.getClass(), str, clsArr);
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T callStaticMethod(Class<?> cls, String str, Object... objArr) {
        if (cls == null) {
            return null;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        Method method = getMethod(cls, str, clsArr);
        if (method != null) {
            try {
                return method.invoke((Object) null, objArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static <T> T findField(Class<?> cls, Object obj, String... strArr) {
        Field findFieldObj = findFieldObj(cls, strArr);
        if (findFieldObj == null) {
            return null;
        }
        try {
            return findFieldObj.get(obj);
        } catch (Exception | IllegalAccessException unused) {
            return null;
        }
    }

    static Field findFieldObj(Class<?> cls, String... strArr) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    Field field = null;
                    for (int i10 = 0; i10 < strArr.length; i10++) {
                        try {
                            field = cls.getDeclaredField(strArr[i10]);
                        } catch (NoSuchFieldException unused) {
                            field = null;
                        }
                        if (field != null) {
                            break;
                        }
                    }
                    if (field == null) {
                        return null;
                    }
                    field.setAccessible(true);
                    return field;
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    static Field findFieldObjRecur(Class<?> cls, String str) {
        while (true) {
            Class<? super Object> cls2 = cls;
            if (cls2 == Object.class) {
                return null;
            }
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
            }
        }
    }

    public static <T> T findFieldRecur(Object obj, String str) {
        Field findFieldObjRecur = findFieldObjRecur(obj.getClass(), str);
        if (findFieldObjRecur == null) {
            return null;
        }
        try {
            return findFieldObjRecur.get(obj);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public static Class<?> getClassByName(String str) {
        try {
            LruCache<String, Class<?>> lruCache = mObjectLruCache;
            Class<?> cls = lruCache.get(str);
            if (cls != null || mObjectSet.contains(str)) {
                return cls;
            }
            Class<?> cls2 = Class.forName(str);
            lruCache.put(str, cls2);
            return cls2;
        } catch (ClassNotFoundException unused) {
            mObjectSet.add(str);
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Class<?> getCurrentClass(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        Class<?> cls = null;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            try {
                LruCache<String, Class<?>> lruCache = mObjectLruCache;
                Class<?> cls2 = lruCache.get(strArr[i10]);
                if (cls2 == null && !mObjectSet.contains(strArr[i10])) {
                    cls2 = Class.forName(strArr[i10]);
                    lruCache.put(strArr[i10], cls2);
                }
                cls = cls2;
            } catch (Throwable unused) {
                mObjectSet.add(strArr[i10]);
                cls = null;
            }
            if (cls != null) {
                break;
            }
        }
        return cls;
    }

    static Method getDeclaredRecur(Class<?> cls, String str, Class<?>... clsArr) {
        Class<? super Object> cls2;
        while (true) {
            Class<? super Object> cls3 = cls;
            if (cls3 == Object.class) {
                return null;
            }
            try {
                Method declaredMethod = cls3.getDeclaredMethod(str, clsArr);
                if (declaredMethod != null) {
                    return declaredMethod;
                }
                cls2 = cls3;
                cls3 = cls2;
            } catch (NoSuchMethodException unused) {
                cls2 = cls3.getSuperclass();
            }
        }
    }

    static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static boolean isInstance(Object obj, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        boolean z10 = false;
        for (String str : strArr) {
            try {
                LruCache<String, Class<?>> lruCache = mObjectLruCache;
                Class<?> cls = lruCache.get(str);
                if (cls == null && !mObjectSet.contains(str)) {
                    cls = Class.forName(str);
                    lruCache.put(str, cls);
                }
                if (cls != null) {
                    z10 = cls.isInstance(obj);
                }
            } catch (Throwable unused) {
                mObjectSet.add(str);
            }
            if (z10) {
                break;
            }
        }
        return z10;
    }

    public static <T> T findField(String[] strArr, Object obj, String... strArr2) {
        Class<?> currentClass = getCurrentClass(strArr);
        if (currentClass != null) {
            return findField(currentClass, obj, strArr2);
        }
        return null;
    }
}
