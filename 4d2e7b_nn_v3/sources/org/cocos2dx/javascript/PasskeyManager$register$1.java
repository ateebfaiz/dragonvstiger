package org.cocos2dx.javascript;

import android.util.Log;
import androidx.credentials.CreatePublicKeyCredentialResponse;
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

@c(c = "org.cocos2dx.javascript.PasskeyManager$register$1", f = "PasskeyManager.kt", l = {40}, m = "invokeSuspend")
final class PasskeyManager$register$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Callback $callback;
    final /* synthetic */ String $challenge;
    final /* synthetic */ String $rpId;
    final /* synthetic */ String $userId;
    final /* synthetic */ String $userName;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PasskeyManager$register$1(String str, String str2, String str3, String str4, Callback callback, d dVar) {
        super(2, dVar);
        this.$userName = str;
        this.$rpId = str2;
        this.$challenge = str3;
        this.$userId = str4;
        this.$callback = callback;
    }

    public final d k(Object obj, d dVar) {
        return new PasskeyManager$register$1(this.$userName, this.$rpId, this.$challenge, this.$userId, this.$callback, dVar);
    }

    public final Object n(Object obj) {
        String str;
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            PasskeyManager passkeyManager = PasskeyManager.INSTANCE;
            String access$fetchRegistrationJsonFromServer = passkeyManager.fetchRegistrationJsonFromServer(this.$userName, this.$rpId, this.$challenge, this.$userId);
            this.label = 1;
            obj = passkeyManager.createPasskey(access$fetchRegistrationJsonFromServer, this);
            if (obj == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        Log.e("PasskeyManager", "register: " + pair.c() + "--" + pair.d());
        kotlin.jvm.internal.b0 b0Var = kotlin.jvm.internal.b0.f709a;
        Object c11 = pair.c();
        CreatePublicKeyCredentialResponse createPublicKeyCredentialResponse = (CreatePublicKeyCredentialResponse) pair.d();
        String str2 = null;
        if (createPublicKeyCredentialResponse != null) {
            str = createPublicKeyCredentialResponse.getRegistrationResponseJson();
        } else {
            str = null;
        }
        String format = String.format("window['G']?.PlatformUtils?.registerResult(%d,  `%s`);", Arrays.copyOf(new Object[]{c11, str}, 2));
        m.e(format, "format(...)");
        PlatformUtils.callJSMethod(format);
        Callback callback = this.$callback;
        if (callback != null) {
            Object c12 = pair.c();
            CreatePublicKeyCredentialResponse createPublicKeyCredentialResponse2 = (CreatePublicKeyCredentialResponse) pair.d();
            if (createPublicKeyCredentialResponse2 != null) {
                str2 = createPublicKeyCredentialResponse2.getRegistrationResponseJson();
            }
            callback.invoke(c12, str2);
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((PasskeyManager$register$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
