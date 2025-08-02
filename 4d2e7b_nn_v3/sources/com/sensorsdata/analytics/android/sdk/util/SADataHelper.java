package com.sensorsdata.analytics.android.sdk.util;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SADataHelper {
    private static final Pattern KEY_PATTERN = Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$|^user_tag.*|^user_group.*)[a-zA-Z_$][a-zA-Z\\d_$]*)$", 2);
    private static final int MAX_LENGTH_100 = 100;
    public static final int MAX_LENGTH_1024 = 1024;
    private static final String TAG = "SA.SADataHelper";

    public static void addTimeProperty(JSONObject jSONObject) {
        if (!jSONObject.has("$time")) {
            try {
                jSONObject.put("$time", new Date(System.currentTimeMillis()));
            } catch (JSONException e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static JSONObject appendLibMethodAutoTrack(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("$lib_method", "autoTrack");
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
        return jSONObject;
    }

    public static void assertDistinctId(String str) throws InvalidDataException {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidDataException("Id is empty or null");
        } else if (str.length() > 1024) {
            SALog.i(TAG, str + "'s length is longer than " + 1024);
        }
    }

    public static void assertEventName(String str) {
        if (TextUtils.isEmpty(str)) {
            SALog.i(TAG, "EventName is empty or null");
        } else if (str.length() > 100) {
            SALog.i(TAG, str + "'s length is longer than " + 100);
        } else if (!KEY_PATTERN.matcher(str).matches()) {
            SALog.i(TAG, str + " is invalid");
        }
    }

    public static void assertItemId(String str) {
        if (str == null) {
            SALog.i(TAG, "ItemId is empty or null");
        } else if (str.length() > 1024) {
            SALog.i(TAG, str + "'s length is longer than " + 1024);
        }
    }

    public static boolean assertPropertyKey(String str) {
        if (TextUtils.isEmpty(str)) {
            SALog.i(TAG, "Property key is empty or null");
            return false;
        } else if (!KEY_PATTERN.matcher(str).matches()) {
            SALog.i(TAG, str + " is invalid");
            return false;
        } else if (str.length() <= 100) {
            return true;
        } else {
            SALog.i(TAG, str + "'s length is longer than " + 100);
            return true;
        }
    }

    public static void assertPropertyTypes(JSONObject jSONObject) throws InvalidDataException {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (!assertPropertyKey(next)) {
                        keys.remove();
                    } else {
                        Object obj = jSONObject.get(next);
                        if (obj == JSONObject.NULL) {
                            SALog.i(TAG, "Property value is empty or null");
                            keys.remove();
                        } else {
                            int i10 = 0;
                            if (obj instanceof List) {
                                List list = (List) obj;
                                int size = list.size();
                                JSONArray jSONArray = new JSONArray();
                                while (i10 < size) {
                                    jSONArray.put(formatString(list.get(i10)));
                                    i10++;
                                }
                                jSONObject.put(next, jSONArray);
                            } else {
                                if (!(obj instanceof CharSequence)) {
                                    if (!(obj instanceof Number) && !(obj instanceof JSONArray) && !(obj instanceof Boolean) && !(obj instanceof Date)) {
                                        SALog.i(TAG, "The property value must be an instance of CharSequence/Number/Boolean/JSONArray/Date/List<String>. [key='" + next + "', value='" + obj.toString() + "', class='" + obj.getClass().getCanonicalName() + "']");
                                        keys.remove();
                                    }
                                }
                                if (obj instanceof JSONArray) {
                                    JSONArray jSONArray2 = (JSONArray) obj;
                                    while (i10 < jSONArray2.length()) {
                                        jSONArray2.put(i10, formatString(jSONArray2.opt(i10)));
                                        i10++;
                                    }
                                } else {
                                    if ("app_crashed_reason".equals(next)) {
                                        if ((obj instanceof String) && ((String) obj).length() > 16382) {
                                            SALog.d(TAG, "The property value is too long. [key='" + next + "', value='" + obj + "']");
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(((String) obj).substring(0, 16382));
                                            sb2.append("$");
                                            jSONObject.put(next, sb2.toString());
                                        }
                                    }
                                    if ((obj instanceof String) && ((String) obj).length() > 8191) {
                                        jSONObject.put(next, ((String) obj).substring(0, 8191) + "$");
                                        SALog.d(TAG, "The property value is too long. [key='" + next + "', value='" + obj + "']");
                                    }
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                    throw new InvalidDataException("Unexpected property key. [key='" + next + "']");
                } catch (Error e10) {
                    SALog.i(TAG, (Throwable) e10);
                }
            }
        }
    }

    public static String assertPropertyValue(String str) {
        if (str == null) {
            SALog.i(TAG, "Property value is empty or null");
            return str;
        }
        if (str.length() > 1024) {
            SALog.i(TAG, str + "'s length is longer than " + 1024);
        }
        return str;
    }

    public static void closeStream(BufferedOutputStream bufferedOutputStream, OutputStream outputStream, InputStream inputStream, HttpURLConnection httpURLConnection) {
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (Exception e10) {
                SALog.i(TAG, e10.getMessage());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e11) {
                SALog.i(TAG, e11.getMessage());
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e12) {
                SALog.i(TAG, e12.getMessage());
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e13) {
                SALog.i(TAG, e13.getMessage());
            }
        }
    }

    public static String formatString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Date) {
            return TimeUtils.formatDate((Date) obj);
        }
        return obj.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d A[SYNTHETIC, Splitter:B:19:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String gzipData(java.lang.String r3) throws com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException {
        /*
            r0 = 0
            java.lang.String r1 = "UTF-8"
            byte[] r3 = r3.getBytes(r1)     // Catch:{ IOException -> 0x0034 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0034 }
            int r2 = r3.length     // Catch:{ IOException -> 0x0034 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0034 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0034 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0034 }
            r2.write(r3)     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            r2.close()     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            byte[] r3 = r1.toByteArray()     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            r1.close()     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            char[] r3 = com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(r3)     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            r0.<init>(r3)     // Catch:{ IOException -> 0x002f, all -> 0x002c }
            r2.close()     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            return r0
        L_0x002c:
            r3 = move-exception
            r0 = r2
            goto L_0x003b
        L_0x002f:
            r3 = move-exception
            r0 = r2
            goto L_0x0035
        L_0x0032:
            r3 = move-exception
            goto L_0x003b
        L_0x0034:
            r3 = move-exception
        L_0x0035:
            com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException r1 = new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException     // Catch:{ all -> 0x0032 }
            r1.<init>((java.lang.Throwable) r3)     // Catch:{ all -> 0x0032 }
            throw r1     // Catch:{ all -> 0x0032 }
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.SADataHelper.gzipData(java.lang.String):java.lang.String");
    }

    public static byte[] slurp(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
