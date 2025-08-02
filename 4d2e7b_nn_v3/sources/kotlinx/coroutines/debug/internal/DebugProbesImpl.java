package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;

public final class DebugProbesImpl {

    /* renamed from: a  reason: collision with root package name */
    public static final DebugProbesImpl f924a;

    /* renamed from: b  reason: collision with root package name */
    private static final StackTraceElement f925b = new y.a().b();

    /* renamed from: c  reason: collision with root package name */
    private static final SimpleDateFormat f926c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /* renamed from: d  reason: collision with root package name */
    private static final a f927d = new a(false, 1, (DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    private static boolean f928e = true;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f929f = true;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f930g = true;

    /* renamed from: h  reason: collision with root package name */
    private static final Function1 f931h;

    /* renamed from: i  reason: collision with root package name */
    private static final a f932i = new a(true);

    /* renamed from: j  reason: collision with root package name */
    private static final a f933j = new a((DefaultConstructorMarker) null);

    /* renamed from: k  reason: collision with root package name */
    private static final b f934k = new b((DefaultConstructorMarker) null);

    public static final class CoroutineOwner<T> implements d, kotlin.coroutines.jvm.internal.b {
        public final d delegate;
        public final c info;

        private final f b() {
            throw null;
        }

        public kotlin.coroutines.jvm.internal.b c() {
            b();
            return null;
        }

        public void d(Object obj) {
            DebugProbesImpl.f924a.c(this);
            this.delegate.d(obj);
        }

        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f935a = AtomicIntegerFieldUpdater.newUpdater(a.class, "installations");
        private volatile int installations;

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final AtomicLongFieldUpdater f936a = AtomicLongFieldUpdater.newUpdater(b.class, "sequenceNumber");
        private volatile long sequenceNumber;

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        f924a = debugProbesImpl;
        f931h = debugProbesImpl.b();
    }

    private DebugProbesImpl() {
    }

    private final Function1 b() {
        Object obj;
        Function1 function1 = null;
        try {
            o.a aVar = o.f12592b;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance((Object[]) null);
            m.d(newInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            obj = o.b((Function1) c0.e(newInstance, 1));
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (!o.f(obj)) {
            function1 = obj;
        }
        return function1;
    }

    /* access modifiers changed from: private */
    public final void c(CoroutineOwner coroutineOwner) {
        f927d.remove(coroutineOwner);
        coroutineOwner.getClass();
        throw null;
    }
}
