package b8;

import android.content.Context;
import com.facebook.soloader.a0;
import com.facebook.soloader.m;
import com.facebook.soloader.r;
import java.io.File;

public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2502a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2503b;

    public b(Context context, a aVar) {
        this.f2502a = context;
        this.f2503b = aVar;
    }

    public boolean a(UnsatisfiedLinkError unsatisfiedLinkError, a0[] a0VarArr) {
        String str = this.f2502a.getApplicationInfo().sourceDir;
        if (new File(str).exists()) {
            m.g("soloader.recovery.CheckBaseApkExists", "Base apk exists: " + str);
            return false;
        }
        StringBuilder sb2 = new StringBuilder("Base apk does not exist: ");
        sb2.append(str);
        sb2.append(". ");
        this.f2503b.b(sb2);
        throw new r(sb2.toString(), unsatisfiedLinkError);
    }
}
