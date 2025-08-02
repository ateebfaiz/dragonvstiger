package androidx.credentials.playservices;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class HiddenActivity$handleCreatePublicKeyCredential$1$1 extends n implements Function1<PendingIntent, Unit> {
    final /* synthetic */ int $requestCode;
    final /* synthetic */ HiddenActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HiddenActivity$handleCreatePublicKeyCredential$1$1(HiddenActivity hiddenActivity, int i10) {
        super(1);
        this.this$0 = hiddenActivity;
        this.$requestCode = i10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PendingIntent) obj);
        return Unit.f12577a;
    }

    public final void invoke(PendingIntent pendingIntent) {
        m.f(pendingIntent, DbParams.KEY_CHANNEL_RESULT);
        try {
            this.this$0.mWaitingForActivityResult = true;
            this.this$0.startIntentSenderForResult(pendingIntent.getIntentSender(), this.$requestCode, (Intent) null, 0, 0, 0, (Bundle) null);
        } catch (IntentSender.SendIntentException e10) {
            HiddenActivity hiddenActivity = this.this$0;
            ResultReceiver access$getResultReceiver$p = hiddenActivity.resultReceiver;
            m.c(access$getResultReceiver$p);
            hiddenActivity.setupFailure(access$getResultReceiver$p, CredentialProviderBaseController.CREATE_UNKNOWN, "During public key credential, found IntentSender failure on public key creation: " + e10.getMessage());
        }
    }
}
