package kd;

import hc.e;
import hc.e1;
import hc.j;
import hc.l;
import hc.r;
import hc.v0;
import hc.z0;
import zd.a;

public class k extends l {

    /* renamed from: a  reason: collision with root package name */
    private final int f609a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f610b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f611c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f612d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f613e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f614f;

    public k(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f609a = i10;
        this.f610b = a.e(bArr);
        this.f611c = a.e(bArr2);
        this.f612d = a.e(bArr3);
        this.f613e = a.e(bArr4);
        this.f614f = a.e(bArr5);
    }

    public r c() {
        e eVar = new e();
        eVar.a(new j(0));
        e eVar2 = new e();
        eVar2.a(new j((long) this.f609a));
        eVar2.a(new v0(this.f610b));
        eVar2.a(new v0(this.f611c));
        eVar2.a(new v0(this.f612d));
        eVar2.a(new v0(this.f613e));
        eVar.a(new z0(eVar2));
        eVar.a(new e1(true, 0, new v0(this.f614f)));
        return new z0(eVar);
    }
}
