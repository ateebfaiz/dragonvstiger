package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import java.util.List;

public abstract /* synthetic */ class o {
    public static void a(LocationListenerCompat locationListenerCompat, int i10) {
    }

    public static void b(LocationListenerCompat locationListenerCompat, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i10));
        }
    }

    public static void c(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void d(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void e(LocationListenerCompat locationListenerCompat, String str, int i10, Bundle bundle) {
    }
}
