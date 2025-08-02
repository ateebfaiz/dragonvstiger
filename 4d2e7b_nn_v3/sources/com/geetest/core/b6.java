package com.geetest.core;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.util.Objects;

public class b6 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5937a;

    public b6(Context context) {
        this.f5937a = context;
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return c.a("persist.sys.identifierid.supported", "0").equals("1");
    }

    public void a(b5 b5Var) {
        Cursor query;
        if (this.f5937a != null && b5Var != null) {
            try {
                query = this.f5937a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), (String[]) null, (String) null, (String[]) null, (String) null);
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
