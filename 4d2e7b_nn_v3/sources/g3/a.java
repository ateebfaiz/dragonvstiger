package g3;

public class a extends Exception {
    public a(String str) {
        super(str);
    }

    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
