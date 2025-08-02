package m4;

import android.net.Uri;
import y2.e;

public abstract class j {
    public static Uri a(Object obj, Object obj2, Object[] objArr, e eVar) {
        Object obj3;
        Uri uri;
        Uri uri2;
        if (obj != null && (uri2 = (Uri) eVar.apply(obj)) != null) {
            return uri2;
        }
        if (objArr != null && objArr.length > 0 && (obj3 = objArr[0]) != null && (uri = (Uri) eVar.apply(obj3)) != null) {
            return uri;
        }
        if (obj2 != null) {
            return (Uri) eVar.apply(obj2);
        }
        return null;
    }
}
