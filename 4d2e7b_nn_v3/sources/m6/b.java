package m6;

import com.facebook.react.bridge.NativeMap;

public interface b {
    String getModuleName();

    int getSurfaceId();

    boolean isRunning();

    void setLayoutConstraints(int i10, int i11, int i12, int i13, boolean z10, boolean z11, float f10);

    void setMountable(boolean z10);

    void setProps(NativeMap nativeMap);

    void setSurfaceId(int i10);

    void start();

    void stop();
}
