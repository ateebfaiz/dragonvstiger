package r0;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f23628a;

    /* renamed from: b  reason: collision with root package name */
    public final float f23629b;

    /* renamed from: c  reason: collision with root package name */
    public final float f23630c;

    public h(String str, float f10, float f11) {
        this.f23628a = str;
        this.f23630c = f11;
        this.f23629b = f10;
    }

    public boolean a(String str) {
        if (this.f23628a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f23628a.endsWith("\r")) {
            String str2 = this.f23628a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
