package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import com.google.android.gms.common.GoogleApiAvailability;

abstract class a0 {

    class a implements Runnable {

        /* renamed from: com.onesignal.a0$a$a  reason: collision with other inner class name */
        class C0124a implements DialogInterface.OnClickListener {
            C0124a() {
            }

            public void onClick(DialogInterface dialogInterface, int i10) {
                z3.j(z3.f11153a, "GT_DO_NOT_SHOW_MISSING_GPS", true);
            }
        }

        class b implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Activity f10342a;

            b(Activity activity) {
                this.f10342a = activity;
            }

            public void onClick(DialogInterface dialogInterface, int i10) {
                a0.a(this.f10342a);
            }
        }

        a() {
        }

        public void run() {
            Activity Q = o3.Q();
            if (Q != null) {
                String k10 = OSUtils.k(Q, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
                String k11 = OSUtils.k(Q, "onesignal_gms_missing_alert_button_update", "Update");
                String k12 = OSUtils.k(Q, "onesignal_gms_missing_alert_button_skip", "Skip");
                new AlertDialog.Builder(Q).setMessage(k10).setPositiveButton(k11, new b(Q)).setNegativeButton(k12, new C0124a()).setNeutralButton(OSUtils.k(Q, "onesignal_gms_missing_alert_button_close", "Close"), (DialogInterface.OnClickListener) null).create().show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void a(Activity activity) {
        try {
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            PendingIntent errorResolutionPendingIntent = instance.getErrorResolutionPendingIntent(activity, instance.isGooglePlayServicesAvailable(o3.f10882b), 9000);
            if (errorResolutionPendingIntent != null) {
                errorResolutionPendingIntent.send();
            }
        } catch (PendingIntent.CanceledException e10) {
            e10.printStackTrace();
        }
    }

    private static boolean c() {
        y a10 = f4.f10638a.a(o3.f10882b, "com.google.android.gms", 128);
        if (!a10.b() || a10.a() == null) {
            return false;
        }
        return !((String) a10.a().applicationInfo.loadLabel(o3.f10882b.getPackageManager())).equals("Market");
    }

    static void d() {
        if (OSUtils.B() && c() && !o3.X() && !z3.b(z3.f11153a, "GT_DO_NOT_SHOW_MISSING_GPS", false)) {
            OSUtils.S(new a());
        }
    }
}
