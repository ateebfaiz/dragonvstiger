package com.alibaba.pdns;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import okio.Utf8;

public class c {

    private static class b extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f17863a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f17864b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f17865c;

        /* renamed from: d  reason: collision with root package name */
        private int f17866d = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f17867e = 18;

        /* renamed from: f  reason: collision with root package name */
        private int f17868f = -8;

        /* renamed from: g  reason: collision with root package name */
        private boolean f17869g = false;

        /* renamed from: h  reason: collision with root package name */
        private boolean f17870h = false;

        /* renamed from: i  reason: collision with root package name */
        private byte[] f17871i = new byte[1];

        b(InputStream inputStream, int[] iArr, boolean z10) {
            this.f17863a = inputStream;
            this.f17865c = iArr;
            this.f17864b = z10;
        }

        public int available() throws IOException {
            if (!this.f17870h) {
                return this.f17863a.available();
            }
            throw new IOException("Stream is closed");
        }

        public void close() throws IOException {
            if (!this.f17870h) {
                this.f17870h = true;
                this.f17863a.close();
            }
        }

        public int read() throws IOException {
            if (read(this.f17871i, 0, 1) == -1) {
                return -1;
            }
            return this.f17871i[0] & 255;
        }

        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12;
            int i13;
            if (this.f17870h) {
                throw new IOException("Stream is closed");
            } else if (this.f17869g && this.f17868f < 0) {
                return -1;
            } else {
                if (i10 < 0 || i11 < 0 || i11 > bArr.length - i10) {
                    throw new IndexOutOfBoundsException();
                }
                if (this.f17868f >= 0) {
                    int i14 = i10;
                    while (i11 != 0) {
                        i12 = i14 + 1;
                        int i15 = this.f17866d;
                        int i16 = this.f17868f;
                        bArr[i14] = (byte) (i15 >> i16);
                        i11--;
                        int i17 = i16 - 8;
                        this.f17868f = i17;
                        if (i17 < 0) {
                            this.f17866d = 0;
                        } else {
                            i14 = i12;
                        }
                    }
                    return i14 - i10;
                }
                i12 = i10;
                while (true) {
                    if (i11 <= 0) {
                        break;
                    }
                    int read = this.f17863a.read();
                    if (read == -1) {
                        this.f17869g = true;
                        int i18 = this.f17867e;
                        if (i18 != 18) {
                            if (i18 != 12) {
                                int i19 = i12 + 1;
                                int i20 = this.f17866d;
                                bArr[i12] = (byte) (i20 >> 16);
                                int i21 = i11 - 1;
                                if (i18 == 0) {
                                    if (i21 == 0) {
                                        this.f17866d = i20 >> 8;
                                        this.f17868f = 0;
                                    } else {
                                        i12 += 2;
                                        bArr[i19] = (byte) (i20 >> 8);
                                    }
                                }
                                i12 = i19;
                            } else {
                                throw new IOException("Base64 stream has one un-decoded dangling byte.");
                            }
                        }
                        if (i12 == i10) {
                            return -1;
                        }
                        return i12 - i10;
                    } else if (read == 61) {
                        int i22 = this.f17867e;
                        if (i22 == 18 || i22 == 12 || (i22 == 6 && this.f17863a.read() != 61)) {
                            throw new IOException("Illegal base64 ending sequence:" + this.f17867e);
                        }
                        int i23 = i12 + 1;
                        int i24 = this.f17866d;
                        bArr[i12] = (byte) (i24 >> 16);
                        int i25 = i11 - 1;
                        if (this.f17867e == 0) {
                            if (i25 == 0) {
                                this.f17866d = i24 >> 8;
                                this.f17868f = 0;
                            } else {
                                i13 = i12 + 2;
                                bArr[i23] = (byte) (i24 >> 8);
                                this.f17869g = true;
                            }
                        }
                        i13 = i23;
                        this.f17869g = true;
                    } else {
                        int i26 = this.f17865c[read];
                        if (i26 != -1) {
                            int i27 = this.f17866d;
                            int i28 = this.f17867e;
                            this.f17866d = (i26 << i28) | i27;
                            if (i28 == 0) {
                                this.f17867e = 18;
                                this.f17868f = 16;
                                while (true) {
                                    int i29 = this.f17868f;
                                    if (i29 < 0) {
                                        this.f17866d = 0;
                                        break;
                                    }
                                    int i30 = i12 + 1;
                                    bArr[i12] = (byte) (this.f17866d >> i29);
                                    i11--;
                                    int i31 = i29 - 8;
                                    this.f17868f = i31;
                                    if (i11 == 0 && i31 >= 0) {
                                        return i30 - i10;
                                    }
                                    i12 = i30;
                                }
                            } else {
                                this.f17867e = i28 - 6;
                            }
                        } else if (!this.f17864b) {
                            throw new IOException("Illegal base64 character " + Integer.toString(i26, 16));
                        }
                    }
                }
                return i12 - i10;
            }
        }
    }

    /* renamed from: com.alibaba.pdns.c$c  reason: collision with other inner class name */
    public static class C0228c {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final int[] f17872c;

        /* renamed from: d  reason: collision with root package name */
        private static final int[] f17873d;

        /* renamed from: e  reason: collision with root package name */
        static final C0228c f17874e = new C0228c(false, false);

        /* renamed from: f  reason: collision with root package name */
        static final C0228c f17875f = new C0228c(true, false);

        /* renamed from: g  reason: collision with root package name */
        static final C0228c f17876g = new C0228c(false, true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f17877a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f17878b;

        static {
            int[] iArr = new int[256];
            f17872c = iArr;
            Arrays.fill(iArr, -1);
            for (int i10 = 0; i10 < e.f17889e.length; i10++) {
                f17872c[e.f17889e[i10]] = i10;
            }
            f17872c[61] = -2;
            int[] iArr2 = new int[256];
            f17873d = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i11 = 0; i11 < e.f17890f.length; i11++) {
                f17873d[e.f17890f[i11]] = i11;
            }
            f17873d[61] = -2;
        }

        private C0228c(boolean z10, boolean z11) {
            this.f17877a = z10;
            this.f17878b = z11;
        }

        public byte[] a(byte[] bArr) {
            int a10 = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[a10];
            int a11 = a(bArr, 0, bArr.length, bArr2);
            return a11 != a10 ? Arrays.copyOf(bArr2, a11) : bArr2;
        }

        public byte[] a(String str) {
            return a(str.getBytes(StandardCharsets.ISO_8859_1));
        }

        public int a(byte[] bArr, byte[] bArr2) {
            if (bArr2.length >= a(bArr, 0, bArr.length)) {
                return a(bArr, 0, bArr.length, bArr2);
            }
            throw new IllegalArgumentException("Output byte array is too small for decoding all input bytes");
        }

        public ByteBuffer a(ByteBuffer byteBuffer) {
            int i10;
            int i11;
            byte[] bArr;
            int position = byteBuffer.position();
            try {
                if (byteBuffer.hasArray()) {
                    bArr = byteBuffer.array();
                    i11 = byteBuffer.arrayOffset() + byteBuffer.position();
                    i10 = byteBuffer.arrayOffset() + byteBuffer.limit();
                    byteBuffer.position(byteBuffer.limit());
                } else {
                    i10 = byteBuffer.remaining();
                    bArr = new byte[i10];
                    byteBuffer.get(bArr);
                    i11 = 0;
                }
                byte[] bArr2 = new byte[a(bArr, i11, i10)];
                return ByteBuffer.wrap(bArr2, 0, a(bArr, i11, i10, bArr2));
            } catch (IllegalArgumentException e10) {
                byteBuffer.position(position);
                throw e10;
            }
        }

        public InputStream a(InputStream inputStream) {
            Objects.requireNonNull(inputStream);
            return new b(inputStream, this.f17877a ? f17873d : f17872c, this.f17878b);
        }

        private int a(byte[] bArr, int i10, int i11) {
            int i12;
            int[] iArr = this.f17877a ? f17873d : f17872c;
            int i13 = i11 - i10;
            int i14 = 0;
            if (i13 == 0) {
                return 0;
            }
            if (i13 >= 2) {
                if (this.f17878b) {
                    int i15 = 0;
                    while (true) {
                        if (i10 >= i11) {
                            break;
                        }
                        int i16 = i10 + 1;
                        byte b10 = bArr[i10] & 255;
                        if (b10 == 61) {
                            i13 -= (i11 - i16) + 1;
                            break;
                        }
                        if (iArr[b10] == -1) {
                            i15++;
                        }
                        i10 = i16;
                    }
                    i13 -= i15;
                } else if (bArr[i11 - 1] == 61) {
                    i14 = bArr[i11 - 2] == 61 ? 2 : 1;
                }
                if (i14 == 0 && (i12 = i13 & 3) != 0) {
                    i14 = 4 - i12;
                }
                return (((i13 + 3) / 4) * 3) - i14;
            } else if (this.f17878b && iArr[0] == -1) {
                return 0;
            } else {
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
            if (r12[r8] == 61) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
            if (r4 != 18) goto L_0x007a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int a(byte[] r12, int r13, int r14, byte[] r15) {
            /*
                r11 = this;
                boolean r0 = r11.f17877a
                if (r0 == 0) goto L_0x0007
                int[] r0 = f17873d
                goto L_0x0009
            L_0x0007:
                int[] r0 = f17872c
            L_0x0009:
                r1 = 18
                r2 = 0
                r4 = r1
                r3 = r2
                r5 = r3
            L_0x000f:
                r6 = 6
                r7 = 16
                if (r13 >= r14) goto L_0x007a
                int r8 = r13 + 1
                byte r9 = r12[r13]
                r9 = r9 & 255(0xff, float:3.57E-43)
                r9 = r0[r9]
                if (r9 >= 0) goto L_0x005d
                r10 = -2
                if (r9 != r10) goto L_0x003a
                if (r4 != r6) goto L_0x002e
                if (r8 == r14) goto L_0x0032
                int r13 = r13 + 2
                byte r2 = r12[r8]
                r8 = 61
                if (r2 != r8) goto L_0x0032
                goto L_0x002f
            L_0x002e:
                r13 = r8
            L_0x002f:
                if (r4 == r1) goto L_0x0032
                goto L_0x007a
            L_0x0032:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.String r13 = "Input byte array has wrong 4-byte ending unit"
                r12.<init>(r13)
                throw r12
            L_0x003a:
                boolean r6 = r11.f17878b
                if (r6 == 0) goto L_0x0040
            L_0x003e:
                r13 = r8
                goto L_0x000f
            L_0x0040:
                java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                r15.<init>()
                java.lang.String r0 = "Illegal base64 character "
                r15.append(r0)
                byte r12 = r12[r13]
                java.lang.String r12 = java.lang.Integer.toString(r12, r7)
                r15.append(r12)
                java.lang.String r12 = r15.toString()
                r14.<init>(r12)
                throw r14
            L_0x005d:
                int r13 = r9 << r4
                r3 = r3 | r13
                int r4 = r4 + -6
                if (r4 >= 0) goto L_0x003e
                int r13 = r5 + 1
                int r4 = r3 >> 16
                byte r4 = (byte) r4
                r15[r5] = r4
                int r4 = r5 + 2
                int r6 = r3 >> 8
                byte r6 = (byte) r6
                r15[r13] = r6
                int r5 = r5 + 3
                byte r13 = (byte) r3
                r15[r4] = r13
                r4 = r1
                r3 = r2
                goto L_0x003e
            L_0x007a:
                if (r4 != r6) goto L_0x0085
                int r1 = r5 + 1
                int r2 = r3 >> 16
                byte r2 = (byte) r2
                r15[r5] = r2
                r5 = r1
                goto L_0x009a
            L_0x0085:
                if (r4 != 0) goto L_0x0096
                int r1 = r5 + 1
                int r2 = r3 >> 16
                byte r2 = (byte) r2
                r15[r5] = r2
                int r5 = r5 + 2
                int r2 = r3 >> 8
                byte r2 = (byte) r2
                r15[r1] = r2
                goto L_0x009a
            L_0x0096:
                r15 = 12
                if (r4 == r15) goto L_0x00c3
            L_0x009a:
                if (r13 >= r14) goto L_0x00c2
                boolean r15 = r11.f17878b
                if (r15 == 0) goto L_0x00ab
                int r15 = r13 + 1
                byte r13 = r12[r13]
                r13 = r0[r13]
                if (r13 >= 0) goto L_0x00aa
                r13 = r15
                goto L_0x009a
            L_0x00aa:
                r13 = r15
            L_0x00ab:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r15 = "Input byte array has incorrect ending byte at "
                r14.append(r15)
                r14.append(r13)
                java.lang.String r13 = r14.toString()
                r12.<init>(r13)
                throw r12
            L_0x00c2:
                return r5
            L_0x00c3:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.String r13 = "Last unit does not have enough valid bits"
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.c.C0228c.a(byte[], int, int, byte[]):int");
        }
    }

    public static class e {
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final char[] f17889e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final char[] f17890f = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};

        /* renamed from: g  reason: collision with root package name */
        private static final int f17891g = 76;

        /* renamed from: h  reason: collision with root package name */
        private static final byte[] f17892h;

        /* renamed from: i  reason: collision with root package name */
        static final e f17893i = new e(false, (byte[]) null, -1, true);

        /* renamed from: j  reason: collision with root package name */
        static final e f17894j = new e(true, (byte[]) null, -1, true);

        /* renamed from: k  reason: collision with root package name */
        static final e f17895k;

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f17896a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17897b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f17898c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f17899d;

        static {
            byte[] bArr = {13, 10};
            f17892h = bArr;
            f17895k = new e(false, bArr, f17891g, true);
        }

        private final int a(int i10) {
            int i11;
            if (this.f17899d) {
                i11 = ((i10 + 2) / 3) * 4;
            } else {
                int i12 = i10 % 3;
                i11 = ((i10 / 3) * 4) + (i12 == 0 ? 0 : i12 + 1);
            }
            int i13 = this.f17897b;
            return i13 > 0 ? i11 + (((i11 - 1) / i13) * this.f17896a.length) : i11;
        }

        private e(boolean z10, byte[] bArr, int i10, boolean z11) {
            this.f17898c = z10;
            this.f17896a = bArr;
            this.f17897b = i10;
            this.f17899d = z11;
        }

        public String b(byte[] bArr) {
            byte[] a10 = a(bArr);
            return new String(a10, 0, 0, a10.length);
        }

        public byte[] a(byte[] bArr) {
            int a10 = a(bArr.length);
            byte[] bArr2 = new byte[a10];
            int a11 = a(bArr, 0, bArr.length, bArr2);
            return a11 != a10 ? Arrays.copyOf(bArr2, a11) : bArr2;
        }

        public int a(byte[] bArr, byte[] bArr2) {
            if (bArr2.length >= a(bArr.length)) {
                return a(bArr, 0, bArr.length, bArr2);
            }
            throw new IllegalArgumentException("Output byte array is too small for encoding all input bytes");
        }

        public ByteBuffer a(ByteBuffer byteBuffer) {
            int i10;
            int a10 = a(byteBuffer.remaining());
            byte[] bArr = new byte[a10];
            if (byteBuffer.hasArray()) {
                i10 = a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.arrayOffset() + byteBuffer.limit(), bArr);
                byteBuffer.position(byteBuffer.limit());
            } else {
                int remaining = byteBuffer.remaining();
                byte[] bArr2 = new byte[remaining];
                byteBuffer.get(bArr2);
                i10 = a(bArr2, 0, remaining, bArr);
            }
            if (i10 != a10) {
                bArr = Arrays.copyOf(bArr, i10);
            }
            return ByteBuffer.wrap(bArr);
        }

        public OutputStream a(OutputStream outputStream) {
            Objects.requireNonNull(outputStream);
            return new d(outputStream, this.f17898c ? f17890f : f17889e, this.f17896a, this.f17897b, this.f17899d);
        }

        public e a() {
            if (!this.f17899d) {
                return this;
            }
            return new e(this.f17898c, this.f17896a, this.f17897b, false);
        }

        private int a(byte[] bArr, int i10, int i11, byte[] bArr2) {
            int i12;
            int i13 = i11;
            char[] cArr = this.f17898c ? f17890f : f17889e;
            int i14 = ((i13 - i10) / 3) * 3;
            int i15 = i10 + i14;
            int i16 = this.f17897b;
            if (i16 > 0 && i14 > (i12 = (i16 / 4) * 3)) {
                i14 = i12;
            }
            int i17 = i10;
            int i18 = 0;
            while (i17 < i15) {
                int min = Math.min(i17 + i14, i15);
                int i19 = i17;
                int i20 = i18;
                while (i19 < min) {
                    int i21 = i19 + 2;
                    int i22 = (bArr[i19 + 1] & 255) << 8;
                    i19 += 3;
                    byte b10 = i22 | ((bArr[i19] & 255) << 16) | (bArr[i21] & 255);
                    bArr2[i20] = (byte) cArr[(b10 >>> 18) & 63];
                    bArr2[i20 + 1] = (byte) cArr[(b10 >>> 12) & 63];
                    int i23 = i20 + 3;
                    bArr2[i20 + 2] = (byte) cArr[(b10 >>> 6) & 63];
                    i20 += 4;
                    bArr2[i23] = (byte) cArr[b10 & Utf8.REPLACEMENT_BYTE];
                }
                int i24 = ((min - i17) / 3) * 4;
                i18 += i24;
                if (i24 == this.f17897b && min < i13) {
                    byte[] bArr3 = this.f17896a;
                    int length = bArr3.length;
                    int i25 = 0;
                    while (i25 < length) {
                        bArr2[i18] = bArr3[i25];
                        i25++;
                        i18++;
                    }
                }
                i17 = min;
            }
            if (i17 >= i13) {
                return i18;
            }
            int i26 = i17 + 1;
            byte b11 = bArr[i17] & 255;
            int i27 = i18 + 1;
            bArr2[i18] = (byte) cArr[b11 >> 2];
            if (i26 == i13) {
                int i28 = i18 + 2;
                bArr2[i27] = (byte) cArr[(b11 << 4) & 63];
                if (!this.f17899d) {
                    return i28;
                }
                int i29 = i18 + 3;
                bArr2[i28] = 61;
                int i30 = i18 + 4;
                bArr2[i29] = 61;
                return i30;
            }
            byte b12 = bArr[i26] & 255;
            bArr2[i27] = (byte) cArr[((b11 << 4) & 63) | (b12 >> 4)];
            int i31 = i18 + 3;
            bArr2[i18 + 2] = (byte) cArr[(b12 << 2) & 63];
            if (!this.f17899d) {
                return i31;
            }
            int i32 = i18 + 4;
            bArr2[i31] = 61;
            return i32;
        }
    }

    private c() {
    }

    public static e a(int i10, byte[] bArr) {
        Objects.requireNonNull(bArr);
        int[] a10 = C0228c.f17872c;
        int length = bArr.length;
        int i11 = 0;
        while (i11 < length) {
            byte b10 = bArr[i11];
            if (a10[b10 & 255] == -1) {
                i11++;
            } else {
                throw new IllegalArgumentException("Illegal base64 line separator character 0x" + Integer.toString(b10, 16));
            }
        }
        if (i10 <= 0) {
            return e.f17893i;
        }
        return new e(false, bArr, (i10 >> 2) << 2, true);
    }

    public static e b() {
        return e.f17893i;
    }

    public static C0228c c() {
        return C0228c.f17876g;
    }

    public static e d() {
        return e.f17895k;
    }

    public static C0228c e() {
        return C0228c.f17875f;
    }

    public static e f() {
        return e.f17894j;
    }

    private static class d extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private int f17879a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f17880b;

        /* renamed from: c  reason: collision with root package name */
        private int f17881c;

        /* renamed from: d  reason: collision with root package name */
        private int f17882d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f17883e = false;

        /* renamed from: f  reason: collision with root package name */
        private final char[] f17884f;

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f17885g;

        /* renamed from: h  reason: collision with root package name */
        private final int f17886h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f17887i;

        /* renamed from: j  reason: collision with root package name */
        private int f17888j = 0;

        d(OutputStream outputStream, char[] cArr, byte[] bArr, int i10, boolean z10) {
            super(outputStream);
            this.f17884f = cArr;
            this.f17885g = bArr;
            this.f17886h = i10;
            this.f17887i = z10;
        }

        private void a() throws IOException {
            if (this.f17888j == this.f17886h) {
                this.out.write(this.f17885g);
                this.f17888j = 0;
            }
        }

        public void close() throws IOException {
            if (!this.f17883e) {
                this.f17883e = true;
                int i10 = this.f17879a;
                if (i10 == 1) {
                    a();
                    this.out.write(this.f17884f[this.f17880b >> 2]);
                    this.out.write(this.f17884f[(this.f17880b << 4) & 63]);
                    if (this.f17887i) {
                        this.out.write(61);
                        this.out.write(61);
                    }
                } else if (i10 == 2) {
                    a();
                    this.out.write(this.f17884f[this.f17880b >> 2]);
                    this.out.write(this.f17884f[((this.f17880b << 4) & 63) | (this.f17881c >> 4)]);
                    this.out.write(this.f17884f[(this.f17881c << 2) & 63]);
                    if (this.f17887i) {
                        this.out.write(61);
                    }
                }
                this.f17879a = 0;
                this.out.close();
            }
        }

        public void write(int i10) throws IOException {
            write(new byte[]{(byte) (i10 & 255)}, 0, 1);
        }

        public void write(byte[] bArr, int i10, int i11) throws IOException {
            if (this.f17883e) {
                throw new IOException("Stream is closed");
            } else if (i10 < 0 || i11 < 0 || i11 > bArr.length - i10) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (i11 != 0) {
                int i12 = this.f17879a;
                if (i12 != 0) {
                    if (i12 == 1) {
                        int i13 = i10 + 1;
                        this.f17881c = bArr[i10] & 255;
                        i11--;
                        if (i11 == 0) {
                            this.f17879a = i12 + 1;
                            return;
                        }
                        i10 = i13;
                    }
                    this.f17882d = bArr[i10] & 255;
                    i11--;
                    a();
                    this.out.write(this.f17884f[this.f17880b >> 2]);
                    this.out.write(this.f17884f[((this.f17880b << 4) & 63) | (this.f17881c >> 4)]);
                    this.out.write(this.f17884f[((this.f17881c << 2) & 63) | (this.f17882d >> 6)]);
                    this.out.write(this.f17884f[this.f17882d & 63]);
                    this.f17888j += 4;
                    i10++;
                }
                int i14 = i11 / 3;
                this.f17879a = i11 - (i14 * 3);
                while (true) {
                    int i15 = i14 - 1;
                    if (i14 <= 0) {
                        break;
                    }
                    a();
                    int i16 = i10 + 2;
                    int i17 = (bArr[i10 + 1] & 255) << 8;
                    i10 += 3;
                    byte b10 = i17 | ((bArr[i10] & 255) << 16) | (bArr[i16] & 255);
                    this.out.write(this.f17884f[(b10 >>> 18) & 63]);
                    this.out.write(this.f17884f[(b10 >>> 12) & 63]);
                    this.out.write(this.f17884f[(b10 >>> 6) & 63]);
                    this.out.write(this.f17884f[b10 & Utf8.REPLACEMENT_BYTE]);
                    this.f17888j += 4;
                    i14 = i15;
                }
                int i18 = this.f17879a;
                if (i18 == 1) {
                    this.f17880b = bArr[i10] & 255;
                } else if (i18 == 2) {
                    this.f17880b = bArr[i10] & 255;
                    this.f17881c = bArr[i10 + 1] & 255;
                }
            }
        }
    }

    public static C0228c a() {
        return C0228c.f17874e;
    }
}
