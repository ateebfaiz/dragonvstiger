package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class n implements f {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f15050a;

    n(Object obj) {
        this.f15050a = d.a(obj);
    }

    public int a(Locale locale) {
        return this.f15050a.indexOf(locale);
    }

    public String b() {
        return this.f15050a.toLanguageTags();
    }

    public Object c() {
        return this.f15050a;
    }

    public Locale d(String[] strArr) {
        return this.f15050a.getFirstMatch(strArr);
    }

    public boolean equals(Object obj) {
        return this.f15050a.equals(((f) obj).c());
    }

    public Locale get(int i10) {
        return this.f15050a.get(i10);
    }

    public int hashCode() {
        return this.f15050a.hashCode();
    }

    public boolean isEmpty() {
        return this.f15050a.isEmpty();
    }

    public int size() {
        return this.f15050a.size();
    }

    public String toString() {
        return this.f15050a.toString();
    }
}
