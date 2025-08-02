package com.geetest.captcha;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class f0 {

    /* renamed from: c  reason: collision with root package name */
    public static final a f5799c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f5800a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f5801b;

    public static final class a {
        public final f0 a(String str) {
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
                        return new f0(strArr[0], hashMap);
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
                            return new f0(strArr[0], hashMap);
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
    }

    public f0(String str, Map<String, String> map) {
        this.f5800a = str;
        this.f5801b = map;
    }

    public String toString() {
        Map<String, String> map = this.f5801b;
        if (map == null || map.isEmpty()) {
            return this.f5800a;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5800a);
        stringBuffer.append('?');
        for (Map.Entry next : this.f5801b.entrySet()) {
            stringBuffer.append((String) next.getKey());
            stringBuffer.append('=');
            stringBuffer.append((String) next.getValue());
            stringBuffer.append('&');
        }
        String stringBuffer2 = stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
        m.e(stringBuffer2, "sb.deleteCharAt(sb.length - 1).toString()");
        return stringBuffer2;
    }
}
