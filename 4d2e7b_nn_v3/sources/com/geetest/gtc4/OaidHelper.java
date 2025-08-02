package com.geetest.gtc4;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;

public class OaidHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final e f6253a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f6254b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f6255c;

    /* renamed from: d  reason: collision with root package name */
    public static PackageManager f6256d;

    public static class a extends j {
        public a() {
            super("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService", "com.asus.msa.action.ACCESS_DID", "com.asus.msa.SupplementaryDID.IDidAidlInterface");
        }

        public final int a() {
            return 2;
        }
    }

    public static class b extends j {
        public b() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", (String) null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        public final int a() {
            return 2;
        }
    }

    public static class c extends j {
        public c() {
            super("com.huawei.hwid", (String) null, "com.uodis.opendevice.OPENIDS_SERVICE", "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }
    }

    public static class d implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public final IBinder f6257a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6258b;

        public d(IBinder iBinder, String str) {
            this.f6257a = iBinder;
            this.f6258b = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r0.recycle();
            r1.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
            return "";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0036 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a(java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7) {
            /*
                r3 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                java.lang.String r2 = r3.f6258b     // Catch:{ all -> 0x0036 }
                r0.writeInterfaceToken(r2)     // Catch:{ all -> 0x0036 }
                boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0036 }
                if (r2 != 0) goto L_0x0016
                r0.writeString(r4)     // Catch:{ all -> 0x0036 }
            L_0x0016:
                boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0036 }
                if (r4 != 0) goto L_0x001f
                r0.writeString(r5)     // Catch:{ all -> 0x0036 }
            L_0x001f:
                boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0036 }
                if (r4 != 0) goto L_0x0028
                r0.writeString(r6)     // Catch:{ all -> 0x0036 }
            L_0x0028:
                android.os.IBinder r4 = r3.f6257a     // Catch:{ all -> 0x0036 }
                r5 = 0
                r4.transact(r7, r0, r1, r5)     // Catch:{ all -> 0x0036 }
                r1.readException()     // Catch:{ all -> 0x0036 }
                java.lang.String r4 = r1.readString()     // Catch:{ all -> 0x0036 }
                goto L_0x003e
            L_0x0036:
                r0.recycle()     // Catch:{ Exception -> 0x003c }
                r1.recycle()     // Catch:{ Exception -> 0x003c }
            L_0x003c:
                java.lang.String r4 = ""
            L_0x003e:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.gtc4.OaidHelper.d.a(java.lang.String, java.lang.String, java.lang.String, int):java.lang.String");
        }

        public final IBinder asBinder() {
            return this.f6257a;
        }
    }

    public interface e {
        boolean a(Context context);

        String b(Context context);

        boolean c(Context context);
    }

    public static class f extends j {
        public f() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", (String) null, "com.zui.deviceidservice.IDeviceidInterface");
        }
    }

    public static class g extends h {
        public g() {
            super("com.meizu.flyme.openidsdk", "");
        }

        public final boolean a(Context context) {
            if (!super.a(context)) {
                try {
                    Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), (String[]) null, (String) null, new String[]{"support"}, (String) null);
                    if (query == null) {
                        return false;
                    }
                    query.moveToFirst();
                    int columnIndex = query.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        String string = query.getString(columnIndex);
                        if (TextUtils.isEmpty(string)) {
                            return false;
                        }
                        h.f6260f = "0".equals(string);
                    } else {
                        h.f6260f = false;
                    }
                } catch (Throwable unused) {
                    h.f6260f = false;
                    return false;
                }
            } else {
                h.f6260f = true;
            }
            this.f6264d = true;
            return h.f6260f;
        }

        public final String b(Context context) {
            this.f6263c = new String[]{"oaid"};
            return super.b(context);
        }
    }

    public static class h implements e {

        /* renamed from: e  reason: collision with root package name */
        public static String f6259e;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f6260f;

        /* renamed from: a  reason: collision with root package name */
        public final String f6261a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6262b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f6263c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6264d = false;

        public h(String str, String str2) {
            this.f6261a = str;
            this.f6262b = str2;
        }

        public boolean a(Context context) {
            boolean z10;
            if (this.f6264d) {
                return f6260f;
            }
            if (context == null) {
                return false;
            }
            try {
                PackageManager access$000 = OaidHelper.getPackageManager(context);
                if (access$000 == null || access$000.resolveContentProvider(this.f6261a, 0) == null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                f6260f = z10;
            } catch (Throwable unused) {
                f6260f = false;
            }
            this.f6264d = true;
            return f6260f;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            f6259e = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
            if (r8 != null) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
            r8.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0048, code lost:
            if (r8 != null) goto L_0x0050;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String b(android.content.Context r8) {
            /*
                r7 = this;
                java.lang.String r0 = f6259e
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x005b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "content://"
                r0.append(r1)
                java.lang.String r1 = r7.f6261a
                r0.append(r1)
                java.lang.String r1 = "/"
                r0.append(r1)
                java.lang.String r1 = r7.f6262b
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                android.net.Uri r2 = android.net.Uri.parse(r0)
                r0 = 0
                android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x004b }
                java.lang.String[] r5 = r7.f6263c     // Catch:{ all -> 0x004b }
                r6 = 0
                r3 = 0
                r4 = 0
                android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x004b }
                if (r8 == 0) goto L_0x0048
                r8.moveToFirst()     // Catch:{ all -> 0x004c }
                java.lang.String r1 = "value"
                int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x004c }
                java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x004c }
                f6259e = r1     // Catch:{ all -> 0x004c }
            L_0x0048:
                if (r8 == 0) goto L_0x005b
                goto L_0x0050
            L_0x004b:
                r8 = r0
            L_0x004c:
                f6259e = r0     // Catch:{ all -> 0x0054 }
                if (r8 == 0) goto L_0x005b
            L_0x0050:
                r8.close()
                goto L_0x005b
            L_0x0054:
                r0 = move-exception
                if (r8 == 0) goto L_0x005a
                r8.close()
            L_0x005a:
                throw r0
            L_0x005b:
                java.lang.String r8 = f6259e
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.gtc4.OaidHelper.h.b(android.content.Context):java.lang.String");
        }

        public final boolean c(Context context) {
            return true;
        }
    }

    public static class i implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public d f6265a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6266b;

        /* renamed from: c  reason: collision with root package name */
        public final CountDownLatch f6267c;

        /* renamed from: d  reason: collision with root package name */
        public IBinder f6268d;

        public i(String str, CountDownLatch countDownLatch) {
            this.f6266b = str;
            this.f6267c = countDownLatch;
        }

        /* JADX WARNING: type inference failed for: r1v2, types: [android.os.IInterface] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                com.geetest.gtc4.OaidHelper$d r0 = r3.f6265a
                r1 = 1
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                boolean r4 = r4.bindService(r5, r3, r1)     // Catch:{ all -> 0x0030 }
                java.util.concurrent.CountDownLatch r5 = r3.f6267c     // Catch:{ all -> 0x0030 }
                java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0030 }
                r1 = 1
                r5.await(r1, r0)     // Catch:{ all -> 0x0030 }
                android.os.IBinder r5 = r3.f6268d     // Catch:{ all -> 0x0030 }
                java.lang.String r0 = r3.f6266b     // Catch:{ all -> 0x0030 }
                if (r5 != 0) goto L_0x001b
                r5 = 0
                goto L_0x002d
            L_0x001b:
                android.os.IInterface r1 = r5.queryLocalInterface(r0)     // Catch:{ all -> 0x0030 }
                boolean r2 = r1 instanceof com.geetest.gtc4.OaidHelper.d     // Catch:{ all -> 0x0030 }
                if (r2 == 0) goto L_0x0027
                r5 = r1
                com.geetest.gtc4.OaidHelper$d r5 = (com.geetest.gtc4.OaidHelper.d) r5     // Catch:{ all -> 0x0030 }
                goto L_0x002d
            L_0x0027:
                com.geetest.gtc4.OaidHelper$d r1 = new com.geetest.gtc4.OaidHelper$d     // Catch:{ all -> 0x0030 }
                r1.<init>(r5, r0)     // Catch:{ all -> 0x0030 }
                r5 = r1
            L_0x002d:
                r3.f6265a = r5     // Catch:{ all -> 0x0030 }
                return r4
            L_0x0030:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.gtc4.OaidHelper.i.a(android.content.Context, android.content.Intent):boolean");
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f6268d = iBinder;
                this.f6267c.countDown();
            } catch (Throwable unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.f6265a = null;
            this.f6268d = null;
        }
    }

    public static class j implements e {

        /* renamed from: f  reason: collision with root package name */
        public static String f6269f;

        /* renamed from: g  reason: collision with root package name */
        public static boolean f6270g;

        /* renamed from: h  reason: collision with root package name */
        public static boolean f6271h;

        /* renamed from: i  reason: collision with root package name */
        public static final CountDownLatch f6272i = new CountDownLatch(1);

        /* renamed from: a  reason: collision with root package name */
        public final String f6273a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6274b;

        /* renamed from: c  reason: collision with root package name */
        public final String f6275c;

        /* renamed from: d  reason: collision with root package name */
        public final String f6276d;

        /* renamed from: e  reason: collision with root package name */
        public i f6277e;

        public j(String str, String str2, String str3, String str4) {
            this.f6273a = str;
            this.f6274b = str2;
            this.f6275c = str3;
            this.f6276d = str4;
        }

        public int a() {
            return 1;
        }

        public String b() {
            return null;
        }

        public boolean c(Context context) {
            if (context == null || TextUtils.isEmpty(this.f6273a)) {
                return false;
            }
            if (this.f6277e == null) {
                this.f6277e = new i(this.f6276d, f6272i);
            }
            Intent intent = new Intent();
            if (TextUtils.isEmpty(this.f6274b)) {
                intent.setPackage(this.f6273a);
            } else {
                intent.setComponent(new ComponentName(this.f6273a, this.f6274b));
            }
            if (!TextUtils.isEmpty(this.f6275c)) {
                intent.setAction(this.f6275c);
            }
            return this.f6277e.a(context, intent);
        }

        public String d(Context context) {
            return null;
        }

        public String e(Context context) {
            return null;
        }

        public boolean a(Context context) {
            if (f6271h) {
                return f6270g;
            }
            boolean z10 = false;
            if (context == null || TextUtils.isEmpty(this.f6273a)) {
                f6270g = false;
            } else {
                try {
                    PackageInfo packageInfo = OaidHelper.getPackageManager(context).getPackageInfo(this.f6273a, 0);
                    if (Build.VERSION.SDK_INT < 28) {
                        if (packageInfo != null && packageInfo.versionCode > 0) {
                            z10 = true;
                        }
                        f6270g = z10;
                    } else if (packageInfo == null || packageInfo.getLongVersionCode() < 1) {
                        return false;
                    } else {
                        return true;
                    }
                } catch (Throwable unused) {
                    return false;
                }
            }
            f6271h = true;
            return f6270g;
        }

        public String b(Context context) {
            i iVar;
            d dVar;
            i iVar2;
            if (!TextUtils.isEmpty(f6269f) || (iVar = this.f6277e) == null || (dVar = iVar.f6265a) == null) {
                return f6269f;
            }
            try {
                String a10 = dVar.a(d(context), e(context), b(), a());
                f6269f = a10;
                if (!TextUtils.isEmpty(a10) && (iVar2 = this.f6277e) != null) {
                    context.unbindService(iVar2);
                }
            } catch (Throwable unused) {
            }
            return f6269f;
        }
    }

    public static class k extends j {

        /* renamed from: j  reason: collision with root package name */
        public String f6278j;

        /* renamed from: k  reason: collision with root package name */
        public String f6279k;

        public k() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }

        public final String b() {
            return "OUID";
        }

        public final String d(Context context) {
            if (TextUtils.isEmpty(this.f6279k)) {
                this.f6279k = context.getPackageName();
            }
            return this.f6279k;
        }

        @SuppressLint({"PackageManagerGetSignatures"})
        public final String e(Context context) {
            if (TextUtils.isEmpty(this.f6278j)) {
                try {
                    if (TextUtils.isEmpty(this.f6279k)) {
                        this.f6279k = context.getPackageName();
                    }
                    this.f6279k = this.f6279k;
                    Signature[] signatureArr = OaidHelper.getPackageManager(context).getPackageInfo(this.f6279k, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b10 : digest) {
                            sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
                        }
                        this.f6278j = sb2.toString();
                    }
                } catch (Throwable unused) {
                }
            }
            return this.f6278j;
        }
    }

    public static class l extends j {
        public l() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", (String) null, "com.samsung.android.deviceidservice.IDeviceIdService");
        }
    }

    public static class m extends h {
        public m() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    public static class n implements e {

        /* renamed from: b  reason: collision with root package name */
        public static String f6280b;

        /* renamed from: a  reason: collision with root package name */
        public Class f6281a = null;

        @SuppressLint({"PrivateApi"})
        public final boolean a(Context context) {
            try {
                this.f6281a = Class.forName("com.android.id.impl.IdProviderImpl");
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        public final String b(Context context) {
            if (TextUtils.isEmpty(f6280b)) {
                try {
                    Object newInstance = this.f6281a.newInstance();
                    f6280b = String.valueOf(this.f6281a.getMethod("getOAID", new Class[]{Context.class}).invoke(newInstance, new Object[]{context}));
                } catch (Throwable unused) {
                    f6280b = null;
                }
            }
            return f6280b;
        }

        public final boolean c(Context context) {
            return true;
        }
    }

    static {
        e eVar;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        upperCase.hashCode();
        char c10 = 65535;
        switch (upperCase.hashCode()) {
            case -2053026509:
                if (upperCase.equals("LENOVO")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1712043046:
                if (upperCase.equals("SAMSUNG")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1706170181:
                if (upperCase.equals("XIAOMI")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1134767290:
                if (upperCase.equals("BLACKSHARK")) {
                    c10 = 3;
                    break;
                }
                break;
            case -602397472:
                if (upperCase.equals("ONEPLUS")) {
                    c10 = 4;
                    break;
                }
                break;
            case 89198:
                if (upperCase.equals("ZUI")) {
                    c10 = 5;
                    break;
                }
                break;
            case 2018896:
                if (upperCase.equals("ASUS")) {
                    c10 = 6;
                    break;
                }
                break;
            case 2255112:
                if (upperCase.equals("IQOO")) {
                    c10 = 7;
                    break;
                }
                break;
            case 2432928:
                if (upperCase.equals("OPPO")) {
                    c10 = 8;
                    break;
                }
                break;
            case 2634924:
                if (upperCase.equals("VIVO")) {
                    c10 = 9;
                    break;
                }
                break;
            case 68924490:
                if (upperCase.equals("HONOR")) {
                    c10 = 10;
                    break;
                }
                break;
            case 73239724:
                if (upperCase.equals("MEIZU")) {
                    c10 = 11;
                    break;
                }
                break;
            case 77852109:
                if (upperCase.equals("REDMI")) {
                    c10 = 12;
                    break;
                }
                break;
            case 1670208650:
                if (upperCase.equals("COOLPAD")) {
                    c10 = 13;
                    break;
                }
                break;
            case 1972178256:
                if (upperCase.equals("HUA_WEI")) {
                    c10 = 14;
                    break;
                }
                break;
            case 2141820391:
                if (upperCase.equals("HUAWEI")) {
                    c10 = 15;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 5:
                eVar = new f();
                break;
            case 1:
                eVar = new l();
                break;
            case 2:
            case 3:
            case 12:
                eVar = new n();
                break;
            case 4:
            case 8:
                eVar = new k();
                break;
            case 6:
                eVar = new a();
                break;
            case 7:
            case 9:
                eVar = new m();
                break;
            case 10:
            case 14:
            case 15:
                eVar = new c();
                break;
            case 11:
                eVar = new g();
                break;
            case 13:
                eVar = new b();
                break;
            default:
                eVar = null;
                break;
        }
        f6253a = eVar;
    }

    private OaidHelper() {
    }

    public static String getOaid(Context context) {
        isSupport(context);
        if (f6255c) {
            return getOaid();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static PackageManager getPackageManager(Context context) {
        if (f6256d == null) {
            f6256d = context.getPackageManager();
        }
        return f6256d;
    }

    private static void isSupport(Context context) {
        e eVar = f6253a;
        if (eVar != null && context != null) {
            f6254b = context.getApplicationContext();
            if (isSupportService()) {
                f6255c = eVar.c(f6254b);
            }
        }
    }

    private static boolean isSupportService() {
        e eVar;
        try {
            Context context = f6254b;
            if (context == null || (eVar = f6253a) == null || !eVar.a(context)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String getOaid() {
        e eVar;
        try {
            Context context = f6254b;
            if (context == null || (eVar = f6253a) == null || !f6255c) {
                return null;
            }
            return eVar.b(context);
        } catch (Throwable unused) {
            return null;
        }
    }
}
