package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.a;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {

    /* renamed from: b  reason: collision with root package name */
    static final boolean f13683b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a  reason: collision with root package name */
    private final c f13684a;

    private static class CustomActionResultReceiver extends ResultReceiver {
        /* access modifiers changed from: protected */
        public void a(int i10, Bundle bundle) {
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        /* access modifiers changed from: protected */
        public void a(int i10, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i10 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                MediaItem mediaItem = (MediaItem) parcelable;
                throw null;
            }
            throw null;
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f13685a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f13686b;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: b */
            public MediaItem[] newArray(int i10) {
                return new MediaItem[i10];
            }
        }

        MediaItem(Parcel parcel) {
            this.f13685a = parcel.readInt();
            this.f13686b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{" + "mFlags=" + this.f13685a + ", mDescription=" + this.f13686b + '}';
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f13685a);
            this.f13686b.writeToParcel(parcel, i10);
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        /* access modifiers changed from: protected */
        public void a(int i10, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i10 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            throw null;
        }
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f13687a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference f13688b;

        a(g gVar) {
            this.f13687a = new WeakReference(gVar);
        }

        /* access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            this.f13688b = new WeakReference(messenger);
        }

        public void handleMessage(Message message) {
            WeakReference weakReference = this.f13688b;
            if (weakReference != null && weakReference.get() != null && this.f13687a.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.a(data);
                g gVar = (g) this.f13687a.get();
                Messenger messenger = (Messenger) this.f13688b.get();
                try {
                    int i10 = message.what;
                    if (i10 == 1) {
                        Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                        MediaSessionCompat.a(bundle);
                        gVar.e(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                    } else if (i10 == 2) {
                        gVar.g(messenger);
                    } else if (i10 != 3) {
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: " + 1 + "\n  Service version: " + message.arg1);
                    } else {
                        Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                        MediaSessionCompat.a(bundle2);
                        Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                        MediaSessionCompat.a(bundle3);
                        gVar.f(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        gVar.g(messenger);
                    }
                }
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f13689a = a.c(new C0173b());

        /* renamed from: b  reason: collision with root package name */
        a f13690b;

        interface a {
            void a();

            void b();

            void c();
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b  reason: collision with other inner class name */
        private class C0173b implements a.C0174a {
            C0173b() {
            }

            public void a() {
                a aVar = b.this.f13690b;
                if (aVar != null) {
                    aVar.a();
                }
                b.this.a();
            }

            public void b() {
                a aVar = b.this.f13690b;
                if (aVar != null) {
                    aVar.b();
                }
                b.this.c();
            }

            public void c() {
                a aVar = b.this.f13690b;
                if (aVar != null) {
                    aVar.c();
                }
                b.this.b();
            }
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        /* access modifiers changed from: package-private */
        public void d(a aVar) {
            this.f13690b = aVar;
        }
    }

    interface c {
        void connect();

        MediaSessionCompat.Token d();

        void disconnect();
    }

    static class d implements c, g, b.a {

        /* renamed from: a  reason: collision with root package name */
        final Context f13692a;

        /* renamed from: b  reason: collision with root package name */
        protected final Object f13693b;

        /* renamed from: c  reason: collision with root package name */
        protected final Bundle f13694c;

        /* renamed from: d  reason: collision with root package name */
        protected final a f13695d = new a(this);

        /* renamed from: e  reason: collision with root package name */
        private final ArrayMap f13696e = new ArrayMap();

        /* renamed from: f  reason: collision with root package name */
        protected int f13697f;

        /* renamed from: g  reason: collision with root package name */
        protected h f13698g;

        /* renamed from: h  reason: collision with root package name */
        protected Messenger f13699h;

        /* renamed from: i  reason: collision with root package name */
        private MediaSessionCompat.Token f13700i;

        d(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            Bundle bundle2;
            this.f13692a = context;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            this.f13694c = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            bVar.d(this);
            this.f13693b = a.b(context, componentName, bVar.f13689a, bundle2);
        }

        public void a() {
            Bundle e10 = a.e(this.f13693b);
            if (e10 != null) {
                this.f13697f = e10.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(e10, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.f13698g = new h(binder, this.f13694c);
                    Messenger messenger = new Messenger(this.f13695d);
                    this.f13699h = messenger;
                    this.f13695d.a(messenger);
                    try {
                        this.f13698g.a(this.f13692a, this.f13699h);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                android.support.v4.media.session.b M = b.a.M(BundleCompat.getBinder(e10, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (M != null) {
                    this.f13700i = MediaSessionCompat.Token.b(a.f(this.f13693b), M);
                }
            }
        }

        public void b() {
            this.f13698g = null;
            this.f13699h = null;
            this.f13700i = null;
            this.f13695d.a((Messenger) null);
        }

        public void c() {
        }

        public void connect() {
            a.a(this.f13693b);
        }

        public MediaSessionCompat.Token d() {
            if (this.f13700i == null) {
                this.f13700i = MediaSessionCompat.Token.a(a.f(this.f13693b));
            }
            return this.f13700i;
        }

        public void disconnect() {
            Messenger messenger;
            h hVar = this.f13698g;
            if (!(hVar == null || (messenger = this.f13699h) == null)) {
                try {
                    hVar.c(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            a.d(this.f13693b);
        }

        public void e(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        public void f(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f13699h == messenger) {
                c.d.a(this.f13696e.get(str));
                if (MediaBrowserCompat.f13683b) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                }
            }
        }

        public void g(Messenger messenger) {
        }
    }

    static class e extends d {
        e(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    static class f extends e {
        f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    interface g {
        void e(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void f(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void g(Messenger messenger);
    }

    private static class h {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f13701a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f13702b;

        public h(IBinder iBinder, Bundle bundle) {
            this.f13701a = new Messenger(iBinder);
            this.f13702b = bundle;
        }

        private void b(int i10, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f13701a.send(obtain);
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f13702b);
            b(6, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        public void c(Messenger messenger) {
            b(7, (Bundle) null, messenger);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f13684a = new f(context, componentName, bVar, bundle);
        } else {
            this.f13684a = new e(context, componentName, bVar, bundle);
        }
    }

    public void a() {
        this.f13684a.connect();
    }

    public void b() {
        this.f13684a.disconnect();
    }

    public MediaSessionCompat.Token c() {
        return this.f13684a.d();
    }
}
