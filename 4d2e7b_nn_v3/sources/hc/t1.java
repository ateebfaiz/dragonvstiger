package hc;

import java.io.InputStream;

abstract class t1 extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    protected final InputStream f426a;

    /* renamed from: b  reason: collision with root package name */
    private int f427b;

    t1(InputStream inputStream, int i10) {
        this.f426a = inputStream;
        this.f427b = i10;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f427b;
    }

    /* access modifiers changed from: protected */
    public void b(boolean z10) {
        InputStream inputStream = this.f426a;
        if (inputStream instanceof q1) {
            ((q1) inputStream).j(z10);
        }
    }
}
