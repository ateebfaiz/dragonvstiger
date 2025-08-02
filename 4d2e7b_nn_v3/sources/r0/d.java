package r0;

import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List f23617a;

    /* renamed from: b  reason: collision with root package name */
    private final char f23618b;

    /* renamed from: c  reason: collision with root package name */
    private final double f23619c;

    /* renamed from: d  reason: collision with root package name */
    private final double f23620d;

    /* renamed from: e  reason: collision with root package name */
    private final String f23621e;

    /* renamed from: f  reason: collision with root package name */
    private final String f23622f;

    public d(List list, char c10, double d10, double d11, String str, String str2) {
        this.f23617a = list;
        this.f23618b = c10;
        this.f23619c = d10;
        this.f23620d = d11;
        this.f23621e = str;
        this.f23622f = str2;
    }

    public static int c(char c10, String str, String str2) {
        return (((c10 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List a() {
        return this.f23617a;
    }

    public double b() {
        return this.f23620d;
    }

    public int hashCode() {
        return c(this.f23618b, this.f23622f, this.f23621e);
    }
}
