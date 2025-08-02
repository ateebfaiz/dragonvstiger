package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.webkit.ProxyConfig;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class n0 {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f9260a;

    static class a {

        /* renamed from: d  reason: collision with root package name */
        private static final long f9261d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a  reason: collision with root package name */
        final String f9262a;

        /* renamed from: b  reason: collision with root package name */
        final String f9263b;

        /* renamed from: c  reason: collision with root package name */
        final long f9264c;

        private a(String str, String str2, long j10) {
            this.f9262a = str;
            this.f9263b = str2;
            this.f9264c = j10;
        }

        static String a(String str, String str2, long j10) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j10);
                return jSONObject.toString();
            } catch (JSONException e10) {
                Log.w(Constants.TAG, "Failed to encode token: " + e10);
                return null;
            }
        }

        static a c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, (String) null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e10) {
                Log.w(Constants.TAG, "Failed to parse token: " + e10);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(String str) {
            if (System.currentTimeMillis() > this.f9264c + f9261d || !str.equals(this.f9263b)) {
                return true;
            }
            return false;
        }
    }

    public n0(Context context) {
        this.f9260a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a(context, "com.google.android.gms.appid-no-backup");
    }

    private void a(Context context, String str) {
        File file = new File(ContextCompat.getNoBackupFilesDir(context), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !f()) {
                    Log.i(Constants.TAG, "App restored, clearing state");
                    c();
                }
            } catch (IOException e10) {
                if (Log.isLoggable(Constants.TAG, 3)) {
                    Log.d(Constants.TAG, "Error creating file in no backup dir: " + e10.getMessage());
                }
            }
        }
    }

    private String b(String str, String str2) {
        return str + "|T|" + str2 + "|" + ProxyConfig.MATCH_ALL_SCHEMES;
    }

    public synchronized void c() {
        this.f9260a.edit().clear().commit();
    }

    public synchronized void d(String str, String str2) {
        String b10 = b(str, str2);
        SharedPreferences.Editor edit = this.f9260a.edit();
        edit.remove(b10);
        edit.commit();
    }

    public synchronized a e(String str, String str2) {
        return a.c(this.f9260a.getString(b(str, str2), (String) null));
    }

    public synchronized boolean f() {
        return this.f9260a.getAll().isEmpty();
    }

    public synchronized void g(String str, String str2, String str3, String str4) {
        String a10 = a.a(str3, str4, System.currentTimeMillis());
        if (a10 != null) {
            SharedPreferences.Editor edit = this.f9260a.edit();
            edit.putString(b(str, str2), a10);
            edit.commit();
        }
    }
}
