package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$cp$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$cp$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $source;
    final /* synthetic */ String $target;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$cp$1(FileAccessModule fileAccessModule, String str, Promise promise, String str2, d dVar) {
        super(2, dVar);
        this.this$0 = fileAccessModule;
        this.$source = str;
        this.$promise = promise;
        this.$target = str2;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$cp$1(this.this$0, this.$source, this.$promise, this.$target, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        tb.c.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0038, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        tb.c.a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003c, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.b.c()
            int r0 = r4.label
            if (r0 != 0) goto L_0x0045
            kotlin.p.b(r5)
            com.alpha0010.fs.FileAccessModule r5 = r4.this$0     // Catch:{ all -> 0x002c }
            java.lang.String r0 = r4.$source     // Catch:{ all -> 0x002c }
            java.io.InputStream r5 = r5.openForReading(r0)     // Catch:{ all -> 0x002c }
            com.alpha0010.fs.FileAccessModule r0 = r4.this$0     // Catch:{ all -> 0x002c }
            java.lang.String r1 = r4.$target     // Catch:{ all -> 0x002c }
            java.io.OutputStream r0 = r0.openForWriting(r1)     // Catch:{ all -> 0x002e }
            r1 = 0
            r2 = 2
            r3 = 0
            tb.b.b(r5, r0, r1, r2, r3)     // Catch:{ all -> 0x0030 }
            tb.c.a(r0, r3)     // Catch:{ all -> 0x002e }
            tb.c.a(r5, r3)     // Catch:{ all -> 0x002c }
            com.facebook.react.bridge.Promise r5 = r4.$promise     // Catch:{ all -> 0x002c }
            r5.resolve(r3)     // Catch:{ all -> 0x002c }
            goto L_0x0042
        L_0x002c:
            r5 = move-exception
            goto L_0x003d
        L_0x002e:
            r0 = move-exception
            goto L_0x0037
        L_0x0030:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r2 = move-exception
            tb.c.a(r0, r1)     // Catch:{ all -> 0x002e }
            throw r2     // Catch:{ all -> 0x002e }
        L_0x0037:
            throw r0     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r1 = move-exception
            tb.c.a(r5, r0)     // Catch:{ all -> 0x002c }
            throw r1     // Catch:{ all -> 0x002c }
        L_0x003d:
            com.facebook.react.bridge.Promise r0 = r4.$promise
            r0.reject((java.lang.Throwable) r5)
        L_0x0042:
            kotlin.Unit r5 = kotlin.Unit.f12577a
            return r5
        L_0x0045:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.FileAccessModule$cp$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$cp$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
