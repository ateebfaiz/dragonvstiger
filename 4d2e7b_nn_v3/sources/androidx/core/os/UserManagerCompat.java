package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public class UserManagerCompat {

    static class a {
        @DoNotInline
        static boolean a(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(context);
        }
        return true;
    }
}
