package com.geetest.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.geetest.core.f5;
import com.geetest.core.x5;

public class n5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6115a;

    public class a implements x5.a {
        public a(n5 n5Var) {
        }

        public String a(IBinder iBinder) throws d5, RemoteException {
            f5 f5Var;
            int i10 = f5.a.f5977a;
            if (iBinder == null) {
                f5Var = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof f5)) {
                    f5Var = new f5.a.C0078a(iBinder);
                } else {
                    f5Var = (f5) queryLocalInterface;
                }
            }
            if (f5Var == null) {
                throw new d5("IDidAidlInterface is null");
            } else if (f5Var.b()) {
                return f5Var.a();
            } else {
                throw new d5("IDidAidlInterface#isSupport return false");
            }
        }
    }

    public n5(Context context) {
        this.f6115a = context;
    }

    public boolean a() {
        Context context = this.f6115a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f6115a != null && b5Var != null) {
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            x5.a(this.f6115a, intent, b5Var, new a(this));
        }
    }
}
