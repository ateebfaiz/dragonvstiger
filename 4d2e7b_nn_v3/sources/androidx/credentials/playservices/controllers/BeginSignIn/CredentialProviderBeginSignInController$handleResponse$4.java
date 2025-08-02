package androidx.credentials.playservices.controllers.BeginSignIn;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.y;

final class CredentialProviderBeginSignInController$handleResponse$4 extends n implements Function0<Unit> {
    final /* synthetic */ y $exception;
    final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderBeginSignInController$handleResponse$4(CredentialProviderBeginSignInController credentialProviderBeginSignInController, y yVar) {
        super(0);
        this.this$0 = credentialProviderBeginSignInController;
        this.$exception = yVar;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController, y yVar) {
        m.f(credentialProviderBeginSignInController, "this$0");
        m.f(yVar, "$exception");
        credentialProviderBeginSignInController.getCallback().onError(yVar.f725a);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$handleResponse$4$$ExternalSyntheticLambda0(this.this$0, this.$exception));
    }
}
