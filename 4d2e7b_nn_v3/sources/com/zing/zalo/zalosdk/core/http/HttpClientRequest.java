package com.zing.zalo.zalosdk.core.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.devicetrackingsdk.DeviceTracking;
import com.zing.zalo.zalosdk.ZaloOAuthResultCode;
import com.zing.zalo.zalosdk.core.log.Log;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpClientRequest {
    private static final String BOUNDARY = "*****";
    private static final String LINE_END = "\r\n";
    private static final String TWO_HYPHENS = "--";
    private byte[] data;
    private String fileKey;
    private String fileName;
    public int liveResponseCode;
    private Map<String, String> mHeader = new HashMap();
    private Map<String, String> mParams = new HashMap();
    private Type mType;
    private String mUrl;

    public enum Type {
        GET,
        POST,
        POST_MULIIPART
    }

    public HttpClientRequest(Type type, String str) {
        this.mType = type;
        this.mUrl = str;
        addHeader("SDK-Source", "ZaloSDK-4.24.1101");
        addHeader("extInfo", DeviceTracking.getInstance().prepareCommonHeaderData().toString());
    }

    public static byte[] getByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            URL url = new URL(str);
            byte[] bArr = new byte[4096];
            InputStream openStream = url.openStream();
            while (true) {
                int read = openStream.read(bArr);
                if (read <= 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (MalformedURLException e10) {
            Log.w(e10.toString());
            return null;
        } catch (IOException e11) {
            Log.w(e11.toString());
            return null;
        }
    }

    private String getQueryString() {
        StringBuilder sb2 = new StringBuilder("");
        Map<String, String> map = this.mParams;
        if (map != null) {
            for (String next : map.keySet()) {
                try {
                    sb2.append(URLEncoder.encode(next, "UTF-8"));
                    sb2.append("=");
                    sb2.append(URLEncoder.encode(this.mParams.get(next), "UTF-8"));
                    sb2.append("&");
                } catch (Exception e10) {
                    Log.w(e10.toString());
                }
            }
        }
        return sb2.toString();
    }

    public void addHeader(String str, String str2) {
        this.mHeader.put(str, str2);
    }

    public void addParams(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public Bitmap getImage() {
        try {
            InputStream response = getResponse();
            if (response == null) {
                return null;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(response);
            response.close();
            return decodeStream;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject getJSON() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResponse()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine);
                    sb2.append("\n");
                } else {
                    bufferedReader.close();
                    String sb3 = sb2.toString();
                    Log.v("getJSON() from: " + this.mUrl + "=" + sb3);
                    JSONObject jSONObject = new JSONObject(sb3);
                    int optInt = jSONObject.optInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                    jSONObject.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, ZaloOAuthResultCode.findById(optInt));
                    jSONObject.put("extCode", optInt);
                    return jSONObject;
                }
            }
        } catch (Exception e10) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errorMsg", "" + "  " + e10.toString());
                return jSONObject2;
            } catch (JSONException e11) {
                e11.printStackTrace();
                Log.w(e10.toString());
                return null;
            }
        }
    }

    public String getJSONString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = this.mParams;
        if (map != null) {
            for (String next : map.keySet()) {
                try {
                    jSONObject.put(next, this.mParams.get(next));
                } catch (Exception e10) {
                    Log.w(e10.toString());
                }
            }
        }
        return jSONObject.toString(4);
    }

    public String getParamsString() {
        StringBuilder sb2 = new StringBuilder("{");
        Map<String, String> map = this.mParams;
        if (map != null) {
            for (String next : map.keySet()) {
                try {
                    sb2.append(next);
                    sb2.append("=");
                    sb2.append(this.mParams.get(next));
                } catch (Exception e10) {
                    Log.w(e10.toString());
                }
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    public InputStream getResponse() throws Exception {
        String str;
        OutputStream outputStream;
        Type type = this.mType;
        if (type == Type.POST) {
            Log.v("connect server : " + this.mUrl + " : " + getQueryString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            for (String next : this.mHeader.keySet()) {
                httpURLConnection.setRequestProperty(next, this.mHeader.get(next));
            }
            if (this.data != null) {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(this.data);
            } else {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(getQueryString().getBytes("UTF-8"));
            }
            outputStream.flush();
            outputStream.close();
            this.liveResponseCode = httpURLConnection.getResponseCode();
            Log.v("connect server POST " + this.liveResponseCode);
            return httpURLConnection.getInputStream();
        } else if (type == Type.POST_MULIIPART) {
            Log.v("connect server : " + this.mUrl + " : " + getQueryString());
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.mUrl).openConnection();
            httpURLConnection2.setDoInput(true);
            httpURLConnection2.setDoOutput(true);
            boolean z10 = false;
            httpURLConnection2.setUseCaches(false);
            httpURLConnection2.setConnectTimeout(120000);
            httpURLConnection2.setRequestMethod("POST");
            httpURLConnection2.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection2.setRequestProperty("ENCTYPE", "multipart/form-data");
            httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
            String str2 = this.fileName;
            if (str2 != null) {
                httpURLConnection2.setRequestProperty("uploaded_file", str2);
            }
            for (String next2 : this.mHeader.keySet()) {
                httpURLConnection2.setRequestProperty(next2, this.mHeader.get(next2));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
            for (String next3 : this.mParams.keySet()) {
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + next3 + "\"" + LINE_END);
                dataOutputStream.writeBytes("Content-Type: text/plain; charset=UTF-8\r\n");
                dataOutputStream.writeBytes(LINE_END);
                dataOutputStream.write(this.mParams.get(next3).getBytes("UTF-8"));
                dataOutputStream.writeBytes(LINE_END);
            }
            if (!(this.data == null || this.fileName == null || this.fileKey == null)) {
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=" + this.fileKey + ";filename=" + this.fileName + "" + LINE_END);
                dataOutputStream.writeBytes(LINE_END);
                dataOutputStream.write(this.data);
            }
            dataOutputStream.writeBytes(LINE_END);
            dataOutputStream.writeBytes("--*****--\r\n");
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection2.getResponseCode();
            Log.v("connect server POST_MULTIPART " + responseCode);
            this.liveResponseCode = httpURLConnection2.getResponseCode();
            if (responseCode < 300) {
                return httpURLConnection2.getInputStream();
            }
            String property = System.getProperty("line.separator");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getErrorStream()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (z10) {
                        str = property;
                    } else {
                        str = "";
                    }
                    sb2.append(str);
                    sb2.append(readLine);
                    z10 = true;
                } else {
                    Log.v(sb2.toString());
                    return null;
                }
            }
        } else {
            StringBuilder sb3 = new StringBuilder(this.mUrl);
            if (sb3.toString().contains("?")) {
                sb3.append("&platform=android");
            } else {
                sb3.append("?platform=android");
            }
            for (String next4 : this.mParams.keySet()) {
                try {
                    sb3.append("&");
                    sb3.append(URLEncoder.encode(next4, "UTF-8"));
                    sb3.append("=");
                    if (this.mParams.get(next4) != null) {
                        sb3.append(URLEncoder.encode(this.mParams.get(next4), "UTF-8").replace("+", "%20"));
                    } else {
                        sb3.append(URLEncoder.encode("", "UTF-8"));
                    }
                } catch (Exception e10) {
                    Log.w(e10.toString());
                }
            }
            Log.v("connect server GET : " + sb3.toString());
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(sb3.toString()).openConnection();
            for (String next5 : this.mHeader.keySet()) {
                httpURLConnection3.setRequestProperty(next5, this.mHeader.get(next5));
            }
            this.liveResponseCode = httpURLConnection3.getResponseCode();
            return httpURLConnection3.getInputStream();
        }
    }

    public int getResponseCode() {
        try {
            return ((HttpURLConnection) new URL(this.mUrl).openConnection()).getResponseCode();
        } catch (Exception e10) {
            Log.w(e10.toString());
            return 0;
        }
    }

    public String getText() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResponse()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (sb2.length() > 0) {
                        sb2.append("\n");
                    }
                    sb2.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb2.toString();
                }
            }
        } catch (Exception e10) {
            Log.w(e10.toString());
            return null;
        }
    }

    public void setBody(byte[] bArr) {
        this.data = bArr;
    }

    public void setMultipartFile(String str, String str2, byte[] bArr) {
        this.fileName = str;
        this.fileKey = str2;
        this.data = bArr;
    }
}
