package org.cocos2dx.javascript;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {
    private static final String SHARED_PREF_NAME = "MySharedPref";
    private static SPUtil instance;
    private final SharedPreferences sharedPreferences;

    private SPUtil(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, 0);
    }

    public static synchronized SPUtil getInstance(Context context) {
        SPUtil sPUtil;
        synchronized (SPUtil.class) {
            try {
                if (instance == null) {
                    instance = new SPUtil(context);
                }
                sPUtil = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sPUtil;
    }

    public void clear() {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.clear();
        edit.apply();
    }

    public int getInt(String str, int i10) {
        return this.sharedPreferences.getInt(str, i10);
    }

    public String getString(String str, String str2) {
        return this.sharedPreferences.getString(str, str2);
    }

    public void saveInt(String str, int i10) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putInt(str, i10);
        edit.apply();
    }

    public void saveString(String str, String str2) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
