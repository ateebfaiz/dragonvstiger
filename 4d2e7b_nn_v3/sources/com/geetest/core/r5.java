package com.geetest.core;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.geetest.core.e5;
import com.geetest.core.x5;

public class r5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6166a;

    public class a implements x5.a {
        public a(r5 r5Var) {
        }

        public String a(IBinder iBinder) throws d5, RemoteException {
            e5 e5Var;
            int i10 = e5.a.f5967a;
            if (iBinder == null) {
                e5Var = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof e5)) {
                    e5Var = new e5.a.C0077a(iBinder);
                } else {
                    e5Var = (e5) queryLocalInterface;
                }
            }
            if (e5Var != null) {
                return e5Var.a();
            }
            throw new d5("IdsSupplier is null");
        }
    }

    public r5(Context context) {
        this.f6166a = context;
    }

    public boolean a() {
        Context context = this.f6166a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.android.creator", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f6166a != null && b5Var != null) {
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            x5.a(this.f6166a, intent, b5Var, new a(this));
        }
    }
}
