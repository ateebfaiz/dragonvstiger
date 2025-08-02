package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.q;
import kotlin.jvm.internal.m;

public final class b extends q {

    /* renamed from: a  reason: collision with root package name */
    private final int f738a;

    /* renamed from: b  reason: collision with root package name */
    private final int f739b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f740c;

    /* renamed from: d  reason: collision with root package name */
    private int f741d;

    public b(char c10, char c11, int i10) {
        this.f738a = i10;
        this.f739b = c11;
        boolean z10 = false;
        if (i10 <= 0 ? m.g(c10, c11) >= 0 : m.g(c10, c11) <= 0) {
            z10 = true;
        }
        this.f740c = z10;
        this.f741d = !z10 ? c11 : c10;
    }

    public char a() {
        int i10 = this.f741d;
        if (i10 != this.f739b) {
            this.f741d = this.f738a + i10;
        } else if (this.f740c) {
            this.f740c = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i10;
    }

    public boolean hasNext() {
        return this.f740c;
    }
}
