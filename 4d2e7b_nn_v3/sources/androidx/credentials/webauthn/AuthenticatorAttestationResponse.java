package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import kotlin.collections.i0;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AuthenticatorAttestationResponse implements AuthenticatorResponse {
    private byte[] attestationObject;

    /* renamed from: be  reason: collision with root package name */
    private final boolean f15346be;
    private final boolean bs;
    private final byte[] clientDataHash;
    private JSONObject clientJson;
    private final byte[] credentialId;
    private final byte[] credentialPublicKey;
    private final String origin;
    private final String packageName;
    private final PublicKeyCredentialCreationOptions requestOptions;
    private final boolean up;
    private final boolean uv;

    public AuthenticatorAttestationResponse(PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions, byte[] bArr, byte[] bArr2, String str, boolean z10, boolean z11, boolean z12, boolean z13, String str2, byte[] bArr3) {
        m.f(publicKeyCredentialCreationOptions, "requestOptions");
        m.f(bArr, "credentialId");
        m.f(bArr2, "credentialPublicKey");
        m.f(str, "origin");
        this.requestOptions = publicKeyCredentialCreationOptions;
        this.credentialId = bArr;
        this.credentialPublicKey = bArr2;
        this.origin = str;
        this.up = z10;
        this.uv = z11;
        this.f15346be = z12;
        this.bs = z13;
        this.packageName = str2;
        this.clientDataHash = bArr3;
        this.clientJson = new JSONObject();
        getClientJson().put("type", "webauthn.create");
        getClientJson().put(ClientData.KEY_CHALLENGE, WebAuthnUtils.Companion.b64Encode(publicKeyCredentialCreationOptions.getChallenge()));
        getClientJson().put("origin", str);
        if (str2 != null) {
            getClientJson().put("androidPackageName", str2);
        }
        this.attestationObject = defaultAttestationObject$credentials_release();
    }

    private final byte[] authData() {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = this.requestOptions.getRp().getId().getBytes(d.f797b);
        m.e(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        boolean z10 = this.up;
        if (this.uv) {
            z10 |= true;
        }
        if (this.f15346be) {
            z10 |= true;
        }
        if (this.bs) {
            z10 |= true;
        }
        boolean z11 = z10 | true;
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 16; i10++) {
            bArr[i10] = 0;
        }
        byte[] bArr2 = this.credentialId;
        byte[] bArr3 = {(byte) (bArr2.length >> 8), (byte) bArr2.length};
        m.e(digest, "rpHash");
        return j.n(j.n(j.n(j.n(j.n(j.n(digest, new byte[]{z11 ? (byte) 1 : 0}), new byte[]{0, 0, 0, 0}), bArr), bArr3), this.credentialId), this.credentialPublicKey);
    }

    public final byte[] defaultAttestationObject$credentials_release() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("fmt", DevicePublicKeyStringDef.NONE);
        linkedHashMap.put("attStmt", i0.f());
        linkedHashMap.put("authData", authData());
        return new Cbor().encode(linkedHashMap);
    }

    public final byte[] getAttestationObject() {
        return this.attestationObject;
    }

    public JSONObject getClientJson() {
        return this.clientJson;
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
        jSONObject2.put("attestationObject", WebAuthnUtils.Companion.b64Encode(this.attestationObject));
        jSONObject2.put("transports", new JSONArray(r.o("internal", "hybrid")));
        return jSONObject2;
    }

    public final void setAttestationObject(byte[] bArr) {
        m.f(bArr, "<set-?>");
        this.attestationObject = bArr;
    }

    public void setClientJson(JSONObject jSONObject) {
        m.f(jSONObject, "<set-?>");
        this.clientJson = jSONObject;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AuthenticatorAttestationResponse(androidx.credentials.webauthn.PublicKeyCredentialCreationOptions r15, byte[] r16, byte[] r17, java.lang.String r18, boolean r19, boolean r20, boolean r21, boolean r22, java.lang.String r23, byte[] r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.webauthn.AuthenticatorAttestationResponse.<init>(androidx.credentials.webauthn.PublicKeyCredentialCreationOptions, byte[], byte[], java.lang.String, boolean, boolean, boolean, boolean, java.lang.String, byte[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
