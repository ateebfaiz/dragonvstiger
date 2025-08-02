package o5;

import com.alibaba.pdns.net.f.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.g0;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.v;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f23028a = new h();

    private h() {
    }

    private final boolean a(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        IntRange w10 = j.w(bArr);
        if (!(w10 instanceof Collection) || !((Collection) w10).isEmpty()) {
            Iterator it = w10.iterator();
            while (it.hasNext()) {
                int nextInt = ((g0) it).nextInt();
                if (((byte) str.charAt(nextInt)) != bArr[nextInt]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final int b(InputStream inputStream) {
        m.f(inputStream, "stream");
        h hVar = f23028a;
        return (hVar.e(inputStream) << 8) | hVar.e(inputStream);
    }

    private final String c(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            sb2.append((char) (v.a((short) b10) & a.f18108a));
        }
        String sb3 = sb2.toString();
        m.e(sb3, "str.toString()");
        return sb3;
    }

    private final int d(InputStream inputStream) {
        int e10 = e(inputStream);
        int e11 = e(inputStream);
        return (e(inputStream) << 24) | (e(inputStream) << 16) | (e11 << 8) | e10;
    }

    private final int e(InputStream inputStream) {
        return inputStream.read() & 255;
    }

    public static final Pair f(InputStream inputStream) {
        m.f(inputStream, "stream");
        byte[] bArr = new byte[4];
        try {
            inputStream.read(bArr);
            h hVar = f23028a;
            if (!hVar.a(bArr, "RIFF")) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
                return null;
            }
            hVar.d(inputStream);
            inputStream.read(bArr);
            if (!hVar.a(bArr, "WEBP")) {
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
                return null;
            }
            inputStream.read(bArr);
            String c10 = hVar.c(bArr);
            int hashCode = c10.hashCode();
            if (hashCode != 2640674) {
                if (hashCode != 2640718) {
                    if (hashCode == 2640730) {
                        if (c10.equals("VP8X")) {
                            Pair i10 = hVar.i(inputStream);
                            try {
                                inputStream.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                            return i10;
                        }
                    }
                } else if (c10.equals("VP8L")) {
                    Pair h10 = hVar.h(inputStream);
                    try {
                        inputStream.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                    return h10;
                }
            } else if (c10.equals("VP8 ")) {
                Pair g10 = hVar.g(inputStream);
                try {
                    inputStream.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
                return g10;
            }
            try {
                inputStream.close();
            } catch (IOException e15) {
                e15.printStackTrace();
            }
            return null;
        } catch (IOException e16) {
            e16.printStackTrace();
            inputStream.close();
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            throw th;
        }
    }

    private final Pair g(InputStream inputStream) {
        inputStream.skip(7);
        int e10 = e(inputStream);
        int e11 = e(inputStream);
        int e12 = e(inputStream);
        if (e10 == 157 && e11 == 1 && e12 == 42) {
            return new Pair(Integer.valueOf(b(inputStream)), Integer.valueOf(b(inputStream)));
        }
        return null;
    }

    private final Pair h(InputStream inputStream) {
        d(inputStream);
        if (e(inputStream) != 47) {
            return null;
        }
        int read = inputStream.read();
        return new Pair(Integer.valueOf(((inputStream.read() & 255) | ((read & 63) << 8)) + 1), Integer.valueOf((((inputStream.read() & 15) << 10) | ((inputStream.read() & 255) << 2) | ((read & 192) >> 6)) + 1));
    }

    private final Pair i(InputStream inputStream) {
        inputStream.skip(8);
        return new Pair(Integer.valueOf(j(inputStream) + 1), Integer.valueOf(j(inputStream) + 1));
    }

    private final int j(InputStream inputStream) {
        return (e(inputStream) << 16) | (e(inputStream) << 8) | e(inputStream);
    }
}
