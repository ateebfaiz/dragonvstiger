package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.m;
import okio.Buffer;

public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel2) {
        m.f(fileChannel2, "fileChannel");
        this.fileChannel = fileChannel2;
    }

    public final void read(long j10, Buffer buffer, long j11) {
        m.f(buffer, "sink");
        if (j11 >= 0) {
            while (j11 > 0) {
                long transferTo = this.fileChannel.transferTo(j10, j11, buffer);
                j10 += transferTo;
                j11 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void write(long j10, Buffer buffer, long j11) throws IOException {
        m.f(buffer, "source");
        if (j11 < 0 || j11 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (j11 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j10, j11);
            j10 += transferFrom;
            j11 -= transferFrom;
        }
    }
}
