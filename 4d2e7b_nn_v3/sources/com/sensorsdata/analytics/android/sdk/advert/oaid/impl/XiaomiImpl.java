package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID;
import java.lang.reflect.InvocationTargetException;

public class XiaomiImpl implements IRomOAID {
    private static final String TAG = "SA.OAIDFactory";
    private final Context mContext;
    private Class<?> mIdProviderClass;
    private Object mIdProviderImpl;

    @SuppressLint({"PrivateApi"})
    public XiaomiImpl(Context context) {
        this.mContext = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.mIdProviderClass = cls;
            this.mIdProviderImpl = cls.newInstance();
        } catch (Throwable th) {
            SALog.i(TAG, th);
        }
    }

    private String getOAID() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.mIdProviderClass.getMethod("getOAID", new Class[]{Context.class}).invoke(this.mIdProviderImpl, new Object[]{this.mContext});
    }

    public String getRomOAID() {
        if (this.mIdProviderClass == null || this.mIdProviderImpl == null) {
            return null;
        }
        try {
            return getOAID();
        } catch (Throwable th) {
            SALog.i(TAG, th);
            return null;
        }
    }

    public boolean isSupported() {
        if (this.mIdProviderImpl != null) {
            return true;
        }
        return false;
    }
}
