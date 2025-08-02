package com.botion.captcha;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public static final b f18469a = new b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f18470b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f18471c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f18472a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, String> f18473b;

        public a(String str, Map<String, String> map) {
            m.f(str, "baseUrl");
            this.f18472a = str;
            this.f18473b = map;
        }
    }

    public static final class b {
        private b() {
        }

        public static ad a(String str) {
            m.f(str, ImagesContract.URL);
            try {
                if (j.s(str)) {
                    return null;
                }
                Object[] array = j.v0(j.P0(str).toString(), new String[]{"?"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    HashMap hashMap = new HashMap();
                    if (strArr.length == 1) {
                        return new ad(strArr[0], hashMap, (byte) 0);
                    }
                    if (strArr.length == 2) {
                        Object[] array2 = j.v0(strArr[1], new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            int length = strArr2.length;
                            int i10 = 0;
                            while (i10 < length) {
                                Object[] array3 = j.v0(strArr2[i10], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                                if (array3 != null) {
                                    String[] strArr3 = (String[]) array3;
                                    if (strArr3.length == 2) {
                                        hashMap.put(strArr3[0], strArr3[1]);
                                    }
                                    i10++;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            return new ad(strArr[0], hashMap, (byte) 0);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public /* synthetic */ b(byte b10) {
            this();
        }
    }

    private ad(String str, Map<String, String> map) {
        this.f18470b = str;
        this.f18471c = map;
    }

    public final a a() {
        return new a(this.f18470b, this.f18471c);
    }

    public final String toString() {
        Map<String, String> map = this.f18471c;
        if (map == null || map.isEmpty()) {
            return this.f18470b;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f18470b);
        stringBuffer.append('?');
        for (Map.Entry next : this.f18471c.entrySet()) {
            stringBuffer.append((String) next.getKey());
            stringBuffer.append('=');
            stringBuffer.append((String) next.getValue());
            stringBuffer.append('&');
        }
        String stringBuffer2 = stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
        m.e(stringBuffer2, "sb.deleteCharAt(sb.length - 1).toString()");
        return stringBuffer2;
    }

    public /* synthetic */ ad(String str, Map map, byte b10) {
        this(str, map);
    }
}
