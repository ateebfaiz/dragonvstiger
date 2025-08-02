package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.exceptions.GetCredentialException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderBeginSignInController$handleResponse$5 extends n implements Function0<Unit> {
    final /* synthetic */ GetCredentialException $e;
    final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderBeginSignInController$handleResponse$5(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialException getCredentialException) {
        super(0);
        this.this$0 = credentialProviderBeginSignInController;
        this.$e = getCredentialException;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialException getCredentialException) {
        m.f(credentialProviderBeginSignInController, "this$0");
        m.f(getCredentialException, "$e");
        credentialProviderBeginSignInController.getCallback().onError(getCredentialException);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$handleResponse$5$$ExternalSyntheticLambda0(this.this$0, this.$e));
    }
}
