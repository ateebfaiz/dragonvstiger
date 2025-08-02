package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID;

class MeizuImpl implements IRomOAID {
    private static final String TAG = "SA.MeizuImpl";
    private final Context mContext;

    public MeizuImpl(Context context) {
        this.mContext = context;
    }

    public String getRomOAID() {
        try {
            Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), (String[]) null, (String) null, new String[]{"oaid"}, (String) null);
            if (query == null || !query.moveToFirst()) {
                return null;
            }
            String string = query.getString(query.getColumnIndex("value"));
            SALog.i(TAG, "OAID query success: " + string);
            query.close();
            return string;
        } catch (Throwable th) {
            SALog.i(TAG, th);
            return null;
        }
    }

    public boolean isSupported() {
        return true;
    }
}
