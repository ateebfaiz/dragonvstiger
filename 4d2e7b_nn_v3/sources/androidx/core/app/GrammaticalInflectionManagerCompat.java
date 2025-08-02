package androidx.core.app;

import android.app.GrammaticalInflectionManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class GrammaticalInflectionManagerCompat {
    public static final int GRAMMATICAL_GENDER_FEMININE = 2;
    public static final int GRAMMATICAL_GENDER_MASCULINE = 3;
    public static final int GRAMMATICAL_GENDER_NEUTRAL = 1;
    public static final int GRAMMATICAL_GENDER_NOT_SPECIFIED = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GrammaticalGender {
    }

    static class a {
        @DoNotInline
        static int a(Context context) {
            return b(context).getApplicationGrammaticalGender();
        }

        private static GrammaticalInflectionManager b(Context context) {
            return (GrammaticalInflectionManager) context.getSystemService(GrammaticalInflectionManager.class);
        }

        @DoNotInline
        static void c(Context context, int i10) {
            b(context).setRequestedApplicationGrammaticalGender(i10);
        }
    }

    private GrammaticalInflectionManagerCompat() {
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @AnyThread
    public static int getApplicationGrammaticalGender(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(context);
        }
        return 0;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @AnyThread
    public static void setRequestedApplicationGrammaticalGender(@NonNull Context context, int i10) {
        if (Build.VERSION.SDK_INT >= 34) {
            a.c(context, i10);
        }
    }
}
