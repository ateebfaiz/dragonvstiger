package o5;

import android.graphics.ColorSpace;
import kotlin.Pair;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final ColorSpace f23019a;

    /* renamed from: b  reason: collision with root package name */
    private final Pair f23020b;

    public d(int i10, int i11, ColorSpace colorSpace) {
        Pair pair;
        this.f23019a = colorSpace;
        if (i10 == -1 || i11 == -1) {
            pair = null;
        } else {
            pair = new Pair(Integer.valueOf(i10), Integer.valueOf(i11));
        }
        this.f23020b = pair;
    }

    public final ColorSpace a() {
        return this.f23019a;
    }

    public final Pair b() {
        return this.f23020b;
    }
}
