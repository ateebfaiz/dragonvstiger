package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssMeasurementsEvent;
import android.location.GnssMeasurementsEvent$Callback;
import android.location.GnssStatus;
import android.location.GnssStatus$Callback;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;
    private static Method sGnssRequestBuilderBuildMethod;
    private static Class<?> sGnssRequestBuilderClass;
    @GuardedBy("sLocationListeners")
    static final WeakHashMap<l, WeakReference<m>> sLocationListeners = new WeakHashMap<>();
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Class f14949a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f14950b;

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        static boolean a(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
            try {
                if (f14949a == null) {
                    f14949a = Class.forName("android.location.LocationRequest");
                }
                if (f14950b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f14949a, LocationListener.class, Looper.class});
                    f14950b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    f14950b.invoke(locationManager, new Object[]{locationRequest, locationListenerCompat, looper});
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        static boolean b(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, m mVar) {
            try {
                if (f14949a == null) {
                    f14949a = Class.forName("android.location.LocationRequest");
                }
                if (f14950b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f14949a, LocationListener.class, Looper.class});
                    f14950b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    synchronized (LocationManagerCompat.sLocationListeners) {
                        f14950b.invoke(locationManager, new Object[]{locationRequest, mVar, Looper.getMainLooper()});
                        LocationManagerCompat.registerLocationListenerTransport(locationManager, mVar);
                    }
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }
    }

    static class b {
        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean a(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
            return locationManager.registerGnssMeasurementsCallback(gnssMeasurementsEvent$Callback);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean b(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback, @NonNull Handler handler) {
            return locationManager.registerGnssMeasurementsCallback(gnssMeasurementsEvent$Callback, handler);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static boolean c(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            boolean z10;
            if (handler != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10);
            SimpleArrayMap simpleArrayMap = g.f14959a;
            synchronized (simpleArrayMap) {
                try {
                    n nVar = (n) simpleArrayMap.get(callback);
                    if (nVar == null) {
                        nVar = new n(callback);
                    } else {
                        nVar.j();
                    }
                    nVar.i(executor);
                    if (!locationManager.registerGnssStatusCallback(nVar, handler)) {
                        return false;
                    }
                    simpleArrayMap.put(callback, nVar);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @DoNotInline
        static void d(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
            locationManager.unregisterGnssMeasurementsCallback(gnssMeasurementsEvent$Callback);
        }

        @DoNotInline
        static void e(LocationManager locationManager, Object obj) {
            if (obj instanceof n) {
                ((n) obj).j();
            }
            locationManager.unregisterGnssStatusCallback((GnssStatus$Callback) obj);
        }
    }

    private static class c {
        @DoNotInline
        static String a(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @DoNotInline
        static int b(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @DoNotInline
        static boolean c(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private static Class f14951a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f14952b;

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void a(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
            Objects.requireNonNull(consumer);
            locationManager.getCurrentLocation(str, cancellationSignal, executor, new u(consumer));
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean b(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            SimpleArrayMap simpleArrayMap = g.f14959a;
            synchronized (simpleArrayMap) {
                try {
                    i iVar = (i) simpleArrayMap.get(callback);
                    if (iVar == null) {
                        iVar = new i(callback);
                    }
                    if (!locationManager.registerGnssStatusCallback(executor, iVar)) {
                        return false;
                    }
                    simpleArrayMap.put(callback, iVar);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @DoNotInline
        public static boolean c(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    if (f14951a == null) {
                        f14951a = Class.forName("android.location.LocationRequest");
                    }
                    if (f14952b == null) {
                        Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f14951a, Executor.class, LocationListener.class});
                        f14952b = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                    if (locationRequest != null) {
                        f14952b.invoke(locationManager, new Object[]{locationRequest, executor, locationListenerCompat});
                        return true;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                }
            }
            return false;
        }
    }

    private static class e {
        @DoNotInline
        static boolean a(LocationManager locationManager, @NonNull String str) {
            return locationManager.hasProvider(str);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean b(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
            return locationManager.registerGnssMeasurementsCallback(executor, gnssMeasurementsEvent$Callback);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void c(LocationManager locationManager, @NonNull String str, @NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    private static final class f implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        private final LocationManager f14953a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f14954b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f14955c = new Handler(Looper.getMainLooper());

        /* renamed from: d  reason: collision with root package name */
        private Consumer f14956d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f14957e;

        /* renamed from: f  reason: collision with root package name */
        Runnable f14958f;

        f(LocationManager locationManager, Executor executor, Consumer consumer) {
            this.f14953a = locationManager;
            this.f14954b = executor;
            this.f14956d = consumer;
        }

        private void d() {
            this.f14956d = null;
            this.f14953a.removeUpdates(this);
            Runnable runnable = this.f14958f;
            if (runnable != null) {
                this.f14955c.removeCallbacks(runnable);
                this.f14958f = null;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f() {
            this.f14958f = null;
            onLocationChanged((Location) null);
        }

        public void c() {
            synchronized (this) {
                try {
                    if (!this.f14957e) {
                        this.f14957e = true;
                        d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void g(long j10) {
            synchronized (this) {
                try {
                    if (!this.f14957e) {
                        v vVar = new v(this);
                        this.f14958f = vVar;
                        this.f14955c.postDelayed(vVar, j10);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onLocationChanged(Location location) {
            synchronized (this) {
                try {
                    if (!this.f14957e) {
                        this.f14957e = true;
                        this.f14954b.execute(new w(this.f14956d, location));
                        d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void onProviderDisabled(String str) {
            onLocationChanged((Location) null);
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i10, Bundle bundle) {
        }
    }

    private static class g {

        /* renamed from: a  reason: collision with root package name */
        static final SimpleArrayMap f14959a = new SimpleArrayMap();

        /* renamed from: b  reason: collision with root package name */
        static final SimpleArrayMap f14960b = new SimpleArrayMap();
    }

    private static class h extends GnssMeasurementsEvent$Callback {

        /* renamed from: a  reason: collision with root package name */
        final GnssMeasurementsEvent$Callback f14961a;

        /* renamed from: b  reason: collision with root package name */
        volatile Executor f14962b;

        h(GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback, Executor executor) {
            this.f14961a = gnssMeasurementsEvent$Callback;
            this.f14962b = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (this.f14962b == executor) {
                this.f14961a.onGnssMeasurementsReceived(gnssMeasurementsEvent);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Executor executor, int i10) {
            if (this.f14962b == executor) {
                this.f14961a.onStatusChanged(i10);
            }
        }

        public void e() {
            this.f14962b = null;
        }

        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            Executor executor = this.f14962b;
            if (executor != null) {
                executor.execute(new z(this, executor, gnssMeasurementsEvent));
            }
        }

        public void onStatusChanged(int i10) {
            Executor executor = this.f14962b;
            if (executor != null) {
                executor.execute(new a0(this, executor, i10));
            }
        }
    }

    private static class i extends GnssStatus$Callback {

        /* renamed from: a  reason: collision with root package name */
        final GnssStatusCompat.Callback f14963a;

        i(GnssStatusCompat.Callback callback) {
            boolean z10;
            if (callback != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "invalid null callback");
            this.f14963a = callback;
        }

        public void onFirstFix(int i10) {
            this.f14963a.onFirstFix(i10);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.f14963a.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        public void onStarted() {
            this.f14963a.onStarted();
        }

        public void onStopped() {
            this.f14963a.onStopped();
        }
    }

    private static class j implements GpsStatus.Listener {

        /* renamed from: a  reason: collision with root package name */
        private final LocationManager f14964a;

        /* renamed from: b  reason: collision with root package name */
        final GnssStatusCompat.Callback f14965b;

        /* renamed from: c  reason: collision with root package name */
        volatile Executor f14966c;

        j(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            boolean z10;
            if (callback != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "invalid null callback");
            this.f14964a = locationManager;
            this.f14965b = callback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(Executor executor) {
            if (this.f14966c == executor) {
                this.f14965b.onStarted();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Executor executor) {
            if (this.f14966c == executor) {
                this.f14965b.onStopped();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(Executor executor, int i10) {
            if (this.f14966c == executor) {
                this.f14965b.onFirstFix(i10);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (this.f14966c == executor) {
                this.f14965b.onSatelliteStatusChanged(gnssStatusCompat);
            }
        }

        public void i(Executor executor) {
            boolean z10;
            if (this.f14966c == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10);
            this.f14966c = executor;
        }

        public void j() {
            this.f14966c = null;
        }

        public void onGpsStatusChanged(int i10) {
            GpsStatus gpsStatus;
            Executor executor = this.f14966c;
            if (executor != null) {
                if (i10 == 1) {
                    executor.execute(new b0(this, executor));
                } else if (i10 == 2) {
                    executor.execute(new c0(this, executor));
                } else if (i10 == 3) {
                    GpsStatus gpsStatus2 = this.f14964a.getGpsStatus((GpsStatus) null);
                    if (gpsStatus2 != null) {
                        executor.execute(new d0(this, executor, gpsStatus2.getTimeToFirstFix()));
                    }
                } else if (i10 == 4 && (gpsStatus = this.f14964a.getGpsStatus((GpsStatus) null)) != null) {
                    executor.execute(new e0(this, executor, GnssStatusCompat.wrap(gpsStatus)));
                }
            }
        }
    }

    private static final class k implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f14967a;

        k(Handler handler) {
            this.f14967a = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(Runnable runnable) {
            if (Looper.myLooper() == this.f14967a.getLooper()) {
                runnable.run();
            } else if (!this.f14967a.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.f14967a + " is shutting down");
            }
        }
    }

    private static class l {

        /* renamed from: a  reason: collision with root package name */
        final String f14968a;

        /* renamed from: b  reason: collision with root package name */
        final LocationListenerCompat f14969b;

        l(String str, LocationListenerCompat locationListenerCompat) {
            this.f14968a = (String) ObjectsCompat.requireNonNull(str, "invalid null provider");
            this.f14969b = (LocationListenerCompat) ObjectsCompat.requireNonNull(locationListenerCompat, "invalid null listener");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            if (!this.f14968a.equals(lVar.f14968a) || !this.f14969b.equals(lVar.f14969b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f14968a, this.f14969b);
        }
    }

    private static class n extends GnssStatus$Callback {

        /* renamed from: a  reason: collision with root package name */
        final GnssStatusCompat.Callback f14972a;

        /* renamed from: b  reason: collision with root package name */
        volatile Executor f14973b;

        n(GnssStatusCompat.Callback callback) {
            boolean z10;
            if (callback != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "invalid null callback");
            this.f14972a = callback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(Executor executor, int i10) {
            if (this.f14973b == executor) {
                this.f14972a.onFirstFix(i10);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Executor executor, GnssStatus gnssStatus) {
            if (this.f14973b == executor) {
                this.f14972a.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(Executor executor) {
            if (this.f14973b == executor) {
                this.f14972a.onStarted();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(Executor executor) {
            if (this.f14973b == executor) {
                this.f14972a.onStopped();
            }
        }

        public void i(Executor executor) {
            boolean z10;
            boolean z11 = false;
            if (executor != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "invalid null executor");
            if (this.f14973b == null) {
                z11 = true;
            }
            Preconditions.checkState(z11);
            this.f14973b = executor;
        }

        public void j() {
            this.f14973b = null;
        }

        public void onFirstFix(int i10) {
            Executor executor = this.f14973b;
            if (executor != null) {
                executor.execute(new l0(this, executor, i10));
            }
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Executor executor = this.f14973b;
            if (executor != null) {
                executor.execute(new m0(this, executor, gnssStatus));
            }
        }

        public void onStarted() {
            Executor executor = this.f14973b;
            if (executor != null) {
                executor.execute(new o0(this, executor));
            }
        }

        public void onStopped() {
            Executor executor = this.f14973b;
            if (executor != null) {
                executor.execute(new n0(this, executor));
            }
        }
    }

    private LocationManagerCompat() {
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @Deprecated
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable androidx.core.os.CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        getCurrentLocation(locationManager, str, cancellationSignal != null ? (CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, executor, consumer);
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.a(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.b(locationManager);
        }
        return 0;
    }

    public static boolean hasProvider(@NonNull LocationManager locationManager, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return e.a(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            if (locationManager.getProvider(str) != null) {
                return true;
            }
            return false;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.c(locationManager);
        }
        if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }

    @RequiresApi(24)
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback, @NonNull Handler handler) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 30) {
            return b.b(locationManager, gnssMeasurementsEvent$Callback, handler);
        }
        if (i10 == 30) {
            return registerGnssMeasurementsCallbackOnR(locationManager, ExecutorCompat.create(handler), gnssMeasurementsEvent$Callback);
        }
        SimpleArrayMap simpleArrayMap = g.f14960b;
        synchronized (simpleArrayMap) {
            try {
                unregisterGnssMeasurementsCallback(locationManager, gnssMeasurementsEvent$Callback);
                if (!b.b(locationManager, gnssMeasurementsEvent$Callback, handler)) {
                    return false;
                }
                simpleArrayMap.put(gnssMeasurementsEvent$Callback, gnssMeasurementsEvent$Callback);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RequiresApi(30)
    private static boolean registerGnssMeasurementsCallbackOnR(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        if (Build.VERSION.SDK_INT == 30) {
            try {
                if (sGnssRequestBuilderClass == null) {
                    sGnssRequestBuilderClass = Class.forName("android.location.GnssRequest$Builder");
                }
                if (sGnssRequestBuilderBuildMethod == null) {
                    Method declaredMethod = sGnssRequestBuilderClass.getDeclaredMethod("build", (Class[]) null);
                    sGnssRequestBuilderBuildMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                if (sRegisterGnssMeasurementsCallbackMethod == null) {
                    Method declaredMethod2 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", new Class[]{Class.forName("android.location.GnssRequest"), Executor.class, q.a()});
                    sRegisterGnssMeasurementsCallbackMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                Object invoke = sRegisterGnssMeasurementsCallbackMethod.invoke(locationManager, new Object[]{sGnssRequestBuilderBuildMethod.invoke(sGnssRequestBuilderClass.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null), (Object[]) null), executor, gnssMeasurementsEvent$Callback});
                if (invoke == null || !((Boolean) invoke).booleanValue()) {
                    return false;
                }
                return true;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, (Executor) new k(handler), callback);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @GuardedBy("sLocationListeners")
    static void registerLocationListenerTransport(LocationManager locationManager, m mVar) {
        m mVar2;
        WeakReference put = sLocationListeners.put(mVar.g(), new WeakReference(mVar));
        if (put != null) {
            mVar2 = (m) put.get();
        } else {
            mVar2 = null;
        }
        if (mVar2 != null) {
            mVar2.n();
            locationManager.removeUpdates(mVar2);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void removeUpdates(@NonNull LocationManager locationManager, @NonNull LocationListenerCompat locationListenerCompat) {
        WeakHashMap<l, WeakReference<m>> weakHashMap = sLocationListeners;
        synchronized (weakHashMap) {
            try {
                ArrayList arrayList = null;
                for (WeakReference<m> weakReference : weakHashMap.values()) {
                    m mVar = (m) weakReference.get();
                    if (mVar != null) {
                        l g10 = mVar.g();
                        if (g10.f14969b == locationListenerCompat) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(g10);
                            mVar.n();
                            locationManager.removeUpdates(mVar);
                        }
                    }
                }
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        sLocationListeners.remove((l) it.next());
                    }
                }
            } finally {
                while (true) {
                }
            }
        }
        locationManager.removeUpdates(locationListenerCompat);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull Executor executor, @NonNull LocationListenerCompat locationListenerCompat) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            e.c(locationManager, str, locationRequestCompat.toLocationRequest(), executor, locationListenerCompat);
        } else if (i10 < 30 || !d.c(locationManager, str, locationRequestCompat, executor, locationListenerCompat)) {
            m mVar = new m(new l(str, locationListenerCompat), executor);
            if (!a.b(locationManager, str, locationRequestCompat, mVar)) {
                synchronized (sLocationListeners) {
                    locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), mVar, Looper.getMainLooper());
                    registerLocationListenerTransport(locationManager, mVar);
                }
            }
        }
    }

    @RequiresApi(24)
    public static void unregisterGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.d(locationManager, gnssMeasurementsEvent$Callback);
            return;
        }
        SimpleArrayMap simpleArrayMap = g.f14960b;
        synchronized (simpleArrayMap) {
            try {
                GnssMeasurementsEvent$Callback a10 = p.a(simpleArrayMap.remove(gnssMeasurementsEvent$Callback));
                if (a10 != null) {
                    if (a10 instanceof h) {
                        ((h) a10).e();
                    }
                    b.d(locationManager, a10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 24) {
            SimpleArrayMap simpleArrayMap = g.f14959a;
            synchronized (simpleArrayMap) {
                try {
                    Object remove = simpleArrayMap.remove(callback);
                    if (remove != null) {
                        b.e(locationManager, remove);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        SimpleArrayMap simpleArrayMap2 = g.f14959a;
        synchronized (simpleArrayMap2) {
            try {
                j jVar = (j) simpleArrayMap2.remove(callback);
                if (jVar != null) {
                    jVar.j();
                    locationManager.removeGpsStatusListener(jVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static class m implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        volatile l f14970a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f14971b;

        m(l lVar, Executor executor) {
            this.f14970a = lVar;
            this.f14971b = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(int i10) {
            l lVar = this.f14970a;
            if (lVar != null) {
                lVar.f14969b.onFlushComplete(i10);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(Location location) {
            l lVar = this.f14970a;
            if (lVar != null) {
                lVar.f14969b.onLocationChanged(location);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(List list) {
            l lVar = this.f14970a;
            if (lVar != null) {
                lVar.f14969b.onLocationChanged(list);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(String str) {
            l lVar = this.f14970a;
            if (lVar != null) {
                lVar.f14969b.onProviderDisabled(str);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(String str) {
            l lVar = this.f14970a;
            if (lVar != null) {
                lVar.f14969b.onProviderEnabled(str);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(String str, int i10, Bundle bundle) {
            l lVar = this.f14970a;
            if (lVar != null) {
                lVar.f14969b.onStatusChanged(str, i10, bundle);
            }
        }

        public l g() {
            return (l) ObjectsCompat.requireNonNull(this.f14970a);
        }

        public void n() {
            this.f14970a = null;
        }

        public void onFlushComplete(int i10) {
            if (this.f14970a != null) {
                this.f14971b.execute(new j0(this, i10));
            }
        }

        public void onLocationChanged(Location location) {
            if (this.f14970a != null) {
                this.f14971b.execute(new i0(this, location));
            }
        }

        public void onProviderDisabled(String str) {
            if (this.f14970a != null) {
                this.f14971b.execute(new g0(this, str));
            }
        }

        public void onProviderEnabled(String str) {
            if (this.f14970a != null) {
                this.f14971b.execute(new f0(this, str));
            }
        }

        public void onStatusChanged(String str, int i10, Bundle bundle) {
            if (this.f14970a != null) {
                this.f14971b.execute(new k0(this, str, i10, bundle));
            }
        }

        public void onLocationChanged(List list) {
            if (this.f14970a != null) {
                this.f14971b.execute(new h0(this, list));
            }
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.a(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation == null || SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) >= 10000) {
            f fVar = new f(locationManager, executor, consumer);
            locationManager.requestLocationUpdates(str, 0, 0.0f, fVar, Looper.getMainLooper());
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new s(fVar));
            }
            fVar.g(30000);
            return;
        }
        executor.execute(new r(consumer, lastKnownLocation));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, (Handler) null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(myLooper), executor, callback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0081, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0096, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0097 */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cd A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e2 A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00eb A[SYNTHETIC, Splitter:B:74:0x00eb] */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean registerGnssStatusCallback(android.location.LocationManager r9, android.os.Handler r10, java.util.concurrent.Executor r11, androidx.core.location.GnssStatusCompat.Callback r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L_0x000b
            boolean r9 = androidx.core.location.LocationManagerCompat.d.b(r9, r10, r11, r12)
            return r9
        L_0x000b:
            r1 = 24
            if (r0 < r1) goto L_0x0014
            boolean r9 = androidx.core.location.LocationManagerCompat.b.c(r9, r10, r11, r12)
            return r9
        L_0x0014:
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L_0x001a
            r2 = r1
            goto L_0x001b
        L_0x001a:
            r2 = r0
        L_0x001b:
            androidx.core.util.Preconditions.checkArgument(r2)
            androidx.collection.SimpleArrayMap r2 = androidx.core.location.LocationManagerCompat.g.f14959a
            monitor-enter(r2)
            java.lang.Object r3 = r2.get(r12)     // Catch:{ all -> 0x002f }
            androidx.core.location.LocationManagerCompat$j r3 = (androidx.core.location.LocationManagerCompat.j) r3     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x0032
            androidx.core.location.LocationManagerCompat$j r3 = new androidx.core.location.LocationManagerCompat$j     // Catch:{ all -> 0x002f }
            r3.<init>(r9, r12)     // Catch:{ all -> 0x002f }
            goto L_0x0035
        L_0x002f:
            r9 = move-exception
            goto L_0x010a
        L_0x0032:
            r3.j()     // Catch:{ all -> 0x002f }
        L_0x0035:
            r3.i(r11)     // Catch:{ all -> 0x002f }
            java.util.concurrent.FutureTask r11 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x002f }
            androidx.core.location.t r4 = new androidx.core.location.t     // Catch:{ all -> 0x002f }
            r4.<init>(r9, r3)     // Catch:{ all -> 0x002f }
            r11.<init>(r4)     // Catch:{ all -> 0x002f }
            android.os.Looper r9 = android.os.Looper.myLooper()     // Catch:{ all -> 0x002f }
            android.os.Looper r4 = r10.getLooper()     // Catch:{ all -> 0x002f }
            if (r9 != r4) goto L_0x0050
            r11.run()     // Catch:{ all -> 0x002f }
            goto L_0x0056
        L_0x0050:
            boolean r9 = r10.post(r11)     // Catch:{ all -> 0x002f }
            if (r9 == 0) goto L_0x00f3
        L_0x0056:
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x00ac, TimeoutException -> 0x00aa }
            r4 = 5
            long r4 = r9.toNanos(r4)     // Catch:{ ExecutionException -> 0x00ac, TimeoutException -> 0x00aa }
            long r6 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x00ac, TimeoutException -> 0x00aa }
            long r6 = r6 + r4
            r9 = r0
        L_0x0064:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            java.lang.Object r4 = r11.get(r4, r8)     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            boolean r4 = r4.booleanValue()     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            if (r4 == 0) goto L_0x008c
            androidx.collection.SimpleArrayMap r4 = androidx.core.location.LocationManagerCompat.g.f14959a     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            r4.put(r12, r3)     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            if (r9 == 0) goto L_0x0080
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r9.interrupt()     // Catch:{ all -> 0x002f }
        L_0x0080:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            return r1
        L_0x0082:
            r10 = move-exception
            r0 = r9
            goto L_0x00e9
        L_0x0086:
            r11 = move-exception
            r0 = r9
            goto L_0x00ae
        L_0x0089:
            r10 = move-exception
            r0 = r9
            goto L_0x00c5
        L_0x008c:
            if (r9 == 0) goto L_0x0095
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r9.interrupt()     // Catch:{ all -> 0x002f }
        L_0x0095:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            return r0
        L_0x0097:
            long r4 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x00a5, TimeoutException -> 0x00a2, all -> 0x009f }
            long r4 = r6 - r4
            r9 = r1
            goto L_0x0064
        L_0x009f:
            r10 = move-exception
            r0 = r1
            goto L_0x00e9
        L_0x00a2:
            r11 = move-exception
            r0 = r1
            goto L_0x00ae
        L_0x00a5:
            r10 = move-exception
            r0 = r1
            goto L_0x00c5
        L_0x00a8:
            r10 = move-exception
            goto L_0x00e9
        L_0x00aa:
            r11 = move-exception
            goto L_0x00ae
        L_0x00ac:
            r10 = move-exception
            goto L_0x00c5
        L_0x00ae:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
            r12.<init>()     // Catch:{ all -> 0x00a8 }
            r12.append(r10)     // Catch:{ all -> 0x00a8 }
            java.lang.String r10 = " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread"
            r12.append(r10)     // Catch:{ all -> 0x00a8 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x00a8 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x00a8 }
            throw r9     // Catch:{ all -> 0x00a8 }
        L_0x00c5:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a8 }
            boolean r9 = r9 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x00a8 }
            if (r9 != 0) goto L_0x00e2
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a8 }
            boolean r9 = r9 instanceof java.lang.Error     // Catch:{ all -> 0x00a8 }
            if (r9 == 0) goto L_0x00dc
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a8 }
            java.lang.Error r9 = (java.lang.Error) r9     // Catch:{ all -> 0x00a8 }
            throw r9     // Catch:{ all -> 0x00a8 }
        L_0x00dc:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a8 }
            r9.<init>(r10)     // Catch:{ all -> 0x00a8 }
            throw r9     // Catch:{ all -> 0x00a8 }
        L_0x00e2:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a8 }
            java.lang.RuntimeException r9 = (java.lang.RuntimeException) r9     // Catch:{ all -> 0x00a8 }
            throw r9     // Catch:{ all -> 0x00a8 }
        L_0x00e9:
            if (r0 == 0) goto L_0x00f2
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r9.interrupt()     // Catch:{ all -> 0x002f }
        L_0x00f2:
            throw r10     // Catch:{ all -> 0x002f }
        L_0x00f3:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002f }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r11.<init>()     // Catch:{ all -> 0x002f }
            r11.append(r10)     // Catch:{ all -> 0x002f }
            java.lang.String r10 = " is shutting down"
            r11.append(r10)     // Catch:{ all -> 0x002f }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x002f }
            r9.<init>(r10)     // Catch:{ all -> 0x002f }
            throw r9     // Catch:{ all -> 0x002f }
        L_0x010a:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.LocationManagerCompat.registerGnssStatusCallback(android.location.LocationManager, android.os.Handler, java.util.concurrent.Executor, androidx.core.location.GnssStatusCompat$Callback):boolean");
    }

    @RequiresApi(24)
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 30) {
            return e.b(locationManager, executor, gnssMeasurementsEvent$Callback);
        }
        if (i10 == 30) {
            return registerGnssMeasurementsCallbackOnR(locationManager, executor, gnssMeasurementsEvent$Callback);
        }
        SimpleArrayMap simpleArrayMap = g.f14960b;
        synchronized (simpleArrayMap) {
            try {
                h hVar = new h(gnssMeasurementsEvent$Callback, executor);
                unregisterGnssMeasurementsCallback(locationManager, gnssMeasurementsEvent$Callback);
                if (!b.a(locationManager, hVar)) {
                    return false;
                }
                simpleArrayMap.put(gnssMeasurementsEvent$Callback, hVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull LocationListenerCompat locationListenerCompat, @NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            e.c(locationManager, str, locationRequestCompat.toLocationRequest(), ExecutorCompat.create(new Handler(looper)), locationListenerCompat);
        } else if (!a.a(locationManager, str, locationRequestCompat, locationListenerCompat, looper)) {
            locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerCompat, looper);
        }
    }
}
