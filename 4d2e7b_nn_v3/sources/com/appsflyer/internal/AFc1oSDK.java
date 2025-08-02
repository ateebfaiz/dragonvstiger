package com.appsflyer.internal;

import android.util.Base64;
import androidx.annotation.WorkerThread;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import org.json.JSONArray;

public interface AFc1oSDK {

    public static final class AFa1xSDK {
        public final String AFInAppEventParameterName;
        public Boolean AFInAppEventType;
        public final Boolean valueOf;

        public AFa1xSDK() {
        }

        public static boolean AFInAppEventParameterName(HttpURLConnection httpURLConnection) {
            m.f(httpURLConnection, "");
            return httpURLConnection.getResponseCode() / 100 == 2;
        }

        public static double AFInAppEventType(String str) throws ParseException {
            m.f(str, "");
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                Number parse = NumberFormat.getInstance(Locale.getDefault()).parse(str);
                if (parse != null) {
                    return parse.doubleValue();
                }
                throw new ParseException("Failed parse String into number", 0);
            }
        }

        public static JSONArray AFKeystoreWrapper(List<AFc1uSDK> list) {
            m.f(list, "");
            Iterable<AFc1uSDK> iterable = list;
            ArrayList arrayList = new ArrayList(r.v(iterable, 10));
            for (AFc1uSDK AFKeystoreWrapper : iterable) {
                arrayList.add(AFKeystoreWrapper.AFKeystoreWrapper());
            }
            return new JSONArray(arrayList);
        }

        public static String valueOf(String str) {
            m.f(str, "");
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes(d.f797b);
            m.e(bytes, "");
            byte[] digest = instance.digest(bytes);
            m.e(digest, "");
            String str2 = "";
            for (byte valueOf2 : digest) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf2)}, 1));
                m.e(format, "");
                sb2.append(format);
                str2 = sb2.toString();
            }
            return str2;
        }

        public AFa1xSDK(String str, Boolean bool) {
            this.AFInAppEventParameterName = str;
            this.valueOf = bool;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
            r0 = kotlin.text.j.i((r0 = r0.a()));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int AFInAppEventParameterName(java.lang.String r4) {
            /*
                java.lang.String r0 = ""
                kotlin.jvm.internal.m.f(r4, r0)
                kotlin.text.h r0 = new kotlin.text.h
                java.lang.String r1 = "(\\d+).?(\\d+)?.?(\\d+)?(-rc\\d+)?(_.*)?"
                r0.<init>((java.lang.String) r1)
                kotlin.text.MatchResult r4 = r0.b(r4)
                if (r4 == 0) goto L_0x0071
                kotlin.text.f r0 = r4.a()
                r1 = 1
                kotlin.text.MatchGroup r0 = r0.get(r1)
                r1 = 0
                if (r0 == 0) goto L_0x002f
                java.lang.String r0 = r0.a()
                if (r0 == 0) goto L_0x002f
                java.lang.Integer r0 = kotlin.text.j.i(r0)
                if (r0 == 0) goto L_0x002f
                int r0 = r0.intValue()
                goto L_0x0030
            L_0x002f:
                r0 = r1
            L_0x0030:
                r2 = 1000000(0xf4240, float:1.401298E-39)
                int r0 = r0 * r2
                kotlin.text.f r2 = r4.a()
                r3 = 2
                kotlin.text.MatchGroup r2 = r2.get(r3)
                if (r2 == 0) goto L_0x0050
                java.lang.String r2 = r2.a()
                if (r2 == 0) goto L_0x0050
                java.lang.Integer r2 = kotlin.text.j.i(r2)
                if (r2 == 0) goto L_0x0050
                int r2 = r2.intValue()
                goto L_0x0051
            L_0x0050:
                r2 = r1
            L_0x0051:
                int r2 = r2 * 1000
                int r0 = r0 + r2
                kotlin.text.f r4 = r4.a()
                r2 = 3
                kotlin.text.MatchGroup r4 = r4.get(r2)
                if (r4 == 0) goto L_0x006f
                java.lang.String r4 = r4.a()
                if (r4 == 0) goto L_0x006f
                java.lang.Integer r4 = kotlin.text.j.i(r4)
                if (r4 == 0) goto L_0x006f
                int r1 = r4.intValue()
            L_0x006f:
                int r0 = r0 + r1
                return r0
            L_0x0071:
                r4 = -1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(java.lang.String):int");
        }

        public static String AFKeystoreWrapper(String str) {
            m.f(str, "");
            byte[] bytes = str.getBytes(d.f797b);
            m.e(bytes, "");
            String encodeToString = Base64.encodeToString(bytes, 2);
            m.e(encodeToString, "");
            return encodeToString;
        }
    }

    @WorkerThread
    void values(byte[] bArr, Map<String, String> map, int i10);
}
