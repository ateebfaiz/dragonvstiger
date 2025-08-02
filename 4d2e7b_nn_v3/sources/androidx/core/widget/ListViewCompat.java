package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

@Deprecated
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @Deprecated
    public static boolean canScrollList(@NonNull ListView listView, int i10) {
        return listView.canScrollList(i10);
    }

    @Deprecated
    public static void scrollListBy(@NonNull ListView listView, int i10) {
        listView.scrollListBy(i10);
    }
}
