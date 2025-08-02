package pa;

import android.content.ContentValues;
import androidx.core.app.NotificationCompat;
import com.onesignal.c2;
import com.onesignal.u3;
import com.onesignal.y2;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.m;
import na.b;
import na.c;
import org.json.JSONArray;
import org.json.JSONException;
import qa.d;
import qa.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final c2 f12895a;

    /* renamed from: b  reason: collision with root package name */
    private final u3 f12896b;

    /* renamed from: c  reason: collision with root package name */
    private final y2 f12897c;

    /* renamed from: pa.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0155a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12898a;

        static {
            int[] iArr = new int[c.values().length];
            iArr[c.DIRECT.ordinal()] = 1;
            iArr[c.INDIRECT.ordinal()] = 2;
            f12898a = iArr;
        }
    }

    public a(c2 c2Var, u3 u3Var, y2 y2Var) {
        m.f(c2Var, "logger");
        m.f(u3Var, "dbHelper");
        m.f(y2Var, "preferences");
        this.f12895a = c2Var;
        this.f12896b = u3Var;
        this.f12897c = y2Var;
    }

    private final void a(List list, JSONArray jSONArray, b bVar) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                try {
                    String string = jSONArray.getString(i10);
                    m.e(string, "influenceId");
                    list.add(new qa.a(string, bVar));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                if (i11 < length) {
                    i10 = i11;
                } else {
                    return;
                }
            }
        }
    }

    private final void b(List list, e eVar) {
        if (eVar != null) {
            JSONArray a10 = eVar.a();
            JSONArray b10 = eVar.b();
            a(list, a10, b.IAM);
            a(list, b10, b.NOTIFICATION);
        }
    }

    private final d f(c cVar, e eVar, e eVar2, String str, d dVar) {
        d dVar2;
        d dVar3;
        int i10 = C0155a.f12898a[cVar.ordinal()];
        if (i10 == 1) {
            eVar.c(new JSONArray(str));
            if (dVar == null) {
                dVar2 = null;
            } else {
                dVar2 = dVar.c(eVar);
            }
            if (dVar2 == null) {
                return new d(eVar, (e) null);
            }
            return dVar2;
        } else if (i10 != 2) {
            return dVar;
        } else {
            eVar2.c(new JSONArray(str));
            if (dVar == null) {
                dVar3 = null;
            } else {
                dVar3 = dVar.e(eVar2);
            }
            if (dVar3 == null) {
                return new d((e) null, eVar2);
            }
            return dVar3;
        }
    }

    private final d h(c cVar, e eVar, e eVar2, String str) {
        d dVar;
        int i10 = C0155a.f12898a[cVar.ordinal()];
        if (i10 == 1) {
            eVar.d(new JSONArray(str));
            dVar = new d(eVar, (e) null);
        } else if (i10 != 2) {
            return null;
        } else {
            eVar2.d(new JSONArray(str));
            dVar = new d((e) null, eVar2);
        }
        return dVar;
    }

    public final synchronized void c(String str, String str2) {
        m.f(str, "notificationTableName");
        m.f(str2, "notificationIdColumnName");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NOT EXISTS(SELECT NULL FROM ");
        sb2.append(str);
        sb2.append(" n WHERE n.");
        sb2.append(str2);
        sb2.append(" = channel_influence_id AND channel_type = \"");
        String bVar = b.NOTIFICATION.toString();
        Locale locale = Locale.ROOT;
        m.e(locale, "ROOT");
        if (bVar != null) {
            String lowerCase = bVar.toLowerCase(locale);
            m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb2.append(lowerCase);
            sb2.append("\")");
            this.f12896b.j("cached_unique_outcome", sb2.toString(), (String[]) null);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final synchronized void d(qa.b bVar) {
        m.f(bVar, NotificationCompat.CATEGORY_EVENT);
        this.f12896b.j("outcome", "timestamp = ?", new String[]{String.valueOf(bVar.c())});
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cb A[SYNTHETIC, Splitter:B:40:0x00cb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List e() {
        /*
            r18 = this;
            r7 = r18
            monitor-enter(r18)
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00c4 }
            r8.<init>()     // Catch:{ all -> 0x00c4 }
            r9 = 0
            com.onesignal.u3 r10 = r7.f12896b     // Catch:{ all -> 0x00c8 }
            java.lang.String r11 = "outcome"
            r16 = 0
            r17 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            android.database.Cursor r10 = r10.h(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x00c8 }
            boolean r0 = r10.moveToFirst()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x00ba
        L_0x001f:
            java.lang.String r0 = "notification_influence_type"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ all -> 0x004c }
            na.c$a r1 = na.c.f12839a     // Catch:{ all -> 0x004c }
            na.c r0 = r1.a(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r2 = "iam_influence_type"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x004c }
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x004c }
            na.c r2 = r1.a(r2)     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "notification_ids"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ all -> 0x004c }
            java.lang.String r1 = r10.getString(r1)     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0050
            java.lang.String r1 = "[]"
            goto L_0x0050
        L_0x004c:
            r0 = move-exception
            r9 = r10
            goto L_0x00c9
        L_0x0050:
            java.lang.String r3 = "iam_ids"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ all -> 0x004c }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ all -> 0x004c }
            if (r3 != 0) goto L_0x005e
            java.lang.String r3 = "[]"
        L_0x005e:
            r5 = r3
            java.lang.String r3 = "name"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ all -> 0x004c }
            java.lang.String r12 = r10.getString(r3)     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "weight"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ all -> 0x004c }
            float r14 = r10.getFloat(r3)     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "timestamp"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ all -> 0x004c }
            long r15 = r10.getLong(r3)     // Catch:{ all -> 0x004c }
            qa.e r3 = new qa.e     // Catch:{ JSONException -> 0x009c }
            r4 = 3
            r3.<init>(r9, r9, r4, r9)     // Catch:{ JSONException -> 0x009c }
            qa.e r6 = new qa.e     // Catch:{ JSONException -> 0x009c }
            r6.<init>(r9, r9, r4, r9)     // Catch:{ JSONException -> 0x009c }
            qa.d r0 = r7.h(r0, r3, r6, r1)     // Catch:{ JSONException -> 0x009c }
            r1 = r18
            r4 = r6
            r6 = r0
            r1.f(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x009c }
            if (r0 != 0) goto L_0x009a
            qa.d r0 = new qa.d     // Catch:{ JSONException -> 0x009c }
            r0.<init>(r9, r9)     // Catch:{ JSONException -> 0x009c }
        L_0x009a:
            r13 = r0
            goto L_0x009e
        L_0x009c:
            r0 = move-exception
            goto L_0x00ad
        L_0x009e:
            qa.b r0 = new qa.b     // Catch:{ JSONException -> 0x009c }
            java.lang.String r1 = "name"
            kotlin.jvm.internal.m.e(r12, r1)     // Catch:{ JSONException -> 0x009c }
            r11 = r0
            r11.<init>(r12, r13, r14, r15)     // Catch:{ JSONException -> 0x009c }
            r8.add(r0)     // Catch:{ JSONException -> 0x009c }
            goto L_0x00b4
        L_0x00ad:
            com.onesignal.c2 r1 = r7.f12895a     // Catch:{ all -> 0x004c }
            java.lang.String r2 = "Generating JSONArray from notifications ids outcome:JSON Failed."
            r1.a(r2, r0)     // Catch:{ all -> 0x004c }
        L_0x00b4:
            boolean r0 = r10.moveToNext()     // Catch:{ all -> 0x004c }
            if (r0 != 0) goto L_0x001f
        L_0x00ba:
            boolean r0 = r10.isClosed()     // Catch:{ all -> 0x00c4 }
            if (r0 != 0) goto L_0x00c6
            r10.close()     // Catch:{ all -> 0x00c4 }
            goto L_0x00c6
        L_0x00c4:
            r0 = move-exception
            goto L_0x00d5
        L_0x00c6:
            monitor-exit(r18)
            return r8
        L_0x00c8:
            r0 = move-exception
        L_0x00c9:
            if (r9 == 0) goto L_0x00d4
            boolean r1 = r9.isClosed()     // Catch:{ all -> 0x00c4 }
            if (r1 != 0) goto L_0x00d4
            r9.close()     // Catch:{ all -> 0x00c4 }
        L_0x00d4:
            throw r0     // Catch:{ all -> 0x00c4 }
        L_0x00d5:
            monitor-exit(r18)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.a.e():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        if (r4.isClosed() == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008e, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009e, code lost:
        if (r4.isClosed() == false) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List g(java.lang.String r23, java.util.List r24) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            monitor-enter(r22)
            java.lang.String r2 = "name"
            kotlin.jvm.internal.m.f(r0, r2)     // Catch:{ all -> 0x0092 }
            java.lang.String r2 = "influences"
            r3 = r24
            kotlin.jvm.internal.m.f(r3, r2)     // Catch:{ all -> 0x0092 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0092 }
            r2.<init>()     // Catch:{ all -> 0x0092 }
            r4 = 0
            java.util.Iterator r3 = r24.iterator()     // Catch:{ JSONException -> 0x006d }
        L_0x001b:
            boolean r5 = r3.hasNext()     // Catch:{ JSONException -> 0x006d }
            if (r5 == 0) goto L_0x0085
            java.lang.Object r5 = r3.next()     // Catch:{ JSONException -> 0x006d }
            na.a r5 = (na.a) r5     // Catch:{ JSONException -> 0x006d }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x006d }
            r6.<init>()     // Catch:{ JSONException -> 0x006d }
            org.json.JSONArray r7 = r5.b()     // Catch:{ JSONException -> 0x006d }
            if (r7 != 0) goto L_0x0033
            goto L_0x001b
        L_0x0033:
            int r8 = r7.length()     // Catch:{ JSONException -> 0x006d }
            if (r8 <= 0) goto L_0x0074
            r9 = 0
            r10 = r9
        L_0x003b:
            int r11 = r10 + 1
            java.lang.String r10 = r7.getString(r10)     // Catch:{ JSONException -> 0x006d }
            na.b r12 = r5.c()     // Catch:{ JSONException -> 0x006d }
            java.lang.String[] r15 = new java.lang.String[r9]     // Catch:{ JSONException -> 0x006d }
            java.lang.String r16 = "channel_influence_id = ? AND channel_type = ? AND name = ?"
            java.lang.String r12 = r12.toString()     // Catch:{ JSONException -> 0x006d }
            java.lang.String[] r17 = new java.lang.String[]{r10, r12, r0}     // Catch:{ JSONException -> 0x006d }
            com.onesignal.u3 r13 = r1.f12896b     // Catch:{ JSONException -> 0x006d }
            java.lang.String r14 = "cached_unique_outcome"
            java.lang.String r21 = "1"
            r18 = 0
            r19 = 0
            r20 = 0
            android.database.Cursor r4 = r13.b(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ JSONException -> 0x006d }
            int r12 = r4.getCount()     // Catch:{ JSONException -> 0x006d }
            if (r12 != 0) goto L_0x006f
            r6.put(r10)     // Catch:{ JSONException -> 0x006d }
            goto L_0x006f
        L_0x006b:
            r0 = move-exception
            goto L_0x00a3
        L_0x006d:
            r0 = move-exception
            goto L_0x0094
        L_0x006f:
            if (r11 < r8) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r10 = r11
            goto L_0x003b
        L_0x0074:
            int r7 = r6.length()     // Catch:{ JSONException -> 0x006d }
            if (r7 <= 0) goto L_0x001b
            na.a r5 = r5.a()     // Catch:{ JSONException -> 0x006d }
            r5.e(r6)     // Catch:{ JSONException -> 0x006d }
            r2.add(r5)     // Catch:{ JSONException -> 0x006d }
            goto L_0x001b
        L_0x0085:
            if (r4 != 0) goto L_0x0088
            goto L_0x00a1
        L_0x0088:
            boolean r0 = r4.isClosed()     // Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x00a1
        L_0x008e:
            r4.close()     // Catch:{ all -> 0x0092 }
            goto L_0x00a1
        L_0x0092:
            r0 = move-exception
            goto L_0x00af
        L_0x0094:
            r0.printStackTrace()     // Catch:{ all -> 0x006b }
            if (r4 != 0) goto L_0x009a
            goto L_0x00a1
        L_0x009a:
            boolean r0 = r4.isClosed()     // Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x00a1
            goto L_0x008e
        L_0x00a1:
            monitor-exit(r22)
            return r2
        L_0x00a3:
            if (r4 == 0) goto L_0x00ae
            boolean r2 = r4.isClosed()     // Catch:{ all -> 0x0092 }
            if (r2 != 0) goto L_0x00ae
            r4.close()     // Catch:{ all -> 0x0092 }
        L_0x00ae:
            throw r0     // Catch:{ all -> 0x0092 }
        L_0x00af:
            monitor-exit(r22)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.a.g(java.lang.String, java.util.List):java.util.List");
    }

    public final Set i() {
        y2 y2Var = this.f12897c;
        return y2Var.c(y2Var.f(), "PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT", (Set) null);
    }

    public final boolean j() {
        y2 y2Var = this.f12897c;
        return y2Var.j(y2Var.f(), this.f12897c.h(), false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0097 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ec A[Catch:{ all -> 0x0035 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void k(qa.b r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "eventParams"
            kotlin.jvm.internal.m.f(r9, r0)     // Catch:{ all -> 0x0035 }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x0035 }
            r0.<init>()     // Catch:{ all -> 0x0035 }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ all -> 0x0035 }
            r1.<init>()     // Catch:{ all -> 0x0035 }
            na.c r2 = na.c.UNATTRIBUTED     // Catch:{ all -> 0x0035 }
            qa.d r3 = r9.b()     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0019
            goto L_0x001f
        L_0x0019:
            qa.e r3 = r3.a()     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0021
        L_0x001f:
            r3 = r2
            goto L_0x004a
        L_0x0021:
            org.json.JSONArray r4 = r3.b()     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x0029
        L_0x0027:
            r4 = r2
            goto L_0x0038
        L_0x0029:
            int r5 = r4.length()     // Catch:{ all -> 0x0035 }
            if (r5 <= 0) goto L_0x0027
            na.c r0 = na.c.DIRECT     // Catch:{ all -> 0x0035 }
            r7 = r4
            r4 = r0
            r0 = r7
            goto L_0x0038
        L_0x0035:
            r9 = move-exception
            goto L_0x00f4
        L_0x0038:
            org.json.JSONArray r3 = r3.a()     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x003f
            goto L_0x0048
        L_0x003f:
            int r5 = r3.length()     // Catch:{ all -> 0x0035 }
            if (r5 <= 0) goto L_0x0048
            na.c r2 = na.c.DIRECT     // Catch:{ all -> 0x0035 }
            r1 = r3
        L_0x0048:
            r3 = r2
            r2 = r4
        L_0x004a:
            qa.d r4 = r9.b()     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x0051
            goto L_0x0078
        L_0x0051:
            qa.e r4 = r4.b()     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x0058
            goto L_0x0078
        L_0x0058:
            org.json.JSONArray r5 = r4.b()     // Catch:{ all -> 0x0035 }
            if (r5 != 0) goto L_0x005f
            goto L_0x0068
        L_0x005f:
            int r6 = r5.length()     // Catch:{ all -> 0x0035 }
            if (r6 <= 0) goto L_0x0068
            na.c r2 = na.c.INDIRECT     // Catch:{ all -> 0x0035 }
            r0 = r5
        L_0x0068:
            org.json.JSONArray r4 = r4.a()     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x006f
            goto L_0x0078
        L_0x006f:
            int r5 = r4.length()     // Catch:{ all -> 0x0035 }
            if (r5 <= 0) goto L_0x0078
            na.c r3 = na.c.INDIRECT     // Catch:{ all -> 0x0035 }
            r1 = r4
        L_0x0078:
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x0035 }
            r4.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "notification_ids"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0035 }
            r4.put(r5, r0)     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "iam_ids"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0035 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "notification_influence_type"
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x00ec
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.m.e(r1, r2)     // Catch:{ all -> 0x0035 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "iam_influence_type"
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x00e4
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.m.e(r1, r2)     // Catch:{ all -> 0x0035 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "name"
            java.lang.String r1 = r9.a()     // Catch:{ all -> 0x0035 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "weight"
            float r1 = r9.d()     // Catch:{ all -> 0x0035 }
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch:{ all -> 0x0035 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "timestamp"
            long r1 = r9.c()     // Catch:{ all -> 0x0035 }
            java.lang.Long r9 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0035 }
            r4.put(r0, r9)     // Catch:{ all -> 0x0035 }
            com.onesignal.u3 r9 = r8.f12896b     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "outcome"
            r1 = 0
            r9.k(r0, r1, r4)     // Catch:{ all -> 0x0035 }
            monitor-exit(r8)
            return
        L_0x00e4:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r9.<init>(r0)     // Catch:{ all -> 0x0035 }
            throw r9     // Catch:{ all -> 0x0035 }
        L_0x00ec:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r9.<init>(r0)     // Catch:{ all -> 0x0035 }
            throw r9     // Catch:{ all -> 0x0035 }
        L_0x00f4:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.a.k(qa.b):void");
    }

    public final void l(Set set) {
        y2 y2Var = this.f12897c;
        String f10 = y2Var.f();
        m.c(set);
        y2Var.g(f10, "PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT", set);
    }

    public final synchronized void m(qa.b bVar) {
        e eVar;
        e eVar2;
        m.f(bVar, "eventParams");
        this.f12895a.b(m.n("OneSignal saveUniqueOutcomeEventParams: ", bVar));
        String a10 = bVar.a();
        ArrayList<qa.a> arrayList = new ArrayList<>();
        d b10 = bVar.b();
        if (b10 == null) {
            eVar = null;
        } else {
            eVar = b10.a();
        }
        d b11 = bVar.b();
        if (b11 == null) {
            eVar2 = null;
        } else {
            eVar2 = b11.b();
        }
        b(arrayList, eVar);
        b(arrayList, eVar2);
        for (qa.a aVar : arrayList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("channel_influence_id", aVar.b());
            contentValues.put("channel_type", aVar.a().toString());
            contentValues.put("name", a10);
            this.f12896b.k("cached_unique_outcome", (String) null, contentValues);
        }
    }
}
