package org.cocos2dx.okio;

import java.io.IOException;

public final class Pipe {
    final Buffer buffer = new Buffer();
    final long maxBufferSize;
    private final Sink sink = new a();
    boolean sinkClosed;
    private final Source source = new b();
    boolean sourceClosed;

    final class a implements Sink {

        /* renamed from: a  reason: collision with root package name */
        final Timeout f1775a = new Timeout();

        a() {
        }

        public void close() {
            synchronized (Pipe.this.buffer) {
                try {
                    Pipe pipe = Pipe.this;
                    if (!pipe.sinkClosed) {
                        if (pipe.sourceClosed) {
                            if (pipe.buffer.size() > 0) {
                                throw new IOException("source is closed");
                            }
                        }
                        Pipe pipe2 = Pipe.this;
                        pipe2.sinkClosed = true;
                        pipe2.buffer.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void flush() {
            synchronized (Pipe.this.buffer) {
                try {
                    Pipe pipe = Pipe.this;
                    if (pipe.sinkClosed) {
                        throw new IllegalStateException("closed");
                    } else if (pipe.sourceClosed) {
                        if (pipe.buffer.size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Timeout timeout() {
            return this.f1775a;
        }

        public void write(Buffer buffer, long j10) {
            synchronized (Pipe.this.buffer) {
                try {
                    if (!Pipe.this.sinkClosed) {
                        while (j10 > 0) {
                            Pipe pipe = Pipe.this;
                            if (!pipe.sourceClosed) {
                                long size = pipe.maxBufferSize - pipe.buffer.size();
                                if (size == 0) {
                                    this.f1775a.waitUntilNotified(Pipe.this.buffer);
                                } else {
                                    long min = Math.min(size, j10);
                                    Pipe.this.buffer.write(buffer, min);
                                    j10 -= min;
                                    Pipe.this.buffer.notifyAll();
                                }
                            } else {
                                throw new IOException("source is closed");
                            }
                        }
                    } else {
                        throw new IllegalStateException("closed");
                    }
                } finally {
                }
            }
        }
    }

    final class b implements Source {

        /* renamed from: a  reason: collision with root package name */
        final Timeout f1777a = new Timeout();

        b() {
        }

        public void close() {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        public long read(Buffer buffer, long j10) {
            synchronized (Pipe.this.buffer) {
                try {
                    if (!Pipe.this.sourceClosed) {
                        while (Pipe.this.buffer.size() == 0) {
                            Pipe pipe = Pipe.this;
                            if (pipe.sinkClosed) {
                                return -1;
                            }
                            this.f1777a.waitUntilNotified(pipe.buffer);
                        }
                        long read = Pipe.this.buffer.read(buffer, j10);
                        Pipe.this.buffer.notifyAll();
                        return read;
                    }
                    throw new IllegalStateException("closed");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Timeout timeout() {
            return this.f1777a;
        }
    }

    public Pipe(long j10) {
        if (j10 >= 1) {
            this.maxBufferSize = j10;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j10);
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
