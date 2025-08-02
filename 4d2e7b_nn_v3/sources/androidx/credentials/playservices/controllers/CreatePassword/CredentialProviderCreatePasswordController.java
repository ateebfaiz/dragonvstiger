package androidx.credentials.playservices.controllers.CreatePassword;

import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CreatePasswordRequest;
import androidx.credentials.CreatePasswordResponse;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SignInPassword;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class CredentialProviderCreatePasswordController extends CredentialProviderController<CreatePasswordRequest, SavePasswordRequest, Unit, CreateCredentialResponse, CreateCredentialException> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "CreatePassword";
    /* access modifiers changed from: private */
    public CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> callback;
    /* access modifiers changed from: private */
    public CancellationSignal cancellationSignal;
    private final Context context;
    /* access modifiers changed from: private */
    public Executor executor;
    private final CredentialProviderCreatePasswordController$resultReceiver$1 resultReceiver = new CredentialProviderCreatePasswordController$resultReceiver$1(this, new Handler(Looper.getMainLooper()));

    public static final class Companion {
        private Companion() {
        }

        public final CredentialProviderCreatePasswordController getInstance(Context context) {
            m.f(context, "context");
            return new CredentialProviderCreatePasswordController(context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderCreatePasswordController(Context context2) {
        super(context2);
        m.f(context2, "context");
        this.context = context2;
    }

    @VisibleForTesting(otherwise = 2)
    private static /* synthetic */ void getCallback$annotations() {
    }

    @VisibleForTesting(otherwise = 2)
    private static /* synthetic */ void getCancellationSignal$annotations() {
    }

    public static final CredentialProviderCreatePasswordController getInstance(Context context2) {
        return Companion.getInstance(context2);
    }

    public final void handleResponse$credentials_play_services_auth_release(int i10, int i11) {
        if (i10 != CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE()) {
            Log.w(TAG, "Returned request code " + CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE() + " which does not match what was given " + i10);
        } else if (!CredentialProviderController.maybeReportErrorResultCodeCreate(i11, CredentialProviderCreatePasswordController$handleResponse$1.INSTANCE, new CredentialProviderCreatePasswordController$handleResponse$2(this), this.cancellationSignal)) {
            CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePasswordController$handleResponse$3(this, convertResponseToCredentialManager(Unit.f12577a)));
        }
    }

    @VisibleForTesting(otherwise = 4)
    public SavePasswordRequest convertRequestToPlayServices(CreatePasswordRequest createPasswordRequest) {
        m.f(createPasswordRequest, "request");
        SavePasswordRequest build = SavePasswordRequest.builder().setSignInPassword(new SignInPassword(createPasswordRequest.getId(), createPasswordRequest.getPassword())).build();
        m.e(build, "builder().setSignInPassw…ssword)\n        ).build()");
        return build;
    }

    @VisibleForTesting(otherwise = 4)
    public CreateCredentialResponse convertResponseToCredentialManager(Unit unit) {
        m.f(unit, "response");
        return new CreatePasswordResponse();
    }

    public void invokePlayServices(CreatePasswordRequest createPasswordRequest, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback, Executor executor2, CancellationSignal cancellationSignal2) {
        m.f(createPasswordRequest, "request");
        m.f(credentialManagerCallback, "callback");
        m.f(executor2, "executor");
        this.cancellationSignal = cancellationSignal2;
        this.callback = credentialManagerCallback;
        this.executor = executor2;
        if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal2)) {
            SavePasswordRequest convertRequestToPlayServices = convertRequestToPlayServices(createPasswordRequest);
            Intent intent = new Intent(this.context, HiddenActivity.class);
            intent.putExtra(CredentialProviderBaseController.REQUEST_TAG, convertRequestToPlayServices);
            generateHiddenActivityIntent(this.resultReceiver, intent, CredentialProviderBaseController.CREATE_PASSWORD_TAG);
            try {
                this.context.startActivity(intent);
            } catch (Exception unused) {
                CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal2, new CredentialProviderCreatePasswordController$invokePlayServices$1(this));
            }
        }
    }
}
