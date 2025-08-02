package a2;

import android.content.Context;
import android.os.Bundle;
import t1.b;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13664a = (o1.a.a() + "PLATFORM-" + 8);

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f13665b = 0;

    public void a(Context context, int i10, Bundle bundle) {
        h1.a.g(context, f13664a, i10, bundle);
    }

    public String[] f() {
        return new String[]{f13664a};
    }

    public void h(Context context, int i10, Bundle bundle) {
        if (i10 == 3101) {
            b2.a.a().b(context);
        }
    }

    public boolean j(int i10) {
        if (i10 != 3101) {
            return false;
        }
        return true;
    }
}
