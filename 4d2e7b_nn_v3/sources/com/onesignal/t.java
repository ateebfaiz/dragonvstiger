package com.onesignal;

import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.onesignal.o3;

abstract class t extends h0 {
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static z f11061j;

    /* renamed from: k  reason: collision with root package name */
    static d f11062k;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                Thread.sleep((long) t.s());
                o3.a(o3.v.WARN, "Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.");
                h0.e();
                h0.m(h0.f10654g);
            } catch (InterruptedException unused) {
            }
        }
    }

    static class b {
        static Location a(GoogleApiClient googleApiClient) {
            synchronized (h0.f10651d) {
                try {
                    if (!googleApiClient.isConnected()) {
                        return null;
                    }
                    Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    return lastLocation;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        static void b(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            try {
                synchronized (h0.f10651d) {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                    if (googleApiClient.isConnected()) {
                        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, locationListener);
                    }
                }
            } catch (Throwable th) {
                o3.b(o3.v.WARN, "FusedLocationApi.requestLocationUpdates failed!", th);
            }
        }
    }

    private static class c implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private c() {
        }

        public void onConnected(Bundle bundle) {
            synchronized (h0.f10651d) {
                try {
                    if (t.f11061j != null) {
                        if (t.f11061j.c() != null) {
                            o3.v vVar = o3.v.DEBUG;
                            o3.a(vVar, "GMSLocationController GoogleApiClientListener onConnected lastLocation: " + h0.f10655h);
                            if (h0.f10655h == null) {
                                h0.f10655h = b.a(t.f11061j.c());
                                o3.a(vVar, "GMSLocationController GoogleApiClientListener lastLocation: " + h0.f10655h);
                                Location location = h0.f10655h;
                                if (location != null) {
                                    h0.d(location);
                                }
                            }
                            t.f11062k = new d(t.f11061j.c());
                            return;
                        }
                    }
                    o3.a(o3.v.DEBUG, "GMSLocationController GoogleApiClientListener onConnected googleApiClient not available, returning");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, "GMSLocationController GoogleApiClientListener onConnectionSuspended connectionResult: " + connectionResult);
            t.e();
        }

        public void onConnectionSuspended(int i10) {
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, "GMSLocationController GoogleApiClientListener onConnectionSuspended i: " + i10);
            t.e();
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    static class d implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        private GoogleApiClient f11063a;

        d(GoogleApiClient googleApiClient) {
            this.f11063a = googleApiClient;
            a();
        }

        private void a() {
            long j10;
            if (o3.O0()) {
                j10 = 270000;
            } else {
                j10 = 570000;
            }
            if (this.f11063a != null) {
                LocationRequest priority = LocationRequest.create().setFastestInterval(j10).setInterval(j10).setMaxWaitTime((long) (((double) j10) * 1.5d)).setPriority(LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY);
                o3.a(o3.v.DEBUG, "GMSLocationController GoogleApiClient requestLocationUpdates!");
                b.b(this.f11063a, priority, this);
            }
        }
    }

    static void e() {
        synchronized (h0.f10651d) {
            try {
                z zVar = f11061j;
                if (zVar != null) {
                    zVar.b();
                }
                f11061j = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void l() {
        /*
            java.lang.Object r0 = com.onesignal.h0.f10651d
            monitor-enter(r0)
            com.onesignal.o3$v r1 = com.onesignal.o3.v.DEBUG     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "GMSLocationController onFocusChange!"
            com.onesignal.o3.a(r1, r2)     // Catch:{ all -> 0x002d }
            com.onesignal.z r1 = f11061j     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0038
            com.google.android.gms.common.api.GoogleApiClient r1 = r1.c()     // Catch:{ all -> 0x002d }
            boolean r1 = r1.isConnected()     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x0019
            goto L_0x0038
        L_0x0019:
            com.onesignal.z r1 = f11061j     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.common.api.GoogleApiClient r1 = r1.c()     // Catch:{ all -> 0x002d }
            com.onesignal.t$d r2 = f11062k     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002f
            com.google.android.gms.location.FusedLocationProviderApi r2 = com.google.android.gms.location.LocationServices.FusedLocationApi     // Catch:{ all -> 0x002d }
            com.onesignal.t$d r3 = f11062k     // Catch:{ all -> 0x002d }
            r2.removeLocationUpdates(r1, r3)     // Catch:{ all -> 0x002d }
            goto L_0x002f
        L_0x002d:
            r1 = move-exception
            goto L_0x003a
        L_0x002f:
            com.onesignal.t$d r2 = new com.onesignal.t$d     // Catch:{ all -> 0x002d }
            r2.<init>(r1)     // Catch:{ all -> 0x002d }
            f11062k = r2     // Catch:{ all -> 0x002d }
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.t.l():void");
    }

    static void p() {
        t();
    }

    /* access modifiers changed from: private */
    public static int s() {
        return 30000;
    }

    private static void t() {
        if (h0.f10653f == null) {
            synchronized (h0.f10651d) {
                try {
                    u();
                    if (f11061j != null) {
                        Location location = h0.f10655h;
                        if (location != null) {
                            h0.d(location);
                        }
                    }
                    c cVar = new c((a) null);
                    z zVar = new z(new GoogleApiClient.Builder(h0.f10654g).addApi(LocationServices.API).addConnectionCallbacks(cVar).addOnConnectionFailedListener(cVar).setHandler(h0.h().f10657a).build());
                    f11061j = zVar;
                    zVar.a();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static void u() {
        Thread thread = new Thread(new a(), "OS_GMS_LOCATION_FALLBACK");
        h0.f10653f = thread;
        thread.start();
    }
}
