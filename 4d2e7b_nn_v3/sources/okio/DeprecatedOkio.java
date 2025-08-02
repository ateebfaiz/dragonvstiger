package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.jvm.internal.m;

/* renamed from: okio.-DeprecatedOkio  reason: invalid class name */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    public final Sink appendingSink(File file) {
        m.f(file, "file");
        return Okio.appendingSink(file);
    }

    public final Sink blackhole() {
        return Okio.blackhole();
    }

    public final BufferedSink buffer(Sink sink) {
        m.f(sink, "sink");
        return Okio.buffer(sink);
    }

    public final Sink sink(File file) {
        m.f(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
    }

    public final Source source(File file) {
        m.f(file, "file");
        return Okio.source(file);
    }

    public final BufferedSource buffer(Source source) {
        m.f(source, "source");
        return Okio.buffer(source);
    }

    public final Sink sink(OutputStream outputStream) {
        m.f(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    public final Source source(InputStream inputStream) {
        m.f(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    public final Sink sink(Path path, OpenOption... openOptionArr) {
        m.f(path, "path");
        m.f(openOptionArr, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Source source(Path path, OpenOption... openOptionArr) {
        m.f(path, "path");
        m.f(openOptionArr, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Sink sink(Socket socket) {
        m.f(socket, "socket");
        return Okio.sink(socket);
    }

    public final Source source(Socket socket) {
        m.f(socket, "socket");
        return Okio.source(socket);
    }
}
