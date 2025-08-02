package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import androidx.credentials.webauthn.WebAuthnUtils;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import java.security.MessageDigest;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AuthenticatorAssertionResponse implements AuthenticatorResponse {
    private byte[] authenticatorData;

    /* renamed from: be  reason: collision with root package name */
    private final boolean f15345be;
    private final boolean bs;
    private final byte[] clientDataHash;
    private JSONObject clientJson;
    private final byte[] credentialId;
    private final String origin;
    private final String packageName;
    private final PublicKeyCredentialRequestOptions requestOptions;
    private byte[] signature;
    private final boolean up;
    private byte[] userHandle;
    private final boolean uv;

    public AuthenticatorAssertionResponse(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, byte[] bArr, String str, boolean z10, boolean z11, boolean z12, boolean z13, byte[] bArr2, String str2, byte[] bArr3) {
        m.f(publicKeyCredentialRequestOptions, "requestOptions");
        m.f(bArr, "credentialId");
        m.f(str, "origin");
        m.f(bArr2, "userHandle");
        this.requestOptions = publicKeyCredentialRequestOptions;
        this.credentialId = bArr;
        this.origin = str;
        this.up = z10;
        this.uv = z11;
        this.f15345be = z12;
        this.bs = z13;
        this.userHandle = bArr2;
        this.packageName = str2;
        this.clientDataHash = bArr3;
        this.clientJson = new JSONObject();
        this.signature = new byte[0];
        getClientJson().put("type", "webauthn.get");
        getClientJson().put(ClientData.KEY_CHALLENGE, WebAuthnUtils.Companion.b64Encode(publicKeyCredentialRequestOptions.getChallenge()));
        getClientJson().put("origin", str);
        if (str2 != null) {
            getClientJson().put("androidPackageName", str2);
        }
        this.authenticatorData = defaultAuthenticatorData();
    }

    public final byte[] dataToSign() {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bArr = this.clientDataHash;
        if (bArr == null) {
            String jSONObject = getClientJson().toString();
            m.e(jSONObject, "clientJson.toString()");
            byte[] bytes = jSONObject.getBytes(d.f797b);
            m.e(bytes, "this as java.lang.String).getBytes(charset)");
            bArr = instance.digest(bytes);
            m.e(bArr, "md.digest(clientJson.toString().toByteArray())");
        }
        return j.n(this.authenticatorData, bArr);
    }

    public final byte[] defaultAuthenticatorData() {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = this.requestOptions.getRpId().getBytes(d.f797b);
        m.e(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        boolean z10 = this.up;
        if (this.uv) {
            z10 |= true;
        }
        if (this.f15345be) {
            z10 |= true;
        }
        if (this.bs) {
            z10 |= true;
        }
        m.e(digest, "rpHash");
        return j.n(j.n(digest, new byte[]{z10 ? (byte) 1 : 0}), new byte[]{0, 0, 0, 0});
    }

    public final byte[] getAuthenticatorData() {
        return this.authenticatorData;
    }

    public JSONObject getClientJson() {
        return this.clientJson;
    }

    public final byte[] getSignature() {
        return this.signature;
    }

    public JSONObject json() {
        String jSONObject = getClientJson().toString();
        m.e(jSONObject, "clientJson.toString()");
        byte[] bytes = jSONObject.getBytes(d.f797b);
        m.e(bytes, "this as java.lang.String).getBytes(charset)");
        JSONObject jSONObject2 = new JSONObject();
        if (this.clientDataHash == null) {
            jSONObject2.put("clientDataJSON", WebAuthnUtils.Companion.b64Encode(bytes));
        }
        WebAuthnUtils.Companion companion = WebAuthnUtils.Companion;
        jSONObject2.put("authenticatorData", companion.b64Encode(this.authenticatorData));
        jSONObject2.put("signature", companion.b64Encode(this.signature));
        jSONObject2.put("userHandle", companion.b64Encode(this.userHandle));
        return jSONObject2;
    }

    public final void setAuthenticatorData(byte[] bArr) {
        m.f(bArr, "<set-?>");
        this.authenticatorData = bArr;
    }

    public void setClientJson(JSONObject jSONObject) {
        m.f(jSONObject, "<set-?>");
        this.clientJson = jSONObject;
    }

    public final void setSignature(byte[] bArr) {
        m.f(bArr, "<set-?>");
        this.signature = bArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AuthenticatorAssertionResponse(androidx.credentials.webauthn.PublicKeyCredentialRequestOptions r15, byte[] r16, java.lang.String r17, boolean r18, boolean r19, boolean r20, boolean r21, byte[] r22, java.lang.String r23, byte[] r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r12 = r2
            goto L_0x000b
        L_0x0009:
            r12 = r23
        L_0x000b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0011
            r13 = r2
            goto L_0x0013
        L_0x0011:
            r13 = r24
        L_0x0013:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.webauthn.AuthenticatorAssertionResponse.<init>(androidx.credentials.webauthn.PublicKeyCredentialRequestOptions, byte[], java.lang.String, boolean, boolean, boolean, boolean, byte[], java.lang.String, byte[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
