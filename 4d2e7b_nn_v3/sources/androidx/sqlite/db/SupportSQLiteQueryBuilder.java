package androidx.sqlite.db;

import java.util.regex.Pattern;

public final class SupportSQLiteQueryBuilder {
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] mBindArgs;
    private String[] mColumns = null;
    private boolean mDistinct = false;
    private String mGroupBy = null;
    private String mHaving = null;
    private String mLimit = null;
    private String mOrderBy = null;
    private String mSelection;
    private final String mTable;

    private SupportSQLiteQueryBuilder(String str) {
        this.mTable = str;
    }

    private static void appendClause(StringBuilder sb2, String str, String str2) {
        if (!isEmpty(str2)) {
            sb2.append(str);
            sb2.append(str2);
        }
    }

    private static void appendColumns(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(str);
        }
        sb2.append(' ');
    }

    public static SupportSQLiteQueryBuilder builder(String str) {
        return new SupportSQLiteQueryBuilder(str);
    }

    private static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    public SupportSQLiteQueryBuilder columns(String[] strArr) {
        this.mColumns = strArr;
        return this;
    }

    public SupportSQLiteQuery create() {
        if (!isEmpty(this.mGroupBy) || isEmpty(this.mHaving)) {
            StringBuilder sb2 = new StringBuilder(120);
            sb2.append("SELECT ");
            if (this.mDistinct) {
                sb2.append("DISTINCT ");
            }
            String[] strArr = this.mColumns;
            if (strArr == null || strArr.length == 0) {
                sb2.append(" * ");
            } else {
                appendColumns(sb2, strArr);
            }
            sb2.append(" FROM ");
            sb2.append(this.mTable);
            appendClause(sb2, " WHERE ", this.mSelection);
            appendClause(sb2, " GROUP BY ", this.mGroupBy);
            appendClause(sb2, " HAVING ", this.mHaving);
            appendClause(sb2, " ORDER BY ", this.mOrderBy);
            appendClause(sb2, " LIMIT ", this.mLimit);
            return new SimpleSQLiteQuery(sb2.toString(), this.mBindArgs);
        }
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }

    public SupportSQLiteQueryBuilder distinct() {
        this.mDistinct = true;
        return this;
    }

    public SupportSQLiteQueryBuilder groupBy(String str) {
        this.mGroupBy = str;
        return this;
    }

    public SupportSQLiteQueryBuilder having(String str) {
        this.mHaving = str;
        return this;
    }

    public SupportSQLiteQueryBuilder limit(String str) {
        if (isEmpty(str) || sLimitPattern.matcher(str).matches()) {
            this.mLimit = str;
            return this;
        }
        throw new IllegalArgumentException("invalid LIMIT clauses:" + str);
    }

    public SupportSQLiteQueryBuilder orderBy(String str) {
        this.mOrderBy = str;
        return this;
    }

    public SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        this.mSelection = str;
        this.mBindArgs = objArr;
        return this;
    }
}
