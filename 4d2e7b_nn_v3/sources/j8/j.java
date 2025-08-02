package j8;

import java.util.ArrayList;
import java.util.Arrays;

public final class j {

    /* renamed from: l  reason: collision with root package name */
    static final char[] f12422l = new char[0];

    /* renamed from: a  reason: collision with root package name */
    private final a f12423a;

    /* renamed from: b  reason: collision with root package name */
    private char[] f12424b;

    /* renamed from: c  reason: collision with root package name */
    private int f12425c;

    /* renamed from: d  reason: collision with root package name */
    private int f12426d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f12427e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12428f;

    /* renamed from: g  reason: collision with root package name */
    private int f12429g;

    /* renamed from: h  reason: collision with root package name */
    private char[] f12430h;

    /* renamed from: i  reason: collision with root package name */
    private int f12431i;

    /* renamed from: j  reason: collision with root package name */
    private String f12432j;

    /* renamed from: k  reason: collision with root package name */
    private char[] f12433k;

    public j(a aVar) {
        this.f12423a = aVar;
    }

    private char[] d(int i10) {
        a aVar = this.f12423a;
        if (aVar != null) {
            return aVar.d(2, i10);
        }
        return new char[Math.max(i10, 500)];
    }

    private char[] e(int i10) {
        return new char[i10];
    }

    private void f() {
        this.f12428f = false;
        this.f12427e.clear();
        this.f12429g = 0;
        this.f12431i = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        if (r3 > 65536) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(int r3) {
        /*
            r2 = this;
            java.util.ArrayList r3 = r2.f12427e
            if (r3 != 0) goto L_0x000b
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.f12427e = r3
        L_0x000b:
            char[] r3 = r2.f12430h
            r0 = 1
            r2.f12428f = r0
            java.util.ArrayList r0 = r2.f12427e
            r0.add(r3)
            int r0 = r2.f12429g
            int r1 = r3.length
            int r0 = r0 + r1
            r2.f12429g = r0
            r0 = 0
            r2.f12431i = r0
            int r3 = r3.length
            int r0 = r3 >> 1
            int r3 = r3 + r0
            r0 = 500(0x1f4, float:7.0E-43)
            if (r3 >= r0) goto L_0x0028
        L_0x0026:
            r3 = r0
            goto L_0x002d
        L_0x0028:
            r0 = 65536(0x10000, float:9.18355E-41)
            if (r3 <= r0) goto L_0x002d
            goto L_0x0026
        L_0x002d:
            char[] r3 = r2.e(r3)
            r2.f12430h = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j8.j.i(int):void");
    }

    public static j k(char[] cArr) {
        return new j((a) null, cArr);
    }

    private char[] m() {
        int i10;
        String str = this.f12432j;
        if (str != null) {
            return str.toCharArray();
        }
        int i11 = this.f12425c;
        if (i11 >= 0) {
            int i12 = this.f12426d;
            if (i12 < 1) {
                return f12422l;
            }
            if (i11 == 0) {
                return Arrays.copyOf(this.f12424b, i12);
            }
            return Arrays.copyOfRange(this.f12424b, i11, i12 + i11);
        }
        int o10 = o();
        if (o10 < 1) {
            return f12422l;
        }
        char[] e10 = e(o10);
        ArrayList arrayList = this.f12427e;
        if (arrayList != null) {
            int size = arrayList.size();
            i10 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                char[] cArr = (char[]) this.f12427e.get(i13);
                int length = cArr.length;
                System.arraycopy(cArr, 0, e10, i10, length);
                i10 += length;
            }
        } else {
            i10 = 0;
        }
        System.arraycopy(this.f12430h, 0, e10, i10, this.f12431i);
        return e10;
    }

    private void p(int i10) {
        int i11 = this.f12426d;
        this.f12426d = 0;
        char[] cArr = this.f12424b;
        this.f12424b = null;
        int i12 = this.f12425c;
        this.f12425c = -1;
        int i13 = i10 + i11;
        char[] cArr2 = this.f12430h;
        if (cArr2 == null || i13 > cArr2.length) {
            this.f12430h = d(i13);
        }
        if (i11 > 0) {
            System.arraycopy(cArr, i12, this.f12430h, 0, i11);
        }
        this.f12429g = 0;
        this.f12431i = i11;
    }

    public void a(char c10) {
        if (this.f12425c >= 0) {
            p(16);
        }
        this.f12432j = null;
        this.f12433k = null;
        char[] cArr = this.f12430h;
        if (this.f12431i >= cArr.length) {
            i(1);
            cArr = this.f12430h;
        }
        int i10 = this.f12431i;
        this.f12431i = i10 + 1;
        cArr[i10] = c10;
    }

    public void b(String str, int i10, int i11) {
        if (this.f12425c >= 0) {
            p(i11);
        }
        this.f12432j = null;
        this.f12433k = null;
        char[] cArr = this.f12430h;
        int length = cArr.length;
        int i12 = this.f12431i;
        int i13 = length - i12;
        if (i13 >= i11) {
            str.getChars(i10, i10 + i11, cArr, i12);
            this.f12431i += i11;
            return;
        }
        if (i13 > 0) {
            int i14 = i10 + i13;
            str.getChars(i10, i14, cArr, i12);
            i11 -= i13;
            i10 = i14;
        }
        while (true) {
            i(i11);
            int min = Math.min(this.f12430h.length, i11);
            int i15 = i10 + min;
            str.getChars(i10, i15, this.f12430h, 0);
            this.f12431i += min;
            i11 -= min;
            if (i11 > 0) {
                i10 = i15;
            } else {
                return;
            }
        }
    }

    public void c(char[] cArr, int i10, int i11) {
        if (this.f12425c >= 0) {
            p(i11);
        }
        this.f12432j = null;
        this.f12433k = null;
        char[] cArr2 = this.f12430h;
        int length = cArr2.length;
        int i12 = this.f12431i;
        int i13 = length - i12;
        if (i13 >= i11) {
            System.arraycopy(cArr, i10, cArr2, i12, i11);
            this.f12431i += i11;
            return;
        }
        if (i13 > 0) {
            System.arraycopy(cArr, i10, cArr2, i12, i13);
            i10 += i13;
            i11 -= i13;
        }
        do {
            i(i11);
            int min = Math.min(this.f12430h.length, i11);
            System.arraycopy(cArr, i10, this.f12430h, 0, min);
            this.f12431i += min;
            i10 += min;
            i11 -= min;
        } while (i11 > 0);
    }

    public char[] g() {
        char[] cArr = this.f12433k;
        if (cArr != null) {
            return cArr;
        }
        char[] m10 = m();
        this.f12433k = m10;
        return m10;
    }

    public String h() {
        if (this.f12432j == null) {
            char[] cArr = this.f12433k;
            if (cArr != null) {
                this.f12432j = new String(cArr);
            } else {
                int i10 = this.f12425c;
                String str = "";
                if (i10 >= 0) {
                    int i11 = this.f12426d;
                    if (i11 < 1) {
                        this.f12432j = str;
                        return str;
                    }
                    this.f12432j = new String(this.f12424b, i10, i11);
                } else {
                    int i12 = this.f12429g;
                    int i13 = this.f12431i;
                    if (i12 == 0) {
                        if (i13 != 0) {
                            str = new String(this.f12430h, 0, i13);
                        }
                        this.f12432j = str;
                    } else {
                        StringBuilder sb2 = new StringBuilder(i12 + i13);
                        ArrayList arrayList = this.f12427e;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i14 = 0; i14 < size; i14++) {
                                char[] cArr2 = (char[]) this.f12427e.get(i14);
                                sb2.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb2.append(this.f12430h, 0, this.f12431i);
                        this.f12432j = sb2.toString();
                    }
                }
            }
        }
        return this.f12432j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        if (r0 > 65536) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char[] j() {
        /*
            r2 = this;
            java.util.ArrayList r0 = r2.f12427e
            if (r0 != 0) goto L_0x000b
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.f12427e = r0
        L_0x000b:
            r0 = 1
            r2.f12428f = r0
            java.util.ArrayList r0 = r2.f12427e
            char[] r1 = r2.f12430h
            r0.add(r1)
            char[] r0 = r2.f12430h
            int r0 = r0.length
            int r1 = r2.f12429g
            int r1 = r1 + r0
            r2.f12429g = r1
            r1 = 0
            r2.f12431i = r1
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L_0x0029
        L_0x0027:
            r0 = r1
            goto L_0x002e
        L_0x0029:
            r1 = 65536(0x10000, float:9.18355E-41)
            if (r0 <= r1) goto L_0x002e
            goto L_0x0027
        L_0x002e:
            char[] r0 = r2.e(r0)
            r2.f12430h = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j8.j.j():char[]");
    }

    public void l() {
        char[] cArr;
        this.f12425c = -1;
        this.f12431i = 0;
        this.f12426d = 0;
        this.f12424b = null;
        this.f12433k = null;
        if (this.f12428f) {
            f();
        }
        a aVar = this.f12423a;
        if (aVar != null && (cArr = this.f12430h) != null) {
            this.f12430h = null;
            aVar.j(2, cArr);
        }
    }

    public void n(int i10) {
        this.f12431i = i10;
    }

    public int o() {
        if (this.f12425c >= 0) {
            return this.f12426d;
        }
        char[] cArr = this.f12433k;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.f12432j;
        if (str != null) {
            return str.length();
        }
        return this.f12429g + this.f12431i;
    }

    public String toString() {
        return h();
    }

    protected j(a aVar, char[] cArr) {
        this.f12423a = aVar;
        this.f12430h = cArr;
        this.f12431i = cArr.length;
        this.f12425c = -1;
    }
}
