package com.facebook.react.uimanager.events;

import android.view.View;
import com.facebook.react.m;

public abstract class o {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3637a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.uimanager.events.o$b[] r0 = com.facebook.react.uimanager.events.o.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3637a = r0
                com.facebook.react.uimanager.events.o$b r1 = com.facebook.react.uimanager.events.o.b.DOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3637a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.uimanager.events.o$b r1 = com.facebook.react.uimanager.events.o.b.DOWN_CAPTURE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3637a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.uimanager.events.o$b r1 = com.facebook.react.uimanager.events.o.b.UP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3637a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.uimanager.events.o$b r1 = com.facebook.react.uimanager.events.o.b.UP_CAPTURE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3637a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.uimanager.events.o$b r1 = com.facebook.react.uimanager.events.o.b.CANCEL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3637a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.uimanager.events.o$b r1 = com.facebook.react.uimanager.events.o.b.CANCEL_CAPTURE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3637a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.facebook.react.uimanager.events.o$b r1 = com.facebook.react.uimanager.events.o.b.CLICK     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f3637a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.facebook.react.uimanager.events.o$b r1 = com.facebook.react.uimanager.events.o.b.CLICK_CAPTURE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.o.a.<clinit>():void");
        }
    }

    public enum b {
        CANCEL,
        CANCEL_CAPTURE,
        CLICK,
        CLICK_CAPTURE,
        DOWN,
        DOWN_CAPTURE,
        ENTER,
        ENTER_CAPTURE,
        LEAVE,
        LEAVE_CAPTURE,
        MOVE,
        MOVE_CAPTURE,
        UP,
        UP_CAPTURE,
        OUT,
        OUT_CAPTURE,
        OVER,
        OVER_CAPTURE
    }

    public static int a(String str, int i10, int i11) {
        int i12 = 0;
        if ("touch".equals(str)) {
            return 0;
        }
        int i13 = i11 ^ i10;
        if (i13 == 0) {
            return -1;
        }
        if (i13 != 1) {
            i12 = 2;
            if (i13 != 2) {
                if (i13 == 4) {
                    return 1;
                }
                if (i13 == 8) {
                    return 3;
                }
                if (i13 != 16) {
                    return -1;
                }
                return 4;
            }
        }
        return i12;
    }

    public static int b(String str, String str2, int i10) {
        if (g(str)) {
            return 0;
        }
        if ("touch".equals(str2)) {
            return 1;
        }
        return i10;
    }

    public static int c(String str) {
        if (str == null) {
            return 2;
        }
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1786514288:
                if (str.equals("topPointerEnter")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1780335505:
                if (str.equals("topPointerLeave")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1304584214:
                if (str.equals("topPointerDown")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1304316135:
                if (str.equals("topPointerMove")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1304250340:
                if (str.equals("topPointerOver")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1065042973:
                if (str.equals("topPointerUp")) {
                    c10 = 5;
                    break;
                }
                break;
            case 383186882:
                if (str.equals("topPointerCancel")) {
                    c10 = 6;
                    break;
                }
                break;
            case 1343400710:
                if (str.equals("topPointerOut")) {
                    c10 = 7;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 1:
            case 3:
            case 4:
            case 7:
                return 4;
            case 2:
            case 5:
            case 6:
                return 3;
            default:
                return 2;
        }
    }

    public static double d(int i10, String str) {
        if (!g(str) && i10 != 0) {
            return 0.5d;
        }
        return 0.0d;
    }

    public static String e(int i10) {
        if (i10 == 1) {
            return "touch";
        }
        if (i10 == 2) {
            return "pen";
        }
        if (i10 != 3) {
            return "";
        }
        return "mouse";
    }

    public static boolean f(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1304584214:
                if (str.equals("topPointerDown")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1304316135:
                if (str.equals("topPointerMove")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1304250340:
                if (str.equals("topPointerOver")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1065042973:
                if (str.equals("topPointerUp")) {
                    c10 = 3;
                    break;
                }
                break;
            case 383186882:
                if (str.equals("topPointerCancel")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1343400710:
                if (str.equals("topPointerOut")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    public static boolean g(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1780335505:
                if (str.equals("topPointerLeave")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1065042973:
                if (str.equals("topPointerUp")) {
                    c10 = 1;
                    break;
                }
                break;
            case 1343400710:
                if (str.equals("topPointerOut")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean h(View view, b bVar) {
        if (view == null) {
            return true;
        }
        switch (a.f3637a[bVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                Integer num = (Integer) view.getTag(m.f20859p);
                if (num == null) {
                    return false;
                }
                if ((num.intValue() & (1 << bVar.ordinal())) != 0) {
                    return true;
                }
                return false;
        }
    }
}
