package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TooltipCompat {

    static class a {
        @DoNotInline
        static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private TooltipCompat() {
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.a(view, charSequence);
        } else {
            y.h(view, charSequence);
        }
    }
}
