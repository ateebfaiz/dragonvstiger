package ha;

public class c extends a {
    public c(String str) {
        super(str);
    }

    public static c d(String str) {
        return e(str.getBytes(f.f12313a));
    }

    public static c e(byte[] bArr) {
        return new c(b.g(bArr, true));
    }

    public static c f(String str) {
        if (str == null) {
            return null;
        }
        return new c(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c) || !toString().equals(obj.toString())) {
            return false;
        }
        return true;
    }
}
