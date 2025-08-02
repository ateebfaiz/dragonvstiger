package com.geetest.core;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.geetest.core.m5;
import com.geetest.core.x5;

public class t5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6181a;

    public class a implements x5.a {
        public a(t5 t5Var) {
        }

        public String a(IBinder iBinder) throws d5, RemoteException {
            m5 m5Var;
            int i10 = m5.a.f6079a;
            if (iBinder == null) {
                m5Var = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof m5)) {
                    m5Var = new m5.a.C0085a(iBinder);
                } else {
                    m5Var = (m5) queryLocalInterface;
                }
            }
            if (m5Var == null) {
                throw new d5("IDeviceidInterface is null");
            } else if (m5Var.b()) {
                return m5Var.a();
            } else {
                throw new d5("IDeviceidInterface#isSupport return false");
            }
        }
    }

    public t5(Context context) {
        this.f6181a = context;
    }

    public boolean a() {
        Context context = this.f6181a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f6181a != null && b5Var != null) {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            x5.a(this.f6181a, intent, b5Var, new a(this));
        }
    }
}
