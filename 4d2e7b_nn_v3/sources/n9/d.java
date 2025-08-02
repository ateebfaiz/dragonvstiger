package n9;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class d {
    public static Uri.Builder a(Uri.Builder builder, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return builder;
    }

    public static Uri b(Uri uri, Map map) {
        return a(f(uri, new String[0]), map).build();
    }

    public static Uri c(String str, Map map) {
        return b(Uri.parse(str), map);
    }

    public static Map d(String... strArr) {
        if (strArr.length % 2 == 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i10 = 0; i10 < strArr.length; i10 += 2) {
                linkedHashMap.put(strArr[i10], strArr[i10 + 1]);
            }
            return linkedHashMap;
        }
        throw new IllegalArgumentException("Odd number of key and Value");
    }

    public static Uri e(Uri uri, String... strArr) {
        return f(uri, strArr).build();
    }

    public static Uri.Builder f(Uri uri, String... strArr) {
        Uri.Builder buildUpon = uri.buildUpon();
        for (String appendEncodedPath : strArr) {
            buildUpon.appendEncodedPath(appendEncodedPath);
        }
        return buildUpon;
    }
}
