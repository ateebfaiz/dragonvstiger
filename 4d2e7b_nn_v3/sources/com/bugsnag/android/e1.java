package com.bugsnag.android;

import android.util.JsonReader;
import com.bugsnag.android.d1;
import java.io.File;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class e1 implements f1 {

    /* renamed from: e  reason: collision with root package name */
    public static final a f18712e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final File f18713a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0 f18714b;

    /* renamed from: c  reason: collision with root package name */
    private final s2 f18715c;

    /* renamed from: d  reason: collision with root package name */
    private final y3 f18716d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* synthetic */ class b extends j implements Function1 {
        b(Object obj) {
            super(1, obj, d1.a.class, "fromReader", "fromReader(Landroid/util/JsonReader;)Lcom/bugsnag/android/DeviceId;", 0);
        }

        /* renamed from: c */
        public final d1 invoke(JsonReader jsonReader) {
            return ((d1.a) this.receiver).a(jsonReader);
        }
    }

    public e1(File file, Function0 function0, s2 s2Var) {
        this.f18713a = file;
        this.f18714b = function0;
        this.f18715c = s2Var;
        try {
            file.createNewFile();
        } catch (Throwable th) {
            this.f18715c.c("Failed to created device ID file", th);
        }
        this.f18716d = new y3(this.f18713a);
    }

    private final d1 b() {
        if (this.f18713a.length() <= 0) {
            return null;
        }
        try {
            return (d1) this.f18716d.b(new b(d1.f18697b));
        } catch (Throwable th) {
            this.f18715c.c("Failed to load device ID", th);
            return null;
        }
    }

    private final String c(FileChannel fileChannel, UUID uuid) {
        String str;
        FileLock e10 = e(fileChannel);
        String str2 = null;
        if (e10 == null) {
            return null;
        }
        try {
            d1 b10 = b();
            if (b10 != null) {
                str2 = b10.a();
            }
            if (str2 != null) {
                str = b10.a();
            } else {
                d1 d1Var = new d1(uuid.toString());
                this.f18716d.c(d1Var);
                str = d1Var.a();
            }
            return str;
        } finally {
            e10.release();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        tb.c.a(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String d(java.util.UUID r4) {
        /*
            r3 = this;
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0015 }
            java.io.File r2 = r3.f18713a     // Catch:{ IOException -> 0x0015 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0015 }
            java.nio.channels.FileChannel r1 = r1.getChannel()     // Catch:{ IOException -> 0x0015 }
            java.lang.String r4 = r3.c(r1, r4)     // Catch:{ all -> 0x0017 }
            tb.c.a(r1, r0)     // Catch:{ IOException -> 0x0015 }
            r0 = r4
            goto L_0x0025
        L_0x0015:
            r4 = move-exception
            goto L_0x001e
        L_0x0017:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r2 = move-exception
            tb.c.a(r1, r4)     // Catch:{ IOException -> 0x0015 }
            throw r2     // Catch:{ IOException -> 0x0015 }
        L_0x001e:
            com.bugsnag.android.s2 r1 = r3.f18715c
            java.lang.String r2 = "Failed to persist device ID"
            r1.c(r2, r4)
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.e1.d(java.util.UUID):java.lang.String");
    }

    private final FileLock e(FileChannel fileChannel) {
        int i10 = 0;
        while (i10 < 20) {
            i10++;
            try {
                return fileChannel.tryLock();
            } catch (OverlappingFileLockException unused) {
                Thread.sleep(25);
            }
        }
        return null;
    }

    public String a(boolean z10) {
        String str;
        try {
            d1 b10 = b();
            if (b10 == null) {
                str = null;
            } else {
                str = b10.a();
            }
            if (str != null) {
                return b10.a();
            }
            if (z10) {
                return d((UUID) this.f18714b.invoke());
            }
            return null;
        } catch (Throwable th) {
            this.f18715c.c("Failed to load device ID", th);
            return null;
        }
    }
}
