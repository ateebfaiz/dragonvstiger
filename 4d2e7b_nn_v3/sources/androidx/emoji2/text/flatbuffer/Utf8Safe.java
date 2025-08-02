package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

public final class Utf8Safe extends Utf8 {

    static class a extends IllegalArgumentException {
        a(int i10, int i11) {
            super("Unpaired surrogate at index " + i10 + " of " + i11);
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && charSequence.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 < length) {
                char charAt = charSequence.charAt(i10);
                if (charAt >= 2048) {
                    i11 += encodedLengthGeneral(charSequence, i10);
                    break;
                }
                i11 += (127 - charAt) >>> 31;
                i10++;
            } else {
                break;
            }
        }
        if (i11 >= length) {
            return i11;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i11) + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] bArr, int i10, int i11) {
        if ((i10 | i11 | ((bArr.length - i10) - i11)) >= 0) {
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (r13 < i12) {
                byte b10 = bArr[r13];
                if (!Utf8.a.g(b10)) {
                    break;
                }
                i10 = r13 + 1;
                Utf8.a.b(b10, cArr, i13);
                i13++;
            }
            int i14 = i13;
            while (r13 < i12) {
                int i15 = r13 + 1;
                byte b11 = bArr[r13];
                if (Utf8.a.g(b11)) {
                    int i16 = i14 + 1;
                    Utf8.a.b(b11, cArr, i14);
                    while (i15 < i12) {
                        byte b12 = bArr[i15];
                        if (!Utf8.a.g(b12)) {
                            break;
                        }
                        i15++;
                        Utf8.a.b(b12, cArr, i16);
                        i16++;
                    }
                    i14 = i16;
                    r13 = i15;
                } else if (Utf8.a.i(b11)) {
                    if (i15 < i12) {
                        r13 += 2;
                        Utf8.a.d(b11, bArr[i15], cArr, i14);
                        i14++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.a.h(b11)) {
                    if (i15 < i12 - 1) {
                        int i17 = r13 + 2;
                        r13 += 3;
                        Utf8.a.c(b11, bArr[i15], bArr[i17], cArr, i14);
                        i14++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i15 < i12 - 2) {
                    byte b13 = bArr[i15];
                    int i18 = r13 + 3;
                    byte b14 = bArr[r13 + 2];
                    r13 += 4;
                    Utf8.a.a(b11, b13, b14, bArr[i18], cArr, i14);
                    i14 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i14);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i10, int i11) {
        if ((i10 | i11 | ((byteBuffer.limit() - i10) - i11)) >= 0) {
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (r13 < i12) {
                byte b10 = byteBuffer.get(r13);
                if (!Utf8.a.g(b10)) {
                    break;
                }
                i10 = r13 + 1;
                Utf8.a.b(b10, cArr, i13);
                i13++;
            }
            int i14 = i13;
            while (r13 < i12) {
                int i15 = r13 + 1;
                byte b11 = byteBuffer.get(r13);
                if (Utf8.a.g(b11)) {
                    int i16 = i14 + 1;
                    Utf8.a.b(b11, cArr, i14);
                    while (i15 < i12) {
                        byte b12 = byteBuffer.get(i15);
                        if (!Utf8.a.g(b12)) {
                            break;
                        }
                        i15++;
                        Utf8.a.b(b12, cArr, i16);
                        i16++;
                    }
                    i14 = i16;
                    r13 = i15;
                } else if (Utf8.a.i(b11)) {
                    if (i15 < i12) {
                        r13 += 2;
                        Utf8.a.d(b11, byteBuffer.get(i15), cArr, i14);
                        i14++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.a.h(b11)) {
                    if (i15 < i12 - 1) {
                        int i17 = r13 + 2;
                        r13 += 3;
                        Utf8.a.c(b11, byteBuffer.get(i15), byteBuffer.get(i17), cArr, i14);
                        i14++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i15 < i12 - 2) {
                    byte b13 = byteBuffer.get(i15);
                    int i18 = r13 + 3;
                    byte b14 = byteBuffer.get(r13 + 2);
                    r13 += 4;
                    Utf8.a.a(b11, b13, b14, byteBuffer.get(i18), cArr, i14);
                    i14 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i14);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        char charAt;
        int length = charSequence.length();
        int i14 = i11 + i10;
        int i15 = 0;
        while (i15 < length && (i13 = i15 + i10) < i14 && (charAt = charSequence.charAt(i15)) < 128) {
            bArr[i13] = (byte) charAt;
            i15++;
        }
        if (i15 == length) {
            return i10 + length;
        }
        int i16 = i10 + i15;
        while (i15 < length) {
            char charAt2 = charSequence.charAt(i15);
            if (charAt2 < 128 && i16 < i14) {
                bArr[i16] = (byte) charAt2;
                i16++;
            } else if (charAt2 < 2048 && i16 <= i14 - 2) {
                int i17 = i16 + 1;
                bArr[i16] = (byte) ((charAt2 >>> 6) | 960);
                i16 += 2;
                bArr[i17] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i16 <= i14 - 3) {
                bArr[i16] = (byte) ((charAt2 >>> 12) | 480);
                int i18 = i16 + 2;
                bArr[i16 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i16 += 3;
                bArr[i18] = (byte) ((charAt2 & '?') | 128);
            } else if (i16 <= i14 - 4) {
                int i19 = i15 + 1;
                if (i19 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i19);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        bArr[i16] = (byte) ((codePoint >>> 18) | 240);
                        bArr[i16 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i20 = i16 + 3;
                        bArr[i16 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i16 += 4;
                        bArr[i20] = (byte) ((codePoint & 63) | 128);
                        i15 = i19;
                    } else {
                        i15 = i19;
                    }
                }
                throw new a(i15 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i12 = i15 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i12)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i16);
            } else {
                throw new a(i15, length);
            }
            i15++;
        }
        return i16;
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i10;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i11 = 0;
        while (i11 < length) {
            try {
                char charAt = charSequence.charAt(i11);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i11, (byte) charAt);
                i11++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i11) + " at index " + (byteBuffer.position() + Math.max(i11, (position - byteBuffer.position()) + 1)));
            }
        }
        if (i11 == length) {
            byteBuffer.position(position + i11);
            return;
        }
        position += i11;
        while (i11 < length) {
            char charAt2 = charSequence.charAt(i11);
            if (charAt2 < 128) {
                byteBuffer.put(position, (byte) charAt2);
            } else if (charAt2 < 2048) {
                i10 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                    byteBuffer.put(i10, (byte) ((charAt2 & '?') | 128));
                    position = i10;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i10;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i11) + " at index " + (byteBuffer.position() + Math.max(i11, (position - byteBuffer.position()) + 1)));
                }
            } else if (charAt2 < 55296 || 57343 < charAt2) {
                i10 = position + 1;
                byteBuffer.put(position, (byte) ((charAt2 >>> 12) | 224));
                position += 2;
                byteBuffer.put(i10, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
            } else {
                int i12 = i11 + 1;
                if (i12 != length) {
                    try {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                int i14 = position + 2;
                                try {
                                    byteBuffer.put(i13, (byte) (((codePoint >>> 12) & 63) | 128));
                                    position += 3;
                                    byteBuffer.put(i14, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(position, (byte) ((codePoint & 63) | 128));
                                    i11 = i12;
                                } catch (IndexOutOfBoundsException unused3) {
                                    i11 = i12;
                                    position = i14;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i11) + " at index " + (byteBuffer.position() + Math.max(i11, (position - byteBuffer.position()) + 1)));
                                }
                            } catch (IndexOutOfBoundsException unused4) {
                                position = i13;
                                i11 = i12;
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i11) + " at index " + (byteBuffer.position() + Math.max(i11, (position - byteBuffer.position()) + 1)));
                            }
                        } else {
                            i11 = i12;
                        }
                    } catch (IndexOutOfBoundsException unused5) {
                        i11 = i12;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i11) + " at index " + (byteBuffer.position() + Math.max(i11, (position - byteBuffer.position()) + 1)));
                    }
                }
                throw new a(i11, length);
            }
            i11++;
            position++;
        }
        byteBuffer.position(position);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt < 2048) {
                i11 += (127 - charAt) >>> 31;
            } else {
                i11 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i10) >= 65536) {
                        i10++;
                    } else {
                        throw new a(i10, length);
                    }
                }
            }
            i10++;
        }
        return i11;
    }

    public String decodeUtf8(ByteBuffer byteBuffer, int i10, int i11) throws IllegalArgumentException {
        if (byteBuffer.hasArray()) {
            return decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i10, i11);
        }
        return decodeUtf8Buffer(byteBuffer, i10, i11);
    }

    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            return;
        }
        encodeUtf8Buffer(charSequence, byteBuffer);
    }

    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
