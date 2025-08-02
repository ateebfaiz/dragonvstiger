package com.geetest.core;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Objects;

public class u5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6192a;

    public u5(Context context) {
        this.f6192a = context;
    }

    public boolean a() {
        Context context = this.f6192a;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        Cursor query;
        if (this.f6192a != null && b5Var != null) {
            try {
                query = this.f6192a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), (String[]) null, (String) null, new String[]{"oaid"}, (String) null);
                Objects.requireNonNull(query);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new d5("OAID query failed");
                }
                z4 z4Var = (z4) b5Var;
                z4Var.f6234a[0] = string;
                z4Var.f6235b.countDown();
                query.close();
                return;
            } catch (Exception unused) {
                ((z4) b5Var).f6235b.countDown();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }
}
