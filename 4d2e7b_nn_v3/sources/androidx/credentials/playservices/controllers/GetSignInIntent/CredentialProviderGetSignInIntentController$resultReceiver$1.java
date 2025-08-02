package androidx.credentials.playservices.controllers.GetSignInIntent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import kotlin.jvm.internal.m;

public final class CredentialProviderGetSignInIntentController$resultReceiver$1 extends ResultReceiver {
    final /* synthetic */ CredentialProviderGetSignInIntentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderGetSignInIntentController$resultReceiver$1(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, Handler handler) {
        super(handler);
        this.this$0 = credentialProviderGetSignInIntentController;
    }

    public void onReceiveResult(int i10, Bundle bundle) {
        m.f(bundle, "resultData");
        if (!this.this$0.maybeReportErrorFromResultReceiver(bundle, new CredentialProviderGetSignInIntentController$resultReceiver$1$onReceiveResult$1(CredentialProviderBaseController.Companion), this.this$0.getExecutor(), this.this$0.getCallback(), this.this$0.cancellationSignal)) {
            this.this$0.handleResponse$credentials_play_services_auth_release(bundle.getInt(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG), i10, (Intent) bundle.getParcelable(CredentialProviderBaseController.RESULT_DATA_TAG));
        }
    }
}
