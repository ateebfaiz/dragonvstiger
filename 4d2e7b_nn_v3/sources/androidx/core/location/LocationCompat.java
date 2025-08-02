package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    @Nullable
    private static Field sFieldsMaskField;
    @Nullable
    private static Integer sHasBearingAccuracyMask;
    @Nullable
    private static Integer sHasSpeedAccuracyMask;
    @Nullable
    private static Integer sHasVerticalAccuracyMask;
    @Nullable
    private static Method sSetIsFromMockProviderMethod;

    private static class a {
        @DoNotInline
        static float a(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        @DoNotInline
        static float b(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        static float c(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        @DoNotInline
        static boolean d(Location location) {
            return location.hasBearingAccuracy();
        }

        @DoNotInline
        static boolean e(Location location) {
            return location.hasSpeedAccuracy();
        }

        @DoNotInline
        static boolean f(Location location) {
            return location.hasVerticalAccuracy();
        }

        @DoNotInline
        static void g(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasBearingAccuracyMask())));
            } catch (NoSuchFieldException e10) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e10);
                throw noSuchFieldError;
            } catch (IllegalAccessException e11) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e11);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void h(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasSpeedAccuracyMask())));
            } catch (NoSuchFieldException e10) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e10);
                throw noSuchFieldError;
            } catch (IllegalAccessException e11) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e11);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void i(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasVerticalAccuracyMask())));
            } catch (IllegalAccessException | NoSuchFieldException e10) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e10);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void j(Location location, float f10) {
            location.setBearingAccuracyDegrees(f10);
        }

        @DoNotInline
        static void k(Location location, float f10) {
            location.setSpeedAccuracyMetersPerSecond(f10);
        }

        @DoNotInline
        static void l(Location location, float f10) {
            location.setVerticalAccuracyMeters(f10);
        }
    }

    private static class b {
        @DoNotInline
        static void a(Location location) {
            Location location2 = location;
            if (location.hasBearingAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float f10 = bearing;
                float accuracy = location.getAccuracy();
                boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
                float f11 = accuracy;
                float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
                float f12 = verticalAccuracyMeters;
                float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                Bundle extras = location.getExtras();
                location.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (hasAltitude) {
                    location2.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location2.setSpeed(speed);
                }
                if (hasBearing) {
                    location2.setBearing(f10);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(f11);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f12);
                }
                if (hasSpeedAccuracy) {
                    location2.setBearingAccuracyDegrees(speedAccuracyMetersPerSecond);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        @DoNotInline
        static void b(Location location) {
            Location location2 = location;
            if (location.hasSpeedAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float f10 = bearing;
                float accuracy = location.getAccuracy();
                boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
                float f11 = accuracy;
                float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                boolean hasBearingAccuracy = location.hasBearingAccuracy();
                float f12 = verticalAccuracyMeters;
                float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                Bundle extras = location.getExtras();
                location.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (hasAltitude) {
                    location2.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location2.setSpeed(speed);
                }
                if (hasBearing) {
                    location2.setBearing(f10);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(f11);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f12);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        @DoNotInline
        static void c(Location location) {
            Location location2 = location;
            if (location.hasVerticalAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float f10 = bearing;
                float accuracy = location.getAccuracy();
                boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
                float f11 = accuracy;
                float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                boolean hasBearingAccuracy = location.hasBearingAccuracy();
                float f12 = speedAccuracyMetersPerSecond;
                float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                Bundle extras = location.getExtras();
                location.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (hasAltitude) {
                    location2.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location2.setSpeed(speed);
                }
                if (hasBearing) {
                    location2.setBearing(f10);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(f11);
                }
                if (hasSpeedAccuracy) {
                    location2.setSpeedAccuracyMetersPerSecond(f12);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }
    }

    private static class c {
        @DoNotInline
        static void a(Location location) {
            if (location.hasBearingAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                b.a(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        @DoNotInline
        static void b(Location location) {
            if (location.hasSpeedAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                b.b(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        @DoNotInline
        static void c(Location location) {
            if (location.hasVerticalAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                b.c(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }
    }

    private static class d {
        @DoNotInline
        static void a(Location location) {
            location.removeBearingAccuracy();
        }

        @DoNotInline
        static void b(Location location) {
            location.removeSpeedAccuracy();
        }

        @DoNotInline
        static void c(Location location) {
            location.removeVerticalAccuracy();
        }
    }

    private static class e {
        @DoNotInline
        static float a(Location location) {
            return location.getMslAltitudeAccuracyMeters();
        }

        @DoNotInline
        static double b(Location location) {
            return location.getMslAltitudeMeters();
        }

        @DoNotInline
        static boolean c(Location location) {
            return location.hasMslAltitude();
        }

        @DoNotInline
        static boolean d(Location location) {
            return location.hasMslAltitudeAccuracy();
        }

        @DoNotInline
        static void e(Location location) {
            location.removeMslAltitude();
        }

        @DoNotInline
        static void f(Location location) {
            location.removeMslAltitudeAccuracy();
        }

        @DoNotInline
        static void g(Location location, float f10) {
            location.setMslAltitudeAccuracyMeters(f10);
        }

        @DoNotInline
        static void h(Location location, double d10) {
            location.setMslAltitudeMeters(d10);
        }
    }

    private LocationCompat() {
    }

    private static boolean containsExtra(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras == null || !extras.containsKey(str)) {
            return false;
        }
        return true;
    }

    public static float getBearingAccuracyDegrees(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.a(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    }

    public static long getElapsedRealtimeMillis(@NonNull Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    public static long getElapsedRealtimeNanos(@NonNull Location location) {
        return location.getElapsedRealtimeNanos();
    }

    @SuppressLint({"BlockedPrivateApi"})
    static Field getFieldsMaskField() throws NoSuchFieldException {
        if (sFieldsMaskField == null) {
            Field declaredField = Location.class.getDeclaredField("mFieldsMask");
            sFieldsMaskField = declaredField;
            declaredField.setAccessible(true);
        }
        return sFieldsMaskField;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int getHasBearingAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasBearingAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasBearingAccuracyMask = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return sHasBearingAccuracyMask.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int getHasSpeedAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasSpeedAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasSpeedAccuracyMask = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return sHasSpeedAccuracyMask.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int getHasVerticalAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasVerticalAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasVerticalAccuracyMask = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return sHasVerticalAccuracyMask.intValue();
    }

    @FloatRange(from = 0.0d)
    public static float getMslAltitudeAccuracyMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return e.a(location);
        }
        return getOrCreateExtras(location).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return e.b(location);
        }
        return getOrCreateExtras(location).getDouble(EXTRA_MSL_ALTITUDE);
    }

    private static Bundle getOrCreateExtras(@NonNull Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras;
        }
        location.setExtras(new Bundle());
        return location.getExtras();
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
            sSetIsFromMockProviderMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.b(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    }

    public static float getVerticalAccuracyMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.c(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    }

    public static boolean hasBearingAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.d(location);
        }
        return containsExtra(location, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return e.c(location);
        }
        return containsExtra(location, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return e.d(location);
        }
        return containsExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.e(location);
        }
        return containsExtra(location, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.f(location);
        }
        return containsExtra(location, EXTRA_VERTICAL_ACCURACY);
    }

    public static boolean isMock(@NonNull Location location) {
        return location.isFromMockProvider();
    }

    public static void removeBearingAccuracy(@NonNull Location location) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            d.a(location);
        } else if (i10 >= 29) {
            c.a(location);
        } else if (i10 >= 28) {
            b.a(location);
        } else if (i10 >= 26) {
            a.g(location);
        } else {
            removeExtra(location, EXTRA_BEARING_ACCURACY);
        }
    }

    private static void removeExtra(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(str);
            if (extras.isEmpty()) {
                location.setExtras((Bundle) null);
            }
        }
    }

    public static void removeMslAltitude(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            e.e(location);
        } else {
            removeExtra(location, EXTRA_MSL_ALTITUDE);
        }
    }

    public static void removeMslAltitudeAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            e.f(location);
        } else {
            removeExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
        }
    }

    public static void removeSpeedAccuracy(@NonNull Location location) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            d.b(location);
        } else if (i10 >= 29) {
            c.b(location);
        } else if (i10 >= 28) {
            b.b(location);
        } else if (i10 >= 26) {
            a.h(location);
        } else {
            removeExtra(location, EXTRA_SPEED_ACCURACY);
        }
    }

    public static void removeVerticalAccuracy(@NonNull Location location) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            d.c(location);
        } else if (i10 >= 29) {
            c.c(location);
        } else if (i10 >= 28) {
            b.c(location);
        } else if (i10 >= 26) {
            a.i(location);
        } else {
            removeExtra(location, EXTRA_VERTICAL_ACCURACY);
        }
    }

    public static void setBearingAccuracyDegrees(@NonNull Location location, float f10) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.j(location, f10);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_BEARING_ACCURACY, f10);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void setMock(@NonNull Location location, boolean z10) {
        try {
            getSetIsFromMockProviderMethod().invoke(location, new Object[]{Boolean.valueOf(z10)});
        } catch (NoSuchMethodException e10) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e10);
            throw noSuchMethodError;
        } catch (IllegalAccessException e11) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e11);
            throw illegalAccessError;
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    public static void setMslAltitudeAccuracyMeters(@NonNull Location location, @FloatRange(from = 0.0d) float f10) {
        if (Build.VERSION.SDK_INT >= 34) {
            e.g(location, f10);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, f10);
        }
    }

    public static void setMslAltitudeMeters(@NonNull Location location, double d10) {
        if (Build.VERSION.SDK_INT >= 34) {
            e.h(location, d10);
        } else {
            getOrCreateExtras(location).putDouble(EXTRA_MSL_ALTITUDE, d10);
        }
    }

    public static void setSpeedAccuracyMetersPerSecond(@NonNull Location location, float f10) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.k(location, f10);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_SPEED_ACCURACY, f10);
        }
    }

    public static void setVerticalAccuracyMeters(@NonNull Location location, float f10) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.l(location, f10);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_VERTICAL_ACCURACY, f10);
        }
    }
}
