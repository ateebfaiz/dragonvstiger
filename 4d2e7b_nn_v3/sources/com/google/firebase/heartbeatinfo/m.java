package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

class m {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f9117a;

    public m(Context context, String str) {
        this.f9117a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    private synchronized void a() {
        try {
            long j10 = this.f9117a.getLong("fire-count", 0);
            String str = "";
            String str2 = null;
            for (Map.Entry next : this.f9117a.getAll().entrySet()) {
                if (next.getValue() instanceof Set) {
                    for (String str3 : (Set) next.getValue()) {
                        if (str2 != null) {
                            if (str2.compareTo(str3) > 0) {
                            }
                        }
                        str = (String) next.getKey();
                        str2 = str3;
                    }
                }
            }
            HashSet hashSet = new HashSet(this.f9117a.getStringSet(str, new HashSet()));
            hashSet.remove(str2);
            this.f9117a.edit().putStringSet(str, hashSet).putLong("fire-count", j10 - 1).commit();
        } finally {
        }
    }

    private synchronized String d(long j10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new Date(j10).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat(TimeUtils.YYYY_MM_DD, Locale.UK).format(new Date(j10));
    }

    private synchronized String e(String str) {
        for (Map.Entry next : this.f9117a.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                for (String equals : (Set) next.getValue()) {
                    if (str.equals(equals)) {
                        return (String) next.getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void h(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.e(r5)     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences r2 = r4.f9117a     // Catch:{ all -> 0x0030 }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x0030 }
            r3.<init>()     // Catch:{ all -> 0x0030 }
            java.util.Set r2 = r2.getStringSet(r0, r3)     // Catch:{ all -> 0x0030 }
            r1.<init>(r2)     // Catch:{ all -> 0x0030 }
            r1.remove(r5)     // Catch:{ all -> 0x0030 }
            boolean r5 = r1.isEmpty()     // Catch:{ all -> 0x0030 }
            if (r5 == 0) goto L_0x0032
            android.content.SharedPreferences r5 = r4.f9117a     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences$Editor r5 = r5.remove(r0)     // Catch:{ all -> 0x0030 }
            r5.commit()     // Catch:{ all -> 0x0030 }
            goto L_0x003f
        L_0x0030:
            r5 = move-exception
            goto L_0x0041
        L_0x0032:
            android.content.SharedPreferences r5 = r4.f9117a     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences$Editor r5 = r5.putStringSet(r0, r1)     // Catch:{ all -> 0x0030 }
            r5.commit()     // Catch:{ all -> 0x0030 }
        L_0x003f:
            monitor-exit(r4)
            return
        L_0x0041:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.heartbeatinfo.m.h(java.lang.String):void");
    }

    private synchronized void m(String str, String str2) {
        h(str2);
        HashSet hashSet = new HashSet(this.f9117a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f9117a.edit().putStringSet(str, hashSet).commit();
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        try {
            SharedPreferences.Editor edit = this.f9117a.edit();
            for (Map.Entry next : this.f9117a.getAll().entrySet()) {
                if (next.getValue() instanceof Set) {
                    edit.remove((String) next.getKey());
                }
            }
            edit.remove("fire-count");
            edit.commit();
        } finally {
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized List c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Map.Entry next : this.f9117a.getAll().entrySet()) {
                if (next.getValue() instanceof Set) {
                    arrayList.add(HeartBeatResult.create((String) next.getKey(), new ArrayList((Set) next.getValue())));
                }
            }
            l(System.currentTimeMillis());
        } finally {
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean f(long j10, long j11) {
        return d(j10).equals(d(j11));
    }

    /* access modifiers changed from: package-private */
    public synchronized void g() {
        String d10 = d(System.currentTimeMillis());
        this.f9117a.edit().putString("last-used-date", d10).commit();
        h(d10);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean i(long j10) {
        return j("fire-global", j10);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean j(String str, long j10) {
        if (!this.f9117a.contains(str)) {
            this.f9117a.edit().putLong(str, j10).commit();
            return true;
        } else if (f(this.f9117a.getLong(str, -1), j10)) {
            return false;
        } else {
            this.f9117a.edit().putLong(str, j10).commit();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void k(long j10, String str) {
        String d10 = d(j10);
        if (this.f9117a.getString("last-used-date", "").equals(d10)) {
            String e10 = e(d10);
            if (e10 != null) {
                if (!e10.equals(str)) {
                    m(str, d10);
                    return;
                }
                return;
            }
            return;
        }
        long j11 = this.f9117a.getLong("fire-count", 0);
        if (j11 + 1 == 30) {
            a();
            j11 = this.f9117a.getLong("fire-count", 0);
        }
        HashSet hashSet = new HashSet(this.f9117a.getStringSet(str, new HashSet()));
        hashSet.add(d10);
        this.f9117a.edit().putStringSet(str, hashSet).putLong("fire-count", j11 + 1).putString("last-used-date", d10).commit();
    }

    /* access modifiers changed from: package-private */
    public synchronized void l(long j10) {
        this.f9117a.edit().putLong("fire-global", j10).commit();
    }
}
