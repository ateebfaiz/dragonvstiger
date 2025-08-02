package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.games.paddleboat.GameControllerManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import q5.e0;

public final class FacebookContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19517a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f19518b = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public final String a(String str, UUID uuid, String str2) {
            m.f(uuid, "callId");
            b0 b0Var = b0.f709a;
            String format = String.format("%s%s/%s/%s", Arrays.copyOf(new Object[]{"content://com.facebook.app.FacebookContentProvider", str, uuid.toString(), str2}, 4));
            m.e(format, "java.lang.String.format(format, *args)");
            return format;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String name = FacebookContentProvider.class.getName();
        m.e(name, "FacebookContentProvider::class.java.name");
        f19517a = name;
    }

    private final Pair a(Uri uri) {
        try {
            String path = uri.getPath();
            if (path != null) {
                String substring = path.substring(1);
                m.e(substring, "(this as java.lang.String).substring(startIndex)");
                Object[] array = j.v0(substring, new String[]{DomExceptionUtils.SEPARATOR}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    String str = strArr[0];
                    String str2 = strArr[1];
                    if (!"..".contentEquals(str) && !"..".contentEquals(str2)) {
                        return new Pair(UUID.fromString(str), str2);
                    }
                    throw new Exception();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Exception unused) {
            return null;
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
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        m.f(uri, "uri");
        m.f(str, "mode");
        Pair a10 = a(uri);
        if (a10 != null) {
            try {
                File j10 = e0.j((UUID) a10.first, (String) a10.second);
                if (j10 != null) {
                    return ParcelFileDescriptor.open(j10, GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
                }
                throw new FileNotFoundException();
            } catch (FileNotFoundException e10) {
                String str2 = f19517a;
                Log.e(str2, "Got unexpected exception:" + e10);
                throw e10;
            }
        } else {
            throw new FileNotFoundException();
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
