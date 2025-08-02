package kotlinx.coroutines.channels;

import cc.d0;

public interface e extends p, ReceiveChannel {

    /* renamed from: s  reason: collision with root package name */
    public static final a f901s = a.f902a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f902a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final int f903b = d0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private a() {
        }

        public final int a() {
            return f903b;
        }
    }
}
