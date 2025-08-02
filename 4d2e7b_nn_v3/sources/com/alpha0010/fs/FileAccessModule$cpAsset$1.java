package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$cpAsset$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$cpAsset$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $asset;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $target;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$cpAsset$1(String str, FileAccessModule fileAccessModule, String str2, Promise promise, String str3, d dVar) {
        super(2, dVar);
        this.$type = str;
        this.this$0 = fileAccessModule;
        this.$asset = str2;
        this.$promise = promise;
        this.$target = str3;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$cpAsset$1(this.$type, this.this$0, this.$asset, this.$promise, this.$target, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0070, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        tb.c.a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0076, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        tb.c.a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.b.c()
            int r0 = r4.label
            if (r0 != 0) goto L_0x0083
            kotlin.p.b(r5)
            java.lang.String r5 = r4.$type     // Catch:{ all -> 0x003e }
            java.lang.String r0 = "resource"
            boolean r5 = kotlin.jvm.internal.m.b(r5, r0)     // Catch:{ all -> 0x003e }
            r0 = 0
            if (r5 == 0) goto L_0x0040
            com.alpha0010.fs.FileAccessModule r5 = r4.this$0     // Catch:{ all -> 0x003e }
            com.facebook.react.bridge.ReactApplicationContext r5 = r5.getReactApplicationContext()     // Catch:{ all -> 0x003e }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ all -> 0x003e }
            java.lang.String r1 = r4.$asset     // Catch:{ all -> 0x003e }
            com.alpha0010.fs.FileAccessModule r2 = r4.this$0     // Catch:{ all -> 0x003e }
            com.facebook.react.bridge.ReactApplicationContext r2 = r2.getReactApplicationContext()     // Catch:{ all -> 0x003e }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x003e }
            int r5 = r5.getIdentifier(r1, r0, r2)     // Catch:{ all -> 0x003e }
            com.alpha0010.fs.FileAccessModule r1 = r4.this$0     // Catch:{ all -> 0x003e }
            com.facebook.react.bridge.ReactApplicationContext r1 = r1.getReactApplicationContext()     // Catch:{ all -> 0x003e }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ all -> 0x003e }
            java.io.InputStream r5 = r1.openRawResource(r5)     // Catch:{ all -> 0x003e }
            goto L_0x0050
        L_0x003e:
            r5 = move-exception
            goto L_0x007b
        L_0x0040:
            com.alpha0010.fs.FileAccessModule r5 = r4.this$0     // Catch:{ all -> 0x003e }
            com.facebook.react.bridge.ReactApplicationContext r5 = r5.getReactApplicationContext()     // Catch:{ all -> 0x003e }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ all -> 0x003e }
            java.lang.String r1 = r4.$asset     // Catch:{ all -> 0x003e }
            java.io.InputStream r5 = r5.open(r1)     // Catch:{ all -> 0x003e }
        L_0x0050:
            com.alpha0010.fs.FileAccessModule r1 = r4.this$0     // Catch:{ all -> 0x003e }
            java.lang.String r2 = r4.$target     // Catch:{ all -> 0x003e }
            java.io.OutputStream r1 = r1.openForWriting(r2)     // Catch:{ all -> 0x006c }
            kotlin.jvm.internal.m.c(r5)     // Catch:{ all -> 0x006e }
            r2 = 0
            r3 = 2
            tb.b.b(r5, r1, r2, r3, r0)     // Catch:{ all -> 0x006e }
            tb.c.a(r1, r0)     // Catch:{ all -> 0x006c }
            tb.c.a(r5, r0)     // Catch:{ all -> 0x003e }
            com.facebook.react.bridge.Promise r5 = r4.$promise     // Catch:{ all -> 0x003e }
            r5.resolve(r0)     // Catch:{ all -> 0x003e }
            goto L_0x0080
        L_0x006c:
            r0 = move-exception
            goto L_0x0075
        L_0x006e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r2 = move-exception
            tb.c.a(r1, r0)     // Catch:{ all -> 0x006c }
            throw r2     // Catch:{ all -> 0x006c }
        L_0x0075:
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r1 = move-exception
            tb.c.a(r5, r0)     // Catch:{ all -> 0x003e }
            throw r1     // Catch:{ all -> 0x003e }
        L_0x007b:
            com.facebook.react.bridge.Promise r0 = r4.$promise
            r0.reject((java.lang.Throwable) r5)
        L_0x0080:
            kotlin.Unit r5 = kotlin.Unit.f12577a
            return r5
        L_0x0083:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.FileAccessModule$cpAsset$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$cpAsset$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
