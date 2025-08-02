package androidx.webkit.internal;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

public class WebViewGlueCommunicator {
    private static final String GLUE_FACTORY_PROVIDER_FETCHER_CLASS = "org.chromium.support_lib_glue.SupportLibReflectionUtil";
    private static final String GLUE_FACTORY_PROVIDER_FETCHER_METHOD = "createWebViewProviderFactory";

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final WebkitToCompatConverter f16939a = new WebkitToCompatConverter(WebViewGlueCommunicator.getFactory().getWebkitToCompatConverter());
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        static final WebViewProviderFactory f16940a = WebViewGlueCommunicator.createGlueProviderFactory();
    }

    private WebViewGlueCommunicator() {
    }

    static WebViewProviderFactory createGlueProviderFactory() {
        try {
            return new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) gc.a.a(WebViewProviderFactoryBoundaryInterface.class, fetchGlueProviderFactoryImpl()));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        } catch (ClassNotFoundException unused) {
            return new IncompatibleApkWebViewProviderFactory();
        }
    }

    private static InvocationHandler fetchGlueProviderFactoryImpl() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        return (InvocationHandler) Class.forName(GLUE_FACTORY_PROVIDER_FETCHER_CLASS, false, getWebViewClassLoader()).getDeclaredMethod(GLUE_FACTORY_PROVIDER_FETCHER_METHOD, (Class[]) null).invoke((Object) null, (Object[]) null);
    }

    public static WebkitToCompatConverter getCompatConverter() {
        return a.f16939a;
    }

    public static WebViewProviderFactory getFactory() {
        return b.f16940a;
    }

    public static ClassLoader getWebViewClassLoader() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ApiHelperForP.getWebViewClassLoader();
        }
        return getWebViewProviderFactory().getClass().getClassLoader();
    }

    private static Object getWebViewProviderFactory() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", (Class[]) null);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke((Object) null, (Object[]) null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }
}
