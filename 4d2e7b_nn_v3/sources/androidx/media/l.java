package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

class l extends e {

    /* renamed from: d  reason: collision with root package name */
    MediaSessionManager f16029d;

    l(Context context) {
        super(context);
        this.f16029d = (MediaSessionManager) context.getSystemService("media_session");
    }

    public boolean a(MediaSessionManager.b bVar) {
        if (bVar instanceof a) {
            return this.f16029d.isTrustedForMediaControl(((a) bVar).f16030a);
        }
        return false;
    }

    static final class a implements MediaSessionManager.b {

        /* renamed from: a  reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f16030a;

        a(String str, int i10, int i11) {
            this.f16030a = k.a(str, i10, i11);
        }

        public int a() {
            return this.f16030a.getUid();
        }

        public int b() {
            return this.f16030a.getPid();
        }

        public String c() {
            return this.f16030a.getPackageName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.f16030a.equals(((a) obj).f16030a);
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f16030a);
        }

        a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f16030a = remoteUserInfo;
        }
    }
}
