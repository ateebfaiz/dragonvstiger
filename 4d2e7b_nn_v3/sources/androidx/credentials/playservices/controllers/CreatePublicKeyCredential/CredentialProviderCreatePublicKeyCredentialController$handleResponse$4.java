package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialException;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderCreatePublicKeyCredentialController$handleResponse$4 extends n implements Function0<Unit> {
    final /* synthetic */ CreateCredentialException $exception;
    final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderCreatePublicKeyCredentialController$handleResponse$4(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, CreateCredentialException createCredentialException) {
        super(0);
        this.this$0 = credentialProviderCreatePublicKeyCredentialController;
        this.$exception = createCredentialException;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, CreateCredentialException createCredentialException) {
        m.f(credentialProviderCreatePublicKeyCredentialController, "this$0");
        CredentialManagerCallback access$getCallback$p = credentialProviderCreatePublicKeyCredentialController.callback;
        if (access$getCallback$p == null) {
            m.u("callback");
            access$getCallback$p = null;
        }
        access$getCallback$p.onError(createCredentialException);
    }

    public final void invoke() {
        Executor access$getExecutor$p = this.this$0.executor;
        if (access$getExecutor$p == null) {
            m.u("executor");
            access$getExecutor$p = null;
        }
        access$getExecutor$p.execute(new CredentialProviderCreatePublicKeyCredentialController$handleResponse$4$$ExternalSyntheticLambda0(this.this$0, this.$exception));
    }
}
