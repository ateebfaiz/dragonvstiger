package com.alpha0010.fs;

import android.util.Base64;
import com.facebook.react.bridge.Promise;
import java.io.File;
import java.nio.charset.Charset;
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

@c(c = "com.alpha0010.fs.FileAccessModule$appendFile$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$appendFile$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $data;
    final /* synthetic */ String $encoding;
    final /* synthetic */ String $path;
    final /* synthetic */ Promise $promise;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$appendFile$1(String str, String str2, String str3, Promise promise, d dVar) {
        super(2, dVar);
        this.$encoding = str;
        this.$path = str2;
        this.$data = str3;
        this.$promise = promise;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$appendFile$1(this.$encoding, this.$path, this.$data, this.$promise, dVar);
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            try {
                if (m.b(this.$encoding, "base64")) {
                    File d10 = e.d(this.$path);
                    byte[] decode = Base64.decode(this.$data, 0);
                    m.e(decode, "decode(...)");
                    h.a(d10, decode);
                } else {
                    h.c(e.d(this.$path), this.$data, (Charset) null, 2, (Object) null);
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
        return ((FileAccessModule$appendFile$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
