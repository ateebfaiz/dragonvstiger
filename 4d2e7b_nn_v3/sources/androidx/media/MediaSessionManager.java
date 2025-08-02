package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.l;
import androidx.media.m;

public final class MediaSessionManager {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    static final String TAG = "MediaSessionManager";
    private static final Object sLock = new Object();
    private static volatile MediaSessionManager sSessionManager;
    a mImpl;

    interface a {
        boolean a(b bVar);

        Context getContext();
    }

    interface b {
        int a();

        int b();

        String c();
    }

    private MediaSessionManager(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new l(context);
        } else {
            this.mImpl = new e(context);
        }
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager = sSessionManager;
        if (mediaSessionManager == null) {
            synchronized (sLock) {
                try {
                    mediaSessionManager = sSessionManager;
                    if (mediaSessionManager == null) {
                        sSessionManager = new MediaSessionManager(context.getApplicationContext());
                        mediaSessionManager = sSessionManager;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mediaSessionManager;
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.mImpl.a(remoteUserInfo.mImpl);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        b mImpl;

        public RemoteUserInfo(@NonNull String str, int i10, int i11) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.mImpl = new l.a(str, i10, i11);
            } else {
                this.mImpl = new m.a(str, i10, i11);
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfo)) {
                return false;
            }
            return this.mImpl.equals(((RemoteUserInfo) obj).mImpl);
        }

        @NonNull
        public String getPackageName() {
            return this.mImpl.c();
        }

        public int getPid() {
            return this.mImpl.b();
        }

        public int getUid() {
            return this.mImpl.a();
        }

        public int hashCode() {
            return this.mImpl.hashCode();
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.mImpl = new l.a(remoteUserInfo);
        }
    }
}
