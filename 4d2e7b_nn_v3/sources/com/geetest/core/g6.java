package com.geetest.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.alibaba.pdns.net.f.g;
import com.geetest.core.p6;
import com.zing.zalo.zalosdk.ZaloOAuthResultCode;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import z8.h;

public class g6 {

    /* renamed from: a  reason: collision with root package name */
    public h6 f5987a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5988b;

    /* renamed from: c  reason: collision with root package name */
    public Network f5989c;

    /* renamed from: d  reason: collision with root package name */
    public ConnectivityManager f5990d;

    /* renamed from: e  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f5991e;

    /* renamed from: f  reason: collision with root package name */
    public e6 f5992f;

    public class c extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f5996a;

        public c(CountDownLatch countDownLatch) {
            this.f5996a = countDownLatch;
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            if (this.f5996a.getCount() != 0) {
                g6 g6Var = g6.this;
                g6Var.f5991e = this;
                g6Var.f5989c = network;
                this.f5996a.countDown();
            }
        }
    }

    public final void b(j6 j6Var) {
        if (this.f5987a == h6.CU) {
            p6 p6Var = p6.a.f6139a;
            Context context = this.f5988b;
            Network network = this.f5989c;
            HashMap hashMap = new HashMap();
            String str = j6Var.f6070a;
            if (TextUtils.isEmpty(str)) {
                str = "1554778161153";
            }
            hashMap.put("appId", str);
            n6 n6Var = new n6(context, c.a((Map<String, String>) hashMap).insert(0, "https://nisportal.10010.com:9001/api?").toString());
            n6Var.f6082b = network;
            n6Var.f6083c = ZaloOAuthResultCode.RESULTCODE_REGIS_IDENTIFY_CARD_NUMBER_SUCCESS;
            p6Var.a(n6Var, new b(j6Var));
            return;
        }
        c(j6Var);
    }

    public final void c(j6 j6Var) {
        String str;
        p6 p6Var = p6.a.f6139a;
        Context context = this.f5988b;
        h6 h6Var = this.f5987a;
        Network network = this.f5989c;
        int ordinal = h6Var.ordinal();
        if (ordinal == 0) {
            str = "https://msg.cmpassport.com/h5/getMobile";
        } else if (ordinal == 1) {
            str = "https://id6.me/gw/preuniq.do";
        } else if (ordinal != 2) {
            str = "";
        } else {
            HashMap hashMap = new HashMap();
            String str2 = j6Var.f6070a;
            if (TextUtils.isEmpty(str2)) {
                str2 = "1554778161153";
            }
            hashMap.put("appId", str2);
            StringBuffer a10 = c.a((Map<String, String>) hashMap);
            str = a10.insert(0, j6Var.f6053k + "?").toString();
        }
        o6 o6Var = new o6(context, str);
        o6Var.f6121d = h6Var;
        o6Var.f6122e = j6Var;
        o6Var.f6082b = network;
        o6Var.f6083c = ZaloOAuthResultCode.RESULTCODE_REGIS_IDENTIFY_CARD_NUMBER_SUCCESS;
        p6Var.a(o6Var, new a());
    }

    public void a(Context context, e6 e6Var) {
        this.f5988b = context;
        this.f5992f = e6Var;
        if (context == null) {
            ((b) e6Var).a(d6.a(new k6("-20501", "Illegal parameters", "context is null")));
        } else if (Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            new Thread(new h(this, context, e6Var));
        } else {
            c(context, e6Var);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0074, code lost:
        if (r5.equalsIgnoreCase("CDMA2000") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        r3 = "5G";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009c, code lost:
        r3 = "4G";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009f, code lost:
        r3 = "3G";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a1, code lost:
        r3 = "2G";
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.geetest.core.j6 r12) {
        /*
            r11 = this;
            java.lang.String r0 = "2G"
            java.lang.String r1 = "3G"
            java.lang.String r2 = "WIFI"
            android.content.Context r3 = r11.f5988b
            java.lang.String r4 = "connectivity"
            java.lang.Object r5 = r3.getSystemService(r4)
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 29
            r8 = 0
            r9 = 1
            if (r6 < r7) goto L_0x0077
            if (r5 != 0) goto L_0x001c
            goto L_0x0096
        L_0x001c:
            android.net.NetworkInfo r3 = r5.getActiveNetworkInfo()
            if (r3 == 0) goto L_0x0096
            boolean r6 = r3.isAvailable()
            if (r6 != 0) goto L_0x002a
            goto L_0x0096
        L_0x002a:
            android.net.NetworkInfo r6 = r5.getNetworkInfo(r9)
            if (r6 == 0) goto L_0x003f
            android.net.NetworkInfo$State r6 = r6.getState()
            if (r6 == 0) goto L_0x003f
            android.net.NetworkInfo$State r7 = android.net.NetworkInfo.State.CONNECTED
            if (r6 == r7) goto L_0x0085
            android.net.NetworkInfo$State r7 = android.net.NetworkInfo.State.CONNECTING
            if (r6 != r7) goto L_0x003f
            goto L_0x0085
        L_0x003f:
            android.net.NetworkInfo r5 = r5.getNetworkInfo(r8)
            if (r5 == 0) goto L_0x0096
            android.net.NetworkInfo$State r6 = r5.getState()
            java.lang.String r5 = r5.getSubtypeName()
            int r3 = r3.getSubtype()
            if (r6 == 0) goto L_0x0096
            android.net.NetworkInfo$State r7 = android.net.NetworkInfo.State.CONNECTED
            if (r6 == r7) goto L_0x005b
            android.net.NetworkInfo$State r7 = android.net.NetworkInfo.State.CONNECTING
            if (r6 != r7) goto L_0x0096
        L_0x005b:
            switch(r3) {
                case 1: goto L_0x00a1;
                case 2: goto L_0x00a1;
                case 3: goto L_0x009f;
                case 4: goto L_0x00a1;
                case 5: goto L_0x009f;
                case 6: goto L_0x009f;
                case 7: goto L_0x00a1;
                case 8: goto L_0x009f;
                case 9: goto L_0x009f;
                case 10: goto L_0x009f;
                case 11: goto L_0x00a1;
                case 12: goto L_0x009f;
                case 13: goto L_0x009c;
                case 14: goto L_0x009f;
                case 15: goto L_0x009f;
                case 16: goto L_0x00a1;
                case 17: goto L_0x005e;
                case 18: goto L_0x009c;
                case 19: goto L_0x009c;
                case 20: goto L_0x0099;
                default: goto L_0x005e;
            }
        L_0x005e:
            java.lang.String r3 = "TD-SCDMA"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x009f
            java.lang.String r3 = "WCDMA"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x009f
            java.lang.String r3 = "CDMA2000"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0096
            goto L_0x009f
        L_0x0077:
            if (r5 == 0) goto L_0x0087
            android.net.NetworkInfo r5 = r5.getNetworkInfo(r9)
            if (r5 == 0) goto L_0x0087
            boolean r5 = r5.isConnectedOrConnecting()
            if (r5 == 0) goto L_0x0087
        L_0x0085:
            r3 = r2
            goto L_0x00a2
        L_0x0087:
            java.lang.String r5 = "phone"
            java.lang.Object r3 = r3.getSystemService(r5)
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3
            int r3 = r3.getNetworkType()
            switch(r3) {
                case 1: goto L_0x00a1;
                case 2: goto L_0x00a1;
                case 3: goto L_0x009f;
                case 4: goto L_0x00a1;
                case 5: goto L_0x009f;
                case 6: goto L_0x009f;
                case 7: goto L_0x00a1;
                case 8: goto L_0x009f;
                case 9: goto L_0x009f;
                case 10: goto L_0x009f;
                case 11: goto L_0x00a1;
                case 12: goto L_0x009f;
                case 13: goto L_0x009c;
                case 14: goto L_0x009f;
                case 15: goto L_0x009f;
                case 16: goto L_0x00a1;
                case 17: goto L_0x009f;
                case 18: goto L_0x009c;
                case 19: goto L_0x009c;
                case 20: goto L_0x0099;
                default: goto L_0x0096;
            }
        L_0x0096:
            java.lang.String r3 = "NULL"
            goto L_0x00a2
        L_0x0099:
            java.lang.String r3 = "5G"
            goto L_0x00a2
        L_0x009c:
            java.lang.String r3 = "4G"
            goto L_0x00a2
        L_0x009f:
            r3 = r1
            goto L_0x00a2
        L_0x00a1:
            r3 = r0
        L_0x00a2:
            java.lang.String r5 = "Can't access cellular."
            java.lang.String r6 = "-20202"
            r7 = -1
            int r10 = r3.hashCode()
            switch(r10) {
                case 1621: goto L_0x00c1;
                case 1652: goto L_0x00b8;
                case 2664213: goto L_0x00af;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            goto L_0x00c9
        L_0x00af:
            boolean r0 = r3.equals(r2)
            if (r0 != 0) goto L_0x00b6
            goto L_0x00c9
        L_0x00b6:
            r7 = 2
            goto L_0x00c9
        L_0x00b8:
            boolean r0 = r3.equals(r1)
            if (r0 != 0) goto L_0x00bf
            goto L_0x00c9
        L_0x00bf:
            r7 = r9
            goto L_0x00c9
        L_0x00c1:
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00c8
            goto L_0x00c9
        L_0x00c8:
            r7 = r8
        L_0x00c9:
            switch(r7) {
                case 0: goto L_0x014d;
                case 1: goto L_0x013a;
                case 2: goto L_0x00d8;
                default: goto L_0x00cc;
            }
        L_0x00cc:
            r0 = 0
            r11.f5990d = r0
            r11.f5991e = r0
            r11.f5989c = r0
            r11.b(r12)
            goto L_0x015f
        L_0x00d8:
            android.content.Context r0 = r11.f5988b
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r1 = "airplane_mode_on"
            int r0 = android.provider.Settings.System.getInt(r0, r1, r8)
            if (r0 != r9) goto L_0x00e7
            goto L_0x0127
        L_0x00e7:
            android.content.Context r0 = r11.f5988b
            boolean r0 = com.geetest.core.c.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x0127
            android.content.Context r0 = r11.f5988b
            java.lang.Object r0 = r0.getSystemService(r4)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r11.f5990d = r0
            android.net.NetworkRequest$Builder r0 = new android.net.NetworkRequest$Builder
            r0.<init>()
            android.net.NetworkRequest$Builder r0 = r0.addTransportType(r8)
            r1 = 12
            android.net.NetworkRequest$Builder r0 = r0.addCapability(r1)
            android.net.NetworkRequest r0 = r0.build()
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch
            r1.<init>(r9)
            android.net.ConnectivityManager r2 = r11.f5990d
            com.geetest.core.g6$c r3 = new com.geetest.core.g6$c
            r3.<init>(r1)
            r2.requestNetwork(r0, r3)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0126 }
            r2 = 8000(0x1f40, double:3.9525E-320)
            r1.await(r2, r0)     // Catch:{ InterruptedException -> 0x0126 }
            r11.b(r12)
            goto L_0x015f
        L_0x0126:
            return
        L_0x0127:
            com.geetest.core.e6 r12 = r11.f5992f
            com.geetest.core.k6 r0 = new com.geetest.core.k6
            java.lang.String r1 = ""
            r0.<init>(r6, r5, r1)
            com.geetest.core.d6 r0 = com.geetest.core.d6.a(r0)
            com.geetest.core.b r12 = (com.geetest.core.b) r12
            r12.a(r0)
            goto L_0x015f
        L_0x013a:
            com.geetest.core.e6 r12 = r11.f5992f
            com.geetest.core.k6 r0 = new com.geetest.core.k6
            java.lang.String r1 = "CT does not support 3G network environment"
            r0.<init>(r6, r5, r1)
            com.geetest.core.d6 r0 = com.geetest.core.d6.a(r0)
            com.geetest.core.b r12 = (com.geetest.core.b) r12
            r12.a(r0)
            goto L_0x015f
        L_0x014d:
            com.geetest.core.e6 r12 = r11.f5992f
            com.geetest.core.k6 r0 = new com.geetest.core.k6
            java.lang.String r1 = "CT does not support 2G network environment"
            r0.<init>(r6, r5, r1)
            com.geetest.core.d6 r0 = com.geetest.core.d6.a(r0)
            com.geetest.core.b r12 = (com.geetest.core.b) r12
            r12.a(r0)
        L_0x015f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.g6.a(com.geetest.core.j6):void");
    }

    public class b implements s6<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j6 f5994a;

        public b(j6 j6Var) {
            this.f5994a = j6Var;
        }

        public void a(String str, Object obj) {
            String str2 = (String) obj;
            if (TextUtils.isEmpty(str) || !str.equals("1")) {
                ((b) g6.this.f5992f).a(d6.a(new k6("-40201", "China Unicom return invalid data.", str2)));
                return;
            }
            j6 j6Var = this.f5994a;
            j6Var.f6053k = str2 + "/api";
            g6.this.c(this.f5994a);
        }

        public void a(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                ((b) g6.this.f5992f).a(d6.a(new k6(str, "Operator return invalid data.", str2)));
            }
        }
    }

    /* renamed from: b */
    public final void c(Context context, e6 e6Var) {
        h6 h6Var;
        try {
            if (!c.b(context)) {
                ((b) this.f5992f).a(d6.a(new k6("-20200", "No valid network.", "Network Unavailable")));
                return;
            }
            if (t6.f6182a == null) {
                t6.f6182a = new t6(context);
            }
            TelephonyManager telephonyManager = (TelephonyManager) t6.f6182a.f6183b.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager != null) {
                String simOperator = telephonyManager.getSimOperator();
                simOperator.hashCode();
                char c10 = 65535;
                switch (simOperator.hashCode()) {
                    case 49679470:
                        if (simOperator.equals(g.f18123p)) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 49679471:
                        if (simOperator.equals(g.f18127t)) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 49679472:
                        if (simOperator.equals(g.f18124q)) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 49679473:
                        if (simOperator.equals(g.f18130w)) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 49679474:
                        if (simOperator.equals("46004")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 49679475:
                        if (simOperator.equals(g.f18131x)) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 49679476:
                        if (simOperator.equals(g.f18128u)) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 49679477:
                        if (simOperator.equals(g.f18125r)) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 49679479:
                        if (simOperator.equals(g.f18129v)) {
                            c10 = 8;
                            break;
                        }
                        break;
                    case 49679502:
                        if (simOperator.equals(g.f18132y)) {
                            c10 = 9;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                    case 2:
                    case 4:
                    case 7:
                        h6Var = h6.CM;
                        break;
                    case 1:
                    case 6:
                    case 8:
                        h6Var = h6.CU;
                        break;
                    case 3:
                    case 5:
                    case 9:
                        h6Var = h6.CT;
                        break;
                    default:
                        h6Var = h6.UNKNOWN;
                        break;
                }
            } else {
                h6Var = h6.UNKNOWN;
            }
            this.f5987a = h6Var;
            if (h6Var != h6.UNKNOWN) {
                j6 j6Var = (j6) ((b) e6Var).a(h6Var.getType(), "30100");
                if (j6Var == null) {
                    ((b) this.f5992f).a(d6.a(new k6("-50101", "GetUaidConfig interface return is illegal.", "beforeGetSignTask returned null GGW")));
                    return;
                }
                a(j6Var);
                return;
            }
            ((b) this.f5992f).a(d6.a(new k6("-20203", "Do not get right operator.", "Check if SIM card is inserted or if it is not from a domestic operator")));
        } catch (Exception e10) {
            ((b) this.f5992f).a(d6.a(new k6("-60100", "InquireUaid interface return exception.", e10.toString())));
        }
    }

    public class a implements s6<i6> {
        public a() {
        }

        public void a(String str, Object obj) {
            ConnectivityManager.NetworkCallback networkCallback;
            i6 i6Var = (i6) obj;
            g6 g6Var = g6.this;
            ConnectivityManager connectivityManager = g6Var.f5990d;
            if (connectivityManager != null && (networkCallback = g6Var.f5991e) != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            } else if (connectivityManager != null) {
                Class<ConnectivityManager> cls = ConnectivityManager.class;
                try {
                    ((Integer) cls.getDeclaredMethod("stopUsingNetworkFeature", new Class[]{Integer.TYPE, String.class}).invoke(connectivityManager, new Object[]{0, "enableHIPRI"})).intValue();
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                }
            }
            int ordinal = g6.this.f5987a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2 && (TextUtils.isEmpty(str) || !str.equals("1"))) {
                        ((b) g6.this.f5992f).a(d6.a(new k6("-40201", "China Unicom return invalid data.", i6Var.toString())));
                        return;
                    }
                } else if (TextUtils.isEmpty(str) || !str.equals("0")) {
                    ((b) g6.this.f5992f).a(d6.a(new k6("-40301", "China Telecom return invalid data.", i6Var.toString())));
                    return;
                }
            } else if (TextUtils.isEmpty(str) || !str.equals("103000")) {
                ((b) g6.this.f5992f).a(d6.a(new k6("-40101", "China Mobile return invalid data.", i6Var.toString())));
                return;
            }
            ((b) g6.this.f5992f).a(new d6(f6.SUCCESS, i6Var, (k6) null));
        }

        public void a(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                ((b) g6.this.f5992f).a(d6.a(new k6(str, "Operator return invalid data.", str2)));
            }
        }
    }
}
