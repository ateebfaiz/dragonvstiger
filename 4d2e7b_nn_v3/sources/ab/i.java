package ab;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.m;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f2409a = new i();

    private i() {
    }

    public final double a(double d10) {
        return Math.cos(Math.toRadians(d10 / 2.0d));
    }

    public final float b(MotionEvent motionEvent, boolean z10) {
        int i10;
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (motionEvent.getActionMasked() == 6) {
            i10 = motionEvent.getActionIndex();
        } else {
            i10 = -1;
        }
        if (z10) {
            int pointerCount = motionEvent.getPointerCount();
            float f10 = 0.0f;
            int i11 = 0;
            for (int i12 = 0; i12 < pointerCount; i12++) {
                if (i12 != i10) {
                    f10 += motionEvent.getX(i12);
                    i11++;
                }
            }
            return f10 / ((float) i11);
        }
        int pointerCount2 = motionEvent.getPointerCount();
        int i13 = pointerCount2 - 1;
        if (i13 == i10) {
            i13 = pointerCount2 - 2;
        }
        return motionEvent.getX(i13);
    }

    public final float c(MotionEvent motionEvent, boolean z10) {
        int i10;
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (motionEvent.getActionMasked() == 6) {
            i10 = motionEvent.getActionIndex();
        } else {
            i10 = -1;
        }
        if (z10) {
            int pointerCount = motionEvent.getPointerCount();
            float f10 = 0.0f;
            int i11 = 0;
            for (int i12 = 0; i12 < pointerCount; i12++) {
                if (i12 != i10) {
                    f10 += motionEvent.getY(i12);
                    i11++;
                }
            }
            return f10 / ((float) i11);
        }
        int pointerCount2 = motionEvent.getPointerCount();
        int i13 = pointerCount2 - 1;
        if (i13 == i10) {
            i13 = pointerCount2 - 2;
        }
        return motionEvent.getY(i13);
    }
}
