package f1;

public class p extends RuntimeException {
    public p(String str) {
        super(str);
    }

    public p(Throwable th) {
        super(th);
    }

    public p(String str, Throwable th) {
        super(str, th);
    }
}
