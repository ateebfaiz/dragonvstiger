package ab;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.m;

public final class n extends d {
    /* access modifiers changed from: protected */
    public void h0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
        if (Q() == 0) {
            n();
        }
    }
}
