package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class MediaControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final b f13728a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaSessionCompat.Token f13729b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet f13730c = new HashSet();

    static class MediaControllerImplApi21 implements b {

        /* renamed from: a  reason: collision with root package name */
        protected final Object f13731a;

        /* renamed from: b  reason: collision with root package name */
        final Object f13732b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private final List f13733c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private HashMap f13734d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        final MediaSessionCompat.Token f13735e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference f13736a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler) null);
                this.f13736a = new WeakReference(mediaControllerImplApi21);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i10, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f13736a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f13732b) {
                        mediaControllerImplApi21.f13735e.e(b.a.M(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.f13735e.f(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                        mediaControllerImplApi21.b();
                    }
                }
            }
        }

        private static class a extends a.C0175a {
            a(a aVar) {
                super(aVar);
            }

            public void L(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            public void j(Bundle bundle) {
                throw new AssertionError();
            }

            public void k(List list) {
                throw new AssertionError();
            }

            public void u(CharSequence charSequence) {
                throw new AssertionError();
            }

            public void v() {
                throw new AssertionError();
            }

            public void w(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f13735e = token;
            Object b10 = c.b(context, token.d());
            this.f13731a = b10;
            if (b10 == null) {
                throw new RemoteException();
            } else if (token.c() == null) {
                c();
            }
        }

        private void c() {
            d("android.support.v4.media.session.command.GET_EXTRA_BINDER", (Bundle) null, new ExtraBinderRequestResultReceiver(this));
        }

        public boolean a(KeyEvent keyEvent) {
            return c.a(this.f13731a, keyEvent);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.f13735e.c() != null) {
                Iterator it = this.f13733c.iterator();
                if (!it.hasNext()) {
                    this.f13733c.clear();
                    return;
                }
                c.d.a(it.next());
                this.f13734d.put((Object) null, new a((a) null));
                throw null;
            }
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
            c.c(this.f13731a, str, bundle, resultReceiver);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        private static class C0175a extends a.C0176a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference f13737a;

            C0175a(a aVar) {
                this.f13737a = new WeakReference(aVar);
            }

            public void A(int i10) {
                c.d.a(this.f13737a.get());
            }

            public void I(PlaybackStateCompat playbackStateCompat) {
                c.d.a(this.f13737a.get());
            }

            public void J(String str, Bundle bundle) {
                c.d.a(this.f13737a.get());
            }

            public void i() {
                c.d.a(this.f13737a.get());
            }

            public void q(boolean z10) {
                c.d.a(this.f13737a.get());
            }

            public void t(boolean z10) {
            }

            public void y(int i10) {
                c.d.a(this.f13737a.get());
            }
        }
    }

    interface b {
        boolean a(KeyEvent keyEvent);
    }

    static class c extends MediaControllerImplApi21 {
        public c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    static class d extends c {
        public d(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token != null) {
            this.f13729b = token;
            if (Build.VERSION.SDK_INT >= 24) {
                this.f13728a = new d(context, token);
            } else {
                this.f13728a = new c(context, token);
            }
        } else {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f13728a.a(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
}
