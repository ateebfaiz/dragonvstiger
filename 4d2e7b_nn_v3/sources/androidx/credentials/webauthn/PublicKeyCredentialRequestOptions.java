package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import androidx.credentials.webauthn.WebAuthnUtils;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PublicKeyCredentialRequestOptions {
    private final byte[] challenge;
    private final JSONObject json;
    private final String rpId;
    private final long timeout;
    private final String userVerification;

    public PublicKeyCredentialRequestOptions(String str) {
        m.f(str, "requestJson");
        JSONObject jSONObject = new JSONObject(str);
        this.json = jSONObject;
        String string = jSONObject.getString(ClientData.KEY_CHALLENGE);
        WebAuthnUtils.Companion companion = WebAuthnUtils.Companion;
        m.e(string, "challengeString");
        this.challenge = companion.b64Decode(string);
        this.timeout = jSONObject.optLong("timeout", 0);
        String optString = jSONObject.optString("rpId", "");
        m.e(optString, "json.optString(\"rpId\", \"\")");
        this.rpId = optString;
        String optString2 = jSONObject.optString("userVerification", "preferred");
        m.e(optString2, "json.optString(\"userVerification\", \"preferred\")");
        this.userVerification = optString2;
    }

    public final byte[] getChallenge() {
        return this.challenge;
    }

    public final JSONObject getJson() {
        return this.json;
    }

    public final String getRpId() {
        return this.rpId;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final String getUserVerification() {
        return this.userVerification;
    }
}
