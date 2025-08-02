package com.alpha0010.fs;

import com.facebook.react.bridge.Promise;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.j;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "com.alpha0010.fs.FileAccessModule$hash$1", f = "FileAccessModule.kt", l = {}, m = "invokeSuspend")
final class FileAccessModule$hash$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ String $algorithm;
    final /* synthetic */ String $path;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18302a = new a();

        a() {
            super(1);
        }

        public final CharSequence a(byte b10) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
            m.e(format, "format(...)");
            return format;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).byteValue());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$hash$1(String str, FileAccessModule fileAccessModule, String str2, Promise promise, d dVar) {
        super(2, dVar);
        this.$algorithm = str;
        this.this$0 = fileAccessModule;
        this.$path = str2;
        this.$promise = promise;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$hash$1(this.$algorithm, this.this$0, this.$path, this.$promise, dVar);
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label == 0) {
            p.b(obj);
            try {
                MessageDigest instance = MessageDigest.getInstance(this.$algorithm);
                InputStream access$openForReading = this.this$0.openForReading(this.$path);
                try {
                    byte[] bArr = new byte[8192];
                    for (int read = access$openForReading.read(bArr); read >= 0; read = access$openForReading.read(bArr)) {
                        instance.update(bArr, 0, read);
                    }
                    Unit unit = Unit.f12577a;
                    tb.c.a(access$openForReading, (Throwable) null);
                    Promise promise = this.$promise;
                    byte[] digest = instance.digest();
                    m.e(digest, "digest(...)");
                    promise.resolve(j.L(digest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.f18302a, 30, (Object) null));
                } catch (Throwable th) {
                    tb.c.a(access$openForReading, th);
                    throw th;
                }
            } catch (Throwable th2) {
                this.$promise.reject(th2);
            }
            return Unit.f12577a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$hash$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
