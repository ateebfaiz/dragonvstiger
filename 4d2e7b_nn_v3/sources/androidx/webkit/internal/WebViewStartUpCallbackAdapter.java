package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.webkit.BlockingStartUpLocation;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewStartUpResult;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.chromium.support_lib_boundary.WebViewStartUpCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewStartUpResultBoundaryInterface;

public class WebViewStartUpCallbackAdapter implements WebViewStartUpCallbackBoundaryInterface {
    private final WebViewCompat.WebViewStartUpCallback mWebViewStartUpCallback;

    class a implements WebViewStartUpResult {

        /* renamed from: a  reason: collision with root package name */
        private final List f16941a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WebViewStartUpResultBoundaryInterface f16942b;

        a(WebViewStartUpResultBoundaryInterface webViewStartUpResultBoundaryInterface) {
            this.f16942b = webViewStartUpResultBoundaryInterface;
            this.f16941a = a(webViewStartUpResultBoundaryInterface.getBlockingStartUpLocations());
        }

        private List a(List list) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new b((Throwable) it.next()));
            }
            return arrayList;
        }

        public List getBlockingStartUpLocations() {
            return this.f16941a;
        }

        public Long getMaxTimePerTaskInUiThreadMillis() {
            return this.f16942b.getMaxTimePerTaskInUiThreadMillis();
        }

        public Long getTotalTimeInUiThreadMillis() {
            return this.f16942b.getTotalTimeInUiThreadMillis();
        }
    }

    private static class b implements BlockingStartUpLocation {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f16944a;

        b(Throwable th) {
            this.f16944a = th;
        }

        public String getStackInformation() {
            StringWriter stringWriter = new StringWriter();
            this.f16944a.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
    }

    public WebViewStartUpCallbackAdapter(@NonNull WebViewCompat.WebViewStartUpCallback webViewStartUpCallback) {
        this.mWebViewStartUpCallback = webViewStartUpCallback;
    }

    private WebViewStartUpResult webViewStartUpResultFromBoundaryInterface(@NonNull WebViewStartUpResultBoundaryInterface webViewStartUpResultBoundaryInterface) {
        return new a(webViewStartUpResultBoundaryInterface);
    }

    public void onSuccess(@NonNull InvocationHandler invocationHandler) {
        WebViewStartUpResultBoundaryInterface webViewStartUpResultBoundaryInterface = (WebViewStartUpResultBoundaryInterface) gc.a.a(WebViewStartUpResultBoundaryInterface.class, invocationHandler);
        Objects.requireNonNull(webViewStartUpResultBoundaryInterface);
        this.mWebViewStartUpCallback.onSuccess(webViewStartUpResultFromBoundaryInterface(webViewStartUpResultBoundaryInterface));
    }
}
