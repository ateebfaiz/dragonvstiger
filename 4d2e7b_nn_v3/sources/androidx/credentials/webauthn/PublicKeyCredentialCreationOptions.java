package androidx.credentials.webauthn;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.credentials.webauthn.WebAuthnUtils;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import io.jsonwebtoken.JwsHeader;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PublicKeyCredentialCreationOptions {
    private String attestation;
    private AuthenticatorSelectionCriteria authenticatorSelection;
    private final byte[] challenge;
    private List<PublicKeyCredentialDescriptor> excludeCredentials;
    private final JSONObject json;
    private final List<PublicKeyCredentialParameters> pubKeyCredParams;
    private final PublicKeyCredentialRpEntity rp;
    private long timeout;
    private final PublicKeyCredentialUserEntity user;

    public PublicKeyCredentialCreationOptions(String str) {
        m.f(str, "requestJson");
        JSONObject jSONObject = new JSONObject(str);
        this.json = jSONObject;
        String string = jSONObject.getString(ClientData.KEY_CHALLENGE);
        WebAuthnUtils.Companion companion = WebAuthnUtils.Companion;
        m.e(string, "challengeString");
        this.challenge = companion.b64Decode(string);
        JSONObject jSONObject2 = jSONObject.getJSONObject("rp");
        String string2 = jSONObject2.getString("name");
        m.e(string2, "rpJson.getString(\"name\")");
        String string3 = jSONObject2.getString("id");
        m.e(string3, "rpJson.getString(\"id\")");
        this.rp = new PublicKeyCredentialRpEntity(string2, string3);
        JSONObject jSONObject3 = jSONObject.getJSONObject("user");
        String string4 = jSONObject3.getString("id");
        m.e(string4, "rpUser.getString(\"id\")");
        byte[] b64Decode = companion.b64Decode(string4);
        String string5 = jSONObject3.getString("name");
        m.e(string5, "rpUser.getString(\"name\")");
        String string6 = jSONObject3.getString("displayName");
        m.e(string6, "rpUser.getString(\"displayName\")");
        this.user = new PublicKeyCredentialUserEntity(string5, b64Decode, string6);
        JSONArray jSONArray = jSONObject.getJSONArray("pubKeyCredParams");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i10);
            String string7 = jSONObject4.getString("type");
            m.e(string7, "e.getString(\"type\")");
            arrayList.add(new PublicKeyCredentialParameters(string7, jSONObject4.getLong(JwsHeader.ALGORITHM)));
        }
        List<PublicKeyCredentialParameters> w02 = r.w0(arrayList);
        this.pubKeyCredParams = w02;
        this.timeout = this.json.optLong("timeout", 0);
        this.excludeCredentials = r.l();
        this.authenticatorSelection = new AuthenticatorSelectionCriteria("platform", "required", false, (String) null, 12, (DefaultConstructorMarker) null);
        String optString = this.json.optString("attestation", DevicePublicKeyStringDef.NONE);
        m.e(optString, "json.optString(\"attestation\", \"none\")");
        this.attestation = optString;
        Log.i("WebAuthn", "Challenge " + this.challenge + "()");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rp ");
        sb2.append(this.rp);
        Log.i("WebAuthn", sb2.toString());
        Log.i("WebAuthn", "user " + this.user);
        Log.i("WebAuthn", "pubKeyCredParams " + w02);
        Log.i("WebAuthn", "timeout " + this.timeout);
        Log.i("WebAuthn", "excludeCredentials " + this.excludeCredentials);
        Log.i("WebAuthn", "authenticatorSelection " + this.authenticatorSelection);
        Log.i("WebAuthn", "attestation " + this.attestation);
    }

    public final String getAttestation() {
        return this.attestation;
    }

    public final AuthenticatorSelectionCriteria getAuthenticatorSelection() {
        return this.authenticatorSelection;
    }

    public final byte[] getChallenge() {
        return this.challenge;
    }

    public final List<PublicKeyCredentialDescriptor> getExcludeCredentials() {
        return this.excludeCredentials;
    }

    public final JSONObject getJson() {
        return this.json;
    }

    public final List<PublicKeyCredentialParameters> getPubKeyCredParams() {
        return this.pubKeyCredParams;
    }

    public final PublicKeyCredentialRpEntity getRp() {
        return this.rp;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final PublicKeyCredentialUserEntity getUser() {
        return this.user;
    }

    public final void setAttestation(String str) {
        m.f(str, "<set-?>");
        this.attestation = str;
    }

    public final void setAuthenticatorSelection(AuthenticatorSelectionCriteria authenticatorSelectionCriteria) {
        m.f(authenticatorSelectionCriteria, "<set-?>");
        this.authenticatorSelection = authenticatorSelectionCriteria;
    }

    public final void setExcludeCredentials(List<PublicKeyCredentialDescriptor> list) {
        m.f(list, "<set-?>");
        this.excludeCredentials = list;
    }

    public final void setTimeout(long j10) {
        this.timeout = j10;
    }
}
