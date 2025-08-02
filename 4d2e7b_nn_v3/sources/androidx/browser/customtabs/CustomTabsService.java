package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import z.b;

public abstract class CustomTabsService extends Service {
    public static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    public static final String KEY_URL = "android.support.customtabs.otherurls.URL";
    public static final int RELATION_HANDLE_ALL_URLS = 2;
    public static final int RELATION_USE_AS_ORIGIN = 1;
    public static final int RESULT_FAILURE_DISALLOWED = -1;
    public static final int RESULT_FAILURE_MESSAGING_ERROR = -3;
    public static final int RESULT_FAILURE_REMOTE_ERROR = -2;
    public static final int RESULT_SUCCESS = 0;
    private b.a mBinder = new a();
    final Map<IBinder, IBinder.DeathRecipient> mDeathRecipientMap = new ArrayMap();

    @Retention(RetentionPolicy.SOURCE)
    public @interface Relation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    class a extends b.a {

        /* renamed from: androidx.browser.customtabs.CustomTabsService$a$a  reason: collision with other inner class name */
        class C0183a implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CustomTabsSessionToken f14449a;

            C0183a(CustomTabsSessionToken customTabsSessionToken) {
                this.f14449a = customTabsSessionToken;
            }

            public void binderDied() {
                CustomTabsService.this.cleanUpSession(this.f14449a);
            }
        }

        a() {
        }

        public int B(z.a aVar, String str, Bundle bundle) {
            return CustomTabsService.this.postMessage(new CustomTabsSessionToken(aVar), str, bundle);
        }

        public boolean G(z.a aVar) {
            CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(aVar);
            try {
                C0183a aVar2 = new C0183a(customTabsSessionToken);
                synchronized (CustomTabsService.this.mDeathRecipientMap) {
                    aVar.asBinder().linkToDeath(aVar2, 0);
                    CustomTabsService.this.mDeathRecipientMap.put(aVar.asBinder(), aVar2);
                }
                return CustomTabsService.this.newSession(customTabsSessionToken);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public boolean g(z.a aVar, Uri uri, Bundle bundle, List list) {
            return CustomTabsService.this.mayLaunchUrl(new CustomTabsSessionToken(aVar), uri, bundle, list);
        }

        public Bundle l(String str, Bundle bundle) {
            return CustomTabsService.this.extraCommand(str, bundle);
        }

        public boolean n(z.a aVar, int i10, Uri uri, Bundle bundle) {
            return CustomTabsService.this.validateRelationship(new CustomTabsSessionToken(aVar), i10, uri, bundle);
        }

        public boolean p(z.a aVar, Uri uri) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(aVar), uri);
        }

        public boolean r(long j10) {
            return CustomTabsService.this.warmup(j10);
        }

        public boolean s(z.a aVar, Bundle bundle) {
            return CustomTabsService.this.updateVisuals(new CustomTabsSessionToken(aVar), bundle);
        }
    }

    /* access modifiers changed from: protected */
    public boolean cleanUpSession(CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.mDeathRecipientMap) {
                IBinder callbackBinder = customTabsSessionToken.getCallbackBinder();
                callbackBinder.unlinkToDeath(this.mDeathRecipientMap.get(callbackBinder), 0);
                this.mDeathRecipientMap.remove(callbackBinder);
            }
            return true;
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Bundle extraCommand(String str, Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract boolean mayLaunchUrl(CustomTabsSessionToken customTabsSessionToken, Uri uri, Bundle bundle, List<Bundle> list);

    /* access modifiers changed from: protected */
    public abstract boolean newSession(CustomTabsSessionToken customTabsSessionToken);

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    /* access modifiers changed from: protected */
    public abstract int postMessage(CustomTabsSessionToken customTabsSessionToken, String str, Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract boolean requestPostMessageChannel(CustomTabsSessionToken customTabsSessionToken, Uri uri);

    /* access modifiers changed from: protected */
    public abstract boolean updateVisuals(CustomTabsSessionToken customTabsSessionToken, Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract boolean validateRelationship(CustomTabsSessionToken customTabsSessionToken, int i10, Uri uri, Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract boolean warmup(long j10);
}
