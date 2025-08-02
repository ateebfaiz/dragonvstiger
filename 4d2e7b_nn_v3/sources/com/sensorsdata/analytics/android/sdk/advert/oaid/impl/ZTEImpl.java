package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID;
import java.lang.reflect.Constructor;

public class ZTEImpl implements IRomOAID {
    private static final String ID_PACKAGE = "com.mdid.msa";
    private static final String TAG = "SA.ZTEImpl";
    private static final String ZTE_MANAGER = "android.app.ZteDeviceIdentifyManager";
    private final Context mContext;
    private final OAIDService mService = new OAIDService();

    static class ZTEInterface implements IInterface {
        private final IBinder mIBinder;

        ZTEInterface(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        public IBinder asBinder() {
            return this.mIBinder;
        }

        public String getOAID() {
            String str = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                this.mIBinder.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str;
            } catch (Throwable th) {
                SALog.i(ZTEImpl.TAG, th);
                return str;
            }
        }
    }

    ZTEImpl(Context context) {
        this.mContext = context;
    }

    private String getOAID29(Context context) {
        String str = null;
        try {
            String packageName = context.getPackageName();
            startMsaklServer(packageName, context);
            Intent intent = new Intent();
            intent.setClassName(ID_PACKAGE, "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", packageName);
            if (!context.bindService(intent, this.mService, 1)) {
                return null;
            }
            str = new ZTEInterface(OAIDService.BINDER_QUEUE.take()).getOAID();
            context.unbindService(this.mService);
            return str;
        } catch (Throwable th) {
            SALog.i(TAG, th);
        }
    }

    @SuppressLint({"PrivateApi"})
    private static String getOAID30(Context context) {
        Class<Context> cls = Context.class;
        try {
            Class<?> cls2 = Class.forName(ZTE_MANAGER);
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(new Class[]{cls});
            if (declaredConstructor == null) {
                return null;
            }
            Object newInstance = declaredConstructor.newInstance(new Object[]{context});
            return (String) cls2.getDeclaredMethod("getOAID", new Class[]{cls}).invoke(newInstance, new Object[]{context});
        } catch (Throwable th) {
            SALog.i(TAG, th);
            return null;
        }
    }

    private static void startMsaklServer(String str, Context context) {
        Intent intent = new Intent();
        intent.setClassName(ID_PACKAGE, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Throwable th) {
            SALog.i(TAG, th);
        }
    }

    public String bindZTEServiceGetOAID(Context context) {
        if (Build.VERSION.SDK_INT <= 29) {
            return getOAID29(context);
        }
        return getOAID30(context);
    }

    public String getRomOAID() {
        return bindZTEServiceGetOAID(this.mContext);
    }

    public boolean isSupported() {
        return true;
    }
}
