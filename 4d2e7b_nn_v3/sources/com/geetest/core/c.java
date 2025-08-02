package com.geetest.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.InputDeviceCompat;
import com.geetest.core.GeeGuard;
import com.geetest.core.GeeGuardConfiguration;
import com.geetest.core.q6;
import com.zing.zalo.zalosdk.common.Constant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import z8.b;
import z8.d;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c5 f5938a;

    public static String a(int i10) {
        if (i10 == 64) {
            return "APPLICATION";
        }
        if (i10 != 128) {
            return i10 != 192 ? "UNIVERSAL" : "PRIVATE";
        }
        return "CONTEXT";
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            for (Network networkInfo : connectivityManager.getAllNetworks()) {
                if (connectivityManager.getNetworkInfo(networkInfo).getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static byte[] c(n4 n4Var, i4 i4Var) {
        byte[] bArr = ((g4) n4Var.f6113d.get(i4Var)).f5984d;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    public static Date d(n4 n4Var, i4 i4Var) {
        return new Date(((p4) n4Var.f6113d.get(i4Var)).f6136c.longValue());
    }

    public static int e(n4 n4Var, i4 i4Var) {
        return ((p4) n4Var.f6113d.get(i4Var)).f6136c.intValue();
    }

    public static Set<Integer> f(n4 n4Var, i4 i4Var) {
        HashSet hashSet = new HashSet();
        Iterator<i4> it = ((f4) n4Var.f6113d.get(i4Var)).f5976d.iterator();
        while (it.hasNext()) {
            hashSet.add(Integer.valueOf(((p4) it.next()).f6136c.intValue()));
        }
        return hashSet;
    }

    public static long g(n4 n4Var, i4 i4Var) {
        return ((p4) n4Var.f6113d.get(i4Var)).f6136c.longValue();
    }

    public static String h(n4 n4Var, i4 i4Var) {
        return new String(c(n4Var, i4Var), StandardCharsets.UTF_8);
    }

    public static StringBuffer a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry next : map.entrySet()) {
                stringBuffer.append((String) next.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) next.getValue());
                stringBuffer.append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return stringBuffer;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.geetest.core.o5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: com.geetest.core.o5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: com.geetest.core.t5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: com.geetest.core.u5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: com.geetest.core.w5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: com.geetest.core.c6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: com.geetest.core.a6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: com.geetest.core.b6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: com.geetest.core.n5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: com.geetest.core.z5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v43, resolved type: com.geetest.core.y5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: com.geetest.core.r5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v45, resolved type: com.geetest.core.p5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: com.geetest.core.o5} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0197  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.geetest.core.c5 c(android.content.Context r5) {
        /*
            if (r5 == 0) goto L_0x000a
            boolean r0 = r5 instanceof android.app.Application
            if (r0 != 0) goto L_0x000a
            android.content.Context r5 = r5.getApplicationContext()
        L_0x000a:
            com.geetest.core.c5 r0 = f5938a
            if (r0 == 0) goto L_0x000f
            return r0
        L_0x000f:
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "LENOVO"
            boolean r2 = r0.equalsIgnoreCase(r1)
            if (r2 != 0) goto L_0x0180
            java.lang.String r2 = android.os.Build.BRAND
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0180
            java.lang.String r1 = "ZUK"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x002b
            goto L_0x0180
        L_0x002b:
            java.lang.String r1 = "MOTOLORA"
            boolean r3 = r0.equalsIgnoreCase(r1)
            if (r3 != 0) goto L_0x0180
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x003b
            goto L_0x0180
        L_0x003b:
            java.lang.String r1 = "MEIZU"
            boolean r3 = r0.equalsIgnoreCase(r1)
            if (r3 != 0) goto L_0x017a
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x017a
            java.lang.String r1 = android.os.Build.DISPLAY
            java.lang.String r1 = r1.toUpperCase()
            java.lang.String r3 = "FLYME"
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto L_0x0059
            goto L_0x017a
        L_0x0059:
            java.lang.String r1 = "NUBIA"
            boolean r3 = r0.equalsIgnoreCase(r1)
            if (r3 != 0) goto L_0x0174
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0069
            goto L_0x0174
        L_0x0069:
            java.lang.String r1 = "XIAOMI"
            boolean r3 = r0.equalsIgnoreCase(r1)
            if (r3 != 0) goto L_0x016e
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x016e
            java.lang.String r1 = "REDMI"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0081
            goto L_0x016e
        L_0x0081:
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r3 = ""
            java.lang.String r1 = a((java.lang.String) r1, (java.lang.String) r3)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r1 = r1 ^ 1
            if (r1 != 0) goto L_0x016e
            java.lang.String r1 = "BLACKSHARK"
            boolean r4 = r0.equalsIgnoreCase(r1)
            if (r4 != 0) goto L_0x016e
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00a1
            goto L_0x016e
        L_0x00a1:
            java.lang.String r1 = "SAMSUNG"
            boolean r4 = r0.equalsIgnoreCase(r1)
            if (r4 != 0) goto L_0x0168
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00b1
            goto L_0x0168
        L_0x00b1:
            java.lang.String r1 = "VIVO"
            boolean r4 = r0.equalsIgnoreCase(r1)
            if (r4 != 0) goto L_0x0162
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0162
            java.lang.String r1 = "ro.vivo.os.version"
            java.lang.String r1 = a((java.lang.String) r1, (java.lang.String) r3)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00cd
            goto L_0x0162
        L_0x00cd:
            java.lang.String r1 = "ASUS"
            boolean r4 = r0.equalsIgnoreCase(r1)
            if (r4 != 0) goto L_0x015c
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00dd
            goto L_0x015c
        L_0x00dd:
            java.lang.String r1 = "OPPO"
            boolean r4 = r0.equalsIgnoreCase(r1)
            if (r4 != 0) goto L_0x014a
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x014a
            java.lang.String r1 = "REALME"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x014a
            java.lang.String r1 = "ro.build.version.opporom"
            java.lang.String r1 = a((java.lang.String) r1, (java.lang.String) r3)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0100
            goto L_0x014a
        L_0x0100:
            java.lang.String r1 = "ONEPLUS"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x014a
            boolean r0 = r2.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x010f
            goto L_0x014a
        L_0x010f:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ Exception -> 0x0120 }
            java.lang.String r1 = "com.coolpad.deviceidsupport"
            r2 = 0
            r0.getPackageInfo(r1, r2)     // Catch:{ Exception -> 0x0120 }
            com.geetest.core.o5 r0 = new com.geetest.core.o5
            r0.<init>(r5)
            goto L_0x0185
        L_0x0120:
            java.lang.String r0 = "ro.odm.manufacturer"
            java.lang.String r0 = a((java.lang.String) r0, (java.lang.String) r3)
            java.lang.String r1 = "PRIZE"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0134
            com.geetest.core.p5 r0 = new com.geetest.core.p5
            r0.<init>(r5)
            goto L_0x0185
        L_0x0134:
            java.lang.String r0 = "ro.build.freeme.label"
            java.lang.String r0 = a((java.lang.String) r0, (java.lang.String) r3)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0148
            com.geetest.core.r5 r0 = new com.geetest.core.r5
            r0.<init>(r5)
            goto L_0x0185
        L_0x0148:
            r0 = 0
            goto L_0x0185
        L_0x014a:
            com.geetest.core.z5 r0 = new com.geetest.core.z5
            r0.<init>(r5)
            boolean r1 = r0.a()
            if (r1 == 0) goto L_0x0156
            goto L_0x0185
        L_0x0156:
            com.geetest.core.y5 r0 = new com.geetest.core.y5
            r0.<init>(r5)
            goto L_0x0185
        L_0x015c:
            com.geetest.core.n5 r0 = new com.geetest.core.n5
            r0.<init>(r5)
            goto L_0x0185
        L_0x0162:
            com.geetest.core.b6 r0 = new com.geetest.core.b6
            r0.<init>(r5)
            goto L_0x0185
        L_0x0168:
            com.geetest.core.a6 r0 = new com.geetest.core.a6
            r0.<init>(r5)
            goto L_0x0185
        L_0x016e:
            com.geetest.core.c6 r0 = new com.geetest.core.c6
            r0.<init>(r5)
            goto L_0x0185
        L_0x0174:
            com.geetest.core.w5 r0 = new com.geetest.core.w5
            r0.<init>(r5)
            goto L_0x0185
        L_0x017a:
            com.geetest.core.u5 r0 = new com.geetest.core.u5
            r0.<init>(r5)
            goto L_0x0185
        L_0x0180:
            com.geetest.core.t5 r0 = new com.geetest.core.t5
            r0.<init>(r5)
        L_0x0185:
            f5938a = r0
            if (r0 == 0) goto L_0x0197
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0197
            com.geetest.core.c5 r5 = f5938a
            r5.getClass()
            com.geetest.core.c5 r5 = f5938a
            return r5
        L_0x0197:
            com.geetest.core.v5 r0 = new com.geetest.core.v5
            r0.<init>(r5)
            boolean r1 = r0.a()
            if (r1 == 0) goto L_0x01a3
            goto L_0x01b4
        L_0x01a3:
            com.geetest.core.s5 r0 = new com.geetest.core.s5
            r0.<init>(r5)
            boolean r5 = r0.a()
            if (r5 == 0) goto L_0x01af
            goto L_0x01b4
        L_0x01af:
            com.geetest.core.q5 r0 = new com.geetest.core.q5
            r0.<init>()
        L_0x01b4:
            f5938a = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.c.c(android.content.Context):com.geetest.core.c5");
    }

    public static Long e(v vVar) throws CertificateParsingException {
        if (vVar instanceof f0) {
            BigInteger j10 = ((f0) vVar).j();
            if (j10.compareTo(BigInteger.valueOf(LocationRequestCompat.PASSIVE_INTERVAL)) <= 0 && j10.compareTo(BigInteger.ZERO) >= 0) {
                return Long.valueOf(j10.longValue());
            }
            throw new CertificateParsingException("INTEGER out of bounds");
        }
        throw new CertificateParsingException("Integer value expected, " + vVar.getClass().getName() + " found.");
    }

    public static List<Boolean> b(n4 n4Var, i4 i4Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<i4> it = ((f4) n4Var.f6113d.get(i4Var)).f5976d.iterator();
        while (it.hasNext()) {
            s4 s4Var = ((r4) it.next()).f6164i;
            if (s4Var == s4.FALSE) {
                arrayList.add(Boolean.FALSE);
            } else if (s4Var == s4.TRUE) {
                arrayList.add(Boolean.TRUE);
            } else {
                throw new RuntimeException("Map contains more than booleans: " + n4Var);
            }
        }
        return arrayList;
    }

    public static Set<Integer> d(v vVar) throws CertificateParsingException {
        if (vVar instanceof w0) {
            HashSet hashSet = new HashSet();
            w0 w0Var = (w0) vVar;
            w0Var.getClass();
            u0 u0Var = new u0(w0Var);
            while (u0Var.hasMoreElements()) {
                hashSet.add(Integer.valueOf(c((v) (f0) u0Var.nextElement())));
            }
            return hashSet;
        }
        throw new CertificateParsingException("Expected set, found " + vVar.getClass().getName());
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || !(obj == null || obj2 == null || !obj.equals(obj2));
    }

    public static String f(v vVar) throws CertificateParsingException, UnsupportedEncodingException {
        if (vVar instanceof l0) {
            return new String(((l0) vVar).f6066c, StandardCharsets.UTF_8);
        }
        throw new CertificateParsingException("Expected octet string, found " + vVar.getClass().getName());
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            Method declaredMethod = Class.forName(connectivityManager.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", (Class[]) null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, (Object[]) null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static HttpURLConnection a(String str, Network network, StringBuffer stringBuffer) throws Exception {
        URL url;
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        try {
            url = new URL(str);
        } catch (Exception unused) {
            url = null;
        }
        if (url == null) {
            stringBuffer.append("Error: Parse URL fail");
            return null;
        }
        q6 q6Var = q6.a.f6148a;
        String host = url.getHost();
        if (!q6Var.f6147a.contains(host)) {
            q6Var.f6147a.add(host);
        }
        try {
            if ("https".equals(url.getProtocol().toLowerCase())) {
                if (network != null) {
                    httpsURLConnection = (HttpsURLConnection) network.openConnection(url);
                } else {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection();
                }
                HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                httpsURLConnection2.setHostnameVerifier(new r6());
                return httpsURLConnection2;
            }
            if (network != null) {
                httpURLConnection = (HttpURLConnection) network.openConnection(url);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            return httpURLConnection;
        } catch (Exception e10) {
            stringBuffer.append("Url: ");
            stringBuffer.append(str);
            stringBuffer.append(", Error: ");
            stringBuffer.append(e10.toString());
            return null;
        }
    }

    public static byte[] b(v vVar) throws CertificateParsingException {
        if (vVar != null && (vVar instanceof d2)) {
            return ((l0) vVar).f6066c;
        }
        throw new CertificateParsingException("Expected DEROctetString");
    }

    public static v b(byte[] bArr) throws CertificateParsingException {
        e0 e0Var;
        try {
            e0Var = new e0(bArr);
            p0 a10 = e0Var.a();
            e0Var.close();
            return a10;
        } catch (IOException e10) {
            throw new CertificateParsingException("Failed to parse Encodable", e10);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static Pair<Boolean, String> b(InputStream inputStream) {
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

    public static void a(String str, SharedPreferences sharedPreferences) {
        if (!TextUtils.isEmpty(str) && sharedPreferences != null) {
            b bVar = new b(str);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            bVar.a(edit);
            edit.apply();
            String string = sharedPreferences.getString("gt_ggwid_obj", (String) null);
            if (string == null) {
                z8.c cVar = new z8.c(str);
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                cVar.a(edit2);
                edit2.apply();
            } else if (!string.equals(str)) {
                d dVar = new d(str);
                SharedPreferences.Editor edit3 = sharedPreferences.edit();
                dVar.a(edit3);
                edit3.apply();
            }
        }
    }

    public static GeeGuardReceipt a(Context context, String str, String str2) {
        if (context == null || str == null) {
            return null;
        }
        String data = Core.getData(context.getApplicationContext(), new GeeGuardConfiguration.Builder().setAppId(str).addSignature(str2).build());
        String string = context.getSharedPreferences("gt_core", 0).getString("gt_gid3", (String) null);
        GeeGuardReceipt geeGuardReceipt = new GeeGuardReceipt();
        geeGuardReceipt.geeToken = data;
        geeGuardReceipt.geeID = string;
        geeGuardReceipt.appID = str;
        if (string != null && !string.isEmpty()) {
            String[] split = string.split("-");
            if (split.length == 4) {
                geeGuardReceipt.geeIDTimestamp = split[1];
            }
        }
        return geeGuardReceipt;
    }

    public static Boolean a(n4 n4Var, i4 i4Var) {
        s4 s4Var = ((r4) n4Var.f6113d.get(i4Var)).f6164i;
        s4 s4Var2 = s4.TRUE;
        if (s4Var == s4Var2 || s4Var == s4.FALSE) {
            return Boolean.valueOf(s4Var == s4Var2);
        }
        throw new RuntimeException("Only expecting boolean values for " + i4Var);
    }

    public static int a(List<X509Certificate> list) throws GeneralSecurityException {
        X509Certificate x509Certificate = list.get(list.size() - 1);
        int size = list.size() - 1;
        X509Certificate x509Certificate2 = x509Certificate;
        while (size >= 0) {
            X509Certificate x509Certificate3 = list.get(size);
            x509Certificate3.checkValidity();
            x509Certificate3.verify(x509Certificate2.getPublicKey());
            size--;
            x509Certificate2 = x509Certificate3;
        }
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        if (Arrays.equals(encoded, Base64.decode("MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAr7bHgiuxpwHsK7Qui8xUFmOr75gvMsd/dTEDDJdSSxtf6An7xyqpRR90PL2abxM1dEqlXnf2tqw1Ne4Xwl5jlRfdnJLmN0pTy/4lj4/7tv0Sk3iiKkypnEUtR6WfMgH0QZfKHM1+di+y9TFRtv6y//0rb+T+W8a9nsNL/ggjnar86461qO0rOs2cXjp3kOG1FEJ5MVmFmBGtnrKpa73XpXyTqRxB/M0n1n/W9nGqC4FSYa04T6N5RIZGBN2z2MT5IKGbFlbC8UrW0DxW7AYImQQcHtGl/m00QLVWutHQoVJYnFPlXTcHYvASLu+RhhsbDmxMgJJ0mcDpvsC4PjvB+TxywElgS70vE0XmLD+OJtvsBslHZvPBKCOdT0MS+tgSOIfga+z1Z1g7+DVagf7quvmag8jfPioyKvxnK/EgsTUVi2ghzq8wm27ud/mIM7AY2qEORR8Go3TVB4HzWQgpZrt3i5MIlCaY504LzSRiigHCzAPlHws+W0rB5N+er5/2pJKnfBSDiCiFAVtCLOZ7gLiMm0jhO2B6tUXHI/+MRPjy02i59lINMRRev56GKtcd9qO/0kUJWdZTdA2XoS82ixPvZtXQpUpuL12ab+9EaDK8Z4RHJYYfCT3Q5vNAXaiWQ+8PTWm2QgBR/bkwSWc+NpUFgNPN9PvQi8WEg5UmAGMCAwEAAQ==", 0))) {
            return 2;
        }
        if (Arrays.equals(encoded, Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE7l1ex+HA220Dpn7mthvsTWpdamguD/9/SQ59dx9EIm29sa/6FsvHrcV30lacqrewLVQBXT5DKyqO107sSHVBpA==", 0))) {
            return 1;
        }
        return 0;
    }

    public static int c(v vVar) throws CertificateParsingException {
        if (vVar instanceof f0) {
            return a(((f0) vVar).j());
        }
        if (vVar instanceof x) {
            x xVar = (x) vVar;
            xVar.getClass();
            return a(new BigInteger(xVar.f6208b));
        }
        throw new CertificateParsingException("Integer value expected, " + vVar.getClass().getName() + " found.");
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Class<String> cls2 = String.class;
            str3 = (String) cls.getMethod("get", new Class[]{cls2, cls2}).invoke(cls, new Object[]{str, str2});
        } catch (Exception e10) {
            e10.toString();
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public static int c(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 = (i10 * InputDeviceCompat.SOURCE_KEYBOARD) ^ bArr[length];
        }
    }

    public static void a(HttpURLConnection httpURLConnection, boolean z10, Map<String, String> map, int i10) throws Exception {
        if (!z10) {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);
        } else {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
        }
        httpURLConnection.setConnectTimeout(i10);
        httpURLConnection.setReadTimeout(i10);
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public static Pair<Integer, String> a(f fVar, int i10) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(fVar.f5970b).openConnection();
            httpURLConnection.setConnectTimeout(i10 > 0 ? i10 : 5000);
            if (i10 <= 0) {
                i10 = 3000;
            }
            httpURLConnection.setReadTimeout(i10);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            if (fVar.f5969a.size() > 0) {
                for (Map.Entry next : fVar.f5969a.entrySet()) {
                    httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
                }
            }
            if (!TextUtils.isEmpty(fVar.f5971c)) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(fVar.f5971c.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                outputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            Pair<Boolean, String> b10 = b(httpURLConnection.getInputStream());
            if (((Boolean) b10.first).booleanValue()) {
                return new Pair<>(Integer.valueOf(responseCode), (String) b10.second);
            }
            return new Pair<>(Integer.valueOf(-responseCode), (String) b10.second);
        } catch (ProtocolException e10) {
            a.a(String.valueOf(-12), e10);
            return new Pair<>(-12, e10.toString());
        } catch (MalformedURLException e11) {
            a.a(String.valueOf(-11), e11);
            return new Pair<>(-11, e11.toString());
        } catch (IOException e12) {
            a.a(String.valueOf(-13), e12);
            return new Pair<>(-13, e12.toString());
        } catch (Exception e13) {
            a.a(String.valueOf(-14), e13);
            return new Pair<>(-14, e13.toString());
        }
    }

    public static boolean a() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            return str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR");
        }
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    String str = new String(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.close();
                    return str;
                }
            } catch (IOException unused) {
                return null;
            }
        }
    }

    public static s0 a(e0 e0Var) throws IOException, CertificateParsingException {
        p0 a10 = e0Var.a();
        if (a10 instanceof l0) {
            e0 e0Var2 = new e0(((l0) a10).f6066c);
            try {
                p0 a11 = e0Var2.a();
                if (a11 instanceof s0) {
                    s0 s0Var = (s0) a11;
                    e0Var2.close();
                    return s0Var;
                }
                throw new CertificateParsingException("Expected sequence, found " + a11.getClass().getName());
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new CertificateParsingException("Expected octet stream, found " + a10.getClass().getName());
        }
        throw th;
    }

    public static Date a(p0 p0Var) throws CertificateParsingException {
        return new Date(e(p0Var).longValue());
    }

    public static boolean a(v vVar) throws CertificateParsingException {
        if (vVar instanceof u) {
            u uVar = (u) vVar;
            if (uVar.b(u.f6185b)) {
                return true;
            }
            if (uVar.b(u.f6184a)) {
                return false;
            }
            throw new CertificateParsingException("DER-encoded boolean values must contain either 0x00 or 0xFF");
        }
        throw new CertificateParsingException("Expected boolean, found " + vVar.getClass().getName());
    }

    public static String a(int i10, int i11) {
        if (i10 == 64) {
            return "[APPLICATION " + i11 + "]";
        } else if (i10 == 128) {
            return "[CONTEXT " + i11 + "]";
        } else if (i10 != 192) {
            return "[UNIVERSAL " + i11 + "]";
        } else {
            return "[PRIVATE " + i11 + "]";
        }
    }

    public static int a(BigInteger bigInteger) throws CertificateParsingException {
        if (bigInteger.compareTo(BigInteger.valueOf(2147483647L)) <= 0 && bigInteger.compareTo(BigInteger.ZERO) >= 0) {
            return bigInteger.intValue();
        }
        throw new CertificateParsingException("INTEGER out of bounds");
    }

    public static z0 a(z0 z0Var) {
        if (z0Var.f6227b == 128) {
            return z0Var;
        }
        String a10 = a(128);
        String a11 = a(z0Var.f6227b);
        throw new IllegalStateException("Expected " + a10 + " tag but found " + a11);
    }

    public static void a(Context context, String str, String str2, int i10, String str3, GeeGuard.CallbackHandler callbackHandler) {
        if (context == null) {
            a.a("Context is null", new IllegalArgumentException("Context is null"));
            if (callbackHandler != null) {
                callbackHandler.onCompletion(-200, (GeeGuardReceipt) null);
            }
        } else if (str == null) {
            a.a("Empty App ID", new IllegalArgumentException("Empty App ID"));
            if (callbackHandler != null) {
                callbackHandler.onCompletion(-200, (GeeGuardReceipt) null);
            }
        } else {
            GeeGuardReceipt a10 = a(context, str, str2);
            if (a10 != null) {
                f fVar = new f();
                fVar.f5969a.put("API-Version", "1");
                fVar.f5969a.put("AppID", str);
                fVar.f5969a.put("GeeID", a10.geeID);
                fVar.f5969a.put("Client-Type", "1");
                fVar.f5971c = a10.geeToken;
                fVar.f5970b = str3;
                Pair<Integer, String> a11 = a(fVar, i10);
                if (((Integer) a11.first).intValue() == 200) {
                    a10.originalResponse = (String) a11.second;
                    try {
                        JSONObject jSONObject = new JSONObject((String) a11.second);
                        if (jSONObject.getInt(Constant.PARAM_OAUTH_CODE) == 0) {
                            a10.respondedGeeToken = jSONObject.getJSONObject("data").getString("gee_token");
                            if (callbackHandler != null) {
                                callbackHandler.onCompletion(200, a10);
                            }
                        } else if (callbackHandler != null) {
                            callbackHandler.onCompletion(-501, a10);
                        }
                    } catch (JSONException e10) {
                        a.a(String.valueOf(-15), e10);
                        if (callbackHandler != null) {
                            callbackHandler.onCompletion(-500, a10);
                        }
                    }
                } else if (callbackHandler != null) {
                    callbackHandler.onCompletion(-300, a10);
                }
            } else if (callbackHandler != null) {
                callbackHandler.onCompletion(-200, (GeeGuardReceipt) null);
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static byte[] a(byte[] bArr, byte b10) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 1, length);
        bArr2[0] = b10;
        return bArr2;
    }
}
