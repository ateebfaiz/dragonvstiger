package androidx.core.content;

import android.content.ContentValues;
import kotlin.Pair;

public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... pairArr) {
        ContentValues contentValues = new ContentValues(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.a();
            Object b10 = pair.b();
            if (b10 == null) {
                contentValues.putNull(str);
            } else if (b10 instanceof String) {
                contentValues.put(str, (String) b10);
            } else if (b10 instanceof Integer) {
                contentValues.put(str, (Integer) b10);
            } else if (b10 instanceof Long) {
                contentValues.put(str, (Long) b10);
            } else if (b10 instanceof Boolean) {
                contentValues.put(str, (Boolean) b10);
            } else if (b10 instanceof Float) {
                contentValues.put(str, (Float) b10);
            } else if (b10 instanceof Double) {
                contentValues.put(str, (Double) b10);
            } else if (b10 instanceof byte[]) {
                contentValues.put(str, (byte[]) b10);
            } else if (b10 instanceof Byte) {
                contentValues.put(str, (Byte) b10);
            } else if (b10 instanceof Short) {
                contentValues.put(str, (Short) b10);
            } else {
                throw new IllegalArgumentException("Illegal value type " + b10.getClass().getCanonicalName() + " for key \"" + str + '\"');
            }
        }
        return contentValues;
    }
}
