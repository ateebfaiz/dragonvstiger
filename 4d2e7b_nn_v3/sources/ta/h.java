package ta;

import android.webkit.MimeTypeMap;

public abstract class h {
    public static String a(String str) {
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    public static String b(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            str2 = str.substring(lastIndexOf + 1);
        } else {
            str2 = null;
        }
        if (str2 != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
        }
        return null;
    }
}
