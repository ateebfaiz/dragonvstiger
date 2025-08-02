package i1;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import t1.a;

public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22046a;

    public c(Context context, Looper looper) {
        super(looper);
        this.f22046a = context;
    }

    public void handleMessage(Message message) {
        try {
            a.b().a(this.f22046a, message.what, message.getData());
        } catch (Throwable th) {
            s1.a.h("MainMessengerHandler", "handleMessage failed " + th.getMessage());
        }
    }
}
