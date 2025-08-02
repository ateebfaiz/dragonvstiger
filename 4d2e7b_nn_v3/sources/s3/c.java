package s3;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class c {

    /* renamed from: b  reason: collision with root package name */
    private static final c f23854b = new c();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f23855c = true;

    /* renamed from: a  reason: collision with root package name */
    private final Queue f23856a = new ArrayBlockingQueue(20);

    public enum a {
        ON_SET_HIERARCHY,
        ON_CLEAR_HIERARCHY,
        ON_SET_CONTROLLER,
        ON_CLEAR_OLD_CONTROLLER,
        ON_CLEAR_CONTROLLER,
        ON_INIT_CONTROLLER,
        ON_ATTACH_CONTROLLER,
        ON_DETACH_CONTROLLER,
        ON_RELEASE_CONTROLLER,
        ON_DATASOURCE_SUBMIT,
        ON_DATASOURCE_RESULT,
        ON_DATASOURCE_RESULT_INT,
        ON_DATASOURCE_FAILURE,
        ON_DATASOURCE_FAILURE_INT,
        ON_HOLDER_ATTACH,
        ON_HOLDER_DETACH,
        ON_DRAWABLE_SHOW,
        ON_DRAWABLE_HIDE,
        ON_ACTIVITY_START,
        ON_ACTIVITY_STOP,
        ON_RUN_CLEAR_CONTROLLER,
        ON_SCHEDULE_CLEAR_CONTROLLER,
        ON_SAME_CONTROLLER_SKIPPED,
        ON_SUBMIT_CACHE_HIT
    }

    private c() {
    }

    public static c a() {
        if (f23855c) {
            return new c();
        }
        return f23854b;
    }

    public void b(a aVar) {
        if (f23855c) {
            int i10 = 5;
            while (!this.f23856a.offer(aVar) && i10 > 0) {
                this.f23856a.poll();
                i10--;
            }
        }
    }

    public String toString() {
        return this.f23856a.toString();
    }
}
