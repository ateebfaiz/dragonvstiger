package androidx.work.impl.model;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.room.TypeConverter;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;

public class WorkTypeConverters {

    public interface BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        public static final int LINEAR = 1;
    }

    public interface NetworkTypeIds {
        public static final int CONNECTED = 1;
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int TEMPORARILY_UNMETERED = 5;
        public static final int UNMETERED = 2;
    }

    public interface OutOfPolicyIds {
        public static final int DROP_WORK_REQUEST = 1;
        public static final int RUN_AS_NON_EXPEDITED_WORK_REQUEST = 0;
    }

    public interface StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17048a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f17049b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f17050c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f17051d;

        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|(2:19|20)|21|23|24|25|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|(2:19|20)|21|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|19|20|21|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0099 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ad */
        static {
            /*
                androidx.work.OutOfQuotaPolicy[] r0 = androidx.work.OutOfQuotaPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17051d = r0
                r1 = 1
                androidx.work.OutOfQuotaPolicy r2 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f17051d     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.work.OutOfQuotaPolicy r3 = androidx.work.OutOfQuotaPolicy.DROP_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                androidx.work.NetworkType[] r2 = androidx.work.NetworkType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f17050c = r2
                androidx.work.NetworkType r3 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f17050c     // Catch:{ NoSuchFieldError -> 0x0038 }
                androidx.work.NetworkType r3 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f17050c     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.work.NetworkType r4 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                r3 = 4
                int[] r4 = f17050c     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.work.NetworkType r5 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                r4 = 5
                int[] r5 = f17050c     // Catch:{ NoSuchFieldError -> 0x0059 }
                androidx.work.NetworkType r6 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                androidx.work.BackoffPolicy[] r5 = androidx.work.BackoffPolicy.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f17049b = r5
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.EXPONENTIAL     // Catch:{ NoSuchFieldError -> 0x006a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r5 = f17049b     // Catch:{ NoSuchFieldError -> 0x0074 }
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.LINEAR     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                androidx.work.WorkInfo$State[] r5 = androidx.work.WorkInfo.State.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f17048a = r5
                androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.ENQUEUED     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r1 = f17048a     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.RUNNING     // Catch:{ NoSuchFieldError -> 0x008f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f17048a     // Catch:{ NoSuchFieldError -> 0x0099 }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                int[] r0 = f17048a     // Catch:{ NoSuchFieldError -> 0x00a3 }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.FAILED     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r0 = f17048a     // Catch:{ NoSuchFieldError -> 0x00ad }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.BLOCKED     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f17048a     // Catch:{ NoSuchFieldError -> 0x00b8 }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.CANCELLED     // Catch:{ NoSuchFieldError -> 0x00b8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b8 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b8 }
            L_0x00b8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.a.<clinit>():void");
        }
    }

    private WorkTypeConverters() {
    }

    @TypeConverter
    public static int backoffPolicyToInt(BackoffPolicy backoffPolicy) {
        int i10 = a.f17049b[backoffPolicy.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + backoffPolicy + " to int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004d A[SYNTHETIC, Splitter:B:28:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005b A[SYNTHETIC, Splitter:B:36:0x005b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0055=Splitter:B:32:0x0055, B:17:0x0037=Splitter:B:17:0x0037} */
    @androidx.room.TypeConverter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.ContentUriTriggers byteArrayToContentUriTriggers(byte[] r6) {
        /*
            androidx.work.ContentUriTriggers r0 = new androidx.work.ContentUriTriggers
            r0.<init>()
            if (r6 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            int r6 = r2.readInt()     // Catch:{ IOException -> 0x002d }
        L_0x0017:
            if (r6 <= 0) goto L_0x002f
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException -> 0x002d }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ IOException -> 0x002d }
            boolean r4 = r2.readBoolean()     // Catch:{ IOException -> 0x002d }
            r0.add(r3, r4)     // Catch:{ IOException -> 0x002d }
            int r6 = r6 + -1
            goto L_0x0017
        L_0x002b:
            r6 = move-exception
            goto L_0x0059
        L_0x002d:
            r6 = move-exception
            goto L_0x0048
        L_0x002f:
            r2.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0037:
            r1.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x0058
        L_0x003b:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0058
        L_0x0040:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto L_0x0059
        L_0x0044:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0048:
            r6.printStackTrace()     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x0055
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0055:
            r1.close()     // Catch:{ IOException -> 0x003b }
        L_0x0058:
            return r0
        L_0x0059:
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0063:
            r1.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.byteArrayToContentUriTriggers(byte[]):androidx.work.ContentUriTriggers");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f A[SYNTHETIC, Splitter:B:28:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071 A[SYNTHETIC, Splitter:B:37:0x0071] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0067=Splitter:B:32:0x0067, B:19:0x004e=Splitter:B:19:0x004e} */
    @androidx.room.TypeConverter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] contentUriTriggersToByteArray(androidx.work.ContentUriTriggers r4) {
        /*
            int r0 = r4.size()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0059 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0059 }
            int r1 = r4.size()     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            java.util.Set r4 = r4.getTriggers()     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
        L_0x0021:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            if (r1 == 0) goto L_0x0046
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            androidx.work.ContentUriTriggers$Trigger r1 = (androidx.work.ContentUriTriggers.Trigger) r1     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            android.net.Uri r3 = r1.getUri()     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            boolean r1 = r1.shouldTriggerForDescendants()     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            r2.writeBoolean(r1)     // Catch:{ IOException -> 0x0043, all -> 0x0040 }
            goto L_0x0021
        L_0x0040:
            r4 = move-exception
            r1 = r2
            goto L_0x006f
        L_0x0043:
            r4 = move-exception
            r1 = r2
            goto L_0x005a
        L_0x0046:
            r2.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004e:
            r0.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x006a
        L_0x0052:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x006a
        L_0x0057:
            r4 = move-exception
            goto L_0x006f
        L_0x0059:
            r4 = move-exception
        L_0x005a:
            r4.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0067:
            r0.close()     // Catch:{ IOException -> 0x0052 }
        L_0x006a:
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x006f:
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0079:
            r0.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0081:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.contentUriTriggersToByteArray(androidx.work.ContentUriTriggers):byte[]");
    }

    @TypeConverter
    public static BackoffPolicy intToBackoffPolicy(int i10) {
        if (i10 == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i10 == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to BackoffPolicy");
    }

    @TypeConverter
    public static NetworkType intToNetworkType(int i10) {
        if (i10 == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i10 == 1) {
            return NetworkType.CONNECTED;
        }
        if (i10 == 2) {
            return NetworkType.UNMETERED;
        }
        if (i10 == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i10 == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i10 == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to NetworkType");
    }

    @TypeConverter
    @NonNull
    public static OutOfQuotaPolicy intToOutOfQuotaPolicy(int i10) {
        if (i10 == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i10 == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to OutOfQuotaPolicy");
    }

    @TypeConverter
    public static WorkInfo.State intToState(int i10) {
        if (i10 == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i10 == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i10 == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i10 == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i10 == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i10 == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to State");
    }

    @TypeConverter
    public static int networkTypeToInt(NetworkType networkType) {
        int i10 = a.f17050c[networkType.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 4;
        }
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    @TypeConverter
    public static int outOfQuotaPolicyToInt(@NonNull OutOfQuotaPolicy outOfQuotaPolicy) {
        int i10 = a.f17051d[outOfQuotaPolicy.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + outOfQuotaPolicy + " to int");
    }

    @TypeConverter
    public static int stateToInt(WorkInfo.State state) {
        switch (a.f17048a[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + state + " to int");
        }
    }
}
