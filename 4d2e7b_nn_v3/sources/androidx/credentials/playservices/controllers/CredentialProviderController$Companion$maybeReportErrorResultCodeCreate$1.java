package androidx.credentials.playservices.controllers;

import androidx.credentials.exceptions.CreateCredentialException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.y;

final class CredentialProviderController$Companion$maybeReportErrorResultCodeCreate$1 extends n implements Function0<Unit> {
    final /* synthetic */ y $exception;
    final /* synthetic */ Function1<CreateCredentialException, Unit> $onError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderController$Companion$maybeReportErrorResultCodeCreate$1(Function1<? super CreateCredentialException, Unit> function1, y yVar) {
        super(0);
        this.$onError = function1;
        this.$exception = yVar;
    }

    public final void invoke() {
        this.$onError.invoke(this.$exception.f725a);
    }
}
