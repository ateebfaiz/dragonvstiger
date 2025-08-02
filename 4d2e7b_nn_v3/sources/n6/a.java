package n6;

import android.view.Choreographer;
import com.facebook.react.bridge.UiThreadUtil;
import kotlin.jvm.internal.m;
import n6.b;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12824a = new a();

    /* renamed from: n6.a$a  reason: collision with other inner class name */
    private static final class C0152a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final Choreographer f12825a;

        public C0152a() {
            Choreographer instance = Choreographer.getInstance();
            m.e(instance, "getInstance(...)");
            this.f12825a = instance;
        }

        public void a(Choreographer.FrameCallback frameCallback) {
            m.f(frameCallback, "callback");
            this.f12825a.postFrameCallback(frameCallback);
        }

        public void b(Choreographer.FrameCallback frameCallback) {
            m.f(frameCallback, "callback");
            this.f12825a.removeFrameCallback(frameCallback);
        }
    }

    private a() {
    }

    public static final a b() {
        return f12824a;
    }

    public b.a a() {
        UiThreadUtil.assertOnUiThread();
        return new C0152a();
    }
}
