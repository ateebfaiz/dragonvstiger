package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

public final class CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1 extends ResultReceiver {
    final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, Handler handler) {
        super(handler);
        this.this$0 = credentialProviderCreatePublicKeyCredentialController;
    }

    public void onReceiveResult(int i10, Bundle bundle) {
        Executor executor;
        CredentialManagerCallback credentialManagerCallback;
        m.f(bundle, "resultData");
        CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController = this.this$0;
        CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1 credentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1 = new CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1(CredentialProviderBaseController.Companion);
        Executor access$getExecutor$p = this.this$0.executor;
        if (access$getExecutor$p == null) {
            m.u("executor");
            executor = null;
        } else {
            executor = access$getExecutor$p;
        }
        CredentialManagerCallback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p == null) {
            m.u("callback");
            credentialManagerCallback = null;
        } else {
            credentialManagerCallback = access$getCallback$p;
        }
        if (!credentialProviderCreatePublicKeyCredentialController.maybeReportErrorFromResultReceiver(bundle, credentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1, executor, credentialManagerCallback, this.this$0.cancellationSignal)) {
            this.this$0.handleResponse$credentials_play_services_auth_release(bundle.getInt(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG), i10, (Intent) bundle.getParcelable(CredentialProviderBaseController.RESULT_DATA_TAG));
        }
    }
}
