package xd;

import java.security.spec.KeySpec;

public class b implements KeySpec {

    /* renamed from: a  reason: collision with root package name */
    private short[][] f2205a;

    /* renamed from: b  reason: collision with root package name */
    private short[][] f2206b;

    /* renamed from: c  reason: collision with root package name */
    private short[] f2207c;

    /* renamed from: d  reason: collision with root package name */
    private int f2208d;

    public b(int i10, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f2208d = i10;
        this.f2205a = sArr;
        this.f2206b = sArr2;
        this.f2207c = sArr3;
    }

    public short[][] a() {
        return this.f2205a;
    }

    public short[] b() {
        return this.f2207c;
    }

    public short[][] c() {
        return this.f2206b;
    }

    public int d() {
        return this.f2208d;
    }
}
