package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface AuthenticatorResponse {
    JSONObject getClientJson();

    JSONObject json();

    void setClientJson(JSONObject jSONObject);
}
