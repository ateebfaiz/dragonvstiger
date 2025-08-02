package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SavedStateViewModelFactoryKt {
    /* access modifiers changed from: private */
    public static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE;
    /* access modifiers changed from: private */
    public static final List<Class<?>> VIEWMODEL_SIGNATURE;

    static {
        Class<SavedStateHandle> cls = SavedStateHandle.class;
        ANDROID_VIEWMODEL_SIGNATURE = r.o(Application.class, cls);
        VIEWMODEL_SIGNATURE = r.e(cls);
    }

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> cls, List<? extends Class<?>> list) {
        m.f(cls, "modelClass");
        m.f(list, "signature");
        Constructor<T>[] constructors = cls.getConstructors();
        m.e(constructors, "modelClass.constructors");
        int length = constructors.length;
        int i10 = 0;
        while (i10 < length) {
            Constructor<T> constructor = constructors[i10];
            Class[] parameterTypes = constructor.getParameterTypes();
            m.e(parameterTypes, "constructor.parameterTypes");
            List W = j.W(parameterTypes);
            if (m.b(list, W)) {
                m.d(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            } else if (list.size() != W.size() || !W.containsAll(list)) {
                i10++;
            } else {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        m.f(cls, "modelClass");
        m.f(constructor, "constructor");
        m.f(objArr, "params");
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
        }
    }
}
