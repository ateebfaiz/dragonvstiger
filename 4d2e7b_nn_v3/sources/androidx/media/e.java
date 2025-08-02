package androidx.media;

import android.content.Context;
import androidx.media.MediaSessionManager;

class e extends m {
    e(Context context) {
        super(context);
        this.f16032a = context;
    }

    private boolean d(MediaSessionManager.b bVar) {
        if (getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", bVar.b(), bVar.a()) == 0) {
            return true;
        }
        return false;
    }

    public boolean a(MediaSessionManager.b bVar) {
        if (d(bVar) || super.a(bVar)) {
            return true;
        }
        return false;
    }
}
