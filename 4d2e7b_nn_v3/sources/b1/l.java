package b1;

import a1.h;
import a1.o;
import android.content.Context;
import java.io.File;

public abstract class l {
    public static o a(Context context) {
        return c(context, (a) null);
    }

    private static o b(Context context, h hVar) {
        o oVar = new o(new d(new File(context.getCacheDir(), "volley")), hVar);
        oVar.d();
        return oVar;
    }

    public static o c(Context context, a aVar) {
        b bVar;
        if (aVar == null) {
            bVar = new b(new h());
        } else {
            bVar = new b(aVar);
        }
        return b(context, bVar);
    }
}
