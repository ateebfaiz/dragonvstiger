package g3;

import java.io.InputStream;
import y2.l;

public abstract class d {
    public static long a(InputStream inputStream, long j10) {
        boolean z10;
        l.g(inputStream);
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        long j11 = j10;
        while (j11 > 0) {
            long skip = inputStream.skip(j11);
            if (skip <= 0) {
                if (inputStream.read() == -1) {
                    return j10 - j11;
                }
                skip = 1;
            }
            j11 -= skip;
        }
        return j10;
    }
}
