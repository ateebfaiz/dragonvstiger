package org.cocos2dx.javascript;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;

@c(c = "org.cocos2dx.javascript.PasskeyManager", f = "PasskeyManager.kt", l = {84}, m = "getSavedCredentials")
final class PasskeyManager$getSavedCredentials$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PasskeyManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PasskeyManager$getSavedCredentials$1(PasskeyManager passkeyManager, d dVar) {
        super(dVar);
        this.this$0 = passkeyManager;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getSavedCredentials((String) null, this);
    }
}
