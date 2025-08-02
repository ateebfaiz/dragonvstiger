package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class FidoPublicKeyCredential {
    private final String authenticatorAttachment;
    private final byte[] rawId;
    private final AuthenticatorResponse response;

    public FidoPublicKeyCredential(byte[] bArr, AuthenticatorResponse authenticatorResponse, String str) {
        m.f(bArr, "rawId");
        m.f(authenticatorResponse, "response");
        m.f(str, "authenticatorAttachment");
        this.rawId = bArr;
        this.response = authenticatorResponse;
        this.authenticatorAttachment = str;
    }

    public final String getAuthenticatorAttachment() {
        return this.authenticatorAttachment;
    }

    public final byte[] getRawId() {
        return this.rawId;
    }

    public final AuthenticatorResponse getResponse() {
        return this.response;
    }

    public final String json() {
        String b64Encode = WebAuthnUtils.Companion.b64Encode(this.rawId);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", b64Encode);
        jSONObject.put("rawId", b64Encode);
        jSONObject.put("type", "public-key");
        jSONObject.put("authenticatorAttachment", this.authenticatorAttachment);
        jSONObject.put("response", this.response.json());
        jSONObject.put("clientExtensionResults", new JSONObject());
        String jSONObject2 = jSONObject.toString();
        m.e(jSONObject2, "ret.toString()");
        return jSONObject2;
    }
}
