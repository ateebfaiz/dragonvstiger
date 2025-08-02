package com.geetest.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class o3 {
    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr, 0, 4096);
            if (read < 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static int a(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 < i11) {
            int read = inputStream.read(bArr, i10 + i12, i11 - i12);
            if (read < 0) {
                break;
            }
            i12 += read;
        }
        return i12;
    }
}
