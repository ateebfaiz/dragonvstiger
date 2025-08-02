package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.webkit.ProxyConfig;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class WorkSpecDao_Impl implements WorkSpecDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetPeriodStartTime;

    class a implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f17028a;

        a(RoomSQLiteQuery roomSQLiteQuery) {
            this.f17028a = roomSQLiteQuery;
        }

        /* renamed from: a */
        public List call() {
            Cursor query;
            WorkSpecDao_Impl.this.__db.beginTransaction();
            try {
                query = DBUtil.query(WorkSpecDao_Impl.this.__db, this.f17028a, false, (CancellationSignal) null);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(query.getString(0));
                }
                WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                query.close();
                WorkSpecDao_Impl.this.__db.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                WorkSpecDao_Impl.this.__db.endTransaction();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f17028a.release();
        }
    }

    class b implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f17030a;

        b(RoomSQLiteQuery roomSQLiteQuery) {
            this.f17030a = roomSQLiteQuery;
        }

        /* renamed from: a */
        public List call() {
            Cursor query;
            ArrayList arrayList;
            ArrayList arrayList2;
            WorkSpecDao_Impl.this.__db.beginTransaction();
            try {
                query = DBUtil.query(WorkSpecDao_Impl.this.__db, this.f17030a, true, (CancellationSignal) null);
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string2 = query.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap2.get(string2)) == null) {
                            arrayMap2.put(string2, new ArrayList());
                        }
                    }
                }
                query.moveToPosition(-1);
                WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                ArrayList arrayList3 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                    } else {
                        arrayList = null;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList2 = (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow));
                    } else {
                        arrayList2 = null;
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.f17027id = query.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList;
                    workInfoPojo.progress = arrayList2;
                    arrayList3.add(workInfoPojo);
                }
                WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                query.close();
                WorkSpecDao_Impl.this.__db.endTransaction();
                return arrayList3;
            } catch (Throwable th) {
                WorkSpecDao_Impl.this.__db.endTransaction();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f17030a.release();
        }
    }

    class c implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f17032a;

        c(RoomSQLiteQuery roomSQLiteQuery) {
            this.f17032a = roomSQLiteQuery;
        }

        /* renamed from: a */
        public List call() {
            Cursor query;
            ArrayList arrayList;
            ArrayList arrayList2;
            WorkSpecDao_Impl.this.__db.beginTransaction();
            try {
                query = DBUtil.query(WorkSpecDao_Impl.this.__db, this.f17032a, true, (CancellationSignal) null);
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string2 = query.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap2.get(string2)) == null) {
                            arrayMap2.put(string2, new ArrayList());
                        }
                    }
                }
                query.moveToPosition(-1);
                WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                ArrayList arrayList3 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                    } else {
                        arrayList = null;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList2 = (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow));
                    } else {
                        arrayList2 = null;
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.f17027id = query.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList;
                    workInfoPojo.progress = arrayList2;
                    arrayList3.add(workInfoPojo);
                }
                WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                query.close();
                WorkSpecDao_Impl.this.__db.endTransaction();
                return arrayList3;
            } catch (Throwable th) {
                WorkSpecDao_Impl.this.__db.endTransaction();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f17032a.release();
        }
    }

    class d implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f17034a;

        d(RoomSQLiteQuery roomSQLiteQuery) {
            this.f17034a = roomSQLiteQuery;
        }

        /* renamed from: a */
        public List call() {
            Cursor query;
            ArrayList arrayList;
            ArrayList arrayList2;
            WorkSpecDao_Impl.this.__db.beginTransaction();
            try {
                query = DBUtil.query(WorkSpecDao_Impl.this.__db, this.f17034a, true, (CancellationSignal) null);
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string2 = query.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap2.get(string2)) == null) {
                            arrayMap2.put(string2, new ArrayList());
                        }
                    }
                }
                query.moveToPosition(-1);
                WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                ArrayList arrayList3 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                    } else {
                        arrayList = null;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList2 = (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow));
                    } else {
                        arrayList2 = null;
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.f17027id = query.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList;
                    workInfoPojo.progress = arrayList2;
                    arrayList3.add(workInfoPojo);
                }
                WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                query.close();
                WorkSpecDao_Impl.this.__db.endTransaction();
                return arrayList3;
            } catch (Throwable th) {
                WorkSpecDao_Impl.this.__db.endTransaction();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f17034a.release();
        }
    }

    class e implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f17036a;

        e(RoomSQLiteQuery roomSQLiteQuery) {
            this.f17036a = roomSQLiteQuery;
        }

        /* renamed from: a */
        public Long call() {
            Long l10 = null;
            Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, this.f17036a, false, (CancellationSignal) null);
            try {
                if (query.moveToFirst()) {
                    if (!query.isNull(0)) {
                        l10 = Long.valueOf(query.getLong(0));
                    }
                }
                return l10;
            } finally {
                query.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f17036a.release();
        }
    }

    class f extends EntityInsertionAdapter {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
            String str = workSpec.f17025id;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec.state));
            String str2 = workSpec.workerClassName;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = workSpec.inputMergerClassName;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
            if (byteArrayInternal == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindBlob(5, byteArrayInternal);
            }
            byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
            if (byteArrayInternal2 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
            }
            supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
            supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
            supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
            supportSQLiteStatement.bindLong(10, (long) workSpec.runAttemptCount);
            supportSQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
            supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
            supportSQLiteStatement.bindLong(13, workSpec.periodStartTime);
            supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
            supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
            supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1 : 0);
            supportSQLiteStatement.bindLong(17, (long) WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
            Constraints constraints = workSpec.constraints;
            if (constraints != null) {
                supportSQLiteStatement.bindLong(18, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                supportSQLiteStatement.bindLong(19, constraints.requiresCharging() ? 1 : 0);
                supportSQLiteStatement.bindLong(20, constraints.requiresDeviceIdle() ? 1 : 0);
                supportSQLiteStatement.bindLong(21, constraints.requiresBatteryNotLow() ? 1 : 0);
                supportSQLiteStatement.bindLong(22, constraints.requiresStorageNotLow() ? 1 : 0);
                supportSQLiteStatement.bindLong(23, constraints.getTriggerContentUpdateDelay());
                supportSQLiteStatement.bindLong(24, constraints.getTriggerMaxContentDelay());
                byte[] contentUriTriggersToByteArray = WorkTypeConverters.contentUriTriggersToByteArray(constraints.getContentUriTriggers());
                if (contentUriTriggersToByteArray == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindBlob(25, contentUriTriggersToByteArray);
                }
            } else {
                supportSQLiteStatement.bindNull(18);
                supportSQLiteStatement.bindNull(19);
                supportSQLiteStatement.bindNull(20);
                supportSQLiteStatement.bindNull(21);
                supportSQLiteStatement.bindNull(22);
                supportSQLiteStatement.bindNull(23);
                supportSQLiteStatement.bindNull(24);
                supportSQLiteStatement.bindNull(25);
            }
        }

        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    class g extends SharedSQLiteStatement {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    class h extends SharedSQLiteStatement {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    class i extends SharedSQLiteStatement {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    class j extends SharedSQLiteStatement {
        j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    class k extends SharedSQLiteStatement {
        k(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    class l extends SharedSQLiteStatement {
        l(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    class m extends SharedSQLiteStatement {
        m(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    class n extends SharedSQLiteStatement {
        n(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new f(roomDatabase);
        this.__preparedStmtOfDelete = new g(roomDatabase);
        this.__preparedStmtOfSetOutput = new h(roomDatabase);
        this.__preparedStmtOfSetPeriodStartTime = new i(roomDatabase);
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new j(roomDatabase);
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new k(roomDatabase);
        this.__preparedStmtOfMarkWorkSpecScheduled = new l(roomDatabase);
        this.__preparedStmtOfResetScheduledState = new m(roomDatabase);
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new n(roomDatabase);
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap<String, ArrayList<Data>> arrayMap) {
        ArrayList arrayList;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                int size = arrayMap.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    arrayMap2.put(arrayMap.keyAt(i10), arrayMap.valueAt(i10));
                    i10++;
                    i11++;
                    if (i11 == 999) {
                        __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                        arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        i11 = 0;
                    }
                }
                if (i11 > 0) {
                    __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2);
            int i12 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i12);
                } else {
                    acquire.bindString(i12, next);
                }
                i12++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndex) && (arrayList = arrayMap.get(query.getString(columnIndex))) != null) {
                            arrayList.add(Data.fromByteArray(query.getBlob(0)));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> arrayMap) {
        ArrayList arrayList;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                int size = arrayMap.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    arrayMap2.put(arrayMap.keyAt(i10), arrayMap.valueAt(i10));
                    i10++;
                    i11++;
                    if (i11 == 999) {
                        __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                        arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        i11 = 0;
                    }
                }
                if (i11 > 0) {
                    __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2);
            int i12 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i12);
                } else {
                    acquire.bindString(i12, next);
                }
                i12++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndex) && (arrayList = arrayMap.get(query.getString(columnIndex))) != null) {
                            arrayList.add(query.getString(0));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i10) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        acquire.bindLong(1, (long) i10);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i11 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i12 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i13 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i14 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    if (query.getInt(columnIndexOrThrow2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    constraints.setRequiresCharging(z10);
                    if (query.getInt(columnIndexOrThrow3) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    constraints.setRequiresDeviceIdle(z11);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    constraints.setRequiresBatteryNotLow(z12);
                    if (query.getInt(columnIndexOrThrow5) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    constraints.setRequiresStorageNotLow(z13);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i17 = i11;
                    workSpec.output = Data.fromByteArray(query.getBlob(i17));
                    int i18 = i15;
                    i11 = i17;
                    int i19 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i19);
                    int i20 = columnIndexOrThrow12;
                    int i21 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i21);
                    int i22 = i19;
                    int i23 = columnIndexOrThrow4;
                    int i24 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i24);
                    int i25 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i25);
                    int i26 = columnIndexOrThrow19;
                    int i27 = i21;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i26));
                    columnIndexOrThrow17 = i24;
                    int i28 = i23;
                    int i29 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i29);
                    int i30 = i25;
                    int i31 = i26;
                    int i32 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i32);
                    int i33 = i29;
                    columnIndexOrThrow21 = i32;
                    int i34 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i34);
                    int i35 = i30;
                    int i36 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i36);
                    int i37 = columnIndexOrThrow24;
                    if (query.getInt(i37) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    workSpec.expedited = z14;
                    int i38 = columnIndexOrThrow25;
                    int i39 = i36;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i38));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow25 = i38;
                    columnIndexOrThrow2 = i18;
                    columnIndexOrThrow12 = i20;
                    columnIndexOrThrow15 = i22;
                    columnIndexOrThrow16 = i27;
                    columnIndexOrThrow18 = i35;
                    columnIndexOrThrow23 = i39;
                    columnIndexOrThrow9 = i12;
                    columnIndexOrThrow11 = i13;
                    columnIndexOrThrow = i14;
                    columnIndexOrThrow24 = i37;
                    columnIndexOrThrow22 = i34;
                    columnIndexOrThrow3 = i16;
                    int i40 = i31;
                    columnIndexOrThrow20 = i33;
                    columnIndexOrThrow4 = i28;
                    columnIndexOrThrow19 = i40;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, new a(RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0)));
    }

    public List<WorkSpec> getEligibleWorkForScheduling(int i10) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, (long) i10);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i11 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i12 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i13 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i14 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    if (query.getInt(columnIndexOrThrow2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    constraints.setRequiresCharging(z10);
                    if (query.getInt(columnIndexOrThrow3) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    constraints.setRequiresDeviceIdle(z11);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    constraints.setRequiresBatteryNotLow(z12);
                    if (query.getInt(columnIndexOrThrow5) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    constraints.setRequiresStorageNotLow(z13);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i17 = i11;
                    workSpec.output = Data.fromByteArray(query.getBlob(i17));
                    int i18 = i15;
                    i11 = i17;
                    int i19 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i19);
                    int i20 = columnIndexOrThrow12;
                    int i21 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i21);
                    int i22 = i19;
                    int i23 = columnIndexOrThrow4;
                    int i24 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i24);
                    int i25 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i25);
                    int i26 = columnIndexOrThrow19;
                    int i27 = i21;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i26));
                    columnIndexOrThrow17 = i24;
                    int i28 = i23;
                    int i29 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i29);
                    int i30 = i25;
                    int i31 = i26;
                    int i32 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i32);
                    int i33 = i29;
                    columnIndexOrThrow21 = i32;
                    int i34 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i34);
                    int i35 = i30;
                    int i36 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i36);
                    int i37 = columnIndexOrThrow24;
                    if (query.getInt(i37) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    workSpec.expedited = z14;
                    int i38 = columnIndexOrThrow25;
                    int i39 = i36;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i38));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow25 = i38;
                    columnIndexOrThrow2 = i18;
                    columnIndexOrThrow12 = i20;
                    columnIndexOrThrow15 = i22;
                    columnIndexOrThrow16 = i27;
                    columnIndexOrThrow18 = i35;
                    columnIndexOrThrow23 = i39;
                    columnIndexOrThrow9 = i12;
                    columnIndexOrThrow11 = i13;
                    columnIndexOrThrow = i14;
                    columnIndexOrThrow24 = i37;
                    columnIndexOrThrow22 = i34;
                    columnIndexOrThrow3 = i16;
                    int i40 = i31;
                    columnIndexOrThrow20 = i33;
                    columnIndexOrThrow4 = i28;
                    columnIndexOrThrow19 = i40;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<Data> getInputsFromPrerequisites(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(Data.fromByteArray(query.getBlob(0)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<WorkSpec> getRecentlyCompletedWork(long j10) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        acquire.bindLong(1, j10);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i10 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i11 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i12 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i13 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    if (query.getInt(columnIndexOrThrow2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    constraints.setRequiresCharging(z10);
                    if (query.getInt(columnIndexOrThrow3) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    constraints.setRequiresDeviceIdle(z11);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    constraints.setRequiresBatteryNotLow(z12);
                    if (query.getInt(columnIndexOrThrow5) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    constraints.setRequiresStorageNotLow(z13);
                    int i14 = columnIndexOrThrow2;
                    int i15 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i16 = i10;
                    workSpec.output = Data.fromByteArray(query.getBlob(i16));
                    int i17 = columnIndexOrThrow15;
                    int i18 = i14;
                    i10 = i16;
                    workSpec.initialDelay = query.getLong(i17);
                    int i19 = columnIndexOrThrow12;
                    int i20 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i20);
                    int i21 = i17;
                    int i22 = columnIndexOrThrow4;
                    int i23 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i23);
                    int i24 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i24);
                    int i25 = columnIndexOrThrow19;
                    int i26 = i20;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i25));
                    columnIndexOrThrow17 = i23;
                    int i27 = i22;
                    int i28 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i28);
                    int i29 = i24;
                    int i30 = i25;
                    int i31 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i31);
                    int i32 = i28;
                    columnIndexOrThrow21 = i31;
                    int i33 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i33);
                    int i34 = i29;
                    int i35 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i35);
                    int i36 = columnIndexOrThrow24;
                    if (query.getInt(i36) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    workSpec.expedited = z14;
                    int i37 = columnIndexOrThrow25;
                    int i38 = i35;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i37));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow2 = i18;
                    columnIndexOrThrow25 = i37;
                    columnIndexOrThrow12 = i19;
                    columnIndexOrThrow15 = i21;
                    columnIndexOrThrow16 = i26;
                    columnIndexOrThrow18 = i34;
                    columnIndexOrThrow23 = i38;
                    columnIndexOrThrow9 = i11;
                    columnIndexOrThrow11 = i12;
                    columnIndexOrThrow = i13;
                    columnIndexOrThrow24 = i36;
                    columnIndexOrThrow22 = i33;
                    columnIndexOrThrow3 = i15;
                    int i39 = i30;
                    columnIndexOrThrow20 = i32;
                    columnIndexOrThrow4 = i27;
                    columnIndexOrThrow19 = i39;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i10 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i11 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i12 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i13 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    if (query.getInt(columnIndexOrThrow2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    constraints.setRequiresCharging(z10);
                    if (query.getInt(columnIndexOrThrow3) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    constraints.setRequiresDeviceIdle(z11);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    constraints.setRequiresBatteryNotLow(z12);
                    if (query.getInt(columnIndexOrThrow5) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    constraints.setRequiresStorageNotLow(z13);
                    int i14 = columnIndexOrThrow2;
                    int i15 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i16 = i10;
                    workSpec.output = Data.fromByteArray(query.getBlob(i16));
                    int i17 = i14;
                    i10 = i16;
                    int i18 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i18);
                    int i19 = columnIndexOrThrow13;
                    int i20 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i20);
                    int i21 = i18;
                    int i22 = columnIndexOrThrow4;
                    int i23 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i23);
                    int i24 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i24);
                    int i25 = columnIndexOrThrow19;
                    int i26 = i20;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i25));
                    columnIndexOrThrow17 = i23;
                    int i27 = i22;
                    int i28 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i28);
                    int i29 = i24;
                    int i30 = i25;
                    int i31 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i31);
                    int i32 = i28;
                    columnIndexOrThrow21 = i31;
                    int i33 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i33);
                    int i34 = i29;
                    int i35 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i35);
                    int i36 = columnIndexOrThrow24;
                    if (query.getInt(i36) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    workSpec.expedited = z14;
                    int i37 = columnIndexOrThrow25;
                    int i38 = i35;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i37));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow25 = i37;
                    columnIndexOrThrow2 = i17;
                    columnIndexOrThrow13 = i19;
                    columnIndexOrThrow15 = i21;
                    columnIndexOrThrow16 = i26;
                    columnIndexOrThrow18 = i34;
                    columnIndexOrThrow23 = i38;
                    columnIndexOrThrow9 = i11;
                    columnIndexOrThrow11 = i12;
                    columnIndexOrThrow = i13;
                    columnIndexOrThrow24 = i36;
                    columnIndexOrThrow22 = i33;
                    columnIndexOrThrow3 = i15;
                    int i39 = i30;
                    columnIndexOrThrow20 = i32;
                    columnIndexOrThrow4 = i27;
                    columnIndexOrThrow19 = i39;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public LiveData<Long> getScheduleRequestedAtLiveData(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, new e(acquire));
    }

    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int i10 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    int i11 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i12 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i13 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    if (query.getInt(columnIndexOrThrow2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    constraints.setRequiresCharging(z10);
                    if (query.getInt(columnIndexOrThrow3) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    constraints.setRequiresDeviceIdle(z11);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    constraints.setRequiresBatteryNotLow(z12);
                    if (query.getInt(columnIndexOrThrow5) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    constraints.setRequiresStorageNotLow(z13);
                    int i14 = columnIndexOrThrow2;
                    int i15 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    int i16 = i10;
                    workSpec.output = Data.fromByteArray(query.getBlob(i16));
                    int i17 = i14;
                    i10 = i16;
                    int i18 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i18);
                    int i19 = columnIndexOrThrow13;
                    int i20 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i20);
                    int i21 = i18;
                    int i22 = columnIndexOrThrow4;
                    int i23 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i23);
                    int i24 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i24);
                    int i25 = columnIndexOrThrow19;
                    int i26 = i20;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i25));
                    columnIndexOrThrow17 = i23;
                    int i27 = i22;
                    int i28 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i28);
                    int i29 = i24;
                    int i30 = i25;
                    int i31 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i31);
                    int i32 = i28;
                    columnIndexOrThrow21 = i31;
                    int i33 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i33);
                    int i34 = i29;
                    int i35 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i35);
                    int i36 = columnIndexOrThrow24;
                    if (query.getInt(i36) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    workSpec.expedited = z14;
                    int i37 = columnIndexOrThrow25;
                    int i38 = i35;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i37));
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow25 = i37;
                    columnIndexOrThrow2 = i17;
                    columnIndexOrThrow13 = i19;
                    columnIndexOrThrow15 = i21;
                    columnIndexOrThrow16 = i26;
                    columnIndexOrThrow18 = i34;
                    columnIndexOrThrow23 = i38;
                    columnIndexOrThrow9 = i11;
                    columnIndexOrThrow11 = i12;
                    columnIndexOrThrow = i13;
                    columnIndexOrThrow24 = i36;
                    columnIndexOrThrow22 = i33;
                    columnIndexOrThrow3 = i15;
                    int i39 = i30;
                    columnIndexOrThrow20 = i32;
                    columnIndexOrThrow4 = i27;
                    columnIndexOrThrow19 = i39;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public WorkInfo.State getState(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        WorkInfo.State state = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                state = WorkTypeConverters.intToState(query.getInt(0));
            }
            return state;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithTag(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                if (query.moveToFirst()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i10 = columnIndexOrThrow25;
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    if (query.getInt(columnIndexOrThrow2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    constraints.setRequiresCharging(z10);
                    if (query.getInt(columnIndexOrThrow3) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    constraints.setRequiresDeviceIdle(z11);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    constraints.setRequiresBatteryNotLow(z12);
                    if (query.getInt(columnIndexOrThrow5) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    constraints.setRequiresStorageNotLow(z13);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec2 = new WorkSpec(string, string2);
                    workSpec2.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec2.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec2.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec2.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow14));
                    workSpec2.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec2.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec2.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec2.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec2.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    workSpec2.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec2.periodStartTime = query.getLong(columnIndexOrThrow21);
                    workSpec2.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec2.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    if (query.getInt(columnIndexOrThrow24) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    workSpec2.expedited = z14;
                    workSpec2.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i10));
                    workSpec2.constraints = constraints;
                    workSpec = workSpec2;
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.f17026id = query.getString(columnIndexOrThrow);
                idAndState.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public WorkSpec[] getWorkSpecs(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append(ProxyConfig.MATCH_ALL_SCHEMES);
        newStringBuilder.append(" FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i10 = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i10);
            } else {
                acquire.bindString(i10, next);
            }
            i10++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                WorkSpec[] workSpecArr = new WorkSpec[query.getCount()];
                int i11 = 0;
                while (query.moveToNext()) {
                    WorkSpec[] workSpecArr2 = workSpecArr;
                    String string = query.getString(columnIndexOrThrow9);
                    int i12 = columnIndexOrThrow9;
                    String string2 = query.getString(columnIndexOrThrow11);
                    int i13 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i14 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    if (query.getInt(columnIndexOrThrow2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    constraints.setRequiresCharging(z10);
                    if (query.getInt(columnIndexOrThrow3) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    constraints.setRequiresDeviceIdle(z11);
                    if (query.getInt(columnIndexOrThrow4) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    constraints.setRequiresBatteryNotLow(z12);
                    if (query.getInt(columnIndexOrThrow5) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    constraints.setRequiresStorageNotLow(z13);
                    int i15 = columnIndexOrThrow2;
                    int i16 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow14));
                    int i17 = i15;
                    int i18 = columnIndexOrThrow14;
                    int i19 = columnIndexOrThrow15;
                    workSpec.initialDelay = query.getLong(i19);
                    columnIndexOrThrow15 = i19;
                    int i20 = columnIndexOrThrow16;
                    workSpec.intervalDuration = query.getLong(i20);
                    int i21 = columnIndexOrThrow12;
                    int i22 = columnIndexOrThrow17;
                    workSpec.flexDuration = query.getLong(i22);
                    int i23 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = query.getInt(i23);
                    int i24 = columnIndexOrThrow19;
                    int i25 = i20;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i24));
                    columnIndexOrThrow17 = i22;
                    int i26 = i23;
                    int i27 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = query.getLong(i27);
                    int i28 = i24;
                    int i29 = columnIndexOrThrow21;
                    workSpec.periodStartTime = query.getLong(i29);
                    int i30 = i27;
                    columnIndexOrThrow21 = i29;
                    int i31 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = query.getLong(i31);
                    columnIndexOrThrow22 = i31;
                    int i32 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = query.getLong(i32);
                    int i33 = columnIndexOrThrow24;
                    if (query.getInt(i33) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    workSpec.expedited = z14;
                    int i34 = columnIndexOrThrow25;
                    int i35 = i32;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i34));
                    workSpec.constraints = constraints;
                    workSpecArr2[i11] = workSpec;
                    i11++;
                    columnIndexOrThrow25 = i34;
                    columnIndexOrThrow2 = i17;
                    columnIndexOrThrow23 = i35;
                    workSpecArr = workSpecArr2;
                    columnIndexOrThrow9 = i12;
                    columnIndexOrThrow11 = i13;
                    columnIndexOrThrow = i14;
                    columnIndexOrThrow24 = i33;
                    columnIndexOrThrow14 = i18;
                    columnIndexOrThrow3 = i16;
                    int i36 = i28;
                    columnIndexOrThrow20 = i30;
                    columnIndexOrThrow12 = i21;
                    columnIndexOrThrow16 = i25;
                    columnIndexOrThrow18 = i26;
                    columnIndexOrThrow19 = i36;
                }
                WorkSpec[] workSpecArr3 = workSpecArr;
                query.close();
                roomSQLiteQuery.release();
                return workSpecArr3;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.util.List<androidx.work.Data>] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.impl.model.WorkSpec.WorkInfoPojo getWorkStatusPojoForId(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "SELECT id, state, output, run_attempt_count FROM workspec WHERE id=?"
            r1 = 1
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            if (r11 != 0) goto L_0x000d
            r0.bindNull(r1)
            goto L_0x0010
        L_0x000d:
            r0.bindString(r1, r11)
        L_0x0010:
            androidx.room.RoomDatabase r11 = r10.__db
            r11.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r11 = r10.__db
            r11.beginTransaction()
            androidx.room.RoomDatabase r11 = r10.__db     // Catch:{ all -> 0x00fd }
            r2 = 0
            android.database.Cursor r11 = androidx.room.util.DBUtil.query(r11, r0, r1, r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = "id"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r11, r1)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "state"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r11, r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = "output"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r11, r4)     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = "run_attempt_count"
            int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r11, r5)     // Catch:{ all -> 0x0064 }
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0064 }
            r6.<init>()     // Catch:{ all -> 0x0064 }
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0064 }
            r7.<init>()     // Catch:{ all -> 0x0064 }
        L_0x0043:
            boolean r8 = r11.moveToNext()     // Catch:{ all -> 0x0064 }
            if (r8 == 0) goto L_0x0082
            boolean r8 = r11.isNull(r1)     // Catch:{ all -> 0x0064 }
            if (r8 != 0) goto L_0x0067
            java.lang.String r8 = r11.getString(r1)     // Catch:{ all -> 0x0064 }
            java.lang.Object r9 = r6.get(r8)     // Catch:{ all -> 0x0064 }
            java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x0064 }
            if (r9 != 0) goto L_0x0067
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0064 }
            r9.<init>()     // Catch:{ all -> 0x0064 }
            r6.put(r8, r9)     // Catch:{ all -> 0x0064 }
            goto L_0x0067
        L_0x0064:
            r1 = move-exception
            goto L_0x00ff
        L_0x0067:
            boolean r8 = r11.isNull(r1)     // Catch:{ all -> 0x0064 }
            if (r8 != 0) goto L_0x0043
            java.lang.String r8 = r11.getString(r1)     // Catch:{ all -> 0x0064 }
            java.lang.Object r9 = r7.get(r8)     // Catch:{ all -> 0x0064 }
            java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x0064 }
            if (r9 != 0) goto L_0x0043
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0064 }
            r9.<init>()     // Catch:{ all -> 0x0064 }
            r7.put(r8, r9)     // Catch:{ all -> 0x0064 }
            goto L_0x0043
        L_0x0082:
            r8 = -1
            r11.moveToPosition(r8)     // Catch:{ all -> 0x0064 }
            r10.__fetchRelationshipWorkTagAsjavaLangString(r6)     // Catch:{ all -> 0x0064 }
            r10.__fetchRelationshipWorkProgressAsandroidxWorkData(r7)     // Catch:{ all -> 0x0064 }
            boolean r8 = r11.moveToFirst()     // Catch:{ all -> 0x0064 }
            if (r8 == 0) goto L_0x00ec
            boolean r8 = r11.isNull(r1)     // Catch:{ all -> 0x0064 }
            if (r8 != 0) goto L_0x00a3
            java.lang.String r8 = r11.getString(r1)     // Catch:{ all -> 0x0064 }
            java.lang.Object r6 = r6.get(r8)     // Catch:{ all -> 0x0064 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x0064 }
            goto L_0x00a4
        L_0x00a3:
            r6 = r2
        L_0x00a4:
            if (r6 != 0) goto L_0x00ab
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0064 }
            r6.<init>()     // Catch:{ all -> 0x0064 }
        L_0x00ab:
            boolean r8 = r11.isNull(r1)     // Catch:{ all -> 0x0064 }
            if (r8 != 0) goto L_0x00bb
            java.lang.String r2 = r11.getString(r1)     // Catch:{ all -> 0x0064 }
            java.lang.Object r2 = r7.get(r2)     // Catch:{ all -> 0x0064 }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x0064 }
        L_0x00bb:
            if (r2 != 0) goto L_0x00c2
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0064 }
            r2.<init>()     // Catch:{ all -> 0x0064 }
        L_0x00c2:
            androidx.work.impl.model.WorkSpec$WorkInfoPojo r7 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x0064 }
            r7.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x0064 }
            r7.f17027id = r1     // Catch:{ all -> 0x0064 }
            int r1 = r11.getInt(r3)     // Catch:{ all -> 0x0064 }
            androidx.work.WorkInfo$State r1 = androidx.work.impl.model.WorkTypeConverters.intToState(r1)     // Catch:{ all -> 0x0064 }
            r7.state = r1     // Catch:{ all -> 0x0064 }
            byte[] r1 = r11.getBlob(r4)     // Catch:{ all -> 0x0064 }
            androidx.work.Data r1 = androidx.work.Data.fromByteArray(r1)     // Catch:{ all -> 0x0064 }
            r7.output = r1     // Catch:{ all -> 0x0064 }
            int r1 = r11.getInt(r5)     // Catch:{ all -> 0x0064 }
            r7.runAttemptCount = r1     // Catch:{ all -> 0x0064 }
            r7.tags = r6     // Catch:{ all -> 0x0064 }
            r7.progress = r2     // Catch:{ all -> 0x0064 }
            r2 = r7
        L_0x00ec:
            androidx.room.RoomDatabase r1 = r10.__db     // Catch:{ all -> 0x0064 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0064 }
            r11.close()     // Catch:{ all -> 0x00fd }
            r0.release()     // Catch:{ all -> 0x00fd }
            androidx.room.RoomDatabase r11 = r10.__db
            r11.endTransaction()
            return r2
        L_0x00fd:
            r11 = move-exception
            goto L_0x0106
        L_0x00ff:
            r11.close()     // Catch:{ all -> 0x00fd }
            r0.release()     // Catch:{ all -> 0x00fd }
            throw r1     // Catch:{ all -> 0x00fd }
        L_0x0106:
            androidx.room.RoomDatabase r0 = r10.__db
            r0.endTransaction()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDao_Impl.getWorkStatusPojoForId(java.lang.String):androidx.work.impl.model.WorkSpec$WorkInfoPojo");
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        Cursor query;
        ArrayList arrayList;
        ArrayList arrayList2;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i10 = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i10);
            } else {
                acquire.bindString(i10, next);
            }
            i10++;
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    String string = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
                if (!query.isNull(columnIndexOrThrow)) {
                    String string2 = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap2.get(string2)) == null) {
                        arrayMap2.put(string2, new ArrayList());
                    }
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList3 = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    arrayList = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                if (!query.isNull(columnIndexOrThrow)) {
                    arrayList2 = (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow));
                } else {
                    arrayList2 = null;
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                workInfoPojo.f17027id = query.getString(columnIndexOrThrow);
                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                workInfoPojo.tags = arrayList;
                workInfoPojo.progress = arrayList2;
                arrayList3.add(workInfoPojo);
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList3;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        Cursor query;
        ArrayList arrayList;
        ArrayList arrayList2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    String string = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
                if (!query.isNull(columnIndexOrThrow)) {
                    String string2 = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap2.get(string2)) == null) {
                        arrayMap2.put(string2, new ArrayList());
                    }
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList3 = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    arrayList = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                if (!query.isNull(columnIndexOrThrow)) {
                    arrayList2 = (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow));
                } else {
                    arrayList2 = null;
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                workInfoPojo.f17027id = query.getString(columnIndexOrThrow);
                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                workInfoPojo.tags = arrayList;
                workInfoPojo.progress = arrayList2;
                arrayList3.add(workInfoPojo);
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList3;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        Cursor query;
        ArrayList arrayList;
        ArrayList arrayList2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    String string = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
                if (!query.isNull(columnIndexOrThrow)) {
                    String string2 = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap2.get(string2)) == null) {
                        arrayMap2.put(string2, new ArrayList());
                    }
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList3 = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    arrayList = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                if (!query.isNull(columnIndexOrThrow)) {
                    arrayList2 = (ArrayList) arrayMap2.get(query.getString(columnIndexOrThrow));
                } else {
                    arrayList2 = null;
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                workInfoPojo.f17027id = query.getString(columnIndexOrThrow);
                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                workInfoPojo.tags = arrayList;
                workInfoPojo.progress = arrayList2;
                arrayList3.add(workInfoPojo);
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList3;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i10 = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i10);
            } else {
                acquire.bindString(i10, next);
            }
            i10++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new b(acquire));
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new d(acquire));
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new c(acquire));
    }

    public boolean hasUnfinishedWork() {
        boolean z10 = false;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst() && query.getInt(0) != 0) {
                z10 = true;
            }
            return z10;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public int incrementWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public int markWorkSpecScheduled(String str, long j10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        acquire.bindLong(1, j10);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(acquire);
        }
    }

    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(acquire);
        }
    }

    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(acquire);
        }
    }

    public int resetWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public void setOutput(String str, Data data) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetOutput.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(acquire);
        }
    }

    public void setPeriodStartTime(String str, long j10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetPeriodStartTime.acquire();
        acquire.bindLong(1, j10);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetPeriodStartTime.release(acquire);
        }
    }

    public int setState(WorkInfo.State state, String... strArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("UPDATE workspec SET state=");
        newStringBuilder.append("?");
        newStringBuilder.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, strArr.length);
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, (long) WorkTypeConverters.stateToInt(state));
        int i10 = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.bindNull(i10);
            } else {
                compileStatement.bindString(i10, str);
            }
            i10++;
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }
}
