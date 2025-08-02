package com.onesignal;

import android.location.Location;
import androidx.core.location.LocationRequestCompat;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationServices;
import com.onesignal.o3;

abstract class b0 extends h0 {

    /* renamed from: j  reason: collision with root package name */
    private static FusedLocationProviderClient f10383j;

    /* renamed from: k  reason: collision with root package name */
    static c f10384k;

    class a implements OnFailureListener {
        a() {
        }
    }

    class b implements OnSuccessListener {
        b() {
        }
    }

    static class c extends LocationCallback {

        /* renamed from: a  reason: collision with root package name */
        private FusedLocationProviderClient f10385a;

        c(FusedLocationProviderClient fusedLocationProviderClient) {
            this.f10385a = fusedLocationProviderClient;
            a();
        }

        private void a() {
            long j10;
            if (o3.O0()) {
                j10 = 270000;
            } else {
                j10 = 570000;
            }
            LocationRequest priority = LocationRequest.create().setFastestInterval(j10).setInterval(j10).setMaxWaitTime((long) (((double) j10) * 1.5d)).setPriority(LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY);
            o3.a(o3.v.DEBUG, "HMSLocationController Huawei LocationServices requestLocationUpdates!");
            this.f10385a.requestLocationUpdates(priority, this, h0.h().getLooper());
        }
    }

    static void e() {
        synchronized (h0.f10651d) {
            f10383j = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void l() {
        /*
            java.lang.Object r0 = com.onesignal.h0.f10651d
            monitor-enter(r0)
            com.onesignal.o3$v r1 = com.onesignal.o3.v.DEBUG     // Catch:{ all -> 0x0016 }
            java.lang.String r2 = "HMSLocationController onFocusChange!"
            com.onesignal.o3.a(r1, r2)     // Catch:{ all -> 0x0016 }
            boolean r1 = com.onesignal.h0.k()     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0018
            com.huawei.hms.location.FusedLocationProviderClient r1 = f10383j     // Catch:{ all -> 0x0016 }
            if (r1 != 0) goto L_0x0018
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return
        L_0x0016:
            r1 = move-exception
            goto L_0x002e
        L_0x0018:
            com.huawei.hms.location.FusedLocationProviderClient r1 = f10383j     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x002c
            com.onesignal.b0$c r2 = f10384k     // Catch:{ all -> 0x0016 }
            if (r2 == 0) goto L_0x0023
            r1.removeLocationUpdates(r2)     // Catch:{ all -> 0x0016 }
        L_0x0023:
            com.onesignal.b0$c r1 = new com.onesignal.b0$c     // Catch:{ all -> 0x0016 }
            com.huawei.hms.location.FusedLocationProviderClient r2 = f10383j     // Catch:{ all -> 0x0016 }
            r1.<init>(r2)     // Catch:{ all -> 0x0016 }
            f10384k = r1     // Catch:{ all -> 0x0016 }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.b0.l():void");
    }

    static void p() {
        q();
    }

    private static void q() {
        synchronized (h0.f10651d) {
            if (f10383j == null) {
                try {
                    f10383j = LocationServices.getFusedLocationProviderClient(h0.f10654g);
                } catch (Exception e10) {
                    o3.v vVar = o3.v.ERROR;
                    o3.a(vVar, "Huawei LocationServices getFusedLocationProviderClient failed! " + e10);
                    e();
                    return;
                }
            }
            Location location = h0.f10655h;
            if (location != null) {
                h0.d(location);
            } else {
                f10383j.getLastLocation().addOnSuccessListener(new b()).addOnFailureListener(new a());
            }
        }
    }
}
