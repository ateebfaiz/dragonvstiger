package i9;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f12358a;

    public e(boolean z10) {
        this.f12358a = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.f12358a == ((e) obj).f12358a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f12358a ? 1 : 0;
    }

    public String toString() {
        return "LineFriendshipStatus{friendFlag=" + this.f12358a + '}';
    }
}
