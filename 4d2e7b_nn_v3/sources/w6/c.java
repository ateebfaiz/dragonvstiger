package w6;

import com.facebook.react.bridge.WritableArray;

public interface c {
    void callIdleCallbacks(double d10);

    void callTimers(WritableArray writableArray);

    void emitTimeDriftWarning(String str);
}
