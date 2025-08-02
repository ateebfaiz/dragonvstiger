package com.google.android.gms.measurement.internal;

import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class e0 extends FutureTask implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    private final long f7467a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f7468b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7469c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzfo f7470d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e0(zzfo zzfo, Runnable runnable, boolean z10, String str) {
        super(runnable, (Object) null);
        this.f7470d = zzfo;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfo.zza.getAndIncrement();
        this.f7467a = andIncrement;
        this.f7469c = str;
        this.f7468b = z10;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            zzfo.zzt.zzay().zzd().zza("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        e0 e0Var = (e0) obj;
        boolean z10 = this.f7468b;
        if (z10 == e0Var.f7468b) {
            int i10 = (this.f7467a > e0Var.f7467a ? 1 : (this.f7467a == e0Var.f7467a ? 0 : -1));
            if (i10 < 0) {
                return -1;
            }
            if (i10 <= 0) {
                this.f7470d.zzt.zzay().zzh().zzb("Two tasks share the same index. index", Long.valueOf(this.f7467a));
                return 0;
            }
        } else if (z10) {
            return -1;
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.f7470d.zzt.zzay().zzd().zzb(this.f7469c, th);
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e0(zzfo zzfo, Callable callable, boolean z10, String str) {
        super(callable);
        this.f7470d = zzfo;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzfo.zza.getAndIncrement();
        this.f7467a = andIncrement;
        this.f7469c = "Task exception on worker thread";
        this.f7468b = z10;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            zzfo.zzt.zzay().zzd().zza("Tasks index overflow");
        }
    }
}
