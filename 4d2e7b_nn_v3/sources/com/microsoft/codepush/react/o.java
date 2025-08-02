package com.microsoft.codepush.react;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f10249a;

    public o(Context context) {
        this.f10249a = context.getSharedPreferences("CodePush", 0);
    }

    public JSONArray a() {
        String string = this.f10249a.getString("CODE_PUSH_FAILED_UPDATES", (String) null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            JSONArray jSONArray = new JSONArray();
            this.f10249a.edit().putString("CODE_PUSH_FAILED_UPDATES", jSONArray.toString()).commit();
            return jSONArray;
        }
    }

    public JSONObject b() {
        String string = this.f10249a.getString("LATEST_ROLLBACK_INFO", (String) null);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            k.h("Unable to parse latest rollback metadata " + string + " stored in SharedPreferences");
            return null;
        }
    }

    public JSONObject c() {
        String string = this.f10249a.getString("CODE_PUSH_PENDING_UPDATE", (String) null);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            k.h("Unable to parse pending update metadata " + string + " stored in SharedPreferences");
            return null;
        }
    }

    public boolean d(String str) {
        JSONArray a10 = a();
        if (str != null) {
            int i10 = 0;
            while (i10 < a10.length()) {
                try {
                    if (str.equals(a10.getJSONObject(i10).getString("packageHash"))) {
                        return true;
                    }
                    i10++;
                } catch (JSONException e10) {
                    throw new g("Unable to read failedUpdates data stored in SharedPreferences.", e10);
                }
            }
        }
        return false;
    }

    public boolean e(String str) {
        JSONObject c10 = c();
        if (c10 != null) {
            try {
                if (c10.getBoolean("isLoading") || (str != null && !c10.getString("hash").equals(str))) {
                    return false;
                }
                return true;
            } catch (JSONException e10) {
                throw new g("Unable to read pending update metadata in isPendingUpdate.", e10);
            }
        }
        return false;
    }

    public void f() {
        this.f10249a.edit().remove("CODE_PUSH_FAILED_UPDATES").commit();
    }

    public void g() {
        this.f10249a.edit().remove("CODE_PUSH_PENDING_UPDATE").commit();
    }

    public void h(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            if (!d(jSONObject.getString("packageHash"))) {
                String string = this.f10249a.getString("CODE_PUSH_FAILED_UPDATES", (String) null);
                if (string == null) {
                    jSONArray = new JSONArray();
                } else {
                    try {
                        jSONArray = new JSONArray(string);
                    } catch (JSONException e10) {
                        throw new d("Unable to parse failed updates information " + string + " stored in SharedPreferences", (Throwable) e10);
                    }
                }
                jSONArray.put(jSONObject);
                this.f10249a.edit().putString("CODE_PUSH_FAILED_UPDATES", jSONArray.toString()).commit();
            }
        } catch (JSONException e11) {
            throw new g("Unable to read package hash from package.", e11);
        }
    }

    public void i(String str, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hash", str);
            jSONObject.put("isLoading", z10);
            this.f10249a.edit().putString("CODE_PUSH_PENDING_UPDATE", jSONObject.toString()).commit();
        } catch (JSONException e10) {
            throw new g("Unable to save pending update.", e10);
        }
    }

    public void j(String str) {
        JSONObject b10 = b();
        int i10 = 0;
        if (b10 != null) {
            try {
                if (b10.getString("packageHash").equals(str)) {
                    i10 = b10.getInt("count");
                }
            } catch (JSONException unused) {
                k.h("Unable to parse latest rollback info.");
            }
        } else {
            b10 = new JSONObject();
        }
        try {
            b10.put("packageHash", str);
            b10.put("time", System.currentTimeMillis());
            b10.put("count", i10 + 1);
            this.f10249a.edit().putString("LATEST_ROLLBACK_INFO", b10.toString()).commit();
        } catch (JSONException e10) {
            throw new g("Unable to save latest rollback info.", e10);
        }
    }
}
