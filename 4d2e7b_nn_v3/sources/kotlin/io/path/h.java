package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.collections.r0;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f698a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final LinkOption[] f699b = {LinkOption.NOFOLLOW_LINKS};

    /* renamed from: c  reason: collision with root package name */
    private static final LinkOption[] f700c = new LinkOption[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Set f701d = r0.d();

    /* renamed from: e  reason: collision with root package name */
    private static final Set f702e = r0.c(FileVisitOption.FOLLOW_LINKS);

    private h() {
    }

    public final Set a(boolean z10) {
        if (z10) {
            return f702e;
        }
        return f701d;
    }
}
