package com.bugsnag.android;

import java.io.Closeable;
import java.io.File;
import java.io.Reader;
import java.io.Writer;

abstract class e2 {
    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    static int b(Reader reader, Writer writer) {
        char[] cArr = new char[4096];
        long j10 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                break;
            }
            writer.write(cArr, 0, read);
            j10 += (long) read;
        }
        if (j10 > 2147483647L) {
            return -1;
        }
        return (int) j10;
    }

    static void c(File file, s2 s2Var) {
        try {
            if (!file.delete()) {
                file.deleteOnExit();
            }
        } catch (Exception e10) {
            s2Var.c("Failed to delete file", e10);
        }
    }
}
