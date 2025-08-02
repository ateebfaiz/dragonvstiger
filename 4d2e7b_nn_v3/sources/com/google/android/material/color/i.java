package com.google.android.material.color;

import android.content.Context;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

abstract class i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static byte f8056a;

    /* renamed from: b  reason: collision with root package name */
    private static final d f8057b = new d(1, com.alibaba.pdns.f.f17924q);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Comparator f8058c = new a();

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.f8061c - bVar2.f8061c;
        }
    }

    static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final byte f8059a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final byte f8060b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final short f8061c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final String f8062d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final int f8063e;

        b(int i10, String str, int i11) {
            this.f8062d = str;
            this.f8063e = i11;
            this.f8061c = (short) (65535 & i10);
            this.f8060b = (byte) ((i10 >> 16) & 255);
            this.f8059a = (byte) ((i10 >> 24) & 255);
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private final e f8064a;

        /* renamed from: b  reason: collision with root package name */
        private final d f8065b;

        /* renamed from: c  reason: collision with root package name */
        private final h f8066c = new h(false, "?1", "?2", "?3", "?4", "?5", "color");

        /* renamed from: d  reason: collision with root package name */
        private final h f8067d;

        /* renamed from: e  reason: collision with root package name */
        private final k f8068e;

        c(d dVar, List list) {
            this.f8065b = dVar;
            String[] strArr = new String[list.size()];
            for (int i10 = 0; i10 < list.size(); i10++) {
                strArr[i10] = ((b) list.get(i10)).f8062d;
            }
            this.f8067d = new h(true, strArr);
            this.f8068e = new k(list);
            this.f8064a = new e(512, 288, a());
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f8066c.a() + 288 + this.f8067d.a() + this.f8068e.b();
        }

        /* access modifiers changed from: package-private */
        public void b(ByteArrayOutputStream byteArrayOutputStream) {
            this.f8064a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(i.j(this.f8065b.f8069a));
            char[] charArray = this.f8065b.f8070b.toCharArray();
            for (int i10 = 0; i10 < 128; i10++) {
                if (i10 < charArray.length) {
                    byteArrayOutputStream.write(i.h(charArray[i10]));
                } else {
                    byteArrayOutputStream.write(i.h(0));
                }
            }
            byteArrayOutputStream.write(i.j(288));
            byteArrayOutputStream.write(i.j(0));
            byteArrayOutputStream.write(i.j(this.f8066c.a() + 288));
            byteArrayOutputStream.write(i.j(0));
            byteArrayOutputStream.write(i.j(0));
            this.f8066c.c(byteArrayOutputStream);
            this.f8067d.c(byteArrayOutputStream);
            this.f8068e.c(byteArrayOutputStream);
        }
    }

    static class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f8069a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f8070b;

        d(int i10, String str) {
            this.f8069a = i10;
            this.f8070b = str;
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        private final short f8071a;

        /* renamed from: b  reason: collision with root package name */
        private final short f8072b;

        /* renamed from: c  reason: collision with root package name */
        private final int f8073c;

        e(short s10, short s11, int i10) {
            this.f8071a = s10;
            this.f8072b = s11;
            this.f8073c = i10;
        }

        /* access modifiers changed from: package-private */
        public void a(ByteArrayOutputStream byteArrayOutputStream) {
            byteArrayOutputStream.write(i.k(this.f8071a));
            byteArrayOutputStream.write(i.k(this.f8072b));
            byteArrayOutputStream.write(i.j(this.f8073c));
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        private final int f8074a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8075b;

        f(int i10, int i11) {
            this.f8074a = i10;
            this.f8075b = i11;
        }

        /* access modifiers changed from: package-private */
        public void a(ByteArrayOutputStream byteArrayOutputStream) {
            byteArrayOutputStream.write(i.k(8));
            byteArrayOutputStream.write(i.k(2));
            byteArrayOutputStream.write(i.j(this.f8074a));
            byteArrayOutputStream.write(i.k(8));
            byteArrayOutputStream.write(new byte[]{0, 28});
            byteArrayOutputStream.write(i.j(this.f8075b));
        }
    }

    private static class g {

        /* renamed from: a  reason: collision with root package name */
        private final e f8076a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8077b;

        /* renamed from: c  reason: collision with root package name */
        private final h f8078c;

        /* renamed from: d  reason: collision with root package name */
        private final List f8079d = new ArrayList();

        g(Map map) {
            this.f8077b = map.size();
            this.f8078c = new h(new String[0]);
            for (Map.Entry entry : map.entrySet()) {
                List list = (List) entry.getValue();
                Collections.sort(list, i.f8058c);
                this.f8079d.add(new c((d) entry.getKey(), list));
            }
            this.f8076a = new e(2, 12, a());
        }

        private int a() {
            int i10 = 0;
            for (c a10 : this.f8079d) {
                i10 += a10.a();
            }
            return this.f8078c.a() + 12 + i10;
        }

        /* access modifiers changed from: package-private */
        public void b(ByteArrayOutputStream byteArrayOutputStream) {
            this.f8076a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(i.j(this.f8077b));
            this.f8078c.c(byteArrayOutputStream);
            for (c b10 : this.f8079d) {
                b10.b(byteArrayOutputStream);
            }
        }
    }

    private static class h {

        /* renamed from: a  reason: collision with root package name */
        private final e f8080a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8081b;

        /* renamed from: c  reason: collision with root package name */
        private final int f8082c;

        /* renamed from: d  reason: collision with root package name */
        private final int f8083d;

        /* renamed from: e  reason: collision with root package name */
        private final int f8084e;

        /* renamed from: f  reason: collision with root package name */
        private final List f8085f;

        /* renamed from: g  reason: collision with root package name */
        private final List f8086g;

        /* renamed from: h  reason: collision with root package name */
        private final List f8087h;

        /* renamed from: i  reason: collision with root package name */
        private final List f8088i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f8089j;

        /* renamed from: k  reason: collision with root package name */
        private final int f8090k;

        /* renamed from: l  reason: collision with root package name */
        private final int f8091l;

        h(String... strArr) {
            this(false, strArr);
        }

        private Pair b(String str) {
            byte[] bArr;
            if (this.f8089j) {
                bArr = i.m(str);
            } else {
                bArr = i.l(str);
            }
            return new Pair(bArr, Collections.emptyList());
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f8091l;
        }

        /* access modifiers changed from: package-private */
        public void c(ByteArrayOutputStream byteArrayOutputStream) {
            int i10;
            this.f8080a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(i.j(this.f8081b));
            byteArrayOutputStream.write(i.j(this.f8082c));
            if (this.f8089j) {
                i10 = 256;
            } else {
                i10 = 0;
            }
            byteArrayOutputStream.write(i.j(i10));
            byteArrayOutputStream.write(i.j(this.f8083d));
            byteArrayOutputStream.write(i.j(this.f8084e));
            for (Integer intValue : this.f8085f) {
                byteArrayOutputStream.write(i.j(intValue.intValue()));
            }
            for (Integer intValue2 : this.f8086g) {
                byteArrayOutputStream.write(i.j(intValue2.intValue()));
            }
            for (byte[] write : this.f8087h) {
                byteArrayOutputStream.write(write);
            }
            int i11 = this.f8090k;
            if (i11 > 0) {
                byteArrayOutputStream.write(new byte[i11]);
            }
            for (List it : this.f8088i) {
                Iterator it2 = it.iterator();
                if (!it2.hasNext()) {
                    byteArrayOutputStream.write(i.j(-1));
                } else {
                    c.d.a(it2.next());
                    throw null;
                }
            }
        }

        h(boolean z10, String... strArr) {
            this.f8085f = new ArrayList();
            this.f8086g = new ArrayList();
            this.f8087h = new ArrayList();
            this.f8088i = new ArrayList();
            this.f8089j = z10;
            int i10 = 0;
            int i11 = 0;
            for (String b10 : strArr) {
                Pair b11 = b(b10);
                this.f8085f.add(Integer.valueOf(i11));
                Object obj = b11.first;
                i11 += ((byte[]) obj).length;
                this.f8087h.add(obj);
                this.f8088i.add(b11.second);
            }
            int i12 = 0;
            for (List<Object> list : this.f8088i) {
                for (Object a10 : list) {
                    c.d.a(a10);
                    this.f8085f.add(Integer.valueOf(i11));
                    i11 += C0092i.a((C0092i) null).length;
                    this.f8087h.add(C0092i.a((C0092i) null));
                }
                this.f8086g.add(Integer.valueOf(i12));
                i12 += (list.size() * 12) + 4;
            }
            int i13 = i11 % 4;
            int i14 = i13 == 0 ? 0 : 4 - i13;
            this.f8090k = i14;
            int size = this.f8087h.size();
            this.f8081b = size;
            this.f8082c = this.f8087h.size() - strArr.length;
            boolean z11 = this.f8087h.size() - strArr.length > 0;
            if (!z11) {
                this.f8086g.clear();
                this.f8088i.clear();
            }
            int size2 = (size * 4) + 28 + (this.f8086g.size() * 4);
            this.f8083d = size2;
            int i15 = i11 + i14;
            this.f8084e = z11 ? size2 + i15 : 0;
            int i16 = size2 + i15 + (z11 ? i12 : i10);
            this.f8091l = i16;
            this.f8080a = new e(1, 28, i16);
        }
    }

    /* renamed from: com.google.android.material.color.i$i  reason: collision with other inner class name */
    private static class C0092i {
        static /* synthetic */ byte[] a(C0092i iVar) {
            throw null;
        }
    }

    private static class j {

        /* renamed from: a  reason: collision with root package name */
        private final e f8092a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8093b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f8094c;

        /* renamed from: d  reason: collision with root package name */
        private final int[] f8095d;

        /* renamed from: e  reason: collision with root package name */
        private final f[] f8096e;

        j(List list, Set set, int i10) {
            byte[] bArr = new byte[64];
            this.f8094c = bArr;
            this.f8093b = i10;
            bArr[0] = 64;
            this.f8096e = new f[list.size()];
            for (int i11 = 0; i11 < list.size(); i11++) {
                this.f8096e[i11] = new f(i11, ((b) list.get(i11)).f8063e);
            }
            this.f8095d = new int[i10];
            int i12 = 0;
            for (short s10 = 0; s10 < i10; s10 = (short) (s10 + 1)) {
                if (set.contains(Short.valueOf(s10))) {
                    this.f8095d[s10] = i12;
                    i12 += 16;
                } else {
                    this.f8095d[s10] = -1;
                }
            }
            this.f8092a = new e(513, 84, a());
        }

        private int b() {
            return c() + 84;
        }

        private int c() {
            return this.f8095d.length * 4;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return b() + (this.f8096e.length * 16);
        }

        /* access modifiers changed from: package-private */
        public void d(ByteArrayOutputStream byteArrayOutputStream) {
            this.f8092a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{i.f8056a, 0, 0, 0});
            byteArrayOutputStream.write(i.j(this.f8093b));
            byteArrayOutputStream.write(i.j(b()));
            byteArrayOutputStream.write(this.f8094c);
            for (int d10 : this.f8095d) {
                byteArrayOutputStream.write(i.j(d10));
            }
            for (f a10 : this.f8096e) {
                a10.a(byteArrayOutputStream);
            }
        }
    }

    private static class k {

        /* renamed from: a  reason: collision with root package name */
        private final e f8097a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8098b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f8099c;

        /* renamed from: d  reason: collision with root package name */
        private final j f8100d;

        k(List list) {
            this.f8098b = ((b) list.get(list.size() - 1)).f8061c + 1;
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(Short.valueOf(((b) it.next()).f8061c));
            }
            this.f8099c = new int[this.f8098b];
            for (short s10 = 0; s10 < this.f8098b; s10 = (short) (s10 + 1)) {
                if (hashSet.contains(Short.valueOf(s10))) {
                    this.f8099c[s10] = 1073741824;
                }
            }
            this.f8097a = new e(514, 16, a());
            this.f8100d = new j(list, hashSet, this.f8098b);
        }

        private int a() {
            return (this.f8098b * 4) + 16;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return a() + this.f8100d.a();
        }

        /* access modifiers changed from: package-private */
        public void c(ByteArrayOutputStream byteArrayOutputStream) {
            this.f8097a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{i.f8056a, 0, 0, 0});
            byteArrayOutputStream.write(i.j(this.f8098b));
            for (int d10 : this.f8099c) {
                byteArrayOutputStream.write(i.j(d10));
            }
            this.f8100d.d(byteArrayOutputStream);
        }
    }

    /* access modifiers changed from: private */
    public static byte[] h(char c10) {
        return new byte[]{(byte) (c10 & 255), (byte) ((c10 >> 8) & 255)};
    }

    static byte[] i(Context context, Map map) {
        d dVar;
        if (!map.entrySet().isEmpty()) {
            d dVar2 = new d(127, context.getPackageName());
            HashMap hashMap = new HashMap();
            b bVar = null;
            for (Map.Entry entry : map.entrySet()) {
                b bVar2 = new b(((Integer) entry.getKey()).intValue(), context.getResources().getResourceName(((Integer) entry.getKey()).intValue()), ((Integer) entry.getValue()).intValue());
                if (context.getResources().getResourceTypeName(((Integer) entry.getKey()).intValue()).equals("color")) {
                    if (bVar2.f8059a == 1) {
                        dVar = f8057b;
                    } else if (bVar2.f8059a == Byte.MAX_VALUE) {
                        dVar = dVar2;
                    } else {
                        throw new IllegalArgumentException("Not supported with unknown package id: " + bVar2.f8059a);
                    }
                    if (!hashMap.containsKey(dVar)) {
                        hashMap.put(dVar, new ArrayList());
                    }
                    ((List) hashMap.get(dVar)).add(bVar2);
                    bVar = bVar2;
                } else {
                    throw new IllegalArgumentException("Non color resource found: name=" + bVar2.f8062d + ", typeId=" + Integer.toHexString(bVar2.f8060b & 255));
                }
            }
            byte d10 = bVar.f8060b;
            f8056a = d10;
            if (d10 != 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new g(hashMap).b(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalArgumentException("No color resources found for harmonization.");
        }
        throw new IllegalArgumentException("No color resources provided for harmonization.");
    }

    /* access modifiers changed from: private */
    public static byte[] j(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)};
    }

    /* access modifiers changed from: private */
    public static byte[] k(short s10) {
        return new byte[]{(byte) (s10 & 255), (byte) ((s10 >> 8) & 255)};
    }

    /* access modifiers changed from: private */
    public static byte[] l(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length * 2;
        byte[] bArr = new byte[(length + 4)];
        byte[] k10 = k((short) charArray.length);
        bArr[0] = k10[0];
        bArr[1] = k10[1];
        for (int i10 = 0; i10 < charArray.length; i10++) {
            byte[] h10 = h(charArray[i10]);
            int i11 = i10 * 2;
            bArr[i11 + 2] = h10[0];
            bArr[i11 + 3] = h10[1];
        }
        bArr[length + 2] = 0;
        bArr[length + 3] = 0;
        return bArr;
    }

    /* access modifiers changed from: private */
    public static byte[] m(String str) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        byte length = (byte) bytes.length;
        int length2 = bytes.length;
        byte[] bArr = new byte[(length2 + 3)];
        System.arraycopy(bytes, 0, bArr, 2, length);
        bArr[1] = length;
        bArr[0] = length;
        bArr[length2 + 2] = 0;
        return bArr;
    }
}
