package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$writeFile$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$writeFile$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $data;
    final /* synthetic */ String $encoding;
    final /* synthetic */ String $path;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$writeFile$1(String str, FileAccessModule fileAccessModule, String str2, Promise promise, String str3, d dVar) {
        super(2, dVar);
        this.$encoding = str;
        this.this$0 = fileAccessModule;
        this.$path = str2;
        this.$promise = promise;
        this.$data = str3;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$writeFile$1(this.$encoding, this.this$0, this.$path, this.$promise, this.$data, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        tb.c.a(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        tb.c.a(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.b.c()
            int r0 = r3.label
            if (r0 != 0) goto L_0x0068
            kotlin.p.b(r4)
            java.lang.String r4 = r3.$encoding     // Catch:{ all -> 0x002d }
            java.lang.String r0 = "base64"
            boolean r4 = kotlin.jvm.internal.m.b(r4, r0)     // Catch:{ all -> 0x002d }
            r0 = 0
            if (r4 == 0) goto L_0x0036
            com.alpha0010.fs.FileAccessModule r4 = r3.this$0     // Catch:{ all -> 0x002d }
            java.lang.String r1 = r3.$path     // Catch:{ all -> 0x002d }
            java.io.OutputStream r4 = r4.openForWriting(r1)     // Catch:{ all -> 0x002d }
            java.lang.String r1 = r3.$data     // Catch:{ all -> 0x002d }
            r2 = 0
            byte[] r1 = android.util.Base64.decode(r1, r2)     // Catch:{ all -> 0x002f }
            r4.write(r1)     // Catch:{ all -> 0x002f }
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x002f }
            tb.c.a(r4, r0)     // Catch:{ all -> 0x002d }
            goto L_0x0053
        L_0x002d:
            r4 = move-exception
            goto L_0x0060
        L_0x002f:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r1 = move-exception
            tb.c.a(r4, r0)     // Catch:{ all -> 0x002d }
            throw r1     // Catch:{ all -> 0x002d }
        L_0x0036:
            com.alpha0010.fs.FileAccessModule r4 = r3.this$0     // Catch:{ all -> 0x002d }
            java.lang.String r1 = r3.$path     // Catch:{ all -> 0x002d }
            java.io.OutputStream r4 = r4.openForWriting(r1)     // Catch:{ all -> 0x002d }
            java.lang.String r1 = r3.$data     // Catch:{ all -> 0x002d }
            java.nio.charset.Charset r2 = kotlin.text.d.f797b     // Catch:{ all -> 0x0059 }
            byte[] r1 = r1.getBytes(r2)     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = "getBytes(...)"
            kotlin.jvm.internal.m.e(r1, r2)     // Catch:{ all -> 0x0059 }
            r4.write(r1)     // Catch:{ all -> 0x0059 }
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0059 }
            tb.c.a(r4, r0)     // Catch:{ all -> 0x002d }
        L_0x0053:
            com.facebook.react.bridge.Promise r4 = r3.$promise     // Catch:{ all -> 0x002d }
            r4.resolve(r0)     // Catch:{ all -> 0x002d }
            goto L_0x0065
        L_0x0059:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005b }
        L_0x005b:
            r1 = move-exception
            tb.c.a(r4, r0)     // Catch:{ all -> 0x002d }
            throw r1     // Catch:{ all -> 0x002d }
        L_0x0060:
            com.facebook.react.bridge.Promise r0 = r3.$promise
            r0.reject((java.lang.Throwable) r4)
        L_0x0065:
            kotlin.Unit r4 = kotlin.Unit.f12577a
            return r4
        L_0x0068:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.FileAccessModule$writeFile$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$writeFile$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
