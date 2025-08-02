package com.flyjingfish.android_aop_core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class AndroidAopContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5737a = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Context f5738b;

    public static final class a {
        private a() {
        }

        public final Context a() {
            Context a10 = AndroidAopContentProvider.f5738b;
            if (a10 != null) {
                return a10;
            }
            throw new IllegalStateException("AndroidAopContentProvider not init");
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        m.f(uri, "uri");
        return 0;
    }

    public String getType(Uri uri) {
        m.f(uri, "uri");
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        m.f(uri, "uri");
        return null;
    }

    public boolean onCreate() {
        Context context = getContext();
        m.c(context);
        f5738b = context;
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        m.f(uri, "uri");
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        m.f(uri, "uri");
        return 0;
    }
}
