package androidx.credentials.playservices.controllers.GetSignInIntent;

import androidx.credentials.exceptions.GetCredentialUnknownException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderGetSignInIntentController$handleResponse$6 extends n implements Function0<Unit> {
    final /* synthetic */ GetCredentialUnknownException $e;
    final /* synthetic */ CredentialProviderGetSignInIntentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderGetSignInIntentController$handleResponse$6(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, GetCredentialUnknownException getCredentialUnknownException) {
        super(0);
        this.this$0 = credentialProviderGetSignInIntentController;
        this.$e = getCredentialUnknownException;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, GetCredentialUnknownException getCredentialUnknownException) {
        m.f(credentialProviderGetSignInIntentController, "this$0");
        m.f(getCredentialUnknownException, "$e");
        credentialProviderGetSignInIntentController.getCallback().onError(getCredentialUnknownException);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderGetSignInIntentController$handleResponse$6$$ExternalSyntheticLambda0(this.this$0, this.$e));
    }
}
