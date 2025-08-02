package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.alibaba.pdns.net.d;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    @Nullable
    public final Set<Index> indices;
    public final String name;

    public static class Column {
        @ColumnInfo.SQLiteTypeAffinity
        public final int affinity;
        public final String defaultValue;
        private final int mCreatedFrom;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        @Deprecated
        public Column(String str, String str2, boolean z10, int i10) {
            this(str, str2, z10, i10, (String) null, 0);
        }

        @ColumnInfo.SQLiteTypeAffinity
        private static int findAffinity(@Nullable String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            if (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) {
                return 4;
            }
            return 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Column column = (Column) obj;
            if (this.primaryKeyPosition != column.primaryKeyPosition || !this.name.equals(column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.mCreatedFrom == 1 && column.mCreatedFrom == 2 && (str3 = this.defaultValue) != null && !str3.equals(column.defaultValue)) {
                return false;
            }
            if (this.mCreatedFrom == 2 && column.mCreatedFrom == 1 && (str2 = column.defaultValue) != null && !str2.equals(this.defaultValue)) {
                return false;
            }
            int i10 = this.mCreatedFrom;
            if (i10 != 0 && i10 == column.mCreatedFrom && ((str = this.defaultValue) == null ? column.defaultValue != null : !str.equals(column.defaultValue))) {
                return false;
            }
            if (this.affinity == column.affinity) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int hashCode = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull) {
                i10 = 1231;
            } else {
                i10 = 1237;
            }
            return ((hashCode + i10) * 31) + this.primaryKeyPosition;
        }

        public boolean isPrimaryKey() {
            if (this.primaryKeyPosition > 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Column{name='" + this.name + '\'' + ", type='" + this.type + '\'' + ", affinity='" + this.affinity + '\'' + ", notNull=" + this.notNull + ", primaryKeyPosition=" + this.primaryKeyPosition + ", defaultValue='" + this.defaultValue + '\'' + '}';
        }

        public Column(String str, String str2, boolean z10, int i10, String str3, int i11) {
            this.name = str;
            this.type = str2;
            this.notNull = z10;
            this.primaryKeyPosition = i10;
            this.affinity = findAffinity(str2);
            this.defaultValue = str3;
            this.mCreatedFrom = i11;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ForeignKey {
        @NonNull
        public final List<String> columnNames;
        @NonNull
        public final String onDelete;
        @NonNull
        public final String onUpdate;
        @NonNull
        public final List<String> referenceColumnNames;
        @NonNull
        public final String referenceTable;

        public ForeignKey(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<String> list, @NonNull List<String> list2) {
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = Collections.unmodifiableList(list);
            this.referenceColumnNames = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (this.referenceTable.equals(foreignKey.referenceTable) && this.onDelete.equals(foreignKey.onDelete) && this.onUpdate.equals(foreignKey.onUpdate) && this.columnNames.equals(foreignKey.columnNames)) {
                return this.referenceColumnNames.equals(foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + '\'' + ", onDelete='" + this.onDelete + '\'' + ", onUpdate='" + this.onUpdate + '\'' + ", columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class Index {
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public final boolean unique;

        public Index(String str, boolean z10, List<String> list) {
            this.name = str;
            this.unique = z10;
            this.columns = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique != index.unique || !this.columns.equals(index.columns)) {
                return false;
            }
            if (this.name.startsWith(DEFAULT_PREFIX)) {
                return index.name.startsWith(DEFAULT_PREFIX);
            }
            return this.name.equals(index.name);
        }

        public int hashCode() {
            int i10;
            if (this.name.startsWith(DEFAULT_PREFIX)) {
                i10 = -1184239155;
            } else {
                i10 = this.name.hashCode();
            }
            return (((i10 * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.name + '\'' + ", unique=" + this.unique + ", columns=" + this.columns + '}';
        }
    }

    static class a implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        final int f16484a;

        /* renamed from: b  reason: collision with root package name */
        final int f16485b;

        /* renamed from: c  reason: collision with root package name */
        final String f16486c;

        /* renamed from: d  reason: collision with root package name */
        final String f16487d;

        a(int i10, int i11, String str, String str2) {
            this.f16484a = i10;
            this.f16485b = i11;
            this.f16486c = str;
            this.f16487d = str2;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            int i10 = this.f16484a - aVar.f16484a;
            if (i10 == 0) {
                return this.f16485b - aVar.f16485b;
            }
            return i10;
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        Set<Index> set3;
        this.name = str;
        this.columns = Collections.unmodifiableMap(map);
        this.foreignKeys = Collections.unmodifiableSet(set);
        if (set2 == null) {
            set3 = null;
        } else {
            set3 = Collections.unmodifiableSet(set2);
        }
        this.indices = set3;
    }

    public static TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return new TableInfo(str, readColumns(supportSQLiteDatabase, str), readForeignKeys(supportSQLiteDatabase, str), readIndices(supportSQLiteDatabase, str));
    }

    private static Map<String, Column> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        boolean z10;
        Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (query.getColumnCount() > 0) {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("notnull");
                int columnIndex4 = query.getColumnIndex("pk");
                int columnIndex5 = query.getColumnIndex("dflt_value");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    String string2 = query.getString(columnIndex2);
                    if (query.getInt(columnIndex3) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    hashMap.put(string, new Column(string, string2, z10, query.getInt(columnIndex4), query.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            query.close();
        }
    }

    private static List<a> readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(Constants.MessagePayloadKeys.FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < count; i10++) {
            cursor.moveToPosition(i10);
            arrayList.add(new a(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<ForeignKey> readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("id");
            int columnIndex2 = query.getColumnIndex("seq");
            int columnIndex3 = query.getColumnIndex("table");
            int columnIndex4 = query.getColumnIndex("on_delete");
            int columnIndex5 = query.getColumnIndex("on_update");
            List<a> readForeignKeyFieldMappings = readForeignKeyFieldMappings(query);
            int count = query.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                query.moveToPosition(i10);
                if (query.getInt(columnIndex2) == 0) {
                    int i11 = query.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (a next : readForeignKeyFieldMappings) {
                        if (next.f16484a == i11) {
                            arrayList.add(next.f16486c);
                            arrayList2.add(next.f16487d);
                        }
                    }
                    hashSet.add(new ForeignKey(query.getString(columnIndex3), query.getString(columnIndex4), query.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            query.close();
            return hashSet;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    private static Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z10) {
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("seqno");
            int columnIndex2 = query.getColumnIndex("cid");
            int columnIndex3 = query.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (query.moveToNext()) {
                        if (query.getInt(columnIndex2) >= 0) {
                            int i10 = query.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i10), query.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    Index index = new Index(str, z10, arrayList);
                    query.close();
                    return index;
                }
            }
            query.close();
            return null;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    @Nullable
    private static Set<Index> readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("name");
            int columnIndex2 = query.getColumnIndex("origin");
            int columnIndex3 = query.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    HashSet hashSet = new HashSet();
                    while (query.moveToNext()) {
                        if (d.f18103f.equals(query.getString(columnIndex2))) {
                            String string = query.getString(columnIndex);
                            boolean z10 = true;
                            if (query.getInt(columnIndex3) != 1) {
                                z10 = false;
                            }
                            Index readIndex = readIndex(supportSQLiteDatabase, string, z10);
                            if (readIndex == null) {
                                query.close();
                                return null;
                            }
                            hashSet.add(readIndex);
                        }
                    }
                    query.close();
                    return hashSet;
                }
            }
            return null;
        } finally {
            query.close();
        }
    }

    public boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        String str = this.name;
        if (str == null ? tableInfo.name != null : !str.equals(tableInfo.name)) {
            return false;
        }
        Map<String, Column> map = this.columns;
        if (map == null ? tableInfo.columns != null : !map.equals(tableInfo.columns)) {
            return false;
        }
        Set<ForeignKey> set2 = this.foreignKeys;
        if (set2 == null ? tableInfo.foreignKeys != null : !set2.equals(tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set3 = this.indices;
        if (set3 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        int i10;
        int i11;
        String str = this.name;
        int i12 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i13 = i10 * 31;
        Map<String, Column> map = this.columns;
        if (map != null) {
            i11 = map.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i13 + i11) * 31;
        Set<ForeignKey> set = this.foreignKeys;
        if (set != null) {
            i12 = set.hashCode();
        }
        return i14 + i12;
    }

    public String toString() {
        return "TableInfo{name='" + this.name + '\'' + ", columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set) {
        this(str, map, set, Collections.emptySet());
    }
}
