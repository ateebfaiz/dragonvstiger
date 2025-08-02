package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.installreferrer.commons.InstallReferrerCommons;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

class InstallReferrerClientImpl extends InstallReferrerClient {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f18320a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Context f18321b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IGetInstallReferrerService f18322c;

    /* renamed from: d  reason: collision with root package name */
    private ServiceConnection f18323d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    private final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final InstallReferrerStateListener f18324a;

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service connected.");
            IGetInstallReferrerService unused = InstallReferrerClientImpl.this.f18322c = IGetInstallReferrerService.Stub.b(iBinder);
            int unused2 = InstallReferrerClientImpl.this.f18320a = 2;
            this.f18324a.onInstallReferrerSetupFinished(0);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Install Referrer service disconnected.");
            IGetInstallReferrerService unused = InstallReferrerClientImpl.this.f18322c = null;
            int unused2 = InstallReferrerClientImpl.this.f18320a = 0;
            this.f18324a.onInstallReferrerServiceDisconnected();
        }

        private b(InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener != null) {
                this.f18324a = installReferrerStateListener;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }
    }

    public InstallReferrerClientImpl(Context context) {
        this.f18321b = context.getApplicationContext();
    }

    private boolean c() {
        try {
            if (this.f18321b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public void endConnection() {
        this.f18320a = 3;
        if (this.f18323d != null) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Unbinding from service.");
            this.f18321b.unbindService(this.f18323d);
            this.f18323d = null;
        }
        this.f18322c = null;
    }

    public ReferrerDetails getInstallReferrer() {
        if (isReady()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f18321b.getPackageName());
            try {
                return new ReferrerDetails(this.f18322c.c(bundle));
            } catch (RemoteException e10) {
                InstallReferrerCommons.logWarn("InstallReferrerClient", "RemoteException getting install referrer information");
                this.f18320a = 0;
                throw e10;
            }
        } else {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
    }

    public boolean isReady() {
        return (this.f18320a != 2 || this.f18322c == null || this.f18323d == null) ? false : true;
    }

    public void startConnection(InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        if (isReady()) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i10 = this.f18320a;
        if (i10 == 1) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
        } else if (i10 == 3) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
        } else {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Starting install referrer service setup.");
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            List<ResolveInfo> queryIntentServices = this.f18321b.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty() || (serviceInfo = queryIntentServices.get(0).serviceInfo) == null) {
                this.f18320a = 0;
                InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service unavailable on device.");
                installReferrerStateListener.onInstallReferrerSetupFinished(2);
                return;
            }
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (!"com.android.vending".equals(str) || str2 == null || !c()) {
                InstallReferrerCommons.logWarn("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
                this.f18320a = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(2);
                return;
            }
            Intent intent2 = new Intent(intent);
            b bVar = new b(installReferrerStateListener);
            this.f18323d = bVar;
            try {
                if (this.f18321b.bindService(intent2, bVar, 1)) {
                    InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service was bonded successfully.");
                    return;
                }
                InstallReferrerCommons.logWarn("InstallReferrerClient", "Connection to service is blocked.");
                this.f18320a = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(1);
            } catch (SecurityException unused) {
                InstallReferrerCommons.logWarn("InstallReferrerClient", "No permission to connect to service.");
                this.f18320a = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(4);
            }
        }
    }
}
