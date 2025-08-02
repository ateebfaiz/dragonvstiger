package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.os.BuildCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import j0.h;
import j0.i;

class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f16993b = Logger.tagWithPrefix("SystemJobInfoConverter");

    /* renamed from: a  reason: collision with root package name */
    private final ComponentName f16994a;

    /* renamed from: androidx.work.impl.background.systemjob.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0219a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16995a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16995a = r0
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16995a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f16995a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f16995a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f16995a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.a.C0219a.<clinit>():void");
        }
    }

    a(Context context) {
        this.f16994a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri b(ContentUriTriggers.Trigger trigger) {
        boolean shouldTriggerForDescendants = trigger.shouldTriggerForDescendants();
        i.a();
        return h.a(trigger.getUri(), shouldTriggerForDescendants ? 1 : 0);
    }

    static int c(NetworkType networkType) {
        int i10 = C0219a.f16995a[networkType.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 != 4) {
            if (i10 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        Logger.get().debug(f16993b, String.format("API version too low. Cannot convert network type value %s", new Object[]{networkType}), new Throwable[0]);
        return 1;
    }

    static void d(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(networkType));
        } else {
            JobInfo.Builder unused = builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    /* access modifiers changed from: package-private */
    public JobInfo a(WorkSpec workSpec, int i10) {
        boolean z10;
        int i11;
        Constraints constraints = workSpec.constraints;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.f17025id);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.isPeriodic());
        JobInfo.Builder extras = new JobInfo.Builder(i10, this.f16994a).setRequiresCharging(constraints.requiresCharging()).setRequiresDeviceIdle(constraints.requiresDeviceIdle()).setExtras(persistableBundle);
        d(extras, constraints.getRequiredNetworkType());
        boolean z11 = false;
        if (!constraints.requiresDeviceIdle()) {
            if (workSpec.backoffPolicy == BackoffPolicy.LINEAR) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            extras.setBackoffCriteria(workSpec.backoffDelayDuration, i11);
        }
        long max = Math.max(workSpec.calculateNextRunTime() - System.currentTimeMillis(), 0);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!workSpec.expedited) {
            JobInfo.Builder unused = extras.setImportantWhileForeground(true);
        }
        if (i12 >= 24 && constraints.hasContentUriTriggers()) {
            for (ContentUriTriggers.Trigger b10 : constraints.getContentUriTriggers().getTriggers()) {
                JobInfo.Builder unused2 = extras.addTriggerContentUri(b(b10));
            }
            JobInfo.Builder unused3 = extras.setTriggerContentUpdateDelay(constraints.getTriggerContentUpdateDelay());
            JobInfo.Builder unused4 = extras.setTriggerContentMaxDelay(constraints.getTriggerMaxContentDelay());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            JobInfo.Builder unused5 = extras.setRequiresBatteryNotLow(constraints.requiresBatteryNotLow());
            JobInfo.Builder unused6 = extras.setRequiresStorageNotLow(constraints.requiresStorageNotLow());
        }
        if (workSpec.runAttemptCount > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (max > 0) {
            z11 = true;
        }
        if (BuildCompat.isAtLeastS() && workSpec.expedited && !z10 && !z11) {
            JobInfo.Builder unused7 = extras.setExpedited(true);
        }
        return extras.build();
    }
}
