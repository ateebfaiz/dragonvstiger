package androidx.credentials.playservices.controllers.GetSignInIntent;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderGetSignInIntentController$invokePlayServices$1 extends n implements Function0<Unit> {
    final /* synthetic */ Exception $e;
    final /* synthetic */ CredentialProviderGetSignInIntentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderGetSignInIntentController$invokePlayServices$1(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, Exception exc) {
        super(0);
        this.this$0 = credentialProviderGetSignInIntentController;
        this.$e = exc;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, Exception exc) {
        m.f(credentialProviderGetSignInIntentController, "this$0");
        m.f(exc, "$e");
        credentialProviderGetSignInIntentController.getCallback().onError(exc);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderGetSignInIntentController$invokePlayServices$1$$ExternalSyntheticLambda0(this.this$0, this.$e));
    }
}
