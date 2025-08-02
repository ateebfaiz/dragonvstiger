package com.alpha0010.fs;

import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.facebook.react.bridge.Promise;
import java.io.File;
import java.io.IOException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$mkdir$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$mkdir$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $path;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$mkdir$1(String str, FileAccessModule fileAccessModule, Promise promise, d dVar) {
        super(2, dVar);
        this.$path = str;
        this.this$0 = fileAccessModule;
        this.$promise = promise;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$mkdir$1(this.$path, this.this$0, this.$promise, dVar);
    }

    public final Object n(Object obj) {
        DocumentFile createDirectory;
        b.c();
        if (this.label == 0) {
            p.b(obj);
            try {
                if (e.b(this.$path)) {
                    Pair e10 = e.e(this.$path);
                    String str = (String) e10.b();
                    DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this.this$0.getReactApplicationContext(), (Uri) e10.a());
                    if (fromTreeUri == null || (createDirectory = fromTreeUri.createDirectory(str)) == null) {
                        String str2 = this.$path;
                        throw new IOException("Failed to create directory '" + str2 + "'.");
                    }
                    this.$promise.resolve(createDirectory.getUri().toString());
                    return Unit.f12577a;
                }
                File d10 = e.d(this.$path);
                if (d10.exists()) {
                    Promise promise = this.$promise;
                    String str3 = this.$path;
                    promise.reject("EEXIST", "'" + str3 + "' already exists.");
                } else if (d10.mkdirs()) {
                    this.$promise.resolve(d10.getCanonicalPath());
                } else {
                    Promise promise2 = this.$promise;
                    String str4 = this.$path;
                    promise2.reject("EPERM", "Failed to create directory '" + str4 + "'.");
                }
                return Unit.f12577a;
            } catch (Throwable th) {
                this.$promise.reject(th);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$mkdir$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
