package com.geetest.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.geetest.core.k5;
import com.geetest.core.x5;

public class y5 extends z5 {

    /* renamed from: c  reason: collision with root package name */
    public final Context f6219c;

    public class a implements x5.a {
        public a() {
        }

        public String a(IBinder iBinder) throws d5, RemoteException {
            try {
                return y5.this.a(iBinder);
            } catch (RemoteException | d5 e10) {
                throw e10;
            } catch (Exception e11) {
                throw new d5((Throwable) e11);
            }
        }
    }

    public y5(Context context) {
        super(context);
        this.f6219c = context;
    }

    public String a(IBinder iBinder, String str, String str2) throws RemoteException, d5 {
        k5 k5Var;
        int i10 = k5.a.f6060b;
        if (iBinder == null) {
            k5Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.stdid.IStdID");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof k5)) {
                k5Var = new k5.a.C0083a(iBinder);
            } else {
                k5Var = (k5) queryLocalInterface;
            }
        }
        if (k5Var != null) {
            return k5Var.a(str, str2, "OUID");
        }
        throw new d5("IStdID is null");
    }

    public boolean a() {
        Context context = this.f6219c;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.coloros.mcs", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f6219c != null && b5Var != null) {
            Intent intent = new Intent("action.com.oplus.stdid.ID_SERVICE");
            intent.setComponent(new ComponentName("com.coloros.mcs", "com.oplus.stdid.IdentifyService"));
            x5.a(this.f6219c, intent, b5Var, new a());
        }
    }
}
