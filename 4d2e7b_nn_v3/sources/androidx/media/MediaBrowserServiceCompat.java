package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;
import androidx.media.MediaBrowserServiceCompatApi26;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final float EPSILON = 1.0E-5f;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_MEDIA_ITEM = "media_item";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SEARCH_RESULTS = "search_results";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_OK = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap<IBinder, e> mConnections = new ArrayMap<>();
    e mCurConnection;
    final n mHandler = new n();
    private f mImpl;
    MediaSessionCompat.Token mSession;

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str != null) {
                this.mRootId = str;
                this.mExtras = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        Result(Object obj) {
            this.mDebug = obj;
        }

        private void checkExtraFields(Bundle bundle) {
            if (bundle != null && bundle.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS")) {
                float f10 = bundle.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
                if (f10 < -1.0E-5f || f10 > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            } else if (this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            } else if (!this.mSendErrorCalled) {
                this.mDetachCalled = true;
            } else {
                throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
            }
        }

        /* access modifiers changed from: package-private */
        public int getFlags() {
            return this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public boolean isDone() {
            if (this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void onErrorSent(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        /* access modifiers changed from: package-private */
        public void onProgressUpdateSent(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        /* access modifiers changed from: package-private */
        public void onResultSent(T t10) {
        }

        public void sendError(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendErrorCalled = true;
            onErrorSent(bundle);
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            checkExtraFields(bundle);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(bundle);
        }

        public void sendResult(T t10) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendResultCalled = true;
            onResultSent(t10);
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i10) {
            this.mFlags = i10;
        }
    }

    class a extends Result {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f15935a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f15936b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bundle f15937c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Bundle f15938d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Object obj, e eVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f15935a = eVar;
            this.f15936b = str;
            this.f15937c = bundle;
            this.f15938d = bundle2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
            if (MediaBrowserServiceCompat.this.mConnections.get(this.f15935a.f15951f.asBinder()) == this.f15935a) {
                if ((getFlags() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.applyOptions(list, this.f15937c);
                }
                try {
                    this.f15935a.f15951f.a(this.f15936b, list, this.f15937c, this.f15938d);
                } catch (RemoteException unused) {
                    Log.w(MediaBrowserServiceCompat.TAG, "Calling onLoadChildren() failed for id=" + this.f15936b + " package=" + this.f15935a.f15946a);
                }
            } else if (MediaBrowserServiceCompat.DEBUG) {
                Log.d(MediaBrowserServiceCompat.TAG, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f15935a.f15946a + " id=" + this.f15936b);
            }
        }
    }

    class b extends Result {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ResultReceiver f15940a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f15940a = resultReceiver;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
            if ((getFlags() & 2) != 0) {
                this.f15940a.b(-1, (Bundle) null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
            this.f15940a.b(0, bundle);
        }
    }

    class c extends Result {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ResultReceiver f15942a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f15942a = resultReceiver;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void onResultSent(List list) {
            if ((getFlags() & 4) != 0 || list == null) {
                this.f15942a.b(-1, (Bundle) null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f15942a.b(0, bundle);
        }
    }

    class d extends Result {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ResultReceiver f15944a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f15944a = resultReceiver;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void onResultSent(Bundle bundle) {
            this.f15944a.b(0, bundle);
        }

        /* access modifiers changed from: package-private */
        public void onErrorSent(Bundle bundle) {
            this.f15944a.b(-1, bundle);
        }

        /* access modifiers changed from: package-private */
        public void onProgressUpdateSent(Bundle bundle) {
            this.f15944a.b(1, bundle);
        }
    }

    private class e implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final String f15946a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15947b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15948c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaSessionManager.RemoteUserInfo f15949d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f15950e;

        /* renamed from: f  reason: collision with root package name */
        public final l f15951f;

        /* renamed from: g  reason: collision with root package name */
        public final HashMap f15952g = new HashMap();

        /* renamed from: h  reason: collision with root package name */
        public BrowserRoot f15953h;

        class a implements Runnable {
            a() {
            }

            public void run() {
                e eVar = e.this;
                MediaBrowserServiceCompat.this.mConnections.remove(eVar.f15951f.asBinder());
            }
        }

        e(String str, int i10, int i11, Bundle bundle, l lVar) {
            this.f15946a = str;
            this.f15947b = i10;
            this.f15948c = i11;
            this.f15949d = new MediaSessionManager.RemoteUserInfo(str, i10, i11);
            this.f15950e = bundle;
            this.f15951f = lVar;
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.mHandler.post(new a());
        }
    }

    interface f {
        Bundle a();

        void b(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        MediaSessionManager.RemoteUserInfo c();

        IBinder d(Intent intent);

        void e(String str, Bundle bundle);

        void f(MediaSessionCompat.Token token);

        void onCreate();
    }

    class g implements f, MediaBrowserServiceCompatApi21.ServiceCompatProxy {

        /* renamed from: a  reason: collision with root package name */
        final List f15956a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        Object f15957b;

        /* renamed from: c  reason: collision with root package name */
        Messenger f15958c;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MediaSessionCompat.Token f15960a;

            a(MediaSessionCompat.Token token) {
                this.f15960a = token;
            }

            public void run() {
                if (!g.this.f15956a.isEmpty()) {
                    android.support.v4.media.session.b c10 = this.f15960a.c();
                    if (c10 != null) {
                        for (Bundle putBinder : g.this.f15956a) {
                            BundleCompat.putBinder(putBinder, MediaBrowserProtocol.EXTRA_SESSION_BINDER, c10.asBinder());
                        }
                    }
                    g.this.f15956a.clear();
                }
                MediaBrowserServiceCompatApi21.d(g.this.f15957b, this.f15960a.d());
            }
        }

        class b extends Result {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MediaBrowserServiceCompatApi21.c f15962a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Object obj, MediaBrowserServiceCompatApi21.c cVar) {
                super(obj);
                this.f15962a = cVar;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void onResultSent(List list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Parcel obtain = Parcel.obtain();
                        ((MediaBrowserCompat.MediaItem) it.next()).writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f15962a.c(arrayList);
            }

            public void detach() {
                this.f15962a.a();
            }
        }

        class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f15964a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Bundle f15965b;

            c(String str, Bundle bundle) {
                this.f15964a = str;
                this.f15965b = bundle;
            }

            public void run() {
                for (IBinder iBinder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                    ArrayMap<IBinder, e> arrayMap = MediaBrowserServiceCompat.this.mConnections;
                    g.this.i(arrayMap.get(iBinder), this.f15964a, this.f15965b);
                }
            }
        }

        class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MediaSessionManager.RemoteUserInfo f15967a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f15968b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f15969c;

            d(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
                this.f15967a = remoteUserInfo;
                this.f15968b = str;
                this.f15969c = bundle;
            }

            public void run() {
                for (int i10 = 0; i10 < MediaBrowserServiceCompat.this.mConnections.size(); i10++) {
                    e valueAt = MediaBrowserServiceCompat.this.mConnections.valueAt(i10);
                    if (valueAt.f15949d.equals(this.f15967a)) {
                        g.this.i(valueAt, this.f15968b, this.f15969c);
                    }
                }
            }
        }

        g() {
        }

        public Bundle a() {
            if (this.f15958c == null) {
                return null;
            }
            e eVar = MediaBrowserServiceCompat.this.mCurConnection;
            if (eVar == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (eVar.f15950e == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.f15950e);
            }
        }

        public void b(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            g(remoteUserInfo, str, bundle);
        }

        public MediaSessionManager.RemoteUserInfo c() {
            e eVar = MediaBrowserServiceCompat.this.mCurConnection;
            if (eVar != null) {
                return eVar.f15949d;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        public IBinder d(Intent intent) {
            return MediaBrowserServiceCompatApi21.b(this.f15957b, intent);
        }

        public void e(String str, Bundle bundle) {
            j(str, bundle);
            h(str, bundle);
        }

        public void f(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.mHandler.a(new a(token));
        }

        /* access modifiers changed from: package-private */
        public void g(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new d(remoteUserInfo, str, bundle));
        }

        /* access modifiers changed from: package-private */
        public void h(String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new c(str, bundle));
        }

        /* access modifiers changed from: package-private */
        public void i(e eVar, String str, Bundle bundle) {
            List<Pair> list = (List) eVar.f15952g.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(str, eVar, (Bundle) pair.second, bundle);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void j(String str, Bundle bundle) {
            MediaBrowserServiceCompatApi21.a(this.f15957b, str);
        }

        public MediaBrowserServiceCompatApi21.a onGetRoot(String str, int i10, Bundle bundle) {
            Bundle bundle2;
            IBinder iBinder;
            if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.f15958c = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                bundle2 = new Bundle();
                bundle2.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.f15958c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.mSession;
                if (token != null) {
                    android.support.v4.media.session.b c10 = token.c();
                    if (c10 == null) {
                        iBinder = null;
                    } else {
                        iBinder = c10.asBinder();
                    }
                    BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_SESSION_BINDER, iBinder);
                } else {
                    this.f15956a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.mCurConnection = new e(str, -1, i10, bundle, (l) null);
            BrowserRoot onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i10, bundle);
            MediaBrowserServiceCompat.this.mCurConnection = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle2.putAll(onGetRoot.getExtras());
            }
            return new MediaBrowserServiceCompatApi21.a(onGetRoot.getRootId(), bundle2);
        }

        public void onLoadChildren(String str, MediaBrowserServiceCompatApi21.c cVar) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new b(str, cVar));
        }
    }

    class h extends g implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {

        class a extends Result {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MediaBrowserServiceCompatApi21.c f15972a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Object obj, MediaBrowserServiceCompatApi21.c cVar) {
                super(obj);
                this.f15972a = cVar;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f15972a.c((Object) null);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                this.f15972a.c(obtain);
            }

            public void detach() {
                this.f15972a.a();
            }
        }

        h() {
            super();
        }

        public void onCreate() {
            Object a10 = MediaBrowserServiceCompatApi23.a(MediaBrowserServiceCompat.this, this);
            this.f15957b = a10;
            MediaBrowserServiceCompatApi21.c(a10);
        }

        public void onLoadItem(String str, MediaBrowserServiceCompatApi21.c cVar) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new a(str, cVar));
        }
    }

    class i extends h implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {

        class a extends Result {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MediaBrowserServiceCompatApi26.b f15975a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Object obj, MediaBrowserServiceCompatApi26.b bVar) {
                super(obj);
                this.f15975a = bVar;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void onResultSent(List list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Parcel obtain = Parcel.obtain();
                        ((MediaBrowserCompat.MediaItem) it.next()).writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f15975a.c(arrayList, getFlags());
            }

            public void detach() {
                this.f15975a.a();
            }
        }

        i() {
            super();
        }

        public Bundle a() {
            e eVar = MediaBrowserServiceCompat.this.mCurConnection;
            if (eVar == null) {
                return MediaBrowserServiceCompatApi26.b(this.f15957b);
            }
            if (eVar.f15950e == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.f15950e);
        }

        /* access modifiers changed from: package-private */
        public void j(String str, Bundle bundle) {
            if (bundle != null) {
                MediaBrowserServiceCompatApi26.c(this.f15957b, str, bundle);
            } else {
                super.j(str, bundle);
            }
        }

        public void onCreate() {
            Object a10 = MediaBrowserServiceCompatApi26.a(MediaBrowserServiceCompat.this, this);
            this.f15957b = a10;
            MediaBrowserServiceCompatApi21.c(a10);
        }

        public void onLoadChildren(String str, MediaBrowserServiceCompatApi26.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new a(str, bVar), bundle);
        }
    }

    class j extends i {
        j() {
            super();
        }

        public MediaSessionManager.RemoteUserInfo c() {
            e eVar = MediaBrowserServiceCompat.this.mCurConnection;
            if (eVar != null) {
                return eVar.f15949d;
            }
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.f15957b).getCurrentBrowserInfo());
        }
    }

    private class k {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f15979a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f15980b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f15981c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f15982d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ Bundle f15983e;

            a(l lVar, String str, int i10, int i11, Bundle bundle) {
                this.f15979a = lVar;
                this.f15980b = str;
                this.f15981c = i10;
                this.f15982d = i11;
                this.f15983e = bundle;
            }

            public void run() {
                IBinder asBinder = this.f15979a.asBinder();
                MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                e eVar = new e(this.f15980b, this.f15981c, this.f15982d, this.f15983e, this.f15979a);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.mCurConnection = eVar;
                BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(this.f15980b, this.f15982d, this.f15983e);
                eVar.f15953h = onGetRoot;
                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat2.mCurConnection = null;
                if (onGetRoot == null) {
                    Log.i(MediaBrowserServiceCompat.TAG, "No root for client " + this.f15980b + " from service " + getClass().getName());
                    try {
                        this.f15979a.b();
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f15980b);
                    }
                } else {
                    try {
                        mediaBrowserServiceCompat2.mConnections.put(asBinder, eVar);
                        asBinder.linkToDeath(eVar, 0);
                        if (MediaBrowserServiceCompat.this.mSession != null) {
                            this.f15979a.c(eVar.f15953h.getRootId(), MediaBrowserServiceCompat.this.mSession, eVar.f15953h.getExtras());
                        }
                    } catch (RemoteException unused2) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnect() failed. Dropping client. pkg=" + this.f15980b);
                        MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                    }
                }
            }
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f15985a;

            b(l lVar) {
                this.f15985a = lVar;
            }

            public void run() {
                e remove = MediaBrowserServiceCompat.this.mConnections.remove(this.f15985a.asBinder());
                if (remove != null) {
                    remove.f15951f.asBinder().unlinkToDeath(remove, 0);
                }
            }
        }

        class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f15987a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f15988b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ IBinder f15989c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Bundle f15990d;

            c(l lVar, String str, IBinder iBinder, Bundle bundle) {
                this.f15987a = lVar;
                this.f15988b = str;
                this.f15989c = iBinder;
                this.f15990d = bundle;
            }

            public void run() {
                e eVar = MediaBrowserServiceCompat.this.mConnections.get(this.f15987a.asBinder());
                if (eVar == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "addSubscription for callback that isn't registered id=" + this.f15988b);
                    return;
                }
                MediaBrowserServiceCompat.this.addSubscription(this.f15988b, eVar, this.f15989c, this.f15990d);
            }
        }

        class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f15992a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f15993b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ IBinder f15994c;

            d(l lVar, String str, IBinder iBinder) {
                this.f15992a = lVar;
                this.f15993b = str;
                this.f15994c = iBinder;
            }

            public void run() {
                e eVar = MediaBrowserServiceCompat.this.mConnections.get(this.f15992a.asBinder());
                if (eVar == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription for callback that isn't registered id=" + this.f15993b);
                } else if (!MediaBrowserServiceCompat.this.removeSubscription(this.f15993b, eVar, this.f15994c)) {
                    Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription called for " + this.f15993b + " which is not subscribed");
                }
            }
        }

        class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f15996a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f15997b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ResultReceiver f15998c;

            e(l lVar, String str, ResultReceiver resultReceiver) {
                this.f15996a = lVar;
                this.f15997b = str;
                this.f15998c = resultReceiver;
            }

            public void run() {
                e eVar = MediaBrowserServiceCompat.this.mConnections.get(this.f15996a.asBinder());
                if (eVar == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "getMediaItem for callback that isn't registered id=" + this.f15997b);
                    return;
                }
                MediaBrowserServiceCompat.this.performLoadItem(this.f15997b, eVar, this.f15998c);
            }
        }

        class f implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f16000a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f16001b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f16002c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f16003d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ Bundle f16004e;

            f(l lVar, String str, int i10, int i11, Bundle bundle) {
                this.f16000a = lVar;
                this.f16001b = str;
                this.f16002c = i10;
                this.f16003d = i11;
                this.f16004e = bundle;
            }

            public void run() {
                IBinder asBinder = this.f16000a.asBinder();
                MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                e eVar = new e(this.f16001b, this.f16002c, this.f16003d, this.f16004e, this.f16000a);
                MediaBrowserServiceCompat.this.mConnections.put(asBinder, eVar);
                try {
                    asBinder.linkToDeath(eVar, 0);
                } catch (RemoteException unused) {
                    Log.w(MediaBrowserServiceCompat.TAG, "IBinder is already dead.");
                }
            }
        }

        class g implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f16006a;

            g(l lVar) {
                this.f16006a = lVar;
            }

            public void run() {
                IBinder asBinder = this.f16006a.asBinder();
                e remove = MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                if (remove != null) {
                    asBinder.unlinkToDeath(remove, 0);
                }
            }
        }

        class h implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f16008a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f16009b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f16010c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ResultReceiver f16011d;

            h(l lVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f16008a = lVar;
                this.f16009b = str;
                this.f16010c = bundle;
                this.f16011d = resultReceiver;
            }

            public void run() {
                e eVar = MediaBrowserServiceCompat.this.mConnections.get(this.f16008a.asBinder());
                if (eVar == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "search for callback that isn't registered query=" + this.f16009b);
                    return;
                }
                MediaBrowserServiceCompat.this.performSearch(this.f16009b, this.f16010c, eVar, this.f16011d);
            }
        }

        class i implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f16013a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f16014b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f16015c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ResultReceiver f16016d;

            i(l lVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f16013a = lVar;
                this.f16014b = str;
                this.f16015c = bundle;
                this.f16016d = resultReceiver;
            }

            public void run() {
                e eVar = MediaBrowserServiceCompat.this.mConnections.get(this.f16013a.asBinder());
                if (eVar == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "sendCustomAction for callback that isn't registered action=" + this.f16014b + ", extras=" + this.f16015c);
                    return;
                }
                MediaBrowserServiceCompat.this.performCustomAction(this.f16014b, this.f16015c, eVar, this.f16016d);
            }
        }

        k() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, l lVar) {
            MediaBrowserServiceCompat.this.mHandler.a(new c(lVar, str, iBinder, bundle));
        }

        public void b(String str, int i10, int i11, Bundle bundle, l lVar) {
            if (MediaBrowserServiceCompat.this.isValidPackage(str, i11)) {
                MediaBrowserServiceCompat.this.mHandler.a(new a(lVar, str, i10, i11, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i11 + " package=" + str);
        }

        public void c(l lVar) {
            MediaBrowserServiceCompat.this.mHandler.a(new b(lVar));
        }

        public void d(String str, ResultReceiver resultReceiver, l lVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.mHandler.a(new e(lVar, str, resultReceiver));
            }
        }

        public void e(l lVar, String str, int i10, int i11, Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.a(new f(lVar, str, i10, i11, bundle));
        }

        public void f(String str, IBinder iBinder, l lVar) {
            MediaBrowserServiceCompat.this.mHandler.a(new d(lVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, l lVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.mHandler.a(new h(lVar, str, bundle, resultReceiver));
            }
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, l lVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.mHandler.a(new i(lVar, str, bundle, resultReceiver));
            }
        }

        public void i(l lVar) {
            MediaBrowserServiceCompat.this.mHandler.a(new g(lVar));
        }
    }

    private interface l {
        void a(String str, List list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        void b();

        void c(String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    private static class m implements l {

        /* renamed from: a  reason: collision with root package name */
        final Messenger f16018a;

        m(Messenger messenger) {
            this.f16018a = messenger;
        }

        private void d(int i10, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f16018a.send(obtain);
        }

        public void a(String str, List list, Bundle bundle, Bundle bundle2) {
            ArrayList arrayList;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
            if (list != null) {
                if (list instanceof ArrayList) {
                    arrayList = (ArrayList) list;
                } else {
                    arrayList = new ArrayList(list);
                }
                bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, arrayList);
            }
            d(3, bundle3);
        }

        public IBinder asBinder() {
            return this.f16018a.getBinder();
        }

        public void b() {
            d(2, (Bundle) null);
        }

        public void c(String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            d(1, bundle2);
        }
    }

    private final class n extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final k f16019a;

        n() {
            this.f16019a = new k();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.a(bundle);
                    this.f16019a.b(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle, new m(message.replyTo));
                    return;
                case 2:
                    this.f16019a.c(new m(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.a(bundle2);
                    this.f16019a.a(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), bundle2, new m(message.replyTo));
                    return;
                case 4:
                    this.f16019a.f(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new m(message.replyTo));
                    return;
                case 5:
                    this.f16019a.d(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new m(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.a(bundle3);
                    k kVar = this.f16019a;
                    m mVar = new m(message.replyTo);
                    kVar.e(mVar, data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle3);
                    return;
                case 7:
                    this.f16019a.i(new m(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                    MediaSessionCompat.a(bundle4);
                    this.f16019a.g(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), bundle4, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new m(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                    MediaSessionCompat.a(bundle5);
                    this.f16019a.h(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), bundle5, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new m(message.replyTo));
                    return;
                default:
                    Log.w(MediaBrowserServiceCompat.TAG, "Unhandled message: " + message + "\n  Service version: " + 2 + "\n  Client version: " + message.arg1);
                    return;
            }
        }

        public boolean sendMessageAtTime(Message message, long j10) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(message, j10);
        }
    }

    /* access modifiers changed from: package-private */
    public void addSubscription(String str, e eVar, IBinder iBinder, Bundle bundle) {
        List<Pair> list = (List) eVar.f15952g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair pair : list) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, (Bundle) pair.second)) {
                return;
            }
        }
        list.add(new Pair(iBinder, bundle));
        eVar.f15952g.put(str, list);
        performLoadChildren(str, eVar, bundle, (Bundle) null);
        this.mCurConnection = eVar;
        onSubscribe(str, bundle);
        this.mCurConnection = null;
    }

    /* access modifiers changed from: package-private */
    public List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i10 = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i11 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (i10 == -1 && i11 == -1) {
            return list;
        }
        int i12 = i11 * i10;
        int i13 = i12 + i11;
        if (i10 < 0 || i11 < 1 || i12 >= list.size()) {
            return Collections.emptyList();
        }
        if (i13 > list.size()) {
            i13 = list.size();
        }
        return list.subList(i12, i13);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.a();
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.c();
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    /* access modifiers changed from: package-private */
    public boolean isValidPackage(String str, int i10) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i10)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void notifyChildrenChanged(@NonNull String str) {
        if (str != null) {
            this.mImpl.e(str, (Bundle) null);
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.d(intent);
    }

    public void onCreate() {
        super.onCreate();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            this.mImpl = new j();
        } else if (i10 >= 26) {
            this.mImpl = new i();
        } else {
            this.mImpl = new h();
        }
        this.mImpl.onCreate();
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        result.sendError((Bundle) null);
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i10, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull Bundle bundle) {
        result.setFlags(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, @NonNull Result<MediaBrowserCompat.MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSubscribe(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnsubscribe(String str) {
    }

    /* access modifiers changed from: package-private */
    public void performCustomAction(String str, Bundle bundle, e eVar, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.mCurConnection = eVar;
        onCustomAction(str, bundle, dVar);
        this.mCurConnection = null;
        if (!dVar.isDone()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void performLoadChildren(String str, e eVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, eVar, str, bundle, bundle2);
        this.mCurConnection = eVar;
        if (bundle == null) {
            onLoadChildren(str, aVar);
        } else {
            onLoadChildren(str, aVar, bundle);
        }
        this.mCurConnection = null;
        if (!aVar.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + eVar.f15946a + " id=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public void performLoadItem(String str, e eVar, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.mCurConnection = eVar;
        onLoadItem(str, bVar);
        this.mCurConnection = null;
        if (!bVar.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public void performSearch(String str, Bundle bundle, e eVar, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.mCurConnection = eVar;
        onSearch(str, bundle, cVar);
        this.mCurConnection = null;
        if (!cVar.isDone()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean removeSubscription(String str, e eVar, IBinder iBinder) {
        boolean z10 = false;
        if (iBinder == null) {
            try {
                if (eVar.f15952g.remove(str) != null) {
                    z10 = true;
                }
            } catch (Throwable th) {
                this.mCurConnection = eVar;
                onUnsubscribe(str);
                this.mCurConnection = null;
                throw th;
            }
        } else {
            List list = (List) eVar.f15952g.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((Pair) it.next()).first) {
                        it.remove();
                        z10 = true;
                    }
                }
                if (list.size() == 0) {
                    eVar.f15952g.remove(str);
                }
            }
        }
        this.mCurConnection = eVar;
        onUnsubscribe(str);
        this.mCurConnection = null;
        return z10;
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.mSession == null) {
            this.mSession = token;
            this.mImpl.f(token);
        } else {
            throw new IllegalStateException("The session token has already been set.");
        }
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.mImpl.e(str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, @NonNull Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        } else if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.mImpl.b(remoteUserInfo, str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }
}
