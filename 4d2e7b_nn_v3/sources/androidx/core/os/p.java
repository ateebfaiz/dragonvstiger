package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import kotlin.jvm.internal.m;

final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f15051a = new p();

    private p() {
    }

    @DoNotInline
    public static final PersistableBundle a(int i10) {
        return new PersistableBundle(i10);
    }

    @DoNotInline
    public static final void b(PersistableBundle persistableBundle, String str, Object obj) {
        if (obj == null) {
            persistableBundle.putString(str, (String) null);
        } else if (obj instanceof Boolean) {
            q.a(persistableBundle, str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            persistableBundle.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Integer) {
            persistableBundle.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof Long) {
            persistableBundle.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof String) {
            persistableBundle.putString(str, (String) obj);
        } else if (obj instanceof boolean[]) {
            q.b(persistableBundle, str, (boolean[]) obj);
        } else if (obj instanceof double[]) {
            persistableBundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof int[]) {
            persistableBundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof long[]) {
            persistableBundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof Object[]) {
            Class<?> componentType = obj.getClass().getComponentType();
            m.c(componentType);
            if (String.class.isAssignableFrom(componentType)) {
                m.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                persistableBundle.putStringArray(str, (String[]) obj);
                return;
            }
            String canonicalName = componentType.getCanonicalName();
            throw new IllegalArgumentException("Illegal value array type " + canonicalName + " for key \"" + str + '\"');
        } else {
            String canonicalName2 = obj.getClass().getCanonicalName();
            throw new IllegalArgumentException("Illegal value type " + canonicalName2 + " for key \"" + str + '\"');
        }
    }
}
