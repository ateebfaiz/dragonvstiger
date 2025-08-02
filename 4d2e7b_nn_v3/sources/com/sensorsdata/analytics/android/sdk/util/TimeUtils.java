package com.sensorsdata.analytics.android.sdk.util;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TimeUtils {
    public static Locale SDK_LOCALE = Locale.CHINA;
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    private static Map<String, ThreadLocal<SimpleDateFormat>> formatMaps = new HashMap();

    public static Float duration(long j10, long j11) {
        long j12 = j11 - j10;
        if (j12 < 0 || j12 > 86400000) {
            return Float.valueOf(0.0f);
        }
        try {
            return Float.valueOf(((float) Math.round((float) j12)) / 1000.0f);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return Float.valueOf(0.0f);
        }
    }

    public static String formatDate(Date date) {
        return formatDate(date, YYYY_MM_DD_HH_MM_SS_SSS);
    }

    public static String formatTime(long j10) {
        return formatTime(j10, SDK_LOCALE);
    }

    private static synchronized SimpleDateFormat getDateFormat(final String str, final Locale locale) {
        String str2;
        SimpleDateFormat simpleDateFormat;
        String str3;
        synchronized (TimeUtils.class) {
            try {
                Map<String, ThreadLocal<SimpleDateFormat>> map = formatMaps;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("_");
                if (locale == null) {
                    str2 = SDK_LOCALE.getCountry();
                } else {
                    str2 = locale.getCountry();
                }
                sb2.append(str2);
                ThreadLocal threadLocal = map.get(sb2.toString());
                if (threadLocal == null) {
                    threadLocal = new ThreadLocal<SimpleDateFormat>() {
                        /* access modifiers changed from: protected */
                        public SimpleDateFormat initialValue() {
                            try {
                                if (locale == null) {
                                    return new SimpleDateFormat(str, TimeUtils.SDK_LOCALE);
                                }
                                return new SimpleDateFormat(str, locale);
                            } catch (Exception e10) {
                                SALog.printStackTrace(e10);
                                return null;
                            }
                        }
                    };
                    if (threadLocal.get() != null) {
                        Map<String, ThreadLocal<SimpleDateFormat>> map2 = formatMaps;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append("_");
                        if (locale == null) {
                            str3 = SDK_LOCALE.getCountry();
                        } else {
                            str3 = locale.getCountry();
                        }
                        sb3.append(str3);
                        map2.put(sb3.toString(), threadLocal);
                    }
                }
                simpleDateFormat = (SimpleDateFormat) threadLocal.get();
            } catch (Throwable th) {
                throw th;
            }
        }
        return simpleDateFormat;
    }

    public static Integer getZoneOffset() {
        try {
            Calendar instance = Calendar.getInstance(Locale.getDefault());
            return Integer.valueOf((-(instance.get(15) + instance.get(16))) / 60000);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public static boolean isDateValid(Date date) {
        try {
            return date.after(getDateFormat(YYYY_MM_DD_HH_MM_SS_SSS, SDK_LOCALE).parse("2015-05-15 10:24:00.000"));
        } catch (ParseException e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public static String formatDate(Date date, String str) {
        return formatDate(date, str, SDK_LOCALE);
    }

    public static String formatTime(long j10, String str) {
        return formatTime(j10, str, SDK_LOCALE);
    }

    public static String formatDate(Date date, Locale locale) {
        return formatDate(date, YYYY_MM_DD_HH_MM_SS_SSS, locale);
    }

    public static String formatTime(long j10, Locale locale) {
        return formatTime(j10, (String) null, locale);
    }

    public static String formatDate(Date date, String str, Locale locale) {
        if (TextUtils.isEmpty(str)) {
            str = YYYY_MM_DD_HH_MM_SS_SSS;
        }
        SimpleDateFormat dateFormat = getDateFormat(str, locale);
        if (dateFormat == null) {
            return "";
        }
        try {
            return dateFormat.format(date);
        } catch (IllegalArgumentException e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public static String formatTime(long j10, String str, Locale locale) {
        if (TextUtils.isEmpty(str)) {
            str = YYYY_MM_DD_HH_MM_SS_SSS;
        }
        SimpleDateFormat dateFormat = getDateFormat(str, locale);
        if (dateFormat == null) {
            return "";
        }
        try {
            return dateFormat.format(Long.valueOf(j10));
        } catch (IllegalArgumentException e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public static Float duration(float f10) {
        return Float.valueOf(((float) Math.round(f10)) / 1000.0f);
    }

    public static boolean isDateValid(long j10) {
        try {
            Date parse = getDateFormat(YYYY_MM_DD_HH_MM_SS_SSS, SDK_LOCALE).parse("2015-05-15 10:24:00.000");
            if (parse != null && parse.getTime() < j10) {
                return true;
            }
            return false;
        } catch (ParseException e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public static JSONObject formatDate(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof Date) {
                    jSONObject.put(next, formatDate((Date) obj, SDK_LOCALE));
                }
            }
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
        return jSONObject;
    }
}
