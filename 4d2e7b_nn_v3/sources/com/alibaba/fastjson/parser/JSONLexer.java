package com.alibaba.fastjson.parser;

import com.adjust.sdk.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import okio.internal.BufferKt;

public final class JSONLexer {
    public static final char[] CA;
    public static final int END = 4;
    public static final char EOI = '\u001a';
    static final int[] IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    private static boolean V6 = false;
    public static final int VALUE = 3;
    protected static final int[] digits = new int[103];
    public static final boolean[] firstIdentifierFlags = new boolean[256];
    public static final boolean[] identifierFlags = new boolean[256];
    private static final ThreadLocal<char[]> sbufLocal = new ThreadLocal<>();
    protected int bp;
    public Calendar calendar;
    protected char ch;
    public boolean disableCircularReferenceDetect;
    protected int eofPos;
    protected boolean exp;
    public int features;
    protected long fieldHash;
    protected boolean hasSpecial;
    protected boolean isDouble;
    protected final int len;
    public Locale locale;
    public int matchStat;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected final String text;
    public TimeZone timeZone;
    protected int token;

    static {
        int i10;
        boolean z10;
        try {
            i10 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt((Object) null);
        } catch (Exception unused) {
            i10 = -1;
        }
        char c10 = 0;
        if (i10 >= 23) {
            z10 = true;
        } else {
            z10 = false;
        }
        V6 = z10;
        for (int i11 = 48; i11 <= 57; i11++) {
            digits[i11] = i11 - 48;
        }
        for (int i12 = 97; i12 <= 102; i12++) {
            digits[i12] = i12 - 87;
        }
        for (int i13 = 65; i13 <= 70; i13++) {
            digits[i13] = i13 - 55;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i14 = 0; i14 < length; i14++) {
            IA[CA[i14]] = i14;
        }
        IA[61] = 0;
        char c11 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c11 >= zArr.length) {
                break;
            }
            if (c11 >= 'A' && c11 <= 'Z') {
                zArr[c11] = true;
            } else if (c11 >= 'a' && c11 <= 'z') {
                zArr[c11] = true;
            } else if (c11 == '_') {
                zArr[c11] = true;
            }
            c11 = (char) (c11 + 1);
        }
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c10 < zArr2.length) {
                if (c10 >= 'A' && c10 <= 'Z') {
                    zArr2[c10] = true;
                } else if (c10 >= 'a' && c10 <= 'z') {
                    zArr2[c10] = true;
                } else if (c10 == '_') {
                    zArr2[c10] = true;
                } else if (c10 >= '0' && c10 <= '9') {
                    zArr2[c10] = true;
                }
                c10 = (char) (c10 + 1);
            } else {
                return;
            }
        }
    }

    public JSONLexer(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    static boolean checkDate(char c10, char c11, char c12, char c13, char c14, char c15, int i10, int i11) {
        if (c10 >= '1' && c10 <= '3' && c11 >= '0' && c11 <= '9' && c12 >= '0' && c12 <= '9' && c13 >= '0' && c13 <= '9') {
            if (c14 == '0') {
                if (c15 < '1' || c15 > '9') {
                    return false;
                }
            } else if (!(c14 == '1' && (c15 == '0' || c15 == '1' || c15 == '2'))) {
                return false;
            }
            return i10 == 48 ? i11 >= 49 && i11 <= 57 : (i10 == 49 || i10 == 50) ? i11 >= 48 && i11 <= 57 : i10 == 51 && (i11 == 48 || i11 == 49);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r5 <= '4') goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean checkTime(char r4, char r5, char r6, char r7, char r8, char r9) {
        /*
            r0 = 57
            r1 = 0
            r2 = 48
            if (r4 != r2) goto L_0x000c
            if (r5 < r2) goto L_0x000b
            if (r5 <= r0) goto L_0x0020
        L_0x000b:
            return r1
        L_0x000c:
            r3 = 49
            if (r4 != r3) goto L_0x0015
            if (r5 < r2) goto L_0x0014
            if (r5 <= r0) goto L_0x0020
        L_0x0014:
            return r1
        L_0x0015:
            r3 = 50
            if (r4 != r3) goto L_0x0042
            if (r5 < r2) goto L_0x0042
            r4 = 52
            if (r5 <= r4) goto L_0x0020
            goto L_0x0042
        L_0x0020:
            r4 = 54
            r5 = 53
            if (r6 < r2) goto L_0x002d
            if (r6 > r5) goto L_0x002d
            if (r7 < r2) goto L_0x002c
            if (r7 <= r0) goto L_0x0032
        L_0x002c:
            return r1
        L_0x002d:
            if (r6 != r4) goto L_0x0042
            if (r7 == r2) goto L_0x0032
            return r1
        L_0x0032:
            if (r8 < r2) goto L_0x003b
            if (r8 > r5) goto L_0x003b
            if (r9 < r2) goto L_0x003a
            if (r9 <= r0) goto L_0x0040
        L_0x003a:
            return r1
        L_0x003b:
            if (r8 != r4) goto L_0x0042
            if (r9 == r2) goto L_0x0040
            return r1
        L_0x0040:
            r4 = 1
            return r4
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.checkTime(char, char, char, char, char, char):boolean");
    }

    public static final byte[] decodeFast(String str, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        String str2 = str;
        int i16 = i11;
        if (i16 == 0) {
            return new byte[0];
        }
        int i17 = (i10 + i16) - 1;
        int i18 = i10;
        while (i12 < i17 && IA[str2.charAt(i12)] < 0) {
            i18 = i12 + 1;
        }
        while (i17 > 0 && IA[str2.charAt(i17)] < 0) {
            i17--;
        }
        if (str2.charAt(i17) != '=') {
            i13 = 0;
        } else if (str2.charAt(i17 - 1) == '=') {
            i13 = 2;
        } else {
            i13 = 1;
        }
        int i19 = (i17 - i12) + 1;
        if (i16 > 76) {
            if (str2.charAt(76) == 13) {
                i15 = i19 / 78;
            } else {
                i15 = 0;
            }
            i14 = i15 << 1;
        } else {
            i14 = 0;
        }
        int i20 = (((i19 - i14) * 6) >> 3) - i13;
        byte[] bArr = new byte[i20];
        int i21 = (i20 / 3) * 3;
        int i22 = 0;
        int i23 = 0;
        while (i22 < i21) {
            int[] iArr = IA;
            int i24 = i12 + 4;
            int i25 = iArr[str2.charAt(i12 + 3)] | (iArr[str2.charAt(i12 + 1)] << 12) | (iArr[str2.charAt(i12)] << 18) | (iArr[str2.charAt(i12 + 2)] << 6);
            bArr[i22] = (byte) (i25 >> 16);
            int i26 = i22 + 2;
            bArr[i22 + 1] = (byte) (i25 >> 8);
            i22 += 3;
            bArr[i26] = (byte) i25;
            if (i14 <= 0 || (i23 = i23 + 1) != 19) {
                i12 = i24;
            } else {
                i12 += 6;
                i23 = 0;
            }
        }
        if (i22 < i20) {
            int i27 = 0;
            int i28 = 0;
            while (i12 <= i17 - i13) {
                i27 |= IA[str2.charAt(i12)] << (18 - (i28 * 6));
                i28++;
                i12++;
            }
            int i29 = 16;
            while (i22 < i20) {
                bArr[i22] = (byte) (i27 >> i29);
                i29 -= 8;
                i22++;
            }
        }
        return bArr;
    }

    private int matchFieldHash(long j10) {
        char c10;
        char charAt;
        char c11 = this.ch;
        int i10 = 1;
        while (c11 != '\"' && c11 != '\'') {
            if (c11 == ' ' || c11 == 10 || c11 == 13 || c11 == 9 || c11 == 12 || c11 == 8) {
                int i11 = i10 + 1;
                int i12 = this.bp + i10;
                if (i12 >= this.len) {
                    c11 = EOI;
                } else {
                    c11 = this.text.charAt(i12);
                }
                i10 = i11;
            } else {
                this.fieldHash = 0;
                this.matchStat = -2;
                return 0;
            }
        }
        int i13 = this.bp + i10;
        long j11 = -3750763034362895579L;
        while (true) {
            if (i13 >= this.len) {
                break;
            }
            char charAt2 = this.text.charAt(i13);
            if (charAt2 == c11) {
                i10 += (i13 - this.bp) - i10;
                break;
            }
            j11 = (((long) charAt2) ^ j11) * 1099511628211L;
            i13++;
        }
        if (j11 != j10) {
            this.fieldHash = j11;
            this.matchStat = -2;
            return 0;
        }
        int i14 = i10 + 1;
        int i15 = this.bp + i14;
        if (i15 >= this.len) {
            c10 = EOI;
        } else {
            c10 = this.text.charAt(i15);
        }
        while (c10 != ':') {
            if (c10 > ' ' || !(c10 == ' ' || c10 == 10 || c10 == 13 || c10 == 9 || c10 == 12 || c10 == 8)) {
                throw new JSONException("match feild error expect ':'");
            }
            int i16 = i14 + 1;
            int i17 = this.bp + i14;
            if (i17 >= this.len) {
                charAt = EOI;
            } else {
                charAt = this.text.charAt(i17);
            }
            i14 = i16;
        }
        return i14 + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
        r12 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        r9 = r1;
        r8 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String readString(char[] r17, int r18) {
        /*
            r0 = r18
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            char[] r6 = new char[r0]
            r7 = 0
            r8 = r7
            r9 = r8
        L_0x000c:
            if (r8 >= r0) goto L_0x0118
            char r10 = r17[r8]
            r11 = 92
            if (r10 == r11) goto L_0x001c
            int r11 = r9 + 1
            r6[r9] = r10
            r12 = r1
            r9 = r11
            goto L_0x0114
        L_0x001c:
            int r10 = r8 + 1
            char r12 = r17[r10]
            r13 = 34
            if (r12 == r13) goto L_0x010e
            r13 = 39
            if (r12 == r13) goto L_0x0108
            r13 = 70
            if (r12 == r13) goto L_0x00f1
            if (r12 == r11) goto L_0x00fb
            r11 = 98
            if (r12 == r11) goto L_0x00f3
            r11 = 102(0x66, float:1.43E-43)
            if (r12 == r11) goto L_0x00f1
            r11 = 110(0x6e, float:1.54E-43)
            if (r12 == r11) goto L_0x00e9
            r11 = 114(0x72, float:1.6E-43)
            if (r12 == r11) goto L_0x00e1
            r11 = 120(0x78, float:1.68E-43)
            r13 = 16
            if (r12 == r11) goto L_0x00ca
            switch(r12) {
                case 47: goto L_0x00c2;
                case 48: goto L_0x00bc;
                case 49: goto L_0x00b6;
                case 50: goto L_0x00b0;
                case 51: goto L_0x00aa;
                case 52: goto L_0x00a4;
                case 53: goto L_0x009d;
                case 54: goto L_0x0097;
                case 55: goto L_0x0091;
                default: goto L_0x0047;
            }
        L_0x0047:
            switch(r12) {
                case 116: goto L_0x0088;
                case 117: goto L_0x005d;
                case 118: goto L_0x0052;
                default: goto L_0x004a;
            }
        L_0x004a:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "unclosed.str.lit"
            r0.<init>(r1)
            throw r0
        L_0x0052:
            int r8 = r9 + 1
            r11 = 11
            r6[r9] = r11
            r12 = r1
            r9 = r8
        L_0x005a:
            r8 = r10
            goto L_0x0114
        L_0x005d:
            int r10 = r9 + 1
            java.lang.String r11 = new java.lang.String
            int r12 = r8 + 2
            char r12 = r17[r12]
            int r14 = r8 + 3
            char r14 = r17[r14]
            int r15 = r8 + 4
            char r15 = r17[r15]
            int r8 = r8 + r1
            char r16 = r17[r8]
            char[] r1 = new char[r2]
            r1[r7] = r12
            r1[r5] = r14
            r1[r4] = r15
            r1[r3] = r16
            r11.<init>(r1)
            int r1 = java.lang.Integer.parseInt(r11, r13)
            char r1 = (char) r1
            r6[r9] = r1
            r9 = r10
        L_0x0085:
            r12 = 5
            goto L_0x0114
        L_0x0088:
            int r1 = r9 + 1
            r8 = 9
            r6[r9] = r8
        L_0x008e:
            r9 = r1
            r8 = r10
            goto L_0x0085
        L_0x0091:
            int r1 = r9 + 1
            r8 = 7
            r6[r9] = r8
            goto L_0x008e
        L_0x0097:
            int r1 = r9 + 1
            r8 = 6
            r6[r9] = r8
            goto L_0x008e
        L_0x009d:
            int r1 = r9 + 1
            r12 = 5
            r6[r9] = r12
        L_0x00a2:
            r9 = r1
            goto L_0x005a
        L_0x00a4:
            r12 = r1
            int r1 = r9 + 1
            r6[r9] = r2
            goto L_0x00a2
        L_0x00aa:
            r12 = r1
            int r1 = r9 + 1
            r6[r9] = r3
            goto L_0x00a2
        L_0x00b0:
            r12 = r1
            int r1 = r9 + 1
            r6[r9] = r4
            goto L_0x00a2
        L_0x00b6:
            r12 = r1
            int r1 = r9 + 1
            r6[r9] = r5
            goto L_0x00a2
        L_0x00bc:
            r12 = r1
            int r1 = r9 + 1
            r6[r9] = r7
            goto L_0x00a2
        L_0x00c2:
            r12 = r1
            int r1 = r9 + 1
            r8 = 47
            r6[r9] = r8
            goto L_0x00a2
        L_0x00ca:
            r12 = r1
            int r1 = r9 + 1
            int[] r10 = digits
            int r11 = r8 + 2
            char r11 = r17[r11]
            r11 = r10[r11]
            int r11 = r11 * r13
            int r8 = r8 + r3
            char r13 = r17[r8]
            r10 = r10[r13]
            int r11 = r11 + r10
            char r10 = (char) r11
            r6[r9] = r10
            r9 = r1
            goto L_0x0114
        L_0x00e1:
            r12 = r1
            int r1 = r9 + 1
            r8 = 13
            r6[r9] = r8
            goto L_0x00a2
        L_0x00e9:
            r12 = r1
            int r1 = r9 + 1
            r8 = 10
            r6[r9] = r8
            goto L_0x00a2
        L_0x00f1:
            r12 = r1
            goto L_0x0101
        L_0x00f3:
            r12 = r1
            int r1 = r9 + 1
            r8 = 8
            r6[r9] = r8
            goto L_0x00a2
        L_0x00fb:
            r12 = r1
            int r1 = r9 + 1
            r6[r9] = r11
            goto L_0x00a2
        L_0x0101:
            int r1 = r9 + 1
            r8 = 12
            r6[r9] = r8
            goto L_0x00a2
        L_0x0108:
            r12 = r1
            int r1 = r9 + 1
            r6[r9] = r13
            goto L_0x00a2
        L_0x010e:
            r12 = r1
            int r1 = r9 + 1
            r6[r9] = r13
            goto L_0x00a2
        L_0x0114:
            int r8 = r8 + r5
            r1 = r12
            goto L_0x000c
        L_0x0118:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r6, r7, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.readString(char[], int):java.lang.String");
    }

    private void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if (stringVal.equals("null")) {
            this.token = 8;
        } else if (stringVal.equals("true")) {
            this.token = 6;
        } else if (stringVal.equals("false")) {
            this.token = 7;
        } else if (stringVal.equals("new")) {
            this.token = 9;
        } else if (stringVal.equals("undefined")) {
            this.token = 23;
        } else if (stringVal.equals("Set")) {
            this.token = 21;
        } else if (stringVal.equals("TreeSet")) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    private void setCalendar(char c10, char c11, char c12, char c13, char c14, char c15, char c16, char c17) {
        Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = instance;
        instance.set(1, ((c10 - '0') * 1000) + ((c11 - '0') * 100) + ((c12 - '0') * 10) + (c13 - '0'));
        this.calendar.set(2, (((c14 - '0') * 10) + (c15 - '0')) - 1);
        this.calendar.set(5, ((c16 - '0') * 10) + (c17 - '0'));
    }

    private final String subString(int i10, int i11) {
        char[] cArr = this.sbuf;
        if (i11 < cArr.length) {
            this.text.getChars(i10, i10 + i11, cArr, 0);
            return new String(this.sbuf, 0, i11);
        }
        char[] cArr2 = new char[i11];
        this.text.getChars(i10, i11 + i10, cArr2, 0);
        return new String(cArr2);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.np + 1, this.sp);
    }

    /* access modifiers changed from: protected */
    public char charAt(int i10) {
        if (i10 >= this.len) {
            return EOI;
        }
        return this.text.charAt(i10);
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final void config(Feature feature, boolean z10) {
        boolean z11;
        String str;
        if (z10) {
            this.features |= feature.mask;
        } else {
            this.features &= ~feature.mask;
        }
        if (feature == Feature.InitStringFieldAsEmpty) {
            if (z10) {
                str = "";
            } else {
                str = null;
            }
            this.stringDefaultValue = str;
        }
        if ((this.features & Feature.DisableCircularReferenceDetect.mask) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.disableCircularReferenceDetect = z11;
    }

    public final Number decimalValue(boolean z10) {
        char c10;
        char[] cArr;
        boolean z11;
        int i10 = (this.np + this.sp) - 1;
        if (i10 >= this.len) {
            c10 = EOI;
        } else {
            c10 = this.text.charAt(i10);
        }
        if (c10 == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(numberString()));
            } catch (NumberFormatException e10) {
                throw new JSONException(e10.getMessage() + ", " + info());
            }
        } else if (c10 == 'D') {
            return Double.valueOf(Double.parseDouble(numberString()));
        } else {
            if (z10) {
                return decimalValue();
            }
            char charAt = this.text.charAt((this.np + this.sp) - 1);
            int i11 = this.sp;
            if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
                i11--;
            }
            int i12 = this.np;
            char[] cArr2 = this.sbuf;
            int i13 = 0;
            if (i11 < cArr2.length) {
                this.text.getChars(i12, i12 + i11, cArr2, 0);
                cArr = this.sbuf;
            } else {
                char[] cArr3 = new char[i11];
                this.text.getChars(i12, i12 + i11, cArr3, 0);
                cArr = cArr3;
            }
            if (i11 > 9 || this.exp) {
                return Double.valueOf(Double.parseDouble(new String(cArr, 0, i11)));
            }
            char c11 = cArr[0];
            int i14 = 2;
            if (c11 == '-') {
                c11 = cArr[1];
                z11 = true;
            } else {
                if (c11 == '+') {
                    c11 = cArr[1];
                } else {
                    i14 = 1;
                }
                z11 = false;
            }
            int i15 = c11 - '0';
            while (i14 < i11) {
                char c12 = cArr[i14];
                if (c12 == '.') {
                    i13 = 1;
                } else {
                    i15 = (i15 * 10) + (c12 - '0');
                    if (i13 != 0) {
                        i13 *= 10;
                    }
                }
                i14++;
            }
            double d10 = ((double) i15) / ((double) i13);
            if (z11) {
                d10 = -d10;
            }
            return Double.valueOf(d10);
        }
    }

    public String info() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pos ");
        sb2.append(this.bp);
        sb2.append(", json : ");
        if (this.len < 65536) {
            str = this.text;
        } else {
            str = this.text.substring(0, 65536);
        }
        sb2.append(str);
        return sb2.toString();
    }

    public final int intValue() {
        char c10;
        boolean z10;
        int i10;
        char c11;
        char c12;
        int i11 = this.np;
        int i12 = this.sp + i11;
        if (i11 >= this.len) {
            c10 = 26;
        } else {
            c10 = this.text.charAt(i11);
        }
        int i13 = 0;
        if (c10 == '-') {
            i11++;
            i10 = Integer.MIN_VALUE;
            z10 = true;
        } else {
            i10 = -2147483647;
            z10 = false;
        }
        if (i11 < i12) {
            int i14 = i11 + 1;
            if (i11 >= this.len) {
                c12 = 26;
            } else {
                c12 = this.text.charAt(i11);
            }
            int i15 = i14;
            i13 = -(c12 - '0');
            i11 = i15;
        }
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int i16 = i11 + 1;
            if (i11 >= this.len) {
                c11 = 26;
            } else {
                c11 = this.text.charAt(i11);
            }
            if (c11 == 'L' || c11 == 'S' || c11 == 'B') {
                i11 = i16;
            } else {
                int i17 = c11 - '0';
                if (i13 >= -214748364) {
                    int i18 = i13 * 10;
                    if (i18 >= i10 + i17) {
                        i13 = i18 - i17;
                        i11 = i16;
                    } else {
                        throw new NumberFormatException(numberString());
                    }
                } else {
                    throw new NumberFormatException(numberString());
                }
            }
        }
        if (!z10) {
            return -i13;
        }
        if (i11 > this.np + 1) {
            return i13;
        }
        throw new NumberFormatException(numberString());
    }

    public final Number integerValue() throws NumberFormatException {
        char c10;
        char c11;
        char c12;
        long j10;
        boolean z10;
        long j11;
        char c13;
        char c14;
        int i10 = this.np;
        int i11 = this.sp + i10;
        int i12 = i11 - 1;
        if (i12 >= this.len) {
            c10 = EOI;
        } else {
            c10 = this.text.charAt(i12);
        }
        if (c10 == 'B') {
            i11--;
            c11 = 'B';
        } else if (c10 == 'L') {
            i11--;
            c11 = 'L';
        } else if (c10 != 'S') {
            c11 = ' ';
        } else {
            i11--;
            c11 = 'S';
        }
        int i13 = this.np;
        if (i13 >= this.len) {
            c12 = EOI;
        } else {
            c12 = this.text.charAt(i13);
        }
        if (c12 == '-') {
            i10++;
            j10 = Long.MIN_VALUE;
            z10 = true;
        } else {
            z10 = false;
            j10 = -9223372036854775807L;
        }
        if (i10 < i11) {
            int i14 = i10 + 1;
            if (i10 >= this.len) {
                c14 = EOI;
            } else {
                c14 = this.text.charAt(i10);
            }
            j11 = (long) (-(c14 - '0'));
            i10 = i14;
        } else {
            j11 = 0;
        }
        while (i10 < i11) {
            int i15 = i10 + 1;
            if (i10 >= this.len) {
                c13 = EOI;
            } else {
                c13 = this.text.charAt(i10);
            }
            int i16 = c13 - '0';
            if (j11 < BufferKt.OVERFLOW_ZONE) {
                return new BigInteger(numberString());
            }
            long j12 = j11 * 10;
            long j13 = (long) i16;
            if (j12 < j10 + j13) {
                return new BigInteger(numberString());
            }
            j11 = j12 - j13;
            i10 = i15;
        }
        if (!z10) {
            long j14 = -j11;
            if (j14 > 2147483647L || c11 == 'L') {
                return Long.valueOf(j14);
            }
            if (c11 == 'S') {
                return Short.valueOf((short) ((int) j14));
            }
            if (c11 == 'B') {
                return Byte.valueOf((byte) ((int) j14));
            }
            return Integer.valueOf((int) j14);
        } else if (i10 <= this.np + 1) {
            throw new NumberFormatException(numberString());
        } else if (j11 < -2147483648L || c11 == 'L') {
            return Long.valueOf(j11);
        } else {
            if (c11 == 'S') {
                return Short.valueOf((short) ((int) j11));
            }
            if (c11 == 'B') {
                return Byte.valueOf((byte) ((int) j11));
            }
            return Integer.valueOf((int) j11);
        }
    }

    public final boolean isBlankInput() {
        int i10 = 0;
        while (true) {
            char charAt = charAt(i10);
            if (charAt == 26) {
                return true;
            }
            if (charAt > ' ' || (charAt != ' ' && charAt != 10 && charAt != 13 && charAt != 9 && charAt != 12 && charAt != 8)) {
                return false;
            }
            i10++;
        }
        return false;
    }

    public final boolean isEnabled(Feature feature) {
        if ((feature.mask & this.features) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r2 = r13.charAt(r0)
            r3 = 45
            r4 = 1
            if (r2 != r3) goto L_0x0015
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r5 = r2
            r2 = r4
            goto L_0x001b
        L_0x0015:
            r2 = 0
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x001b:
            if (r0 >= r1) goto L_0x0029
            int r3 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + -48
            int r0 = -r0
            long r7 = (long) r0
        L_0x0027:
            r0 = r3
            goto L_0x002b
        L_0x0029:
            r7 = 0
        L_0x002b:
            if (r0 >= r1) goto L_0x0075
            int r3 = r0 + 1
            int r9 = r13.len
            if (r0 < r9) goto L_0x0036
            r0 = 26
            goto L_0x003c
        L_0x0036:
            java.lang.String r9 = r13.text
            char r0 = r9.charAt(r0)
        L_0x003c:
            r9 = 76
            if (r0 == r9) goto L_0x0074
            r9 = 83
            if (r0 == r9) goto L_0x0074
            r9 = 66
            if (r0 != r9) goto L_0x0049
            goto L_0x0074
        L_0x0049:
            int r0 = r0 + -48
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x006a
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r5 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x0060
            long r7 = r7 - r9
            goto L_0x0027
        L_0x0060:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L_0x006a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0074:
            r0 = r3
        L_0x0075:
            if (r2 == 0) goto L_0x0087
            int r1 = r13.np
            int r1 = r1 + r4
            if (r0 <= r1) goto L_0x007d
            return r7
        L_0x007d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0087:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.longValue():long");
    }

    public boolean matchField(long j10) {
        char c10;
        char c11;
        char c12;
        char c13;
        char c14;
        char charAt;
        char c15 = this.ch;
        int i10 = this.bp + 1;
        int i11 = 1;
        while (c15 != '\"' && c15 != '\'') {
            if (c15 > ' ' || !(c15 == ' ' || c15 == 10 || c15 == 13 || c15 == 9 || c15 == 12 || c15 == 8)) {
                this.fieldHash = 0;
                this.matchStat = -2;
                return false;
            }
            int i12 = i11 + 1;
            int i13 = this.bp + i11;
            if (i13 >= this.len) {
                c15 = EOI;
            } else {
                c15 = this.text.charAt(i13);
            }
            i11 = i12;
        }
        int i14 = i10;
        long j11 = -3750763034362895579L;
        while (true) {
            if (i14 >= this.len) {
                break;
            }
            char charAt2 = this.text.charAt(i14);
            if (charAt2 == c15) {
                i11 += (i14 - i10) + 1;
                break;
            }
            j11 = 1099511628211L * (j11 ^ ((long) charAt2));
            i14++;
        }
        if (j11 != j10) {
            this.matchStat = -2;
            this.fieldHash = j11;
            return false;
        }
        int i15 = i11 + 1;
        int i16 = this.bp + i11;
        if (i16 >= this.len) {
            c10 = EOI;
        } else {
            c10 = this.text.charAt(i16);
        }
        while (c10 != ':') {
            if (c10 > ' ' || !(c10 == ' ' || c10 == 10 || c10 == 13 || c10 == 9 || c10 == 12 || c10 == 8)) {
                throw new JSONException("match feild error expect ':'");
            }
            int i17 = i15 + 1;
            int i18 = this.bp + i15;
            if (i18 >= this.len) {
                charAt = EOI;
            } else {
                charAt = this.text.charAt(i18);
            }
            i15 = i17;
        }
        int i19 = this.bp + i15;
        if (i19 >= this.len) {
            c11 = EOI;
        } else {
            c11 = this.text.charAt(i19);
        }
        if (c11 == '{') {
            int i20 = i19 + 1;
            this.bp = i20;
            if (i20 >= this.len) {
                c14 = EOI;
            } else {
                c14 = this.text.charAt(i20);
            }
            this.ch = c14;
            this.token = 12;
        } else if (c11 == '[') {
            int i21 = i19 + 1;
            this.bp = i21;
            if (i21 >= this.len) {
                c13 = EOI;
            } else {
                c13 = this.text.charAt(i21);
            }
            this.ch = c13;
            this.token = 14;
        } else {
            this.bp = i19;
            if (i19 >= this.len) {
                c12 = EOI;
            } else {
                c12 = this.text.charAt(i19);
            }
            this.ch = c12;
            nextToken();
        }
        return true;
    }

    public char next() {
        char c10;
        int i10 = this.bp + 1;
        this.bp = i10;
        if (i10 >= this.len) {
            c10 = EOI;
        } else {
            c10 = this.text.charAt(i10);
        }
        this.ch = c10;
        return c10;
    }

    public final void nextIdent() {
        char c10;
        while (true) {
            c10 = this.ch;
            if (c10 <= ' ' && (c10 == ' ' || c10 == 10 || c10 == 13 || c10 == 9 || c10 == 12 || c10 == 8)) {
                next();
            }
        }
        if (c10 == '_' || Character.isLetter(c10)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        scanNumber();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a1, code lost:
        if (r0.token == 20) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00a3, code lost:
        r0.token = 20;
        r1 = r0.eofPos;
        r0.bp = r1;
        r0.pos = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b3, code lost:
        throw new com.alibaba.fastjson.JSONException("EOF error");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void nextToken() {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r0.sp = r1
        L_0x0005:
            int r2 = r0.bp
            r0.pos = r2
            char r3 = r0.ch
            r4 = 47
            if (r3 != r4) goto L_0x0013
            r16.skipComment()
            goto L_0x0005
        L_0x0013:
            r4 = 34
            if (r3 != r4) goto L_0x001b
            r16.scanString()
            return
        L_0x001b:
            r4 = 48
            if (r3 < r4) goto L_0x0023
            r4 = 57
            if (r3 <= r4) goto L_0x0027
        L_0x0023:
            r4 = 45
            if (r3 != r4) goto L_0x002b
        L_0x0027:
            r16.scanNumber()
            return
        L_0x002b:
            r4 = 44
            if (r3 != r4) goto L_0x0037
            r16.next()
            r1 = 16
            r0.token = r1
            return
        L_0x0037:
            r5 = 12
            if (r3 == r5) goto L_0x01d5
            r6 = 13
            if (r3 == r6) goto L_0x01d5
            r7 = 32
            if (r3 == r7) goto L_0x01d5
            r8 = 58
            if (r3 == r8) goto L_0x01cd
            r9 = 91
            r10 = 1
            r11 = 26
            if (r3 == r9) goto L_0x01b8
            r9 = 93
            if (r3 == r9) goto L_0x01b0
            r12 = 102(0x66, float:1.43E-43)
            r13 = 8
            r14 = 9
            r15 = 10
            r1 = 125(0x7d, float:1.75E-43)
            if (r3 == r12) goto L_0x0178
            r12 = 110(0x6e, float:1.54E-43)
            if (r3 == r12) goto L_0x0128
            r12 = 123(0x7b, float:1.72E-43)
            if (r3 == r12) goto L_0x0115
            if (r3 == r1) goto L_0x0102
            r12 = 83
            if (r3 == r12) goto L_0x00fe
            r12 = 84
            if (r3 == r12) goto L_0x00fe
            r12 = 116(0x74, float:1.63E-43)
            if (r3 == r12) goto L_0x00c6
            r1 = 117(0x75, float:1.64E-43)
            if (r3 == r1) goto L_0x00fe
            switch(r3) {
                case 8: goto L_0x01d5;
                case 9: goto L_0x01d5;
                case 10: goto L_0x01d5;
                default: goto L_0x007b;
            }
        L_0x007b:
            switch(r3) {
                case 39: goto L_0x00c2;
                case 40: goto L_0x00bc;
                case 41: goto L_0x00b4;
                default: goto L_0x007e;
            }
        L_0x007e:
            int r1 = r0.len
            if (r2 == r1) goto L_0x009d
            if (r3 != r11) goto L_0x0089
            int r2 = r2 + 1
            if (r2 != r1) goto L_0x0089
            goto L_0x009d
        L_0x0089:
            r1 = 31
            if (r3 <= r1) goto L_0x0098
            r1 = 127(0x7f, float:1.78E-43)
            if (r3 != r1) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            r0.token = r10
            r16.next()
            goto L_0x00ab
        L_0x0098:
            r16.next()
            goto L_0x01d8
        L_0x009d:
            int r1 = r0.token
            r2 = 20
            if (r1 == r2) goto L_0x00ac
            r0.token = r2
            int r1 = r0.eofPos
            r0.bp = r1
            r0.pos = r1
        L_0x00ab:
            return
        L_0x00ac:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r2 = "EOF error"
            r1.<init>(r2)
            throw r1
        L_0x00b4:
            r16.next()
            r1 = 11
            r0.token = r1
            return
        L_0x00bc:
            r16.next()
            r0.token = r15
            return
        L_0x00c2:
            r16.scanString()
            return
        L_0x00c6:
            java.lang.String r3 = r0.text
            java.lang.String r10 = "true"
            boolean r2 = r3.startsWith(r10, r2)
            if (r2 == 0) goto L_0x00f6
            int r2 = r0.bp
            int r2 = r2 + 4
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            if (r2 == r7) goto L_0x00f2
            if (r2 == r4) goto L_0x00f2
            if (r2 == r1) goto L_0x00f2
            if (r2 == r9) goto L_0x00f2
            if (r2 == r15) goto L_0x00f2
            if (r2 == r6) goto L_0x00f2
            if (r2 == r14) goto L_0x00f2
            if (r2 == r11) goto L_0x00f2
            if (r2 == r5) goto L_0x00f2
            if (r2 == r13) goto L_0x00f2
            if (r2 != r8) goto L_0x00f6
        L_0x00f2:
            r1 = 6
            r0.token = r1
            return
        L_0x00f6:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r2 = "scan true error"
            r1.<init>(r2)
            throw r1
        L_0x00fe:
            r16.scanIdent()
            return
        L_0x0102:
            int r2 = r2 + r10
            r0.bp = r2
            int r1 = r0.len
            if (r2 < r1) goto L_0x010a
            goto L_0x0110
        L_0x010a:
            java.lang.String r1 = r0.text
            char r11 = r1.charAt(r2)
        L_0x0110:
            r0.ch = r11
            r0.token = r6
            return
        L_0x0115:
            int r2 = r2 + r10
            r0.bp = r2
            int r1 = r0.len
            if (r2 < r1) goto L_0x011d
            goto L_0x0123
        L_0x011d:
            java.lang.String r1 = r0.text
            char r11 = r1.charAt(r2)
        L_0x0123:
            r0.ch = r11
            r0.token = r5
            return
        L_0x0128:
            java.lang.String r3 = r0.text
            java.lang.String r8 = "null"
            boolean r2 = r3.startsWith(r8, r2)
            if (r2 == 0) goto L_0x013a
            int r2 = r0.bp
            int r2 = r2 + 4
            r0.bp = r2
            r2 = r13
            goto L_0x014f
        L_0x013a:
            java.lang.String r2 = r0.text
            java.lang.String r3 = "new"
            int r8 = r0.bp
            boolean r2 = r2.startsWith(r3, r8)
            if (r2 == 0) goto L_0x014e
            int r2 = r0.bp
            int r2 = r2 + 3
            r0.bp = r2
            r2 = r14
            goto L_0x014f
        L_0x014e:
            r2 = 0
        L_0x014f:
            if (r2 == 0) goto L_0x0170
            int r3 = r0.bp
            char r3 = r0.charAt(r3)
            r0.ch = r3
            if (r3 == r7) goto L_0x016d
            if (r3 == r4) goto L_0x016d
            if (r3 == r1) goto L_0x016d
            if (r3 == r9) goto L_0x016d
            if (r3 == r15) goto L_0x016d
            if (r3 == r6) goto L_0x016d
            if (r3 == r14) goto L_0x016d
            if (r3 == r11) goto L_0x016d
            if (r3 == r5) goto L_0x016d
            if (r3 != r13) goto L_0x0170
        L_0x016d:
            r0.token = r2
            return
        L_0x0170:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r2 = "scan null/new error"
            r1.<init>(r2)
            throw r1
        L_0x0178:
            java.lang.String r3 = r0.text
            java.lang.String r10 = "false"
            boolean r2 = r3.startsWith(r10, r2)
            if (r2 == 0) goto L_0x01a8
            int r2 = r0.bp
            int r2 = r2 + 5
            r0.bp = r2
            char r2 = r0.charAt(r2)
            r0.ch = r2
            if (r2 == r7) goto L_0x01a4
            if (r2 == r4) goto L_0x01a4
            if (r2 == r1) goto L_0x01a4
            if (r2 == r9) goto L_0x01a4
            if (r2 == r15) goto L_0x01a4
            if (r2 == r6) goto L_0x01a4
            if (r2 == r14) goto L_0x01a4
            if (r2 == r11) goto L_0x01a4
            if (r2 == r5) goto L_0x01a4
            if (r2 == r13) goto L_0x01a4
            if (r2 != r8) goto L_0x01a8
        L_0x01a4:
            r1 = 7
            r0.token = r1
            return
        L_0x01a8:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r2 = "scan false error"
            r1.<init>(r2)
            throw r1
        L_0x01b0:
            r16.next()
            r1 = 15
            r0.token = r1
            return
        L_0x01b8:
            int r2 = r2 + r10
            r0.bp = r2
            int r1 = r0.len
            if (r2 < r1) goto L_0x01c0
            goto L_0x01c6
        L_0x01c0:
            java.lang.String r1 = r0.text
            char r11 = r1.charAt(r2)
        L_0x01c6:
            r0.ch = r11
            r1 = 14
            r0.token = r1
            return
        L_0x01cd:
            r16.next()
            r1 = 17
            r0.token = r1
            return
        L_0x01d5:
            r16.next()
        L_0x01d8:
            r1 = 0
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.nextToken():void");
    }

    public final void nextTokenWithChar(char c10) {
        char c11;
        this.sp = 0;
        while (true) {
            char c12 = this.ch;
            if (c12 == c10) {
                int i10 = this.bp + 1;
                this.bp = i10;
                if (i10 >= this.len) {
                    c11 = EOI;
                } else {
                    c11 = this.text.charAt(i10);
                }
                this.ch = c11;
                nextToken();
                return;
            } else if (c12 == ' ' || c12 == 10 || c12 == 13 || c12 == 9 || c12 == 12 || c12 == 8) {
                next();
            } else {
                throw new JSONException("not match " + c10 + " - " + this.ch);
            }
        }
    }

    public final String numberString() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i10 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i10--;
        }
        return subString(this.np, i10);
    }

    public boolean scanBoolean() {
        int i10;
        boolean z10 = false;
        if (this.text.startsWith("false", this.bp)) {
            i10 = 5;
        } else if (this.text.startsWith("true", this.bp)) {
            i10 = 4;
            z10 = true;
        } else {
            char c10 = this.ch;
            if (c10 == '1') {
                i10 = 1;
                z10 = true;
            } else if (c10 == '0') {
                i10 = 1;
            } else {
                this.matchStat = -1;
                return false;
            }
        }
        int i11 = this.bp + i10;
        this.bp = i11;
        this.ch = charAt(i11);
        return z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scanFieldBoolean(long r13) {
        /*
            r12 = this;
            r0 = 0
            r12.matchStat = r0
            int r13 = r12.matchFieldHash(r13)
            if (r13 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.String r14 = r12.text
            int r1 = r12.bp
            int r1 = r1 + r13
            java.lang.String r2 = "false"
            boolean r14 = r14.startsWith(r2, r1)
            r1 = 4
            r2 = -1
            r3 = 3
            r4 = 1
            if (r14 == 0) goto L_0x0020
            int r13 = r13 + 5
        L_0x001d:
            r14 = r0
            goto L_0x008c
        L_0x0020:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "true"
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x0030
            int r13 = r13 + r1
        L_0x002e:
            r14 = r4
            goto L_0x008c
        L_0x0030:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "\"false\""
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x0040
            int r13 = r13 + 7
            goto L_0x001d
        L_0x0040:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "\"true\""
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x0050
            int r13 = r13 + 6
            goto L_0x002e
        L_0x0050:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            char r14 = r14.charAt(r5)
            r5 = 49
            if (r14 != r5) goto L_0x005f
            int r13 = r13 + r4
            goto L_0x002e
        L_0x005f:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            char r14 = r14.charAt(r5)
            r5 = 48
            if (r14 != r5) goto L_0x006e
            int r13 = r13 + r4
            goto L_0x001d
        L_0x006e:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "\"1\""
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x007d
            int r13 = r13 + r3
            goto L_0x002e
        L_0x007d:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "\"0\""
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x0158
            int r13 = r13 + r3
            goto L_0x001d
        L_0x008c:
            int r5 = r12.bp
            int r6 = r13 + 1
            int r5 = r5 + r13
            int r13 = r12.len
            r7 = 26
            if (r5 < r13) goto L_0x0099
            r13 = r7
            goto L_0x009f
        L_0x0099:
            java.lang.String r13 = r12.text
            char r13 = r13.charAt(r5)
        L_0x009f:
            r5 = 16
            r8 = 44
            if (r13 != r8) goto L_0x00be
            int r13 = r12.bp
            int r6 = r6 - r4
            int r13 = r13 + r6
            int r13 = r13 + r4
            r12.bp = r13
            int r0 = r12.len
            if (r13 < r0) goto L_0x00b1
            goto L_0x00b7
        L_0x00b1:
            java.lang.String r0 = r12.text
            char r7 = r0.charAt(r13)
        L_0x00b7:
            r12.ch = r7
            r12.matchStat = r3
            r12.token = r5
            return r14
        L_0x00be:
            r9 = 13
            r10 = 125(0x7d, float:1.75E-43)
            if (r13 == r10) goto L_0x00ed
            r11 = 32
            if (r13 == r11) goto L_0x00da
            r11 = 10
            if (r13 == r11) goto L_0x00da
            if (r13 == r9) goto L_0x00da
            r11 = 9
            if (r13 == r11) goto L_0x00da
            r11 = 12
            if (r13 == r11) goto L_0x00da
            r11 = 8
            if (r13 != r11) goto L_0x00ed
        L_0x00da:
            int r13 = r12.bp
            int r5 = r6 + 1
            int r13 = r13 + r6
            int r6 = r12.len
            if (r13 < r6) goto L_0x00e5
            r13 = r7
            goto L_0x00eb
        L_0x00e5:
            java.lang.String r6 = r12.text
            char r13 = r6.charAt(r13)
        L_0x00eb:
            r6 = r5
            goto L_0x009f
        L_0x00ed:
            if (r13 != r10) goto L_0x0155
            int r13 = r12.bp
            int r13 = r13 + r6
            char r13 = r12.charAt(r13)
            if (r13 != r8) goto L_0x010e
            r12.token = r5
            int r13 = r12.bp
            int r13 = r13 + r6
            int r13 = r13 + r4
            r12.bp = r13
            int r0 = r12.len
            if (r13 < r0) goto L_0x0105
            goto L_0x010b
        L_0x0105:
            java.lang.String r0 = r12.text
            char r7 = r0.charAt(r13)
        L_0x010b:
            r12.ch = r7
            goto L_0x014f
        L_0x010e:
            r3 = 93
            if (r13 != r3) goto L_0x012a
            r13 = 15
            r12.token = r13
            int r13 = r12.bp
            int r13 = r13 + r6
            int r13 = r13 + r4
            r12.bp = r13
            int r0 = r12.len
            if (r13 < r0) goto L_0x0121
            goto L_0x0127
        L_0x0121:
            java.lang.String r0 = r12.text
            char r7 = r0.charAt(r13)
        L_0x0127:
            r12.ch = r7
            goto L_0x014f
        L_0x012a:
            if (r13 != r10) goto L_0x0142
            r12.token = r9
            int r13 = r12.bp
            int r13 = r13 + r6
            int r13 = r13 + r4
            r12.bp = r13
            int r0 = r12.len
            if (r13 < r0) goto L_0x0139
            goto L_0x013f
        L_0x0139:
            java.lang.String r0 = r12.text
            char r7 = r0.charAt(r13)
        L_0x013f:
            r12.ch = r7
            goto L_0x014f
        L_0x0142:
            if (r13 != r7) goto L_0x0152
            r13 = 20
            r12.token = r13
            int r13 = r12.bp
            int r13 = r13 + r6
            r12.bp = r13
            r12.ch = r7
        L_0x014f:
            r12.matchStat = r1
            return r14
        L_0x0152:
            r12.matchStat = r2
            return r0
        L_0x0155:
            r12.matchStat = r2
            return r0
        L_0x0158:
            r12.matchStat = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldBoolean(long):boolean");
    }

    public Date scanFieldDate(long j10) {
        char c10;
        char c11;
        int i10;
        Date date;
        int i11;
        char c12;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return null;
        }
        int i12 = this.bp;
        char c13 = this.ch;
        int i13 = matchFieldHash + 1;
        int i14 = i12 + matchFieldHash;
        int i15 = this.len;
        char c14 = EOI;
        if (i14 >= i15) {
            c10 = 26;
        } else {
            c10 = this.text.charAt(i14);
        }
        if (c10 == '\"') {
            int i16 = this.bp;
            int i17 = i16 + i13;
            int i18 = matchFieldHash + 2;
            int i19 = i16 + i13;
            if (i19 < this.len) {
                this.text.charAt(i19);
            }
            int indexOf = this.text.indexOf(34, this.bp + i18);
            if (indexOf != -1) {
                int i20 = indexOf - i17;
                this.bp = i17;
                if (scanISO8601DateIfMatch(false, i20)) {
                    date = this.calendar.getTime();
                    int i21 = i18 + i20;
                    i10 = i21 + 1;
                    c11 = charAt(i21 + i12);
                    this.bp = i12;
                } else {
                    this.bp = i12;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (c10 < '0' || c10 > '9') {
            this.matchStat = -1;
            return null;
        } else {
            long j11 = (long) (c10 - '0');
            while (true) {
                i11 = i13 + 1;
                int i22 = this.bp + i13;
                if (i22 >= this.len) {
                    c12 = 26;
                } else {
                    c12 = this.text.charAt(i22);
                }
                if (c12 >= '0' && c12 <= '9') {
                    j11 = (j11 * 10) + ((long) (c12 - '0'));
                    i13 = i11;
                }
            }
            if (c12 == '.') {
                this.matchStat = -1;
                return null;
            }
            if (c12 == '\"') {
                i10 = i13 + 2;
                int i23 = this.bp + i11;
                if (i23 >= this.len) {
                    c11 = 26;
                } else {
                    c11 = this.text.charAt(i23);
                }
            } else {
                c11 = c12;
                i10 = i11;
            }
            if (j11 < 0) {
                this.matchStat = -1;
                return null;
            }
            date = new Date(j11);
        }
        if (c11 == ',') {
            int i24 = this.bp + (i10 - 1) + 1;
            this.bp = i24;
            if (i24 < this.len) {
                c14 = this.text.charAt(i24);
            }
            this.ch = c14;
            this.matchStat = 3;
            this.token = 16;
            return date;
        } else if (c11 == '}') {
            char charAt = charAt(this.bp + i10);
            if (charAt == ',') {
                this.token = 16;
                int i25 = this.bp + i10 + 1;
                this.bp = i25;
                if (i25 < this.len) {
                    c14 = this.text.charAt(i25);
                }
                this.ch = c14;
            } else if (charAt == ']') {
                this.token = 15;
                int i26 = this.bp + i10 + 1;
                this.bp = i26;
                if (i26 < this.len) {
                    c14 = this.text.charAt(i26);
                }
                this.ch = c14;
            } else if (charAt == '}') {
                this.token = 13;
                int i27 = this.bp + i10 + 1;
                this.bp = i27;
                if (i27 < this.len) {
                    c14 = this.text.charAt(i27);
                }
                this.ch = c14;
            } else if (charAt == 26) {
                this.token = 20;
                this.bp += i10;
                this.ch = EOI;
            } else {
                this.bp = i12;
                this.ch = c13;
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.bp = i12;
            this.ch = c13;
            this.matchStat = -1;
            return null;
        }
    }

    public final double scanFieldDouble(long j10) {
        boolean z10;
        int i10;
        int i11;
        char charAt;
        int i12;
        char c10;
        int i13;
        boolean z11;
        double d10;
        int i14;
        char charAt2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0.0d;
        }
        int i15 = matchFieldHash + 1;
        char charAt3 = charAt(this.bp + matchFieldHash);
        int i16 = this.bp;
        int i17 = (i16 + i15) - 1;
        if (charAt3 == '-') {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            charAt3 = charAt(i16 + i15);
            i15 = matchFieldHash + 2;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return 0.0d;
        }
        int i18 = charAt3 - '0';
        while (true) {
            i11 = i15 + 1;
            charAt = charAt(this.bp + i15);
            if (charAt >= '0' && charAt <= '9') {
                i18 = (i10 * 10) + (charAt - '0');
                i15 = i11;
            }
        }
        if (charAt == '.') {
            int i19 = i15 + 2;
            char charAt4 = charAt(this.bp + i11);
            if (charAt4 < '0' || charAt4 > '9') {
                this.matchStat = -1;
                return 0.0d;
            }
            i10 = (i10 * 10) + (charAt4 - '0');
            int i20 = 10;
            while (true) {
                i14 = i19 + 1;
                charAt2 = charAt(this.bp + i19);
                if (charAt2 < '0' || charAt2 > '9') {
                    i11 = i14;
                    int i21 = i20;
                    charAt = charAt2;
                    i13 = i21;
                } else {
                    i10 = (i10 * 10) + (charAt2 - '0');
                    i20 *= 10;
                    i19 = i14;
                }
            }
            i11 = i14;
            int i212 = i20;
            charAt = charAt2;
            i13 = i212;
        } else {
            i13 = 1;
        }
        if (c10 == 'e' || c10 == 'E') {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i22 = i12 + 1;
            c10 = charAt(this.bp + i12);
            if (c10 == '+' || c10 == '-') {
                i12 += 2;
                c10 = charAt(this.bp + i22);
            } else {
                i12 = i22;
            }
            while (c10 >= '0' && c10 <= '9') {
                c10 = charAt(this.bp + i12);
                i12++;
            }
        }
        int i23 = ((this.bp + i12) - i17) - 1;
        if (z11 || i23 >= 10) {
            d10 = Double.parseDouble(subString(i17, i23));
        } else {
            d10 = ((double) i10) / ((double) i13);
            if (z10) {
                d10 = -d10;
            }
        }
        if (c10 == ',') {
            this.bp += i12 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return d10;
        } else if (c10 == '}') {
            char charAt5 = charAt(this.bp + i12);
            if (charAt5 == ',') {
                this.token = 16;
                this.bp += i12;
                next();
            } else if (charAt5 == ']') {
                this.token = 15;
                this.bp += i12;
                next();
            } else if (charAt5 == '}') {
                this.token = 13;
                this.bp += i12;
                next();
            } else if (charAt5 == 26) {
                this.bp += i12;
                this.token = 20;
                this.ch = EOI;
            } else {
                this.matchStat = -1;
                return 0.0d;
            }
            this.matchStat = 4;
            return d10;
        } else {
            this.matchStat = -1;
            return 0.0d;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x012f  */
    public final double[] scanFieldDoubleArray(long r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r0.matchStat = r1
            int r2 = r19.matchFieldHash(r20)
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            int r4 = r0.bp
            int r5 = r2 + 1
            int r4 = r4 + r2
            int r6 = r0.len
            if (r4 < r6) goto L_0x0019
            r4 = 26
            goto L_0x001f
        L_0x0019:
            java.lang.String r6 = r0.text
            char r4 = r6.charAt(r4)
        L_0x001f:
            r6 = 91
            r8 = -1
            if (r4 == r6) goto L_0x0027
            r0.matchStat = r8
            return r3
        L_0x0027:
            int r4 = r0.bp
            int r2 = r2 + 2
            int r4 = r4 + r5
            int r5 = r0.len
            if (r4 < r5) goto L_0x0033
            r4 = 26
            goto L_0x0039
        L_0x0033:
            java.lang.String r5 = r0.text
            char r4 = r5.charAt(r4)
        L_0x0039:
            r5 = 16
            double[] r6 = new double[r5]
            r9 = r1
        L_0x003e:
            int r10 = r0.bp
            int r11 = r10 + r2
            r12 = 1
            int r11 = r11 - r12
            r13 = 45
            if (r4 != r13) goto L_0x004a
            r14 = r12
            goto L_0x004b
        L_0x004a:
            r14 = r1
        L_0x004b:
            if (r14 == 0) goto L_0x0062
            int r4 = r2 + 1
            int r10 = r10 + r2
            int r2 = r0.len
            if (r10 < r2) goto L_0x0057
            r2 = 26
            goto L_0x005d
        L_0x0057:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r10)
        L_0x005d:
            r18 = r4
            r4 = r2
            r2 = r18
        L_0x0062:
            r10 = 48
            if (r4 < r10) goto L_0x022f
            r15 = 57
            if (r4 > r15) goto L_0x022f
            int r4 = r4 + -48
        L_0x006c:
            int r7 = r0.bp
            int r16 = r2 + 1
            int r7 = r7 + r2
            int r5 = r0.len
            if (r7 < r5) goto L_0x0078
            r5 = 26
            goto L_0x007e
        L_0x0078:
            java.lang.String r5 = r0.text
            char r5 = r5.charAt(r7)
        L_0x007e:
            if (r5 < r10) goto L_0x008c
            if (r5 > r15) goto L_0x008c
            int r4 = r4 * 10
            int r5 = r5 + -48
            int r4 = r4 + r5
            r2 = r16
            r5 = 16
            goto L_0x006c
        L_0x008c:
            r7 = 46
            if (r5 != r7) goto L_0x0092
            r7 = r12
            goto L_0x0093
        L_0x0092:
            r7 = r1
        L_0x0093:
            r1 = 10
            if (r7 == 0) goto L_0x00dd
            int r5 = r0.bp
            int r2 = r2 + 2
            int r5 = r5 + r16
            int r7 = r0.len
            if (r5 < r7) goto L_0x00a4
            r5 = 26
            goto L_0x00aa
        L_0x00a4:
            java.lang.String r7 = r0.text
            char r5 = r7.charAt(r5)
        L_0x00aa:
            if (r5 < r10) goto L_0x00da
            if (r5 > r15) goto L_0x00da
            int r4 = r4 * 10
            int r5 = r5 + -48
            int r4 = r4 + r5
            r5 = r1
        L_0x00b4:
            int r7 = r0.bp
            int r16 = r2 + 1
            int r7 = r7 + r2
            int r2 = r0.len
            if (r7 < r2) goto L_0x00c0
            r2 = 26
            goto L_0x00c6
        L_0x00c0:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r7)
        L_0x00c6:
            if (r2 < r10) goto L_0x00d4
            if (r2 > r15) goto L_0x00d4
            int r4 = r4 * 10
            int r2 = r2 + -48
            int r4 = r4 + r2
            int r5 = r5 * 10
            r2 = r16
            goto L_0x00b4
        L_0x00d4:
            r18 = r5
            r5 = r2
            r2 = r18
            goto L_0x00de
        L_0x00da:
            r0.matchStat = r8
            return r3
        L_0x00dd:
            r2 = r12
        L_0x00de:
            r7 = 101(0x65, float:1.42E-43)
            if (r5 == r7) goto L_0x00e9
            r7 = 69
            if (r5 != r7) goto L_0x00e7
            goto L_0x00e9
        L_0x00e7:
            r7 = 0
            goto L_0x00ea
        L_0x00e9:
            r7 = r12
        L_0x00ea:
            if (r7 == 0) goto L_0x0138
            int r5 = r0.bp
            int r17 = r16 + 1
            int r5 = r5 + r16
            int r3 = r0.len
            if (r5 < r3) goto L_0x00f9
            r3 = 26
            goto L_0x00ff
        L_0x00f9:
            java.lang.String r3 = r0.text
            char r3 = r3.charAt(r5)
        L_0x00ff:
            r5 = 43
            if (r3 == r5) goto L_0x010a
            if (r3 != r13) goto L_0x0106
            goto L_0x010a
        L_0x0106:
            r5 = r3
            r16 = r17
            goto L_0x011e
        L_0x010a:
            int r3 = r0.bp
            int r16 = r16 + 2
            int r3 = r3 + r17
            int r5 = r0.len
            if (r3 < r5) goto L_0x0117
            r3 = 26
            goto L_0x011d
        L_0x0117:
            java.lang.String r5 = r0.text
            char r3 = r5.charAt(r3)
        L_0x011d:
            r5 = r3
        L_0x011e:
            if (r5 < r10) goto L_0x0138
            if (r5 > r15) goto L_0x0138
            int r3 = r0.bp
            int r5 = r16 + 1
            int r3 = r3 + r16
            int r13 = r0.len
            if (r3 < r13) goto L_0x012f
            r3 = 26
            goto L_0x0135
        L_0x012f:
            java.lang.String r13 = r0.text
            char r3 = r13.charAt(r3)
        L_0x0135:
            r16 = r5
            goto L_0x011d
        L_0x0138:
            int r3 = r0.bp
            int r3 = r3 + r16
            int r3 = r3 - r11
            int r3 = r3 - r12
            if (r7 != 0) goto L_0x0149
            if (r3 >= r1) goto L_0x0149
            double r3 = (double) r4
            double r1 = (double) r2
            double r3 = r3 / r1
            if (r14 == 0) goto L_0x0151
            double r3 = -r3
            goto L_0x0151
        L_0x0149:
            java.lang.String r1 = r0.subString(r11, r3)
            double r3 = java.lang.Double.parseDouble(r1)
        L_0x0151:
            int r1 = r6.length
            r2 = 3
            if (r9 < r1) goto L_0x0160
            int r1 = r6.length
            int r1 = r1 * r2
            int r1 = r1 / 2
            double[] r1 = new double[r1]
            r7 = 0
            java.lang.System.arraycopy(r6, r7, r1, r7, r9)
            r6 = r1
        L_0x0160:
            int r7 = r9 + 1
            r6[r9] = r3
            r1 = 44
            if (r5 != r1) goto L_0x0186
            int r1 = r0.bp
            int r2 = r16 + 1
            int r1 = r1 + r16
            int r3 = r0.len
            if (r1 < r3) goto L_0x0175
            r1 = 26
            goto L_0x017b
        L_0x0175:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x017b:
            r4 = r1
            r16 = r2
            r1 = 16
            r2 = 26
            r3 = 0
            r10 = 0
            goto L_0x0228
        L_0x0186:
            r3 = 93
            if (r5 != r3) goto L_0x0221
            int r4 = r0.bp
            int r5 = r16 + 1
            int r4 = r4 + r16
            int r9 = r0.len
            if (r4 < r9) goto L_0x0197
            r4 = 26
            goto L_0x019d
        L_0x0197:
            java.lang.String r9 = r0.text
            char r4 = r9.charAt(r4)
        L_0x019d:
            int r9 = r6.length
            if (r7 == r9) goto L_0x01a7
            double[] r9 = new double[r7]
            r10 = 0
            java.lang.System.arraycopy(r6, r10, r9, r10, r7)
            r6 = r9
        L_0x01a7:
            if (r4 != r1) goto L_0x01b9
            int r1 = r0.bp
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            r0.matchStat = r2
            r1 = 16
            r0.token = r1
            return r6
        L_0x01b9:
            r2 = 125(0x7d, float:1.75E-43)
            if (r4 != r2) goto L_0x021d
            int r4 = r0.bp
            int r4 = r4 + r5
            int r5 = r0.len
            if (r4 < r5) goto L_0x01c7
            r4 = 26
            goto L_0x01cd
        L_0x01c7:
            java.lang.String r5 = r0.text
            char r4 = r5.charAt(r4)
        L_0x01cd:
            if (r4 != r1) goto L_0x01df
            r1 = 16
            r0.token = r1
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            goto L_0x0215
        L_0x01df:
            if (r4 != r3) goto L_0x01f1
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            goto L_0x0215
        L_0x01f1:
            if (r4 != r2) goto L_0x0203
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            goto L_0x0215
        L_0x0203:
            r2 = 26
            if (r4 != r2) goto L_0x0219
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r1 = 20
            r0.token = r1
            r0.ch = r2
        L_0x0215:
            r1 = 4
            r0.matchStat = r1
            return r6
        L_0x0219:
            r0.matchStat = r8
            r3 = 0
            return r3
        L_0x021d:
            r3 = 0
            r0.matchStat = r8
            return r3
        L_0x0221:
            r1 = 16
            r2 = 26
            r3 = 0
            r10 = 0
            r4 = r5
        L_0x0228:
            r5 = r1
            r9 = r7
            r1 = r10
            r2 = r16
            goto L_0x003e
        L_0x022f:
            r0.matchStat = r8
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray(long):double[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:162:0x029c, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double[][] scanFieldDoubleArray2(long r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = 0
            r0.matchStat = r1
            int r2 = r20.matchFieldHash(r21)
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            int r4 = r0.bp
            int r5 = r2 + 1
            int r4 = r4 + r2
            int r6 = r0.len
            if (r4 < r6) goto L_0x0019
            r4 = 26
            goto L_0x001f
        L_0x0019:
            java.lang.String r6 = r0.text
            char r4 = r6.charAt(r4)
        L_0x001f:
            r6 = 91
            r8 = -1
            if (r4 == r6) goto L_0x0027
            r0.matchStat = r8
            return r3
        L_0x0027:
            int r4 = r0.bp
            int r2 = r2 + 2
            int r4 = r4 + r5
            int r5 = r0.len
            if (r4 < r5) goto L_0x0033
            r4 = 26
            goto L_0x0039
        L_0x0033:
            java.lang.String r5 = r0.text
            char r4 = r5.charAt(r4)
        L_0x0039:
            r5 = 16
            double[][] r9 = new double[r5][]
            r10 = r1
        L_0x003e:
            if (r4 != r6) goto L_0x029d
            int r4 = r0.bp
            int r11 = r2 + 1
            int r4 = r4 + r2
            int r2 = r0.len
            if (r4 < r2) goto L_0x004c
            r2 = 26
            goto L_0x0052
        L_0x004c:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r4)
        L_0x0052:
            double[] r4 = new double[r5]
            r12 = r1
        L_0x0055:
            int r13 = r0.bp
            int r14 = r13 + r11
            r15 = 1
            int r14 = r14 - r15
            r6 = 45
            if (r2 != r6) goto L_0x0062
            r16 = r15
            goto L_0x0064
        L_0x0062:
            r16 = r1
        L_0x0064:
            if (r16 == 0) goto L_0x007b
            int r2 = r11 + 1
            int r13 = r13 + r11
            int r11 = r0.len
            if (r13 < r11) goto L_0x0070
            r11 = 26
            goto L_0x0076
        L_0x0070:
            java.lang.String r11 = r0.text
            char r11 = r11.charAt(r13)
        L_0x0076:
            r19 = r11
            r11 = r2
            r2 = r19
        L_0x007b:
            r13 = 48
            if (r2 < r13) goto L_0x0299
            r7 = 57
            if (r2 > r7) goto L_0x0299
            int r2 = r2 + -48
        L_0x0085:
            int r5 = r0.bp
            int r17 = r11 + 1
            int r5 = r5 + r11
            int r1 = r0.len
            if (r5 < r1) goto L_0x0091
            r1 = 26
            goto L_0x0097
        L_0x0091:
            java.lang.String r1 = r0.text
            char r1 = r1.charAt(r5)
        L_0x0097:
            if (r1 < r13) goto L_0x00a4
            if (r1 > r7) goto L_0x00a4
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r11 = r17
            r1 = 0
            goto L_0x0085
        L_0x00a4:
            r5 = 46
            r15 = 10
            if (r1 != r5) goto L_0x00f1
            int r1 = r0.bp
            int r11 = r11 + 2
            int r1 = r1 + r17
            int r5 = r0.len
            if (r1 < r5) goto L_0x00b7
            r1 = 26
            goto L_0x00bd
        L_0x00b7:
            java.lang.String r5 = r0.text
            char r1 = r5.charAt(r1)
        L_0x00bd:
            if (r1 < r13) goto L_0x00ee
            if (r1 > r7) goto L_0x00ee
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r1 = r15
        L_0x00c7:
            int r5 = r0.bp
            int r17 = r11 + 1
            int r5 = r5 + r11
            int r11 = r0.len
            if (r5 < r11) goto L_0x00d3
            r5 = 26
            goto L_0x00d9
        L_0x00d3:
            java.lang.String r11 = r0.text
            char r5 = r11.charAt(r5)
        L_0x00d9:
            if (r5 < r13) goto L_0x00e7
            if (r5 > r7) goto L_0x00e7
            int r2 = r2 * 10
            int r5 = r5 + -48
            int r2 = r2 + r5
            int r1 = r1 * 10
            r11 = r17
            goto L_0x00c7
        L_0x00e7:
            r19 = r2
            r2 = r1
            r1 = r5
            r5 = r19
            goto L_0x00f3
        L_0x00ee:
            r0.matchStat = r8
            return r3
        L_0x00f1:
            r5 = r2
            r2 = 1
        L_0x00f3:
            r11 = 101(0x65, float:1.42E-43)
            if (r1 == r11) goto L_0x00fe
            r11 = 69
            if (r1 != r11) goto L_0x00fc
            goto L_0x00fe
        L_0x00fc:
            r11 = 0
            goto L_0x00ff
        L_0x00fe:
            r11 = 1
        L_0x00ff:
            if (r11 == 0) goto L_0x014b
            int r1 = r0.bp
            int r18 = r17 + 1
            int r1 = r1 + r17
            int r3 = r0.len
            if (r1 < r3) goto L_0x010e
            r1 = 26
            goto L_0x0114
        L_0x010e:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x0114:
            r3 = 43
            if (r1 == r3) goto L_0x011e
            if (r1 != r6) goto L_0x011b
            goto L_0x011e
        L_0x011b:
            r17 = r18
            goto L_0x0131
        L_0x011e:
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r18
            int r3 = r0.len
            if (r1 < r3) goto L_0x012b
            r1 = 26
            goto L_0x0131
        L_0x012b:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x0131:
            if (r1 < r13) goto L_0x014b
            if (r1 > r7) goto L_0x014b
            int r1 = r0.bp
            int r3 = r17 + 1
            int r1 = r1 + r17
            int r6 = r0.len
            if (r1 < r6) goto L_0x0142
            r1 = 26
            goto L_0x0148
        L_0x0142:
            java.lang.String r6 = r0.text
            char r1 = r6.charAt(r1)
        L_0x0148:
            r17 = r3
            goto L_0x0131
        L_0x014b:
            int r3 = r0.bp
            int r3 = r3 + r17
            int r3 = r3 - r14
            r6 = 1
            int r3 = r3 - r6
            if (r11 != 0) goto L_0x015d
            if (r3 >= r15) goto L_0x015d
            double r5 = (double) r5
            double r2 = (double) r2
            double r5 = r5 / r2
            if (r16 == 0) goto L_0x0165
            double r5 = -r5
            goto L_0x0165
        L_0x015d:
            java.lang.String r2 = r0.subString(r14, r3)
            double r5 = java.lang.Double.parseDouble(r2)
        L_0x0165:
            int r2 = r4.length
            r3 = 3
            if (r12 < r2) goto L_0x0174
            int r2 = r4.length
            int r2 = r2 * r3
            int r2 = r2 / 2
            double[] r2 = new double[r2]
            r7 = 0
            java.lang.System.arraycopy(r4, r7, r2, r7, r12)
            r4 = r2
        L_0x0174:
            int r2 = r12 + 1
            r4[r12] = r5
            r5 = 44
            if (r1 != r5) goto L_0x0199
            int r1 = r0.bp
            int r3 = r17 + 1
            int r1 = r1 + r17
            int r5 = r0.len
            if (r1 < r5) goto L_0x0189
            r1 = 26
            goto L_0x018f
        L_0x0189:
            java.lang.String r5 = r0.text
            char r1 = r5.charAt(r1)
        L_0x018f:
            r17 = r3
        L_0x0191:
            r3 = 16
            r5 = 26
            r6 = 0
            r11 = 0
            goto L_0x028e
        L_0x0199:
            r6 = 93
            if (r1 != r6) goto L_0x0191
            int r1 = r0.bp
            int r7 = r17 + 1
            int r1 = r1 + r17
            int r11 = r0.len
            if (r1 < r11) goto L_0x01aa
            r1 = 26
            goto L_0x01b0
        L_0x01aa:
            java.lang.String r11 = r0.text
            char r1 = r11.charAt(r1)
        L_0x01b0:
            int r11 = r4.length
            if (r2 == r11) goto L_0x01bb
            double[] r11 = new double[r2]
            r12 = 0
            java.lang.System.arraycopy(r4, r12, r11, r12, r2)
            r4 = r11
            goto L_0x01bc
        L_0x01bb:
            r12 = 0
        L_0x01bc:
            int r11 = r9.length
            if (r10 < r11) goto L_0x01c8
            int r9 = r9.length
            int r9 = r9 * r3
            int r9 = r9 / 2
            double[][] r9 = new double[r9][]
            java.lang.System.arraycopy(r4, r12, r9, r12, r2)
        L_0x01c8:
            int r2 = r10 + 1
            r9[r10] = r4
            if (r1 != r5) goto L_0x01e9
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r7
            int r3 = r0.len
            if (r1 < r3) goto L_0x01da
            r1 = 26
            goto L_0x01e0
        L_0x01da:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x01e0:
            r4 = r1
            r3 = 16
            r5 = 26
            r6 = 0
            r11 = 0
            goto L_0x0284
        L_0x01e9:
            if (r1 != r6) goto L_0x027b
            int r1 = r0.bp
            int r4 = r17 + 2
            int r1 = r1 + r7
            int r7 = r0.len
            if (r1 < r7) goto L_0x01f7
            r1 = 26
            goto L_0x01fd
        L_0x01f7:
            java.lang.String r7 = r0.text
            char r1 = r7.charAt(r1)
        L_0x01fd:
            int r7 = r9.length
            if (r2 == r7) goto L_0x0207
            double[][] r7 = new double[r2][]
            r11 = 0
            java.lang.System.arraycopy(r9, r11, r7, r11, r2)
            r9 = r7
        L_0x0207:
            if (r1 != r5) goto L_0x021c
            int r1 = r0.bp
            r2 = 1
            int r17 = r17 + 1
            int r1 = r1 + r17
            r0.bp = r1
            r20.next()
            r0.matchStat = r3
            r3 = 16
            r0.token = r3
            return r9
        L_0x021c:
            r3 = 16
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 != r2) goto L_0x0277
            int r1 = r0.bp
            int r1 = r1 + r4
            char r1 = r0.charAt(r1)
            if (r1 != r5) goto L_0x0239
            r0.token = r3
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r17
            r0.bp = r1
            r20.next()
            goto L_0x026f
        L_0x0239:
            if (r1 != r6) goto L_0x024b
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r17
            r0.bp = r1
            r20.next()
            goto L_0x026f
        L_0x024b:
            if (r1 != r2) goto L_0x025d
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r17
            r0.bp = r1
            r20.next()
            goto L_0x026f
        L_0x025d:
            r5 = 26
            if (r1 != r5) goto L_0x0273
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r17
            r0.bp = r1
            r1 = 20
            r0.token = r1
            r0.ch = r5
        L_0x026f:
            r1 = 4
            r0.matchStat = r1
            return r9
        L_0x0273:
            r0.matchStat = r8
            r6 = 0
            return r6
        L_0x0277:
            r6 = 0
            r0.matchStat = r8
            return r6
        L_0x027b:
            r3 = 16
            r5 = 26
            r6 = 0
            r11 = 0
            r4 = r1
            r17 = r7
        L_0x0284:
            r10 = r2
            r5 = r3
            r3 = r6
            r1 = r11
            r2 = r17
        L_0x028a:
            r6 = 91
            goto L_0x003e
        L_0x028e:
            r12 = r2
            r5 = r3
            r3 = r6
            r6 = 91
            r2 = r1
            r1 = r11
            r11 = r17
            goto L_0x0055
        L_0x0299:
            r6 = r3
            r0.matchStat = r8
            return r6
        L_0x029d:
            r6 = r3
            goto L_0x028a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray2(long):double[][]");
    }

    public final float scanFieldFloat(long j10) {
        boolean z10;
        int i10;
        int i11;
        char charAt;
        int i12;
        char c10;
        int i13;
        float f10;
        int i14;
        char charAt2;
        boolean z11 = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0.0f;
        }
        int i15 = matchFieldHash + 1;
        char charAt3 = charAt(this.bp + matchFieldHash);
        int i16 = this.bp;
        int i17 = (i16 + i15) - 1;
        if (charAt3 == '-') {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            charAt3 = charAt(i16 + i15);
            i15 = matchFieldHash + 2;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i18 = charAt3 - '0';
        while (true) {
            i11 = i15 + 1;
            charAt = charAt(this.bp + i15);
            if (charAt >= '0' && charAt <= '9') {
                i18 = (i10 * 10) + (charAt - '0');
                i15 = i11;
            }
        }
        if (charAt == '.') {
            int i19 = i15 + 2;
            char charAt4 = charAt(this.bp + i11);
            if (charAt4 < '0' || charAt4 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            i10 = (i10 * 10) + (charAt4 - '0');
            int i20 = 10;
            while (true) {
                i14 = i19 + 1;
                charAt2 = charAt(this.bp + i19);
                if (charAt2 < '0' || charAt2 > '9') {
                    i11 = i14;
                    int i21 = i20;
                    charAt = charAt2;
                    i13 = i21;
                } else {
                    i10 = (i10 * 10) + (charAt2 - '0');
                    i20 *= 10;
                    i19 = i14;
                }
            }
            i11 = i14;
            int i212 = i20;
            charAt = charAt2;
            i13 = i212;
        } else {
            i13 = 1;
        }
        if (c10 == 'e' || c10 == 'E') {
            z11 = true;
        }
        if (z11) {
            int i22 = i12 + 1;
            c10 = charAt(this.bp + i12);
            if (c10 == '+' || c10 == '-') {
                i12 += 2;
                c10 = charAt(this.bp + i22);
            } else {
                i12 = i22;
            }
            while (c10 >= '0' && c10 <= '9') {
                c10 = charAt(this.bp + i12);
                i12++;
            }
        }
        int i23 = ((this.bp + i12) - i17) - 1;
        if (z11 || i23 >= 10) {
            f10 = Float.parseFloat(subString(i17, i23));
        } else {
            f10 = ((float) i10) / ((float) i13);
            if (z10) {
                f10 = -f10;
            }
        }
        if (c10 == ',') {
            this.bp += i12 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return f10;
        } else if (c10 == '}') {
            char charAt5 = charAt(this.bp + i12);
            if (charAt5 == ',') {
                this.token = 16;
                this.bp += i12;
                next();
            } else if (charAt5 == ']') {
                this.token = 15;
                this.bp += i12;
                next();
            } else if (charAt5 == '}') {
                this.token = 13;
                this.bp += i12;
                next();
            } else if (charAt5 == 26) {
                this.bp += i12;
                this.token = 20;
                this.ch = EOI;
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
            this.matchStat = 4;
            return f10;
        } else {
            this.matchStat = -1;
            return 0.0f;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x012f  */
    public final float[] scanFieldFloatArray(long r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r0.matchStat = r1
            int r2 = r19.matchFieldHash(r20)
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            int r4 = r0.bp
            int r5 = r2 + 1
            int r4 = r4 + r2
            int r6 = r0.len
            if (r4 < r6) goto L_0x0019
            r4 = 26
            goto L_0x001f
        L_0x0019:
            java.lang.String r6 = r0.text
            char r4 = r6.charAt(r4)
        L_0x001f:
            r6 = 91
            r8 = -1
            if (r4 == r6) goto L_0x0027
            r0.matchStat = r8
            return r3
        L_0x0027:
            int r4 = r0.bp
            int r2 = r2 + 2
            int r4 = r4 + r5
            int r5 = r0.len
            if (r4 < r5) goto L_0x0033
            r4 = 26
            goto L_0x0039
        L_0x0033:
            java.lang.String r5 = r0.text
            char r4 = r5.charAt(r4)
        L_0x0039:
            r5 = 16
            float[] r6 = new float[r5]
            r9 = r1
        L_0x003e:
            int r10 = r0.bp
            int r11 = r10 + r2
            r12 = 1
            int r11 = r11 - r12
            r13 = 45
            if (r4 != r13) goto L_0x004a
            r14 = r12
            goto L_0x004b
        L_0x004a:
            r14 = r1
        L_0x004b:
            if (r14 == 0) goto L_0x0062
            int r4 = r2 + 1
            int r10 = r10 + r2
            int r2 = r0.len
            if (r10 < r2) goto L_0x0057
            r2 = 26
            goto L_0x005d
        L_0x0057:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r10)
        L_0x005d:
            r18 = r4
            r4 = r2
            r2 = r18
        L_0x0062:
            r10 = 48
            if (r4 < r10) goto L_0x0229
            r15 = 57
            if (r4 > r15) goto L_0x0229
            int r4 = r4 + -48
        L_0x006c:
            int r7 = r0.bp
            int r16 = r2 + 1
            int r7 = r7 + r2
            int r5 = r0.len
            if (r7 < r5) goto L_0x0078
            r5 = 26
            goto L_0x007e
        L_0x0078:
            java.lang.String r5 = r0.text
            char r5 = r5.charAt(r7)
        L_0x007e:
            if (r5 < r10) goto L_0x008c
            if (r5 > r15) goto L_0x008c
            int r4 = r4 * 10
            int r5 = r5 + -48
            int r4 = r4 + r5
            r2 = r16
            r5 = 16
            goto L_0x006c
        L_0x008c:
            r7 = 46
            if (r5 != r7) goto L_0x0092
            r7 = r12
            goto L_0x0093
        L_0x0092:
            r7 = r1
        L_0x0093:
            r1 = 10
            if (r7 == 0) goto L_0x00dd
            int r5 = r0.bp
            int r2 = r2 + 2
            int r5 = r5 + r16
            int r7 = r0.len
            if (r5 < r7) goto L_0x00a4
            r5 = 26
            goto L_0x00aa
        L_0x00a4:
            java.lang.String r7 = r0.text
            char r5 = r7.charAt(r5)
        L_0x00aa:
            if (r5 < r10) goto L_0x00da
            if (r5 > r15) goto L_0x00da
            int r4 = r4 * 10
            int r5 = r5 + -48
            int r4 = r4 + r5
            r5 = r1
        L_0x00b4:
            int r7 = r0.bp
            int r16 = r2 + 1
            int r7 = r7 + r2
            int r2 = r0.len
            if (r7 < r2) goto L_0x00c0
            r2 = 26
            goto L_0x00c6
        L_0x00c0:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r7)
        L_0x00c6:
            if (r2 < r10) goto L_0x00d4
            if (r2 > r15) goto L_0x00d4
            int r4 = r4 * 10
            int r2 = r2 + -48
            int r4 = r4 + r2
            int r5 = r5 * 10
            r2 = r16
            goto L_0x00b4
        L_0x00d4:
            r18 = r5
            r5 = r2
            r2 = r18
            goto L_0x00de
        L_0x00da:
            r0.matchStat = r8
            return r3
        L_0x00dd:
            r2 = r12
        L_0x00de:
            r7 = 101(0x65, float:1.42E-43)
            if (r5 == r7) goto L_0x00e9
            r7 = 69
            if (r5 != r7) goto L_0x00e7
            goto L_0x00e9
        L_0x00e7:
            r7 = 0
            goto L_0x00ea
        L_0x00e9:
            r7 = r12
        L_0x00ea:
            if (r7 == 0) goto L_0x0138
            int r5 = r0.bp
            int r17 = r16 + 1
            int r5 = r5 + r16
            int r3 = r0.len
            if (r5 < r3) goto L_0x00f9
            r3 = 26
            goto L_0x00ff
        L_0x00f9:
            java.lang.String r3 = r0.text
            char r3 = r3.charAt(r5)
        L_0x00ff:
            r5 = 43
            if (r3 == r5) goto L_0x010a
            if (r3 != r13) goto L_0x0106
            goto L_0x010a
        L_0x0106:
            r5 = r3
            r16 = r17
            goto L_0x011e
        L_0x010a:
            int r3 = r0.bp
            int r16 = r16 + 2
            int r3 = r3 + r17
            int r5 = r0.len
            if (r3 < r5) goto L_0x0117
            r3 = 26
            goto L_0x011d
        L_0x0117:
            java.lang.String r5 = r0.text
            char r3 = r5.charAt(r3)
        L_0x011d:
            r5 = r3
        L_0x011e:
            if (r5 < r10) goto L_0x0138
            if (r5 > r15) goto L_0x0138
            int r3 = r0.bp
            int r5 = r16 + 1
            int r3 = r3 + r16
            int r13 = r0.len
            if (r3 < r13) goto L_0x012f
            r3 = 26
            goto L_0x0135
        L_0x012f:
            java.lang.String r13 = r0.text
            char r3 = r13.charAt(r3)
        L_0x0135:
            r16 = r5
            goto L_0x011d
        L_0x0138:
            int r3 = r0.bp
            int r3 = r3 + r16
            int r3 = r3 - r11
            int r3 = r3 - r12
            if (r7 != 0) goto L_0x0149
            if (r3 >= r1) goto L_0x0149
            float r1 = (float) r4
            float r2 = (float) r2
            float r1 = r1 / r2
            if (r14 == 0) goto L_0x0151
            float r1 = -r1
            goto L_0x0151
        L_0x0149:
            java.lang.String r1 = r0.subString(r11, r3)
            float r1 = java.lang.Float.parseFloat(r1)
        L_0x0151:
            int r2 = r6.length
            r3 = 3
            if (r9 < r2) goto L_0x0160
            int r2 = r6.length
            int r2 = r2 * r3
            int r2 = r2 / 2
            float[] r2 = new float[r2]
            r4 = 0
            java.lang.System.arraycopy(r6, r4, r2, r4, r9)
            r6 = r2
        L_0x0160:
            int r4 = r9 + 1
            r6[r9] = r1
            r1 = 44
            if (r5 != r1) goto L_0x0186
            int r1 = r0.bp
            int r2 = r16 + 1
            int r1 = r1 + r16
            int r3 = r0.len
            if (r1 < r3) goto L_0x0175
            r1 = 26
            goto L_0x017b
        L_0x0175:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x017b:
            r5 = r1
            r16 = r2
        L_0x017e:
            r1 = 16
            r2 = 26
            r3 = 0
            r10 = 0
            goto L_0x0221
        L_0x0186:
            r2 = 93
            if (r5 != r2) goto L_0x017e
            int r5 = r0.bp
            int r7 = r16 + 1
            int r5 = r5 + r16
            int r9 = r0.len
            if (r5 < r9) goto L_0x0197
            r5 = 26
            goto L_0x019d
        L_0x0197:
            java.lang.String r9 = r0.text
            char r5 = r9.charAt(r5)
        L_0x019d:
            int r9 = r6.length
            if (r4 == r9) goto L_0x01a7
            float[] r9 = new float[r4]
            r10 = 0
            java.lang.System.arraycopy(r6, r10, r9, r10, r4)
            r6 = r9
        L_0x01a7:
            if (r5 != r1) goto L_0x01b9
            int r1 = r0.bp
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            r0.matchStat = r3
            r1 = 16
            r0.token = r1
            return r6
        L_0x01b9:
            r3 = 125(0x7d, float:1.75E-43)
            if (r5 != r3) goto L_0x021d
            int r4 = r0.bp
            int r4 = r4 + r7
            int r5 = r0.len
            if (r4 < r5) goto L_0x01c7
            r4 = 26
            goto L_0x01cd
        L_0x01c7:
            java.lang.String r5 = r0.text
            char r4 = r5.charAt(r4)
        L_0x01cd:
            if (r4 != r1) goto L_0x01df
            r1 = 16
            r0.token = r1
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            goto L_0x0215
        L_0x01df:
            if (r4 != r2) goto L_0x01f1
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            goto L_0x0215
        L_0x01f1:
            if (r4 != r3) goto L_0x0203
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r19.next()
            goto L_0x0215
        L_0x0203:
            r2 = 26
            if (r4 != r2) goto L_0x0219
            int r1 = r0.bp
            int r16 = r16 + 1
            int r1 = r1 + r16
            r0.bp = r1
            r1 = 20
            r0.token = r1
            r0.ch = r2
        L_0x0215:
            r1 = 4
            r0.matchStat = r1
            return r6
        L_0x0219:
            r0.matchStat = r8
            r3 = 0
            return r3
        L_0x021d:
            r3 = 0
            r0.matchStat = r8
            return r3
        L_0x0221:
            r9 = r4
            r4 = r5
            r2 = r16
            r5 = r1
            r1 = r10
            goto L_0x003e
        L_0x0229:
            r0.matchStat = r8
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray(long):float[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:162:0x029a, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float[][] scanFieldFloatArray2(long r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = 0
            r0.matchStat = r1
            int r2 = r20.matchFieldHash(r21)
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            int r4 = r0.bp
            int r5 = r2 + 1
            int r4 = r4 + r2
            int r6 = r0.len
            if (r4 < r6) goto L_0x0019
            r4 = 26
            goto L_0x001f
        L_0x0019:
            java.lang.String r6 = r0.text
            char r4 = r6.charAt(r4)
        L_0x001f:
            r6 = 91
            r8 = -1
            if (r4 == r6) goto L_0x0027
            r0.matchStat = r8
            return r3
        L_0x0027:
            int r4 = r0.bp
            int r2 = r2 + 2
            int r4 = r4 + r5
            int r5 = r0.len
            if (r4 < r5) goto L_0x0033
            r4 = 26
            goto L_0x0039
        L_0x0033:
            java.lang.String r5 = r0.text
            char r4 = r5.charAt(r4)
        L_0x0039:
            r5 = 16
            float[][] r9 = new float[r5][]
            r10 = r1
        L_0x003e:
            if (r4 != r6) goto L_0x029b
            int r4 = r0.bp
            int r11 = r2 + 1
            int r4 = r4 + r2
            int r2 = r0.len
            if (r4 < r2) goto L_0x004c
            r2 = 26
            goto L_0x0052
        L_0x004c:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r4)
        L_0x0052:
            float[] r4 = new float[r5]
            r12 = r1
        L_0x0055:
            int r13 = r0.bp
            int r14 = r13 + r11
            r15 = 1
            int r14 = r14 - r15
            r6 = 45
            if (r2 != r6) goto L_0x0062
            r16 = r15
            goto L_0x0064
        L_0x0062:
            r16 = r1
        L_0x0064:
            if (r16 == 0) goto L_0x007b
            int r2 = r11 + 1
            int r13 = r13 + r11
            int r11 = r0.len
            if (r13 < r11) goto L_0x0070
            r11 = 26
            goto L_0x0076
        L_0x0070:
            java.lang.String r11 = r0.text
            char r11 = r11.charAt(r13)
        L_0x0076:
            r19 = r11
            r11 = r2
            r2 = r19
        L_0x007b:
            r13 = 48
            if (r2 < r13) goto L_0x0297
            r7 = 57
            if (r2 > r7) goto L_0x0297
            int r2 = r2 + -48
        L_0x0085:
            int r5 = r0.bp
            int r17 = r11 + 1
            int r5 = r5 + r11
            int r1 = r0.len
            if (r5 < r1) goto L_0x0091
            r1 = 26
            goto L_0x0097
        L_0x0091:
            java.lang.String r1 = r0.text
            char r1 = r1.charAt(r5)
        L_0x0097:
            if (r1 < r13) goto L_0x00a4
            if (r1 > r7) goto L_0x00a4
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r11 = r17
            r1 = 0
            goto L_0x0085
        L_0x00a4:
            r5 = 46
            r15 = 10
            if (r1 != r5) goto L_0x00f1
            int r1 = r0.bp
            int r11 = r11 + 2
            int r1 = r1 + r17
            int r5 = r0.len
            if (r1 < r5) goto L_0x00b7
            r1 = 26
            goto L_0x00bd
        L_0x00b7:
            java.lang.String r5 = r0.text
            char r1 = r5.charAt(r1)
        L_0x00bd:
            if (r1 < r13) goto L_0x00ee
            if (r1 > r7) goto L_0x00ee
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r1 = r15
        L_0x00c7:
            int r5 = r0.bp
            int r17 = r11 + 1
            int r5 = r5 + r11
            int r11 = r0.len
            if (r5 < r11) goto L_0x00d3
            r5 = 26
            goto L_0x00d9
        L_0x00d3:
            java.lang.String r11 = r0.text
            char r5 = r11.charAt(r5)
        L_0x00d9:
            if (r5 < r13) goto L_0x00e7
            if (r5 > r7) goto L_0x00e7
            int r2 = r2 * 10
            int r5 = r5 + -48
            int r2 = r2 + r5
            int r1 = r1 * 10
            r11 = r17
            goto L_0x00c7
        L_0x00e7:
            r19 = r2
            r2 = r1
            r1 = r5
            r5 = r19
            goto L_0x00f3
        L_0x00ee:
            r0.matchStat = r8
            return r3
        L_0x00f1:
            r5 = r2
            r2 = 1
        L_0x00f3:
            r11 = 101(0x65, float:1.42E-43)
            if (r1 == r11) goto L_0x00fe
            r11 = 69
            if (r1 != r11) goto L_0x00fc
            goto L_0x00fe
        L_0x00fc:
            r11 = 0
            goto L_0x00ff
        L_0x00fe:
            r11 = 1
        L_0x00ff:
            if (r11 == 0) goto L_0x014b
            int r1 = r0.bp
            int r18 = r17 + 1
            int r1 = r1 + r17
            int r3 = r0.len
            if (r1 < r3) goto L_0x010e
            r1 = 26
            goto L_0x0114
        L_0x010e:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x0114:
            r3 = 43
            if (r1 == r3) goto L_0x011e
            if (r1 != r6) goto L_0x011b
            goto L_0x011e
        L_0x011b:
            r17 = r18
            goto L_0x0131
        L_0x011e:
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r18
            int r3 = r0.len
            if (r1 < r3) goto L_0x012b
            r1 = 26
            goto L_0x0131
        L_0x012b:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x0131:
            if (r1 < r13) goto L_0x014b
            if (r1 > r7) goto L_0x014b
            int r1 = r0.bp
            int r3 = r17 + 1
            int r1 = r1 + r17
            int r6 = r0.len
            if (r1 < r6) goto L_0x0142
            r1 = 26
            goto L_0x0148
        L_0x0142:
            java.lang.String r6 = r0.text
            char r1 = r6.charAt(r1)
        L_0x0148:
            r17 = r3
            goto L_0x0131
        L_0x014b:
            int r3 = r0.bp
            int r3 = r3 + r17
            int r3 = r3 - r14
            r6 = 1
            int r3 = r3 - r6
            if (r11 != 0) goto L_0x015d
            if (r3 >= r15) goto L_0x015d
            float r3 = (float) r5
            float r2 = (float) r2
            float r3 = r3 / r2
            if (r16 == 0) goto L_0x0165
            float r3 = -r3
            goto L_0x0165
        L_0x015d:
            java.lang.String r2 = r0.subString(r14, r3)
            float r3 = java.lang.Float.parseFloat(r2)
        L_0x0165:
            int r2 = r4.length
            r5 = 3
            if (r12 < r2) goto L_0x0174
            int r2 = r4.length
            int r2 = r2 * r5
            int r2 = r2 / 2
            float[] r2 = new float[r2]
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r2, r6, r12)
            r4 = r2
        L_0x0174:
            int r2 = r12 + 1
            r4[r12] = r3
            r3 = 44
            if (r1 != r3) goto L_0x0199
            int r1 = r0.bp
            int r3 = r17 + 1
            int r1 = r1 + r17
            int r5 = r0.len
            if (r1 < r5) goto L_0x0189
            r1 = 26
            goto L_0x018f
        L_0x0189:
            java.lang.String r5 = r0.text
            char r1 = r5.charAt(r1)
        L_0x018f:
            r17 = r3
        L_0x0191:
            r3 = 26
            r5 = 16
            r6 = 0
            r11 = 0
            goto L_0x028d
        L_0x0199:
            r6 = 93
            if (r1 != r6) goto L_0x0191
            int r1 = r0.bp
            int r7 = r17 + 1
            int r1 = r1 + r17
            int r11 = r0.len
            if (r1 < r11) goto L_0x01aa
            r1 = 26
            goto L_0x01b0
        L_0x01aa:
            java.lang.String r11 = r0.text
            char r1 = r11.charAt(r1)
        L_0x01b0:
            int r11 = r4.length
            if (r2 == r11) goto L_0x01bb
            float[] r11 = new float[r2]
            r12 = 0
            java.lang.System.arraycopy(r4, r12, r11, r12, r2)
            r4 = r11
            goto L_0x01bc
        L_0x01bb:
            r12 = 0
        L_0x01bc:
            int r11 = r9.length
            if (r10 < r11) goto L_0x01c8
            int r9 = r9.length
            int r9 = r9 * r5
            int r9 = r9 / 2
            float[][] r9 = new float[r9][]
            java.lang.System.arraycopy(r4, r12, r9, r12, r2)
        L_0x01c8:
            int r2 = r10 + 1
            r9[r10] = r4
            if (r1 != r3) goto L_0x01e9
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r7
            int r3 = r0.len
            if (r1 < r3) goto L_0x01da
            r1 = 26
            goto L_0x01e0
        L_0x01da:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x01e0:
            r4 = r1
            r3 = 26
            r5 = 16
            r6 = 0
            r11 = 0
            goto L_0x0284
        L_0x01e9:
            if (r1 != r6) goto L_0x027b
            int r1 = r0.bp
            int r4 = r17 + 2
            int r1 = r1 + r7
            int r7 = r0.len
            if (r1 < r7) goto L_0x01f7
            r1 = 26
            goto L_0x01fd
        L_0x01f7:
            java.lang.String r7 = r0.text
            char r1 = r7.charAt(r1)
        L_0x01fd:
            int r7 = r9.length
            if (r2 == r7) goto L_0x0207
            float[][] r7 = new float[r2][]
            r11 = 0
            java.lang.System.arraycopy(r9, r11, r7, r11, r2)
            r9 = r7
        L_0x0207:
            if (r1 != r3) goto L_0x021c
            int r1 = r0.bp
            r2 = 1
            int r17 = r17 + 1
            int r1 = r1 + r17
            r0.bp = r1
            r20.next()
            r0.matchStat = r5
            r5 = 16
            r0.token = r5
            return r9
        L_0x021c:
            r5 = 16
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 != r2) goto L_0x0277
            int r1 = r0.bp
            int r1 = r1 + r4
            char r1 = r0.charAt(r1)
            if (r1 != r3) goto L_0x0239
            r0.token = r5
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r17
            r0.bp = r1
            r20.next()
            goto L_0x026f
        L_0x0239:
            if (r1 != r6) goto L_0x024b
            r1 = 15
            r0.token = r1
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r17
            r0.bp = r1
            r20.next()
            goto L_0x026f
        L_0x024b:
            if (r1 != r2) goto L_0x025d
            r1 = 13
            r0.token = r1
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r17
            r0.bp = r1
            r20.next()
            goto L_0x026f
        L_0x025d:
            r3 = 26
            if (r1 != r3) goto L_0x0273
            int r1 = r0.bp
            int r17 = r17 + 2
            int r1 = r1 + r17
            r0.bp = r1
            r1 = 20
            r0.token = r1
            r0.ch = r3
        L_0x026f:
            r1 = 4
            r0.matchStat = r1
            return r9
        L_0x0273:
            r0.matchStat = r8
            r6 = 0
            return r6
        L_0x0277:
            r6 = 0
            r0.matchStat = r8
            return r6
        L_0x027b:
            r3 = 26
            r5 = 16
            r6 = 0
            r11 = 0
            r4 = r1
            r17 = r7
        L_0x0284:
            r10 = r2
            r3 = r6
            r1 = r11
            r2 = r17
        L_0x0289:
            r6 = 91
            goto L_0x003e
        L_0x028d:
            r12 = r2
            r3 = r6
            r6 = 91
            r2 = r1
            r1 = r11
            r11 = r17
            goto L_0x0055
        L_0x0297:
            r6 = r3
            r0.matchStat = r8
            return r6
        L_0x029b:
            r6 = r3
            goto L_0x0289
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray2(long):float[][]");
    }

    public int scanFieldInt(long j10) {
        char c10;
        boolean z10;
        boolean z11;
        int i10;
        char c11;
        char charAt;
        char charAt2;
        char charAt3;
        char charAt4;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i11 = matchFieldHash + 1;
        int i12 = this.bp + matchFieldHash;
        int i13 = this.len;
        char c12 = EOI;
        if (i12 >= i13) {
            c10 = 26;
        } else {
            c10 = this.text.charAt(i12);
        }
        if (c10 == '\"') {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i14 = matchFieldHash + 2;
            int i15 = this.bp + i11;
            if (i15 >= this.len) {
                charAt4 = 26;
            } else {
                charAt4 = this.text.charAt(i15);
            }
            i11 = i14;
            z10 = true;
        }
        if (c10 == '-') {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i16 = i11 + 1;
            int i17 = this.bp + i11;
            if (i17 >= this.len) {
                charAt3 = 26;
            } else {
                charAt3 = this.text.charAt(i17);
            }
            i11 = i16;
        }
        if (c10 < '0' || c10 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i18 = c10 - '0';
        while (true) {
            i10 = i11 + 1;
            int i19 = this.bp + i11;
            if (i19 >= this.len) {
                c11 = 26;
            } else {
                c11 = this.text.charAt(i19);
            }
            if (c11 >= '0' && c11 <= '9') {
                i18 = (i18 * 10) + (c11 - '0');
                i11 = i10;
            }
        }
        if (c11 == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (c11 == '\"') {
            if (!z10) {
                this.matchStat = -1;
                return 0;
            }
            int i20 = i11 + 2;
            int i21 = this.bp + i10;
            if (i21 >= this.len) {
                charAt2 = 26;
            } else {
                charAt2 = this.text.charAt(i21);
            }
            i10 = i20;
        }
        if (i18 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (c11 != ',') {
            if (c11 <= ' ' && (c11 == ' ' || c11 == 10 || c11 == 13 || c11 == 9 || c11 == 12 || c11 == 8)) {
                int i22 = i10 + 1;
                int i23 = this.bp + i10;
                if (i23 >= this.len) {
                    charAt = 26;
                } else {
                    charAt = this.text.charAt(i23);
                }
                i10 = i22;
            } else if (c11 == '}') {
                char charAt5 = charAt(this.bp + i10);
                if (charAt5 == ',') {
                    this.token = 16;
                    int i24 = this.bp + i10 + 1;
                    this.bp = i24;
                    if (i24 < this.len) {
                        c12 = this.text.charAt(i24);
                    }
                    this.ch = c12;
                } else if (charAt5 == ']') {
                    this.token = 15;
                    int i25 = this.bp + i10 + 1;
                    this.bp = i25;
                    if (i25 < this.len) {
                        c12 = this.text.charAt(i25);
                    }
                    this.ch = c12;
                } else if (charAt5 == '}') {
                    this.token = 13;
                    int i26 = this.bp + i10 + 1;
                    this.bp = i26;
                    if (i26 < this.len) {
                        c12 = this.text.charAt(i26);
                    }
                    this.ch = c12;
                } else if (charAt5 == 26) {
                    this.token = 20;
                    this.bp += i10;
                    this.ch = EOI;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
                this.matchStat = 4;
                if (z11) {
                    return -i18;
                }
                return i18;
            } else {
                this.matchStat = -1;
                return 0;
            }
        }
        int i27 = this.bp + (i10 - 1) + 1;
        this.bp = i27;
        if (i27 < this.len) {
            c12 = this.text.charAt(i27);
        }
        this.ch = c12;
        this.matchStat = 3;
        this.token = 16;
        if (z11) {
            return -i18;
        }
        return i18;
    }

    public final int[] scanFieldIntArray(long j10) {
        char c10;
        char c11;
        char c12;
        int i10;
        int i11;
        boolean z10;
        int[] iArr;
        int i12;
        int i13;
        char c13;
        char c14;
        char c15;
        char charAt;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        int[] iArr2 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i14 = matchFieldHash + 1;
        int i15 = this.bp + matchFieldHash;
        if (i15 >= this.len) {
            c10 = EOI;
        } else {
            c10 = this.text.charAt(i15);
        }
        int i16 = -1;
        if (c10 != '[') {
            this.matchStat = -1;
            return null;
        }
        int i17 = matchFieldHash + 2;
        int i18 = this.bp + i14;
        if (i18 >= this.len) {
            c11 = EOI;
        } else {
            c11 = this.text.charAt(i18);
        }
        int[] iArr3 = new int[16];
        if (c11 == ']') {
            i11 = matchFieldHash + 3;
            int i19 = this.bp + i17;
            if (i19 >= this.len) {
                c12 = EOI;
            } else {
                c12 = this.text.charAt(i19);
            }
            i10 = 0;
        } else {
            int i20 = 0;
            while (true) {
                if (c11 == '-') {
                    int i21 = i17 + 1;
                    int i22 = this.bp + i17;
                    if (i22 >= this.len) {
                        charAt = EOI;
                    } else {
                        charAt = this.text.charAt(i22);
                    }
                    i17 = i21;
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (c11 >= '0') {
                    if (c11 > '9') {
                        i12 = i16;
                        iArr = null;
                        break;
                    }
                    int i23 = c11 - '0';
                    while (true) {
                        i13 = i17 + 1;
                        int i24 = this.bp + i17;
                        if (i24 >= this.len) {
                            c13 = EOI;
                        } else {
                            c13 = this.text.charAt(i24);
                        }
                        if (c13 >= '0' && c13 <= '9') {
                            i23 = (i23 * 10) + (c13 - '0');
                            i17 = i13;
                        }
                    }
                    if (i20 >= iArr3.length) {
                        int[] iArr4 = new int[((iArr3.length * 3) / 2)];
                        System.arraycopy(iArr3, 0, iArr4, 0, i20);
                        iArr3 = iArr4;
                    }
                    i10 = i20 + 1;
                    if (z10) {
                        i23 = -i23;
                    }
                    iArr3[i20] = i23;
                    if (c13 == ',') {
                        int i25 = i17 + 2;
                        int i26 = this.bp + i13;
                        if (i26 >= this.len) {
                            c15 = EOI;
                        } else {
                            c15 = this.text.charAt(i26);
                        }
                        c13 = c15;
                        i13 = i25;
                    } else if (c13 == ']') {
                        int i27 = i17 + 2;
                        int i28 = this.bp + i13;
                        if (i28 >= this.len) {
                            c14 = EOI;
                        } else {
                            c14 = this.text.charAt(i28);
                        }
                        int i29 = i27;
                        c12 = c14;
                        i11 = i29;
                    }
                    i16 = -1;
                    i20 = i10;
                    iArr2 = null;
                    c11 = c13;
                    i17 = i13;
                } else {
                    iArr = iArr2;
                    i12 = i16;
                    break;
                }
            }
            this.matchStat = i12;
            return iArr;
        }
        if (i10 != iArr3.length) {
            int[] iArr5 = new int[i10];
            System.arraycopy(iArr3, 0, iArr5, 0, i10);
            iArr3 = iArr5;
        }
        if (c12 == ',') {
            this.bp += i11 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr3;
        } else if (c12 == '}') {
            char charAt2 = charAt(this.bp + i11);
            if (charAt2 == ',') {
                this.token = 16;
                this.bp += i11;
                next();
            } else if (charAt2 == ']') {
                this.token = 15;
                this.bp += i11;
                next();
            } else if (charAt2 == '}') {
                this.token = 13;
                this.bp += i11;
                next();
            } else if (charAt2 == 26) {
                this.bp += i11;
                this.token = 20;
                this.ch = EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr3;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldLong(long j10) {
        char c10;
        boolean z10;
        int i10;
        char c11;
        char c12;
        char c13;
        char c14;
        char c15;
        char charAt;
        char c16;
        char charAt2;
        boolean z11 = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i11 = matchFieldHash + 1;
        int i12 = this.bp + matchFieldHash;
        if (i12 >= this.len) {
            c10 = EOI;
        } else {
            c10 = this.text.charAt(i12);
        }
        if (c10 == '\"') {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i13 = matchFieldHash + 2;
            int i14 = this.bp + i11;
            if (i14 >= this.len) {
                charAt2 = EOI;
            } else {
                charAt2 = this.text.charAt(i14);
            }
            i11 = i13;
        }
        if (c10 == '-') {
            z11 = true;
        }
        if (z11) {
            int i15 = i11 + 1;
            int i16 = this.bp + i11;
            if (i16 >= this.len) {
                c16 = EOI;
            } else {
                c16 = this.text.charAt(i16);
            }
            i11 = i15;
            c10 = c16;
        }
        if (c10 < '0' || c10 > '9') {
            this.matchStat = -1;
            return 0;
        }
        long j11 = (long) (c10 - '0');
        while (true) {
            i10 = i11 + 1;
            int i17 = this.bp + i11;
            if (i17 >= this.len) {
                c11 = EOI;
            } else {
                c11 = this.text.charAt(i17);
            }
            if (c11 >= '0' && c11 <= '9') {
                j11 = (j11 * 10) + ((long) (c11 - '0'));
                i11 = i10;
            }
        }
        if (c11 == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (c11 == '\"') {
            if (!z10) {
                this.matchStat = -1;
                return 0;
            }
            int i18 = i11 + 2;
            int i19 = this.bp + i10;
            if (i19 >= this.len) {
                charAt = EOI;
            } else {
                charAt = this.text.charAt(i19);
            }
            i10 = i18;
        }
        if (j11 < 0) {
            this.matchStat = -1;
            return 0;
        } else if (c11 == ',') {
            int i20 = this.bp + (i10 - 1) + 1;
            this.bp = i20;
            if (i20 >= this.len) {
                c15 = EOI;
            } else {
                c15 = this.text.charAt(i20);
            }
            this.ch = c15;
            this.matchStat = 3;
            this.token = 16;
            if (z11) {
                return -j11;
            }
            return j11;
        } else if (c11 == '}') {
            char charAt3 = charAt(this.bp + i10);
            if (charAt3 == ',') {
                this.token = 16;
                int i21 = this.bp + i10 + 1;
                this.bp = i21;
                if (i21 >= this.len) {
                    c14 = EOI;
                } else {
                    c14 = this.text.charAt(i21);
                }
                this.ch = c14;
            } else if (charAt3 == ']') {
                this.token = 15;
                int i22 = this.bp + i10 + 1;
                this.bp = i22;
                if (i22 >= this.len) {
                    c13 = EOI;
                } else {
                    c13 = this.text.charAt(i22);
                }
                this.ch = c13;
            } else if (charAt3 == '}') {
                this.token = 13;
                int i23 = this.bp + i10 + 1;
                this.bp = i23;
                if (i23 >= this.len) {
                    c12 = EOI;
                } else {
                    c12 = this.text.charAt(i23);
                }
                this.ch = c12;
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i10;
                this.ch = EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            if (z11) {
                return -j11;
            }
            return j11;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public String scanFieldString(long j10) {
        String str;
        char c10;
        char c11;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return null;
        }
        int i10 = matchFieldHash + 1;
        int i11 = this.bp + matchFieldHash;
        if (i11 >= this.len) {
            throw new JSONException("unclosed str, " + info());
        } else if (this.text.charAt(i11) != '\"') {
            this.matchStat = -1;
            return this.stringDefaultValue;
        } else {
            int i12 = this.bp + i10;
            int indexOf = this.text.indexOf(34, i12);
            if (indexOf != -1) {
                if (V6) {
                    str = this.text.substring(i12, indexOf);
                } else {
                    int i13 = indexOf - i12;
                    str = new String(sub_chars(this.bp + i10, i13), 0, i13);
                }
                if (str.indexOf(92) != -1) {
                    boolean z10 = false;
                    while (true) {
                        int i14 = indexOf - 1;
                        int i15 = 0;
                        while (i14 >= 0 && this.text.charAt(i14) == '\\') {
                            i15++;
                            i14--;
                            z10 = true;
                        }
                        if (i15 % 2 == 0) {
                            break;
                        }
                        indexOf = this.text.indexOf(34, indexOf + 1);
                    }
                    int i16 = indexOf - i12;
                    char[] sub_chars = sub_chars(this.bp + i10, i16);
                    if (z10) {
                        str = readString(sub_chars, i16);
                    } else {
                        str = new String(sub_chars, 0, i16);
                        if (str.indexOf(92) != -1) {
                            str = readString(sub_chars, i16);
                        }
                    }
                }
                int i17 = indexOf + 1;
                int i18 = this.len;
                char c12 = EOI;
                if (i17 >= i18) {
                    c10 = 26;
                } else {
                    c10 = this.text.charAt(i17);
                }
                if (c10 == ',') {
                    int i19 = indexOf + 2;
                    this.bp = i19;
                    if (i19 < this.len) {
                        c12 = this.text.charAt(i19);
                    }
                    this.ch = c12;
                    this.matchStat = 3;
                    this.token = 16;
                    return str;
                } else if (c10 == '}') {
                    int i20 = indexOf + 2;
                    if (i20 >= this.len) {
                        c11 = 26;
                    } else {
                        c11 = this.text.charAt(i20);
                    }
                    if (c11 == ',') {
                        this.token = 16;
                        this.bp = i20;
                        next();
                    } else if (c11 == ']') {
                        this.token = 15;
                        this.bp = i20;
                        next();
                    } else if (c11 == '}') {
                        this.token = 13;
                        this.bp = i20;
                        next();
                    } else if (c11 == 26) {
                        this.token = 20;
                        this.bp = i20;
                        this.ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return this.stringDefaultValue;
                    }
                    this.matchStat = 4;
                    return str;
                } else {
                    this.matchStat = -1;
                    return this.stringDefaultValue;
                }
            } else {
                throw new JSONException("unclosed str, " + info());
            }
        }
    }

    public long scanFieldSymbol(long j10) {
        char c10;
        char c11;
        char c12;
        char c13;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i10 = matchFieldHash + 1;
        int i11 = this.bp + matchFieldHash;
        int i12 = this.len;
        char c14 = EOI;
        if (i11 >= i12) {
            c10 = 26;
        } else {
            c10 = this.text.charAt(i11);
        }
        if (c10 != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j11 = -3750763034362895579L;
        while (true) {
            int i13 = i10 + 1;
            int i14 = this.bp + i10;
            if (i14 >= this.len) {
                c11 = 26;
            } else {
                c11 = this.text.charAt(i14);
            }
            if (c11 == '\"') {
                int i15 = i10 + 2;
                int i16 = this.bp + i13;
                if (i16 >= this.len) {
                    c12 = 26;
                } else {
                    c12 = this.text.charAt(i16);
                }
                if (c12 == ',') {
                    int i17 = this.bp + i10 + 1 + 1;
                    this.bp = i17;
                    if (i17 < this.len) {
                        c14 = this.text.charAt(i17);
                    }
                    this.ch = c14;
                    this.matchStat = 3;
                    return j11;
                } else if (c12 == '}') {
                    int i18 = this.bp + i15;
                    if (i18 >= this.len) {
                        c13 = 26;
                    } else {
                        c13 = this.text.charAt(i18);
                    }
                    if (c13 == ',') {
                        this.token = 16;
                        this.bp += i10 + 2;
                        next();
                    } else if (c13 == ']') {
                        this.token = 15;
                        this.bp += i10 + 2;
                        next();
                    } else if (c13 == '}') {
                        this.token = 13;
                        this.bp += i10 + 2;
                        next();
                    } else if (c13 == 26) {
                        this.token = 20;
                        this.bp += i10 + 2;
                        this.ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return j11;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else {
                j11 = (j11 ^ ((long) c11)) * 1099511628211L;
                if (c11 == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i10 = i13;
            }
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z10) {
        return scanISO8601DateIfMatch(z10, this.len - this.bp);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long scanLongValue() {
        /*
            r12 = this;
            r0 = 0
            r12.np = r0
            char r1 = r12.ch
            r2 = 45
            r3 = 1
            if (r1 != r2) goto L_0x003d
            r12.np = r3
            int r0 = r12.bp
            int r0 = r0 + r3
            r12.bp = r0
            int r1 = r12.len
            if (r0 >= r1) goto L_0x0022
            java.lang.String r1 = r12.text
            char r0 = r1.charAt(r0)
            r12.ch = r0
            r0 = -9223372036854775808
            r1 = r0
            r0 = r3
            goto L_0x0042
        L_0x0022:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "syntax error, "
            r1.append(r2)
            java.lang.String r2 = r12.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x003d:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0042:
            r4 = 0
        L_0x0044:
            char r6 = r12.ch
            r7 = 48
            if (r6 < r7) goto L_0x00c0
            r7 = 57
            if (r6 > r7) goto L_0x00c0
            int r6 = r6 + -48
            r7 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            java.lang.String r8 = ", "
            java.lang.String r9 = "error long value, "
            if (r7 < 0) goto L_0x00a1
            r10 = 10
            long r4 = r4 * r10
            long r6 = (long) r6
            long r10 = r1 + r6
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x0082
            long r4 = r4 - r6
            int r6 = r12.np
            int r6 = r6 + r3
            r12.np = r6
            int r6 = r12.bp
            int r6 = r6 + r3
            r12.bp = r6
            int r7 = r12.len
            if (r6 < r7) goto L_0x0079
            r6 = 26
            goto L_0x007f
        L_0x0079:
            java.lang.String r7 = r12.text
            char r6 = r7.charAt(r6)
        L_0x007f:
            r12.ch = r6
            goto L_0x0044
        L_0x0082:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r4)
            r1.append(r8)
            java.lang.String r2 = r12.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00a1:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r4)
            r1.append(r8)
            java.lang.String r2 = r12.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00c0:
            if (r0 != 0) goto L_0x00c3
            long r4 = -r4
        L_0x00c3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanLongValue():long");
    }

    public final void scanNumber() {
        char c10;
        char c11;
        char c12;
        char c13;
        char c14;
        char c15;
        char c16;
        char c17;
        int i10 = this.bp;
        this.np = i10;
        this.exp = false;
        if (this.ch == '-') {
            this.sp++;
            int i11 = i10 + 1;
            this.bp = i11;
            if (i11 >= this.len) {
                c17 = 26;
            } else {
                c17 = this.text.charAt(i11);
            }
            this.ch = c17;
        }
        while (true) {
            c10 = this.ch;
            if (c10 < '0' || c10 > '9') {
                this.isDouble = false;
            } else {
                this.sp++;
                int i12 = this.bp + 1;
                this.bp = i12;
                if (i12 >= this.len) {
                    c16 = 26;
                } else {
                    c16 = this.text.charAt(i12);
                }
                this.ch = c16;
            }
        }
        this.isDouble = false;
        if (c10 == '.') {
            this.sp++;
            int i13 = this.bp + 1;
            this.bp = i13;
            if (i13 >= this.len) {
                c14 = 26;
            } else {
                c14 = this.text.charAt(i13);
            }
            this.ch = c14;
            this.isDouble = true;
            while (true) {
                char c18 = this.ch;
                if (c18 < '0' || c18 > '9') {
                    break;
                }
                this.sp++;
                int i14 = this.bp + 1;
                this.bp = i14;
                if (i14 >= this.len) {
                    c15 = 26;
                } else {
                    c15 = this.text.charAt(i14);
                }
                this.ch = c15;
            }
        }
        char c19 = this.ch;
        if (c19 == 'L') {
            this.sp++;
            next();
        } else if (c19 == 'S') {
            this.sp++;
            next();
        } else if (c19 == 'B') {
            this.sp++;
            next();
        } else if (c19 == 'F') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c19 == 'D') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c19 == 'e' || c19 == 'E') {
            this.sp++;
            int i15 = this.bp + 1;
            this.bp = i15;
            if (i15 >= this.len) {
                c11 = 26;
            } else {
                c11 = this.text.charAt(i15);
            }
            this.ch = c11;
            if (c11 == '+' || c11 == '-') {
                this.sp++;
                int i16 = this.bp + 1;
                this.bp = i16;
                if (i16 >= this.len) {
                    c13 = 26;
                } else {
                    c13 = this.text.charAt(i16);
                }
                this.ch = c13;
            }
            while (true) {
                char c20 = this.ch;
                if (c20 >= '0' && c20 <= '9') {
                    this.sp++;
                    int i17 = this.bp + 1;
                    this.bp = i17;
                    if (i17 >= this.len) {
                        c12 = 26;
                    } else {
                        c12 = this.text.charAt(i17);
                    }
                    this.ch = c12;
                } else if (c20 == 'D' || c20 == 'F') {
                    this.sp++;
                    next();
                }
            }
            this.sp++;
            next();
            this.exp = true;
            this.isDouble = true;
        }
        if (this.isDouble) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x020b A[Catch:{ NumberFormatException -> 0x021f }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0225 A[Catch:{ NumberFormatException -> 0x021f }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0230 A[Catch:{ NumberFormatException -> 0x021f }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Number scanNumberValue() {
        /*
            r16 = this;
            r1 = r16
            int r0 = r1.bp
            r2 = 0
            r1.np = r2
            char r3 = r1.ch
            r5 = 1
            r6 = 45
            if (r3 != r6) goto L_0x0027
            r1.np = r5
            int r3 = r0 + 1
            r1.bp = r3
            int r7 = r1.len
            if (r3 < r7) goto L_0x001b
            r3 = 26
            goto L_0x0021
        L_0x001b:
            java.lang.String r7 = r1.text
            char r3 = r7.charAt(r3)
        L_0x0021:
            r1.ch = r3
            r7 = -9223372036854775808
            r3 = r5
            goto L_0x002d
        L_0x0027:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3 = r2
        L_0x002d:
            r9 = 0
            r11 = r2
        L_0x0030:
            char r12 = r1.ch
            r13 = 57
            r14 = 48
            if (r12 < r14) goto L_0x006c
            if (r12 > r13) goto L_0x006c
            int r12 = r12 + -48
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r13 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r13 >= 0) goto L_0x0046
            r11 = r5
        L_0x0046:
            r13 = 10
            long r9 = r9 * r13
            long r12 = (long) r12
            long r14 = r7 + r12
            int r14 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x0051
            r11 = r5
        L_0x0051:
            long r9 = r9 - r12
            int r12 = r1.np
            int r12 = r12 + r5
            r1.np = r12
            int r12 = r1.bp
            int r12 = r12 + r5
            r1.bp = r12
            int r13 = r1.len
            if (r12 < r13) goto L_0x0063
            r12 = 26
            goto L_0x0069
        L_0x0063:
            java.lang.String r13 = r1.text
            char r12 = r13.charAt(r12)
        L_0x0069:
            r1.ch = r12
            goto L_0x0030
        L_0x006c:
            if (r3 != 0) goto L_0x006f
            long r9 = -r9
        L_0x006f:
            r7 = 76
            r8 = 68
            r15 = 70
            if (r12 != r7) goto L_0x0086
            int r7 = r1.np
            int r7 = r7 + r5
            r1.np = r7
            r16.next()
            java.lang.Long r7 = java.lang.Long.valueOf(r9)
        L_0x0083:
            r12 = r3
            r2 = r7
            goto L_0x00cf
        L_0x0086:
            r7 = 83
            if (r12 != r7) goto L_0x0099
            int r7 = r1.np
            int r7 = r7 + r5
            r1.np = r7
            r16.next()
            int r7 = (int) r9
            short r7 = (short) r7
            java.lang.Short r7 = java.lang.Short.valueOf(r7)
            goto L_0x0083
        L_0x0099:
            r7 = 66
            if (r12 != r7) goto L_0x00ac
            int r7 = r1.np
            int r7 = r7 + r5
            r1.np = r7
            r16.next()
            int r7 = (int) r9
            byte r7 = (byte) r7
            java.lang.Byte r7 = java.lang.Byte.valueOf(r7)
            goto L_0x0083
        L_0x00ac:
            if (r12 != r15) goto L_0x00bc
            int r7 = r1.np
            int r7 = r7 + r5
            r1.np = r7
            r16.next()
            float r7 = (float) r9
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            goto L_0x0083
        L_0x00bc:
            if (r12 != r8) goto L_0x00cd
            int r7 = r1.np
            int r7 = r7 + r5
            r1.np = r7
            r16.next()
            r12 = r3
            double r2 = (double) r9
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            goto L_0x00cf
        L_0x00cd:
            r12 = r3
            r2 = 0
        L_0x00cf:
            char r3 = r1.ch
            r4 = 46
            if (r3 != r4) goto L_0x0110
            int r3 = r1.np
            int r3 = r3 + r5
            r1.np = r3
            int r3 = r1.bp
            int r3 = r3 + r5
            r1.bp = r3
            int r7 = r1.len
            if (r3 < r7) goto L_0x00e6
            r3 = 26
            goto L_0x00ec
        L_0x00e6:
            java.lang.String r7 = r1.text
            char r3 = r7.charAt(r3)
        L_0x00ec:
            r1.ch = r3
        L_0x00ee:
            char r3 = r1.ch
            if (r3 < r14) goto L_0x010e
            if (r3 > r13) goto L_0x010e
            int r3 = r1.np
            int r3 = r3 + r5
            r1.np = r3
            int r3 = r1.bp
            int r3 = r3 + r5
            r1.bp = r3
            int r7 = r1.len
            if (r3 < r7) goto L_0x0105
            r3 = 26
            goto L_0x010b
        L_0x0105:
            java.lang.String r7 = r1.text
            char r3 = r7.charAt(r3)
        L_0x010b:
            r1.ch = r3
            goto L_0x00ee
        L_0x010e:
            r7 = r5
            goto L_0x0111
        L_0x0110:
            r7 = 0
        L_0x0111:
            char r3 = r1.ch
            r4 = 101(0x65, float:1.42E-43)
            r15 = 43
            if (r3 == r4) goto L_0x0122
            r4 = 69
            if (r3 != r4) goto L_0x011e
            goto L_0x0122
        L_0x011e:
            r3 = 0
            r4 = 0
            goto L_0x018a
        L_0x0122:
            int r3 = r1.np
            int r3 = r3 + r5
            r1.np = r3
            int r3 = r1.bp
            int r3 = r3 + r5
            r1.bp = r3
            int r4 = r1.len
            if (r3 < r4) goto L_0x0133
            r3 = 26
            goto L_0x0139
        L_0x0133:
            java.lang.String r4 = r1.text
            char r3 = r4.charAt(r3)
        L_0x0139:
            r1.ch = r3
            if (r3 == r15) goto L_0x013f
            if (r3 != r6) goto L_0x0158
        L_0x013f:
            int r3 = r1.np
            int r3 = r3 + r5
            r1.np = r3
            int r3 = r1.bp
            int r3 = r3 + r5
            r1.bp = r3
            int r4 = r1.len
            if (r3 < r4) goto L_0x0150
            r3 = 26
            goto L_0x0156
        L_0x0150:
            java.lang.String r4 = r1.text
            char r3 = r4.charAt(r3)
        L_0x0156:
            r1.ch = r3
        L_0x0158:
            char r3 = r1.ch
            if (r3 < r14) goto L_0x0178
            if (r3 > r13) goto L_0x0178
            int r3 = r1.np
            int r3 = r3 + r5
            r1.np = r3
            int r3 = r1.bp
            int r3 = r3 + r5
            r1.bp = r3
            int r4 = r1.len
            if (r3 < r4) goto L_0x016f
            r3 = 26
            goto L_0x0175
        L_0x016f:
            java.lang.String r4 = r1.text
            char r3 = r4.charAt(r3)
        L_0x0175:
            r1.ch = r3
            goto L_0x0158
        L_0x0178:
            if (r3 == r8) goto L_0x0181
            r4 = 70
            if (r3 != r4) goto L_0x017f
            goto L_0x0181
        L_0x017f:
            r3 = 0
            goto L_0x0189
        L_0x0181:
            int r4 = r1.np
            int r4 = r4 + r5
            r1.np = r4
            r16.next()
        L_0x0189:
            r4 = r5
        L_0x018a:
            if (r7 != 0) goto L_0x01c1
            if (r4 != 0) goto L_0x01c1
            if (r11 == 0) goto L_0x01a6
            int r2 = r1.bp
            int r3 = r2 - r0
            char[] r3 = new char[r3]
            java.lang.String r4 = r1.text
            r5 = 0
            r4.getChars(r0, r2, r3, r5)
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            java.math.BigInteger r2 = new java.math.BigInteger
            r2.<init>(r0)
        L_0x01a6:
            if (r2 != 0) goto L_0x01c0
            r2 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x01bc
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x01bc
            int r0 = (int) r9
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            goto L_0x01c0
        L_0x01bc:
            java.lang.Long r2 = java.lang.Long.valueOf(r9)
        L_0x01c0:
            return r2
        L_0x01c1:
            int r2 = r1.bp
            int r2 = r2 - r0
            if (r3 == 0) goto L_0x01c8
            int r2 = r2 + -1
        L_0x01c8:
            char[] r8 = r1.sbuf
            int r9 = r8.length
            if (r2 >= r9) goto L_0x01d8
            java.lang.String r9 = r1.text
            int r10 = r0 + r2
            r7 = 0
            r9.getChars(r0, r10, r8, r7)
            char[] r0 = r1.sbuf
            goto L_0x01e3
        L_0x01d8:
            r7 = 0
            char[] r8 = new char[r2]
            java.lang.String r9 = r1.text
            int r10 = r0 + r2
            r9.getChars(r0, r10, r8, r7)
            r0 = r8
        L_0x01e3:
            if (r4 != 0) goto L_0x01f5
            int r8 = r1.features
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.UseBigDecimal
            int r9 = r9.mask
            r8 = r8 & r9
            if (r8 == 0) goto L_0x01f5
            java.math.BigDecimal r3 = new java.math.BigDecimal
            r3.<init>(r0, r7, r2)
            goto L_0x0254
        L_0x01f5:
            r8 = 9
            if (r2 > r8) goto L_0x023b
            if (r4 != 0) goto L_0x023b
            char r4 = r0[r7]     // Catch:{ NumberFormatException -> 0x021f }
            if (r4 == r6) goto L_0x0204
            if (r4 != r15) goto L_0x0202
            goto L_0x0204
        L_0x0202:
            r6 = r5
            goto L_0x0207
        L_0x0204:
            char r4 = r0[r5]     // Catch:{ NumberFormatException -> 0x021f }
            r6 = 2
        L_0x0207:
            int r4 = r4 - r14
            r7 = 0
        L_0x0209:
            if (r6 >= r2) goto L_0x0221
            char r8 = r0[r6]     // Catch:{ NumberFormatException -> 0x021f }
            r9 = 46
            if (r8 != r9) goto L_0x0213
            r7 = r5
            goto L_0x021c
        L_0x0213:
            int r8 = r8 + -48
            int r4 = r4 * 10
            int r4 = r4 + r8
            if (r7 == 0) goto L_0x021c
            int r7 = r7 * 10
        L_0x021c:
            int r6 = r6 + 1
            goto L_0x0209
        L_0x021f:
            r0 = move-exception
            goto L_0x0255
        L_0x0221:
            r0 = 70
            if (r3 != r0) goto L_0x0230
            float r0 = (float) r4     // Catch:{ NumberFormatException -> 0x021f }
            float r2 = (float) r7     // Catch:{ NumberFormatException -> 0x021f }
            float r0 = r0 / r2
            if (r12 == 0) goto L_0x022b
            float r0 = -r0
        L_0x022b:
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ NumberFormatException -> 0x021f }
            return r0
        L_0x0230:
            double r2 = (double) r4     // Catch:{ NumberFormatException -> 0x021f }
            double r4 = (double) r7     // Catch:{ NumberFormatException -> 0x021f }
            double r2 = r2 / r4
            if (r12 == 0) goto L_0x0236
            double r2 = -r2
        L_0x0236:
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x021f }
            return r0
        L_0x023b:
            java.lang.String r4 = new java.lang.String     // Catch:{ NumberFormatException -> 0x021f }
            r5 = 0
            r4.<init>(r0, r5, r2)     // Catch:{ NumberFormatException -> 0x021f }
            r0 = 70
            if (r3 != r0) goto L_0x024b
            java.lang.Float r0 = java.lang.Float.valueOf(r4)     // Catch:{ NumberFormatException -> 0x021f }
        L_0x0249:
            r3 = r0
            goto L_0x0254
        L_0x024b:
            double r2 = java.lang.Double.parseDouble(r4)     // Catch:{ NumberFormatException -> 0x021f }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x021f }
            goto L_0x0249
        L_0x0254:
            return r3
        L_0x0255:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.getMessage()
            r3.append(r4)
            java.lang.String r4 = ", "
            r3.append(r4)
            java.lang.String r4 = r16.info()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanNumberValue():java.lang.Number");
    }

    public final void scanString() {
        char c10;
        char c11 = this.ch;
        int i10 = this.bp + 1;
        int indexOf = this.text.indexOf(c11, i10);
        if (indexOf != -1) {
            int i11 = indexOf - i10;
            char[] sub_chars = sub_chars(this.bp + 1, i11);
            boolean z10 = false;
            while (i11 > 0 && sub_chars[i11 - 1] == '\\') {
                int i12 = i11 - 2;
                int i13 = 1;
                while (i12 >= 0 && sub_chars[i12] == '\\') {
                    i13++;
                    i12--;
                }
                if (i13 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c11, indexOf + 1);
                int i14 = (indexOf2 - indexOf) + i11;
                if (i14 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i14) {
                        length = i14;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i11);
                indexOf = indexOf2;
                i11 = i14;
                z10 = true;
            }
            if (!z10) {
                for (int i15 = 0; i15 < i11; i15++) {
                    if (sub_chars[i15] == '\\') {
                        z10 = true;
                    }
                }
            }
            this.sbuf = sub_chars;
            this.sp = i11;
            this.np = this.bp;
            this.hasSpecial = z10;
            int i16 = indexOf + 1;
            this.bp = i16;
            if (i16 >= this.len) {
                c10 = EOI;
            } else {
                c10 = this.text.charAt(i16);
            }
            this.ch = c10;
            this.token = 4;
            return;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public String scanStringValue(char c10) {
        String str;
        char c11;
        int i10 = this.bp + 1;
        int indexOf = this.text.indexOf(c10, i10);
        if (indexOf != -1) {
            if (V6) {
                str = this.text.substring(i10, indexOf);
            } else {
                int i11 = indexOf - i10;
                str = new String(sub_chars(this.bp + 1, i11), 0, i11);
            }
            if (str.indexOf(92) != -1) {
                while (true) {
                    int i12 = indexOf - 1;
                    int i13 = 0;
                    while (i12 >= 0 && this.text.charAt(i12) == '\\') {
                        i13++;
                        i12--;
                    }
                    if (i13 % 2 == 0) {
                        break;
                    }
                    indexOf = this.text.indexOf(c10, indexOf + 1);
                }
                int i14 = indexOf - i10;
                str = readString(sub_chars(this.bp + 1, i14), i14);
            }
            int i15 = indexOf + 1;
            this.bp = i15;
            if (i15 >= this.len) {
                c11 = EOI;
            } else {
                c11 = this.text.charAt(i15);
            }
            this.ch = c11;
            return str;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c10;
        while (true) {
            c10 = this.ch;
            if (c10 != ' ' && c10 != 10 && c10 != 13 && c10 != 9 && c10 != 12 && c10 != 8) {
                break;
            }
            next();
        }
        if (c10 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c10 == '\'') {
            return scanSymbol(symbolTable, '\'');
        }
        if (c10 == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c10 == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c10 != 26) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            this.token = 20;
            return null;
        }
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i10 = this.ch;
        boolean[] zArr = firstIdentifierFlags;
        if (i10 >= zArr.length || zArr[i10]) {
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                boolean[] zArr2 = identifierFlags;
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i10 = (i10 * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp != 4 || !this.text.startsWith("null", this.np)) {
                return symbolTable.addSymbol(this.text, this.np, this.sp, i10);
            }
            return null;
        }
        throw new JSONException("illegal identifier : " + this.ch + ", " + info());
    }

    /* access modifiers changed from: protected */
    public void setTime(char c10, char c11, char c12, char c13, char c14, char c15) {
        this.calendar.set(11, ((c10 - '0') * 10) + (c11 - '0'));
        this.calendar.set(12, ((c12 - '0') * 10) + (c13 - '0'));
        this.calendar.set(13, ((c14 - '0') * 10) + (c15 - '0'));
    }

    /* access modifiers changed from: protected */
    public void setTimeZone(char c10, char c11, char c12) {
        int i10 = (((c11 - '0') * 10) + (c12 - '0')) * Constants.ONE_HOUR;
        if (c10 == '-') {
            i10 = -i10;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i10) {
            String[] availableIDs = TimeZone.getAvailableIDs(i10);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void skipComment() {
        next();
        char c10 = this.ch;
        if (c10 == '/') {
            do {
                next();
            } while (this.ch != 10);
            next();
        } else if (c10 == '*') {
            next();
            while (true) {
                char c11 = this.ch;
                if (c11 == 26) {
                    return;
                }
                if (c11 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    /* access modifiers changed from: package-private */
    public final void skipWhitespace() {
        while (true) {
            char c10 = this.ch;
            if (c10 > '/') {
                return;
            }
            if (c10 == ' ' || c10 == 13 || c10 == 10 || c10 == 9 || c10 == 12 || c10 == 8) {
                next();
            } else if (c10 == '/') {
                skipComment();
            } else {
                return;
            }
        }
    }

    public final String stringVal() {
        if (this.hasSpecial) {
            return readString(this.sbuf, this.sp);
        }
        return subString(this.np + 1, this.sp);
    }

    /* access modifiers changed from: package-private */
    public final char[] sub_chars(int i10, int i11) {
        char[] cArr = this.sbuf;
        if (i11 < cArr.length) {
            this.text.getChars(i10, i11 + i10, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i11];
        this.sbuf = cArr2;
        this.text.getChars(i10, i11 + i10, cArr2, 0);
        return cArr2;
    }

    public final int token() {
        return this.token;
    }

    public JSONLexer(char[] cArr, int i10) {
        this(cArr, i10, JSON.DEFAULT_PARSER_FEATURE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: int} */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0207 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scanISO8601DateIfMatch(boolean r37, int r38) {
        /*
            r36 = this;
            r9 = r36
            r10 = r38
            r0 = 47
            r11 = 13
            r12 = 57
            r13 = 6
            r14 = 3
            r15 = 2
            r8 = 5
            r16 = 1
            r7 = 48
            r6 = 0
            if (r37 != 0) goto L_0x00a9
            if (r10 <= r11) goto L_0x00a9
            int r1 = r9.bp
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            int r2 = r2 + 1
            char r2 = r9.charAt(r2)
            int r3 = r9.bp
            int r3 = r3 + r15
            char r3 = r9.charAt(r3)
            int r4 = r9.bp
            int r4 = r4 + r14
            char r4 = r9.charAt(r4)
            int r5 = r9.bp
            int r5 = r5 + 4
            char r5 = r9.charAt(r5)
            int r11 = r9.bp
            int r11 = r11 + r8
            char r11 = r9.charAt(r11)
            int r14 = r9.bp
            int r14 = r14 + r10
            int r14 = r14 + -1
            char r14 = r9.charAt(r14)
            int r8 = r9.bp
            int r8 = r8 + r10
            int r8 = r8 - r15
            char r8 = r9.charAt(r8)
            if (r1 != r0) goto L_0x00a9
            r1 = 68
            if (r2 != r1) goto L_0x00a9
            r1 = 97
            if (r3 != r1) goto L_0x00a9
            r1 = 116(0x74, float:1.63E-43)
            if (r4 != r1) goto L_0x00a9
            r1 = 101(0x65, float:1.42E-43)
            if (r5 != r1) goto L_0x00a9
            r1 = 40
            if (r11 != r1) goto L_0x00a9
            if (r14 != r0) goto L_0x00a9
            r1 = 41
            if (r8 != r1) goto L_0x00a9
            r0 = -1
            r1 = r13
        L_0x0071:
            if (r1 >= r10) goto L_0x0088
            int r2 = r9.bp
            int r2 = r2 + r1
            char r2 = r9.charAt(r2)
            r3 = 43
            if (r2 != r3) goto L_0x0080
            r0 = r1
            goto L_0x0085
        L_0x0080:
            if (r2 < r7) goto L_0x0088
            if (r2 <= r12) goto L_0x0085
            goto L_0x0088
        L_0x0085:
            int r1 = r1 + 1
            goto L_0x0071
        L_0x0088:
            r1 = -1
            if (r0 != r1) goto L_0x008c
            return r6
        L_0x008c:
            int r1 = r9.bp
            int r1 = r1 + r13
            int r0 = r0 - r1
            java.lang.String r0 = r9.subString(r1, r0)
            long r0 = java.lang.Long.parseLong(r0)
            java.util.TimeZone r2 = r9.timeZone
            java.util.Locale r3 = r9.locale
            java.util.Calendar r2 = java.util.Calendar.getInstance(r2, r3)
            r9.calendar = r2
            r2.setTimeInMillis(r0)
            r0 = 5
            r9.token = r0
            return r16
        L_0x00a9:
            r11 = 84
            r14 = 16
            r4 = 8
            r3 = 9
            r2 = 14
            r1 = 45
            r20 = 10
            if (r10 == r4) goto L_0x04b7
            if (r10 == r2) goto L_0x04b7
            if (r10 != r14) goto L_0x00d7
            int r2 = r9.bp
            int r2 = r2 + 10
            char r2 = r9.charAt(r2)
            if (r2 == r11) goto L_0x00cc
            r5 = 32
            if (r2 == r5) goto L_0x00cc
            goto L_0x00d7
        L_0x00cc:
            r8 = r1
            r21 = r3
            r15 = r4
            r12 = r6
            r13 = r14
            r11 = 5
            r14 = 14
            goto L_0x04bf
        L_0x00d7:
            r2 = 17
            if (r10 != r2) goto L_0x00e5
            int r2 = r9.bp
            int r2 = r2 + r13
            char r2 = r9.charAt(r2)
            if (r2 == r1) goto L_0x00e5
            goto L_0x00cc
        L_0x00e5:
            if (r10 >= r3) goto L_0x00e8
            return r6
        L_0x00e8:
            int r2 = r9.bp
            char r2 = r9.charAt(r2)
            int r5 = r9.bp
            int r5 = r5 + 1
            char r5 = r9.charAt(r5)
            int r14 = r9.bp
            int r14 = r14 + r15
            char r14 = r9.charAt(r14)
            int r7 = r9.bp
            r18 = 3
            int r7 = r7 + 3
            char r7 = r9.charAt(r7)
            int r8 = r9.bp
            int r8 = r8 + 4
            char r8 = r9.charAt(r8)
            int r12 = r9.bp
            r19 = 5
            int r12 = r12 + 5
            char r12 = r9.charAt(r12)
            int r15 = r9.bp
            int r15 = r15 + r13
            char r15 = r9.charAt(r15)
            int r13 = r9.bp
            int r13 = r13 + 7
            char r13 = r9.charAt(r13)
            int r11 = r9.bp
            int r11 = r11 + r4
            char r11 = r9.charAt(r11)
            int r4 = r9.bp
            int r4 = r4 + r3
            char r4 = r9.charAt(r4)
            r6 = 26085(0x65e5, float:3.6553E-41)
            if (r8 != r1) goto L_0x013c
            if (r13 == r1) goto L_0x0140
        L_0x013c:
            if (r8 != r0) goto L_0x014d
            if (r13 != r0) goto L_0x014d
        L_0x0140:
            r13 = r20
            r8 = 51068(0xc77c, float:7.1562E-41)
        L_0x0145:
            r35 = r11
            r11 = r4
            r4 = r7
            r7 = r35
            goto L_0x01f1
        L_0x014d:
            if (r8 != r1) goto L_0x016e
            if (r15 != r1) goto L_0x016e
            r0 = 32
            if (r11 != r0) goto L_0x0163
            r4 = r7
            r15 = r12
            r11 = r13
            r7 = 48
            r8 = 51068(0xc77c, float:7.1562E-41)
            r12 = 48
            r13 = 8
            goto L_0x01f1
        L_0x0163:
            r4 = r7
            r15 = r12
            r7 = r13
            r8 = 51068(0xc77c, float:7.1562E-41)
            r12 = 48
            r13 = r3
            goto L_0x01f1
        L_0x016e:
            r0 = 46
            if (r14 != r0) goto L_0x0176
            r0 = 46
            if (r12 == r0) goto L_0x017a
        L_0x0176:
            if (r14 != r1) goto L_0x0188
            if (r12 != r1) goto L_0x0188
        L_0x017a:
            r12 = r7
            r14 = r11
            r7 = r2
            r11 = r5
            r5 = r13
            r2 = r15
            r13 = r20
            r15 = r8
            r8 = 51068(0xc77c, float:7.1562E-41)
            goto L_0x01f1
        L_0x0188:
            r0 = 24180(0x5e74, float:3.3883E-41)
            if (r8 == r0) goto L_0x0194
            r0 = 45380(0xb144, float:6.3591E-41)
            if (r8 != r0) goto L_0x0192
            goto L_0x0194
        L_0x0192:
            r0 = 0
            return r0
        L_0x0194:
            r0 = 26376(0x6708, float:3.696E-41)
            if (r13 == r0) goto L_0x019d
            r0 = 50900(0xc6d4, float:7.1326E-41)
            if (r13 != r0) goto L_0x01a1
        L_0x019d:
            r8 = 51068(0xc77c, float:7.1562E-41)
            goto L_0x01cc
        L_0x01a1:
            r0 = 26376(0x6708, float:3.696E-41)
            if (r15 == r0) goto L_0x01aa
            r0 = 50900(0xc6d4, float:7.1326E-41)
            if (r15 != r0) goto L_0x01ac
        L_0x01aa:
            r0 = 0
            goto L_0x01ae
        L_0x01ac:
            r0 = 0
            return r0
        L_0x01ae:
            r8 = 51068(0xc77c, float:7.1562E-41)
            if (r11 == r6) goto L_0x01c4
            if (r11 != r8) goto L_0x01b6
            goto L_0x01c4
        L_0x01b6:
            if (r4 == r6) goto L_0x01bc
            if (r4 != r8) goto L_0x01bb
            goto L_0x01bc
        L_0x01bb:
            return r0
        L_0x01bc:
            r4 = r7
            r15 = r12
            r7 = r13
            r13 = r20
        L_0x01c1:
            r12 = 48
            goto L_0x01f1
        L_0x01c4:
            r4 = r7
            r15 = r12
            r11 = r13
            r13 = r20
            r7 = 48
            goto L_0x01c1
        L_0x01cc:
            if (r4 == r6) goto L_0x01ec
            if (r4 != r8) goto L_0x01d1
            goto L_0x01ec
        L_0x01d1:
            int r0 = r9.bp
            int r0 = r0 + 10
            char r0 = r9.charAt(r0)
            if (r0 == r6) goto L_0x01e8
            int r0 = r9.bp
            int r0 = r0 + 10
            char r0 = r9.charAt(r0)
            if (r0 != r8) goto L_0x01e6
            goto L_0x01e8
        L_0x01e6:
            r0 = 0
            return r0
        L_0x01e8:
            r13 = 11
            goto L_0x0145
        L_0x01ec:
            r4 = r7
            r13 = r20
            r7 = 48
        L_0x01f1:
            r27 = r2
            r28 = r5
            r29 = r14
            r30 = r4
            r31 = r12
            r32 = r15
            r33 = r7
            r34 = r11
            boolean r0 = checkDate(r27, r28, r29, r30, r31, r32, r33, r34)
            if (r0 != 0) goto L_0x020a
            r26 = 0
            return r26
        L_0x020a:
            r26 = 0
            r0 = r36
            r10 = r1
            r1 = r2
            r2 = r5
            r21 = r3
            r3 = r14
            r14 = 8
            r14 = 11
            r5 = r12
            r14 = r6
            r12 = r26
            r6 = r15
            r15 = 48
            r15 = r8
            r8 = r11
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            int r0 = r9.bp
            int r0 = r0 + r13
            char r7 = r9.charAt(r0)
            r0 = 84
            if (r7 == r0) goto L_0x0235
            r0 = 32
            if (r7 != r0) goto L_0x023a
            if (r37 != 0) goto L_0x023a
        L_0x0235:
            r11 = 5
            r14 = 14
            goto L_0x02d5
        L_0x023a:
            r0 = 34
            if (r7 == r0) goto L_0x0246
            r0 = 26
            if (r7 == r0) goto L_0x0246
            if (r7 == r14) goto L_0x0246
            if (r7 != r15) goto L_0x024a
        L_0x0246:
            r11 = 5
            r14 = 14
            goto L_0x02ad
        L_0x024a:
            r0 = 43
            if (r7 == r0) goto L_0x0252
            if (r7 != r10) goto L_0x0251
            goto L_0x0252
        L_0x0251:
            return r12
        L_0x0252:
            int r0 = r9.len
            int r1 = r13 + 6
            if (r0 != r1) goto L_0x02ac
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 3
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            r1 = 58
            if (r0 != r1) goto L_0x02ac
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            r1 = 48
            if (r0 != r1) goto L_0x02ac
            int r0 = r9.bp
            int r0 = r0 + r13
            r11 = 5
            int r0 = r0 + r11
            char r0 = r9.charAt(r0)
            if (r0 == r1) goto L_0x027e
            goto L_0x02ac
        L_0x027e:
            r5 = 48
            r6 = 48
            r1 = 48
            r2 = 48
            r3 = 48
            r4 = 48
            r0 = r36
            r0.setTime(r1, r2, r3, r4, r5, r6)
            java.util.Calendar r0 = r9.calendar
            r14 = 14
            r0.set(r14, r12)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 1
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            int r1 = r1 + r13
            r2 = 2
            int r1 = r1 + r2
            char r1 = r9.charAt(r1)
            r9.setTimeZone(r7, r0, r1)
            return r16
        L_0x02ac:
            return r12
        L_0x02ad:
            java.util.Calendar r0 = r9.calendar
            r1 = 11
            r0.set(r1, r12)
            java.util.Calendar r0 = r9.calendar
            r1 = 12
            r0.set(r1, r12)
            java.util.Calendar r0 = r9.calendar
            r1 = 13
            r0.set(r1, r12)
            java.util.Calendar r0 = r9.calendar
            r0.set(r14, r12)
            int r0 = r9.bp
            int r0 = r0 + r13
            r9.bp = r0
            char r0 = r9.charAt(r0)
            r9.ch = r0
            r9.token = r11
            return r16
        L_0x02d5:
            int r7 = r13 + 9
            r8 = r10
            r10 = r38
            if (r10 >= r7) goto L_0x02dd
            return r12
        L_0x02dd:
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 3
            int r0 = r0 + r1
            char r0 = r9.charAt(r0)
            r1 = 58
            if (r0 == r1) goto L_0x02eb
            return r12
        L_0x02eb:
            int r0 = r9.bp
            int r0 = r0 + r13
            r2 = 6
            int r0 = r0 + r2
            char r0 = r9.charAt(r0)
            if (r0 == r1) goto L_0x02f7
            return r12
        L_0x02f7:
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 1
            char r15 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 2
            int r0 = r0 + r1
            char r17 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 4
            char r19 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + r11
            char r24 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 7
            char r26 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r13
            r1 = 8
            int r0 = r0 + r1
            char r25 = r9.charAt(r0)
            r1 = r15
            r2 = r17
            r3 = r19
            r4 = r24
            r5 = r26
            r6 = r25
            boolean r0 = checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x033f
            return r12
        L_0x033f:
            r0 = r36
            r1 = r15
            r2 = r17
            r3 = r19
            r4 = r24
            r5 = r26
            r6 = r25
            r0.setTime(r1, r2, r3, r4, r5, r6)
            int r0 = r9.bp
            int r0 = r0 + r13
            int r0 = r0 + 9
            char r0 = r9.charAt(r0)
            r1 = 46
            if (r0 != r1) goto L_0x0482
            int r0 = r13 + 11
            if (r10 >= r0) goto L_0x0361
            return r12
        L_0x0361:
            int r1 = r9.bp
            int r1 = r1 + r13
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            r2 = 48
            if (r1 < r2) goto L_0x0481
            r3 = 57
            if (r1 <= r3) goto L_0x0374
            goto L_0x0481
        L_0x0374:
            int r1 = r1 - r2
            if (r10 <= r0) goto L_0x038c
            int r0 = r9.bp
            int r0 = r0 + r13
            r4 = 11
            int r0 = r0 + r4
            char r0 = r9.charAt(r0)
            if (r0 < r2) goto L_0x038c
            if (r0 > r3) goto L_0x038c
            int r1 = r1 * 10
            int r0 = r0 - r2
            int r1 = r1 + r0
            r0 = 2
        L_0x038a:
            r2 = 2
            goto L_0x038f
        L_0x038c:
            r0 = r16
            goto L_0x038a
        L_0x038f:
            if (r0 != r2) goto L_0x03a7
            int r2 = r9.bp
            int r2 = r2 + r13
            int r2 = r2 + 12
            char r2 = r9.charAt(r2)
            r3 = 48
            if (r2 < r3) goto L_0x03a7
            r4 = 57
            if (r2 > r4) goto L_0x03a7
            int r1 = r1 * 10
            int r2 = r2 - r3
            int r1 = r1 + r2
            r0 = 3
        L_0x03a7:
            java.util.Calendar r2 = r9.calendar
            r2.set(r14, r1)
            int r1 = r9.bp
            int r1 = r1 + r13
            int r1 = r1 + 10
            int r1 = r1 + r0
            char r1 = r9.charAt(r1)
            r2 = 43
            if (r1 == r2) goto L_0x03e6
            if (r1 != r8) goto L_0x03bd
            goto L_0x03e6
        L_0x03bd:
            r2 = 90
            if (r1 != r2) goto L_0x03e3
            java.util.Calendar r1 = r9.calendar
            java.util.TimeZone r1 = r1.getTimeZone()
            int r1 = r1.getRawOffset()
            if (r1 == 0) goto L_0x03df
            java.lang.String[] r1 = java.util.TimeZone.getAvailableIDs(r12)
            int r2 = r1.length
            if (r2 <= 0) goto L_0x03df
            r1 = r1[r12]
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            java.util.Calendar r2 = r9.calendar
            r2.setTimeZone(r1)
        L_0x03df:
            r6 = r16
            goto L_0x045f
        L_0x03e3:
            r6 = r12
            goto L_0x045f
        L_0x03e6:
            int r2 = r9.bp
            int r2 = r2 + r13
            int r2 = r2 + 10
            int r2 = r2 + r0
            int r2 = r2 + 1
            char r2 = r9.charAt(r2)
            r3 = 48
            if (r2 < r3) goto L_0x0481
            r4 = 49
            if (r2 <= r4) goto L_0x03fc
            goto L_0x0481
        L_0x03fc:
            int r4 = r9.bp
            int r4 = r4 + r13
            int r4 = r4 + 10
            int r4 = r4 + r0
            r5 = 2
            int r4 = r4 + r5
            char r4 = r9.charAt(r4)
            if (r4 < r3) goto L_0x0481
            r3 = 57
            if (r4 <= r3) goto L_0x0410
            goto L_0x0481
        L_0x0410:
            int r3 = r9.bp
            int r3 = r3 + r13
            int r3 = r3 + 10
            int r3 = r3 + r0
            r5 = 3
            int r3 = r3 + r5
            char r3 = r9.charAt(r3)
            r5 = 58
            if (r3 != r5) goto L_0x0442
            int r3 = r9.bp
            int r3 = r3 + r13
            int r3 = r3 + 10
            int r3 = r3 + r0
            int r3 = r3 + 4
            char r3 = r9.charAt(r3)
            r5 = 48
            if (r3 == r5) goto L_0x0431
            return r12
        L_0x0431:
            int r3 = r9.bp
            int r3 = r3 + r13
            int r3 = r3 + 10
            int r3 = r3 + r0
            int r3 = r3 + r11
            char r3 = r9.charAt(r3)
            if (r3 == r5) goto L_0x043f
            return r12
        L_0x043f:
            r18 = 6
            goto L_0x045a
        L_0x0442:
            r5 = 48
            if (r3 != r5) goto L_0x0458
            int r3 = r9.bp
            int r3 = r3 + r13
            int r3 = r3 + 10
            int r3 = r3 + r0
            int r3 = r3 + 4
            char r3 = r9.charAt(r3)
            if (r3 == r5) goto L_0x0455
            return r12
        L_0x0455:
            r18 = r11
            goto L_0x045a
        L_0x0458:
            r18 = 3
        L_0x045a:
            r9.setTimeZone(r1, r2, r4)
            r6 = r18
        L_0x045f:
            int r1 = r9.bp
            int r13 = r13 + 10
            int r13 = r13 + r0
            int r13 = r13 + r6
            int r1 = r1 + r13
            char r0 = r9.charAt(r1)
            r1 = 26
            if (r0 == r1) goto L_0x0473
            r1 = 34
            if (r0 == r1) goto L_0x0473
            return r12
        L_0x0473:
            int r0 = r9.bp
            int r0 = r0 + r13
            r9.bp = r0
            char r0 = r9.charAt(r0)
            r9.ch = r0
            r9.token = r11
            return r16
        L_0x0481:
            return r12
        L_0x0482:
            java.util.Calendar r1 = r9.calendar
            r1.set(r14, r12)
            int r1 = r9.bp
            int r1 = r1 + r7
            r9.bp = r1
            char r1 = r9.charAt(r1)
            r9.ch = r1
            r9.token = r11
            r1 = 90
            if (r0 != r1) goto L_0x04b6
            java.util.Calendar r0 = r9.calendar
            java.util.TimeZone r0 = r0.getTimeZone()
            int r0 = r0.getRawOffset()
            if (r0 == 0) goto L_0x04b6
            java.lang.String[] r0 = java.util.TimeZone.getAvailableIDs(r12)
            int r1 = r0.length
            if (r1 <= 0) goto L_0x04b6
            r0 = r0[r12]
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            java.util.Calendar r1 = r9.calendar
            r1.setTimeZone(r0)
        L_0x04b6:
            return r16
        L_0x04b7:
            r8 = r1
            r21 = r3
            r15 = r4
            r12 = r6
            r13 = r14
            r11 = 5
            r14 = r2
        L_0x04bf:
            if (r37 == 0) goto L_0x04c2
            return r12
        L_0x04c2:
            int r0 = r9.bp
            char r1 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + 1
            char r2 = r9.charAt(r0)
            int r0 = r9.bp
            r3 = 2
            int r0 = r0 + r3
            char r3 = r9.charAt(r0)
            int r0 = r9.bp
            r4 = 3
            int r0 = r0 + r4
            char r4 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            int r5 = r9.bp
            int r5 = r5 + r11
            char r5 = r9.charAt(r5)
            int r6 = r9.bp
            r7 = 6
            int r6 = r6 + r7
            char r6 = r9.charAt(r6)
            int r7 = r9.bp
            int r7 = r7 + 7
            char r7 = r9.charAt(r7)
            int r11 = r9.bp
            int r11 = r11 + r15
            char r11 = r9.charAt(r11)
            if (r0 != r8) goto L_0x050d
            if (r7 != r8) goto L_0x050d
            r8 = r16
            goto L_0x050e
        L_0x050d:
            r8 = r12
        L_0x050e:
            if (r8 == 0) goto L_0x0515
            if (r10 != r13) goto L_0x0515
            r18 = r16
            goto L_0x0517
        L_0x0515:
            r18 = r12
        L_0x0517:
            if (r8 == 0) goto L_0x0520
            r8 = 17
            if (r10 != r8) goto L_0x0520
            r19 = r16
            goto L_0x0522
        L_0x0520:
            r19 = r12
        L_0x0522:
            if (r19 != 0) goto L_0x052c
            if (r18 == 0) goto L_0x0527
            goto L_0x052c
        L_0x0527:
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r0
            goto L_0x0536
        L_0x052c:
            int r0 = r9.bp
            int r0 = r0 + 9
            char r0 = r9.charAt(r0)
            r8 = r0
            r7 = r11
        L_0x0536:
            r25 = r1
            r26 = r2
            r27 = r3
            r28 = r4
            r29 = r5
            r30 = r6
            r31 = r7
            r32 = r8
            boolean r0 = checkDate(r25, r26, r27, r28, r29, r30, r31, r32)
            if (r0 != 0) goto L_0x054d
            return r12
        L_0x054d:
            r0 = r36
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r10 == r15) goto L_0x061b
            int r0 = r9.bp
            int r0 = r0 + 9
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            r3 = 11
            int r2 = r2 + r3
            char r2 = r9.charAt(r2)
            int r3 = r9.bp
            int r3 = r3 + 12
            char r7 = r9.charAt(r3)
            int r3 = r9.bp
            r4 = 13
            int r3 = r3 + r4
            char r3 = r9.charAt(r3)
            if (r19 == 0) goto L_0x0593
            r4 = 84
            if (r1 != r4) goto L_0x0593
            r4 = 58
            if (r3 != r4) goto L_0x0593
            int r4 = r9.bp
            int r4 = r4 + r13
            char r4 = r9.charAt(r4)
            r5 = 90
            if (r4 == r5) goto L_0x05a1
        L_0x0593:
            if (r18 == 0) goto L_0x05b7
            r4 = 32
            if (r1 == r4) goto L_0x059d
            r4 = 84
            if (r1 != r4) goto L_0x05b7
        L_0x059d:
            r4 = 58
            if (r3 != r4) goto L_0x05b7
        L_0x05a1:
            int r0 = r9.bp
            int r0 = r0 + r14
            char r1 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + 15
            char r0 = r9.charAt(r0)
            r11 = r2
            r3 = 48
            r2 = r0
            r0 = r7
            r7 = 48
        L_0x05b7:
            r22 = r11
            r23 = r0
            r24 = r1
            r25 = r2
            r26 = r7
            r27 = r3
            boolean r4 = checkTime(r22, r23, r24, r25, r26, r27)
            if (r4 != 0) goto L_0x05ca
            return r12
        L_0x05ca:
            r4 = 17
            if (r10 != r4) goto L_0x0606
            if (r19 != 0) goto L_0x0606
            int r4 = r9.bp
            int r4 = r4 + r14
            char r4 = r9.charAt(r4)
            int r5 = r9.bp
            int r5 = r5 + 15
            char r5 = r9.charAt(r5)
            int r6 = r9.bp
            int r6 = r6 + r13
            char r6 = r9.charAt(r6)
            r8 = 48
            if (r4 < r8) goto L_0x0605
            r10 = 57
            if (r4 <= r10) goto L_0x05ef
            goto L_0x0605
        L_0x05ef:
            if (r5 < r8) goto L_0x0605
            if (r5 <= r10) goto L_0x05f4
            goto L_0x0605
        L_0x05f4:
            if (r6 < r8) goto L_0x0605
            if (r6 <= r10) goto L_0x05f9
            goto L_0x0605
        L_0x05f9:
            int r4 = r4 - r8
            int r4 = r4 * 100
            int r5 = r5 - r8
            int r5 = r5 * 10
            int r4 = r4 + r5
            int r6 = r6 - r8
            int r6 = r6 + r4
        L_0x0602:
            r4 = 48
            goto L_0x0608
        L_0x0605:
            return r12
        L_0x0606:
            r6 = r12
            goto L_0x0602
        L_0x0608:
            int r11 = r11 - r4
            int r11 = r11 * 10
            int r0 = r0 - r4
            int r0 = r0 + r11
            int r1 = r1 - r4
            int r1 = r1 * 10
            int r2 = r2 - r4
            int r1 = r1 + r2
            int r7 = r7 - r4
            int r7 = r7 * 10
            int r3 = r3 - r4
            int r2 = r7 + r3
            r12 = r6
            r6 = r0
            goto L_0x061e
        L_0x061b:
            r1 = r12
            r2 = r1
            r6 = r2
        L_0x061e:
            java.util.Calendar r0 = r9.calendar
            r3 = 11
            r0.set(r3, r6)
            java.util.Calendar r0 = r9.calendar
            r3 = 12
            r0.set(r3, r1)
            java.util.Calendar r0 = r9.calendar
            r1 = 13
            r0.set(r1, r2)
            java.util.Calendar r0 = r9.calendar
            r0.set(r14, r12)
            r0 = 5
            r9.token = r0
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    public JSONLexer(char[] cArr, int i10, int i11) {
        this(new String(cArr, 0, i10), i11);
    }

    public JSONLexer(String str, int i10) {
        char c10;
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        boolean z10 = false;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        String str2 = null;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i10;
        this.text = str;
        int length = str.length();
        this.len = length;
        int i11 = -1 + 1;
        this.bp = i11;
        if (i11 >= length) {
            c10 = EOI;
        } else {
            c10 = str.charAt(i11);
        }
        this.ch = c10;
        if (c10 == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i10) != 0 ? "" : str2;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i10) != 0 ? true : z10;
    }

    public String scanSymbol(SymbolTable symbolTable, char c10) {
        String str;
        char c11;
        int i10 = this.bp + 1;
        int indexOf = this.text.indexOf(c10, i10);
        if (indexOf != -1) {
            int i11 = indexOf - i10;
            char[] sub_chars = sub_chars(this.bp + 1, i11);
            boolean z10 = false;
            while (i11 > 0 && sub_chars[i11 - 1] == '\\') {
                int i12 = i11 - 2;
                int i13 = 1;
                while (i12 >= 0 && sub_chars[i12] == '\\') {
                    i13++;
                    i12--;
                }
                if (i13 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c10, indexOf + 1);
                int i14 = (indexOf2 - indexOf) + i11;
                if (i14 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i14) {
                        length = i14;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i11);
                indexOf = indexOf2;
                i11 = i14;
                z10 = true;
            }
            if (!z10) {
                int i15 = 0;
                for (int i16 = 0; i16 < i11; i16++) {
                    char c12 = sub_chars[i16];
                    i15 = (i15 * 31) + c12;
                    if (c12 == '\\') {
                        z10 = true;
                    }
                }
                if (z10) {
                    str = readString(sub_chars, i11);
                } else {
                    str = i11 < 20 ? symbolTable.addSymbol(sub_chars, 0, i11, i15) : new String(sub_chars, 0, i11);
                }
            } else {
                str = readString(sub_chars, i11);
            }
            int i17 = indexOf + 1;
            this.bp = i17;
            if (i17 >= this.len) {
                c11 = EOI;
            } else {
                c11 = this.text.charAt(i17);
            }
            this.ch = c11;
            return str;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public final BigDecimal decimalValue() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i10 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i10--;
        }
        int i11 = this.np;
        char[] cArr = this.sbuf;
        if (i10 < cArr.length) {
            this.text.getChars(i11, i11 + i10, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i10);
        }
        char[] cArr2 = new char[i10];
        this.text.getChars(i11, i10 + i11, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    public final void nextToken(int i10) {
        this.sp = 0;
        while (true) {
            if (i10 != 2) {
                char c10 = EOI;
                if (i10 == 4) {
                    char c11 = this.ch;
                    if (c11 == '\"') {
                        this.pos = this.bp;
                        scanString();
                        return;
                    } else if (c11 >= '0' && c11 <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                        return;
                    } else if (c11 == '{') {
                        this.token = 12;
                        int i11 = this.bp + 1;
                        this.bp = i11;
                        if (i11 < this.len) {
                            c10 = this.text.charAt(i11);
                        }
                        this.ch = c10;
                        return;
                    }
                } else if (i10 == 12) {
                    char c12 = this.ch;
                    if (c12 == '{') {
                        this.token = 12;
                        int i12 = this.bp + 1;
                        this.bp = i12;
                        if (i12 < this.len) {
                            c10 = this.text.charAt(i12);
                        }
                        this.ch = c10;
                        return;
                    } else if (c12 == '[') {
                        this.token = 14;
                        int i13 = this.bp + 1;
                        this.bp = i13;
                        if (i13 < this.len) {
                            c10 = this.text.charAt(i13);
                        }
                        this.ch = c10;
                        return;
                    }
                } else if (i10 != 18) {
                    if (i10 != 20) {
                        switch (i10) {
                            case 14:
                                char c13 = this.ch;
                                if (c13 == '[') {
                                    this.token = 14;
                                    next();
                                    return;
                                } else if (c13 == '{') {
                                    this.token = 12;
                                    next();
                                    return;
                                }
                                break;
                            case 15:
                                if (this.ch == ']') {
                                    this.token = 15;
                                    next();
                                    return;
                                }
                                break;
                            case 16:
                                char c14 = this.ch;
                                if (c14 == ',') {
                                    this.token = 16;
                                    int i14 = this.bp + 1;
                                    this.bp = i14;
                                    if (i14 < this.len) {
                                        c10 = this.text.charAt(i14);
                                    }
                                    this.ch = c10;
                                    return;
                                } else if (c14 == '}') {
                                    this.token = 13;
                                    int i15 = this.bp + 1;
                                    this.bp = i15;
                                    if (i15 < this.len) {
                                        c10 = this.text.charAt(i15);
                                    }
                                    this.ch = c10;
                                    return;
                                } else if (c14 == ']') {
                                    this.token = 15;
                                    int i16 = this.bp + 1;
                                    this.bp = i16;
                                    if (i16 < this.len) {
                                        c10 = this.text.charAt(i16);
                                    }
                                    this.ch = c10;
                                    return;
                                } else if (c14 == 26) {
                                    this.token = 20;
                                    return;
                                }
                                break;
                        }
                    }
                    if (this.ch == 26) {
                        this.token = 20;
                        return;
                    }
                } else {
                    nextIdent();
                    return;
                }
            } else {
                char c15 = this.ch;
                if (c15 >= '0' && c15 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c15 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c15 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c15 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            }
            char c16 = this.ch;
            if (c16 == ' ' || c16 == 10 || c16 == 13 || c16 == 9 || c16 == 12 || c16 == 8) {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }
}
