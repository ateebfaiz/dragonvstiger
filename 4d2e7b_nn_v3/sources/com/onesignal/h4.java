package com.onesignal;

import android.content.Context;
import androidx.work.WorkRequest;
import com.amazon.device.messaging.ADM;
import com.onesignal.g4;
import com.onesignal.o3;

public class h4 implements g4 {

    /* renamed from: a  reason: collision with root package name */
    private static g4.a f10671a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static boolean f10672b;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10673a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g4.a f10674b;

        a(Context context, g4.a aVar) {
            this.f10673a = context;
            this.f10674b = aVar;
        }

        public void run() {
            ADM adm = new ADM(this.f10673a);
            String registrationId = adm.getRegistrationId();
            if (registrationId == null) {
                adm.startRegister();
            } else {
                o3.v vVar = o3.v.DEBUG;
                o3.a(vVar, "ADM Already registered with ID:" + registrationId);
                this.f10674b.a(registrationId, 1);
            }
            try {
                Thread.sleep(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            } catch (InterruptedException unused) {
            }
            if (!h4.f10672b) {
                o3.a(o3.v.ERROR, "com.onesignal.ADMMessageHandler timed out, please check that your have the receiver, service, and your package name matches(NOTE: Case Sensitive) per the OneSignal instructions.");
                h4.c((String) null);
            }
        }
    }

    public static void c(String str) {
        g4.a aVar = f10671a;
        if (aVar != null) {
            f10672b = true;
            aVar.a(str, 1);
        }
    }

    public void a(Context context, String str, g4.a aVar) {
        f10671a = aVar;
        new Thread(new a(context, aVar)).start();
    }
}
