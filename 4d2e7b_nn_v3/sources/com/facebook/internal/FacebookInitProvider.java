package com.facebook.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.o;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class FacebookInitProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20336a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f20337b = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = FacebookInitProvider.class.getSimpleName();
        m.e(simpleName, "FacebookInitProvider::class.java.simpleName");
        f20336a = simpleName;
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
        try {
            Context context = getContext();
            if (context != null) {
                o.G(context);
                return false;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Exception e10) {
            Log.i(f20336a, "Failed to auto initialize the Facebook SDK", e10);
            return false;
        }
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
