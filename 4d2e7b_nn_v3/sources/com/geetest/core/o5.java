package com.geetest.core;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.geetest.core.h5;
import com.geetest.core.x5;

public class o5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6119a;

    public class a implements x5.a {
        public a() {
        }

        public String a(IBinder iBinder) throws d5, RemoteException {
            h5 h5Var;
            int i10 = h5.a.f6011a;
            if (iBinder == null) {
                h5Var = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof h5)) {
                    h5Var = new h5.a.C0080a(iBinder);
                } else {
                    h5Var = (h5) queryLocalInterface;
                }
            }
            if (h5Var != null) {
                return h5Var.a(o5.this.f6119a.getPackageName());
            }
            throw new d5("IDeviceIdManager is null");
        }
    }

    public o5(Context context) {
        if (context instanceof Application) {
            this.f6119a = context;
        } else {
            this.f6119a = context.getApplicationContext();
        }
    }

    public boolean a() {
        Context context = this.f6119a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f6119a != null && b5Var != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            x5.a(this.f6119a, intent, b5Var, new a());
        }
    }
}
