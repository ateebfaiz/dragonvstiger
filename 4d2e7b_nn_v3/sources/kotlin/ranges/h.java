package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.g0;

public final class h extends g0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f748a;

    /* renamed from: b  reason: collision with root package name */
    private final int f749b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f750c;

    /* renamed from: d  reason: collision with root package name */
    private int f751d;

    public h(int i10, int i11, int i12) {
        this.f748a = i12;
        this.f749b = i11;
        boolean z10 = false;
        if (i12 <= 0 ? i10 >= i11 : i10 <= i11) {
            z10 = true;
        }
        this.f750c = z10;
        this.f751d = !z10 ? i11 : i10;
    }

    public boolean hasNext() {
        return this.f750c;
    }

    public int nextInt() {
        int i10 = this.f751d;
        if (i10 != this.f749b) {
            this.f751d = this.f748a + i10;
        } else if (this.f750c) {
            this.f750c = false;
        } else {
            throw new NoSuchElementException();
        }
        return i10;
    }
}
