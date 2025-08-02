package androidx.credentials.playservices.controllers.GetSignInIntent;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.y;

final class CredentialProviderGetSignInIntentController$handleResponse$4 extends n implements Function0<Unit> {
    final /* synthetic */ y $exception;
    final /* synthetic */ CredentialProviderGetSignInIntentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderGetSignInIntentController$handleResponse$4(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, y yVar) {
        super(0);
        this.this$0 = credentialProviderGetSignInIntentController;
        this.$exception = yVar;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, y yVar) {
        m.f(credentialProviderGetSignInIntentController, "this$0");
        m.f(yVar, "$exception");
        credentialProviderGetSignInIntentController.getCallback().onError(yVar.f725a);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderGetSignInIntentController$handleResponse$4$$ExternalSyntheticLambda0(this.this$0, this.$exception));
    }
}
