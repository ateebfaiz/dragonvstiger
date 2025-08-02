package androidx.room.util;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    private StringUtil() {
    }

    public static void appendPlaceholders(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("?");
            if (i11 < i10 - 1) {
                sb2.append(",");
            }
        }
    }

    @Nullable
    public static String joinIntoString(@Nullable List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append(Integer.toString(list.get(i10).intValue()));
            if (i10 < size - 1) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    @Nullable
    public static List<Integer> splitToIntList(@Nullable String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreElements()) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
            } catch (NumberFormatException e10) {
                Log.e("ROOM", "Malformed integer list", e10);
            }
        }
        return arrayList;
    }
}
