package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.lang.Strings;
import java.util.Map;

public class DefaultHeader<T extends Header<T>> extends JwtMap implements Header<T> {
    public DefaultHeader() {
    }

    public String getCompressionAlgorithm() {
        String string = getString(Header.COMPRESSION_ALGORITHM);
        if (!Strings.hasText(string)) {
            return getString(Header.DEPRECATED_COMPRESSION_ALGORITHM);
        }
        return string;
    }

    public String getContentType() {
        return getString(Header.CONTENT_TYPE);
    }

    public String getType() {
        return getString("typ");
    }

    public T setCompressionAlgorithm(String str) {
        setValue(Header.COMPRESSION_ALGORITHM, str);
        return this;
    }

    public T setContentType(String str) {
        setValue(Header.CONTENT_TYPE, str);
        return this;
    }

    public T setType(String str) {
        setValue("typ", str);
        return this;
    }

    public DefaultHeader(Map<String, Object> map) {
        super(map);
    }
}
