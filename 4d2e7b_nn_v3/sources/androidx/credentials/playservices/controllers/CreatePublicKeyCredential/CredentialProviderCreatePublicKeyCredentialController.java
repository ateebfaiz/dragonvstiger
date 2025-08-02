package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.CreatePublicKeyCredentialResponse;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.fido.Fido;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;

public final class CredentialProviderCreatePublicKeyCredentialController extends CredentialProviderController<CreatePublicKeyCredentialRequest, PublicKeyCredentialCreationOptions, PublicKeyCredential, CreateCredentialResponse, CreateCredentialException> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "CreatePublicKey";
    /* access modifiers changed from: private */
    public CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> callback;
    /* access modifiers changed from: private */
    public CancellationSignal cancellationSignal;
    private final Context context;
    /* access modifiers changed from: private */
    public Executor executor;
    private final CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1 resultReceiver = new CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1(this, new Handler(Looper.getMainLooper()));

    public static final class Companion {
        private Companion() {
        }

        public final CredentialProviderCreatePublicKeyCredentialController getInstance(Context context) {
            m.f(context, "context");
            return new CredentialProviderCreatePublicKeyCredentialController(context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderCreatePublicKeyCredentialController(Context context2) {
        super(context2);
        m.f(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public final CreatePublicKeyCredentialDomException JSONExceptionToPKCError(JSONException jSONException) {
        String message = jSONException.getMessage();
        if (message == null || message.length() <= 0) {
            return new CreatePublicKeyCredentialDomException(new EncodingError(), "Unknown error");
        }
        return new CreatePublicKeyCredentialDomException(new EncodingError(), message);
    }

    @VisibleForTesting(otherwise = 2)
    private static /* synthetic */ void getCallback$annotations() {
    }

    @VisibleForTesting(otherwise = 2)
    private static /* synthetic */ void getCancellationSignal$annotations() {
    }

    @VisibleForTesting(otherwise = 2)
    private static /* synthetic */ void getExecutor$annotations() {
    }

    public static final CredentialProviderCreatePublicKeyCredentialController getInstance(Context context2) {
        return Companion.getInstance(context2);
    }

    /* access modifiers changed from: private */
    public static final void handleResponse$lambda$0(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController) {
        m.f(credentialProviderCreatePublicKeyCredentialController, "this$0");
        CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback = credentialProviderCreatePublicKeyCredentialController.callback;
        if (credentialManagerCallback == null) {
            m.u("callback");
            credentialManagerCallback = null;
        }
        credentialManagerCallback.onError(new CreatePublicKeyCredentialDomException(new UnknownError(), "Upon handling create public key credential response, fido module giving null bytes indicating internal error"));
    }

    public final void handleResponse$credentials_play_services_auth_release(int i10, int i11, Intent intent) {
        byte[] bArr;
        if (i10 != CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE()) {
            Log.w(TAG, "Returned request code " + CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE() + " does not match what was given " + i10);
        } else if (!CredentialProviderController.maybeReportErrorResultCodeCreate(i11, CredentialProviderCreatePublicKeyCredentialController$handleResponse$1.INSTANCE, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$2(this), this.cancellationSignal)) {
            Executor executor2 = null;
            if (intent != null) {
                bArr = intent.getByteArrayExtra(Fido.FIDO2_KEY_CREDENTIAL_EXTRA);
            } else {
                bArr = null;
            }
            if (bArr != null) {
                PublicKeyCredential deserializeFromBytes = PublicKeyCredential.deserializeFromBytes(bArr);
                m.e(deserializeFromBytes, "deserializeFromBytes(bytes)");
                CreateCredentialException publicKeyCredentialResponseContainsError = PublicKeyCredentialControllerUtility.Companion.publicKeyCredentialResponseContainsError(deserializeFromBytes);
                if (publicKeyCredentialResponseContainsError != null) {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$4(this, publicKeyCredentialResponseContainsError));
                    return;
                }
                try {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$5(this, convertResponseToCredentialManager(deserializeFromBytes)));
                } catch (JSONException e10) {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$6(this, e10));
                } catch (Throwable th) {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$7(this, th));
                }
            } else if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(this.cancellationSignal)) {
                Executor executor3 = this.executor;
                if (executor3 == null) {
                    m.u("executor");
                } else {
                    executor2 = executor3;
                }
                executor2.execute(new CredentialProviderCreatePublicKeyCredentialController$$ExternalSyntheticLambda0(this));
            }
        }
    }

    @VisibleForTesting(otherwise = 4)
    public PublicKeyCredentialCreationOptions convertRequestToPlayServices(CreatePublicKeyCredentialRequest createPublicKeyCredentialRequest) {
        m.f(createPublicKeyCredentialRequest, "request");
        return PublicKeyCredentialControllerUtility.Companion.convert(createPublicKeyCredentialRequest);
    }

    @VisibleForTesting(otherwise = 4)
    public CreateCredentialResponse convertResponseToCredentialManager(PublicKeyCredential publicKeyCredential) {
        m.f(publicKeyCredential, "response");
        try {
            String json = publicKeyCredential.toJson();
            m.e(json, "response.toJson()");
            return new CreatePublicKeyCredentialResponse(json);
        } catch (Throwable th) {
            throw new CreateCredentialUnknownException("The PublicKeyCredential response json had an unexpected exception when parsing: " + th.getMessage());
        }
    }

    public void invokePlayServices(CreatePublicKeyCredentialRequest createPublicKeyCredentialRequest, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback, Executor executor2, CancellationSignal cancellationSignal2) {
        m.f(createPublicKeyCredentialRequest, "request");
        m.f(credentialManagerCallback, "callback");
        m.f(executor2, "executor");
        this.cancellationSignal = cancellationSignal2;
        this.callback = credentialManagerCallback;
        this.executor = executor2;
        try {
            PublicKeyCredentialCreationOptions convertRequestToPlayServices = convertRequestToPlayServices(createPublicKeyCredentialRequest);
            if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal2)) {
                Intent intent = new Intent(this.context, HiddenActivity.class);
                intent.putExtra(CredentialProviderBaseController.REQUEST_TAG, convertRequestToPlayServices);
                generateHiddenActivityIntent(this.resultReceiver, intent, CredentialProviderBaseController.CREATE_PUBLIC_KEY_CREDENTIAL_TAG);
                try {
                    this.context.startActivity(intent);
                } catch (Exception unused) {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal2, new CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$3(this));
                }
            }
        } catch (JSONException e10) {
            CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal2, new CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$1(this, e10));
        } catch (Throwable th) {
            CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal2, new CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$2(this, th));
        }
    }
}
