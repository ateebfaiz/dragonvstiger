package y5;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    private static final String f24936e;

    /* renamed from: f  reason: collision with root package name */
    public static final C0356a f24937f = new C0356a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f24938a;

    /* renamed from: b  reason: collision with root package name */
    private Object f24939b;

    /* renamed from: c  reason: collision with root package name */
    private Field f24940c;

    /* renamed from: d  reason: collision with root package name */
    private Field f24941d;

    /* renamed from: y5.a$a  reason: collision with other inner class name */
    public static final class C0356a {
        private C0356a() {
        }

        public /* synthetic */ C0356a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final View f24942a;

        /* renamed from: b  reason: collision with root package name */
        private final WindowManager.LayoutParams f24943b;

        public b(View view, WindowManager.LayoutParams layoutParams) {
            m.f(view, "view");
            m.f(layoutParams, "param");
            this.f24942a = view;
            this.f24943b = layoutParams;
        }

        public final WindowManager.LayoutParams a() {
            return this.f24943b;
        }

        public final View b() {
            return this.f24942a;
        }
    }

    static {
        String simpleName = a.class.getSimpleName();
        m.e(simpleName, "AndroidRootResolver::class.java.simpleName");
        f24936e = simpleName;
    }

    private final void a() {
        this.f24938a = true;
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            m.e(cls, "Class.forName(accessClass)");
            Method method = cls.getMethod("getInstance", (Class[]) null);
            m.e(method, "clazz.getMethod(instanceMethod)");
            this.f24939b = method.invoke((Object) null, (Object[]) null);
            Field declaredField = cls.getDeclaredField("mViews");
            this.f24940c = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Field declaredField2 = cls.getDeclaredField("mParams");
            this.f24941d = declaredField2;
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
        } catch (InvocationTargetException e10) {
            String str = f24936e;
            b0 b0Var = b0.f709a;
            String format = String.format("could not invoke: %s on %s", Arrays.copyOf(new Object[]{"getInstance", "android.view.WindowManagerGlobal"}, 2));
            m.e(format, "java.lang.String.format(format, *args)");
            Log.d(str, format, e10.getCause());
        } catch (ClassNotFoundException e11) {
            String str2 = f24936e;
            b0 b0Var2 = b0.f709a;
            String format2 = String.format("could not find class: %s", Arrays.copyOf(new Object[]{"android.view.WindowManagerGlobal"}, 1));
            m.e(format2, "java.lang.String.format(format, *args)");
            Log.d(str2, format2, e11);
        } catch (NoSuchFieldException e12) {
            String str3 = f24936e;
            b0 b0Var3 = b0.f709a;
            String format3 = String.format("could not find field: %s or %s on %s", Arrays.copyOf(new Object[]{"mParams", "mViews", "android.view.WindowManagerGlobal"}, 3));
            m.e(format3, "java.lang.String.format(format, *args)");
            Log.d(str3, format3, e12);
        } catch (NoSuchMethodException e13) {
            String str4 = f24936e;
            b0 b0Var4 = b0.f709a;
            String format4 = String.format("could not find method: %s on %s", Arrays.copyOf(new Object[]{"getInstance", "android.view.WindowManagerGlobal"}, 2));
            m.e(format4, "java.lang.String.format(format, *args)");
            Log.d(str4, format4, e13);
        } catch (RuntimeException e14) {
            String str5 = f24936e;
            b0 b0Var5 = b0.f709a;
            String format5 = String.format("reflective setup failed using obj: %s method: %s field: %s", Arrays.copyOf(new Object[]{"android.view.WindowManagerGlobal", "getInstance", "mViews"}, 3));
            m.e(format5, "java.lang.String.format(format, *args)");
            Log.d(str5, format5, e14);
        } catch (IllegalAccessException e15) {
            String str6 = f24936e;
            b0 b0Var6 = b0.f709a;
            String format6 = String.format("reflective setup failed using obj: %s method: %s field: %s", Arrays.copyOf(new Object[]{"android.view.WindowManagerGlobal", "getInstance", "mViews"}, 3));
            m.e(format6, "java.lang.String.format(format, *args)");
            Log.d(str6, format6, e15);
        }
    }

    public final List b() {
        Object obj;
        Object obj2;
        Iterable iterable;
        if (!this.f24938a) {
            a();
        }
        Object obj3 = this.f24939b;
        if (obj3 == null) {
            Log.d(f24936e, "No reflective access to windowmanager object.");
            return null;
        }
        Field field = this.f24940c;
        if (field == null) {
            Log.d(f24936e, "No reflective access to mViews");
            return null;
        } else if (this.f24941d == null) {
            Log.d(f24936e, "No reflective access to mPArams");
            return null;
        } else {
            if (field != null) {
                try {
                    obj = field.get(obj3);
                } catch (RuntimeException e10) {
                    String str = f24936e;
                    b0 b0Var = b0.f709a;
                    String format = String.format("Reflective access to %s or %s on %s failed.", Arrays.copyOf(new Object[]{this.f24940c, this.f24941d, this.f24939b}, 3));
                    m.e(format, "java.lang.String.format(format, *args)");
                    Log.d(str, format, e10);
                    return null;
                } catch (IllegalAccessException e11) {
                    String str2 = f24936e;
                    b0 b0Var2 = b0.f709a;
                    String format2 = String.format("Reflective access to %s or %s on %s failed.", Arrays.copyOf(new Object[]{this.f24940c, this.f24941d, this.f24939b}, 3));
                    m.e(format2, "java.lang.String.format(format, *args)");
                    Log.d(str2, format2, e11);
                    return null;
                }
            } else {
                obj = null;
            }
            List list = (List) obj;
            Field field2 = this.f24941d;
            if (field2 != null) {
                obj2 = field2.get(this.f24939b);
            } else {
                obj2 = null;
            }
            List list2 = (List) obj2;
            ArrayList arrayList = new ArrayList();
            if (list == null) {
                list = r.l();
            }
            Iterable iterable2 = list;
            if (list2 != null) {
                iterable = list2;
            } else {
                iterable = r.l();
            }
            for (Pair pair : r.B0(iterable2, iterable)) {
                arrayList.add(new b((View) pair.a(), (WindowManager.LayoutParams) pair.b()));
            }
            return arrayList;
        }
    }
}
