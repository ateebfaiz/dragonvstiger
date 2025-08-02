package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

public class TileServiceCompat {
    private static c sTileServiceWrapper;

    private static class a {
        @DoNotInline
        static void a(TileService tileService, Intent intent) {
            tileService.startActivityAndCollapse(intent);
        }
    }

    private static class b {
        @DoNotInline
        static void a(TileService tileService, PendingIntent pendingIntent) {
            tileService.startActivityAndCollapse(pendingIntent);
        }
    }

    interface c {
    }

    private TileServiceCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void clearTileServiceWrapper() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setTileServiceWrapper(@NonNull c cVar) {
    }

    public static void startActivityAndCollapse(@NonNull TileService tileService, @NonNull PendingIntentActivityWrapper pendingIntentActivityWrapper) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            b.a(tileService, pendingIntentActivityWrapper.getPendingIntent());
        } else if (i10 >= 24) {
            a.a(tileService, pendingIntentActivityWrapper.getIntent());
        }
    }
}
