package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID;

public class CoolpadImpl implements IRomOAID {
    private static final String TAG = "SA.CoolpadImpl";
    private final Context context;
    private final OAIDService service = new OAIDService();

    static class CoolpadInterface implements IInterface {
        private final IBinder mIBinder;

        CoolpadInterface(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        public IBinder asBinder() {
            return this.mIBinder;
        }

        public String getOAID(String str) {
            String str2 = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                obtain.writeString(str);
                this.mIBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                str2 = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str2;
            } catch (Throwable th) {
                SALog.i(CoolpadImpl.TAG, th);
                return str2;
            }
        }
    }

    public CoolpadImpl(Context context2) {
        this.context = context2;
    }

    public String getRomOAID() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            if (!this.context.bindService(intent, this.service, 1)) {
                return null;
            }
            String oaid = new CoolpadInterface(OAIDService.BINDER_QUEUE.take()).getOAID(this.context.getPackageName());
            this.context.unbindService(this.service);
            return oaid;
        } catch (Throwable th) {
            SALog.i(TAG, th);
            return null;
        }
    }

    public boolean isSupported() {
        return true;
    }
}
