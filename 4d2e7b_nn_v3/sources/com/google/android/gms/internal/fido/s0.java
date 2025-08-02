package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

final class s0 {

    /* renamed from: a  reason: collision with root package name */
    private final Deque f7096a = new ArrayDeque(16);

    private s0(boolean z10) {
    }

    public static s0 a() {
        return new s0(false);
    }

    private final long h() {
        if (this.f7096a.isEmpty()) {
            return 0;
        }
        return ((Long) this.f7096a.peek()).longValue();
    }

    private final void i(long j10) {
        this.f7096a.pop();
        this.f7096a.push(Long.valueOf(j10));
    }

    public final void b() {
        if (!this.f7096a.isEmpty()) {
            throw new IOException(String.format("data item not completed, stackSize: %s scope: %s", new Object[]{Integer.valueOf(this.f7096a.size()), Long.valueOf(h())}));
        }
    }

    public final void c() {
        long h10 = h();
        if (h10 >= 0) {
            throw new IOException(String.format("expected indefinite length scope but found %s", new Object[]{Long.valueOf(h10)}));
        } else if (h10 != -5) {
            this.f7096a.pop();
        } else {
            throw new IOException("expected a value for dangling key in indefinite-length map");
        }
    }

    public final void d() {
        long h10 = h();
        if (h10 != -1) {
            if (h10 == -2) {
                h10 = -2;
            } else {
                return;
            }
        }
        throw new IOException(String.format("expected non-string scope but found %s", new Object[]{Long.valueOf(h10)}));
    }

    public final void e(long j10) {
        long h10 = h();
        if (h10 != j10) {
            if (h10 != -1) {
                if (h10 == -2) {
                    h10 = -2;
                } else {
                    return;
                }
            }
            throw new IOException(String.format("expected non-string scope or scope %s but found %s", new Object[]{Long.valueOf(j10), Long.valueOf(h10)}));
        }
    }

    public final void f() {
        long h10 = h();
        int i10 = (h10 > 1 ? 1 : (h10 == 1 ? 0 : -1));
        if (i10 == 0) {
            this.f7096a.pop();
        } else if (i10 > 0) {
            i(h10 - 1);
        } else if (h10 == -4) {
            i(-5);
        } else if (h10 == -5) {
            i(-4);
        }
    }

    public final void g(long j10) {
        this.f7096a.push(Long.valueOf(j10));
    }
}
