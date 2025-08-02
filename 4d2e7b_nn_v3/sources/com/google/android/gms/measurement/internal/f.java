package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class f extends u3 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f7485c = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f7486d = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f7487e = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f7488f = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f7489g = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f7490h = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f7491i = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f7492j = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: a  reason: collision with root package name */
    private final e f7493a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final r3 f7494b = new r3(this.zzt.zzav());

    f(zzkt zzkt) {
        super(zzkt);
        this.zzt.zzf();
        this.f7493a = new e(this, this.zzt.zzau(), "google_app_measurement.db");
    }

    static final void u(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final long v(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = zzh().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j10 = cursor.getLong(0);
                cursor.close();
                return j10;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Database error", str, e10);
            throw e10;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long x(String str, String[] strArr, long j10) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzh().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j11 = rawQuery.getLong(0);
                rawQuery.close();
                return j11;
            }
            rawQuery.close();
            return j10;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Database error", str, e10);
            throw e10;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long A() {
        return x("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long B(String str) {
        Preconditions.checkNotEmpty(str);
        return x("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle C(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzg()
            r7.zzW()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.zzh()     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            java.lang.String[] r2 = new java.lang.String[]{r8}     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            java.lang.String r3 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r3, r2)     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0031 }
            if (r2 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzfr r8 = r7.zzt     // Catch:{ SQLiteException -> 0x0031 }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzay()     // Catch:{ SQLiteException -> 0x0031 }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzj()     // Catch:{ SQLiteException -> 0x0031 }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x0031 }
            r1.close()
            return r0
        L_0x002e:
            r8 = move-exception
            goto L_0x00bf
        L_0x0031:
            r8 = move-exception
            goto L_0x00c5
        L_0x0034:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch:{ SQLiteException -> 0x0031 }
            com.google.android.gms.internal.measurement.zzfs r3 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.internal.measurement.zzll r2 = com.google.android.gms.measurement.internal.zzkv.zzl(r3, r2)     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.internal.measurement.zzkf r2 = r2.zzaC()     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ IOException -> 0x00a7 }
            com.google.android.gms.measurement.internal.zzkt r8 = r7.zzf     // Catch:{ SQLiteException -> 0x0031 }
            r8.zzu()     // Catch:{ SQLiteException -> 0x0031 }
            java.util.List r8 = r2.zzi()     // Catch:{ SQLiteException -> 0x0031 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x0031 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0031 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x0031 }
        L_0x005b:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x0031 }
            if (r3 == 0) goto L_0x00a3
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x0031 }
            com.google.android.gms.internal.measurement.zzfx r3 = (com.google.android.gms.internal.measurement.zzfx) r3     // Catch:{ SQLiteException -> 0x0031 }
            java.lang.String r4 = r3.zzg()     // Catch:{ SQLiteException -> 0x0031 }
            boolean r5 = r3.zzu()     // Catch:{ SQLiteException -> 0x0031 }
            if (r5 == 0) goto L_0x0079
            double r5 = r3.zza()     // Catch:{ SQLiteException -> 0x0031 }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x0031 }
            goto L_0x005b
        L_0x0079:
            boolean r5 = r3.zzv()     // Catch:{ SQLiteException -> 0x0031 }
            if (r5 == 0) goto L_0x0087
            float r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x0031 }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x0031 }
            goto L_0x005b
        L_0x0087:
            boolean r5 = r3.zzy()     // Catch:{ SQLiteException -> 0x0031 }
            if (r5 == 0) goto L_0x0095
            java.lang.String r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x0031 }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x0031 }
            goto L_0x005b
        L_0x0095:
            boolean r5 = r3.zzw()     // Catch:{ SQLiteException -> 0x0031 }
            if (r5 == 0) goto L_0x005b
            long r5 = r3.zzd()     // Catch:{ SQLiteException -> 0x0031 }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x0031 }
            goto L_0x005b
        L_0x00a3:
            r1.close()
            return r2
        L_0x00a7:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r7.zzt     // Catch:{ SQLiteException -> 0x0031 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x0031 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0031 }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)     // Catch:{ SQLiteException -> 0x0031 }
            r3.zzc(r4, r8, r2)     // Catch:{ SQLiteException -> 0x0031 }
            r1.close()
            return r0
        L_0x00bf:
            r0 = r1
            goto L_0x00da
        L_0x00c1:
            r8 = move-exception
            goto L_0x00da
        L_0x00c3:
            r8 = move-exception
            r1 = r0
        L_0x00c5:
            com.google.android.gms.measurement.internal.zzfr r2 = r7.zzt     // Catch:{ all -> 0x002e }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x002e }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x002e }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r8)     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x00d9
            r1.close()
        L_0x00d9:
            return r0
        L_0x00da:
            if (r0 == 0) goto L_0x00df
            r0.close()
        L_0x00df:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.C(java.lang.String):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.c1 D(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r35)
            r34.zzg()
            r34.zzW()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r34.zzh()     // Catch:{ SQLiteException -> 0x01e2, all -> 0x01e0 }
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "admob_app_id"
            java.lang.String r30 = "dynamite_version"
            java.lang.String r31 = "safelisted_events"
            java.lang.String r32 = "ga_app_id"
            java.lang.String r33 = "session_stitching_token"
            java.lang.String[] r6 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33}     // Catch:{ SQLiteException -> 0x01e2, all -> 0x01e0 }
            java.lang.String[] r8 = new java.lang.String[]{r35}     // Catch:{ SQLiteException -> 0x01e2, all -> 0x01e0 }
            java.lang.String r5 = "apps"
            java.lang.String r7 = "app_id=?"
            r10 = 0
            r11 = 0
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x01e2, all -> 0x01e0 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x00db }
            if (r0 != 0) goto L_0x0069
            r4.close()
            return r3
        L_0x0069:
            com.google.android.gms.measurement.internal.c1 r0 = new com.google.android.gms.measurement.internal.c1     // Catch:{ SQLiteException -> 0x00db }
            com.google.android.gms.measurement.internal.zzkt r5 = r1.zzf     // Catch:{ SQLiteException -> 0x00db }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzq()     // Catch:{ SQLiteException -> 0x00db }
            r0.<init>(r5, r2)     // Catch:{ SQLiteException -> 0x00db }
            r5 = 0
            java.lang.String r6 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00db }
            r0.h(r6)     // Catch:{ SQLiteException -> 0x00db }
            r6 = 1
            java.lang.String r7 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x00db }
            r0.w(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 2
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.F(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 3
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.B(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 4
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.C(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 5
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.z(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 6
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.j(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 7
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.i(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 8
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.x(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 9
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.s(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 10
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00db }
            if (r8 != 0) goto L_0x00d4
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00db }
            if (r7 == 0) goto L_0x00d6
        L_0x00d4:
            r7 = r6
            goto L_0x00de
        L_0x00d6:
            r7 = r5
            goto L_0x00de
        L_0x00d8:
            r0 = move-exception
            goto L_0x01de
        L_0x00db:
            r0 = move-exception
            goto L_0x01e4
        L_0x00de:
            r0.D(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 11
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.r(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 12
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.p(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 13
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.o(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 14
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.m(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 15
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.l(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 16
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.u(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 17
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00db }
            if (r8 == 0) goto L_0x0123
            r7 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0128
        L_0x0123:
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00db }
            long r7 = (long) r7     // Catch:{ SQLiteException -> 0x00db }
        L_0x0128:
            r0.k(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 18
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.v(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 19
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.n(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 20
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.q(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 21
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x00db }
            r0.y(r7)     // Catch:{ SQLiteException -> 0x00db }
            r7 = 23
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00db }
            if (r8 != 0) goto L_0x015d
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00db }
            if (r7 == 0) goto L_0x015e
        L_0x015d:
            r5 = r6
        L_0x015e:
            r0.g(r5)     // Catch:{ SQLiteException -> 0x00db }
            r5 = 24
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00db }
            r0.f(r5)     // Catch:{ SQLiteException -> 0x00db }
            r5 = 25
            boolean r6 = r4.isNull(r5)     // Catch:{ SQLiteException -> 0x00db }
            if (r6 == 0) goto L_0x0175
            r5 = 0
            goto L_0x0179
        L_0x0175:
            long r5 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00db }
        L_0x0179:
            r0.t(r5)     // Catch:{ SQLiteException -> 0x00db }
            r5 = 26
            boolean r6 = r4.isNull(r5)     // Catch:{ SQLiteException -> 0x00db }
            if (r6 != 0) goto L_0x0196
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00db }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r5 = r5.split(r6, r7)     // Catch:{ SQLiteException -> 0x00db }
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ SQLiteException -> 0x00db }
            r0.G(r5)     // Catch:{ SQLiteException -> 0x00db }
        L_0x0196:
            com.google.android.gms.internal.measurement.zzpd.zzc()     // Catch:{ SQLiteException -> 0x00db }
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x00db }
            com.google.android.gms.measurement.internal.zzag r5 = r5.zzf()     // Catch:{ SQLiteException -> 0x00db }
            com.google.android.gms.measurement.internal.zzdt r6 = com.google.android.gms.measurement.internal.zzdu.zzal     // Catch:{ SQLiteException -> 0x00db }
            boolean r5 = r5.zzs(r3, r6)     // Catch:{ SQLiteException -> 0x00db }
            if (r5 == 0) goto L_0x01be
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x00db }
            com.google.android.gms.measurement.internal.zzag r5 = r5.zzf()     // Catch:{ SQLiteException -> 0x00db }
            com.google.android.gms.measurement.internal.zzdt r6 = com.google.android.gms.measurement.internal.zzdu.zzan     // Catch:{ SQLiteException -> 0x00db }
            boolean r5 = r5.zzs(r2, r6)     // Catch:{ SQLiteException -> 0x00db }
            if (r5 == 0) goto L_0x01be
            r5 = 28
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00db }
            r0.H(r5)     // Catch:{ SQLiteException -> 0x00db }
        L_0x01be:
            r0.d()     // Catch:{ SQLiteException -> 0x00db }
            boolean r5 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x00db }
            if (r5 == 0) goto L_0x01da
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x00db }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ SQLiteException -> 0x00db }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ SQLiteException -> 0x00db }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r35)     // Catch:{ SQLiteException -> 0x00db }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x00db }
        L_0x01da:
            r4.close()
            return r0
        L_0x01de:
            r3 = r4
            goto L_0x01fd
        L_0x01e0:
            r0 = move-exception
            goto L_0x01fd
        L_0x01e2:
            r0 = move-exception
            r4 = r3
        L_0x01e4:
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ all -> 0x00d8 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x00d8 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x00d8 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r35)     // Catch:{ all -> 0x00d8 }
            r5.zzc(r6, r2, r0)     // Catch:{ all -> 0x00d8 }
            if (r4 == 0) goto L_0x01fc
            r4.close()
        L_0x01fc:
            return r3
        L_0x01fd:
            if (r3 == 0) goto L_0x0202
            r3.close()
        L_0x0202:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.D(java.lang.String):com.google.android.gms.measurement.internal.c1");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzac E(java.lang.String r27, java.lang.String r28) {
        /*
            r26 = this;
            r1 = r26
            r8 = r28
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            r26.zzg()
            r26.zzW()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r26.zzh()     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fd }
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r12 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fd }
            java.lang.String[] r14 = new java.lang.String[]{r27, r28}     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fd }
            java.lang.String r11 = "conditional_properties"
            java.lang.String r13 = "app_id=? and name=?"
            r16 = 0
            r17 = 0
            r15 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fd }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0058 }
            if (r0 != 0) goto L_0x004a
            r10.close()
            return r9
        L_0x004a:
            r0 = 0
            java.lang.String r2 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0058 }
            if (r2 != 0) goto L_0x0053
            java.lang.String r2 = ""
        L_0x0053:
            r13 = r2
            goto L_0x005b
        L_0x0055:
            r0 = move-exception
            goto L_0x00fb
        L_0x0058:
            r0 = move-exception
            goto L_0x0101
        L_0x005b:
            r2 = 1
            java.lang.Object r6 = r1.K(r10, r2)     // Catch:{ SQLiteException -> 0x0058 }
            r3 = 2
            int r3 = r10.getInt(r3)     // Catch:{ SQLiteException -> 0x0058 }
            if (r3 == 0) goto L_0x006a
            r17 = r2
            goto L_0x006c
        L_0x006a:
            r17 = r0
        L_0x006c:
            r0 = 3
            java.lang.String r18 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0058 }
            r0 = 4
            long r20 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzkt r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x0058 }
            r2 = 5
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0058 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaw> r3 = com.google.android.gms.measurement.internal.zzaw.CREATOR     // Catch:{ SQLiteException -> 0x0058 }
            android.os.Parcelable r0 = r0.zzh(r2, r3)     // Catch:{ SQLiteException -> 0x0058 }
            r19 = r0
            com.google.android.gms.measurement.internal.zzaw r19 = (com.google.android.gms.measurement.internal.zzaw) r19     // Catch:{ SQLiteException -> 0x0058 }
            r0 = 6
            long r15 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzkt r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x0058 }
            r2 = 7
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0058 }
            android.os.Parcelable r0 = r0.zzh(r2, r3)     // Catch:{ SQLiteException -> 0x0058 }
            r22 = r0
            com.google.android.gms.measurement.internal.zzaw r22 = (com.google.android.gms.measurement.internal.zzaw) r22     // Catch:{ SQLiteException -> 0x0058 }
            r0 = 8
            long r4 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0058 }
            r0 = 9
            long r23 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzkt r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x0058 }
            r2 = 10
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0058 }
            android.os.Parcelable r0 = r0.zzh(r2, r3)     // Catch:{ SQLiteException -> 0x0058 }
            r25 = r0
            com.google.android.gms.measurement.internal.zzaw r25 = (com.google.android.gms.measurement.internal.zzaw) r25     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzkw r14 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ SQLiteException -> 0x0058 }
            r2 = r14
            r3 = r28
            r7 = r13
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzac r0 = new com.google.android.gms.measurement.internal.zzac     // Catch:{ SQLiteException -> 0x0058 }
            r11 = r0
            r12 = r27
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r22, r23, r25)     // Catch:{ SQLiteException -> 0x0058 }
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0058 }
            if (r2 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0058 }
            java.lang.String r3 = "Got multiple records for conditional property, expected one"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r27)     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()     // Catch:{ SQLiteException -> 0x0058 }
            java.lang.String r5 = r5.zzf(r8)     // Catch:{ SQLiteException -> 0x0058 }
            r2.zzc(r3, r4, r5)     // Catch:{ SQLiteException -> 0x0058 }
        L_0x00f7:
            r10.close()
            return r0
        L_0x00fb:
            r9 = r10
            goto L_0x0124
        L_0x00fd:
            r0 = move-exception
            goto L_0x0124
        L_0x00ff:
            r0 = move-exception
            r10 = r9
        L_0x0101:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x0055 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0055 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r27)     // Catch:{ all -> 0x0055 }
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ all -> 0x0055 }
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = r5.zzf(r8)     // Catch:{ all -> 0x0055 }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x0055 }
            if (r10 == 0) goto L_0x0123
            r10.close()
        L_0x0123:
            return r9
        L_0x0124:
            if (r9 == 0) goto L_0x0129
            r9.close()
        L_0x0129:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.E(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    public final zzak F(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return G(j10, str, 1, false, false, z12, false, z14);
    }

    public final zzak G(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        String[] strArr = {str};
        zzak zzak = new zzak();
        Cursor cursor = null;
        try {
            SQLiteDatabase zzh = zzh();
            cursor = zzh.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                this.zzt.zzay().zzk().zzb("Not updating daily counts, app is not known. appId", zzeh.zzn(str));
                cursor.close();
                return zzak;
            }
            if (cursor.getLong(0) == j10) {
                zzak.zzb = cursor.getLong(1);
                zzak.zza = cursor.getLong(2);
                zzak.zzc = cursor.getLong(3);
                zzak.zzd = cursor.getLong(4);
                zzak.zze = cursor.getLong(5);
            }
            if (z10) {
                zzak.zzb += j11;
            }
            if (z11) {
                zzak.zza += j11;
            }
            if (z12) {
                zzak.zzc += j11;
            }
            if (z13) {
                zzak.zzd += j11;
            }
            if (z14) {
                zzak.zze += j11;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j10));
            contentValues.put("daily_public_events_count", Long.valueOf(zzak.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzak.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzak.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzak.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzak.zze));
            zzh.update("apps", contentValues, "app_id=?", strArr);
            cursor.close();
            return zzak;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error updating daily counts. appId", zzeh.zzn(str), e10);
            if (cursor != null) {
                cursor.close();
            }
            return zzak;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.i H(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r1 = r29
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzg()
            r29.zzW()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r29.zzh()     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            r11 = 0
            java.lang.String[] r4 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            r5 = r0
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            java.lang.String[] r7 = new java.lang.String[]{r30, r31}     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            java.lang.String r4 = "events"
            java.lang.String r6 = "app_id=? and name=?"
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x00cc }
            if (r0 != 0) goto L_0x0055
            r3.close()
            return r2
        L_0x0055:
            long r15 = r3.getLong(r11)     // Catch:{ SQLiteException -> 0x00cc }
            r0 = 1
            long r17 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x00cc }
            r4 = 2
            long r21 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00cc }
            r4 = 3
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00cc }
            r6 = 0
            if (r5 == 0) goto L_0x006f
            r23 = r6
            goto L_0x0075
        L_0x006f:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00cc }
            r23 = r4
        L_0x0075:
            r4 = 4
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00cc }
            if (r5 == 0) goto L_0x007f
            r25 = r2
            goto L_0x0089
        L_0x007f:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00cc }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00cc }
            r25 = r4
        L_0x0089:
            r4 = 5
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00cc }
            if (r5 == 0) goto L_0x0093
            r26 = r2
            goto L_0x009d
        L_0x0093:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00cc }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00cc }
            r26 = r4
        L_0x009d:
            r4 = 6
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00cc }
            if (r5 == 0) goto L_0x00a7
            r27 = r2
            goto L_0x00b1
        L_0x00a7:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00cc }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00cc }
            r27 = r4
        L_0x00b1:
            r4 = 7
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00cc }
            if (r5 != 0) goto L_0x00ce
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00cc }
            r8 = 1
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x00c3
            r11 = r0
        L_0x00c3:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)     // Catch:{ SQLiteException -> 0x00cc }
            r28 = r0
            goto L_0x00d0
        L_0x00ca:
            r0 = move-exception
            goto L_0x0108
        L_0x00cc:
            r0 = move-exception
            goto L_0x010e
        L_0x00ce:
            r28 = r2
        L_0x00d0:
            r0 = 8
            boolean r4 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x00cc }
            if (r4 == 0) goto L_0x00db
            r19 = r6
            goto L_0x00e1
        L_0x00db:
            long r4 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x00cc }
            r19 = r4
        L_0x00e1:
            com.google.android.gms.measurement.internal.i r0 = new com.google.android.gms.measurement.internal.i     // Catch:{ SQLiteException -> 0x00cc }
            r12 = r0
            r13 = r30
            r14 = r31
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)     // Catch:{ SQLiteException -> 0x00cc }
            boolean r4 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x00cc }
            if (r4 == 0) goto L_0x0104
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ SQLiteException -> 0x00cc }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ SQLiteException -> 0x00cc }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ SQLiteException -> 0x00cc }
            java.lang.String r5 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r30)     // Catch:{ SQLiteException -> 0x00cc }
            r4.zzb(r5, r6)     // Catch:{ SQLiteException -> 0x00cc }
        L_0x0104:
            r3.close()
            return r0
        L_0x0108:
            r2 = r3
            goto L_0x0133
        L_0x010a:
            r0 = move-exception
            goto L_0x0133
        L_0x010c:
            r0 = move-exception
            r3 = r2
        L_0x010e:
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ all -> 0x00ca }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x00ca }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x00ca }
            java.lang.String r5 = "Error querying events. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r30)     // Catch:{ all -> 0x00ca }
            com.google.android.gms.measurement.internal.zzfr r7 = r1.zzt     // Catch:{ all -> 0x00ca }
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()     // Catch:{ all -> 0x00ca }
            r8 = r31
            java.lang.String r7 = r7.zzd(r8)     // Catch:{ all -> 0x00ca }
            r4.zzd(r5, r6, r7, r0)     // Catch:{ all -> 0x00ca }
            if (r3 == 0) goto L_0x0132
            r3.close()
        L_0x0132:
            return r2
        L_0x0133:
            if (r2 == 0) goto L_0x0138
            r2.close()
        L_0x0138:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.H(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.i");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.d4 J(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r10.zzg()
            r10.zzW()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.zzh()     // Catch:{ SQLiteException -> 0x0077, all -> 0x0075 }
            java.lang.String r2 = "set_timestamp"
            java.lang.String r3 = "value"
            java.lang.String r4 = "origin"
            java.lang.String[] r3 = new java.lang.String[]{r2, r3, r4}     // Catch:{ SQLiteException -> 0x0077, all -> 0x0075 }
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch:{ SQLiteException -> 0x0077, all -> 0x0075 }
            java.lang.String r2 = "user_attributes"
            java.lang.String r4 = "app_id=? and name=?"
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0077, all -> 0x0075 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x006d }
            if (r2 != 0) goto L_0x0034
            r1.close()
            return r0
        L_0x0034:
            r2 = 0
            long r7 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x006d }
            r2 = 1
            java.lang.Object r9 = r10.K(r1, r2)     // Catch:{ SQLiteException -> 0x006d }
            if (r9 != 0) goto L_0x0044
            r1.close()
            return r0
        L_0x0044:
            r2 = 2
            java.lang.String r5 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x006d }
            com.google.android.gms.measurement.internal.d4 r2 = new com.google.android.gms.measurement.internal.d4     // Catch:{ SQLiteException -> 0x006d }
            r3 = r2
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ SQLiteException -> 0x006d }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x006d }
            if (r3 == 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzfr r3 = r10.zzt     // Catch:{ SQLiteException -> 0x006d }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x006d }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r4 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r11)     // Catch:{ SQLiteException -> 0x006d }
            r3.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x006d }
            goto L_0x006f
        L_0x006b:
            r11 = move-exception
            goto L_0x0073
        L_0x006d:
            r2 = move-exception
            goto L_0x007a
        L_0x006f:
            r1.close()
            return r2
        L_0x0073:
            r0 = r1
            goto L_0x009d
        L_0x0075:
            r11 = move-exception
            goto L_0x009d
        L_0x0077:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x007a:
            com.google.android.gms.measurement.internal.zzfr r3 = r10.zzt     // Catch:{ all -> 0x006b }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x006b }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x006b }
            java.lang.String r4 = "Error querying user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r11)     // Catch:{ all -> 0x006b }
            com.google.android.gms.measurement.internal.zzfr r5 = r10.zzt     // Catch:{ all -> 0x006b }
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()     // Catch:{ all -> 0x006b }
            java.lang.String r12 = r5.zzf(r12)     // Catch:{ all -> 0x006b }
            r3.zzd(r4, r11, r12, r2)     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x009c
            r1.close()
        L_0x009c:
            return r0
        L_0x009d:
            if (r0 == 0) goto L_0x00a2
            r0.close()
        L_0x00a2:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.J(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.d4");
    }

    /* access modifiers changed from: package-private */
    public final Object K(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 0) {
            this.zzt.zzay().zzd().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i10));
            }
            if (type == 3) {
                return cursor.getString(i10);
            }
            if (type != 4) {
                this.zzt.zzay().zzd().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.zzt.zzay().zzd().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final List L(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat(ProxyConfig.MATCH_ALL_SCHEMES));
            sb2.append(" and name glob ?");
        }
        return M(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List M(String str, String[] strArr) {
        boolean z10;
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase zzh = zzh();
            String[] strArr2 = {Constant.PARAM_APP_ID, "origin", "name", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            this.zzt.zzf();
            Cursor query = zzh.query("conditional_properties", strArr2, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (query.moveToFirst()) {
                while (true) {
                    int size = arrayList.size();
                    this.zzt.zzf();
                    if (size < 1000) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object K = K(query, 3);
                        if (query.getInt(4) != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        String string4 = query.getString(5);
                        long j10 = query.getLong(6);
                        zzkv zzu = this.zzf.zzu();
                        byte[] blob = query.getBlob(7);
                        Parcelable.Creator<zzaw> creator = zzaw.CREATOR;
                        arrayList.add(new zzac(string, string2, new zzkw(string3, query.getLong(10), K, string2), query.getLong(8), z10, string4, (zzaw) zzu.zzh(blob, creator), j10, (zzaw) this.zzf.zzu().zzh(query.getBlob(9), creator), query.getLong(11), (zzaw) this.zzf.zzu().zzh(query.getBlob(12), creator)));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } else {
                        zzef zzd = this.zzt.zzay().zzd();
                        this.zzt.zzf();
                        zzd.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                }
                query.close();
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzb("Error querying conditional user property value", e10);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List N(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            this.zzt.zzf();
            Cursor query = zzh().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j10 = query.getLong(2);
                    Object K = K(query, 3);
                    if (K == null) {
                        this.zzt.zzay().zzd().zzb("Read invalid user property value, ignoring it. appId", zzeh.zzn(str));
                    } else {
                        arrayList.add(new d4(str, str2, string, j10, K));
                    }
                } while (query.moveToNext());
                query.close();
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error querying user properties. appId", zzeh.zzn(str), e10);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List O(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r18)
            r17.zzg()
            r17.zzW()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r11 = "1001"
            r12 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0108 }
            r13 = 3
            r3.<init>(r13)     // Catch:{ SQLiteException -> 0x0108 }
            r14 = r18
            r3.add(r14)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x0104 }
            boolean r5 = android.text.TextUtils.isEmpty(r19)     // Catch:{ SQLiteException -> 0x0104 }
            if (r5 != 0) goto L_0x0038
            r15 = r19
            r3.add(r15)     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r5 = " and origin=?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x00eb }
            goto L_0x003a
        L_0x0038:
            r15 = r19
        L_0x003a:
            boolean r5 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SQLiteException -> 0x00eb }
            if (r5 != 0) goto L_0x0059
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00eb }
            r5.<init>()     // Catch:{ SQLiteException -> 0x00eb }
            r5.append(r0)     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r6 = "*"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x00eb }
            r3.add(r5)     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r5 = " and name glob ?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x00eb }
        L_0x0059:
            int r5 = r3.size()     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ SQLiteException -> 0x00eb }
            r7 = r3
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ SQLiteException -> 0x00eb }
            android.database.sqlite.SQLiteDatabase r3 = r17.zzh()     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r5 = "user_attributes"
            java.lang.String r6 = "name"
            java.lang.String r8 = "set_timestamp"
            java.lang.String r9 = "value"
            java.lang.String r10 = "origin"
            java.lang.String[] r6 = new java.lang.String[]{r6, r8, r9, r10}     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r8 = r4.toString()     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r10 = "rowid"
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ SQLiteException -> 0x00eb }
            r4.zzf()     // Catch:{ SQLiteException -> 0x00eb }
            r9 = 0
            r16 = 0
            r4 = r5
            r5 = r6
            r6 = r8
            r8 = r9
            r9 = r16
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00eb }
            boolean r3 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x00eb }
            if (r3 != 0) goto L_0x009a
            r12.close()
            return r2
        L_0x009a:
            int r3 = r2.size()     // Catch:{ SQLiteException -> 0x00eb }
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ SQLiteException -> 0x00eb }
            r4.zzf()     // Catch:{ SQLiteException -> 0x00eb }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x00c2
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x00eb }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x00eb }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r3 = "Read more than the max allowed user properties, ignoring excess"
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x00eb }
            r5.zzf()     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x00eb }
            r0.zzb(r3, r4)     // Catch:{ SQLiteException -> 0x00eb }
            goto L_0x0100
        L_0x00c0:
            r0 = move-exception
            goto L_0x0129
        L_0x00c2:
            r3 = 0
            java.lang.String r7 = r12.getString(r3)     // Catch:{ SQLiteException -> 0x00eb }
            r3 = 1
            long r8 = r12.getLong(r3)     // Catch:{ SQLiteException -> 0x00eb }
            r3 = 2
            java.lang.Object r10 = r1.K(r12, r3)     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r15 = r12.getString(r13)     // Catch:{ SQLiteException -> 0x00eb }
            if (r10 != 0) goto L_0x00ed
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ SQLiteException -> 0x00eb }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x00eb }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r4 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r18)     // Catch:{ SQLiteException -> 0x00eb }
            r3.zzd(r4, r5, r15, r0)     // Catch:{ SQLiteException -> 0x00eb }
            goto L_0x00f9
        L_0x00eb:
            r0 = move-exception
            goto L_0x010c
        L_0x00ed:
            com.google.android.gms.measurement.internal.d4 r3 = new com.google.android.gms.measurement.internal.d4     // Catch:{ SQLiteException -> 0x00eb }
            r4 = r3
            r5 = r18
            r6 = r15
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x00eb }
            r2.add(r3)     // Catch:{ SQLiteException -> 0x00eb }
        L_0x00f9:
            boolean r3 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x00eb }
            if (r3 == 0) goto L_0x0100
            goto L_0x009a
        L_0x0100:
            r12.close()
            return r2
        L_0x0104:
            r0 = move-exception
        L_0x0105:
            r15 = r19
            goto L_0x010c
        L_0x0108:
            r0 = move-exception
            r14 = r18
            goto L_0x0105
        L_0x010c:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x00c0 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x00c0 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x00c0 }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r18)     // Catch:{ all -> 0x00c0 }
            r2.zzd(r3, r4, r15, r0)     // Catch:{ all -> 0x00c0 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00c0 }
            if (r12 == 0) goto L_0x0128
            r12.close()
        L_0x0128:
            return r0
        L_0x0129:
            if (r12 == 0) goto L_0x012e
            r12.close()
        L_0x012e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.O(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void P() {
        zzW();
        zzh().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final void Q(List list) {
        zzg();
        zzW();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (h()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (v("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                this.zzt.zzay().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                zzh().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e10) {
                this.zzt.zzay().zzd().zzb("Error incrementing retry count. error", e10);
            }
        }
    }

    public final void a(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            zzh().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzd("Error deleting user property. appId", zzeh.zzn(str), this.zzt.zzj().zzf(str2), e10);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x032d, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzi());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0336, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0337, code lost:
        r10.put("session_scoped", r0);
        r10.put("data", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x034b, code lost:
        if (zzh().insertWithOnConflict("property_filters", (java.lang.String) null, r10, 5) != -1) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x034d, code lost:
        r1.zzt.zzay().zzd().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzeh.zzn(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0361, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0363, code lost:
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r1.zzt.zzay().zzd().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r24), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03a7, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x017b, code lost:
        r10 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0187, code lost:
        if (r10.hasNext() == false) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0193, code lost:
        if (((com.google.android.gms.internal.measurement.zzet) r10.next()).zzj() != false) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0195, code lost:
        r1.zzt.zzay().zzk().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzeh.zzn(r24), java.lang.Integer.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01ae, code lost:
        r10 = r0.zzg().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01c4, code lost:
        if (r10.hasNext() == false) goto L_0x029a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r11 = (com.google.android.gms.internal.measurement.zzek) r10.next();
        zzW();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e0, code lost:
        if (r11.zzg().isEmpty() == false) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01e2, code lost:
        r0 = r1.zzt.zzay().zzk();
        r10 = com.google.android.gms.measurement.internal.zzeh.zzn(r24);
        r12 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01fa, code lost:
        if (r11.zzp() == false) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01fc, code lost:
        r16 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0207, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0209, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r10, r12, java.lang.String.valueOf(r16));
        r21 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0214, code lost:
        r3 = r11.zzbu();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put(com.zing.zalo.zalosdk.common.Constant.PARAM_APP_ID, r2);
        r7.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x022d, code lost:
        if (r11.zzp() == false) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x022f, code lost:
        r8 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0238, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0239, code lost:
        r7.put("filter_id", r8);
        r7.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME, r11.zzg());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0249, code lost:
        if (r11.zzq() == false) goto L_0x0254;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x024b, code lost:
        r8 = java.lang.Boolean.valueOf(r11.zzn());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0254, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0255, code lost:
        r7.put("session_scoped", r8);
        r7.put("data", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0269, code lost:
        if (zzh().insertWithOnConflict("event_filters", (java.lang.String) null, r7, 5) != -1) goto L_0x027e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x026b, code lost:
        r1.zzt.zzay().zzd().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzeh.zzn(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x027e, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x029a, code lost:
        r21 = r7;
        r0 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02a8, code lost:
        if (r0.hasNext() == false) goto L_0x03a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02aa, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzet) r0.next();
        zzW();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02c4, code lost:
        if (r3.zze().isEmpty() == false) goto L_0x02f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02c6, code lost:
        r0 = r1.zzt.zzay().zzk();
        r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24);
        r10 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02de, code lost:
        if (r3.zzj() == false) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02e0, code lost:
        r16 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02eb, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02ed, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r10, java.lang.String.valueOf(r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02f6, code lost:
        r7 = r3.zzbu();
        r10 = new android.content.ContentValues();
        r10.put(com.zing.zalo.zalosdk.common.Constant.PARAM_APP_ID, r2);
        r10.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x030d, code lost:
        if (r3.zzj() == false) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x030f, code lost:
        r11 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0318, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0319, code lost:
        r10.put("filter_id", r11);
        r22 = r0;
        r10.put("property_name", r3.zze());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x032b, code lost:
        if (r3.zzk() == false) goto L_0x0336;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r24, java.util.List r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r5 = "event_filters"
            java.lang.String r6 = "property_filters"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r8 = 0
        L_0x0012:
            int r9 = r25.size()
            if (r8 >= r9) goto L_0x00dc
            java.lang.Object r9 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzei r9 = (com.google.android.gms.internal.measurement.zzei) r9
            com.google.android.gms.internal.measurement.zzkb r9 = r9.zzby()
            com.google.android.gms.internal.measurement.zzeh r9 = (com.google.android.gms.internal.measurement.zzeh) r9
            int r10 = r9.zza()
            if (r10 == 0) goto L_0x009d
            r10 = 0
        L_0x002b:
            int r11 = r9.zza()
            if (r10 >= r11) goto L_0x009d
            com.google.android.gms.internal.measurement.zzek r11 = r9.zze(r10)
            com.google.android.gms.internal.measurement.zzkb r11 = r11.zzby()
            com.google.android.gms.internal.measurement.zzej r11 = (com.google.android.gms.internal.measurement.zzej) r11
            com.google.android.gms.internal.measurement.zzkb r12 = r11.zzau()
            com.google.android.gms.internal.measurement.zzej r12 = (com.google.android.gms.internal.measurement.zzej) r12
            java.lang.String r13 = r11.zze()
            java.lang.String r13 = com.google.android.gms.measurement.internal.zzgo.zzb(r13)
            if (r13 == 0) goto L_0x0050
            r12.zzb(r13)
            r13 = 1
            goto L_0x0051
        L_0x0050:
            r13 = 0
        L_0x0051:
            r15 = 0
        L_0x0052:
            int r14 = r11.zza()
            if (r15 >= r14) goto L_0x0088
            com.google.android.gms.internal.measurement.zzem r14 = r11.zzd(r15)
            java.lang.String r7 = r14.zze()
            r17 = r11
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.zzgp.zza
            r18 = r4
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzgp.zzb
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzid.zzb(r7, r11, r4)
            if (r4 == 0) goto L_0x0081
            com.google.android.gms.internal.measurement.zzkb r7 = r14.zzby()
            com.google.android.gms.internal.measurement.zzel r7 = (com.google.android.gms.internal.measurement.zzel) r7
            r7.zza(r4)
            com.google.android.gms.internal.measurement.zzkf r4 = r7.zzaC()
            com.google.android.gms.internal.measurement.zzem r4 = (com.google.android.gms.internal.measurement.zzem) r4
            r12.zzc(r15, r4)
            r13 = 1
        L_0x0081:
            int r15 = r15 + 1
            r11 = r17
            r4 = r18
            goto L_0x0052
        L_0x0088:
            r18 = r4
            if (r13 == 0) goto L_0x0098
            r9.zzc(r10, r12)
            com.google.android.gms.internal.measurement.zzkf r4 = r9.zzaC()
            com.google.android.gms.internal.measurement.zzei r4 = (com.google.android.gms.internal.measurement.zzei) r4
            r3.set(r8, r4)
        L_0x0098:
            int r10 = r10 + 1
            r4 = r18
            goto L_0x002b
        L_0x009d:
            r18 = r4
            int r4 = r9.zzb()
            if (r4 == 0) goto L_0x00d6
            r4 = 0
        L_0x00a6:
            int r7 = r9.zzb()
            if (r4 >= r7) goto L_0x00d6
            com.google.android.gms.internal.measurement.zzet r7 = r9.zzf(r4)
            java.lang.String r10 = r7.zze()
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.zzgq.zza
            java.lang.String[] r12 = com.google.android.gms.measurement.internal.zzgq.zzb
            java.lang.String r10 = com.google.android.gms.measurement.internal.zzid.zzb(r10, r11, r12)
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.internal.measurement.zzkb r7 = r7.zzby()
            com.google.android.gms.internal.measurement.zzes r7 = (com.google.android.gms.internal.measurement.zzes) r7
            r7.zza(r10)
            r9.zzd(r4, r7)
            com.google.android.gms.internal.measurement.zzkf r7 = r9.zzaC()
            com.google.android.gms.internal.measurement.zzei r7 = (com.google.android.gms.internal.measurement.zzei) r7
            r3.set(r8, r7)
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x00a6
        L_0x00d6:
            int r8 = r8 + 1
            r4 = r18
            goto L_0x0012
        L_0x00dc:
            r18 = r4
            r23.zzW()
            r23.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            android.database.sqlite.SQLiteDatabase r4 = r23.zzh()
            r4.beginTransaction()
            r23.zzW()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r7 = r23.zzh()     // Catch:{ all -> 0x0142 }
            java.lang.String[] r8 = new java.lang.String[]{r24}     // Catch:{ all -> 0x0142 }
            r7.delete(r6, r0, r8)     // Catch:{ all -> 0x0142 }
            java.lang.String[] r8 = new java.lang.String[]{r24}     // Catch:{ all -> 0x0142 }
            r7.delete(r5, r0, r8)     // Catch:{ all -> 0x0142 }
            java.util.Iterator r7 = r25.iterator()     // Catch:{ all -> 0x0142 }
        L_0x0110:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0142 }
            if (r0 == 0) goto L_0x03aa
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ all -> 0x0142 }
            r23.zzW()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0142 }
            boolean r9 = r0.zzk()     // Catch:{ all -> 0x0142 }
            if (r9 != 0) goto L_0x0145
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "Audience with no ID. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0142 }
            r0.zzb(r8, r9)     // Catch:{ all -> 0x0142 }
            goto L_0x0110
        L_0x0142:
            r0 = move-exception
            goto L_0x0484
        L_0x0145:
            int r9 = r0.zza()     // Catch:{ all -> 0x0142 }
            java.util.List r10 = r0.zzg()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0142 }
        L_0x0151:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x017b
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzek r11 = (com.google.android.gms.internal.measurement.zzek) r11     // Catch:{ all -> 0x0142 }
            boolean r11 = r11.zzp()     // Catch:{ all -> 0x0142 }
            if (r11 != 0) goto L_0x0151
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            r0.zzc(r8, r10, r9)     // Catch:{ all -> 0x0142 }
            goto L_0x0110
        L_0x017b:
            java.util.List r10 = r0.zzh()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0142 }
        L_0x0183:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x01ae
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzet r11 = (com.google.android.gms.internal.measurement.zzet) r11     // Catch:{ all -> 0x0142 }
            boolean r11 = r11.zzj()     // Catch:{ all -> 0x0142 }
            if (r11 != 0) goto L_0x0183
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            r0.zzc(r8, r10, r9)     // Catch:{ all -> 0x0142 }
            goto L_0x0110
        L_0x01ae:
            java.util.List r10 = r0.zzg()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0142 }
        L_0x01b6:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0142 }
            java.lang.String r15 = "data"
            java.lang.String r12 = "session_scoped"
            java.lang.String r13 = "filter_id"
            java.lang.String r8 = "audience_id"
            java.lang.String r14 = "app_id"
            if (r11 == 0) goto L_0x029a
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzek r11 = (com.google.android.gms.internal.measurement.zzek) r11     // Catch:{ all -> 0x0142 }
            r23.zzW()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x0142 }
            java.lang.String r21 = r11.zzg()     // Catch:{ all -> 0x0142 }
            boolean r21 = r21.isEmpty()     // Catch:{ all -> 0x0142 }
            if (r21 == 0) goto L_0x0214
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            boolean r13 = r11.zzp()     // Catch:{ all -> 0x0142 }
            if (r13 == 0) goto L_0x0207
            int r11 = r11.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0142 }
            r16 = r11
            goto L_0x0209
        L_0x0207:
            r16 = 0
        L_0x0209:
            java.lang.String r11 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x0142 }
            r0.zzd(r8, r10, r12, r11)     // Catch:{ all -> 0x0142 }
            r21 = r7
            goto L_0x037a
        L_0x0214:
            byte[] r3 = r11.zzbu()     // Catch:{ all -> 0x0142 }
            r21 = r7
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x0142 }
            r7.<init>()     // Catch:{ all -> 0x0142 }
            r7.put(r14, r2)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            r7.put(r8, r14)     // Catch:{ all -> 0x0142 }
            boolean r8 = r11.zzp()     // Catch:{ all -> 0x0142 }
            if (r8 == 0) goto L_0x0238
            int r8 = r11.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0142 }
            goto L_0x0239
        L_0x0238:
            r8 = 0
        L_0x0239:
            r7.put(r13, r8)     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "event_name"
            java.lang.String r13 = r11.zzg()     // Catch:{ all -> 0x0142 }
            r7.put(r8, r13)     // Catch:{ all -> 0x0142 }
            boolean r8 = r11.zzq()     // Catch:{ all -> 0x0142 }
            if (r8 == 0) goto L_0x0254
            boolean r8 = r11.zzn()     // Catch:{ all -> 0x0142 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x0142 }
            goto L_0x0255
        L_0x0254:
            r8 = 0
        L_0x0255:
            r7.put(r12, r8)     // Catch:{ all -> 0x0142 }
            r7.put(r15, r3)     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r3 = r23.zzh()     // Catch:{ SQLiteException -> 0x0284 }
            r8 = 0
            r11 = 5
            long r11 = r3.insertWithOnConflict(r5, r8, r7, r11)     // Catch:{ SQLiteException -> 0x0284 }
            r7 = -1
            int r3 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x027e
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ SQLiteException -> 0x0284 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x0284 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0284 }
            java.lang.String r7 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ SQLiteException -> 0x0284 }
            r3.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0284 }
        L_0x027e:
            r3 = r25
            r7 = r21
            goto L_0x01b6
        L_0x0284:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = "Error storing event filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0142 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0142 }
            goto L_0x037a
        L_0x029a:
            r21 = r7
            java.util.List r0 = r0.zzh()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0142 }
        L_0x02a4:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0142 }
            if (r3 == 0) goto L_0x03a7
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzet r3 = (com.google.android.gms.internal.measurement.zzet) r3     // Catch:{ all -> 0x0142 }
            r23.zzW()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = r3.zze()     // Catch:{ all -> 0x0142 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0142 }
            if (r7 == 0) goto L_0x02f6
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            boolean r11 = r3.zzj()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x02eb
            int r3 = r3.zza()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0142 }
            r16 = r3
            goto L_0x02ed
        L_0x02eb:
            r16 = 0
        L_0x02ed:
            java.lang.String r3 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x0142 }
            r0.zzd(r7, r8, r10, r3)     // Catch:{ all -> 0x0142 }
            goto L_0x037a
        L_0x02f6:
            byte[] r7 = r3.zzbu()     // Catch:{ all -> 0x0142 }
            android.content.ContentValues r10 = new android.content.ContentValues     // Catch:{ all -> 0x0142 }
            r10.<init>()     // Catch:{ all -> 0x0142 }
            r10.put(r14, r2)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            r10.put(r8, r11)     // Catch:{ all -> 0x0142 }
            boolean r11 = r3.zzj()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x0318
            int r11 = r3.zza()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0142 }
            goto L_0x0319
        L_0x0318:
            r11 = 0
        L_0x0319:
            r10.put(r13, r11)     // Catch:{ all -> 0x0142 }
            java.lang.String r11 = "property_name"
            r22 = r0
            java.lang.String r0 = r3.zze()     // Catch:{ all -> 0x0142 }
            r10.put(r11, r0)     // Catch:{ all -> 0x0142 }
            boolean r0 = r3.zzk()     // Catch:{ all -> 0x0142 }
            if (r0 == 0) goto L_0x0336
            boolean r0 = r3.zzi()     // Catch:{ all -> 0x0142 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0142 }
            goto L_0x0337
        L_0x0336:
            r0 = 0
        L_0x0337:
            r10.put(r12, r0)     // Catch:{ all -> 0x0142 }
            r10.put(r15, r7)     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r0 = r23.zzh()     // Catch:{ SQLiteException -> 0x0361 }
            r3 = 0
            r7 = 5
            long r10 = r0.insertWithOnConflict(r6, r3, r10, r7)     // Catch:{ SQLiteException -> 0x0361 }
            r19 = -1
            int r0 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r0 != 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0361 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0361 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0361 }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ SQLiteException -> 0x0361 }
            r0.zzb(r3, r7)     // Catch:{ SQLiteException -> 0x0361 }
            goto L_0x037a
        L_0x0361:
            r0 = move-exception
            goto L_0x0367
        L_0x0363:
            r0 = r22
            goto L_0x02a4
        L_0x0367:
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = "Error storing property filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0142 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0142 }
        L_0x037a:
            r23.zzW()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r0 = r23.zzh()     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0142 }
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0142 }
            r7 = r18
            r0.delete(r6, r7, r3)     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0142 }
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0142 }
            r0.delete(r5, r7, r3)     // Catch:{ all -> 0x0142 }
            r3 = r25
            r18 = r7
        L_0x03a3:
            r7 = r21
            goto L_0x0110
        L_0x03a7:
            r3 = r25
            goto L_0x03a3
        L_0x03aa:
            r3 = 0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0142 }
            r0.<init>()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r5 = r25.iterator()     // Catch:{ all -> 0x0142 }
        L_0x03b4:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0142 }
            if (r6 == 0) goto L_0x03d4
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzei r6 = (com.google.android.gms.internal.measurement.zzei) r6     // Catch:{ all -> 0x0142 }
            boolean r7 = r6.zzk()     // Catch:{ all -> 0x0142 }
            if (r7 == 0) goto L_0x03cf
            int r6 = r6.zza()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0142 }
            goto L_0x03d0
        L_0x03cf:
            r8 = r3
        L_0x03d0:
            r0.add(r8)     // Catch:{ all -> 0x0142 }
            goto L_0x03b4
        L_0x03d4:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            r23.zzW()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r3 = r23.zzh()     // Catch:{ all -> 0x0142 }
            java.lang.String[] r5 = new java.lang.String[]{r24}     // Catch:{ SQLiteException -> 0x0469 }
            java.lang.String r6 = "select count(1) from audience_filter_values where app_id=?"
            long r5 = r1.v(r6, r5)     // Catch:{ SQLiteException -> 0x0469 }
            com.google.android.gms.measurement.internal.zzfr r7 = r1.zzt     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzag r7 = r7.zzf()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzE     // Catch:{ all -> 0x0142 }
            int r7 = r7.zze(r2, r8)     // Catch:{ all -> 0x0142 }
            r8 = 2000(0x7d0, float:2.803E-42)
            int r7 = java.lang.Math.min(r8, r7)     // Catch:{ all -> 0x0142 }
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)     // Catch:{ all -> 0x0142 }
            long r9 = (long) r7     // Catch:{ all -> 0x0142 }
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0408
            goto L_0x047d
        L_0x0408:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0142 }
            r5.<init>()     // Catch:{ all -> 0x0142 }
        L_0x040d:
            int r6 = r0.size()     // Catch:{ all -> 0x0142 }
            if (r8 >= r6) goto L_0x0429
            java.lang.Object r6 = r0.get(r8)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0142 }
            if (r6 == 0) goto L_0x047d
            int r6 = r6.intValue()     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0142 }
            r5.add(r6)     // Catch:{ all -> 0x0142 }
            int r8 = r8 + 1
            goto L_0x040d
        L_0x0429:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r5)     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r5.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = "("
            r5.append(r6)     // Catch:{ all -> 0x0142 }
            r5.append(r0)     // Catch:{ all -> 0x0142 }
            java.lang.String r0 = ")"
            r5.append(r0)     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r0.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            r0.append(r6)     // Catch:{ all -> 0x0142 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0142 }
            r0.append(r5)     // Catch:{ all -> 0x0142 }
            java.lang.String r5 = " order by rowid desc limit -1 offset ?)"
            r0.append(r5)     // Catch:{ all -> 0x0142 }
            java.lang.String r5 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0142 }
            java.lang.String[] r2 = new java.lang.String[]{r2, r5}     // Catch:{ all -> 0x0142 }
            java.lang.String r5 = "audience_filter_values"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0142 }
            r3.delete(r5, r0, r2)     // Catch:{ all -> 0x0142 }
            goto L_0x047d
        L_0x0469:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0142 }
            java.lang.String r5 = "Database error querying filters. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0142 }
            r3.zzc(r5, r2, r0)     // Catch:{ all -> 0x0142 }
        L_0x047d:
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0142 }
            r4.endTransaction()
            return
        L_0x0484:
            r4.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.b(java.lang.String, java.util.List):void");
    }

    public final void c(c1 c1Var) {
        Preconditions.checkNotNull(c1Var);
        zzg();
        zzW();
        String d02 = c1Var.d0();
        Preconditions.checkNotNull(d02);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.PARAM_APP_ID, d02);
        contentValues.put("app_instance_id", c1Var.e0());
        contentValues.put("gmp_app_id", c1Var.i0());
        contentValues.put("resettable_device_id_hash", c1Var.a());
        contentValues.put("last_bundle_index", Long.valueOf(c1Var.Y()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(c1Var.Z()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(c1Var.X()));
        contentValues.put("app_version", c1Var.g0());
        contentValues.put("app_store", c1Var.f0());
        contentValues.put("gmp_version", Long.valueOf(c1Var.W()));
        contentValues.put("dev_cert_hash", Long.valueOf(c1Var.T()));
        contentValues.put("measurement_enabled", Boolean.valueOf(c1Var.J()));
        contentValues.put("day", Long.valueOf(c1Var.S()));
        contentValues.put("daily_public_events_count", Long.valueOf(c1Var.Q()));
        contentValues.put("daily_events_count", Long.valueOf(c1Var.P()));
        contentValues.put("daily_conversions_count", Long.valueOf(c1Var.N()));
        contentValues.put("config_fetched_time", Long.valueOf(c1Var.M()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(c1Var.V()));
        contentValues.put("app_version_int", Long.valueOf(c1Var.L()));
        contentValues.put("firebase_instance_id", c1Var.h0());
        contentValues.put("daily_error_events_count", Long.valueOf(c1Var.O()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(c1Var.R()));
        contentValues.put("health_monitor_sample", c1Var.j0());
        c1Var.A();
        contentValues.put("android_id", 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(c1Var.I()));
        contentValues.put("admob_app_id", c1Var.b0());
        contentValues.put("dynamite_version", Long.valueOf(c1Var.U()));
        contentValues.put("session_stitching_token", c1Var.b());
        List c10 = c1Var.c();
        if (c10 != null) {
            if (c10.isEmpty()) {
                this.zzt.zzay().zzk().zzb("Safelisted events should not be an empty list. appId", d02);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", c10));
            }
        }
        zznt.zzc();
        if (this.zzt.zzf().zzs((String) null, zzdu.zzai) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase zzh = zzh();
            if (((long) zzh.update("apps", contentValues, "app_id = ?", new String[]{d02})) == 0 && zzh.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                this.zzt.zzay().zzd().zzb("Failed to insert/update app (got -1). appId", zzeh.zzn(d02));
            }
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing app. appId", zzeh.zzn(d02), e10);
        }
    }

    public final void d(i iVar) {
        long j10;
        Preconditions.checkNotNull(iVar);
        zzg();
        zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.PARAM_APP_ID, iVar.f7537a);
        contentValues.put("name", iVar.f7538b);
        contentValues.put("lifetime_count", Long.valueOf(iVar.f7539c));
        contentValues.put("current_bundle_count", Long.valueOf(iVar.f7540d));
        contentValues.put("last_fire_timestamp", Long.valueOf(iVar.f7542f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(iVar.f7543g));
        contentValues.put("last_bundled_day", iVar.f7544h);
        contentValues.put("last_sampled_complex_event_id", iVar.f7545i);
        contentValues.put("last_sampling_rate", iVar.f7546j);
        contentValues.put("current_session_count", Long.valueOf(iVar.f7541e));
        Boolean bool = iVar.f7547k;
        if (bool == null || !bool.booleanValue()) {
            j10 = null;
        } else {
            j10 = 1L;
        }
        contentValues.put("last_exempt_from_sampling", j10);
        try {
            if (zzh().insertWithOnConflict(DbParams.TABLE_EVENTS, (String) null, contentValues, 5) == -1) {
                this.zzt.zzay().zzd().zzb("Failed to insert/update event aggregates (got -1). appId", zzeh.zzn(iVar.f7537a));
            }
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing event aggregates. appId", zzeh.zzn(iVar.f7537a), e10);
        }
    }

    public final boolean e() {
        if (v("select count(1) > 0 from raw_events", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (v("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (v("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean h() {
        Context zzau = this.zzt.zzau();
        this.zzt.zzf();
        return zzau.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean i(String str, Long l10, long j10, zzft zzft) {
        zzg();
        zzW();
        Preconditions.checkNotNull(zzft);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l10);
        byte[] zzbu = zzft.zzbu();
        this.zzt.zzay().zzj().zzc("Saving complex main event, appId, data size", this.zzt.zzj().zzd(str), Integer.valueOf(zzbu.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.PARAM_APP_ID, str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", zzbu);
        try {
            if (zzh().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzt.zzay().zzd().zzb("Failed to insert complex main event (got -1). appId", zzeh.zzn(str));
            return false;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing complex main event. appId", zzeh.zzn(str), e10);
            return false;
        }
    }

    public final boolean j(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        zzg();
        zzW();
        String str = zzac.zza;
        Preconditions.checkNotNull(str);
        if (J(str, zzac.zzc.zzb) == null) {
            long v10 = v("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzt.zzf();
            if (v10 >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.PARAM_APP_ID, str);
        contentValues.put("origin", zzac.zzb);
        contentValues.put("name", zzac.zzc.zzb);
        u(contentValues, "value", Preconditions.checkNotNull(zzac.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzac.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzac.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzac.zzh));
        contentValues.put("timed_out_event", this.zzt.zzv().zzan(zzac.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzac.zzd));
        contentValues.put("triggered_event", this.zzt.zzv().zzan(zzac.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzac.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzac.zzj));
        contentValues.put("expired_event", this.zzt.zzv().zzan(zzac.zzk));
        try {
            if (zzh().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzt.zzay().zzd().zzb("Failed to insert/update conditional user property (got -1)", zzeh.zzn(str));
            return true;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing conditional user property", zzeh.zzn(str), e10);
            return true;
        }
    }

    public final boolean k(d4 d4Var) {
        Preconditions.checkNotNull(d4Var);
        zzg();
        zzW();
        if (J(d4Var.f7461a, d4Var.f7463c) == null) {
            if (zzlb.zzai(d4Var.f7463c)) {
                if (v("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{d4Var.f7461a}) >= ((long) this.zzt.zzf().zzf(d4Var.f7461a, zzdu.zzF, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(d4Var.f7463c)) {
                long v10 = v("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{d4Var.f7461a, d4Var.f7462b});
                this.zzt.zzf();
                if (v10 >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.PARAM_APP_ID, d4Var.f7461a);
        contentValues.put("origin", d4Var.f7462b);
        contentValues.put("name", d4Var.f7463c);
        contentValues.put("set_timestamp", Long.valueOf(d4Var.f7464d));
        u(contentValues, "value", d4Var.f7465e);
        try {
            if (zzh().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzt.zzay().zzd().zzb("Failed to insert/update user property (got -1). appId", zzeh.zzn(d4Var.f7461a));
            return true;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing user property. appId", zzeh.zzn(d4Var.f7461a), e10);
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0041=Splitter:B:16:0x0041, B:36:0x0091=Splitter:B:36:0x0091} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(java.lang.String r20, long r21, long r23, com.google.android.gms.measurement.internal.b4 r25) {
        /*
            r19 = this;
            r1 = r19
            r2 = r25
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r19.zzg()
            r19.zzW()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r19.zzh()     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            r13 = 1
            java.lang.String r5 = ""
            r14 = -1
            r12 = 0
            if (r4 == 0) goto L_0x007c
            int r4 = (r23 > r14 ? 1 : (r23 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x0035
            java.lang.String r6 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r7 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String[] r6 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            goto L_0x003d
        L_0x002f:
            r0 = move-exception
            goto L_0x0215
        L_0x0032:
            r0 = move-exception
            goto L_0x01fb
        L_0x0035:
            java.lang.String r6 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String[] r6 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
        L_0x003d:
            if (r4 == 0) goto L_0x0041
            java.lang.String r5 = "rowid <= ? and "
        L_0x0041:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r4.append(r7)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0076 }
            if (r5 != 0) goto L_0x0065
            r4.close()
            return
        L_0x0065:
            java.lang.String r3 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.String r5 = r4.getString(r13)     // Catch:{ SQLiteException -> 0x0076 }
            r4.close()     // Catch:{ SQLiteException -> 0x0076 }
        L_0x0070:
            r16 = r4
            r11 = r5
            goto L_0x00bd
        L_0x0074:
            r0 = move-exception
            goto L_0x0079
        L_0x0076:
            r0 = move-exception
            goto L_0x01fc
        L_0x0079:
            r3 = r4
            goto L_0x0215
        L_0x007c:
            int r4 = (r23 > r14 ? 1 : (r23 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x0089
            java.lang.String r6 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String[] r6 = new java.lang.String[]{r3, r6}     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            goto L_0x008d
        L_0x0089:
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
        L_0x008d:
            if (r4 == 0) goto L_0x0091
            java.lang.String r5 = " and rowid <= ?"
        L_0x0091:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            r4.append(r7)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r5 = " order by rowid limit 1;"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x0032, all -> 0x002f }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0076 }
            if (r5 != 0) goto L_0x00b5
            r4.close()
            return
        L_0x00b5:
            java.lang.String r5 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0076 }
            r4.close()     // Catch:{ SQLiteException -> 0x0076 }
            goto L_0x0070
        L_0x00bd:
            java.lang.String r4 = "metadata"
            java.lang.String[] r6 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x01f3, all -> 0x01f1 }
            java.lang.String[] r8 = new java.lang.String[]{r3, r11}     // Catch:{ SQLiteException -> 0x01f3, all -> 0x01f1 }
            java.lang.String r5 = "raw_events_metadata"
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String r17 = "rowid"
            java.lang.String r18 = "2"
            r9 = 0
            r10 = 0
            r4 = r0
            r13 = r11
            r11 = r17
            r14 = r12
            r12 = r18
            android.database.Cursor r15 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x01f3, all -> 0x01f1 }
            boolean r4 = r15.moveToFirst()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            if (r4 != 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            r0.zzb(r2, r4)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            r15.close()
            return
        L_0x00f9:
            r0 = move-exception
            goto L_0x01ed
        L_0x00fc:
            r0 = move-exception
            goto L_0x01ef
        L_0x00ff:
            byte[] r4 = r15.getBlob(r14)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            com.google.android.gms.internal.measurement.zzgc r5 = com.google.android.gms.internal.measurement.zzgd.zzt()     // Catch:{ IOException -> 0x01d5 }
            com.google.android.gms.internal.measurement.zzll r4 = com.google.android.gms.measurement.internal.zzkv.zzl(r5, r4)     // Catch:{ IOException -> 0x01d5 }
            com.google.android.gms.internal.measurement.zzgc r4 = (com.google.android.gms.internal.measurement.zzgc) r4     // Catch:{ IOException -> 0x01d5 }
            com.google.android.gms.internal.measurement.zzkf r4 = r4.zzaC()     // Catch:{ IOException -> 0x01d5 }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ IOException -> 0x01d5 }
            boolean r5 = r15.moveToNext()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            if (r5 == 0) goto L_0x012c
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzk()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            java.lang.String r6 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
        L_0x012c:
            r15.close()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            r2.f7405a = r4     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            r4 = -1
            int r4 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0147
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String r5 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            java.lang.String[] r5 = new java.lang.String[]{r3, r13, r5}     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
        L_0x0144:
            r7 = r4
            r8 = r5
            goto L_0x014e
        L_0x0147:
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r5 = new java.lang.String[]{r3, r13}     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            goto L_0x0144
        L_0x014e:
            java.lang.String r4 = "rowid"
            java.lang.String r5 = "name"
            java.lang.String r6 = "timestamp"
            java.lang.String r9 = "data"
            java.lang.String[] r6 = new java.lang.String[]{r4, r5, r6, r9}     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            java.lang.String r5 = "raw_events"
            java.lang.String r11 = "rowid"
            r12 = 0
            r9 = 0
            r10 = 0
            r4 = r0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0076 }
            if (r0 == 0) goto L_0x01be
        L_0x016c:
            long r5 = r4.getLong(r14)     // Catch:{ SQLiteException -> 0x0076 }
            r0 = 3
            byte[] r0 = r4.getBlob(r0)     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzfs r7 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x019f }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r7, r0)     // Catch:{ IOException -> 0x019f }
            com.google.android.gms.internal.measurement.zzfs r0 = (com.google.android.gms.internal.measurement.zzfs) r0     // Catch:{ IOException -> 0x019f }
            r7 = 1
            java.lang.String r8 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x0076 }
            r0.zzi(r8)     // Catch:{ SQLiteException -> 0x0076 }
            r8 = 2
            long r8 = r4.getLong(r8)     // Catch:{ SQLiteException -> 0x0076 }
            r0.zzm(r8)     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0     // Catch:{ SQLiteException -> 0x0076 }
            boolean r0 = r2.a(r5, r0)     // Catch:{ SQLiteException -> 0x0076 }
            if (r0 != 0) goto L_0x01b4
            r4.close()
            return
        L_0x019f:
            r0 = move-exception
            r7 = 1
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.String r6 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0076 }
            r5.zzc(r6, r8, r0)     // Catch:{ SQLiteException -> 0x0076 }
        L_0x01b4:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0076 }
            if (r0 != 0) goto L_0x016c
            r4.close()
            return
        L_0x01be:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0076 }
            r0.zzb(r2, r5)     // Catch:{ SQLiteException -> 0x0076 }
            r4.close()
            return
        L_0x01d5:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            r2.zzc(r4, r5, r0)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f9 }
            r15.close()
            return
        L_0x01ed:
            r3 = r15
            goto L_0x0215
        L_0x01ef:
            r4 = r15
            goto L_0x01fc
        L_0x01f1:
            r0 = move-exception
            goto L_0x01f5
        L_0x01f3:
            r0 = move-exception
            goto L_0x01f8
        L_0x01f5:
            r3 = r16
            goto L_0x0215
        L_0x01f8:
            r4 = r16
            goto L_0x01fc
        L_0x01fb:
            r4 = r3
        L_0x01fc:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x0074 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0074 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0074 }
            if (r4 == 0) goto L_0x0214
            r4.close()
        L_0x0214:
            return
        L_0x0215:
            if (r3 == 0) goto L_0x021a
            r3.close()
        L_0x021a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.t(java.lang.String, long, long, com.google.android.gms.measurement.internal.b4):void");
    }

    public final int w(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            return zzh().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzd("Error deleting conditional property", zzeh.zzn(str), this.zzt.zzj().zzf(str2), e10);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final long y(String str, String str2) {
        long j10;
        SQLiteException e10;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzW();
        SQLiteDatabase zzh = zzh();
        zzh.beginTransaction();
        try {
            j10 = x("select " + "first_open_count" + " from app2 where app_id=?", new String[]{str}, -1);
            if (j10 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(Constant.PARAM_APP_ID, str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (zzh.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    this.zzt.zzay().zzd().zzc("Failed to insert column (got -1). appId", zzeh.zzn(str), "first_open_count");
                    zzh.endTransaction();
                    return -1;
                }
                j10 = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(Constant.PARAM_APP_ID, str);
                contentValues2.put("first_open_count", Long.valueOf(1 + j10));
                if (((long) zzh.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    this.zzt.zzay().zzd().zzc("Failed to update column (got 0). appId", zzeh.zzn(str), "first_open_count");
                    zzh.endTransaction();
                    return -1;
                }
                zzh.setTransactionSuccessful();
                zzh.endTransaction();
                return j10;
            } catch (SQLiteException e11) {
                e10 = e11;
                try {
                    this.zzt.zzay().zzd().zzd("Error inserting column. appId", zzeh.zzn(str), "first_open_count", e10);
                    zzh.endTransaction();
                    return j10;
                } catch (Throwable th) {
                    zzh.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            j10 = 0;
            this.zzt.zzay().zzd().zzd("Error inserting column. appId", zzeh.zzn(str), "first_open_count", e10);
            zzh.endTransaction();
            return j10;
        }
    }

    public final long z() {
        return x("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final void zzC() {
        zzW();
        zzh().setTransactionSuccessful();
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase zzh() {
        zzg();
        try {
            return this.f7493a.getWritableDatabase();
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzk().zzb("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzr() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zzh()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0028, all -> 0x0026 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001c }
            if (r2 == 0) goto L_0x001e
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001c }
            r0.close()
            return r1
        L_0x001a:
            r1 = move-exception
            goto L_0x0022
        L_0x001c:
            r2 = move-exception
            goto L_0x002b
        L_0x001e:
            r0.close()
            return r1
        L_0x0022:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0040
        L_0x0026:
            r0 = move-exception
            goto L_0x0040
        L_0x0028:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.zzfr r3 = r6.zzt     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x001a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x003f
            r0.close()
        L_0x003f:
            return r1
        L_0x0040:
            if (r1 == 0) goto L_0x0045
            r1.close()
        L_0x0045:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.zzr():java.lang.String");
    }

    public final void zzw() {
        zzW();
        zzh().beginTransaction();
    }

    /* access modifiers changed from: package-private */
    public final void zzz() {
        zzg();
        zzW();
        if (h()) {
            long zza = this.zzf.zzs().zza.zza();
            long elapsedRealtime = this.zzt.zzav().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza);
            this.zzt.zzf();
            if (abs > ((Long) zzdu.zzx.zza((Object) null)).longValue()) {
                this.zzf.zzs().zza.zzb(elapsedRealtime);
                zzg();
                zzW();
                if (h()) {
                    SQLiteDatabase zzh = zzh();
                    String valueOf = String.valueOf(this.zzt.zzav().currentTimeMillis());
                    this.zzt.zzf();
                    int delete = zzh.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{valueOf, String.valueOf(zzag.zzA())});
                    if (delete > 0) {
                        this.zzt.zzay().zzj().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }
}
