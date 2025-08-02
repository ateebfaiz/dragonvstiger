package com.onesignal;

import android.content.Context;
import com.onesignal.g4;
import com.onesignal.o3;
import java.io.IOException;

abstract class i4 implements g4 {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static int f10696d = 5;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static int f10697e = 10000;

    /* renamed from: a  reason: collision with root package name */
    private g4.a f10698a;

    /* renamed from: b  reason: collision with root package name */
    private Thread f10699b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10700c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10701a;

        a(String str) {
            this.f10701a = str;
        }

        public void run() {
            int i10 = 0;
            while (i10 < i4.f10696d && !i4.this.e(this.f10701a, i10)) {
                i10++;
                OSUtils.V(i4.f10697e * i10);
            }
        }
    }

    i4() {
    }

    /* access modifiers changed from: private */
    public boolean e(String str, int i10) {
        try {
            String g10 = g(str);
            o3.v vVar = o3.v.INFO;
            o3.a(vVar, "Device registered, push token = " + g10);
            this.f10698a.a(g10, 1);
            return true;
        } catch (IOException e10) {
            int j10 = j(e10);
            String l10 = OSUtils.l(e10);
            if ("SERVICE_NOT_AVAILABLE".equals(l10) || "AUTHENTICATION_FAILED".equals(l10)) {
                Exception exc = new Exception(e10);
                if (i10 >= f10696d - 1) {
                    o3.v vVar2 = o3.v.ERROR;
                    o3.b(vVar2, "Retry count of " + f10696d + " exceed! Could not get a " + f() + " Token.", exc);
                    return false;
                }
                o3.v vVar3 = o3.v.INFO;
                o3.b(vVar3, "'Google Play services' returned " + l10 + " error. Current retry count: " + i10, exc);
                if (i10 != 2) {
                    return false;
                }
                this.f10698a.a((String) null, j10);
                this.f10700c = true;
                return true;
            }
            Exception exc2 = new Exception(e10);
            o3.v vVar4 = o3.v.ERROR;
            o3.b(vVar4, "Error Getting " + f() + " Token", exc2);
            if (!this.f10700c) {
                this.f10698a.a((String) null, j10);
            }
            return true;
        } catch (Throwable th) {
            Exception exc3 = new Exception(th);
            int j11 = j(th);
            o3.v vVar5 = o3.v.ERROR;
            o3.b(vVar5, "Unknown error getting " + f() + " Token", exc3);
            this.f10698a.a((String) null, j11);
            return true;
        }
    }

    private void h(String str) {
        try {
            if (OSUtils.D()) {
                k(str);
                return;
            }
            a0.d();
            o3.a(o3.v.ERROR, "'Google Play services' app not installed or disabled on the device.");
            this.f10698a.a((String) null, -7);
        } catch (Throwable th) {
            o3.v vVar = o3.v.ERROR;
            o3.b(vVar, "Could not register with " + f() + " due to an issue with your AndroidManifest.xml or with 'Google Play services'.", th);
            this.f10698a.a((String) null, -8);
        }
    }

    private boolean i(String str, g4.a aVar) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (Throwable unused) {
            o3.a(o3.v.ERROR, "Missing Google Project number!\nPlease enter a Google Project number / Sender ID on under App Settings > Android > Configuration on the OneSignal dashboard.");
            aVar.a((String) null, -6);
            return false;
        }
    }

    private static int j(Throwable th) {
        String l10 = OSUtils.l(th);
        if (!(th instanceof IOException)) {
            return -12;
        }
        if ("SERVICE_NOT_AVAILABLE".equals(l10)) {
            return -9;
        }
        if ("AUTHENTICATION_FAILED".equals(l10)) {
            return -29;
        }
        return -11;
    }

    private synchronized void k(String str) {
        Thread thread = this.f10699b;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new a(str));
            this.f10699b = thread2;
            thread2.start();
        }
    }

    public void a(Context context, String str, g4.a aVar) {
        this.f10698a = aVar;
        if (i(str, aVar)) {
            h(str);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract String f();

    /* access modifiers changed from: package-private */
    public abstract String g(String str);
}
