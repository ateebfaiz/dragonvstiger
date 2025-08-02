package z5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25250a = new a();

    private a() {
    }

    public static final String a(Context context) {
        m.f(context, "ctx");
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            StringBuilder sb2 = new StringBuilder();
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            for (Signature byteArray : signatureArr) {
                instance.update(byteArray.toByteArray());
                sb2.append(Base64.encodeToString(instance.digest(), 0));
                sb2.append(":");
            }
            if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            String sb3 = sb2.toString();
            m.e(sb3, "sb.toString()");
            return sb3;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
