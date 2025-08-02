package org.cocos2dx.javascript;

import com.facebook.react.bridge.Callback;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "org.cocos2dx.javascript.PasskeyManager$signIn$1", f = "PasskeyManager.kt", l = {57}, m = "invokeSuspend")
final class PasskeyManager$signIn$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Callback $callback;
    final /* synthetic */ String $challenge;
    final /* synthetic */ String $rpId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PasskeyManager$signIn$1(String str, String str2, Callback callback, d dVar) {
        super(2, dVar);
        this.$rpId = str;
        this.$challenge = str2;
        this.$callback = callback;
    }

    public final d k(Object obj, d dVar) {
        return new PasskeyManager$signIn$1(this.$rpId, this.$challenge, this.$callback, dVar);
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            PasskeyManager passkeyManager = PasskeyManager.INSTANCE;
            String access$fetchAuthJsonFromServer = passkeyManager.fetchAuthJsonFromServer(this.$rpId, this.$challenge);
            this.label = 1;
            obj = passkeyManager.getSavedCredentials(access$fetchAuthJsonFromServer, this);
            if (obj == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        kotlin.jvm.internal.b0 b0Var = kotlin.jvm.internal.b0.f709a;
        String format = String.format("window['G']?.PlatformUtils?.signInResult(%d,  `%s`);", Arrays.copyOf(new Object[]{pair.c(), pair.d()}, 2));
        m.e(format, "format(...)");
        PlatformUtils.callJSMethod(format);
        Callback callback = this.$callback;
        if (callback != null) {
            callback.invoke(pair.c(), pair.d());
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((PasskeyManager$signIn$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
