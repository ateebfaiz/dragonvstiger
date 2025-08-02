package u;

import android.content.Context;
import android.hardware.SensorManager;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24172a = w.d.f("");

    /* renamed from: b  reason: collision with root package name */
    public static final List f24173b;

    public static class b implements p {
        public b(a aVar) {
        }

        public b a(Context context) {
            String b10 = c.h("gsm.version.baseband");
            int i10 = 2;
            if (b10 == null) {
                return new b(0, (String) null, 2);
            }
            if (b10.contains("1.0.0.0")) {
                i10 = 1;
            }
            return new b(i10, b10);
        }
    }

    /* renamed from: u.c$c  reason: collision with other inner class name */
    public static class C0340c implements p {
        public C0340c(a aVar) {
        }

        public b a(Context context) {
            int i10;
            String b10 = c.h("ro.product.board");
            if (b10 == null) {
                return new b(0, (String) null);
            }
            String lowerCase = b10.toLowerCase();
            if (!lowerCase.contains(com.alibaba.pdns.f.f17924q) && !lowerCase.contains("goldfish")) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            return new b(i10, b10);
        }
    }

    public static class d implements p {
        public d(a aVar) {
        }

        public b a(Context context) {
            String e10 = c.f("cat /proc/self/cgroup");
            if (e10 == null) {
                return new b(0, (String) null);
            }
            return new b(2, e10);
        }
    }

    public static class e implements p {
        public e(a aVar) {
        }

        public b a(Context context) {
            int i10;
            String b10 = c.h("ro.build.flavor");
            if (b10 == null) {
                return new b(0, (String) null);
            }
            String lowerCase = b10.toLowerCase();
            if (!lowerCase.contains("vbox") && !lowerCase.contains("sdk_gphone")) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            return new b(i10, b10);
        }
    }

    public static class f implements p {
        public f(a aVar) {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
            if (r3.equals("cancro") == false) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public u.b a(android.content.Context r7) {
            /*
                r6 = this;
                r7 = 2
                r0 = 1
                r1 = 0
                java.lang.String r2 = "ro.hardware"
                java.lang.String r2 = u.c.h(r2)
                if (r2 != 0) goto L_0x0012
                u.b r7 = new u.b
                r0 = 0
                r7.<init>(r1, r0)
                return r7
            L_0x0012:
                java.lang.String r3 = r2.toLowerCase()
                r3.getClass()
                r4 = -1
                int r5 = r3.hashCode()
                switch(r5) {
                    case -1367724016: goto L_0x0065;
                    case -822798509: goto L_0x005a;
                    case 109271: goto L_0x004f;
                    case 3570999: goto L_0x0044;
                    case 3613077: goto L_0x0039;
                    case 100361430: goto L_0x002e;
                    case 937844646: goto L_0x0023;
                    default: goto L_0x0021;
                }
            L_0x0021:
                r1 = r4
                goto L_0x006e
            L_0x0023:
                java.lang.String r1 = "android_x86"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x002c
                goto L_0x0021
            L_0x002c:
                r1 = 6
                goto L_0x006e
            L_0x002e:
                java.lang.String r1 = "intel"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x0037
                goto L_0x0021
            L_0x0037:
                r1 = 5
                goto L_0x006e
            L_0x0039:
                java.lang.String r1 = "vbox"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x0042
                goto L_0x0021
            L_0x0042:
                r1 = 4
                goto L_0x006e
            L_0x0044:
                java.lang.String r1 = "ttvm"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x004d
                goto L_0x0021
            L_0x004d:
                r1 = 3
                goto L_0x006e
            L_0x004f:
                java.lang.String r1 = "nox"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x0058
                goto L_0x0021
            L_0x0058:
                r1 = r7
                goto L_0x006e
            L_0x005a:
                java.lang.String r1 = "vbox86"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x0063
                goto L_0x0021
            L_0x0063:
                r1 = r0
                goto L_0x006e
            L_0x0065:
                java.lang.String r5 = "cancro"
                boolean r3 = r3.equals(r5)
                if (r3 != 0) goto L_0x006e
                goto L_0x0021
            L_0x006e:
                switch(r1) {
                    case 0: goto L_0x0072;
                    case 1: goto L_0x0072;
                    case 2: goto L_0x0072;
                    case 3: goto L_0x0072;
                    case 4: goto L_0x0072;
                    case 5: goto L_0x0072;
                    case 6: goto L_0x0072;
                    default: goto L_0x0071;
                }
            L_0x0071:
                goto L_0x0073
            L_0x0072:
                r7 = r0
            L_0x0073:
                u.b r0 = new u.b
                r0.<init>(r7, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: u.c.f.a(android.content.Context):u.b");
        }
    }

    public static class g implements p {
        public g(a aVar) {
        }

        public b a(Context context) {
            int i10;
            String b10 = c.h("ro.product.manufacturer");
            if (b10 == null) {
                return new b(0, (String) null);
            }
            String lowerCase = b10.toLowerCase();
            if (!lowerCase.contains("genymotion") && !lowerCase.contains("netease")) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            return new b(i10, b10);
        }
    }

    public static class h implements p {
        public h(a aVar) {
        }

        public b a(Context context) {
            int i10;
            String b10 = c.h("ro.product.model");
            if (b10 == null) {
                return new b(0, (String) null);
            }
            String lowerCase = b10.toLowerCase();
            if (!lowerCase.contains("google_sdk") && !lowerCase.contains("emulator") && !lowerCase.contains("android sdk built for x86")) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            return new b(i10, b10);
        }
    }

    public static class i implements p {
        public i(a aVar) {
        }

        public b a(Context context) {
            int i10;
            String b10 = c.h("ro.board.platform");
            if (b10 == null) {
                return new b(0, (String) null);
            }
            if (b10.toLowerCase().contains(com.alibaba.pdns.f.f17924q)) {
                i10 = 1;
            } else {
                i10 = 2;
            }
            return new b(i10, b10);
        }
    }

    public static class j implements p {
        public j(a aVar) {
        }

        public b a(Context context) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            int i10 = 0;
            if (sensorManager == null) {
                return new b(0, (String) null);
            }
            if (sensorManager.getDefaultSensor(5) != null) {
                i10 = 2;
            }
            return new b(i10, (String) null);
        }
    }

    public static class k implements p {
        public k(a aVar) {
        }

        public b a(Context context) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            int i10 = 0;
            if (sensorManager == null) {
                return new b(0, (String) null);
            }
            if (sensorManager.getSensorList(-1).size() > 7) {
                i10 = 2;
            }
            return new b(i10, (String) null);
        }
    }

    public static class l implements p {
        public l(a aVar) {
        }

        public b a(Context context) {
            int i10;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
                i10 = 0;
            } else {
                i10 = 2;
            }
            return new b(i10, (String) null);
        }
    }

    public static class m implements p {
        public m(a aVar) {
        }

        public b a(Context context) {
            int i10;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.camera")) {
                i10 = 0;
            } else {
                i10 = 2;
            }
            return new b(i10, (String) null);
        }
    }

    public static class n implements p {
        public n(a aVar) {
        }

        public b a(Context context) {
            int i10;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                i10 = 0;
            } else {
                i10 = 2;
            }
            return new b(i10, (String) null);
        }
    }

    public static class o implements p {
        public o(a aVar) {
        }

        public b a(Context context) {
            int i10;
            if (c.g(c.f("pm list package -3")) <= 5) {
                i10 = 0;
            } else {
                i10 = 2;
            }
            return new b(i10, (String) null);
        }
    }

    public interface p {
        b a(Context context);
    }

    static {
        ArrayList arrayList = new ArrayList();
        f24173b = arrayList;
        arrayList.add(new f((a) null));
        arrayList.add(new e((a) null));
        arrayList.add(new h((a) null));
        arrayList.add(new g((a) null));
        arrayList.add(new C0340c((a) null));
        arrayList.add(new i((a) null));
        arrayList.add(new b((a) null));
        arrayList.add(new k((a) null));
        arrayList.add(new o((a) null));
        arrayList.add(new n((a) null));
        arrayList.add(new m((a) null));
        arrayList.add(new l((a) null));
        arrayList.add(new j((a) null));
        arrayList.add(new d((a) null));
    }

    public static String a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder sb2 = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb2.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception unused) {
            }
        } while (read >= 512);
        return sb2.toString();
    }

    public static boolean c(Context context) {
        if (context != null) {
            return d(f24173b, context);
        }
        throw new IllegalArgumentException("context must not be null");
    }

    public static boolean d(List list, Context context) {
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            b a10 = ((p) it.next()).a(context);
            int i11 = a10.f24169a;
            if (i11 == 1) {
                return true;
            }
            if (i11 == 0) {
                i10 += a10.f24171c;
            }
        }
        if (i10 > 3) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0058, all -> 0x0049 }
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0049 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0059, all -> 0x0047 }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ Exception -> 0x0059, all -> 0x0047 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0059, all -> 0x0047 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.io.InputStream r4 = r1.getInputStream()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x005b, all -> 0x0040 }
            r2.write(r5)     // Catch:{ Exception -> 0x005b, all -> 0x0040 }
            r5 = 10
            r2.write(r5)     // Catch:{ Exception -> 0x005b, all -> 0x0040 }
            r2.flush()     // Catch:{ Exception -> 0x005b, all -> 0x0040 }
            r2.close()     // Catch:{ Exception -> 0x005b, all -> 0x0040 }
            r1.waitFor()     // Catch:{ Exception -> 0x005b, all -> 0x0040 }
            java.lang.String r5 = a(r3)     // Catch:{ Exception -> 0x005b, all -> 0x0040 }
            i.v.f(r2)
            i.v.f(r3)
            r1.destroy()
            return r5
        L_0x0040:
            r5 = move-exception
            r0 = r3
            goto L_0x004c
        L_0x0043:
            r5 = move-exception
            goto L_0x004c
        L_0x0045:
            r3 = r0
            goto L_0x005b
        L_0x0047:
            r5 = move-exception
            goto L_0x004b
        L_0x0049:
            r5 = move-exception
            r1 = r0
        L_0x004b:
            r2 = r0
        L_0x004c:
            i.v.f(r2)
            i.v.f(r0)
            if (r1 == 0) goto L_0x0057
            r1.destroy()
        L_0x0057:
            throw r5
        L_0x0058:
            r1 = r0
        L_0x0059:
            r2 = r0
            r3 = r2
        L_0x005b:
            i.v.f(r2)
            i.v.f(r3)
            if (r1 == 0) goto L_0x0066
            r1.destroy()
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u.c.f(java.lang.String):java.lang.String");
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return str.split("package:").length;
    }

    public static String h(String str) {
        String a10 = a.a(str);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        return a10;
    }
}
