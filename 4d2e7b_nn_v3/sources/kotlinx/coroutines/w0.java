package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.n;

public abstract class w0 extends y implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1197a = new a((DefaultConstructorMarker) null);

    public static final class a extends b {

        /* renamed from: kotlinx.coroutines.w0$a$a  reason: collision with other inner class name */
        static final class C0018a extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final C0018a f1198a = new C0018a();

            C0018a() {
                super(1);
            }

            /* renamed from: a */
            public final w0 invoke(CoroutineContext.Element element) {
                if (element instanceof w0) {
                    return (w0) element;
                }
                return null;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
            super(y.Key, C0018a.f1198a);
        }
    }
}
