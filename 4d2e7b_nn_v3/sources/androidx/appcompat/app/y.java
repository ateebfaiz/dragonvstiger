package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Calendar;

class y {

    /* renamed from: d  reason: collision with root package name */
    private static y f13994d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f13995a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f13996b;

    /* renamed from: c  reason: collision with root package name */
    private final a f13997c = new a();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f13998a;

        /* renamed from: b  reason: collision with root package name */
        long f13999b;

        a() {
        }
    }

    y(Context context, LocationManager locationManager) {
        this.f13995a = context;
        this.f13996b = locationManager;
    }

    static y a(Context context) {
        if (f13994d == null) {
            Context applicationContext = context.getApplicationContext();
            f13994d = new y(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION));
        }
        return f13994d;
    }

    private Location b() {
        Location location;
        Location location2 = null;
        if (PermissionChecker.checkSelfPermission(this.f13995a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = c("network");
        } else {
            location = null;
        }
        if (PermissionChecker.checkSelfPermission(this.f13995a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = c("gps");
        }
        if (location2 == null || location == null) {
            if (location2 != null) {
                return location2;
            }
            return location;
        } else if (location2.getTime() > location.getTime()) {
            return location2;
        } else {
            return location;
        }
    }

    private Location c(String str) {
        try {
            if (this.f13996b.isProviderEnabled(str)) {
                return this.f13996b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e10) {
            Log.d("TwilightManager", "Failed to get last known location", e10);
            return null;
        }
    }

    private boolean e() {
        if (this.f13997c.f13999b > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    private void f(Location location) {
        long j10;
        a aVar = this.f13997c;
        long currentTimeMillis = System.currentTimeMillis();
        x b10 = x.b();
        x xVar = b10;
        xVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        xVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = true;
        if (b10.f13993c != 1) {
            z10 = false;
        }
        boolean z11 = z10;
        long j11 = b10.f13992b;
        long j12 = b10.f13991a;
        long j13 = j12;
        double latitude = location.getLatitude();
        long j14 = j11;
        b10.a(currentTimeMillis + 86400000, latitude, location.getLongitude());
        long j15 = b10.f13992b;
        if (j14 == -1 || j13 == -1) {
            j10 = currentTimeMillis + 43200000;
        } else {
            if (currentTimeMillis <= j13) {
                if (currentTimeMillis > j14) {
                    j15 = j13;
                } else {
                    j15 = j14;
                }
            }
            j10 = j15 + 60000;
        }
        aVar.f13998a = z11;
        aVar.f13999b = j10;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f13997c;
        if (e()) {
            return aVar.f13998a;
        }
        Location b10 = b();
        if (b10 != null) {
            f(b10);
            return aVar.f13998a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i10 = Calendar.getInstance().get(11);
        if (i10 < 6 || i10 >= 22) {
            return true;
        }
        return false;
    }
}
