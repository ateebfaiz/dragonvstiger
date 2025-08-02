package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    static class a implements LayoutInflater.Factory2 {

        /* renamed from: a  reason: collision with root package name */
        final LayoutInflaterFactory f15155a;

        a(LayoutInflaterFactory layoutInflaterFactory) {
            this.f15155a = layoutInflaterFactory;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f15155a.onCreateView((View) null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f15155a + "}";
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f15155a.onCreateView(view, str, context, attributeSet);
        }
    }

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        Class<LayoutInflater> cls = LayoutInflater.class;
        if (!sCheckedField) {
            try {
                Field declaredField = cls.getDeclaredField("mFactory2");
                sLayoutInflaterFactory2Field = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e(TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + cls.getName() + "; inflation may have unexpected results.", e10);
            }
            sCheckedField = true;
        }
        Field field = sLayoutInflaterFactory2Field;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e11) {
                Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e11);
            }
        }
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof a) {
            return ((a) factory).f15155a;
        }
        return null;
    }

    @Deprecated
    public static void setFactory(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(new a(layoutInflaterFactory));
    }

    public static void setFactory2(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
