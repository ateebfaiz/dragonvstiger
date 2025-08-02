package io.jsonwebtoken.impl;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;

@Deprecated
public class Base64UrlCodec extends AbstractTextCodec {
    public byte[] decode(String str) {
        return Decoders.BASE64URL.decode(str);
    }

    public String encode(byte[] bArr) {
        return Encoders.BASE64URL.encode(bArr);
    }
}
