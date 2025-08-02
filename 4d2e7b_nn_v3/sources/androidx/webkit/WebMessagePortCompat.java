package androidx.webkit;

import android.os.Handler;
import android.webkit.WebMessagePort;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationHandler;

@AnyThread
public abstract class WebMessagePortCompat {

    public static abstract class WebMessageCallbackCompat {
        public void onMessage(WebMessagePortCompat webMessagePortCompat, WebMessageCompat webMessageCompat) {
        }
    }

    public abstract void close();

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract WebMessagePort getFrameworkPort();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract InvocationHandler getInvocationHandler();

    public abstract void postMessage(WebMessageCompat webMessageCompat);

    public abstract void setWebMessageCallback(Handler handler, WebMessageCallbackCompat webMessageCallbackCompat);

    public abstract void setWebMessageCallback(WebMessageCallbackCompat webMessageCallbackCompat);
}
