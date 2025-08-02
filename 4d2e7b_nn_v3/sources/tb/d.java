package tb;

import java.io.File;
import kotlin.jvm.internal.m;

public abstract class d {
    /* access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb2 = new StringBuilder(file.toString());
        if (file2 != null) {
            sb2.append(" -> " + file2);
        }
        if (str != null) {
            sb2.append(": " + str);
        }
        String sb3 = sb2.toString();
        m.e(sb3, "toString(...)");
        return sb3;
    }
}
