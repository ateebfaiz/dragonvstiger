package x0;

import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.internal.BufferKt;
import x0.c;

final class e extends c {
    private static final ByteString N0 = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString O0 = ByteString.encodeUtf8("\n\r");
    private static final ByteString P0 = ByteString.encodeUtf8("*/");
    private static final ByteString Y = ByteString.encodeUtf8("'\\");
    private static final ByteString Z = ByteString.encodeUtf8("\"\\");
    private int C;
    private String X;

    /* renamed from: h  reason: collision with root package name */
    private final BufferedSource f24700h;

    /* renamed from: i  reason: collision with root package name */
    private final Buffer f24701i;

    /* renamed from: j  reason: collision with root package name */
    private int f24702j = 0;

    /* renamed from: w  reason: collision with root package name */
    private long f24703w;

    e(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f24700h = bufferedSource;
            this.f24701i = bufferedSource.buffer();
            B(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void J() {
        if (!this.f24685e) {
            throw I("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int K() {
        int[] iArr = this.f24682b;
        int i10 = this.f24681a;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int N = N(true);
            this.f24701i.readByte();
            if (N != 44) {
                if (N == 59) {
                    J();
                } else if (N == 93) {
                    this.f24702j = 4;
                    return 4;
                } else {
                    throw I("Unterminated array");
                }
            }
        } else if (i11 == 3 || i11 == 5) {
            iArr[i10 - 1] = 4;
            if (i11 == 5) {
                int N2 = N(true);
                this.f24701i.readByte();
                if (N2 != 44) {
                    if (N2 == 59) {
                        J();
                    } else if (N2 == 125) {
                        this.f24702j = 2;
                        return 2;
                    } else {
                        throw I("Unterminated object");
                    }
                }
            }
            int N3 = N(true);
            if (N3 == 34) {
                this.f24701i.readByte();
                this.f24702j = 13;
                return 13;
            } else if (N3 == 39) {
                this.f24701i.readByte();
                J();
                this.f24702j = 12;
                return 12;
            } else if (N3 != 125) {
                J();
                if (M((char) N3)) {
                    this.f24702j = 14;
                    return 14;
                }
                throw I("Expected name");
            } else if (i11 != 5) {
                this.f24701i.readByte();
                this.f24702j = 2;
                return 2;
            } else {
                throw I("Expected name");
            }
        } else if (i11 == 4) {
            iArr[i10 - 1] = 5;
            int N4 = N(true);
            this.f24701i.readByte();
            if (N4 != 58) {
                if (N4 == 61) {
                    J();
                    if (this.f24700h.request(1) && this.f24701i.getByte(0) == 62) {
                        this.f24701i.readByte();
                    }
                } else {
                    throw I("Expected ':'");
                }
            }
        } else if (i11 == 6) {
            iArr[i10 - 1] = 7;
        } else if (i11 == 7) {
            if (N(false) == -1) {
                this.f24702j = 18;
                return 18;
            }
            J();
        } else if (i11 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int N5 = N(true);
        if (N5 == 34) {
            this.f24701i.readByte();
            this.f24702j = 9;
            return 9;
        } else if (N5 != 39) {
            if (!(N5 == 44 || N5 == 59)) {
                if (N5 == 91) {
                    this.f24701i.readByte();
                    this.f24702j = 3;
                    return 3;
                } else if (N5 != 93) {
                    if (N5 != 123) {
                        int Q = Q();
                        if (Q != 0) {
                            return Q;
                        }
                        int R = R();
                        if (R != 0) {
                            return R;
                        }
                        if (M(this.f24701i.getByte(0))) {
                            J();
                            this.f24702j = 10;
                            return 10;
                        }
                        throw I("Expected value");
                    }
                    this.f24701i.readByte();
                    this.f24702j = 1;
                    return 1;
                } else if (i11 == 1) {
                    this.f24701i.readByte();
                    this.f24702j = 4;
                    return 4;
                }
            }
            if (i11 == 1 || i11 == 2) {
                J();
                this.f24702j = 7;
                return 7;
            }
            throw I("Unexpected value");
        } else {
            J();
            this.f24701i.readByte();
            this.f24702j = 8;
            return 8;
        }
    }

    private int L(String str, c.a aVar) {
        int length = aVar.f24687a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(aVar.f24687a[i10])) {
                this.f24702j = 0;
                this.f24683c[this.f24681a - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    private boolean M(int i10) {
        if (i10 == 9 || i10 == 10 || i10 == 12 || i10 == 13 || i10 == 32) {
            return false;
        }
        if (i10 != 35) {
            if (i10 == 44) {
                return false;
            }
            if (!(i10 == 47 || i10 == 61)) {
                if (i10 == 123 || i10 == 125 || i10 == 58) {
                    return false;
                }
                if (i10 != 59) {
                    switch (i10) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        J();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.f24701i.skip((long) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r2 != 47) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r6.f24700h.request(2) != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        J();
        r3 = r6.f24701i.getByte(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r3 == 42) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r3 == 47) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        r6.f24701i.readByte();
        r6.f24701i.readByte();
        V();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r6.f24701i.readByte();
        r6.f24701i.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (U() == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        throw I("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
        if (r2 != 35) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0076, code lost:
        J();
        V();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int N(boolean r7) {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            okio.BufferedSource r2 = r6.f24700h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L_0x0080
            okio.Buffer r2 = r6.f24701i
            long r4 = (long) r1
            byte r2 = r2.getByte(r4)
            r4 = 10
            if (r2 == r4) goto L_0x007e
            r4 = 32
            if (r2 == r4) goto L_0x007e
            r4 = 13
            if (r2 == r4) goto L_0x007e
            r4 = 9
            if (r2 != r4) goto L_0x0025
            goto L_0x007e
        L_0x0025:
            okio.Buffer r3 = r6.f24701i
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L_0x0072
            okio.BufferedSource r3 = r6.f24700h
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L_0x003a
            return r2
        L_0x003a:
            r6.J()
            okio.Buffer r3 = r6.f24701i
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005a
            if (r3 == r1) goto L_0x004c
            return r2
        L_0x004c:
            okio.Buffer r1 = r6.f24701i
            r1.readByte()
            okio.Buffer r1 = r6.f24701i
            r1.readByte()
            r6.V()
            goto L_0x0001
        L_0x005a:
            okio.Buffer r1 = r6.f24701i
            r1.readByte()
            okio.Buffer r1 = r6.f24701i
            r1.readByte()
            boolean r1 = r6.U()
            if (r1 == 0) goto L_0x006b
            goto L_0x0001
        L_0x006b:
            java.lang.String r7 = "Unterminated comment"
            x0.b r7 = r6.I(r7)
            throw r7
        L_0x0072:
            r1 = 35
            if (r2 != r1) goto L_0x007d
            r6.J()
            r6.V()
            goto L_0x0001
        L_0x007d:
            return r2
        L_0x007e:
            r1 = r3
            goto L_0x0002
        L_0x0080:
            if (r7 != 0) goto L_0x0084
            r7 = -1
            return r7
        L_0x0084:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.e.N(boolean):int");
    }

    private String O(ByteString byteString) {
        StringBuilder sb2 = null;
        while (true) {
            long indexOfElement = this.f24700h.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw I("Unterminated string");
            } else if (this.f24701i.getByte(indexOfElement) == 92) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.f24701i.readUtf8(indexOfElement));
                this.f24701i.readByte();
                sb2.append(S());
            } else if (sb2 == null) {
                String readUtf8 = this.f24701i.readUtf8(indexOfElement);
                this.f24701i.readByte();
                return readUtf8;
            } else {
                sb2.append(this.f24701i.readUtf8(indexOfElement));
                this.f24701i.readByte();
                return sb2.toString();
            }
        }
    }

    private String P() {
        long indexOfElement = this.f24700h.indexOfElement(N0);
        if (indexOfElement != -1) {
            return this.f24701i.readUtf8(indexOfElement);
        }
        return this.f24701i.readUtf8();
    }

    private int Q() {
        int i10;
        String str;
        String str2;
        byte b10 = this.f24701i.getByte(0);
        if (b10 == 116 || b10 == 84) {
            str2 = "true";
            str = "TRUE";
            i10 = 5;
        } else if (b10 == 102 || b10 == 70) {
            str2 = "false";
            str = "FALSE";
            i10 = 6;
        } else if (b10 != 110 && b10 != 78) {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i10 = 7;
        }
        int length = str2.length();
        int i11 = 1;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (!this.f24700h.request((long) i12)) {
                return 0;
            }
            byte b11 = this.f24701i.getByte((long) i11);
            if (b11 != str2.charAt(i11) && b11 != str.charAt(i11)) {
                return 0;
            }
            i11 = i12;
        }
        if (this.f24700h.request((long) (length + 1)) && M(this.f24701i.getByte((long) length))) {
            return 0;
        }
        this.f24701i.skip((long) length);
        this.f24702j = i10;
        return i10;
    }

    private int R() {
        byte b10;
        char c10;
        boolean z10;
        boolean z11 = true;
        long j10 = 0;
        int i10 = 0;
        char c11 = 0;
        boolean z12 = false;
        boolean z13 = true;
        while (true) {
            int i11 = i10 + 1;
            if (!this.f24700h.request((long) i11)) {
                break;
            }
            b10 = this.f24701i.getByte((long) i10);
            if (b10 == 43) {
                c10 = 6;
                if (c11 != 5) {
                    return 0;
                }
            } else if (b10 != 69 && b10 != 101) {
                if (b10 == 45) {
                    c10 = 6;
                    if (c11 == 0) {
                        c11 = 1;
                        z12 = true;
                    } else if (c11 != 5) {
                        return 0;
                    }
                } else if (b10 != 46) {
                    if (b10 >= 48 && b10 <= 57) {
                        if (c11 == z11 || c11 == 0) {
                            j10 = (long) (-(b10 - 48));
                            c11 = 2;
                        } else if (c11 == 2) {
                            if (j10 == 0) {
                                return 0;
                            }
                            long j11 = (10 * j10) - ((long) (b10 - 48));
                            int i12 = (j10 > BufferKt.OVERFLOW_ZONE ? 1 : (j10 == BufferKt.OVERFLOW_ZONE ? 0 : -1));
                            if (i12 > 0 || (i12 == 0 && j11 < j10)) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            z13 &= z10;
                            j10 = j11;
                        } else if (c11 == 3) {
                            c11 = 4;
                        } else if (c11 == 5 || c11 == 6) {
                            c11 = 7;
                        }
                    }
                } else if (c11 != 2) {
                    return 0;
                } else {
                    c11 = 3;
                }
                i10 = i11;
                z11 = true;
            } else if (c11 != 2 && c11 != 4) {
                return 0;
            } else {
                c11 = 5;
                i10 = i11;
                z11 = true;
            }
            c11 = c10;
            i10 = i11;
            z11 = true;
        }
        if (M(b10)) {
            return 0;
        }
        if (c11 == 2 && z13 && ((j10 != Long.MIN_VALUE || z12) && (j10 != 0 || !z12))) {
            if (!z12) {
                j10 = -j10;
            }
            this.f24703w = j10;
            this.f24701i.skip((long) i10);
            this.f24702j = 16;
            return 16;
        } else if (c11 != 2 && c11 != 4 && c11 != 7) {
            return 0;
        } else {
            this.C = i10;
            this.f24702j = 17;
            return 17;
        }
    }

    private char S() {
        int i10;
        if (this.f24700h.request(1)) {
            byte readByte = this.f24701i.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return 12;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return 13;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                if (this.f24685e) {
                    return (char) readByte;
                }
                throw I("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.f24700h.request(4)) {
                char c10 = 0;
                for (int i11 = 0; i11 < 4; i11++) {
                    byte b10 = this.f24701i.getByte((long) i11);
                    char c11 = (char) (c10 << 4);
                    if (b10 >= 48 && b10 <= 57) {
                        i10 = b10 - 48;
                    } else if (b10 >= 97 && b10 <= 102) {
                        i10 = b10 - 87;
                    } else if (b10 < 65 || b10 > 70) {
                        throw I("\\u" + this.f24701i.readUtf8(4));
                    } else {
                        i10 = b10 - 55;
                    }
                    c10 = (char) (c11 + i10);
                }
                this.f24701i.skip(4);
                return c10;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + getPath());
            }
        } else {
            throw I("Unterminated escape sequence");
        }
    }

    private void T(ByteString byteString) {
        while (true) {
            long indexOfElement = this.f24700h.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw I("Unterminated string");
            } else if (this.f24701i.getByte(indexOfElement) == 92) {
                this.f24701i.skip(indexOfElement + 1);
                S();
            } else {
                this.f24701i.skip(indexOfElement + 1);
                return;
            }
        }
    }

    private boolean U() {
        boolean z10;
        long j10;
        BufferedSource bufferedSource = this.f24700h;
        ByteString byteString = P0;
        long indexOf = bufferedSource.indexOf(byteString);
        if (indexOf != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Buffer buffer = this.f24701i;
        if (z10) {
            j10 = indexOf + ((long) byteString.size());
        } else {
            j10 = buffer.size();
        }
        buffer.skip(j10);
        return z10;
    }

    private void V() {
        long j10;
        long indexOfElement = this.f24700h.indexOfElement(O0);
        Buffer buffer = this.f24701i;
        if (indexOfElement != -1) {
            j10 = indexOfElement + 1;
        } else {
            j10 = buffer.size();
        }
        buffer.skip(j10);
    }

    private void W() {
        long indexOfElement = this.f24700h.indexOfElement(N0);
        Buffer buffer = this.f24701i;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    public c.b A() {
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        switch (i10) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public int C(c.a aVar) {
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 < 12 || i10 > 15) {
            return -1;
        }
        if (i10 == 15) {
            return L(this.X, aVar);
        }
        int select = this.f24700h.select(aVar.f24688b);
        if (select != -1) {
            this.f24702j = 0;
            this.f24683c[this.f24681a - 1] = aVar.f24687a[select];
            return select;
        }
        String str = this.f24683c[this.f24681a - 1];
        String w10 = w();
        int L = L(w10, aVar);
        if (L == -1) {
            this.f24702j = 15;
            this.X = w10;
            this.f24683c[this.f24681a - 1] = str;
        }
        return L;
    }

    public void E() {
        if (!this.f24686f) {
            int i10 = this.f24702j;
            if (i10 == 0) {
                i10 = K();
            }
            if (i10 == 14) {
                W();
            } else if (i10 == 13) {
                T(Z);
            } else if (i10 == 12) {
                T(Y);
            } else if (i10 != 15) {
                throw new a("Expected a name but was " + A() + " at path " + getPath());
            }
            this.f24702j = 0;
            this.f24683c[this.f24681a - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + A() + " at " + getPath());
    }

    public void G() {
        if (!this.f24686f) {
            int i10 = 0;
            do {
                int i11 = this.f24702j;
                if (i11 == 0) {
                    i11 = K();
                }
                if (i11 == 3) {
                    B(1);
                } else if (i11 == 1) {
                    B(3);
                } else {
                    if (i11 == 4) {
                        i10--;
                        if (i10 >= 0) {
                            this.f24681a--;
                        } else {
                            throw new a("Expected a value but was " + A() + " at path " + getPath());
                        }
                    } else if (i11 == 2) {
                        i10--;
                        if (i10 >= 0) {
                            this.f24681a--;
                        } else {
                            throw new a("Expected a value but was " + A() + " at path " + getPath());
                        }
                    } else if (i11 == 14 || i11 == 10) {
                        W();
                    } else if (i11 == 9 || i11 == 13) {
                        T(Z);
                    } else if (i11 == 8 || i11 == 12) {
                        T(Y);
                    } else if (i11 == 17) {
                        this.f24701i.skip((long) this.C);
                    } else if (i11 == 18) {
                        throw new a("Expected a value but was " + A() + " at path " + getPath());
                    }
                    this.f24702j = 0;
                }
                i10++;
                this.f24702j = 0;
            } while (i10 != 0);
            int[] iArr = this.f24684d;
            int i12 = this.f24681a;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.f24683c[i12 - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + A() + " at " + getPath());
    }

    public void b() {
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 3) {
            B(1);
            this.f24684d[this.f24681a - 1] = 0;
            this.f24702j = 0;
            return;
        }
        throw new a("Expected BEGIN_ARRAY but was " + A() + " at path " + getPath());
    }

    public void close() {
        this.f24702j = 0;
        this.f24682b[0] = 8;
        this.f24681a = 1;
        this.f24701i.clear();
        this.f24700h.close();
    }

    public void h() {
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 1) {
            B(3);
            this.f24702j = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + A() + " at path " + getPath());
    }

    public void j() {
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 4) {
            int i11 = this.f24681a;
            this.f24681a = i11 - 1;
            int[] iArr = this.f24684d;
            int i12 = i11 - 2;
            iArr[i12] = iArr[i12] + 1;
            this.f24702j = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + A() + " at path " + getPath());
    }

    public void k() {
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 2) {
            int i11 = this.f24681a;
            int i12 = i11 - 1;
            this.f24681a = i12;
            this.f24683c[i12] = null;
            int[] iArr = this.f24684d;
            int i13 = i11 - 2;
            iArr[i13] = iArr[i13] + 1;
            this.f24702j = 0;
            return;
        }
        throw new a("Expected END_OBJECT but was " + A() + " at path " + getPath());
    }

    public boolean m() {
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 2 || i10 == 4 || i10 == 18) {
            return false;
        }
        return true;
    }

    public boolean n() {
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 5) {
            this.f24702j = 0;
            int[] iArr = this.f24684d;
            int i11 = this.f24681a - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        } else if (i10 == 6) {
            this.f24702j = 0;
            int[] iArr2 = this.f24684d;
            int i12 = this.f24681a - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        } else {
            throw new a("Expected a boolean but was " + A() + " at path " + getPath());
        }
    }

    public double p() {
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 16) {
            this.f24702j = 0;
            int[] iArr = this.f24684d;
            int i11 = this.f24681a - 1;
            iArr[i11] = iArr[i11] + 1;
            return (double) this.f24703w;
        }
        if (i10 == 17) {
            this.X = this.f24701i.readUtf8((long) this.C);
        } else if (i10 == 9) {
            this.X = O(Z);
        } else if (i10 == 8) {
            this.X = O(Y);
        } else if (i10 == 10) {
            this.X = P();
        } else if (i10 != 11) {
            throw new a("Expected a double but was " + A() + " at path " + getPath());
        }
        this.f24702j = 11;
        try {
            double parseDouble = Double.parseDouble(this.X);
            if (this.f24685e || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.X = null;
                this.f24702j = 0;
                int[] iArr2 = this.f24684d;
                int i12 = this.f24681a - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseDouble;
            }
            throw new b("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.X + " at path " + getPath());
        }
    }

    public String toString() {
        return "JsonReader(" + this.f24700h + ")";
    }

    public int v() {
        String str;
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 16) {
            long j10 = this.f24703w;
            int i11 = (int) j10;
            if (j10 == ((long) i11)) {
                this.f24702j = 0;
                int[] iArr = this.f24684d;
                int i12 = this.f24681a - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new a("Expected an int but was " + this.f24703w + " at path " + getPath());
        }
        if (i10 == 17) {
            this.X = this.f24701i.readUtf8((long) this.C);
        } else if (i10 == 9 || i10 == 8) {
            if (i10 == 9) {
                str = O(Z);
            } else {
                str = O(Y);
            }
            this.X = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.f24702j = 0;
                int[] iArr2 = this.f24684d;
                int i13 = this.f24681a - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i10 != 11) {
            throw new a("Expected an int but was " + A() + " at path " + getPath());
        }
        this.f24702j = 11;
        try {
            double parseDouble = Double.parseDouble(this.X);
            int i14 = (int) parseDouble;
            if (((double) i14) == parseDouble) {
                this.X = null;
                this.f24702j = 0;
                int[] iArr3 = this.f24684d;
                int i15 = this.f24681a - 1;
                iArr3[i15] = iArr3[i15] + 1;
                return i14;
            }
            throw new a("Expected an int but was " + this.X + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.X + " at path " + getPath());
        }
    }

    public String w() {
        String str;
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 14) {
            str = P();
        } else if (i10 == 13) {
            str = O(Z);
        } else if (i10 == 12) {
            str = O(Y);
        } else if (i10 == 15) {
            str = this.X;
        } else {
            throw new a("Expected a name but was " + A() + " at path " + getPath());
        }
        this.f24702j = 0;
        this.f24683c[this.f24681a - 1] = str;
        return str;
    }

    public String y() {
        String str;
        int i10 = this.f24702j;
        if (i10 == 0) {
            i10 = K();
        }
        if (i10 == 10) {
            str = P();
        } else if (i10 == 9) {
            str = O(Z);
        } else if (i10 == 8) {
            str = O(Y);
        } else if (i10 == 11) {
            str = this.X;
            this.X = null;
        } else if (i10 == 16) {
            str = Long.toString(this.f24703w);
        } else if (i10 == 17) {
            str = this.f24701i.readUtf8((long) this.C);
        } else {
            throw new a("Expected a string but was " + A() + " at path " + getPath());
        }
        this.f24702j = 0;
        int[] iArr = this.f24684d;
        int i11 = this.f24681a - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }
}
