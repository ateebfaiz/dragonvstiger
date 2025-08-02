package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class RawQueries {
    private RawQueries() {
    }

    private static void bindings(@NonNull StringBuilder sb2, int i10) {
        if (i10 > 0) {
            sb2.append("?");
            for (int i11 = 1; i11 < i10; i11++) {
                sb2.append(",");
                sb2.append("?");
            }
        }
    }

    @NonNull
    public static SupportSQLiteQuery workQueryToRawQuery(@NonNull WorkQuery workQuery) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder("SELECT * FROM workspec");
        List<WorkInfo.State> states = workQuery.getStates();
        String str = " AND";
        String str2 = " WHERE";
        if (!states.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(states.size());
            for (WorkInfo.State stateToInt : states) {
                arrayList2.add(Integer.valueOf(WorkTypeConverters.stateToInt(stateToInt)));
            }
            sb2.append(str2);
            sb2.append(" state IN (");
            bindings(sb2, arrayList2.size());
            sb2.append(")");
            arrayList.addAll(arrayList2);
            str2 = str;
        }
        List<UUID> ids = workQuery.getIds();
        if (!ids.isEmpty()) {
            ArrayList arrayList3 = new ArrayList(ids.size());
            for (UUID uuid : ids) {
                arrayList3.add(uuid.toString());
            }
            sb2.append(str2);
            sb2.append(" id IN (");
            bindings(sb2, ids.size());
            sb2.append(")");
            arrayList.addAll(arrayList3);
            str2 = str;
        }
        List<String> tags = workQuery.getTags();
        if (!tags.isEmpty()) {
            sb2.append(str2);
            sb2.append(" id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
            bindings(sb2, tags.size());
            sb2.append("))");
            arrayList.addAll(tags);
        } else {
            str = str2;
        }
        List<String> uniqueWorkNames = workQuery.getUniqueWorkNames();
        if (!uniqueWorkNames.isEmpty()) {
            sb2.append(str);
            sb2.append(" id IN (SELECT work_spec_id FROM workname WHERE name IN (");
            bindings(sb2, uniqueWorkNames.size());
            sb2.append("))");
            arrayList.addAll(uniqueWorkNames);
        }
        sb2.append(";");
        return new SimpleSQLiteQuery(sb2.toString(), arrayList.toArray());
    }
}
