package org.cocos2dx.okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Okio {
    static final Logger logger = Logger.getLogger(Okio.class.getName());

    class a implements Sink {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Timeout f1770a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OutputStream f1771b;

        a(Timeout timeout, OutputStream outputStream) {
            this.f1770a = timeout;
            this.f1771b = outputStream;
        }

        public void close() {
            this.f1771b.close();
        }

        public void flush() {
            this.f1771b.flush();
        }

        public Timeout timeout() {
            return this.f1770a;
        }

        public String toString() {
            return "sink(" + this.f1771b + ")";
        }

        public void write(Buffer buffer, long j10) {
            g.b(buffer.size, 0, j10);
            while (j10 > 0) {
                this.f1770a.throwIfReached();
                d dVar = buffer.head;
                int min = (int) Math.min(j10, (long) (dVar.f1791c - dVar.f1790b));
                this.f1771b.write(dVar.f1789a, dVar.f1790b, min);
                int i10 = dVar.f1790b + min;
                dVar.f1790b = i10;
                long j11 = (long) min;
                j10 -= j11;
                buffer.size -= j11;
                if (i10 == dVar.f1791c) {
                    buffer.head = dVar.b();
                    e.a(dVar);
                }
            }
        }
    }

    class b implements Source {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Timeout f1772a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InputStream f1773b;

        b(Timeout timeout, InputStream inputStream) {
            this.f1772a = timeout;
            this.f1773b = inputStream;
        }

        public void close() {
            this.f1773b.close();
        }

        public long read(Buffer buffer, long j10) {
            int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
            if (i10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            } else if (i10 == 0) {
                return 0;
            } else {
                try {
                    this.f1772a.throwIfReached();
                    d writableSegment = buffer.writableSegment(1);
                    int read = this.f1773b.read(writableSegment.f1789a, writableSegment.f1791c, (int) Math.min(j10, (long) (8192 - writableSegment.f1791c)));
                    if (read == -1) {
                        return -1;
                    }
                    writableSegment.f1791c += read;
                    long j11 = (long) read;
                    buffer.size += j11;
                    return j11;
                } catch (AssertionError e10) {
                    if (Okio.isAndroidGetsocknameError(e10)) {
                        throw new IOException(e10);
                    }
                    throw e10;
                }
            }
        }

        public Timeout timeout() {
            return this.f1772a;
        }

        public String toString() {
            return "source(" + this.f1773b + ")";
        }
    }

    class c implements Sink {
        c() {
        }

        public void close() {
        }

        public void flush() {
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void write(Buffer buffer, long j10) {
            buffer.skip(j10);
        }
    }

    class d extends AsyncTimeout {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Socket f1774a;

        d(Socket socket) {
            this.f1774a = socket;
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            try {
                this.f1774a.close();
            } catch (Exception e10) {
                Logger logger = Okio.logger;
                Level level = Level.WARNING;
                logger.log(level, "Failed to close timed out socket " + this.f1774a, e10);
            } catch (AssertionError e11) {
                if (Okio.isAndroidGetsocknameError(e11)) {
                    Logger logger2 = Okio.logger;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + this.f1774a, e11);
                    return;
                }
                throw e11;
            }
        }
    }

    private Okio() {
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new c();
    }

    public static BufferedSource buffer(Source source) {
        return new c(source);
    }

    static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        if (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) {
            return false;
        }
        return true;
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static AsyncTimeout timeout(Socket socket) {
        return new d(socket);
    }

    public static BufferedSink buffer(Sink sink) {
        return new b(sink);
    }

    private static Sink sink(OutputStream outputStream, Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new a(timeout, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    private static Source source(InputStream inputStream, Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new b(timeout, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            AsyncTimeout timeout = timeout(socket);
            return timeout.sink(sink(socket.getOutputStream(), (Timeout) timeout));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    @IgnoreJRERequirement
    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            AsyncTimeout timeout = timeout(socket);
            return timeout.source(source(socket.getInputStream(), (Timeout) timeout));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    @IgnoreJRERequirement
    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }
}
