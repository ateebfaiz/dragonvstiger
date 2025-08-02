package androidx.credentials.playservices.controllers.GetSignInIntent;

import androidx.credentials.exceptions.GetCredentialException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderGetSignInIntentController$handleResponse$5 extends n implements Function0<Unit> {
    final /* synthetic */ GetCredentialException $e;
    final /* synthetic */ CredentialProviderGetSignInIntentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderGetSignInIntentController$handleResponse$5(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, GetCredentialException getCredentialException) {
        super(0);
        this.this$0 = credentialProviderGetSignInIntentController;
        this.$e = getCredentialException;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, GetCredentialException getCredentialException) {
        m.f(credentialProviderGetSignInIntentController, "this$0");
        m.f(getCredentialException, "$e");
        credentialProviderGetSignInIntentController.getCallback().onError(getCredentialException);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderGetSignInIntentController$handleResponse$5$$ExternalSyntheticLambda0(this.this$0, this.$e));
    }
}
