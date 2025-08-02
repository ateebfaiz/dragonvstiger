package com.onesignal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.onesignal.b4;
import com.onesignal.o3;
import java.util.concurrent.TimeUnit;

class OSReceiveReceiptController {

    /* renamed from: d  reason: collision with root package name */
    private static OSReceiveReceiptController f10299d;

    /* renamed from: a  reason: collision with root package name */
    private int f10300a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f10301b = 25;

    /* renamed from: c  reason: collision with root package name */
    private final u2 f10302c = o3.k0();

    public static class ReceiveReceiptWorker extends Worker {

        class a extends b4.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f10303a;

            a(String str) {
                this.f10303a = str;
            }

            /* access modifiers changed from: package-private */
            public void a(int i10, String str, Throwable th) {
                o3.v vVar = o3.v.ERROR;
                o3.a(vVar, "Receive receipt failed with statusCode: " + i10 + " response: " + str);
            }

            /* access modifiers changed from: package-private */
            public void b(String str) {
                o3.v vVar = o3.v.DEBUG;
                o3.a(vVar, "Receive receipt sent for notificationID: " + this.f10303a);
            }
        }

        public ReceiveReceiptWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
            super(context, workerParameters);
        }

        /* access modifiers changed from: package-private */
        public void a(String str) {
            String o02;
            Integer num;
            String str2 = o3.f10886d;
            if (str2 == null || str2.isEmpty()) {
                o02 = o3.o0();
            } else {
                o02 = o3.f10886d;
            }
            String str3 = o02;
            String z02 = o3.z0();
            t2 t2Var = new t2();
            try {
                num = Integer.valueOf(new OSUtils().e());
            } catch (NullPointerException e10) {
                e10.printStackTrace();
                num = null;
            }
            Integer num2 = num;
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, "ReceiveReceiptWorker: Device Type is: " + num2);
            t2Var.a(str3, z02, num2, str, new a(str));
        }

        public ListenableWorker.Result doWork() {
            a(getInputData().getString("os_notification_id"));
            return ListenableWorker.Result.success();
        }
    }

    private OSReceiveReceiptController() {
    }

    public static synchronized OSReceiveReceiptController c() {
        OSReceiveReceiptController oSReceiveReceiptController;
        synchronized (OSReceiveReceiptController.class) {
            try {
                if (f10299d == null) {
                    f10299d = new OSReceiveReceiptController();
                }
                oSReceiveReceiptController = f10299d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oSReceiveReceiptController;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, String str) {
        if (!this.f10302c.j()) {
            o3.a(o3.v.DEBUG, "sendReceiveReceipt disabled");
            return;
        }
        int j10 = OSUtils.j(this.f10300a, this.f10301b);
        Data build = new Data.Builder().putString("os_notification_id", str).build();
        Constraints b10 = b();
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "OSReceiveReceiptController enqueueing send receive receipt work with notificationId: " + str + " and delay: " + j10 + " seconds");
        WorkManager a10 = n3.a(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("_receive_receipt");
        a10.enqueueUniqueWork(sb2.toString(), ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(ReceiveReceiptWorker.class).setConstraints(b10)).setInitialDelay((long) j10, TimeUnit.SECONDS)).setInputData(build)).build());
    }

    /* access modifiers changed from: package-private */
    public Constraints b() {
        return new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
    }
}
