package q1;

import android.os.HandlerThread;
import s1.a;

public class b extends HandlerThread {
    public b(String str) {
        super(str);
    }

    public void run() {
        try {
            super.run();
        } catch (Throwable th) {
            a.h("CommonHandlerThread", "run failed " + th.getMessage());
        }
    }
}
