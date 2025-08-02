package com.bumptech.glide.util;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class ExceptionPassthroughInputStream extends InputStream {
    @GuardedBy("POOL")
    private static final Queue<ExceptionPassthroughInputStream> POOL = Util.createQueue(0);
    private IOException exception;
    private InputStream wrapped;

    ExceptionPassthroughInputStream() {
    }

    static void clearQueue() {
        synchronized (POOL) {
            while (true) {
                try {
                    Queue<ExceptionPassthroughInputStream> queue = POOL;
                    if (!queue.isEmpty()) {
                        queue.remove();
                    }
                } finally {
                }
            }
        }
    }

    @NonNull
    public static ExceptionPassthroughInputStream obtain(@NonNull InputStream inputStream) {
        ExceptionPassthroughInputStream poll;
        Queue<ExceptionPassthroughInputStream> queue = POOL;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionPassthroughInputStream();
        }
        poll.setInputStream(inputStream);
        return poll;
    }

    public int available() throws IOException {
        return this.wrapped.available();
    }

    public void close() throws IOException {
        this.wrapped.close();
    }

    @Nullable
    public IOException getException() {
        return this.exception;
    }

    public void mark(int i10) {
        this.wrapped.mark(i10);
    }

    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    public int read() throws IOException {
        try {
            return this.wrapped.read();
        } catch (IOException e10) {
            this.exception = e10;
            throw e10;
        }
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        Queue<ExceptionPassthroughInputStream> queue = POOL;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public synchronized void reset() throws IOException {
        this.wrapped.reset();
    }

    /* access modifiers changed from: package-private */
    public void setInputStream(@NonNull InputStream inputStream) {
        this.wrapped = inputStream;
    }

    public long skip(long j10) throws IOException {
        try {
            return this.wrapped.skip(j10);
        } catch (IOException e10) {
            this.exception = e10;
            throw e10;
        }
    }

    public int read(byte[] bArr) throws IOException {
        try {
            return this.wrapped.read(bArr);
        } catch (IOException e10) {
            this.exception = e10;
            throw e10;
        }
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            return this.wrapped.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.exception = e10;
            throw e10;
        }
    }
}
