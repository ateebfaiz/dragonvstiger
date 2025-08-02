package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

abstract class n3 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f7236a;

    static {
        char[] cArr = new char[80];
        f7236a = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String a(zzlm zzlm, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        d(zzlm, sb2, 0);
        return sb2.toString();
    }

    static void b(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj instanceof List) {
            for (Object b10 : (List) obj) {
                b(sb2, i10, str, b10);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry b11 : ((Map) obj).entrySet()) {
                b(sb2, i10, str, b11);
            }
        } else {
            sb2.append(10);
            c(i10, sb2);
            if (!str.isEmpty()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Character.toLowerCase(str.charAt(0)));
                for (int i11 = 1; i11 < str.length(); i11++) {
                    char charAt = str.charAt(i11);
                    if (Character.isUpperCase(charAt)) {
                        sb3.append("_");
                    }
                    sb3.append(Character.toLowerCase(charAt));
                }
                str = sb3.toString();
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(i4.a(zzje.zzm((String) obj)));
                sb2.append('\"');
            } else if (obj instanceof zzje) {
                sb2.append(": \"");
                sb2.append(i4.a((zzje) obj));
                sb2.append('\"');
            } else if (obj instanceof zzkf) {
                sb2.append(" {");
                d((zzkf) obj, sb2, i10 + 2);
                sb2.append("\n");
                c(i10, sb2);
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i12 = i10 + 2;
                b(sb2, i12, "key", entry.getKey());
                b(sb2, i12, "value", entry.getValue());
                sb2.append("\n");
                c(i10, sb2);
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj);
            }
        }
    }

    private static void c(int i10, StringBuilder sb2) {
        while (i10 > 0) {
            int i11 = 80;
            if (i10 <= 80) {
                i11 = i10;
            }
            sb2.append(f7236a, 0, i11);
            i10 -= i11;
        }
    }

    private static void d(zzlm zzlm, StringBuilder sb2, int i10) {
        int i11;
        boolean z10;
        Method method;
        Method method2;
        zzlm zzlm2 = zzlm;
        StringBuilder sb3 = sb2;
        int i12 = i10;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzlm.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i13 = 0;
        while (true) {
            i11 = 3;
            if (i13 >= length) {
                break;
            }
            Method method3 = declaredMethods[i13];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i13++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i11);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                b(sb3, i12, substring.substring(0, substring.length() - 4), zzkf.zzbH(method2, zzlm2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                b(sb3, i12, substring.substring(0, substring.length() - 3), zzkf.zzbH(method, zzlm2, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzbH = zzkf.zzbH(method4, zzlm2, new Object[0]);
                    if (method5 == null) {
                        if (zzbH instanceof Boolean) {
                            if (!((Boolean) zzbH).booleanValue()) {
                            }
                        } else if (zzbH instanceof Integer) {
                            if (((Integer) zzbH).intValue() == 0) {
                            }
                        } else if (zzbH instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzbH).floatValue()) == 0) {
                            }
                        } else if (!(zzbH instanceof Double)) {
                            if (zzbH instanceof String) {
                                z10 = zzbH.equals("");
                            } else if (zzbH instanceof zzje) {
                                z10 = zzbH.equals(zzje.zzb);
                            } else if (zzbH instanceof zzlm) {
                                if (zzbH == ((zzlm) zzbH).zzbS()) {
                                }
                            } else if ((zzbH instanceof Enum) && ((Enum) zzbH).ordinal() == 0) {
                            }
                            if (z10) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzbH).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzkf.zzbH(method5, zzlm2, new Object[0])).booleanValue()) {
                    }
                    b(sb3, i12, substring, zzbH);
                }
            }
            i11 = 3;
        }
        if (!(zzlm2 instanceof zzkc)) {
            zzmp zzmp = ((zzkf) zzlm2).zzc;
            if (zzmp != null) {
                zzmp.zzi(sb3, i12);
                return;
            }
            return;
        }
        zzkc zzkc = (zzkc) zzlm2;
        throw null;
    }
}
