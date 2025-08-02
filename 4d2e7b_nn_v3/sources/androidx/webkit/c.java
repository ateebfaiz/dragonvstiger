package androidx.webkit;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final /* synthetic */ class c implements Executor {
    public final void execute(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
