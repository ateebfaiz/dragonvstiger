package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.webkit.internal.ServiceWorkerControllerImpl;

@AnyThread
public abstract class ServiceWorkerControllerCompat {

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final ServiceWorkerControllerCompat f16921a = new ServiceWorkerControllerImpl();
    }

    public static ServiceWorkerControllerCompat getInstance() {
        return a.f16921a;
    }

    public abstract ServiceWorkerWebSettingsCompat getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(ServiceWorkerClientCompat serviceWorkerClientCompat);
}
