package f1;

import f1.j;
import f1.k;
import java.util.UUID;

public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    public static final UUID f21490a = new UUID(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final j.f f21491b = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final k.a f21492c = new b();

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f21493d = new char[256];

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f21494e = new byte[55];

    class a implements j.f {
        a() {
        }

        /* renamed from: b */
        public UUID a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return t.a(jVar);
        }
    }

    class b implements k.a {
        b() {
        }

        /* renamed from: b */
        public void a(k kVar, UUID uuid) {
            t.d(uuid, kVar);
        }
    }

    static {
        int i10;
        int i11;
        for (int i12 = 0; i12 < 256; i12++) {
            int i13 = (i12 >> 4) & 15;
            int i14 = i12 & 15;
            char[] cArr = f21493d;
            if (i13 < 10) {
                i10 = i13 + 48;
            } else {
                i10 = i13 + 87;
            }
            int i15 = i10 << 8;
            if (i14 < 10) {
                i11 = i14 + 48;
            } else {
                i11 = i14 + 87;
            }
            cArr[i12] = (char) (i15 + i11);
        }
        for (char c10 = '0'; c10 <= '9'; c10 = (char) (c10 + 1)) {
            int i16 = c10 - '0';
            f21494e[i16] = (byte) i16;
        }
        for (char c11 = 'a'; c11 <= 'f'; c11 = (char) (c11 + 1)) {
            f21494e[c11 - '0'] = (byte) (c11 - 'W');
        }
        for (char c12 = 'A'; c12 <= 'F'; c12 = (char) (c12 + 1)) {
            f21494e[c12 - '0'] = (byte) (c12 - '7');
        }
    }

    public static UUID a(j jVar) {
        int i10;
        char[] E = jVar.E();
        int g10 = jVar.g() - jVar.i();
        long j10 = 0;
        if (g10 == 37 && E[8] == '-' && E[13] == '-' && E[18] == '-' && E[23] == '-') {
            long j11 = 0;
            int i11 = 0;
            while (i11 < 8) {
                try {
                    j11 = (j11 << 4) + ((long) f21494e[E[i11] - '0']);
                    i11++;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    return UUID.fromString(new String(E, 0, 36));
                }
            }
            for (int i12 = 9; i12 < 13; i12++) {
                j11 = (j11 << 4) + ((long) f21494e[E[i12] - '0']);
            }
            for (int i13 = 14; i13 < 18; i13++) {
                j11 = (j11 << 4) + ((long) f21494e[E[i13] - '0']);
            }
            for (int i14 = 19; i14 < 23; i14++) {
                j10 = (j10 << 4) + ((long) f21494e[E[i14] - '0']);
            }
            for (int i15 = 24; i15 < 36; i15++) {
                j10 = (j10 << 4) + ((long) f21494e[E[i15] - '0']);
            }
            return new UUID(j11, j10);
        } else if (g10 != 33) {
            return UUID.fromString(new String(E, 0, g10 - 1));
        } else {
            long j12 = 0;
            int i16 = 0;
            while (true) {
                if (i16 >= 16) {
                    break;
                }
                try {
                    j12 = (j12 << 4) + ((long) f21494e[E[i16] - '0']);
                    i16++;
                } catch (ArrayIndexOutOfBoundsException unused2) {
                    return UUID.fromString(new String(E, 0, 32));
                }
            }
            for (i10 = 16; i10 < 32; i10++) {
                j10 = (j10 << 4) + ((long) f21494e[E[i10] - '0']);
            }
            return new UUID(j12, j10);
        }
    }

    public static void b(long j10, long j11, k kVar) {
        int i10 = (int) (j10 >> 32);
        int i11 = (int) j10;
        int i12 = (int) (j11 >> 32);
        int i13 = (int) j11;
        byte[] c10 = kVar.c(38);
        int h10 = kVar.h();
        c10[h10] = 34;
        char[] cArr = f21493d;
        char c11 = cArr[(i10 >> 24) & 255];
        c10[h10 + 1] = (byte) (c11 >> 8);
        c10[h10 + 2] = (byte) c11;
        char c12 = cArr[(i10 >> 16) & 255];
        c10[h10 + 3] = (byte) (c12 >> 8);
        c10[h10 + 4] = (byte) c12;
        char c13 = cArr[(i10 >> 8) & 255];
        c10[h10 + 5] = (byte) (c13 >> 8);
        c10[h10 + 6] = (byte) c13;
        char c14 = cArr[i10 & 255];
        c10[h10 + 7] = (byte) (c14 >> 8);
        c10[h10 + 8] = (byte) c14;
        c10[h10 + 9] = 45;
        char c15 = cArr[(i11 >> 24) & 255];
        c10[h10 + 10] = (byte) (c15 >> 8);
        c10[h10 + 11] = (byte) c15;
        char c16 = cArr[(i11 >> 16) & 255];
        c10[h10 + 12] = (byte) (c16 >> 8);
        c10[h10 + 13] = (byte) c16;
        c10[h10 + 14] = 45;
        char c17 = cArr[(i11 >> 8) & 255];
        c10[h10 + 15] = (byte) (c17 >> 8);
        c10[h10 + 16] = (byte) c17;
        char c18 = cArr[i11 & 255];
        c10[h10 + 17] = (byte) (c18 >> 8);
        c10[h10 + 18] = (byte) c18;
        c10[h10 + 19] = 45;
        char c19 = cArr[(i12 >> 24) & 255];
        c10[h10 + 20] = (byte) (c19 >> 8);
        c10[h10 + 21] = (byte) c19;
        char c20 = cArr[(i12 >> 16) & 255];
        c10[h10 + 22] = (byte) (c20 >> 8);
        c10[h10 + 23] = (byte) c20;
        c10[h10 + 24] = 45;
        char c21 = cArr[(i12 >> 8) & 255];
        c10[h10 + 25] = (byte) (c21 >> 8);
        c10[h10 + 26] = (byte) c21;
        char c22 = cArr[i12 & 255];
        c10[h10 + 27] = (byte) (c22 >> 8);
        c10[h10 + 28] = (byte) c22;
        char c23 = cArr[(i13 >> 24) & 255];
        c10[h10 + 29] = (byte) (c23 >> 8);
        c10[h10 + 30] = (byte) c23;
        char c24 = cArr[(i13 >> 16) & 255];
        c10[h10 + 31] = (byte) (c24 >> 8);
        c10[h10 + 32] = (byte) c24;
        char c25 = cArr[(i13 >> 8) & 255];
        c10[h10 + 33] = (byte) (c25 >> 8);
        c10[h10 + 34] = (byte) c25;
        char c26 = cArr[i13 & 255];
        c10[h10 + 35] = (byte) (c26 >> 8);
        c10[h10 + 36] = (byte) c26;
        c10[h10 + 37] = 34;
        kVar.a(38);
    }

    public static void c(UUID uuid, k kVar) {
        b(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits(), kVar);
    }

    public static void d(UUID uuid, k kVar) {
        if (uuid == null) {
            kVar.n();
        } else {
            c(uuid, kVar);
        }
    }
}
