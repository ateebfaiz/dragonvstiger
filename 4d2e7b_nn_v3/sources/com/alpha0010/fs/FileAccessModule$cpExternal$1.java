package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$cpExternal$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$cpExternal$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $dir;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $source;
    final /* synthetic */ String $targetName;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$cpExternal$1(FileAccessModule fileAccessModule, String str, Promise promise, String str2, String str3, d dVar) {
        super(2, dVar);
        this.this$0 = fileAccessModule;
        this.$source = str;
        this.$promise = promise;
        this.$dir = str2;
        this.$targetName = str3;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$cpExternal$1(this.this$0, this.$source, this.$promise, this.$dir, this.$targetName, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0129, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        tb.c.a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012d, code lost:
        throw r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0101 A[Catch:{ all -> 0x0055, all -> 0x0158 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012e A[Catch:{ all -> 0x0055, all -> 0x0158 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r12) {
        /*
            r11 = this;
            kotlin.coroutines.intrinsics.b.c()
            int r0 = r11.label
            if (r0 != 0) goto L_0x0165
            kotlin.p.b(r12)
            com.alpha0010.fs.FileAccessModule r12 = r11.this$0     // Catch:{ all -> 0x0125 }
            java.lang.String r0 = r11.$source     // Catch:{ all -> 0x0125 }
            java.io.InputStream r12 = r12.openForReading(r0)     // Catch:{ all -> 0x0125 }
            java.lang.String r0 = r11.$dir     // Catch:{ all -> 0x0125 }
            com.alpha0010.fs.FileAccessModule r1 = r11.this$0     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = r11.$targetName     // Catch:{ all -> 0x0125 }
            com.facebook.react.bridge.Promise r3 = r11.$promise     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = "downloads"
            boolean r4 = kotlin.jvm.internal.m.b(r0, r4)     // Catch:{ all -> 0x0055 }
            r5 = 29
            java.lang.String r6 = "_display_name"
            r7 = 0
            if (r4 == 0) goto L_0x006d
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0055 }
            if (r4 < r5) goto L_0x005b
            com.facebook.react.bridge.ReactApplicationContext r4 = r1.getReactApplicationContext()     // Catch:{ all -> 0x0055 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x0055 }
            android.net.Uri r5 = android.provider.MediaStore.Downloads.EXTERNAL_CONTENT_URI     // Catch:{ all -> 0x0055 }
            android.content.ContentValues r8 = new android.content.ContentValues     // Catch:{ all -> 0x0055 }
            r8.<init>()     // Catch:{ all -> 0x0055 }
            r8.put(r6, r2)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0055 }
            android.net.Uri r4 = r4.insert(r5, r8)     // Catch:{ all -> 0x0055 }
            if (r4 == 0) goto L_0x0058
            com.facebook.react.bridge.ReactApplicationContext r1 = r1.getReactApplicationContext()     // Catch:{ all -> 0x0055 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x0055 }
            java.io.OutputStream r1 = r1.openOutputStream(r4)     // Catch:{ all -> 0x0055 }
            goto L_0x010d
        L_0x0055:
            r0 = move-exception
            goto L_0x0157
        L_0x0058:
            r1 = r7
            goto L_0x010d
        L_0x005b:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0055 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ all -> 0x0055 }
            java.io.File r5 = android.os.Environment.getExternalStoragePublicDirectory(r5)     // Catch:{ all -> 0x0055 }
            r4.<init>(r5, r2)     // Catch:{ all -> 0x0055 }
            r1.<init>(r4)     // Catch:{ all -> 0x0055 }
            goto L_0x010d
        L_0x006d:
            int r4 = r0.hashCode()     // Catch:{ all -> 0x0055 }
            r8 = -1185250696(0xffffffffb95a8278, float:-2.0838703E-4)
            if (r4 == r8) goto L_0x00dd
            r8 = 93166550(0x58d9bd6, float:1.3316821E-35)
            if (r4 == r8) goto L_0x00a3
            r5 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r4 == r5) goto L_0x0081
            goto L_0x00e5
        L_0x0081:
            java.lang.String r4 = "video"
            boolean r4 = r0.equals(r4)     // Catch:{ all -> 0x0055 }
            if (r4 != 0) goto L_0x008a
            goto L_0x00e5
        L_0x008a:
            com.facebook.react.bridge.ReactApplicationContext r4 = r1.getReactApplicationContext()     // Catch:{ all -> 0x0055 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x0055 }
            android.net.Uri r5 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch:{ all -> 0x0055 }
            android.content.ContentValues r8 = new android.content.ContentValues     // Catch:{ all -> 0x0055 }
            r8.<init>()     // Catch:{ all -> 0x0055 }
            r8.put(r6, r2)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0055 }
            android.net.Uri r4 = r4.insert(r5, r8)     // Catch:{ all -> 0x0055 }
            goto L_0x00ff
        L_0x00a3:
            java.lang.String r4 = "audio"
            boolean r4 = r0.equals(r4)     // Catch:{ all -> 0x0055 }
            if (r4 != 0) goto L_0x00ac
            goto L_0x00e5
        L_0x00ac:
            com.facebook.react.bridge.ReactApplicationContext r4 = r1.getReactApplicationContext()     // Catch:{ all -> 0x0055 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x0055 }
            android.net.Uri r8 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI     // Catch:{ all -> 0x0055 }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0055 }
            r9.<init>()     // Catch:{ all -> 0x0055 }
            r9.put(r6, r2)     // Catch:{ all -> 0x0055 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0055 }
            if (r6 >= r5) goto L_0x00d6
            java.lang.String r5 = "_data"
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0055 }
            java.lang.String r10 = android.os.Environment.DIRECTORY_MUSIC     // Catch:{ all -> 0x0055 }
            java.io.File r10 = android.os.Environment.getExternalStoragePublicDirectory(r10)     // Catch:{ all -> 0x0055 }
            r6.<init>(r10, r2)     // Catch:{ all -> 0x0055 }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ all -> 0x0055 }
            r9.put(r5, r6)     // Catch:{ all -> 0x0055 }
        L_0x00d6:
            kotlin.Unit r5 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0055 }
            android.net.Uri r4 = r4.insert(r8, r9)     // Catch:{ all -> 0x0055 }
            goto L_0x00ff
        L_0x00dd:
            java.lang.String r4 = "images"
            boolean r4 = r0.equals(r4)     // Catch:{ all -> 0x0055 }
            if (r4 != 0) goto L_0x00e7
        L_0x00e5:
            r4 = r7
            goto L_0x00ff
        L_0x00e7:
            com.facebook.react.bridge.ReactApplicationContext r4 = r1.getReactApplicationContext()     // Catch:{ all -> 0x0055 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x0055 }
            android.net.Uri r5 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ all -> 0x0055 }
            android.content.ContentValues r8 = new android.content.ContentValues     // Catch:{ all -> 0x0055 }
            r8.<init>()     // Catch:{ all -> 0x0055 }
            r8.put(r6, r2)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0055 }
            android.net.Uri r4 = r4.insert(r5, r8)     // Catch:{ all -> 0x0055 }
        L_0x00ff:
            if (r4 == 0) goto L_0x0058
            com.facebook.react.bridge.ReactApplicationContext r1 = r1.getReactApplicationContext()     // Catch:{ all -> 0x0055 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x0055 }
            java.io.OutputStream r1 = r1.openOutputStream(r4)     // Catch:{ all -> 0x0055 }
        L_0x010d:
            if (r1 == 0) goto L_0x012e
            r0 = 0
            r2 = 2
            tb.b.b(r12, r1, r0, r2, r7)     // Catch:{ all -> 0x0118 }
            r3.resolve(r7)     // Catch:{ all -> 0x0118 }
            goto L_0x011c
        L_0x0118:
            r0 = move-exception
            r3.reject((java.lang.Throwable) r0)     // Catch:{ all -> 0x0127 }
        L_0x011c:
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0127 }
            tb.c.a(r1, r7)     // Catch:{ all -> 0x0055 }
            tb.c.a(r12, r7)     // Catch:{ all -> 0x0125 }
            return r0
        L_0x0125:
            r12 = move-exception
            goto L_0x015d
        L_0x0127:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0129 }
        L_0x0129:
            r2 = move-exception
            tb.c.a(r1, r0)     // Catch:{ all -> 0x0055 }
            throw r2     // Catch:{ all -> 0x0055 }
        L_0x012e:
            java.lang.String r1 = "ERR"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r4.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = "Failed to copy to '"
            r4.append(r5)     // Catch:{ all -> 0x0055 }
            r4.append(r2)     // Catch:{ all -> 0x0055 }
            java.lang.String r2 = "' ('"
            r4.append(r2)     // Catch:{ all -> 0x0055 }
            r4.append(r0)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = "')"
            r4.append(r0)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0055 }
            r3.reject((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0055 }
            tb.c.a(r12, r7)     // Catch:{ all -> 0x0125 }
            goto L_0x0162
        L_0x0157:
            throw r0     // Catch:{ all -> 0x0158 }
        L_0x0158:
            r1 = move-exception
            tb.c.a(r12, r0)     // Catch:{ all -> 0x0125 }
            throw r1     // Catch:{ all -> 0x0125 }
        L_0x015d:
            com.facebook.react.bridge.Promise r0 = r11.$promise
            r0.reject((java.lang.Throwable) r12)
        L_0x0162:
            kotlin.Unit r12 = kotlin.Unit.f12577a
            return r12
        L_0x0165:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alpha0010.fs.FileAccessModule$cpExternal$1.n(java.lang.Object):java.lang.Object");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$cpExternal$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
