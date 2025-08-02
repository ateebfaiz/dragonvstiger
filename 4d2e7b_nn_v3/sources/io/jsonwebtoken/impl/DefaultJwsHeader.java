package io.jsonwebtoken.impl;

import io.jsonwebtoken.JwsHeader;
import java.util.Map;

public class DefaultJwsHeader extends DefaultHeader implements JwsHeader {
    public DefaultJwsHeader() {
    }

    public String getAlgorithm() {
        return getString(JwsHeader.ALGORITHM);
    }

    public String getKeyId() {
        return getString(JwsHeader.KEY_ID);
    }

    public JwsHeader setAlgorithm(String str) {
        setValue(JwsHeader.ALGORITHM, str);
        return this;
    }

    public JwsHeader setKeyId(String str) {
        setValue(JwsHeader.KEY_ID, str);
        return this;
    }

    public DefaultJwsHeader(Map<String, Object> map) {
        super(map);
    }
}
