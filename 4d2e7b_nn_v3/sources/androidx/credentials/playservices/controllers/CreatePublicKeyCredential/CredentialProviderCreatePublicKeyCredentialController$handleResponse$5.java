package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CredentialManagerCallback;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderCreatePublicKeyCredentialController$handleResponse$5 extends n implements Function0<Unit> {
    final /* synthetic */ CreateCredentialResponse $response;
    final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderCreatePublicKeyCredentialController$handleResponse$5(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, CreateCredentialResponse createCredentialResponse) {
        super(0);
        this.this$0 = credentialProviderCreatePublicKeyCredentialController;
        this.$response = createCredentialResponse;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, CreateCredentialResponse createCredentialResponse) {
        m.f(credentialProviderCreatePublicKeyCredentialController, "this$0");
        m.f(createCredentialResponse, "$response");
        CredentialManagerCallback access$getCallback$p = credentialProviderCreatePublicKeyCredentialController.callback;
        if (access$getCallback$p == null) {
            m.u("callback");
            access$getCallback$p = null;
        }
        access$getCallback$p.onResult(createCredentialResponse);
    }

    public final void invoke() {
        Executor access$getExecutor$p = this.this$0.executor;
        if (access$getExecutor$p == null) {
            m.u("executor");
            access$getExecutor$p = null;
        }
        access$getExecutor$p.execute(new CredentialProviderCreatePublicKeyCredentialController$handleResponse$5$$ExternalSyntheticLambda0(this.this$0, this.$response));
    }
}
