package com.geetest.gtc4;

import a9.a;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.geetest.gtc4.GeeGuard;
import com.geetest.gtc4.GeeGuardConfiguration;
import com.zing.zalo.zalosdk.common.Constant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static GeeGuardReceipt a(Context context, String str, String str2) {
        if (str == null) {
            return null;
        }
        String data = Core.getData(context.getApplicationContext(), new GeeGuardConfiguration.Builder().setAppId(str).addSignature(str2).build());
        String string = context.getSharedPreferences("gt_core", 0).getString("gt_gid3", (String) null);
        GeeGuardReceipt geeGuardReceipt = new GeeGuardReceipt();
        geeGuardReceipt.geeToken = data;
        geeGuardReceipt.geeID = string;
        geeGuardReceipt.appID = str;
        if (string != null && string.length() > 0) {
            String[] split = string.split("-");
            if (split.length == 4) {
                geeGuardReceipt.geeIDTimestamp = split[1];
            }
        }
        return geeGuardReceipt;
    }

    public static void a(String str, GeeGuardReceipt geeGuardReceipt, int i10, GeeGuard.CallbackHandler callbackHandler) {
        Pair pair;
        HashMap hashMap = new HashMap();
        hashMap.put("API-Version", "1");
        hashMap.put("AppID", str);
        hashMap.put("GeeID", geeGuardReceipt.geeID);
        hashMap.put("Client-Type", "1");
        String str2 = geeGuardReceipt.geeToken;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://riskct.geetest.com/g2/api/v1/client_report").openConnection();
            httpURLConnection.setConnectTimeout(i10 > 0 ? i10 : 5000);
            if (i10 <= 0) {
                i10 = 3000;
            }
            httpURLConnection.setReadTimeout(i10);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            if (hashMap.size() > 0) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(str2.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                outputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            Pair<Boolean, String> a10 = a(httpURLConnection.getInputStream());
            if (((Boolean) a10.first).booleanValue()) {
                pair = new Pair(Integer.valueOf(responseCode), (String) a10.second);
            } else {
                pair = new Pair(Integer.valueOf(-responseCode), (String) a10.second);
            }
        } catch (ProtocolException e10) {
            a.a(String.valueOf(-12), e10);
            pair = new Pair(-12, e10.toString());
        } catch (MalformedURLException e11) {
            a.a(String.valueOf(-11), e11);
            pair = new Pair(-11, e11.toString());
        } catch (IOException e12) {
            a.a(String.valueOf(-13), e12);
            pair = new Pair(-13, e12.toString());
        } catch (Exception e13) {
            a.a(String.valueOf(-14), e13);
            pair = new Pair(-14, e13.toString());
        }
        if (((Integer) pair.first).intValue() == 200) {
            geeGuardReceipt.originalResponse = (String) pair.second;
            try {
                JSONObject jSONObject = new JSONObject((String) pair.second);
                if (jSONObject.getInt(Constant.PARAM_OAUTH_CODE) == 0) {
                    geeGuardReceipt.respondedGeeToken = jSONObject.getJSONObject("data").getString("gee_token");
                    if (callbackHandler != null) {
                        callbackHandler.onCompletion(200, geeGuardReceipt);
                    }
                } else if (callbackHandler != null) {
                    callbackHandler.onCompletion(-501, geeGuardReceipt);
                }
            } catch (JSONException e14) {
                a.a(String.valueOf(-15), e14);
                if (callbackHandler != null) {
                    callbackHandler.onCompletion(-500, geeGuardReceipt);
                }
            }
        } else if (callbackHandler != null) {
            callbackHandler.onCompletion(-300, geeGuardReceipt);
        }
    }

    public static void a(Context context, String str, String str2, int i10, GeeGuard.CallbackHandler callbackHandler) {
        if (str == null) {
            a.a("Empty App ID", new IllegalArgumentException("Empty App ID"));
            if (callbackHandler != null) {
                callbackHandler.onCompletion(-200, (GeeGuardReceipt) null);
                return;
            }
            return;
        }
        GeeGuardReceipt a10 = a(context, str, str2);
        if (a10 != null) {
            new Thread(new a(str, a10, i10, callbackHandler)).start();
        } else if (callbackHandler != null) {
            callbackHandler.onCompletion(-200, (GeeGuardReceipt) null);
        }
    }

    public static Pair<Boolean, String> a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            Pair<Boolean, String> pair = new Pair<>(Boolean.TRUE, byteArrayOutputStream.toString());
            try {
                byteArrayOutputStream.close();
            } catch (IOException e10) {
                a.a(String.valueOf(-13), e10);
            }
            try {
                inputStream.close();
            } catch (IOException e11) {
                a.a(String.valueOf(-13), e11);
            }
            return pair;
        } catch (IOException e12) {
            a.a(String.valueOf(-13), e12);
            Pair<Boolean, String> pair2 = new Pair<>(Boolean.FALSE, e12.toString());
            try {
                byteArrayOutputStream.close();
            } catch (IOException e13) {
                a.a(String.valueOf(-13), e13);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e14) {
                    a.a(String.valueOf(-13), e14);
                }
            }
            return pair2;
        } catch (Exception e15) {
            a.a(String.valueOf(-14), e15);
            Pair<Boolean, String> pair3 = new Pair<>(Boolean.FALSE, e15.toString());
            try {
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                a.a(String.valueOf(-13), e16);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e17) {
                    a.a(String.valueOf(-13), e17);
                }
            }
            return pair3;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e18) {
                a.a(String.valueOf(-13), e18);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e19) {
                    a.a(String.valueOf(-13), e19);
                }
            }
            throw th;
        }
    }
}
