package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

abstract class a {
    private static byte[] a(Queue queue, int i10) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i10) {
            return bArr;
        }
        int length = i10 - bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, i10);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int min = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i10 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static InputStream b(InputStream inputStream, long j10) {
        return new C0108a(inputStream, j10);
    }

    private static int c(long j10) {
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j10;
    }

    public static byte[] d(InputStream inputStream) {
        return e(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] e(InputStream inputStream, Queue queue, int i10) {
        int i11;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i10) * 2));
        while (i10 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i10);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i12 = 0;
            while (i12 < min2) {
                int read = inputStream.read(bArr, i12, min2 - i12);
                if (read == -1) {
                    return a(queue, i10);
                }
                i12 += read;
                i10 += read;
            }
            long j10 = (long) min;
            if (min < 4096) {
                i11 = 4;
            } else {
                i11 = 2;
            }
            min = c(j10 * ((long) i11));
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* renamed from: com.google.firebase.messaging.a$a  reason: collision with other inner class name */
    private static final class C0108a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private long f9203a;

        /* renamed from: b  reason: collision with root package name */
        private long f9204b = -1;

        C0108a(InputStream inputStream, long j10) {
            super(inputStream);
            this.f9203a = j10;
        }

        public int available() {
            return (int) Math.min((long) this.in.available(), this.f9203a);
        }

        public synchronized void mark(int i10) {
            this.in.mark(i10);
            this.f9204b = this.f9203a;
        }

        public int read() {
            if (this.f9203a == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.f9203a--;
            }
            return read;
        }

        public synchronized void reset() {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.f9204b != -1) {
                this.in.reset();
                this.f9203a = this.f9204b;
            } else {
                throw new IOException("Mark not set");
            }
        }

        public long skip(long j10) {
            long skip = this.in.skip(Math.min(j10, this.f9203a));
            this.f9203a -= skip;
            return skip;
        }

        public int read(byte[] bArr, int i10, int i11) {
            long j10 = this.f9203a;
            if (j10 == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i10, (int) Math.min((long) i11, j10));
            if (read != -1) {
                this.f9203a -= (long) read;
            }
            return read;
        }
    }
}
