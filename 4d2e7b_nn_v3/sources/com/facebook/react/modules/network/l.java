package com.facebook.react.modules.network;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import z2.a;

class l {

    /* renamed from: a  reason: collision with root package name */
    private final CharsetDecoder f3337a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f3338b = null;

    public l(Charset charset) {
        this.f3337a = charset.newDecoder();
    }

    public String a(byte[] bArr, int i10) {
        byte[] bArr2 = this.f3338b;
        if (bArr2 != null) {
            byte[] bArr3 = new byte[(bArr2.length + i10)];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, this.f3338b.length, i10);
            i10 += this.f3338b.length;
            bArr = bArr3;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, i10);
        boolean z10 = false;
        int i11 = 0;
        CharBuffer charBuffer = null;
        while (!z10 && i11 < 4) {
            try {
                charBuffer = this.f3337a.decode(wrap);
                z10 = true;
            } catch (CharacterCodingException unused) {
                i11++;
                wrap = ByteBuffer.wrap(bArr, 0, i10 - i11);
            }
        }
        if (!z10 || i11 <= 0) {
            this.f3338b = null;
        } else {
            byte[] bArr4 = new byte[i11];
            this.f3338b = bArr4;
            System.arraycopy(bArr, i10 - i11, bArr4, 0, i11);
        }
        if (z10) {
            return new String(charBuffer.array(), 0, charBuffer.length());
        }
        a.G("ReactNative", "failed to decode string from byte array");
        return "";
    }
}
