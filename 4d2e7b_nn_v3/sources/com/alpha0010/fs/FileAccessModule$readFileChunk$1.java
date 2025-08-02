package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$readFileChunk$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$readFileChunk$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $encoding;
    final /* synthetic */ double $length;
    final /* synthetic */ double $offset;
    final /* synthetic */ String $path;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$readFileChunk$1(FileAccessModule fileAccessModule, String str, String str2, Promise promise, double d10, double d11, d dVar) {
        super(2, dVar);
        this.this$0 = fileAccessModule;
        this.$path = str;
        this.$encoding = str2;
        this.$promise = promise;
        this.$offset = d10;
        this.$length = d11;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$readFileChunk$1(this.this$0, this.$path, this.$encoding, this.$promise, this.$offset, this.$length, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        tb.c.a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.b.c()
            int r0 = r4.label
            if (r0 != 0) goto L_0x004f
            kotlin.p.b(r5)
            com.alpha0010.fs.FileAccessModule r5 = r4.this$0     // Catch:{ all -> 0x0034 }
            java.lang.String r0 = r4.$path     // Catch:{ all -> 0x0034 }
            java.io.InputStream r5 = r5.openForReading(r0)     // Catch:{ all -> 0x0034 }
            double r0 = r4.$offset     // Catch:{ all -> 0x0034 }
            double r2 = r4.$length     // Catch:{ all -> 0x0034 }
            long r0 = (long) r0
            r5.skip(r0)     // Catch:{ all -> 0x0040 }
            int r0 = (int) r2     // Catch:{ all -> 0x0040 }
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0040 }
            r5.read(r0)     // Catch:{ all -> 0x0040 }
            r1 = 0
            tb.c.a(r5, r1)     // Catch:{ all -> 0x0034 }
            java.lang.String r5 = r4.$encoding     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "base64"
            boolean r5 = kotlin.jvm.internal.m.b(r5, r1)     // Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x0036
            r5 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r0, r5)     // Catch:{ all -> 0x0034 }
            goto L_0x003a
        L_0x0034:
            r5 = move-exception
            goto L_0x0047
        L_0x0036:
            java.lang.String r5 = kotlin.text.j.m(r0)     // Catch:{ all -> 0x0034 }
        L_0x003a:
            com.facebook.react.bridge.Promise r0 = r4.$promise     // Catch:{ all -> 0x0034 }
            r0.resolve(r5)     // Catch:{ all -> 0x0034 }
            goto L_0x004c
        L_0x0040:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r1 = move-exception
            tb.c.a(r5, r0)     // Catch:{ all -> 0x0034 }
            throw r1     // Catch:{ all -> 0x0034 }
        L_0x0047:
            com.facebook.react.bridge.Promise r0 = r4.$promise
            r0.reject((java.lang.Throwable) r5)
        L_0x004c:
            kotlin.Unit r5 = kotlin.Unit.f12577a
            return r5
        L_0x004f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.FileAccessModule$readFileChunk$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$readFileChunk$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
