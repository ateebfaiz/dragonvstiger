package com.geetest.core;

public class r4 extends u4 {

    /* renamed from: e  reason: collision with root package name */
    public static final r4 f6160e = new r4(s4.FALSE);

    /* renamed from: f  reason: collision with root package name */
    public static final r4 f6161f = new r4(s4.TRUE);

    /* renamed from: g  reason: collision with root package name */
    public static final r4 f6162g = new r4(s4.NULL);

    /* renamed from: h  reason: collision with root package name */
    public static final r4 f6163h = new r4(s4.UNDEFINED);

    /* renamed from: i  reason: collision with root package name */
    public final s4 f6164i;

    /* renamed from: j  reason: collision with root package name */
    public final int f6165j;

    public r4(s4 s4Var) {
        super(v4.SIMPLE_VALUE);
        this.f6165j = s4Var.getValue();
        this.f6164i = s4Var;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r4)) {
            return false;
        }
        r4 r4Var = (r4) obj;
        if (!super.equals(obj) || this.f6165j != r4Var.f6165j) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ Integer.valueOf(this.f6165j).hashCode();
    }

    public String toString() {
        return this.f6164i.toString();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r4(int i10) {
        super(i10 <= 23 ? v4.SIMPLE_VALUE : v4.SIMPLE_VALUE_NEXT_BYTE);
        this.f6165j = i10;
        this.f6164i = s4.ofByte(i10);
    }
}
