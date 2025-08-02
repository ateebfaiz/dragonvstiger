package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.util.Base64;
import android.util.Log;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.GetPublicKeyCredentialOption;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.domerrors.AbortError;
import androidx.credentials.exceptions.domerrors.ConstraintError;
import androidx.credentials.exceptions.domerrors.DataError;
import androidx.credentials.exceptions.domerrors.DomError;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.domerrors.InvalidStateError;
import androidx.credentials.exceptions.domerrors.NetworkError;
import androidx.credentials.exceptions.domerrors.NotAllowedError;
import androidx.credentials.exceptions.domerrors.NotReadableError;
import androidx.credentials.exceptions.domerrors.NotSupportedError;
import androidx.credentials.exceptions.domerrors.SecurityError;
import androidx.credentials.exceptions.domerrors.TimeoutError;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException;
import androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialDomException;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.Attachment;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse;
import com.google.android.gms.fido.fido2.api.common.AuthenticatorSelectionCriteria;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension;
import com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialDescriptor;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialParameters;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRpEntity;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialUserEntity;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.zing.zalo.zalosdk.common.Constant;
import io.jsonwebtoken.JwsHeader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;
import kotlin.text.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class PublicKeyCredentialControllerUtility {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int FLAGS = 11;
    /* access modifiers changed from: private */
    public static final String JSON_KEY_ALG = JwsHeader.ALGORITHM;
    /* access modifiers changed from: private */
    public static final String JSON_KEY_APPID = AppsFlyerProperties.APP_ID;
    /* access modifiers changed from: private */
    public static final String JSON_KEY_ATTESTATION = "attestation";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_ATTESTATION_OBJ = "attestationObject";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_AUTH_ATTACHMENT = "authenticatorAttachment";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_AUTH_DATA = "authenticatorData";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_AUTH_SELECTION = "authenticatorSelection";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_CHALLENGE = ClientData.KEY_CHALLENGE;
    /* access modifiers changed from: private */
    public static final String JSON_KEY_CLIENT_DATA = "clientDataJSON";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_CLIENT_EXTENSION_RESULTS = "clientExtensionResults";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_CRED_PROPS = "credProps";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_DISPLAY_NAME = "displayName";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_EXCLUDE_CREDENTIALS = "excludeCredentials";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_EXTENSTIONS = "extensions";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_ICON = "icon";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_ID = "id";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_KEY_PROTECTION_TYPE = "keyProtectionType";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_MATCHER_PROTECTION_TYPE = "matcherProtectionType";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_NAME = "name";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_PUB_KEY_CRED_PARAMS = "pubKeyCredParams";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_RAW_ID = "rawId";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_REQUIRE_RES_KEY = "requireResidentKey";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_RESPONSE = "response";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_RES_KEY = "residentKey";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_RK = "rk";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_RP = "rp";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_RPID = "rpId";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_SIGNATURE = "signature";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_THIRD_PARTY_PAYMENT = "thirdPartyPayment";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_TIMEOUT = "timeout";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_TRANSPORTS = "transports";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_TYPE = "type";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_USER = "user";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_USER_HANDLE = "userHandle";
    /* access modifiers changed from: private */
    public static final String JSON_KEY_USER_VERIFICATION_METHOD = "userVerificationMethod";
    private static final String TAG = "PublicKeyUtility";
    /* access modifiers changed from: private */
    public static final LinkedHashMap<ErrorCode, DomError> orderedErrorCodeToExceptions = i0.h(t.a(ErrorCode.UNKNOWN_ERR, new UnknownError()), t.a(ErrorCode.ABORT_ERR, new AbortError()), t.a(ErrorCode.ATTESTATION_NOT_PRIVATE_ERR, new NotReadableError()), t.a(ErrorCode.CONSTRAINT_ERR, new ConstraintError()), t.a(ErrorCode.DATA_ERR, new DataError()), t.a(ErrorCode.INVALID_STATE_ERR, new InvalidStateError()), t.a(ErrorCode.ENCODING_ERR, new EncodingError()), t.a(ErrorCode.NETWORK_ERR, new NetworkError()), t.a(ErrorCode.NOT_ALLOWED_ERR, new NotAllowedError()), t.a(ErrorCode.NOT_SUPPORTED_ERR, new NotSupportedError()), t.a(ErrorCode.SECURITY_ERR, new SecurityError()), t.a(ErrorCode.TIMEOUT_ERR, new TimeoutError()));

    public static final class Companion {
        private Companion() {
        }

        private final byte[] getChallenge(JSONObject jSONObject) {
            String optString = jSONObject.optString(getJSON_KEY_CHALLENGE$credentials_play_services_auth_release(), "");
            m.e(optString, "challengeB64");
            if (optString.length() != 0) {
                return b64Decode(optString);
            }
            throw new JSONException("Challenge not found in request or is unexpectedly empty");
        }

        public final void addAuthenticatorAttestationResponse$credentials_play_services_auth_release(byte[] bArr, byte[] bArr2, String[] strArr, JSONObject jSONObject) {
            m.f(bArr, "clientDataJSON");
            m.f(bArr2, "attestationObject");
            m.f(strArr, "transportArray");
            m.f(jSONObject, "json");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(getJSON_KEY_CLIENT_DATA$credentials_play_services_auth_release(), b64Encode(bArr));
            jSONObject2.put(getJSON_KEY_ATTESTATION_OBJ$credentials_play_services_auth_release(), b64Encode(bArr2));
            jSONObject2.put(getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release(), new JSONArray(strArr));
            jSONObject.put(getJSON_KEY_RESPONSE$credentials_play_services_auth_release(), jSONObject2);
        }

        public final byte[] b64Decode(String str) {
            m.f(str, "str");
            byte[] decode = Base64.decode(str, 11);
            m.e(decode, "decode(str, FLAGS)");
            return decode;
        }

        public final String b64Encode(byte[] bArr) {
            m.f(bArr, "data");
            String encodeToString = Base64.encodeToString(bArr, 11);
            m.e(encodeToString, "encodeToString(data, FLAGS)");
            return encodeToString;
        }

        public final GetCredentialException beginSignInPublicKeyCredentialResponseContainsError$credentials_play_services_auth_release(ErrorCode errorCode, String str) {
            m.f(errorCode, Constant.PARAM_OAUTH_CODE);
            DomError domError = getOrderedErrorCodeToExceptions$credentials_play_services_auth_release().get(errorCode);
            if (domError == null) {
                UnknownError unknownError = new UnknownError();
                return new GetPublicKeyCredentialDomException(unknownError, "unknown fido gms exception - " + str);
            } else if (errorCode == ErrorCode.CONSTRAINT_ERR && str != null && j.K(str, "Unable to get sync account", false, 2, (Object) null)) {
                return new GetCredentialCancellationException("Passkey retrieval was cancelled by the user.");
            } else {
                return new GetPublicKeyCredentialDomException(domError, str);
            }
        }

        public final boolean checkAlgSupported(int i10) {
            try {
                COSEAlgorithmIdentifier.fromCoseValue(i10);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        public final PublicKeyCredentialCreationOptions convert(CreatePublicKeyCredentialRequest createPublicKeyCredentialRequest) {
            m.f(createPublicKeyCredentialRequest, "request");
            return convertJSON$credentials_play_services_auth_release(new JSONObject(createPublicKeyCredentialRequest.getRequestJson()));
        }

        public final PublicKeyCredentialCreationOptions convertJSON$credentials_play_services_auth_release(JSONObject jSONObject) {
            m.f(jSONObject, "json");
            PublicKeyCredentialCreationOptions.Builder builder = new PublicKeyCredentialCreationOptions.Builder();
            parseRequiredChallengeAndUser$credentials_play_services_auth_release(jSONObject, builder);
            parseRequiredRpAndParams$credentials_play_services_auth_release(jSONObject, builder);
            parseOptionalWithRequiredDefaultsAttestationAndExcludeCredentials$credentials_play_services_auth_release(jSONObject, builder);
            parseOptionalTimeout$credentials_play_services_auth_release(jSONObject, builder);
            parseOptionalAuthenticatorSelection$credentials_play_services_auth_release(jSONObject, builder);
            parseOptionalExtensions$credentials_play_services_auth_release(jSONObject, builder);
            PublicKeyCredentialCreationOptions build = builder.build();
            m.e(build, "builder.build()");
            return build;
        }

        public final BeginSignInRequest.PasskeyJsonRequestOptions convertToPlayAuthPasskeyJsonRequest(GetPublicKeyCredentialOption getPublicKeyCredentialOption) {
            m.f(getPublicKeyCredentialOption, "option");
            BeginSignInRequest.PasskeyJsonRequestOptions build = new BeginSignInRequest.PasskeyJsonRequestOptions.Builder().setSupported(true).setRequestJson(getPublicKeyCredentialOption.getRequestJson()).build();
            m.e(build, "Builder()\n        .setSu…estJson)\n        .build()");
            return build;
        }

        public final BeginSignInRequest.PasskeysRequestOptions convertToPlayAuthPasskeyRequest(GetPublicKeyCredentialOption getPublicKeyCredentialOption) {
            m.f(getPublicKeyCredentialOption, "option");
            JSONObject jSONObject = new JSONObject(getPublicKeyCredentialOption.getRequestJson());
            String optString = jSONObject.optString(getJSON_KEY_RPID$credentials_play_services_auth_release(), "");
            m.e(optString, "rpId");
            if (optString.length() != 0) {
                BeginSignInRequest.PasskeysRequestOptions build = new BeginSignInRequest.PasskeysRequestOptions.Builder().setSupported(true).setRpId(optString).setChallenge(getChallenge(jSONObject)).build();
                m.e(build, "Builder()\n        .setSu…allenge)\n        .build()");
                return build;
            }
            throw new JSONException("GetPublicKeyCredentialOption - rpId not specified in the request or is unexpectedly empty");
        }

        public final String getJSON_KEY_ALG$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ALG;
        }

        public final String getJSON_KEY_APPID$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_APPID;
        }

        public final String getJSON_KEY_ATTESTATION$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ATTESTATION;
        }

        public final String getJSON_KEY_ATTESTATION_OBJ$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ATTESTATION_OBJ;
        }

        public final String getJSON_KEY_AUTH_ATTACHMENT$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_AUTH_ATTACHMENT;
        }

        public final String getJSON_KEY_AUTH_DATA$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_AUTH_DATA;
        }

        public final String getJSON_KEY_AUTH_SELECTION$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_AUTH_SELECTION;
        }

        public final String getJSON_KEY_CHALLENGE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_CHALLENGE;
        }

        public final String getJSON_KEY_CLIENT_DATA$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_CLIENT_DATA;
        }

        public final String getJSON_KEY_CLIENT_EXTENSION_RESULTS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_CLIENT_EXTENSION_RESULTS;
        }

        public final String getJSON_KEY_CRED_PROPS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_CRED_PROPS;
        }

        public final String getJSON_KEY_DISPLAY_NAME$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_DISPLAY_NAME;
        }

        public final String getJSON_KEY_EXCLUDE_CREDENTIALS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_EXCLUDE_CREDENTIALS;
        }

        public final String getJSON_KEY_EXTENSTIONS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_EXTENSTIONS;
        }

        public final String getJSON_KEY_ICON$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ICON;
        }

        public final String getJSON_KEY_ID$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_ID;
        }

        public final String getJSON_KEY_KEY_PROTECTION_TYPE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_KEY_PROTECTION_TYPE;
        }

        public final String getJSON_KEY_MATCHER_PROTECTION_TYPE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_MATCHER_PROTECTION_TYPE;
        }

        public final String getJSON_KEY_NAME$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_NAME;
        }

        public final String getJSON_KEY_PUB_KEY_CRED_PARAMS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_PUB_KEY_CRED_PARAMS;
        }

        public final String getJSON_KEY_RAW_ID$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RAW_ID;
        }

        public final String getJSON_KEY_REQUIRE_RES_KEY$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_REQUIRE_RES_KEY;
        }

        public final String getJSON_KEY_RESPONSE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RESPONSE;
        }

        public final String getJSON_KEY_RES_KEY$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RES_KEY;
        }

        public final String getJSON_KEY_RK$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RK;
        }

        public final String getJSON_KEY_RP$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RP;
        }

        public final String getJSON_KEY_RPID$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_RPID;
        }

        public final String getJSON_KEY_SIGNATURE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_SIGNATURE;
        }

        public final String getJSON_KEY_THIRD_PARTY_PAYMENT$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_THIRD_PARTY_PAYMENT;
        }

        public final String getJSON_KEY_TIMEOUT$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_TIMEOUT;
        }

        public final String getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_TRANSPORTS;
        }

        public final String getJSON_KEY_TYPE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_TYPE;
        }

        public final String getJSON_KEY_USER$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_USER;
        }

        public final String getJSON_KEY_USER_HANDLE$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_USER_HANDLE;
        }

        public final String getJSON_KEY_USER_VERIFICATION_METHOD$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.JSON_KEY_USER_VERIFICATION_METHOD;
        }

        public final LinkedHashMap<ErrorCode, DomError> getOrderedErrorCodeToExceptions$credentials_play_services_auth_release() {
            return PublicKeyCredentialControllerUtility.orderedErrorCodeToExceptions;
        }

        public final void parseOptionalAuthenticatorSelection$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            ResidentKeyRequirement residentKeyRequirement;
            m.f(jSONObject, "json");
            m.f(builder, "builder");
            if (jSONObject.has(getJSON_KEY_AUTH_SELECTION$credentials_play_services_auth_release())) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(getJSON_KEY_AUTH_SELECTION$credentials_play_services_auth_release());
                AuthenticatorSelectionCriteria.Builder builder2 = new AuthenticatorSelectionCriteria.Builder();
                boolean optBoolean = jSONObject2.optBoolean(getJSON_KEY_REQUIRE_RES_KEY$credentials_play_services_auth_release(), false);
                String optString = jSONObject2.optString(getJSON_KEY_RES_KEY$credentials_play_services_auth_release(), "");
                m.e(optString, "residentKey");
                if (optString.length() > 0) {
                    residentKeyRequirement = ResidentKeyRequirement.fromString(optString);
                } else {
                    residentKeyRequirement = null;
                }
                builder2.setRequireResidentKey(Boolean.valueOf(optBoolean)).setResidentKeyRequirement(residentKeyRequirement);
                String optString2 = jSONObject2.optString(getJSON_KEY_AUTH_ATTACHMENT$credentials_play_services_auth_release(), "");
                m.e(optString2, "authenticatorAttachmentString");
                if (optString2.length() > 0) {
                    builder2.setAttachment(Attachment.fromString(optString2));
                }
                builder.setAuthenticatorSelection(builder2.build());
            }
        }

        public final void parseOptionalExtensions$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            m.f(jSONObject, "json");
            m.f(builder, "builder");
            if (jSONObject.has(getJSON_KEY_EXTENSTIONS$credentials_play_services_auth_release())) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(getJSON_KEY_EXTENSTIONS$credentials_play_services_auth_release());
                AuthenticationExtensions.Builder builder2 = new AuthenticationExtensions.Builder();
                String optString = jSONObject2.optString(getJSON_KEY_APPID$credentials_play_services_auth_release(), "");
                m.e(optString, "appIdExtension");
                if (optString.length() > 0) {
                    builder2.setFido2Extension(new FidoAppIdExtension(optString));
                }
                if (jSONObject2.optBoolean(getJSON_KEY_THIRD_PARTY_PAYMENT$credentials_play_services_auth_release(), false)) {
                    builder2.setGoogleThirdPartyPaymentExtension(new GoogleThirdPartyPaymentExtension(true));
                }
                if (jSONObject2.optBoolean("uvm", false)) {
                    builder2.setUserVerificationMethodExtension(new UserVerificationMethodExtension(true));
                }
                builder.setAuthenticationExtensions(builder2.build());
            }
        }

        public final void parseOptionalTimeout$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            m.f(jSONObject, "json");
            m.f(builder, "builder");
            if (jSONObject.has(getJSON_KEY_TIMEOUT$credentials_play_services_auth_release())) {
                builder.setTimeoutSeconds(Double.valueOf(((double) jSONObject.getLong(getJSON_KEY_TIMEOUT$credentials_play_services_auth_release())) / ((double) 1000)));
            }
        }

        public final void parseOptionalWithRequiredDefaultsAttestationAndExcludeCredentials$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            ArrayList arrayList;
            m.f(jSONObject, "json");
            m.f(builder, "builder");
            ArrayList arrayList2 = new ArrayList();
            if (jSONObject.has(getJSON_KEY_EXCLUDE_CREDENTIALS$credentials_play_services_auth_release())) {
                JSONArray jSONArray = jSONObject.getJSONArray(getJSON_KEY_EXCLUDE_CREDENTIALS$credentials_play_services_auth_release());
                int length = jSONArray.length();
                int i10 = 0;
                while (i10 < length) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    String string = jSONObject2.getString(getJSON_KEY_ID$credentials_play_services_auth_release());
                    m.e(string, "descriptorJSON.getString(JSON_KEY_ID)");
                    byte[] b64Decode = b64Decode(string);
                    String string2 = jSONObject2.getString(getJSON_KEY_TYPE$credentials_play_services_auth_release());
                    m.e(string2, "descriptorType");
                    if (string2.length() == 0) {
                        throw new JSONException("PublicKeyCredentialDescriptor type value is not found or unexpectedly empty");
                    } else if (b64Decode.length != 0) {
                        if (jSONObject2.has(getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release())) {
                            arrayList = new ArrayList();
                            JSONArray jSONArray2 = jSONObject2.getJSONArray(getJSON_KEY_TRANSPORTS$credentials_play_services_auth_release());
                            int length2 = jSONArray2.length();
                            int i11 = 0;
                            while (i11 < length2) {
                                try {
                                    Transport fromString = Transport.fromString(jSONArray2.getString(i11));
                                    m.e(fromString, "fromString(descriptorTransports.getString(j))");
                                    arrayList.add(fromString);
                                    i11++;
                                } catch (Transport.UnsupportedTransportException e10) {
                                    throw new CreatePublicKeyCredentialDomException(new EncodingError(), e10.getMessage());
                                }
                            }
                        } else {
                            arrayList = null;
                        }
                        arrayList2.add(new PublicKeyCredentialDescriptor(string2, b64Decode, arrayList));
                        i10++;
                    } else {
                        throw new JSONException("PublicKeyCredentialDescriptor id value is not found or unexpectedly empty");
                    }
                }
            }
            builder.setExcludeList(arrayList2);
            String jSON_KEY_ATTESTATION$credentials_play_services_auth_release = getJSON_KEY_ATTESTATION$credentials_play_services_auth_release();
            String str = DevicePublicKeyStringDef.NONE;
            String optString = jSONObject.optString(jSON_KEY_ATTESTATION$credentials_play_services_auth_release, str);
            m.e(optString, "attestationString");
            if (optString.length() != 0) {
                str = optString;
            }
            builder.setAttestationConveyancePreference(AttestationConveyancePreference.fromString(str));
        }

        public final void parseRequiredChallengeAndUser$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            m.f(jSONObject, "json");
            m.f(builder, "builder");
            builder.setChallenge(getChallenge(jSONObject));
            JSONObject jSONObject2 = jSONObject.getJSONObject(getJSON_KEY_USER$credentials_play_services_auth_release());
            String string = jSONObject2.getString(getJSON_KEY_ID$credentials_play_services_auth_release());
            m.e(string, "user.getString(JSON_KEY_ID)");
            byte[] b64Decode = b64Decode(string);
            String string2 = jSONObject2.getString(getJSON_KEY_NAME$credentials_play_services_auth_release());
            String string3 = jSONObject2.getString(getJSON_KEY_DISPLAY_NAME$credentials_play_services_auth_release());
            String optString = jSONObject2.optString(getJSON_KEY_ICON$credentials_play_services_auth_release(), "");
            m.e(string3, "displayName");
            if (string3.length() == 0) {
                throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing displayName or they are unexpectedly empty");
            } else if (b64Decode.length != 0) {
                m.e(string2, "userName");
                if (string2.length() != 0) {
                    builder.setUser(new PublicKeyCredentialUserEntity(b64Decode, string2, optString, string3));
                    return;
                }
                throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing user name or they are unexpectedly empty");
            } else {
                throw new JSONException("PublicKeyCredentialCreationOptions UserEntity missing user id or they are unexpectedly empty");
            }
        }

        public final void parseRequiredRpAndParams$credentials_play_services_auth_release(JSONObject jSONObject, PublicKeyCredentialCreationOptions.Builder builder) {
            m.f(jSONObject, "json");
            m.f(builder, "builder");
            JSONObject jSONObject2 = jSONObject.getJSONObject(getJSON_KEY_RP$credentials_play_services_auth_release());
            String string = jSONObject2.getString(getJSON_KEY_ID$credentials_play_services_auth_release());
            String optString = jSONObject2.optString(getJSON_KEY_NAME$credentials_play_services_auth_release(), "");
            String optString2 = jSONObject2.optString(getJSON_KEY_ICON$credentials_play_services_auth_release(), "");
            m.c(optString2);
            if (optString2.length() == 0) {
                optString2 = null;
            }
            m.e(optString, "rpName");
            if (optString.length() != 0) {
                m.e(string, "rpId");
                if (string.length() != 0) {
                    builder.setRp(new PublicKeyCredentialRpEntity(string, optString, optString2));
                    JSONArray jSONArray = jSONObject.getJSONArray(getJSON_KEY_PUB_KEY_CRED_PARAMS$credentials_play_services_auth_release());
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArray.length();
                    int i10 = 0;
                    while (i10 < length) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                        int i11 = (int) jSONObject3.getLong(getJSON_KEY_ALG$credentials_play_services_auth_release());
                        String optString3 = jSONObject3.optString(getJSON_KEY_TYPE$credentials_play_services_auth_release(), "");
                        m.e(optString3, "typeParam");
                        if (optString3.length() != 0) {
                            if (checkAlgSupported(i11)) {
                                arrayList.add(new PublicKeyCredentialParameters(optString3, i11));
                            }
                            i10++;
                        } else {
                            throw new JSONException("PublicKeyCredentialCreationOptions PublicKeyCredentialParameter type missing or unexpectedly empty");
                        }
                    }
                    builder.setParameters(arrayList);
                    return;
                }
                throw new JSONException("PublicKeyCredentialCreationOptions rp ID is missing or unexpectedly empty");
            }
            throw new JSONException("PublicKeyCredentialCreationOptions rp name is missing or unexpectedly empty");
        }

        public final CreateCredentialException publicKeyCredentialResponseContainsError(PublicKeyCredential publicKeyCredential) {
            m.f(publicKeyCredential, "cred");
            AuthenticatorResponse response = publicKeyCredential.getResponse();
            m.e(response, "cred.response");
            if (!(response instanceof AuthenticatorErrorResponse)) {
                return null;
            }
            AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) response;
            ErrorCode errorCode = authenticatorErrorResponse.getErrorCode();
            m.e(errorCode, "authenticatorResponse.errorCode");
            DomError domError = getOrderedErrorCodeToExceptions$credentials_play_services_auth_release().get(errorCode);
            String errorMessage = authenticatorErrorResponse.getErrorMessage();
            if (domError == null) {
                UnknownError unknownError = new UnknownError();
                return new CreatePublicKeyCredentialDomException(unknownError, "unknown fido gms exception - " + errorMessage);
            } else if (errorCode == ErrorCode.CONSTRAINT_ERR && errorMessage != null && j.K(errorMessage, "Unable to get sync account", false, 2, (Object) null)) {
                return new CreateCredentialCancellationException("Passkey registration was cancelled by the user.");
            } else {
                return new CreatePublicKeyCredentialDomException(domError, errorMessage);
            }
        }

        public final String toAssertPasskeyResponse(SignInCredential signInCredential) {
            AuthenticatorResponse authenticatorResponse;
            m.f(signInCredential, "cred");
            JSONObject jSONObject = new JSONObject();
            PublicKeyCredential publicKeyCredential = signInCredential.getPublicKeyCredential();
            if (publicKeyCredential != null) {
                authenticatorResponse = publicKeyCredential.getResponse();
            } else {
                authenticatorResponse = null;
            }
            m.c(authenticatorResponse);
            if (authenticatorResponse instanceof AuthenticatorErrorResponse) {
                AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) authenticatorResponse;
                ErrorCode errorCode = authenticatorErrorResponse.getErrorCode();
                m.e(errorCode, "authenticatorResponse.errorCode");
                throw beginSignInPublicKeyCredentialResponseContainsError$credentials_play_services_auth_release(errorCode, authenticatorErrorResponse.getErrorMessage());
            } else if (authenticatorResponse instanceof AuthenticatorAssertionResponse) {
                try {
                    String json = publicKeyCredential.toJson();
                    m.e(json, "publicKeyCred.toJson()");
                    return json;
                } catch (Throwable th) {
                    throw new GetCredentialUnknownException("The PublicKeyCredential response json had an unexpected exception when parsing: " + th.getMessage());
                }
            } else {
                Log.e(PublicKeyCredentialControllerUtility.TAG, "AuthenticatorResponse expected assertion response but got: " + authenticatorResponse.getClass().getName());
                String jSONObject2 = jSONObject.toString();
                m.e(jSONObject2, "json.toString()");
                return jSONObject2;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final PublicKeyCredentialCreationOptions convert(CreatePublicKeyCredentialRequest createPublicKeyCredentialRequest) {
        return Companion.convert(createPublicKeyCredentialRequest);
    }
}
