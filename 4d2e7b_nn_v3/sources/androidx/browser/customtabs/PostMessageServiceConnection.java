package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import z.a;
import z.c;

public abstract class PostMessageServiceConnection implements ServiceConnection {
    private final Object mLock = new Object();
    private c mService;
    private final a mSessionBinder;

    public PostMessageServiceConnection(CustomTabsSessionToken customTabsSessionToken) {
        this.mSessionBinder = a.C0358a.M(customTabsSessionToken.getCallbackBinder());
    }

    public boolean bindSessionToPostMessageService(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(str, PostMessageService.class.getName());
        return context.bindService(intent, this, 1);
    }

    public final boolean notifyMessageChannelReady(Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        synchronized (this.mLock) {
            try {
                this.mService.o(this.mSessionBinder, bundle);
            } catch (RemoteException unused) {
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void onPostMessageServiceConnected() {
    }

    public void onPostMessageServiceDisconnected() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = c.a.M(iBinder);
        onPostMessageServiceConnected();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        onPostMessageServiceDisconnected();
    }

    public final boolean postMessage(String str, Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        synchronized (this.mLock) {
            try {
                this.mService.h(this.mSessionBinder, str, bundle);
            } catch (RemoteException unused) {
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void unbindFromContext(Context context) {
        context.unbindService(this);
    }
}
