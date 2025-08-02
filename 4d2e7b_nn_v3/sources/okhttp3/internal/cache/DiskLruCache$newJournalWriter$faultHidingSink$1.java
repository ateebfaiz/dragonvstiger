package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import okhttp3.internal.Util;

final class DiskLruCache$newJournalWriter$faultHidingSink$1 extends n implements Function1<IOException, Unit> {
    final /* synthetic */ DiskLruCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiskLruCache$newJournalWriter$faultHidingSink$1(DiskLruCache diskLruCache) {
        super(1);
        this.this$0 = diskLruCache;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return Unit.f12577a;
    }

    public final void invoke(IOException iOException) {
        m.f(iOException, "it");
        DiskLruCache diskLruCache = this.this$0;
        if (!Util.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
            this.this$0.hasJournalErrors = true;
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(diskLruCache);
        throw new AssertionError(sb2.toString());
    }
}
