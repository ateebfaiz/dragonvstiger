package androidx.credentials.playservices;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.fido.Fido;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.tasks.Task;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class HiddenActivity extends Activity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_VALUE = 1;
    private static final String KEY_AWAITING_RESULT = "androidx.credentials.playservices.AWAITING_RESULT";
    private static final String TAG = "HiddenActivity";
    /* access modifiers changed from: private */
    public boolean mWaitingForActivityResult;
    /* access modifiers changed from: private */
    public ResultReceiver resultReceiver;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void handleBeginSignIn() {
        Task<BeginSignInResult> task;
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        int intExtra = getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1);
        if (beginSignInRequest != null) {
            task = Identity.getSignInClient((Activity) this).beginSignIn(beginSignInRequest).addOnSuccessListener(new HiddenActivity$$ExternalSyntheticLambda6(new HiddenActivity$handleBeginSignIn$1$1(this, intExtra))).addOnFailureListener(new HiddenActivity$$ExternalSyntheticLambda7(this));
        } else {
            task = null;
        }
        if (task == null) {
            Log.i(TAG, "During begin sign in, params is null, nothing to launch for begin sign in");
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void handleBeginSignIn$lambda$10$lambda$8(Function1 function1, Object obj) {
        m.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void handleBeginSignIn$lambda$10$lambda$9(HiddenActivity hiddenActivity, Exception exc) {
        String str;
        m.f(hiddenActivity, "this$0");
        m.f(exc, "e");
        if (!(exc instanceof ApiException) || !CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) {
            str = CredentialProviderBaseController.GET_NO_CREDENTIALS;
        } else {
            str = CredentialProviderBaseController.GET_INTERRUPTED;
        }
        ResultReceiver resultReceiver2 = hiddenActivity.resultReceiver;
        m.c(resultReceiver2);
        hiddenActivity.setupFailure(resultReceiver2, str, "During begin sign in, failure response from one tap: " + exc.getMessage());
    }

    private final void handleCreatePassword() {
        Task<SavePasswordResult> task;
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        int intExtra = getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1);
        if (savePasswordRequest != null) {
            task = Identity.getCredentialSavingClient((Activity) this).savePassword(savePasswordRequest).addOnSuccessListener(new HiddenActivity$$ExternalSyntheticLambda2(new HiddenActivity$handleCreatePassword$1$1(this, intExtra))).addOnFailureListener(new HiddenActivity$$ExternalSyntheticLambda3(this));
        } else {
            task = null;
        }
        if (task == null) {
            Log.i(TAG, "During save password, params is null, nothing to launch for create password");
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void handleCreatePassword$lambda$14$lambda$12(Function1 function1, Object obj) {
        m.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void handleCreatePassword$lambda$14$lambda$13(HiddenActivity hiddenActivity, Exception exc) {
        String str;
        m.f(hiddenActivity, "this$0");
        m.f(exc, "e");
        if (!(exc instanceof ApiException) || !CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) {
            str = CredentialProviderBaseController.CREATE_UNKNOWN;
        } else {
            str = CredentialProviderBaseController.CREATE_INTERRUPTED;
        }
        ResultReceiver resultReceiver2 = hiddenActivity.resultReceiver;
        m.c(resultReceiver2);
        hiddenActivity.setupFailure(resultReceiver2, str, "During save password, found password failure response from one tap " + exc.getMessage());
    }

    private final void handleCreatePublicKeyCredential() {
        Task<PendingIntent> task;
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        int intExtra = getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1);
        if (publicKeyCredentialCreationOptions != null) {
            task = Fido.getFido2ApiClient((Activity) this).getRegisterPendingIntent(publicKeyCredentialCreationOptions).addOnSuccessListener(new HiddenActivity$$ExternalSyntheticLambda0(new HiddenActivity$handleCreatePublicKeyCredential$1$1(this, intExtra))).addOnFailureListener(new HiddenActivity$$ExternalSyntheticLambda1(this));
        } else {
            task = null;
        }
        if (task == null) {
            Log.w(TAG, "During create public key credential, request is null, so nothing to launch for public key credentials");
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void handleCreatePublicKeyCredential$lambda$2$lambda$0(Function1 function1, Object obj) {
        m.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void handleCreatePublicKeyCredential$lambda$2$lambda$1(HiddenActivity hiddenActivity, Exception exc) {
        String str;
        m.f(hiddenActivity, "this$0");
        m.f(exc, "e");
        if (!(exc instanceof ApiException) || !CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) {
            str = CredentialProviderBaseController.CREATE_UNKNOWN;
        } else {
            str = CredentialProviderBaseController.CREATE_INTERRUPTED;
        }
        ResultReceiver resultReceiver2 = hiddenActivity.resultReceiver;
        m.c(resultReceiver2);
        hiddenActivity.setupFailure(resultReceiver2, str, "During create public key credential, fido registration failure: " + exc.getMessage());
    }

    private final void handleGetSignInIntent() {
        Task<PendingIntent> task;
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        int intExtra = getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1);
        if (getSignInIntentRequest != null) {
            task = Identity.getSignInClient((Activity) this).getSignInIntent(getSignInIntentRequest).addOnSuccessListener(new HiddenActivity$$ExternalSyntheticLambda4(new HiddenActivity$handleGetSignInIntent$1$1(this, intExtra))).addOnFailureListener(new HiddenActivity$$ExternalSyntheticLambda5(this));
        } else {
            task = null;
        }
        if (task == null) {
            Log.i(TAG, "During get sign-in intent, params is null, nothing to launch for get sign-in intent");
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void handleGetSignInIntent$lambda$6$lambda$4(Function1 function1, Object obj) {
        m.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void handleGetSignInIntent$lambda$6$lambda$5(HiddenActivity hiddenActivity, Exception exc) {
        String str;
        m.f(hiddenActivity, "this$0");
        m.f(exc, "e");
        if (!(exc instanceof ApiException) || !CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) {
            str = CredentialProviderBaseController.GET_NO_CREDENTIALS;
        } else {
            str = CredentialProviderBaseController.GET_INTERRUPTED;
        }
        ResultReceiver resultReceiver2 = hiddenActivity.resultReceiver;
        m.c(resultReceiver2);
        hiddenActivity.setupFailure(resultReceiver2, str, "During get sign-in intent, failure response from one tap: " + exc.getMessage());
    }

    private final void restoreState(Bundle bundle) {
        if (bundle != null) {
            this.mWaitingForActivityResult = bundle.getBoolean(KEY_AWAITING_RESULT, false);
        }
    }

    /* access modifiers changed from: private */
    public final void setupFailure(ResultReceiver resultReceiver2, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG, true);
        bundle.putString(CredentialProviderBaseController.EXCEPTION_TYPE_TAG, str);
        bundle.putString(CredentialProviderBaseController.EXCEPTION_MESSAGE_TAG, str2);
        resultReceiver2.send(Integer.MAX_VALUE, bundle);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Bundle bundle = new Bundle();
        bundle.putBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG, false);
        bundle.putInt(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, i10);
        bundle.putParcelable(CredentialProviderBaseController.RESULT_DATA_TAG, intent);
        ResultReceiver resultReceiver2 = this.resultReceiver;
        if (resultReceiver2 != null) {
            resultReceiver2.send(i11, bundle);
        }
        this.mWaitingForActivityResult = false;
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        String stringExtra = getIntent().getStringExtra(CredentialProviderBaseController.TYPE_TAG);
        ResultReceiver resultReceiver2 = (ResultReceiver) getIntent().getParcelableExtra(CredentialProviderBaseController.RESULT_RECEIVER_TAG);
        this.resultReceiver = resultReceiver2;
        if (resultReceiver2 == null) {
            finish();
        }
        restoreState(bundle);
        if (!this.mWaitingForActivityResult) {
            if (stringExtra != null) {
                switch (stringExtra.hashCode()) {
                    case -441061071:
                        if (stringExtra.equals(CredentialProviderBaseController.BEGIN_SIGN_IN_TAG)) {
                            handleBeginSignIn();
                            return;
                        }
                        break;
                    case 15545322:
                        if (stringExtra.equals(CredentialProviderBaseController.CREATE_PUBLIC_KEY_CREDENTIAL_TAG)) {
                            handleCreatePublicKeyCredential();
                            return;
                        }
                        break;
                    case 1246634622:
                        if (stringExtra.equals(CredentialProviderBaseController.CREATE_PASSWORD_TAG)) {
                            handleCreatePassword();
                            return;
                        }
                        break;
                    case 1980564212:
                        if (stringExtra.equals(CredentialProviderBaseController.SIGN_IN_INTENT_TAG)) {
                            handleGetSignInIntent();
                            return;
                        }
                        break;
                }
            }
            Log.w(TAG, "Activity handed an unsupported type");
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        m.f(bundle, "outState");
        bundle.putBoolean(KEY_AWAITING_RESULT, this.mWaitingForActivityResult);
        super.onSaveInstanceState(bundle);
    }
}
