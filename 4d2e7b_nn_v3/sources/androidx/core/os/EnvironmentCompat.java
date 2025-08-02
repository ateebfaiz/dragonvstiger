package androidx.core.os;

import android.os.Environment;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.io.File;

public final class EnvironmentCompat {
    @Deprecated
    public static final String MEDIA_UNKNOWN = "unknown";

    static class a {
        @DoNotInline
        static String a(File file) {
            return Environment.getExternalStorageState(file);
        }
    }

    private EnvironmentCompat() {
    }

    @NonNull
    public static String getStorageState(@NonNull File file) {
        return a.a(file);
    }
}
