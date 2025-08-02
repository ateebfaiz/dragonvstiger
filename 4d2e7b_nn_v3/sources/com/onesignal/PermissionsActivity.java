package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.onesignal.a;
import java.util.HashMap;

public class PermissionsActivity extends Activity {

    /* renamed from: c  reason: collision with root package name */
    private static final String f10318c = "com.onesignal.PermissionsActivity";

    /* renamed from: d  reason: collision with root package name */
    private static boolean f10319d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f10320e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f10321f;

    /* renamed from: g  reason: collision with root package name */
    private static a.b f10322g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final HashMap f10323h = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f10324a;

    /* renamed from: b  reason: collision with root package name */
    private String f10325b;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f10326a;

        a(int[] iArr) {
            this.f10326a = iArr;
        }

        public void run() {
            int[] iArr = this.f10326a;
            boolean z10 = false;
            if (iArr.length > 0 && iArr[0] == 0) {
                z10 = true;
            }
            c cVar = (c) PermissionsActivity.f10323h.get(PermissionsActivity.this.f10324a);
            if (cVar == null) {
                throw new RuntimeException("Missing handler for permissionRequestType: " + PermissionsActivity.this.f10324a);
            } else if (z10) {
                cVar.a();
            } else {
                cVar.b(PermissionsActivity.this.g());
            }
        }
    }

    class b extends a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10328a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10329b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Class f10330c;

        b(String str, String str2, Class cls) {
            this.f10328a = str;
            this.f10329b = str2;
            this.f10330c = cls;
        }

        public void a(Activity activity) {
            Class<PermissionsActivity> cls = PermissionsActivity.class;
            if (!activity.getClass().equals(cls)) {
                Intent intent = new Intent(activity, cls);
                intent.setFlags(131072);
                intent.putExtra("INTENT_EXTRA_PERMISSION_TYPE", this.f10328a).putExtra("INTENT_EXTRA_ANDROID_PERMISSION_STRING", this.f10329b).putExtra("INTENT_EXTRA_CALLBACK_CLASS", this.f10330c.getName());
                activity.startActivity(intent);
                activity.overridePendingTransition(l4.f10771a, l4.f10772b);
            }
        }
    }

    interface c {
        void a();

        void b(boolean z10);
    }

    private void d(Bundle bundle) {
        f(bundle);
        this.f10324a = bundle.getString("INTENT_EXTRA_PERMISSION_TYPE");
        String string = bundle.getString("INTENT_EXTRA_ANDROID_PERMISSION_STRING");
        this.f10325b = string;
        e(string);
    }

    private void e(String str) {
        if (!f10319d) {
            f10319d = true;
            f10321f = true ^ f.b(this, str);
            f.a(this, new String[]{str}, 2);
        }
    }

    private void f(Bundle bundle) {
        String string = bundle.getString("INTENT_EXTRA_CALLBACK_CLASS");
        try {
            Class.forName(string);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Could not find callback class for PermissionActivity: " + string);
        }
    }

    /* access modifiers changed from: private */
    public boolean g() {
        if (!f10320e || !f10321f || f.b(this, this.f10325b)) {
            return false;
        }
        return true;
    }

    static void h(boolean z10, String str, String str2, Class cls) {
        if (!f10319d) {
            f10320e = z10;
            f10322g = new b(str, str2, cls);
            a b10 = b.b();
            if (b10 != null) {
                b10.c(f10318c, f10322g);
            }
        }
    }

    public static void registerAsCallback(@NonNull String str, @NonNull c cVar) {
        f10323h.put(str, cVar);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o3.L0(this);
        d(getIntent().getExtras());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        d(intent.getExtras());
    }

    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        f10319d = false;
        if (i10 == 2) {
            new Handler().postDelayed(new a(iArr), 500);
        }
        a b10 = b.b();
        if (b10 != null) {
            b10.r(f10318c);
        }
        finish();
        overridePendingTransition(l4.f10771a, l4.f10772b);
    }
}
