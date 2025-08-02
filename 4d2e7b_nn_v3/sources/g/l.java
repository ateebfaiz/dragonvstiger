package g;

import android.os.Handler;
import android.os.HandlerThread;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f21565a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f21566b;

    public l(String str, Handler.Callback callback) {
        HandlerThread handlerThread = new HandlerThread("MAH_" + str);
        this.f21565a = handlerThread;
        handlerThread.start();
        this.f21566b = new Handler(handlerThread.getLooper(), callback);
    }
}
