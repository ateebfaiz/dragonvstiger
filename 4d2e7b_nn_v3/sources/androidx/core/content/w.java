package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

class w implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    IUnusedAppRestrictionsBackportService f14919a = null;

    /* renamed from: b  reason: collision with root package name */
    ResolvableFuture f14920b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f14921c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14922d = false;

    class a extends IUnusedAppRestrictionsBackportCallback.Stub {
        a() {
        }

        public void onIsPermissionRevocationEnabledForAppResult(boolean z10, boolean z11) {
            if (!z10) {
                w.this.f14920b.set(0);
                Log.e(PackageManagerCompat.LOG_TAG, "Unable to retrieve the permission revocation setting from the backport");
            } else if (z11) {
                w.this.f14920b.set(3);
            } else {
                w.this.f14920b.set(2);
            }
        }
    }

    w(Context context) {
        this.f14921c = context;
    }

    private IUnusedAppRestrictionsBackportCallback c() {
        return new a();
    }

    public void a(ResolvableFuture resolvableFuture) {
        if (!this.f14922d) {
            this.f14922d = true;
            this.f14920b = resolvableFuture;
            this.f14921c.bindService(new Intent(UnusedAppRestrictionsBackportService.ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION).setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.f14921c.getPackageManager())), this, 1);
            return;
        }
        throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
    }

    public void b() {
        if (this.f14922d) {
            this.f14922d = false;
            this.f14921c.unbindService(this);
            return;
        }
        throw new IllegalStateException("bindService must be called before unbind");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService asInterface = IUnusedAppRestrictionsBackportService.Stub.asInterface(iBinder);
        this.f14919a = asInterface;
        try {
            asInterface.isPermissionRevocationEnabledForApp(c());
        } catch (RemoteException unused) {
            this.f14920b.set(0);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f14919a = null;
    }
}
