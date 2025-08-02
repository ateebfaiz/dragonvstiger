package j8;

import java.io.Serializable;

public class i implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final char f12419a;

    /* renamed from: b  reason: collision with root package name */
    private final char f12420b;

    /* renamed from: c  reason: collision with root package name */
    private final char f12421c;

    public i() {
        this(':', ',', ',');
    }

    public static i a() {
        return new i();
    }

    public char b() {
        return this.f12421c;
    }

    public char c() {
        return this.f12420b;
    }

    public char d() {
        return this.f12419a;
    }

    public i(char c10, char c11, char c12) {
        this.f12419a = c10;
        this.f12420b = c11;
        this.f12421c = c12;
    }
}
