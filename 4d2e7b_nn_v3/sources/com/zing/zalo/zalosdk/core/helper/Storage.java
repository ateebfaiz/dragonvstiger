package com.zing.zalo.zalosdk.core.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Storage {
    protected Context context;
    protected SharedPreferences localPref;

    public Storage(Context context2) {
        this.context = context2;
        this.localPref = PreferenceManager.getDefaultSharedPreferences(context2);
    }

    public static boolean getBoolean(Context context2, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context2).getBoolean(str, false);
    }

    public static void setBoolean(Context context2, String str, boolean z10) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context2).edit();
        edit.putBoolean(str, z10);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public int getInt(String str) {
        return this.localPref.getInt(str, 0);
    }

    /* access modifiers changed from: protected */
    public long getLong(String str) {
        return this.localPref.getLong(str, 0);
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        return this.localPref.getString(str, "");
    }

    /* access modifiers changed from: protected */
    public void setInt(String str, int i10) {
        SharedPreferences.Editor edit = this.localPref.edit();
        edit.putInt(str, i10);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public void setLong(String str, long j10) {
        SharedPreferences.Editor edit = this.localPref.edit();
        edit.putLong(str, j10);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public void setString(String str, String str2) {
        SharedPreferences.Editor edit = this.localPref.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
