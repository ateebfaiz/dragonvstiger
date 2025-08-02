package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences sharedPreferences, boolean z10, Function1<? super SharedPreferences.Editor, Unit> function1) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        function1.invoke(edit);
        if (z10) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        function1.invoke(edit);
        if (z10) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
