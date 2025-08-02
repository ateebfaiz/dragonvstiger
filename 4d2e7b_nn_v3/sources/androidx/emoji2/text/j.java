package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class j {

    private static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f15465a;

        a(ByteBuffer byteBuffer) {
            this.f15465a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f15465a.getInt();
        }

        public void b(int i10) {
            ByteBuffer byteBuffer = this.f15465a;
            byteBuffer.position(byteBuffer.position() + i10);
        }

        public long c() {
            return j.e(this.f15465a.getInt());
        }

        public long getPosition() {
            return (long) this.f15465a.position();
        }

        public int readUnsignedShort() {
            return j.f(this.f15465a.getShort());
        }
    }

    private static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f15466a;

        /* renamed from: b  reason: collision with root package name */
        private final ByteBuffer f15467b;

        /* renamed from: c  reason: collision with root package name */
        private final InputStream f15468c;

        /* renamed from: d  reason: collision with root package name */
        private long f15469d = 0;

        b(InputStream inputStream) {
            this.f15468c = inputStream;
            byte[] bArr = new byte[4];
            this.f15466a = bArr;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f15467b = wrap;
            wrap.order(ByteOrder.BIG_ENDIAN);
        }

        private void d(int i10) {
            if (this.f15468c.read(this.f15466a, 0, i10) == i10) {
                this.f15469d += (long) i10;
                return;
            }
            throw new IOException("read failed");
        }

        public int a() {
            this.f15467b.position(0);
            d(4);
            return this.f15467b.getInt();
        }

        public void b(int i10) {
            while (i10 > 0) {
                int skip = (int) this.f15468c.skip((long) i10);
                if (skip >= 1) {
                    i10 -= skip;
                    this.f15469d += (long) skip;
                } else {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
            }
        }

        public long c() {
            this.f15467b.position(0);
            d(4);
            return j.e(this.f15467b.getInt());
        }

        public long getPosition() {
            return this.f15469d;
        }

        public int readUnsignedShort() {
            this.f15467b.position(0);
            d(2);
            return j.f(this.f15467b.getShort());
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private final long f15470a;

        /* renamed from: b  reason: collision with root package name */
        private final long f15471b;

        c(long j10, long j11) {
            this.f15470a = j10;
            this.f15471b = j11;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.f15471b;
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return this.f15470a;
        }
    }

    private interface d {
        int a();

        void b(int i10);

        long c();

        long getPosition();

        int readUnsignedShort();
    }

    private static c a(d dVar) {
        long j10;
        dVar.b(4);
        int readUnsignedShort = dVar.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            dVar.b(6);
            int i10 = 0;
            while (true) {
                if (i10 >= readUnsignedShort) {
                    j10 = -1;
                    break;
                }
                int a10 = dVar.a();
                dVar.b(4);
                j10 = dVar.c();
                dVar.b(4);
                if (1835365473 == a10) {
                    break;
                }
                i10++;
            }
            if (j10 != -1) {
                dVar.b((int) (j10 - dVar.getPosition()));
                dVar.b(12);
                long c10 = dVar.c();
                for (int i11 = 0; ((long) i11) < c10; i11++) {
                    int a11 = dVar.a();
                    long c11 = dVar.c();
                    long c12 = dVar.c();
                    if (1164798569 == a11 || 1701669481 == a11) {
                        return new c(c11 + j10, c12);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    static MetadataList b(AssetManager assetManager, String str) {
        InputStream open = assetManager.open(str);
        try {
            MetadataList c10 = c(open);
            if (open != null) {
                open.close();
            }
            return c10;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static MetadataList c(InputStream inputStream) {
        b bVar = new b(inputStream);
        c a10 = a(bVar);
        bVar.b((int) (a10.b() - bVar.getPosition()));
        ByteBuffer allocate = ByteBuffer.allocate((int) a10.a());
        int read = inputStream.read(allocate.array());
        if (((long) read) == a10.a()) {
            return MetadataList.getRootAsMetadataList(allocate);
        }
        throw new IOException("Needed " + a10.a() + " bytes, got " + read);
    }

    static MetadataList d(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).b());
        return MetadataList.getRootAsMetadataList(duplicate);
    }

    static long e(int i10) {
        return ((long) i10) & 4294967295L;
    }

    static int f(short s10) {
        return s10 & com.alibaba.pdns.net.f.a.f18108a;
    }
}
