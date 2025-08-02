package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.p;

public abstract class i {

    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18397b = new a(p.a().getPackageName(), p.a().getPackageName(), 3);
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public NotificationChannel f18398a;

        public a(String str, CharSequence charSequence, int i10) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f18398a = h.a(str, charSequence, i10);
            }
        }

        public NotificationChannel b() {
            return this.f18398a;
        }
    }

    public static Notification a(a aVar, p.a aVar2) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            ((NotificationManager) p.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(p.a());
        if (i10 >= 26) {
            builder.setChannelId(aVar.f18398a.getId());
        }
        if (aVar2 != null) {
            aVar2.accept(builder);
        }
        return builder.build();
    }
}
