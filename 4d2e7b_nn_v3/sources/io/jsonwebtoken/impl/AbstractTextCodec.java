package io.jsonwebtoken.impl;

import io.jsonwebtoken.lang.Assert;
import java.nio.charset.Charset;

@Deprecated
public abstract class AbstractTextCodec implements TextCodec {
    protected static final Charset US_ASCII = Charset.forName("US-ASCII");
    protected static final Charset UTF8 = Charset.forName("UTF-8");

    public String decodeToString(String str) {
        return new String(decode(str), UTF8);
    }

    public String encode(String str) {
        Assert.hasText(str, "String argument to encode cannot be null or empty.");
        return encode(str.getBytes(UTF8));
    }
}
