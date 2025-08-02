package io.jsonwebtoken.lang;

public final class Arrays {
    private Arrays() {
    }

    public static byte[] clean(byte[] bArr) {
        if (length(bArr) > 0) {
            return bArr;
        }
        return null;
    }

    public static int length(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }
}
