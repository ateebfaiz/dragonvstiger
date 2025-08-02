package org.cocos2dx.javascript;

import android.app.ActivityManager;
import android.content.Context;
import android.icu.util.TimeZone;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.m;
import kotlin.random.c;
import kotlin.s;
import kotlin.text.d;

public final class UniqueIdManager {
    public static final UniqueIdManager INSTANCE = new UniqueIdManager();
    private static final String TAG = "UniqueIdManager";
    private static s randomNumber;
    private static String uniqueId = "";

    private UniqueIdManager() {
    }

    private final String addSalt(String str) {
        s generateRandomNumbers;
        if (str.length() != 64 || (generateRandomNumbers = generateRandomNumbers()) == null) {
            return "";
        }
        Object a10 = generateRandomNumbers.a();
        String substring = str.substring(0, 32);
        m.e(substring, "substring(...)");
        Object b10 = generateRandomNumbers.b();
        String substring2 = str.substring(32, 64);
        m.e(substring2, "substring(...)");
        Object c10 = generateRandomNumbers.c();
        return a10 + substring + b10 + substring2 + c10;
    }

    private final s generateRandomNumbers() {
        int e10;
        int e11;
        int e12;
        s sVar = randomNumber;
        if (sVar != null) {
            return sVar;
        }
        do {
            c.a aVar = c.f729a;
            e10 = aVar.e(0, 10);
            e11 = aVar.e(0, 10);
            e12 = aVar.e(0, 10);
        } while (e10 + e11 + e12 != 18);
        s sVar2 = new s(Integer.valueOf(e10), Integer.valueOf(e11), Integer.valueOf(e12));
        randomNumber = sVar2;
        return sVar2;
    }

    private final String generateSHA256Hash(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes(d.f797b);
            m.e(bytes, "getBytes(...)");
            byte[] digest = instance.digest(bytes);
            StringBuilder sb2 = new StringBuilder();
            m.c(digest);
            for (byte b10 : digest) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    sb2.append('0');
                }
                sb2.append(hexString);
            }
            String sb3 = sb2.toString();
            m.e(sb3, "toString(...)");
            return sb3;
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private final String getDeviceInfo(Context context) {
        String str = Build.BOARD;
        String str2 = Build.BRAND;
        String str3 = Build.CPU_ABI;
        String str4 = Build.DEVICE;
        String str5 = Build.DISPLAY;
        String str6 = Build.HOST;
        String str7 = Build.ID;
        String str8 = Build.MANUFACTURER;
        String str9 = Build.MODEL;
        String str10 = Build.PRODUCT;
        String str11 = Build.TAGS;
        String str12 = Build.TYPE;
        String str13 = Build.USER;
        long j10 = Build.TIME;
        long totalMemory = getTotalMemory(context);
        long j11 = j10;
        String timeZone = getTimeZone();
        String siteCode = getSiteCode();
        return str + str2 + str3 + str4 + str5 + str6 + str7 + str8 + str9 + str10 + str11 + str12 + str13 + j11 + totalMemory + timeZone + siteCode;
    }

    private final String getDeviceShortInfo() {
        return "35" + (Build.BOARD.length() % 10);
    }

    private final String getSiteCode() {
        String infoValue = PlatformUtils.getInfoValue("siteCode");
        m.e(infoValue, "getInfoValue(...)");
        return infoValue;
    }

    private final String getTimeZone() {
        if (Build.VERSION.SDK_INT <= 24) {
            return "";
        }
        String a10 = TimeZone.getDefault().getID();
        m.e(a10, "getID(...)");
        return a10;
    }

    private final long getTotalMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        return memoryInfo.totalMem;
    }

    public final String getUniqueId(Context context) {
        String str;
        m.f(context, "context");
        try {
            if (uniqueId.length() > 0) {
                return uniqueId;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    str = Settings.System.getString(context.getContentResolver(), "android_id");
                    m.c(str);
                } catch (Exception unused) {
                    str = "serialdDWQ";
                }
                Log.i(TAG, "API>=28,android.os.Build.SERIAL=" + str);
            } else {
                try {
                    str = Build.class.getField("SERIAL").get((Object) null).toString();
                    Log.i(TAG, "api>=9,android.os.Build.SERIAL=" + str);
                } catch (Exception unused2) {
                    str = "serial";
                    Log.i(TAG, "api<9,serial=" + str);
                }
            }
            String deviceShortInfo = getDeviceShortInfo();
            String deviceInfo = getDeviceInfo(context);
            Log.i(TAG, "szDevIDShort=" + deviceShortInfo);
            Log.i(TAG, "serial=" + str);
            Log.i(TAG, "szDevID=" + deviceInfo);
            uniqueId = addSalt(generateSHA256Hash(str + deviceShortInfo + deviceInfo));
            return uniqueId;
        } catch (Exception unused3) {
        }
    }
}
