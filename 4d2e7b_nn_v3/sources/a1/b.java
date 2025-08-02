package a1;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface b {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f13578a;

        /* renamed from: b  reason: collision with root package name */
        public String f13579b;

        /* renamed from: c  reason: collision with root package name */
        public long f13580c;

        /* renamed from: d  reason: collision with root package name */
        public long f13581d;

        /* renamed from: e  reason: collision with root package name */
        public long f13582e;

        /* renamed from: f  reason: collision with root package name */
        public long f13583f;

        /* renamed from: g  reason: collision with root package name */
        public Map f13584g = Collections.emptyMap();

        /* renamed from: h  reason: collision with root package name */
        public List f13585h;

        public boolean a() {
            if (this.f13582e < System.currentTimeMillis()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (this.f13583f < System.currentTimeMillis()) {
                return true;
            }
            return false;
        }
    }

    void a(String str, a aVar);

    a get(String str);

    void initialize();
}
