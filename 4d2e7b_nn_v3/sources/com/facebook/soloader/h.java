package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private File f4810a;

    /* renamed from: b  reason: collision with root package name */
    private FileInputStream f4811b;

    /* renamed from: c  reason: collision with root package name */
    private FileChannel f4812c;

    public h(File file) {
        this.f4810a = file;
        a();
    }

    public void a() {
        FileInputStream fileInputStream = new FileInputStream(this.f4810a);
        this.f4811b = fileInputStream;
        this.f4812c = fileInputStream.getChannel();
    }

    public void close() {
        this.f4811b.close();
    }

    public boolean isOpen() {
        return this.f4812c.isOpen();
    }

    public int o(ByteBuffer byteBuffer, long j10) {
        return this.f4812c.read(byteBuffer, j10);
    }

    public int read(ByteBuffer byteBuffer) {
        return this.f4812c.read(byteBuffer);
    }

    public int write(ByteBuffer byteBuffer) {
        return this.f4812c.write(byteBuffer);
    }
}
