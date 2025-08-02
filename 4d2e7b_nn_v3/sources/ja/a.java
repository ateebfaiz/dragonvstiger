package ja;

import java.util.Date;

public abstract class a {
    public static Date a(long j10) {
        return new Date(j10 * 1000);
    }

    public static long b(Date date) {
        return date.getTime() / 1000;
    }
}
