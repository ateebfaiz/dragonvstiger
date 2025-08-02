package android.support.v4.media.session;

import android.media.session.MediaSession;

abstract class d {
    public static Object a(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
