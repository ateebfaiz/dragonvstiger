package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$exists$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$exists$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $path;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$exists$1(Promise promise, String str, FileAccessModule fileAccessModule, d dVar) {
        super(2, dVar);
        this.$promise = promise;
        this.$path = str;
        this.this$0 = fileAccessModule;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$exists$1(this.$promise, this.$path, this.this$0, dVar);
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            try {
                Promise promise = this.$promise;
                String str = this.$path;
                ReactApplicationContext access$getReactApplicationContext = this.this$0.getReactApplicationContext();
                m.e(access$getReactApplicationContext, "access$getReactApplicationContext(...)");
                promise.resolve(a.a(e.a(str, access$getReactApplicationContext).exists()));
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.f12577a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$exists$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
