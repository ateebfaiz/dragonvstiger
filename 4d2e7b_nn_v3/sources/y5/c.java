package y5;

import android.content.res.Resources;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f24953a = new c();

    private c() {
    }

    private final String a(int i10) {
        return "#" + Integer.toHexString(i10);
    }

    public static final String b(Resources resources, int i10) {
        String str;
        String str2;
        if (resources == null) {
            return f24953a.a(i10);
        }
        if (f24953a.d(i10) != 127) {
            str2 = resources.getResourcePackageName(i10);
            m.e(str2, "r.getResourcePackageName(resourceId)");
            str = ":";
        } else {
            str2 = "";
            str = str2;
        }
        String resourceTypeName = resources.getResourceTypeName(i10);
        String resourceEntryName = resources.getResourceEntryName(i10);
        StringBuilder sb2 = new StringBuilder(str2.length() + 1 + str.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb2.append("@");
        sb2.append(str2);
        sb2.append(str);
        sb2.append(resourceTypeName);
        sb2.append(DomExceptionUtils.SEPARATOR);
        sb2.append(resourceEntryName);
        String sb3 = sb2.toString();
        m.e(sb3, "sb.toString()");
        return sb3;
    }

    public static final String c(Resources resources, int i10) {
        try {
            return b(resources, i10);
        } catch (Resources.NotFoundException unused) {
            return f24953a.a(i10);
        }
    }

    private final int d(int i10) {
        return (i10 >>> 24) & 255;
    }
}
