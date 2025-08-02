package androidx.core.util;

import androidx.annotation.NonNull;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f10, S s10) {
        this.first = f10;
        this.second = s10;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a10, B b10) {
        return new Pair<>(a10, b10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat.equals(pair.first, this.first) || !ObjectsCompat.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        F f10 = this.first;
        int i11 = 0;
        if (f10 == null) {
            i10 = 0;
        } else {
            i10 = f10.hashCode();
        }
        S s10 = this.second;
        if (s10 != null) {
            i11 = s10.hashCode();
        }
        return i10 ^ i11;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
