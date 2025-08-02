package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import ra.a;
import sa.b;

public class SamsungHomeBadger implements a {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f11054b = {"_id", "class"};

    /* renamed from: a  reason: collision with root package name */
    private DefaultBadger f11055a = new DefaultBadger();

    private ContentValues c(ComponentName componentName, int i10, boolean z10) {
        ContentValues contentValues = new ContentValues();
        if (z10) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i10));
        return contentValues;
    }

    public List a() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }

    public void b(Context context, ComponentName componentName, int i10) {
        DefaultBadger defaultBadger = this.f11055a;
        if (defaultBadger == null || !defaultBadger.c(context)) {
            Uri parse = Uri.parse("content://com.sec.badge/apps?notify=true");
            ContentResolver contentResolver = context.getContentResolver();
            try {
                Cursor query = contentResolver.query(parse, f11054b, "package=?", new String[]{componentName.getPackageName()}, (String) null);
                if (query != null) {
                    String className = componentName.getClassName();
                    boolean z10 = false;
                    while (query.moveToNext()) {
                        contentResolver.update(parse, c(componentName, i10, false), "_id=?", new String[]{String.valueOf(query.getInt(0))});
                        if (className.equals(query.getString(query.getColumnIndex("class")))) {
                            z10 = true;
                        }
                    }
                    if (!z10) {
                        contentResolver.insert(parse, c(componentName, i10, true));
                    }
                }
                b.a(query);
            } catch (Throwable th) {
                b.a((Cursor) null);
                throw th;
            }
        } else {
            this.f11055a.b(context, componentName, i10);
        }
    }
}
