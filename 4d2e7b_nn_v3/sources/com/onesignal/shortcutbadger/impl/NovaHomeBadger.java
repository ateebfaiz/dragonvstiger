package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.util.Arrays;
import java.util.List;
import ra.a;

public class NovaHomeBadger implements a {
    public List a() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }

    public void b(Context context, ComponentName componentName, int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", componentName.getPackageName() + DomExceptionUtils.SEPARATOR + componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i10));
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }
}
