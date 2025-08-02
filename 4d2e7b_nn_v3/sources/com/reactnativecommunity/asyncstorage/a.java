package com.reactnativecommunity.asyncstorage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONObject;

public abstract class a {
    static String a(int i10) {
        String[] strArr = new String[i10];
        Arrays.fill(strArr, "?");
        return "key IN (" + TextUtils.join(", ", strArr) + ")";
    }

    static String[] b(ReadableArray readableArray, int i10, int i11) {
        String[] strArr = new String[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            strArr[i12] = readableArray.getString(i10 + i12);
        }
        return strArr;
    }

    private static void c(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject2.optJSONObject(next);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(next);
            if (optJSONObject == null || optJSONObject2 == null) {
                jSONObject.put(next, jSONObject2.get(next));
            } else {
                c(optJSONObject2, optJSONObject);
                jSONObject.put(next, optJSONObject2);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static String d(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query("catalystLocalStorage", new String[]{"value"}, "key=?", new String[]{str}, (String) null, (String) null, (String) null);
        try {
            if (!query.moveToFirst()) {
                query.close();
                return null;
            }
            String string = query.getString(0);
            query.close();
            return string;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    static boolean e(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String d10 = d(sQLiteDatabase, str);
        if (d10 != null) {
            JSONObject jSONObject = new JSONObject(d10);
            c(jSONObject, new JSONObject(str2));
            str2 = jSONObject.toString();
        }
        return f(sQLiteDatabase, str, str2);
    }

    static boolean f(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        contentValues.put("value", str2);
        if (-1 != sQLiteDatabase.insertWithOnConflict("catalystLocalStorage", (String) null, contentValues, 5)) {
            return true;
        }
        return false;
    }
}
