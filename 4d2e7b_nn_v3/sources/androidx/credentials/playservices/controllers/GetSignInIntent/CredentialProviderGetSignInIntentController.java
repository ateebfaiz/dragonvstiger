package androidx.credentials.playservices.controllers.GetSignInIntent;

import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialUnsupportedException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;

public final class CredentialProviderGetSignInIntentController extends CredentialProviderController<GetCredentialRequest, GetSignInIntentRequest, SignInCredential, GetCredentialResponse, GetCredentialException> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "GetSignInIntent";
    public CredentialManagerCallback<GetCredentialResponse, GetCredentialException> callback;
    /* access modifiers changed from: private */
    public CancellationSignal cancellationSignal;
    private final Context context;
    public Executor executor;
    private final CredentialProviderGetSignInIntentController$resultReceiver$1 resultReceiver = new CredentialProviderGetSignInIntentController$resultReceiver$1(this, new Handler(Looper.getMainLooper()));

    public static final class Companion {
        private Companion() {
        }

        public final CredentialProviderGetSignInIntentController getInstance(Context context) {
            m.f(context, "context");
            return new CredentialProviderGetSignInIntentController(context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderGetSignInIntentController(Context context2) {
        super(context2);
        m.f(context2, "context");
        this.context = context2;
    }

    @VisibleForTesting
    public static /* synthetic */ void getCallback$annotations() {
    }

    @VisibleForTesting
    private static /* synthetic */ void getCancellationSignal$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getExecutor$annotations() {
    }

    public static final CredentialProviderGetSignInIntentController getInstance(Context context2) {
        return Companion.getInstance(context2);
    }

    @VisibleForTesting
    public final GoogleIdTokenCredential createGoogleIdCredential(SignInCredential signInCredential) {
        m.f(signInCredential, "response");
        GoogleIdTokenCredential.Builder builder = new GoogleIdTokenCredential.Builder();
        String id2 = signInCredential.getId();
        m.e(id2, "response.id");
        GoogleIdTokenCredential.Builder id3 = builder.setId(id2);
        try {
            String googleIdToken = signInCredential.getGoogleIdToken();
            m.c(googleIdToken);
            id3.setIdToken(googleIdToken);
            if (signInCredential.getDisplayName() != null) {
                id3.setDisplayName(signInCredential.getDisplayName());
            }
            if (signInCredential.getGivenName() != null) {
                id3.setGivenName(signInCredential.getGivenName());
            }
            if (signInCredential.getFamilyName() != null) {
                id3.setFamilyName(signInCredential.getFamilyName());
            }
            if (signInCredential.getPhoneNumber() != null) {
                id3.setPhoneNumber(signInCredential.getPhoneNumber());
            }
            if (signInCredential.getProfilePictureUri() != null) {
                id3.setProfilePictureUri(signInCredential.getProfilePictureUri());
            }
            return id3.build();
        } catch (Exception unused) {
            throw new GetCredentialUnknownException("When attempting to convert get response, null Google ID Token found");
        }
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
        } else if (!CredentialProviderController.maybeReportErrorResultCodeGet(i11, CredentialProviderGetSignInIntentController$handleResponse$1.INSTANCE, new CredentialProviderGetSignInIntentController$handleResponse$2(this), this.cancellationSignal)) {
            try {
                SignInCredential signInCredentialFromIntent = Identity.getSignInClient(this.context).getSignInCredentialFromIntent(intent);
                m.e(signInCredentialFromIntent, "getSignInClient(context)…redentialFromIntent(data)");
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderGetSignInIntentController$handleResponse$3(this, convertResponseToCredentialManager(signInCredentialFromIntent)));
            } catch (ApiException e10) {
                y yVar = new y();
                yVar.f725a = new GetCredentialUnknownException(e10.getMessage());
                if (e10.getStatusCode() == 16) {
                    yVar.f725a = new GetCredentialCancellationException(e10.getMessage());
                } else if (CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(e10.getStatusCode()))) {
                    yVar.f725a = new GetCredentialInterruptedException(e10.getMessage());
                }
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderGetSignInIntentController$handleResponse$4(this, yVar));
            } catch (GetCredentialException e11) {
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderGetSignInIntentController$handleResponse$5(this, e11));
            } catch (Throwable th) {
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderGetSignInIntentController$handleResponse$6(this, new GetCredentialUnknownException(th.getMessage())));
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

    @VisibleForTesting
    public GetSignInIntentRequest convertRequestToPlayServices(GetCredentialRequest getCredentialRequest) {
        m.f(getCredentialRequest, "request");
        if (getCredentialRequest.getCredentialOptions().size() == 1) {
            CredentialOption credentialOption = getCredentialRequest.getCredentialOptions().get(0);
            m.d(credentialOption, "null cannot be cast to non-null type com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption");
            GetSignInWithGoogleOption getSignInWithGoogleOption = (GetSignInWithGoogleOption) credentialOption;
            GetSignInIntentRequest build = GetSignInIntentRequest.builder().setServerClientId(getSignInWithGoogleOption.getServerClientId()).filterByHostedDomain(getSignInWithGoogleOption.getHostedDomainFilter()).setNonce(getSignInWithGoogleOption.getNonce()).build();
            m.e(build, "builder()\n            .s…nce)\n            .build()");
            return build;
        }
        throw new GetCredentialUnsupportedException("GetSignInWithGoogleOption cannot be combined with other options.");
    }

    /* access modifiers changed from: protected */
    public GetCredentialResponse convertResponseToCredentialManager(SignInCredential signInCredential) {
        GoogleIdTokenCredential googleIdTokenCredential;
        m.f(signInCredential, "response");
        if (signInCredential.getGoogleIdToken() != null) {
            googleIdTokenCredential = createGoogleIdCredential(signInCredential);
        } else {
            Log.w(TAG, "Credential returned but no google Id found");
            googleIdTokenCredential = null;
        }
        if (googleIdTokenCredential != null) {
            return new GetCredentialResponse(googleIdTokenCredential);
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
            try {
                GetSignInIntentRequest convertRequestToPlayServices = convertRequestToPlayServices(getCredentialRequest);
                Intent intent = new Intent(this.context, HiddenActivity.class);
                intent.putExtra(CredentialProviderBaseController.REQUEST_TAG, convertRequestToPlayServices);
                generateHiddenActivityIntent(this.resultReceiver, intent, CredentialProviderBaseController.SIGN_IN_INTENT_TAG);
                this.context.startActivity(intent);
            } catch (Exception e10) {
                if (e10 instanceof GetCredentialUnsupportedException) {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal2, new CredentialProviderGetSignInIntentController$invokePlayServices$1(this, e10));
                } else {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal2, new CredentialProviderGetSignInIntentController$invokePlayServices$2(this));
                }
            }
        }
    }
}
