package b8;

import android.content.Context;
import com.facebook.soloader.a0;
import com.facebook.soloader.m;
import com.facebook.soloader.s;
import java.io.File;

public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2508a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2509b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2510c;

    public e(Context context, a aVar) {
        this.f2508a = context;
        this.f2509b = aVar;
        this.f2510c = aVar.c();
    }

    private boolean b() {
        String c10 = c();
        if (!new File(c10).exists() || !this.f2509b.a(c10)) {
            return false;
        }
        return true;
    }

    private String c() {
        return this.f2508a.getApplicationInfo().sourceDir;
    }

    private void d(a0[] a0VarArr) {
        for (int i10 = 0; i10 < a0VarArr.length; i10++) {
            a0 a0Var = a0VarArr[i10];
            if (a0Var instanceof s) {
                a0VarArr[i10] = ((s) a0Var).b(this.f2508a);
            }
        }
    }

    public boolean a(UnsatisfiedLinkError unsatisfiedLinkError, a0[] a0VarArr) {
        if (b()) {
            d(a0VarArr);
            return true;
        } else if (this.f2510c == this.f2509b.c()) {
            return false;
        } else {
            m.g("soloader.recovery.DetectDataAppMove", "Context was updated (perhaps by another thread)");
            return true;
        }
    }
}
