package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;

abstract class a {

    /* renamed from: android.support.v4.media.a$a  reason: collision with other inner class name */
    interface C0174a {
        void a();

        void b();

        void c();
    }

    static class b extends MediaBrowser.ConnectionCallback {

        /* renamed from: a  reason: collision with root package name */
        protected final C0174a f13727a;

        public b(C0174a aVar) {
            this.f13727a = aVar;
        }

        public void onConnected() {
            this.f13727a.a();
        }

        public void onConnectionFailed() {
            this.f13727a.c();
        }

        public void onConnectionSuspended() {
            this.f13727a.b();
        }
    }

    public static void a(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static Object b(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static Object c(C0174a aVar) {
        return new b(aVar);
    }

    public static void d(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static Bundle e(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static Object f(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }
}
