package kotlinx.coroutines.channels;

import androidx.core.location.LocationRequestCompat;
import cc.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CancellableContinuation;
import zb.e;

public abstract class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final i f881a = new i(-1, (i) null, (BufferedChannel) null, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final int f882b = f0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int f883c = f0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f884d = new c0("BUFFERED");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f885e = new c0("SHOULD_BUFFER");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final c0 f886f = new c0("S_RESUMING_BY_RCV");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final c0 f887g = new c0("RESUMING_BY_EB");
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final c0 f888h = new c0("POISONED");
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final c0 f889i = new c0("DONE_RCV");
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final c0 f890j = new c0("INTERRUPTED_SEND");
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final c0 f891k = new c0("INTERRUPTED_RCV");

    /* renamed from: l  reason: collision with root package name */
    private static final c0 f892l = new c0("CHANNEL_CLOSED");
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final c0 f893m = new c0("SUSPEND");
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final c0 f894n = new c0("SUSPEND_NO_WAITER");
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final c0 f895o = new c0("FAILED");
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final c0 f896p = new c0("NO_RECEIVE_RESULT");
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final c0 f897q = new c0("CLOSE_HANDLER_CLOSED");
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final c0 f898r = new c0("CLOSE_HANDLER_INVOKED");
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final c0 f899s = new c0("NO_CLOSE_CAUSE");

    /* synthetic */ class a extends j implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f900a = new a();

        a() {
            super(2, d.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final i c(long j10, i iVar) {
            return d.x(j10, iVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c(((Number) obj).longValue(), (i) obj2);
        }
    }

    /* access modifiers changed from: private */
    public static final long A(int i10) {
        if (i10 != 0) {
            return i10 != Integer.MAX_VALUE ? (long) i10 : LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static final boolean B(CancellableContinuation cancellableContinuation, Object obj, Function1 function1) {
        Object l10 = cancellableContinuation.l(obj, (Object) null, function1);
        if (l10 == null) {
            return false;
        }
        cancellableContinuation.D(l10);
        return true;
    }

    static /* synthetic */ boolean C(CancellableContinuation cancellableContinuation, Object obj, Function1 function1, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        return B(cancellableContinuation, obj, function1);
    }

    /* access modifiers changed from: private */
    public static final long v(long j10, boolean z10) {
        return (z10 ? 4611686018427387904L : 0) + j10;
    }

    /* access modifiers changed from: private */
    public static final long w(long j10, int i10) {
        return (((long) i10) << 60) + j10;
    }

    /* access modifiers changed from: private */
    public static final i x(long j10, i iVar) {
        return new i(j10, iVar, iVar.u(), 0);
    }

    public static final e y() {
        return a.f900a;
    }

    public static final c0 z() {
        return f892l;
    }
}
