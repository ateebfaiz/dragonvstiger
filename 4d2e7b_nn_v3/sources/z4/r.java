package z4;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.m;

public final class r implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final int f25176a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25177b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25178c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f25179d = new AtomicInteger(1);

    public r(int i10, String str, boolean z10) {
        m.f(str, "prefix");
        this.f25176a = i10;
        this.f25177b = str;
        this.f25178c = z10;
    }

    /* access modifiers changed from: private */
    public static final void b(r rVar, Runnable runnable) {
        m.f(rVar, "this$0");
        m.f(runnable, "$runnable");
        try {
            Process.setThreadPriority(rVar.f25176a);
        } catch (Throwable unused) {
        }
        runnable.run();
    }

    public Thread newThread(Runnable runnable) {
        String str;
        m.f(runnable, "runnable");
        q qVar = new q(this, runnable);
        if (this.f25178c) {
            str = this.f25177b + "-" + this.f25179d.getAndIncrement();
        } else {
            str = this.f25177b;
        }
        return new Thread(qVar, str);
    }
}
