package com.botion.captcha;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final char f18532a = File.separatorChar;

    /* renamed from: b  reason: collision with root package name */
    public static String f18533b;

    static {
        try {
            StringWriter stringWriter = new StringWriter(4);
            new PrintWriter(stringWriter).println();
            f18533b = stringWriter.toString();
        } catch (Exception unused) {
        }
    }

    public static String a(Reader reader) {
        try {
            StringWriter stringWriter = new StringWriter();
            a(reader, stringWriter, new char[4096]);
            return stringWriter.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(byte[] bArr, String str) throws IOException {
        return new String(bArr, Charset.forName(str));
    }

    public static void a(String str, Writer writer) throws IOException {
        if (str != null) {
            writer.write(str);
        }
    }

    private static long a(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j10 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j10;
            }
            writer.write(cArr, 0, read);
            j10 += (long) read;
        }
    }
}
