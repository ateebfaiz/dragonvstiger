package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$concatFiles$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$concatFiles$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $source;
    final /* synthetic */ String $target;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$concatFiles$1(FileAccessModule fileAccessModule, String str, Promise promise, String str2, d dVar) {
        super(2, dVar);
        this.this$0 = fileAccessModule;
        this.$source = str;
        this.$promise = promise;
        this.$target = str2;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$concatFiles$1(this.this$0, this.$source, this.$promise, this.$target, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        tb.c.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        tb.c.a(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0048, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.b.c()
            int r0 = r7.label
            if (r0 != 0) goto L_0x0051
            kotlin.p.b(r8)
            com.alpha0010.fs.FileAccessModule r8 = r7.this$0     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = r7.$source     // Catch:{ all -> 0x0038 }
            java.io.InputStream r8 = r8.openForReading(r0)     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = r7.$target     // Catch:{ all -> 0x0038 }
            com.facebook.react.bridge.Promise r1 = r7.$promise     // Catch:{ all -> 0x0038 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x003a }
            java.io.File r0 = com.alpha0010.fs.e.d(r0)     // Catch:{ all -> 0x003a }
            r3 = 1
            r2.<init>(r0, r3)     // Catch:{ all -> 0x003a }
            r0 = 0
            r3 = 2
            r4 = 0
            long r5 = tb.b.b(r8, r2, r0, r3, r4)     // Catch:{ all -> 0x003c }
            int r0 = (int) r5     // Catch:{ all -> 0x003c }
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.a.b(r0)     // Catch:{ all -> 0x003c }
            r1.resolve(r0)     // Catch:{ all -> 0x003c }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x003c }
            tb.c.a(r2, r4)     // Catch:{ all -> 0x003a }
            tb.c.a(r8, r4)     // Catch:{ all -> 0x0038 }
            goto L_0x004e
        L_0x0038:
            r8 = move-exception
            goto L_0x0049
        L_0x003a:
            r0 = move-exception
            goto L_0x0043
        L_0x003c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003e }
        L_0x003e:
            r1 = move-exception
            tb.c.a(r2, r0)     // Catch:{ all -> 0x003a }
            throw r1     // Catch:{ all -> 0x003a }
        L_0x0043:
            throw r0     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r1 = move-exception
            tb.c.a(r8, r0)     // Catch:{ all -> 0x0038 }
            throw r1     // Catch:{ all -> 0x0038 }
        L_0x0049:
            com.facebook.react.bridge.Promise r0 = r7.$promise
            r0.reject((java.lang.Throwable) r8)
        L_0x004e:
            kotlin.Unit r8 = kotlin.Unit.f12577a
            return r8
        L_0x0051:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.FileAccessModule$concatFiles$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$concatFiles$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
