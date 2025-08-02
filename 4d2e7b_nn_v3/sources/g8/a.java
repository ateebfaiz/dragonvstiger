package g8;

import com.fasterxml.jackson.core.f;
import java.util.HashSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected final Object f12217a;

    /* renamed from: b  reason: collision with root package name */
    protected String f12218b;

    /* renamed from: c  reason: collision with root package name */
    protected String f12219c;

    /* renamed from: d  reason: collision with root package name */
    protected HashSet f12220d;

    private a(Object obj) {
        this.f12217a = obj;
    }

    public static a e(f fVar) {
        return new a(fVar);
    }

    public a a() {
        return new a(this.f12217a);
    }

    public Object b() {
        return this.f12217a;
    }

    public boolean c(String str) {
        String str2 = this.f12218b;
        if (str2 == null) {
            this.f12218b = str;
            return false;
        } else if (str.equals(str2)) {
            return true;
        } else {
            String str3 = this.f12219c;
            if (str3 == null) {
                this.f12219c = str;
                return false;
            } else if (str.equals(str3)) {
                return true;
            } else {
                if (this.f12220d == null) {
                    HashSet hashSet = new HashSet(16);
                    this.f12220d = hashSet;
                    hashSet.add(this.f12218b);
                    this.f12220d.add(this.f12219c);
                }
                return !this.f12220d.add(str);
            }
        }
    }

    public void d() {
        this.f12218b = null;
        this.f12219c = null;
        this.f12220d = null;
    }
}
