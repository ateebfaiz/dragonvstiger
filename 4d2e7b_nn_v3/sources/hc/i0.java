package hc;

import java.io.IOException;

public class i0 implements d, p1 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f380a;

    /* renamed from: b  reason: collision with root package name */
    private int f381b;

    /* renamed from: c  reason: collision with root package name */
    private v f382c;

    i0(boolean z10, int i10, v vVar) {
        this.f380a = z10;
        this.f381b = i10;
        this.f382c = vVar;
    }

    public r c() {
        try {
            return d();
        } catch (IOException e10) {
            throw new q(e10.getMessage());
        }
    }

    public r d() {
        return this.f382c.c(this.f380a, this.f381b);
    }
}
