package com.alpha0010.fs;

import androidx.documentfile.provider.DocumentFile;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$statDir$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$statDir$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $path;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$statDir$1(String str, FileAccessModule fileAccessModule, Promise promise, d dVar) {
        super(2, dVar);
        this.$path = str;
        this.this$0 = fileAccessModule;
        this.$promise = promise;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$statDir$1(this.$path, this.this$0, this.$promise, dVar);
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            try {
                WritableArray createArray = Arguments.createArray();
                String str = this.$path;
                ReactApplicationContext access$getReactApplicationContext = this.this$0.getReactApplicationContext();
                m.e(access$getReactApplicationContext, "access$getReactApplicationContext(...)");
                DocumentFile[] listFiles = e.a(str, access$getReactApplicationContext).listFiles();
                m.e(listFiles, "listFiles(...)");
                FileAccessModule fileAccessModule = this.this$0;
                for (DocumentFile documentFile : listFiles) {
                    m.c(documentFile);
                    createArray.pushMap(fileAccessModule.statFile(documentFile));
                }
                this.$promise.resolve(createArray);
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
            return Unit.f12577a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$statDir$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
