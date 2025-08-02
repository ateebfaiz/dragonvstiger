package com.geetest.core;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.geetest.core.i5;
import com.geetest.core.x5;

public class s5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6180a;

    public class a implements x5.a {
        public a(s5 s5Var) {
        }

        public String a(IBinder iBinder) throws d5, RemoteException {
            i5 i5Var;
            int i10 = i5.a.f6021a;
            if (iBinder == null) {
                i5Var = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof i5)) {
                    i5Var = new i5.a.C0081a(iBinder);
                } else {
                    i5Var = (i5) queryLocalInterface;
                }
            }
            i5Var.a(true);
            return i5Var.c();
        }
    }

    public s5(Context context) {
        this.f6180a = context;
    }

    public boolean a() {
        Context context = this.f6180a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.android.vending", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f6180a != null && b5Var != null) {
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            x5.a(this.f6180a, intent, b5Var, new a(this));
        }
    }
}
