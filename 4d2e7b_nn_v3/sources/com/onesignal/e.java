package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Arrays;
import kotlin.jvm.internal.m;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f10606a = new e();

    public interface a {
        void a();

        void b();
    }

    private e() {
    }

    /* access modifiers changed from: private */
    public static final void d(a aVar, DialogInterface dialogInterface, int i10) {
        m.f(aVar, "$callback");
        aVar.a();
    }

    /* access modifiers changed from: private */
    public static final void e(a aVar, DialogInterface dialogInterface, int i10) {
        m.f(aVar, "$callback");
        aVar.b();
    }

    public final void c(Activity activity, String str, String str2, a aVar) {
        m.f(activity, "activity");
        m.f(str, "titlePrefix");
        m.f(str2, "previouslyDeniedPostfix");
        m.f(aVar, "callback");
        String string = activity.getString(o4.f10957i);
        m.e(string, "activity.getString(R.str…sion_not_available_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        m.e(format, "java.lang.String.format(this, *args)");
        String string2 = activity.getString(o4.f10955g);
        m.e(string2, "activity.getString(R.str…on_not_available_message)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str2}, 1));
        m.e(format2, "java.lang.String.format(this, *args)");
        new AlertDialog.Builder(activity).setTitle(format).setMessage(format2).setPositiveButton(o4.f10956h, new c(aVar)).setNegativeButton(17039369, new d(aVar)).show();
    }
}
