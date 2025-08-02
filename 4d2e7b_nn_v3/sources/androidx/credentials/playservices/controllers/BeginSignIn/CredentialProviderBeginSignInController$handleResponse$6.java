package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.exceptions.GetCredentialUnknownException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderBeginSignInController$handleResponse$6 extends n implements Function0<Unit> {
    final /* synthetic */ GetCredentialUnknownException $e;
    final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderBeginSignInController$handleResponse$6(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialUnknownException getCredentialUnknownException) {
        super(0);
        this.this$0 = credentialProviderBeginSignInController;
        this.$e = getCredentialUnknownException;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialUnknownException getCredentialUnknownException) {
        m.f(credentialProviderBeginSignInController, "this$0");
        m.f(getCredentialUnknownException, "$e");
        credentialProviderBeginSignInController.getCallback().onError(getCredentialUnknownException);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$handleResponse$6$$ExternalSyntheticLambda0(this.this$0, this.$e));
    }
}
