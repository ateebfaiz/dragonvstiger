package k9;

import android.content.Context;
import h9.b;
import java.util.concurrent.Executors;

public abstract class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final b f12518a = new b("com.linecorp.linesdk.sharedpreference.encryptionsalt", 5000, true);

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f12519b = false;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Context f12520a;

        a(Context context) {
            this.f12520a = context;
        }

        public void run() {
            c.f12518a.f(this.f12520a);
        }
    }

    public static b b() {
        return f12518a;
    }

    public static void c(Context context) {
        if (!f12519b) {
            f12519b = true;
            Executors.newSingleThreadExecutor().execute(new a(context.getApplicationContext()));
        }
    }
}
