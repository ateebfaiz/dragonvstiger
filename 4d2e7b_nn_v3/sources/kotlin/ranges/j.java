package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.h0;

public final class j extends h0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f756a;

    /* renamed from: b  reason: collision with root package name */
    private final long f757b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f758c;

    /* renamed from: d  reason: collision with root package name */
    private long f759d;

    public j(long j10, long j11, long j12) {
        this.f756a = j12;
        this.f757b = j11;
        boolean z10 = false;
        if (j12 <= 0 ? j10 >= j11 : j10 <= j11) {
            z10 = true;
        }
        this.f758c = z10;
        this.f759d = !z10 ? j11 : j10;
    }

    public boolean hasNext() {
        return this.f758c;
    }

    public long nextLong() {
        long j10 = this.f759d;
        if (j10 != this.f757b) {
            this.f759d = this.f756a + j10;
        } else if (this.f758c) {
            this.f758c = false;
        } else {
            throw new NoSuchElementException();
        }
        return j10;
    }
}
