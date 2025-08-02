package bc;

import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.a;
import kotlinx.coroutines.z;

public final class b extends a implements z {
    private volatile Object _preHandler = this;

    public b() {
        super(z.f1213q);
    }

    private final Method G() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", (Class[]) null);
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    public void B(CoroutineContext coroutineContext, Throwable th) {
        Object obj;
        int i10 = Build.VERSION.SDK_INT;
        if (26 <= i10 && i10 < 28) {
            Method G = G();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
            if (G != null) {
                obj = G.invoke((Object) null, (Object[]) null);
            } else {
                obj = null;
            }
            if (obj instanceof Thread.UncaughtExceptionHandler) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) obj;
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
