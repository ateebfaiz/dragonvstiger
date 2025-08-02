package androidx.media;

import android.content.Context;
import android.service.media.MediaBrowserService;
import androidx.media.MediaBrowserServiceCompatApi21;

abstract class MediaBrowserServiceCompatApi23 {

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String str, MediaBrowserServiceCompatApi21.c cVar);
    }

    static class a extends MediaBrowserServiceCompatApi21.b {
        a(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        public void onLoadItem(String str, MediaBrowserService.Result result) {
            ((ServiceCompatProxy) this.f16023a).onLoadItem(str, new MediaBrowserServiceCompatApi21.c(result));
        }
    }

    public static Object a(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new a(context, serviceCompatProxy);
    }
}
