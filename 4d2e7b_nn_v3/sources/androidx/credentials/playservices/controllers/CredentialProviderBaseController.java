package androidx.credentials.playservices.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.ResultReceiver;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialInterruptedException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.NoCredentialException;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public class CredentialProviderBaseController {
    public static final String ACTIVITY_REQUEST_CODE_TAG = "ACTIVITY_REQUEST_CODE";
    public static final String BEGIN_SIGN_IN_TAG = "BEGIN_SIGN_IN";
    /* access modifiers changed from: private */
    public static final int CONTROLLER_REQUEST_CODE = 1;
    public static final String CREATE_CANCELED = "CREATE_CANCELED";
    public static final String CREATE_INTERRUPTED = "CREATE_INTERRUPTED";
    public static final String CREATE_PASSWORD_TAG = "CREATE_PASSWORD";
    public static final String CREATE_PUBLIC_KEY_CREDENTIAL_TAG = "CREATE_PUBLIC_KEY_CREDENTIAL";
    public static final String CREATE_UNKNOWN = "CREATE_UNKNOWN";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXCEPTION_MESSAGE_TAG = "EXCEPTION_MESSAGE";
    public static final String EXCEPTION_TYPE_TAG = "EXCEPTION_TYPE";
    public static final String FAILURE_RESPONSE_TAG = "FAILURE_RESPONSE";
    public static final String GET_CANCELED = "GET_CANCELED_TAG";
    public static final String GET_INTERRUPTED = "GET_INTERRUPTED";
    public static final String GET_NO_CREDENTIALS = "GET_NO_CREDENTIALS";
    public static final String GET_UNKNOWN = "GET_UNKNOWN";
    public static final String REQUEST_TAG = "REQUEST_TYPE";
    public static final String RESULT_DATA_TAG = "RESULT_DATA";
    public static final String RESULT_RECEIVER_TAG = "RESULT_RECEIVER";
    public static final String SIGN_IN_INTENT_TAG = "SIGN_IN_INTENT";
    public static final String TYPE_TAG = "TYPE";
    /* access modifiers changed from: private */
    public static final Set<Integer> retryables = r0.h(7, 20);
    private final Context context;

    public static final class Companion {
        private Companion() {
        }

        protected static /* synthetic */ void getCONTROLLER_REQUEST_CODE$annotations() {
        }

        public final CreateCredentialException createCredentialExceptionTypeToException$credentials_play_services_auth_release(String str, String str2) {
            if (m.b(str, CredentialProviderBaseController.CREATE_CANCELED)) {
                return new CreateCredentialCancellationException(str2);
            }
            if (m.b(str, CredentialProviderBaseController.CREATE_INTERRUPTED)) {
                return new CreateCredentialInterruptedException(str2);
            }
            return new CreateCredentialUnknownException(str2);
        }

        /* access modifiers changed from: protected */
        public final int getCONTROLLER_REQUEST_CODE() {
            return CredentialProviderBaseController.CONTROLLER_REQUEST_CODE;
        }

        public final GetCredentialException getCredentialExceptionTypeToException$credentials_play_services_auth_release(String str, String str2) {
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1567968963) {
                    if (hashCode != -154594663) {
                        if (hashCode == 1996705159 && str.equals(CredentialProviderBaseController.GET_NO_CREDENTIALS)) {
                            return new NoCredentialException(str2);
                        }
                    } else if (str.equals(CredentialProviderBaseController.GET_INTERRUPTED)) {
                        return new GetCredentialInterruptedException(str2);
                    }
                } else if (str.equals(CredentialProviderBaseController.GET_CANCELED)) {
                    return new GetCredentialCancellationException(str2);
                }
            }
            return new GetCredentialUnknownException(str2);
        }

        public final Set<Integer> getRetryables() {
            return CredentialProviderBaseController.retryables;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CredentialProviderBaseController(Context context2) {
        m.f(context2, "context");
        this.context = context2;
    }

    protected static final int getCONTROLLER_REQUEST_CODE() {
        return Companion.getCONTROLLER_REQUEST_CODE();
    }

    /* access modifiers changed from: protected */
    public final void generateHiddenActivityIntent(ResultReceiver resultReceiver, Intent intent, String str) {
        m.f(resultReceiver, "resultReceiver");
        m.f(intent, "hiddenIntent");
        m.f(str, "typeTag");
        intent.putExtra(TYPE_TAG, str);
        intent.putExtra(ACTIVITY_REQUEST_CODE_TAG, CONTROLLER_REQUEST_CODE);
        intent.putExtra(RESULT_RECEIVER_TAG, toIpcFriendlyResultReceiver(resultReceiver));
        intent.setFlags(65536);
    }

    public final <T extends ResultReceiver> ResultReceiver toIpcFriendlyResultReceiver(T t10) {
        Parcel obtain = Parcel.obtain();
        m.e(obtain, "obtain()");
        m.c(t10);
        t10.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return resultReceiver;
    }
}
