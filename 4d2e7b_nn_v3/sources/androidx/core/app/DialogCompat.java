package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public class DialogCompat {

    static class a {
        @DoNotInline
        static <T> T a(Dialog dialog, int i10) {
            return dialog.requireViewById(i10);
        }
    }

    private DialogCompat() {
    }

    @NonNull
    public static View requireViewById(@NonNull Dialog dialog, int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) a.a(dialog, i10);
        }
        View findViewById = dialog.findViewById(i10);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    }
}
