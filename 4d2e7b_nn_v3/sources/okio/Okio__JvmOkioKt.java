package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

final /* synthetic */ class Okio__JvmOkioKt {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger("okio.Okio");

    public static final Sink appendingSink(File file) throws FileNotFoundException {
        m.f(file, "$this$appendingSink");
        return Okio.sink((OutputStream) new FileOutputStream(file, true));
    }

    public static final CipherSink cipherSink(Sink sink, Cipher cipher) {
        m.f(sink, "$this$cipherSink");
        m.f(cipher, "cipher");
        return new CipherSink(Okio.buffer(sink), cipher);
    }

    public static final CipherSource cipherSource(Source source, Cipher cipher) {
        m.f(source, "$this$cipherSource");
        m.f(cipher, "cipher");
        return new CipherSource(Okio.buffer(source), cipher);
    }

    private static final Logger getLogger$Okio__JvmOkioKt() {
        return logger;
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        boolean z10;
        m.f(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        if (message != null) {
            z10 = j.K(message, "getsockname failed", false, 2, (Object) null);
        } else {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        return sink$default(file, false, 1, (Object) null);
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z10, int i10, Object obj) throws FileNotFoundException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return Okio.sink(file, z10);
    }

    public static final Source source(InputStream inputStream) {
        m.f(inputStream, "$this$source");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Sink sink(OutputStream outputStream) {
        m.f(outputStream, "$this$sink");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Source source(Socket socket) throws IOException {
        m.f(socket, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        m.e(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    public static final Sink sink(Socket socket) throws IOException {
        m.f(socket, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        m.e(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static final Source source(File file) throws FileNotFoundException {
        m.f(file, "$this$source");
        return Okio.source((InputStream) new FileInputStream(file));
    }

    public static final Sink sink(File file, boolean z10) throws FileNotFoundException {
        m.f(file, "$this$sink");
        return Okio.sink((OutputStream) new FileOutputStream(file, z10));
    }

    @IgnoreJRERequirement
    public static final Source source(Path path, OpenOption... openOptionArr) throws IOException {
        m.f(path, "$this$source");
        m.f(openOptionArr, "options");
        InputStream a10 = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        m.e(a10, "Files.newInputStream(this, *options)");
        return Okio.source(a10);
    }

    @IgnoreJRERequirement
    public static final Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        m.f(path, "$this$sink");
        m.f(openOptionArr, "options");
        OutputStream a10 = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        m.e(a10, "Files.newOutputStream(this, *options)");
        return Okio.sink(a10);
    }
}
