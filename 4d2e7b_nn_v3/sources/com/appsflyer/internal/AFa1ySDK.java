package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;
import com.alibaba.pdns.DNSResolver;
import com.appsflyer.AFLogger;
import io.jsonwebtoken.JwtParser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AFa1ySDK {
    private static int AFInAppEventParameterName = 0;
    private static char[] AFInAppEventType = null;
    private static int AFKeystoreWrapper = ((AFInAppEventParameterName + 105) % 128);
    private static long valueOf;
    private static long values;

    static {
        AFInAppEventType();
        View.resolveSizeAndState(0, 0, 0);
        ViewConfiguration.getLongPressTimeout();
        Color.alpha(0);
        ViewConfiguration.getTapTimeout();
        Color.blue(0);
        TextUtils.lastIndexOf("", '0');
        Process.myTid();
        TypedValue.complexToFloat(0);
        TextUtils.indexOf("", '0');
        TextUtils.indexOf("", '0', 0, 0);
        TextUtils.indexOf("", '0', 0);
        KeyEvent.keyCodeFromString("");
        ViewConfiguration.getScrollFriction();
        TextUtils.indexOf("", '0', 0, 0);
        ViewConfiguration.getDoubleTapTimeout();
        AudioTrack.getMaxVolume();
        AndroidCharacter.getMirror('0');
    }

    private static String AFInAppEventParameterName(String str) {
        AFInAppEventParameterName = (AFKeystoreWrapper + 75) % 128;
        Object[] objArr = new Object[1];
        AFInAppEventType((char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 60565), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 107, KeyEvent.getDeadChar(0, 0) + 1, objArr);
        if (!str.contains(((String) objArr[0]).intern())) {
            int i10 = AFInAppEventParameterName + 107;
            AFKeystoreWrapper = i10 % 128;
            if (i10 % 2 == 0) {
                int i11 = 6 / 0;
            }
            return str;
        }
        Object[] objArr2 = new Object[1];
        values("铰鏸揄ﲛ", ViewConfiguration.getFadingEdgeLength() >> 16, objArr2);
        String[] split = str.split(((String) objArr2[0]).intern());
        int length = split.length;
        StringBuilder sb2 = new StringBuilder();
        int i12 = length - 1;
        sb2.append(split[i12]);
        Object[] objArr3 = new Object[1];
        AFInAppEventType((char) (((Process.getThreadPriority(0) + 20) >> 6) + 60565), ExpandableListView.getPackedPositionType(0) + 107, -TextUtils.lastIndexOf("", '0'), objArr3);
        sb2.append(((String) objArr3[0]).intern());
        AFInAppEventParameterName = (AFKeystoreWrapper + 95) % 128;
        for (int i13 = 1; i13 < i12; i13++) {
            sb2.append(split[i13]);
            Object[] objArr4 = new Object[1];
            AFInAppEventType((char) (60565 - (ViewConfiguration.getEdgeSlop() >> 16)), 107 - (ViewConfiguration.getLongPressTimeout() >> 16), 1 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr4);
            sb2.append(((String) objArr4[0]).intern());
        }
        sb2.append(split[0]);
        return sb2.toString();
    }

    static void AFInAppEventType() {
        values = 1997584226170046246L;
        AFInAppEventType = new char[]{'y', 11743, 23349, 34955, 46773, 58483, 4521, 16295, 27988, 39602, 51235, 63082, 9088, 20739, 32633, 44233, 55827, 2140, 45695, 40922, 59699, 14986, 1252, 22086, 41929, 36258, 57108, 10415, 31316, 17420, 37300, 58129, 52528, 7828, 26697, 47741, 34693, 53546, 8913, 3302, 24173, 43975, 62953, 50962, 4336, 25337, 19463, 39395, 60248, 13622, 'i', 11733, 23311, 34974, 46841, 58445, 4503, 16298, 27933, 39670, 51218, 63053, 9148, 20814, 32626, 44245, 55829, 2152, 13768, 26933, 17564, 12924, 57812, 57251, 36099, 30932, 22256, 1036, 62435, 41306, 40722, 19179, 14427, 5682, 50571, 45850, 24833, 23709, 2664, 63967, 55205, 34146, 6688, 14217, 16745, 37569, 44214, 65046, 3009, 9701, 30495, 33010, 53833, 60493, 14812, 19293, 25916, 60603, 61858, 56335, 43762, 31067, 18302, 5535, 57411, 52844, 40076, 27507, 14788, 1934, 53865, 41172, JwtParser.SEPARATOR_CHAR, 11660, 23395, 34990, 46827, 58388, 4556, 16292, 27930, 39679, 'F', 11719, 23333, 34974, 46845, 58458, 4548, 16382, 27999, 39670, 51227, 63047, 9148, 20814, 32631, 44251, 55811, 2158, 13769, 25458, 37000, 48895, 60464, 6530, 60393, 50788, 45187, 25403, 23897, 4071, 64059, 54349, 34527, 28932, 9141, 7661, 51218, 47792, 38103, 18303, 12708, 'F', 11719, 23333, 34974, 46845, 58458, 4548, 16382, 27999, 39670, 51227, 63047, 9148, 20814, 32631, 44251, 55811, 2158, 13769, 25458, 37000, 48895, 60464, 6530, 18352, 30017, 41653, 53494, 65088, 11246, 22801, 34658, 46243, 57859, 4220, 15814, 27441, 39057, 50890, 62576, 8656, 'P', 11719, 23343, 34969, 46841, 58457, 4481, 16332, 27970, 39609, 51217, 63087, 9129, 20736, 32637, 44252, 55813, 2165, 13784, 25458, 37014, 48881, 60464, 6602, 18422, 30041, 41641, 53484, 65100};
        valueOf = -292703458466845274L;
    }

    private static String AFKeystoreWrapper(String str, Long l10) {
        long j10 = 0;
        if (str != null) {
            int i10 = AFKeystoreWrapper;
            AFInAppEventParameterName = (i10 + 87) % 128;
            if (l10 != null) {
                AFInAppEventParameterName = (i10 + 47) % 128;
                if (str.length() == 32) {
                    StringBuilder sb2 = new StringBuilder(str);
                    String obj = l10.toString();
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < obj.length()) {
                        i12 += Character.getNumericValue(obj.charAt(i11));
                        i11++;
                        AFInAppEventParameterName = (AFKeystoreWrapper + 15) % 128;
                    }
                    String hexString = Integer.toHexString(i12);
                    sb2.replace(7, hexString.length() + 7, hexString);
                    for (int i13 = 0; i13 < sb2.length(); i13++) {
                        j10 += (long) Character.getNumericValue(sb2.charAt(i13));
                    }
                    while (j10 > 100) {
                        j10 %= 100;
                    }
                    sb2.insert(23, (int) j10);
                    if (j10 < 10) {
                        AFInAppEventParameterName = (AFKeystoreWrapper + 21) % 128;
                        Object[] objArr = new Object[1];
                        values("쨰쨀亷ᖮ폷", ViewConfiguration.getMinimumFlingVelocity() >> 16, objArr);
                        sb2.insert(23, ((String) objArr[0]).intern());
                    }
                    return sb2.toString();
                }
            }
        }
        Object[] objArr2 = new Object[1];
        AFInAppEventType((char) (45598 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 19 - (SystemClock.elapsedRealtime() > 0 ? 1 : (SystemClock.elapsedRealtime() == 0 ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 32, objArr2);
        return ((String) objArr2[0]).intern();
    }

    private static String valueOf(String str, String str2, int i10) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.setCharAt(i10, values(str2).charAt(0));
        String obj = sb2.toString();
        int i11 = AFKeystoreWrapper + 49;
        AFInAppEventParameterName = i11 % 128;
        if (i11 % 2 == 0) {
            return obj;
        }
        throw null;
    }

    private static String values(String str) {
        int parseInt;
        int i10;
        int i11 = AFInAppEventParameterName + 47;
        AFKeystoreWrapper = i11 % 128;
        if (i11 % 2 == 0) {
            parseInt = Integer.parseInt(str, 2);
            i10 = 43;
        } else {
            parseInt = Integer.parseInt(str, 2);
            i10 = 16;
        }
        String num = Integer.toString(parseInt, i10);
        AFInAppEventParameterName = (AFKeystoreWrapper + 57) % 128;
        return num;
    }

    @Nullable
    static String AFInAppEventType(Context context, long j10) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        Object[] objArr = new Object[1];
        values("咐哱ꖝꋕ⏀ⷨ绋毋䡧脂ी䳯淔擐「Ĩ﹓䞻ᖟ⚉?ꌸ良?㒮뻴?ｯဍ驥뾄鳙淵ꌶ뀵䥁", (SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1)) - 1, objArr);
        if (!(!AFInAppEventType(((String) objArr[0]).intern()))) {
            AFInAppEventParameterName = (AFKeystoreWrapper + 63) % 128;
            Object[] objArr2 = new Object[1];
            values("젻젊㭿ъ窫", '0' - AndroidCharacter.getMirror('0'), objArr2);
            str = ((String) objArr2[0]).intern();
            AFInAppEventParameterName = (AFKeystoreWrapper + 9) % 128;
        } else {
            Object[] objArr3 = new Object[1];
            values("쨰쨀亷ᖮ폷", (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr3);
            str = ((String) objArr3[0]).intern();
        }
        sb3.append(str);
        sb2.append(AFInAppEventParameterName(context, sb3));
        try {
            long j11 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            Object[] objArr4 = new Object[1];
            AFInAppEventType((char) (ViewConfiguration.getJumpTapTimeout() >> 16), 1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), TextUtils.getCapsMode("", 0, 0) + 18, objArr4);
            sb2.append(new SimpleDateFormat(((String) objArr4[0]).intern(), Locale.US).format(new Date(j11)));
            int i10 = AFInAppEventParameterName + 7;
            AFKeystoreWrapper = i10 % 128;
            if (i10 % 2 == 0) {
                sb2.append(j10);
                AFKeystoreWrapper(sb4);
                return AFKeystoreWrapper(valueOf(valueOf(valueOf(sb2.toString()), sb3.toString(), 95), sb4.toString(), 22), Long.valueOf(j10));
            }
            sb2.append(j10);
            AFKeystoreWrapper(sb4);
            return AFKeystoreWrapper(valueOf(valueOf(valueOf(sb2.toString()), sb3.toString(), 17), sb4.toString(), 27), Long.valueOf(j10));
        } catch (PackageManager.NameNotFoundException e10) {
            Object[] objArr5 = new Object[1];
            values("嬽孚黈馋삙캡킻얊䟍멐扞?螈鸹໘악ꓣ믠⤰䀕圇햪࿡巽璷⭈礫ᇝ", ViewConfiguration.getLongPressTimeout() >> 16, objArr5);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e10);
            Object[] objArr6 = new Object[1];
            AFInAppEventType((char) (45597 - (ViewConfiguration.getPressedStateDuration() >> 16)), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (ViewConfiguration.getLongPressTimeout() >> 16) + 32, objArr6);
            return ((String) objArr6[0]).intern();
        }
    }

    private static String valueOf(String str) {
        AFKeystoreWrapper = (AFInAppEventParameterName + 21) % 128;
        String values2 = AFb1ySDK.values(AFb1ySDK.AFInAppEventParameterName(str));
        AFKeystoreWrapper = (AFInAppEventParameterName + 31) % 128;
        return values2;
    }

    private static String values(Context context) {
        Properties properties = System.getProperties();
        Object[] objArr = new Object[1];
        AFInAppEventType((char) (View.resolveSizeAndState(0, 0, 0) + 61896), (SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1)) + 107, 15 - (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)), objArr);
        String str = null;
        if (properties.containsKey(((String) objArr[0]).intern())) {
            AFKeystoreWrapper = (AFInAppEventParameterName + 43) % 128;
            try {
                String path = context.getCacheDir().getPath();
                Object[] objArr2 = new Object[1];
                values("詐詿脕輸ﵖ隠욋", (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)) + 1, objArr2);
                String replace = path.replace(((String) objArr2[0]).intern(), "");
                Object[] objArr3 = new Object[1];
                AFInAppEventType((char) (-1 - MotionEvent.axisFromString("")), (ViewConfiguration.getWindowTouchSlop() >> 8) + 122, Gravity.getAbsoluteGravity(0, 0) + 10, objArr3);
                Matcher matcher = Pattern.compile(((String) objArr3[0]).intern()).matcher(replace);
                if (matcher.find()) {
                    str = matcher.group(1);
                }
                AFInAppEventParameterName = (AFKeystoreWrapper + 31) % 128;
            } catch (Exception e10) {
                Object[] objArr4 = new Object[1];
                AFInAppEventType((char) (TextUtils.lastIndexOf("", '0', 0) + 1), Process.getGidForName("") + 133, (ViewConfiguration.getScrollBarSize() >> 8) + 24, objArr4);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr4[0]).intern(), e10);
                AFb1sSDK afErrorLogForExcManagerOnly = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly();
                Object[] objArr5 = new Object[1];
                AFInAppEventType((char) (60331 - (SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1))), 156 - Color.red(0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 16, objArr5);
                String intern = ((String) objArr5[0]).intern();
                StringBuilder sb2 = new StringBuilder();
                Object[] objArr6 = new Object[1];
                AFInAppEventType((char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 173, 42 - (SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1)), objArr6);
                sb2.append(((String) objArr6[0]).intern());
                sb2.append(e10);
                afErrorLogForExcManagerOnly.valueOf(intern, sb2.toString());
            }
        }
        return str;
    }

    private static String valueOf(Context context) {
        AFKeystoreWrapper = (AFInAppEventParameterName + 1) % 128;
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            AFKeystoreWrapper = (AFInAppEventParameterName + 11) % 128;
            return str;
        } catch (PackageManager.NameNotFoundException e10) {
            Object[] objArr = new Object[1];
            AFInAppEventType((char) Drawable.resolveOpacity(0, 0), TextUtils.lastIndexOf("", '0', 0) + 215, 28 - MotionEvent.axisFromString(""), objArr);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr[0]).intern(), e10);
            return null;
        }
    }

    private static String AFInAppEventParameterName(Context context, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        String packageName = context.getPackageName();
        String AFInAppEventParameterName2 = AFInAppEventParameterName(packageName);
        Object[] objArr = new Object[1];
        values("젻젊㭿ъ窫", (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)) + 1, objArr);
        sb2.append(((String) objArr[0]).intern());
        sb3.append(AFInAppEventParameterName2);
        if (values(context) == null) {
            AFInAppEventParameterName = (AFKeystoreWrapper + 35) % 128;
            Object[] objArr2 = new Object[1];
            values("쨰쨀亷ᖮ폷", View.MeasureSpec.getSize(0), objArr2);
            sb2.append(((String) objArr2[0]).intern());
            sb3.append(packageName);
            AFKeystoreWrapper = (AFInAppEventParameterName + 121) % 128;
        } else {
            Object[] objArr3 = new Object[1];
            values("젻젊㭿ъ窫", Gravity.getAbsoluteGravity(0, 0), objArr3);
            sb2.append(((String) objArr3[0]).intern());
            sb3.append(packageName);
        }
        String valueOf2 = valueOf(context);
        if (valueOf2 == null) {
            AFKeystoreWrapper = (AFInAppEventParameterName + 11) % 128;
            Object[] objArr4 = new Object[1];
            values("쨰쨀亷ᖮ폷", View.combineMeasuredStates(0, 0), objArr4);
            sb2.append(((String) objArr4[0]).intern());
            sb3.append(packageName);
            AFKeystoreWrapper = (AFInAppEventParameterName + 3) % 128;
        } else {
            Object[] objArr5 = new Object[1];
            values("젻젊㭿ъ窫", -1 - TextUtils.lastIndexOf("", '0', 0), objArr5);
            sb2.append(((String) objArr5[0]).intern());
            sb3.append(valueOf2);
        }
        sb3.append(Boolean.TRUE.toString());
        return sb3.toString();
    }

    public static class AFa1xSDK extends HashMap<String, Object> {
        private static char[] AFInAppEventType = null;
        private static int AFKeystoreWrapper = ((AFLogger + 53) % 128);
        private static int AFLogger = 1;
        private static int values;
        private final Context AFInAppEventParameterName;
        private final Map<String, Object> valueOf;

        /* renamed from: com.appsflyer.internal.AFa1ySDK$AFa1xSDK$AFa1ySDK  reason: collision with other inner class name */
        static class C0237AFa1ySDK {
            private static short[] AFInAppEventParameterName = null;
            private static int AFInAppEventType = 1580374223;
            private static int AFKeystoreWrapper = 1185622814;
            private static int afErrorLog = 0;
            private static int afInfoLog = 1;
            private static byte[] valueOf = {-82};
            private static int values = 83;

            C0237AFa1ySDK() {
            }

            @NonNull
            static String AFInAppEventParameterName(String str) throws Exception {
                int i10 = afErrorLog + DNSResolver.GOBACK_LOCAL;
                afInfoLog = i10 % 128;
                int i11 = i10 % 2;
                byte[] AFKeystoreWrapper2 = AFKeystoreWrapper(str);
                if (i11 != 0) {
                    return AFInAppEventParameterName(AFInAppEventType(AFKeystoreWrapper2));
                }
                int i12 = 3 / 0;
                return AFInAppEventParameterName(AFInAppEventType(AFKeystoreWrapper2));
            }

            private static byte[] AFInAppEventType(@NonNull byte[] bArr) throws Exception {
                int i10;
                int i11 = afErrorLog + 81;
                afInfoLog = i11 % 128;
                if (i11 % 2 == 0) {
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                while (i10 < bArr.length) {
                    bArr[i10] = (byte) (bArr[i10] ^ ((i10 % 2) + 42));
                    i10++;
                }
                int i12 = afInfoLog + 123;
                afErrorLog = i12 % 128;
                if (i12 % 2 != 0) {
                    int i13 = 32 / 0;
                }
                return bArr;
            }

            @NonNull
            private static byte[] AFKeystoreWrapper(@NonNull String str) throws Exception {
                afInfoLog = (afErrorLog + 95) % 128;
                byte[] bytes = str.getBytes();
                int i10 = afErrorLog + 3;
                afInfoLog = i10 % 128;
                if (i10 % 2 != 0) {
                    return bytes;
                }
                throw null;
            }

            private static void values(int i10, int i11, byte b10, int i12, short s10, Object[] objArr) {
                int i13;
                String obj;
                synchronized (AFg1qSDK.valueOf) {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        int i14 = values;
                        int i15 = i12 + i14;
                        if (i15 == -1) {
                            i13 = 1;
                        } else {
                            i13 = 0;
                        }
                        if (i13 != 0) {
                            byte[] bArr = valueOf;
                            if (bArr != null) {
                                i15 = (byte) (bArr[AFInAppEventType + i10] + i14);
                            } else {
                                i15 = (short) (AFInAppEventParameterName[AFInAppEventType + i10] + i14);
                            }
                        }
                        if (i15 > 0) {
                            AFg1qSDK.values = ((i10 + i15) - 2) + AFInAppEventType + i13;
                            char c10 = (char) (i11 + AFKeystoreWrapper);
                            AFg1qSDK.AFKeystoreWrapper = c10;
                            sb2.append(c10);
                            AFg1qSDK.AFInAppEventType = AFg1qSDK.AFKeystoreWrapper;
                            AFg1qSDK.AFInAppEventParameterName = 1;
                            while (AFg1qSDK.AFInAppEventParameterName < i15) {
                                byte[] bArr2 = valueOf;
                                if (bArr2 != null) {
                                    int i16 = AFg1qSDK.values;
                                    AFg1qSDK.values = i16 - 1;
                                    AFg1qSDK.AFKeystoreWrapper = (char) (AFg1qSDK.AFInAppEventType + (((byte) (bArr2[i16] + s10)) ^ b10));
                                } else {
                                    short[] sArr = AFInAppEventParameterName;
                                    int i17 = AFg1qSDK.values;
                                    AFg1qSDK.values = i17 - 1;
                                    AFg1qSDK.AFKeystoreWrapper = (char) (AFg1qSDK.AFInAppEventType + (((short) (sArr[i17] + s10)) ^ b10));
                                }
                                sb2.append(AFg1qSDK.AFKeystoreWrapper);
                                AFg1qSDK.AFInAppEventType = AFg1qSDK.AFKeystoreWrapper;
                                AFg1qSDK.AFInAppEventParameterName++;
                            }
                        }
                        obj = sb2.toString();
                    } finally {
                    }
                }
                objArr[0] = obj;
            }

            @NonNull
            private static String AFInAppEventParameterName(@NonNull byte[] bArr) throws Exception {
                StringBuilder sb2 = new StringBuilder();
                int length = bArr.length;
                int i10 = 0;
                while (i10 < length) {
                    String hexString = Integer.toHexString(bArr[i10]);
                    if (hexString.length() == 1) {
                        StringBuilder sb3 = new StringBuilder();
                        Object[] objArr = new Object[1];
                        values(-1580374223 - ExpandableListView.getPackedPositionType(0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) - 1185622766, (byte) (-107 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), -84 - (ViewConfiguration.getLongPressTimeout() >> 16), (short) (-44 - TextUtils.indexOf("", "")), objArr);
                        sb3.append(((String) objArr[0]).intern());
                        sb3.append(hexString);
                        hexString = sb3.toString();
                        afErrorLog = (afInfoLog + 89) % 128;
                    }
                    sb2.append(hexString);
                    i10++;
                    afErrorLog = (afInfoLog + 53) % 128;
                }
                return sb2.toString();
            }
        }

        static {
            AFInAppEventType();
            ViewConfiguration.getKeyRepeatTimeout();
            View.MeasureSpec.getSize(0);
            PointF.length(0.0f, 0.0f);
            ViewConfiguration.getTouchSlop();
            Process.getGidForName("");
            ViewConfiguration.getJumpTapTimeout();
            TextUtils.getCapsMode("", 0, 0);
            KeyEvent.getMaxKeyCode();
            KeyEvent.keyCodeFromString("");
            ViewConfiguration.getTapTimeout();
            View.resolveSize(0, 0);
            ViewConfiguration.getWindowTouchSlop();
        }

        public AFa1xSDK(Map<String, Object> map, Context context) {
            this.valueOf = map;
            this.AFInAppEventParameterName = context;
            put(AFInAppEventParameterName(), valueOf());
        }

        @NonNull
        private String AFInAppEventParameterName() {
            String str;
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                Map<String, Object> map = this.valueOf;
                Object[] objArr = new Object[1];
                AFInAppEventParameterName((String) null, true, new int[]{0, 12, 26, 1}, objArr);
                String obj = map.get(((String) objArr[0]).intern()).toString();
                Map<String, Object> map2 = this.valueOf;
                Object[] objArr2 = new Object[1];
                AFKeystoreWrapper(((Process.getThreadPriority(0) + 20) >> 6) + 135, KeyEvent.keyCodeFromString("") + 5, 5 - Color.red(0), true, "�\u0007￺\u000b￻", objArr2);
                String obj2 = map2.get(((String) objArr2[0]).intern()).toString();
                if (obj2 == null) {
                    int i10 = AFKeystoreWrapper + 19;
                    AFLogger = i10 % 128;
                    if (i10 % 2 == 0) {
                        Object[] objArr3 = new Object[1];
                        AFInAppEventParameterName("\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000", false, new int[]{12, 8, 0, 3}, objArr3);
                        str = (String) objArr3[0];
                    } else {
                        Object[] objArr4 = new Object[1];
                        AFInAppEventParameterName("\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000", false, new int[]{12, 8, 0, 3}, objArr4);
                        str = (String) objArr4[0];
                    }
                    obj2 = str.intern();
                }
                StringBuilder sb2 = new StringBuilder(obj);
                sb2.reverse();
                StringBuilder AFKeystoreWrapper2 = AFKeystoreWrapper(num, obj2, sb2.toString());
                int length = AFKeystoreWrapper2.length();
                if (length > 4) {
                    int i11 = AFKeystoreWrapper + 69;
                    AFLogger = i11 % 128;
                    if (i11 % 2 == 0) {
                        AFKeystoreWrapper2.delete(3, length);
                    } else {
                        AFKeystoreWrapper2.delete(4, length);
                    }
                } else {
                    while (length < 4) {
                        length++;
                        AFKeystoreWrapper2.append('1');
                        AFLogger = (AFKeystoreWrapper + 119) % 128;
                    }
                }
                Object[] objArr5 = new Object[1];
                AFKeystoreWrapper((ViewConfiguration.getLongPressTimeout() >> 16) + 135, 3 - View.MeasureSpec.getSize(0), 2 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), false, "￾￿\u0004", objArr5);
                AFKeystoreWrapper2.insert(0, ((String) objArr5[0]).intern());
                return AFKeystoreWrapper2.toString();
            } catch (Exception e10) {
                Object[] objArr6 = new Object[1];
                AFInAppEventParameterName("\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000", false, new int[]{20, 40, 0, 0}, objArr6);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr6[0]).intern(), e10);
                StringBuilder sb3 = new StringBuilder();
                Object[] objArr7 = new Object[1];
                AFInAppEventParameterName("\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001", true, new int[]{60, 42, 0, 42}, objArr7);
                sb3.append(((String) objArr7[0]).intern());
                sb3.append(e10);
                AFLogger.afRDLog(sb3.toString());
                Object[] objArr8 = new Object[1];
                AFKeystoreWrapper(((byte) KeyEvent.getModifierMetaStateMask()) + 109, (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)) + 6, (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)) + 3, false, "￭￭￭￭\u001f\u0019\u001a", objArr8);
                return ((String) objArr8[0]).intern();
            }
        }

        static void AFInAppEventType() {
            AFInAppEventType = new char[]{'{', 138, 135, '{', 142, 141, 127, 135, 131, 142, 'y', 128, ' ', 'G', 'I', 'I', 'N', 'W', 'P', 'J', 16, 'C', 'f', 'l', 'e', 'D', '>', 'X', 'o', 'L', 'C', 'c', 'e', 'j', 'h', 'd', 'B', 'C', 'f', 'i', 'i', 'k', 'i', 'j', 'n', 'k', 'j', 'C', 'E', 'h', 'e', 'C', 'E', 'h', 'o', 'L', 'K', 'p', 'n', 'n', 16, '-', 'T', 'n', 'l', 'n', 'r', 'j', 'd', 'm', 'n', 'B', 'D', 'n', 'n', 'p', 'K', 'L', 'o', 'h', 'E', 'C', 'e', 'h', 'E', 'C', 'j', 'k', 'n', 'j', 'i', 'k', 'i', 'i', 'f', 'C', 'B', 'd', 'h', 'j', 'e', 'c', 22, 'O', 'j', 'H', ',', ':', 'p', 'f', 'k', 'K', 'C', 'e', 'h', 'E', 'C', 'j', 'k', 'n', 'j', 'i', 'k', 'i', 'i', 'f', 'C', 'B', 'd', 'h', 'j', 'e', 'c', 'C', 'B', 'm', 'p', 'f', '[', 'D', 'D', 'e', 'l', 'f', 'f', '3', 'j', 'k', 'n', 'j', 'i', 'k', 'i', 'i', 'f', 'C', 'B', 'd', 'h', 'j', 'e', 'c', 'C', '-', 'T', 'n', 'l', 'n', 'r', 'j', 'd', 'm', 'n', 'B', 'D', 'n', 'n', 'p', 'K', 'B', 'm', 'p', 'f', 'k', 'K', 'C', 'e', 'h', 'E', ':', 'l', 'i', 'n', 'j', 'k', 'i', 'j', 't', 's', 'k', 27, 'W', 'X', 147, 288, 285, 292, 293, 292, 135, 233, 'Q', 178, 185, 179, 185, 189, 189, 191, 184, 143, 143, 186, 189, 179, 168, 145, '3', 'K', 'P', 'P', 'P', 'Q', 'P', 'P', 'P', 'Q', '2', 'J', 'e', 'n', 'j', 'g'};
            values = 32;
        }

        private static StringBuilder AFKeystoreWrapper(@NonNull String... strArr) throws Exception {
            char c10;
            ArrayList arrayList = new ArrayList();
            int length = strArr.length;
            int i10 = 0;
            while (i10 < 3) {
                int i11 = AFKeystoreWrapper + 79;
                AFLogger = i11 % 128;
                if (i11 % 2 == 0) {
                    arrayList.add(Integer.valueOf(strArr[i10].length()));
                    i10 += 38;
                } else {
                    arrayList.add(Integer.valueOf(strArr[i10].length()));
                    i10++;
                }
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb2 = new StringBuilder();
            for (int i12 = 0; i12 < intValue; i12++) {
                Integer num = null;
                for (int i13 = 0; i13 < 3; i13++) {
                    int i14 = AFKeystoreWrapper + 95;
                    AFLogger = i14 % 128;
                    if (i14 % 2 == 0) {
                        c10 = strArr[i13].charAt(i12);
                        int i15 = 82 / 0;
                        if (num == null) {
                            num = Integer.valueOf(c10);
                        }
                    } else {
                        c10 = strArr[i13].charAt(i12);
                        if (num == null) {
                            num = Integer.valueOf(c10);
                        }
                    }
                    c10 ^= num.intValue();
                    num = Integer.valueOf(c10);
                }
                sb2.append(Integer.toHexString(num.intValue()));
            }
            return sb2;
        }

        private String valueOf() {
            String obj;
            int i10;
            try {
                Map<String, Object> map = this.valueOf;
                Object[] objArr = new Object[1];
                AFInAppEventParameterName((String) null, true, new int[]{0, 12, 26, 1}, objArr);
                String obj2 = map.get(((String) objArr[0]).intern()).toString();
                Map<String, Object> map2 = this.valueOf;
                Object[] objArr2 = new Object[1];
                AFKeystoreWrapper(134 - Color.alpha(0), TextUtils.lastIndexOf("", '0', 0, 0) + 16, View.getDefaultSize(0, 0) + 9, false, "￻\u000f\b�\u0002￞￻\u000e￿\u0000\u0003\f\r\u000e￦", objArr2);
                String obj3 = map2.get(((String) objArr2[0]).intern()).toString();
                Object[] objArr3 = new Object[1];
                AFKeystoreWrapper(80 - View.resolveSize(0, 0), 6 - (Process.myPid() >> 22), View.combineMeasuredStates(0, 0) + 2, true, "￾\u0006\u0002￾\u0000\u0001", objArr3);
                String intern = ((String) objArr3[0]).intern();
                Object[] objArr4 = new Object[1];
                AFInAppEventParameterName("\u0001\u0001\u0001\u0001\u0000", false, new int[]{LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 5, 0, 0}, objArr4);
                String replaceAll = intern.replaceAll(((String) objArr4[0]).intern(), "");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj2);
                sb2.append(obj3);
                sb2.append(replaceAll);
                String AFInAppEventParameterName2 = AFb1ySDK.AFInAppEventParameterName(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(AFInAppEventParameterName2.substring(0, 16));
                obj = sb3.toString();
                AFKeystoreWrapper = (AFLogger + 123) % 128;
            } catch (Exception e10) {
                Object[] objArr5 = new Object[1];
                AFInAppEventParameterName("\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0000", true, new int[]{107, 38, 0, 37}, objArr5);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e10);
                StringBuilder sb4 = new StringBuilder();
                Object[] objArr6 = new Object[1];
                AFInAppEventParameterName("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001", true, new int[]{145, 44, 0, 17}, objArr6);
                sb4.append(((String) objArr6[0]).intern());
                sb4.append(e10);
                AFLogger.afRDLog(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                Object[] objArr7 = new Object[1];
                AFKeystoreWrapper((ViewConfiguration.getPressedStateDuration() >> 16) + LocationRequestCompat.QUALITY_LOW_POWER, KeyEvent.keyCodeFromString("") + 18, TextUtils.indexOf("", "", 0, 0) + 16, false, "\u001a\u001d\u0019\u001d￨￭￬￨\u001c￱￩\u001e￪￨￩￰\u001a\u0019", objArr7);
                sb5.append(((String) objArr7[0]).intern());
                obj = sb5.toString();
            }
            String str = obj;
            try {
                Context context = this.AFInAppEventParameterName;
                Object[] objArr8 = new Object[1];
                AFKeystoreWrapper(120 - TextUtils.indexOf("", '0', 0, 0), 37 - Color.green(0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 31, true, "￪\u0006\u0000￹￬￻￻￨￩ￕ\u0015\u0016\u0010\u001b\n\bￕ\u001b\u0015\f\u001b\u0015\u0010ￕ\u000b\u0010\u0016\u0019\u000b\u0015\b￫￬￮￵￨￯", objArr8);
                Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter(((String) objArr8[0]).intern()));
                int i11 = -2700;
                if (registerReceiver != null) {
                    AFLogger = (AFKeystoreWrapper + 15) % 128;
                    Object[] objArr9 = new Object[1];
                    AFInAppEventParameterName("\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001", false, new int[]{189, 11, 0, 0}, objArr9);
                    i11 = registerReceiver.getIntExtra(((String) objArr9[0]).intern(), -2700);
                }
                String str2 = this.AFInAppEventParameterName.getApplicationInfo().nativeLibraryDir;
                if (str2 != null) {
                    AFKeystoreWrapper = (AFLogger + 97) % 128;
                    Object[] objArr10 = new Object[1];
                    AFInAppEventParameterName("\u0000\u0000\u0000", false, new int[]{200, 3, 0, 1}, objArr10);
                    if (!(!str2.contains(((String) objArr10[0]).intern()))) {
                        AFKeystoreWrapper = (AFLogger + 21) % 128;
                        i10 = 1;
                        Context context2 = this.AFInAppEventParameterName;
                        Object[] objArr11 = new Object[1];
                        AFInAppEventParameterName("\u0001\u0000\u0001\u0001\u0000\u0001", false, new int[]{203, 6, 180, 0}, objArr11);
                        int size = ((SensorManager) context2.getSystemService(((String) objArr11[0]).intern())).getSensorList(-1).size();
                        StringBuilder sb6 = new StringBuilder();
                        Object[] objArr12 = new Object[1];
                        AFKeystoreWrapper(130 - (ViewConfiguration.getJumpTapTimeout() >> 16), 1 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.getTrimmedLength("") + 1, true, "\u0000", objArr12);
                        sb6.append(((String) objArr12[0]).intern());
                        sb6.append(i11);
                        Object[] objArr13 = new Object[1];
                        AFKeystoreWrapper(((Process.getThreadPriority(0) + 20) >> 6) + 111, 3 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1)), Color.green(0) + 2, false, "ￗ)", objArr13);
                        sb6.append(((String) objArr13[0]).intern());
                        sb6.append(i10);
                        Object[] objArr14 = new Object[1];
                        AFKeystoreWrapper(TextUtils.lastIndexOf("", '0', 0, 0) + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, View.MeasureSpec.getSize(0) + 2, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), false, "'ￚ", objArr14);
                        sb6.append(((String) objArr14[0]).intern());
                        sb6.append(size);
                        Object[] objArr15 = new Object[1];
                        AFInAppEventParameterName("\u0000\u0000", true, new int[]{209, 2, 158, 0}, objArr15);
                        sb6.append(((String) objArr15[0]).intern());
                        sb6.append(this.valueOf.size());
                        String obj4 = sb6.toString();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str);
                        sb7.append(C0237AFa1ySDK.AFInAppEventParameterName(obj4));
                        return sb7.toString();
                    }
                }
                i10 = 0;
                Context context22 = this.AFInAppEventParameterName;
                Object[] objArr112 = new Object[1];
                AFInAppEventParameterName("\u0001\u0000\u0001\u0001\u0000\u0001", false, new int[]{203, 6, 180, 0}, objArr112);
                int size2 = ((SensorManager) context22.getSystemService(((String) objArr112[0]).intern())).getSensorList(-1).size();
                StringBuilder sb62 = new StringBuilder();
                Object[] objArr122 = new Object[1];
                AFKeystoreWrapper(130 - (ViewConfiguration.getJumpTapTimeout() >> 16), 1 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.getTrimmedLength("") + 1, true, "\u0000", objArr122);
                sb62.append(((String) objArr122[0]).intern());
                sb62.append(i11);
                Object[] objArr132 = new Object[1];
                AFKeystoreWrapper(((Process.getThreadPriority(0) + 20) >> 6) + 111, 3 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1)), Color.green(0) + 2, false, "ￗ)", objArr132);
                sb62.append(((String) objArr132[0]).intern());
                sb62.append(i10);
                Object[] objArr142 = new Object[1];
                AFKeystoreWrapper(TextUtils.lastIndexOf("", '0', 0, 0) + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, View.MeasureSpec.getSize(0) + 2, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), false, "'ￚ", objArr142);
                sb62.append(((String) objArr142[0]).intern());
                sb62.append(size2);
                Object[] objArr152 = new Object[1];
                AFInAppEventParameterName("\u0000\u0000", true, new int[]{209, 2, 158, 0}, objArr152);
                sb62.append(((String) objArr152[0]).intern());
                sb62.append(this.valueOf.size());
                String obj42 = sb62.toString();
                StringBuilder sb72 = new StringBuilder();
                sb72.append(str);
                sb72.append(C0237AFa1ySDK.AFInAppEventParameterName(obj42));
                return sb72.toString();
            } catch (Exception e11) {
                Object[] objArr16 = new Object[1];
                AFInAppEventParameterName("\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000", true, new int[]{211, 16, 77, 4}, objArr16);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr16[0]).intern(), e11);
                StringBuilder sb8 = new StringBuilder();
                Object[] objArr17 = new Object[1];
                AFInAppEventParameterName("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001", true, new int[]{145, 44, 0, 17}, objArr17);
                sb8.append(((String) objArr17[0]).intern());
                sb8.append(e11);
                AFLogger.afRDLog(sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str);
                Object[] objArr18 = new Object[1];
                AFInAppEventParameterName("\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000", false, new int[]{227, 16, 0, 0}, objArr18);
                sb9.append(((String) objArr18[0]).intern());
                return sb9.toString();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void AFKeystoreWrapper(int r6, int r7, int r8, boolean r9, java.lang.String r10, java.lang.Object[] r11) {
            /*
                if (r10 == 0) goto L_0x0006
                char[] r10 = r10.toCharArray()
            L_0x0006:
                char[] r10 = (char[]) r10
                java.lang.Object r0 = com.appsflyer.internal.AFg1pSDK.values
                monitor-enter(r0)
                char[] r1 = new char[r7]     // Catch:{ all -> 0x002f }
                r2 = 0
                com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r2     // Catch:{ all -> 0x002f }
            L_0x0010:
                int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch:{ all -> 0x002f }
                if (r3 >= r7) goto L_0x0031
                char r3 = r10[r3]     // Catch:{ all -> 0x002f }
                com.appsflyer.internal.AFg1pSDK.AFKeystoreWrapper = r3     // Catch:{ all -> 0x002f }
                int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch:{ all -> 0x002f }
                int r4 = com.appsflyer.internal.AFg1pSDK.AFKeystoreWrapper     // Catch:{ all -> 0x002f }
                int r4 = r4 + r6
                char r4 = (char) r4     // Catch:{ all -> 0x002f }
                r1[r3] = r4     // Catch:{ all -> 0x002f }
                int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch:{ all -> 0x002f }
                char r4 = r1[r3]     // Catch:{ all -> 0x002f }
                int r5 = values     // Catch:{ all -> 0x002f }
                int r4 = r4 - r5
                char r4 = (char) r4     // Catch:{ all -> 0x002f }
                r1[r3] = r4     // Catch:{ all -> 0x002f }
                int r3 = r3 + 1
                com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r3     // Catch:{ all -> 0x002f }
                goto L_0x0010
            L_0x002f:
                r6 = move-exception
                goto L_0x0069
            L_0x0031:
                if (r8 <= 0) goto L_0x0048
                com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName = r8     // Catch:{ all -> 0x002f }
                char[] r6 = new char[r7]     // Catch:{ all -> 0x002f }
                java.lang.System.arraycopy(r1, r2, r6, r2, r7)     // Catch:{ all -> 0x002f }
                int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName     // Catch:{ all -> 0x002f }
                int r10 = r7 - r8
                java.lang.System.arraycopy(r6, r2, r1, r10, r8)     // Catch:{ all -> 0x002f }
                int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName     // Catch:{ all -> 0x002f }
                int r10 = r7 - r8
                java.lang.System.arraycopy(r6, r8, r1, r2, r10)     // Catch:{ all -> 0x002f }
            L_0x0048:
                if (r9 == 0) goto L_0x0060
                char[] r6 = new char[r7]     // Catch:{ all -> 0x002f }
                com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r2     // Catch:{ all -> 0x002f }
            L_0x004e:
                int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch:{ all -> 0x002f }
                if (r8 >= r7) goto L_0x005f
                int r9 = r7 - r8
                int r9 = r9 + -1
                char r9 = r1[r9]     // Catch:{ all -> 0x002f }
                r6[r8] = r9     // Catch:{ all -> 0x002f }
                int r8 = r8 + 1
                com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r8     // Catch:{ all -> 0x002f }
                goto L_0x004e
            L_0x005f:
                r1 = r6
            L_0x0060:
                java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x002f }
                r6.<init>(r1)     // Catch:{ all -> 0x002f }
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                r11[r2] = r6
                return
            L_0x0069:
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFa1xSDK.AFKeystoreWrapper(int, int, int, boolean, java.lang.String, java.lang.Object[]):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r8v3, types: [char] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void AFInAppEventParameterName(java.lang.String r12, boolean r13, int[] r14, java.lang.Object[] r15) {
            /*
                if (r12 == 0) goto L_0x0008
                java.lang.String r0 = "ISO-8859-1"
                byte[] r12 = r12.getBytes(r0)
            L_0x0008:
                byte[] r12 = (byte[]) r12
                java.lang.Object r0 = com.appsflyer.internal.AFg1sSDK.values
                monitor-enter(r0)
                r1 = 0
                r2 = r14[r1]     // Catch:{ all -> 0x0038 }
                r3 = 1
                r4 = r14[r3]     // Catch:{ all -> 0x0038 }
                r5 = 2
                r6 = r14[r5]     // Catch:{ all -> 0x0038 }
                r7 = 3
                r7 = r14[r7]     // Catch:{ all -> 0x0038 }
                char[] r8 = AFInAppEventType     // Catch:{ all -> 0x0038 }
                char[] r9 = new char[r4]     // Catch:{ all -> 0x0038 }
                java.lang.System.arraycopy(r8, r2, r9, r1, r4)     // Catch:{ all -> 0x0038 }
                if (r12 == 0) goto L_0x0049
                char[] r2 = new char[r4]     // Catch:{ all -> 0x0038 }
                com.appsflyer.internal.AFg1sSDK.valueOf = r1     // Catch:{ all -> 0x0038 }
                r8 = r1
            L_0x0027:
                int r10 = com.appsflyer.internal.AFg1sSDK.valueOf     // Catch:{ all -> 0x0038 }
                if (r10 >= r4) goto L_0x0048
                byte r11 = r12[r10]     // Catch:{ all -> 0x0038 }
                if (r11 != r3) goto L_0x003a
                char r11 = r9[r10]     // Catch:{ all -> 0x0038 }
                int r11 = r11 << r3
                int r11 = r11 + r3
                int r11 = r11 - r8
                char r8 = (char) r11     // Catch:{ all -> 0x0038 }
                r2[r10] = r8     // Catch:{ all -> 0x0038 }
                goto L_0x0041
            L_0x0038:
                r12 = move-exception
                goto L_0x008d
            L_0x003a:
                char r11 = r9[r10]     // Catch:{ all -> 0x0038 }
                int r11 = r11 << r3
                int r11 = r11 - r8
                char r8 = (char) r11     // Catch:{ all -> 0x0038 }
                r2[r10] = r8     // Catch:{ all -> 0x0038 }
            L_0x0041:
                char r8 = r2[r10]     // Catch:{ all -> 0x0038 }
                int r10 = r10 + 1
                com.appsflyer.internal.AFg1sSDK.valueOf = r10     // Catch:{ all -> 0x0038 }
                goto L_0x0027
            L_0x0048:
                r9 = r2
            L_0x0049:
                if (r7 <= 0) goto L_0x0058
                char[] r12 = new char[r4]     // Catch:{ all -> 0x0038 }
                java.lang.System.arraycopy(r9, r1, r12, r1, r4)     // Catch:{ all -> 0x0038 }
                int r2 = r4 - r7
                java.lang.System.arraycopy(r12, r1, r9, r2, r7)     // Catch:{ all -> 0x0038 }
                java.lang.System.arraycopy(r12, r7, r9, r1, r2)     // Catch:{ all -> 0x0038 }
            L_0x0058:
                if (r13 == 0) goto L_0x006f
                char[] r12 = new char[r4]     // Catch:{ all -> 0x0038 }
                com.appsflyer.internal.AFg1sSDK.valueOf = r1     // Catch:{ all -> 0x0038 }
            L_0x005e:
                int r13 = com.appsflyer.internal.AFg1sSDK.valueOf     // Catch:{ all -> 0x0038 }
                if (r13 >= r4) goto L_0x006e
                int r2 = r4 - r13
                int r2 = r2 - r3
                char r2 = r9[r2]     // Catch:{ all -> 0x0038 }
                r12[r13] = r2     // Catch:{ all -> 0x0038 }
                int r13 = r13 + 1
                com.appsflyer.internal.AFg1sSDK.valueOf = r13     // Catch:{ all -> 0x0038 }
                goto L_0x005e
            L_0x006e:
                r9 = r12
            L_0x006f:
                if (r6 <= 0) goto L_0x0084
                com.appsflyer.internal.AFg1sSDK.valueOf = r1     // Catch:{ all -> 0x0038 }
            L_0x0073:
                int r12 = com.appsflyer.internal.AFg1sSDK.valueOf     // Catch:{ all -> 0x0038 }
                if (r12 >= r4) goto L_0x0084
                char r13 = r9[r12]     // Catch:{ all -> 0x0038 }
                r2 = r14[r5]     // Catch:{ all -> 0x0038 }
                int r13 = r13 - r2
                char r13 = (char) r13     // Catch:{ all -> 0x0038 }
                r9[r12] = r13     // Catch:{ all -> 0x0038 }
                int r12 = r12 + 1
                com.appsflyer.internal.AFg1sSDK.valueOf = r12     // Catch:{ all -> 0x0038 }
                goto L_0x0073
            L_0x0084:
                java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x0038 }
                r12.<init>(r9)     // Catch:{ all -> 0x0038 }
                monitor-exit(r0)     // Catch:{ all -> 0x0038 }
                r15[r1] = r12
                return
            L_0x008d:
                monitor-exit(r0)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFa1xSDK.AFInAppEventParameterName(java.lang.String, boolean, int[], java.lang.Object[]):void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFKeystoreWrapper(java.lang.StringBuilder r11) {
        /*
            int r0 = android.view.ViewConfiguration.getWindowTouchSlop()
            int r0 = r0 >> 8
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "ꬑꭰ꾱꣹?휬꓾뇾럦謮雚鉎鹖ﺸ뵤쾡?턆姥⍍▇㺆䐧ñó"
            values(r3, r0, r2)
            r0 = 0
            r2 = r2[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r2 = AFInAppEventType(r2)
            java.lang.String r3 = "쨰쨀亷ᖮ폷"
            java.lang.String r4 = "젻젊㭿ъ窫"
            if (r2 == 0) goto L_0x0033
            int r2 = android.graphics.drawable.Drawable.resolveOpacity(r0, r0)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            values(r4, r2, r5)
            r2 = r5[r0]
        L_0x002c:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            goto L_0x0042
        L_0x0033:
            r2 = 0
            float r5 = android.util.TypedValue.complexToFraction(r0, r2, r2)
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            java.lang.Object[] r5 = new java.lang.Object[r1]
            values(r3, r2, r5)
            r2 = r5[r0]
            goto L_0x002c
        L_0x0042:
            r11.append(r2)
            int r2 = android.view.KeyEvent.getModifierMetaStateMask()
            byte r2 = (byte) r2
            int r2 = r2 + 26965
            char r2 = (char) r2
            long r5 = android.os.Process.getElapsedCpuTime()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r5 = r5 + 68
            int r6 = android.view.KeyEvent.getDeadChar(r0, r0)
            int r6 = r6 + 23
            java.lang.Object[] r9 = new java.lang.Object[r1]
            AFInAppEventType(r2, r5, r6, r9)
            r2 = r9[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r2 = AFInAppEventType(r2)
            if (r2 == 0) goto L_0x00a8
            int r2 = AFKeystoreWrapper
            int r2 = r2 + 33
            int r5 = r2 % 128
            AFInAppEventParameterName = r5
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x0092
            long r5 = android.os.SystemClock.uptimeMillis()
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r2 = -1 - r2
            java.lang.Object[] r5 = new java.lang.Object[r1]
            values(r4, r2, r5)
            r2 = r5[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            goto L_0x00b7
        L_0x0092:
            long r5 = android.os.SystemClock.uptimeMillis()
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r2 = r2 + -1
            java.lang.Object[] r5 = new java.lang.Object[r1]
            values(r4, r2, r5)
            r2 = r5[r0]
        L_0x00a1:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            goto L_0x00b7
        L_0x00a8:
            long r5 = android.widget.ExpandableListView.getPackedPositionForChild(r0, r0)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r2 = r2 + r1
            java.lang.Object[] r5 = new java.lang.Object[r1]
            values(r3, r2, r5)
            r2 = r5[r0]
            goto L_0x00a1
        L_0x00b7:
            r11.append(r2)
            java.lang.String r2 = ""
            int r2 = android.text.TextUtils.indexOf(r2, r2)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r6 = "鯄鮥ￋ᎓ᶻ兄䑄蜳?㤓捠ꊛ뿮品ᾧ칿ꍜ矩㨝蘬鍌훽"
            values(r6, r2, r5)
            r2 = r5[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r2 = AFInAppEventType(r2)
            if (r2 == 0) goto L_0x00e5
            long r5 = android.os.Process.getElapsedCpuTime()
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r2 = 1 - r2
            java.lang.Object[] r5 = new java.lang.Object[r1]
            values(r4, r2, r5)
            r2 = r5[r0]
            goto L_0x00f0
        L_0x00e5:
            int r2 = android.view.View.getDefaultSize(r0, r0)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            values(r3, r2, r5)
            r2 = r5[r0]
        L_0x00f0:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            r11.append(r2)
            long r5 = android.os.Process.getElapsedCpuTime()
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r2 = r2 + 6720
            char r2 = (char) r2
            long r5 = android.os.SystemClock.uptimeMillis()
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r5 = 93 - r5
            long r9 = android.widget.ExpandableListView.getPackedPositionForGroup(r0)
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            int r6 = r6 + 15
            java.lang.Object[] r7 = new java.lang.Object[r1]
            AFInAppEventType(r2, r5, r6, r7)
            r2 = r7[r0]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r2 = AFInAppEventType(r2)
            r2 = r2 ^ r1
            if (r2 == 0) goto L_0x013a
            int r2 = android.view.ViewConfiguration.getMaximumDrawingCacheSize()
            int r2 = r2 >> 24
            java.lang.Object[] r1 = new java.lang.Object[r1]
            values(r3, r2, r1)
            r0 = r1[r0]
        L_0x0133:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            goto L_0x0150
        L_0x013a:
            int r2 = AFInAppEventParameterName
            int r2 = r2 + 49
            int r2 = r2 % 128
            AFKeystoreWrapper = r2
            int r2 = android.view.ViewConfiguration.getKeyRepeatTimeout()
            int r2 = r2 >> 16
            java.lang.Object[] r1 = new java.lang.Object[r1]
            values(r4, r2, r1)
            r0 = r1[r0]
            goto L_0x0133
        L_0x0150:
            r11.append(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.AFKeystoreWrapper(java.lang.StringBuilder):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void values(java.lang.String r8, int r9, java.lang.Object[] r10) {
        /*
            if (r8 == 0) goto L_0x0006
            char[] r8 = r8.toCharArray()
        L_0x0006:
            char[] r8 = (char[]) r8
            java.lang.Object r0 = com.appsflyer.internal.AFf1aSDK.values
            monitor-enter(r0)
            long r1 = values     // Catch:{ all -> 0x0039 }
            char[] r8 = com.appsflyer.internal.AFf1aSDK.values(r1, r8, r9)     // Catch:{ all -> 0x0039 }
            r9 = 4
            com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper = r9     // Catch:{ all -> 0x0039 }
        L_0x0014:
            int r1 = com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0039 }
            int r2 = r8.length     // Catch:{ all -> 0x0039 }
            if (r1 >= r2) goto L_0x003b
            int r1 = r1 + -4
            com.appsflyer.internal.AFf1aSDK.AFInAppEventType = r1     // Catch:{ all -> 0x0039 }
            int r1 = com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0039 }
            char r2 = r8[r1]     // Catch:{ all -> 0x0039 }
            int r3 = r1 % 4
            char r3 = r8[r3]     // Catch:{ all -> 0x0039 }
            r2 = r2 ^ r3
            long r2 = (long) r2     // Catch:{ all -> 0x0039 }
            int r4 = com.appsflyer.internal.AFf1aSDK.AFInAppEventType     // Catch:{ all -> 0x0039 }
            long r4 = (long) r4     // Catch:{ all -> 0x0039 }
            long r6 = values     // Catch:{ all -> 0x0039 }
            long r4 = r4 * r6
            long r2 = r2 ^ r4
            int r2 = (int) r2     // Catch:{ all -> 0x0039 }
            char r2 = (char) r2     // Catch:{ all -> 0x0039 }
            r8[r1] = r2     // Catch:{ all -> 0x0039 }
            int r1 = com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0039 }
            int r1 = r1 + 1
            com.appsflyer.internal.AFf1aSDK.AFKeystoreWrapper = r1     // Catch:{ all -> 0x0039 }
            goto L_0x0014
        L_0x0039:
            r8 = move-exception
            goto L_0x0047
        L_0x003b:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0039 }
            int r2 = r8.length     // Catch:{ all -> 0x0039 }
            int r2 = r2 - r9
            r1.<init>(r8, r9, r2)     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            r8 = 0
            r10[r8] = r1
            return
        L_0x0047:
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1ySDK.values(java.lang.String, int, java.lang.Object[]):void");
    }

    private static boolean AFInAppEventType(String str) {
        int i10 = AFKeystoreWrapper + 25;
        AFInAppEventParameterName = i10 % 128;
        if (i10 % 2 != 0) {
            try {
                Class.forName(str);
                return false;
            } catch (ClassNotFoundException e10) {
                Object[] objArr = new Object[1];
                AFInAppEventType((char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 50 - (ViewConfiguration.getJumpTapTimeout() >> 16), 18 - TextUtils.lastIndexOf("", '0', 0, 0), objArr);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr[0]).intern(), e10);
                return false;
            }
        } else {
            Class.forName(str);
            return true;
        }
    }

    private static void AFInAppEventType(char c10, int i10, int i11, Object[] objArr) {
        String str;
        synchronized (AFg1oSDK.AFInAppEventType) {
            try {
                char[] cArr = new char[i11];
                AFg1oSDK.AFKeystoreWrapper = 0;
                while (true) {
                    int i12 = AFg1oSDK.AFKeystoreWrapper;
                    if (i12 < i11) {
                        cArr[i12] = (char) ((int) ((((long) AFInAppEventType[i10 + i12]) ^ (((long) i12) * valueOf)) ^ ((long) c10)));
                        AFg1oSDK.AFKeystoreWrapper = i12 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = str;
    }
}
