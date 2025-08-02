package b1;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final int f17151a;

    /* renamed from: b  reason: collision with root package name */
    private final List f17152b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17153c;

    /* renamed from: d  reason: collision with root package name */
    private final InputStream f17154d;

    public f(int i10, List list) {
        this(i10, list, -1, (InputStream) null);
    }

    public final InputStream a() {
        return this.f17154d;
    }

    public final int b() {
        return this.f17153c;
    }

    public final List c() {
        return Collections.unmodifiableList(this.f17152b);
    }

    public final int d() {
        return this.f17151a;
    }

    public f(int i10, List list, int i11, InputStream inputStream) {
        this.f17151a = i10;
        this.f17152b = list;
        this.f17153c = i11;
        this.f17154d = inputStream;
    }
}
