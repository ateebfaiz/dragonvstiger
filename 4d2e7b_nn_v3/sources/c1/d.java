package c1;

import java.io.File;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.r;
import kotlin.t;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f17215a = new d();

    private d() {
    }

    public static final File a(Lazy lazy) {
        File file = (File) lazy.getValue();
        File file2 = new File(file, "bugsnag");
        if (!file2.isDirectory()) {
            file2.mkdirs();
        }
        for (Pair pair : r.o(t.a("last-run-info", "last-run-info"), t.a("bugsnag-sessions", "sessions"), t.a("user-info", "user-info"), t.a("bugsnag-native", "native"), t.a("bugsnag-errors", "errors"))) {
            String str = (String) pair.b();
            File file3 = new File(file, (String) pair.a());
            if (file3.exists()) {
                file3.renameTo(new File(file2, str));
            }
        }
        return file2;
    }
}
