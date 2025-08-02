package com.onesignal;

import com.onesignal.j3;
import com.onesignal.o3;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

class f1 {

    /* renamed from: c  reason: collision with root package name */
    private static Date f10628c = new Date();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f10629a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f10630b = new ArrayList();

    class a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10631a;

        a(String str) {
            this.f10631a = str;
        }

        public void run() {
            f1.this.f10630b.remove(this.f10631a);
            f1.this.f10629a.a();
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10633a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10634b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.onesignal.j3$b[] r0 = com.onesignal.j3.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10634b = r0
                r1 = 1
                com.onesignal.j3$b r2 = com.onesignal.j3.b.LESS_THAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f10634b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.j3$b r3 = com.onesignal.j3.b.LESS_THAN_OR_EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f10634b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.j3$b r3 = com.onesignal.j3.b.GREATER_THAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = f10634b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.onesignal.j3$b r3 = com.onesignal.j3.b.GREATER_THAN_OR_EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r2 = f10634b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.onesignal.j3$b r3 = com.onesignal.j3.b.EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r2 = f10634b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.onesignal.j3$b r3 = com.onesignal.j3.b.NOT_EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r4 = 6
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.onesignal.j3$a[] r2 = com.onesignal.j3.a.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f10633a = r2
                com.onesignal.j3$a r3 = com.onesignal.j3.a.SESSION_TIME     // Catch:{ NoSuchFieldError -> 0x005a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f10633a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.onesignal.j3$a r2 = com.onesignal.j3.a.TIME_SINCE_LAST_IN_APP     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.f1.b.<clinit>():void");
        }
    }

    interface c {
        void a();

        void b(String str);
    }

    f1(c cVar) {
        this.f10629a = cVar;
    }

    private static boolean d(double d10, double d11, j3.b bVar) {
        switch (b.f10634b[bVar.ordinal()]) {
            case 1:
                if (d11 < d10) {
                    return true;
                }
                return false;
            case 2:
                if (d11 <= d10 || f(d10, d11)) {
                    return true;
                }
                return false;
            case 3:
                if (d11 >= d10) {
                    return true;
                }
                return false;
            case 4:
                if (d11 >= d10 || f(d10, d11)) {
                    return true;
                }
                return false;
            case 5:
                return f(d10, d11);
            case 6:
                return !f(d10, d11);
            default:
                o3.v vVar = o3.v.ERROR;
                o3.d1(vVar, "Attempted to apply an invalid operator on a time-based in-app-message trigger: " + bVar.toString());
                return false;
        }
    }

    static void e() {
        f10628c = new Date();
    }

    private static boolean f(double d10, double d11) {
        if (Math.abs(d10 - d11) < 0.3d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007a A[Catch:{ all -> 0x0011 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081 A[Catch:{ all -> 0x0011 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(com.onesignal.j3 r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r15.f10712e
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.ArrayList r0 = r14.f10630b
            monitor-enter(r0)
            java.lang.Object r2 = r15.f10712e     // Catch:{ all -> 0x0011 }
            boolean r2 = r2 instanceof java.lang.Number     // Catch:{ all -> 0x0011 }
            if (r2 != 0) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r1
        L_0x0011:
            r15 = move-exception
            goto L_0x00a1
        L_0x0014:
            int[] r2 = com.onesignal.f1.b.f10633a     // Catch:{ all -> 0x0011 }
            com.onesignal.j3$a r3 = r15.f10709b     // Catch:{ all -> 0x0011 }
            int r3 = r3.ordinal()     // Catch:{ all -> 0x0011 }
            r2 = r2[r3]     // Catch:{ all -> 0x0011 }
            r3 = 1
            r4 = 0
            if (r2 == r3) goto L_0x004f
            r6 = 2
            if (r2 == r6) goto L_0x0028
            r6 = r4
            goto L_0x005f
        L_0x0028:
            com.onesignal.o1 r2 = com.onesignal.o3.c0()     // Catch:{ all -> 0x0011 }
            boolean r2 = r2.X()     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x0034
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r1
        L_0x0034:
            com.onesignal.o1 r2 = com.onesignal.o3.c0()     // Catch:{ all -> 0x0011 }
            java.util.Date r2 = r2.f10843t     // Catch:{ all -> 0x0011 }
            if (r2 != 0) goto L_0x0040
            r6 = 999999(0xf423f, double:4.94065E-318)
            goto L_0x005f
        L_0x0040:
            java.util.Date r6 = new java.util.Date     // Catch:{ all -> 0x0011 }
            r6.<init>()     // Catch:{ all -> 0x0011 }
            long r6 = r6.getTime()     // Catch:{ all -> 0x0011 }
            long r8 = r2.getTime()     // Catch:{ all -> 0x0011 }
        L_0x004d:
            long r6 = r6 - r8
            goto L_0x005f
        L_0x004f:
            java.util.Date r2 = new java.util.Date     // Catch:{ all -> 0x0011 }
            r2.<init>()     // Catch:{ all -> 0x0011 }
            long r6 = r2.getTime()     // Catch:{ all -> 0x0011 }
            java.util.Date r2 = f10628c     // Catch:{ all -> 0x0011 }
            long r8 = r2.getTime()     // Catch:{ all -> 0x0011 }
            goto L_0x004d
        L_0x005f:
            java.lang.String r2 = r15.f10708a     // Catch:{ all -> 0x0011 }
            java.lang.Object r8 = r15.f10712e     // Catch:{ all -> 0x0011 }
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ all -> 0x0011 }
            double r8 = r8.doubleValue()     // Catch:{ all -> 0x0011 }
            r10 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r8 = r8 * r10
            long r8 = (long) r8     // Catch:{ all -> 0x0011 }
            double r10 = (double) r8     // Catch:{ all -> 0x0011 }
            double r12 = (double) r6     // Catch:{ all -> 0x0011 }
            com.onesignal.j3$b r15 = r15.f10711d     // Catch:{ all -> 0x0011 }
            boolean r15 = d(r10, r12, r15)     // Catch:{ all -> 0x0011 }
            if (r15 == 0) goto L_0x0081
            com.onesignal.f1$c r15 = r14.f10629a     // Catch:{ all -> 0x0011 }
            r15.b(r2)     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r3
        L_0x0081:
            long r8 = r8 - r6
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 > 0) goto L_0x0088
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r1
        L_0x0088:
            java.util.ArrayList r15 = r14.f10630b     // Catch:{ all -> 0x0011 }
            boolean r15 = r15.contains(r2)     // Catch:{ all -> 0x0011 }
            if (r15 == 0) goto L_0x0092
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r1
        L_0x0092:
            com.onesignal.f1$a r15 = new com.onesignal.f1$a     // Catch:{ all -> 0x0011 }
            r15.<init>(r2)     // Catch:{ all -> 0x0011 }
            com.onesignal.g1.a(r15, r2, r8)     // Catch:{ all -> 0x0011 }
            java.util.ArrayList r15 = r14.f10630b     // Catch:{ all -> 0x0011 }
            r15.add(r2)     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return r1
        L_0x00a1:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.f1.c(com.onesignal.j3):boolean");
    }
}
