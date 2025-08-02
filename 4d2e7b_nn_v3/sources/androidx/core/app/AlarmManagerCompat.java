package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public final class AlarmManagerCompat {

    static class a {
        @DoNotInline
        static AlarmManager.AlarmClockInfo a(long j10, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j10, pendingIntent);
        }

        @DoNotInline
        static void b(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    static class b {
        @DoNotInline
        static void a(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i10, j10, pendingIntent);
        }

        @DoNotInline
        static void b(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i10, j10, pendingIntent);
        }
    }

    static class c {
        @DoNotInline
        static boolean a(AlarmManager alarmManager) {
            return alarmManager.canScheduleExactAlarms();
        }
    }

    private AlarmManagerCompat() {
    }

    public static boolean canScheduleExactAlarms(@NonNull AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31) {
            return c.a(alarmManager);
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long j10, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        a.b(alarmManager, a.a(j10, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i10, long j10, @NonNull PendingIntent pendingIntent) {
        b.a(alarmManager, i10, j10, pendingIntent);
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int i10, long j10, @NonNull PendingIntent pendingIntent) {
        alarmManager.setExact(i10, j10, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i10, long j10, @NonNull PendingIntent pendingIntent) {
        b.b(alarmManager, i10, j10, pendingIntent);
    }
}
