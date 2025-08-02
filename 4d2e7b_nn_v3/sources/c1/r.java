package c1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.i0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f17269a = new r();

    private r() {
    }

    private final boolean a(Object obj) {
        if ((obj instanceof ArrayList) || (obj instanceof LinkedList) || (obj instanceof CopyOnWriteArrayList) || (obj instanceof Vector)) {
            return true;
        }
        return false;
    }

    private final boolean b(Object obj) {
        if ((obj instanceof HashMap) || (obj instanceof TreeMap) || (obj instanceof ConcurrentMap) || (obj instanceof EnumMap) || (obj instanceof Hashtable) || (obj instanceof WeakHashMap)) {
            return true;
        }
        return false;
    }

    public final String c(int i10, String str) {
        int length = str.length() - i10;
        if (length < 25) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        String substring = str.substring(0, i10);
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb2.append(substring);
        sb2.append("***<");
        sb2.append(length);
        sb2.append("> CHARS TRUNCATED***");
        return sb2.toString();
    }

    public final u d(int i10, List list) {
        int a10;
        int b10;
        Map map;
        int size = list.size();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < size) {
            int i14 = i11 + 1;
            r rVar = f17269a;
            Object obj = list.get(i11);
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() > i10) {
                    list.set(i11, rVar.c(i10, str));
                    i12++;
                    i13 += str.length() - i10;
                    i11 = i14;
                }
            }
            if (rVar.b(obj)) {
                if (obj != null) {
                    u e10 = rVar.e(i10, c0.d(obj));
                    a10 = e10.a();
                    b10 = e10.b();
                    map = obj;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
                }
            } else if (rVar.a(obj)) {
                if (obj != null) {
                    u d10 = rVar.d(i10, c0.c(obj));
                    a10 = d10.a();
                    b10 = d10.b();
                    map = obj;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                }
            } else if (obj instanceof Map) {
                Map d11 = c0.d(i0.r((Map) obj));
                u e11 = rVar.e(i10, d11);
                a10 = e11.a();
                b10 = e11.b();
                map = d11;
            } else if (obj instanceof Collection) {
                List y02 = kotlin.collections.r.y0((Collection) obj);
                u d12 = rVar.d(i10, y02);
                a10 = d12.a();
                b10 = d12.b();
                map = y02;
            } else {
                i11 = i14;
            }
            list.set(i11, map);
            i12 += a10;
            i13 += b10;
            i11 = i14;
        }
        return new u(i12, i13);
    }

    public final u e(int i10, Map map) {
        int a10;
        int b10;
        Map map2;
        int i11 = 0;
        int i12 = 0;
        for (Map.Entry entry : map.entrySet()) {
            r rVar = f17269a;
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (str.length() > i10) {
                    entry.setValue(rVar.c(i10, str));
                    i11++;
                    i12 += str.length() - i10;
                }
            }
            if (rVar.b(value)) {
                if (value != null) {
                    u e10 = rVar.e(i10, c0.d(value));
                    a10 = e10.a();
                    b10 = e10.b();
                    map2 = value;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
                }
            } else if (rVar.a(value)) {
                if (value != null) {
                    u d10 = rVar.d(i10, c0.c(value));
                    a10 = d10.a();
                    b10 = d10.b();
                    map2 = value;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                }
            } else if (value instanceof Map) {
                Map d11 = c0.d(i0.r((Map) value));
                u e11 = rVar.e(i10, d11);
                a10 = e11.a();
                b10 = e11.b();
                map2 = d11;
            } else if (value instanceof Collection) {
                List y02 = kotlin.collections.r.y0((Collection) value);
                u d12 = rVar.d(i10, y02);
                a10 = d12.a();
                b10 = d12.b();
                map2 = y02;
            }
            entry.setValue(map2);
            i11 += a10;
            i12 += b10;
        }
        return new u(i11, i12);
    }
}
