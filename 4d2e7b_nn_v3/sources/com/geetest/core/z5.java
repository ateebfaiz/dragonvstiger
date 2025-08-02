package com.geetest.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.geetest.core.j5;
import com.geetest.core.x5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class z5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6236a;

    /* renamed from: b  reason: collision with root package name */
    public String f6237b;

    public class a implements x5.a {
        public a() {
        }

        public String a(IBinder iBinder) throws d5, RemoteException {
            try {
                return z5.this.a(iBinder);
            } catch (RemoteException | d5 e10) {
                throw e10;
            } catch (Exception e11) {
                throw new d5((Throwable) e11);
            }
        }
    }

    public z5(Context context) {
        if (context instanceof Application) {
            this.f6236a = context;
        } else {
            this.f6236a = context.getApplicationContext();
        }
    }

    public String a(IBinder iBinder, String str, String str2) throws RemoteException, d5 {
        j5 j5Var;
        int i10 = j5.a.f6043a;
        if (iBinder == null) {
            j5Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof j5)) {
                j5Var = new j5.a.C0082a(iBinder);
            } else {
                j5Var = (j5) queryLocalInterface;
            }
        }
        if (j5Var != null) {
            return j5Var.a(str, str2, "OUID");
        }
        throw new d5("IOpenID is null");
    }

    public boolean a() {
        Context context = this.f6236a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f6236a != null && b5Var != null) {
            Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            x5.a(this.f6236a, intent, b5Var, new a());
        }
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public String a(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, d5 {
        String packageName = this.f6236a.getPackageName();
        String str = this.f6237b;
        if (str != null) {
            return a(iBinder, packageName, str);
        }
        byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f6236a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : digest) {
            sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
        }
        String sb3 = sb2.toString();
        this.f6237b = sb3;
        return a(iBinder, packageName, sb3);
    }
}
