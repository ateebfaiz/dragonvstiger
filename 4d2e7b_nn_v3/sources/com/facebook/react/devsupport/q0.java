package com.facebook.react.devsupport;

import java.util.HashMap;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

class q0 {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f3148a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3149b;

    /* renamed from: c  reason: collision with root package name */
    private long f3150c;

    public interface a {
        void a(Map map, long j10, long j11);

        void b(Map map, Buffer buffer, boolean z10);
    }

    public q0(BufferedSource bufferedSource, String str) {
        this.f3148a = bufferedSource;
        this.f3149b = str;
    }

    private void a(Buffer buffer, boolean z10, a aVar) {
        ByteString encodeUtf8 = ByteString.encodeUtf8("\r\n\r\n");
        long indexOf = buffer.indexOf(encodeUtf8);
        if (indexOf == -1) {
            aVar.b((Map) null, buffer, z10);
            return;
        }
        Buffer buffer2 = new Buffer();
        Buffer buffer3 = new Buffer();
        buffer.read(buffer2, indexOf);
        buffer.skip((long) encodeUtf8.size());
        buffer.readAll(buffer3);
        aVar.b(c(buffer2), buffer3, z10);
    }

    private void b(Map map, long j10, boolean z10, a aVar) {
        long j11;
        if (map != null && aVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f3150c > 16 || z10) {
                this.f3150c = currentTimeMillis;
                if (map.get("Content-Length") != null) {
                    j11 = Long.parseLong((String) map.get("Content-Length"));
                } else {
                    j11 = 0;
                }
                aVar.a(map, j10, j11);
            }
        }
    }

    private Map c(Buffer buffer) {
        HashMap hashMap = new HashMap();
        for (String str : buffer.readUtf8().split("\r\n")) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                hashMap.put(str.substring(0, indexOf).trim(), str.substring(indexOf + 1).trim());
            }
        }
        return hashMap;
    }

    public boolean d(a aVar) {
        boolean z10;
        long j10;
        ByteString encodeUtf8 = ByteString.encodeUtf8("\r\n--" + this.f3149b + "\r\n");
        ByteString encodeUtf82 = ByteString.encodeUtf8("\r\n--" + this.f3149b + "--" + "\r\n");
        ByteString encodeUtf83 = ByteString.encodeUtf8("\r\n\r\n");
        Buffer buffer = new Buffer();
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        Map map = null;
        while (true) {
            long max = Math.max(j11 - ((long) encodeUtf82.size()), j12);
            long indexOf = buffer.indexOf(encodeUtf8, max);
            if (indexOf == -1) {
                indexOf = buffer.indexOf(encodeUtf82, max);
                z10 = true;
            } else {
                z10 = false;
            }
            if (indexOf == -1) {
                long size = buffer.size();
                if (map == null) {
                    long indexOf2 = buffer.indexOf(encodeUtf83, max);
                    if (indexOf2 >= 0) {
                        this.f3148a.read(buffer, indexOf2);
                        Buffer buffer2 = new Buffer();
                        j10 = j12;
                        buffer.copyTo(buffer2, max, indexOf2 - max);
                        j13 = buffer2.size() + ((long) encodeUtf83.size());
                        map = c(buffer2);
                    } else {
                        j10 = j12;
                    }
                } else {
                    j10 = j12;
                    b(map, buffer.size() - j13, false, aVar);
                }
                if (this.f3148a.read(buffer, (long) 4096) <= 0) {
                    return false;
                }
                j11 = size;
                j12 = j10;
            } else {
                long j14 = j12;
                long j15 = indexOf - j14;
                if (j14 > 0) {
                    Buffer buffer3 = new Buffer();
                    buffer.skip(j14);
                    buffer.read(buffer3, j15);
                    b(map, buffer3.size() - j13, true, aVar);
                    a(buffer3, z10, aVar);
                    j13 = 0;
                    map = null;
                } else {
                    a aVar2 = aVar;
                    buffer.skip(indexOf);
                }
                if (z10) {
                    return true;
                }
                j12 = (long) encodeUtf8.size();
                j11 = j12;
            }
        }
    }
}
