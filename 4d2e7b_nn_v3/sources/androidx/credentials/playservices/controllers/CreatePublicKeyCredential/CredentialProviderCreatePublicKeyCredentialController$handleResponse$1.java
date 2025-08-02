package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.os.CancellationSignal;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderCreatePublicKeyCredentialController$handleResponse$1 extends n implements Function2<CancellationSignal, Function0<? extends Unit>, Unit> {
    public static final CredentialProviderCreatePublicKeyCredentialController$handleResponse$1 INSTANCE = new CredentialProviderCreatePublicKeyCredentialController$handleResponse$1();

    CredentialProviderCreatePublicKeyCredentialController$handleResponse$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CancellationSignal) obj, (Function0<Unit>) (Function0) obj2);
        return Unit.f12577a;
    }

    public final void invoke(CancellationSignal cancellationSignal, Function0<Unit> function0) {
        m.f(function0, "f");
        CredentialProviderController.Companion companion = CredentialProviderController.Companion;
        CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal, function0);
    }
}
