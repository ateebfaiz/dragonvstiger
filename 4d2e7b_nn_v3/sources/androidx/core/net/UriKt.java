package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.m;

public final class UriKt {
    public static final File toFile(Uri uri) {
        if (m.b(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }

    public static final Uri toUri(String str) {
        return Uri.parse(str);
    }

    public static final Uri toUri(File file) {
        return Uri.fromFile(file);
    }
}
