package com.onesignal;

import android.content.ContentValues;
import com.google.firebase.messaging.Constants;
import com.onesignal.b4;
import com.onesignal.o3;
import com.zing.zalo.zalosdk.common.Constant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class z1 {

    /* renamed from: a  reason: collision with root package name */
    private final v3 f11118a;

    /* renamed from: b  reason: collision with root package name */
    private final c2 f11119b;

    /* renamed from: c  reason: collision with root package name */
    private final y2 f11120c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f11121d = 0;

    class a extends JSONObject {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11122a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f11123b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11124c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f11125d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f11126e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f11127f;

        a(String str, int i10, String str2, String str3, String str4, boolean z10) {
            this.f11122a = str;
            this.f11123b = i10;
            this.f11124c = str2;
            this.f11125d = str3;
            this.f11126e = str4;
            this.f11127f = z10;
            put(Constant.PARAM_APP_ID, str);
            put("device_type", i10);
            put("player_id", str2);
            put("click_id", str3);
            put("variant_id", str4);
            if (z10) {
                put("first_click", true);
            }
        }
    }

    class b extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Set f11129a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f11130b;

        b(Set set, i iVar) {
            this.f11129a = set;
            this.f11130b = iVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            z1.this.u("engagement", i10, str);
            this.f11130b.onFailure(str);
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            z1.this.v("engagement", str);
            z1.this.w(this.f11129a);
        }
    }

    class c extends JSONObject {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11132a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11133b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11134c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f11135d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f11136e;

        c(String str, String str2, String str3, int i10, String str4) {
            this.f11132a = str;
            this.f11133b = str2;
            this.f11134c = str3;
            this.f11135d = i10;
            this.f11136e = str4;
            put(Constant.PARAM_APP_ID, str);
            put("player_id", str2);
            put("variant_id", str3);
            put("device_type", i10);
            put("page_id", str4);
        }
    }

    class d extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Set f11138a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f11139b;

        d(Set set, i iVar) {
            this.f11138a = set;
            this.f11139b = iVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            z1.this.u("page impression", i10, str);
            this.f11139b.onFailure(str);
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            z1.this.v("page impression", str);
            z1.this.C(this.f11138a);
        }
    }

    class e extends JSONObject {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11141a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11142b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11143c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f11144d;

        e(String str, String str2, String str3, int i10) {
            this.f11141a = str;
            this.f11142b = str2;
            this.f11143c = str3;
            this.f11144d = i10;
            put(Constant.PARAM_APP_ID, str);
            put("player_id", str2);
            put("variant_id", str3);
            put("device_type", i10);
            put("first_impression", true);
        }
    }

    class f extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Set f11146a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f11147b;

        f(Set set, i iVar) {
            this.f11146a = set;
            this.f11147b = iVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            z1.this.u("impression", i10, str);
            this.f11147b.onFailure(str);
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            z1.this.v("impression", str);
            z1.this.z(this.f11146a);
        }
    }

    class g extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f11149a;

        g(i iVar) {
            this.f11149a = iVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            z1.this.u("html", i10, str);
            this.f11149a.onFailure(str);
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            this.f11149a.onSuccess(str);
        }
    }

    class h extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f11151a;

        h(i iVar) {
            this.f11151a = iVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            z1.this.u("html", i10, str);
            JSONObject jSONObject = new JSONObject();
            if (!OSUtils.U(i10) || z1.this.f11121d >= OSUtils.f10310a) {
                int unused = z1.this.f11121d = 0;
                try {
                    jSONObject.put("retry", false);
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            } else {
                z1.g(z1.this);
                try {
                    jSONObject.put("retry", true);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
            this.f11151a.onFailure(jSONObject.toString());
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            int unused = z1.this.f11121d = 0;
            this.f11151a.onSuccess(str);
        }
    }

    interface i {
        void onFailure(String str);

        void onSuccess(String str);
    }

    z1(v3 v3Var, c2 c2Var, y2 y2Var) {
        this.f11118a = v3Var;
        this.f11119b = c2Var;
        this.f11120c = y2Var;
    }

    static /* synthetic */ int g(z1 z1Var) {
        int i10 = z1Var.f11121d;
        z1Var.f11121d = i10 + 1;
        return i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = com.onesignal.z3.f11153a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(java.util.Set r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x001f
            int r0 = r5.size()
            if (r0 <= 0) goto L_0x001f
            java.lang.String r0 = com.onesignal.z3.f11153a
            r1 = 0
            java.lang.String r2 = "PREFS_OS_CLICKED_CLICK_IDS_IAMS"
            java.util.Set r1 = com.onesignal.z3.g(r0, r2, r1)
            if (r1 == 0) goto L_0x001f
            int r3 = r1.size()
            if (r3 <= 0) goto L_0x001f
            r1.removeAll(r5)
            com.onesignal.z3.n(r0, r2, r1)
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.z1.i(java.util.Set):void");
    }

    private void j(Set set) {
        if (set != null && set.size() > 0) {
            String str = z3.f11153a;
            Set g10 = z3.g(str, "PREFS_OS_DISPLAYED_IAMS", (Set) null);
            Set g11 = z3.g(str, "PREFS_OS_IMPRESSIONED_IAMS", (Set) null);
            if (g10 != null && g10.size() > 0) {
                g10.removeAll(set);
                z3.n(str, "PREFS_OS_DISPLAYED_IAMS", g10);
            }
            if (g11 != null && g11.size() > 0) {
                g11.removeAll(set);
                z3.n(str, "PREFS_OS_IMPRESSIONED_IAMS", g11);
            }
        }
    }

    private String t(String str, String str2, String str3) {
        if (str2 == null) {
            c2 c2Var = this.f11119b;
            c2Var.d("Unable to find a variant for in-app message " + str);
            return null;
        }
        return "in_app_messages/" + str + "/variants/" + str2 + "/html?app_id=" + str3;
    }

    /* access modifiers changed from: private */
    public void u(String str, int i10, String str2) {
        c2 c2Var = this.f11119b;
        c2Var.d("Encountered a " + i10 + " error while attempting in-app message " + str + " request: " + str2);
    }

    /* access modifiers changed from: private */
    public void v(String str, String str2) {
        c2 c2Var = this.f11119b;
        c2Var.b("Successful post for in-app message " + str + " request: " + str2);
    }

    /* access modifiers changed from: private */
    public void w(Set set) {
        this.f11120c.g(z3.f11153a, "PREFS_OS_CLICKED_CLICK_IDS_IAMS", set);
    }

    /* access modifiers changed from: private */
    public void z(Set set) {
        this.f11120c.g(z3.f11153a, "PREFS_OS_IMPRESSIONED_IAMS", set);
    }

    /* access modifiers changed from: package-private */
    public synchronized void A(q1 q1Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.MessagePayloadKeys.MSGID_SERVER, q1Var.f10768a);
        contentValues.put("display_quantity", Integer.valueOf(q1Var.e().a()));
        contentValues.put("last_display", Long.valueOf(q1Var.e().b()));
        contentValues.put("click_ids", q1Var.c().toString());
        contentValues.put("displayed_in_session", Boolean.valueOf(q1Var.g()));
        if (this.f11118a.a("in_app_message", contentValues, "message_id = ?", new String[]{q1Var.f10768a}) == 0) {
            this.f11118a.k("in_app_message", (String) null, contentValues);
        }
    }

    /* access modifiers changed from: package-private */
    public void B(Date date) {
        String str;
        if (date != null) {
            str = date.toString();
        } else {
            str = null;
        }
        this.f11120c.i(z3.f11153a, "PREFS_OS_LAST_TIME_IAM_DISMISSED", str);
    }

    /* access modifiers changed from: package-private */
    public void C(Set set) {
        this.f11120c.g(z3.f11153a, "PREFS_OS_PAGE_IMPRESSIONED_IAMS", set);
    }

    /* access modifiers changed from: package-private */
    public void D(String str, String str2, String str3, int i10, String str4, String str5, boolean z10, Set set, i iVar) {
        try {
            a aVar = new a(str, i10, str2, str5, str3, z10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("in_app_messages/");
            String str6 = str4;
            sb2.append(str4);
            sb2.append("/click");
            b4.j(sb2.toString(), aVar, new b(set, iVar));
        } catch (JSONException e10) {
            e10.printStackTrace();
            this.f11119b.d("Unable to execute in-app message action HTTP request due to invalid JSON");
        }
    }

    /* access modifiers changed from: package-private */
    public void E(String str, String str2, String str3, int i10, String str4, Set set, i iVar) {
        try {
            e eVar = new e(str, str2, str3, i10);
            b4.j("in_app_messages/" + str4 + "/impression", eVar, new f(set, iVar));
        } catch (JSONException e10) {
            e10.printStackTrace();
            this.f11119b.d("Unable to execute in-app message impression HTTP request due to invalid JSON");
        }
    }

    /* access modifiers changed from: package-private */
    public void F(String str, String str2, String str3, int i10, String str4, String str5, Set set, i iVar) {
        try {
            c cVar = new c(str, str2, str3, i10, str5);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("in_app_messages/");
            String str6 = str4;
            sb2.append(str4);
            sb2.append("/pageImpression");
            b4.j(sb2.toString(), cVar, new d(set, iVar));
        } catch (JSONException e10) {
            e10.printStackTrace();
            this.f11119b.d("Unable to execute in-app message impression HTTP request due to invalid JSON");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0075, code lost:
        if (r12.isClosed() == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void h() {
        /*
            r13 = this;
            monitor-enter(r13)
            java.lang.String r0 = "message_id"
            java.lang.String r1 = "click_ids"
            java.lang.String[] r4 = new java.lang.String[]{r0, r1}     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "last_display < ?"
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007b }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r5
            r5 = 15552000(0xed4e00, double:7.683709E-317)
            long r1 = r1 - r5
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x007b }
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch:{ all -> 0x007b }
            java.util.Set r10 = com.onesignal.OSUtils.K()     // Catch:{ all -> 0x007b }
            java.util.Set r11 = com.onesignal.OSUtils.K()     // Catch:{ all -> 0x007b }
            r12 = 0
            com.onesignal.v3 r2 = r13.f11118a     // Catch:{ JSONException -> 0x006f }
            java.lang.String r3 = "in_app_message"
            r8 = 0
            r9 = 0
            r7 = 0
            r5 = r0
            r6 = r1
            android.database.Cursor r12 = r2.h(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x006f }
            if (r12 == 0) goto L_0x007d
            int r2 = r12.getCount()     // Catch:{ JSONException -> 0x006f }
            if (r2 != 0) goto L_0x003d
            goto L_0x007d
        L_0x003d:
            boolean r2 = r12.moveToFirst()     // Catch:{ JSONException -> 0x006f }
            if (r2 == 0) goto L_0x0071
        L_0x0043:
            java.lang.String r2 = "message_id"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ JSONException -> 0x006f }
            java.lang.String r2 = r12.getString(r2)     // Catch:{ JSONException -> 0x006f }
            java.lang.String r3 = "click_ids"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ JSONException -> 0x006f }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ JSONException -> 0x006f }
            r10.add(r2)     // Catch:{ JSONException -> 0x006f }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x006f }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x006f }
            java.util.Set r2 = com.onesignal.OSUtils.L(r2)     // Catch:{ JSONException -> 0x006f }
            r11.addAll(r2)     // Catch:{ JSONException -> 0x006f }
            boolean r2 = r12.moveToNext()     // Catch:{ JSONException -> 0x006f }
            if (r2 != 0) goto L_0x0043
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            goto L_0x00ac
        L_0x006f:
            r2 = move-exception
            goto L_0x0091
        L_0x0071:
            boolean r2 = r12.isClosed()     // Catch:{ all -> 0x007b }
            if (r2 != 0) goto L_0x009d
        L_0x0077:
            r12.close()     // Catch:{ all -> 0x007b }
            goto L_0x009d
        L_0x007b:
            r0 = move-exception
            goto L_0x00b8
        L_0x007d:
            com.onesignal.o3$v r2 = com.onesignal.o3.v.DEBUG     // Catch:{ JSONException -> 0x006f }
            java.lang.String r3 = "Attempted to clean 6 month old IAM data, but none exists!"
            com.onesignal.o3.d1(r2, r3)     // Catch:{ JSONException -> 0x006f }
            if (r12 == 0) goto L_0x008f
            boolean r0 = r12.isClosed()     // Catch:{ all -> 0x007b }
            if (r0 != 0) goto L_0x008f
            r12.close()     // Catch:{ all -> 0x007b }
        L_0x008f:
            monitor-exit(r13)
            return
        L_0x0091:
            r2.printStackTrace()     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x009d
            boolean r2 = r12.isClosed()     // Catch:{ all -> 0x007b }
            if (r2 != 0) goto L_0x009d
            goto L_0x0077
        L_0x009d:
            com.onesignal.v3 r2 = r13.f11118a     // Catch:{ all -> 0x007b }
            java.lang.String r3 = "in_app_message"
            r2.j(r3, r0, r1)     // Catch:{ all -> 0x007b }
            r13.j(r10)     // Catch:{ all -> 0x007b }
            r13.i(r11)     // Catch:{ all -> 0x007b }
            monitor-exit(r13)
            return
        L_0x00ac:
            if (r12 == 0) goto L_0x00b7
            boolean r1 = r12.isClosed()     // Catch:{ all -> 0x007b }
            if (r1 != 0) goto L_0x00b7
            r12.close()     // Catch:{ all -> 0x007b }
        L_0x00b7:
            throw r0     // Catch:{ all -> 0x007b }
        L_0x00b8:
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.z1.h():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0077, code lost:
        if (r1.isClosed() == false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008c, code lost:
        if (r1.isClosed() == false) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List k() {
        /*
            r10 = this;
            monitor-enter(r10)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x007d }
            r0.<init>()     // Catch:{ all -> 0x007d }
            r1 = 0
            com.onesignal.v3 r2 = r10.f11118a     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r3 = "in_app_message"
            r8 = 0
            r9 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r2.h(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x0071 }
            boolean r2 = r1.moveToFirst()     // Catch:{ JSONException -> 0x0071 }
            if (r2 == 0) goto L_0x0073
        L_0x001b:
            java.lang.String r2 = "message_id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r3 = "click_ids"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r4 = "display_quantity"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ JSONException -> 0x0071 }
            int r4 = r1.getInt(r4)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r5 = "last_display"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ JSONException -> 0x0071 }
            long r5 = r1.getLong(r5)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r7 = "displayed_in_session"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ JSONException -> 0x0071 }
            int r7 = r1.getInt(r7)     // Catch:{ JSONException -> 0x0071 }
            r8 = 1
            if (r7 != r8) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r8 = 0
        L_0x0052:
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0071 }
            r7.<init>(r3)     // Catch:{ JSONException -> 0x0071 }
            java.util.Set r3 = com.onesignal.OSUtils.L(r7)     // Catch:{ JSONException -> 0x0071 }
            com.onesignal.q1 r7 = new com.onesignal.q1     // Catch:{ JSONException -> 0x0071 }
            com.onesignal.y1 r9 = new com.onesignal.y1     // Catch:{ JSONException -> 0x0071 }
            r9.<init>(r4, r5)     // Catch:{ JSONException -> 0x0071 }
            r7.<init>(r2, r3, r8, r9)     // Catch:{ JSONException -> 0x0071 }
            r0.add(r7)     // Catch:{ JSONException -> 0x0071 }
            boolean r2 = r1.moveToNext()     // Catch:{ JSONException -> 0x0071 }
            if (r2 != 0) goto L_0x001b
            goto L_0x0073
        L_0x006f:
            r0 = move-exception
            goto L_0x0091
        L_0x0071:
            r2 = move-exception
            goto L_0x007f
        L_0x0073:
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x007d }
            if (r2 != 0) goto L_0x008f
        L_0x0079:
            r1.close()     // Catch:{ all -> 0x007d }
            goto L_0x008f
        L_0x007d:
            r0 = move-exception
            goto L_0x009d
        L_0x007f:
            com.onesignal.o3$v r3 = com.onesignal.o3.v.ERROR     // Catch:{ all -> 0x006f }
            java.lang.String r4 = "Generating JSONArray from iam click ids:JSON Failed."
            com.onesignal.o3.b(r3, r4, r2)     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x008f
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x007d }
            if (r2 != 0) goto L_0x008f
            goto L_0x0079
        L_0x008f:
            monitor-exit(r10)
            return r0
        L_0x0091:
            if (r1 == 0) goto L_0x009c
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x007d }
            if (r2 != 0) goto L_0x009c
            r1.close()     // Catch:{ all -> 0x007d }
        L_0x009c:
            throw r0     // Catch:{ all -> 0x007d }
        L_0x009d:
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.z1.k():java.util.List");
    }

    /* access modifiers changed from: package-private */
    public Set l() {
        return this.f11120c.c(z3.f11153a, "PREFS_OS_CLICKED_CLICK_IDS_IAMS", (Set) null);
    }

    /* access modifiers changed from: package-private */
    public Set m() {
        return this.f11120c.c(z3.f11153a, "PREFS_OS_DISPLAYED_IAMS", (Set) null);
    }

    /* access modifiers changed from: package-private */
    public void n(String str, String str2, String str3, i iVar) {
        b4.e(t(str2, str3, str), new h(iVar), (String) null);
    }

    /* access modifiers changed from: package-private */
    public void o(String str, String str2, i iVar) {
        b4.e("in_app_messages/device_preview?preview_id=" + str2 + "&app_id=" + str, new g(iVar), (String) null);
    }

    /* access modifiers changed from: package-private */
    public Set p() {
        return this.f11120c.c(z3.f11153a, "PREFS_OS_IMPRESSIONED_IAMS", (Set) null);
    }

    /* access modifiers changed from: package-private */
    public Date q() {
        String e10 = this.f11120c.e(z3.f11153a, "PREFS_OS_LAST_TIME_IAM_DISMISSED", (String) null);
        if (e10 == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(e10);
        } catch (ParseException e11) {
            o3.d1(o3.v.ERROR, e11.getLocalizedMessage());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String r() {
        return this.f11120c.e(z3.f11153a, "PREFS_OS_CACHED_IAMS", (String) null);
    }

    /* access modifiers changed from: package-private */
    public Set s() {
        return this.f11120c.c(z3.f11153a, "PREFS_OS_PAGE_IMPRESSIONED_IAMS", (Set) null);
    }

    /* access modifiers changed from: package-private */
    public void x(Set set) {
        this.f11120c.g(z3.f11153a, "PREFS_OS_DISPLAYED_IAMS", set);
    }

    /* access modifiers changed from: package-private */
    public void y(String str) {
        this.f11120c.i(z3.f11153a, "PREFS_OS_CACHED_IAMS", str);
    }
}
