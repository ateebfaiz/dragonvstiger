package id;

import zd.a;

class c implements e {

    /* renamed from: a  reason: collision with root package name */
    protected final int[] f466a;

    c(int[] iArr) {
        this.f466a = a.f(iArr);
    }

    public int[] a() {
        return a.f(this.f466a);
    }

    public int b() {
        int[] iArr = this.f466a;
        return iArr[iArr.length - 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return a.c(this.f466a, ((c) obj).f466a);
    }

    public int hashCode() {
        return a.o(this.f466a);
    }
}
