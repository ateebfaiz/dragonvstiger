package q7;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12910a = new a();

    private a() {
    }

    public static final Object a(Context context, Class cls) {
        Context baseContext;
        m.f(cls, "clazz");
        while (!cls.isInstance(context)) {
            if (!(context instanceof ContextWrapper) || context == (baseContext = ((ContextWrapper) context).getBaseContext())) {
                return null;
            }
            context = baseContext;
        }
        return context;
    }
}
