package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import javax.crypto.Cipher;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Okio {
    public static final Sink appendingSink(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(file);
    }

    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    public static final BufferedSink buffer(Sink sink) {
        return Okio__OkioKt.buffer(sink);
    }

    public static final CipherSink cipherSink(Sink sink, Cipher cipher) {
        return Okio__JvmOkioKt.cipherSink(sink, cipher);
    }

    public static final CipherSource cipherSource(Source source, Cipher cipher) {
        return Okio__JvmOkioKt.cipherSource(source, cipher);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(assertionError);
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
    }

    public static final Source source(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(file);
    }

    public static final BufferedSource buffer(Source source) {
        return Okio__OkioKt.buffer(source);
    }

    public static final Sink sink(File file, boolean z10) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file, z10);
    }

    public static final Source source(InputStream inputStream) {
        return Okio__JvmOkioKt.source(inputStream);
    }

    public static final Sink sink(OutputStream outputStream) {
        return Okio__JvmOkioKt.sink(outputStream);
    }

    public static final Source source(Socket socket) throws IOException {
        return Okio__JvmOkioKt.source(socket);
    }

    public static final Sink sink(Socket socket) throws IOException {
        return Okio__JvmOkioKt.sink(socket);
    }

    @IgnoreJRERequirement
    public static final Source source(Path path, OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.source(path, openOptionArr);
    }

    @IgnoreJRERequirement
    public static final Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.sink(path, openOptionArr);
    }
}
