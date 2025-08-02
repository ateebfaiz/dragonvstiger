package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class g2 extends d1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final v3 f10639a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c2 f10640b;

    class a extends k {
        a() {
        }

        public void run() {
            super.run();
            g2.this.f10639a.j("notification", "created_time < ?", new String[]{String.valueOf((o3.w0().b() / 1000) - 604800)});
        }
    }

    class b extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f10642a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10643b;

        b(WeakReference weakReference, int i10) {
            this.f10642a = weakReference;
            this.f10643b = i10;
        }

        public void run() {
            super.run();
            Context context = (Context) this.f10642a.get();
            if (context != null) {
                String str = "android_notification_id = " + this.f10643b + " AND " + "opened" + " = 0 AND " + "dismissed" + " = 0";
                ContentValues contentValues = new ContentValues();
                contentValues.put("dismissed", 1);
                if (g2.this.f10639a.a("notification", contentValues, str, (String[]) null) > 0) {
                    c1.e(context, g2.this.f10639a, this.f10643b);
                }
                l.c(g2.this.f10639a, context);
                y3.i(context).cancel(this.f10643b);
            }
        }
    }

    class c extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10645a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f10646b;

        c(String str, d dVar) {
            this.f10645a = str;
            this.f10646b = dVar;
        }

        public void run() {
            boolean z10;
            super.run();
            String[] strArr = {this.f10645a};
            Cursor h10 = g2.this.f10639a.h("notification", new String[]{"notification_id"}, "notification_id = ?", strArr, (String) null, (String) null, (String) null);
            boolean moveToFirst = h10.moveToFirst();
            h10.close();
            if (moveToFirst) {
                c2 f10 = g2.this.f10640b;
                f10.b("Notification notValidOrDuplicated with id duplicated, duplicate FCM message received, skip processing of " + this.f10645a);
                z10 = true;
            } else {
                z10 = false;
            }
            this.f10646b.a(z10);
        }
    }

    interface d {
        void a(boolean z10);
    }

    public g2(v3 v3Var, c2 c2Var) {
        this.f10639a = v3Var;
        this.f10640b = c2Var;
    }

    private void g() {
        d(new a(), "OS_NOTIFICATIONS_THREAD");
    }

    private void i(String str, d dVar) {
        if (str == null || "".equals(str)) {
            dVar.a(false);
        } else if (!OSNotificationWorkManager.a(str)) {
            this.f10640b.b("Notification notValidOrDuplicated with id duplicated");
            dVar.a(true);
        } else {
            d(new c(str, dVar), "OS_NOTIFICATIONS_THREAD");
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        g();
    }

    /* access modifiers changed from: package-private */
    public void j(JSONObject jSONObject, d dVar) {
        String b10 = h2.b(jSONObject);
        if (b10 == null) {
            this.f10640b.b("Notification notValidOrDuplicated with id null");
            dVar.a(true);
            return;
        }
        i(b10, dVar);
    }

    /* access modifiers changed from: package-private */
    public void k(int i10, WeakReference weakReference) {
        d(new b(weakReference, i10), "OS_NOTIFICATIONS_THREAD");
    }
}
