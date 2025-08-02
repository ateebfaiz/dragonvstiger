package org.cocos2dx.javascript;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "org.cocos2dx.javascript.PasskeyManager", f = "PasskeyManager.kt", l = {69}, m = "createPasskey")
final class PasskeyManager$createPasskey$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PasskeyManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PasskeyManager$createPasskey$1(PasskeyManager passkeyManager, d dVar) {
        super(dVar);
        this.this$0 = passkeyManager;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createPasskey((String) null, this);
    }
}
