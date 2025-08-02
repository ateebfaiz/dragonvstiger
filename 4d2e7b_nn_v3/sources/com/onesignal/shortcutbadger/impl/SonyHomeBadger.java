package com.onesignal.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;

public class SonyHomeBadger implements ra.a {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f11056a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");

    /* renamed from: b  reason: collision with root package name */
    private AsyncQueryHandler f11057b;

    class a extends AsyncQueryHandler {
        a(ContentResolver contentResolver) {
            super(contentResolver);
        }
    }

    private ContentValues c(int i10, ComponentName componentName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf(i10));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        return contentValues;
    }

    private static void d(Context context, ComponentName componentName, int i10) {
        boolean z10;
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i10));
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", z10);
        context.sendBroadcast(intent);
    }

    private void e(Context context, ComponentName componentName, int i10) {
        if (i10 >= 0) {
            ContentValues c10 = c(i10, componentName);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f11057b == null) {
                    this.f11057b = new a(context.getApplicationContext().getContentResolver());
                }
                f(c10);
                return;
            }
            g(context, c10);
        }
    }

    private void f(ContentValues contentValues) {
        this.f11057b.startInsert(0, (Object) null, this.f11056a, contentValues);
    }

    private void g(Context context, ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.f11056a, contentValues);
    }

    private static boolean h(Context context) {
        if (context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null) {
            return true;
        }
        return false;
    }

    public List a() {
        return Arrays.asList(new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }

    public void b(Context context, ComponentName componentName, int i10) {
        if (h(context)) {
            e(context, componentName, i10);
        } else {
            d(context, componentName, i10);
        }
    }
}
