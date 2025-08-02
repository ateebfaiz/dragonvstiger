package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.p;
import kotlinx.coroutines.b0;
import tb.h;

@c(c = "com.alpha0010.fs.FileAccessModule$mv$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$mv$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $source;
    final /* synthetic */ String $target;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$mv$1(String str, FileAccessModule fileAccessModule, String str2, Promise promise, d dVar) {
        super(2, dVar);
        this.$source = str;
        this.this$0 = fileAccessModule;
        this.$target = str2;
        this.$promise = promise;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$mv$1(this.$source, this.this$0, this.$target, this.$promise, dVar);
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            try {
                if (e.b(this.$source)) {
                    String str = this.$source;
                    ReactApplicationContext access$getReactApplicationContext = this.this$0.getReactApplicationContext();
                    m.e(access$getReactApplicationContext, "access$getReactApplicationContext(...)");
                    if (!e.a(str, access$getReactApplicationContext).renameTo(this.$target)) {
                        Promise promise = this.$promise;
                        String str2 = this.$source;
                        String str3 = this.$target;
                        promise.reject("ERR", "Failed to rename '" + str2 + "' to '" + str3 + "'.");
                        return Unit.f12577a;
                    }
                } else if (!e.d(this.$source).renameTo(e.d(this.$target))) {
                    File d10 = e.d(this.$source);
                    h.l(d10, e.d(this.$target), true, 0, 4, (Object) null);
                    d10.delete();
                }
                this.$promise.resolve((Object) null);
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.f12577a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$mv$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
