package y3;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class a {

    /* renamed from: a  reason: collision with root package name */
    C0354a f24883a;

    /* renamed from: b  reason: collision with root package name */
    final float f24884b;

    /* renamed from: c  reason: collision with root package name */
    boolean f24885c;

    /* renamed from: d  reason: collision with root package name */
    boolean f24886d;

    /* renamed from: e  reason: collision with root package name */
    long f24887e;

    /* renamed from: f  reason: collision with root package name */
    float f24888f;

    /* renamed from: g  reason: collision with root package name */
    float f24889g;

    /* renamed from: y3.a$a  reason: collision with other inner class name */
    public interface C0354a {
        boolean onClick();
    }

    public a(Context context) {
        this.f24884b = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        a();
    }

    public static a c(Context context) {
        return new a(context);
    }

    public void a() {
        this.f24883a = null;
        e();
    }

    public boolean b() {
        return this.f24885c;
    }

    public boolean d(MotionEvent motionEvent) {
        C0354a aVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f24885c = true;
            this.f24886d = true;
            this.f24887e = motionEvent.getEventTime();
            this.f24888f = motionEvent.getX();
            this.f24889g = motionEvent.getY();
        } else if (action == 1) {
            this.f24885c = false;
            if (Math.abs(motionEvent.getX() - this.f24888f) > this.f24884b || Math.abs(motionEvent.getY() - this.f24889g) > this.f24884b) {
                this.f24886d = false;
            }
            if (this.f24886d && motionEvent.getEventTime() - this.f24887e <= ((long) ViewConfiguration.getLongPressTimeout()) && (aVar = this.f24883a) != null) {
                aVar.onClick();
            }
            this.f24886d = false;
        } else if (action != 2) {
            if (action == 3) {
                this.f24885c = false;
                this.f24886d = false;
            }
        } else if (Math.abs(motionEvent.getX() - this.f24888f) > this.f24884b || Math.abs(motionEvent.getY() - this.f24889g) > this.f24884b) {
            this.f24886d = false;
        }
        return true;
    }

    public void e() {
        this.f24885c = false;
        this.f24886d = false;
    }

    public void f(C0354a aVar) {
        this.f24883a = aVar;
    }
}
