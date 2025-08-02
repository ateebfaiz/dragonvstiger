package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$readFile$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$readFile$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $encoding;
    final /* synthetic */ String $path;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$readFile$1(FileAccessModule fileAccessModule, String str, String str2, Promise promise, d dVar) {
        super(2, dVar);
        this.this$0 = fileAccessModule;
        this.$path = str;
        this.$encoding = str2;
        this.$promise = promise;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$readFile$1(this.this$0, this.$path, this.$encoding, this.$promise, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        tb.c.a(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r3) {
        /*
            r2 = this;
            kotlin.coroutines.intrinsics.b.c()
            int r0 = r2.label
            if (r0 != 0) goto L_0x004a
            kotlin.p.b(r3)
            com.alpha0010.fs.FileAccessModule r3 = r2.this$0     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r2.$path     // Catch:{ all -> 0x002f }
            java.io.InputStream r3 = r3.openForReading(r0)     // Catch:{ all -> 0x002f }
            byte[] r0 = tb.b.c(r3)     // Catch:{ all -> 0x003b }
            r1 = 0
            tb.c.a(r3, r1)     // Catch:{ all -> 0x002f }
            java.lang.String r3 = r2.$encoding     // Catch:{ all -> 0x002f }
            java.lang.String r1 = "base64"
            boolean r3 = kotlin.jvm.internal.m.b(r3, r1)     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x0031
            com.facebook.react.bridge.Promise r3 = r2.$promise     // Catch:{ all -> 0x002f }
            r1 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ all -> 0x002f }
            r3.resolve(r0)     // Catch:{ all -> 0x002f }
            goto L_0x0047
        L_0x002f:
            r3 = move-exception
            goto L_0x0042
        L_0x0031:
            com.facebook.react.bridge.Promise r3 = r2.$promise     // Catch:{ all -> 0x002f }
            java.lang.String r0 = kotlin.text.j.m(r0)     // Catch:{ all -> 0x002f }
            r3.resolve(r0)     // Catch:{ all -> 0x002f }
            goto L_0x0047
        L_0x003b:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r1 = move-exception
            tb.c.a(r3, r0)     // Catch:{ all -> 0x002f }
            throw r1     // Catch:{ all -> 0x002f }
        L_0x0042:
            com.facebook.react.bridge.Promise r0 = r2.$promise
            r0.reject((java.lang.Throwable) r3)
        L_0x0047:
            kotlin.Unit r3 = kotlin.Unit.f12577a
            return r3
        L_0x004a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.FileAccessModule$readFile$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$readFile$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
