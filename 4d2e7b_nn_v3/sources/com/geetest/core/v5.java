package com.geetest.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.geetest.core.g5;
import com.geetest.core.x5;

public class v5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6196a;

    public class a implements x5.a {
        public a(v5 v5Var) {
        }

        public String a(IBinder iBinder) throws d5, RemoteException {
            g5 g5Var;
            int i10 = g5.a.f5985a;
            if (iBinder == null) {
                g5Var = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof g5)) {
                    g5Var = new g5.a.C0079a(iBinder);
                } else {
                    g5Var = (g5) queryLocalInterface;
                }
            }
            if (g5Var == null) {
                throw new d5("MsaIdInterface is null");
            } else if (g5Var.d()) {
                return g5Var.a();
            } else {
                throw new d5("MsaIdInterface#isSupported return false");
            }
        }
    }

    public v5(Context context) {
        this.f6196a = context;
    }

    public boolean a() {
        Context context = this.f6196a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f6196a != null && b5Var != null) {
            try {
                Intent intent = new Intent("com.bun.msa.action.start.service");
                intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
                intent.putExtra("com.bun.msa.param.pkgname", this.f6196a.getPackageName());
                if (Build.VERSION.SDK_INT < 26) {
                    this.f6196a.startService(intent);
                } else {
                    ComponentName unused = this.f6196a.startForegroundService(intent);
                }
            } catch (Exception unused2) {
            }
            Intent intent2 = new Intent("com.bun.msa.action.bindto.service");
            intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent2.putExtra("com.bun.msa.param.pkgname", this.f6196a.getPackageName());
            x5.a(this.f6196a, intent2, b5Var, new a(this));
        }
    }
}
