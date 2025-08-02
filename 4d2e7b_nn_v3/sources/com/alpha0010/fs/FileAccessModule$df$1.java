package com.alpha0010.fs;

import android.os.StatFs;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import java.io.File;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.i0;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlin.t;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$df$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$df$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$df$1(FileAccessModule fileAccessModule, Promise promise, d dVar) {
        super(2, dVar);
        this.this$0 = fileAccessModule;
        this.$promise = promise;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$df$1(this.this$0, this.$promise, dVar);
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            try {
                StatFs statFs = new StatFs(this.this$0.getReactApplicationContext().getFilesDir().getAbsolutePath());
                Map j10 = i0.j(t.a("internal_free", a.c(statFs.getAvailableBytes())), t.a("internal_total", a.c(statFs.getTotalBytes())));
                File externalFilesDir = this.this$0.getReactApplicationContext().getExternalFilesDir((String) null);
                if (externalFilesDir != null) {
                    StatFs statFs2 = new StatFs(externalFilesDir.getAbsolutePath());
                    j10.put("external_free", a.c(statFs2.getAvailableBytes()));
                    j10.put("external_total", a.c(statFs2.getTotalBytes()));
                }
                this.$promise.resolve(Arguments.makeNativeMap((Map<String, Object>) j10));
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.f12577a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$df$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
