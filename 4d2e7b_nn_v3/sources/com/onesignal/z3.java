package com.onesignal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.o3;
import java.util.HashMap;
import java.util.Set;

abstract class z3 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11153a = o3.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    static HashMap f11154b;

    /* renamed from: c  reason: collision with root package name */
    public static a f11155c;

    public static class a extends HandlerThread {

        /* renamed from: a  reason: collision with root package name */
        private Handler f11156a;

        /* renamed from: b  reason: collision with root package name */
        private long f11157b = 0;

        /* renamed from: c  reason: collision with root package name */
        private boolean f11158c;

        /* renamed from: com.onesignal.z3$a$a  reason: collision with other inner class name */
        class C0128a implements Runnable {
            C0128a() {
            }

            public void run() {
                a.this.c();
            }
        }

        a(String str) {
            super(str);
        }

        /* access modifiers changed from: private */
        public void c() {
            for (String str : z3.f11154b.keySet()) {
                SharedPreferences.Editor edit = z3.e(str).edit();
                HashMap hashMap = (HashMap) z3.f11154b.get(str);
                synchronized (hashMap) {
                    try {
                        for (String str2 : hashMap.keySet()) {
                            Object obj = hashMap.get(str2);
                            if (obj instanceof String) {
                                edit.putString(str2, (String) obj);
                            } else if (obj instanceof Boolean) {
                                edit.putBoolean(str2, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Integer) {
                                edit.putInt(str2, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                edit.putLong(str2, ((Long) obj).longValue());
                            } else if (obj instanceof Set) {
                                edit.putStringSet(str2, (Set) obj);
                            } else if (obj == null) {
                                edit.remove(str2);
                            }
                        }
                        hashMap.clear();
                    } finally {
                        while (true) {
                        }
                    }
                }
                edit.apply();
            }
            this.f11157b = o3.w0().b();
        }

        private synchronized void d() {
            try {
                Handler handler = this.f11156a;
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                    if (this.f11157b == 0) {
                        this.f11157b = o3.w0().b();
                    }
                    C0128a aVar = new C0128a();
                    this.f11156a.postDelayed(aVar, (this.f11157b - o3.w0().b()) + 200);
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        /* access modifiers changed from: private */
        public synchronized void e() {
            if (o3.f10882b != null) {
                f();
                d();
            }
        }

        private void f() {
            if (!this.f11158c) {
                start();
                this.f11158c = true;
            }
        }

        /* access modifiers changed from: protected */
        public void onLooperPrepared() {
            super.onLooperPrepared();
            this.f11156a = new Handler(getLooper());
            d();
        }
    }

    static {
        h();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        r3 = e(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        if (r3 == null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (r5.equals(java.lang.String.class) == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        return r3.getString(r4, (java.lang.String) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        if (r5.equals(java.lang.Boolean.class) == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        return java.lang.Boolean.valueOf(r3.getBoolean(r4, ((java.lang.Boolean) r6).booleanValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005f, code lost:
        if (r5.equals(java.lang.Integer.class) == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006f, code lost:
        return java.lang.Integer.valueOf(r3.getInt(r4, ((java.lang.Integer) r6).intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0076, code lost:
        if (r5.equals(java.lang.Long.class) == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0086, code lost:
        return java.lang.Long.valueOf(r3.getLong(r4, ((java.lang.Long) r6).longValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008d, code lost:
        if (r5.equals(java.util.Set.class) == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0095, code lost:
        return r3.getStringSet(r4, (java.util.Set) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009c, code lost:
        if (r5.equals(java.lang.Object.class) == false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a6, code lost:
        return java.lang.Boolean.valueOf(r3.contains(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a7, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object a(java.lang.String r3, java.lang.String r4, java.lang.Class r5, java.lang.Object r6) {
        /*
            java.util.HashMap r0 = f11154b
            java.lang.Object r0 = r0.get(r3)
            java.util.HashMap r0 = (java.util.HashMap) r0
            monitor-enter(r0)
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r1 = r5.equals(r1)     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x001e
            boolean r1 = r0.containsKey(r4)     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x001e
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return r3
        L_0x001b:
            r3 = move-exception
            goto L_0x00ac
        L_0x001e:
            java.lang.Object r1 = r0.get(r4)     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x00aa
            boolean r2 = r0.containsKey(r4)     // Catch:{ all -> 0x001b }
            if (r2 == 0) goto L_0x002c
            goto L_0x00aa
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            android.content.SharedPreferences r3 = e(r3)
            if (r3 == 0) goto L_0x00a9
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0042
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r3 = r3.getString(r4, r6)
            return r3
        L_0x0042:
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0059
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            boolean r3 = r3.getBoolean(r4, r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            return r3
        L_0x0059:
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0070
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r5 = r6.intValue()
            int r3 = r3.getInt(r4, r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            return r3
        L_0x0070:
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0087
            java.lang.Long r6 = (java.lang.Long) r6
            long r5 = r6.longValue()
            long r3 = r3.getLong(r4, r5)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            return r3
        L_0x0087:
            java.lang.Class<java.util.Set> r0 = java.util.Set.class
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0096
            java.util.Set r6 = (java.util.Set) r6
            java.util.Set r3 = r3.getStringSet(r4, r6)
            return r3
        L_0x0096:
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x00a7
            boolean r3 = r3.contains(r4)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            return r3
        L_0x00a7:
            r3 = 0
            return r3
        L_0x00a9:
            return r6
        L_0x00aa:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return r1
        L_0x00ac:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.z3.a(java.lang.String, java.lang.String, java.lang.Class, java.lang.Object):java.lang.Object");
    }

    static boolean b(String str, String str2, boolean z10) {
        return ((Boolean) a(str, str2, Boolean.class, Boolean.valueOf(z10))).booleanValue();
    }

    static int c(String str, String str2, int i10) {
        return ((Integer) a(str, str2, Integer.class, Integer.valueOf(i10))).intValue();
    }

    static long d(String str, String str2, long j10) {
        return ((Long) a(str, str2, Long.class, Long.valueOf(j10))).longValue();
    }

    static synchronized SharedPreferences e(String str) {
        synchronized (z3.class) {
            Context context = o3.f10882b;
            if (context == null) {
                o3.b(o3.v.WARN, "OneSignal.appContext null, could not read " + str + " from getSharedPreferences.", new Throwable());
                return null;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            return sharedPreferences;
        }
    }

    static String f(String str, String str2, String str3) {
        return (String) a(str, str2, String.class, str3);
    }

    public static Set g(String str, String str2, Set set) {
        return (Set) a(str, str2, Set.class, set);
    }

    public static void h() {
        HashMap hashMap = new HashMap();
        f11154b = hashMap;
        hashMap.put(f11153a, new HashMap());
        f11154b.put("GTPlayerPurchases", new HashMap());
        f11154b.put("OneSignalTriggers", new HashMap());
        f11155c = new a("OSH_WritePrefs");
    }

    private static void i(String str, String str2, Object obj) {
        HashMap hashMap = (HashMap) f11154b.get(str);
        synchronized (hashMap) {
            hashMap.put(str2, obj);
        }
        o();
    }

    public static void j(String str, String str2, boolean z10) {
        i(str, str2, Boolean.valueOf(z10));
    }

    public static void k(String str, String str2, int i10) {
        i(str, str2, Integer.valueOf(i10));
    }

    public static void l(String str, String str2, long j10) {
        i(str, str2, Long.valueOf(j10));
    }

    public static void m(String str, String str2, String str3) {
        i(str, str2, str3);
    }

    public static void n(String str, String str2, Set set) {
        i(str, str2, set);
    }

    public static void o() {
        f11155c.e();
    }
}
