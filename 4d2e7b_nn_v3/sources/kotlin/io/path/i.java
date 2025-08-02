package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.m;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private final Path f703a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f704b;

    /* renamed from: c  reason: collision with root package name */
    private final i f705c;

    /* renamed from: d  reason: collision with root package name */
    private Iterator f706d;

    public i(Path path, Object obj, i iVar) {
        m.f(path, "path");
        this.f703a = path;
        this.f704b = obj;
        this.f705c = iVar;
    }

    public final Iterator a() {
        return this.f706d;
    }

    public final Object b() {
        return this.f704b;
    }

    public final i c() {
        return this.f705c;
    }

    public final Path d() {
        return this.f703a;
    }

    public final void e(Iterator it) {
        this.f706d = it;
    }
}
