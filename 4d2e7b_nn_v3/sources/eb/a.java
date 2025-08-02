package eb;

import android.content.Context;
import android.content.pm.PackageManager;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12066a = new a();

    private a() {
    }

    public final boolean a(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null || !packageManager.hasSystemFeature("android.software.leanback")) {
            return false;
        }
        return true;
    }
}
