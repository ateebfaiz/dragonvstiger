package u9;

import java.util.Collection;
import s9.h;

public abstract class a {
    private static String a(Collection collection) {
        StringBuilder sb2 = new StringBuilder();
        Object[] array = collection.toArray();
        for (int i10 = 0; i10 < array.length; i10++) {
            if (i10 != 0) {
                if (i10 < array.length - 1) {
                    sb2.append(", ");
                } else if (i10 == array.length - 1) {
                    sb2.append(" or ");
                }
            }
            sb2.append(array[i10].toString());
        }
        return sb2.toString();
    }

    public static String b(h hVar, Collection collection) {
        return "Unsupported JWS algorithm " + hVar + ", must be " + a(collection);
    }
}
