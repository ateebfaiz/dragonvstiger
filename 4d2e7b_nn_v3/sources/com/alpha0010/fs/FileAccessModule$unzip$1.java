package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$unzip$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$unzip$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $source;
    final /* synthetic */ String $target;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$unzip$1(String str, FileAccessModule fileAccessModule, String str2, Promise promise, d dVar) {
        super(2, dVar);
        this.$target = str;
        this.this$0 = fileAccessModule;
        this.$source = str2;
        this.$promise = promise;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$unzip$1(this.$target, this.this$0, this.$source, this.$promise, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        tb.c.a(r3, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0070, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        tb.c.a(r1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ce, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.String r0 = "getCanonicalPath(...)"
            kotlin.coroutines.intrinsics.b.c()
            int r1 = r10.label
            if (r1 != 0) goto L_0x00d7
            kotlin.p.b(r11)
            java.lang.String r11 = r10.$target     // Catch:{ all -> 0x00bf }
            java.io.File r11 = com.alpha0010.fs.e.d(r11)     // Catch:{ all -> 0x00bf }
            r11.mkdirs()     // Catch:{ all -> 0x00bf }
            com.alpha0010.fs.FileAccessModule r1 = r10.this$0     // Catch:{ all -> 0x00bf }
            java.lang.String r2 = r10.$source     // Catch:{ all -> 0x00bf }
            java.io.InputStream r1 = r1.openForReading(r2)     // Catch:{ all -> 0x00bf }
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x00c1 }
            r2.<init>(r1)     // Catch:{ all -> 0x00c1 }
            java.util.zip.ZipEntry r3 = r2.getNextEntry()     // Catch:{ all -> 0x0052 }
        L_0x0026:
            r4 = 0
            if (r3 == 0) goto L_0x00b1
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = r3.getName()     // Catch:{ all -> 0x0052 }
            r5.<init>(r11, r6)     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = r5.getCanonicalPath()     // Catch:{ all -> 0x0052 }
            kotlin.jvm.internal.m.e(r6, r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r7 = r11.getCanonicalPath()     // Catch:{ all -> 0x0052 }
            kotlin.jvm.internal.m.e(r7, r0)     // Catch:{ all -> 0x0052 }
            r8 = 2
            r9 = 0
            boolean r6 = kotlin.text.j.F(r6, r7, r9, r8, r4)     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0091
            boolean r3 = r3.isDirectory()     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x0054
            r5.mkdirs()     // Catch:{ all -> 0x0052 }
            goto L_0x0065
        L_0x0052:
            r11 = move-exception
            goto L_0x00c3
        L_0x0054:
            boolean r3 = r5.exists()     // Catch:{ all -> 0x0052 }
            if (r3 != 0) goto L_0x0071
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0052 }
            r3.<init>(r5)     // Catch:{ all -> 0x0052 }
            tb.b.b(r2, r3, r9, r8, r4)     // Catch:{ all -> 0x006a }
            tb.c.a(r3, r4)     // Catch:{ all -> 0x0052 }
        L_0x0065:
            java.util.zip.ZipEntry r3 = r2.getNextEntry()     // Catch:{ all -> 0x0052 }
            goto L_0x0026
        L_0x006a:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x006c }
        L_0x006c:
            r0 = move-exception
            tb.c.a(r3, r11)     // Catch:{ all -> 0x0052 }
            throw r0     // Catch:{ all -> 0x0052 }
        L_0x0071:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = r5.getAbsolutePath()     // Catch:{ all -> 0x0052 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r3.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = "Could not extract '"
            r3.append(r4)     // Catch:{ all -> 0x0052 }
            r3.append(r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "' because a file with the same name already exists."
            r3.append(r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0052 }
            r11.<init>(r0)     // Catch:{ all -> 0x0052 }
            throw r11     // Catch:{ all -> 0x0052 }
        L_0x0091:
            java.lang.SecurityException r11 = new java.lang.SecurityException     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = r3.getName()     // Catch:{ all -> 0x0052 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r3.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = "Failed to extract invalid filename '"
            r3.append(r4)     // Catch:{ all -> 0x0052 }
            r3.append(r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "'."
            r3.append(r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0052 }
            r11.<init>(r0)     // Catch:{ all -> 0x0052 }
            throw r11     // Catch:{ all -> 0x0052 }
        L_0x00b1:
            kotlin.Unit r11 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0052 }
            tb.c.a(r2, r4)     // Catch:{ all -> 0x00c1 }
            tb.c.a(r1, r4)     // Catch:{ all -> 0x00bf }
            com.facebook.react.bridge.Promise r11 = r10.$promise     // Catch:{ all -> 0x00bf }
            r11.resolve(r4)     // Catch:{ all -> 0x00bf }
            goto L_0x00d4
        L_0x00bf:
            r11 = move-exception
            goto L_0x00cf
        L_0x00c1:
            r11 = move-exception
            goto L_0x00c9
        L_0x00c3:
            throw r11     // Catch:{ all -> 0x00c4 }
        L_0x00c4:
            r0 = move-exception
            tb.c.a(r2, r11)     // Catch:{ all -> 0x00c1 }
            throw r0     // Catch:{ all -> 0x00c1 }
        L_0x00c9:
            throw r11     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r0 = move-exception
            tb.c.a(r1, r11)     // Catch:{ all -> 0x00bf }
            throw r0     // Catch:{ all -> 0x00bf }
        L_0x00cf:
            com.facebook.react.bridge.Promise r0 = r10.$promise
            r0.reject((java.lang.Throwable) r11)
        L_0x00d4:
            kotlin.Unit r11 = kotlin.Unit.f12577a
            return r11
        L_0x00d7:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.FileAccessModule$unzip$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$unzip$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
