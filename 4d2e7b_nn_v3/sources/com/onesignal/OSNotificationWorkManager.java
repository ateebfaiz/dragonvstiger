package com.onesignal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.onesignal.o3;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

abstract class OSNotificationWorkManager {

    /* renamed from: a  reason: collision with root package name */
    private static Set f10298a = OSUtils.K();

    public static class NotificationWorker extends Worker {
        public NotificationWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
            super(context, workerParameters);
        }

        private void a(Context context, int i10, JSONObject jSONObject, boolean z10, Long l10) {
            d2 d2Var = new d2((List) null, jSONObject, i10);
            n2 n2Var = new n2(new f2(context, d2Var, jSONObject, z10, true, l10), d2Var);
            String str = o3.I;
            o3.a(o3.v.WARN, "remoteNotificationReceivedHandler not setup, displaying normal OneSignal notification");
            n2Var.b(d2Var);
        }

        public ListenableWorker.Result doWork() {
            Data inputData = getInputData();
            try {
                o3.v vVar = o3.v.DEBUG;
                o3.d1(vVar, "NotificationWorker running doWork with data: " + inputData);
                int i10 = inputData.getInt("android_notif_id", 0);
                JSONObject jSONObject = new JSONObject(inputData.getString("json_payload"));
                long j10 = inputData.getLong("timestamp", System.currentTimeMillis() / 1000);
                boolean z10 = inputData.getBoolean("is_restoring", false);
                a(getApplicationContext(), i10, jSONObject, z10, Long.valueOf(j10));
                return ListenableWorker.Result.success();
            } catch (JSONException e10) {
                o3.v vVar2 = o3.v.ERROR;
                o3.d1(vVar2, "Error occurred doing work for job with id: " + getId().toString());
                e10.printStackTrace();
                return ListenableWorker.Result.failure();
            }
        }
    }

    static boolean a(String str) {
        if (!OSUtils.I(str)) {
            return true;
        }
        if (f10298a.contains(str)) {
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, "OSNotificationWorkManager notification with notificationId: " + str + " already queued");
            return false;
        }
        f10298a.add(str);
        return true;
    }

    static void b(Context context, String str, int i10, String str2, long j10, boolean z10, boolean z11) {
        Data build = new Data.Builder().putInt("android_notif_id", i10).putString("json_payload", str2).putLong("timestamp", j10).putBoolean("is_restoring", z10).build();
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "OSNotificationWorkManager enqueueing notification work with notificationId: " + str + " and jsonPayload: " + str2);
        n3.a(context).enqueueUniqueWork(str, ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(NotificationWorker.class).setInputData(build)).build());
    }

    static void c(String str) {
        if (OSUtils.I(str)) {
            f10298a.remove(str);
        }
    }
}
