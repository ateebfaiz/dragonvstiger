package k0;

public class e extends RuntimeException {
    public e(Exception exc) {
        super("An exception was thrown by an Executor", exc);
    }
}
