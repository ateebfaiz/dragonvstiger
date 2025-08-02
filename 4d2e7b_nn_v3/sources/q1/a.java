package q1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationManagerCompat;

public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23182a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23183b;

    public a(Looper looper, Context context, int i10) {
        super(looper);
        this.f23182a = context;
        this.f23183b = i10;
    }

    public void handleMessage(Message message) {
        try {
            int i10 = message.arg1;
            String valueOf = String.valueOf(message.obj);
            int i11 = message.what;
            Bundle data = message.getData();
            if (i11 == -1000) {
                c.c().e(this.f23182a, getLooper().getThread().getName());
                return;
            }
            removeMessages(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
            sendEmptyMessageDelayed(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, (long) this.f23183b);
            t1.a.b().c(this.f23182a, i10, valueOf, i11, data);
        } catch (Throwable th) {
            s1.a.h("CommonHandler", "handleMessage failed " + th.getMessage());
        }
    }
}
