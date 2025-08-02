package e7;

import com.facebook.react.bridge.UiThreadUtil;
import java.util.concurrent.Executor;

abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f11921a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f11922b = new a();

    private static class a implements Executor {
        private a() {
        }

        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private static class b implements Executor {
        private b() {
        }

        public void execute(Runnable runnable) {
            UiThreadUtil.runOnUiThread(runnable);
        }
    }
}
