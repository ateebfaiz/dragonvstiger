package m4;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum e {
    UNKNOWN(-1),
    REQUESTED(0),
    INTERMEDIATE_AVAILABLE(2),
    SUCCESS(3),
    CANCELED(4),
    ERROR(5),
    DRAW(6),
    EMPTY_EVENT(7),
    RELEASED(8);
    

    /* renamed from: b  reason: collision with root package name */
    public static final a f22550b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final e[] f22551c = null;

    /* renamed from: a  reason: collision with root package name */
    private final int f22560a;

    public static final class a {
        private a() {
        }

        public final e a(int i10) {
            for (e eVar : e.f22551c) {
                if (eVar.c() == i10) {
                    return eVar;
                }
            }
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22561a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                m4.e[] r0 = m4.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                m4.e r1 = m4.e.REQUESTED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                m4.e r1 = m4.e.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                m4.e r1 = m4.e.CANCELED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                m4.e r1 = m4.e.INTERMEDIATE_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                m4.e r1 = m4.e.ERROR     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                m4.e r1 = m4.e.RELEASED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                f22561a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m4.e.b.<clinit>():void");
        }
    }

    static {
        f22550b = new a((DefaultConstructorMarker) null);
        f22551c = values();
    }

    private e(int i10) {
        this.f22560a = i10;
    }

    public final int c() {
        return this.f22560a;
    }

    public String toString() {
        switch (b.f22561a[ordinal()]) {
            case 1:
                return "requested";
            case 2:
                return FirebaseAnalytics.Param.SUCCESS;
            case 3:
                return "canceled";
            case 4:
                return "intermediate_available";
            case 5:
                return Constants.IPC_BUNDLE_KEY_SEND_ERROR;
            case 6:
                return "released";
            default:
                return "unknown";
        }
    }
}
