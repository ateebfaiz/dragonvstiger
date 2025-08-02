package com.alibaba.fastjson.util;

import com.adjust.sdk.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.pdns.o;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.c;
import kotlin.ranges.k;
import zb.e;
import zb.h;

public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    private static volatile Map<Class, String[]> kotlinIgnores = null;
    private static volatile boolean kotlinIgnores_error = false;
    private static volatile boolean kotlin_class_klass_error = false;
    private static volatile boolean kotlin_error = false;
    private static volatile Constructor kotlin_kclass_constructor = null;
    private static volatile Method kotlin_kclass_getConstructors = null;
    private static volatile Method kotlin_kfunction_getParameters = null;
    private static volatile Method kotlin_kparameter_getName = null;
    private static volatile Class kotlin_metadata = null;
    private static volatile boolean kotlin_metadata_error = false;
    private static final ConcurrentMap<String, Class<?>> mappings;
    private static boolean setAccessibleEnable = true;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(36, 0.75f, 1);
        mappings = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        concurrentHashMap.put("short", Short.TYPE);
        concurrentHashMap.put("int", Integer.TYPE);
        concurrentHashMap.put(Constants.LONG, Long.TYPE);
        concurrentHashMap.put("float", Float.TYPE);
        concurrentHashMap.put("double", Double.TYPE);
        concurrentHashMap.put("boolean", Boolean.TYPE);
        concurrentHashMap.put("char", Character.TYPE);
        Class<byte[]> cls = byte[].class;
        concurrentHashMap.put("[byte", cls);
        Class<short[]> cls2 = short[].class;
        concurrentHashMap.put("[short", cls2);
        Class<int[]> cls3 = int[].class;
        concurrentHashMap.put("[int", cls3);
        Class<long[]> cls4 = long[].class;
        concurrentHashMap.put("[long", cls4);
        Class<float[]> cls5 = float[].class;
        concurrentHashMap.put("[float", cls5);
        Class<double[]> cls6 = double[].class;
        concurrentHashMap.put("[double", cls6);
        Class<boolean[]> cls7 = boolean[].class;
        concurrentHashMap.put("[boolean", cls7);
        Class<char[]> cls8 = char[].class;
        concurrentHashMap.put("[char", cls8);
        concurrentHashMap.put("[B", cls);
        concurrentHashMap.put("[S", cls2);
        concurrentHashMap.put("[I", cls3);
        concurrentHashMap.put("[J", cls4);
        concurrentHashMap.put("[F", cls5);
        concurrentHashMap.put("[D", cls6);
        concurrentHashMap.put("[C", cls8);
        concurrentHashMap.put("[Z", cls7);
        concurrentHashMap.put("java.util.HashMap", HashMap.class);
        concurrentHashMap.put("java.util.TreeMap", TreeMap.class);
        concurrentHashMap.put("java.util.Date", Date.class);
        concurrentHashMap.put("com.alibaba.fastjson.JSONObject", JSONObject.class);
        concurrentHashMap.put("java.util.concurrent.ConcurrentHashMap", ConcurrentHashMap.class);
        concurrentHashMap.put("java.text.SimpleDateFormat", SimpleDateFormat.class);
        concurrentHashMap.put("java.lang.StackTraceElement", StackTraceElement.class);
        concurrentHashMap.put("java.lang.RuntimeException", RuntimeException.class);
    }

    public static void addMapping(String str, Class<?> cls) {
        mappings.put(str, cls);
    }

    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        return cast(obj, cls, parserConfig, 0);
    }

    public static final BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static final BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static final Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z10 = true;
            if (((Number) obj).intValue() != 1) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return JSONLexer.decodeFast(str, 0, str.length());
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new JSONException("can not cast to byte, value : " + obj);
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final Date castToDate(Object obj) {
        long j10;
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Number) {
            j10 = ((Number) obj).longValue();
        } else {
            j10 = -1;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                    str = JSON.DEFFAULT_DATE_FORMAT;
                } else if (str2.length() == 10) {
                    str = TimeUtils.YYYY_MM_DD;
                } else if (str2.length() == 19) {
                    str = o.f18139c;
                } else if (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') {
                    str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                } else {
                    str = "yyyy-MM-dd HH:mm:ss.SSS";
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                try {
                    return simpleDateFormat.parse(str2);
                } catch (ParseException unused) {
                    throw new JSONException("can not cast to Date, value : " + str2);
                }
            } else if (str2.length() == 0 || "null".equals(str2)) {
                return null;
            } else {
                j10 = Long.parseLong(str2);
            }
        }
        if (j10 >= 0) {
            return new Date(j10);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static final Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new JSONException("can not cast to double, value : " + obj);
    }

    public static final <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e10) {
            throw new JSONException("can not cast to : " + cls.getName(), e10);
        }
    }

    public static final Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new JSONException("can not cast to float, value : " + obj);
    }

    public static final Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final <T> T castToJavaBean(Object obj, Class<T> cls) {
        return cast(obj, cls, ParserConfig.global);
    }

    public static final Long castToLong(Object obj) {
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                JSONLexer jSONLexer = new JSONLexer(str);
                if (jSONLexer.scanISO8601DateIfMatch(false)) {
                    calendar = jSONLexer.calendar;
                }
                jSONLexer.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static final Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static final String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Type checkPrimitiveArray(GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String str = "[";
        while (genericComponentType instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
            str = str + str;
        }
        if (!(genericComponentType instanceof Class)) {
            return genericArrayType;
        }
        Class cls = (Class) genericComponentType;
        if (!cls.isPrimitive()) {
            return genericArrayType;
        }
        try {
            if (cls == Boolean.TYPE) {
                return Class.forName(str + "Z");
            } else if (cls == Character.TYPE) {
                return Class.forName(str + "C");
            } else if (cls == Byte.TYPE) {
                return Class.forName(str + "B");
            } else if (cls == Short.TYPE) {
                return Class.forName(str + "S");
            } else if (cls == Integer.TYPE) {
                return Class.forName(str + "I");
            } else if (cls == Long.TYPE) {
                return Class.forName(str + "J");
            } else if (cls == Float.TYPE) {
                return Class.forName(str + "F");
            } else if (cls != Double.TYPE) {
                return genericArrayType;
            } else {
                return Class.forName(str + "D");
            }
        } catch (ClassNotFoundException unused) {
            return genericArrayType;
        }
    }

    /* JADX WARNING: type inference failed for: r49v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if (r10.getReturnType().getName().equals("groovy.lang.MetaClass") != false) goto L_0x00ef;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x036e A[PHI: r0 
      PHI: (r0v54 java.lang.String) = (r0v53 java.lang.String), (r0v58 java.lang.String) binds: [B:153:0x035a, B:155:0x0362] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x04a9  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04b2 A[PHI: r0 
      PHI: (r0v31 java.lang.String) = (r0v30 java.lang.String), (r0v34 java.lang.String) binds: [B:207:0x049f, B:209:0x04a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x05c9 A[PHI: r0 
      PHI: (r0v6 java.lang.String) = (r0v5 java.lang.String), (r0v13 java.lang.String) binds: [B:253:0x05be, B:255:0x05c6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0634  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0647  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x01ad A[EDGE_INSN: B:300:0x01ad->B:88:0x01ad ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x0597 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x018d  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> r49, int r50, boolean r51, com.alibaba.fastjson.annotation.JSONType r52, java.util.Map<java.lang.String, java.lang.String> r53, boolean r54, boolean r55, boolean r56, com.alibaba.fastjson.PropertyNamingStrategy r57) {
        /*
            r11 = r49
            r12 = r50
            r13 = r52
            r14 = r53
            r15 = r57
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.reflect.Field[] r6 = r49.getDeclaredFields()
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r4 = com.alibaba.fastjson.annotation.JSONField.class
            r16 = 0
            if (r51 != 0) goto L_0x04fa
            boolean r17 = isKotlin(r49)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r11
        L_0x002a:
            if (r1 == 0) goto L_0x0097
            if (r1 == r5) goto L_0x0097
            java.lang.reflect.Method[] r2 = r1.getDeclaredMethods()
            int r3 = r2.length
            r10 = 0
        L_0x0034:
            if (r10 >= r3) goto L_0x008e
            r9 = r2[r10]
            r51 = r2
            int r2 = r9.getModifiers()
            r22 = r2 & 8
            if (r22 != 0) goto L_0x0081
            r21 = 2
            r22 = r2 & 2
            if (r22 != 0) goto L_0x007c
            r22 = r3
            r3 = r2 & 256(0x100, float:3.59E-43)
            r20 = 4
            if (r3 != 0) goto L_0x0054
            r2 = r2 & 4
            if (r2 == 0) goto L_0x0056
        L_0x0054:
            r2 = 1
            goto L_0x0088
        L_0x0056:
            java.lang.Class r2 = r9.getReturnType()
            java.lang.Class r3 = java.lang.Void.TYPE
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0054
            java.lang.Class[] r2 = r9.getParameterTypes()
            int r2 = r2.length
            if (r2 != 0) goto L_0x0054
            java.lang.Class r2 = r9.getReturnType()
            java.lang.Class<java.lang.ClassLoader> r3 = java.lang.ClassLoader.class
            if (r2 == r3) goto L_0x0054
            java.lang.Class r2 = r9.getDeclaringClass()
            if (r2 != r5) goto L_0x0078
            goto L_0x0054
        L_0x0078:
            r0.add(r9)
            goto L_0x0054
        L_0x007c:
            r22 = r3
            r20 = 4
            goto L_0x0054
        L_0x0081:
            r22 = r3
            r20 = 4
            r21 = 2
            goto L_0x0054
        L_0x0088:
            int r10 = r10 + r2
            r2 = r51
            r3 = r22
            goto L_0x0034
        L_0x008e:
            r20 = 4
            r21 = 2
            java.lang.Class r1 = r1.getSuperclass()
            goto L_0x002a
        L_0x0097:
            r20 = 4
            r21 = 2
            java.util.Iterator r22 = r0.iterator()
            r0 = r16
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x00a4:
            boolean r9 = r22.hasNext()
            if (r9 == 0) goto L_0x04fa
            java.lang.Object r9 = r22.next()
            r10 = r9
            java.lang.reflect.Method r10 = (java.lang.reflect.Method) r10
            java.lang.String r9 = r10.getName()
            r51 = r1
            java.lang.String r1 = "getMetaClass"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x00d2
            java.lang.Class r1 = r10.getReturnType()
            java.lang.String r1 = r1.getName()
            r23 = r2
            java.lang.String r2 = "groovy.lang.MetaClass"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00d4
            goto L_0x00ef
        L_0x00d2:
            r23 = r2
        L_0x00d4:
            if (r55 == 0) goto L_0x00dd
            java.lang.annotation.Annotation r1 = r10.getAnnotation(r4)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x00df
        L_0x00dd:
            r1 = r16
        L_0x00df:
            if (r1 != 0) goto L_0x00e7
            if (r55 == 0) goto L_0x00e7
            com.alibaba.fastjson.annotation.JSONField r1 = getSupperMethodAnnotation(r11, r10)
        L_0x00e7:
            if (r17 == 0) goto L_0x00f4
            boolean r2 = isKotlinIgnore(r11, r9)
            if (r2 == 0) goto L_0x00f4
        L_0x00ef:
            r1 = r51
            r2 = r23
            goto L_0x00a4
        L_0x00f4:
            java.lang.String r2 = "get"
            r24 = r5
            if (r1 != 0) goto L_0x01bc
            if (r17 == 0) goto L_0x01bc
            if (r0 != 0) goto L_0x014e
            java.lang.reflect.Constructor[] r0 = r49.getDeclaredConstructors()
            int r5 = r0.length
            r26 = r1
            r1 = 1
            if (r5 != r1) goto L_0x0147
            r5 = 0
            r1 = r0[r5]
            java.lang.annotation.Annotation[][] r3 = r1.getParameterAnnotations()
            java.lang.String[] r1 = getKoltinConstructorParameters(r49)
            if (r1 == 0) goto L_0x0140
            int r5 = r1.length
            java.lang.String[] r5 = new java.lang.String[r5]
            r27 = r0
            int r0 = r1.length
            r51 = r3
            r3 = 0
            java.lang.System.arraycopy(r1, r3, r5, r3, r0)
            java.util.Arrays.sort(r5)
            int r0 = r1.length
            short[] r0 = new short[r0]
            r28 = r4
        L_0x0129:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0138
            r4 = r1[r3]
            int r4 = java.util.Arrays.binarySearch(r5, r4)
            r0[r4] = r3
            r4 = 1
            int r3 = r3 + r4
            short r3 = (short) r3
            goto L_0x0129
        L_0x0138:
            r3 = r51
            r23 = r0
            r1 = r5
            r0 = r27
            goto L_0x0151
        L_0x0140:
            r27 = r0
            r51 = r3
            r28 = r4
            goto L_0x0151
        L_0x0147:
            r27 = r0
        L_0x0149:
            r28 = r4
            r1 = r51
            goto L_0x0151
        L_0x014e:
            r26 = r1
            goto L_0x0149
        L_0x0151:
            if (r1 == 0) goto L_0x01b2
            if (r23 == 0) goto L_0x01b2
            boolean r4 = r9.startsWith(r2)
            if (r4 == 0) goto L_0x01b2
            r4 = 3
            java.lang.String r5 = r9.substring(r4)
            java.lang.String r4 = decapitalize(r5)
            int r5 = java.util.Arrays.binarySearch(r1, r4)
            r51 = r0
            r27 = r5
            if (r5 >= 0) goto L_0x017f
            r0 = 0
        L_0x016f:
            int r5 = r1.length
            if (r0 >= r5) goto L_0x017f
            r5 = r1[r0]
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x017c
            r5 = r0
            goto L_0x0181
        L_0x017c:
            r5 = 1
            int r0 = r0 + r5
            goto L_0x016f
        L_0x017f:
            r5 = r27
        L_0x0181:
            if (r5 < 0) goto L_0x01ad
            short r0 = r23[r5]
            r0 = r3[r0]
            if (r0 == 0) goto L_0x01ad
            int r4 = r0.length
            r5 = 0
        L_0x018b:
            if (r5 >= r4) goto L_0x01ad
            r27 = r1
            r1 = r0[r5]
            r29 = r0
            boolean r0 = r1 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r0 == 0) goto L_0x01a4
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            r30 = r1
            r29 = r3
            r26 = r23
            r19 = 1
        L_0x01a1:
            r23 = r51
            goto L_0x01cc
        L_0x01a4:
            r19 = 1
            int r5 = r5 + 1
            r1 = r27
            r0 = r29
            goto L_0x018b
        L_0x01ad:
            r27 = r1
            r19 = 1
            goto L_0x01b5
        L_0x01b2:
            r51 = r0
            goto L_0x01ad
        L_0x01b5:
            r29 = r3
            r30 = r26
            r26 = r23
            goto L_0x01a1
        L_0x01bc:
            r26 = r1
            r28 = r4
            r19 = 1
            r27 = r51
            r29 = r3
            r30 = r26
            r26 = r23
            r23 = r0
        L_0x01cc:
            if (r30 == 0) goto L_0x025a
            boolean r0 = r30.serialize()
            if (r0 != 0) goto L_0x01e2
        L_0x01d4:
            r45 = r6
            r38 = r7
            r13 = r8
            r14 = r15
            r35 = r24
            r44 = r28
            r18 = 0
            goto L_0x04de
        L_0x01e2:
            int r31 = r30.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r30.serialzeFeatures()
            int r32 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            java.lang.String r0 = r30.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x024d
            java.lang.String r0 = r30.name()
            if (r14 == 0) goto L_0x0207
            java.lang.Object r0 = r14.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0207
            goto L_0x01d4
        L_0x0207:
            r9 = r0
            setAccessible(r11, r10, r12)
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r25 = 0
            r33 = 1
            r3 = 0
            r34 = 0
            r0 = r5
            r1 = r9
            r18 = 0
            r2 = r10
            r10 = r28
            r4 = r49
            r36 = r5
            r35 = r24
            r5 = r34
            r37 = r6
            r6 = r31
            r38 = r7
            r7 = r32
            r39 = r8
            r8 = r30
            r40 = r9
            r9 = r25
            r12 = r10
            r15 = r20
            r10 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = r36
            r8 = r39
            r0 = r40
            r8.put(r0, r1)
        L_0x0244:
            r14 = r57
            r13 = r8
            r44 = r12
        L_0x0249:
            r45 = r37
            goto L_0x04de
        L_0x024d:
            r37 = r6
            r38 = r7
            r15 = r20
            r35 = r24
            r12 = r28
            r18 = 0
            goto L_0x026a
        L_0x025a:
            r37 = r6
            r38 = r7
            r15 = r20
            r35 = r24
            r12 = r28
            r18 = 0
            r31 = r18
            r32 = r31
        L_0x026a:
            boolean r0 = r9.startsWith(r2)
            r7 = 102(0x66, float:1.43E-43)
            r6 = 95
            if (r0 == 0) goto L_0x03ab
            int r0 = r9.length()
            if (r0 < r15) goto L_0x03a7
            java.lang.String r0 = "getClass"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x028a
        L_0x0282:
            r14 = r57
            r13 = r8
            r44 = r12
            r20 = r15
            goto L_0x0249
        L_0x028a:
            r5 = 3
            char r0 = r9.charAt(r5)
            boolean r1 = java.lang.Character.isUpperCase(r0)
            if (r1 == 0) goto L_0x02be
            boolean r0 = compatibleWithJavaBean
            if (r0 == 0) goto L_0x02a2
            java.lang.String r0 = r9.substring(r5)
            java.lang.String r0 = decapitalize(r0)
            goto L_0x02e5
        L_0x02a2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r9.charAt(r5)
            char r1 = java.lang.Character.toLowerCase(r1)
            r0.append(r1)
            java.lang.String r1 = r9.substring(r15)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x02e5
        L_0x02be:
            if (r0 != r6) goto L_0x02c5
            java.lang.String r0 = r9.substring(r15)
            goto L_0x02e5
        L_0x02c5:
            if (r0 != r7) goto L_0x02cc
            java.lang.String r0 = r9.substring(r5)
            goto L_0x02e5
        L_0x02cc:
            int r0 = r9.length()
            r1 = 5
            if (r0 < r1) goto L_0x03a7
            char r0 = r9.charAt(r15)
            boolean r0 = java.lang.Character.isUpperCase(r0)
            if (r0 == 0) goto L_0x03a7
            java.lang.String r0 = r9.substring(r5)
            java.lang.String r0 = decapitalize(r0)
        L_0x02e5:
            boolean r1 = isJSONTypeIgnore(r11, r13, r0)
            if (r1 == 0) goto L_0x02ec
            goto L_0x0282
        L_0x02ec:
            r3 = r37
            r4 = r38
            java.lang.reflect.Field r2 = getField(r11, r0, r3, r4)
            if (r2 == 0) goto L_0x034b
            if (r55 == 0) goto L_0x02ff
            java.lang.annotation.Annotation r1 = r2.getAnnotation(r12)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x0301
        L_0x02ff:
            r1 = r16
        L_0x0301:
            if (r1 == 0) goto L_0x0343
            boolean r20 = r1.serialize()
            if (r20 != 0) goto L_0x0316
        L_0x0309:
            r14 = r57
            r45 = r3
            r38 = r4
            r13 = r8
            r44 = r12
            r20 = r15
            goto L_0x04de
        L_0x0316:
            int r31 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r20 = r1.serialzeFeatures()
            int r32 = com.alibaba.fastjson.serializer.SerializerFeature.of(r20)
            java.lang.String r20 = r1.name()
            int r20 = r20.length()
            if (r20 == 0) goto L_0x0343
            java.lang.String r0 = r1.name()
            if (r14 == 0) goto L_0x033b
            java.lang.Object r0 = r14.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x033b
            goto L_0x0309
        L_0x033b:
            r5 = r57
            r20 = r15
            r15 = r1
            r1 = r19
            goto L_0x0352
        L_0x0343:
            r5 = r57
            r20 = r15
            r15 = r1
        L_0x0348:
            r1 = r18
            goto L_0x0352
        L_0x034b:
            r5 = r57
            r20 = r15
            r15 = r16
            goto L_0x0348
        L_0x0352:
            if (r5 == 0) goto L_0x035a
            if (r1 != 0) goto L_0x035a
            java.lang.String r0 = r5.translate(r0)
        L_0x035a:
            if (r14 == 0) goto L_0x036e
            java.lang.Object r0 = r14.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x036e
            r45 = r3
            r38 = r4
            r14 = r5
            r13 = r8
            r44 = r12
            goto L_0x04de
        L_0x036e:
            r1 = r50
            r48 = r12
            r12 = r0
            r0 = r48
            setAccessible(r11, r10, r1)
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r21 = 0
            r14 = r0
            r0 = r5
            r1 = r12
            r24 = r2
            r2 = r10
            r41 = r3
            r3 = r24
            r28 = r14
            r14 = r4
            r4 = r49
            r38 = r14
            r14 = r5
            r5 = r21
            r6 = r31
            r7 = r32
            r42 = r8
            r8 = r30
            r43 = r9
            r9 = r15
            r15 = r10
            r10 = r56
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r10 = r42
            r10.put(r12, r14)
            goto L_0x03b5
        L_0x03a7:
            r20 = r15
            goto L_0x0244
        L_0x03ab:
            r43 = r9
            r28 = r12
            r20 = r15
            r41 = r37
            r15 = r10
            r10 = r8
        L_0x03b5:
            java.lang.String r0 = "is"
            r1 = r43
            boolean r0 = r1.startsWith(r0)
            if (r0 == 0) goto L_0x03c6
            int r0 = r1.length()
            r2 = 3
            if (r0 >= r2) goto L_0x03cf
        L_0x03c6:
            r14 = r57
            r13 = r10
            r44 = r28
            r45 = r41
            goto L_0x04de
        L_0x03cf:
            r12 = 2
            char r0 = r1.charAt(r12)
            boolean r2 = java.lang.Character.isUpperCase(r0)
            if (r2 == 0) goto L_0x0404
            boolean r0 = compatibleWithJavaBean
            if (r0 == 0) goto L_0x03e7
            java.lang.String r0 = r1.substring(r12)
            java.lang.String r0 = decapitalize(r0)
            goto L_0x0416
        L_0x03e7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r2 = r1.charAt(r12)
            char r2 = java.lang.Character.toLowerCase(r2)
            r0.append(r2)
            r2 = 3
            java.lang.String r2 = r1.substring(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L_0x0416
        L_0x0404:
            r2 = 3
            r3 = 95
            if (r0 != r3) goto L_0x040e
            java.lang.String r0 = r1.substring(r2)
            goto L_0x0416
        L_0x040e:
            r2 = 102(0x66, float:1.43E-43)
            if (r0 != r2) goto L_0x03c6
            java.lang.String r0 = r1.substring(r12)
        L_0x0416:
            boolean r2 = isJSONTypeIgnore(r11, r13, r0)
            if (r2 == 0) goto L_0x041d
            goto L_0x03c6
        L_0x041d:
            r14 = r38
            r9 = r41
            java.lang.reflect.Field r2 = getField(r11, r0, r9, r14)
            if (r2 != 0) goto L_0x042d
            java.lang.reflect.Field r1 = getField(r11, r1, r9, r14)
            r3 = r1
            goto L_0x042e
        L_0x042d:
            r3 = r2
        L_0x042e:
            if (r3 == 0) goto L_0x0490
            r1 = r28
            if (r55 == 0) goto L_0x043b
            java.lang.annotation.Annotation r2 = r3.getAnnotation(r1)
            com.alibaba.fastjson.annotation.JSONField r2 = (com.alibaba.fastjson.annotation.JSONField) r2
            goto L_0x043d
        L_0x043b:
            r2 = r16
        L_0x043d:
            if (r2 == 0) goto L_0x0486
            boolean r4 = r2.serialize()
            if (r4 != 0) goto L_0x0450
            r44 = r1
        L_0x0447:
            r45 = r9
            r13 = r10
            r38 = r14
            r14 = r57
            goto L_0x04de
        L_0x0450:
            int r4 = r2.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r5 = r2.serialzeFeatures()
            int r5 = com.alibaba.fastjson.serializer.SerializerFeature.of(r5)
            java.lang.String r6 = r2.name()
            int r6 = r6.length()
            if (r6 == 0) goto L_0x0482
            java.lang.String r0 = r2.name()
            r8 = r53
            r7 = r1
            if (r8 == 0) goto L_0x047a
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x047a
            r44 = r7
            goto L_0x0447
        L_0x047a:
            r21 = r2
            r6 = r4
            r32 = r5
            r5 = r57
            goto L_0x0499
        L_0x0482:
            r8 = r53
            r7 = r1
            goto L_0x047a
        L_0x0486:
            r8 = r53
            r7 = r1
            r5 = r57
            r21 = r2
        L_0x048d:
            r6 = r31
            goto L_0x0499
        L_0x0490:
            r8 = r53
            r7 = r28
            r5 = r57
            r21 = r16
            goto L_0x048d
        L_0x0499:
            if (r5 == 0) goto L_0x049f
            java.lang.String r0 = r5.translate(r0)
        L_0x049f:
            if (r8 == 0) goto L_0x04b2
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x04b2
            r44 = r7
            r45 = r9
            r13 = r10
            r38 = r14
            r14 = r5
            goto L_0x04de
        L_0x04b2:
            r2 = r50
            r4 = r0
            setAccessible(r11, r3, r2)
            setAccessible(r11, r15, r2)
            com.alibaba.fastjson.util.FieldInfo r1 = new com.alibaba.fastjson.util.FieldInfo
            r24 = 0
            r0 = r1
            r12 = r1
            r1 = r4
            r2 = r15
            r15 = r4
            r4 = r49
            r38 = r14
            r14 = r5
            r5 = r24
            r44 = r7
            r7 = r32
            r8 = r30
            r45 = r9
            r9 = r21
            r13 = r10
            r10 = r56
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r13.put(r15, r12)
        L_0x04de:
            r12 = r50
            r8 = r13
            r15 = r14
            r0 = r23
            r2 = r26
            r1 = r27
            r3 = r29
            r5 = r35
            r7 = r38
            r4 = r44
            r6 = r45
            r21 = 2
            r13 = r52
            r14 = r53
            goto L_0x00a4
        L_0x04fa:
            r44 = r4
            r35 = r5
            r45 = r6
            r13 = r8
            r14 = r15
            r18 = 0
            r19 = 1
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r45
            int r2 = r1.length
            r0.<init>(r2)
            int r2 = r1.length
            r3 = r18
        L_0x0511:
            if (r3 >= r2) goto L_0x0539
            r4 = r1[r3]
            int r5 = r4.getModifiers()
            r5 = r5 & 8
            if (r5 == 0) goto L_0x051e
            goto L_0x0536
        L_0x051e:
            java.lang.String r5 = r4.getName()
            java.lang.String r6 = "this$0"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x052b
            goto L_0x0536
        L_0x052b:
            int r5 = r4.getModifiers()
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0536
            r0.add(r4)
        L_0x0536:
            int r3 = r3 + 1
            goto L_0x0511
        L_0x0539:
            java.lang.Class r1 = r49.getSuperclass()
        L_0x053d:
            if (r1 == 0) goto L_0x056c
            r2 = r35
            if (r1 == r2) goto L_0x056c
            java.lang.reflect.Field[] r3 = r1.getDeclaredFields()
            int r4 = r3.length
            r5 = r18
        L_0x054a:
            if (r5 >= r4) goto L_0x0565
            r6 = r3[r5]
            int r7 = r6.getModifiers()
            r7 = r7 & 8
            if (r7 == 0) goto L_0x0557
            goto L_0x0562
        L_0x0557:
            int r7 = r6.getModifiers()
            r7 = r7 & 1
            if (r7 == 0) goto L_0x0562
            r0.add(r6)
        L_0x0562:
            int r5 = r5 + 1
            goto L_0x054a
        L_0x0565:
            java.lang.Class r1 = r1.getSuperclass()
            r35 = r2
            goto L_0x053d
        L_0x056c:
            java.util.Iterator r12 = r0.iterator()
        L_0x0570:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x05fb
            java.lang.Object r0 = r12.next()
            r3 = r0
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            r15 = r44
            if (r55 == 0) goto L_0x0589
            java.lang.annotation.Annotation r0 = r3.getAnnotation(r15)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            r9 = r0
            goto L_0x058b
        L_0x0589:
            r9 = r16
        L_0x058b:
            java.lang.String r0 = r3.getName()
            if (r9 == 0) goto L_0x05b9
            boolean r1 = r9.serialize()
            if (r1 != 0) goto L_0x059a
        L_0x0597:
            r44 = r15
            goto L_0x0570
        L_0x059a:
            int r1 = r9.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r9.serialzeFeatures()
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.of(r2)
            java.lang.String r4 = r9.name()
            int r4 = r4.length()
            if (r4 == 0) goto L_0x05b4
            java.lang.String r0 = r9.name()
        L_0x05b4:
            r10 = r53
            r6 = r1
            r7 = r2
            goto L_0x05be
        L_0x05b9:
            r10 = r53
            r6 = r18
            r7 = r6
        L_0x05be:
            if (r10 == 0) goto L_0x05c9
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x05c9
            goto L_0x0597
        L_0x05c9:
            if (r14 == 0) goto L_0x05cf
            java.lang.String r0 = r14.translate(r0)
        L_0x05cf:
            r8 = r0
            boolean r0 = r13.containsKey(r8)
            if (r0 != 0) goto L_0x0597
            r5 = r50
            setAccessible(r11, r3, r5)
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r17 = 0
            r20 = 0
            r2 = 0
            r0 = r4
            r1 = r8
            r46 = r4
            r4 = r49
            r5 = r17
            r47 = r8
            r8 = r20
            r10 = r56
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = r46
            r0 = r47
            r13.put(r0, r1)
            goto L_0x0597
        L_0x05fb:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r13
            if (r52 == 0) goto L_0x062f
            java.lang.String[] r2 = r52.orders()
            if (r2 == 0) goto L_0x062b
            int r3 = r2.length
            int r4 = r1.size()
            if (r3 != r4) goto L_0x062b
            int r3 = r2.length
            r4 = r18
        L_0x0613:
            if (r4 >= r3) goto L_0x0623
            r5 = r2[r4]
            boolean r5 = r1.containsKey(r5)
            if (r5 != 0) goto L_0x0620
            r3 = r18
            goto L_0x0625
        L_0x0620:
            int r4 = r4 + 1
            goto L_0x0613
        L_0x0623:
            r3 = r19
        L_0x0625:
            r48 = r3
            r3 = r2
            r2 = r48
            goto L_0x0632
        L_0x062b:
            r3 = r2
        L_0x062c:
            r2 = r18
            goto L_0x0632
        L_0x062f:
            r3 = r16
            goto L_0x062c
        L_0x0632:
            if (r2 == 0) goto L_0x0647
            int r2 = r3.length
            r4 = r18
        L_0x0637:
            if (r4 >= r2) goto L_0x0664
            r5 = r3[r4]
            java.lang.Object r5 = r1.get(r5)
            com.alibaba.fastjson.util.FieldInfo r5 = (com.alibaba.fastjson.util.FieldInfo) r5
            r0.add(r5)
            int r4 = r4 + 1
            goto L_0x0637
        L_0x0647:
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x064f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x065f
            java.lang.Object r2 = r1.next()
            com.alibaba.fastjson.util.FieldInfo r2 = (com.alibaba.fastjson.util.FieldInfo) r2
            r0.add(r2)
            goto L_0x064f
        L_0x065f:
            if (r54 == 0) goto L_0x0664
            java.util.Collections.sort(r0)
        L_0x0664:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.computeGetters(java.lang.Class, int, boolean, com.alibaba.fastjson.annotation.JSONType, java.util.Map, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Object defaultValue(Class<?> cls) {
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Character.TYPE) {
            return '0';
        }
        return null;
    }

    public static long fnv_64_lower(String str) {
        long j10 = -3750763034362895579L;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (!(charAt == '_' || charAt == '-')) {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j10 = (j10 ^ ((long) charAt)) * 1099511628211L;
            }
        }
        return j10;
    }

    public static boolean getArgument(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            ParameterizedType parameterizedType = typeArr[i10];
            if (parameterizedType instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = parameterizedType;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i10] = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    z10 = true;
                }
            } else if (parameterizedType instanceof TypeVariable) {
                for (int i11 = 0; i11 < typeVariableArr.length; i11++) {
                    if (parameterizedType.equals(typeVariableArr[i11])) {
                        typeArr[i10] = typeArr2[i11];
                        z10 = true;
                    }
                }
            }
        }
        return z10;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        if (upperBounds.length == 1) {
            return getClass(upperBounds[0]);
        }
        return Object.class;
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Type getCollectionItemType(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = getCollectionItemType(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        if (type2 == null) {
            return Object.class;
        }
        return type2;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        return getField(cls, str, fieldArr, (Map<Class<?>, Field[]>) null);
    }

    private static Field getField0(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        Field[] fieldArr2 = null;
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        if (map != null) {
            fieldArr2 = map.get(superclass);
        }
        if (fieldArr2 == null) {
            fieldArr2 = superclass.getDeclaredFields();
            if (map != null) {
                map.put(superclass, fieldArr2);
            }
        }
        return getField(superclass, str, fieldArr2, map);
    }

    public static Type getGenericParamType(Type type) {
        if (type instanceof Class) {
            return getGenericParamType(((Class) type).getGenericSuperclass());
        }
        return type;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                Class<?> cls2 = Class.forName("kotlin.reflect.jvm.internal.KClassImpl");
                kotlin_kclass_constructor = cls2.getConstructor(new Class[]{Class.class});
                kotlin_kclass_getConstructors = cls2.getMethod("getConstructors", (Class[]) null);
                kotlin_kfunction_getParameters = e.class.getMethod("getParameters", (Class[]) null);
                kotlin_kparameter_getName = h.class.getMethod("getName", (Class[]) null);
            } catch (Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null || kotlin_error) {
            return null;
        }
        try {
            Iterator it = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(new Object[]{cls}), (Object[]) null)).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) kotlin_kfunction_getParameters.invoke(next, (Object[]) null);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, (Object[]) null);
            String[] strArr = new String[list2.size()];
            for (int i10 = 0; i10 < list2.size(); i10++) {
                strArr[i10] = (String) kotlin_kparameter_getName.invoke(list2.get(i10), (Object[]) null);
            }
            return strArr;
        } catch (Throwable unused2) {
            kotlin_error = true;
            return null;
        }
    }

    public static JSONField getSupperMethodAnnotation(Class<?> cls, Method method) {
        Class[] interfaces = cls.getInterfaces();
        int length = interfaces.length;
        int i10 = 0;
        while (true) {
            Class cls2 = JSONField.class;
            if (i10 < length) {
                for (Method method2 : interfaces[i10].getMethods()) {
                    if (method2.getName().equals(method.getName())) {
                        Class[] parameterTypes = method2.getParameterTypes();
                        Class[] parameterTypes2 = method.getParameterTypes();
                        if (parameterTypes.length != parameterTypes2.length) {
                            continue;
                        } else {
                            int i11 = 0;
                            while (true) {
                                if (i11 >= parameterTypes.length) {
                                    JSONField jSONField = (JSONField) method2.getAnnotation(cls2);
                                    if (jSONField != null) {
                                        return jSONField;
                                    }
                                } else if (!parameterTypes[i11].equals(parameterTypes2[i11])) {
                                    break;
                                } else {
                                    i11++;
                                }
                            }
                        }
                    }
                }
                i10++;
            } else {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
                    Class[] parameterTypes3 = method.getParameterTypes();
                    for (Method method3 : superclass.getMethods()) {
                        Class[] parameterTypes4 = method3.getParameterTypes();
                        if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                            int i12 = 0;
                            while (true) {
                                if (i12 >= parameterTypes3.length) {
                                    JSONField jSONField2 = (JSONField) method3.getAnnotation(cls2);
                                    if (jSONField2 != null) {
                                        return jSONField2;
                                    }
                                } else if (!parameterTypes4[i12].equals(parameterTypes3[i12])) {
                                    break;
                                } else {
                                    i12++;
                                }
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    public static boolean isGenericParamType(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        if (genericSuperclass == Object.class || !isGenericParamType(genericSuperclass)) {
            return false;
        }
        return true;
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, JSONType jSONType, String str) {
        if (!(jSONType == null || jSONType.ignores() == null)) {
            for (String equalsIgnoreCase : jSONType.ignores()) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == Object.class || superclass == null || !isJSONTypeIgnore(superclass, (JSONType) superclass.getAnnotation(JSONType.class), str)) {
            return false;
        }
        return true;
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = m.class;
            } catch (Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        if (kotlin_metadata == null) {
            return false;
        }
        return cls.isAnnotationPresent(kotlin_metadata);
    }

    private static boolean isKotlinIgnore(Class cls, String str) {
        String[] strArr;
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                HashMap hashMap = new HashMap();
                c.a aVar = c.f742e;
                hashMap.put(c.class, new String[]{"getEndInclusive", "isEmpty"});
                IntRange.a aVar2 = IntRange.f732e;
                hashMap.put(IntRange.class, new String[]{"getEndInclusive", "isEmpty"});
                k.a aVar3 = k.f760e;
                hashMap.put(k.class, new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.e"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.ranges.d"), new String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = hashMap;
            } catch (Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        if (kotlinIgnores == null || (strArr = kotlinIgnores.get(cls)) == null) {
            return false;
        }
        if (Arrays.binarySearch(strArr, str) >= 0) {
            return true;
        }
        return false;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static boolean setAccessible(Class<?> cls, Member member, int i10) {
        if (member != null && setAccessibleEnable) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i10 & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
        return false;
    }

    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig, int i10) {
        T t10;
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                int i11 = 0;
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        T newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object cast : collection) {
                            Array.set(newInstance, i11, cast(cast, cls.getComponentType(), parserConfig));
                            i11++;
                        }
                        return newInstance;
                    } else if (cls == byte[].class) {
                        return castToBytes(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return castToBoolean(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return castToByte(obj);
                }
                if ((cls == Character.TYPE || cls == Character.class) && (obj instanceof String)) {
                    String str = (String) obj;
                    if (str.length() == 1) {
                        return Character.valueOf(str.charAt(0));
                    }
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return castToShort(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return castToInt(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return castToLong(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return castToFloat(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return castToDouble(obj);
                }
                if (cls == String.class) {
                    return castToString(obj);
                }
                if (cls == BigDecimal.class) {
                    return castToBigDecimal(obj);
                }
                if (cls == BigInteger.class) {
                    return castToBigInteger(obj);
                }
                if (cls == Date.class) {
                    return castToDate(obj);
                }
                if (cls.isEnum()) {
                    return castToEnum(obj, cls, parserConfig);
                }
                Class<Calendar> cls2 = Calendar.class;
                if (cls2.isAssignableFrom(cls)) {
                    Date castToDate = castToDate(obj);
                    if (cls == cls2) {
                        t10 = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    } else {
                        try {
                            t10 = (Calendar) cls.newInstance();
                        } catch (Exception e10) {
                            throw new JSONException("can not cast to : " + cls.getName(), e10);
                        }
                    }
                    t10.setTime(castToDate);
                    return t10;
                }
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() == 0 || "null".equals(str2)) {
                        return null;
                    }
                    if (cls == Currency.class) {
                        return Currency.getInstance(str2);
                    }
                }
                throw new JSONException("can not cast to : " + cls.getName());
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                    return castToJavaBean(map, cls, parserConfig, i10);
                }
                return obj;
            }
        }
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        return castToJavaBean(map, cls, parserConfig, 0);
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        Field field0 = getField0(cls, str, fieldArr, map);
        if (field0 == null) {
            field0 = getField0(cls, "_" + str, fieldArr, map);
        }
        if (field0 == null) {
            field0 = getField0(cls, "m_" + str, fieldArr, map);
        }
        if (field0 != null) {
            return field0;
        }
        return getField0(cls, "m" + str.substring(0, 1).toUpperCase() + str.substring(1), fieldArr, map);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:(4:23|24|(1:26)|27)|28|29|(3:32|(1:34)|35)|(3:36|37|42)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x007e */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078 A[Catch:{ Exception -> 0x007e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> loadClass(java.lang.String r7, java.lang.ClassLoader r8, boolean r9) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x009f
            int r1 = r7.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x009f
        L_0x000b:
            int r1 = r7.length()
            r2 = 256(0x100, float:3.59E-43)
            if (r1 >= r2) goto L_0x0088
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r1 = mappings
            java.lang.Object r2 = r1.get(r7)
            java.lang.Class r2 = (java.lang.Class) r2
            if (r2 == 0) goto L_0x001e
            return r2
        L_0x001e:
            r3 = 0
            char r4 = r7.charAt(r3)
            r5 = 91
            r6 = 1
            if (r4 != r5) goto L_0x003c
            java.lang.String r7 = r7.substring(r6)
            java.lang.Class r7 = loadClass(r7, r8, r3)
            if (r7 != 0) goto L_0x0033
            return r0
        L_0x0033:
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r7, r3)
            java.lang.Class r7 = r7.getClass()
            return r7
        L_0x003c:
            java.lang.String r0 = "L"
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto L_0x005a
            java.lang.String r0 = ";"
            boolean r0 = r7.endsWith(r0)
            if (r0 == 0) goto L_0x005a
            int r9 = r7.length()
            int r9 = r9 - r6
            java.lang.String r7 = r7.substring(r6, r9)
            java.lang.Class r7 = loadClass(r7, r8, r3)
            return r7
        L_0x005a:
            if (r8 == 0) goto L_0x0066
            java.lang.Class r2 = r8.loadClass(r7)     // Catch:{ Exception -> 0x0066 }
            if (r9 == 0) goto L_0x0065
            r1.put(r7, r2)     // Catch:{ Exception -> 0x0066 }
        L_0x0065:
            return r2
        L_0x0066:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x007e }
            java.lang.ClassLoader r0 = r0.getContextClassLoader()     // Catch:{ Exception -> 0x007e }
            if (r0 == 0) goto L_0x007e
            if (r0 == r8) goto L_0x007e
            java.lang.Class r2 = r0.loadClass(r7)     // Catch:{ Exception -> 0x007e }
            if (r9 == 0) goto L_0x007d
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r8 = mappings     // Catch:{ Exception -> 0x007e }
            r8.put(r7, r2)     // Catch:{ Exception -> 0x007e }
        L_0x007d:
            return r2
        L_0x007e:
            java.lang.Class r2 = java.lang.Class.forName(r7)     // Catch:{ Exception -> 0x0087 }
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r8 = mappings     // Catch:{ Exception -> 0x0087 }
            r8.put(r7, r2)     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            return r2
        L_0x0088:
            com.alibaba.fastjson.JSONException r8 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "className too long. "
            r9.append(r0)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.<init>(r7)
            throw r8
        L_0x009f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.loadClass(java.lang.String, java.lang.ClassLoader, boolean):java.lang.Class");
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [com.alibaba.fastjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T castToJavaBean(java.util.Map<java.lang.String, java.lang.Object> r4, java.lang.Class<T> r5, com.alibaba.fastjson.parser.ParserConfig r6, int r7) {
        /*
            r0 = 0
            java.lang.Class<java.lang.StackTraceElement> r1 = java.lang.StackTraceElement.class
            if (r5 != r1) goto L_0x0035
            java.lang.String r5 = "className"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0032 }
            java.lang.String r6 = "methodName"
            java.lang.Object r6 = r4.get(r6)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0032 }
            java.lang.String r7 = "fileName"
            java.lang.Object r7 = r4.get(r7)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0032 }
            java.lang.String r1 = "lineNumber"
            java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x0032 }
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x0032 }
            if (r4 != 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            int r0 = r4.intValue()     // Catch:{ Exception -> 0x0032 }
        L_0x002c:
            java.lang.StackTraceElement r4 = new java.lang.StackTraceElement     // Catch:{ Exception -> 0x0032 }
            r4.<init>(r5, r6, r7, r0)     // Catch:{ Exception -> 0x0032 }
            return r4
        L_0x0032:
            r4 = move-exception
            goto L_0x00d3
        L_0x0035:
            java.lang.String r1 = "@type"
            java.lang.Object r1 = r4.get(r1)     // Catch:{ Exception -> 0x0032 }
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0032 }
            r3 = 0
            if (r2 == 0) goto L_0x006e
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0032 }
            if (r6 != 0) goto L_0x0046
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.global     // Catch:{ Exception -> 0x0032 }
        L_0x0046:
            java.lang.Class r2 = r6.checkAutoType(r1, r3, r7)     // Catch:{ Exception -> 0x0032 }
            if (r2 == 0) goto L_0x0057
            boolean r1 = r2.equals(r5)     // Catch:{ Exception -> 0x0032 }
            if (r1 != 0) goto L_0x006e
            java.lang.Object r4 = castToJavaBean(r4, r2, r6, r7)     // Catch:{ Exception -> 0x0032 }
            return r4
        L_0x0057:
            java.lang.ClassNotFoundException r4 = new java.lang.ClassNotFoundException     // Catch:{ Exception -> 0x0032 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0032 }
            r5.<init>()     // Catch:{ Exception -> 0x0032 }
            r5.append(r1)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r6 = " not found"
            r5.append(r6)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0032 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0032 }
            throw r4     // Catch:{ Exception -> 0x0032 }
        L_0x006e:
            boolean r7 = r5.isInterface()     // Catch:{ Exception -> 0x0032 }
            if (r7 == 0) goto L_0x00a8
            boolean r7 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0032 }
            if (r7 == 0) goto L_0x007b
            com.alibaba.fastjson.JSONObject r4 = (com.alibaba.fastjson.JSONObject) r4     // Catch:{ Exception -> 0x0032 }
            goto L_0x0081
        L_0x007b:
            com.alibaba.fastjson.JSONObject r7 = new com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0032 }
            r7.<init>((java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ Exception -> 0x0032 }
            r4 = r7
        L_0x0081:
            if (r6 != 0) goto L_0x0087
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance()     // Catch:{ Exception -> 0x0032 }
        L_0x0087:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r6 = r6.getDeserializer(r5)     // Catch:{ Exception -> 0x0032 }
            if (r6 == 0) goto L_0x0096
            java.lang.String r4 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r4 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r4, r5)     // Catch:{ Exception -> 0x0032 }
            return r4
        L_0x0096:
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0032 }
            java.lang.ClassLoader r6 = r6.getContextClassLoader()     // Catch:{ Exception -> 0x0032 }
            r7 = 1
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x0032 }
            r7[r0] = r5     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r4 = java.lang.reflect.Proxy.newProxyInstance(r6, r7, r4)     // Catch:{ Exception -> 0x0032 }
            return r4
        L_0x00a8:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r5 != r7) goto L_0x00b5
            boolean r7 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0032 }
            if (r7 == 0) goto L_0x00b5
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0032 }
            return r4
        L_0x00b5:
            if (r6 != 0) goto L_0x00b9
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.global     // Catch:{ Exception -> 0x0032 }
        L_0x00b9:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r5 = r6.getDeserializer(r5)     // Catch:{ Exception -> 0x0032 }
            boolean r7 = r5 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer     // Catch:{ Exception -> 0x0032 }
            if (r7 == 0) goto L_0x00c4
            r3 = r5
            com.alibaba.fastjson.parser.JavaBeanDeserializer r3 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r3     // Catch:{ Exception -> 0x0032 }
        L_0x00c4:
            if (r3 == 0) goto L_0x00cb
            java.lang.Object r4 = r3.createInstance((java.util.Map<java.lang.String, java.lang.Object>) r4, (com.alibaba.fastjson.parser.ParserConfig) r6)     // Catch:{ Exception -> 0x0032 }
            return r4
        L_0x00cb:
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException     // Catch:{ Exception -> 0x0032 }
            java.lang.String r5 = "can not get javaBeanDeserializer"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0032 }
            throw r4     // Catch:{ Exception -> 0x0032 }
        L_0x00d3:
            com.alibaba.fastjson.JSONException r5 = new com.alibaba.fastjson.JSONException
            java.lang.String r6 = r4.getMessage()
            r5.<init>(r6, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.castToJavaBean(java.util.Map, java.lang.Class, com.alibaba.fastjson.parser.ParserConfig, int):java.lang.Object");
    }

    public static final <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == null) {
            return null;
        }
        if (type instanceof Class) {
            return cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static final <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t10;
        Type rawType = parameterizedType.getRawType();
        Class<TreeSet> cls = TreeSet.class;
        Class<HashSet> cls2 = HashSet.class;
        Class<Set> cls3 = Set.class;
        if (rawType == cls3 || rawType == cls2 || rawType == cls || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == cls3 || rawType == cls2) {
                    t10 = new HashSet();
                } else if (rawType == cls) {
                    t10 = new TreeSet();
                } else {
                    t10 = new ArrayList();
                }
                for (Object cast : (Iterable) obj) {
                    t10.add(cast(cast, type, parserConfig));
                }
                return t10;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                T hashMap = new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    hashMap.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return hashMap;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }
}
