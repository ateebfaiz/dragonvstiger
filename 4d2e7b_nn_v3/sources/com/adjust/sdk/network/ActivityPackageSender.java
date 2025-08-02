package com.adjust.sdk.network;

import android.net.Uri;
import com.adjust.sdk.ActivityKind;
import com.adjust.sdk.ActivityPackage;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.ResponseData;
import com.adjust.sdk.TrackingState;
import com.adjust.sdk.Util;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityPackageSender implements IActivityPackageSender {
    private String basePath;
    private String clientSdk;
    private UtilNetworking.IConnectionOptions connectionOptions;
    private ThreadExecutor executor = new SingleThreadCachedScheduler("ActivityPackageSender");
    private String gdprPath;
    private UtilNetworking.IHttpsURLConnectionProvider httpsURLConnectionProvider;
    private ILogger logger = AdjustFactory.getLogger();
    private String subscriptionPath;
    private UrlStrategy urlStrategy;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IActivityPackageSender.ResponseDataCallbackSubscriber f17499a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f17500b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f17501c;

        public a(IActivityPackageSender.ResponseDataCallbackSubscriber responseDataCallbackSubscriber, ActivityPackage activityPackage, Map map) {
            this.f17499a = responseDataCallbackSubscriber;
            this.f17500b = activityPackage;
            this.f17501c = map;
        }

        public final void run() {
            this.f17499a.onResponseDataCallback(ActivityPackageSender.this.sendActivityPackageSync(this.f17500b, this.f17501c));
        }
    }

    public ActivityPackageSender(String str, String str2, String str3, String str4, String str5) {
        this.basePath = str2;
        this.gdprPath = str3;
        this.subscriptionPath = str4;
        this.clientSdk = str5;
        this.urlStrategy = new UrlStrategy(AdjustFactory.getBaseUrl(), AdjustFactory.getGdprUrl(), AdjustFactory.getSubscriptionUrl(), str);
        this.httpsURLConnectionProvider = AdjustFactory.getHttpsURLConnectionProvider();
        this.connectionOptions = AdjustFactory.getConnectionOptions();
    }

    private String buildAndExtractAuthorizationHeader(Map<String, String> map, ActivityKind activityKind) {
        String activityKind2 = activityKind.toString();
        String extractSecretId = extractSecretId(map);
        String buildAuthorizationHeaderV2 = buildAuthorizationHeaderV2(extractSignature(map), extractSecretId, extractHeadersId(map), extractAlgorithm(map), extractNativeVersion(map));
        return buildAuthorizationHeaderV2 != null ? buildAuthorizationHeaderV2 : buildAuthorizationHeaderV1(map, extractAppSecret(map), extractSecretId, activityKind2);
    }

    private String buildAuthorizationHeaderV1(Map<String, String> map, String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Map<String, String> signature = getSignature(map, str3, str);
        String sha256 = Util.sha256(signature.get("clear_signature"));
        String formatString = Util.formatString("Signature %s,%s,%s,%s", Util.formatString("secret_id=\"%s\"", str2), Util.formatString("signature=\"%s\"", sha256), Util.formatString("algorithm=\"%s\"", "sha256"), Util.formatString("headers=\"%s\"", signature.get("fields")));
        this.logger.verbose("authorizationHeader: %s", formatString);
        return formatString;
    }

    private String buildAuthorizationHeaderV2(String str, String str2, String str3, String str4, String str5) {
        if (str2 == null || str == null || str3 == null) {
            return null;
        }
        String formatString = Util.formatString("signature=\"%s\"", str);
        String formatString2 = Util.formatString("secret_id=\"%s\"", str2);
        String formatString3 = Util.formatString("headers_id=\"%s\"", str3);
        if (str4 == null) {
            str4 = "adj1";
        }
        String formatString4 = Util.formatString("algorithm=\"%s\"", str4);
        if (str5 == null) {
            str5 = "";
        }
        String formatString5 = Util.formatString("Signature %s,%s,%s,%s,%s", formatString, formatString2, formatString4, formatString3, Util.formatString("native_version=\"%s\"", str5));
        this.logger.verbose("authorizationHeader: %s", formatString5);
        return formatString5;
    }

    private DataOutputStream configConnectionForGET(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestMethod("GET");
        return null;
    }

    private DataOutputStream configConnectionForPOST(HttpsURLConnection httpsURLConnection, Map<String, String> map, Map<String, String> map2) {
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        String generatePOSTBodyString = generatePOSTBodyString(map, map2);
        if (generatePOSTBodyString == null) {
            return null;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(generatePOSTBodyString);
        return dataOutputStream;
    }

    private String errorMessage(Throwable th, String str, ActivityPackage activityPackage) {
        return Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th));
    }

    private static String extractAlgorithm(Map<String, String> map) {
        return map.remove("algorithm");
    }

    private static String extractAppSecret(Map<String, String> map) {
        return map.remove("app_secret");
    }

    private static void extractEventCallbackId(Map<String, String> map) {
        map.remove("event_callback_id");
    }

    private static String extractHeadersId(Map<String, String> map) {
        return map.remove("headers_id");
    }

    private static String extractNativeVersion(Map<String, String> map) {
        return map.remove("native_version");
    }

    private static String extractSecretId(Map<String, String> map) {
        return map.remove("secret_id");
    }

    private static String extractSignature(Map<String, String> map) {
        return map.remove("signature");
    }

    private String generatePOSTBodyString(Map<String, String> map, Map<String, String> map2) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        injectParametersToPOSTStringBuilder(map, sb2);
        injectParametersToPOSTStringBuilder(map2, sb2);
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '&') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb2.toString();
    }

    private String generateUrlStringForGET(ActivityKind activityKind, String str, Map<String, String> map, Map<String, String> map2) {
        URL url = new URL(urlWithExtraPathByActivityKind(activityKind, this.urlStrategy.targetUrlByActivityKind(activityKind)));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(url.getProtocol());
        builder.encodedAuthority(url.getAuthority());
        builder.path(url.getPath());
        builder.appendPath(str);
        this.logger.debug("Making request to url: %s", builder.toString());
        for (Map.Entry next : map.entrySet()) {
            builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        if (map2 != null) {
            for (Map.Entry next2 : map2.entrySet()) {
                builder.appendQueryParameter((String) next2.getKey(), (String) next2.getValue());
            }
        }
        return builder.build().toString();
    }

    private String generateUrlStringForPOST(ActivityKind activityKind, String str) {
        String formatString = Util.formatString("%s%s", urlWithExtraPathByActivityKind(activityKind, this.urlStrategy.targetUrlByActivityKind(activityKind)), str);
        this.logger.debug("Making request to url : %s", formatString);
        return formatString;
    }

    private Map<String, String> getSignature(Map<String, String> map, String str, String str2) {
        String validIdentifier = getValidIdentifier(map);
        String str3 = map.get("source");
        String str4 = map.get("payload");
        HashMap hashMap = new HashMap();
        hashMap.put("app_secret", str2);
        hashMap.put(DbParams.KEY_CREATED_AT, map.get(DbParams.KEY_CREATED_AT));
        hashMap.put("activity_kind", str);
        hashMap.put(validIdentifier, map.get(validIdentifier));
        if (str3 != null) {
            hashMap.put("source", str3);
        }
        if (str4 != null) {
            hashMap.put("payload", str4);
        }
        String str5 = "";
        String str6 = str5;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                str5 = str5 + ((String) entry.getKey()) + " ";
                str6 = str6 + ((String) entry.getValue());
            }
        }
        String substring = str5.substring(0, str5.length() - 1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("clear_signature", str6);
        hashMap2.put("fields", substring);
        return hashMap2;
    }

    private String getValidIdentifier(Map<String, String> map) {
        if (map.get("gps_adid") != null) {
            return "gps_adid";
        }
        if (map.get("fire_adid") != null) {
            return "fire_adid";
        }
        if (map.get("android_id") != null) {
            return "android_id";
        }
        if (map.get("android_uuid") != null) {
            return "android_uuid";
        }
        return null;
    }

    private void injectParametersToPOSTStringBuilder(Map<String, String> map, StringBuilder sb2) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                String encode = URLEncoder.encode((String) next.getKey(), "UTF-8");
                String str = (String) next.getValue();
                String encode2 = str != null ? URLEncoder.encode(str, "UTF-8") : "";
                sb2.append(encode);
                sb2.append("=");
                sb2.append(encode2);
                sb2.append("&");
            }
        }
    }

    private void localError(Throwable th, String str, ResponseData responseData) {
        String errorMessage = errorMessage(th, str, responseData.activityPackage);
        this.logger.error(errorMessage, new Object[0]);
        responseData.message = errorMessage;
        responseData.willRetry = false;
    }

    private void parseResponse(ResponseData responseData, String str) {
        JSONObject jSONObject;
        if (str.length() == 0) {
            this.logger.error("Empty response string", new Object[0]);
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e10) {
            this.logger.error(errorMessage(e10, "Failed to parse JSON response", responseData.activityPackage), new Object[0]);
            jSONObject = null;
        }
        if (jSONObject != null) {
            responseData.jsonResponse = jSONObject;
            responseData.message = UtilNetworking.extractJsonString(jSONObject, "message");
            responseData.adid = UtilNetworking.extractJsonString(jSONObject, "adid");
            responseData.timestamp = UtilNetworking.extractJsonString(jSONObject, "timestamp");
            String extractJsonString = UtilNetworking.extractJsonString(jSONObject, "tracking_state");
            if (extractJsonString != null && extractJsonString.equals("opted_out")) {
                responseData.trackingState = TrackingState.OPTED_OUT;
            }
            responseData.askIn = UtilNetworking.extractJsonLong(jSONObject, "ask_in");
            responseData.retryIn = UtilNetworking.extractJsonLong(jSONObject, "retry_in");
            responseData.continueIn = UtilNetworking.extractJsonLong(jSONObject, "continue_in");
            responseData.attribution = AdjustAttribution.fromJson(jSONObject.optJSONObject("attribution"), responseData.adid, Util.getSdkPrefixPlatform(this.clientSdk));
        }
    }

    private void remoteError(Throwable th, String str, ResponseData responseData) {
        String str2 = errorMessage(th, str, responseData.activityPackage) + " Will retry later";
        this.logger.error(str2, new Object[0]);
        responseData.message = str2;
        responseData.willRetry = true;
    }

    private boolean shouldRetryToSend(ResponseData responseData) {
        if (!responseData.willRetry) {
            this.logger.debug("Will not retry with current url strategy", new Object[0]);
            this.urlStrategy.resetAfterSuccess();
            return false;
        } else if (this.urlStrategy.shouldRetryAfterFailure(responseData.activityKind)) {
            this.logger.error("Failed with current url strategy, but it will retry with new", new Object[0]);
            return true;
        } else {
            this.logger.error("Failed with current url strategy and it will not retry", new Object[0]);
            return false;
        }
    }

    private void tryToGetResponse(ResponseData responseData) {
        String str;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            ActivityPackage activityPackage = responseData.activityPackage;
            HashMap hashMap = new HashMap(activityPackage.getParameters());
            Map<String, String> map = responseData.sendingParameters;
            String buildAndExtractAuthorizationHeader = buildAndExtractAuthorizationHeader(hashMap, activityPackage.getActivityKind());
            boolean z10 = true;
            boolean z11 = responseData.activityPackage.getActivityKind() == ActivityKind.ATTRIBUTION;
            if (z11) {
                extractEventCallbackId(hashMap);
                str = generateUrlStringForGET(activityPackage.getActivityKind(), activityPackage.getPath(), hashMap, map);
            } else {
                str = generateUrlStringForPOST(activityPackage.getActivityKind(), activityPackage.getPath());
            }
            HttpsURLConnection generateHttpsURLConnection = this.httpsURLConnectionProvider.generateHttpsURLConnection(new URL(str));
            this.connectionOptions.applyConnectionOptions(generateHttpsURLConnection, activityPackage.getClientSdk());
            if (buildAndExtractAuthorizationHeader != null) {
                generateHttpsURLConnection.setRequestProperty("Authorization", buildAndExtractAuthorizationHeader);
            }
            if (z11) {
                dataOutputStream = configConnectionForGET(generateHttpsURLConnection);
            } else {
                extractEventCallbackId(hashMap);
                dataOutputStream = configConnectionForPOST(generateHttpsURLConnection, hashMap, map);
            }
            Integer readConnectionResponse = readConnectionResponse(generateHttpsURLConnection, responseData);
            responseData.success = responseData.jsonResponse != null && responseData.retryIn == null && readConnectionResponse != null && readConnectionResponse.intValue() == 200;
            if (responseData.jsonResponse != null) {
                if (responseData.retryIn == null) {
                    z10 = false;
                }
            }
            responseData.willRetry = z10;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException e10) {
                    this.logger.error(errorMessage(e10, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (UnsupportedEncodingException e11) {
            localError(e11, "Failed to encode parameters", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e12) {
                    this.logger.error(errorMessage(e12, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (MalformedURLException e13) {
            localError(e13, "Malformed URL", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e14) {
                    this.logger.error(errorMessage(e14, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (ProtocolException e15) {
            localError(e15, "Protocol Error", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e16) {
                    this.logger.error(errorMessage(e16, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (SocketTimeoutException e17) {
            remoteError(e17, "Request timed out", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e18) {
                    this.logger.error(errorMessage(e18, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (SSLHandshakeException e19) {
            remoteError(e19, "Certificate failed", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e20) {
                    this.logger.error(errorMessage(e20, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (IOException e21) {
            remoteError(e21, "Request failed", responseData);
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e22) {
                    this.logger.error(errorMessage(e22, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (IOException e23) {
                    this.logger.error(errorMessage(e23, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
            throw th;
        }
    }

    private String urlWithExtraPathByActivityKind(ActivityKind activityKind, String str) {
        if (activityKind == ActivityKind.GDPR) {
            if (this.gdprPath == null) {
                return str;
            }
            return str + this.gdprPath;
        } else if (activityKind == ActivityKind.SUBSCRIPTION) {
            if (this.subscriptionPath == null) {
                return str;
            }
            return str + this.subscriptionPath;
        } else if (this.basePath == null) {
            return str;
        } else {
            return str + this.basePath;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r8 == null) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Integer readConnectionResponse(javax.net.ssl.HttpsURLConnection r8, com.adjust.sdk.ResponseData r9) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            r8.connect()     // Catch:{ IOException -> 0x001f }
            int r4 = r8.getResponseCode()     // Catch:{ IOException -> 0x001f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x001f }
            r5 = 400(0x190, float:5.6E-43)
            if (r4 < r5) goto L_0x0021
            java.io.InputStream r4 = r8.getErrorStream()     // Catch:{ IOException -> 0x001f }
            goto L_0x0025
        L_0x001c:
            r9 = move-exception
            goto L_0x00a4
        L_0x001f:
            r4 = move-exception
            goto L_0x0039
        L_0x0021:
            java.io.InputStream r4 = r8.getInputStream()     // Catch:{ IOException -> 0x001f }
        L_0x0025:
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x001f }
            r5.<init>(r4)     // Catch:{ IOException -> 0x001f }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x001f }
            r4.<init>(r5)     // Catch:{ IOException -> 0x001f }
        L_0x002f:
            java.lang.String r5 = r4.readLine()     // Catch:{ IOException -> 0x001f }
            if (r5 == 0) goto L_0x004a
            r2.append(r5)     // Catch:{ IOException -> 0x001f }
            goto L_0x002f
        L_0x0039:
            java.lang.String r5 = "Connecting and reading response"
            com.adjust.sdk.ActivityPackage r6 = r9.activityPackage     // Catch:{ all -> 0x001c }
            java.lang.String r4 = r7.errorMessage(r4, r5, r6)     // Catch:{ all -> 0x001c }
            com.adjust.sdk.ILogger r5 = r7.logger     // Catch:{ all -> 0x001c }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x001c }
            r5.error(r4, r6)     // Catch:{ all -> 0x001c }
            if (r8 == 0) goto L_0x004d
        L_0x004a:
            r8.disconnect()
        L_0x004d:
            int r8 = r2.length()
            if (r8 != 0) goto L_0x005d
            com.adjust.sdk.ILogger r8 = r7.logger
            java.lang.Object[] r9 = new java.lang.Object[r1]
            java.lang.String r0 = "Empty response string buffer"
            r8.error(r0, r9)
            return r3
        L_0x005d:
            int r8 = r3.intValue()
            r4 = 429(0x1ad, float:6.01E-43)
            if (r8 != r4) goto L_0x006f
            com.adjust.sdk.ILogger r8 = r7.logger
            java.lang.Object[] r9 = new java.lang.Object[r1]
            java.lang.String r0 = "Too frequent requests to the endpoint (429)"
            r8.error(r0, r9)
            return r3
        L_0x006f:
            java.lang.String r8 = r2.toString()
            com.adjust.sdk.ILogger r2 = r7.logger
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r1] = r8
            java.lang.String r5 = "Response string: %s"
            r2.debug(r5, r4)
            r7.parseResponse(r9, r8)
            java.lang.String r8 = r9.message
            if (r8 != 0) goto L_0x0086
            return r3
        L_0x0086:
            int r9 = r3.intValue()
            r2 = 200(0xc8, float:2.8E-43)
            java.lang.String r4 = "Response message: %s"
            if (r9 != r2) goto L_0x009a
            com.adjust.sdk.ILogger r9 = r7.logger
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r8
            r9.info(r4, r0)
            goto L_0x00a3
        L_0x009a:
            com.adjust.sdk.ILogger r9 = r7.logger
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r8
            r9.error(r4, r0)
        L_0x00a3:
            return r3
        L_0x00a4:
            if (r8 == 0) goto L_0x00a9
            r8.disconnect()
        L_0x00a9:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.network.ActivityPackageSender.readConnectionResponse(javax.net.ssl.HttpsURLConnection, com.adjust.sdk.ResponseData):java.lang.Integer");
    }

    public void sendActivityPackage(ActivityPackage activityPackage, Map<String, String> map, IActivityPackageSender.ResponseDataCallbackSubscriber responseDataCallbackSubscriber) {
        this.executor.submit(new a(responseDataCallbackSubscriber, activityPackage, map));
    }

    public ResponseData sendActivityPackageSync(ActivityPackage activityPackage, Map<String, String> map) {
        ResponseData buildResponseData;
        do {
            buildResponseData = ResponseData.buildResponseData(activityPackage, map);
            tryToGetResponse(buildResponseData);
        } while (shouldRetryToSend(buildResponseData));
        return buildResponseData;
    }
}
