package com.sensorsdata.analytics.android.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.sensorsdata.analytics.android.sdk.SALog;

public class SASpUtils {
    private static final String TAG = "SA.SASpUtils";
    private static ISharedPreferencesProvider mSharedPreferencesProvider;

    public interface ISharedPreferencesProvider {
        SharedPreferences createSharedPreferences(Context context, String str, int i10);
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i10) {
        SharedPreferences createSharedPreferences;
        ISharedPreferencesProvider iSharedPreferencesProvider = mSharedPreferencesProvider;
        if (iSharedPreferencesProvider == null || (createSharedPreferences = iSharedPreferencesProvider.createSharedPreferences(context, str, i10)) == null) {
            return context.getSharedPreferences(str, i10);
        }
        SALog.i(TAG, "create SharedPreferences by user default, file name is: " + str);
        return createSharedPreferences;
    }

    public static void setSharedPreferencesProvider(ISharedPreferencesProvider iSharedPreferencesProvider) {
        mSharedPreferencesProvider = iSharedPreferencesProvider;
    }
}
