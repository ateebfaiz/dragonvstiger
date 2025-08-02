package androidx.webkit.internal;

import android.content.Context;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerClientCompat;
import java.io.File;

@RequiresApi(24)
public class ApiHelperForN {
    private ApiHelperForN() {
    }

    public static boolean getAllowContentAccess(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowContentAccess();
    }

    public static boolean getAllowFileAccess(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowFileAccess();
    }

    public static boolean getBlockNetworkLoads(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getBlockNetworkLoads();
    }

    public static int getCacheMode(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getCacheMode();
    }

    public static File getDataDir(Context context) {
        return context.getDataDir();
    }

    public static int getDisabledActionModeMenuItems(WebSettings webSettings) {
        return webSettings.getDisabledActionModeMenuItems();
    }

    public static ServiceWorkerController getServiceWorkerControllerInstance() {
        return ServiceWorkerController.getInstance();
    }

    public static ServiceWorkerWebSettings getServiceWorkerWebSettings(ServiceWorkerController serviceWorkerController) {
        return serviceWorkerController.getServiceWorkerWebSettings();
    }

    public static ServiceWorkerWebSettingsImpl getServiceWorkerWebSettingsImpl(ServiceWorkerController serviceWorkerController) {
        return new ServiceWorkerWebSettingsImpl(getServiceWorkerWebSettings(serviceWorkerController));
    }

    public static boolean isRedirect(WebResourceRequest webResourceRequest) {
        return webResourceRequest.isRedirect();
    }

    public static void setAllowContentAccess(ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z10) {
        serviceWorkerWebSettings.setAllowContentAccess(z10);
    }

    public static void setAllowFileAccess(ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z10) {
        serviceWorkerWebSettings.setAllowFileAccess(z10);
    }

    public static void setBlockNetworkLoads(ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z10) {
        serviceWorkerWebSettings.setBlockNetworkLoads(z10);
    }

    public static void setCacheMode(ServiceWorkerWebSettings serviceWorkerWebSettings, int i10) {
        serviceWorkerWebSettings.setCacheMode(i10);
    }

    public static void setDisabledActionModeMenuItems(WebSettings webSettings, int i10) {
        webSettings.setDisabledActionModeMenuItems(i10);
    }

    public static void setServiceWorkerClient(ServiceWorkerController serviceWorkerController, ServiceWorkerClient serviceWorkerClient) {
        serviceWorkerController.setServiceWorkerClient(serviceWorkerClient);
    }

    public static void setServiceWorkerClientCompat(ServiceWorkerController serviceWorkerController, ServiceWorkerClientCompat serviceWorkerClientCompat) {
        serviceWorkerController.setServiceWorkerClient(new FrameworkServiceWorkerClient(serviceWorkerClientCompat));
    }
}
