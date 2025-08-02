package com.cocos.lib;

import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class CocosHttpURLConnection {
    private static final String PATCH_METHOD = "PATCH";
    private static final String POST_METHOD = "POST";
    private static final String PUT_METHOD = "PUT";
    private static final String TAG = "CocosHttpURLConnection";
    public static CocoslibCallback cocoslibCallback;
    public static CocosMahAgent mahAgent;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19285a;

        a(String str) {
            this.f19285a = str;
        }

        public void run() {
            CocosJavascriptJavaBridge.evalString(this.f19285a);
        }
    }

    static void addRequestHeader(HttpURLConnection httpURLConnection, String str, String str2) {
        httpURLConnection.setRequestProperty(str, str2);
    }

    public static String combinCookies(List<String> list, String str) {
        StringBuilder sb2 = new StringBuilder();
        String str2 = "FALSE";
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = DomExceptionUtils.SEPARATOR;
        String str7 = str;
        for (String split : list) {
            int i10 = 0;
            for (String str8 : split.split(";")) {
                int indexOf = str8.indexOf("=");
                if (-1 != indexOf) {
                    String[] strArr = {str8.substring(i10, indexOf), str8.substring(indexOf + 1)};
                    if ("expires".equalsIgnoreCase(strArr[i10].trim())) {
                        str5 = str2Seconds(strArr[1].trim());
                    } else {
                        if ("path".equalsIgnoreCase(strArr[i10].trim())) {
                            str6 = strArr[1];
                        } else if ("secure".equalsIgnoreCase(strArr[0].trim())) {
                            str2 = strArr[1];
                        } else if ("domain".equalsIgnoreCase(strArr[0].trim())) {
                            str7 = strArr[1];
                        } else {
                            i10 = 0;
                            if (!"version".equalsIgnoreCase(strArr[0].trim()) && !"max-age".equalsIgnoreCase(strArr[0].trim())) {
                                str3 = strArr[0];
                                str4 = strArr[1];
                            }
                        }
                        i10 = 0;
                    }
                }
            }
            if (str7 == null) {
                str7 = DevicePublicKeyStringDef.NONE;
            }
            sb2.append(str7);
            sb2.append(9);
            sb2.append("FALSE");
            sb2.append(9);
            sb2.append(str6);
            sb2.append(9);
            sb2.append(str2);
            sb2.append(9);
            sb2.append(str5);
            sb2.append("\t");
            sb2.append(str3);
            sb2.append("\t");
            sb2.append(str4);
            sb2.append(10);
        }
        return sb2.toString();
    }

    static int connect(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            Log.d(TAG, "createHttpURLConnection: connect ok");
            return 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.e(TAG, "connect" + e10.toString());
            if (!httpURLConnection.getURL().getPath().contains("home/login")) {
                return 1;
            }
            CocosHelper.runOnGameThread(new a(String.format("window['G']?.PlatformUtils?.connectFail(\"%s\", \"%s\");", new Object[]{httpURLConnection.getRequestProperty("x-request-id"), e10.toString().replace("\"", " ")})));
            return 1;
        }
    }

    static HttpURLConnection createHttpURLConnection(String str) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str);
            CocosMahAgent cocosMahAgent = mahAgent;
            if (cocosMahAgent != null) {
                httpURLConnection = cocosMahAgent.createProxyConnection(url);
            } else {
                httpURLConnection = null;
            }
            if (httpURLConnection == null) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        } catch (MalformedURLException unused) {
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.e(TAG, "createHttpURLConnection:" + e10.toString());
            return null;
        }
    }

    static void disconnect(HttpURLConnection httpURLConnection) {
        httpURLConnection.disconnect();
    }

    static int getResponseCode(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.e(TAG, "getResponseCode:" + e10.toString());
            return 0;
        }
    }

    static byte[] getResponseContent(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            String contentEncoding = httpURLConnection.getContentEncoding();
            if (contentEncoding != null) {
                if (contentEncoding.equalsIgnoreCase("gzip")) {
                    inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                } else if (contentEncoding.equalsIgnoreCase("deflate")) {
                    inputStream = new InflaterInputStream(httpURLConnection.getInputStream());
                }
            }
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.e(TAG, "1 getResponseContent: " + e10.toString());
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            Log.e(TAG, "2 getResponseContent:" + e11.toString());
            return null;
        }
    }

    static String getResponseHeaderByIdx(HttpURLConnection httpURLConnection, int i10) {
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return null;
        }
        int i11 = 0;
        for (Map.Entry next : headerFields.entrySet()) {
            if (i11 == i10) {
                String str = (String) next.getKey();
                if (str == null) {
                    return listToString((List) next.getValue(), ",") + "\n";
                }
                return str + ":" + listToString((List) next.getValue(), ",") + "\n";
            }
            i11++;
        }
        return null;
    }

    static String getResponseHeaderByKey(HttpURLConnection httpURLConnection, String str) {
        Map<String, List<String>> headerFields;
        if (str == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return null;
        }
        for (Map.Entry next : headerFields.entrySet()) {
            if (str.equalsIgnoreCase((String) next.getKey())) {
                if ("set-cookie".equalsIgnoreCase(str)) {
                    return combinCookies((List) next.getValue(), httpURLConnection.getURL().getHost());
                }
                return listToString((List) next.getValue(), ",");
            }
        }
        return null;
    }

    static int getResponseHeaderByKeyInt(HttpURLConnection httpURLConnection, String str) {
        String headerField = httpURLConnection.getHeaderField(str);
        if (headerField == null) {
            return 0;
        }
        return Integer.parseInt(headerField);
    }

    static String getResponseHeaders(HttpURLConnection httpURLConnection) {
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return null;
        }
        String str = "";
        for (Map.Entry next : headerFields.entrySet()) {
            String str2 = (String) next.getKey();
            if (str2 == null) {
                str = str + listToString((List) next.getValue(), ",") + "\n";
            } else {
                str = str + str2 + ":" + listToString((List) next.getValue(), ",") + "\n";
            }
        }
        return str;
    }

    static String getResponseMessage(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseMessage();
        } catch (Exception e10) {
            e10.printStackTrace();
            String obj = e10.toString();
            Log.e(TAG, "getResponseMessage: " + obj);
            return obj;
        }
    }

    public static String listToString(List<String> list, String str) {
        if (list == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = false;
        for (String next : list) {
            if (z10) {
                sb2.append(str);
            }
            if (next == null) {
                next = "";
            }
            sb2.append(next);
            z10 = true;
        }
        return sb2.toString();
    }

    static void sendRequest(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            if (bArr != null) {
                outputStream.write(bArr);
                outputStream.flush();
            }
            outputStream.close();
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.e(TAG, "sendRequest:" + e10.toString());
        }
    }

    static void setReadAndConnectTimeout(HttpURLConnection httpURLConnection, int i10, int i11) {
        httpURLConnection.setReadTimeout(i10);
        httpURLConnection.setConnectTimeout(i11);
    }

    static void setRequestMethod(HttpURLConnection httpURLConnection, String str) {
        try {
            httpURLConnection.setRequestMethod(str);
            if (!str.equalsIgnoreCase(POST_METHOD) && !str.equalsIgnoreCase(PUT_METHOD)) {
                if (!str.equalsIgnoreCase(PATCH_METHOD)) {
                    return;
                }
            }
            httpURLConnection.setDoOutput(true);
        } catch (ProtocolException e10) {
            Log.e(TAG, "setRequestMethod:" + e10.toString());
        }
    }

    static void setVerifySSL(HttpURLConnection httpURLConnection, String str) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                if (str.startsWith(DomExceptionUtils.SEPARATOR)) {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                } else {
                    bufferedInputStream = new BufferedInputStream(GlobalObject.getContext().getAssets().open(str.substring(7)));
                }
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(bufferedInputStream);
                PrintStream printStream = System.out;
                printStream.println("ca=" + ((X509Certificate) generateCertificate).getSubjectDN());
                bufferedInputStream.close();
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load((InputStream) null, (char[]) null);
                instance.setCertificateEntry("ca", generateCertificate);
                TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance2.init(instance);
                SSLContext instance3 = SSLContext.getInstance("TLS");
                instance3.init((KeyManager[]) null, instance2.getTrustManagers(), (SecureRandom) null);
                httpsURLConnection.setSSLSocketFactory(instance3.getSocketFactory());
            } catch (Exception e10) {
                e10.printStackTrace();
                Log.e(TAG, "setVerifySSL:" + e10.toString());
            }
        }
    }

    private static String str2Seconds(String str) {
        long j10;
        Calendar instance = Calendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat("EEE, dd-MMM-yy hh:mm:ss zzz", Locale.US).parse(str));
            j10 = instance.getTimeInMillis() / 1000;
        } catch (ParseException e10) {
            Log.e(TAG, "str2Seconds: " + e10.toString());
            j10 = 0;
        }
        return Long.toString(j10);
    }

    static void trackException(String str, String str2) {
        CocoslibCallback cocoslibCallback2 = cocoslibCallback;
        if (cocoslibCallback2 != null) {
            cocoslibCallback2.onHttpException(str, str2);
        }
    }
}
