package z4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b implements g {

    /* renamed from: f  reason: collision with root package name */
    public static final a f25014f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Executor f25015a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f25016b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f25017c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f25018d;

    /* renamed from: e  reason: collision with root package name */
    private final ScheduledExecutorService f25019e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(int i10) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2, new r(10, "FrescoIoBoundExecutor", true));
        m.e(newFixedThreadPool, "newFixedThreadPool(\n    …oIoBoundExecutor\", true))");
        this.f25015a = newFixedThreadPool;
        ExecutorService newFixedThreadPool2 = Executors.newFixedThreadPool(i10, new r(10, "FrescoDecodeExecutor", true));
        m.e(newFixedThreadPool2, "newFixedThreadPool(\n    …coDecodeExecutor\", true))");
        this.f25016b = newFixedThreadPool2;
        ExecutorService newFixedThreadPool3 = Executors.newFixedThreadPool(i10, new r(10, "FrescoBackgroundExecutor", true));
        m.e(newFixedThreadPool3, "newFixedThreadPool(\n    …ckgroundExecutor\", true))");
        this.f25017c = newFixedThreadPool3;
        ExecutorService newFixedThreadPool4 = Executors.newFixedThreadPool(1, new r(10, "FrescoLightWeightBackgroundExecutor", true));
        m.e(newFixedThreadPool4, "newFixedThreadPool(\n    …ckgroundExecutor\", true))");
        this.f25018d = newFixedThreadPool4;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(i10, new r(10, "FrescoBackgroundExecutor", true));
        m.e(newScheduledThreadPool, "newScheduledThreadPool(\n…ckgroundExecutor\", true))");
        this.f25019e = newScheduledThreadPool;
    }

    public Executor a() {
        return this.f25016b;
    }

    public Executor b() {
        return this.f25018d;
    }

    public Executor c() {
        return this.f25017c;
    }

    public Executor d() {
        return this.f25015a;
    }

    public Executor e() {
        return this.f25015a;
    }

    public Executor f() {
        return this.f25015a;
    }

    public ScheduledExecutorService g() {
        return this.f25019e;
    }
}
