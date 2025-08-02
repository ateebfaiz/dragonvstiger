package ga;

import aa.f;
import io.jsonwebtoken.JwtParser;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import okio.internal.BufferKt;

public class a implements Closeable {
    private int[] C;
    private int X;
    private String[] Y;
    private int[] Z;

    /* renamed from: a  reason: collision with root package name */
    private final Reader f12235a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12236b = false;

    /* renamed from: c  reason: collision with root package name */
    private final char[] f12237c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private int f12238d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f12239e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f12240f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f12241g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f12242h = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f12243i;

    /* renamed from: j  reason: collision with root package name */
    private int f12244j;

    /* renamed from: w  reason: collision with root package name */
    private String f12245w;

    /* renamed from: ga.a$a  reason: collision with other inner class name */
    class C0141a extends f {
        C0141a() {
        }

        public void a(a aVar) {
            int i10 = aVar.f12242h;
            if (i10 == 0) {
                i10 = aVar.k();
            }
            if (i10 == 13) {
                aVar.f12242h = 9;
            } else if (i10 == 12) {
                aVar.f12242h = 8;
            } else if (i10 == 14) {
                aVar.f12242h = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + aVar.O() + aVar.B());
            }
        }
    }

    static {
        f.f2295a = new C0141a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.C = iArr;
        this.X = 1;
        iArr[0] = 6;
        this.Y = new String[32];
        this.Z = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f12235a = reader;
    }

    private boolean A(char c10) {
        if (c10 == 9 || c10 == 10 || c10 == 12 || c10 == 13 || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (!(c10 == '/' || c10 == '=')) {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        h();
        return false;
    }

    private int J(boolean z10) {
        char[] cArr = this.f12237c;
        int i10 = this.f12238d;
        int i11 = this.f12239e;
        while (true) {
            if (i10 == i11) {
                this.f12238d = i10;
                if (p(1)) {
                    i10 = this.f12238d;
                    i11 = this.f12239e;
                } else if (!z10) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + B());
                }
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == 10) {
                this.f12240f++;
                this.f12241g = i12;
            } else if (!(c10 == ' ' || c10 == 13 || c10 == 9)) {
                if (c10 == '/') {
                    this.f12238d = i12;
                    if (i12 == i11) {
                        this.f12238d = i10;
                        boolean p10 = p(2);
                        this.f12238d++;
                        if (!p10) {
                            return c10;
                        }
                    }
                    h();
                    int i13 = this.f12238d;
                    char c11 = cArr[i13];
                    if (c11 == '*') {
                        this.f12238d = i13 + 1;
                        if (V("*/")) {
                            i10 = this.f12238d + 2;
                            i11 = this.f12239e;
                        } else {
                            throw Z("Unterminated comment");
                        }
                    } else if (c11 != '/') {
                        return c10;
                    } else {
                        this.f12238d = i13 + 1;
                        W();
                        i10 = this.f12238d;
                        i11 = this.f12239e;
                    }
                } else if (c10 == '#') {
                    this.f12238d = i12;
                    h();
                    W();
                    i10 = this.f12238d;
                    i11 = this.f12239e;
                } else {
                    this.f12238d = i12;
                    return c10;
                }
            }
            i10 = i12;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r1 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.f12238d = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String L(char r10) {
        /*
            r9 = this;
            char[] r0 = r9.f12237c
            r1 = 0
        L_0x0003:
            int r2 = r9.f12238d
            int r3 = r9.f12239e
        L_0x0007:
            r4 = r3
            r3 = r2
        L_0x0009:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L_0x005a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L_0x0028
            r9.f12238d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0020
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L_0x0020:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L_0x0028:
            r8 = 92
            if (r2 != r8) goto L_0x004d
            r9.f12238d = r7
            int r7 = r7 - r3
            int r2 = r7 + -1
            if (r1 != 0) goto L_0x003e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L_0x003e:
            r1.append(r0, r3, r2)
            char r2 = r9.S()
            r1.append(r2)
            int r2 = r9.f12238d
            int r3 = r9.f12239e
            goto L_0x0007
        L_0x004d:
            r5 = 10
            if (r2 != r5) goto L_0x0058
            int r2 = r9.f12240f
            int r2 = r2 + r6
            r9.f12240f = r2
            r9.f12241g = r7
        L_0x0058:
            r2 = r7
            goto L_0x0009
        L_0x005a:
            if (r1 != 0) goto L_0x006a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L_0x006a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f12238d = r2
            boolean r2 = r9.p(r6)
            if (r2 == 0) goto L_0x0078
            goto L_0x0003
        L_0x0078:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.Z(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.a.L(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        h();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String N() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = r1
        L_0x0003:
            int r3 = r6.f12238d
            int r4 = r3 + r2
            int r5 = r6.f12239e
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.f12237c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.h()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.f12237c
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.p(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r1 = r2
            goto L_0x007e
        L_0x005e:
            if (r0 != 0) goto L_0x006b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L_0x006b:
            char[] r3 = r6.f12237c
            int r4 = r6.f12238d
            r0.append(r3, r4, r2)
            int r3 = r6.f12238d
            int r3 = r3 + r2
            r6.f12238d = r3
            r2 = 1
            boolean r2 = r6.p(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r0 != 0) goto L_0x008a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f12237c
            int r3 = r6.f12238d
            r0.<init>(r2, r3, r1)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.f12237c
            int r3 = r6.f12238d
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L_0x0095:
            int r2 = r6.f12238d
            int r2 = r2 + r1
            r6.f12238d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.a.N():java.lang.String");
    }

    private int P() {
        int i10;
        String str;
        String str2;
        char c10 = this.f12237c[this.f12238d];
        if (c10 == 't' || c10 == 'T') {
            str2 = "true";
            str = "TRUE";
            i10 = 5;
        } else if (c10 == 'f' || c10 == 'F') {
            str2 = "false";
            str = "FALSE";
            i10 = 6;
        } else if (c10 != 'n' && c10 != 'N') {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i10 = 7;
        }
        int length = str2.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.f12238d + i11 >= this.f12239e && !p(i11 + 1)) {
                return 0;
            }
            char c11 = this.f12237c[this.f12238d + i11];
            if (c11 != str2.charAt(i11) && c11 != str.charAt(i11)) {
                return 0;
            }
        }
        if ((this.f12238d + length < this.f12239e || p(length + 1)) && A(this.f12237c[this.f12238d + length])) {
            return 0;
        }
        this.f12238d += length;
        this.f12242h = i10;
        return i10;
    }

    private int Q() {
        char c10;
        char c11;
        boolean z10;
        char[] cArr = this.f12237c;
        int i10 = this.f12238d;
        int i11 = this.f12239e;
        int i12 = 0;
        int i13 = 0;
        char c12 = 0;
        boolean z11 = false;
        boolean z12 = true;
        long j10 = 0;
        while (true) {
            if (i10 + i13 == i11) {
                if (i13 == cArr.length) {
                    return i12;
                }
                if (!p(i13 + 1)) {
                    break;
                }
                i10 = this.f12238d;
                i11 = this.f12239e;
            }
            c10 = cArr[i10 + i13];
            if (c10 == '+') {
                c11 = 6;
                i12 = 0;
                if (c12 != 5) {
                    return 0;
                }
            } else if (c10 == 'E' || c10 == 'e') {
                i12 = 0;
                if (c12 != 2 && c12 != 4) {
                    return 0;
                }
                c12 = 5;
                i13++;
            } else if (c10 != '-') {
                c11 = 3;
                if (c10 == '.') {
                    i12 = 0;
                    if (c12 != 2) {
                        return 0;
                    }
                } else if (c10 >= '0' && c10 <= '9') {
                    if (c12 == 1 || c12 == 0) {
                        j10 = (long) (-(c10 - '0'));
                        c12 = 2;
                    } else if (c12 != 2) {
                        if (c12 == 3) {
                            i12 = 0;
                            c12 = 4;
                        } else if (c12 == 5 || c12 == 6) {
                            i12 = 0;
                            c12 = 7;
                        }
                        i13++;
                    } else if (j10 == 0) {
                        return 0;
                    } else {
                        long j11 = (10 * j10) - ((long) (c10 - '0'));
                        int i14 = (j10 > BufferKt.OVERFLOW_ZONE ? 1 : (j10 == BufferKt.OVERFLOW_ZONE ? 0 : -1));
                        if (i14 > 0 || (i14 == 0 && j11 < j10)) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z12 &= z10;
                        j10 = j11;
                    }
                    i12 = 0;
                    i13++;
                }
            } else {
                c11 = 6;
                i12 = 0;
                if (c12 == 0) {
                    c12 = 1;
                    z11 = true;
                    i13++;
                } else if (c12 != 5) {
                    return 0;
                }
            }
            c12 = c11;
            i13++;
        }
        if (A(c10)) {
            return 0;
        }
        if (c12 == 2 && z12 && ((j10 != Long.MIN_VALUE || z11) && (j10 != 0 || !z11))) {
            if (!z11) {
                j10 = -j10;
            }
            this.f12243i = j10;
            this.f12238d += i13;
            this.f12242h = 15;
            return 15;
        } else if (c12 != 2 && c12 != 4 && c12 != 7) {
            return 0;
        } else {
            this.f12244j = i13;
            this.f12242h = 16;
            return 16;
        }
    }

    private void R(int i10) {
        int i11 = this.X;
        int[] iArr = this.C;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.C = Arrays.copyOf(iArr, i12);
            this.Z = Arrays.copyOf(this.Z, i12);
            this.Y = (String[]) Arrays.copyOf(this.Y, i12);
        }
        int[] iArr2 = this.C;
        int i13 = this.X;
        this.X = i13 + 1;
        iArr2[i13] = i10;
    }

    private char S() {
        int i10;
        if (this.f12238d != this.f12239e || p(1)) {
            char[] cArr = this.f12237c;
            int i11 = this.f12238d;
            int i12 = i11 + 1;
            this.f12238d = i12;
            char c10 = cArr[i11];
            if (c10 == 10) {
                this.f12240f++;
                this.f12241g = i12;
            } else if (!(c10 == '\"' || c10 == '\'' || c10 == '/' || c10 == '\\')) {
                if (c10 == 'b') {
                    return 8;
                }
                if (c10 == 'f') {
                    return 12;
                }
                if (c10 == 'n') {
                    return 10;
                }
                if (c10 == 'r') {
                    return 13;
                }
                if (c10 == 't') {
                    return 9;
                }
                if (c10 != 'u') {
                    throw Z("Invalid escape sequence");
                } else if (i11 + 5 <= this.f12239e || p(4)) {
                    int i13 = this.f12238d;
                    int i14 = i13 + 4;
                    char c11 = 0;
                    while (i13 < i14) {
                        char c12 = this.f12237c[i13];
                        char c13 = (char) (c11 << 4);
                        if (c12 >= '0' && c12 <= '9') {
                            i10 = c12 - '0';
                        } else if (c12 >= 'a' && c12 <= 'f') {
                            i10 = c12 - 'W';
                        } else if (c12 < 'A' || c12 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f12237c, this.f12238d, 4));
                        } else {
                            i10 = c12 - '7';
                        }
                        c11 = (char) (c13 + i10);
                        i13++;
                    }
                    this.f12238d += 4;
                    return c11;
                } else {
                    throw Z("Unterminated escape sequence");
                }
            }
            return c10;
        }
        throw Z("Unterminated escape sequence");
    }

    private void U(char c10) {
        char[] cArr = this.f12237c;
        do {
            int i10 = this.f12238d;
            int i11 = this.f12239e;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f12238d = i12;
                    return;
                } else if (c11 == '\\') {
                    this.f12238d = i12;
                    S();
                    i10 = this.f12238d;
                    i11 = this.f12239e;
                } else {
                    if (c11 == 10) {
                        this.f12240f++;
                        this.f12241g = i12;
                    }
                    i10 = i12;
                }
            }
            this.f12238d = i10;
        } while (p(1));
        throw Z("Unterminated string");
    }

    private boolean V(String str) {
        int length = str.length();
        while (true) {
            int i10 = 0;
            if (this.f12238d + length > this.f12239e && !p(length)) {
                return false;
            }
            char[] cArr = this.f12237c;
            int i11 = this.f12238d;
            if (cArr[i11] == 10) {
                this.f12240f++;
                this.f12241g = i11 + 1;
            } else {
                while (i10 < length) {
                    if (this.f12237c[this.f12238d + i10] == str.charAt(i10)) {
                        i10++;
                    }
                }
                return true;
            }
            this.f12238d++;
        }
    }

    private void W() {
        char c10;
        do {
            if (this.f12238d < this.f12239e || p(1)) {
                char[] cArr = this.f12237c;
                int i10 = this.f12238d;
                int i11 = i10 + 1;
                this.f12238d = i11;
                c10 = cArr[i10];
                if (c10 == 10) {
                    this.f12240f++;
                    this.f12241g = i11;
                    return;
                }
            } else {
                return;
            }
        } while (c10 != 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        h();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void X() {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.f12238d
            int r2 = r1 + r0
            int r3 = r4.f12239e
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.f12237c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.h()
        L_0x004b:
            int r1 = r4.f12238d
            int r1 = r1 + r0
            r4.f12238d = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.f12238d = r1
            r0 = 1
            boolean r0 = r4.p(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.a.X():void");
    }

    private IOException Z(String str) {
        throw new d(str + B());
    }

    private void h() {
        if (!this.f12236b) {
            throw Z("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void j() {
        J(true);
        int i10 = this.f12238d;
        this.f12238d = i10 - 1;
        if (i10 + 4 <= this.f12239e || p(5)) {
            int i11 = this.f12238d;
            char[] cArr = this.f12237c;
            if (cArr[i11] == ')' && cArr[i11 + 1] == ']' && cArr[i11 + 2] == '}' && cArr[i11 + 3] == '\'' && cArr[i11 + 4] == 10) {
                this.f12238d = i11 + 5;
            }
        }
    }

    private boolean p(int i10) {
        int i11;
        int i12;
        char[] cArr = this.f12237c;
        int i13 = this.f12241g;
        int i14 = this.f12238d;
        this.f12241g = i13 - i14;
        int i15 = this.f12239e;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f12239e = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f12239e = 0;
        }
        this.f12238d = 0;
        do {
            Reader reader = this.f12235a;
            int i17 = this.f12239e;
            int read = reader.read(cArr, i17, cArr.length - i17);
            if (read == -1) {
                return false;
            }
            i11 = this.f12239e + read;
            this.f12239e = i11;
            if (this.f12240f == 0 && (i12 = this.f12241g) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f12238d++;
                this.f12241g = i12 + 1;
                i10++;
                continue;
            }
        } while (i11 < i10);
        return true;
    }

    private String v(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.X;
            if (i10 >= i11) {
                return sb2.toString();
            }
            int i12 = this.C[i10];
            if (i12 == 1 || i12 == 2) {
                int i13 = this.Z[i10];
                if (z10 && i13 > 0 && i10 == i11 - 1) {
                    i13--;
                }
                sb2.append('[');
                sb2.append(i13);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append(JwtParser.SEPARATOR_CHAR);
                String str = this.Y[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    /* access modifiers changed from: package-private */
    public String B() {
        return " at line " + (this.f12240f + 1) + " column " + ((this.f12238d - this.f12241g) + 1) + " path " + getPath();
    }

    public boolean C() {
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 5) {
            this.f12242h = 0;
            int[] iArr = this.Z;
            int i11 = this.X - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        } else if (i10 == 6) {
            this.f12242h = 0;
            int[] iArr2 = this.Z;
            int i12 = this.X - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + O() + B());
        }
    }

    public double E() {
        char c10;
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 15) {
            this.f12242h = 0;
            int[] iArr = this.Z;
            int i11 = this.X - 1;
            iArr[i11] = iArr[i11] + 1;
            return (double) this.f12243i;
        }
        if (i10 == 16) {
            this.f12245w = new String(this.f12237c, this.f12238d, this.f12244j);
            this.f12238d += this.f12244j;
        } else if (i10 == 8 || i10 == 9) {
            if (i10 == 8) {
                c10 = '\'';
            } else {
                c10 = '\"';
            }
            this.f12245w = L(c10);
        } else if (i10 == 10) {
            this.f12245w = N();
        } else if (i10 != 11) {
            throw new IllegalStateException("Expected a double but was " + O() + B());
        }
        this.f12242h = 11;
        double parseDouble = Double.parseDouble(this.f12245w);
        if (this.f12236b || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f12245w = null;
            this.f12242h = 0;
            int[] iArr2 = this.Z;
            int i12 = this.X - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return parseDouble;
        }
        throw new d("JSON forbids NaN and infinities: " + parseDouble + B());
    }

    public int G() {
        char c10;
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 15) {
            long j10 = this.f12243i;
            int i11 = (int) j10;
            if (j10 == ((long) i11)) {
                this.f12242h = 0;
                int[] iArr = this.Z;
                int i12 = this.X - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new NumberFormatException("Expected an int but was " + this.f12243i + B());
        }
        if (i10 == 16) {
            this.f12245w = new String(this.f12237c, this.f12238d, this.f12244j);
            this.f12238d += this.f12244j;
        } else if (i10 == 8 || i10 == 9 || i10 == 10) {
            if (i10 == 10) {
                this.f12245w = N();
            } else {
                if (i10 == 8) {
                    c10 = '\'';
                } else {
                    c10 = '\"';
                }
                this.f12245w = L(c10);
            }
            try {
                int parseInt = Integer.parseInt(this.f12245w);
                this.f12242h = 0;
                int[] iArr2 = this.Z;
                int i13 = this.X - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + O() + B());
        }
        this.f12242h = 11;
        double parseDouble = Double.parseDouble(this.f12245w);
        int i14 = (int) parseDouble;
        if (((double) i14) == parseDouble) {
            this.f12245w = null;
            this.f12242h = 0;
            int[] iArr3 = this.Z;
            int i15 = this.X - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        }
        throw new NumberFormatException("Expected an int but was " + this.f12245w + B());
    }

    public long H() {
        char c10;
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 15) {
            this.f12242h = 0;
            int[] iArr = this.Z;
            int i11 = this.X - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f12243i;
        }
        if (i10 == 16) {
            this.f12245w = new String(this.f12237c, this.f12238d, this.f12244j);
            this.f12238d += this.f12244j;
        } else if (i10 == 8 || i10 == 9 || i10 == 10) {
            if (i10 == 10) {
                this.f12245w = N();
            } else {
                if (i10 == 8) {
                    c10 = '\'';
                } else {
                    c10 = '\"';
                }
                this.f12245w = L(c10);
            }
            try {
                long parseLong = Long.parseLong(this.f12245w);
                this.f12242h = 0;
                int[] iArr2 = this.Z;
                int i12 = this.X - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + O() + B());
        }
        this.f12242h = 11;
        double parseDouble = Double.parseDouble(this.f12245w);
        long j10 = (long) parseDouble;
        if (((double) j10) == parseDouble) {
            this.f12245w = null;
            this.f12242h = 0;
            int[] iArr3 = this.Z;
            int i13 = this.X - 1;
            iArr3[i13] = iArr3[i13] + 1;
            return j10;
        }
        throw new NumberFormatException("Expected a long but was " + this.f12245w + B());
    }

    public String I() {
        String str;
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 14) {
            str = N();
        } else if (i10 == 12) {
            str = L('\'');
        } else if (i10 == 13) {
            str = L('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + O() + B());
        }
        this.f12242h = 0;
        this.Y[this.X - 1] = str;
        return str;
    }

    public void K() {
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 7) {
            this.f12242h = 0;
            int[] iArr = this.Z;
            int i11 = this.X - 1;
            iArr[i11] = iArr[i11] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + O() + B());
    }

    public String M() {
        String str;
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 10) {
            str = N();
        } else if (i10 == 8) {
            str = L('\'');
        } else if (i10 == 9) {
            str = L('\"');
        } else if (i10 == 11) {
            str = this.f12245w;
            this.f12245w = null;
        } else if (i10 == 15) {
            str = Long.toString(this.f12243i);
        } else if (i10 == 16) {
            str = new String(this.f12237c, this.f12238d, this.f12244j);
            this.f12238d += this.f12244j;
        } else {
            throw new IllegalStateException("Expected a string but was " + O() + B());
        }
        this.f12242h = 0;
        int[] iArr = this.Z;
        int i11 = this.X - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    public b O() {
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        switch (i10) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void T(boolean z10) {
        this.f12236b = z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        r7.f12242h = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Y() {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            int r2 = r7.f12242h
            if (r2 != 0) goto L_0x000a
            int r2 = r7.k()
        L_0x000a:
            r3 = 39
            r4 = 34
            java.lang.String r5 = "<skipped>"
            r6 = 1
            switch(r2) {
                case 1: goto L_0x006f;
                case 2: goto L_0x005f;
                case 3: goto L_0x0059;
                case 4: goto L_0x0051;
                case 5: goto L_0x0014;
                case 6: goto L_0x0014;
                case 7: goto L_0x0014;
                case 8: goto L_0x004d;
                case 9: goto L_0x0049;
                case 10: goto L_0x0045;
                case 11: goto L_0x0014;
                case 12: goto L_0x0038;
                case 13: goto L_0x002b;
                case 14: goto L_0x001e;
                case 15: goto L_0x0014;
                case 16: goto L_0x0016;
                case 17: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0074
        L_0x0015:
            return
        L_0x0016:
            int r2 = r7.f12238d
            int r3 = r7.f12244j
            int r2 = r2 + r3
            r7.f12238d = r2
            goto L_0x0074
        L_0x001e:
            r7.X()
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.Y
            int r3 = r7.X
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x002b:
            r7.U(r4)
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.Y
            int r3 = r7.X
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x0038:
            r7.U(r3)
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.Y
            int r3 = r7.X
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x0045:
            r7.X()
            goto L_0x0074
        L_0x0049:
            r7.U(r4)
            goto L_0x0074
        L_0x004d:
            r7.U(r3)
            goto L_0x0074
        L_0x0051:
            int r2 = r7.X
            int r2 = r2 - r6
            r7.X = r2
        L_0x0056:
            int r1 = r1 + -1
            goto L_0x0074
        L_0x0059:
            r7.R(r6)
        L_0x005c:
            int r1 = r1 + 1
            goto L_0x0074
        L_0x005f:
            if (r1 != 0) goto L_0x0069
            java.lang.String[] r2 = r7.Y
            int r3 = r7.X
            int r3 = r3 - r6
            r4 = 0
            r2[r3] = r4
        L_0x0069:
            int r2 = r7.X
            int r2 = r2 - r6
            r7.X = r2
            goto L_0x0056
        L_0x006f:
            r2 = 3
            r7.R(r2)
            goto L_0x005c
        L_0x0074:
            r7.f12242h = r0
            if (r1 > 0) goto L_0x0002
            int[] r0 = r7.Z
            int r1 = r7.X
            int r1 = r1 - r6
            r2 = r0[r1]
            int r2 = r2 + r6
            r0[r1] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.a.Y():void");
    }

    public void a() {
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 3) {
            R(1);
            this.Z[this.X - 1] = 0;
            this.f12242h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + O() + B());
    }

    public void b() {
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 1) {
            R(3);
            this.f12242h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + O() + B());
    }

    public void close() {
        this.f12242h = 0;
        this.C[0] = 8;
        this.X = 1;
        this.f12235a.close();
    }

    public String getPath() {
        return v(false);
    }

    /* access modifiers changed from: package-private */
    public int k() {
        int J;
        int[] iArr = this.C;
        int i10 = this.X;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int J2 = J(true);
            if (J2 != 44) {
                if (J2 == 59) {
                    h();
                } else if (J2 == 93) {
                    this.f12242h = 4;
                    return 4;
                } else {
                    throw Z("Unterminated array");
                }
            }
        } else if (i11 == 3 || i11 == 5) {
            iArr[i10 - 1] = 4;
            if (i11 == 5 && (J = J(true)) != 44) {
                if (J == 59) {
                    h();
                } else if (J == 125) {
                    this.f12242h = 2;
                    return 2;
                } else {
                    throw Z("Unterminated object");
                }
            }
            int J3 = J(true);
            if (J3 == 34) {
                this.f12242h = 13;
                return 13;
            } else if (J3 == 39) {
                h();
                this.f12242h = 12;
                return 12;
            } else if (J3 != 125) {
                h();
                this.f12238d--;
                if (A((char) J3)) {
                    this.f12242h = 14;
                    return 14;
                }
                throw Z("Expected name");
            } else if (i11 != 5) {
                this.f12242h = 2;
                return 2;
            } else {
                throw Z("Expected name");
            }
        } else if (i11 == 4) {
            iArr[i10 - 1] = 5;
            int J4 = J(true);
            if (J4 != 58) {
                if (J4 == 61) {
                    h();
                    if (this.f12238d < this.f12239e || p(1)) {
                        char[] cArr = this.f12237c;
                        int i12 = this.f12238d;
                        if (cArr[i12] == '>') {
                            this.f12238d = i12 + 1;
                        }
                    }
                } else {
                    throw Z("Expected ':'");
                }
            }
        } else if (i11 == 6) {
            if (this.f12236b) {
                j();
            }
            this.C[this.X - 1] = 7;
        } else if (i11 == 7) {
            if (J(false) == -1) {
                this.f12242h = 17;
                return 17;
            }
            h();
            this.f12238d--;
        } else if (i11 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int J5 = J(true);
        if (J5 == 34) {
            this.f12242h = 9;
            return 9;
        } else if (J5 != 39) {
            if (!(J5 == 44 || J5 == 59)) {
                if (J5 == 91) {
                    this.f12242h = 3;
                    return 3;
                } else if (J5 != 93) {
                    if (J5 != 123) {
                        this.f12238d--;
                        int P = P();
                        if (P != 0) {
                            return P;
                        }
                        int Q = Q();
                        if (Q != 0) {
                            return Q;
                        }
                        if (A(this.f12237c[this.f12238d])) {
                            h();
                            this.f12242h = 10;
                            return 10;
                        }
                        throw Z("Expected value");
                    }
                    this.f12242h = 1;
                    return 1;
                } else if (i11 == 1) {
                    this.f12242h = 4;
                    return 4;
                }
            }
            if (i11 == 1 || i11 == 2) {
                h();
                this.f12238d--;
                this.f12242h = 7;
                return 7;
            }
            throw Z("Unexpected value");
        } else {
            h();
            this.f12242h = 8;
            return 8;
        }
    }

    public void m() {
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 4) {
            int i11 = this.X;
            this.X = i11 - 1;
            int[] iArr = this.Z;
            int i12 = i11 - 2;
            iArr[i12] = iArr[i12] + 1;
            this.f12242h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + O() + B());
    }

    public void n() {
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 2) {
            int i11 = this.X;
            int i12 = i11 - 1;
            this.X = i12;
            this.Y[i12] = null;
            int[] iArr = this.Z;
            int i13 = i11 - 2;
            iArr[i13] = iArr[i13] + 1;
            this.f12242h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + O() + B());
    }

    public String toString() {
        return getClass().getSimpleName() + B();
    }

    public String w() {
        return v(true);
    }

    public boolean y() {
        int i10 = this.f12242h;
        if (i10 == 0) {
            i10 = k();
        }
        if (i10 == 2 || i10 == 4 || i10 == 17) {
            return false;
        }
        return true;
    }

    public final boolean z() {
        return this.f12236b;
    }
}
