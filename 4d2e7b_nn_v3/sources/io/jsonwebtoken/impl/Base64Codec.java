package io.jsonwebtoken.impl;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;

@Deprecated
public class Base64Codec extends AbstractTextCodec {
    public byte[] decode(String str) {
        return Decoders.BASE64.decode(str);
    }

    public String encode(byte[] bArr) {
        return Encoders.BASE64.encode(bArr);
    }
}
