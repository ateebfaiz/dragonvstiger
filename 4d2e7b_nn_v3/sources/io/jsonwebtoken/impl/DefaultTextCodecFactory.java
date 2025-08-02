package io.jsonwebtoken.impl;

import com.alibaba.pdns.f;

@Deprecated
public class DefaultTextCodecFactory implements TextCodecFactory {
    /* access modifiers changed from: protected */
    public String getSystemProperty(String str) {
        return System.getProperty(str);
    }

    public TextCodec getTextCodec() {
        if (isAndroid()) {
            return new AndroidBase64Codec();
        }
        return new Base64Codec();
    }

    /* access modifiers changed from: protected */
    public boolean isAndroid() {
        String systemProperty = getSystemProperty("java.vm.name");
        if (systemProperty != null) {
            return systemProperty.toLowerCase().contains("dalvik");
        }
        String systemProperty2 = getSystemProperty("java.vm.vendor");
        if (systemProperty2 != null) {
            return systemProperty2.toLowerCase().contains(f.f17924q);
        }
        return false;
    }
}
