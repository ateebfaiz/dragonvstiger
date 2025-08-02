package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsSessionToken;
import java.util.List;
import z.a;
import z.b;

public final class CustomTabsSession {
    private static final String TAG = "CustomTabsSession";
    private final a mCallback;
    private final ComponentName mComponentName;
    private final Object mLock = new Object();
    private final b mService;

    CustomTabsSession(b bVar, a aVar, ComponentName componentName) {
        this.mService = bVar;
        this.mCallback = aVar;
        this.mComponentName = componentName;
    }

    @VisibleForTesting
    @NonNull
    public static CustomTabsSession createMockSessionForTesting(@NonNull ComponentName componentName) {
        return new CustomTabsSession((b) null, new CustomTabsSessionToken.b(), componentName);
    }

    /* access modifiers changed from: package-private */
    public IBinder getBinder() {
        return this.mCallback.asBinder();
    }

    /* access modifiers changed from: package-private */
    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            return this.mService.g(this.mCallback, uri, bundle, list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public int postMessage(String str, Bundle bundle) {
        int B;
        synchronized (this.mLock) {
            try {
                B = this.mService.B(this.mCallback, str, bundle);
            } catch (RemoteException unused) {
                return -2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return B;
    }

    public boolean requestPostMessageChannel(Uri uri) {
        try {
            return this.mService.p(this.mCallback, uri);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean setActionButton(@NonNull Bitmap bitmap, @NonNull String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
        bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
        try {
            return this.mService.s(this.mCallback, bundle2);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean setSecondaryToolbarViews(@Nullable RemoteViews remoteViews, @Nullable int[] iArr, @Nullable PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CustomTabsIntent.EXTRA_REMOTEVIEWS, remoteViews);
        bundle.putIntArray(CustomTabsIntent.EXTRA_REMOTEVIEWS_VIEW_IDS, iArr);
        bundle.putParcelable(CustomTabsIntent.EXTRA_REMOTEVIEWS_PENDINGINTENT, pendingIntent);
        try {
            return this.mService.s(this.mCallback, bundle);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Deprecated
    public boolean setToolbarItem(int i10, @NonNull Bitmap bitmap, @NonNull String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(CustomTabsIntent.KEY_ID, i10);
        bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
        bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
        try {
            return this.mService.s(this.mCallback, bundle2);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean validateRelationship(int i10, @NonNull Uri uri, @Nullable Bundle bundle) {
        if (i10 >= 1 && i10 <= 2) {
            try {
                return this.mService.n(this.mCallback, i10, uri, bundle);
            } catch (RemoteException unused) {
            }
        }
        return false;
    }
}
