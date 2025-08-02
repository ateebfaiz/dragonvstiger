package com.alpha0010.fs;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import vb.n;

@c(c = "com.alpha0010.fs.NetworkHandler", f = "NetworkHandler.kt", l = {176}, m = "getClient")
final class NetworkHandler$getClient$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkHandler$getClient$1(NetworkHandler networkHandler, d dVar) {
        super(dVar);
        this.this$0 = networkHandler;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(false, (n) null, this);
    }
}
