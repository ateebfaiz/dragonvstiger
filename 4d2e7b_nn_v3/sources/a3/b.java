package a3;

import android.webkit.MimeTypeMap;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.util.Map;
import y2.g;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final MimeTypeMap f13668a = MimeTypeMap.getSingleton();

    /* renamed from: b  reason: collision with root package name */
    private static final Map f13669b = g.of(ClipboardModule.MIMETYPE_HEIF, "heif", ClipboardModule.MIMETYPE_HEIC, "heic");

    /* renamed from: c  reason: collision with root package name */
    private static final Map f13670c = g.of("heif", ClipboardModule.MIMETYPE_HEIF, "heic", ClipboardModule.MIMETYPE_HEIC);

    public static String a(String str) {
        String str2 = (String) f13670c.get(str);
        if (str2 != null) {
            return str2;
        }
        return f13668a.getMimeTypeFromExtension(str);
    }
}
