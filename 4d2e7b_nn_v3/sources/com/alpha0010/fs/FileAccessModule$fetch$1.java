package com.alpha0010.fs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.p;
import kotlinx.coroutines.b0;
import okhttp3.Call;

@c(c = "com.alpha0010.fs.FileAccessModule$fetch$1", f = "FileAccessModule.kt", l = {268}, m = "invokeSuspend")
final class FileAccessModule$fetch$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ ReadableMap $init;
    final /* synthetic */ double $requestId;
    final /* synthetic */ String $resource;
    int I$0;
    int label;
    final /* synthetic */ FileAccessModule this$0;

    static final class a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileAccessModule f18300a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f18301b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FileAccessModule fileAccessModule, int i10) {
            super(0);
            this.f18300a = fileAccessModule;
            this.f18301b = i10;
        }

        public final void invoke() {
            this.f18300a.fetchCalls.remove(Integer.valueOf(this.f18301b));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileAccessModule$fetch$1(double d10, FileAccessModule fileAccessModule, String str, ReadableMap readableMap, d dVar) {
        super(2, dVar);
        this.$requestId = d10;
        this.this$0 = fileAccessModule;
        this.$resource = str;
        this.$init = readableMap;
    }

    public final d k(Object obj, d dVar) {
        return new FileAccessModule$fetch$1(this.$requestId, this.this$0, this.$resource, this.$init, dVar);
    }

    public final Object n(Object obj) {
        int i10;
        Object c10 = b.c();
        int i11 = this.label;
        if (i11 == 0) {
            p.b(obj);
            int i12 = (int) this.$requestId;
            ReactApplicationContext access$getReactApplicationContext = this.this$0.getReactApplicationContext();
            m.e(access$getReactApplicationContext, "access$getReactApplicationContext(...)");
            NetworkHandler networkHandler = new NetworkHandler(access$getReactApplicationContext);
            String str = this.$resource;
            ReadableMap readableMap = this.$init;
            a aVar = new a(this.this$0, i12);
            this.I$0 = i12;
            this.label = 1;
            Object e10 = networkHandler.e(i12, str, readableMap, aVar, this);
            if (e10 == c10) {
                return c10;
            }
            i10 = i12;
            obj = e10;
        } else if (i11 == 1) {
            i10 = this.I$0;
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Call call = (Call) obj;
        if (call != null) {
            FileAccessModule fileAccessModule = this.this$0;
            fileAccessModule.fetchCalls.put(kotlin.coroutines.jvm.internal.a.b(i10), new WeakReference(call));
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FileAccessModule$fetch$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
