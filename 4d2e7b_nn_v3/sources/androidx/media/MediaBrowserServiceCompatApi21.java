package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class MediaBrowserServiceCompatApi21 {

    public interface ServiceCompatProxy {
        a onGetRoot(String str, int i10, Bundle bundle);

        void onLoadChildren(String str, c cVar);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final String f16021a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f16022b;

        a(String str, Bundle bundle) {
            this.f16021a = str;
            this.f16022b = bundle;
        }
    }

    static class b extends MediaBrowserService {

        /* renamed from: a  reason: collision with root package name */
        final ServiceCompatProxy f16023a;

        b(Context context, ServiceCompatProxy serviceCompatProxy) {
            attachBaseContext(context);
            this.f16023a = serviceCompatProxy;
        }

        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i10, Bundle bundle) {
            Bundle bundle2;
            MediaSessionCompat.a(bundle);
            ServiceCompatProxy serviceCompatProxy = this.f16023a;
            if (bundle == null) {
                bundle2 = null;
            } else {
                bundle2 = new Bundle(bundle);
            }
            a onGetRoot = serviceCompatProxy.onGetRoot(str, i10, bundle2);
            if (onGetRoot == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(onGetRoot.f16021a, onGetRoot.f16022b);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result result) {
            this.f16023a.onLoadChildren(str, new c(result));
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        MediaBrowserService.Result f16024a;

        c(MediaBrowserService.Result result) {
            this.f16024a = result;
        }

        public void a() {
            this.f16024a.detach();
        }

        /* access modifiers changed from: package-private */
        public List b(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Parcel parcel = (Parcel) it.next();
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        public void c(Object obj) {
            if (obj instanceof List) {
                this.f16024a.sendResult(b((List) obj));
            } else if (obj instanceof Parcel) {
                Parcel parcel = (Parcel) obj;
                parcel.setDataPosition(0);
                this.f16024a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.f16024a.sendResult((Object) null);
            }
        }
    }

    public static void a(Object obj, String str) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str);
    }

    public static IBinder b(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void c(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static void d(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((MediaSession.Token) obj2);
    }
}
