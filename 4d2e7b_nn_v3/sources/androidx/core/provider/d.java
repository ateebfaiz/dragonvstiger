package androidx.core.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.provider.e;

public abstract /* synthetic */ class d {
    public static e.a a(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 24) {
            return new e.b(context, uri);
        }
        return new e.c(context, uri);
    }
}
