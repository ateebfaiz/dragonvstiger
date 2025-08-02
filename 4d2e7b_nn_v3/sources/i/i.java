package i;

public class i extends Exception {
    public i(String str, Throwable th) {
        super("\"" + str + "\" native method error", th);
    }
}
