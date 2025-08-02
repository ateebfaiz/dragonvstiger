package h6;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.soloader.SoLoader;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12268a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f12269b;

    private a() {
    }

    public static final void a() {
        if (!f12269b) {
            f12269b = true;
            c8.a.c(0, "ReadableMapBufferSoLoader.staticInit::load:mapbufferjni");
            ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_MAPBUFFER_SO_FILE_START);
            SoLoader.t("mapbufferjni");
            ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_MAPBUFFER_SO_FILE_END);
            c8.a.g(0);
        }
    }
}
