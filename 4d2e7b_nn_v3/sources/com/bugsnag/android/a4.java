package com.bugsnag.android;

import com.bugsnag.android.k2;
import java.lang.Thread;
import java.util.List;

public class a4 implements k2.a {

    /* renamed from: a  reason: collision with root package name */
    private final c4 f18612a;

    /* renamed from: b  reason: collision with root package name */
    private final s2 f18613b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18614a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.lang.Thread$State[] r0 = java.lang.Thread.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18614a = r0
                java.lang.Thread$State r1 = java.lang.Thread.State.NEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18614a     // Catch:{ NoSuchFieldError -> 0x001d }
                java.lang.Thread$State r1 = java.lang.Thread.State.BLOCKED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18614a     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.lang.Thread$State r1 = java.lang.Thread.State.RUNNABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f18614a     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.lang.Thread$State r1 = java.lang.Thread.State.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f18614a     // Catch:{ NoSuchFieldError -> 0x003e }
                java.lang.Thread$State r1 = java.lang.Thread.State.TIMED_WAITING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f18614a     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.lang.Thread$State r1 = java.lang.Thread.State.WAITING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.a4.a.<clinit>():void");
        }
    }

    public enum b {
        NEW("NEW"),
        BLOCKED("BLOCKED"),
        RUNNABLE("RUNNABLE"),
        TERMINATED("TERMINATED"),
        TIMED_WAITING("TIMED_WAITING"),
        WAITING("WAITING"),
        UNKNOWN("UNKNOWN");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f18623a;

        private b(String str) {
            this.f18623a = str;
        }

        public static b a(String str) {
            if (str == null) {
                return UNKNOWN;
            }
            for (b bVar : values()) {
                if (bVar.c().equals(str)) {
                    return bVar;
                }
            }
            return UNKNOWN;
        }

        public static b b(Thread thread) {
            return d(thread.getState());
        }

        private static b d(Thread.State state) {
            switch (a.f18614a[state.ordinal()]) {
                case 1:
                    return NEW;
                case 2:
                    return BLOCKED;
                case 3:
                    return RUNNABLE;
                case 4:
                    return TERMINATED;
                case 5:
                    return TIMED_WAITING;
                case 6:
                    return WAITING;
                default:
                    return UNKNOWN;
            }
        }

        public String c() {
            return this.f18623a;
        }
    }

    a4(String str, String str2, ErrorType errorType, boolean z10, b bVar, u3 u3Var, s2 s2Var) {
        this.f18612a = new c4(str, str2, errorType, z10, bVar.c(), u3Var);
        this.f18613b = s2Var;
    }

    public boolean a() {
        return this.f18612a.f();
    }

    public String b() {
        return this.f18612a.a();
    }

    public String c() {
        return this.f18612a.b();
    }

    public List d() {
        return this.f18612a.c();
    }

    public b e() {
        return b.a(this.f18612a.d());
    }

    public ErrorType f() {
        return this.f18612a.e();
    }

    public void toStream(k2 k2Var) {
        this.f18612a.toStream(k2Var);
    }

    a4(c4 c4Var, s2 s2Var) {
        this.f18612a = c4Var;
        this.f18613b = s2Var;
    }
}
