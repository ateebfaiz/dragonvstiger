package y9;

public class k extends RuntimeException {
    public k(String str) {
        super(str);
    }

    public k(String str, Throwable th) {
        super(str, th);
    }

    public k(Throwable th) {
        super(th);
    }
}
