package y8;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import u8.b;
import w8.c;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f13358a = new k();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f13359b;

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f13360c;

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f13361d;

    static {
        Pattern compile = Pattern.compile("\\$\\$.{32}\\$\\$AndroidAOP$");
        m.e(compile, "compile(\"\\\\$\\\\$.{32}\\\\$\\\\\\$AndroidAOP$\")");
        f13359b = compile;
        Pattern compile2 = Pattern.compile("\\$Invoke[a-zA-Z0-9]{32}$");
        m.e(compile2, "compile(\"\\\\\\$Invoke[a-zA-Z0-9]{32}$\")");
        f13360c = compile2;
        Pattern compile3 = Pattern.compile("Invoke[a-zA-Z0-9]{32}$");
        m.e(compile3, "compile(\"Invoke[a-zA-Z0-9]{32}$\")");
        f13361d = compile3;
    }

    private k() {
    }

    private final String a(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f13359b.matcher(str);
        m.e(matcher, "AOPMethodPattern.matcher(methodName)");
        if (matcher.find()) {
            return matcher.replaceAll("");
        }
        return str;
    }

    private final boolean c(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = f13360c.matcher(str);
        m.e(matcher, "InvokeClassPattern.matcher(className)");
        return matcher.find();
    }

    private final boolean d(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = f13361d.matcher(str);
        m.e(matcher, "InvokeStaticClassPattern.matcher(className)");
        return matcher.find();
    }

    public final Throwable b(Throwable th) {
        Class<StackTraceElement> cls;
        int i10;
        m.f(th, "e");
        if (th instanceof InvocationTargetException) {
            th = ((InvocationTargetException) th).getTargetException();
            m.e(th, "{\n            e.targetException\n        }");
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            List X = j.X(stackTrace);
            Iterator it = X.iterator();
            loop0:
            while (true) {
                String str = null;
                String str2 = null;
                while (true) {
                    cls = StackTraceElement.class;
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    StackTraceElement stackTraceElement = (StackTraceElement) it.next();
                    if (stackTraceElement != null) {
                        k kVar = f13358a;
                        if (!kVar.c(stackTraceElement.getClassName())) {
                            if (kVar.d(stackTraceElement.getClassName()) && kVar.c(stackTraceElement.getMethodName())) {
                                it.remove();
                            } else if (!m.b(stackTraceElement.getClassName(), z.b(b.class).a()) || (th instanceof c)) {
                                if (str != null && str2 != null && m.b(stackTraceElement.getClassName(), str) && m.b(stackTraceElement.getMethodName(), str2) && stackTraceElement.getLineNumber() < 0) {
                                    break;
                                }
                                String a10 = kVar.a(stackTraceElement.getMethodName());
                                if (!m.b(a10, stackTraceElement.getMethodName())) {
                                    str = stackTraceElement.getClassName();
                                    try {
                                        Field declaredField = cls.getDeclaredField("methodName");
                                        declaredField.setAccessible(true);
                                        declaredField.set(stackTraceElement, a10);
                                    } catch (Throwable unused) {
                                    }
                                    str2 = a10;
                                }
                            } else {
                                it.remove();
                            }
                        }
                    }
                    it.remove();
                }
                it.remove();
            }
            i10 = 0;
            try {
                th.setStackTrace((StackTraceElement[]) X.toArray(new StackTraceElement[0]));
                break loop0;
            } catch (Throwable unused2) {
            }
        }
        return th;
        i10++;
    }
}
