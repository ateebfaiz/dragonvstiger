package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompatApi23;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class MediaBrowserServiceCompatApi26 {

    /* renamed from: a  reason: collision with root package name */
    static Field f16025a;

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String str, b bVar, Bundle bundle);
    }

    static class a extends MediaBrowserServiceCompatApi23.a {
        a(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((ServiceCompatProxy) this.f16023a).onLoadChildren(str, new b(result), bundle);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        MediaBrowserService.Result f16026a;

        b(MediaBrowserService.Result result) {
            this.f16026a = result;
        }

        public void a() {
            this.f16026a.detach();
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

        public void c(List list, int i10) {
            try {
                MediaBrowserServiceCompatApi26.f16025a.setInt(this.f16026a, i10);
            } catch (IllegalAccessException e10) {
                Log.w("MBSCompatApi26", e10);
            }
            this.f16026a.sendResult(b(list));
        }
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f16025a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e10) {
            Log.w("MBSCompatApi26", e10);
        }
    }

    public static Object a(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new a(context, serviceCompatProxy);
    }

    public static Bundle b(Object obj) {
        return ((MediaBrowserService) obj).getBrowserRootHints();
    }

    public static void c(Object obj, String str, Bundle bundle) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }
}
