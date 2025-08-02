package androidx.credentials.playservices.controllers.BeginSignIn;

import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;

public final class CredentialProviderBeginSignInController extends CredentialProviderController<GetCredentialRequest, BeginSignInRequest, SignInCredential, GetCredentialResponse, GetCredentialException> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "BeginSignIn";
    public CredentialManagerCallback<GetCredentialResponse, GetCredentialException> callback;
    /* access modifiers changed from: private */
    public CancellationSignal cancellationSignal;
    private final Context context;
    public Executor executor;
    private final CredentialProviderBeginSignInController$resultReceiver$1 resultReceiver = new CredentialProviderBeginSignInController$resultReceiver$1(this, new Handler(Looper.getMainLooper()));

    public static final class Companion {
        private Companion() {
        }

        public final CredentialProviderBeginSignInController getInstance(Context context) {
            m.f(context, "context");
            return new CredentialProviderBeginSignInController(context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderBeginSignInController(Context context2) {
        super(context2);
        m.f(context2, "context");
        this.context = context2;
    }

    private final GoogleIdTokenCredential createGoogleIdCredential(SignInCredential signInCredential) {
        GoogleIdTokenCredential.Builder builder = new GoogleIdTokenCredential.Builder();
        String id2 = signInCredential.getId();
        m.e(id2, "response.id");
        GoogleIdTokenCredential.Builder id3 = builder.setId(id2);
        String googleIdToken = signInCredential.getGoogleIdToken();
        m.c(googleIdToken);
        GoogleIdTokenCredential.Builder idToken = id3.setIdToken(googleIdToken);
        if (signInCredential.getDisplayName() != null) {
            idToken.setDisplayName(signInCredential.getDisplayName());
        }
        if (signInCredential.getGivenName() != null) {
            idToken.setGivenName(signInCredential.getGivenName());
        }
        if (signInCredential.getFamilyName() != null) {
            idToken.setFamilyName(signInCredential.getFamilyName());
        }
        if (signInCredential.getPhoneNumber() != null) {
            idToken.setPhoneNumber(signInCredential.getPhoneNumber());
        }
        if (signInCredential.getProfilePictureUri() != null) {
            idToken.setProfilePictureUri(signInCredential.getProfilePictureUri());
        }
        return idToken.build();
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getCallback$annotations() {
    }

    @VisibleForTesting(otherwise = 2)
    private static /* synthetic */ void getCancellationSignal$annotations() {
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getExecutor$annotations() {
    }

    public static final CredentialProviderBeginSignInController getInstance(Context context2) {
        return Companion.getInstance(context2);
    }

    public final CredentialManagerCallback<GetCredentialResponse, GetCredentialException> getCallback() {
        CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback = this.callback;
        if (credentialManagerCallback != null) {
            return credentialManagerCallback;
        }
        m.u("callback");
        return null;
    }

    public final Executor getExecutor() {
        Executor executor2 = this.executor;
        if (executor2 != null) {
            return executor2;
        }
        m.u("executor");
        return null;
    }

    public final void handleResponse$credentials_play_services_auth_release(int i10, int i11, Intent intent) {
        if (i10 != CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE()) {
            Log.w(TAG, "Returned request code " + CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE() + " which  does not match what was given " + i10);
        } else if (!CredentialProviderController.maybeReportErrorResultCodeGet(i11, CredentialProviderBeginSignInController$handleResponse$1.INSTANCE, new CredentialProviderBeginSignInController$handleResponse$2(this), this.cancellationSignal)) {
            try {
                SignInCredential signInCredentialFromIntent = Identity.getSignInClient(this.context).getSignInCredentialFromIntent(intent);
                m.e(signInCredentialFromIntent, "getSignInClient(context)…redentialFromIntent(data)");
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderBeginSignInController$handleResponse$3(this, convertResponseToCredentialManager(signInCredentialFromIntent)));
            } catch (ApiException e10) {
                y yVar = new y();
                yVar.f725a = new GetCredentialUnknownException(e10.getMessage());
                if (e10.getStatusCode() == 16) {
                    yVar.f725a = new GetCredentialCancellationException(e10.getMessage());
                } else if (CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(e10.getStatusCode()))) {
                    yVar.f725a = new GetCredentialInterruptedException(e10.getMessage());
                }
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderBeginSignInController$handleResponse$4(this, yVar));
            } catch (GetCredentialException e11) {
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderBeginSignInController$handleResponse$5(this, e11));
            } catch (Throwable th) {
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderBeginSignInController$handleResponse$6(this, new GetCredentialUnknownException(th.getMessage())));
            }
        }
    }

    public final void setCallback(CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        m.f(credentialManagerCallback, "<set-?>");
        this.callback = credentialManagerCallback;
    }

    public final void setExecutor(Executor executor2) {
        m.f(executor2, "<set-?>");
        this.executor = executor2;
    }

    @VisibleForTesting(otherwise = 4)
    public BeginSignInRequest convertRequestToPlayServices(GetCredentialRequest getCredentialRequest) {
        m.f(getCredentialRequest, "request");
        return BeginSignInControllerUtility.Companion.constructBeginSignInRequest$credentials_play_services_auth_release(getCredentialRequest, this.context);
    }

    @VisibleForTesting(otherwise = 4)
    public GetCredentialResponse convertResponseToCredentialManager(SignInCredential signInCredential) {
        Credential credential;
        m.f(signInCredential, "response");
        if (signInCredential.getPassword() != null) {
            String id2 = signInCredential.getId();
            m.e(id2, "response.id");
            String password = signInCredential.getPassword();
            m.c(password);
            credential = new PasswordCredential(id2, password);
        } else if (signInCredential.getGoogleIdToken() != null) {
            credential = createGoogleIdCredential(signInCredential);
        } else if (signInCredential.getPublicKeyCredential() != null) {
            credential = new PublicKeyCredential(PublicKeyCredentialControllerUtility.Companion.toAssertPasskeyResponse(signInCredential));
        } else {
            Log.w(TAG, "Credential returned but no google Id or password or passkey found");
            credential = null;
        }
        if (credential != null) {
            return new GetCredentialResponse(credential);
        }
        throw new GetCredentialUnknownException("When attempting to convert get response, null credential found");
    }

    public void invokePlayServices(GetCredentialRequest getCredentialRequest, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback, Executor executor2, CancellationSignal cancellationSignal2) {
        m.f(getCredentialRequest, "request");
        m.f(credentialManagerCallback, "callback");
        m.f(executor2, "executor");
        this.cancellationSignal = cancellationSignal2;
        setCallback(credentialManagerCallback);
        setExecutor(executor2);
        if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal2)) {
            BeginSignInRequest convertRequestToPlayServices = convertRequestToPlayServices(getCredentialRequest);
            Intent intent = new Intent(this.context, HiddenActivity.class);
            intent.putExtra(CredentialProviderBaseController.REQUEST_TAG, convertRequestToPlayServices);
            generateHiddenActivityIntent(this.resultReceiver, intent, CredentialProviderBaseController.BEGIN_SIGN_IN_TAG);
            try {
                this.context.startActivity(intent);
            } catch (Exception unused) {
                CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal2, new CredentialProviderBeginSignInController$invokePlayServices$1(this));
            }
        }
    }
}
