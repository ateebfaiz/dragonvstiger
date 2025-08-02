package androidx.credentials.playservices.controllers;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;

public abstract class CredentialProviderController<T1, T2, R2, R1, E1> extends CredentialProviderBaseController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_MESSAGE_START_ACTIVITY_FAILED = "Failed to launch the selector UI. Hint: ensure the `context` parameter is an Activity-based context.";
    private final Context context;

    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: protected */
        public final void cancelOrCallbackExceptionOrResult(CancellationSignal cancellationSignal, Function0<Unit> function0) {
            m.f(function0, "onResultOrException");
            if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
                function0.invoke();
            }
        }

        public final String generateErrorStringCanceled$credentials_play_services_auth_release() {
            return "activity is cancelled by the user.";
        }

        public final String generateErrorStringUnknown$credentials_play_services_auth_release(int i10) {
            return "activity with result code: " + i10 + " indicating not RESULT_OK";
        }

        /* access modifiers changed from: protected */
        public final boolean maybeReportErrorResultCodeCreate(int i10, Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> function2, Function1<? super CreateCredentialException, Unit> function1, CancellationSignal cancellationSignal) {
            m.f(function2, "cancelOnError");
            m.f(function1, "onError");
            if (i10 == -1) {
                return false;
            }
            y yVar = new y();
            yVar.f725a = new CreateCredentialUnknownException(generateErrorStringUnknown$credentials_play_services_auth_release(i10));
            if (i10 == 0) {
                yVar.f725a = new CreateCredentialCancellationException(generateErrorStringCanceled$credentials_play_services_auth_release());
            }
            function2.invoke(cancellationSignal, new CredentialProviderController$Companion$maybeReportErrorResultCodeCreate$1(function1, yVar));
            return true;
        }

        /* access modifiers changed from: protected */
        public final boolean maybeReportErrorResultCodeGet(int i10, Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> function2, Function1<? super GetCredentialException, Unit> function1, CancellationSignal cancellationSignal) {
            m.f(function2, "cancelOnError");
            m.f(function1, "onError");
            if (i10 == -1) {
                return false;
            }
            y yVar = new y();
            yVar.f725a = new GetCredentialUnknownException(generateErrorStringUnknown$credentials_play_services_auth_release(i10));
            if (i10 == 0) {
                yVar.f725a = new GetCredentialCancellationException(generateErrorStringCanceled$credentials_play_services_auth_release());
            }
            function2.invoke(cancellationSignal, new CredentialProviderController$Companion$maybeReportErrorResultCodeGet$1(function1, yVar));
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderController(Context context2) {
        super(context2);
        m.f(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public static final void cancelOrCallbackExceptionOrResult(CancellationSignal cancellationSignal, Function0<Unit> function0) {
        Companion.cancelOrCallbackExceptionOrResult(cancellationSignal, function0);
    }

    protected static final boolean maybeReportErrorResultCodeCreate(int i10, Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> function2, Function1<? super CreateCredentialException, Unit> function1, CancellationSignal cancellationSignal) {
        return Companion.maybeReportErrorResultCodeCreate(i10, function2, function1, cancellationSignal);
    }

    protected static final boolean maybeReportErrorResultCodeGet(int i10, Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> function2, Function1<? super GetCredentialException, Unit> function1, CancellationSignal cancellationSignal) {
        return Companion.maybeReportErrorResultCodeGet(i10, function2, function1, cancellationSignal);
    }

    /* access modifiers changed from: protected */
    public abstract T2 convertRequestToPlayServices(T1 t12);

    /* access modifiers changed from: protected */
    public abstract R1 convertResponseToCredentialManager(R2 r22);

    public abstract void invokePlayServices(T1 t12, CredentialManagerCallback<R1, E1> credentialManagerCallback, Executor executor, CancellationSignal cancellationSignal);

    /* access modifiers changed from: protected */
    public final boolean maybeReportErrorFromResultReceiver(Bundle bundle, Function2<? super String, ? super String, ? extends E1> function2, Executor executor, CredentialManagerCallback<R1, E1> credentialManagerCallback, CancellationSignal cancellationSignal) {
        m.f(bundle, "resultData");
        m.f(function2, "conversionFn");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        if (!bundle.getBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG)) {
            return false;
        }
        cancelOrCallbackExceptionOrResult(cancellationSignal, new CredentialProviderController$maybeReportErrorFromResultReceiver$1(executor, credentialManagerCallback, function2.invoke(bundle.getString(CredentialProviderBaseController.EXCEPTION_TYPE_TAG), bundle.getString(CredentialProviderBaseController.EXCEPTION_MESSAGE_TAG))));
        return true;
    }
}
