package com.geetest.core;

import android.content.Context;
import android.util.Pair;
import com.geetest.core.GeeGuard;
import com.geetest.core.i6;
import com.zing.zalo.zalosdk.common.Constant;
import org.json.JSONObject;

public class b implements e6 {

    /* renamed from: a  reason: collision with root package name */
    public String f5924a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5925b = true;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GeeGuardReceipt f5926c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5927d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f5928e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5929f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GeeGuard.CallbackHandler f5930g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f5931h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f5932i;

    public b(GeeGuardReceipt geeGuardReceipt, String str, String str2, int i10, GeeGuard.CallbackHandler callbackHandler, Context context, String str3) {
        this.f5926c = geeGuardReceipt;
        this.f5927d = str;
        this.f5928e = str2;
        this.f5929f = i10;
        this.f5930g = callbackHandler;
        this.f5931h = context;
        this.f5932i = str3;
    }

    public void a(d6 d6Var) {
        if (d6Var.f5954a != f6.SUCCESS) {
            GeeGuard.CallbackHandler callbackHandler = this.f5930g;
            if (callbackHandler != null) {
                if (this.f5925b) {
                    callbackHandler.onCompletion(-300, this.f5926c);
                } else {
                    callbackHandler.onCompletion(200, this.f5926c);
                }
            }
        } else {
            try {
                GeeGuardReceipt a10 = c.a(this.f5931h, this.f5927d, this.f5932i);
                if (a10 == null) {
                    GeeGuard.CallbackHandler callbackHandler2 = this.f5930g;
                    if (callbackHandler2 != null) {
                        callbackHandler2.onCompletion(-200, this.f5926c);
                        return;
                    }
                    return;
                }
                i6 i6Var = d6Var.f5955b;
                i6.a aVar = i6Var.f6023a;
                i6.c cVar = i6Var.f6025c;
                i6.b bVar = i6Var.f6024b;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("out_id", this.f5924a);
                if (aVar != null) {
                    jSONObject.put("carrier", "CM");
                    jSONObject.put("token", aVar.f6031f);
                } else if (bVar != null) {
                    jSONObject.put("carrier", "CT");
                    jSONObject.put("token", bVar.f6033b);
                } else if (cVar != null) {
                    jSONObject.put("carrier", "CU");
                    jSONObject.put("token", cVar.f6036b);
                    jSONObject.put("province", cVar.f6035a);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("u_query", jSONObject);
                jSONObject2.put("gee_token", a10.geeToken);
                f fVar = new f();
                fVar.f5969a.put("API-Version", "1.1");
                fVar.f5969a.put("AppID", this.f5927d);
                fVar.f5969a.put("GeeID", a10.geeID);
                fVar.f5969a.put("Client-Type", "4");
                fVar.f5971c = jSONObject2.toString();
                fVar.f5970b = this.f5928e;
                Pair<Integer, String> a11 = c.a(fVar, this.f5929f);
                if (((Integer) a11.first).intValue() != 200) {
                    GeeGuard.CallbackHandler callbackHandler3 = this.f5930g;
                    if (callbackHandler3 != null) {
                        callbackHandler3.onCompletion(-300, a10);
                        return;
                    }
                    return;
                }
                a10.originalResponse = (String) a11.second;
                JSONObject jSONObject3 = new JSONObject((String) a11.second);
                if (jSONObject3.optInt(Constant.PARAM_OAUTH_CODE, -10000) != 0) {
                    GeeGuard.CallbackHandler callbackHandler4 = this.f5930g;
                    if (callbackHandler4 != null) {
                        callbackHandler4.onCompletion(-501, a10);
                        return;
                    }
                    return;
                }
                JSONObject optJSONObject = jSONObject3.optJSONObject("data");
                if (optJSONObject == null) {
                    GeeGuard.CallbackHandler callbackHandler5 = this.f5930g;
                    if (callbackHandler5 != null) {
                        callbackHandler5.onCompletion(-500, a10);
                        return;
                    }
                    return;
                }
                a10.respondedGeeToken = optJSONObject.getString("gee_token");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("u_info");
                if (optJSONObject2 != null) {
                    if (optJSONObject2.length() != 0) {
                        c.a(optJSONObject2.optString("info"), this.f5931h.getSharedPreferences("gt_core", 0));
                        GeeGuard.CallbackHandler callbackHandler6 = this.f5930g;
                        if (callbackHandler6 != null) {
                            callbackHandler6.onCompletion(200, a10);
                            return;
                        }
                        return;
                    }
                }
                GeeGuard.CallbackHandler callbackHandler7 = this.f5930g;
                if (callbackHandler7 != null) {
                    callbackHandler7.onCompletion(-500, a10);
                }
            } catch (Exception e10) {
                a.a(String.valueOf(-15), e10);
                GeeGuard.CallbackHandler callbackHandler8 = this.f5930g;
                if (callbackHandler8 != null) {
                    callbackHandler8.onCompletion(-500, this.f5926c);
                }
            }
        }
    }

    public l6 a(String str, String str2) {
        j6 j6Var = new j6();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("client_type", str2);
            jSONObject.put("carrier", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("gee_token", this.f5926c.geeToken);
            jSONObject2.put("u_sign", jSONObject);
            f fVar = new f();
            fVar.f5969a.put("API-Version", "1.1");
            fVar.f5969a.put("AppID", this.f5927d);
            fVar.f5969a.put("GeeID", this.f5926c.geeID);
            fVar.f5969a.put("Client-Type", "4");
            fVar.f5971c = jSONObject2.toString();
            fVar.f5970b = this.f5928e;
            Pair<Integer, String> a10 = c.a(fVar, this.f5929f);
            if (((Integer) a10.first).intValue() == 200) {
                JSONObject jSONObject3 = new JSONObject((String) a10.second);
                if (jSONObject3.optInt(Constant.PARAM_OAUTH_CODE, -10000) == 0) {
                    JSONObject optJSONObject = jSONObject3.optJSONObject("data");
                    if (optJSONObject != null) {
                        this.f5926c.respondedGeeToken = optJSONObject.getString("gee_token");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("u_token");
                        if (optJSONObject2 != null) {
                            if (optJSONObject2.length() != 0) {
                                String optString = optJSONObject2.optString("appId");
                                String optString2 = optJSONObject2.optString("sign");
                                String optString3 = optJSONObject2.optString("format");
                                String optString4 = optJSONObject2.optString("paramKey");
                                String optString5 = optJSONObject2.optString("paramStr");
                                String optString6 = optJSONObject2.optString("traceId");
                                String optString7 = optJSONObject2.optString("msgId");
                                String optString8 = optJSONObject2.optString("version");
                                int optInt = optJSONObject2.optInt("businessType");
                                String optString9 = optJSONObject2.optString("timestamp");
                                this.f5924a = optString6;
                                j6Var.f6070a = optString;
                                j6Var.f6045c = optString2;
                                j6Var.f6046d = optString3;
                                j6Var.f6047e = optString4;
                                j6Var.f6048f = optString5;
                                j6Var.f6049g = optString6;
                                j6Var.f6050h = optString7;
                                j6Var.f6051i = optString8;
                                j6Var.f6052j = optInt;
                                j6Var.f6071b = optString9;
                                return j6Var;
                            }
                        }
                        this.f5925b = false;
                    }
                }
            }
            return null;
        } catch (Exception unused) {
            return j6Var;
        }
    }
}
