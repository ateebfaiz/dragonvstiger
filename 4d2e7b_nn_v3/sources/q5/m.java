package q5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.text.j;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet f23370a = r0.e("8a3c4b262d721acd49a4bf97d5213199c86fa2b9", "cc2751449a350f668590264ed76692694a80308a", "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc", "df6b721c8b4d3b6eb44c861d4415007e5a35fc95", "9b8f518b086098de3d77736f9458a3d2f6f95a37", "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3", "c56fb7d591ba6704df047fd98f535372fea00211");

    /* renamed from: b  reason: collision with root package name */
    public static final m f23371b = new m();

    private m() {
    }

    public static final boolean a(Context context, String str) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(str, "packageName");
        String str2 = Build.BRAND;
        int i10 = context.getApplicationInfo().flags;
        kotlin.jvm.internal.m.e(str2, "brand");
        if (j.F(str2, "generic", false, 2, (Object) null) && (i10 & 2) != 0) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return false;
            }
            kotlin.jvm.internal.m.e(signatureArr, "packageInfo.signatures");
            if (signatureArr.length == 0) {
                return false;
            }
            Signature[] signatureArr2 = packageInfo.signatures;
            kotlin.jvm.internal.m.e(signatureArr2, "packageInfo.signatures");
            for (Signature byteArray : signatureArr2) {
                HashSet hashSet = f23370a;
                byte[] byteArray2 = byteArray.toByteArray();
                kotlin.jvm.internal.m.e(byteArray2, "it.toByteArray()");
                if (!r.S(hashSet, p0.B0(byteArray2))) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
