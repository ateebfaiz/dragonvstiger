package com.geetest.core;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.geetest.core.l5;
import com.geetest.core.x5;

public class a6 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5923a;

    public class a implements x5.a {
        public a(a6 a6Var) {
        }

        public String a(IBinder iBinder) throws d5, RemoteException {
            l5 l5Var;
            int i10 = l5.a.f6068a;
            if (iBinder == null) {
                l5Var = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof l5)) {
                    l5Var = new l5.a.C0084a(iBinder);
                } else {
                    l5Var = (l5) queryLocalInterface;
                }
            }
            if (l5Var != null) {
                return l5Var.a();
            }
            throw new d5("IDeviceIdService is null");
        }
    }

    public a6(Context context) {
        this.f5923a = context;
    }

    public boolean a() {
        Context context = this.f5923a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f5923a != null && b5Var != null) {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            x5.a(this.f5923a, intent, b5Var, new a(this));
        }
    }
}
