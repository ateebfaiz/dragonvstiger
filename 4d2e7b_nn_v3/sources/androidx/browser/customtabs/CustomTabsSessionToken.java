package androidx.browser.customtabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.BundleCompat;
import z.a;

public class CustomTabsSessionToken {
    private static final String TAG = "CustomTabsSessionToken";
    private final CustomTabsCallback mCallback = new a();
    final z.a mCallbackBinder;

    class a extends CustomTabsCallback {
        a() {
        }

        public void extraCallback(String str, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.z(str, bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void onMessageChannelReady(Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.E(bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void onNavigationEvent(int i10, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.C(i10, bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void onPostMessage(String str, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.D(str, bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void onRelationshipValidationResult(int i10, Uri uri, boolean z10, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.mCallbackBinder.H(i10, uri, z10, bundle);
            } catch (RemoteException unused) {
                Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
            }
        }
    }

    static class b extends a.C0358a {
        b() {
        }

        public void C(int i10, Bundle bundle) {
        }

        public void D(String str, Bundle bundle) {
        }

        public void E(Bundle bundle) {
        }

        public void H(int i10, Uri uri, boolean z10, Bundle bundle) {
        }

        public IBinder asBinder() {
            return this;
        }

        public void z(String str, Bundle bundle) {
        }
    }

    CustomTabsSessionToken(z.a aVar) {
        this.mCallbackBinder = aVar;
    }

    @NonNull
    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new b());
    }

    public static CustomTabsSessionToken getSessionTokenFromIntent(Intent intent) {
        IBinder binder = BundleCompat.getBinder(intent.getExtras(), CustomTabsIntent.EXTRA_SESSION);
        if (binder == null) {
            return null;
        }
        return new CustomTabsSessionToken(a.C0358a.M(binder));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        return ((CustomTabsSessionToken) obj).getCallbackBinder().equals(this.mCallbackBinder.asBinder());
    }

    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    /* access modifiers changed from: package-private */
    public IBinder getCallbackBinder() {
        return this.mCallbackBinder.asBinder();
    }

    public int hashCode() {
        return getCallbackBinder().hashCode();
    }

    public boolean isAssociatedWith(CustomTabsSession customTabsSession) {
        return customTabsSession.getBinder().equals(this.mCallbackBinder);
    }
}
