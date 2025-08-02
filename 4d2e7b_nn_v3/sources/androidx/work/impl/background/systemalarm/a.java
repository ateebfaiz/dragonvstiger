package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.utils.IdGenerator;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16987a = Logger.tagWithPrefix("Alarms");

    public static void a(Context context, WorkManagerImpl workManagerImpl, String str) {
        SystemIdInfoDao systemIdInfoDao = workManagerImpl.getWorkDatabase().systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(str);
        if (systemIdInfo != null) {
            b(context, str, systemIdInfo.systemId);
            Logger.get().debug(f16987a, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{str}), new Throwable[0]);
            systemIdInfoDao.removeSystemIdInfo(str);
        }
    }

    private static void b(Context context, String str, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i10, CommandHandler.createDelayMetIntent(context, str), 603979776);
        if (service != null && alarmManager != null) {
            Logger.get().debug(f16987a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i10)}), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void c(Context context, WorkManagerImpl workManagerImpl, String str, long j10) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(str);
        if (systemIdInfo != null) {
            b(context, str, systemIdInfo.systemId);
            d(context, str, systemIdInfo.systemId, j10);
            return;
        }
        int nextAlarmManagerId = new IdGenerator(workDatabase).nextAlarmManagerId();
        systemIdInfoDao.insertSystemIdInfo(new SystemIdInfo(str, nextAlarmManagerId));
        d(context, str, nextAlarmManagerId, j10);
    }

    private static void d(Context context, String str, int i10, long j10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(context, i10, CommandHandler.createDelayMetIntent(context, str), 201326592);
        if (alarmManager != null) {
            alarmManager.setExact(0, j10, service);
        }
    }
}
