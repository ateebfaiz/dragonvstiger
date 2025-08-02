package com.alibaba.fastjson.serializer;

import androidx.room.RoomDatabase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.pdns.x.c;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import okio.Utf8;

public final class SerializeWriter extends Writer {
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final char[] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] DigitTens = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] ascii_chars = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] replaceChars = new char[93];
    static final int[] sizeTable = {9, 99, RoomDatabase.MAX_BIND_PARAMETER_CNT, c.f18290d, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    static final byte[] specicalFlags_doubleQuotes;
    static final byte[] specicalFlags_singleQuotes;
    protected char[] buf;
    protected int count;
    protected int features;
    protected final Writer writer;

    static {
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i10 = 14; i10 <= 31; i10++) {
            specicalFlags_doubleQuotes[i10] = 4;
            specicalFlags_singleQuotes[i10] = 4;
        }
        for (int i11 = 127; i11 < 160; i11++) {
            specicalFlags_doubleQuotes[i11] = 4;
            specicalFlags_singleQuotes[i11] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    protected static void getChars(long j10, int i10, char[] cArr) {
        char c10;
        if (j10 < 0) {
            j10 = -j10;
            c10 = '-';
        } else {
            c10 = 0;
        }
        while (j10 > 2147483647L) {
            long j11 = j10 / 100;
            int i11 = (int) (j10 - (((j11 << 6) + (j11 << 5)) + (j11 << 2)));
            cArr[i10 - 1] = DigitOnes[i11];
            i10 -= 2;
            cArr[i10] = DigitTens[i11];
            j10 = j11;
        }
        int i12 = (int) j10;
        while (i12 >= 65536) {
            int i13 = i12 / 100;
            int i14 = i12 - (((i13 << 6) + (i13 << 5)) + (i13 << 2));
            cArr[i10 - 1] = DigitOnes[i14];
            i10 -= 2;
            cArr[i10] = DigitTens[i14];
            i12 = i13;
        }
        while (true) {
            int i15 = (52429 * i12) >>> 19;
            int i16 = i10 - 1;
            cArr[i16] = digits[i12 - ((i15 << 3) + (i15 << 1))];
            if (i15 == 0) {
                break;
            }
            i12 = i15;
            i10 = i16;
        }
        if (c10 != 0) {
            cArr[i10 - 2] = c10;
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.count + length + 1;
        if (i10 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i10);
            } else if (length == 0) {
                write(34);
                write(34);
                write(58);
                return;
            } else {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    }
                    i11++;
                }
                if (z10) {
                    write(34);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char charAt2 = str.charAt(i12);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (charAt2 >= bArr2.length || bArr2[charAt2] == 0) {
                        write((int) charAt2);
                    } else {
                        write(92);
                        write((int) replaceChars[charAt2]);
                    }
                }
                if (z10) {
                    write(34);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i13 = this.count;
            if (i13 + 3 > this.buf.length) {
                expandCapacity(i13 + 3);
            }
            char[] cArr = this.buf;
            int i14 = this.count;
            cArr[i14] = '\"';
            cArr[i14 + 1] = '\"';
            this.count = i14 + 3;
            cArr[i14 + 2] = ':';
            return;
        }
        int i15 = this.count;
        int i16 = i15 + length;
        str.getChars(0, length, this.buf, i15);
        this.count = i10;
        int i17 = i15;
        boolean z11 = false;
        while (i17 < i16) {
            char[] cArr2 = this.buf;
            char c10 = cArr2[i17];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c10 < bArr3.length && bArr3[c10] != 0) {
                if (!z11) {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr3 = this.buf;
                    int i18 = i17 + 1;
                    System.arraycopy(cArr3, i18, cArr3, i17 + 3, (i16 - i17) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, 0, cArr4, 1, i17);
                    char[] cArr5 = this.buf;
                    cArr5[i15] = '\"';
                    cArr5[i18] = '\\';
                    i17 += 2;
                    cArr5[i17] = replaceChars[c10];
                    i16 += 2;
                    cArr5[this.count - 2] = '\"';
                    z11 = true;
                } else {
                    i10++;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr6 = this.buf;
                    int i19 = i17 + 1;
                    System.arraycopy(cArr6, i19, cArr6, i17 + 2, i16 - i17);
                    char[] cArr7 = this.buf;
                    cArr7[i17] = '\\';
                    cArr7[i19] = replaceChars[c10];
                    i16++;
                    i17 = i19;
                }
            }
            i17++;
        }
        this.buf[this.count - 1] = ':';
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.count + length + 1;
        if (i10 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i10);
            } else if (length == 0) {
                write(39);
                write(39);
                write(58);
                return;
            } else {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    byte[] bArr = specicalFlags_singleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    }
                    i11++;
                }
                if (z10) {
                    write(39);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char charAt2 = str.charAt(i12);
                    byte[] bArr2 = specicalFlags_singleQuotes;
                    if (charAt2 >= bArr2.length || bArr2[charAt2] == 0) {
                        write((int) charAt2);
                    } else {
                        write(92);
                        write((int) replaceChars[charAt2]);
                    }
                }
                if (z10) {
                    write(39);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i13 = this.count;
            if (i13 + 3 > this.buf.length) {
                expandCapacity(i13 + 3);
            }
            char[] cArr = this.buf;
            int i14 = this.count;
            cArr[i14] = '\'';
            cArr[i14 + 1] = '\'';
            this.count = i14 + 3;
            cArr[i14 + 2] = ':';
            return;
        }
        int i15 = this.count;
        int i16 = i15 + length;
        str.getChars(0, length, this.buf, i15);
        this.count = i10;
        int i17 = i15;
        boolean z11 = false;
        while (i17 < i16) {
            char[] cArr2 = this.buf;
            char c10 = cArr2[i17];
            byte[] bArr3 = specicalFlags_singleQuotes;
            if (c10 < bArr3.length && bArr3[c10] != 0) {
                if (!z11) {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr3 = this.buf;
                    int i18 = i17 + 1;
                    System.arraycopy(cArr3, i18, cArr3, i17 + 3, (i16 - i17) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, 0, cArr4, 1, i17);
                    char[] cArr5 = this.buf;
                    cArr5[i15] = '\'';
                    cArr5[i18] = '\\';
                    i17 += 2;
                    cArr5[i17] = replaceChars[c10];
                    i16 += 2;
                    cArr5[this.count - 2] = '\'';
                    z11 = true;
                } else {
                    i10++;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr6 = this.buf;
                    int i19 = i17 + 1;
                    System.arraycopy(cArr6, i19, cArr6, i17 + 2, i16 - i17);
                    char[] cArr7 = this.buf;
                    cArr7[i17] = '\\';
                    cArr7[i19] = replaceChars[c10];
                    i16++;
                    i17 = i19;
                }
            }
            i17++;
        }
        this.buf[i10 - 1] = ':';
    }

    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 8192) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void config(SerializerFeature serializerFeature, boolean z10) {
        if (z10) {
            this.features = serializerFeature.mask | this.features;
            return;
        }
        this.features = (~serializerFeature.mask) & this.features;
    }

    /* access modifiers changed from: protected */
    public void expandCapacity(int i10) {
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i10) {
            i10 = length;
        }
        char[] cArr2 = new char[i10];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    public void flush() {
        Writer writer2 = this.writer;
        if (writer2 != null) {
            try {
                writer2.write(this.buf, 0, this.count);
                this.writer.flush();
                this.count = 0;
            } catch (IOException e10) {
                throw new JSONException(e10.getMessage(), e10);
            }
        }
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        if ((serializerFeature.mask & this.features) != 0) {
            return true;
        }
        return false;
    }

    public byte[] toBytes(String str) {
        if (this.writer == null) {
            if (str == null) {
                str = "UTF-8";
            }
            try {
                return new String(this.buf, 0, this.count).getBytes(str);
            } catch (UnsupportedEncodingException e10) {
                throw new JSONException("toBytes error", e10);
            }
        } else {
            throw new UnsupportedOperationException("writer not null");
        }
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public void write(int i10) {
        int i11 = 1;
        int i12 = this.count + 1;
        if (i12 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i12);
            } else {
                flush();
                this.buf[this.count] = (char) i10;
                this.count = i11;
            }
        }
        i11 = i12;
        this.buf[this.count] = (char) i10;
        this.count = i11;
    }

    public void writeByteArray(byte[] bArr) {
        boolean z10;
        char c10;
        char c11;
        char c12;
        String str;
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        int i10 = 0;
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            c10 = '\'';
        } else {
            c10 = '\"';
        }
        if (length == 0) {
            if (z10) {
                str = "''";
            } else {
                str = "\"\"";
            }
            write(str);
            return;
        }
        char[] cArr = JSONLexer.CA;
        int i11 = (length / 3) * 3;
        int i12 = length - 1;
        int i13 = this.count;
        int i14 = (((i12 / 3) + 1) << 2) + i13;
        int i15 = i14 + 2;
        if (i15 > this.buf.length) {
            if (this.writer != null) {
                write((int) c10);
                int i16 = 0;
                while (i16 < i11) {
                    int i17 = i16 + 2;
                    int i18 = (bArr2[i16 + 1] & 255) << 8;
                    i16 += 3;
                    byte b10 = i18 | ((bArr2[i16] & 255) << 16) | (bArr2[i17] & 255);
                    write((int) cArr[(b10 >>> 18) & 63]);
                    write((int) cArr[(b10 >>> 12) & 63]);
                    write((int) cArr[(b10 >>> 6) & 63]);
                    write((int) cArr[b10 & Utf8.REPLACEMENT_BYTE]);
                }
                int i19 = length - i11;
                if (i19 > 0) {
                    int i20 = (bArr2[i11] & 255) << 10;
                    if (i19 == 2) {
                        i10 = (bArr2[i12] & 255) << 2;
                    }
                    int i21 = i20 | i10;
                    write((int) cArr[i21 >> 12]);
                    write((int) cArr[(i21 >>> 6) & 63]);
                    if (i19 == 2) {
                        c12 = cArr[i21 & 63];
                    } else {
                        c12 = '=';
                    }
                    write((int) c12);
                    write(61);
                }
                write((int) c10);
                return;
            }
            expandCapacity(i15);
        }
        this.count = i15;
        int i22 = i13 + 1;
        this.buf[i13] = c10;
        int i23 = 0;
        while (i23 < i11) {
            int i24 = i23 + 2;
            int i25 = (bArr2[i23 + 1] & 255) << 8;
            i23 += 3;
            byte b11 = i25 | ((bArr2[i23] & 255) << 16) | (bArr2[i24] & 255);
            char[] cArr2 = this.buf;
            cArr2[i22] = cArr[(b11 >>> 18) & 63];
            cArr2[i22 + 1] = cArr[(b11 >>> 12) & 63];
            int i26 = i22 + 3;
            cArr2[i22 + 2] = cArr[(b11 >>> 6) & 63];
            i22 += 4;
            cArr2[i26] = cArr[b11 & Utf8.REPLACEMENT_BYTE];
        }
        int i27 = length - i11;
        if (i27 > 0) {
            int i28 = (bArr2[i11] & 255) << 10;
            if (i27 == 2) {
                i10 = (bArr2[i12] & 255) << 2;
            }
            int i29 = i28 | i10;
            char[] cArr3 = this.buf;
            cArr3[i14 - 3] = cArr[i29 >> 12];
            cArr3[i14 - 2] = cArr[(i29 >>> 6) & 63];
            int i30 = i14 - 1;
            if (i27 == 2) {
                c11 = cArr[i29 & 63];
            } else {
                c11 = '=';
            }
            cArr3[i30] = c11;
            cArr3[i14] = '=';
        }
        this.buf[i14 + 1] = c10;
    }

    public void writeFieldName(String str, boolean z10) {
        int i10 = this.features;
        if ((SerializerFeature.UseSingleQuotes.mask & i10) != 0) {
            if ((SerializerFeature.QuoteFieldNames.mask & i10) != 0) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else if ((i10 & SerializerFeature.QuoteFieldNames.mask) != 0) {
            writeStringWithDoubleQuote(str, ':', z10);
        } else {
            writeKeyWithDoubleQuoteIfHasSpecial(str);
        }
    }

    public void writeInt(int i10) {
        int i11;
        if (i10 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        if (i10 < 0) {
            i11 = -i10;
        } else {
            i11 = i10;
        }
        int i12 = 0;
        while (i11 > sizeTable[i12]) {
            i12++;
        }
        int i13 = i12 + 1;
        if (i10 < 0) {
            i13 = i12 + 2;
        }
        int i14 = this.count + i13;
        if (i14 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i14);
            } else {
                char[] cArr = new char[i13];
                getChars((long) i10, i13, cArr);
                write(cArr, 0, i13);
                return;
            }
        }
        getChars((long) i10, i14, this.buf);
        this.count = i14;
    }

    public void writeLong(long j10) {
        long j11;
        int i10;
        if (j10 == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        int i11 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i11 < 0) {
            j11 = -j10;
        } else {
            j11 = j10;
        }
        int i12 = 1;
        long j12 = 10;
        while (true) {
            i10 = 19;
            if (i12 >= 19) {
                i12 = 0;
                break;
            } else if (j11 < j12) {
                break;
            } else {
                j12 *= 10;
                i12++;
            }
        }
        if (i12 != 0) {
            i10 = i12;
        }
        if (i11 < 0) {
            i10++;
        }
        int i13 = this.count + i10;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            } else {
                char[] cArr = new char[i10];
                getChars(j10, i10, cArr);
                write(cArr, 0, i10);
                return;
            }
        }
        getChars(j10, i13, this.buf);
        this.count = i13;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str) {
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, 0, true);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
        if (r14 == -1) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00dd, code lost:
        if (r14 == -1) goto L_0x0092;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeStringWithDoubleQuote(java.lang.String r17, char r18, boolean r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            if (r1 != 0) goto L_0x0011
            r16.writeNull()
            if (r2 == 0) goto L_0x0010
            r0.write((int) r2)
        L_0x0010:
            return
        L_0x0011:
            int r3 = r17.length()
            int r4 = r0.count
            int r4 = r4 + r3
            int r5 = r4 + 2
            if (r2 == 0) goto L_0x001e
            int r5 = r4 + 3
        L_0x001e:
            char[] r4 = r0.buf
            int r4 = r4.length
            r6 = 47
            r7 = 0
            r8 = 34
            r9 = 92
            if (r5 <= r4) goto L_0x006c
            java.io.Writer r4 = r0.writer
            if (r4 == 0) goto L_0x0069
            r0.write((int) r8)
        L_0x0031:
            int r3 = r17.length()
            if (r7 >= r3) goto L_0x0060
            char r3 = r1.charAt(r7)
            byte[] r4 = specicalFlags_doubleQuotes
            int r5 = r4.length
            if (r3 >= r5) goto L_0x0044
            byte r4 = r4[r3]
            if (r4 != 0) goto L_0x004f
        L_0x0044:
            if (r3 != r6) goto L_0x005a
            int r4 = r0.features
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            int r5 = r5.mask
            r4 = r4 & r5
            if (r4 == 0) goto L_0x005a
        L_0x004f:
            r0.write((int) r9)
            char[] r4 = replaceChars
            char r3 = r4[r3]
            r0.write((int) r3)
            goto L_0x005d
        L_0x005a:
            r0.write((int) r3)
        L_0x005d:
            int r7 = r7 + 1
            goto L_0x0031
        L_0x0060:
            r0.write((int) r8)
            if (r2 == 0) goto L_0x0068
            r0.write((int) r2)
        L_0x0068:
            return
        L_0x0069:
            r0.expandCapacity(r5)
        L_0x006c:
            int r4 = r0.count
            int r10 = r4 + 1
            int r11 = r10 + r3
            char[] r12 = r0.buf
            r12[r4] = r8
            r1.getChars(r7, r3, r12, r10)
            r0.count = r5
            if (r19 == 0) goto L_0x022d
            r4 = -1
            r14 = r4
            r15 = r14
            r12 = r7
            r13 = r10
        L_0x0082:
            r3 = 8232(0x2028, float:1.1535E-41)
            if (r13 >= r11) goto L_0x00e7
            char[] r8 = r0.buf
            char r8 = r8[r13]
            if (r8 != r3) goto L_0x0099
            int r7 = r7 + 1
            int r5 = r5 + 4
            if (r14 != r4) goto L_0x0096
        L_0x0092:
            r12 = r8
            r14 = r13
            r15 = r14
            goto L_0x00e0
        L_0x0096:
            r12 = r8
            r15 = r13
            goto L_0x00e0
        L_0x0099:
            r3 = 93
            if (r8 < r3) goto L_0x00ad
            r3 = 127(0x7f, float:1.78E-43)
            if (r8 < r3) goto L_0x00e0
            r3 = 160(0xa0, float:2.24E-43)
            if (r8 >= r3) goto L_0x00e0
            if (r14 != r4) goto L_0x00a8
            r14 = r13
        L_0x00a8:
            int r7 = r7 + 1
            int r5 = r5 + 4
            goto L_0x0096
        L_0x00ad:
            r3 = 32
            if (r8 != r3) goto L_0x00b2
            goto L_0x00e0
        L_0x00b2:
            if (r8 != r6) goto L_0x00be
            int r3 = r0.features
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            int r6 = r6.mask
            r3 = r3 & r6
            if (r3 == 0) goto L_0x00be
            goto L_0x00cf
        L_0x00be:
            r3 = 35
            if (r8 <= r3) goto L_0x00c5
            if (r8 == r9) goto L_0x00c5
            goto L_0x00e0
        L_0x00c5:
            r3 = 31
            if (r8 <= r3) goto L_0x00cf
            if (r8 == r9) goto L_0x00cf
            r3 = 34
            if (r8 != r3) goto L_0x00e0
        L_0x00cf:
            int r7 = r7 + 1
            byte[] r3 = specicalFlags_doubleQuotes
            int r6 = r3.length
            if (r8 >= r6) goto L_0x00dd
            byte r3 = r3[r8]
            r6 = 4
            if (r3 != r6) goto L_0x00dd
            int r5 = r5 + 4
        L_0x00dd:
            if (r14 != r4) goto L_0x0096
            goto L_0x0092
        L_0x00e0:
            int r13 = r13 + 1
            r6 = 47
            r8 = 34
            goto L_0x0082
        L_0x00e7:
            if (r7 <= 0) goto L_0x022d
            int r5 = r5 + r7
            char[] r4 = r0.buf
            int r4 = r4.length
            if (r5 <= r4) goto L_0x00f2
            r0.expandCapacity(r5)
        L_0x00f2:
            r0.count = r5
            r4 = 117(0x75, float:1.64E-43)
            r5 = 1
            if (r7 != r5) goto L_0x0183
            if (r12 != r3) goto L_0x0124
            int r1 = r15 + 1
            int r3 = r15 + 6
            int r11 = r11 - r15
            int r11 = r11 - r5
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r3, r11)
            char[] r3 = r0.buf
            r3[r15] = r9
            r3[r1] = r4
            int r1 = r15 + 2
            r4 = 50
            r3[r1] = r4
            int r1 = r15 + 3
            r5 = 48
            r3[r1] = r5
            int r1 = r15 + 4
            r3[r1] = r4
            int r15 = r15 + 5
            r1 = 56
            r3[r15] = r1
            goto L_0x022d
        L_0x0124:
            byte[] r1 = specicalFlags_doubleQuotes
            int r3 = r1.length
            if (r12 >= r3) goto L_0x016b
            byte r1 = r1[r12]
            r3 = 4
            if (r1 != r3) goto L_0x016b
            int r1 = r15 + 1
            int r3 = r15 + 6
            int r11 = r11 - r15
            r5 = 1
            int r11 = r11 - r5
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r3, r11)
            char[] r3 = r0.buf
            r3[r15] = r9
            int r5 = r15 + 2
            r3[r1] = r4
            int r1 = r15 + 3
            char[] r4 = DIGITS
            int r6 = r12 >>> 12
            r6 = r6 & 15
            char r6 = r4[r6]
            r3[r5] = r6
            int r5 = r15 + 4
            int r6 = r12 >>> 8
            r6 = r6 & 15
            char r6 = r4[r6]
            r3[r1] = r6
            int r15 = r15 + 5
            int r1 = r12 >>> 4
            r1 = r1 & 15
            char r1 = r4[r1]
            r3[r5] = r1
            r1 = r12 & 15
            char r1 = r4[r1]
            r3[r15] = r1
            r5 = 1
            goto L_0x022d
        L_0x016b:
            int r1 = r15 + 1
            int r3 = r15 + 2
            int r11 = r11 - r15
            r5 = 1
            int r11 = r11 - r5
            char[] r4 = r0.buf
            java.lang.System.arraycopy(r4, r1, r4, r3, r11)
            char[] r3 = r0.buf
            r3[r15] = r9
            char[] r4 = replaceChars
            char r4 = r4[r12]
            r3[r1] = r4
            goto L_0x022d
        L_0x0183:
            if (r7 <= r5) goto L_0x022d
            int r5 = r14 - r10
        L_0x0187:
            int r6 = r17.length()
            if (r5 >= r6) goto L_0x022d
            char r6 = r1.charAt(r5)
            byte[] r7 = specicalFlags_doubleQuotes
            int r8 = r7.length
            if (r6 >= r8) goto L_0x019a
            byte r8 = r7[r6]
            if (r8 != 0) goto L_0x019d
        L_0x019a:
            r8 = 47
            goto L_0x01a0
        L_0x019d:
            r8 = 47
            goto L_0x01ab
        L_0x01a0:
            if (r6 != r8) goto L_0x01ec
            int r10 = r0.features
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            int r11 = r11.mask
            r10 = r10 & r11
            if (r10 == 0) goto L_0x01ec
        L_0x01ab:
            char[] r10 = r0.buf
            int r11 = r14 + 1
            r10[r14] = r9
            byte r7 = r7[r6]
            r12 = 4
            if (r7 != r12) goto L_0x01e3
            int r7 = r14 + 2
            r10[r11] = r4
            int r11 = r14 + 3
            char[] r13 = DIGITS
            int r15 = r6 >>> 12
            r15 = r15 & 15
            char r15 = r13[r15]
            r10[r7] = r15
            int r7 = r14 + 4
            int r15 = r6 >>> 8
            r15 = r15 & 15
            char r15 = r13[r15]
            r10[r11] = r15
            int r11 = r14 + 5
            int r15 = r6 >>> 4
            r15 = r15 & 15
            char r15 = r13[r15]
            r10[r7] = r15
            int r14 = r14 + 6
            r6 = r6 & 15
            char r6 = r13[r6]
            r10[r11] = r6
            goto L_0x0229
        L_0x01e3:
            int r14 = r14 + 2
            char[] r7 = replaceChars
            char r6 = r7[r6]
            r10[r11] = r6
            goto L_0x0229
        L_0x01ec:
            r12 = 4
            if (r6 != r3) goto L_0x0222
            char[] r7 = r0.buf
            int r10 = r14 + 1
            r7[r14] = r9
            int r11 = r14 + 2
            r7[r10] = r4
            int r10 = r14 + 3
            char[] r13 = DIGITS
            int r15 = r6 >>> 12
            r15 = r15 & 15
            char r15 = r13[r15]
            r7[r11] = r15
            int r11 = r14 + 4
            int r15 = r6 >>> 8
            r15 = r15 & 15
            char r15 = r13[r15]
            r7[r10] = r15
            int r10 = r14 + 5
            int r15 = r6 >>> 4
            r15 = r15 & 15
            char r15 = r13[r15]
            r7[r11] = r15
            int r14 = r14 + 6
            r6 = r6 & 15
            char r6 = r13[r6]
            r7[r10] = r6
            goto L_0x0229
        L_0x0222:
            char[] r7 = r0.buf
            int r10 = r14 + 1
            r7[r14] = r6
            r14 = r10
        L_0x0229:
            int r5 = r5 + 1
            goto L_0x0187
        L_0x022d:
            if (r2 == 0) goto L_0x023e
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r5 = 34
            r1[r4] = r5
            r4 = 1
            int r3 = r3 - r4
            r1[r3] = r2
            goto L_0x0248
        L_0x023e:
            r4 = 1
            r5 = 34
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r4
            r1[r2] = r5
        L_0x0248:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char, boolean):void");
    }

    /* access modifiers changed from: protected */
    public void writeStringWithSingleQuote(String str) {
        int i10 = 0;
        if (str == null) {
            int i11 = this.count + 4;
            if (i11 > this.buf.length) {
                expandCapacity(i11);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i11;
            return;
        }
        int length = str.length();
        int i12 = this.count + length + 2;
        if (i12 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i10 < str.length()) {
                    char charAt = str.charAt(i10);
                    if (charAt <= 13 || charAt == '\\' || charAt == '\'' || (charAt == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                        write(92);
                        write((int) replaceChars[charAt]);
                    } else {
                        write((int) charAt);
                    }
                    i10++;
                }
                write(39);
                return;
            }
            expandCapacity(i12);
        }
        int i13 = this.count;
        int i14 = i13 + 1;
        int i15 = i14 + length;
        char[] cArr = this.buf;
        cArr[i13] = '\'';
        str.getChars(0, length, cArr, i14);
        this.count = i12;
        int i16 = -1;
        char c10 = 0;
        for (int i17 = i14; i17 < i15; i17++) {
            char c11 = this.buf[i17];
            if (c11 <= 13 || c11 == '\\' || c11 == '\'' || (c11 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i10++;
                i16 = i17;
                c10 = c11;
            }
        }
        int i18 = i12 + i10;
        if (i18 > this.buf.length) {
            expandCapacity(i18);
        }
        this.count = i18;
        if (i10 == 1) {
            char[] cArr2 = this.buf;
            int i19 = i16 + 1;
            System.arraycopy(cArr2, i19, cArr2, i16 + 2, (i15 - i16) - 1);
            char[] cArr3 = this.buf;
            cArr3[i16] = '\\';
            cArr3[i19] = replaceChars[c10];
        } else if (i10 > 1) {
            char[] cArr4 = this.buf;
            int i20 = i16 + 1;
            System.arraycopy(cArr4, i20, cArr4, i16 + 2, (i15 - i16) - 1);
            char[] cArr5 = this.buf;
            cArr5[i16] = '\\';
            cArr5[i20] = replaceChars[c10];
            int i21 = i15 + 1;
            for (int i22 = i16 - 1; i22 >= i14; i22--) {
                char[] cArr6 = this.buf;
                char c12 = cArr6[i22];
                if (c12 <= 13 || c12 == '\\' || c12 == '\'' || (c12 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    int i23 = i22 + 1;
                    System.arraycopy(cArr6, i23, cArr6, i22 + 2, (i21 - i22) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i22] = '\\';
                    cArr7[i23] = replaceChars[c12];
                    i21++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer2) throws IOException {
        if (this.writer == null) {
            writer2.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(Writer writer2) {
        this.writer = writer2;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<char[]> threadLocal = bufLocal;
        this.buf = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set((Object) null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer == null) {
            outputStream.write(new String(this.buf, 0, this.count).getBytes(charset.name()));
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void write(char[] cArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > cArr.length || i11 < 0 || (i12 = i10 + i11) > cArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i11 != 0) {
            int i13 = this.count + i11;
            if (i13 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i13);
                } else {
                    do {
                        char[] cArr2 = this.buf;
                        int length = cArr2.length;
                        int i14 = this.count;
                        int i15 = length - i14;
                        System.arraycopy(cArr, i10, cArr2, i14, i15);
                        this.count = this.buf.length;
                        flush();
                        i11 -= i15;
                        i10 += i15;
                    } while (i11 > this.buf.length);
                    i13 = i11;
                }
            }
            System.arraycopy(cArr, i10, this.buf, this.count, i11);
            this.count = i13;
        }
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, 0, serializerFeatureArr);
    }

    public SerializeWriter append(CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i10, i11).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter(Writer writer2, int i10, SerializerFeature[] serializerFeatureArr) {
        this.writer = writer2;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set((Object) null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i10 |= serializerFeature.mask;
        }
        this.features = i10;
    }

    public SerializeWriter append(char c10) {
        write((int) c10);
        return this;
    }

    public SerializeWriter(int i10) {
        this((Writer) null, i10);
    }

    public SerializeWriter(Writer writer2, int i10) {
        this.writer = writer2;
        if (i10 > 0) {
            this.buf = new char[i10];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i10);
    }

    public void write(String str, int i10, int i11) {
        int i12;
        int i13 = this.count + i11;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i14 = this.count;
                    int i15 = length - i14;
                    i12 = i10 + i15;
                    str.getChars(i10, i12, cArr, i14);
                    this.count = this.buf.length;
                    flush();
                    i11 -= i15;
                    if (i11 <= this.buf.length) {
                        break;
                    }
                    i10 = i12;
                }
                i13 = i11;
                i10 = i12;
            }
        }
        str.getChars(i10, i11 + i10, this.buf, this.count);
        this.count = i13;
    }

    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(boolean z10) {
        write(z10 ? "true" : "false");
    }
}
