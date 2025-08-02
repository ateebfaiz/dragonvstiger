package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID;

public class HuaweiImpl implements IRomOAID {
    private static final String TAG = "SA.HuaweiImpl";
    private final Context mContext;
    private final OAIDService mService = new OAIDService();

    static final class HuaWeiInterface implements IInterface {
        private final IBinder iBinder;

        public IBinder asBinder() {
            return this.iBinder;
        }

        public String getOAID() {
            String str = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str;
            } catch (Throwable th) {
                SALog.i(HuaweiImpl.TAG, th);
                return str;
            }
        }

        private HuaWeiInterface(IBinder iBinder2) {
            this.iBinder = iBinder2;
        }
    }

    public HuaweiImpl(Context context) {
        this.mContext = context;
    }

    private String realLoadOaid(String str) {
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(str);
            if (this.mContext.bindService(intent, this.mService, 1)) {
                return new HuaWeiInterface(OAIDService.BINDER_QUEUE.take()).getOAID();
            }
            return "";
        } catch (Throwable th) {
            SALog.i(TAG, th);
            return "";
        }
    }

    public String getRomOAID() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(this.mContext.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    SALog.i(TAG, "Get oaid from global settings");
                    return string;
                }
            } catch (Throwable th) {
                SALog.i(TAG, th);
            }
        }
        String[] strArr = {"com.huawei.hwid", "com.huawei.hwid.tv", "com.huawei.hms"};
        String str = null;
        for (int i10 = 0; i10 < 3; i10++) {
            String str2 = strArr[i10];
            if (TextUtils.isEmpty(str)) {
                str = realLoadOaid(str2);
            }
        }
        return str;
    }

    public boolean isSupported() {
        return true;
    }
}
