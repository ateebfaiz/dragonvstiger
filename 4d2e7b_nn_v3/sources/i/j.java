package i;

import android.content.Context;
import android.os.Process;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f22008a;

    public static int a(Context context, String str, int i10, int i11) {
        try {
            return context.checkPermission(str, i10, i11);
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    public static boolean b(Context context) {
        boolean z10;
        if (f22008a == null) {
            if (a(context, "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            f22008a = Boolean.valueOf(z10);
        }
        return f22008a.booleanValue();
    }
}
