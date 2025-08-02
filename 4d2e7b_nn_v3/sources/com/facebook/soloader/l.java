package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public final class l implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final FileOutputStream f4830a;

    /* renamed from: b  reason: collision with root package name */
    private final FileLock f4831b;

    private l(File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.f4830a = fileOutputStream;
        try {
            FileLock lock = fileOutputStream.getChannel().lock();
            if (lock == null) {
                fileOutputStream.close();
            }
            this.f4831b = lock;
        } catch (Throwable th) {
            this.f4830a.close();
            throw th;
        }
    }

    public static l a(File file) {
        return new l(file);
    }

    public void close() {
        try {
            FileLock fileLock = this.f4831b;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.f4830a.close();
        }
    }
}
