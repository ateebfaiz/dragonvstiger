package com.alpha0010.fs;

import com.facebook.react.bridge.ReadableMap;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function0;

@c(c = "com.alpha0010.fs.NetworkHandler", f = "NetworkHandler.kt", l = {50}, m = "fetch")
final class NetworkHandler$fetch$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkHandler$fetch$1(NetworkHandler networkHandler, d dVar) {
        super(dVar);
        this.this$0 = networkHandler;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(0, (String) null, (ReadableMap) null, (Function0) null, this);
    }
}
