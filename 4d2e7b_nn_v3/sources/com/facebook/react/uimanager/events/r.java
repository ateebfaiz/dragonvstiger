package com.facebook.react.uimanager.events;

import android.util.SparseIntArray;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f3658a = new SparseIntArray();

    public void a(long j10) {
        this.f3658a.put((int) j10, 0);
    }

    public short b(long j10) {
        int i10 = this.f3658a.get((int) j10, -1);
        if (i10 != -1) {
            return (short) (i10 & 65535);
        }
        throw new RuntimeException("Tried to get non-existent cookie");
    }

    public boolean c(long j10) {
        if (this.f3658a.get((int) j10, -1) == -1) {
            return false;
        }
        return true;
    }

    public void d(long j10) {
        int i10 = (int) j10;
        int i11 = this.f3658a.get(i10, -1);
        if (i11 != -1) {
            this.f3658a.put(i10, i11 + 1);
            return;
        }
        throw new RuntimeException("Tried to increment non-existent cookie");
    }

    public void e(long j10) {
        this.f3658a.delete((int) j10);
    }
}
