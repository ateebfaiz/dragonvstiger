package i1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import t1.a;

public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22047a;

    public d(Context context, Looper looper) {
        super(looper);
        this.f22047a = context;
    }

    public void handleMessage(Message message) {
        try {
            a.b().d(message.replyTo);
            int i10 = message.what;
            Bundle data = message.getData();
            if (i10 == 101) {
                a.b().e(this.f22047a, data);
            } else {
                a.b().a(this.f22047a, i10, data);
            }
        } catch (Throwable th) {
            s1.a.h("RemoteMessengerHandler", "handleMessage failed " + th.getMessage());
        }
    }
}
