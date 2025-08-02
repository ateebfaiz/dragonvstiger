package hc;

public class u1 {

    /* renamed from: a  reason: collision with root package name */
    private String f431a;

    /* renamed from: b  reason: collision with root package name */
    private int f432b = 0;

    public u1(String str) {
        this.f431a = str;
    }

    public boolean a() {
        if (this.f432b != -1) {
            return true;
        }
        return false;
    }

    public String b() {
        int i10 = this.f432b;
        if (i10 == -1) {
            return null;
        }
        int indexOf = this.f431a.indexOf(46, i10);
        if (indexOf == -1) {
            String substring = this.f431a.substring(this.f432b);
            this.f432b = -1;
            return substring;
        }
        String substring2 = this.f431a.substring(this.f432b, indexOf);
        this.f432b = indexOf + 1;
        return substring2;
    }
}
