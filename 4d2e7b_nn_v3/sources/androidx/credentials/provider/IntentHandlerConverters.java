package androidx.credentials.provider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.credentials.CreateCredentialException;
import android.credentials.CreateCredentialResponse;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialResponse;
import android.service.credentials.BeginGetCredentialResponse;
import androidx.annotation.RequiresApi;
import androidx.credentials.k0;
import androidx.credentials.m0;
import androidx.credentials.n0;
import androidx.credentials.o0;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import kotlin.jvm.internal.m;

@SuppressLint({"ClassVerificationFailure"})
public final class IntentHandlerConverters {
    @RequiresApi(34)
    public static final BeginGetCredentialResponse getBeginGetResponse(Intent intent) {
        BeginGetCredentialResponse a10;
        m.f(intent, "<this>");
        if (intent.hasExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE") && (a10 = p.a(intent.getParcelableExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE", o.a()))) != null) {
            return BeginGetCredentialUtil.Companion.convertToJetpackResponse(a10);
        }
        return null;
    }

    @RequiresApi(34)
    public static final CreateCredentialResponse getCreateCredentialCredentialResponse(Intent intent) {
        m.f(intent, "<this>");
        if (!intent.hasExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE")) {
            return null;
        }
        return m0.a(intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", s.a()));
    }

    @RequiresApi(34)
    public static final CreateCredentialException getCreateCredentialException(Intent intent) {
        m.f(intent, "<this>");
        if (!intent.hasExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION")) {
            return null;
        }
        return k0.a(intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", q.a()));
    }

    @RequiresApi(34)
    public static final GetCredentialException getGetCredentialException(Intent intent) {
        m.f(intent, "<this>");
        if (!intent.hasExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION")) {
            return null;
        }
        return o0.a(intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", r.a()));
    }

    @RequiresApi(34)
    public static final GetCredentialResponse getGetCredentialResponse(Intent intent) {
        m.f(intent, "<this>");
        if (!intent.hasExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE")) {
            return null;
        }
        return n0.a(intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", m.a()));
    }
}
