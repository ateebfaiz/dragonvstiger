package z1;

import android.content.Context;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f24997a = "4.2.6";

    /* renamed from: z1.a$a  reason: collision with other inner class name */
    public static class C0362a {

        /* renamed from: a  reason: collision with root package name */
        public static int f24998a = 6002;

        /* renamed from: b  reason: collision with root package name */
        public static int f24999b = 6003;

        /* renamed from: c  reason: collision with root package name */
        public static int f25000c = 6004;

        /* renamed from: d  reason: collision with root package name */
        public static int f25001d = 6005;

        /* renamed from: e  reason: collision with root package name */
        public static int f25002e = 6006;

        /* renamed from: f  reason: collision with root package name */
        public static int f25003f = 6007;

        /* renamed from: g  reason: collision with root package name */
        public static int f25004g = 6008;

        /* renamed from: h  reason: collision with root package name */
        public static int f25005h = 6011;

        /* renamed from: i  reason: collision with root package name */
        public static int f25006i = 6023;
    }

    public static void a(Context context) {
        s1.a.a("MTPushPrivatesApi", "MTPushPrivatesApi.init 3.6.0");
        if (context == null) {
            s1.a.b("MTPushPrivatesApi", "init context can't be null, please check it");
            return;
        }
        s1.a.a("MTPushPrivatesApi", "init setAddress");
        if (p1.a.z(context.getApplicationContext()) || p1.a.A(context.getApplicationContext())) {
            h1.a.b(context.getApplicationContext(), true);
            if (p1.a.z(context.getApplicationContext())) {
                h1.a.c(context.getApplicationContext(), new v1.a());
                h1.a.c(context.getApplicationContext(), new y1.a());
                return;
            }
            return;
        }
        s1.a.b("MTPushPrivatesApi", "Please call the MTPushPrivatesApi.init function in the main process or the push process");
    }
}
