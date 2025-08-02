package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import b3.h;
import b3.j;
import c3.a;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import h3.b;
import h3.c;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.OutputStream;
import java.lang.reflect.Method;
import y2.d;
import y2.l;
import y2.q;

@d
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {

    /* renamed from: d  reason: collision with root package name */
    private static Method f20002d;

    /* renamed from: c  reason: collision with root package name */
    private final b f20003c = c.i();

    private static MemoryFile h(a aVar, int i10, byte[] bArr) {
        int i11;
        Closeable closeable;
        e3.a aVar2;
        if (bArr == null) {
            i11 = 0;
        } else {
            i11 = bArr.length;
        }
        j jVar = null;
        MemoryFile memoryFile = new MemoryFile((String) null, i11 + i10);
        memoryFile.allowPurging(false);
        try {
            j jVar2 = new j((h) aVar.p());
            try {
                aVar2 = new e3.a(jVar2, i10);
                try {
                    OutputStream outputStream = memoryFile.getOutputStream();
                    y2.a.a(aVar2, outputStream);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i10, bArr.length);
                    }
                    a.m(aVar);
                    y2.b.b(jVar2);
                    y2.b.b(aVar2);
                    y2.b.a(outputStream, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    jVar = jVar2;
                    a.m(aVar);
                    y2.b.b(jVar);
                    y2.b.b(aVar2);
                    y2.b.a(closeable, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                aVar2 = null;
                jVar = jVar2;
                a.m(aVar);
                y2.b.b(jVar);
                y2.b.b(aVar2);
                y2.b.a(closeable, true);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            aVar2 = null;
            a.m(aVar);
            y2.b.b(jVar);
            y2.b.b(aVar2);
            y2.b.a(closeable, true);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap i(c3.a r2, int r3, byte[] r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r1 = this;
            r0 = 0
            android.os.MemoryFile r2 = h(r2, r3, r4)     // Catch:{ IOException -> 0x002f }
            java.io.FileDescriptor r3 = r1.k(r2)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            h3.b r4 = r1.f20003c     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            if (r4 == 0) goto L_0x0025
            android.graphics.Bitmap r3 = r4.a(r3, r0, r5)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            java.lang.String r4 = "BitmapFactory returned null"
            java.lang.Object r3 = y2.l.h(r3, r4)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            if (r2 == 0) goto L_0x001e
            r2.close()
        L_0x001e:
            return r3
        L_0x001f:
            r3 = move-exception
            r0 = r2
            goto L_0x0035
        L_0x0022:
            r3 = move-exception
            r0 = r2
            goto L_0x0030
        L_0x0025:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            java.lang.String r4 = "WebpBitmapFactory is null"
            r3.<init>(r4)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            throw r3     // Catch:{ IOException -> 0x0022, all -> 0x001f }
        L_0x002d:
            r3 = move-exception
            goto L_0x0035
        L_0x002f:
            r3 = move-exception
        L_0x0030:
            java.lang.RuntimeException r2 = y2.q.a(r3)     // Catch:{ all -> 0x002d }
            throw r2     // Catch:{ all -> 0x002d }
        L_0x0035:
            if (r0 == 0) goto L_0x003a
            r0.close()
        L_0x003a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder.i(c3.a, int, byte[], android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    private synchronized Method j() {
        if (f20002d == null) {
            try {
                f20002d = MemoryFile.class.getDeclaredMethod("getFileDescriptor", (Class[]) null);
            } catch (Exception e10) {
                throw q.a(e10);
            }
        }
        return f20002d;
    }

    private FileDescriptor k(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) l.g(j().invoke(memoryFile, (Object[]) null));
        } catch (Exception e10) {
            throw q.a(e10);
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap c(a aVar, BitmapFactory.Options options) {
        return i(aVar, ((h) aVar.p()).size(), (byte[]) null, options);
    }

    /* access modifiers changed from: protected */
    public Bitmap d(a aVar, int i10, BitmapFactory.Options options) {
        byte[] bArr;
        if (DalvikPurgeableDecoder.e(aVar, i10)) {
            bArr = null;
        } else {
            bArr = DalvikPurgeableDecoder.f19990b;
        }
        return i(aVar, i10, bArr, options);
    }
}
