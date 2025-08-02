package okhttp3.internal.ws;

import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.m;
import okio.Buffer;
import okio.InflaterSource;
import okio.Source;

public final class MessageInflater implements Closeable {
    private final Buffer deflatedBytes;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z10) {
        this.noContextTakeover = z10;
        Buffer buffer = new Buffer();
        this.deflatedBytes = buffer;
        Inflater inflater2 = new Inflater(true);
        this.inflater = inflater2;
        this.inflaterSource = new InflaterSource((Source) buffer, inflater2);
    }

    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(Buffer buffer) throws IOException {
        boolean z10;
        m.f(buffer, "buffer");
        if (this.deflatedBytes.size() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (this.noContextTakeover) {
                this.inflater.reset();
            }
            this.deflatedBytes.writeAll(buffer);
            this.deflatedBytes.writeInt(65535);
            long bytesRead = this.inflater.getBytesRead() + this.deflatedBytes.size();
            do {
                this.inflaterSource.readOrInflate(buffer, LocationRequestCompat.PASSIVE_INTERVAL);
            } while (this.inflater.getBytesRead() < bytesRead);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
