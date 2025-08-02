package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserHandleCompat {
    @Nullable
    private static Method sGetUserIdMethod;
    @Nullable
    private static Constructor<UserHandle> sUserHandleConstructor;

    private static class a {
        @NonNull
        static UserHandle a(int i10) {
            return UserHandle.getUserHandleForUid(i10);
        }
    }

    private UserHandleCompat() {
    }

    private static Method getGetUserIdMethod() throws NoSuchMethodException {
        if (sGetUserIdMethod == null) {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("getUserId", new Class[]{Integer.TYPE});
            sGetUserIdMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sGetUserIdMethod;
    }

    private static Constructor<UserHandle> getUserHandleConstructor() throws NoSuchMethodException {
        if (sUserHandleConstructor == null) {
            Constructor<UserHandle> declaredConstructor = UserHandle.class.getDeclaredConstructor(new Class[]{Integer.TYPE});
            sUserHandleConstructor = declaredConstructor;
            declaredConstructor.setAccessible(true);
        }
        return sUserHandleConstructor;
    }

    @NonNull
    public static UserHandle getUserHandleForUid(int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(i10);
        }
        try {
            Method getUserIdMethod = getGetUserIdMethod();
            Object[] objArr = {Integer.valueOf(i10)};
            return getUserHandleConstructor().newInstance(new Object[]{(Integer) getUserIdMethod.invoke((Object) null, objArr)});
        } catch (NoSuchMethodException e10) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e10);
            throw noSuchMethodError;
        } catch (IllegalAccessException e11) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e11);
            throw illegalAccessError;
        } catch (InstantiationException e12) {
            InstantiationError instantiationError = new InstantiationError();
            instantiationError.initCause(e12);
            throw instantiationError;
        } catch (InvocationTargetException e13) {
            throw new RuntimeException(e13);
        }
    }
}
