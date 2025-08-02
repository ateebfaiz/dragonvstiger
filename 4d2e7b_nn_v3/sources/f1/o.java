package f1;

import java.io.IOException;

public class o extends IOException {
    public static o a(String str, Throwable th, boolean z10) {
        if (z10) {
            return new o(str, th);
        }
        return new b(str, th);
    }

    public static o b(String str, boolean z10) {
        if (z10) {
            return new o(str);
        }
        return new b(str);
    }

    private static class b extends o {
        public synchronized Throwable fillInStackTrace() {
            return this;
        }

        private b(String str) {
            super(str);
        }

        private b(String str, Throwable th) {
            super(str, th);
        }
    }

    private o(String str) {
        super(str);
    }

    private o(String str, Throwable th) {
        super(str, th);
    }
}
